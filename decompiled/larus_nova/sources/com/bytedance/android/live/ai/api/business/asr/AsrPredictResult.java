package com.bytedance.android.live.ai.api.business.asr;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/ai/api/business/asr/AsrPredictResult;", "", "code", "", "message", "", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Lcom/bytedance/android/live/ai/api/business/asr/AsrResultStrategy;", "(ILjava/lang/String;Lcom/bytedance/android/live/ai/api/business/asr/AsrResultStrategy;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getStrategy", "()Lcom/bytedance/android/live/ai/api/business/asr/AsrResultStrategy;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "liveai-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AsrPredictResult {
    private final int code;
    private final String message;
    private final AsrResultStrategy strategy;

    public AsrPredictResult() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ AsrPredictResult copy$default(AsrPredictResult r100, int r101, String r102, AsrResultStrategy r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.code;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.message;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.strategy;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final AsrResultStrategy component3() {
        return this.strategy;
    }

    public final AsrPredictResult copy(int r100, String r101, AsrResultStrategy r102) {
        Intrinsics.checkNotNullParameter(r101, "message");
        return new AsrPredictResult(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AsrPredictResult) == false) goto L12;
        AsrPredictResult r101 = (AsrPredictResult) r100;
        if (this.code == r101.code) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.strategy, r101.strategy) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        int r100 = this.code * 31;
        String r101 = this.message;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        AsrResultStrategy r105 = this.strategy;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "AsrPredictResult(code=" + this.code + ", message=" + this.message + ", strategy=" + this.strategy + ")";
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final AsrResultStrategy getStrategy() {
        return this.strategy;
    }

    public AsrPredictResult(int r100, String r101, AsrResultStrategy r102) {
        Intrinsics.checkNotNullParameter(r101, "message");
        this.code = r100;
        this.message = r101;
        this.strategy = r102;
    }

    public /* synthetic */ AsrPredictResult(int r100, String r101, AsrResultStrategy r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
