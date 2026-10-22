package bytekn.foundation.concurrent.scheduler;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ThreadFactory;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ThreadFactoryImpl implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f21738a = null;

    public static final class a {
    }

    static {
        f21738a = LazyKt.lazy(ThreadFactoryImpl$Companion$factory$2.INSTANCE);
    }

    public ThreadFactoryImpl() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        Thread r101 = ((ThreadFactory) f21738a.getValue()).newThread(r100);
        ThreadMethodProxy.setName(r101, "IO, " + r101.getName());
        r101.setDaemon(true);
        return r101;
    }
}
