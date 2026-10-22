package com.bytedance.android.livesdk.chatroom.vsplayer.model;

import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements Comparable<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f118417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f118418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f118419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f118420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f118421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f118422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f118423g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f118424h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f118425i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f118426j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final k f118427k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f118428l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f118429m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f118430n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f118431o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f118432p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f118433q;

    public static final class a {
    }

    static {
    }

    public e() {
        this(null, 0, 0, 0, 0, 0, null, 0, false, false, false, 16383);
    }

    @Override // java.lang.Comparable
    public final int compareTo(e r100) {
        e r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        int r102 = this.f118428l;
        int r103 = r101.f118428l;
        if (r102 != r103) goto L6;
        return (int) (this.f118423g - r101.f118423g);
    L6:
        return r102 - r103;
    }

    public e(String r110, long r111, long r210, long r211, long r212, int r213, k r214, int r215, boolean r216, boolean r310, boolean r311, int r312) {
        if ((r312 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r312 & 2) == 0) goto L9;
        long r101 = 1;
    L10:
        long r102 = 0;
        if ((r312 & 4) == 0) goto L13;
        long r103 = 0;
    L15:
        if ((r312 & 8) == 0) goto L17;
        long r112 = r103;
    L19:
        if ((r312 & 16) != 0) goto L23;
        r102 = r212;
    L23:
        if ((r312 & 32) == 0) goto L25;
        int r104 = ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT);
    L27:
        if ((r312 & 128) == 0) goto L29;
        k r113 = null;
    L31:
        if ((r312 & 512) == 0) goto L33;
        int r114 = 1;
    L35:
        if ((r312 & 1024) == 0) goto L37;
        boolean r115 = false;
    L39:
        if ((r312 & 4096) == 0) goto L41;
        boolean r116 = false;
    L43:
        if ((r312 & 8192) == 0) goto L45;
        boolean r117 = false;
    L46:
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.f118421e = r100;
        this.f118422f = r101;
        this.f118423g = r103;
        this.f118424h = r112;
        this.f118425i = r102;
        this.f118426j = r104;
        this.f118427k = r113;
        this.f118428l = 0;
        this.f118429m = r114;
        this.f118430n = r115;
        this.f118431o = false;
        this.f118432p = r116;
        this.f118433q = r117;
        return;
    L45:
        r117 = r311;
        goto L46
    L41:
        r116 = r310;
        goto L43
    L37:
        r115 = r216;
        goto L39
    L33:
        r114 = r215;
        goto L35
    L29:
        r113 = r214;
        goto L31
    L25:
        r104 = r213;
        goto L27
    L17:
        r112 = r211;
        goto L19
    L13:
        r103 = r210;
        goto L15
    L9:
        r101 = r111;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }
}
