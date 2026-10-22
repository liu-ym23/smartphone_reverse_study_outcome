package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractEntrance;
import com.bytedance.android.livesdk.chatroom.model.d1;
import com.bytedance.android.livesdk.chatroom.model.j1;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class y<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f80261a;

    public y(s r100) {
        this.f80261a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        d1 r102 = (d1) r101.data;
        if (r102 == null) goto L9;
        List<ILinkmicInteractEntrance> r103 = r102.getEntranceList();
        if (r103 == null) goto L9;
        s.a r104 = (s.a) this.f80261a.f531633a;
        if (r104 == null) goto L9;
        r104.j9(r103);
    L9:
        d1 r105 = (d1) r101.data;
        if (r105 == null) goto L17;
        List<j1> r106 = r105.getEntrancePosList();
        if (r106 == null) goto L18;
        s.a r107 = (s.a) this.f80261a.f531633a;
        if (r107 == null) goto L19;
        r107.A2(r106);
        return;
    L19:
        return;
    L18:
        return;
    }
}
