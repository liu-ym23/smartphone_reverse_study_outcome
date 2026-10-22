package com.bytedance.android.live.revlink.link.domain.anchorimpl;

import android.graphics.RectF;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f98444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f98445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f98446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f98447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f98448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f98449f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L18;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f98444a, r101.f98444a) == true) goto L8;
        return false;
    L8:
        if (this.f98445b == r101.f98445b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f98446c, r101.f98446c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f98447d, r101.f98447d) == true) goto L14;
        return false;
    L14:
        if (this.f98448e == r101.f98448e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f98449f, r101.f98449f) == true) goto L28;
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
    public final int hashCode() {
        String r100 = this.f98444a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f98445b;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        RectF r107 = this.f98446c;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        RectF r110 = this.f98447d;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (((r109 + r111) * 31) + this.f98448e) * 31;
        Function0<Unit> r113 = this.f98449f;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        return r112 + r101;
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "RenderState(zOrder=" + this.f98448e + ", layerRectF={width=" + this.f98447d.width() + ", height=" + this.f98447d.height() + ",top=" + this.f98447d.top + ", bottom=" + this.f98447d.bottom + "}, screenRectF={width=" + this.f98446c.width() + ", height=" + this.f98446c.height() + ", top=" + this.f98446c.top + ", bottom=" + this.f98446c.bottom + ", visible=" + this.f98445b + ", linkerID='" + this.f98444a + "')";
    }

    public /* synthetic */ p(String r100, RectF r101, RectF r110) {
        this(r100, true, r101, r110, 0, null);
    }

    public p(String r100, boolean r101, RectF r102, RectF r103, int r104, Function0<Unit> r105) {
        Intrinsics.checkNotNullParameter(r100, "linkerID");
        Intrinsics.checkNotNullParameter(r102, "screenRectF");
        Intrinsics.checkNotNullParameter(r103, "layerRectF");
        this.f98444a = r100;
        this.f98445b = r101;
        this.f98446c = r102;
        this.f98447d = r103;
        this.f98448e = r104;
        this.f98449f = r105;
    }
}
