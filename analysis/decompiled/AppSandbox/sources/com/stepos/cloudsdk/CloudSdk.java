package com.stepos.cloudsdk;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class CloudSdk {
    private static final Object LOCK = new Object();
    private static final String TAG = "CloudSdk";
    private static volatile CloudSdk instance;
    private CloudClientImpl configClient;
    private boolean debugEnabled = false;

    private CloudSdk() {
    }

    public static CloudSdk init(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Package name cannot be empty");
        }
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = new CloudSdk();
                    instance.configClient = new CloudClientImpl(context, str);
                    Logger.i(TAG, "init: SDK initialized, packageName=" + str);
                }
            }
        }
        return instance;
    }

    public static CloudSdk getInstance() {
        if (instance == null) {
            throw new IllegalStateException("ConfigSdk not initialized. Please call init() first.");
        }
        return instance;
    }

    public static CloudClient getClient() {
        return getInstance().configClient;
    }

    public void setDebugEnabled(boolean z) {
        this.debugEnabled = z;
        Logger.setEnabled(z);
        Logger.i(TAG, "setDebugEnabled: " + z);
    }

    public boolean isDebugEnabled() {
        return this.debugEnabled;
    }

    public void release() {
        synchronized (LOCK) {
            CloudClientImpl cloudClientImpl = this.configClient;
            if (cloudClientImpl != null) {
                cloudClientImpl.release();
                this.configClient = null;
            }
            instance = null;
            Logger.i(TAG, "release: SDK released");
        }
    }

    public static String getVersion() {
        return "1.0.0";
    }
}
