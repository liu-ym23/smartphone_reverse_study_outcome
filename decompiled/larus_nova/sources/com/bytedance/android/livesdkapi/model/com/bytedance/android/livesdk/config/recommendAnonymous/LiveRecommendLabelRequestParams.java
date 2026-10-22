package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.recommendAnonymous;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bHÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\fHÆ\u0003JM\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/recommendAnonymous/LiveRecommendLabelRequestParams;", "", "roomId", "", "requestTag", "", "recommendStatus", "onSuccess", "Lkotlin/Function1;", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/recommendAnonymous/LiveRecommendLabelResult;", "", "onFail", "Lkotlin/Function0;", "(JLjava/lang/String;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "getOnFail", "()Lkotlin/jvm/functions/Function0;", "getOnSuccess", "()Lkotlin/jvm/functions/Function1;", "getRecommendStatus", "()J", "getRequestTag", "()Ljava/lang/String;", "getRoomId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRecommendLabelRequestParams {
    private final Function0<Unit> onFail;
    private final Function1<LiveRecommendLabelResult, Unit> onSuccess;
    private final long recommendStatus;
    private final String requestTag;
    private final long roomId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveRecommendLabelRequestParams copy$default(LiveRecommendLabelRequestParams r100, long r101, String r110, long r111, Function1 r112, Function0 r113, int r114, Object r115) {
        if ((r114 & 1) == 0) goto L5;
        long r102 = r100.roomId;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = r100.requestTag;
    L11:
        if ((r114 & 4) == 0) goto L13;
        long r104 = r100.recommendStatus;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Function1 r105 = r100.onSuccess;
    L19:
        if ((r114 & 16) == 0) goto L21;
        Function0 r106 = r100.onFail;
    L23:
        return r100.copy(r102, r103, r104, r105, r106);
    L21:
        r106 = r113;
        goto L23
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }

    public final long component1() {
        return this.roomId;
    }

    public final String component2() {
        return this.requestTag;
    }

    public final long component3() {
        return this.recommendStatus;
    }

    public final Function1<LiveRecommendLabelResult, Unit> component4() {
        return this.onSuccess;
    }

    public final Function0<Unit> component5() {
        return this.onFail;
    }

    public final LiveRecommendLabelRequestParams copy(long r110, String r111, long r112, Function1<? super LiveRecommendLabelResult, Unit> r113, Function0<Unit> r114) {
        Intrinsics.checkNotNullParameter(r111, "requestTag");
        Intrinsics.checkNotNullParameter(r113, "onSuccess");
        Intrinsics.checkNotNullParameter(r114, "onFail");
        return new LiveRecommendLabelRequestParams(r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveRecommendLabelRequestParams) == false) goto L16;
        LiveRecommendLabelRequestParams r101 = (LiveRecommendLabelRequestParams) r100;
        if (this.roomId == r101.roomId) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.requestTag, r101.requestTag) == true) goto L10;
        return false;
    L10:
        if (this.recommendStatus == r101.recommendStatus) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.onSuccess, r101.onSuccess) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.onFail, r101.onFail) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        long r100 = this.roomId;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.requestTag;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        long r105 = this.recommendStatus;
        int r106 = (((r101 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        Function1<LiveRecommendLabelResult, Unit> r107 = this.onSuccess;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (r106 + r108) * 31;
        Function0<Unit> r110 = this.onFail;
        if (r110 == null) goto L14;
        r103 = r110.hashCode();
    L14:
        return r109 + r103;
    L9:
        r108 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public String toString() {
        return "LiveRecommendLabelRequestParams(roomId=" + this.roomId + ", requestTag=" + this.requestTag + ", recommendStatus=" + this.recommendStatus + ", onSuccess=" + this.onSuccess + ", onFail=" + this.onFail + ")";
    }

    public final Function0<Unit> getOnFail() {
        return this.onFail;
    }

    public final Function1<LiveRecommendLabelResult, Unit> getOnSuccess() {
        return this.onSuccess;
    }

    public final long getRecommendStatus() {
        return this.recommendStatus;
    }

    public final String getRequestTag() {
        return this.requestTag;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LiveRecommendLabelRequestParams(long r100, String r101, long r102, Function1<? super LiveRecommendLabelResult, Unit> r103, Function0<Unit> r104) {
        Intrinsics.checkNotNullParameter(r101, "requestTag");
        Intrinsics.checkNotNullParameter(r103, "onSuccess");
        Intrinsics.checkNotNullParameter(r104, "onFail");
        this.roomId = r100;
        this.requestTag = r101;
        this.recommendStatus = r102;
        this.onSuccess = r103;
        this.onFail = r104;
    }
}
