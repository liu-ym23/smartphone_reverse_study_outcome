package h2;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.datastore.preferences.protobuf.b1;
import androidx.lifecycle.x;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class p {
    public static final n a(final b1 tracer, final String label, final s2.a executor, final zb.a aVar) {
        kotlin.jvm.internal.g.f(tracer, "tracer");
        kotlin.jvm.internal.g.f(label, "label");
        kotlin.jvm.internal.g.f(executor, "executor");
        final x xVar = new x(0);
        CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: h2.o
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object c(CallbackToFutureAdapter.a aVar2) {
                executor.execute(new com.stepos.core.ota.display.b(tracer, label, aVar, xVar, aVar2));
                return lb.n.f10413a;
            }
        });
        return new n();
    }
}
