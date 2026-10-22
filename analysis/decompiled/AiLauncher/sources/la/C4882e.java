package la;

import E9.InterfaceC0799d;
import E9.b0;
import Z8.C1174w;
import Z8.r;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import xa.InterfaceC5869l;
import ya.B0;
import ya.C5978M;
import ya.C6018y;
import ya.D0;
import ya.E0;
import ya.S;
import ya.Y;

/* renamed from: la.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4882e {

    /* renamed from: la.e$a */
    public static final class a extends C6018y {

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f37004d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(E0 e02, boolean z10) {
            super(e02);
            this.f37004d = z10;
        }

        @Override // ya.E0
        public boolean b() {
            return this.f37004d;
        }

        @Override // ya.C6018y, ya.E0
        public B0 e(S key) {
            p.i(key, "key");
            B0 b0E = super.e(key);
            if (b0E == null) {
                return null;
            }
            InterfaceC0799d interfaceC0799dD = key.H0().d();
            return C4882e.c(b0E, interfaceC0799dD instanceof b0 ? (b0) interfaceC0799dD : null);
        }
    }

    public static final B0 c(B0 b02, b0 b0Var) {
        if (b0Var == null || b02.c() == Variance.INVARIANT) {
            return b02;
        }
        if (b0Var.l() != b02.c()) {
            return new D0(e(b02));
        }
        if (!b02.b()) {
            return new D0(b02.getType());
        }
        InterfaceC5869l NO_LOCKS = LockBasedStorageManager.f36050e;
        p.h(NO_LOCKS, "NO_LOCKS");
        return new D0(new Y(NO_LOCKS, new C4881d(b02)));
    }

    public static final S d(B0 b02) {
        S type = b02.getType();
        p.h(type, "getType(...)");
        return type;
    }

    public static final S e(B0 typeProjection) {
        p.i(typeProjection, "typeProjection");
        return new C4878a(typeProjection, null, false, null, 14, null);
    }

    public static final boolean f(S s10) {
        p.i(s10, "<this>");
        return s10.H0() instanceof InterfaceC4879b;
    }

    public static final E0 g(E0 e02, boolean z10) {
        p.i(e02, "<this>");
        if (!(e02 instanceof C5978M)) {
            return new a(e02, z10);
        }
        C5978M c5978m = (C5978M) e02;
        b0[] b0VarArrJ = c5978m.j();
        List<Pair> listM1 = r.m1(c5978m.i(), c5978m.j());
        ArrayList arrayList = new ArrayList(C1174w.x(listM1, 10));
        for (Pair pair : listM1) {
            arrayList.add(c((B0) pair.e(), (b0) pair.f()));
        }
        return new C5978M(b0VarArrJ, (B0[]) arrayList.toArray(new B0[0]), z10);
    }

    public static /* synthetic */ E0 h(E0 e02, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return g(e02, z10);
    }
}
