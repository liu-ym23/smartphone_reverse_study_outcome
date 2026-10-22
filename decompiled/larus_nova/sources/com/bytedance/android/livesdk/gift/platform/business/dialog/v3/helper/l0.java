package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f127438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f127439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f127440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vz1.e f127441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f127442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f127443f;

    public l0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l0) == false) goto L18;
        l0 r101 = (l0) r100;
        if (this.f127438a == r101.f127438a) goto L8;
        return false;
    L8:
        if (this.f127439b == r101.f127439b) goto L10;
        return false;
    L10:
        if (this.f127440c == r101.f127440c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f127441d, r101.f127441d) == true) goto L14;
        return false;
    L14:
        if (this.f127442e == r101.f127442e) goto L16;
        return false;
    L16:
        if (this.f127443f == r101.f127443f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    public final int hashCode() {
        boolean r100 = this.f127438a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = ((((r101 * 31) + this.f127439b) * 31) + this.f127440c) * 31;
        vz1.e r103 = this.f127441d;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return ((((r102 + r104) * 31) + this.f127442e) * 31) + this.f127443f;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "SaveSelectedStatus(needSelect=" + this.f127438a + ", pagePos=" + this.f127439b + ", pos=" + this.f127440c + ", dialogIconModel=" + this.f127441d + ", pageType=" + this.f127442e + ", counterPosition=" + this.f127443f + ")";
    }

    public /* synthetic */ l0(int r100) {
        this(false, -1, -1, null, 0, -1);
    }

    public l0(boolean r100, int r101, int r102, vz1.e r103, int r104, int r105) {
        this.f127438a = r100;
        this.f127439b = r101;
        this.f127440c = r102;
        this.f127441d = r103;
        this.f127442e = r104;
        this.f127443f = r105;
    }
}
