package t;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p0 extends yb.l implements xb.a {

    /* renamed from: f, reason: collision with root package name */
    public static final p0 f13051f;

    /* renamed from: g, reason: collision with root package name */
    public static final p0 f13052g;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13053c;

    static {
        int i = 0;
        f13051f = new p0(i, 0);
        f13052g = new p0(i, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p0(int i, int i3) {
        super(i);
        this.f13053c = i3;
    }

    @Override // xb.a
    public final Object invoke() {
        switch (this.f13053c) {
            case 0:
                return x.f13086a;
            case 1:
                long jC = d1.f0.c(4284900966L);
                float f5 = 0;
                w.l0 l0Var = new w.l0(f5, f5, f5, f5);
                z0 z0Var = new z0();
                z0Var.f13104a = jC;
                z0Var.f13105b = l0Var;
                VarHandle.storeStoreFence();
                return z0Var;
            default:
                return new h1(0);
        }
    }
}
