package android.os.collector;

import android.content.Context;
import android.os.RemoteException;
import android.os.collector.IStepOSDataResultCallback;
import android.os.collector.IStepOSDataSubscriptionCallback;
import android.os.collector.base.StepOSBaseEntity;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class StepOSDataCollectManager {
    private static final boolean DEBUG = true;
    private static final long DEFAULT_TIMEOUT_MS = 5000;
    private static final String TAG = "StepOSDataCollectManager";
    private final Context mContext;
    private final IStepOSDataCollectManager mService;
    private final Object mSubscriptionLock = new Object();
    private final Map<SubscriptionDataCallback, DataSubscriptionCallbackWrapper> mSubscriptionCallbacks = new HashMap();

    public interface ResultDataCallback {
        int onResult(List<StepOSBaseEntity> list);
    }

    public interface SubscriptionDataCallback {
        int onSubscribeData(List<StepOSBaseEntity> list);
    }

    public StepOSDataCollectManager(Context context, IStepOSDataCollectManager service) {
        this.mContext = context;
        this.mService = service;
    }

    public boolean getData(int atomId, long from, long duration, ResultDataCallback callback) {
        RemoteException e;
        if (callback == null) {
            throw new IllegalArgumentException("ResultDataCallback cannot be null");
        }
        try {
            DataResultCallbackWrapper wrapper = new DataResultCallbackWrapper(callback);
            try {
                return this.mService.getData(atomId, from, duration, wrapper);
            } catch (RemoteException e2) {
                e = e2;
                throw e.rethrowFromSystemServer();
            }
        } catch (RemoteException e3) {
            e = e3;
        }
    }

    public List<StepOSBaseEntity> getDataByConfig(long configId) {
        try {
            CollectEventParcel[] parcels = this.mService.getDataByConfig(configId);
            if (parcels != null && parcels.length != 0) {
                return parseEventParcels(parcels);
            }
            return Collections.emptyList();
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public List<StepOSBaseEntity> getDataSync(int atomId, long from, long duration) {
        return getDataSync(atomId, from, duration, 5000L);
    }

    public List<StepOSBaseEntity> getDataSync(int atomId, long from, long duration, long timeoutMs) throws InterruptedException {
        List<StepOSBaseEntity> result = Collections.synchronizedList(new ArrayList());
        CountDownLatch latch = new CountDownLatch(1);
        AtomicBoolean success = new AtomicBoolean(false);
        try {
            SyncResultCallbackWrapper wrapper = new SyncResultCallbackWrapper(result, latch, success);
            boolean initiated = this.mService.getData(atomId, from, duration, wrapper);
            if (!initiated) {
                Log.w(TAG, "getDataSync: failed to initiate request");
                return Collections.emptyList();
            }
            try {
                boolean completed = latch.await(timeoutMs, TimeUnit.MILLISECONDS);
                if (!completed) {
                    Log.w(TAG, "getDataSync: timeout waiting for result");
                    return Collections.emptyList();
                }
                if (!success.get()) {
                    Log.w(TAG, "getDataSync: request failed");
                    return Collections.emptyList();
                }
                return new ArrayList(result);
            } catch (RemoteException e) {
                e = e;
                throw e.rethrowFromSystemServer();
            } catch (InterruptedException e2) {
                Log.w(TAG, "getDataSync: interrupted while waiting for result");
                Thread.currentThread().interrupt();
                return Collections.emptyList();
            }
        } catch (RemoteException e3) {
            e = e3;
        } catch (InterruptedException e4) {
        }
    }

    public boolean addSubscription(int[] atomIds, SubscriptionDataCallback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("SubscriptionDataCallback cannot be null");
        }
        if (atomIds == null || atomIds.length == 0) {
            throw new IllegalArgumentException("atomIds cannot be null or empty");
        }
        synchronized (this.mSubscriptionLock) {
            if (this.mSubscriptionCallbacks.containsKey(callback)) {
                Log.w(TAG, "addSubscription: callback already subscribed");
                return false;
            }
            try {
                DataSubscriptionCallbackWrapper wrapper = new DataSubscriptionCallbackWrapper(callback);
                this.mService.addSubscription(atomIds, wrapper);
                this.mSubscriptionCallbacks.put(callback, wrapper);
                return true;
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    }

    public boolean removeSubscription(SubscriptionDataCallback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("SubscriptionDataCallback cannot be null");
        }
        synchronized (this.mSubscriptionLock) {
            DataSubscriptionCallbackWrapper wrapper = this.mSubscriptionCallbacks.remove(callback);
            if (wrapper == null) {
                Log.w(TAG, "removeSubscription: callback not found");
                return false;
            }
            try {
                this.mService.removeSubscription(wrapper);
                return true;
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<StepOSBaseEntity> parseEventParcels(CollectEventParcel[] parcels) {
        if (parcels == null || parcels.length == 0) {
            return new ArrayList();
        }
        List<StepOSBaseEntity> entities = new ArrayList<>(parcels.length);
        for (CollectEventParcel parcel : parcels) {
            if (parcel == null || parcel.buffer == null) {
                Log.w(TAG, "Skipping null parcel or buffer");
            } else {
                try {
                    StepOSCollectEvent event = new StepOSCollectEvent();
                    event.setBytes(parcel.buffer);
                    if (!event.parseBuffer() || !event.isValid()) {
                        Log.w(TAG, "Failed to parse buffer or invalid event");
                    } else {
                        StepOSBaseEntity entity = event.getEntity();
                        if (entity == null) {
                            Log.w(TAG, "Parsed event has null entity");
                        } else {
                            entities.add(entity);
                        }
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Error parsing CollectEventParcel: " + e.getMessage(), e);
                }
            }
        }
        return entities;
    }

    private static class SyncResultCallbackWrapper extends IStepOSDataResultCallback.Stub {
        private final CountDownLatch mLatch;
        private final List<StepOSBaseEntity> mResultData;
        private final AtomicBoolean mSuccess;

        SyncResultCallbackWrapper(List<StepOSBaseEntity> result, CountDownLatch latch, AtomicBoolean success) {
            this.mResultData = result;
            this.mLatch = latch;
            this.mSuccess = success;
        }

        @Override // android.os.collector.IStepOSDataResultCallback
        public void onResult(int atomTag, boolean isFinished, CollectEventParcel[] parcels) {
            Log.d(StepOSDataCollectManager.TAG, "SyncResultCallbackWrapper onResult atomTag:" + atomTag + ", isFinished:" + isFinished + ", parcels count:" + (parcels != null ? parcels.length : 0));
            List<StepOSBaseEntity> entities = StepOSDataCollectManager.parseEventParcels(parcels);
            this.mResultData.addAll(entities);
            if (isFinished) {
                this.mSuccess.set(true);
                this.mLatch.countDown();
            }
        }
    }

    private static class DataResultCallbackWrapper extends IStepOSDataResultCallback.Stub {
        private final ResultDataCallback mCallback;
        private final List<StepOSBaseEntity> mResultData = new ArrayList();

        DataResultCallbackWrapper(ResultDataCallback callback) {
            this.mCallback = callback;
        }

        @Override // android.os.collector.IStepOSDataResultCallback
        public void onResult(int atomTag, boolean isFinished, CollectEventParcel[] parcels) {
            Log.d(StepOSDataCollectManager.TAG, "DataResultCallbackWrapper onResult atomTag:" + atomTag + ", isFinished:" + isFinished + ", parcels count:" + (parcels != null ? parcels.length : 0));
            List<StepOSBaseEntity> entities = StepOSDataCollectManager.parseEventParcels(parcels);
            this.mResultData.addAll(entities);
            if (isFinished) {
                Log.d(StepOSDataCollectManager.TAG, "DataResultCallbackWrapper invoking callback with " + this.mResultData.size() + " entities");
                try {
                    try {
                        this.mCallback.onResult(this.mResultData);
                    } catch (Exception e) {
                        Log.e(StepOSDataCollectManager.TAG, "Error in result callback: " + e.getMessage(), e);
                    }
                } finally {
                    this.mResultData.clear();
                }
            }
        }
    }

    private static class DataSubscriptionCallbackWrapper extends IStepOSDataSubscriptionCallback.Stub {
        private final SubscriptionDataCallback mCallback;

        DataSubscriptionCallbackWrapper(SubscriptionDataCallback callback) {
            this.mCallback = callback;
        }

        @Override // android.os.collector.IStepOSDataSubscriptionCallback
        public void onSubscriptionData(int reason, CollectEventParcel[] parcels) {
            if (parcels == null || parcels.length == 0) {
                Log.d(StepOSDataCollectManager.TAG, "onSubscriptionData received null or empty parcels");
                return;
            }
            Log.d(StepOSDataCollectManager.TAG, "DataSubscriptionCallbackWrapper onSubscriptionData, size: " + parcels.length + ", reason: " + reason);
            List<StepOSBaseEntity> entities = StepOSDataCollectManager.parseEventParcels(parcels);
            if (entities.isEmpty()) {
                Log.w(StepOSDataCollectManager.TAG, "No valid entities to report");
                return;
            }
            try {
                this.mCallback.onSubscribeData(entities);
            } catch (Exception e) {
                Log.e(StepOSDataCollectManager.TAG, "Error in subscription callback: " + e.getMessage(), e);
            }
        }
    }
}
