package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes9.dex */
public final class i implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatChannelInviteButtonWidget f134607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Observer f134608b;

    public i(ChatChannelInviteButtonWidget r100, k r101) {
        this.f134607a = r100;
        this.f134608b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        DataCenter r100 = this.f134607a.dataCenter;
        if (r100 == null) goto L6;
        r100.removeObserver(this.f134608b);
        return;
    }
}
