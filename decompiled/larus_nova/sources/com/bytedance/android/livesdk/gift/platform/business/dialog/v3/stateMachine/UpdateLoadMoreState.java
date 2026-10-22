package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/UpdateLoadMoreState;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", "isLoading", "", "pageType", "", "topicId", "", "(ZILjava/lang/Long;)V", "()Z", "getPageType", "()I", "getTopicId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UpdateLoadMoreState extends GiftRepoAction {
    private final boolean isLoading;
    private final int pageType;
    private final Long topicId;

    public final int getPageType() {
        return this.pageType;
    }

    public final Long getTopicId() {
        return this.topicId;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public UpdateLoadMoreState(boolean r100, int r101, Long r102) {
        super("UpdateLoadMoreState");
        this.isLoading = r100;
        this.pageType = r101;
        this.topicId = r102;
    }

    public /* synthetic */ UpdateLoadMoreState(boolean r100, int r101, Long r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
