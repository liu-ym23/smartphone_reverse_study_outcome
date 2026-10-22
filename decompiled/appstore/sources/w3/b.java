package w3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class b extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RejectedExecutionHandler f25357a = null;

    static {
        f25357a = new ThreadPoolExecutor.AbortPolicy();
    }

    public b(int r10, int r11, long r12, TimeUnit r14, BlockingQueue r15, ThreadFactory r16) {
        super(r10, r11, r12, r14, r15, r16, f25357a);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List shutdownNow() {
        return new ArrayList();
    }

    public b(int r10, int r11, long r12, TimeUnit r13, BlockingQueue r14, ThreadFactory r15, RejectedExecutionHandler r16) {
        super(r10, r11, r12, r13, r14, r15, r16);
    }
}
