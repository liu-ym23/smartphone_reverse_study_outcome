package c0;

import b0.e1;
import b0.j2;
import b0.s2;
import i1.a1;

/* loaded from: classes.dex */
public final class h extends b9.d {

    /* renamed from: d, reason: collision with root package name */
    public static final h f1739d = new h(0, 4, 1);

    @Override // b9.d
    public final void c(androidx.datastore.preferences.protobuf.k kVar, b0.c cVar, s2 s2Var, a1 a1Var, h0 h0Var) {
        e1 e1Var = (e1) kVar.c(2);
        b0.u uVar = (b0.u) kVar.c(1);
        j2 j2Var = (j2) uVar;
        synchronized (j2Var.f1207b) {
        }
        b0.s.d("Could not resolve state for movable content");
        throw new a4.u();
    }
}
