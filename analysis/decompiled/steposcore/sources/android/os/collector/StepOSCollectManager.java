package android.os.collector;

import android.content.Context;
import android.content.ContextExt;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.collector.ICollectManagerService;
import android.os.collector.ICollectPullCallback;
import android.os.collector.ICollectResultCallback;
import android.os.collector.ICollectSubscriptionCallback;
import android.os.collector.base.StepOSBaseEntity;
import android.util.Log;
import android.util.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class StepOSCollectManager {
    private static final boolean DEBUG = true;
    public static final long DEFAULT_COOL_DOWN_MS = 5000;
    public static final long DEFAULT_TIMEOUT_MS = 5000;
    public static final int PULL_SKIP = 1;
    public static final int PULL_SUCCESS = 0;
    private static final String TAG = "StepOSCollectManager";
    private final Context mContext;
    private static final Object sLock = new Object();
    private static final Singleton<ICollectManagerService> ICollectManagerSingleton = new Singleton<ICollectManagerService>() { // from class: android.os.collector.StepOSCollectManager.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: create, reason: merged with bridge method [inline-methods] */
        public ICollectManagerService m129create() {
            IBinder b = ServiceManager.getService(ContextExt.COLLECTD_MANAGER_SERVICE);
            return ICollectManagerService.Stub.asInterface(b);
        }
    };

    public interface CollectPullAtomCallback {
        int onPullAtom(int i, List<StepOSCollectEvent> list);
    }

    public interface ResultDataCallback {
        int onResult(List<StepOSBaseEntity> list);
    }

    public interface SubscriptionDataCallback {
        int onSubscribeData(List<StepOSBaseEntity> list);
    }

    public StepOSCollectManager(Context context) {
        this.mContext = context;
    }

    public static ICollectManagerService getService() {
        return (ICollectManagerService) ICollectManagerSingleton.get();
    }

    public static boolean isCollectable(int atomTag) {
        try {
            boolean result = getService().isCollectable(atomTag);
            return result;
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void addConfig(long configKey, byte[] config) {
        synchronized (sLock) {
            try {
                try {
                    ICollectManagerService service = getService();
                    if (service != null) {
                        Log.d(TAG, "addConfig configKey:" + configKey);
                        service.addConfiguration(configKey, config, this.mContext.getOpPackageName());
                    }
                } catch (RemoteException e) {
                    throw new RuntimeException("Unable to add config", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void removeConfig(long configKey) {
        synchronized (sLock) {
            try {
                try {
                    ICollectManagerService service = getService();
                    if (service != null) {
                        Log.d(TAG, "removeConfig configKey:" + configKey);
                        service.removeConfiguration(configKey, this.mContext.getOpPackageName());
                    }
                } catch (RemoteException e) {
                    throw new RuntimeException("Unable to remove config", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setPullAtomCallback(int atomTag, Executor executor, CollectPullAtomCallback callback) throws Throwable {
        Throwable th;
        RemoteException e;
        synchronized (sLock) {
            try {
                try {
                    ICollectManagerService service = getService();
                    if (service != null) {
                        Log.d(TAG, "setPullAtomCallback atomTag:" + atomTag);
                        CollectPullAtomCallbackInternal rec = new CollectPullAtomCallbackInternal(atomTag, callback, executor);
                        try {
                            service.registerPullAtomCallback(atomTag, 5000L, 5000L, rec);
                        } catch (RemoteException e2) {
                            e = e2;
                            throw new RuntimeException("Unable to register pull callback", e);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (RemoteException e3) {
                e = e3;
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        }
    }

    public boolean getData(int atomid, long from, long duration, ResultDataCallback callback) throws RemoteException {
        boolean result = false;
        synchronized (sLock) {
            try {
                try {
                    ICollectManagerService service = getService();
                    if (service != null) {
                        try {
                            CollectResultCallbackInternal csci = new CollectResultCallbackInternal(callback);
                            result = service.getData(atomid, from, duration, csci);
                        } catch (RemoteException e) {
                            e = e;
                            throw new RuntimeException("Unable to register pull callback", e);
                        }
                    }
                    return result;
                } catch (Throwable th) {
                    e = th;
                    throw e;
                }
            } catch (RemoteException e2) {
                e = e2;
            } catch (Throwable th2) {
                e = th2;
                throw e;
            }
        }
    }

    public void addSubscription(int[] atomIds, SubscriptionDataCallback callback) {
        synchronized (sLock) {
            try {
                try {
                    ICollectManagerService service = getService();
                    if (service != null) {
                        CollectSubscriptionCallbackInternal csi = new CollectSubscriptionCallbackInternal(callback);
                        service.addSubscription(atomIds, csi);
                    }
                } catch (RemoteException e) {
                    throw new RuntimeException("Unable to register pull callback", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void removeSubscription(CollectSubscriptionCallbackInternal csci) {
        synchronized (sLock) {
            try {
                try {
                    ICollectManagerService service = getService();
                    if (service != null) {
                        service.removeSubscription(csci);
                    }
                } catch (RemoteException e) {
                    throw new RuntimeException("Unable to register pull callback", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static class CollectResultCallbackInternal extends ICollectResultCallback.Stub {
        public final ResultDataCallback mCallback;
        private boolean mIsFinished;
        private final List<StepOSBaseEntity> mResultData;

        CollectResultCallbackInternal(ResultDataCallback callback) {
            if (callback == null) {
                throw new IllegalArgumentException("ResultDataCallback cannot be null");
            }
            this.mCallback = callback;
            this.mIsFinished = false;
            this.mResultData = new ArrayList();
        }

        @Override // android.os.collector.ICollectResultCallback
        public void onResult(int atomTag, boolean isFinished, CollectEventParcel[] parcels) {
            this.mIsFinished = isFinished;
            Log.d(StepOSCollectManager.TAG, "CollectResultCallbackInternal onResult atomTag:" + atomTag + ", isFinished:" + isFinished + ", parcels count:" + (parcels != null ? parcels.length : 0));
            if (parcels == null || parcels.length == 0) {
                Log.w(StepOSCollectManager.TAG, "onResult received null or empty parcels");
            } else {
                for (CollectEventParcel parcel : parcels) {
                    if (parcel == null || parcel.buffer == null) {
                        Log.w(StepOSCollectManager.TAG, "Skipping null parcel or buffer");
                    } else {
                        try {
                            StepOSCollectEvent event = new StepOSCollectEvent();
                            event.setBytes(parcel.buffer);
                            if (!event.parseBuffer() || !event.isValid()) {
                                Log.w(StepOSCollectManager.TAG, "Failed to parse buffer or invalid event");
                            } else {
                                StepOSBaseEntity entity = event.getEntity();
                                if (entity == null) {
                                    Log.w(StepOSCollectManager.TAG, "Parsed event has null entity");
                                } else {
                                    this.mResultData.add(entity);
                                }
                            }
                        } catch (Exception e) {
                            Log.e(StepOSCollectManager.TAG, "Error parsing CollectEventParcel: " + e.getMessage(), e);
                        }
                    }
                }
            }
            if (this.mIsFinished) {
                Log.d(StepOSCollectManager.TAG, "CollectResultCallbackInternal invoking callback with " + this.mResultData.size() + " entities");
                try {
                    try {
                        this.mCallback.onResult(this.mResultData);
                    } catch (Exception e2) {
                        Log.e(StepOSCollectManager.TAG, "Error in result callback: " + e2.getMessage(), e2);
                    }
                } finally {
                    this.mResultData.clear();
                }
            }
        }

        public boolean isFinished() {
            return this.mIsFinished;
        }
    }

    private static class CollectSubscriptionCallbackInternal extends ICollectSubscriptionCallback.Stub {
        public final SubscriptionDataCallback mCallback;

        CollectSubscriptionCallbackInternal(SubscriptionDataCallback callback) {
            if (callback == null) {
                throw new IllegalArgumentException("SubscriptionDataCallback cannot be null");
            }
            this.mCallback = callback;
        }

        @Override // android.os.collector.ICollectSubscriptionCallback
        public void onSubscriptionData(int reason, CollectEventParcel[] parcels) {
            if (parcels == null || parcels.length == 0) {
                Log.d(StepOSCollectManager.TAG, "onSubscriptionData received null or empty parcels");
                return;
            }
            Log.d(StepOSCollectManager.TAG, "CollectSubscriptionCallbackInternal onSubscriptionData, size: " + parcels.length + ", reason: " + reason);
            List<StepOSBaseEntity> entities = new ArrayList<>(parcels.length);
            for (CollectEventParcel parcel : parcels) {
                if (parcel == null || parcel.buffer == null) {
                    Log.w(StepOSCollectManager.TAG, "Skipping null parcel or buffer");
                } else {
                    Log.d(StepOSCollectManager.TAG, "Processing parcel with buffer size: " + parcel.buffer.length);
                    try {
                        StepOSCollectEvent event = new StepOSCollectEvent();
                        event.setBytes(parcel.buffer);
                        if (!event.parseBuffer() || !event.isValid()) {
                            Log.w(StepOSCollectManager.TAG, "Failed to parse buffer or invalid event");
                        } else {
                            StepOSBaseEntity entity = event.getEntity();
                            if (entity == null) {
                                Log.w(StepOSCollectManager.TAG, "Parsed event has null entity");
                            } else {
                                entities.add(entity);
                            }
                        }
                    } catch (Exception e) {
                        Log.e(StepOSCollectManager.TAG, "Error parsing CollectEventParcel: " + e.getMessage(), e);
                    }
                }
            }
            if (entities.isEmpty()) {
                Log.w(StepOSCollectManager.TAG, "No valid entities to report");
                return;
            }
            try {
                this.mCallback.onSubscribeData(entities);
            } catch (Exception e2) {
                Log.e(StepOSCollectManager.TAG, "Error in subscription callback: " + e2.getMessage(), e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class CollectPullAtomCallbackInternal extends ICollectPullCallback.Stub {
        public final int mAtomId;
        public final CollectPullAtomCallback mCallback;
        public final Executor mExecutor;

        CollectPullAtomCallbackInternal(int atomId, CollectPullAtomCallback callback, Executor executor) {
            if (callback == null) {
                throw new IllegalArgumentException("CollectPullAtomCallback cannot be null");
            }
            if (executor == null) {
                throw new IllegalArgumentException("Executor cannot be null");
            }
            this.mAtomId = atomId;
            this.mCallback = callback;
            this.mExecutor = executor;
        }

        @Override // android.os.collector.ICollectPullCallback
        public void onPullAtom(final int atomTag, final ICollectPullAtomResultReceiver resultReceiver) {
            Log.d(StepOSCollectManager.TAG, "CollectPullAtomCallbackInternal onPullAtom atomTag:" + atomTag);
            long token = Binder.clearCallingIdentity();
            try {
                this.mExecutor.execute(new Runnable() { // from class: android.os.collector.StepOSCollectManager$CollectPullAtomCallbackInternal$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onPullAtom$0(atomTag, resultReceiver);
                    }
                });
            } finally {
                Binder.restoreCallingIdentity(token);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPullAtom$0(int atomTag, ICollectPullAtomResultReceiver resultReceiver) {
            List<StepOSCollectEvent> data = new ArrayList<>();
            int successInt = this.mCallback.onPullAtom(atomTag, data);
            boolean success = successInt == 0;
            CollectEventParcel[] parcels = new CollectEventParcel[data.size()];
            for (int i = 0; i < data.size(); i++) {
                parcels[i] = new CollectEventParcel();
                parcels[i].buffer = data.get(i).getBytes();
            }
            Log.d(StepOSCollectManager.TAG, "resultReceiver.pullFinished atomTag:" + atomTag + ", success:" + success + ", data size:" + data.size());
            try {
                resultReceiver.pullFinished(atomTag, success, parcels);
            } catch (RemoteException e) {
                Log.w(StepOSCollectManager.TAG, "CollectPullResultReceiver failed for tag " + this.mAtomId + " due to TransactionTooLarge. Calling pullFinish with no data", e);
                CollectEventParcel[] emptyData = new CollectEventParcel[0];
                try {
                    resultReceiver.pullFinished(atomTag, false, emptyData);
                } catch (RemoteException nestedException) {
                    Log.e(StepOSCollectManager.TAG, "CollectPullResultReceiver failed for tag " + this.mAtomId + " with empty payload", nestedException);
                }
            }
        }
    }
}
