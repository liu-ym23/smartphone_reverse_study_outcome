package com.obric.oui.animation.engine;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.View;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DynamicAnimation implements AnimationHandler.AnimationFrameCallback {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final p f12312m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final p f12313n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final p f12314o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final p f12315p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final p f12316q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final p f12317r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final p f12318s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final p f12319t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final p f12320u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final p f12321v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final p f12322w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final p f12323x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final p f12324y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final p f12325z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f12326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f12327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f12329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.obric.oui.animation.engine.a f12330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f12331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f12332g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f12333h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f12334i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f12335j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f12336k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f12337l;

    public interface OnAnimationEndListener {
        void onAnimationEnd(DynamicAnimation r10, boolean r11, float r12, float r13);
    }

    public interface OnAnimationUpdateListener {
        void onAnimationUpdate(DynamicAnimation r10, float r11, float r12);
    }

    public class a extends p {
        public a(String r10) {
            super(r10, null);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ float a(Object r10) {
            return c((View) r10);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ void b(Object r10, float r11) {
            d((View) r10, r11);
        }

        public float c(View r10) {
            return r10.getY();
        }

        public void d(View r10, float r11) {
            r10.setY(r11);
        }
    }

    public class b extends p {
        public b(String r10) {
            super(r10, null);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ float a(Object r10) {
            return c((View) r10);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ void b(Object r10, float r11) {
            d((View) r10, r11);
        }

        public float c(View r10) {
            return r10.getZ();
        }

        public void d(View r10, float r11) {
            r10.setZ(r11);
        }
    }

    public class c extends p {
        public c(String r10) {
            super(r10, null);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ float a(Object r10) {
            return c((View) r10);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ void b(Object r10, float r11) {
            d((View) r10, r11);
        }

        public float c(View r10) {
            return r10.getAlpha();
        }

        public void d(View r10, float r11) {
            r10.setAlpha(r11);
        }
    }

    public class d extends p {
        public d(String r10) {
            super(r10, null);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ float a(Object r10) {
            return c((View) r10);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ void b(Object r10, float r11) {
            d((View) r10, r11);
        }

        public float c(View r10) {
            return r10.getScrollX();
        }

        public void d(View r10, float r11) {
            r10.setScrollX((int) r11);
        }
    }

    public class e extends p {
        public e(String r10) {
            super(r10, null);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ float a(Object r10) {
            return c((View) r10);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ void b(Object r10, float r11) {
            d((View) r10, r11);
        }

        public float c(View r10) {
            return r10.getScrollY();
        }

        public void d(View r10, float r11) {
            r10.setScrollY((int) r11);
        }
    }

    public class f extends p {
        public f(String r10) {
            super(r10, null);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ float a(Object r10) {
            return c((View) r10);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ void b(Object r10, float r11) {
            d((View) r10, r11);
        }

        public float c(View r10) {
            return r10.getTranslationX();
        }

        public void d(View r10, float r11) {
            r10.setTranslationX(r11);
        }
    }

    public class g extends p {
        public g(String r10) {
            super(r10, null);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ float a(Object r10) {
            return c((View) r10);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ void b(Object r10, float r11) {
            d((View) r10, r11);
        }

        public float c(View r10) {
            return r10.getTranslationY();
        }

        public void d(View r10, float r11) {
            r10.setTranslationY(r11);
        }
    }

    public class h extends p {
        public h(String r10) {
            super(r10, null);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ float a(Object r10) {
            return c((View) r10);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ void b(Object r10, float r11) {
            d((View) r10, r11);
        }

        public float c(View r10) {
            return r10.getTranslationZ();
        }

        public void d(View r10, float r11) {
            r10.setTranslationZ(r11);
        }
    }

    public class i extends p {
        public i(String r10) {
            super(r10, null);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ float a(Object r10) {
            return c((View) r10);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ void b(Object r10, float r11) {
            d((View) r10, r11);
        }

        public float c(View r10) {
            return r10.getScaleX();
        }

        public void d(View r10, float r11) {
            r10.setScaleX(r11);
        }
    }

    public class j extends p {
        public j(String r10) {
            super(r10, null);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ float a(Object r10) {
            return c((View) r10);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ void b(Object r10, float r11) {
            d((View) r10, r11);
        }

        public float c(View r10) {
            return r10.getScaleY();
        }

        public void d(View r10, float r11) {
            r10.setScaleY(r11);
        }
    }

    public class k extends p {
        public k(String r10) {
            super(r10, null);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ float a(Object r10) {
            return c((View) r10);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ void b(Object r10, float r11) {
            d((View) r10, r11);
        }

        public float c(View r10) {
            return r10.getRotation();
        }

        public void d(View r10, float r11) {
            r10.setRotation(r11);
        }
    }

    public class l extends p {
        public l(String r10) {
            super(r10, null);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ float a(Object r10) {
            return c((View) r10);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ void b(Object r10, float r11) {
            d((View) r10, r11);
        }

        public float c(View r10) {
            return r10.getRotationX();
        }

        public void d(View r10, float r11) {
            r10.setRotationX(r11);
        }
    }

    public class m extends p {
        public m(String r10) {
            super(r10, null);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ float a(Object r10) {
            return c((View) r10);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ void b(Object r10, float r11) {
            d((View) r10, r11);
        }

        public float c(View r10) {
            return r10.getRotationY();
        }

        public void d(View r10, float r11) {
            r10.setRotationY(r11);
        }
    }

    public class n extends p {
        public n(String r10) {
            super(r10, null);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ float a(Object r10) {
            return c((View) r10);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ void b(Object r10, float r11) {
            d((View) r10, r11);
        }

        public float c(View r10) {
            return r10.getX();
        }

        public void d(View r10, float r11) {
            r10.setX(r11);
        }
    }

    public static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f12338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f12339b;

        public o() {
        }
    }

    public static abstract class p extends com.obric.oui.animation.engine.a {
        public /* synthetic */ p(String r10, f r11) {
            this(r10);
        }

        public p(String r10) {
            super(r10);
        }
    }

    static {
        f12312m = new f("translationX");
        f12313n = new g("translationY");
        f12314o = new h("translationZ");
        f12315p = new i("scaleX");
        f12316q = new j("scaleY");
        f12317r = new k("rotation");
        f12318s = new l("rotationX");
        f12319t = new m("rotationY");
        f12320u = new n(FixCard.FixStyle.KEY_X);
        f12321v = new a(FixCard.FixStyle.KEY_Y);
        f12322w = new b("z");
        f12323x = new c("alpha");
        f12324y = new d("scrollX");
        f12325z = new e("scrollY");
    }

    public DynamicAnimation(Object r10, com.obric.oui.animation.engine.a r11) {
        this.f12326a = 0.0f;
        this.f12327b = Float.MAX_VALUE;
        this.f12328c = false;
        this.f12331f = false;
        this.f12332g = Float.MAX_VALUE;
        this.f12333h = -Float.MAX_VALUE;
        this.f12334i = 0;
        this.f12336k = new ArrayList();
        this.f12337l = new ArrayList();
        this.f12329d = r10;
        this.f12330e = r11;
        if (r11 != f12317r) goto L5;
    L19:
        this.f12335j = 0.1f;
        return;
    L5:
        if (r11 == f12318s) goto L19;
        if (r11 == f12319t) goto L19;
        if (r11 != f12323x) goto L13;
        this.f12335j = 0.00390625f;
        return;
    L13:
        if (r11 != f12315p) goto L15;
    L18:
        this.f12335j = 0.00390625f;
        return;
    L15:
        if (r11 == f12316q) goto L18;
        this.f12335j = 1.0f;
    }

    public static void h(ArrayList r10, Object r11) {
        int r12 = r10.indexOf(r11);
        if (r12 < 0) goto L6;
        r10.set(r12, null);
        return;
    }

    public static void i(ArrayList r10) {
        int r11 = r10.size() - 1;
    L3:
        if (r11 < 0) goto L8;
        if (r10.get(r11) != null) goto L7;
        r10.remove(r11);
    L7:
        r11 = r11 - 1;
        goto L3
    }

    public DynamicAnimation a(OnAnimationEndListener r10) {
        if (this.f12336k.contains(r10) == true) goto L5;
        this.f12336k.add(r10);
    L5:
        return this;
    }

    public DynamicAnimation b(OnAnimationUpdateListener r10) {
        if (g() == true) goto L9;
        if (this.f12337l.contains(r10) == true) goto L7;
        this.f12337l.add(r10);
    L7:
        return this;
    L9:
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    }

    public void c() {
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        if (this.f12331f == false) goto L10;
        d(true);
        return;
    L10:
        return;
    L9:
        throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
    }

    public final void d(boolean r10) {
        int r11 = 0;
        this.f12331f = false;
        AnimationHandler.d().g(this);
        this.f12334i = 0;
        this.f12328c = false;
    L4:
        if (r11 >= this.f12336k.size()) goto L9;
        if (this.f12336k.get(r11) == null) goto L8;
        ((OnAnimationEndListener) this.f12336k.get(r11)).onAnimationEnd(this, r10, this.f12327b, this.f12326a);
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        i(this.f12336k);
    }

    @Override // com.obric.oui.animation.engine.AnimationHandler.AnimationFrameCallback
    public boolean doAnimationFrame(long r10) {
        long r11 = this.f12334i;
        if (r11 != 0) goto L6;
        this.f12334i = r10;
        l(this.f12327b);
        return false;
    L6:
        this.f12334i = r10;
        boolean r12 = q(r10 - r11);
        float r13 = Math.min(this.f12327b, this.f12332g);
        this.f12327b = r13;
        float r14 = Math.max(r13, this.f12333h);
        this.f12327b = r14;
        l(r14);
        if (r12 == false) goto L9;
        d(false);
    L9:
        return r12;
    }

    public final float e() {
        return this.f12330e.a(this.f12329d);
    }

    public float f() {
        return this.f12335j * 0.75f;
    }

    public boolean g() {
        return this.f12331f;
    }

    public DynamicAnimation j(float r10) {
        this.f12332g = r10;
        return this;
    }

    public DynamicAnimation k(float r10) {
        this.f12333h = r10;
        return this;
    }

    public void l(float r10) {
        this.f12330e.b(this.f12329d, r10);
        int r11 = 0;
    L4:
        if (r11 >= this.f12337l.size()) goto L9;
        if (this.f12337l.get(r11) == null) goto L8;
        ((OnAnimationUpdateListener) this.f12337l.get(r11)).onAnimationUpdate(this, this.f12327b, this.f12326a);
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        i(this.f12337l);
    }

    public DynamicAnimation m(float r10) {
        this.f12327b = r10;
        this.f12328c = true;
        return this;
    }

    public DynamicAnimation n(float r10) {
        this.f12326a = r10;
        return this;
    }

    public void o() {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L5;
        Log.e("DynamicAnimation", "Current Thread Id + " + Thread.currentThread().getId() + " Main Thread Id + " + Looper.getMainLooper().getThread().getId());
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    L5:
        if (this.f12331f == true) goto L10;
        p();
        return;
    }

    public final void p() {
        if (this.f12331f == true) goto L14;
        this.f12331f = true;
        if (this.f12328c == true) goto L7;
        this.f12327b = e();
    L7:
        float r10 = this.f12327b;
        if (r10 > this.f12332g) goto L13;
        if (r10 < this.f12333h) goto L13;
        AnimationHandler.d().a(this, 0);
        return;
    L13:
        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
    }

    public abstract boolean q(long r10);

    public void removeEndListener(OnAnimationEndListener r10) {
        h(this.f12336k, r10);
    }

    public void removeUpdateListener(OnAnimationUpdateListener r10) {
        h(this.f12337l, r10);
    }
}
