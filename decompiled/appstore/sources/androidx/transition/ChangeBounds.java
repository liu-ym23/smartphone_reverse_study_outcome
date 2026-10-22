package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ChangeBounds extends Transition {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f4899d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Property f4900e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Property f4901f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Property f4902g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Property f4903h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Property f4904i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Property f4905j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static l f4906k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f4907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4909c;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f4910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitmapDrawable f4911b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f4912c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f4913d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ChangeBounds f4914e;

        public a(ChangeBounds r10, ViewGroup r11, BitmapDrawable r12, View r13, float r14) {
            this.f4914e = r10;
            this.f4910a = r11;
            this.f4911b = r12;
            this.f4912c = r13;
            this.f4913d = r14;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            y.b(this.f4910a).remove(this.f4911b);
            y.h(this.f4912c, this.f4913d);
        }
    }

    public class b extends Property {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f4915a;

        public b(Class r10, String r11) {
            super(r10, r11);
            this.f4915a = new Rect();
        }

        public PointF a(Drawable r10) {
            r10.copyBounds(this.f4915a);
            Rect r11 = this.f4915a;
            return new PointF(r11.left, r11.top);
        }

        public void b(Drawable r10, PointF r11) {
            r10.copyBounds(this.f4915a);
            this.f4915a.offsetTo(Math.round(r11.x), Math.round(r11.y));
            r10.setBounds(this.f4915a);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Object get(Object r10) {
            return a((Drawable) r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(Object r10, Object r11) {
            b((Drawable) r10, (PointF) r11);
        }
    }

    public class c extends Property {
        public c(Class r10, String r11) {
            super(r10, r11);
        }

        public PointF a(k r10) {
            return null;
        }

        public void b(k r10, PointF r11) {
            r10.c(r11);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Object get(Object r10) {
            return a((k) r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(Object r10, Object r11) {
            b((k) r10, (PointF) r11);
        }
    }

    public class d extends Property {
        public d(Class r10, String r11) {
            super(r10, r11);
        }

        public PointF a(k r10) {
            return null;
        }

        public void b(k r10, PointF r11) {
            r10.a(r11);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Object get(Object r10) {
            return a((k) r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(Object r10, Object r11) {
            b((k) r10, (PointF) r11);
        }
    }

    public class e extends Property {
        public e(Class r10, String r11) {
            super(r10, r11);
        }

        public PointF a(View r10) {
            return null;
        }

        public void b(View r10, PointF r11) {
            y.g(r10, r10.getLeft(), r10.getTop(), Math.round(r11.x), Math.round(r11.y));
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Object get(Object r10) {
            return a((View) r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(Object r10, Object r11) {
            b((View) r10, (PointF) r11);
        }
    }

    public class f extends Property {
        public f(Class r10, String r11) {
            super(r10, r11);
        }

        public PointF a(View r10) {
            return null;
        }

        public void b(View r10, PointF r11) {
            y.g(r10, Math.round(r11.x), Math.round(r11.y), r10.getRight(), r10.getBottom());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Object get(Object r10) {
            return a((View) r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(Object r10, Object r11) {
            b((View) r10, (PointF) r11);
        }
    }

    public class g extends Property {
        public g(Class r10, String r11) {
            super(r10, r11);
        }

        public PointF a(View r10) {
            return null;
        }

        public void b(View r10, PointF r11) {
            int r12 = Math.round(r11.x);
            int r13 = Math.round(r11.y);
            y.g(r10, r12, r13, r10.getWidth() + r12, r10.getHeight() + r13);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Object get(Object r10) {
            return a((View) r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(Object r10, Object r11) {
            b((View) r10, (PointF) r11);
        }
    }

    public class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f4916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChangeBounds f4917b;
        private k mViewBounds;

        public h(ChangeBounds r10, k r11) {
            this.f4917b = r10;
            this.f4916a = r11;
            this.mViewBounds = r11;
        }
    }

    public class i extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f4919b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Rect f4920c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f4921d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f4922e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f4923f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f4924g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ ChangeBounds f4925h;

        public i(ChangeBounds r10, View r11, Rect r12, int r13, int r14, int r15, int r16) {
            this.f4925h = r10;
            this.f4919b = r11;
            this.f4920c = r12;
            this.f4921d = r13;
            this.f4922e = r14;
            this.f4923f = r15;
            this.f4924g = r16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            this.f4918a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            if (this.f4918a == true) goto L6;
            ViewCompat.w0(this.f4919b, this.f4920c);
            y.g(this.f4919b, this.f4921d, this.f4922e, this.f4923f, this.f4924g);
            return;
        }
    }

    public class j extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f4927b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ChangeBounds f4928c;

        public j(ChangeBounds r10, ViewGroup r11) {
            this.f4928c = r10;
            this.f4927b = r11;
            this.f4926a = false;
        }

        @Override // androidx.transition.o, androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition r10) {
            w.c(this.f4927b, false);
            this.f4926a = true;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r10) {
            if (this.f4926a == true) goto L5;
            w.c(this.f4927b, false);
        L5:
            r10.removeListener(this);
        }

        @Override // androidx.transition.o, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition r10) {
            w.c(this.f4927b, false);
        }

        @Override // androidx.transition.o, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition r10) {
            w.c(this.f4927b, true);
        }
    }

    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4931c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4932d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f4933e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f4934f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f4935g;

        public k(View r10) {
            this.f4933e = r10;
        }

        public void a(PointF r10) {
            this.f4931c = Math.round(r10.x);
            this.f4932d = Math.round(r10.y);
            int r11 = this.f4935g + 1;
            this.f4935g = r11;
            if (this.f4934f != r11) goto L6;
            b();
            return;
        }

        public final void b() {
            y.g(this.f4933e, this.f4929a, this.f4930b, this.f4931c, this.f4932d);
            this.f4934f = 0;
            this.f4935g = 0;
        }

        public void c(PointF r10) {
            this.f4929a = Math.round(r10.x);
            this.f4930b = Math.round(r10.y);
            int r11 = this.f4934f + 1;
            this.f4934f = r11;
            if (r11 != this.f4935g) goto L6;
            b();
            return;
        }
    }

    static {
        f4899d = new String[]{"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
        f4900e = new b(PointF.class, "boundsOrigin");
        f4901f = new c(PointF.class, "topLeft");
        f4902g = new d(PointF.class, "bottomRight");
        f4903h = new e(PointF.class, "bottomRight");
        f4904i = new f(PointF.class, "topLeft");
        f4905j = new g(PointF.class, "position");
        f4906k = new l();
    }

    public ChangeBounds() {
        this.f4907a = new int[2];
        this.f4908b = false;
        this.f4909c = false;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(s r10) {
        captureValues(r10);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(s r10) {
        captureValues(r10);
    }

    public final void captureValues(s r10) {
        View r11 = r10.f5086b;
        if (ViewCompat.T(r11) == false) goto L5;
    L8:
        r10.f5085a.put("android:changeBounds:bounds", new Rect(r11.getLeft(), r11.getTop(), r11.getRight(), r11.getBottom()));
        r10.f5085a.put("android:changeBounds:parent", r10.f5086b.getParent());
        if (this.f4909c == false) goto L12;
        r10.f5086b.getLocationInWindow(this.f4907a);
        r10.f5085a.put("android:changeBounds:windowX", Integer.valueOf(this.f4907a[0]));
        r10.f5085a.put("android:changeBounds:windowY", Integer.valueOf(this.f4907a[1]));
    L12:
        if (this.f4908b == false) goto L16;
        r10.f5085a.put("android:changeBounds:clip", ViewCompat.t(r11));
        return;
    L16:
        return;
    L5:
        if (r11.getWidth() != 0) goto L8;
        if (r11.getHeight() != 0) goto L8;
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup r20, s r21, s r22) {
        if (r21 == null) goto L5;
        if (r22 == null) goto L5;
        Map r10 = r21.f5085a;
        Map r11 = r22.f5085a;
        ViewGroup r12 = (ViewGroup) r10.get("android:changeBounds:parent");
        ViewGroup r13 = (ViewGroup) r11.get("android:changeBounds:parent");
        if (r12 == null) goto L9;
        if (r13 == null) goto L9;
        View r14 = r22.f5086b;
        if (s(r12, r13) == false) goto L71;
        Rect r15 = (Rect) r21.f5085a.get("android:changeBounds:bounds");
        Rect r16 = (Rect) r22.f5085a.get("android:changeBounds:bounds");
        int r17 = r15.left;
        int r18 = r16.left;
        int r19 = r15.top;
        int r110 = r16.top;
        int r111 = r15.right;
        int r112 = r16.right;
        int r23 = r15.bottom;
        int r24 = r16.bottom;
        int r25 = r111 - r17;
        int r26 = r23 - r19;
        int r27 = r112 - r18;
        int r28 = r24 - r110;
        Rect r29 = (Rect) r21.f5085a.get("android:changeBounds:clip");
        Rect r113 = (Rect) r22.f5085a.get("android:changeBounds:clip");
        if (r25 == 0) goto L15;
        if (r26 == 0) goto L15;
    L17:
        if (r17 != r18) goto L21;
        if (r19 != r110) goto L21;
        int r30 = 0;
    L22:
        if (r111 != r112) goto L24;
        if (r23 != r24) goto L24;
    L26:
        if (r29 != null) goto L28;
    L31:
        if (r29 != null) goto L35;
        if (r113 == null) goto L35;
    L34:
        r30 = r30 + 1;
    L35:
        if (r30 > 0) goto L37;
        return null;
    L37:
        if (this.f4908b == true) goto L49;
        View r114 = r14;
        y.g(r114, r17, r19, r111, r23);
        if (r30 != 2) goto L44;
        if (r25 != r27) goto L43;
        if (r26 != r28) goto L43;
        Animator r31 = androidx.transition.j.a(r114, f4905j, getPathMotion().getPath(r17, r19, r18, r110));
    L67:
        if ((r114.getParent() instanceof ViewGroup) == false) goto L69;
        ViewGroup r32 = (ViewGroup) r114.getParent();
        w.c(r32, true);
        addListener(new j(this, r32));
    L69:
        return r31;
    L43:
        k r33 = new k(r114);
        ObjectAnimator r34 = androidx.transition.j.a(r33, f4901f, getPathMotion().getPath(r17, r19, r18, r110));
        ObjectAnimator r35 = androidx.transition.j.a(r33, f4902g, getPathMotion().getPath(r111, r23, r112, r24));
        AnimatorSet r36 = new AnimatorSet();
        r36.playTogether(new Animator[]{r34, r35});
        r36.addListener(new h(this, r33));
        r31 = r36;
        goto L67
    L44:
        if (r17 != r18) goto L48;
        if (r19 != r110) goto L48;
        r31 = androidx.transition.j.a(r114, f4903h, getPathMotion().getPath(r111, r23, r112, r24));
    L48:
        r31 = androidx.transition.j.a(r114, f4904i, getPathMotion().getPath(r17, r19, r18, r110));
        goto L67
    L49:
        r114 = r14;
        y.g(r114, r17, r19, Math.max(r25, r27) + r17, Math.max(r26, r28) + r19);
        if (r17 != r18) goto L54;
        if (r19 != r110) goto L54;
        ObjectAnimator r115 = null;
    L55:
        if (r29 != null) goto L57;
        int r37 = 0;
        r29 = new Rect(0, 0, r25, r26);
    L58:
        if (r113 != null) goto L60;
        Rect r38 = new Rect(r37, r37, r27, r28);
    L62:
        if (r29.equals(r38) == true) goto L64;
        ViewCompat.w0(r114, r29);
        ObjectAnimator r39 = ObjectAnimator.ofObject(r114, "clipBounds", f4906k, new Object[]{r29, r38});
        r39.addListener(new i(this, r114, r113, r18, r110, r112, r24));
        ObjectAnimator r40 = r39;
    L65:
        r31 = r.c(r115, r40);
        goto L67
    L64:
        r40 = null;
        goto L65
    L60:
        r38 = r113;
        goto L62
    L57:
        r37 = 0;
    L54:
        r115 = androidx.transition.j.a(r114, f4905j, getPathMotion().getPath(r17, r19, r18, r110));
        goto L55
    L28:
        if (r29.equals(r113) == false) goto L34;
    L24:
        r30 = r30 + 1;
    L21:
        r30 = 1;
    L15:
        if (r27 == 0) goto L25;
        if (r28 != 0) goto L17;
    L25:
        r30 = 0;
        goto L26
    L71:
        int r41 = ((Integer) r21.f5085a.get("android:changeBounds:windowX")).intValue();
        int r42 = ((Integer) r21.f5085a.get("android:changeBounds:windowY")).intValue();
        int r43 = ((Integer) r22.f5085a.get("android:changeBounds:windowX")).intValue();
        int r44 = ((Integer) r22.f5085a.get("android:changeBounds:windowY")).intValue();
        if (r41 != r43) goto L76;
        if (r42 != r44) goto L76;
        return null;
    L76:
        r20.getLocationInWindow(this.f4907a);
        Bitmap r45 = Bitmap.createBitmap(r14.getWidth(), r14.getHeight(), Bitmap.Config.ARGB_8888);
        r14.draw(new Canvas(r45));
        BitmapDrawable r46 = new BitmapDrawable(r45);
        float r47 = y.c(r14);
        y.h(r14, 0.0f);
        y.b(r20).add(r46);
        PathMotion r48 = getPathMotion();
        int[] r49 = this.f4907a;
        int r116 = r49[0];
        int r50 = r49[1];
        ObjectAnimator r51 = ObjectAnimator.ofPropertyValuesHolder(r46, new PropertyValuesHolder[]{androidx.transition.k.a(f4900e, r48.getPath(r41 - r116, r42 - r50, r43 - r116, r44 - r50))});
        r51.addListener(new a(this, r20, r46, r14, r47));
        return r51;
    L9:
        return null;
    L5:
        return null;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f4899d;
    }

    public final boolean s(View r10, View r11) {
        if (this.f4909c == false) goto L11;
        s r12 = getMatchedTransitionValues(r10, true);
        if (r12 != null) goto L10;
        if (r10 != r11) goto L12;
        return true;
    L12:
        return false;
    L10:
        if (r11 != r12.f5086b) goto L12;
        return true;
    L11:
        return true;
    }

    public void t(boolean r10) {
        this.f4908b = r10;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(@NonNull Context r10, @NonNull AttributeSet r11) {
        super(r10, r11);
        this.f4907a = new int[2];
        this.f4908b = false;
        this.f4909c = false;
        TypedArray r12 = r10.obtainStyledAttributes(r11, Styleable.f4997d);
        boolean r13 = n.g.a(r12, (XmlResourceParser) r11, "resizeClip", 0, false);
        r12.recycle();
        t(r13);
    }
}
