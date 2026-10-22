package com.bytedance.android.live.ui.artist;

import android.text.style.ImageSpan;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f102047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IntRange f102048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageSpan f102049c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f102047a, r101.f102047a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f102048b, r101.f102048b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f102049c, r101.f102049c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f102047a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        IntRange r104 = this.f102048b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ImageSpan r107 = this.f102049c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ImageSlice(value=" + this.f102047a + ", range=" + this.f102048b + ", image=" + this.f102049c + ")";
    }

    public d(String r100, IntRange r101, ImageSpan r102) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r101, FilterData.FilterOptionItem.Type.RANGE);
        Intrinsics.checkNotNullParameter(r102, "image");
        this.f102047a = r100;
        this.f102048b = r101;
        this.f102049c = r102;
    }
}
