package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Choreographer;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public final class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f24724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LottieComposition f24725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u0.c f24726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f24727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<m> f24728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f24729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f24730g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f24731h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public l0.b f24732i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f24733j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.airbnb.lottie.d f24734k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public l0.a f24735l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.airbnb.lottie.c f24736m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f24737n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.airbnb.lottie.model.layer.b f24738o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f24739p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f24740q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public t0.a f24741r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f24742s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final d f24743t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f24744u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f24745v;

    /* JADX INFO: loaded from: classes28.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    /* JADX INFO: loaded from: classes28.dex */
    public class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f24746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieDrawable f24747b;

        @Override // com.airbnb.lottie.LottieDrawable.m
        public final void run() {
            this.f24747b.o(this.f24746a);
        }

        public a(LottieDrawable r100, int r101) {
            this.f24747b = r100;
            this.f24746a = r101;
        }
    }

    public class b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f24748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieDrawable f24749b;

        @Override // com.airbnb.lottie.LottieDrawable.m
        public final void run() {
            this.f24749b.v(this.f24748a);
        }

        public b(LottieDrawable r100, float r101) {
            this.f24749b = r100;
            this.f24748a = r101;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public class c implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m0.e f24750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f24751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ v0.c f24752c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ LottieDrawable f24753d;

        @Override // com.airbnb.lottie.LottieDrawable.m
        public final void run() {
            this.f24753d.a(this.f24750a, this.f24751b, this.f24752c);
        }

        public c(LottieDrawable r100, m0.e r101, Object r102, v0.c r103) {
            this.f24753d = r100;
            this.f24750a = r101;
            this.f24751b = r102;
            this.f24752c = r103;
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LottieDrawable f24754a;

        public d(LottieDrawable r100) {
            this.f24754a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            LottieDrawable r101 = this.f24754a;
            if (r101.f24738o == null) goto L11;
            int r102 = r0.c.f535396a;
            if (r0.c.a.f535397a == true) goto L7;
        L9:
            r101.getClass();
            LottieDrawable r103 = this.f24754a;
            r103.f24738o.r(r103.f24726c.c());
            return;
        L7:
            if (r101.f24744u == false) goto L9;
            r101.f24744u = false;
            goto L9
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public class e implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LottieDrawable f24755a;

        @Override // com.airbnb.lottie.LottieDrawable.m
        public final void run() {
            this.f24755a.k();
        }

        public e(LottieDrawable r100) {
            this.f24755a = r100;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public class f implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LottieDrawable f24756a;

        @Override // com.airbnb.lottie.LottieDrawable.m
        public final void run() {
            this.f24756a.l();
        }

        public f(LottieDrawable r100) {
            this.f24756a = r100;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public class g implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f24757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieDrawable f24758b;

        @Override // com.airbnb.lottie.LottieDrawable.m
        public final void run() {
            this.f24758b.t(this.f24757a);
        }

        public g(LottieDrawable r100, int r101) {
            this.f24758b = r100;
            this.f24757a = r101;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public class h implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f24759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieDrawable f24760b;

        @Override // com.airbnb.lottie.LottieDrawable.m
        public final void run() {
            this.f24760b.u(this.f24759a);
        }

        public h(LottieDrawable r100, float r101) {
            this.f24760b = r100;
            this.f24759a = r101;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public class i implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f24761a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieDrawable f24762b;

        @Override // com.airbnb.lottie.LottieDrawable.m
        public final void run() {
            this.f24762b.p(this.f24761a);
        }

        public i(LottieDrawable r100, int r101) {
            this.f24762b = r100;
            this.f24761a = r101;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public class j implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f24763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LottieDrawable f24764b;

        @Override // com.airbnb.lottie.LottieDrawable.m
        public final void run() {
            this.f24764b.q(this.f24763a);
        }

        public j(LottieDrawable r100, float r101) {
            this.f24764b = r100;
            this.f24763a = r101;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public class k implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f24765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f24766b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LottieDrawable f24767c;

        @Override // com.airbnb.lottie.LottieDrawable.m
        public final void run() {
            this.f24767c.r(this.f24765a, this.f24766b);
        }

        public k(LottieDrawable r100, int r101, int r102) {
            this.f24767c = r100;
            this.f24765a = r101;
            this.f24766b = r102;
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    public class l implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f24768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f24769b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LottieDrawable f24770c;

        @Override // com.airbnb.lottie.LottieDrawable.m
        public final void run() {
            this.f24770c.s(this.f24768a, this.f24769b);
        }

        public l(LottieDrawable r100, float r101, float r102) {
            this.f24770c = r100;
            this.f24768a = r101;
            this.f24769b = r102;
        }
    }

    public interface m {
        void run();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    public final void b() {
        this.f24738o = new com.airbnb.lottie.model.layer.b(this, s0.m.b(this.f24725b), this.f24725b.getLayers(), this.f24725b);
        i();
    }

    public final void c() {
        int r100 = r0.c.f535396a;
        this.f24728e.clear();
        this.f24726c.cancel();
    }

    public final void d() {
        int r100 = r0.c.f535396a;
        this.f24728e.clear();
        this.f24726c.b();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        LottieComposition r100 = this.f24725b;
        if (r100 != null) goto L6;
        return -1;
    L6:
        return (int) (r100.getBounds().height() * this.f24727d);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        LottieComposition r100 = this.f24725b;
        if (r100 != null) goto L6;
        return -1;
    L6:
        return (int) (r100.getBounds().width() * this.f24727d);
    }

    public final boolean h() {
        u0.c r100 = this.f24726c;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.f548108k;
    }

    public final void i() {
        t0.a r100 = this.f24741r;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.f544116f = this.f24733j;
        if (this.f24738o == null) goto L8;
        u0.f.d();
    L8:
        LottieComposition r101 = this.f24725b;
        if (r101 == null) goto L11;
        t0.a r102 = this.f24741r;
        r102.f544115e = r101.getNM();
    L11:
        com.airbnb.lottie.i.a().getClass();
        this.f24741r.getClass();
    }

    public final void j() {
        t0.a r100 = this.f24741r;
        if (r100 != null) goto L5;
    L29:
        this.f24742s = false;
        return;
    L5:
        if (this.f24742s == false) goto L29;
        System.currentTimeMillis();
        if (r100.f544111a == null) goto L10;
    L28:
        com.airbnb.lottie.i.a().getClass();
        com.airbnb.lottie.i.a().getClass();
        goto L29
    L10:
        if (TextUtils.isEmpty(r100.f544112b) == true) goto L13;
        r100.f544111a = r100.f544112b;
        goto L28
    L13:
        if (TextUtils.isEmpty(r100.f544113c) == true) goto L16;
        r100.f544111a = r100.f544113c;
        goto L28
    L16:
        if (TextUtils.isEmpty(r100.f544114d) == true) goto L19;
        r100.f544111a = r100.f544114d;
        goto L28
    L19:
        if (TextUtils.isEmpty(r100.f544116f) == true) goto L22;
        r100.f544111a = r100.f544116f;
        goto L28
    L22:
        if (TextUtils.isEmpty(r100.f544115e) == true) goto L25;
        r100.f544111a = r100.f544115e;
        goto L28
    L25:
        if (TextUtils.isEmpty(r100.a()) == true) goto L27;
        r100.f544111a = r100.a();
        goto L28
    L27:
        r100.f544111a = r100.f544118h;
        goto L28
    }

    public final void k() {
        int r100 = r0.c.f535396a;
        if (this.f24738o != null) goto L6;
        this.f24728e.add(new e(this));
        return;
    L6:
        u0.c r101 = this.f24726c;
        r101.f548108k = true;
        boolean r102 = r101.f();
        Iterator r103 = ((CopyOnWriteArraySet) r101.f548099b).iterator();
    L8:
        if (r103.hasNext() == false) goto L14;
        Animator.AnimatorListener r104 = (Animator.AnimatorListener) r103.next();
        if (Build.VERSION.SDK_INT >= 26) goto L11;
        r104.onAnimationStart(r101);
        goto L8
    L11:
        r104.onAnimationStart(r101, r102);
        goto L8
    L14:
        if (r101.f() == false) goto L16;
        float r105 = r101.d();
    L17:
        r101.h((int) r105);
        if (r0.c.a.f535397a == false) goto L20;
        r101.f548102e = 0;
    L21:
        r101.f548104g = 0;
        if (r101.f548108k == false) goto L31;
        r101.g(false);
        Choreographer.getInstance().postFrameCallback(r101);
        return;
    L31:
        return;
    L20:
        r101.f548102e = System.nanoTime();
        goto L21
    L16:
        r105 = r101.e();
        goto L17
    }

    public final void l() {
        int r100 = r0.c.f535396a;
        if (this.f24738o != null) goto L6;
        this.f24728e.add(new f(this));
        return;
    L6:
        u0.c r101 = this.f24726c;
        r101.f548108k = true;
        r101.g(false);
        Choreographer.getInstance().postFrameCallback(r101);
        if (r0.c.a.f535397a == false) goto L9;
        r101.f548102e = 0;
    L11:
        if (r101.f() == false) goto L16;
        if (r101.f548103f != r101.e()) goto L16;
        r101.f548103f = r101.d();
        return;
    L16:
        if (r101.f() == false) goto L18;
        return;
    L18:
        if (r101.f548103f != r101.d()) goto L23;
        r101.f548103f = r101.e();
        return;
    L23:
        return;
    L9:
        r101.f548102e = System.nanoTime();
        goto L11
    }

    public final void n() {
        u0.c r100 = this.f24726c;
        LottieComposition r101 = this.f24725b;
        if (r100.f548107j != null) goto L5;
        boolean r102 = true;
    L6:
        r100.f548107j = r101;
        if (r102 == false) goto L9;
        r100.i((int) Math.max(r100.f548105h, r101.getStartFrame()), (int) Math.min(r100.f548106i, r101.getEndFrame()));
    L10:
        r100.h((int) r100.f548103f);
        if (r0.c.a.f535397a == true) goto L13;
        r100.f548102e = System.nanoTime();
    L13:
        v(this.f24726c.getAnimatedFraction());
        this.f24727d = this.f24727d;
        x();
        x();
        Iterator r103 = new ArrayList(this.f24728e).iterator();
    L15:
        if (r103.hasNext() == false) goto L20;
        m r104 = (m) r103.next();
        if (r104 == null) goto L19;
        r104.run();
    L19:
        r103.remove();
        goto L15
    L20:
        this.f24728e.clear();
        this.f24725b.setPerformanceTrackingEnabled(this.f24740q);
        return;
    L9:
        r100.i((int) r101.getStartFrame(), (int) r101.getEndFrame());
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        if (r0.c.a.f535397a == false) goto L10;
        Drawable.Callback r100 = getCallback();
        if ((r100 instanceof View) == true) goto L7;
        return;
    L7:
        if (((View) r100).isInEditMode() == true) goto L13;
        k();
        return;
    L13:
        return;
    L10:
        k();
    }

    public final void x() {
        if (r0.c.a.f535397a == false) goto L5;
        return;
    L5:
        LottieComposition r100 = this.f24725b;
        if (r100 != null) goto L8;
        return;
    L8:
        float r101 = this.f24727d;
        setBounds(0, 0, (int) (r100.getBounds().width() * r101), (int) (this.f24725b.getBounds().height() * r101));
    }

    public LottieDrawable() {
        this.f24724a = new Matrix();
        u0.c r100 = new u0.c();
        this.f24726c = r100;
        this.f24727d = 1.0f;
        new HashSet();
        this.f24728e = new ArrayList();
        this.f24729f = false;
        this.f24730g = false;
        this.f24731h = true;
        this.f24739p = 255;
        this.f24741r = t0.a.f544110j;
        this.f24742s = true;
        d r101 = new d(this);
        this.f24743t = r101;
        this.f24744u = false;
        this.f24745v = new Object();
        r100.addUpdateListener(r101);
        int r102 = r0.c.f535396a;
    }

    private Context getContext() {
        Drawable.Callback r100 = getCallback();
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof View) == true) goto L8;
        return null;
    L8:
        return ((View) r100).getContext();
    }

    public final l0.b f() {
        if (getCallback() != null) goto L5;
        return null;
    L5:
        l0.b r100 = this.f24732i;
        if (r100 == null) goto L20;
        Context r101 = getContext();
        if (r101 == null) goto L10;
    L11:
        Context r102 = r100.f506839a;
        if (r102 != null) goto L14;
    L16:
        boolean r103 = false;
    L17:
        if (r103 == true) goto L20;
        this.f24732i = null;
        goto L20
    L14:
        if (r102.equals(r101) == false) goto L16;
    L15:
        r103 = true;
        goto L17
    L10:
        if (r100.f506839a == null) goto L15;
    L20:
        if (this.f24732i != null) goto L23;
        r0.c.b.a(getContext());
        this.f24732i = new l0.b(getCallback(), this.f24733j, this.f24734k, this.f24725b.getImages());
    L23:
        return this.f24732i;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable.Callback r100 = getCallback();
        if (r0.c.a.f535397a == true) goto L8;
        if (r100 == null) goto L23;
        r100.invalidateDrawable(this);
        int r101 = r0.c.f535396a;
        return;
    L23:
        return;
    L8:
        if (this.f24729f == false) goto L10;
        return;
    L10:
        this.f24729f = true;
        if (r100 == null) goto L24;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L16;
        r100.invalidateDrawable(this);     // Catch: Throwable -> L19
        int r102 = r0.c.f535396a;     // Catch: Throwable -> L19
    L20:
        return;
    L16:
        if ((r100 instanceof View) == false) goto L20;
        ((View) r100).postInvalidate();     // Catch: Throwable -> L19
        int r103 = r0.c.f535396a;     // Catch: Throwable -> L19
    L25:
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return h();
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f24739p;
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        d();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        boolean r101 = false;
        this.f24729f = false;
        if (r0.c.a.f535397a == false) goto L88;
        Set<String> r102 = com.airbnb.lottie.f.f24776a;
        if (this.f24738o == null) goto L106;
        j();
        int r103 = -1;
        if (this.f24730g == true) goto L103;
        LottieComposition r104 = this.f24725b;
        if (r104 != null) goto L12;
    L18:
        r101 = true;
    L19:
        if (r101 == true) goto L36;
        if (this.f24738o == null) goto L87;
        Rect r105 = getBounds();
        float r106 = r105.width() / this.f24725b.getBounds().width();
        float r107 = r105.height() / this.f24725b.getBounds().height();
        if (this.f24731h == false) goto L32;
        float r108 = Math.min(r106, r107);
        if (r108 >= 1.0f) goto L28;
        float r109 = 1.0f / r108;
        r106 = r106 / r109;
        r107 = r107 / r109;
    L30:
        if (r109 <= 1.0f) goto L32;
        r103 = r100.save();
        float r110 = r105.width() / 2.0f;
        float r111 = r105.height() / 2.0f;
        float r112 = r110 * r108;
        float r113 = r108 * r111;
        r100.translate(r110 - r112, r111 - r113);
        r100.scale(r109, r109, r112, r113);
        goto L32
    L28:
        r109 = 1.0f;
    L32:
        this.f24724a.reset();
        this.f24724a.preScale(r106, r107);
        this.f24738o.d(r100, this.f24724a, this.f24739p);
        if (r103 <= 0) goto L87;
        r100.restoreToCount(r103);
    L87:
        com.airbnb.lottie.f.a();
        return;
    L36:
        if (this.f24738o == null) goto L87;
        float r114 = this.f24727d;
        float r115 = g(r100);
        if (r114 <= r115) goto L41;
        float r116 = this.f24727d / r115;
    L43:
        if (r116 <= 1.0f) goto L45;
        r103 = r100.save();
        float r117 = this.f24725b.getBounds().width() / 2.0f;
        float r118 = this.f24725b.getBounds().height() / 2.0f;
        float r119 = r117 * r115;
        float r120 = r118 * r115;
        float r121 = this.f24727d;
        r100.translate((r117 * r121) - r119, (r121 * r118) - r120);
        r100.scale(r116, r116, r119, r120);
    L45:
        this.f24724a.reset();
        this.f24724a.preScale(r115, r115);
        this.f24738o.d(r100, this.f24724a, this.f24739p);
        if (r103 <= 0) goto L87;
        r100.restoreToCount(r103);
        goto L87
    L41:
        r115 = r114;
        r116 = 1.0f;
        goto L43
    L12:
        if (getBounds().isEmpty() == true) goto L18;
        if (r104.getBounds().isEmpty() == true) goto L18;
        Rect r122 = getBounds();
        float r123 = r122.width() / r122.height();
        Rect r124 = r104.getBounds();
        if (r123 != (r124.width() / r124.height())) goto L19;
    L103:
        LottieComposition r125 = this.f24725b;     // Catch: Throwable -> L102
        if (r125 != null) goto L51;
    L57:
        r101 = true;
    L58:
        if (r101 == true) goto L75;
        if (this.f24738o == null) goto L87;
        Rect r126 = getBounds();     // Catch: Throwable -> L102
        float r127 = r126.width() / this.f24725b.getBounds().width();     // Catch: Throwable -> L102
        float r128 = r126.height() / this.f24725b.getBounds().height();     // Catch: Throwable -> L102
        if (this.f24731h == false) goto L71;
        float r129 = Math.min(r127, r128);     // Catch: Throwable -> L102
        if (r129 >= 1.0f) goto L67;
        float r130 = 1.0f / r129;     // Catch: Throwable -> L102
        r127 = r127 / r130;     // Catch: Throwable -> L102
        r128 = r128 / r130;     // Catch: Throwable -> L102
    L69:
        if (r130 <= 1.0f) goto L71;
        r103 = r100.save();     // Catch: Throwable -> L102
        float r131 = r126.width() / 2.0f;     // Catch: Throwable -> L102
        float r132 = r126.height() / 2.0f;     // Catch: Throwable -> L102
        float r133 = r131 * r129;     // Catch: Throwable -> L102
        float r134 = r129 * r132;     // Catch: Throwable -> L102
        r100.translate(r131 - r133, r132 - r134);     // Catch: Throwable -> L102
        r100.scale(r130, r130, r133, r134);     // Catch: Throwable -> L102
        goto L71
    L67:
        r130 = 1.0f;
    L71:
        this.f24724a.reset();     // Catch: Throwable -> L102
        this.f24724a.preScale(r127, r128);     // Catch: Throwable -> L102
        this.f24738o.d(r100, this.f24724a, this.f24739p);     // Catch: Throwable -> L102
        if (r103 <= 0) goto L87;
        r100.restoreToCount(r103);     // Catch: Throwable -> L102
        goto L87
    L75:
        if (this.f24738o == null) goto L87;
        float r135 = this.f24727d;     // Catch: Throwable -> L102
        float r136 = g(r100);     // Catch: Throwable -> L102
        if (r135 <= r136) goto L80;
        float r137 = this.f24727d / r136;     // Catch: Throwable -> L102
    L82:
        if (r137 <= 1.0f) goto L84;
        r103 = r100.save();     // Catch: Throwable -> L102
        float r138 = this.f24725b.getBounds().width() / 2.0f;     // Catch: Throwable -> L102
        float r139 = this.f24725b.getBounds().height() / 2.0f;     // Catch: Throwable -> L102
        float r140 = r138 * r136;     // Catch: Throwable -> L102
        float r141 = r139 * r136;     // Catch: Throwable -> L102
        float r142 = this.f24727d;     // Catch: Throwable -> L102
        r100.translate((r138 * r142) - r140, (r142 * r139) - r141);     // Catch: Throwable -> L102
        r100.scale(r137, r137, r140, r141);     // Catch: Throwable -> L102
    L84:
        this.f24724a.reset();     // Catch: Throwable -> L102
        this.f24724a.preScale(r136, r136);     // Catch: Throwable -> L102
        this.f24738o.d(r100, this.f24724a, this.f24739p);     // Catch: Throwable -> L102
        if (r103 <= 0) goto L87;
        r100.restoreToCount(r103);     // Catch: Throwable -> L102
        goto L87
    L80:
        r136 = r135;
        r137 = 1.0f;
        goto L82
    L51:
        if (getBounds().isEmpty() == true) goto L57;
        if (r125.getBounds().isEmpty() == true) goto L57;
        Rect r143 = getBounds();     // Catch: Throwable -> L102
        float r144 = r143.width() / r143.height();     // Catch: Throwable -> L102
        Rect r145 = r125.getBounds();     // Catch: Throwable -> L102
        if (r144 != (r145.width() / r145.height())) goto L58;
    L106:
        return;
    L88:
        Set<String> r146 = com.airbnb.lottie.f.f24776a;
        if (this.f24738o == null) goto L107;
        j();
        float r147 = this.f24727d;
        float r148 = g(r100);
        if (r147 <= r148) goto L94;
        float r149 = this.f24727d / r148;
    L96:
        if (r149 <= 1.0f) goto L98;
        r100.save();
        float r150 = this.f24725b.getBounds().width() / 2.0f;
        float r151 = this.f24725b.getBounds().height() / 2.0f;
        float r152 = r150 * r148;
        float r153 = r151 * r148;
        float r154 = this.f24727d;
        r100.translate((r150 * r154) - r152, (r154 * r151) - r153);
        r100.scale(r149, r149, r152, r153);
    L98:
        this.f24724a.reset();
        this.f24724a.preScale(r148, r148);
        this.f24738o.d(r100, this.f24724a, this.f24739p);
        com.airbnb.lottie.f.a();
        if (r149 <= 1.0f) goto L105;
        r100.restore();
        return;
    L105:
        return;
    L94:
        r148 = r147;
        r149 = 1.0f;
        goto L96
    }

    public final Bitmap e(String r100) {
        l0.b r101 = f();
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r0.c.a.f535397a == false) goto L25;
        return r101.a(r100);
    L8:
        e = move-exception;
        Drawable.Callback r102 = getCallback();
        if (r102 != null) goto L12;
    L14:
        String r103 = null;
    L16:
        if (this.f24730g == true) goto L23;
        if (r0.c.a.f535397a == false) goto L21;
        int r104 = r0.c.f535396a;
        goto L23
    L21:
        throw new IllegalStateException("animName:" + r103 + " message:" + e.getMessage());
    L23:
        return null;
    L12:
        if ((r102 instanceof LottieAnimationView) == false) goto L14;
        r103 = ((LottieAnimationView) r102).getAnimationName();
        goto L16
    L25:
        return r101.a(r100);
    }

    public final float g(Canvas r100) {
        return Math.min(r100.getWidth() / this.f24725b.getBounds().width(), r100.getHeight() / this.f24725b.getBounds().height());
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        Drawable.Callback r101 = getCallback();
        if (r101 != null) goto L5;
        return;
    L5:
        r101.invalidateDrawable(this);
    }

    public final boolean m(LottieComposition r100) {
        int r101 = r0.c.f535396a;
        if (this.f24725b != r100) goto L6;
        return false;
    L6:
        if (r0.c.a.f535397a == false) goto L8;
        this.f24729f = false;
    L8:
        u0.c r102 = this.f24726c;
        if (r102.f548108k == false) goto L11;
        r102.cancel();
    L11:
        this.f24725b = null;
        this.f24738o = null;
        this.f24732i = null;
        u0.c r103 = this.f24726c;
        r103.f548107j = null;
        r103.f548105h = -2.1474836E9f;
        r103.f548106i = 2.1474836E9f;
        invalidateSelf();
        this.f24725b = r100;
        if (r100 == null) goto L19;
        String r104 = this.f24733j;
        if (r104 == null) goto L16;
        r100.errorReportResId = r104;
    L16:
        com.airbnb.lottie.d r105 = this.f24734k;
        if (r105 == null) goto L19;
        r100.errorReportResId = r105.getClass().getName();
    L19:
        b();
        n();
        return true;
    }

    public final void o(int r100) {
        if (this.f24725b != null) goto L6;
        this.f24728e.add(new a(this, r100));
        return;
    L6:
        this.f24726c.h(r100);
    }

    public final void p(int r100) {
        if (this.f24725b != null) goto L6;
        this.f24728e.add(new i(this, r100));
        return;
    L6:
        u0.c r101 = this.f24726c;
        r101.i((int) r101.f548105h, r100);
    }

    public final void q(float r100) {
        LottieComposition r101 = this.f24725b;
        if (r101 != null) goto L6;
        this.f24728e.add(new j(this, r100));
        return;
    L6:
        float r102 = r101.getStartFrame();
        float r103 = this.f24725b.getEndFrame();
        u0.e.a r104 = u0.e.f548111a;
        p((int) (r102 + (r100 * (r103 - r102))));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f24739p = r100;
        if (r0.c.a.f535397a == false) goto L6;
        invalidateSelf();
        return;
    }

    public final void t(int r100) {
        if (this.f24725b != null) goto L6;
        this.f24728e.add(new g(this, r100));
        return;
    L6:
        u0.c r101 = this.f24726c;
        r101.i(r100, (int) r101.f548106i);
    }

    public final void u(float r100) {
        LottieComposition r101 = this.f24725b;
        if (r101 != null) goto L6;
        this.f24728e.add(new h(this, r100));
        return;
    L6:
        float r102 = r101.getStartFrame();
        float r103 = this.f24725b.getEndFrame();
        u0.e.a r104 = u0.e.f548111a;
        t((int) (r102 + (r100 * (r103 - r102))));
    }

    public final void v(float r100) {
        LottieComposition r101 = this.f24725b;
        if (r101 != null) goto L6;
        this.f24728e.add(new b(this, r100));
        return;
    L6:
        float r102 = r101.getStartFrame();
        float r103 = this.f24725b.getEndFrame();
        u0.e.a r104 = u0.e.f548111a;
        o((int) (r102 + (r100 * (r103 - r102))));
    }

    public final void w(int r100) {
        this.f24726c.setRepeatCount(r100);
    }

    public final void r(int r100, int r101) {
        if (this.f24725b != null) goto L6;
        this.f24728e.add(new k(this, r100, r101));
        return;
    L6:
        this.f24726c.i(r100, r101);
    }

    public final void s(float r100, float r101) {
        LottieComposition r102 = this.f24725b;
        if (r102 != null) goto L6;
        this.f24728e.add(new l(this, r100, r101));
        return;
    L6:
        float r103 = r102.getStartFrame();
        float r104 = this.f24725b.getEndFrame();
        u0.e.a r105 = u0.e.f548111a;
        int r106 = (int) (r103 + (r100 * (r104 - r103)));
        float r107 = this.f24725b.getStartFrame();
        r(r106, (int) (r107 + (r101 * (this.f24725b.getEndFrame() - r107))));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable r100, Runnable r101) {
        Drawable.Callback r102 = getCallback();
        if (r102 != null) goto L5;
        return;
    L5:
        r102.unscheduleDrawable(this, r101);
    }

    public final <T> void a(m0.e r100, T r101, v0.c<T> r102) {
        com.airbnb.lottie.model.layer.b r103 = this.f24738o;
        if (r103 != null) goto L6;
        this.f24728e.add(new c(this, r100, r101, r102));
        return;
    L6:
        m0.f r104 = r100.f511471b;
        boolean r105 = true;
        if (r104 == null) goto L9;
        r104.g(r101, r102);
    L17:
        if (r105 == false) goto L24;
        invalidateSelf();
        if (r101 != com.airbnb.lottie.k.A) goto L25;
        v(this.f24726c.c());
        return;
    L25:
        return;
    L24:
        return;
    L9:
        int r106 = 0;
        if (r103 != null) goto L12;
        List r107 = Collections.emptyList();
    L14:
        if (r106 >= r107.size()) goto L16;
        ((m0.e) ListProtector.get(r107, r106)).f511471b.g(r101, r102);
        r106 = r106 + 1;
        goto L14
    L16:
        r105 = true ^ r107.isEmpty();
        goto L17
    L12:
        ArrayList r108 = new ArrayList();
        this.f24738o.f(r100, 0, r108, new m0.e(new String[0]));
        r107 = r108;
        goto L14
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable r100, Runnable r101, long r102) {
        Drawable.Callback r103 = getCallback();
        if (r103 != null) goto L5;
        return;
    L5:
        r103.scheduleDrawable(this, r101, r102);
    }
}
