package com.bytedance.android.ec.hybrid.list.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/o;", "", "", "adjustFling", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "boostFlingMaxThreshold", "b", "limitMaxFlingThreshold", "f", "limitMaxFling", "e", "", "boostFlingPercent", "Ljava/lang/Float;", "c", "()Ljava/lang/Float;", "limitFlingPercent", "d", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o {

    @SerializedName("adjust_fling")
    private final Integer adjustFling;

    @SerializedName("boost_fling_max_threshold")
    private final Integer boostFlingMaxThreshold;

    @SerializedName("boost_fling_percent")
    private final Float boostFlingPercent;

    @SerializedName("limit_fling_percent")
    private final Float limitFlingPercent;

    @SerializedName("lim_max_fling")
    private final Integer limitMaxFling;

    @SerializedName("limit_max_fling_threshold")
    private final Integer limitMaxFlingThreshold;

    public o() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L18;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.adjustFling, r101.adjustFling) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.boostFlingMaxThreshold, r101.boostFlingMaxThreshold) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.limitMaxFlingThreshold, r101.limitMaxFlingThreshold) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.limitMaxFling, r101.limitMaxFling) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.boostFlingPercent, r101.boostFlingPercent) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.limitFlingPercent, r101.limitFlingPercent) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.adjustFling;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.boostFlingMaxThreshold;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.limitMaxFlingThreshold;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.limitMaxFling;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Float r113 = this.boostFlingPercent;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Float r116 = this.limitFlingPercent;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MallFlingParams(adjustFling=" + this.adjustFling + ", boostFlingMaxThreshold=" + this.boostFlingMaxThreshold + ", limitMaxFlingThreshold=" + this.limitMaxFlingThreshold + ", limitMaxFling=" + this.limitMaxFling + ", boostFlingPercent=" + this.boostFlingPercent + ", limitFlingPercent=" + this.limitFlingPercent + ")";
    }

    public final Integer a() {
        return this.adjustFling;
    }

    public final Integer b() {
        return this.boostFlingMaxThreshold;
    }

    public final Float c() {
        return this.boostFlingPercent;
    }

    public final Float d() {
        return this.limitFlingPercent;
    }

    public final Integer e() {
        return this.limitMaxFling;
    }

    public final Integer f() {
        return this.limitMaxFlingThreshold;
    }

    public o(int r100) {
        this.adjustFling = 0;
        this.boostFlingMaxThreshold = null;
        this.limitMaxFlingThreshold = null;
        this.limitMaxFling = null;
        this.boostFlingPercent = null;
        this.limitFlingPercent = null;
    }
}
