package com.bytedance.android.gamecp.business.comment.edit;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentEditorFullscreenDialog f52125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f52126b;

    public h(CommentEditorFullscreenDialog r100, Function1 r101) {
        this.f52125a = r100;
        this.f52126b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f52126b.invoke(Integer.valueOf(CommentEditorFullscreenDialog.S90(this.f52125a).getWidth()));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
