package com.bytedance.android.live.liveinteract.review;

import android.content.Context;
import com.bytedance.android.live.base.model.message.a3;
import com.bytedance.android.live.base.model.message.j2;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import kotlin.Metadata;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: classes46.dex */
public final class LinkmicReviewPresenter extends n<IView> implements l {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/review/LinkmicReviewPresenter$IView;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/IWidget;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface IView extends IWidget {
        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
        /* synthetic */ Context getContext();
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.n, q46.b
    public final void detachView() {
        super.detachView();
        d r100 = this.f107665d;
        if (r100 == null) goto L6;
        r100.removeMessageListener(this);
        return;
    }

    public LinkmicReviewPresenter() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.n
    public final /* bridge */ /* synthetic */ void c0(IWidget r100) {
        g0((IView) r100);
    }

    public final void g0(IView r100) {
        super.c0(r100);
        d r101 = this.f107665d;
        if (r101 == null) goto L6;
        r101.addMessageListener(MessageType.LINK_MIC_REVIEW.getKey(), this);
        return;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof j2) == false) goto L10;
        j2 r101 = (j2) r100;
        long r102 = r101.getMsgType();
        j2.Companion.getClass();
        if (r102 != 1) goto L11;
        a3 r103 = r101.getNormalPaidDescContent();
        if (r103 == null) goto L12;
        f2.c(r103.getToast(), 0);
        return;
    L12:
        return;
    L11:
        return;
    }
}
