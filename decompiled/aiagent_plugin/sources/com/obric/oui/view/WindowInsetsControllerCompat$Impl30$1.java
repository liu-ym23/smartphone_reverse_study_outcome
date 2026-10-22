package com.obric.oui.view;

import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class WindowInsetsControllerCompat$Impl30$1 implements WindowInsetsAnimationControlListener {
    private f mCompatAnimController;
    final /* synthetic */ h.b this$0;
    final /* synthetic */ e val$listener;

    WindowInsetsControllerCompat$Impl30$1(h.b r3, e r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.aiagent.plugin");
        this.this$0 = r3;
        this.val$listener = r5;
        this.mCompatAnimController = null;
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onReady(WindowInsetsAnimationController r3, int r4) {
        f r0 = new f((WindowInsetsAnimationController) ZeusTransformUtils.wrapperContextForParams(r3, WindowInsetsAnimationController.class, "com.obric.aiagent.plugin"));
        this.mCompatAnimController = r0;
        this.val$listener.a(r0, r4);
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onFinished(WindowInsetsAnimationController r3) {
        WindowInsetsAnimationController r4 = (WindowInsetsAnimationController) ZeusTransformUtils.wrapperContextForParams(r3, WindowInsetsAnimationController.class, "com.obric.aiagent.plugin");
        this.val$listener.a(this.mCompatAnimController);
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onCancelled(WindowInsetsAnimationController r3) {
        WindowInsetsAnimationController r4 = (WindowInsetsAnimationController) ZeusTransformUtils.wrapperContextForParams(r3, WindowInsetsAnimationController.class, "com.obric.aiagent.plugin");
        e r0 = this.val$listener;
        if (r4 != null) goto L5;
        f r2 = null;
    L6:
        r0.b(r2);
        return;
    L5:
        r2 = this.mCompatAnimController;
        goto L6
    }
}
