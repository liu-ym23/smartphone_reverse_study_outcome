package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.FrequentChatShowMode;

/* JADX INFO: loaded from: classes9.dex */
public final class c0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrequentCommentSectionProvider.FrequentChatController f135785a;

    public c0(FrequentCommentSectionProvider.FrequentChatController r100) {
        this.f135785a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        FrequentCommentSectionProvider.FrequentChatController.g(this.f135785a, FrequentChatShowMode.SORT);
    }
}
