package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/IncrementalUpdatePanelGiftList;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftRepoAction;", "receiverType", "Lcom/bytedance/android/livesdk/gift/platform/core/model/ReceiverType;", "pageType", "", "topicId", "", "(Lcom/bytedance/android/livesdk/gift/platform/core/model/ReceiverType;IJ)V", "getPageType", "()I", "getReceiverType", "()Lcom/bytedance/android/livesdk/gift/platform/core/model/ReceiverType;", "getTopicId", "()J", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IncrementalUpdatePanelGiftList extends GiftRepoAction {
    private final int pageType;
    private final ReceiverType receiverType;
    private final long topicId;

    public final int getPageType() {
        return this.pageType;
    }

    public final ReceiverType getReceiverType() {
        return this.receiverType;
    }

    public final long getTopicId() {
        return this.topicId;
    }

    public IncrementalUpdatePanelGiftList(ReceiverType r100, int r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "receiverType");
        super("IncrementalUpdatePanelGiftList");
        this.receiverType = r100;
        this.pageType = r101;
        this.topicId = r102;
    }

    public /* synthetic */ IncrementalUpdatePanelGiftList(ReceiverType r100, int r101, long r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = -1;
    L5:
        this(r100, r101, r102);
    }
}
