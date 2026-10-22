package androidx.core.view;

import android.R;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes17.dex */
public final class SoftwareKeyboardControllerCompat {
    private final Impl mImpl;

    public static class Impl {
        public void hide() {
        }

        public void show() {
        }

        public Impl() {
        }
    }

    public static class Impl20 extends Impl {
        private final View mView;

        public static /* synthetic */ void a(View r100) {
            lambda$show$0(r100);
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        public void hide() {
            View r100 = this.mView;
            if (r100 == null) goto L6;
            ((InputMethodManager) r100.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
            return;
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        public void show() {
            final View r100 = this.mView;
            if (r100 != null) goto L6;
            return;
        L6:
            if (r100.isInEditMode() == false) goto L8;
        L11:
            r100.requestFocus();
        L12:
            if (r100 != null) goto L14;
            r100 = this.mView.getRootView().findViewById(R.id.content);
        L14:
            if (r100 != null) goto L16;
            return;
        L16:
            if (r100.hasWindowFocus() == false) goto L20;
            r100.post(new h(r100));
            return;
        L20:
            return;
        L8:
            if (r100.onCheckIsTextEditor() == true) goto L11;
            r100 = r100.getRootView().findFocus();
            goto L12
        }

        public Impl20(View r100) {
            this.mView = r100;
        }

        private static /* synthetic */ void lambda$show$0(View r100) {
            ((InputMethodManager) r100.getContext().getSystemService("input_method")).showSoftInput(r100, 0);
        }
    }

    public static class Impl30 extends Impl20 {
        private View mView;
        private WindowInsetsController mWindowInsetsController;

        public static /* synthetic */ void b(AtomicBoolean r100, WindowInsetsController r101, int r102) {
            lambda$hide$0(r100, r101, r102);
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl20, androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        public void hide() {
            WindowInsetsController r100 = this.mWindowInsetsController;
            if (r100 != null) goto L9;
            View r101 = this.mView;
            if (r101 == null) goto L8;
            r100 = r101.getWindowInsetsController();
            goto L9
        L8:
            r100 = null;
        L9:
            if (r100 == null) goto L16;
            final AtomicBoolean r102 = new AtomicBoolean(false);
            WindowInsetsController.OnControllableInsetsChangedListener r103 = new i(r102);
            r100.addOnControllableInsetsChangedListener(r103);
            if (r102.get() == true) goto L15;
            View r104 = this.mView;
            if (r104 == null) goto L15;
            ((InputMethodManager) r104.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
        L15:
            r100.removeOnControllableInsetsChangedListener(r103);
            r100.hide(WindowInsets.Type.ime());
            return;
        L16:
            super.hide();
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl20, androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        public void show() {
            View r100 = this.mView;
            if (r100 != null) goto L5;
        L7:
            WindowInsetsController r101 = this.mWindowInsetsController;
            if (r101 != null) goto L14;
            View r102 = this.mView;
            if (r102 == null) goto L13;
            r101 = r102.getWindowInsetsController();
            goto L14
        L13:
            r101 = null;
        L14:
            if (r101 == null) goto L16;
            r101.show(WindowInsets.Type.ime());
        L16:
            super.show();
            return;
        L5:
            if (Build.VERSION.SDK_INT >= 33) goto L7;
            ((InputMethodManager) r100.getContext().getSystemService("input_method")).isActive();
            goto L7
        }

        public Impl30(WindowInsetsController r100) {
            super(null);
            this.mWindowInsetsController = r100;
        }

        public Impl30(View r100) {
            super(r100);
            this.mView = r100;
        }

        private static /* synthetic */ void lambda$hide$0(AtomicBoolean r100, WindowInsetsController r101, int r102) {
            if ((r102 & 8) == 0) goto L5;
            boolean r103 = true;
        L6:
            r100.set(r103);
            return;
        L5:
            r103 = false;
            goto L6
        }
    }

    public void hide() {
        this.mImpl.hide();
    }

    public void show() {
        this.mImpl.show();
    }

    public SoftwareKeyboardControllerCompat(View r100) {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        this.mImpl = new Impl30(r100);
        return;
    L5:
        this.mImpl = new Impl20(r100);
    }

    public SoftwareKeyboardControllerCompat(WindowInsetsController r100) {
        this.mImpl = new Impl30(r100);
    }
}
