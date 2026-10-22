package com.bytedance.android.live.revlink.impl.player;

import android.graphics.Matrix;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f97418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f97419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f97420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f97421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Matrix f97422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f97423f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L18;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f97418a, r101.f97418a) == true) goto L8;
        return false;
    L8:
        if (this.f97419b == r101.f97419b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f97420c, r101.f97420c) == true) goto L12;
        return false;
    L12:
        if (this.f97421d == r101.f97421d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f97422e, r101.f97422e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f97423f, r101.f97423f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        RectF r100 = this.f97418a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f97419b;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        Integer r108 = this.f97420c;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.f97421d;
        if (r111 == true) goto L17;
        r105 = r111;
    L17:
        int r112 = (r110 + r105) * 31;
        Matrix r113 = this.f97422e;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f97423f;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        return r115 + r101;
    L20:
        r114 = 0;
        goto L21
    L12:
        r109 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ExtraStreamRenderDataInner(contentInScreen=" + this.f97418a + ", needBackGround=" + this.f97419b + ", version=" + this.f97420c + ", isPortrait=" + this.f97421d + ", gridMatrix=" + this.f97422e + ", seiRaw=" + this.f97423f + ")";
    }

    public b(RectF r100, boolean r101, Integer r102, boolean r103, Matrix r104, String r105) {
        Intrinsics.checkNotNullParameter(r104, "gridMatrix");
        Intrinsics.checkNotNullParameter(r105, "seiRaw");
        this.f97418a = r100;
        this.f97419b = r101;
        this.f97420c = r102;
        this.f97421d = r103;
        this.f97422e = r104;
        this.f97423f = r105;
    }
}
