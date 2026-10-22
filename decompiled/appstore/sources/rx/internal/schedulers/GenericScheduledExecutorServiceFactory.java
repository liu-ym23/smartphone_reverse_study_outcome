package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import rx.functions.Func0;
import rx.internal.util.RxThreadFactory;

/* JADX INFO: loaded from: classes4.dex */
final enum GenericScheduledExecutorServiceFactory extends Enum<GenericScheduledExecutorServiceFactory> {
    private static final /* synthetic */ GenericScheduledExecutorServiceFactory[] $VALUES = null;
    static final RxThreadFactory THREAD_FACTORY = null;
    static final String THREAD_NAME_PREFIX = "RxScheduledExecutorPool-";

    static {
        $VALUES = new GenericScheduledExecutorServiceFactory[0];
        THREAD_FACTORY = new RxThreadFactory(THREAD_NAME_PREFIX);
    }

    private GenericScheduledExecutorServiceFactory(String r10, int r11) {
        super(r10, r11);
    }

    public static ScheduledExecutorService create() {
        Func0 r10 = og.c.a();
        if (r10 != null) goto L7;
        return createDefault();
    L7:
        return (ScheduledExecutorService) r10.call();
    }

    public static ScheduledExecutorService createDefault() {
        return Executors.newScheduledThreadPool(1, threadFactory());
    }

    public static ThreadFactory threadFactory() {
        return THREAD_FACTORY;
    }

    public static GenericScheduledExecutorServiceFactory valueOf(String r10) {
        return (GenericScheduledExecutorServiceFactory) Enum.valueOf(GenericScheduledExecutorServiceFactory.class, r10);
    }

    public static GenericScheduledExecutorServiceFactory[] values() {
        return (GenericScheduledExecutorServiceFactory[]) $VALUES.clone();
    }
}
