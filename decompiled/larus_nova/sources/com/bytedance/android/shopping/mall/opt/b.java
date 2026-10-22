package com.bytedance.android.shopping.mall.opt;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/mall/opt/b;", "", "", "count", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "", "dispersed", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "", "dispersedInterval", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "offset", "d", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("count")
    private final Integer count;

    @SerializedName("dispersed")
    private final Boolean dispersed;

    @SerializedName("dispersed_interval")
    private final Long dispersedInterval;

    @SerializedName("offset")
    private final Integer offset;

    public b() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.count, r101.count) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.dispersed, r101.dispersed) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.dispersedInterval, r101.dispersedInterval) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.offset, r101.offset) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.count;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.dispersed;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.dispersedInterval;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.offset;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "ECMallFeedPreBindOnLoadMoreSuccessPageConfig(count=" + this.count + ", dispersed=" + this.dispersed + ", dispersedInterval=" + this.dispersedInterval + ", offset=" + this.offset + ")";
    }

    public final Integer a() {
        return this.count;
    }

    public final Boolean b() {
        return this.dispersed;
    }

    public final Long c() {
        return this.dispersedInterval;
    }

    public final Integer d() {
        return this.offset;
    }

    public b(Integer r100, Boolean r101, Long r102, Integer r103) {
        this.count = r100;
        this.dispersed = r101;
        this.dispersedInterval = r102;
        this.offset = r103;
    }
}
