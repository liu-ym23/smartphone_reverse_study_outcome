package com.bytedance.android.live.recharge.model;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final d f90011p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f90012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f90013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f90014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f90015d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f90016e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f90017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f90018g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f90019h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f90020i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f90021j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f90022k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f90023l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, String> f90024m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f90025n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f90026o;

    public static final class a {
    }

    static {
        f90011p = new d(true, "", null, 0, false, 0, 0, null, null, null, null, null, null, 32764);
    }

    public /* synthetic */ d(boolean r210, String r211, String r212, long r213, boolean r214, int r215, int r216, String r217, String r218, b r310, f r311, String r312, String r313, int r314) {
        if ((r314 & 4) == 0) goto L5;
        String r100 = "live_detail";
    L7:
        if ((r314 & 8) == 0) goto L9;
        long r101 = 0;
    L11:
        if ((r314 & 16) != 0) goto L13;
        boolean r102 = r214;
    L19:
        if ((r314 & 32) == 0) goto L21;
        int r103 = -1;
    L23:
        if ((r314 & 64) == 0) goto L25;
        int r110 = -1;
    L27:
        if ((r314 & 128) == 0) goto L29;
        String r111 = "";
    L31:
        if ((r314 & 256) == 0) goto L33;
        String r112 = "";
    L35:
        if ((r314 & 512) == 0) goto L37;
        b r113 = null;
    L39:
        if ((r314 & 1024) == 0) goto L41;
        f r114 = null;
    L43:
        if ((r314 & 2048) == 0) goto L45;
        String r115 = null;
    L47:
        if ((r314 & 8192) == 0) goto L49;
        String r116 = "";
    L51:
        if ((r314 & 16384) == 0) goto L53;
        String r117 = "";
    L54:
        this(r210, r211, r100, r101, r102, r103, r110, r111, r112, r113, r114, r115, null, r116, r117);
        return;
    L53:
        r117 = r313;
        goto L54
    L49:
        r116 = null;
        goto L51
    L45:
        r115 = r312;
        goto L47
    L41:
        r114 = r311;
        goto L43
    L37:
        r113 = r310;
        goto L39
    L33:
        r112 = r218;
        goto L35
    L29:
        r111 = r217;
        goto L31
    L25:
        r110 = r216;
        goto L27
    L21:
        r103 = r215;
        goto L23
    L13:
        if (r101 <= 0) goto L15;
        boolean r104 = true;
    L16:
        r102 = r104;
        goto L19
    L15:
        r104 = false;
        goto L16
    L9:
        r101 = r213;
        goto L11
    L5:
        r100 = r212;
        goto L7
    }

    public d(boolean r100, String r101, String r110, long r111, boolean r112, int r113, int r114, String r115, String r116, b r117, f r118, String r210, Map<String, String> r211, String r212, String r213) {
        Intrinsics.checkNotNullParameter(r101, "chargeReason");
        Intrinsics.checkNotNullParameter(r110, "requestPage");
        Intrinsics.checkNotNullParameter(r115, "chargeScene");
        Intrinsics.checkNotNullParameter(r116, "showType");
        Intrinsics.checkNotNullParameter(r213, "couponIdV2");
        this.f90012a = r100;
        this.f90013b = r101;
        this.f90014c = r110;
        this.f90015d = r111;
        this.f90016e = r112;
        this.f90017f = r113;
        this.f90018g = r114;
        this.f90019h = r115;
        this.f90020i = r116;
        this.f90021j = r117;
        this.f90022k = r118;
        this.f90023l = r210;
        this.f90024m = r211;
        this.f90025n = r212;
        this.f90026o = r213;
    }
}
