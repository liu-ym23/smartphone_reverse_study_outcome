package androidx.fragment.app;

import android.animation.Animator;
import android.view.animation.Animation;

/* loaded from: classes.dex */
public final class H {

    /* renamed from: a, reason: collision with root package name */
    public final Animation f3617a;

    /* renamed from: b, reason: collision with root package name */
    public final Animator f3618b;

    public H(Animation animation) {
        this.f3617a = animation;
        this.f3618b = null;
    }

    public H(Animator animator) {
        this.f3617a = null;
        this.f3618b = animator;
    }
}
