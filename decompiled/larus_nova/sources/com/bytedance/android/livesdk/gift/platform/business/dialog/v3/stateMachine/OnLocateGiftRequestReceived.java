package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.chatroom.event.LocateGiftInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/OnLocateGiftRequestReceived;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "locateGiftInfo", "Lcom/bytedance/android/livesdk/chatroom/event/LocateGiftInfo;", "source", "", "(Lcom/bytedance/android/livesdk/chatroom/event/LocateGiftInfo;I)V", "getLocateGiftInfo", "()Lcom/bytedance/android/livesdk/chatroom/event/LocateGiftInfo;", "getSource", "()I", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OnLocateGiftRequestReceived extends GiftUIAction {
    private final LocateGiftInfo locateGiftInfo;
    private final int source;

    public final LocateGiftInfo getLocateGiftInfo() {
        return this.locateGiftInfo;
    }

    public final int getSource() {
        return this.source;
    }

    public OnLocateGiftRequestReceived(LocateGiftInfo r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "locateGiftInfo");
        super(false, "OnLocateGiftRequestReceived", 1, null);
        this.locateGiftInfo = r100;
        this.source = r101;
    }
}
