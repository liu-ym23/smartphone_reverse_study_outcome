package E9;

import B9.Q;
import S7.k;

/* loaded from: classes4.dex */
public interface f {
    void a(Z7.d dVar, k kVar);

    void b(Z7.d dVar, Z7.d dVar2, x9.b bVar);

    void h(Z7.d dVar, k kVar);

    void i(Z7.d dVar, k kVar);

    default void o(Z7.d dVar, x9.b serializer) {
        kotlin.jvm.internal.k.f(serializer, "serializer");
        a(dVar, new Q(serializer, 9));
    }
}
