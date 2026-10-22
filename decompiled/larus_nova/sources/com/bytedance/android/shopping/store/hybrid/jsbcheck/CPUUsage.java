package com.bytedance.android.shopping.store.hybrid.jsbcheck;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/jsbcheck/CPUUsage;", "", "()V", "avg", "", "getAvg", "()Ljava/lang/Double;", "setAvg", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "detail", "", "getDetail", "()Ljava/util/List;", "median", "getMedian", "setMedian", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CPUUsage {
    private Double avg;
    private final List<Double> detail;
    private Double median;

    public CPUUsage() {
        this.detail = new ArrayList();
    }

    public final Double getAvg() {
        return this.avg;
    }

    public final List<Double> getDetail() {
        return this.detail;
    }

    public final Double getMedian() {
        return this.median;
    }

    public final void setAvg(Double r100) {
        this.avg = r100;
    }

    public final void setMedian(Double r100) {
        this.median = r100;
    }
}
