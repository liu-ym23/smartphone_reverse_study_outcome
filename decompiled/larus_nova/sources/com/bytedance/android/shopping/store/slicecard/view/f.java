package com.bytedance.android.shopping.store.slicecard.view;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<h> f186378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f186379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<h> f186380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f186381d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L14;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f186378a, r101.f186378a) == true) goto L8;
        return false;
    L8:
        if (Float.compare(this.f186379b, r101.f186379b) == 0) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f186380c, r101.f186380c) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.f186381d, r101.f186381d) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        List<h> r100 = this.f186378a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + Float.floatToIntBits(this.f186379b)) * 31;
        List<h> r104 = this.f186380c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + Float.floatToIntBits(this.f186381d);
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ResolvedTrustFloatBar(segments=" + this.f186378a + ", totalWidthPx=" + this.f186379b + ", trailingSegments=" + this.f186380c + ", trailingWidthPx=" + this.f186381d + ")";
    }

    public /* synthetic */ f(List r100, float r101) {
        this(r100, r101, CollectionsKt.emptyList(), 0.0f);
    }

    public static f a(f r100, List r101, float r102) {
        List<h> r103 = r100.f186378a;
        float r104 = r100.f186379b;
        Intrinsics.checkNotNullParameter(r103, DBDefinition.SEGMENT_TABLE_NAME);
        Intrinsics.checkNotNullParameter(r101, "trailingSegments");
        return new f(r103, r104, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(List<? extends h> r100, float r101, List<? extends h> r102, float r103) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.SEGMENT_TABLE_NAME);
        Intrinsics.checkNotNullParameter(r102, "trailingSegments");
        this.f186378a = r100;
        this.f186379b = r101;
        this.f186380c = r102;
        this.f186381d = r103;
    }
}
