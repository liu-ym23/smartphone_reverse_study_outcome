package com.bytedance.android.live.broadcastgame.xplay.littlewindow;

import com.bytedance.android.live.broadcastgame.api.xplay.LittleWindowPos;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LittleWindowPos f62262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f62263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f62264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f62265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f62266e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L16;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f62262a, r101.f62262a) == true) goto L8;
        return false;
    L8:
        if (this.f62263b == r101.f62263b) goto L10;
        return false;
    L10:
        if (this.f62264c == r101.f62264c) goto L12;
        return false;
    L12:
        if (Float.compare(this.f62265d, r101.f62265d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.f62266e, r101.f62266e) == 0) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        LittleWindowPos r100 = this.f62262a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f62263b;
        ?? r104 = 1;
        ?? r105 = r103;
        if (r103 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r102 + r105) * 31;
        boolean r107 = this.f62264c;
        if (r107 == true) goto L14;
        r104 = r107;
    L14:
        return ((((r106 + r104) * 31) + Float.floatToIntBits(this.f62265d)) * 31) + Float.floatToIntBits(this.f62266e);
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "LittleWindowState(position=" + this.f62262a + ", small=" + this.f62263b + ", isCustom=" + this.f62264c + ", x=" + this.f62265d + ", y=" + this.f62266e + ")";
    }

    public /* synthetic */ g(LittleWindowPos r100, boolean r101) {
        this(r100, r101, false, 0.0f, 0.0f);
    }

    public static g a(g r100, LittleWindowPos r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        r101 = r100.f62262a;
    L5:
        LittleWindowPos r104 = r101;
        if ((r103 & 2) == 0) goto L8;
        r102 = r100.f62263b;
    L8:
        boolean r105 = r102;
        if ((r103 & 4) == 0) goto L11;
        boolean r106 = r100.f62264c;
    L13:
        if ((r103 & 8) == 0) goto L15;
        float r107 = r100.f62265d;
    L17:
        if ((r103 & 16) == 0) goto L19;
        float r108 = r100.f62266e;
    L20:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r104, "position");
        return new g(r104, r105, r106, r107, r108);
    L19:
        r108 = 0.0f;
        goto L20
    L15:
        r107 = 0.0f;
        goto L17
    L11:
        r106 = false;
        goto L13
    }

    public g(LittleWindowPos r100, boolean r101, boolean r102, float r103, float r104) {
        Intrinsics.checkNotNullParameter(r100, "position");
        this.f62262a = r100;
        this.f62263b = r101;
        this.f62264c = r102;
        this.f62265d = r103;
        this.f62266e = r104;
    }
}
