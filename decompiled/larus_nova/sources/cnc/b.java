package cnc;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ThreadPoolExecutor f24595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Deque<a> f24596b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Deque<a> f24597c = null;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f24598a;

        @Override // java.lang.Runnable
        public void run() {
            com_ss_videoarch_liveplayer_utils_LiveThreadPool$AsyncRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_videoarch_liveplayer_utils_LiveThreadPool$AsyncRunnable__run$___twin___() {
            this.f24598a.run();
            b.access$000(this);
        }

        public a(Runnable r100) {
            this.f24598a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_videoarch_liveplayer_utils_LiveThreadPool$AsyncRunnable_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_ss_videoarch_liveplayer_utils_LiveThreadPool$AsyncRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public b() {
    }

    static {
        f24596b = new ArrayDeque();
        f24597c = new ArrayDeque();
    }

    private static void _promoteRunnable() {
        Deque<a> r100 = f24596b;
        if (((ArrayDeque) r100).size() <= 0) goto L8;
        Iterator r101 = ((ArrayDeque) r100).iterator();
        if (r101.hasNext() == false) goto L9;
        a r102 = (a) r101.next();
        r101.remove();
        ((ArrayDeque) f24597c).add(r102);
        f24595a.execute(r102);
        return;
    L9:
        return;
    }

    public static ThreadPoolExecutor getExecutorInstance() {
        if (f24595a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f24595a != null) goto L9;
        f24595a = new PThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory("iveThreadPool"));     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f24595a;
    }

    public static int getPoolSize() {
        if (f24595a != null) goto L6;
        getExecutorInstance();
    L6:
        return f24595a.getPoolSize();
    }

    public static void shutdown() {
        if (f24595a == null) goto L6;
        f24595a.shutdown();
        return;
    }

    private static synchronized void _finished(a r100) {
        monitor-enter(b.class);
        ((ArrayDeque) f24597c).remove(r100);     // Catch: Throwable -> L7
        _promoteRunnable();     // Catch: Throwable -> L7
        monitor-exit(b.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void access$000(a r100) {
        _finished(r100);
    }

    public static synchronized Future addExecuteTask(Runnable r100) {
        monitor-enter(b.class);
        if (r100 != null) goto L22;
        monitor-exit(b.class);
        return null;
    L22:
    L19:
        th = move-exception;
        throw th;
    L9:
        if (f24595a != null) goto L11;
        getExecutorInstance();     // Catch: Throwable -> L19
    L11:
        com.ss.videoarch.liveplayer.log.c.d("LiveThreadPool", "addExecuteTask,cur thread num:" + getPoolSize());     // Catch: Throwable -> L19
        a r101 = new a(r100);     // Catch: Throwable -> L19
        Deque<a> r102 = f24597c;     // Catch: Throwable -> L19
        if (((ArrayDeque) r102).size() < 5) goto L16;
        ((ArrayDeque) f24596b).add(r101);     // Catch: Throwable -> L19
        monitor-exit(b.class);
        return null;
    L16:
        ((ArrayDeque) r102).add(r101);     // Catch: Throwable -> L19
        Future<?> r103 = f24595a.submit(r101);     // Catch: Throwable -> L19
        monitor-exit(b.class);
        return r103;
    }

    public static void setExecutorInstance(ThreadPoolExecutor r100) {
        monitor-enter(b.class);
        f24595a = r100;     // Catch: Throwable -> L7
        monitor-exit(b.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
