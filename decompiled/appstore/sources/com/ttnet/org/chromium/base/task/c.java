package com.ttnet.org.chromium.base.task;

import android.os.AsyncTask;
import android.os.Process;
import androidx.appcompat.widget.p;
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
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes4.dex */
public class c extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f18347a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f18348b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f18349c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadFactory f18350d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final BlockingQueue f18351e = null;

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f18352a;

        public a() {
            this.f18352a = new AtomicInteger(1);
        }

        public static /* synthetic */ void a(Runnable r10) {
            b(r10);
        }

        public static /* synthetic */ void b(Runnable r10) {
            Process.setThreadPriority(10);
            r10.run();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable r10) {
            return new Thread(new b(r10), "CrAsyncTask #" + this.f18352a.getAndIncrement());
        }
    }

    static {
        int r10 = Runtime.getRuntime().availableProcessors();
        f18347a = r10;
        f18348b = Math.max(2, Math.min(r10 - 1, 4));
        f18349c = (r10 * 2) + 1;
        f18350d = new a();
        f18351e = new ArrayBlockingQueue(128);
    }

    public c() {
        this(f18348b, f18349c, 30, TimeUnit.SECONDS, f18351e, f18350d);
    }

    public static String b(Runnable r10) {
        Class<?> r11 = r10.getClass();
        if (r11 != com.ttnet.org.chromium.base.task.a.class) goto L6;
        p.a(r10);     // Catch: IllegalAccessException -> L8 NoSuchFieldException -> L10
        throw null;
    L6:
        if (r11.getEnclosingClass() != AsyncTask.class) goto L23;
        Field r12 = r11.getDeclaredField("this$0");     // Catch: IllegalAccessException -> L8 NoSuchFieldException -> L10
        r12.setAccessible(true);     // Catch: IllegalAccessException -> L8 NoSuchFieldException -> L10
        r11 = r12.get(r10).getClass();     // Catch: IllegalAccessException -> L8 NoSuchFieldException -> L10
    L23:
        return r11.getName();
    L8:
        e = move-exception;
        if (com.ttnet.org.chromium.base.c.f18315a == false) goto L23;
        throw new RuntimeException(e);
    L10:
        e = move-exception;
        if (com.ttnet.org.chromium.base.c.f18315a == false) goto L23;
        throw new RuntimeException(e);
    }

    public final String a(Map r10) {
        StringBuilder r11 = new StringBuilder();
        Iterator r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Map.Entry r13 = (Map.Entry) r12.next();
        if (((Integer) r13.getValue()).intValue() <= 32) goto L4;
        r11.append((String) r13.getKey());
        r11.append(TokenParser.SP);
        goto L4
    L9:
        if (r11.length() != 0) goto L13;
        return "NO CLASSES FOUND";
    L13:
        return r11.toString();
    }

    public final Map c() {
        HashMap r10 = new HashMap();
        Runnable[] r11 = (Runnable[]) getQueue().toArray(new Runnable[0]);
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        String r14 = b(r11[r13]);
        if (r10.containsKey(r14) == false) goto L7;
        int r15 = ((Integer) r10.get(r14)).intValue();
    L8:
        r10.put(r14, Integer.valueOf(r15 + 1));
        r13 = r13 + 1;
        goto L3
    L7:
        r15 = 0;
        goto L8
    L9:
        return r10;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable r10) {
        super.execute(r10);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        throw new RejectedExecutionException("Prominent classes in AsyncTask: " + a(c()), e);
    }

    public c(int r10, int r11, long r12, TimeUnit r13, BlockingQueue r14, ThreadFactory r15) {
        super(r10, r11, r12, r13, r14, r15);
        allowCoreThreadTimeOut(true);
    }
}
