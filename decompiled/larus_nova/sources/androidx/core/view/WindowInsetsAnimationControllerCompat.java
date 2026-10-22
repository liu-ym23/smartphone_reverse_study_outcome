package androidx.core.view;

import android.view.WindowInsetsAnimationController;
import androidx.core.graphics.Insets;

/* JADX INFO: loaded from: classes17.dex */
public final class WindowInsetsAnimationControllerCompat {
    private final Impl mImpl;

    public static class Impl {
        public void finish(boolean r100) {
        }

        public float getCurrentAlpha() {
            return 0.0f;
        }

        public float getCurrentFraction() {
            return 0.0f;
        }

        public int getTypes() {
            return 0;
        }

        public boolean isCancelled() {
            return true;
        }

        public boolean isFinished() {
            return false;
        }

        public void setInsetsAndAlpha(Insets r100, float r101, float r102) {
        }

        public Impl() {
        }

        public Insets getCurrentInsets() {
            return Insets.NONE;
        }

        public Insets getHiddenStateInsets() {
            return Insets.NONE;
        }

        public Insets getShownStateInsets() {
            return Insets.NONE;
        }
    }

    public static class Impl30 extends Impl {
        private final WindowInsetsAnimationController mController;

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public float getCurrentAlpha() {
            return this.mController.getCurrentAlpha();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public float getCurrentFraction() {
            return this.mController.getCurrentFraction();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public Insets getCurrentInsets() {
            return Insets.toCompatInsets(this.mController.getCurrentInsets());
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public Insets getHiddenStateInsets() {
            return Insets.toCompatInsets(this.mController.getHiddenStateInsets());
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public Insets getShownStateInsets() {
            return Insets.toCompatInsets(this.mController.getShownStateInsets());
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public int getTypes() {
            return this.mController.getTypes();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public boolean isCancelled() {
            return this.mController.isCancelled();
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public boolean isFinished() {
            return this.mController.isFinished();
        }

        public Impl30(WindowInsetsAnimationController r100) {
            this.mController = r100;
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public void finish(boolean r100) {
            this.mController.finish(r100);
        }

        @Override // androidx.core.view.WindowInsetsAnimationControllerCompat.Impl
        public void setInsetsAndAlpha(Insets r100, float r101, float r102) {
            WindowInsetsAnimationController r103 = this.mController;
            if (r100 != null) goto L5;
            android.graphics.Insets r104 = null;
        L6:
            r103.setInsetsAndAlpha(r104, r101, r102);
            return;
        L5:
            r104 = r100.toPlatformInsets();
            goto L6
        }
    }

    public float getCurrentAlpha() {
        return this.mImpl.getCurrentAlpha();
    }

    public float getCurrentFraction() {
        return this.mImpl.getCurrentFraction();
    }

    public Insets getCurrentInsets() {
        return this.mImpl.getCurrentInsets();
    }

    public Insets getHiddenStateInsets() {
        return this.mImpl.getHiddenStateInsets();
    }

    public Insets getShownStateInsets() {
        return this.mImpl.getShownStateInsets();
    }

    public int getTypes() {
        return this.mImpl.getTypes();
    }

    public boolean isCancelled() {
        return this.mImpl.isCancelled();
    }

    public boolean isFinished() {
        return this.mImpl.isFinished();
    }

    public boolean isReady() {
        if (isFinished() == false) goto L5;
    L7:
        return false;
    L5:
        if (isCancelled() == true) goto L7;
        return true;
    }

    public WindowInsetsAnimationControllerCompat(WindowInsetsAnimationController r100) {
        this.mImpl = new Impl30(r100);
    }

    public void finish(boolean r100) {
        this.mImpl.finish(r100);
    }

    public void setInsetsAndAlpha(Insets r100, float r101, float r102) {
        this.mImpl.setInsetsAndAlpha(r100, r101, r102);
    }
}
