package aa2;

import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ITextMessageView;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends com.bytedance.android.livesdk.chatroom.presenter.n<ITextMessageView> implements vlc.l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f2317e;

    @Override // com.bytedance.android.livesdk.chatroom.presenter.n, q46.b
    public final void detachView() {
        this.f107665d.removeMessageListener(this);
    }

    public b(boolean r100) {
        this.f2317e = r100;
    }

    public final void A(ITextMessageView r100) {
        super.c0(r100);
        if (this.f2317e == false) goto L6;
        this.f107665d.addMessageListener("WebcastOChannelAnchorMessage", this);
        this.f107665d.addMessageListener("WebcastOChannelModifyMessage", this);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.n
    public final /* bridge */ /* synthetic */ void c0(IWidget r100) {
        A((ITextMessageView) r100);
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        T r101 = this.f531633a;
        if (r101 != 0) goto L5;
        return;
    L5:
        ((ITextMessageView) r101).lU(r100);
    }
}
