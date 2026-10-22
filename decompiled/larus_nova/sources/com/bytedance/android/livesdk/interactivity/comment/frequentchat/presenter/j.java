package com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter;

import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FrequentChatPresenter f134923a;

    public j(FrequentChatPresenter r100) {
        this.f134923a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        int r101 = com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.b.f134926a;
        com.bytedance.android.livesdk.interactivity.comment.frequentchat.util.b.a((Throwable) r100, "sort", s1.B(R.string.frequent_chat_sort_failed));
        this.f134923a.f134902k = false;
    }
}
