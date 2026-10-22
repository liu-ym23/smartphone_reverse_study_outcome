package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.q4;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdkapi.shopping.LiveShoppingMessageHelper;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/CommerceAnchorServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lvlc/l;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommerceAnchorServiceWidget extends RoomRecyclableWidget implements vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vlc.d f114891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public js2.a f114892b;

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        vlc.d r100 = this.f114891a;
        if (r100 == null) goto L6;
        r100.removeMessageListener(this);
        return;
    }

    public CommerceAnchorServiceWidget() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        this.f114892b = new js2.a(this.dataCenter);
        vlc.d r101 = (vlc.d) this.dataCenter.get("data_message_manager", null);
        this.f114891a = r101;
        if (r101 == null) goto L6;
        r101.addMessageListener(1002, this);
        return;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.getIntType();
        if (1001 <= r101) goto L8;
        return;
    L8:
        if (2000 < r101) goto L18;
        Integer r102 = LiveShoppingMessageHelper.INSTANCE.getMessageType(r100);
        if (r102 == null) goto L19;
        int r103 = r102.intValue();
        js2.a r104 = this.f114892b;
        if (r104 == null) goto L15;
        r104.a(r103);
    L15:
        if (r103 != 10) goto L20;
        com.bytedance.android.livesdk.business.douplus.h.g(true, this.dataCenter);
        int r105 = q4.f117346e;
        q4.a.b(this.dataCenter);
        return;
    L20:
        return;
    L19:
        return;
    }
}
