package kotlinx.coroutines;

import kotlinx.coroutines.internal.ThreadLocalElement;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ThreadContextElementKt {
    public static final <T> ThreadContextElement<T> asContextElement(ThreadLocal<T> threadLocal, T t8) {
        return new ThreadLocalElement(t8, threadLocal);
    }
}
