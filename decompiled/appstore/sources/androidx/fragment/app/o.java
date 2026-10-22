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
import androidx.fragment.R$animator;
import androidx.fragment.R$id;

/* JADX INFO: loaded from: classes.dex */
public abstract class o {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Animation f3369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Animator f3370b;

        public a(Animation r10) {
            this.f3369a = r10;
            this.f3370b = null;
            if (r10 == null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Animation cannot be null");
        }

        public a(Animator r10) {
            this.f3369a = null;
            this.f3370b = r10;
            if (r10 == null) goto L6;
            return;
        L6:
            throw new IllegalStateException("Animator cannot be null");
        }
    }

    public static class b extends AnimationSet implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewGroup f3371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f3372b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f3373c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f3374d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f3375e;

        public b(Animation r10, ViewGroup r11, View r12) {
            super(false);
            this.f3375e = true;
            this.f3371a = r11;
            this.f3372b = r12;
            addAnimation(r10);
            r11.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long r10, Transformation r11) {
            this.f3375e = true;
            if (this.f3373c == false) goto L7;
            return !this.f3374d;
        L7:
            if (super.getTransformation(r10, r11) == true) goto L9;
            this.f3373c = true;
            androidx.core.view.j.a(this.f3371a, this);
        L9:
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3373c == false) goto L5;
        L7:
            this.f3371a.endViewTransition(this.f3372b);
            this.f3374d = true;
            return;
        L5:
            if (this.f3375e == false) goto L7;
            this.f3375e = false;
            this.f3371a.post(this);
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long r10, Transformation r11, float r12) {
            this.f3375e = true;
            if (this.f3373c == false) goto L7;
            return !this.f3374d;
        L7:
            if (super.getTransformation(r10, r11, r12) == true) goto L9;
            this.f3373c = true;
            androidx.core.view.j.a(this.f3371a, this);
        L9:
            return true;
        }
    }

    public static int a(Fragment r10, boolean r11, boolean r12) {
        if (r12 == false) goto L8;
        if (r11 == false) goto L7;
        return r10.getPopEnterAnim();
    L7:
        return r10.getPopExitAnim();
    L8:
        if (r11 == false) goto L12;
        return r10.getEnterAnim();
    L12:
        return r10.getExitAnim();
    }

    public static a b(Context r10, Fragment r11, boolean r12, boolean r13) {
        int r14 = r11.getNextTransition();
        int r15 = a(r11, r12, r13);
        r11.setAnimations(0, 0, 0, 0);
        ViewGroup r16 = r11.mContainer;
        if (r16 == null) goto L7;
        int r17 = R$id.visible_removing_fragment_view_tag;
        if (r16.getTag(r17) == null) goto L7;
        r11.mContainer.setTag(r17, null);
    L7:
        ViewGroup r18 = r11.mContainer;
        if (r18 != null) goto L10;
    L12:
        Animation r19 = r11.onCreateAnimation(r14, r12, r15);
        if (r19 != null) goto L15;
        Animator r20 = r11.onCreateAnimator(r14, r12, r15);
        if (r20 != null) goto L19;
        if (r15 != 0) goto L23;
        if (r14 == 0) goto L23;
        r15 = d(r10, r14, r12);
    L23:
        if (r15 == 0) goto L43;
        boolean r21 = "anim".equals(r10.getResources().getResourceTypeName(r15));
        if (r21 == true) goto L47;
    L45:
        Animator r22 = AnimatorInflater.loadAnimator(r10, r15);     // Catch: RuntimeException -> L36
        if (r22 == null) goto L43;
        return new a(r22);
    L36:
        e = move-exception;
        if (r21 == true) goto L42;
        Animation r23 = AnimationUtils.loadAnimation(r10, r15);
        if (r23 == null) goto L43;
        return new a(r23);
    L42:
        throw e;
    L47:
        Animation r24 = AnimationUtils.loadAnimation(r10, r15);     // Catch: Resources.NotFoundException -> L30 RuntimeException -> L44
        if (r24 == null) goto L43;
        return new a(r24);
    L30:
        e = move-exception;
        throw e;
    L43:
        return null;
    L19:
        return new a(r20);
    L15:
        return new a(r19);
    L10:
        if (r18.getLayoutTransition() == null) goto L12;
        return null;
    }

    public static int c(Context r10, int r11) {
        TypedArray r12 = r10.obtainStyledAttributes(R.style.Animation.Activity, new int[]{r11});
        int r13 = r12.getResourceId(0, -1);
        r12.recycle();
        return r13;
    }

    public static int d(Context r10, int r11, boolean r12) {
        if (r11 != 4097) goto L5;
        if (r12 == false) goto L28;
        return R$animator.fragment_open_enter;
    L28:
        return R$animator.fragment_open_exit;
    L5:
        if (r11 != 8194) goto L7;
        if (r12 == false) goto L37;
        return R$animator.fragment_close_enter;
    L37:
        return R$animator.fragment_close_exit;
    L7:
        if (r11 != 8197) goto L9;
        if (r12 == false) goto L35;
        return c(r10, R.attr.activityCloseEnterAnimation);
    L35:
        return c(r10, R.attr.activityCloseExitAnimation);
    L9:
        if (r11 != 4099) goto L11;
        if (r12 == false) goto L33;
        return R$animator.fragment_fade_enter;
    L33:
        return R$animator.fragment_fade_exit;
    L11:
        if (r11 == 4100) goto L13;
        return -1;
    L13:
        if (r12 == false) goto L31;
        return c(r10, R.attr.activityOpenEnterAnimation);
    L31:
        return c(r10, R.attr.activityOpenExitAnimation);
    }
}
