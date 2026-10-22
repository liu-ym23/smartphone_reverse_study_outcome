package com.bytedance.android.livesdk.chatroom.presenter;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.android.livesdk.message.model.w3;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.DecorationDetail;

/* JADX INFO: loaded from: classes7.dex */
public final class AudienceStickerPresenter extends StickerPresenter implements vlc.l {

    public interface IView extends StickerPresenter.IView {
        void OU(DecorationDetail r100);

        @Override // com.bytedance.android.livesdk.chatroom.presenter.StickerPresenter.IView, com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
        /* synthetic */ Context getContext();
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.StickerPresenter, q46.b
    public final q46.a b0() {
        return (IView) ((StickerPresenter.IView) this.f531633a);
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.StickerPresenter
    public final StickerPresenter.IView i0() {
        return (IView) ((StickerPresenter.IView) this.f531633a);
    }

    public AudienceStickerPresenter() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.StickerPresenter, com.bytedance.android.livesdk.chatroom.presenter.n
    public final /* bridge */ /* synthetic */ void c0(IWidget r100) {
        g0((StickerPresenter.IView) r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.StickerPresenter
    public final void g0(StickerPresenter.IView r100) {
        super.g0(r100);
        vlc.d r101 = this.f107665d;
        if (r101 == null) goto L6;
        r101.addMessageListener(MessageType.MODIFY_DECORATION.getIntType(), this);
        this.f107665d.addMessageListener(MessageType.MODIFY_DECORATION_V2.getIntType(), this);
        return;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (((o0) r100).getMessageType() != MessageType.MODIFY_DECORATION_V2) goto L9;
        T r101 = this.f531633a;
        if (((IView) ((StickerPresenter.IView) r101)) != null) goto L7;
        return;
    L7:
        ((IView) ((StickerPresenter.IView) r101)).OU(((w3) r100).E());
        return;
    }
}
