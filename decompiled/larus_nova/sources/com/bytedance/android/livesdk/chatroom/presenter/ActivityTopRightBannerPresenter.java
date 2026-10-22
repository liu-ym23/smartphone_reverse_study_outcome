package com.bytedance.android.livesdk.chatroom.presenter;

import android.content.Context;
import com.bytedance.android.live.base.model.message.h1;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: classes7.dex */
public final class ActivityTopRightBannerPresenter extends n<IView> implements vlc.l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IRoom f107615e;

    public interface IView extends IWidget {
        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
        /* synthetic */ Context getContext();

        void m5(h1 r100);
    }

    public ActivityTopRightBannerPresenter(IRoom r100) {
        this.f107615e = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.n
    public final /* bridge */ /* synthetic */ void c0(IWidget r100) {
        g0((IView) r100);
    }

    public final void g0(IView r100) {
        super.c0(r100);
        vlc.d r101 = this.f107665d;
        if (r101 == null) goto L6;
        r101.addMessageListener(MessageType.IN_ROOM_BANNER_MESSAGE.getWsMethod(), this);
        return;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (this.f531633a != 0) goto L6;
        return;
    L6:
        if ((r100 instanceof h1) == false) goto L11;
        h1 r101 = (h1) r100;
        if (r101.getPosition() != 5) goto L12;
        ((IView) this.f531633a).m5(r101);
        return;
    L12:
        return;
    }
}
