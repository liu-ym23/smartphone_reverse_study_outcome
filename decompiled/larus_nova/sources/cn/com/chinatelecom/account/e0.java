package cn.com.chinatelecom.account;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class e0 extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f24392a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadFactory f24393b = null;

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f24394a;

        public a() {
            this.f24394a = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r100) {
            return new Thread(r100);
        }
    }

    static {
        f24392a = new LinkedBlockingQueue(256);
        f24393b = new a();
    }

    public e0() {
        this(5);
    }

    public e0(int r100) {
        this(r100, r100 * 2, 1, TimeUnit.SECONDS, f24392a, f24393b);
    }

    public e0(int r100, int r101, long r102, TimeUnit r103, BlockingQueue<Runnable> r104, ThreadFactory r105) {
        super(r100, r101, r102, r103, r104, r105);
    }

    public void a(f0 r100) {
        execute(r100);
    }
}
