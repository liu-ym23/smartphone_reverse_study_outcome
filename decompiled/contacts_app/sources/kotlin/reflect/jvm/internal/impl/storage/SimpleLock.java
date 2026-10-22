package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: locks.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface SimpleLock {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: locks.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public final DefaultSimpleLock simpleLock(Runnable r1, Function1<? super InterruptedException, Unit> r2) {
            if (r1 == null) goto L6;
            if (r2 == null) goto L6;
            return new CancellableSimpleLock(r1, r2);
        L6:
            return new DefaultSimpleLock(null, 1, null);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void lock();

    void unlock();
}
