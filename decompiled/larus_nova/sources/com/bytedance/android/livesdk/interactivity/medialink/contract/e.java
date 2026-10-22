package com.bytedance.android.livesdk.interactivity.medialink.contract;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements x32.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f137996c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x32.c f137997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x32.d f137998b;

    public static final class a {
    }

    static {
    }

    public e() {
        this(null, null, 3);
    }

    public final int hashCode() {
        x32.c r100 = this.f137997a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        x32.d r104 = this.f137998b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MediaLinkSwitchExtraContext(multiLinkAnchorSwitchContext=" + this.f137997a + ", multiLinkAudienceSwitchContext=" + this.f137998b + ")";
    }

    @Override // x32.b
    public final x32.d W0() {
        return this.f137998b;
    }

    @Override // x32.b
    public final x32.c a() {
        return this.f137997a;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f137997a, r101.f137997a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f137998b, r101.f137998b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public e(f r100, g r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this.f137997a = r100;
        this.f137998b = r101;
    }
}
