package com.bytedance.android.live.liveinteract.hamlet.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/hamlet/model/l;", "", "", "x", "Ljava/lang/Double;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Double;", "y", "b", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class l {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private final Double f73513x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private final Double f73514y;

    public l() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L10;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f73513x, r101.f73513x) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f73514y, r101.f73514y) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Double r100 = this.f73513x;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Double r104 = this.f73514y;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "HamletCestPositionStruct(x=" + this.f73513x + ", y=" + this.f73514y + ")";
    }

    public final Double a() {
        return this.f73513x;
    }

    public final Double b() {
        return this.f73514y;
    }

    public l(Double r100, Double r101) {
        this.f73513x = r100;
        this.f73514y = r101;
    }
}
