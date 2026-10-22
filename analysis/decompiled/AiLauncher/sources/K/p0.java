package K;

import g3.InterfaceFutureC4095a;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface p0<T> {

    public interface a<T> {
        void a(T t10);

        void onError(Throwable th);
    }

    void a(Executor executor, a<? super T> aVar);

    InterfaceFutureC4095a<T> b();

    void c(a<? super T> aVar);
}
