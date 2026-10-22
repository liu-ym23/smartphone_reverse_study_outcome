package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public interface Animatable2Compat extends Animatable {

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Animatable2.AnimationCallback f2877a;

        public void a(Drawable r1) {
        }

        public void b(Drawable r1) {
        }

        public a() {
        }

        Animatable2.AnimationCallback a() {
            if (this.f2877a != null) goto L6;
            this.f2877a = new Animatable2Compat$AnimationCallback$1(this);
        L6:
            return this.f2877a;
        }
    }

    void clearAnimationCallbacks();

    void registerAnimationCallback(a r1);

    boolean unregisterAnimationCallback(a r1);
}
