package com.ttnet.org.chromium.base.task;

import android.os.AsyncTask;
import android.os.Process;
import com.ttnet.org.chromium.build.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ChromeThreadPoolExecutor.java */
/* JADX INFO: loaded from: classes4.dex */
class d extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f37749a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f37750b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f37751c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ThreadFactory f37752d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f37753e = null;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.task.d$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChromeThreadPoolExecutor.java */
    class AnonymousClass1 implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f37754a;

        public static /* synthetic */ void lambda$gC8eRtpJ5xdIPPoGxgSwGeg0G2A(Runnable r0) {
            a(r0);
        }

        AnonymousClass1() {
            this.f37754a = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r4) {
            final Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
            return new Thread(new $$Lambda$d$1$gC8eRtpJ5xdIPPoGxgSwGeg0G2A(r5), "CrAsyncTask #" + this.f37754a.getAndIncrement());
        }

        private static /* synthetic */ void a(Runnable r2) {
            Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
            Process.setThreadPriority(10);
            r3.run();
        }
    }

    static {
        int r0 = Runtime.getRuntime().availableProcessors();
        f37749a = r0;
        f37750b = Math.max(2, Math.min(r0 - 1, 4));
        f37751c = (r0 * 2) + 1;
        f37752d = new AnonymousClass1();
        f37753e = new ArrayBlockingQueue(128);
    }

    d() {
        this(f37750b, f37751c, 30, TimeUnit.SECONDS, f37753e, f37752d);
    }

    d(int r11, int r12, long r13, TimeUnit r15, BlockingQueue<Runnable> r16, ThreadFactory r17) {
        super(r11, r12, r13, r15, (BlockingQueue) ZeusTransformUtils.wrapperContextForParams(r16, BlockingQueue.class, "com.obric.aiagent.plugin"), (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r17, ThreadFactory.class, "com.obric.aiagent.plugin"));
        allowCoreThreadTimeOut(true);
    }

    private static String a(Runnable r3) {
        Object r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        Class r0 = r4.getClass();
        if (r0 != a.C1026a.class) goto L8;
        Class r5 = ((a.C1026a) ZeusTransformUtils.preCheckCast(r4, a.C1026a.class, "com.obric.aiagent.plugin")).a();     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
    L6:
        r0 = r5;
    L21:
        return r0.getName();
    L8:
        if (r0.getEnclosingClass() != AsyncTask.class) goto L21;
        Field r1 = r0.getDeclaredField("this$0");     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
        r1.setAccessible(true);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
        r5 = r1.get(r4).getClass();     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
    L11:
        e = move-exception;
        if (BuildConfig.ENABLE_ASSERTS == false) goto L21;
        throw new RuntimeException(e);
    L17:
        e = move-exception;
        if (BuildConfig.ENABLE_ASSERTS == false) goto L21;
        throw new RuntimeException(e);
    }

    private Map<String, Integer> a() {
        HashMap r0 = new HashMap();
        Runnable[] r8 = (Runnable[]) ZeusTransformUtils.preCheckCast(getQueue().toArray(new Runnable[0]), Runnable[].class, "com.obric.aiagent.plugin");
        int r2 = r8.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L9;
        String r5 = a(r8[r4]);
        if (r0.containsKey(r5) == false) goto L7;
        int r6 = ((Integer) ZeusTransformUtils.preCheckCast(r0.get(r5), Integer.class, "com.obric.aiagent.plugin")).intValue();
    L8:
        r0.put(r5, Integer.valueOf(r6 + 1));
        r4 = r4 + 1;
        goto L3
    L7:
        r6 = 0;
        goto L8
    L9:
        return r0;
    }

    private String a(Map<String, Integer> r5) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        StringBuilder r6 = new StringBuilder();
        Iterator r7 = r4.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (((Integer) ZeusTransformUtils.preCheckCast(r1.getValue(), Integer.class, "com.obric.aiagent.plugin")).intValue() <= 32) goto L4;
        r6.append((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.aiagent.plugin")).append(' ');
        goto L4
    L9:
        if (r6.length() != 0) goto L13;
        return "NO CLASSES FOUND";
    L13:
        return r6.toString();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable r5) {
        super.execute((Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin"));     // Catch: RejectedExecutionException -> L5
        return;
    L5:
        e = move-exception;
        throw new RejectedExecutionException("Prominent classes in AsyncTask: " + a(a()), e);
    }
}
