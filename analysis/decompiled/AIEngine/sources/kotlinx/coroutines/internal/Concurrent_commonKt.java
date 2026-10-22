package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Concurrent_commonKt {
    public static final <T> T getValue(AtomicReference<T> atomicReference) {
        return atomicReference.get();
    }

    public static final <T> void setValue(AtomicReference<T> atomicReference, T t8) {
        atomicReference.set(t8);
    }
}
