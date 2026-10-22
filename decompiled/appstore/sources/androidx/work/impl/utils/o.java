package androidx.work.impl.utils;

import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class o implements SerialExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque f5836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f5837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f5838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f5839d;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o f5840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Runnable f5841b;

        public a(o r10, Runnable r11) {
            this.f5840a = r10;
            this.f5841b = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5841b.run();     // Catch: Throwable -> L11
            Object r10 = this.f5840a.f5839d;
            monitor-enter(r10);
            this.f5840a.a();     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L11:
            th = move-exception;
            monitor-enter(this.f5840a.f5839d);
            this.f5840a.a();     // Catch: Throwable -> L17
            throw th;
        L17:
            th = move-exception;
            throw th;
        }
    }

    public o(Executor r10) {
        this.f5837b = r10;
        this.f5836a = new ArrayDeque();
        this.f5839d = new Object();
    }

    public void a() {
        Runnable r10 = (Runnable) this.f5836a.poll();
        this.f5838c = r10;
        if (r10 == null) goto L6;
        this.f5837b.execute(r10);
        return;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r10) {
        Object r11 = this.f5839d;
        monitor-enter(r11);
        this.f5836a.add(new a(this, r10));     // Catch: Throwable -> L7
        if (this.f5838c != null) goto L9;
        a();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.utils.taskexecutor.SerialExecutor
    public boolean hasPendingTasks() {
        Object r10 = this.f5839d;
        monitor-enter(r10);
        boolean r11 = !this.f5836a.isEmpty();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }
}
