package kotlinx.coroutines.a;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface s<E> {
    Object a(d.c.d<? super E> r1);

    void a(CancellationException r1);

    Object a_(d.c.d<? super h<? extends E>> r1);

    kotlinx.coroutines.e.g<E> f();

    f<E> g();

    Object r_();
}
