package com.stepos.cloudsdk;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.stepos.cloudsdk.ICloudListener;
import com.stepos.cloudsdk.internal.CloudUpdateReceiver;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class CloudClientImpl implements CloudClient {
    private static final String KEY_GLOBAL = "__GLOBAL__";
    private static final String TAG = "CloudClientImpl";
    private final Context context;
    private final String packageName;
    private CloudUpdateReceiver receiver;
    private boolean isRegistered = false;
    private final Map<String, ICloudListener> listenerMap = new ConcurrentHashMap();
    private final ExecutorService executorService = Executors.newFixedThreadPool(2);

    CloudClientImpl(Context context, String str) {
        this.context = context.getApplicationContext();
        this.packageName = str;
    }

    @Override // com.stepos.cloudsdk.CloudClient
    public void registerForUpdates() {
        synchronized (this) {
            if (this.isRegistered) {
                Logger.d(TAG, "registerForUpdates: already registered");
                return;
            }
            if (this.receiver == null) {
                this.receiver = new CloudUpdateReceiver(new CloudUpdateReceiver.ConfigUpdateCallback() { // from class: com.stepos.cloudsdk.CloudClientImpl$$ExternalSyntheticLambda1
                    @Override // com.stepos.cloudsdk.internal.CloudUpdateReceiver.ConfigUpdateCallback
                    public final void onConfigUpdated(String str) {
                        this.f$0.notifyListeners(str);
                    }
                });
            }
            this.receiver.register(this.context);
            this.isRegistered = true;
            Logger.d(TAG, "registerForUpdates: registered");
        }
    }

    @Override // com.stepos.cloudsdk.CloudClient
    public void unregisterForUpdates() {
        CloudUpdateReceiver cloudUpdateReceiver;
        synchronized (this) {
            if (this.isRegistered && (cloudUpdateReceiver = this.receiver) != null) {
                cloudUpdateReceiver.unregister(this.context);
                this.isRegistered = false;
                Logger.d(TAG, "unregisterForUpdates: unregistered");
                return;
            }
            Logger.d(TAG, "unregisterForUpdates: not registered");
        }
    }

    @Override // com.stepos.cloudsdk.CloudClient
    public void addListener(ICloudListener iCloudListener) {
        this.listenerMap.put(KEY_GLOBAL, iCloudListener);
        Logger.d(TAG, "addListener: global listener added, total=" + this.listenerMap.size());
    }

    @Override // com.stepos.cloudsdk.CloudClient
    public void addListener(String str, ICloudListener iCloudListener) {
        if (TextUtils.isEmpty(str)) {
            Logger.e(TAG, "addListener: key is empty, use global listener instead");
            addListener(iCloudListener);
            return;
        }
        this.listenerMap.put(str, iCloudListener);
        Logger.d(TAG, "addListener: key=" + str + ", total=" + this.listenerMap.size());
    }

    @Override // com.stepos.cloudsdk.CloudClient
    public void removeListener(ICloudListener iCloudListener) {
        Iterator<Map.Entry<String, ICloudListener>> it = this.listenerMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, ICloudListener> next = it.next();
            if (next.getValue() == iCloudListener) {
                it.remove();
                Logger.d(TAG, "removeListener: removed listener for key=" + next.getKey());
            }
        }
        Logger.d(TAG, "removeListener: total=" + this.listenerMap.size());
    }

    @Override // com.stepos.cloudsdk.CloudClient
    public void removeListener(String str) {
        if (this.listenerMap.remove(str) != null) {
            Logger.d(TAG, "removeListener: removed listener for key=" + str);
        }
        Logger.d(TAG, "removeListener: total=" + this.listenerMap.size());
    }

    @Override // com.stepos.cloudsdk.CloudClient
    public void removeAllListeners() {
        int size = this.listenerMap.size();
        this.listenerMap.clear();
        Logger.d(TAG, "removeAllListeners: removed " + size + " listeners");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListeners(final String str) {
        if (this.listenerMap.isEmpty()) {
            Logger.d(TAG, "notifyListeners: no listeners, key=" + str);
            return;
        }
        Logger.d(TAG, "notifyListeners: key=" + str + ", listenerCount=" + this.listenerMap.size());
        final ICloudListener iCloudListenerFindMatchingListener = findMatchingListener(str);
        if (iCloudListenerFindMatchingListener == null) {
            Logger.d(TAG, "notifyListeners: no matching listener for key=" + str);
            return;
        }
        this.executorService.execute(new Runnable() { // from class: com.stepos.cloudsdk.CloudClientImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m326lambda$notifyListeners$0$comsteposcloudsdkCloudClientImpl(str, iCloudListenerFindMatchingListener);
            }
        });
    }

    /* renamed from: lambda$notifyListeners$0$com-stepos-cloudsdk-CloudClientImpl, reason: not valid java name */
    /* synthetic */ void m326lambda$notifyListeners$0$comsteposcloudsdkCloudClientImpl(String str, ICloudListener iCloudListener) {
        ICloudListener.ResultCode resultCodeApplyInputStream;
        try {
            InputStream inputStreamOpenFileInputStream = openFileInputStream(str);
            if (inputStreamOpenFileInputStream != null) {
                resultCodeApplyInputStream = iCloudListener.applyInputStream(str, inputStreamOpenFileInputStream);
                Logger.d(TAG, "notifyListeners: applyInputStream result=" + resultCodeApplyInputStream.getInfo());
            } else {
                resultCodeApplyInputStream = ICloudListener.ResultCode.FILE_NOT_EXIST;
                Logger.e(TAG, "notifyListeners: failed to open file stream for key=" + str);
            }
            updateConfigState(str, resultCodeApplyInputStream);
        } catch (Exception e) {
            Logger.e(TAG, "notifyListeners: listener callback failed for key=" + str, e);
            updateConfigState(str, ICloudListener.ResultCode.INNER_ERROR);
        }
    }

    private ICloudListener findMatchingListener(String str) {
        ICloudListener iCloudListener;
        if (this.listenerMap.size() == 1) {
            return this.listenerMap.values().iterator().next();
        }
        if (!TextUtils.isEmpty(str) && (iCloudListener = this.listenerMap.get(str)) != null) {
            Logger.d(TAG, "findMatchingListener: matched by key=" + str);
            return iCloudListener;
        }
        ICloudListener iCloudListener2 = this.listenerMap.get(KEY_GLOBAL);
        if (iCloudListener2 != null) {
            Logger.d(TAG, "findMatchingListener: using global listener for key=" + str);
            return iCloudListener2;
        }
        Logger.d(TAG, "findMatchingListener: no matching listener for key=" + str);
        return null;
    }

    private InputStream openFileInputStream(String str) throws FileNotFoundException {
        try {
            InputStream inputStreamOpenInputStream = this.context.getContentResolver().openInputStream(buildFileUri(str));
            StringBuilder sb = new StringBuilder("openFileInputStream: key=");
            sb.append(str);
            sb.append(", success=");
            sb.append(inputStreamOpenInputStream != null);
            Logger.d(TAG, sb.toString());
            return inputStreamOpenInputStream;
        } catch (Exception e) {
            Logger.e(TAG, "openFileInputStream: failed for key=" + str, e);
            return null;
        }
    }

    private Uri buildFileUri(String str) {
        return Uri.parse("content://com.stepos.cloudconfig.provider/file/" + this.packageName + "/" + str);
    }

    private Uri buildStateUri(String str) {
        return Uri.parse("content://com.stepos.cloudconfig.provider/state/" + this.packageName + "/" + str);
    }

    private void updateConfigState(String str, ICloudListener.ResultCode resultCode) {
        try {
            Uri uriBuildStateUri = buildStateUri(str);
            ContentValues contentValues = new ContentValues();
            if (resultCode == ICloudListener.ResultCode.SUCCESS) {
                contentValues.put("state", (Integer) 1);
            } else {
                contentValues.put("state", (Integer) 2);
            }
            contentValues.put(Constants.COLUMN_RESULT_CODE, resultCode.getInfo());
            Logger.d(TAG, "updateConfigState: key=" + str + ", result=" + resultCode.getInfo() + ", rowsUpdated=" + this.context.getContentResolver().update(uriBuildStateUri, contentValues, null, null));
        } catch (Exception e) {
            Logger.e(TAG, "updateConfigState: failed for key=" + str, e);
        }
    }

    void release() {
        unregisterForUpdates();
        removeAllListeners();
        this.executorService.shutdown();
        Logger.d(TAG, "release: resources released");
    }
}
