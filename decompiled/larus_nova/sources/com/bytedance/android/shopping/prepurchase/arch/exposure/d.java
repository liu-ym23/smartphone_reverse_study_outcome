package com.bytedance.android.shopping.prepurchase.arch.exposure;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f180889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f180890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<l> f180891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f180892d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L14;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f180889a, r101.f180889a) == true) goto L8;
        return false;
    L8:
        if (Float.compare(this.f180890b, r101.f180890b) == 0) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f180891c, r101.f180891c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f180892d, r101.f180892d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f180889a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + Float.floatToIntBits(this.f180890b)) * 31;
        List<l> r104 = this.f180891c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        g r107 = this.f180892d;
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
        return "ExposureItem(taskId=" + this.f180889a + ", percentage=" + this.f180890b + ", views=" + this.f180891c + ", reporter=" + this.f180892d + ")";
    }

    public d(String r100, float r101, List<l> r102, g r103) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "views");
        Intrinsics.checkNotNullParameter(r103, "reporter");
        this.f180889a = r100;
        this.f180890b = r101;
        this.f180891c = r102;
        this.f180892d = r103;
    }
}
