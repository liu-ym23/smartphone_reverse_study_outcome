package com.bytedance.android.livesdk.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.Property;
import android.view.View;
import com.bytedance.android.livesdk.utils.animate.frame.FrameAnimatorSet;
import com.bytedance.android.livesdk.utils.animate.frame.ValueFrameAnimator;
import com.facebook.keyframes.model.KFAnimation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class AnAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Animator f158728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<Animator> f158729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<? extends View> f158730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f158731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f158732e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f158733f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f158734g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TimeInterpolator f158735h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f158736i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f158737j;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f158738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function2 f158739b;

        public a(View r100, Function2 r101) {
            this.f158738a = r100;
            this.f158739b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "anim");
            Function2 r101 = this.f158739b;
            View r102 = this.f158738a;
            Object r103 = r100.getAnimatedValue();
            if (r103 == null) goto L7;
            r101.invoke(r102, (Integer) r103);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2 f158740a;

        public b(Function2 r100) {
            this.f158740a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "anim");
            Function2 r101 = this.f158740a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.invoke(null, (Integer) r102);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f158741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Property f158742b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function1 f158743c;

        public c(View r100, Property r101, Function1 r102) {
            this.f158741a = r100;
            this.f158742b = r101;
            this.f158743c = r102;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            Property r101 = this.f158742b;
            View r102 = this.f158741a;
            Object r103 = r100.getAnimatedValue();
            if (r103 == null) goto L7;
            r101.set(r102, (Float) r103);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f158744a;

        public d(Function1 r100) {
            this.f158744a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            this.f158744a.invoke(r100.getAnimatedValue());
        }
    }

    public AnAnimator(boolean r100) {
        this.f158737j = r100;
        if (r100 == false) goto L5;
        Animator r101 = new FrameAnimatorSet();
    L6:
        this.f158728a = r101;
        this.f158729b = new ArrayList();
        this.f158730c = new ArrayList();
        this.f158732e = 300;
        return;
    L5:
        r101 = new AnimatorSet();
        goto L6
    }

    public final void i(List<? extends View> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f158730c = r100;
    }

    public static void a(AnAnimator r100, float[] r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "values");
        r100.e(View.ALPHA, Arrays.copyOf(r101, r101.length), null);
    }

    public static void f(AnAnimator r100, float[] r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "values");
        r100.g(Arrays.copyOf(r101, r101.length), null);
        r100.h(Arrays.copyOf(r101, r101.length), null);
    }

    public static void j(AnAnimator r100, float[] r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "values");
        r100.e(View.TRANSLATION_X, Arrays.copyOf(r101, r101.length), null);
    }

    public final void d(Path r100, final Function3<? super View, ? super Float, ? super Float, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "onUpdate");
        final PathMeasure r102 = new PathMeasure(r100, false);
        b(this, new float[]{0.0f, r102.getLength()}, new AnAnimator$path$1(r102, r101));
    }

    public final void g(float[] r100, Function1<Object, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "values");
        e(View.SCALE_X, Arrays.copyOf(r100, r100.length), r101);
    }

    public final void h(float[] r100, Function1<Object, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "values");
        e(View.SCALE_Y, Arrays.copyOf(r100, r100.length), r101);
    }

    public final void k(float[] r100, Function1<Object, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "values");
        e(View.TRANSLATION_Y, Arrays.copyOf(r100, r100.length), r101);
    }

    public final void l(float[] r100, final Function1<? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "values");
        b(this, Arrays.copyOf(r100, r100.length), new AnAnimator$width$1(r101));
    }

    public static void b(AnAnimator r100, float[] r101, Function2 r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "values");
        Intrinsics.checkNotNullParameter(r102, "onUpdate");
        if (r100.f158737j == false) goto L5;
        int r103 = ValueFrameAnimator.f158837q;
        ValueFrameAnimator r104 = ValueFrameAnimator.Companion.a(Arrays.copyOf(r101, r101.length));
        Intrinsics.checkNotNullParameter("FloatFrameAnimator", "<set-?>");
        r104.f158840c = "FloatFrameAnimator";
        ValueAnimator r105 = r104;
    L7:
        if (r100.f158730c.isEmpty() == false) goto L9;
        r105.addUpdateListener(new h(r102));
        r100.f158729b.add(r105);
        return;
    L9:
        Iterator<T> r106 = r100.f158730c.iterator();
    L11:
        if (r106.hasNext() == false) goto L15;
        r105.addUpdateListener(new g((View) r106.next(), r102));
        r100.f158729b.add(r105);
        goto L11
    L15:
        return;
    L5:
        r105 = ValueAnimator.ofFloat(Arrays.copyOf(r101, r101.length));
        goto L7
    }

    public final void c(int[] r100, TypeEvaluator<?> r101, Function2<? super View, ? super Integer, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "values");
        Intrinsics.checkNotNullParameter(r102, "onUpdate");
        if (this.f158737j == false) goto L5;
        int r103 = ValueFrameAnimator.f158837q;
        ValueFrameAnimator r104 = ValueFrameAnimator.Companion.b(Arrays.copyOf(r100, r100.length));
        Intrinsics.checkNotNullParameter("IntFrameAnimator", "<set-?>");
        r104.f158840c = "IntFrameAnimator";
        ValueAnimator r105 = r104;
    L7:
        if (this.f158730c.isEmpty() == false) goto L12;
        r105.addUpdateListener(new b(r102));
        if (r101 == null) goto L11;
        r105.setEvaluator(r101);
    L11:
        this.f158729b.add(r105);
        return;
    L12:
        Iterator<T> r106 = this.f158730c.iterator();
    L14:
        if (r106.hasNext() == false) goto L23;
        r105.addUpdateListener(new a((View) r106.next(), r102));
        if (r101 == null) goto L18;
        r105.setEvaluator(r101);
    L18:
        this.f158729b.add(r105);
        goto L14
    L23:
        return;
    L5:
        r105 = ValueAnimator.ofInt(Arrays.copyOf(r100, r100.length));
        goto L7
    }

    public final void e(Property<View, Float> r100, float[] r101, Function1<Object, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, "values");
        Iterator<T> r103 = this.f158730c.iterator();
    L4:
        if (r103.hasNext() == false) goto L13;
        View r104 = (View) r103.next();
        if (this.f158737j == false) goto L8;
        int r105 = ValueFrameAnimator.f158837q;
        ValueFrameAnimator r106 = ValueFrameAnimator.Companion.a(Arrays.copyOf(r101, r101.length));
        r106.addUpdateListener(new c(r104, r100, r102));
        Intrinsics.checkNotNullParameter("PropertyFrameAnimator", "<set-?>");
        r106.f158840c = "PropertyFrameAnimator";
        ValueAnimator r107 = r106;
    L9:
        r107.setRepeatCount(this.f158731d);
        if (r102 == null) goto L12;
        r107.addUpdateListener(new d(r102));
    L12:
        this.f158729b.add(r107);
        goto L4
    L8:
        r107 = ObjectAnimator.ofFloat(r104, r100, Arrays.copyOf(r101, r101.length));
        goto L9
    }
}
