package com.bytedance.android.livesdkapi.roomplayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/LiveMetricsBuilder;", "", "()V", "enterFromMerge", "Lcom/bytedance/android/livesdkapi/roomplayer/EnterFromMerge;", "enterMethod", "Lcom/bytedance/android/livesdkapi/roomplayer/EnterMethod;", "build", "Lcom/bytedance/android/livesdkapi/roomplayer/LiveMetricsParams;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMetricsBuilder {
    private EnterFromMerge enterFromMerge;
    private EnterMethod enterMethod;

    public final LiveMetricsParams build() {
        return new LiveMetricsParams(this.enterFromMerge, this.enterMethod);
    }

    public LiveMetricsBuilder() {
        this.enterFromMerge = EnterFromMerge.HOMEPAGE_HOT;
        this.enterMethod = EnterMethod.LIVE_CELL;
    }

    public final LiveMetricsBuilder enterFromMerge(EnterFromMerge r100) {
        Intrinsics.checkNotNullParameter(r100, "enterFromMerge");
        this.enterFromMerge = r100;
        return this;
    }

    public final LiveMetricsBuilder enterMethod(EnterMethod r100) {
        Intrinsics.checkNotNullParameter(r100, "enterMethod");
        this.enterMethod = r100;
        return this;
    }
}
