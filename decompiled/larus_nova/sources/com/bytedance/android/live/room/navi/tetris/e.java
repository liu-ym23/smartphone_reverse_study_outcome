package com.bytedance.android.live.room.navi.tetris;

import com.bytedance.android.livesdk.popup.manager.LivePopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorRoomNavigatorTetris f99769a;

    public e(AnchorRoomNavigatorTetris r100) {
        this.f99769a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        if (this.f99769a.W() == false) goto L8;
        LivePopupWindow r102 = this.f99769a.f99718w;
        if (r102 == null) goto L9;
        PopupWindowLancet.handleDismissBeforeOrigin(r102);
        r102.dismiss();
        return;
    L9:
        return;
    }
}
