package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import com.bytedance.android.live.base.model.user.UserEvent;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DrawerHistoryItemViewHolder f123981a;

    public q(DrawerHistoryItemViewHolder r100) {
        this.f123981a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((UserEvent) r100).isLogin() == false) goto L6;
        DrawerHistoryItemViewHolder r101 = this.f123981a;
        int r102 = DrawerHistoryItemViewHolder.f123872n;
        r101.V3();
        return;
    }
}
