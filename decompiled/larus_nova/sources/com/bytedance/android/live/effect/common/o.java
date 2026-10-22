package com.bytedance.android.live.effect.common;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f67868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView.ItemDecoration f67869b;

    public o() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L10;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f67868a, r101.f67868a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f67869b, r101.f67869b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        f r100 = this.f67868a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        RecyclerView.ItemDecoration r104 = this.f67869b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveCommonStickerListStyleConfig(itemViewProvider=" + this.f67868a + ", decor=" + this.f67869b + ")";
    }

    public o(j r100, int r101) {
        f r102 = r100;
        if ((r101 & 1) == 0) goto L6;
        r102 = new e();
    L6:
        if ((r101 & 2) == 0) goto L8;
        DefaultLiveCommonStickerListItemDecoration r103 = new DefaultLiveCommonStickerListItemDecoration();
    L9:
        Intrinsics.checkNotNullParameter(r102, "itemViewProvider");
        this.f67868a = r102;
        this.f67869b = r103;
        return;
    L8:
        r103 = null;
        goto L9
    }
}
