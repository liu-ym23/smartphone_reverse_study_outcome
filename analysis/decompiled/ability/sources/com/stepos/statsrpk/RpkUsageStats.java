package com.stepos.statsrpk;

import android.content.Context;
import java.util.Map;

/* loaded from: classes3.dex */
public class RpkUsageStats {
    private static String TAG = "RpkUsageStats";
    private static RpkUsageStats sInstance;
    private static final Object sLock = new Object();
    private Context mContext;
    private RpkInfo mRpkInfo;
    private e mRpkInstance;
    private V5.a sharedPreferencesHelper;

    private RpkUsageStats(Context context, String str, String str2, int i) {
        if (context == null) {
            throw new IllegalArgumentException("The context is null!");
        }
        this.mContext = context.getApplicationContext();
        long jCurrentTimeMillis = System.currentTimeMillis();
        RpkInfo rpkInfo = new RpkInfo();
        this.mRpkInfo = rpkInfo;
        rpkInfo.f3976a = str;
        rpkInfo.b = str2;
        rpkInfo.c = i;
        S0.b.n = "6KAIUyh8oTuWsB0JiE9";
        S0.b.f1164j = "https://uxip.stepaos.com/api/v3/event/";
        S0.b.k = "https://uxip-config.stepaos.com/api/v3/umid/privacy";
        S0.b.l = "https://uxip-res.stepaos.com/resource/v3/config/";
        S0.b.m = "https://uxip-res.stepaos.com/resource/v3/config/rpk/";
        findRelativeApp(str);
        W5.c.a(TAG, "##### RpkUsageStats init complete, " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    private void findRelativeApp(String str) {
        W5.c.a(TAG, "##### RpkUsageStats findRelativeApp: " + str);
        d.j(new a(this, str, 2));
    }

    public static RpkUsageStats getInstance() {
        return sInstance;
    }

    public static void init(Context context, String str, String str2, int i) {
        if (sInstance == null) {
            synchronized (sLock) {
                try {
                    if (sInstance == null) {
                        sInstance = new RpkUsageStats(context, str, str2, i);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void onEvent(String str, String str2, Map<String, String> map) {
        W5.c.a(TAG, "##### RpkUsageStats onEvent: " + str);
        d.j(new H.e(this, str, str2, map, 1));
    }

    public void onPageHide(String str) {
        W5.c.a(TAG, "##### RpkUsageStats onPageHide: " + str);
        d.j(new a(this, str, 1));
    }

    public void onPageShow(String str) {
        W5.c.a(TAG, "##### RpkUsageStats onPageShow: " + str);
        d.j(new a(this, str, 0));
    }
}
