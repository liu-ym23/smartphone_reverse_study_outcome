package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: Concurrent.common.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class g {
    public static final <T> T a(AtomicReference<T> r0) {
        return r0.get();
    }

    public static final <T> void a(AtomicReference<T> r0, T r1) {
        r0.set(r1);
    }
}
