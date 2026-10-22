package com.obric.oui.view;

import android.R;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import android.view.inputmethod.InputMethodManager;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: loaded from: classes4.dex */
public final class WindowInsetsControllerCompat {
    public static final int BEHAVIOR_SHOW_BARS_BY_SWIPE = 1;
    public static final int BEHAVIOR_SHOW_BARS_BY_TOUCH = 0;
    public static final int BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE = 2;
    private final Impl mImpl;

    private static class Impl {
        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r1) {
        }

        void controlWindowInsetsAnimation(int r1, long r2, Interpolator r4, CancellationSignal r5, WindowInsetsAnimationControlListenerCompat r6) {
        }

        int getSystemBarsBehavior() {
            return 0;
        }

        void hide(int r1) {
        }

        public boolean isAppearanceLightNavigationBars() {
            return false;
        }

        public boolean isAppearanceLightStatusBars() {
            return false;
        }

        void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r1) {
        }

        public void setAppearanceLightNavigationBars(boolean r1) {
        }

        public void setAppearanceLightStatusBars(boolean r1) {
        }

        void setSystemBarsBehavior(int r1) {
        }

        void show(int r1) {
        }

        Impl() {
        }
    }

    private static class Impl20 extends Impl {
        private final View mView;
        protected final Window mWindow;

        @Override // com.obric.oui.view.WindowInsetsControllerCompat.Impl
        void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r1) {
        }

        @Override // com.obric.oui.view.WindowInsetsControllerCompat.Impl
        void controlWindowInsetsAnimation(int r1, long r2, Interpolator r4, CancellationSignal r5, WindowInsetsAnimationControlListenerCompat r6) {
        }

        @Override // com.obric.oui.view.WindowInsetsControllerCompat.Impl
        int getSystemBarsBehavior() {
            return 0;
        }

        @Override // com.obric.oui.view.WindowInsetsControllerCompat.Impl
        void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r1) {
        }

        Impl20(Window r1, View r2) {
            this.mWindow = r1;
            this.mView = r2;
        }

        @Override // com.obric.oui.view.WindowInsetsControllerCompat.Impl
        void show(int r3) {
            int r0 = 1;
        L4:
            if (r0 > 256) goto L10;
            if ((r3 & r0) == 0) goto L9;
            showForType(r0);
        L9:
            r0 = r0 << 1;
            goto L4
        }

        private void showForType(int r2) {
            if (r2 != 1) goto L5;
            unsetSystemUiFlag(4);
            unsetWindowFlag(1024);
            return;
        L5:
            if (r2 != 2) goto L7;
            unsetSystemUiFlag(2);
            return;
        L7:
            if (r2 != 8) goto L30;
            final View r3 = this.mView;
            if (r3 != null) goto L12;
        L16:
            r3 = this.mWindow.getCurrentFocus();
        L17:
            if (r3 != null) goto L19;
            r3 = this.mWindow.findViewById(R.id.content);
        L19:
            if (r3 != null) goto L21;
            return;
        L21:
            if (r3.hasWindowFocus() == false) goto L29;
            r3.post(new AnonymousClass1(this, r3));
            return;
        L29:
            return;
        L12:
            if (r3.isInEditMode() == false) goto L14;
        L15:
            r3.requestFocus();
            goto L17
        L14:
            if (r3.onCheckIsTextEditor() == false) goto L16;
        }

        @Override // com.obric.oui.view.WindowInsetsControllerCompat.Impl
        void hide(int r3) {
            int r0 = 1;
        L4:
            if (r0 > 256) goto L10;
            if ((r3 & r0) == 0) goto L9;
            hideForType(r0);
        L9:
            r0 = r0 << 1;
            goto L4
        }

        private void hideForType(int r2) {
            if (r2 != 1) goto L5;
            setSystemUiFlag(4);
            return;
        L5:
            if (r2 != 2) goto L7;
            setSystemUiFlag(2);
            return;
        L7:
            if (r2 != 8) goto L15;
            ((InputMethodManager) this.mWindow.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mWindow.getDecorView().getWindowToken(), 0);
            return;
        }

        protected void setSystemUiFlag(int r2) {
            View r1 = this.mWindow.getDecorView();
            r1.setSystemUiVisibility(r2 | r1.getSystemUiVisibility());
        }

        protected void unsetSystemUiFlag(int r2) {
            View r1 = this.mWindow.getDecorView();
            int r0 = r1.getSystemUiVisibility();
            r1.setSystemUiVisibility((~r2) & r0);
        }

        protected void setWindowFlag(int r1) {
            this.mWindow.addFlags(r1);
        }

        protected void unsetWindowFlag(int r1) {
            this.mWindow.clearFlags(r1);
        }

        @Override // com.obric.oui.view.WindowInsetsControllerCompat.Impl
        void setSystemBarsBehavior(int r4) {
            if (r4 != 0) goto L4;
            unsetSystemUiFlag(6144);
            return;
        L4:
            if (r4 != 1) goto L6;
            unsetSystemUiFlag(4096);
            setSystemUiFlag(2048);
            return;
        L6:
            if (r4 != 2) goto L14;
            unsetSystemUiFlag(2048);
            setSystemUiFlag(4096);
            return;
        }
    }

    private static class Impl23 extends Impl20 {
        Impl23(Window r1, View r2) {
            super(r1, r2);
        }

        @Override // com.obric.oui.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            if ((this.mWindow.getDecorView().getSystemUiVisibility() & 8192) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.oui.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean r2) {
            if (r2 == false) goto L5;
            unsetWindowFlag(67108864);
            setWindowFlag(Integer.MIN_VALUE);
            setSystemUiFlag(8192);
            return;
        L5:
            unsetSystemUiFlag(8192);
        }
    }

    private static class Impl26 extends Impl23 {
        Impl26(Window r1, View r2) {
            super(r1, r2);
        }

        @Override // com.obric.oui.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            if ((this.mWindow.getDecorView().getSystemUiVisibility() & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.oui.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean r2) {
            if (r2 == false) goto L5;
            unsetWindowFlag(134217728);
            setWindowFlag(Integer.MIN_VALUE);
            setSystemUiFlag(16);
            return;
        L5:
            unsetSystemUiFlag(16);
        }
    }

    private static class Impl30 extends Impl {
        final WindowInsetsControllerCompat mCompatController;
        final WindowInsetsController mInsetsController;
        private final SimpleArrayMap<OnControllableInsetsChangedListener, WindowInsetsController.OnControllableInsetsChangedListener> mListeners;

        Impl30(Window r1, WindowInsetsControllerCompat r2) {
            this(r1.getInsetsController(), r2);
        }

        Impl30(WindowInsetsController r2, WindowInsetsControllerCompat r3) {
            this.mListeners = new SimpleArrayMap();
            this.mInsetsController = r2;
            this.mCompatController = r3;
        }

        @Override // com.obric.oui.view.WindowInsetsControllerCompat.Impl
        void show(int r1) {
            this.mInsetsController.show(r1);
        }

        @Override // com.obric.oui.view.WindowInsetsControllerCompat.Impl
        void hide(int r1) {
            this.mInsetsController.hide(r1);
        }

        @Override // com.obric.oui.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            if ((this.mInsetsController.getSystemBarsAppearance() & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.oui.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean r2) {
            if (r2 == false) goto L5;
            this.mInsetsController.setSystemBarsAppearance(8, 8);
            return;
        L5:
            this.mInsetsController.setSystemBarsAppearance(0, 8);
        }

        @Override // com.obric.oui.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            if ((this.mInsetsController.getSystemBarsAppearance() & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.oui.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean r2) {
            if (r2 == false) goto L5;
            this.mInsetsController.setSystemBarsAppearance(16, 16);
            return;
        L5:
            this.mInsetsController.setSystemBarsAppearance(0, 16);
        }

        @Override // com.obric.oui.view.WindowInsetsControllerCompat.Impl
        void controlWindowInsetsAnimation(int r8, long r9, Interpolator r11, CancellationSignal r12, final WindowInsetsAnimationControlListenerCompat r13) {
            WindowInsetsAnimationControlListener r6 = new AnonymousClass1(this, r13);
            this.mInsetsController.controlWindowInsetsAnimation(r8, r9, r11, r12, r6);
        }

        @Override // com.obric.oui.view.WindowInsetsControllerCompat.Impl
        void setSystemBarsBehavior(int r1) {
            this.mInsetsController.setSystemBarsBehavior(r1);
        }

        @Override // com.obric.oui.view.WindowInsetsControllerCompat.Impl
        int getSystemBarsBehavior() {
            return this.mInsetsController.getSystemBarsBehavior();
        }

        @Override // com.obric.oui.view.WindowInsetsControllerCompat.Impl
        void addOnControllableInsetsChangedListener(final OnControllableInsetsChangedListener r3) {
            if (this.mListeners.containsKey(r3) == false) goto L5;
            return;
        L5:
            WindowInsetsController.OnControllableInsetsChangedListener r0 = new AnonymousClass2(this, r3);
            this.mListeners.put(r3, r0);
            this.mInsetsController.addOnControllableInsetsChangedListener(r0);
        }

        @Override // com.obric.oui.view.WindowInsetsControllerCompat.Impl
        void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r2) {
            WindowInsetsController.OnControllableInsetsChangedListener r3 = this.mListeners.remove(r2);
            if (r3 == null) goto L6;
            this.mInsetsController.removeOnControllableInsetsChangedListener(r3);
            return;
        }
    }

    public interface OnControllableInsetsChangedListener {
        void onControllableInsetsChanged(WindowInsetsControllerCompat r1, int r2);
    }

    private WindowInsetsControllerCompat(WindowInsetsController r2) {
        this.mImpl = new Impl30(r2, this);
    }

    public WindowInsetsControllerCompat(Window r1, View r2) {
        this.mImpl = new Impl30(r1, this);
    }

    public static WindowInsetsControllerCompat toWindowInsetsControllerCompat(WindowInsetsController r1) {
        return new WindowInsetsControllerCompat(r1);
    }

    public void show(int r1) {
        this.mImpl.show(r1);
    }

    public void hide(int r1) {
        this.mImpl.hide(r1);
    }

    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.isAppearanceLightStatusBars();
    }

    public void setAppearanceLightStatusBars(boolean r1) {
        this.mImpl.setAppearanceLightStatusBars(r1);
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.isAppearanceLightNavigationBars();
    }

    public void setAppearanceLightNavigationBars(boolean r1) {
        this.mImpl.setAppearanceLightNavigationBars(r1);
    }

    public void controlWindowInsetsAnimation(int r8, long r9, Interpolator r11, CancellationSignal r12, WindowInsetsAnimationControlListenerCompat r13) {
        this.mImpl.controlWindowInsetsAnimation(r8, r9, r11, r12, r13);
    }

    public void setSystemBarsBehavior(int r1) {
        this.mImpl.setSystemBarsBehavior(r1);
    }

    public int getSystemBarsBehavior() {
        return this.mImpl.getSystemBarsBehavior();
    }

    public void addOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r1) {
        this.mImpl.addOnControllableInsetsChangedListener(r1);
    }

    public void removeOnControllableInsetsChangedListener(OnControllableInsetsChangedListener r1) {
        this.mImpl.removeOnControllableInsetsChangedListener(r1);
    }
}
