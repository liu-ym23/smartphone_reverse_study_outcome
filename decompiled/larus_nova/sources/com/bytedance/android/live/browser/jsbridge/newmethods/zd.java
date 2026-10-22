package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: classes45.dex */
public final class zd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vlc.d f63753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ies.web.jsbridge2.d0 f63754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IHybridComponent f63755c;

    public static final void a(zd r100) {
        r100.getClass();
        StringBuilder r101 = new StringBuilder("release message: ");
        vlc.d r102 = r100.f63753a;
        if (r102 == null) goto L5;
        Integer r103 = Integer.valueOf(r102.hashCode());
    L6:
        r101.append(r103);
        b(r101.toString());
        vlc.d r104 = r100.f63753a;
        if (r104 == null) goto L9;
        r104.release();
    L9:
        r100.f63753a = null;
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static void b(String r100) {
        ALogger.i("VenueMessageMethods", r100);
    }

    public zd(com.bytedance.ies.web.jsbridge2.d0 r100, IHybridComponent r101) {
        this.f63754b = r100;
        this.f63755c = r101;
    }
}
