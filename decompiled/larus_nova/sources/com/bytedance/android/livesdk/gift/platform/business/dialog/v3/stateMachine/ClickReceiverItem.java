package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/ClickReceiverItem;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/GiftUIAction;", "position", "", SocialConstants.PARAM_RECEIVER, "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "(ILcom/bytedance/android/live/base/model/user/IBaseUser;)V", "getPosition", "()I", "getReceiver", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClickReceiverItem extends GiftUIAction {
    private final int position;
    private final IBaseUser receiver;

    public final int getPosition() {
        return this.position;
    }

    public final IBaseUser getReceiver() {
        return this.receiver;
    }

    public ClickReceiverItem(int r100, IBaseUser r101) {
        super(false, "ClickReceiverItem", 1, null);
        this.position = r100;
        this.receiver = r101;
    }
}
