package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class DynamicAnimation implements AnimationHandler.AnimationFrameCallback {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final p f2971m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final p f2972n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final p f2973o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final p f2974p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final p f2975q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final p f2976r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final p f2977s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final p f2978t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final p f2979u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final p f2980v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final p f2981w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final p f2982x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final p f2983y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final p f2984z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f2986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f2988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final androidx.dynamicanimation.animation.a f2989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2990f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f2991g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f2992h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f2993i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f2994j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f2995k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f2996l;

    public interface OnAnimationEndListener {
        void onAnimationEnd(DynamicAnimation r10, boolean r11, float r12, float r13);
    }

    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(DynamicAnimation r10, float r11, float r12);
    }

    public static class a extends p {
        public a(String r10) {
            super(r10, null);
        }

        public float a(View r10) {
            return r10.getY();
        }

        public void b(View r10, float r11) {
            r10.setY(r11);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ float getValue(Object r10) {
            return a((View) r10);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ void setValue(Object r10, float r11) {
            b((View) r10, r11);
        }
    }

    public static class b extends p {
        public b(String r10) {
            super(r10, null);
        }

        public float a(View r10) {
            return ViewCompat.M(r10);
        }

        public void b(View r10, float r11) {
            ViewCompat.K0(r10, r11);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ float getValue(Object r10) {
            return a((View) r10);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ void setValue(Object r10, float r11) {
            b((View) r10, r11);
        }
    }

    public static class c extends p {
        public c(String r10) {
            super(r10, null);
        }

        public float a(View r10) {
            return r10.getAlpha();
        }

        public void b(View r10, float r11) {
            r10.setAlpha(r11);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ float getValue(Object r10) {
            return a((View) r10);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ void setValue(Object r10, float r11) {
            b((View) r10, r11);
        }
    }

    public static class d extends p {
        public d(String r10) {
            super(r10, null);
        }

        public float a(View r10) {
            return r10.getScrollX();
        }

        public void b(View r10, float r11) {
            r10.setScrollX((int) r11);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ float getValue(Object r10) {
            return a((View) r10);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ void setValue(Object r10, float r11) {
            b((View) r10, r11);
        }
    }

    public static class e extends p {
        public e(String r10) {
            super(r10, null);
        }

        public float a(View r10) {
            return r10.getScrollY();
        }

        public void b(View r10, float r11) {
            r10.setScrollY((int) r11);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ float getValue(Object r10) {
            return a((View) r10);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ void setValue(Object r10, float r11) {
            b((View) r10, r11);
        }
    }

    public static class f extends p {
        public f(String r10) {
            super(r10, null);
        }

        public float a(View r10) {
            return r10.getTranslationX();
        }

        public void b(View r10, float r11) {
            r10.setTranslationX(r11);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ float getValue(Object r10) {
            return a((View) r10);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ void setValue(Object r10, float r11) {
            b((View) r10, r11);
        }
    }

    public static class g extends p {
        public g(String r10) {
            super(r10, null);
        }

        public float a(View r10) {
            return r10.getTranslationY();
        }

        public void b(View r10, float r11) {
            r10.setTranslationY(r11);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ float getValue(Object r10) {
            return a((View) r10);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ void setValue(Object r10, float r11) {
            b((View) r10, r11);
        }
    }

    public static class h extends p {
        public h(String r10) {
            super(r10, null);
        }

        public float a(View r10) {
            return ViewCompat.K(r10);
        }

        public void b(View r10, float r11) {
            ViewCompat.I0(r10, r11);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ float getValue(Object r10) {
            return a((View) r10);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ void setValue(Object r10, float r11) {
            b((View) r10, r11);
        }
    }

    public static class i extends p {
        public i(String r10) {
            super(r10, null);
        }

        public float a(View r10) {
            return r10.getScaleX();
        }

        public void b(View r10, float r11) {
            r10.setScaleX(r11);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ float getValue(Object r10) {
            return a((View) r10);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ void setValue(Object r10, float r11) {
            b((View) r10, r11);
        }
    }

    public static class j extends p {
        public j(String r10) {
            super(r10, null);
        }

        public float a(View r10) {
            return r10.getScaleY();
        }

        public void b(View r10, float r11) {
            r10.setScaleY(r11);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ float getValue(Object r10) {
            return a((View) r10);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ void setValue(Object r10, float r11) {
            b((View) r10, r11);
        }
    }

    public static class k extends p {
        public k(String r10) {
            super(r10, null);
        }

        public float a(View r10) {
            return r10.getRotation();
        }

        public void b(View r10, float r11) {
            r10.setRotation(r11);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ float getValue(Object r10) {
            return a((View) r10);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ void setValue(Object r10, float r11) {
            b((View) r10, r11);
        }
    }

    public static class l extends p {
        public l(String r10) {
            super(r10, null);
        }

        public float a(View r10) {
            return r10.getRotationX();
        }

        public void b(View r10, float r11) {
            r10.setRotationX(r11);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ float getValue(Object r10) {
            return a((View) r10);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ void setValue(Object r10, float r11) {
            b((View) r10, r11);
        }
    }

    public static class m extends p {
        public m(String r10) {
            super(r10, null);
        }

        public float a(View r10) {
            return r10.getRotationY();
        }

        public void b(View r10, float r11) {
            r10.setRotationY(r11);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ float getValue(Object r10) {
            return a((View) r10);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ void setValue(Object r10, float r11) {
            b((View) r10, r11);
        }
    }

    public static class n extends p {
        public n(String r10) {
            super(r10, null);
        }

        public float a(View r10) {
            return r10.getX();
        }

        public void b(View r10, float r11) {
            r10.setX(r11);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ float getValue(Object r10) {
            return a((View) r10);
        }

        @Override // androidx.dynamicanimation.animation.a
        public /* bridge */ /* synthetic */ void setValue(Object r10, float r11) {
            b((View) r10, r11);
        }
    }

    public static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f2997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f2998b;

        public o() {
        }
    }

    public static abstract class p extends androidx.dynamicanimation.animation.a {
        public /* synthetic */ p(String r10, f r11) {
            this(r10);
        }

        public p(String r10) {
            super(r10);
        }
    }

    static {
        f2971m = new f("translationX");
        f2972n = new g("translationY");
        f2973o = new h("translationZ");
        f2974p = new i("scaleX");
        f2975q = new j("scaleY");
        f2976r = new k("rotation");
        f2977s = new l("rotationX");
        f2978t = new m("rotationY");
        f2979u = new n(FixCard.FixStyle.KEY_X);
        f2980v = new a(FixCard.FixStyle.KEY_Y);
        f2981w = new b("z");
        f2982x = new c("alpha");
        f2983y = new d("scrollX");
        f2984z = new e("scrollY");
    }

    public DynamicAnimation(Object r10, androidx.dynamicanimation.animation.a r11) {
        this.f2985a = 0.0f;
        this.f2986b = Float.MAX_VALUE;
        this.f2987c = false;
        this.f2990f = false;
        this.f2991g = Float.MAX_VALUE;
        this.f2992h = -Float.MAX_VALUE;
        this.f2993i = 0;
        this.f2995k = new ArrayList();
        this.f2996l = new ArrayList();
        this.f2988d = r10;
        this.f2989e = r11;
        if (r11 != f2976r) goto L5;
    L19:
        this.f2994j = 0.1f;
        return;
    L5:
        if (r11 == f2977s) goto L19;
        if (r11 == f2978t) goto L19;
        if (r11 != f2982x) goto L13;
        this.f2994j = 0.00390625f;
        return;
    L13:
        if (r11 != f2974p) goto L15;
    L18:
        this.f2994j = 0.00390625f;
        return;
    L15:
        if (r11 == f2975q) goto L18;
        this.f2994j = 1.0f;
    }

    public static void f(ArrayList r10, Object r11) {
        int r12 = r10.indexOf(r11);
        if (r12 < 0) goto L6;
        r10.set(r12, null);
        return;
    }

    public static void g(ArrayList r10) {
        int r11 = r10.size() - 1;
    L3:
        if (r11 < 0) goto L8;
        if (r10.get(r11) != null) goto L7;
        r10.remove(r11);
    L7:
        r11 = r11 - 1;
        goto L3
    }

    public void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        if (this.f2990f == false) goto L10;
        b(true);
        return;
    L10:
        return;
    L9:
        throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
    }

    public final void b(boolean r10) {
        int r11 = 0;
        this.f2990f = false;
        AnimationHandler.d().g(this);
        this.f2993i = 0;
        this.f2987c = false;
    L4:
        if (r11 >= this.f2995k.size()) goto L9;
        if (this.f2995k.get(r11) == null) goto L8;
        ((OnAnimationEndListener) this.f2995k.get(r11)).onAnimationEnd(this, r10, this.f2986b, this.f2985a);
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        g(this.f2995k);
    }

    public final float c() {
        return this.f2989e.getValue(this.f2988d);
    }

    public float d() {
        return this.f2994j * 0.75f;
    }

    @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallback
    public boolean doAnimationFrame(long r10) {
        long r11 = this.f2993i;
        if (r11 != 0) goto L6;
        this.f2993i = r10;
        h(this.f2986b);
        return false;
    L6:
        this.f2993i = r10;
        boolean r12 = l(r10 - r11);
        float r13 = Math.min(this.f2986b, this.f2991g);
        this.f2986b = r13;
        float r14 = Math.max(r13, this.f2992h);
        this.f2986b = r14;
        h(r14);
        if (r12 == false) goto L9;
        b(false);
    L9:
        return r12;
    }

    public boolean e() {
        return this.f2990f;
    }

    public void h(float r10) {
        this.f2989e.setValue(this.f2988d, r10);
        int r11 = 0;
    L4:
        if (r11 >= this.f2996l.size()) goto L9;
        if (this.f2996l.get(r11) == null) goto L8;
        ((OnAnimationUpdateListener) this.f2996l.get(r11)).onAnimationUpdate(this, this.f2986b, this.f2985a);
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        g(this.f2996l);
    }

    public DynamicAnimation i(float r10) {
        this.f2986b = r10;
        this.f2987c = true;
        return this;
    }

    public void j() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        if (this.f2990f == true) goto L10;
        k();
        return;
    L10:
        return;
    L9:
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    }

    public final void k() {
        if (this.f2990f == true) goto L14;
        this.f2990f = true;
        if (this.f2987c == true) goto L7;
        this.f2986b = c();
    L7:
        float r10 = this.f2986b;
        if (r10 > this.f2991g) goto L13;
        if (r10 < this.f2992h) goto L13;
        AnimationHandler.d().a(this, 0);
        return;
    L13:
        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
    }

    public abstract boolean l(long r10);

    public void removeEndListener(OnAnimationEndListener r10) {
        f(this.f2995k, r10);
    }

    public void removeUpdateListener(OnAnimationUpdateListener r10) {
        f(this.f2996l, r10);
    }
}
