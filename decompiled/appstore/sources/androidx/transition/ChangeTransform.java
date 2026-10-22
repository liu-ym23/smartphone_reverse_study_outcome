package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ChangeTransform extends Transition {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f4944d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Property f4945e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Property f4946f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f4947g = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Matrix f4950c;

    public class a extends Property {
        public a(Class r10, String r11) {
            super(r10, r11);
        }

        public float[] a(e r10) {
            return null;
        }

        public void b(e r10, float[] r11) {
            r10.d(r11);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Object get(Object r10) {
            return a((e) r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(Object r10, Object r11) {
            b((e) r10, (float[]) r11);
        }
    }

    public class b extends Property {
        public b(Class r10, String r11) {
            super(r10, r11);
        }

        public PointF a(e r10) {
            return null;
        }

        public void b(e r10, PointF r11) {
            r10.c(r11);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Object get(Object r10) {
            return a((e) r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(Object r10, Object r11) {
            b((e) r10, (PointF) r11);
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Matrix f4952b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f4953c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Matrix f4954d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ View f4955e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ f f4956f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ e f4957g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ ChangeTransform f4958h;

        public c(ChangeTransform r10, boolean r11, Matrix r12, View r13, f r14, e r15) {
            this.f4958h = r10;
            this.f4953c = r11;
            this.f4954d = r12;
            this.f4955e = r13;
            this.f4956f = r14;
            this.f4957g = r15;
            this.f4952b = new Matrix();
        }

        public final void a(Matrix r10) {
            this.f4952b.set(r10);
            this.f4955e.setTag(R$id.transition_transform, this.f4952b);
            this.f4956f.a(this.f4955e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            this.f4951a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            if (this.f4951a == false) goto L5;
        L10:
            y.f(this.f4955e, null);
            this.f4956f.a(this.f4955e);
            return;
        L5:
            if (this.f4953c == true) goto L7;
        L9:
            this.f4955e.setTag(R$id.transition_transform, null);
            this.f4955e.setTag(R$id.parent_matrix, null);
            goto L10
        L7:
            if (this.f4958h.f4948a == false) goto L9;
            a(this.f4954d);
            goto L10
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator r10) {
            a(this.f4957g.a());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator r10) {
            ChangeTransform.v(this.f4955e);
        }
    }

    public static class d extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f4959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public GhostView f4960b;

        public d(View r10, GhostView r11) {
            this.f4959a = r10;
            this.f4960b = r11;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r10) {
            r10.removeListener(this);
            g.b(this.f4959a);
            this.f4959a.setTag(R$id.transition_transform, null);
            this.f4959a.setTag(R$id.parent_matrix, null);
        }

        @Override // androidx.transition.o, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition r10) {
            this.f4960b.setVisibility(4);
        }

        @Override // androidx.transition.o, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition r10) {
            this.f4960b.setVisibility(0);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f4961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f4962b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float[] f4963c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f4964d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f4965e;

        public e(View r10, float[] r11) {
            this.f4961a = new Matrix();
            this.f4962b = r10;
            float[] r12 = (float[]) r11.clone();
            this.f4963c = r12;
            this.f4964d = r12[2];
            this.f4965e = r12[5];
            b();
        }

        public Matrix a() {
            return this.f4961a;
        }

        public final void b() {
            float[] r10 = this.f4963c;
            r10[2] = this.f4964d;
            r10[5] = this.f4965e;
            this.f4961a.setValues(r10);
            y.f(this.f4962b, this.f4961a);
        }

        public void c(PointF r10) {
            this.f4964d = r10.x;
            this.f4965e = r10.y;
            b();
        }

        public void d(float[] r10) {
            System.arraycopy(r10, 0, this.f4963c, 0, r10.length);
            b();
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f4966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f4967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f4968c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f4969d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f4970e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f4971f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f4972g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f4973h;

        public f(View r10) {
            this.f4966a = r10.getTranslationX();
            this.f4967b = r10.getTranslationY();
            this.f4968c = ViewCompat.K(r10);
            this.f4969d = r10.getScaleX();
            this.f4970e = r10.getScaleY();
            this.f4971f = r10.getRotationX();
            this.f4972g = r10.getRotationY();
            this.f4973h = r10.getRotation();
        }

        public void a(View r10) {
            ChangeTransform.x(r10, this.f4966a, this.f4967b, this.f4968c, this.f4969d, this.f4970e, this.f4971f, this.f4972g, this.f4973h);
        }

        public boolean equals(Object r10) {
            if ((r10 instanceof f) == true) goto L5;
            return false;
        L5:
            f r11 = (f) r10;
            if (r11.f4966a == this.f4966a) goto L8;
            return false;
        L8:
            if (r11.f4967b == this.f4967b) goto L10;
            return false;
        L10:
            if (r11.f4968c == this.f4968c) goto L12;
            return false;
        L12:
            if (r11.f4969d == this.f4969d) goto L14;
            return false;
        L14:
            if (r11.f4970e == this.f4970e) goto L16;
            return false;
        L16:
            if (r11.f4971f == this.f4971f) goto L18;
            return false;
        L18:
            if (r11.f4972g == this.f4972g) goto L20;
            return false;
        L20:
            if (r11.f4973h != this.f4973h) goto L30;
            return true;
        L30:
            return false;
        }

        public int hashCode() {
            float r10 = this.f4966a;
            int r11 = 0;
            if (r10 == 0.0f) goto L5;
            int r12 = Float.floatToIntBits(r10);
        L6:
            int r13 = r12 * 31;
            float r14 = this.f4967b;
            if (r14 == 0.0f) goto L9;
            int r15 = Float.floatToIntBits(r14);
        L10:
            int r16 = (r13 + r15) * 31;
            float r17 = this.f4968c;
            if (r17 == 0.0f) goto L13;
            int r18 = Float.floatToIntBits(r17);
        L14:
            int r19 = (r16 + r18) * 31;
            float r20 = this.f4969d;
            if (r20 == 0.0f) goto L17;
            int r21 = Float.floatToIntBits(r20);
        L18:
            int r22 = (r19 + r21) * 31;
            float r23 = this.f4970e;
            if (r23 == 0.0f) goto L21;
            int r24 = Float.floatToIntBits(r23);
        L22:
            int r25 = (r22 + r24) * 31;
            float r26 = this.f4971f;
            if (r26 == 0.0f) goto L25;
            int r27 = Float.floatToIntBits(r26);
        L26:
            int r28 = (r25 + r27) * 31;
            float r29 = this.f4972g;
            if (r29 == 0.0f) goto L29;
            int r30 = Float.floatToIntBits(r29);
        L30:
            int r31 = (r28 + r30) * 31;
            float r32 = this.f4973h;
            if (r32 == 0.0f) goto L34;
            r11 = Float.floatToIntBits(r32);
        L34:
            return r31 + r11;
        L29:
            r30 = 0;
            goto L30
        L25:
            r27 = 0;
            goto L26
        L21:
            r24 = 0;
            goto L22
        L17:
            r21 = 0;
            goto L18
        L13:
            r18 = 0;
            goto L14
        L9:
            r15 = 0;
            goto L10
        L5:
            r12 = 0;
            goto L6
        }
    }

    static {
        f4944d = new String[]{"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};
        f4945e = new a(float[].class, "nonTranslations");
        f4946f = new b(PointF.class, "translations");
        f4947g = true;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeTransform(@NonNull Context r10, @NonNull AttributeSet r11) {
        super(r10, r11);
        this.f4948a = true;
        this.f4949b = true;
        this.f4950c = new Matrix();
        TypedArray r12 = r10.obtainStyledAttributes(r11, Styleable.f5000g);
        XmlPullParser r13 = (XmlPullParser) r11;
        this.f4948a = n.g.a(r12, r13, "reparentWithOverlay", 1, true);
        this.f4949b = n.g.a(r12, r13, "reparent", 0, true);
        r12.recycle();
    }

    private void captureValues(s r10) {
        View r11 = r10.f5086b;
        if (r11.getVisibility() != 8) goto L5;
        return;
    L5:
        r10.f5085a.put("android:changeTransform:parent", r11.getParent());
        r10.f5085a.put("android:changeTransform:transforms", new f(r11));
        Matrix r12 = r11.getMatrix();
        if (r12 != null) goto L8;
    L11:
        Matrix r13 = null;
    L12:
        r10.f5085a.put("android:changeTransform:matrix", r13);
        if (this.f4949b == false) goto L16;
        Matrix r14 = new Matrix();
        ViewGroup r15 = (ViewGroup) r11.getParent();
        y.j(r15, r14);
        r14.preTranslate(-r15.getScrollX(), -r15.getScrollY());
        r10.f5085a.put("android:changeTransform:parentMatrix", r14);
        r10.f5085a.put("android:changeTransform:intermediateMatrix", r11.getTag(R$id.transition_transform));
        r10.f5085a.put("android:changeTransform:intermediateParentMatrix", r11.getTag(R$id.parent_matrix));
        return;
    L16:
        return;
    L8:
        if (r12.isIdentity() == true) goto L11;
        r13 = new Matrix(r12);
        goto L12
    }

    public static void v(View r10) {
        x(r10, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    public static void x(View r10, float r11, float r12, float r13, float r14, float r15, float r16, float r17, float r18) {
        r10.setTranslationX(r11);
        r10.setTranslationY(r12);
        ViewCompat.I0(r10, r13);
        r10.setScaleX(r14);
        r10.setScaleY(r15);
        r10.setRotationX(r16);
        r10.setRotationY(r17);
        r10.setRotation(r18);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(s r10) {
        captureValues(r10);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(s r10) {
        captureValues(r10);
        if (f4947g == true) goto L6;
        ((ViewGroup) r10.f5086b.getParent()).startViewTransition(r10.f5086b);
        return;
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup r10, s r11, s r12) {
        if (r11 == null) goto L33;
        if (r12 != null) goto L5;
        return null;
    L5:
        if (r11.f5085a.containsKey("android:changeTransform:parent") == true) goto L7;
        return null;
    L7:
        if (r12.f5085a.containsKey("android:changeTransform:parent") == false) goto L37;
        ViewGroup r13 = (ViewGroup) r11.f5085a.get("android:changeTransform:parent");
        ViewGroup r14 = (ViewGroup) r12.f5085a.get("android:changeTransform:parent");
        if (this.f4949b == true) goto L12;
    L14:
        boolean r15 = false;
    L15:
        Matrix r16 = (Matrix) r11.f5085a.get("android:changeTransform:intermediateMatrix");
        if (r16 == null) goto L18;
        r11.f5085a.put("android:changeTransform:matrix", r16);
    L18:
        Matrix r17 = (Matrix) r11.f5085a.get("android:changeTransform:intermediateParentMatrix");
        if (r17 == null) goto L21;
        r11.f5085a.put("android:changeTransform:parentMatrix", r17);
    L21:
        if (r15 == false) goto L23;
        w(r11, r12);
    L23:
        ObjectAnimator r18 = t(r11, r12, r15);
        if (r15 == false) goto L30;
        if (r18 == null) goto L30;
        if (this.f4948a == false) goto L30;
        s(r10, r11, r12);
    L32:
        return r18;
    L30:
        if (f4947g == true) goto L32;
        r13.endViewTransition(r11.f5086b);
        goto L32
    L12:
        if (u(r13, r14) == true) goto L14;
        r15 = true;
        goto L15
    L37:
        return null;
    L33:
        return null;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f4944d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [androidx.transition.Transition] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    public final void s(ViewGroup r10, s r11, s r12) {
        View r13 = r12.f5086b;
        Matrix r14 = new Matrix((Matrix) r12.f5085a.get("android:changeTransform:parentMatrix"));
        y.k(r10, r14);
        GhostView r15 = g.a(r13, r10, r14);
        if (r15 != null) goto L5;
        return;
    L5:
        r15.reserveEndViewTransition((ViewGroup) r11.f5085a.get("android:changeTransform:parent"), r11.f5086b);
        ?? r16 = this;
    L6:
        TransitionSet r17 = r16.mParent;
        if (r17 == null) goto L9;
        r16 = r17;
        goto L6
    L9:
        r16.addListener(new d(r13, r15));
        if (f4947g == false) goto L17;
        View r18 = r11.f5086b;
        if (r18 == r12.f5086b) goto L14;
        y.h(r18, 0.0f);
    L14:
        y.h(r13, 1.0f);
        return;
    }

    public final ObjectAnimator t(s r10, s r11, boolean r12) {
        Matrix r13 = (Matrix) r10.f5085a.get("android:changeTransform:matrix");
        Matrix r14 = (Matrix) r11.f5085a.get("android:changeTransform:matrix");
        if (r13 != null) goto L5;
        r13 = i.f5068a;
    L5:
        if (r14 != null) goto L7;
        r14 = i.f5068a;
    L7:
        Matrix r15 = r14;
        if (r13.equals(r15) == false) goto L11;
        return null;
    L11:
        f r16 = (f) r11.f5085a.get("android:changeTransform:transforms");
        View r17 = r11.f5086b;
        v(r17);
        float[] r18 = new float[9];
        r13.getValues(r18);
        float[] r19 = new float[9];
        r15.getValues(r19);
        e r20 = new e(r17, r18);
        PropertyValuesHolder r110 = PropertyValuesHolder.ofObject(f4945e, new androidx.transition.c(new float[9]), new float[][]{r18, r19});
        Path r111 = getPathMotion().getPath(r18[2], r18[5], r19[2], r19[5]);
        ObjectAnimator r112 = ObjectAnimator.ofPropertyValuesHolder(r20, new PropertyValuesHolder[]{r110, k.a(f4946f, r111)});
        c r113 = new c(this, r12, r15, r17, r16, r20);
        r112.addListener(r113);
        AnimatorUtils.a(r112, r113);
        return r112;
    }

    public final boolean u(ViewGroup r10, ViewGroup r11) {
        boolean r12 = true;
        if (isValidTarget(r10) == true) goto L5;
    L14:
        if (r10 == r11) goto L17;
    L12:
        r12 = false;
    L17:
        return r12;
    L5:
        if (isValidTarget(r11) == false) goto L14;
        s r13 = getMatchedTransitionValues(r10, true);
        if (r13 != null) goto L10;
        return false;
    L10:
        if (r11 != r13.f5086b) goto L12;
        goto L12
    }

    public final void w(s r10, s r11) {
        Matrix r12 = (Matrix) r11.f5085a.get("android:changeTransform:parentMatrix");
        r11.f5086b.setTag(R$id.parent_matrix, r12);
        Matrix r13 = this.f4950c;
        r13.reset();
        r12.invert(r13);
        Matrix r14 = (Matrix) r10.f5085a.get("android:changeTransform:matrix");
        if (r14 != null) goto L5;
        r14 = new Matrix();
        r10.f5085a.put("android:changeTransform:matrix", r14);
    L5:
        r14.postConcat((Matrix) r10.f5085a.get("android:changeTransform:parentMatrix"));
        r14.postConcat(r13);
    }
}
