package rx.internal.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    public static final ThreadFactory NONE = null;
    private static final long serialVersionUID = -8841098858898482335L;
    final String prefix;

    public static class a implements ThreadFactory {
        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            throw new AssertionError("No threads allowed.");
        }
    }

    static {
        NONE = new a();
    }

    public RxThreadFactory(String r10) {
        this.prefix = r10;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r10) {
        Thread r11 = new Thread(r10, this.prefix + incrementAndGet());
        r11.setDaemon(true);
        return r11;
    }
}
