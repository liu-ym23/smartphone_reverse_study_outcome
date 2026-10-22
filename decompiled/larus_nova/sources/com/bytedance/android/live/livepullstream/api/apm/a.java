package com.bytedance.android.live.livepullstream.api.apm;

/* JADX INFO: loaded from: classes46.dex */
public final class a {
    public static APMEvent a(APMEvent.Level r100, String r101) {
        APMEvent r102 = new APMEvent();
        r102.d(r101);
        r102.e(r100);
        r102.g(System.currentTimeMillis());
        return r102;
    }

    public static APMEvent b(APMEvent.Level r100, String r101, long r102) {
        APMEvent r103 = new APMEvent();
        r103.d(r101);
        r103.e(r100);
        r103.g(r102);
        return r103;
    }

    public static APMEvent c(APMEvent.Level r100, String r101, String r102) {
        APMEvent r103 = new APMEvent();
        r103.d(r101);
        r103.e(r100);
        r103.f(r102);
        r103.g(System.currentTimeMillis());
        return r103;
    }
}
