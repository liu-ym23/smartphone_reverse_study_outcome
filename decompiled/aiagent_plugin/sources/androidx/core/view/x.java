package androidx.core.view;

import android.R;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SoftwareKeyboardControllerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f1524a;

    /* JADX INFO: compiled from: SoftwareKeyboardControllerCompat.java */
    private static class a {
        void a() {
        }

        void b() {
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: SoftwareKeyboardControllerCompat.java */
    private static class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f1525a;

        public static /* synthetic */ void lambda$IlOlFIFapHk9DycjpzmCadgyTUg(View r0) {
            a(r0);
        }

        b(View r1) {
            this.f1525a = r1;
        }

        @Override // androidx.core.view.x.a
        void a() {
            final View r0 = this.f1525a;
            if (r0 != null) goto L6;
            return;
        L6:
            if (r0.isInEditMode() == false) goto L8;
        L11:
            r0.requestFocus();
        L12:
            if (r0 != null) goto L14;
            r0 = this.f1525a.getRootView().findViewById(R.id.content);
        L14:
            if (r0 != null) goto L16;
            return;
        L16:
            if (r0.hasWindowFocus() == false) goto L20;
            r0.post(new $$Lambda$x$b$IlOlFIFapHk9DycjpzmCadgyTUg(r0));
            return;
        L20:
            return;
        L8:
            if (r0.onCheckIsTextEditor() == true) goto L11;
            r0 = r0.getRootView().findFocus();
            goto L12
        }

        private static /* synthetic */ void a(View r3) {
            ((InputMethodManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("input_method"), InputMethodManager.class, "com.obric.aiagent.plugin")).showSoftInput(r3, 0);
        }

        @Override // androidx.core.view.x.a
        void b() {
            View r0 = this.f1525a;
            if (r0 == null) goto L6;
            ((InputMethodManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("input_method"), InputMethodManager.class, "com.obric.aiagent.plugin")).hideSoftInputFromWindow(this.f1525a.getWindowToken(), 0);
            return;
        }
    }

    /* JADX INFO: compiled from: SoftwareKeyboardControllerCompat.java */
    private static class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private View f1526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WindowInsetsController f1527b;

        public static /* synthetic */ void lambda$hsroEoGw6pIibpFT0xKUP9tqgsQ(AtomicBoolean r0, WindowInsetsController r1, int r2) {
            a(r0, r1, r2);
        }

        c(View r1) {
            super(r1);
            this.f1526a = r1;
        }

        c(WindowInsetsController r3) {
            WindowInsetsController r4 = (WindowInsetsController) ZeusTransformUtils.wrapperContextForParams(r3, WindowInsetsController.class, "com.obric.aiagent.plugin");
            super(null);
            this.f1527b = r4;
        }

        @Override // androidx.core.view.x.b, androidx.core.view.x.a
        void a() {
            if (this.f1526a != null) goto L5;
        L7:
            WindowInsetsController r0 = null;
            WindowInsetsController r1 = this.f1527b;
            if (r1 == null) goto L10;
            r0 = r1;
        L13:
            if (r0 == null) goto L15;
            r0.show(WindowInsets.Type.ime());
            return;
        L15:
            super.a();
            return;
        L10:
            View r2 = this.f1526a;
            if (r2 == null) goto L13;
            r0 = r2.getWindowInsetsController();
            goto L13
        L5:
            if (Build.VERSION.SDK_INT >= 33) goto L7;
            ((InputMethodManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f1526a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("input_method"), InputMethodManager.class, "com.obric.aiagent.plugin")).isActive();
            goto L7
        }

        @Override // androidx.core.view.x.b, androidx.core.view.x.a
        void b() {
            WindowInsetsController r0 = this.f1527b;
            if (r0 != null) goto L9;
            View r1 = this.f1526a;
            if (r1 == null) goto L8;
            r0 = r1.getWindowInsetsController();
            goto L9
        L8:
            r0 = null;
        L9:
            if (r0 == null) goto L16;
            final AtomicBoolean r2 = new AtomicBoolean(false);
            WindowInsetsController.OnControllableInsetsChangedListener r3 = new $$Lambda$x$c$hsroEoGw6pIibpFT0xKUP9tqgsQ(r2);
            r0.addOnControllableInsetsChangedListener(r3);
            if (r2.get() == true) goto L15;
            View r4 = this.f1526a;
            if (r4 == null) goto L15;
            ((InputMethodManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("input_method"), InputMethodManager.class, "com.obric.aiagent.plugin")).hideSoftInputFromWindow(this.f1526a.getWindowToken(), 0);
        L15:
            r0.removeOnControllableInsetsChangedListener(r3);
            r0.hide(WindowInsets.Type.ime());
            return;
        L16:
            super.b();
        }

        private static /* synthetic */ void a(AtomicBoolean r2, WindowInsetsController r3, int r4) {
            WindowInsetsController r5 = (WindowInsetsController) ZeusTransformUtils.wrapperContextForParams(r3, WindowInsetsController.class, "com.obric.aiagent.plugin");
            if ((r4 & 8) == 0) goto L5;
            boolean r6 = true;
        L6:
            r2.set(r6);
            return;
        L5:
            r6 = false;
            goto L6
        }
    }

    public x(View r3) {
        if (Build.VERSION.SDK_INT < 30) goto L6;
        this.f1524a = new c(r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 20) goto L8;
        this.f1524a = new b(r3);
        return;
    L8:
        this.f1524a = new a();
    }

    @Deprecated
    x(WindowInsetsController r3) {
        this.f1524a = new c((WindowInsetsController) ZeusTransformUtils.wrapperContextForParams(r3, WindowInsetsController.class, "com.obric.aiagent.plugin"));
    }

    public void a() {
        this.f1524a.a();
    }

    public void b() {
        this.f1524a.b();
    }
}
