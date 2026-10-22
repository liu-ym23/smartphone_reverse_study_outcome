package s2;

import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import r2.k;
import s2.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface b {
    c.a a();

    default CoroutineDispatcher b() {
        return ExecutorsKt.from(c());
    }

    k c();

    default void d(Runnable runnable) {
        c().execute(runnable);
    }
}
