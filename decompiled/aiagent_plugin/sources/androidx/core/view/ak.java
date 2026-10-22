package androidx.core.view;

import android.view.WindowInsetsAnimationController;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: WindowInsetsAnimationControllerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f1454a;

    /* JADX INFO: compiled from: WindowInsetsAnimationControllerCompat.java */
    private static class a {
        a() {
        }
    }

    /* JADX INFO: compiled from: WindowInsetsAnimationControllerCompat.java */
    private static class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WindowInsetsAnimationController f1455a;

        b(WindowInsetsAnimationController r3) {
            this.f1455a = (WindowInsetsAnimationController) ZeusTransformUtils.wrapperContextForParams(r3, WindowInsetsAnimationController.class, "com.obric.aiagent.plugin");
        }
    }

    ak(WindowInsetsAnimationController r3) {
        this.f1454a = new b((WindowInsetsAnimationController) ZeusTransformUtils.wrapperContextForParams(r3, WindowInsetsAnimationController.class, "com.obric.aiagent.plugin"));
    }
}
