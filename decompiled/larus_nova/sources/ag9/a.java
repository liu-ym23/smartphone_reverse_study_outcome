package ag9;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PThreadPoolExecutor f3362a = null;

    /* JADX INFO: renamed from: ag9.a$a, reason: collision with other inner class name */
    public static final class ThreadFactoryC0066a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f3363a;

        public ThreadFactoryC0066a() {
            this.f3363a = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            Intrinsics.checkNotNullParameter(r100, "r");
            return new PthreadThreadV2(new ThreadGroup("flow_a"), r100, "flow_a_launch" + this.f3363a.getAndIncrement(), 0);
        }
    }

    static {
        ThreadFactoryC0066a r100 = new ThreadFactoryC0066a();
        int r101 = Runtime.getRuntime().availableProcessors();
        PThreadPoolExecutor r102 = new PThreadPoolExecutor(r101 + 1, (r101 * 2) + 1, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), r100);
        r102.allowCoreThreadTimeOut(true);
        f3362a = r102;
    }
}
