package com.bytedance.android.gamecp.business.comment.edit;

import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements gs.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentEditorFullscreenActivity f52119a;

    public b(CommentEditorFullscreenActivity r100) {
        this.f52119a = r100;
    }

    public static View c(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // gs.b
    public final void a(com.bytedance.android.gamecp.business.comment.edit.help.d r100) {
        c(this.f52119a.getWindow()).getViewTreeObserver().addOnGlobalLayoutListener(r100);
    }

    @Override // gs.b
    public final void b(com.bytedance.android.gamecp.business.comment.edit.help.d r100) {
        c(this.f52119a.getWindow()).getViewTreeObserver().removeOnGlobalLayoutListener(r100);
    }
}
