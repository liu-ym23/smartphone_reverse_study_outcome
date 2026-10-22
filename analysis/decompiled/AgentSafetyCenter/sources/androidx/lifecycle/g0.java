package androidx.lifecycle;

import android.os.Handler;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g0 implements x {

    /* renamed from: l, reason: collision with root package name */
    public static final g0 f1381l;

    /* renamed from: c, reason: collision with root package name */
    public int f1382c;

    /* renamed from: f, reason: collision with root package name */
    public int f1383f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1384g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1385h;
    public Handler i;

    /* renamed from: j, reason: collision with root package name */
    public z f1386j;

    /* renamed from: k, reason: collision with root package name */
    public a4.t f1387k;

    static {
        g0 g0Var = new g0();
        g0Var.f1384g = true;
        g0Var.f1385h = true;
        g0Var.f1386j = new z(g0Var, true);
        a4.t tVar = new a4.t(7);
        tVar.f200f = g0Var;
        VarHandle.storeStoreFence();
        g0Var.f1387k = tVar;
        VarHandle.storeStoreFence();
        f1381l = g0Var;
    }

    @Override // androidx.lifecycle.x
    public final q getLifecycle() {
        return this.f1386j;
    }
}
