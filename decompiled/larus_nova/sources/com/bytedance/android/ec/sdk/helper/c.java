package com.bytedance.android.ec.sdk.helper;

import kotlin.Deprecated;

/* JADX INFO: loaded from: classes44.dex */
@Deprecated(message = "use ECLogService instead.")
public final class c implements ji.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f48117a = null;

    public c() {
    }

    static {
        f48117a = new c();
    }

    public final void a(String r100, String r101) {
        log(3, "EC_SDK_".concat(r100), r101);
    }

    public final void b(String r100, String r101) {
        log(4, "EC_SDK_" + r100, r101);
    }

    @Override // ji.a
    public final void log(int r100, String r101, String r102) {
        ji.a r103 = d.f48119b.getIECHostALogService();
        if (r103 != null) goto L5;
        r103 = new b();
    L5:
        r103.log(r100, r101, r102);
    }
}
