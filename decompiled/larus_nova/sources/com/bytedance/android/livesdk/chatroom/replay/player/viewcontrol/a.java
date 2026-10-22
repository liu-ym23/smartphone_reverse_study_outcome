package com.bytedance.android.livesdk.chatroom.replay.player.viewcontrol;

import com.bytedance.android.livesdk.chatroom.progress.context.PlayerTipsContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayerTipsContext f109871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReplayPlayerBackgroundWidget f109872b;

    public a(PlayerTipsContext r100, ReplayPlayerBackgroundWidget r101) {
        this.f109871a = r100;
        this.f109872b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.livesdk.chatroom.progress.context.a r101 = (com.bytedance.android.livesdk.chatroom.progress.context.a) r100;
        ReplayPlayerBackgroundWidget.wq(this.f109872b, this.f109871a.getPlayerTipShowing());
    }
}
