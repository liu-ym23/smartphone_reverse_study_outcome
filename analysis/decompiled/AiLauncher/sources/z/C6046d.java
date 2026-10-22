package z;

import La.H;
import android.os.Process;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u000e*\u00020\u00042\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u0011*\u00020\u00042\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lz/d;", "", "<init>", "()V", "Ljava/util/concurrent/ThreadFactory;", "", "androidPriority", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/util/concurrent/ThreadFactory;I)Ljava/util/concurrent/ThreadFactory;", "", "namePrefix", "k", "(Ljava/util/concurrent/ThreadFactory;Ljava/lang/String;)Ljava/util/concurrent/ThreadFactory;", "threads", "Ljava/util/concurrent/ExecutorService;", "e", "(Ljava/util/concurrent/ThreadFactory;I)Ljava/util/concurrent/ExecutorService;", "Ljava/util/concurrent/ScheduledExecutorService;", "f", "(Ljava/util/concurrent/ThreadFactory;I)Ljava/util/concurrent/ScheduledExecutorService;", Const.INTENT_KEY_UMID, "(I)I", "", Const.INTENT_KEY_PKGNAME, "[I", "NICE_VALUES", "c", "Ljava/util/concurrent/ThreadFactory;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/concurrent/ThreadFactory;", "factory", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: z.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6046d {

    /* renamed from: a, reason: collision with root package name */
    public static final C6046d f44499a = new C6046d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final int[] NICE_VALUES = {19, 16, 13, 10, 0, -2, -4, -5, -6, -8};

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final ThreadFactory factory;

    static {
        ThreadFactory threadFactoryDefaultThreadFactory = Executors.defaultThreadFactory();
        kotlin.jvm.internal.p.h(threadFactoryDefaultThreadFactory, "defaultThreadFactory(...)");
        factory = threadFactoryDefaultThreadFactory;
    }

    public static final Thread i(final int i10, ThreadFactory threadFactory, final Runnable runnable) {
        int iD = f44499a.d(i10);
        Thread threadNewThread = threadFactory.newThread(new Runnable() { // from class: z.c
            @Override // java.lang.Runnable
            public final void run() throws SecurityException, IllegalArgumentException {
                C6046d.j(i10, runnable);
            }
        });
        kotlin.jvm.internal.p.h(threadNewThread, "newThread(...)");
        threadNewThread.setPriority(iD);
        return threadNewThread;
    }

    public static final void j(int i10, Runnable runnable) throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(i10);
        runnable.run();
    }

    public static final Thread l(ThreadFactory threadFactory, String str, Oa.c cVar, Runnable runnable) {
        Thread threadNewThread = threadFactory.newThread(runnable);
        kotlin.jvm.internal.p.h(threadNewThread, "newThread(...)");
        threadNewThread.setName(str + H.J0(String.valueOf(cVar.d()), 2, '0'));
        return threadNewThread;
    }

    public final int d(int androidPriority) {
        int length = NICE_VALUES.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (androidPriority >= NICE_VALUES[i10]) {
                return i10 + 1;
            }
        }
        return 10;
    }

    public final ExecutorService e(ThreadFactory threadFactory, int i10) {
        kotlin.jvm.internal.p.i(threadFactory, "<this>");
        if (i10 > 0) {
            ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(i10, threadFactory);
            kotlin.jvm.internal.p.h(executorServiceNewFixedThreadPool, "newFixedThreadPool(...)");
            return executorServiceNewFixedThreadPool;
        }
        throw new IllegalArgumentException(("Threads (" + i10 + ") must be > 0").toString());
    }

    public final ScheduledExecutorService f(ThreadFactory threadFactory, int i10) {
        kotlin.jvm.internal.p.i(threadFactory, "<this>");
        if (i10 > 0) {
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(i10, threadFactory);
            kotlin.jvm.internal.p.h(scheduledExecutorServiceNewScheduledThreadPool, "newScheduledThreadPool(...)");
            return scheduledExecutorServiceNewScheduledThreadPool;
        }
        throw new IllegalArgumentException(("Threads (" + i10 + ") must be > 0").toString());
    }

    public final ThreadFactory g() {
        return factory;
    }

    public final ThreadFactory h(final ThreadFactory threadFactory, final int i10) {
        kotlin.jvm.internal.p.i(threadFactory, "<this>");
        return new ThreadFactory() { // from class: z.a
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return C6046d.i(i10, threadFactory, runnable);
            }
        };
    }

    public final ThreadFactory k(final ThreadFactory threadFactory, final String namePrefix) {
        kotlin.jvm.internal.p.i(threadFactory, "<this>");
        kotlin.jvm.internal.p.i(namePrefix, "namePrefix");
        final Oa.c cVarC = Oa.b.c(0);
        return new ThreadFactory() { // from class: z.b
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return C6046d.l(threadFactory, namePrefix, cVarC, runnable);
            }
        };
    }
}
