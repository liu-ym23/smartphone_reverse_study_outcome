package yc;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements vc.e {

    /* renamed from: b, reason: collision with root package name */
    public static final c f16102b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f16103c;

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ xc.a f16104a;

    static {
        c cVar = new c();
        h hVar = h.f16107a;
        vc.f fVar = h.f16108b;
        fVar.getClass();
        cVar.f16104a = new xc.a(fVar);
        VarHandle.storeStoreFence();
        f16102b = cVar;
        f16103c = "kotlinx.serialization.json.JsonArray";
    }

    @Override // vc.e
    public final String a() {
        return f16103c;
    }

    @Override // vc.e
    public final boolean c() {
        this.f16104a.getClass();
        return false;
    }

    @Override // vc.e
    public final int d() {
        this.f16104a.getClass();
        return 1;
    }

    @Override // vc.e
    public final String e(int i) {
        this.f16104a.getClass();
        return String.valueOf(i);
    }

    @Override // vc.e
    public final vc.e f(int i) {
        return this.f16104a.f(i);
    }

    @Override // vc.e
    public final t.o getKind() {
        this.f16104a.getClass();
        return vc.g.f14892c;
    }
}
