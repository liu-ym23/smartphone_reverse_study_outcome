package com.bytedance.android.gamecp.business.comment;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentReplyListView f52216a;

    public f(CommentReplyListView r100) {
        this.f52216a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CommentReplyListView.c(this.f52216a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
