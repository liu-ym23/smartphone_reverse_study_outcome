package com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.FrequentChatViewHolder;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrequentChatListAdapter f134913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FrequentChatViewHolder f134914b;

    public e(FrequentChatListAdapter r100, FrequentChatViewHolder r101) {
        this.f134913a = r100;
        this.f134914b = r101;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        if (this.f134913a.getItemCount() > 1) goto L6;
        return false;
    L6:
        this.f134913a.f134888b.O(this.f134914b);
        return true;
    }
}
