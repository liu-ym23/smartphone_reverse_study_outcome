package com.obric.oui.view;

import android.view.WindowInsetsController;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
class WindowInsetsControllerCompat$Impl30$2 implements WindowInsetsController.OnControllableInsetsChangedListener {
    final /* synthetic */ h.b this$0;
    final /* synthetic */ h.c val$listener;

    WindowInsetsControllerCompat$Impl30$2(h.b r3, h.c r4) {
        h.c r5 = (h.c) ZeusTransformUtils.wrapperContextForParams(r4, h.c.class, "com.obric.aiagent.plugin");
        this.this$0 = r3;
        this.val$listener = r5;
    }

    @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
    public void onControllableInsetsChanged(WindowInsetsController r3, int r4) {
        WindowInsetsController r5 = (WindowInsetsController) ZeusTransformUtils.wrapperContextForParams(r3, WindowInsetsController.class, "com.obric.aiagent.plugin");
        if (this.this$0.f36850b != r5) goto L6;
        this.val$listener.a(this.this$0.f36849a, r4);
        return;
    }
}
