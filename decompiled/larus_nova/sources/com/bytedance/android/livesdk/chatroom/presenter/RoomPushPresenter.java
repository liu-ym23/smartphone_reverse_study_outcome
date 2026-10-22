package com.bytedance.android.livesdk.chatroom.presenter;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.message.model.kk;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes7.dex */
public final class RoomPushPresenter extends n<IView> implements vlc.l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Queue<kk> f107635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f107636f;

    public interface IView extends IWidget {
        void eO(kk r100);

        boolean eS();

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
        /* synthetic */ Context getContext();
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.n, q46.b
    public final void detachView() {
        Queue<kk> r100 = this.f107635e;
        if (r100 == null) goto L5;
        ((ArrayDeque) r100).clear();
    L5:
        vlc.d r101 = this.f107665d;
        if (r101 == null) goto L8;
        r101.removeMessageListener(this);
    L8:
        super.detachView();
    }

    public final void h0() {
        T r100 = this.f531633a;
        if (r100 != 0) goto L5;
        return;
    L5:
        if (((IView) r100).eS() == true) goto L12;
        kk r101 = this.f107635e.poll();
        if (r101 != null) goto L9;
        return;
    L9:
        ((IView) this.f531633a).eO(r101);
        return;
    }

    public RoomPushPresenter() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.n
    public final /* bridge */ /* synthetic */ void c0(IWidget r100) {
        g0((IView) r100);
    }

    public final void g0(IView r100) {
        super.c0(r100);
        this.f107636f = ((Long) this.f107664c.get("data_room_id", 0L)).longValue();
        vlc.d r101 = this.f107665d;
        if (r101 == null) goto L6;
        r101.addMessageListener(MessageType.ROOM_PUSH.getIntType(), this);
        return;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof kk) == true) goto L5;
        return;
    L5:
        kk r101 = (kk) r100;
        if (r101.getBaseMessage() != null) goto L8;
        return;
    L8:
        if (r101.getBaseMessage().getRoomId() == this.f107636f) goto L11;
        return;
    L11:
        if (this.f107635e != null) goto L13;
        this.f107635e = new ArrayDeque();
    L13:
        this.f107635e.offer(r101);
        h0();
    }
}
