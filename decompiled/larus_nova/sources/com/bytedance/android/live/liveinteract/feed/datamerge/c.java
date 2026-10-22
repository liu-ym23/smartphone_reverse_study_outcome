package com.bytedance.android.live.liveinteract.feed.datamerge;

import com.bytedance.android.live.base.model.message.ILinkmicEnlargeGuestMessage;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.service.MessageHub;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends a implements vlc.l {
    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void attach() {
        MessageHub r100 = c().getMessageHub();
        if (r100 == null) goto L6;
        r100.addMessageListener(MessageType.LINK_MIC_ENLARGE_GUEST_MESSAGE.getIntType(), this);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void detach() {
        MessageHub r100 = c().getMessageHub();
        if (r100 == null) goto L6;
        r100.removeMessageListener(MessageType.LINK_MIC_ENLARGE_GUEST_MESSAGE.getIntType(), this);
        return;
    }

    public c() {
    }

    public final void e(boolean r100) {
        wg0.a r101 = wg0.a.a(c().j(), r100, null, false, 6);
        c().c(r101);
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof ILinkmicEnlargeGuestMessage) == false) goto L14;
        int r101 = ((ILinkmicEnlargeGuestMessage) r100).getMsg_type();
        if (r101 != ILinkmicEnlargeGuestMessage.LinkmicEnlargeGuestMessageType.EnlargeGuestMessageType_TurnOn.ordinal()) goto L8;
        e(true);
        return;
    L8:
        if (r101 != ILinkmicEnlargeGuestMessage.LinkmicEnlargeGuestMessageType.EnlargeGuestMessageType_ChangeUser.ordinal()) goto L11;
        e(true);
        return;
    L11:
        if (r101 != ILinkmicEnlargeGuestMessage.LinkmicEnlargeGuestMessageType.EnlargeGuestMessageType_TurnOff.ordinal()) goto L17;
        e(false);
        return;
    L17:
        return;
    }
}
