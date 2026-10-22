package androidx.compose.foundation;

import java.lang.invoke.VarHandle;
import k0.s2;
import t.n0;
import t.p0;
import t.q0;
import t.t0;
import v.k;
import w0.h;
import w0.j;
import w0.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final s2 f862a = new s2(p0.f13051f);

    public static final m a(n0 n0Var, k kVar) {
        if (n0Var == null) {
            return j.f15113c;
        }
        if (n0Var instanceof t0) {
            IndicationModifierElement indicationModifierElement = new IndicationModifierElement();
            indicationModifierElement.f851c = kVar;
            indicationModifierElement.f852f = (t0) n0Var;
            VarHandle.storeStoreFence();
            return indicationModifierElement;
        }
        q0 q0Var = new q0(n0Var, kVar);
        h hVar = new h();
        hVar.f15111f = q0Var;
        VarHandle.storeStoreFence();
        return hVar;
    }
}
