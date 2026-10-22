package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class p {
    public static int a(int i10, Context context) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i10});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Animation f2171a;

        /* renamed from: b, reason: collision with root package name */
        public final Animator f2172b;

        public a(Animation animation) {
            this.f2171a = animation;
            this.f2172b = null;
        }

        public a(Animator animator) {
            this.f2171a = null;
            this.f2172b = animator;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b extends AnimationSet implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final ViewGroup f2173a;

        /* renamed from: b, reason: collision with root package name */
        public final View f2174b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f2175c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f2176d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f2177e;

        public b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f2177e = true;
            this.f2173a = viewGroup;
            this.f2174b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public final boolean getTransformation(long j10, Transformation transformation) {
            this.f2177e = true;
            if (this.f2175c) {
                return !this.f2176d;
            }
            if (!super.getTransformation(j10, transformation)) {
                this.f2175c = true;
                v0.u.a(this.f2173a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z = this.f2175c;
            ViewGroup viewGroup = this.f2173a;
            if (z || !this.f2177e) {
                viewGroup.endViewTransition(this.f2174b);
                this.f2176d = true;
            } else {
                this.f2177e = false;
                viewGroup.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public final boolean getTransformation(long j10, Transformation transformation, float f8) {
            this.f2177e = true;
            if (this.f2175c) {
                return !this.f2176d;
            }
            if (!super.getTransformation(j10, transformation, f8)) {
                this.f2175c = true;
                v0.u.a(this.f2173a, this);
            }
            return true;
        }
    }
}
