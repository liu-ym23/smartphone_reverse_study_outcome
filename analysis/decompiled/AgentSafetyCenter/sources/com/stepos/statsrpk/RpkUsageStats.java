package com.stepos.statsrpk;

import android.content.Context;
import java.lang.invoke.VarHandle;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class RpkUsageStats {
    private static String TAG = "RpkUsageStats";
    private static RpkUsageStats sInstance;
    private static final Object sLock = new Object();
    private Context mContext;
    private b mRpkInfo;
    private i mRpkInstance;
    private ta.a sharedPreferencesHelper;

    private RpkUsageStats(Context context, String str, String str2, int i) {
        if (context == null) {
            g5.f.s("The context is null!");
            throw null;
        }
        this.mContext = context.getApplicationContext();
        long jCurrentTimeMillis = System.currentTimeMillis();
        b bVar = new b();
        this.mRpkInfo = bVar;
        bVar.f2848c = str;
        bVar.f2849f = str2;
        bVar.f2850g = i;
        h.f2869g = "6KAIUyh8oTuWsB0JiE9";
        h.f2865c = "https://uxip.stepaos.com/api/v3/event/";
        h.f2866d = "https://uxip-config.stepaos.com/api/v3/umid/privacy";
        h.f2867e = "https://uxip-res.stepaos.com/resource/v3/config/";
        h.f2868f = "https://uxip-res.stepaos.com/resource/v3/config/rpk/";
        findRelativeApp(str);
        ua.c.a(TAG, "##### RpkUsageStats init complete, " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    private void findRelativeApp(String str) {
        ua.c.a(TAG, "##### RpkUsageStats findRelativeApp: " + str);
        d dVar = new d(2);
        dVar.f2858g = this;
        dVar.f2857f = str;
        VarHandle.storeStoreFence();
        h.c(dVar);
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
        ua.c.a(TAG, "##### RpkUsageStats onEvent: " + str);
        c cVar = new c(0);
        cVar.i = this;
        cVar.f2853f = str;
        cVar.f2854g = str2;
        cVar.f2855h = map;
        VarHandle.storeStoreFence();
        h.c(cVar);
    }

    public void onPageHide(String str) {
        ua.c.a(TAG, "##### RpkUsageStats onPageHide: " + str);
        d dVar = new d(1);
        dVar.f2858g = this;
        dVar.f2857f = str;
        VarHandle.storeStoreFence();
        h.c(dVar);
    }

    public void onPageShow(String str) {
        ua.c.a(TAG, "##### RpkUsageStats onPageShow: " + str);
        d dVar = new d(0);
        dVar.f2858g = this;
        dVar.f2857f = str;
        VarHandle.storeStoreFence();
        h.c(dVar);
    }
}
