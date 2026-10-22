package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import i0.e;
import j0.c;
import j0.g;
import j0.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import m0.f;
import n0.l;
import u0.d;

/* JADX INFO: loaded from: classes28.dex */
public abstract class a implements e, j0.a.InterfaceC6374a, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f24887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Matrix f24888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f24889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f24890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f24891e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f24892f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f24893g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f24894h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f24895i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RectF f24896j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RectF f24897k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Matrix f24898l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LottieDrawable f24899m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Layer f24900n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final g f24901o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c f24902p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a f24903q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a f24904r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List<a> f24905s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List<j0.a<?, ?>> f24906t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final o f24907u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f24908v;

    /* JADX INFO: renamed from: com.airbnb.lottie.model.layer.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0475a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24909a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f24910b = null;

        static {
            int[] r100 = new int[Mask.MaskMode.values().length];
            f24910b = r100;
            r100[Mask.MaskMode.MaskModeSubtract.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            f24910b[Mask.MaskMode.MaskModeIntersect.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L35:
            f24910b[Mask.MaskMode.MaskModeAdd.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L8:
            int[] r101 = new int[Layer.LayerType.values().length];
            f24909a = r101;
            r101[Layer.LayerType.Shape.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L45:
            f24909a[Layer.LayerType.PreComp.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L27:
            f24909a[Layer.LayerType.Solid.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L33:
            f24909a[Layer.LayerType.Image.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L43:
            f24909a[Layer.LayerType.Null.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L31:
            f24909a[Layer.LayerType.Text.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L37:
            f24909a[Layer.LayerType.Unknown.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
            return;
        }
    }

    @Override // i0.c
    public final void b(List<i0.c> r100, List<i0.c> r101) {
    }

    public abstract void k(Canvas r100, Matrix r101, int r102);

    public void p(m0.e r100, int r101, List<m0.e> r102, m0.e r103) {
    }

    @Override // j0.a.InterfaceC6374a
    public final void a() {
        this.f24899m.invalidateSelf();
    }

    @Override // i0.c
    public final String getName() {
        return this.f24900n.f24866c;
    }

    public final void i() {
        if (this.f24905s == null) goto L6;
        return;
    L6:
        if (this.f24904r != null) goto L9;
        this.f24905s = Collections.emptyList();
        return;
    L9:
        this.f24905s = new ArrayList();
        a r100 = this.f24904r;
    L10:
        if (r100 == null) goto L12;
        this.f24905s.add(r100);
        r100 = r100.f24904r;
        goto L10
    }

    public final boolean m() {
        g r100 = this.f24901o;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (((ArrayList) r100.f496762a).isEmpty() == true) goto L7;
        return true;
    }

    public final void o() {
        n r100 = this.f24899m.f24725b.getPerformanceTracker();
        String r101 = this.f24900n.f24866c;
        boolean r102 = r100.f24917b;
        if (r102 == true) goto L8;
        if (r100.f24916a == true) goto L8;
        return;
    L8:
        if (r100.f24916a == false) goto L10;
        if (r102 == true) goto L10;
    L17:
        if (r101.equals("__container") == false) goto L22;
        Iterator<E> r103 = r100.f24918c.iterator();
    L20:
        if (r103.hasNext() == false) goto L25;
        ((n.a) r103.next()).a();
        goto L20
    L25:
        return;
    L22:
        return;
    L10:
        d r104 = (d) ((HashMap) r100.f24919d).get(r101);
        if (r104 != null) goto L13;
        r104 = new d();
        ((HashMap) r100.f24919d).put(r101, r104);
    L13:
        int r105 = r104.f548110a + 1;
        r104.f548110a = r105;
        if (r105 != Integer.MAX_VALUE) goto L17;
        r104.f548110a = r105 / 2;
        goto L17
    }

    public final void e(j0.a<?, ?> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f24906t.add(r100);
    }

    public final void j(Canvas r110) {
        Set<String> r100 = com.airbnb.lottie.f.f24776a;
        RectF r101 = this.f24894h;
        r110.drawRect(r101.left - 1.0f, r101.top - 1.0f, r101.right + 1.0f, r101.bottom + 1.0f, this.f24893g);
        com.airbnb.lottie.f.a();
    }

    public void r(float r100) {
        o r101 = this.f24907u;
        r101.f496779b.j(r100);
        r101.f496780c.j(r100);
        r101.f496781d.j(r100);
        r101.f496782e.j(r100);
        r101.f496783f.j(r100);
        c r102 = r101.f496784g;
        if (r102 == null) goto L5;
        r102.j(r100);
    L5:
        c r103 = r101.f496785h;
        if (r103 == null) goto L8;
        r103.j(r100);
    L8:
        int r104 = 0;
        if (this.f24901o == null) goto L14;
        int r105 = 0;
    L12:
        if (r105 >= ((ArrayList) this.f24901o.f496762a).size()) goto L14;
        ((j0.a) ListProtector.get(this.f24901o.f496762a, r105)).j(r100);
        r105 = r105 + 1;
    L14:
        float r106 = this.f24900n.f24876m;
        if (r106 == 0.0f) goto L18;
        r100 = r100 / r106;
    L18:
        if (r0.c.a.f535397a == false) goto L22;
        c r107 = this.f24902p;
        if (r107 == null) goto L22;
        r107.j(r100 / r106);
    L22:
        a r108 = this.f24903q;
        if (r108 == null) goto L26;
        r108.r(r108.f24900n.f24876m * r100);
    L26:
        if (r104 >= ((ArrayList) this.f24906t).size()) goto L28;
        ((j0.a) ListProtector.get(this.f24906t, r104)).j(r100);
        r104 = r104 + 1;
        goto L26
    }

    public a(LottieDrawable r100, Layer r101) {
        this.f24887a = new Path();
        this.f24888b = new Matrix();
        this.f24894h = new RectF();
        this.f24895i = new RectF();
        this.f24896j = new RectF();
        this.f24897k = new RectF();
        this.f24898l = new Matrix();
        this.f24906t = new ArrayList();
        boolean r102 = true;
        this.f24908v = true;
        if (r0.c.a.f535397a == false) goto L5;
        this.f24889c = new h0.a(1);
        this.f24890d = new h0.a(PorterDuff.Mode.DST_IN, 0);
        this.f24891e = new h0.a(PorterDuff.Mode.DST_OUT, 0);
        this.f24892f = new h0.a(1);
        this.f24893g = new h0.a(PorterDuff.Mode.CLEAR);
    L6:
        this.f24899m = r100;
        this.f24900n = r101;
        StringBuilder r103 = new StringBuilder();
        r103.append(r101.f24866c);
        r103.append("#draw");
        if (r101.f24884u != Layer.MatteType.Invert) goto L9;
        this.f24892f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    L10:
        l r104 = r101.f24872i;
        r104.getClass();
        o r105 = new o(r104);
        this.f24907u = r105;
        r105.b(this);
        List<Mask> r106 = r101.f24871h;
        if (r106 == null) goto L23;
        if (r106.isEmpty() == true) goto L23;
        g r107 = new g(r101.f24871h);
        this.f24901o = r107;
        Iterator r108 = ((ArrayList) r107.f496762a).iterator();
    L16:
        if (r108.hasNext() == false) goto L18;
        ((j0.a) r108.next()).a(this);
        goto L16
    L18:
        Iterator r109 = ((ArrayList) this.f24901o.f496763b).iterator();
    L20:
        if (r109.hasNext() == false) goto L23;
        j0.a<?, ?> r110 = (j0.a) r109.next();
        e(r110);
        r110.a(this);
    L23:
        if (this.f24900n.f24883t.isEmpty() == true) goto L33;
        c r111 = new c(this.f24900n.f24883t);
        this.f24902p = r111;
        r111.f496746b = true;
        r111.a(new p0.a(this));
        if (this.f24902p.g().floatValue() == 1.0f) goto L29;
        r102 = false;
    L29:
        if (r102 == this.f24908v) goto L31;
        this.f24908v = r102;
        this.f24899m.invalidateSelf();
    L31:
        e(this.f24902p);
        return;
    L33:
        if (true == this.f24908v) goto L39;
        this.f24908v = true;
        this.f24899m.invalidateSelf();
        return;
    L39:
        return;
    L9:
        this.f24892f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        goto L10
    L5:
        this.f24889c = new Paint(1);
        Paint r112 = new Paint(1);
        this.f24890d = r112;
        Paint r113 = new Paint(1);
        this.f24891e = r113;
        this.f24892f = new Paint(1);
        Paint r114 = new Paint();
        this.f24893g = r114;
        r114.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        r112.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        r113.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        goto L6
    }

    @Override // i0.e
    public void c(RectF r100, Matrix r101) {
        if (r0.c.a.f535397a == false) goto L5;
        this.f24894h.set(0.0f, 0.0f, 0.0f, 0.0f);
        i();
    L5:
        this.f24898l.set(r101);
        this.f24898l.preConcat(this.f24907u.d());
    }

    @Override // m0.f
    public <T> void g(T r100, v0.c<T> r101) {
        this.f24907u.c(r100, r101);
    }

    public void l(RectF r100, Matrix r101) {
        this.f24894h.set(0.0f, 0.0f, 0.0f, 0.0f);
        i();
        this.f24898l.set(r101);
        List<a> r102 = this.f24905s;
        if (r102 == null) goto L8;
        int r103 = r102.size();
    L5:
        r103 = r103 - 1;
        if (r103 < 0) goto L11;
        this.f24898l.preConcat(((a) ListProtector.get(this.f24905s, r103)).f24907u.d());
    L11:
        this.f24898l.preConcat(this.f24907u.d());
        return;
    L8:
        a r104 = this.f24904r;
        if (r104 == null) goto L11;
        this.f24898l.preConcat(r104.f24907u.d());
        goto L11
    }

    public final void n(RectF r100, Matrix r101) {
        a r102 = this.f24903q;
        if (r102 == null) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L9;
        return;
    L9:
        if (this.f24900n.f24884u != Layer.MatteType.Invert) goto L12;
        return;
    L12:
        if (r0.c.a.f535397a == false) goto L17;
        this.f24896j.set(0.0f, 0.0f, 0.0f, 0.0f);
        this.f24903q.l(this.f24896j, r101);
        if (r100.intersect(this.f24896j) == true) goto L19;
        r100.set(0.0f, 0.0f, 0.0f, 0.0f);
        return;
    L19:
        return;
    L17:
        r102.c(this.f24896j, r101);
        r100.set(Math.max(r100.left, this.f24896j.left), Math.max(r100.top, this.f24896j.top), Math.min(r100.right, this.f24896j.right), Math.min(r100.bottom, this.f24896j.bottom));
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // i0.e
    public final void d(Canvas r110, Matrix r111, int r112) {
        Set<String> r100 = com.airbnb.lottie.f.f24776a;
        if (this.f24908v == true) goto L6;
        com.airbnb.lottie.f.a();
        return;
    L6:
        i();
        this.f24888b.reset();
        this.f24888b.set(r111);
        boolean r101 = true;
        int r102 = this.f24905s.size() - 1;
    L7:
        if (r102 < 0) goto L9;
        this.f24888b.preConcat(((a) ListProtector.get(this.f24905s, r102)).f24907u.d());
        r102 = r102 - 1;
        goto L7
    L9:
        com.airbnb.lottie.f.a();
        int r103 = (int) ((((r112 / 255.0f) * this.f24907u.f496783f.g().intValue()) / 100.0f) * 255.0f);
        boolean r104 = false;
        if (this.f24903q == null) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L15;
    L18:
        this.f24894h.set(0.0f, 0.0f, 0.0f, 0.0f);
        c(this.f24894h, this.f24888b);
        if (r0.c.a.f535397a == false) goto L21;
        n(this.f24894h, r111);
    L22:
        this.f24888b.preConcat(this.f24907u.d());
        RectF r106 = this.f24894h;
        Matrix r107 = this.f24888b;
        this.f24895i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (m() == false) goto L43;
        int r108 = this.f24901o.f496764c.size();
        int r113 = 0;
    L26:
        if (r113 >= r108) goto L37;
        Mask r114 = (Mask) ListProtector.get(this.f24901o.f496764c, r113);
        this.f24887a.set((Path) ((j0.a) ListProtector.get(this.f24901o.f496762a, r113)).g());
        this.f24887a.transform(r107);
        int r115 = C0475a.f24910b[r114.f24818a.ordinal()];
        if (r115 == 1) goto L43;
        if (r115 == 2) goto L43;
        this.f24887a.computeBounds(this.f24897k, r104);
        if (r113 != 0) goto L34;
        this.f24895i.set(this.f24897k);
    L35:
        r113 = r113 + 1;
        r104 = false;
        goto L26
    L34:
        RectF r116 = this.f24895i;
        r116.set(Math.min(r116.left, this.f24897k.left), Math.min(this.f24895i.top, this.f24897k.top), Math.max(this.f24895i.right, this.f24897k.right), Math.max(this.f24895i.bottom, this.f24897k.bottom));
        goto L35
    L37:
        if (r0.c.a.f535397a == true) goto L39;
        r106.set(Math.max(r106.left, this.f24895i.left), Math.max(r106.top, this.f24895i.top), Math.min(r106.right, this.f24895i.right), Math.min(r106.bottom, this.f24895i.bottom));
        goto L43
    L39:
        if (r106.intersect(this.f24895i) == true) goto L43;
        r106.set(0.0f, 0.0f, 0.0f, 0.0f);
    L43:
        if (r0.c.a.f535397a == true) goto L45;
        this.f24894h.set(0.0f, 0.0f, r110.getWidth(), r110.getHeight());
    L48:
        com.airbnb.lottie.f.a();
        if (r0.c.a.f535397a == true) goto L51;
    L58:
        q(r110, this.f24894h, this.f24889c, true);
        com.airbnb.lottie.f.a();
        j(r110);
        k(r110, this.f24888b, r103);
        com.airbnb.lottie.f.a();
        if (m() == false) goto L62;
        Matrix r109 = this.f24888b;
        h(r110, r109, Mask.MaskMode.MaskModeAdd);
        h(r110, r109, Mask.MaskMode.MaskModeIntersect);
        h(r110, r109, Mask.MaskMode.MaskModeSubtract);
    L62:
        if (this.f24903q != null) goto L65;
        r101 = false;
    L65:
        if (r101 == false) goto L67;
        q(r110, this.f24894h, this.f24892f, false);
        com.airbnb.lottie.f.a();
        j(r110);
        this.f24903q.d(r110, r111, r103);
        r110.restore();
        com.airbnb.lottie.f.a();
        com.airbnb.lottie.f.a();
    L67:
        r110.restore();
        com.airbnb.lottie.f.a();
        com.airbnb.lottie.f.a();
        o();
        return;
    L51:
        if (this.f24894h.width() >= 1.0f) goto L53;
    L56:
        com.airbnb.lottie.f.a();
        o();
        return;
    L53:
        if (this.f24894h.height() < 1.0f) goto L56;
        this.f24889c.setAlpha(255);
        goto L58
    L45:
        if (this.f24894h.intersect(0.0f, 0.0f, r110.getWidth(), r110.getHeight()) == true) goto L48;
        this.f24894h.set(0.0f, 0.0f, 0.0f, 0.0f);
        goto L48
    L21:
        n(this.f24894h, this.f24888b);
        goto L22
    L15:
        if (m() == true) goto L18;
        this.f24888b.preConcat(this.f24907u.d());
        k(r110, this.f24888b, r103);
        com.airbnb.lottie.f.a();
        com.airbnb.lottie.f.a();
        o();
        return;
    L12:
        r105 = false;
        goto L13
    }

    public final void h(Canvas r100, Matrix r101, Mask.MaskMode r102) {
        boolean r103 = true;
        if (C0475a.f24910b[r102.ordinal()] == 1) goto L5;
        Paint r104 = this.f24890d;
    L6:
        int r105 = this.f24901o.f496764c.size();
        int r106 = 0;
        int r107 = 0;
    L7:
        if (r107 >= r105) goto L12;
        if (((Mask) ListProtector.get(this.f24901o.f496764c, r107)).f24818a == r102) goto L13;
        r107 = r107 + 1;
    L13:
        if (r103 == true) goto L15;
        return;
    L15:
        Set<String> r108 = com.airbnb.lottie.f.f24776a;
        q(r100, this.f24894h, r104, false);
        com.airbnb.lottie.f.a();
        j(r100);
    L16:
        if (r106 >= r105) goto L22;
        if (((Mask) ListProtector.get(this.f24901o.f496764c, r106)).f24818a != r102) goto L21;
        this.f24887a.set((Path) ((j0.a) ListProtector.get(this.f24901o.f496762a, r106)).g());
        this.f24887a.transform(r101);
        j0.a r109 = (j0.a) ListProtector.get(this.f24901o.f496763b, r106);
        int r110 = this.f24889c.getAlpha();
        this.f24889c.setAlpha((int) (((Integer) r109.g()).intValue() * 2.55f));
        r100.drawPath(this.f24887a, this.f24889c);
        this.f24889c.setAlpha(r110);
    L21:
        r106 = r106 + 1;
        goto L16
    L22:
        Set<String> r111 = com.airbnb.lottie.f.f24776a;
        r100.restore();
        com.airbnb.lottie.f.a();
        com.airbnb.lottie.f.a();
        return;
    L12:
        r103 = false;
        goto L13
    L5:
        r104 = this.f24891e;
        goto L6
    }

    public static void q(Canvas r100, RectF r101, Paint r102, boolean r103) {
        if (Build.VERSION.SDK_INT >= 23) goto L8;
        if (r103 == false) goto L6;
        int r104 = 31;
    L7:
        r100.saveLayer(r101, r102, r104);
        return;
    L6:
        r104 = 19;
        goto L7
    L8:
        r100.saveLayer(r101, r102);
    }

    @Override // m0.f
    public final void f(m0.e r100, int r101, List<m0.e> r102, m0.e r103) {
        if (r100.c(this.f24900n.f24866c, r101) == true) goto L6;
        return;
    L6:
        if ("__container".equals(this.f24900n.f24866c) == true) goto L12;
        String r104 = this.f24900n.f24866c;
        r103.getClass();
        m0.e r105 = new m0.e(r103);
        r105.f511470a.add(r104);
        if (r100.a(this.f24900n.f24866c, r101) == false) goto L10;
        m0.e r106 = new m0.e(r105);
        r106.f511471b = this;
        ((ArrayList) r102).add(r106);
    L10:
        r103 = r105;
    L12:
        if (r100.d(this.f24900n.f24866c, r101) == false) goto L15;
        p(r100, r101 + r100.b(this.f24900n.f24866c, r101), r102, r103);
        return;
    }
}
