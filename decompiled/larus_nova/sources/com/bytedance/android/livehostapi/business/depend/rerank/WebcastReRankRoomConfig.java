package com.bytedance.android.livehostapi.business.depend.rerank;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/rerank/WebcastReRankRoomConfig;", "", "enable", "", "delegate", "Lcom/bytedance/android/livehostapi/business/depend/rerank/ILiveReRankCommonDelegate;", "(ZLcom/bytedance/android/livehostapi/business/depend/rerank/ILiveReRankCommonDelegate;)V", "getDelegate", "()Lcom/bytedance/android/livehostapi/business/depend/rerank/ILiveReRankCommonDelegate;", "getEnable", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WebcastReRankRoomConfig {
    private final ILiveReRankCommonDelegate delegate;
    private final boolean enable;

    public static /* synthetic */ WebcastReRankRoomConfig copy$default(WebcastReRankRoomConfig r100, boolean r101, ILiveReRankCommonDelegate r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.enable;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.delegate;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final ILiveReRankCommonDelegate component2() {
        return this.delegate;
    }

    public final WebcastReRankRoomConfig copy(boolean r100, ILiveReRankCommonDelegate r101) {
        return new WebcastReRankRoomConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof WebcastReRankRoomConfig) == false) goto L10;
        WebcastReRankRoomConfig r101 = (WebcastReRankRoomConfig) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.delegate, r101.delegate) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        ILiveReRankCommonDelegate r103 = this.delegate;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public String toString() {
        return "WebcastReRankRoomConfig(enable=" + this.enable + ", delegate=" + this.delegate + ")";
    }

    public final ILiveReRankCommonDelegate getDelegate() {
        return this.delegate;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public WebcastReRankRoomConfig(boolean r100, ILiveReRankCommonDelegate r101) {
        this.enable = r100;
        this.delegate = r101;
    }

    public /* synthetic */ WebcastReRankRoomConfig(boolean r100, ILiveReRankCommonDelegate r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
