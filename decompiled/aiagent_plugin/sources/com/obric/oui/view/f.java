package com.obric.oui.view;

import android.os.Build;
import android.view.WindowInsetsAnimationController;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: WindowInsetsAnimationControllerCompat.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f36825a;

    /* JADX INFO: compiled from: WindowInsetsAnimationControllerCompat.java */
    private static class a {
        a() {
        }
    }

    /* JADX INFO: compiled from: WindowInsetsAnimationControllerCompat.java */
    private static class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WindowInsetsAnimationController f36826a;

        b(WindowInsetsAnimationController r3) {
            this.f36826a = (WindowInsetsAnimationController) ZeusTransformUtils.wrapperContextForParams(r3, WindowInsetsAnimationController.class, "com.obric.aiagent.plugin");
        }
    }

    f() {
        if (Build.VERSION.SDK_INT >= 30) goto L7;
        this.f36825a = new a();
        return;
    L7:
        throw new UnsupportedOperationException("On API 30+, the constructor taking a " + WindowInsetsAnimationController.class.getSimpleName() + " as parameter");
    }

    f(WindowInsetsAnimationController r3) {
        this.f36825a = new b((WindowInsetsAnimationController) ZeusTransformUtils.wrapperContextForParams(r3, WindowInsetsAnimationController.class, "com.obric.aiagent.plugin"));
    }
}
