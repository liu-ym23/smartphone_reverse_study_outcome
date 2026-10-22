package androidx.core.view;

import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class WindowInsetsControllerCompat$Impl30$1 implements WindowInsetsAnimationControlListener {
    private ak mCompatAnimController;
    final /* synthetic */ am.e this$0;
    final /* synthetic */ aj val$listener;

    WindowInsetsControllerCompat$Impl30$1(am.e r3, aj r4) {
        aj r5 = (aj) ZeusTransformUtils.wrapperContextForParams(r4, aj.class, "com.obric.aiagent.plugin");
        this.this$0 = r3;
        this.val$listener = r5;
        this.mCompatAnimController = null;
    }

    @Override // android.view.WindowInsetsAnimationControlListener
    public void onReady(WindowInsetsAnimationController r3, int r4) {
        ak r0 = new ak((WindowInsetsAnimationController) ZeusTransformUtils.wrapperContextForParams(r3, WindowInsetsAnimationController.class, "com.obric.aiagent.plugin"));
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
        aj r0 = this.val$listener;
        if (r4 != null) goto L5;
        ak r2 = null;
    L6:
        r0.b(r2);
        return;
    L5:
        r2 = this.mCompatAnimController;
        goto L6
    }
}
