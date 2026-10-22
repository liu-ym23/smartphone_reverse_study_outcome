package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: CollapsingTextHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String TAG = "CollapsingTextHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f13436a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Paint f13437b = null;
    private Typeface A;
    private Typeface B;
    private Typeface C;
    private Typeface D;
    private Typeface E;
    private Typeface F;
    private com.google.android.material.g.a G;
    private com.google.android.material.g.a H;
    private CharSequence I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private CharSequence f13438J;
    private boolean K;
    private boolean L;
    private boolean M;
    private Bitmap N;
    private Paint O;
    private float P;
    private float Q;
    private float R;
    private float S;
    private float T;
    private int U;
    private int[] V;
    private boolean W;
    private final TextPaint X;
    private final TextPaint Y;
    private TimeInterpolator Z;
    private TimeInterpolator aa;
    private float ab;
    private float ac;
    private float ad;
    private ColorStateList ae;
    private float af;
    private float ag;
    private float ah;
    private ColorStateList ai;
    private float aj;
    private float ak;
    private float al;
    private StaticLayout am;
    private float an;
    private float ao;
    private float ap;
    private CharSequence aq;
    private int ar;
    private float as;
    private float at;
    private int au;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f13439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f13440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f13441e;
    private boolean f;
    private float g;
    private float h;
    private int i;
    private final Rect j;
    private final Rect k;
    private final RectF l;
    private int m;
    private int n;
    private float o;
    private float p;
    private ColorStateList q;
    private ColorStateList r;
    private int s;
    private float t;
    private float u;
    private float v;
    private float w;
    private float x;
    private float y;
    private Typeface z;

    static {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        boolean r0 = true;
    L6:
        f13436a = r0;
        Paint r1 = null;
        f13437b = null;
        if (0 == 0) goto L10;
        r1.setAntiAlias(true);
        r1.setColor(-65281);
        return;
    L10:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public b(View r3) {
        this.m = 16;
        this.n = 16;
        this.o = 15.0f;
        this.p = 15.0f;
        this.L = true;
        this.ar = 1;
        this.as = 0.0f;
        this.at = 1.0f;
        this.au = i.f13466a;
        this.f13439c = r3;
        TextPaint r0 = new TextPaint(129);
        this.X = r0;
        this.Y = new TextPaint(r0);
        this.k = new Rect();
        this.j = new Rect();
        this.l = new RectF();
        this.h = x();
        a(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration());
    }

    public void a(TimeInterpolator r3) {
        this.aa = (TimeInterpolator) ZeusTransformUtils.wrapperContextForParams(r3, TimeInterpolator.class, "com.obric.aiagent.plugin");
        o();
    }

    public void b(TimeInterpolator r3) {
        this.Z = (TimeInterpolator) ZeusTransformUtils.wrapperContextForParams(r3, TimeInterpolator.class, "com.obric.aiagent.plugin");
        o();
    }

    public TimeInterpolator a() {
        return this.Z;
    }

    public void a(float r2) {
        if (this.o == r2) goto L6;
        this.o = r2;
        o();
        return;
    }

    public void a(ColorStateList r2) {
        if (this.r == r2) goto L6;
        this.r = r2;
        o();
        return;
    }

    public void b(ColorStateList r2) {
        if (this.q == r2) goto L6;
        this.q = r2;
        o();
        return;
    }

    public void b(float r2) {
        if (this.ak == r2) goto L6;
        this.ak = r2;
        o();
        return;
    }

    public void a(int r2, int r3, int r4, int r5) {
        if (a(this.j, r2, r3, r4, r5) == true) goto L6;
        this.j.set(r2, r3, r4, r5);
        this.W = true;
        e();
        return;
    }

    public void a(Rect r4) {
        a(r4.left, r4.top, r4.right, r4.bottom);
    }

    public void b(int r2, int r3, int r4, int r5) {
        if (a(this.k, r2, r3, r4, r5) == true) goto L6;
        this.k.set(r2, r3, r4, r5);
        this.W = true;
        e();
        return;
    }

    public void b(Rect r4) {
        b(r4.left, r4.top, r4.right, r4.bottom);
    }

    public void a(RectF r2, int r3, int r4) {
        this.K = b(this.I);
        r2.left = a(r3, r4);
        r2.top = this.k.top;
        r2.right = b(r2, r3, r4);
        r2.bottom = this.k.top + d();
    }

    private float a(int r3, int r4) {
        if (r4 == 17) goto L23;
        if ((r4 & 7) == 1) goto L23;
        if ((r4 & 8388613) == 8388613) goto L18;
        if ((r4 & 5) == 5) goto L18;
        if (this.K == false) goto L16;
        return this.k.right - this.an;
    L16:
        return this.k.left;
    L18:
        if (this.K == false) goto L21;
        return this.k.left;
    L21:
        return this.k.right - this.an;
    L23:
        return (r3 / 2.0f) - (this.an / 2.0f);
    }

    private float b(RectF r3, int r4, int r5) {
        if (r5 == 17) goto L23;
        if ((r5 & 7) == 1) goto L23;
        if ((r5 & 8388613) == 8388613) goto L18;
        if ((r5 & 5) == 5) goto L18;
        if (this.K == false) goto L16;
        return this.k.right;
    L16:
        return this.an + r3.left;
    L18:
        if (this.K == false) goto L21;
        return r3.left + this.an;
    L21:
        return this.k.right;
    L23:
        return (r4 / 2.0f) + (this.an / 2.0f);
    }

    public float b() {
        a(this.Y);
        return -this.Y.ascent();
    }

    public float c() {
        a(this.Y);
        return (-this.Y.ascent()) + this.Y.descent();
    }

    public float d() {
        b(this.Y);
        return -this.Y.ascent();
    }

    public void a(int r1) {
        this.i = r1;
    }

    public void c(float r1) {
        this.g = r1;
        this.h = x();
    }

    private float x() {
        float r2 = this.g;
        return r2 + ((1.0f - r2) * 0.5f);
    }

    public void a(boolean r1) {
        this.f = r1;
    }

    private void a(TextPaint r3) {
        r3.setTextSize(this.o);
        r3.setTypeface(this.C);
        if (Build.VERSION.SDK_INT < 21) goto L6;
        r3.setLetterSpacing(this.ak);
        return;
    }

    private void b(TextPaint r3) {
        r3.setTextSize(this.p);
        r3.setTypeface(this.z);
        if (Build.VERSION.SDK_INT < 21) goto L6;
        r3.setLetterSpacing(this.aj);
        return;
    }

    void e() {
        if (this.k.width() > 0) goto L5;
    L11:
        boolean r0 = false;
    L12:
        this.f13440d = r0;
        return;
    L5:
        if (this.k.height() <= 0) goto L11;
        if (this.j.width() <= 0) goto L11;
        if (this.j.height() <= 0) goto L11;
        r0 = true;
        goto L12
    }

    public void b(int r2) {
        if (this.m == r2) goto L6;
        this.m = r2;
        o();
        return;
    }

    public int f() {
        return this.m;
    }

    public void c(int r2) {
        if (this.n == r2) goto L6;
        this.n = r2;
        o();
        return;
    }

    public int g() {
        return this.n;
    }

    public void d(int r5) {
        com.google.android.material.g.d r0 = new com.google.android.material.g.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13439c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5);
        if (r0.b() == null) goto L6;
        this.r = r0.b();
    L6:
        if (r0.c() == 0.0f) goto L9;
        this.p = r0.c();
    L9:
        if (r0.f13411c == null) goto L11;
        this.ae = r0.f13411c;
    L11:
        this.ac = r0.h;
        this.ad = r0.i;
        this.ab = r0.j;
        this.aj = r0.l;
        com.google.android.material.g.a r6 = this.H;
        if (r6 == null) goto L14;
        r6.a();
    L14:
        this.H = new com.google.android.material.g.a(new AnonymousClass1(this), r0.a());
        r0.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13439c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.H);
        o();
    }

    public void e(int r5) {
        com.google.android.material.g.d r0 = new com.google.android.material.g.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13439c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5);
        if (r0.b() == null) goto L6;
        this.q = r0.b();
    L6:
        if (r0.c() == 0.0f) goto L9;
        this.o = r0.c();
    L9:
        if (r0.f13411c == null) goto L11;
        this.ai = r0.f13411c;
    L11:
        this.ag = r0.h;
        this.ah = r0.i;
        this.af = r0.j;
        this.ak = r0.l;
        com.google.android.material.g.a r6 = this.G;
        if (r6 == null) goto L14;
        r6.a();
    L14:
        this.G = new com.google.android.material.g.a(new AnonymousClass2(this), r0.a());
        r0.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13439c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this.G);
        o();
    }

    public void a(Typeface r1) {
        if (d(r1) == false) goto L6;
        o();
        return;
    }

    public void b(Typeface r1) {
        if (e(r1) == false) goto L6;
        o();
        return;
    }

    public void c(Typeface r2) {
        boolean r0 = d(r2);
        boolean r3 = e(r2);
        if (r0 == true) goto L5;
        if (r3 == true) goto L5;
        return;
    L5:
        o();
    }

    private boolean d(Typeface r4) {
        com.google.android.material.g.a r0 = this.H;
        if (r0 == null) goto L6;
        r0.a();
    L6:
        if (this.B == r4) goto L12;
        this.B = r4;
        Typeface r5 = com.google.android.material.g.g.a(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13439c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration(), r4);
        this.A = r5;
        if (r5 != null) goto L10;
        r5 = this.B;
    L10:
        this.z = r5;
        return true;
    L12:
        return false;
    }

    private boolean e(Typeface r4) {
        com.google.android.material.g.a r0 = this.G;
        if (r0 == null) goto L6;
        r0.a();
    L6:
        if (this.E == r4) goto L12;
        this.E = r4;
        Typeface r5 = com.google.android.material.g.g.a(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13439c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration(), r4);
        this.D = r5;
        if (r5 != null) goto L10;
        r5 = this.E;
    L10:
        this.C = r5;
        return true;
    L12:
        return false;
    }

    public Typeface h() {
        Typeface r0 = this.z;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return Typeface.DEFAULT;
    }

    public Typeface i() {
        Typeface r0 = this.C;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return Typeface.DEFAULT;
    }

    public void a(Configuration r3) {
        if (Build.VERSION.SDK_INT < 31) goto L20;
        Typeface r0 = this.B;
        if (r0 == null) goto L7;
        this.A = com.google.android.material.g.g.a(r3, r0);
    L7:
        Typeface r1 = this.E;
        if (r1 == null) goto L10;
        this.D = com.google.android.material.g.g.a(r3, r1);
    L10:
        Typeface r4 = this.A;
        if (r4 != null) goto L14;
        r4 = this.B;
    L14:
        this.z = r4;
        Typeface r5 = this.D;
        if (r5 != null) goto L18;
        r5 = this.E;
    L18:
        this.C = r5;
        c(true);
        return;
    }

    public void d(float r3) {
        float r4 = androidx.core.a.a.a(r3, 0.0f, 1.0f);
        if (r4 == this.f13441e) goto L6;
        this.f13441e = r4;
        y();
        return;
    }

    public final boolean a(int[] r1) {
        this.V = r1;
        if (j() == false) goto L6;
        o();
        return true;
    L6:
        return false;
    }

    public final boolean j() {
        ColorStateList r0 = this.r;
        if (r0 != null) goto L5;
    L6:
        ColorStateList r1 = this.q;
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.isStateful() == false) goto L11;
    L10:
        return true;
    L5:
        if (r0.isStateful() == true) goto L10;
        goto L6
    }

    public float k() {
        return this.h;
    }

    public float l() {
        return this.f13441e;
    }

    public void b(boolean r1) {
        this.L = r1;
    }

    public boolean m() {
        return this.L;
    }

    private void y() {
        g(this.f13441e);
    }

    private void g(float r6) {
        i(r6);
        if (this.f == true) goto L5;
        this.x = a(this.v, this.w, r6, this.Z);
        this.y = a(this.t, this.u, r6, this.Z);
        l(r6);
        float r0 = r6;
    L9:
        j(1.0f - a(0.0f, 1.0f, 1.0f - r6, com.google.android.material.animation.a.f13143b));
        k(a(1.0f, 0.0f, r6, com.google.android.material.animation.a.f13143b));
        if (this.r == this.q) goto L12;
        this.X.setColor(a(z(), n(), r0));
    L14:
        if (Build.VERSION.SDK_INT < 21) goto L19;
        float r1 = this.aj;
        float r2 = this.ak;
        if (r1 == r2) goto L18;
        this.X.setLetterSpacing(a(r2, r1, r6, com.google.android.material.animation.a.f13143b));
        goto L19
    L18:
        this.X.setLetterSpacing(r1);
    L19:
        this.R = a(this.af, this.ab, r6, null);
        this.S = a(this.ag, this.ac, r6, null);
        this.T = a(this.ah, this.ad, r6, null);
        int r3 = a(c(this.ai), c(this.ae), r6);
        this.U = r3;
        this.X.setShadowLayer(this.R, this.S, this.T, r3);
        if (this.f == false) goto L22;
        this.X.setAlpha((int) (h(r6) * this.X.getAlpha()));
    L22:
        ViewCompat.f(this.f13439c);
        return;
    L12:
        this.X.setColor(n());
        goto L14
    L5:
        if (r6 >= this.h) goto L7;
        this.x = this.v;
        this.y = this.t;
        l(0.0f);
        r0 = 0.0f;
        goto L9
    L7:
        this.x = this.w;
        this.y = this.u - Math.max(0, this.i);
        l(1.0f);
        r0 = 1.0f;
        goto L9
    }

    private float h(float r5) {
        float r0 = this.h;
        if (r5 > r0) goto L7;
        return com.google.android.material.animation.a.a(1.0f, 0.0f, this.g, r0, r5);
    L7:
        return com.google.android.material.animation.a.a(0.0f, 1.0f, r0, 1.0f, r5);
    }

    private int z() {
        return c(this.q);
    }

    public int n() {
        return c(this.r);
    }

    private int c(ColorStateList r2) {
        if (r2 != null) goto L5;
        return 0;
    L5:
        int[] r1 = this.V;
        if (r1 == null) goto L10;
        return r2.getColorForState(r1, 0);
    L10:
        return r2.getDefaultColor();
    }

    private void d(boolean r10) {
        a(1.0f, r10);
        CharSequence r0 = this.f13438J;
        if (r0 == null) goto L7;
        StaticLayout r1 = this.am;
        if (r1 == null) goto L7;
        this.aq = TextUtils.ellipsize(r0, this.X, r1.getWidth(), TextUtils.TruncateAt.END);
    L7:
        CharSequence r2 = this.aq;
        float r3 = 0.0f;
        if (r2 == null) goto L10;
        this.an = a(this.X, r2);
    L11:
        int r4 = androidx.core.view.d.a(this.n, this.K ? 1 : 0);
        int r5 = r4 & 112;
        if (r5 == 48) goto L16;
        if (r5 == 80) goto L15;
        this.u = this.k.centerY() - ((this.X.descent() - this.X.ascent()) / 2.0f);
    L17:
        int r6 = r4 & 8388615;
        if (r6 == 1) goto L22;
        if (r6 == 5) goto L21;
        this.w = this.k.left;
    L23:
        a(0.0f, r10);
        StaticLayout r11 = this.am;
        if (r11 == null) goto L26;
        float r12 = r11.getHeight();
    L27:
        StaticLayout r7 = this.am;
        if (r7 != null) goto L30;
    L32:
        CharSequence r8 = this.f13438J;
        if (r8 == null) goto L35;
        r3 = a(this.X, r8);
    L35:
        StaticLayout r9 = this.am;
        if (r9 == null) goto L38;
        int r13 = r9.getLineCount();
    L39:
        this.s = r13;
        int r14 = androidx.core.view.d.a(this.m, this.K ? 1 : 0);
        int r15 = r14 & 112;
        if (r15 == 48) goto L44;
        if (r15 == 80) goto L43;
        this.t = this.j.centerY() - (r12 / 2.0f);
    L45:
        int r16 = r14 & 8388615;
        if (r16 == 1) goto L50;
        if (r16 == 5) goto L49;
        this.v = this.j.left;
    L51:
        E();
        l(this.f13441e);
        return;
    L49:
        this.v = this.j.right - r3;
        goto L51
    L50:
        this.v = this.j.centerX() - (r3 / 2.0f);
        goto L51
    L43:
        this.t = (this.j.bottom - r12) + this.X.descent();
        goto L45
    L44:
        this.t = this.j.top;
        goto L45
    L38:
        r13 = 0;
        goto L39
    L30:
        if (this.ar <= 1) goto L32;
        r3 = r7.getWidth();
        goto L35
    L26:
        r12 = 0.0f;
        goto L27
    L21:
        this.w = this.k.right - this.an;
        goto L23
    L22:
        this.w = this.k.centerX() - (this.an / 2.0f);
        goto L23
    L15:
        this.u = this.k.bottom + this.X.ascent();
        goto L17
    L16:
        this.u = this.k.top;
        goto L17
    L10:
        this.an = 0.0f;
        goto L11
    }

    private float a(TextPaint r2, CharSequence r3) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        return r2.measureText(r1, 0, r1.length());
    }

    private void i(float r5) {
        if (this.f == false) goto L9;
        RectF r0 = this.l;
        if (r5 >= this.h) goto L7;
        Rect r4 = this.j;
    L8:
        r0.set(r4);
        return;
    L7:
        r4 = this.k;
        goto L8
    L9:
        this.l.left = a(this.j.left, this.k.left, r5, this.Z);
        this.l.top = a(this.t, this.u, r5, this.Z);
        this.l.right = a(this.j.right, this.k.right, r5, this.Z);
        this.l.bottom = a(this.j.bottom, this.k.bottom, r5, this.Z);
    }

    private void j(float r1) {
        this.ao = r1;
        ViewCompat.f(this.f13439c);
    }

    private void k(float r1) {
        this.ap = r1;
        ViewCompat.f(this.f13439c);
    }

    public void a(Canvas r8) {
        int r0 = r8.save();
        if (this.f13438J != null) goto L5;
        return;
    L5:
        if (this.f13440d == false) goto L31;
        this.X.setTextSize(this.Q);
        float r1 = this.x;
        float r2 = this.y;
        if (this.M == true) goto L9;
    L11:
        boolean r3 = false;
    L12:
        float r5 = this.P;
        if (r5 != 1.0f) goto L15;
    L17:
        if (r3 == false) goto L21;
        r8.drawBitmap(this.N, r1, r2, this.O);
        r8.restoreToCount(r0);
        return;
    L21:
        if (A() == true) goto L23;
    L27:
        r8.translate(r1, r2);
        this.am.draw(r8);
    L28:
        r8.restoreToCount(r0);
        return;
    L23:
        if (this.f == true) goto L25;
    L26:
        a(r8, this.x - this.am.getLineStart(0), r2);
        goto L28
    L25:
        if (this.f13441e <= this.h) goto L27;
    L15:
        if (this.f == true) goto L17;
        r8.scale(r5, r5, r1, r2);
        goto L17
    L9:
        if (this.N == null) goto L11;
        r3 = true;
        goto L12
    }

    private boolean A() {
        if (this.ar > 1) goto L5;
    L11:
        return false;
    L5:
        if (this.K == false) goto L9;
        if (this.f == false) goto L11;
    L9:
        if (this.M == true) goto L11;
        return true;
    }

    private void a(Canvas r14, float r15, float r16) {
        int r1 = this.X.getAlpha();
        r14.translate(r15, r16);
        float r4 = r1;
        this.X.setAlpha((int) (this.ap * r4));
        if (Build.VERSION.SDK_INT < 31) goto L5;
        TextPaint r2 = this.X;
        r2.setShadowLayer(this.R, this.S, this.T, com.google.android.material.color.b.b(this.U, r2.getAlpha()));
    L5:
        this.am.draw(r14);
        this.X.setAlpha((int) (this.ao * r4));
        if (Build.VERSION.SDK_INT < 31) goto L8;
        TextPaint r3 = this.X;
        r3.setShadowLayer(this.R, this.S, this.T, com.google.android.material.color.b.b(this.U, r3.getAlpha()));
    L8:
        int r5 = this.am.getLineBaseline(0);
        CharSequence r6 = this.aq;
        float r7 = r5;
        r14.drawText(r6, 0, r6.length(), 0.0f, r7, this.X);
        if (Build.VERSION.SDK_INT < 31) goto L12;
        this.X.setShadowLayer(this.R, this.S, this.T, this.U);
    L12:
        if (this.f == true) goto L18;
        String r8 = this.aq.toString().trim();
        if (r8.endsWith("…") == false) goto L16;
        r8 = r8.substring(0, r8.length() - 1);
    L16:
        String r9 = r8;
        this.X.setAlpha(r1);
        r14.drawText(r9, 0, Math.min(this.am.getLineEnd(0), r9.length()), 0.0f, r7, this.X);
        return;
    }

    private boolean b(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r0 = B();
        if (this.L == true) goto L5;
        return r0;
    L5:
        return a(r4, r0);
    }

    private boolean B() {
        if (ViewCompat.i(this.f13439c) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean a(CharSequence r2, boolean r3) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 == false) goto L5;
        androidx.core.text.d r4 = androidx.core.text.e.f1362d;
    L7:
        return r4.a(r1, 0, r1.length());
    L5:
        r4 = androidx.core.text.e.f1361c;
        goto L7
    }

    private void l(float r2) {
        m(r2);
        if (f13436a == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.M = r3;
        if (r3 == false) goto L11;
        D();
    L11:
        ViewCompat.f(this.f13439c);
        return;
    L5:
        if (this.P == 1.0f) goto L7;
        r3 = true;
        goto L8
    }

    private void m(float r2) {
        a(r2, false);
    }

    private void a(float r13, boolean r14) {
        if (this.I != null) goto L5;
        return;
    L5:
        float r0 = this.k.width();
        float r1 = this.j.width();
        boolean r5 = false;
        int r6 = 1;
        if (a(r13, 1.0f) == false) goto L11;
        float r15 = this.p;
        float r16 = this.aj;
        this.P = 1.0f;
        Typeface r2 = this.F;
        Typeface r3 = this.z;
        if (r2 == r3) goto L10;
        this.F = r3;
        boolean r4 = true;
    L27:
        if (r0 <= 0.0f) goto L46;
        if (this.Q == r15) goto L31;
        boolean r7 = true;
    L33:
        if (this.al == r16) goto L35;
        boolean r8 = true;
    L36:
        if (r7 == true) goto L43;
        if (r8 == true) goto L43;
        if (this.W == true) goto L43;
        if (r4 == true) goto L43;
        r4 = false;
    L44:
        this.Q = r15;
        this.al = r16;
        this.W = false;
    L43:
        r4 = true;
        goto L44
    L35:
        r8 = false;
        goto L36
    L31:
        r7 = false;
    L46:
        if (this.f13438J == null) goto L48;
        if (r4 == true) goto L48;
        return;
    L48:
        this.X.setTextSize(this.Q);
        this.X.setTypeface(this.F);
        if (Build.VERSION.SDK_INT < 21) goto L51;
        this.X.setLetterSpacing(this.al);
    L51:
        TextPaint r17 = this.X;
        if (this.P == 1.0f) goto L54;
        r5 = true;
    L54:
        r17.setLinearText(r5);
        this.K = b(this.I);
        if (A() == false) goto L57;
        r6 = this.ar;
    L57:
        StaticLayout r18 = a(r6, r0, this.K);
        this.am = r18;
        this.f13438J = r18.getText();
        return;
    L10:
        r4 = false;
        goto L27
    L11:
        float r9 = this.o;
        float r10 = this.ak;
        Typeface r11 = this.F;
        Typeface r12 = this.C;
        if (r11 == r12) goto L14;
        this.F = r12;
        boolean r19 = true;
    L16:
        if (a(r13, 0.0f) == false) goto L18;
        this.P = 1.0f;
    L19:
        float r110 = this.p / this.o;
        float r20 = r1 * r110;
        if (r14 == false) goto L24;
    L21:
        r0 = r1;
    L22:
        r15 = r9;
        r16 = r10;
        r4 = r19;
        goto L27
    L24:
        if (r20 <= r0) goto L21;
        r0 = Math.min(r0 / r110, r1);
        goto L22
    L18:
        this.P = a(this.o, this.p, r13, this.aa) / this.o;
        goto L19
    L14:
        r19 = false;
        goto L16
    }

    private StaticLayout a(int r4, float r5, boolean r6) {
        if (r4 != 1) goto L5;
        Layout.Alignment r0 = Layout.Alignment.ALIGN_NORMAL;     // Catch: i.a -> L8
    L6:
        StaticLayout r3 = i.a(this.I, this.X, (int) r5).a(TextUtils.TruncateAt.END).b(r6).a(r0).a(false).a(r4).a(this.as, this.at).b(this.au).a();     // Catch: i.a -> L8
    L11:
        return (StaticLayout) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a(r3), StaticLayout.class, "com.obric.aiagent.plugin");
    L5:
        r0 = C();     // Catch: i.a -> L8
    L8:
        e = move-exception;
        a(TAG, e.getCause().getMessage(), e);
        r3 = null;
        goto L11
    }

    private Layout.Alignment C() {
        int r0 = androidx.core.view.d.a(this.m, this.K ? 1 : 0) & 7;
        if (r0 == 1) goto L17;
        if (r0 == 5) goto L12;
        if (this.K == false) goto L10;
        return Layout.Alignment.ALIGN_OPPOSITE;
    L10:
        return Layout.Alignment.ALIGN_NORMAL;
    L12:
        if (this.K == false) goto L15;
        return Layout.Alignment.ALIGN_NORMAL;
    L15:
        return Layout.Alignment.ALIGN_OPPOSITE;
    L17:
        return Layout.Alignment.ALIGN_CENTER;
    }

    private void D() {
        if (this.N == null) goto L5;
        return;
    L5:
        if (this.j.isEmpty() == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(this.f13438J) == true) goto L21;
        g(0.0f);
        int r0 = this.am.getWidth();
        int r1 = this.am.getHeight();
        if (r0 <= 0) goto L19;
        if (r1 <= 0) goto L22;
        this.N = Bitmap.createBitmap(r0, r1, Bitmap.Config.ARGB_8888);
        Canvas r2 = new Canvas(this.N);
        this.am.draw(r2);
        if (this.O != null) goto L20;
        this.O = new Paint(3);
        return;
    L20:
        return;
    L22:
        return;
    L19:
        return;
    }

    public void o() {
        c(false);
    }

    public void c(boolean r2) {
        if (this.f13439c.getHeight() > 0) goto L5;
    L6:
        if (r2 == false) goto L9;
    L7:
        d(r2);
        y();
        return;
    L9:
        return;
    L5:
        if (this.f13439c.getWidth() > 0) goto L7;
        goto L6
    }

    public void a(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
    L6:
        this.I = r4;
        this.f13438J = null;
        E();
        o();
        return;
    L5:
        if (TextUtils.equals(this.I, r4) == false) goto L6;
    }

    public CharSequence p() {
        return this.I;
    }

    private void E() {
        Bitmap r0 = this.N;
        if (r0 == null) goto L6;
        r0.recycle();
        this.N = null;
        return;
    }

    public void f(int r2) {
        if (r2 == this.ar) goto L6;
        this.ar = r2;
        E();
        o();
        return;
    }

    public int q() {
        return this.ar;
    }

    public int r() {
        StaticLayout r0 = this.am;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getLineCount();
    }

    public int s() {
        return this.s;
    }

    public void e(float r1) {
        this.as = r1;
    }

    public float t() {
        return this.am.getSpacingAdd();
    }

    public void f(float r1) {
        this.at = r1;
    }

    public float u() {
        return this.am.getSpacingMultiplier();
    }

    public void g(int r1) {
        this.au = r1;
    }

    public int v() {
        return this.au;
    }

    private static boolean a(float r0, float r1) {
        if (Math.abs(r0 - r1) >= 1.0E-5f) goto L5;
        return true;
    L5:
        return false;
    }

    public ColorStateList w() {
        return this.r;
    }

    private static int a(int r5, int r6, float r7) {
        float r0 = 1.0f - r7;
        return Color.argb(Math.round((Color.alpha(r5) * r0) + (Color.alpha(r6) * r7)), Math.round((Color.red(r5) * r0) + (Color.red(r6) * r7)), Math.round((Color.green(r5) * r0) + (Color.green(r6) * r7)), Math.round((Color.blue(r5) * r0) + (Color.blue(r6) * r7)));
    }

    private static float a(float r2, float r3, float r4, TimeInterpolator r5) {
        TimeInterpolator r6 = (TimeInterpolator) ZeusTransformUtils.wrapperContextForParams(r5, TimeInterpolator.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L6;
        r4 = r6.getInterpolation(r4);
    L6:
        return com.google.android.material.animation.a.a(r2, r3, r4);
    }

    private static boolean a(Rect r1, int r2, int r3, int r4, int r5) {
        if (r1.left == r2) goto L5;
    L11:
        return false;
    L5:
        if (r1.top != r3) goto L11;
        if (r1.right != r4) goto L11;
        if (r1.bottom != r5) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
