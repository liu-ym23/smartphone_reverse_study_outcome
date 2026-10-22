package t;

import com.google.crypto.tink.shaded.protobuf.Reader;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h1 implements u.u0 {
    public static final p5.u i = t0.l.a(f1.f12978c, j.i);

    /* renamed from: a, reason: collision with root package name */
    public final k0.h1 f12998a;

    /* renamed from: e, reason: collision with root package name */
    public float f13002e;

    /* renamed from: b, reason: collision with root package name */
    public final k0.h1 f12999b = new k0.h1(0);

    /* renamed from: c, reason: collision with root package name */
    public final v.k f13000c = t0.a.a();

    /* renamed from: d, reason: collision with root package name */
    public final k0.h1 f13001d = new k0.h1(Reader.READ_DONE);

    /* renamed from: f, reason: collision with root package name */
    public final ad.z f13003f = c1.b(new a2.m(this, 17));

    /* renamed from: g, reason: collision with root package name */
    public final k0.i0 f13004g = k0.z.q(new g1(this, 1));

    /* renamed from: h, reason: collision with root package name */
    public final k0.i0 f13005h = k0.z.q(new g1(this, 0));

    public h1(int i3) {
        this.f12998a = new k0.h1(i3);
    }

    @Override // u.u0
    public final boolean a() {
        return this.f13003f.a();
    }

    @Override // u.u0
    public final boolean b() {
        return ((Boolean) this.f13005h.getValue()).booleanValue();
    }

    @Override // u.u0
    public final Object c(u0 u0Var, xb.p pVar, pb.c cVar) {
        Object objC = this.f13003f.c(u0Var, pVar, cVar);
        return objC == ob.a.f9351c ? objC : jb.v.f6774a;
    }

    @Override // u.u0
    public final boolean d() {
        return ((Boolean) this.f13004g.getValue()).booleanValue();
    }

    @Override // u.u0
    public final float e(float f5) {
        return this.f13003f.e(f5);
    }
}
