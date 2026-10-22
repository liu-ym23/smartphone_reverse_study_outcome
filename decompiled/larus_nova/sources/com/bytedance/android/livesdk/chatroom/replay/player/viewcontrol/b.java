package com.bytedance.android.livesdk.chatroom.replay.player.viewcontrol;

import com.bytedance.android.livesdk.chatroom.progress.context.PlayerTipsContext;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayerTipsContext f109873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReplayPlayerBackgroundWidget f109874b;

    public b(PlayerTipsContext r100, ReplayPlayerBackgroundWidget r101) {
        this.f109873a = r100;
        this.f109874b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        ReplayPlayerBackgroundWidget.wq(this.f109874b, this.f109873a.getPlayerTipShowing());
    }
}
