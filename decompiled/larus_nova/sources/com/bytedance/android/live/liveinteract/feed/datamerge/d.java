package com.bytedance.android.live.liveinteract.feed.datamerge;

import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.service.MessageHub;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d extends a implements vlc.l {
    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void attach() {
        k r100 = this.f72943a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L5:
        MessageHub r101 = r100.getMessageHub();
        if (r101 == null) goto L9;
        r101.addMessageListener(MessageType.LINK_MIC.getIntType(), this);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void detach() {
        k r100 = this.f72943a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("proxy");
    L5:
        MessageHub r101 = r100.getMessageHub();
        if (r101 == null) goto L9;
        r101.removeMessageListener(MessageType.LINK_MIC.getIntType(), this);
        return;
    }

    public d() {
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof z0) == false) goto L17;
        z0 r101 = (z0) r100;
        if (((int) r101.getType2()) != 17) goto L18;
        boolean r102 = d0.e(r101.getPlayModes());
        ch0.a r103 = c().e();
        List r104 = CollectionsKt.toMutableList(r103.f23715c);
        if (r102 == false) goto L13;
        if (r104.contains(4) == true) goto L15;
        r104.add(4);
    L15:
        ch0.a r105 = ch0.a.a(r103, 0, 0, r104, 3);
        c().l(r105);
        return;
    L13:
        if (r104.contains(4) == false) goto L15;
        r104.remove(4);
        goto L15
    L18:
        return;
    }
}
