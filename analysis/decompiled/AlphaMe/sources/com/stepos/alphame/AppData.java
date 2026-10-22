package com.stepos.alphame;

import android.annotation.SuppressLint;
import android.content.Context;

/* loaded from: classes.dex */
public final class AppData {
    private static final int NAVIGATION_TYPE = 10;
    private static final int RUNNING_TYPE = 11;
    private static final String TAG = "AppData";

    @SuppressLint({"StaticFieldLeak"})
    private static AppData sInstance;
    private Context mContext;

    private AppData(Context context) {
        this.mContext = context;
    }

    public static synchronized AppData getInstance(Context context) {
        try {
            if (sInstance == null) {
                sInstance = new AppData(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    public synchronized int getAppType(String str) {
        return 0;
    }

    public boolean isMusicTypeApp(String str) {
        return getAppType(str) == 14;
    }

    public boolean isNavigationTypeApp(String str) {
        int appType = getAppType(str);
        return appType == 10 || appType == 11;
    }
}
