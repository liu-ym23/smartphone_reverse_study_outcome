package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

/* renamed from: androidx.fragment.app.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0517l {
    private static int a(ComponentCallbacksC0511f componentCallbacksC0511f, boolean z5, boolean z6) {
        return z6 ? z5 ? componentCallbacksC0511f.M() : componentCallbacksC0511f.N() : z5 ? componentCallbacksC0511f.x() : componentCallbacksC0511f.A();
    }

    static a b(Context context, ComponentCallbacksC0511f componentCallbacksC0511f, boolean z5, boolean z6) throws Resources.NotFoundException {
        int I5 = componentCallbacksC0511f.I();
        int iA = a(componentCallbacksC0511f, z5, z6);
        componentCallbacksC0511f.F1(0, 0, 0, 0);
        ViewGroup viewGroup = componentCallbacksC0511f.f10612H;
        if (viewGroup != null) {
            int i5 = S.b.f5200c;
            if (viewGroup.getTag(i5) != null) {
                componentCallbacksC0511f.f10612H.setTag(i5, null);
            }
        }
        ViewGroup viewGroup2 = componentCallbacksC0511f.f10612H;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation animationW0 = componentCallbacksC0511f.w0(I5, z5, iA);
        if (animationW0 != null) {
            return new a(animationW0);
        }
        Animator animatorX0 = componentCallbacksC0511f.x0(I5, z5, iA);
        if (animatorX0 != null) {
            return new a(animatorX0);
        }
        if (iA == 0 && I5 != 0) {
            iA = d(context, I5, z5);
        }
        if (iA != 0) {
            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(iA));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, iA);
                    if (animationLoadAnimation != null) {
                        return new a(animationLoadAnimation);
                    }
                } catch (Resources.NotFoundException e6) {
                    throw e6;
                } catch (RuntimeException unused) {
                }
            } else {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, iA);
                    if (animatorLoadAnimator != null) {
                        return new a(animatorLoadAnimator);
                    }
                } catch (RuntimeException e7) {
                    if (zEquals) {
                        throw e7;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, iA);
                    if (animationLoadAnimation2 != null) {
                        return new a(animationLoadAnimation2);
                    }
                }
            }
        }
        return null;
    }

    private static int c(Context context, int i5) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i5});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int d(Context context, int i5, boolean z5) {
        if (i5 == 4097) {
            return z5 ? S.a.f5196e : S.a.f5197f;
        }
        if (i5 == 8194) {
            return z5 ? S.a.f5192a : S.a.f5193b;
        }
        if (i5 == 8197) {
            return z5 ? c(context, R.attr.activityCloseEnterAnimation) : c(context, R.attr.activityCloseExitAnimation);
        }
        if (i5 == 4099) {
            return z5 ? S.a.f5194c : S.a.f5195d;
        }
        if (i5 != 4100) {
            return -1;
        }
        return z5 ? c(context, R.attr.activityOpenEnterAnimation) : c(context, R.attr.activityOpenExitAnimation);
    }

    /* renamed from: androidx.fragment.app.l$a */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Animation f10699a;

        /* renamed from: b, reason: collision with root package name */
        public final Animator f10700b;

        a(Animation animation) {
            this.f10699a = animation;
            this.f10700b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        a(Animator animator) {
            this.f10699a = null;
            this.f10700b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* renamed from: androidx.fragment.app.l$b */
    static class b extends AnimationSet implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final ViewGroup f10701a;

        /* renamed from: b, reason: collision with root package name */
        private final View f10702b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f10703c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f10704d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f10705e;

        b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f10705e = true;
            this.f10701a = viewGroup;
            this.f10702b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j5, Transformation transformation) {
            this.f10705e = true;
            if (this.f10703c) {
                return !this.f10704d;
            }
            if (!super.getTransformation(j5, transformation)) {
                this.f10703c = true;
                androidx.core.view.A.a(this.f10701a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f10703c || !this.f10705e) {
                this.f10701a.endViewTransition(this.f10702b);
                this.f10704d = true;
            } else {
                this.f10705e = false;
                this.f10701a.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j5, Transformation transformation, float f5) {
            this.f10705e = true;
            if (this.f10703c) {
                return !this.f10704d;
            }
            if (!super.getTransformation(j5, transformation, f5)) {
                this.f10703c = true;
                androidx.core.view.A.a(this.f10701a, this);
            }
            return true;
        }
    }
}
