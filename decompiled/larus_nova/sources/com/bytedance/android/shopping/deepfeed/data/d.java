package com.bytedance.android.shopping.deepfeed.data;

import android.view.View;
import android.view.animation.PathInterpolator;
import com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedProductSlcView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f173110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f173111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f173112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f173113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f173114e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f173115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PathInterpolator f173116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Unit> f173117h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L22;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f173110a, r101.f173110a) == true) goto L8;
        return false;
    L8:
        if (this.f173111b == r101.f173111b) goto L10;
        return false;
    L10:
        if (this.f173112c == r101.f173112c) goto L12;
        return false;
    L12:
        if (this.f173113d == r101.f173113d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f173114e, r101.f173114e) == true) goto L16;
        return false;
    L16:
        if (this.f173115f == r101.f173115f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f173116g, r101.f173116g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f173117h, r101.f173117h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    public final int hashCode() {
        String r100 = this.f173110a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f173111b;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (((((r103 + r105) * 31) + this.f173112c) * 31) + this.f173113d) * 31;
        View r107 = this.f173114e;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        long r110 = this.f173115f;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        PathInterpolator r112 = this.f173116g;
        if (r112 == null) goto L16;
        int r113 = r112.hashCode();
    L17:
        int r114 = (r111 + r113) * 31;
        Function0<Unit> r115 = this.f173117h;
        if (r115 == null) goto L21;
        r101 = r115.hashCode();
    L21:
        return r114 + r101;
    L16:
        r113 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedScrollTopParams(tipsText=" + this.f173110a + ", isShowTips=" + this.f173111b + ", finalHeight=" + this.f173112c + ", position=" + this.f173113d + ", view=" + this.f173114e + ", durationMs=" + this.f173115f + ", interpolator=" + this.f173116g + ", callback=" + this.f173117h + ")";
    }

    public d(String r100, boolean r101, int r102, int r103, DeepFeedProductSlcView r104, long r105, PathInterpolator r106, Function0 r110) {
        Intrinsics.checkNotNullParameter(r100, "tipsText");
        Intrinsics.checkNotNullParameter(r104, "view");
        Intrinsics.checkNotNullParameter(r110, "callback");
        this.f173110a = r100;
        this.f173111b = r101;
        this.f173112c = r102;
        this.f173113d = r103;
        this.f173114e = r104;
        this.f173115f = r105;
        this.f173116g = r106;
        this.f173117h = r110;
    }
}
