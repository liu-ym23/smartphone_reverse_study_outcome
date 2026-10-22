package q1;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public Animatable2.AnimationCallback f38505a;

    public class a extends Animatable2.AnimationCallback {
        public a() {
        }

        @Override // android.graphics.drawable.Animatable2.AnimationCallback
        public void onAnimationEnd(Drawable drawable) {
            b.this.b(drawable);
        }

        @Override // android.graphics.drawable.Animatable2.AnimationCallback
        public void onAnimationStart(Drawable drawable) {
            b.this.c(drawable);
        }
    }

    public Animatable2.AnimationCallback a() {
        if (this.f38505a == null) {
            this.f38505a = new a();
        }
        return this.f38505a;
    }

    public void b(Drawable drawable) {
    }

    public void c(Drawable drawable) {
    }
}
