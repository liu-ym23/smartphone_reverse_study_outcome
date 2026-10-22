package t3;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class f {
    static {
        TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15L).longValue());
    }

    public abstract e b();
}
