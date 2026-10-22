package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatChannelInviteButtonWidget f134691a;

    public j(ChatChannelInviteButtonWidget r100) {
        this.f134691a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.livesdk.interactivity.api.base.d r101 = (com.bytedance.android.livesdk.interactivity.api.base.d) r100;
        ChatChannelInviteButtonWidget r102 = this.f134691a;
        View r103 = r102.contentView;
        int r104 = ChatChannelInviteButtonWidget.f134534c;
        r102.yq(r103);
    }
}
