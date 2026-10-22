package com.stepos.statsrpk;

import android.content.Context;
import java.util.Map;
import k.RunnableC0653g;

/* loaded from: classes.dex */
public class RpkUsageStats {
    private static String TAG = "RpkUsageStats";
    private static RpkUsageStats sInstance;
    private static final Object sLock = new Object();
    private Context mContext;
    private RpkInfo mRpkInfo;
    private d mRpkInstance;
    private S2.a sharedPreferencesHelper;

    private RpkUsageStats(Context context, String str, String str2, int i4) {
        if (context == null) {
            throw new IllegalArgumentException("The context is null!");
        }
        this.mContext = context.getApplicationContext();
        long jCurrentTimeMillis = System.currentTimeMillis();
        RpkInfo rpkInfo = new RpkInfo();
        this.mRpkInfo = rpkInfo;
        rpkInfo.f12349a = str;
        rpkInfo.f12350b = str2;
        rpkInfo.f12351c = i4;
        c.f12363f = "6KAIUyh8oTuWsB0JiE9";
        c.f12359b = "http://uxip.zyql.com/api/v3/event/";
        c.f12360c = "http://uxip-config.zyql.com/api/v3/umid/privacy";
        c.f12361d = "http://uxip-res.zyql.com/resource/v3/config/";
        c.f12362e = "http://uxip-res.zyql.com/resource/v3/config/rpk/";
        findRelativeApp(str);
        T2.d.a(TAG, "##### RpkUsageStats init complete, " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    private void findRelativeApp(String str) {
        T2.d.a(TAG, "##### RpkUsageStats findRelativeApp: " + str);
        c.f(new a(this, str, 2));
    }

    public static RpkUsageStats getInstance() {
        return sInstance;
    }

    public static void init(Context context, String str, String str2, int i4) {
        if (sInstance == null) {
            synchronized (sLock) {
                try {
                    if (sInstance == null) {
                        sInstance = new RpkUsageStats(context, str, str2, i4);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void onEvent(String str, String str2, Map<String, String> map) {
        T2.d.a(TAG, "##### RpkUsageStats onEvent: " + str);
        c.f(new RunnableC0653g(3, this, str, str2, map));
    }

    public void onPageHide(String str) {
        T2.d.a(TAG, "##### RpkUsageStats onPageHide: " + str);
        c.f(new a(this, str, 1));
    }

    public void onPageShow(String str) {
        T2.d.a(TAG, "##### RpkUsageStats onPageShow: " + str);
        c.f(new a(this, str, 0));
    }
}
