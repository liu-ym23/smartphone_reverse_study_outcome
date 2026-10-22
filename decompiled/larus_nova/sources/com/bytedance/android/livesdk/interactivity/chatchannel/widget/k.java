package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.view.View;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes9.dex */
public final class k<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatChannelInviteButtonWidget f134692a;

    public k(ChatChannelInviteButtonWidget r100) {
        this.f134692a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        ChatChannelInviteButtonWidget r102 = this.f134692a;
        View r103 = r102.contentView;
        int r104 = ChatChannelInviteButtonWidget.f134534c;
        r102.yq(r103);
    }
}
