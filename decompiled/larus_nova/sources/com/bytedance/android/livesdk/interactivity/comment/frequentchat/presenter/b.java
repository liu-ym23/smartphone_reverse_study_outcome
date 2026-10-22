package com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter;

import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrequentChatListAdapter f134907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c f134908b;

    public b(FrequentChatListAdapter r100, com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.c r101) {
        this.f134907a = r100;
        this.f134908b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if ((r100 instanceof TextView) == true) goto L5;
        r100 = null;
    L5:
        TextView r101 = (TextView) r100;
        if (r101 == null) goto L12;
        CharSequence r102 = r101.getText();
        if (r102 == null) goto L13;
        this.f134907a.f134888b.k(r102, this.f134908b);
        return;
    L13:
        return;
    }
}
