package com.bytedance.android.livesdkapi.roomplayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/LiveMetricsParams;", "", "enterFromMerge", "Lcom/bytedance/android/livesdkapi/roomplayer/EnterFromMerge;", "enterMethod", "Lcom/bytedance/android/livesdkapi/roomplayer/EnterMethod;", "(Lcom/bytedance/android/livesdkapi/roomplayer/EnterFromMerge;Lcom/bytedance/android/livesdkapi/roomplayer/EnterMethod;)V", "getEnterFromMerge", "()Lcom/bytedance/android/livesdkapi/roomplayer/EnterFromMerge;", "getEnterMethod", "()Lcom/bytedance/android/livesdkapi/roomplayer/EnterMethod;", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMetricsParams {
    private final EnterFromMerge enterFromMerge;
    private final EnterMethod enterMethod;

    public final EnterFromMerge getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public final EnterMethod getEnterMethod() {
        return this.enterMethod;
    }

    public LiveMetricsParams(EnterFromMerge r100, EnterMethod r101) {
        Intrinsics.checkNotNullParameter(r100, "enterFromMerge");
        Intrinsics.checkNotNullParameter(r101, "enterMethod");
        this.enterFromMerge = r100;
        this.enterMethod = r101;
    }
}
