package com.bytedance.android.live.ai.api.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/ai/api/model/RechargeFeatureData;", "", "balance", "", "dealList", "", "(JLjava/util/List;)V", "getBalance", "()J", "setBalance", "(J)V", "getDealList", "()Ljava/util/List;", "setDealList", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeFeatureData {
    private long balance;
    private List<Long> dealList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RechargeFeatureData copy$default(RechargeFeatureData r100, long r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.balance;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.dealList;
    L9:
        return r100.copy(r101, r102);
    }

    public final long component1() {
        return this.balance;
    }

    public final List<Long> component2() {
        return this.dealList;
    }

    public final RechargeFeatureData copy(long r100, List<Long> r101) {
        Intrinsics.checkNotNullParameter(r101, "dealList");
        return new RechargeFeatureData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RechargeFeatureData) == false) goto L10;
        RechargeFeatureData r101 = (RechargeFeatureData) r100;
        if (this.balance == r101.balance) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.dealList, r101.dealList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        long r100 = this.balance;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        List<Long> r102 = this.dealList;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return r101 + r103;
    L5:
        r103 = 0;
        goto L7
    }

    public String toString() {
        return "RechargeFeatureData(balance=" + this.balance + ", dealList=" + this.dealList + ")";
    }

    public final long getBalance() {
        return this.balance;
    }

    public final List<Long> getDealList() {
        return this.dealList;
    }

    public final void setBalance(long r100) {
        this.balance = r100;
    }

    public final void setDealList(List<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.dealList = r100;
    }

    public RechargeFeatureData(long r100, List<Long> r101) {
        Intrinsics.checkNotNullParameter(r101, "dealList");
        this.balance = r100;
        this.dealList = r101;
    }
}
