package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import com.bytedance.android.shopping.anchorv3.detail.widget.VideoHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f167874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VideoHolder f167875b;

    public d() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f167874a, r101.f167874a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f167875b, r101.f167875b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f167874a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        VideoHolder r104 = this.f167875b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MediaMeta(identifier=" + this.f167874a + ", holder=" + this.f167875b + ")";
    }

    public final String getIdentifier() {
        return this.f167874a;
    }

    public d(String r100, VideoHolder r101) {
        this.f167874a = r100;
        this.f167875b = r101;
    }
}
