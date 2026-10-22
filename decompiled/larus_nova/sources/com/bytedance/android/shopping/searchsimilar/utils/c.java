package com.bytedance.android.shopping.searchsimilar.utils;

import com.bytedance.android.shopping.searchsimilar.view.SearchSimilarAuthorizationDialog;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchSimilarAuthorizationDialog f182496a;

    public c(SearchSimilarAuthorizationDialog r100) {
        this.f182496a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SearchSimilarAuthorizationDialog r100 = this.f182496a;     // Catch: Throwable -> L9
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(r100);     // Catch: Throwable -> L9
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14 Throwable -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);     // Catch: Throwable -> L9
        r100.show();     // Catch: Throwable -> L9
        DialogLancet.afterDialogShow(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    }
}
