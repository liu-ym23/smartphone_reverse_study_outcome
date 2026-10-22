package c9;

import X8.F;
import X8.K;
import X8.L;
import X8.N;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* renamed from: c9.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0890c extends L {
    @Override // X8.L
    public final N g(K key) {
        k.f(key, "key");
        K8.b bVar = key instanceof K8.b ? (K8.b) key : null;
        if (bVar == null) {
            return null;
        }
        if (bVar.a().c()) {
            return new F(bVar.a().b(), Variance.e);
        }
        return bVar.a();
    }
}
