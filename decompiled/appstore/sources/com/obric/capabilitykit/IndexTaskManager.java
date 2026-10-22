package com.obric.capabilitykit;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Keep;
import com.obric.capabilitykit.logger.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0002J\r\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\u0018\u0010\u0017\u001a\u00020\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0019J\"\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0019J\u0018\u0010\u001c\u001a\u00020\u00152\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010\r\u001a&\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f \u0010*\u0012\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/capabilitykit/IndexTaskManager;", "", "()V", "DELAY_MILLIS", "", "MSG_EXECUTE_TASK", "", "TAG", "", "currentHandlerThread", "Landroid/os/HandlerThread;", "handler", "Landroid/os/Handler;", "pendingTaskList", "", "Lcom/obric/capabilitykit/IndexTaskManager$PendingIndexTask;", "kotlin.jvm.PlatformType", "", "getFullTaskName", "taskName", "init", "", "init$capabilitykit_release", "postTask", "task", "Ljava/lang/Runnable;", "postTaskDelay", "delayTimeMs", "runTask", "scheduleRestoreHistoryProcessTask", "IndexTask", "PendingIndexTask", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IndexTaskManager {
    private static final long DELAY_MILLIS = 60000;

    @NotNull
    public static final IndexTaskManager INSTANCE = null;
    private static final int MSG_EXECUTE_TASK = 1;

    @NotNull
    private static final String TAG = "IndexTaskManager";

    @Nullable
    private static volatile HandlerThread currentHandlerThread;

    @Nullable
    private static volatile Handler handler;
    private static final List<b> pendingTaskList = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f11215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f11216b;

        public a(String r10, Runnable r11) {
            kotlin.jvm.internal.q.g(r11, "runnable");
            this.f11215a = r11;
            this.f11216b = IndexTaskManager.access$getFullTaskName(IndexTaskManager.INSTANCE, r10);
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger r10 = Logger.INSTANCE;
            r10.i(IndexTaskManager.TAG, "Task: " + this.f11216b + ", start");
            long r11 = System.currentTimeMillis();
            this.f11215a.run();
            r10.i(IndexTaskManager.TAG, "Task: " + this.f11216b + " end, costTime: " + (System.currentTimeMillis() - r11));
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f11217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f11218b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f11219c;

        public b(long r10, String r11, Runnable r12) {
            kotlin.jvm.internal.q.g(r12, "runnable");
            this.f11217a = r10;
            this.f11218b = r11;
            this.f11219c = r12;
        }

        public final long a() {
            return this.f11217a;
        }

        public final Runnable b() {
            return this.f11219c;
        }

        public final String c() {
            return this.f11218b;
        }
    }

    public static final class c extends HandlerThread {

        public static final class a extends Handler {
            public a(Looper r10) {
                super(r10);
            }

            @Override // android.os.Handler
            public void handleMessage(Message r10) {
                kotlin.jvm.internal.q.g(r10, "msg");
                if (r10.what != 1) goto L6;
                p.f11375a.f();
                return;
            }
        }

        public c() {
            super("EntityProviderThread");
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            IndexTaskManager r10 = IndexTaskManager.INSTANCE;
            monitor-enter(r10);
            IndexTaskManager.access$setHandler$p(new a(getLooper()));     // Catch: Throwable -> L8
            List r11 = IndexTaskManager.access$getPendingTaskList$p();     // Catch: Throwable -> L8
            kotlin.jvm.internal.q.f(r11, "pendingTaskList");     // Catch: Throwable -> L8
            Iterator r12 = r11.iterator();     // Catch: Throwable -> L8
        L6:
            if (r12.hasNext() == false) goto L10;
            b r13 = (b) r12.next();     // Catch: Throwable -> L8
            IndexTaskManager.INSTANCE.postTaskDelay(r13.a(), r13.c(), r13.b());     // Catch: Throwable -> L8
            goto L6
        L10:
            IndexTaskManager.access$getPendingTaskList$p().clear();     // Catch: Throwable -> L8
            monitor-exit(r10);
            return;
        L8:
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

    public static final /* synthetic */ String access$getFullTaskName(IndexTaskManager r10, String r11) {
        return r10.getFullTaskName(r11);
    }

    public static final /* synthetic */ List access$getPendingTaskList$p() {
        return pendingTaskList;
    }

    public static final /* synthetic */ void access$setHandler$p(Handler r10) {
        handler = r10;
    }

    private final String getFullTaskName(String r10) {
        StringBuilder r11 = new StringBuilder();
        if (r10 == null) goto L6;
        String r12 = r10 + '_';
        if (r12 == null) goto L6;
    L7:
        r11.append(r12);
        r11.append(System.currentTimeMillis());
        return r11.toString();
    L6:
        r12 = "";
        goto L7
    }

    public static /* synthetic */ void postTaskDelay$default(IndexTaskManager r10, long r11, String r12, Runnable r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L5;
        r12 = null;
    L5:
        r10.postTaskDelay(r11, r12, r13);
    }

    public final synchronized void init$capabilitykit_release() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (handler != null) goto L15;
        HandlerThread r10 = currentHandlerThread;     // Catch: Throwable -> L10
        if (r10 != null) goto L8;
    L12:
        c r11 = new c();     // Catch: Throwable -> L10
        currentHandlerThread = r11;     // Catch: Throwable -> L10
        r11.start();     // Catch: Throwable -> L10
        Logger.INSTANCE.d(TAG, "IndexTaskManager thread start");     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L8:
        if (r10.isAlive() != true) goto L12;
    L15:
        monitor-exit(this);
    }

    public final synchronized void postTask(@Nullable String r10, @NotNull Runnable r11) {
        monitor-enter(this);
        kotlin.jvm.internal.q.g(r11, "task");     // Catch: Throwable -> L6
        postTaskDelay(0, r10, r11);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void postTaskDelay(long r10, @Nullable String r11, @NotNull Runnable r12) {
        monitor-enter(this);
        kotlin.jvm.internal.q.g(r12, "task");     // Catch: Throwable -> L8
        if (handler != null) goto L10;
        Logger.INSTANCE.d(TAG, "postPending: " + r11);     // Catch: Throwable -> L8
        pendingTaskList.add(new b(r10, r11, r12));     // Catch: Throwable -> L8
        init$capabilitykit_release();     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L10:
        Logger.INSTANCE.d(TAG, "postTaskDelay: " + r11);     // Catch: Throwable -> L8
        Handler r13 = handler;     // Catch: Throwable -> L8
        if (r13 == null) goto L13;
        r13.postDelayed(new a(r11, r12), r10);     // Catch: Throwable -> L8
    L13:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void runTask(@Nullable String r10, @NotNull Runnable r11) {
        kotlin.jvm.internal.q.g(r11, "task");
        Looper r12 = Looper.myLooper();
        if (r12 == null) goto L11;
        Handler r13 = handler;
        if (r13 == null) goto L7;
        Looper r14 = r13.getLooper();
    L9:
        if (kotlin.jvm.internal.q.b(r14, r12) == false) goto L11;
        new a(r10, r11).run();
        return;
    L7:
        r14 = null;
    L11:
        postTask(r10, r11);
    }

    public final void scheduleRestoreHistoryProcessTask() {
        Handler r10 = handler;
        if (r10 != null) goto L5;
        Logger.INSTANCE.e(TAG, "scheduleRestoreHistoryProcessTask handler is null");
        return;
    L5:
        if (r10.hasMessages(1) == false) goto L7;
        return;
    L7:
        Logger.INSTANCE.i(TAG, "scheduleRestoreHistoryProcessTask send");
        r10.sendEmptyMessageDelayed(1, 60000);
    }
}
