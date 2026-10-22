package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter;

import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DanmuPanelBasePresenter f109129a;

    public a(DanmuPanelBasePresenter r100) {
        this.f109129a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        DanmuPanelBasePresenter r102 = this.f109129a;
        DataCenter r103 = r102.f510285b;
        if (r103 == null) goto L6;
        r103.removeObserver(r102);
        return;
    }
}
