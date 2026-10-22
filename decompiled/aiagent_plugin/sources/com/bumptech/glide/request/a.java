package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.m;
import com.bumptech.glide.load.resource.bitmap.l;
import com.bumptech.glide.load.resource.bitmap.o;
import com.bumptech.glide.load.resource.bitmap.q;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.a;
import com.obric.capabilitykit.common.UiType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: BaseRequestOptions.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T extends a<T>> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f3907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.load.engine.j f3908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bumptech.glide.e f3909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f3910e;
    private int f;
    private Drawable g;
    private int h;
    private boolean i;
    private int j;
    private int k;
    private com.bumptech.glide.load.g l;
    private boolean m;
    private boolean n;
    private Drawable o;
    private int p;
    private com.bumptech.glide.load.i q;
    private Map<Class<?>, m<?>> r;
    private Class<?> s;
    private boolean t;
    private Resources.Theme u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    private static boolean a(int r0, int r1) {
        if ((r0 & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private T b() {
        return this;
    }

    public /* synthetic */ Object clone() {
        return c();
    }

    public a() {
        this.f3907b = 1.0f;
        this.f3908c = com.bumptech.glide.load.engine.j.f3679e;
        this.f3909d = com.bumptech.glide.e.f3296c;
        this.i = true;
        this.j = -1;
        this.k = -1;
        this.l = com.bumptech.glide.e.c.a();
        this.n = true;
        this.q = new com.bumptech.glide.load.i();
        this.r = new com.bumptech.glide.f.b();
        this.s = Object.class;
        this.y = true;
    }

    public T a(float r2) {
        if (this.v == false) goto L7;
        return (T) c().a(r2);
    L7:
        if (r2 < 0.0f) goto L13;
        if (r2 > 1.0f) goto L13;
        this.f3907b = r2;
        this.f3906a |= 2;
        return (T) a();
    L13:
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    public T a(boolean r2) {
        if (this.v == true) goto L5;
        this.z = r2;
        this.f3906a |= 1048576;
        return (T) a();
    L5:
        return (T) c().a(r2);
    }

    public T a(com.bumptech.glide.load.engine.j r3) {
        if (this.v == true) goto L5;
        this.f3908c = (com.bumptech.glide.load.engine.j) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r3), com.bumptech.glide.load.engine.j.class, "com.obric.aiagent.plugin");
        this.f3906a |= 4;
        return (T) a();
    L5:
        return (T) c().a(r3);
    }

    public T a(com.bumptech.glide.e r3) {
        if (this.v == true) goto L5;
        this.f3909d = (com.bumptech.glide.e) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r3), com.bumptech.glide.e.class, "com.obric.aiagent.plugin");
        this.f3906a |= 8;
        return (T) a();
    L5:
        return (T) c().a(r3);
    }

    public T b(boolean r3) {
        if (this.v == true) goto L5;
        this.i = !r3;
        this.f3906a |= 256;
        return (T) a();
    L5:
        return (T) c().b(true);
    }

    public T b(int r2, int r3) {
        if (this.v == true) goto L5;
        this.k = r2;
        this.j = r3;
        this.f3906a |= 512;
        return (T) a();
    L5:
        return (T) c().b(r2, r3);
    }

    public T a(com.bumptech.glide.load.g r3) {
        com.bumptech.glide.load.g r4 = (com.bumptech.glide.load.g) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        if (this.v == true) goto L5;
        this.l = (com.bumptech.glide.load.g) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r4), com.bumptech.glide.load.g.class, "com.obric.aiagent.plugin");
        this.f3906a |= 1024;
        return (T) a();
    L5:
        return (T) c().a(r4);
    }

    public T c() {
        T r0 = (T) ZeusTransformUtils.preCheckCast(super.clone(), a.class, "com.obric.aiagent.plugin");     // Catch: CloneNotSupportedException -> L4
        com.bumptech.glide.load.i r1 = new com.bumptech.glide.load.i();     // Catch: CloneNotSupportedException -> L4
        r0.q = r1;     // Catch: CloneNotSupportedException -> L4
        r1.a(this.q);     // Catch: CloneNotSupportedException -> L4
        com.bumptech.glide.f.b r2 = new com.bumptech.glide.f.b();     // Catch: CloneNotSupportedException -> L4
        r0.r = r2;     // Catch: CloneNotSupportedException -> L4
        r2.putAll(this.r);     // Catch: CloneNotSupportedException -> L4
        r0.t = false;     // Catch: CloneNotSupportedException -> L4
        r0.v = false;     // Catch: CloneNotSupportedException -> L4
        return r0;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public <Y> T a(com.bumptech.glide.load.h<Y> r2, Y r3) {
        if (this.v == true) goto L5;
        com.bumptech.glide.f.j.a(r2);
        com.bumptech.glide.f.j.a(r3);
        this.q.a(r2, r3);
        return (T) a();
    L5:
        return (T) c().a(r2, r3);
    }

    public T a(Class<?> r3) {
        if (this.v == true) goto L5;
        this.s = (Class) ZeusTransformUtils.preCheckCast(com.bumptech.glide.f.j.a(r3), Class.class, "com.obric.aiagent.plugin");
        this.f3906a |= 4096;
        return (T) a();
    L5:
        return (T) c().a(r3);
    }

    public final boolean d() {
        return this.n;
    }

    public final boolean e() {
        return a(2048);
    }

    public T a(l r2) {
        return (T) a(l.h, com.bumptech.glide.f.j.a(r2));
    }

    public T f() {
        return (T) a(l.f3811e, new com.bumptech.glide.load.resource.bitmap.i());
    }

    public T g() {
        return (T) c(l.f3809c, new q());
    }

    public T h() {
        return (T) c(l.f3810d, new com.bumptech.glide.load.resource.bitmap.j());
    }

    final T a(l r3, m<Bitmap> r4) {
        m<Bitmap> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        if (this.v == true) goto L5;
        a(r3);
        return (T) a(r5, false);
    L5:
        return (T) c().a(r3, r5);
    }

    final T b(l r3, m<Bitmap> r4) {
        m<Bitmap> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        if (this.v == true) goto L5;
        a(r3);
        return (T) a(r5);
    L5:
        return (T) c().b(r3, r5);
    }

    private T c(l r3, m<Bitmap> r4) {
        return (T) a(r3, (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin"), false);
    }

    private T a(l r3, m<Bitmap> r4, boolean r5) {
        m<Bitmap> r6 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        if (r5 == false) goto L5;
        T r2 = (T) b(r3, r6);
    L6:
        r2.y = true;
        return r2;
    L5:
        r2 = (T) a(r3, r6);
        goto L6
    }

    public T a(m<Bitmap> r3) {
        return (T) a((m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin"), true);
    }

    T a(m<Bitmap> r3, boolean r4) {
        m<Y> r5 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
        if (this.v == true) goto L5;
        o r0 = new o(r5, r4);
        a(Bitmap.class, r5, r4);
        a(Drawable.class, r0, r4);
        a(BitmapDrawable.class, r0.a(), r4);
        a(GifDrawable.class, new com.bumptech.glide.load.resource.gif.e(r5), r4);
        return (T) a();
    L5:
        return (T) c().a(r5, r4);
    }

    <Y> T a(Class<Y> r3, m<Y> r4, boolean r5) {
        m<?> r6 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin");
        if (this.v == true) goto L5;
        com.bumptech.glide.f.j.a(r3);
        com.bumptech.glide.f.j.a(r6);
        this.r.put(r3, r6);
        int r7 = this.f3906a | 2048;
        this.f3906a = r7;
        this.n = true;
        int r8 = r7 | 65536;
        this.f3906a = r8;
        this.y = false;
        if (r5 == false) goto L10;
        this.f3906a = r8 | UiType.FLAG_PHONE_CARD;
        this.m = true;
    L10:
        return (T) a();
    L5:
        return (T) c().a(r3, r6, r5);
    }

    public T b(a<?> r5) {
        if (this.v == false) goto L7;
        return (T) c().b(r5);
    L7:
        if (a(r5.f3906a, 2) == false) goto L10;
        this.f3907b = r5.f3907b;
    L10:
        if (a(r5.f3906a, 262144) == false) goto L13;
        this.w = r5.w;
    L13:
        if (a(r5.f3906a, 1048576) == false) goto L16;
        this.z = r5.z;
    L16:
        if (a(r5.f3906a, 4) == false) goto L19;
        this.f3908c = r5.f3908c;
    L19:
        if (a(r5.f3906a, 8) == false) goto L22;
        this.f3909d = r5.f3909d;
    L22:
        if (a(r5.f3906a, 16) == false) goto L25;
        this.f3910e = r5.f3910e;
        this.f = 0;
        this.f3906a &= -33;
    L25:
        if (a(r5.f3906a, 32) == false) goto L28;
        this.f = r5.f;
        this.f3910e = null;
        this.f3906a &= -17;
    L28:
        if (a(r5.f3906a, 64) == false) goto L31;
        this.g = r5.g;
        this.h = 0;
        this.f3906a &= -129;
    L31:
        if (a(r5.f3906a, 128) == false) goto L34;
        this.h = r5.h;
        this.g = null;
        this.f3906a &= -65;
    L34:
        if (a(r5.f3906a, 256) == false) goto L37;
        this.i = r5.i;
    L37:
        if (a(r5.f3906a, 512) == false) goto L40;
        this.k = r5.k;
        this.j = r5.j;
    L40:
        if (a(r5.f3906a, 1024) == false) goto L43;
        this.l = r5.l;
    L43:
        if (a(r5.f3906a, 4096) == false) goto L46;
        this.s = r5.s;
    L46:
        if (a(r5.f3906a, 8192) == false) goto L49;
        this.o = r5.o;
        this.p = 0;
        this.f3906a &= -16385;
    L49:
        if (a(r5.f3906a, 16384) == false) goto L52;
        this.p = r5.p;
        this.o = null;
        this.f3906a &= -8193;
    L52:
        if (a(r5.f3906a, 32768) == false) goto L55;
        this.u = r5.u;
    L55:
        if (a(r5.f3906a, 65536) == false) goto L58;
        this.n = r5.n;
    L58:
        if (a(r5.f3906a, UiType.FLAG_PHONE_CARD) == false) goto L61;
        this.m = r5.m;
    L61:
        if (a(r5.f3906a, 2048) == false) goto L64;
        this.r.putAll(r5.r);
        this.y = r5.y;
    L64:
        if (a(r5.f3906a, UiType.FLAG_WIFI_QRCODE_CARD) == false) goto L67;
        this.x = r5.x;
    L67:
        if (this.n == true) goto L69;
        this.r.clear();
        int r0 = this.f3906a & (-2049);
        this.f3906a = r0;
        this.m = false;
        this.f3906a = r0 & (-131073);
        this.y = true;
    L69:
        this.f3906a |= r5.f3906a;
        this.q.a(r5.q);
        return (T) a();
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L48;
        a r5 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin");
        if (Float.compare(r5.f3907b, this.f3907b) == 0) goto L7;
        return false;
    L7:
        if (this.f == r5.f) goto L9;
        return false;
    L9:
        if (com.bumptech.glide.f.k.a(this.f3910e, r5.f3910e) == true) goto L11;
        return false;
    L11:
        if (this.h == r5.h) goto L13;
        return false;
    L13:
        if (com.bumptech.glide.f.k.a(this.g, r5.g) == true) goto L15;
        return false;
    L15:
        if (this.p == r5.p) goto L17;
        return false;
    L17:
        if (com.bumptech.glide.f.k.a(this.o, r5.o) == true) goto L19;
        return false;
    L19:
        if (this.i == r5.i) goto L21;
        return false;
    L21:
        if (this.j == r5.j) goto L23;
        return false;
    L23:
        if (this.k == r5.k) goto L25;
        return false;
    L25:
        if (this.m == r5.m) goto L27;
        return false;
    L27:
        if (this.n == r5.n) goto L29;
        return false;
    L29:
        if (this.w == r5.w) goto L31;
        return false;
    L31:
        if (this.x == r5.x) goto L33;
        return false;
    L33:
        if (this.f3908c.equals(r5.f3908c) == true) goto L35;
        return false;
    L35:
        if (this.f3909d == r5.f3909d) goto L37;
        return false;
    L37:
        if (this.q.equals(r5.q) == true) goto L39;
        return false;
    L39:
        if (this.r.equals(r5.r) == true) goto L41;
        return false;
    L41:
        if (this.s.equals(r5.s) == true) goto L43;
        return false;
    L43:
        if (com.bumptech.glide.f.k.a(this.l, r5.l) == true) goto L45;
        return false;
    L45:
        if (com.bumptech.glide.f.k.a(this.u, r5.u) == false) goto L69;
        return true;
    L69:
        return false;
    L48:
        return false;
    }

    public int hashCode() {
        int r0 = com.bumptech.glide.f.k.a(this.f3907b);
        int r1 = com.bumptech.glide.f.k.b(this.f, r0);
        int r2 = com.bumptech.glide.f.k.a(this.f3910e, r1);
        int r3 = com.bumptech.glide.f.k.b(this.h, r2);
        int r4 = com.bumptech.glide.f.k.a(this.g, r3);
        int r5 = com.bumptech.glide.f.k.b(this.p, r4);
        int r6 = com.bumptech.glide.f.k.a(this.o, r5);
        int r7 = com.bumptech.glide.f.k.a(this.i, r6);
        int r8 = com.bumptech.glide.f.k.b(this.j, r7);
        int r9 = com.bumptech.glide.f.k.b(this.k, r8);
        int r10 = com.bumptech.glide.f.k.a(this.m, r9);
        int r11 = com.bumptech.glide.f.k.a(this.n, r10);
        int r12 = com.bumptech.glide.f.k.a(this.w, r11);
        int r13 = com.bumptech.glide.f.k.a(this.x, r12);
        int r14 = com.bumptech.glide.f.k.a(this.f3908c, r13);
        int r15 = com.bumptech.glide.f.k.a(this.f3909d, r14);
        int r16 = com.bumptech.glide.f.k.a(this.q, r15);
        int r17 = com.bumptech.glide.f.k.a(this.r, r16);
        int r18 = com.bumptech.glide.f.k.a(this.s, r17);
        int r19 = com.bumptech.glide.f.k.a(this.l, r18);
        return com.bumptech.glide.f.k.a(this.u, r19);
    }

    public T i() {
        this.t = true;
        return (T) b();
    }

    public T j() {
        if (this.t == true) goto L5;
    L9:
        this.v = true;
        return (T) i();
    L5:
        if (this.v == true) goto L9;
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    private T a() {
        if (this.t == true) goto L7;
        return (T) b();
    L7:
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    public final boolean k() {
        return a(4);
    }

    public final boolean l() {
        return a(256);
    }

    public final Map<Class<?>, m<?>> m() {
        return this.r;
    }

    public final boolean n() {
        return this.m;
    }

    public final com.bumptech.glide.load.i o() {
        return this.q;
    }

    public final Class<?> p() {
        return this.s;
    }

    public final com.bumptech.glide.load.engine.j q() {
        return this.f3908c;
    }

    public final Drawable r() {
        return this.f3910e;
    }

    public final int s() {
        return this.f;
    }

    public final int t() {
        return this.h;
    }

    public final Drawable u() {
        return this.g;
    }

    public final int v() {
        return this.p;
    }

    public final Drawable w() {
        return this.o;
    }

    public final Resources.Theme x() {
        return this.u;
    }

    public final boolean y() {
        return this.i;
    }

    public final com.bumptech.glide.load.g z() {
        return this.l;
    }

    public final boolean A() {
        return a(8);
    }

    public final com.bumptech.glide.e B() {
        return this.f3909d;
    }

    public final int C() {
        return this.k;
    }

    public final boolean D() {
        return com.bumptech.glide.f.k.a(this.k, this.j);
    }

    public final int E() {
        return this.j;
    }

    public final float F() {
        return this.f3907b;
    }

    boolean G() {
        return this.y;
    }

    private boolean a(int r1) {
        return a(this.f3906a, r1);
    }

    public final boolean H() {
        return this.w;
    }

    public final boolean I() {
        return this.z;
    }

    public final boolean J() {
        return this.x;
    }
}
