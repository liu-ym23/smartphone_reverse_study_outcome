package com.obric.capabilitykit;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import com.obric.capabilitykit.logger.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0002J\r\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\u0018\u0010\u0017\u001a\u00020\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0019J\"\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0019J\u0018\u0010\u001c\u001a\u00020\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\r\u001a&\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f \u0010*\u0012\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/capabilitykit/IndexTaskManager;", "", "()V", "DELAY_MILLIS", "", "MSG_EXECUTE_TASK", "", "TAG", "", "currentHandlerThread", "Landroid/os/HandlerThread;", "handler", "Landroid/os/Handler;", "pendingTaskList", "", "Lcom/obric/capabilitykit/IndexTaskManager$PendingIndexTask;", "kotlin.jvm.PlatformType", "", "getFullTaskName", "taskName", "init", "", "init$capabilitykit_release", "postTask", "task", "Ljava/lang/Runnable;", "postTaskDelay", "delayTimeMs", "runTask", "scheduleRestoreHistoryProcessTask", "IndexTask", "PendingIndexTask", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IndexTaskManager {
    private static final long DELAY_MILLIS = 60000;
    public static final IndexTaskManager INSTANCE = null;
    private static final int MSG_EXECUTE_TASK = 1;
    private static final String TAG = "IndexTaskManager";
    private static volatile HandlerThread currentHandlerThread;
    private static volatile Handler handler;
    private static final List<b> pendingTaskList = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/obric/capabilitykit/IndexTaskManager$IndexTask;", "Ljava/lang/Runnable;", "taskName", "", "runnable", "(Ljava/lang/String;Ljava/lang/Runnable;)V", "fullTaskName", "getFullTaskName", "()Ljava/lang/String;", "getRunnable", "()Ljava/lang/Runnable;", "run", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Runnable {
        private final Runnable a;
        private final String b;

        public a(String r2, Runnable r3) {
            Intrinsics.checkNotNullParameter(r3, "runnable");
            this.a = r3;
            this.b = IndexTaskManager.access$getFullTaskName(IndexTaskManager.INSTANCE, r2);
        }

        public final String a() {
            return this.b;
        }

        public final Runnable b() {
            return this.a;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger r0 = Logger.INSTANCE;
            r0.i(IndexTaskManager.TAG, "Task: " + this.b + ", start");
            long r4 = System.currentTimeMillis();
            this.a.run();
            r0.i(IndexTaskManager.TAG, "Task: " + this.b + " end, costTime: " + (System.currentTimeMillis() - r4));
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/IndexTaskManager$PendingIndexTask;", "", "delayTimeMs", "", "taskName", "", "runnable", "Ljava/lang/Runnable;", "(JLjava/lang/String;Ljava/lang/Runnable;)V", "getDelayTimeMs", "()J", "getRunnable", "()Ljava/lang/Runnable;", "getTaskName", "()Ljava/lang/String;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        private final long a;
        private final String b;
        private final Runnable c;

        public b(long r2, String r4, Runnable r5) {
            Intrinsics.checkNotNullParameter(r5, "runnable");
            this.a = r2;
            this.b = r4;
            this.c = r5;
        }

        public final long a() {
            return this.a;
        }

        public final Runnable b() {
            return this.c;
        }

        public final String c() {
            return this.b;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, d2 = {"com/obric/capabilitykit/IndexTaskManager$init$handlerThread$1", "Landroid/os/HandlerThread;", "onLooperPrepared", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends HandlerThread {

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/capabilitykit/IndexTaskManager$init$handlerThread$1$onLooperPrepared$1$1", "Landroid/os/Handler;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class a extends Handler {
            public a(Looper r1) {
                super(r1);
            }

            @Override // android.os.Handler
            public void handleMessage(Message r1) {
                Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_MESSAGE);
                if (r1.what != 1) goto L6;
                p.a.b();
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
            Intrinsics.checkNotNullExpressionValue(r6, "pendingTaskList");     // Catch: Throwable -> L11
            Iterator r7 = r6.iterator();     // Catch: Throwable -> L11
        L6:
            if (r7.hasNext() == false) goto L8;
            b r1 = (b) r7.next();     // Catch: Throwable -> L11
            IndexTaskManager.INSTANCE.postTaskDelay(r1.a(), r1.c(), r1.b());     // Catch: Throwable -> L11
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

    public static /* synthetic */ void postTaskDelay$default(IndexTaskManager r0, long r1, String r3, Runnable r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L5;
        r3 = null;
    L5:
        r0.postTaskDelay(r1, r3, r4);
    }

    public final synchronized void init$capabilitykit_release() {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (handler != null) goto L16;
        HandlerThread r0 = currentHandlerThread;     // Catch: Throwable -> L18
        if (r0 == null) goto L10;
        boolean r1 = true;
        if (r0.isAlive() != true) goto L10;
    L11:
        if (r1 == true) goto L16;
        c r2 = new c();     // Catch: Throwable -> L18
        currentHandlerThread = r2;     // Catch: Throwable -> L18
        r2.start();     // Catch: Throwable -> L18
        Logger.INSTANCE.d(TAG, "IndexTaskManager thread start");     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L10:
        r1 = false;
    L16:
        monitor-exit(this);
    }

    public final synchronized void postTask(String r3, Runnable r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, "task");     // Catch: Throwable -> L6
        postTaskDelay(0, r3, r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void postTaskDelay(long r4, String r6, Runnable r7) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, "task");     // Catch: Throwable -> L14
        if (handler != null) goto L9;
        Logger.INSTANCE.d(TAG, "postPending: " + r6);     // Catch: Throwable -> L14
        pendingTaskList.add(new b(r4, r6, r7));     // Catch: Throwable -> L14
        init$capabilitykit_release();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L9:
        Logger.INSTANCE.d(TAG, "postTaskDelay: " + r6);     // Catch: Throwable -> L14
        Handler r0 = handler;     // Catch: Throwable -> L14
        if (r0 == null) goto L12;
        r0.postDelayed(new a(r6, r7), r4);     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public final void runTask(String r3, Runnable r4) {
        Intrinsics.checkNotNullParameter(r4, "task");
        Looper r0 = Looper.myLooper();
        if (r0 == null) goto L11;
        Handler r1 = handler;
        if (r1 == null) goto L7;
        Looper r2 = r1.getLooper();
    L9:
        if (Intrinsics.areEqual(r2, r0) == false) goto L11;
        new a(r3, r4).run();
        return;
    L7:
        r2 = null;
    L11:
        postTask(r3, r4);
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
        r4.sendEmptyMessageDelayed(1, 60000);
    }
}
