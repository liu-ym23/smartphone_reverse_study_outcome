package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final State f169317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n0 f169318b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L10;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f169317a, r101.f169317a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f169318b, r101.f169318b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        State r100 = this.f169317a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        n0 r104 = this.f169318b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GalleryAnchorContainerData(state=" + this.f169317a + ", rect=" + this.f169318b + ")";
    }

    public j(State r100, n0 r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r101, SVGRenderEngine.RECT);
        this.f169317a = r100;
        this.f169318b = r101;
    }
}
