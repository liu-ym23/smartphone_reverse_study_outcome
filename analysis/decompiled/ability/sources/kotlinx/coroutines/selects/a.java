package kotlinx.coroutines.selects;

import S7.k;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.p;
import v9.AbstractC2077f;
import v9.C2072a;
import v9.C2074c;
import v9.C2076e;

/* loaded from: classes4.dex */
public abstract class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(b bVar, long j5, k kVar) {
        C2072a c2072a = new C2072a(j5);
        OnTimeout$selectClause$1 onTimeout$selectClause$1 = OnTimeout$selectClause$1.f5253a;
        kotlin.jvm.internal.k.d(onTimeout$selectClause$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        p.e(3, onTimeout$selectClause$1);
        C2074c c2074c = new C2074c(bVar, c2072a, onTimeout$selectClause$1, C2076e.f6796a, AbstractC2077f.e, (SuspendLambda) kVar, null);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b.f;
        bVar.j(c2074c, false);
    }
}
