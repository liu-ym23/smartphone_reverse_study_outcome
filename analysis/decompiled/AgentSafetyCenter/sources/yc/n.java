package yc;

import java.lang.invoke.VarHandle;
import xc.l0;
import xc.s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n implements vc.e {

    /* renamed from: b, reason: collision with root package name */
    public static final n f16113b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f16114c;

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ s f16115a;

    static {
        n nVar = new n();
        l0 l0Var = l0.f15644a;
        h hVar = h.f16107a;
        l0 l0Var2 = l0.f15644a;
        h hVar2 = h.f16107a;
        vc.e descriptor = l0Var2.getDescriptor();
        vc.e descriptor2 = hVar2.getDescriptor();
        descriptor.getClass();
        descriptor2.getClass();
        nVar.f16115a = new s("kotlin.collections.LinkedHashMap", descriptor, descriptor2);
        VarHandle.storeStoreFence();
        f16113b = nVar;
        f16114c = "kotlinx.serialization.json.JsonObject";
    }

    @Override // vc.e
    public final String a() {
        return f16114c;
    }

    @Override // vc.e
    public final boolean c() {
        this.f16115a.getClass();
        return false;
    }

    @Override // vc.e
    public final int d() {
        this.f16115a.getClass();
        return 2;
    }

    @Override // vc.e
    public final String e(int i) {
        this.f16115a.getClass();
        return String.valueOf(i);
    }

    @Override // vc.e
    public final vc.e f(int i) {
        return this.f16115a.f(i);
    }

    @Override // vc.e
    public final t.o getKind() {
        this.f16115a.getClass();
        return vc.g.f14893d;
    }
}
