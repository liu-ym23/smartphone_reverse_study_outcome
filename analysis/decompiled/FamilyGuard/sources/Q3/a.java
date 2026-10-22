package Q3;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class a<T> extends AtomicInteger implements G3.c<T> {
    @Override // G3.f
    public final boolean offer(T t5) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
