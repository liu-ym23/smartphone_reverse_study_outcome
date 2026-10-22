package com.obric.capabilitykit;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.obric.capabilitykit.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class IndexTaskManager {
    private static final long DELAY_MILLIS = 60000;
    public static final IndexTaskManager INSTANCE = null;
    private static final int MSG_EXECUTE_TASK = 1;
    private static final String TAG = "IndexTaskManager";
    private static volatile HandlerThread currentHandlerThread;
    private static volatile Handler handler;
    private static final List<b> pendingTaskList = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f31996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f31997b;

        public a(String r3, Runnable r4) {
            Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "runnable");
            this.f31996a = r5;
            this.f31997b = IndexTaskManager.access$getFullTaskName(IndexTaskManager.INSTANCE, r3);
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger r0 = Logger.INSTANCE;
            r0.i(IndexTaskManager.TAG, "Task: " + this.f31997b + ", start");
            long r4 = System.currentTimeMillis();
            this.f31996a.run();
            r0.i(IndexTaskManager.TAG, "Task: " + this.f31997b + " end, costTime: " + (System.currentTimeMillis() - r4));
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f31998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f31999b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Runnable f32000c;

        public b(long r3, String r5, Runnable r6) {
            Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r7, "runnable");
            this.f31998a = r3;
            this.f31999b = r5;
            this.f32000c = r7;
        }

        public final long a() {
            return this.f31998a;
        }

        public final String b() {
            return this.f31999b;
        }

        public final Runnable c() {
            return this.f32000c;
        }
    }

    public static final class c extends HandlerThread {

        public static final class a extends Handler {
            public a(Looper r1) {
                super(r1);
            }

            @Override // android.os.Handler
            public void handleMessage(Message r1) {
                d.h.b.o.e(r1, "msg");
                if (r1.what != 1) goto L6;
                l.f32157a.a();
                return;
            }
        }

        public c() {
            super("EntityProviderThread");
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            IndexTaskManager r0 = IndexTaskManager.INSTANCE;
            monitor-enter(r0);
            IndexTaskManager.access$setHandler$p(new a(getLooper()));     // Catch: Throwable -> L11
            List r6 = IndexTaskManager.access$getPendingTaskList$p();     // Catch: Throwable -> L11
            d.h.b.o.c(r6, "pendingTaskList");     // Catch: Throwable -> L11
            Iterator r7 = r6.iterator();     // Catch: Throwable -> L11
        L6:
            if (r7.hasNext() == false) goto L8;
            b r1 = (b) ZeusTransformUtils.preCheckCast(r7.next(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
            IndexTaskManager.INSTANCE.postTaskDelay(r1.a(), r1.b(), r1.c());     // Catch: Throwable -> L11
            goto L6
        L8:
            IndexTaskManager.access$getPendingTaskList$p().clear();     // Catch: Throwable -> L11
            monitor-exit(r0);
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    static {
        INSTANCE = new IndexTaskManager();
        pendingTaskList = Collections.synchronizedList(new ArrayList());
    }

    private IndexTaskManager() {
    }

    public static final /* synthetic */ String access$getFullTaskName(IndexTaskManager r0, String r1) {
        return r0.getFullTaskName(r1);
    }

    public static final /* synthetic */ List access$getPendingTaskList$p() {
        return pendingTaskList;
    }

    public static final /* synthetic */ void access$setHandler$p(Handler r0) {
        handler = r0;
    }

    private final String getFullTaskName(String r3) {
        StringBuilder r2 = new StringBuilder();
        if (r3 == null) goto L6;
        String r4 = r3 + '_';
        if (r4 == null) goto L6;
    L8:
        return r2.append(r4).append(System.currentTimeMillis()).toString();
    L6:
        r4 = "";
        goto L8
    }

    public static /* synthetic */ void postTaskDelay$default(IndexTaskManager r1, long r2, String r4, Runnable r5, int r6, Object r7) {
        Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L5;
        r4 = null;
    L5:
        r1.postTaskDelay(r2, r4, r8);
    }

    public final synchronized void init$capabilitykit_release() {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (handler != null) goto L16;
        HandlerThread r0 = currentHandlerThread;     // Catch: Throwable -> L18
        boolean r1 = true;
        if (r0 != null) goto L8;
    L10:
        r1 = false;
    L11:
        if (r1 == true) goto L16;
        c r2 = new c();     // Catch: Throwable -> L18
        currentHandlerThread = r2;     // Catch: Throwable -> L18
        r2.start();     // Catch: Throwable -> L18
        Logger.INSTANCE.d(TAG, "IndexTaskManager thread start");     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L8:
        if (r0.isAlive() != true) goto L10;
    L16:
        monitor-exit(this);
    }

    public final synchronized void postTask(String r3, Runnable r4) {
        monitor-enter(this);
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L6
        d.h.b.o.e(r5, "task");     // Catch: Throwable -> L6
        postTaskDelay(0, r3, r5);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void postTaskDelay(long r4, String r6, Runnable r7) {
        monitor-enter(this);
        Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        d.h.b.o.e(r8, "task");     // Catch: Throwable -> L13
        if (handler != null) goto L8;
        Logger.INSTANCE.d(TAG, "postPending: " + r6);     // Catch: Throwable -> L13
        pendingTaskList.add(new b(r4, r6, r8));     // Catch: Throwable -> L13
        init$capabilitykit_release();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L8:
        Logger.INSTANCE.d(TAG, "postTaskDelay: " + r6);     // Catch: Throwable -> L13
        Handler r0 = handler;     // Catch: Throwable -> L13
        if (r0 == null) goto L11;
        r0.postDelayed(new a(r6, r8), r4);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void runTask(String r3, Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "task");
        Looper r0 = Looper.myLooper();
        if (r0 == null) goto L11;
        Handler r1 = handler;
        if (r1 == null) goto L7;
        Looper r2 = r1.getLooper();
    L9:
        if (d.h.b.o.a(r2, r0) == false) goto L11;
        new a(r3, r5).run();
        return;
    L7:
        r2 = null;
    L11:
        postTask(r3, r5);
    }

    public final void scheduleRestoreHistoryProcessTask() {
        Handler r4 = handler;
        if (r4 != null) goto L5;
        Logger.INSTANCE.e(TAG, "scheduleRestoreHistoryProcessTask handler is null");
        return;
    L5:
        if (r4.hasMessages(1) == false) goto L7;
        return;
    L7:
        Logger.INSTANCE.i(TAG, "scheduleRestoreHistoryProcessTask send");
        r4.sendEmptyMessageDelayed(1, DELAY_MILLIS);
    }
}
