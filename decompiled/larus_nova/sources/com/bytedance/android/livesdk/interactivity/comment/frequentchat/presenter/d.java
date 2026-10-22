package com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter;

import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrequentChatListAdapter f134911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c f134912b;

    public d(FrequentChatListAdapter r100, com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r101) {
        this.f134911a = r100;
        this.f134912b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f134911a.f134888b.u(this.f134912b);
    }
}
