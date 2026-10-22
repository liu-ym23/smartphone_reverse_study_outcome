package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes17.dex */
public interface Animatable2Compat extends Animatable {

    public static abstract class AnimationCallback {
        Animatable2.AnimationCallback mPlatformCallback;

        public AnimationCallback() {
        }

        public void onAnimationEnd(Drawable r100) {
        }

        public void onAnimationStart(Drawable r100) {
        }

        public Animatable2.AnimationCallback getPlatformCallback() {
            if (this.mPlatformCallback != null) goto L6;
            this.mPlatformCallback = new AnonymousClass1(this);
        L6:
            return this.mPlatformCallback;
        }
    }

    void clearAnimationCallbacks();

    void registerAnimationCallback(AnimationCallback r100);

    boolean unregisterAnimationCallback(AnimationCallback r100);
}
