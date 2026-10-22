package androidx.camera.core.impl.utils.executor;

import B0.h;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class SequentialExecutor implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public final Executor f11528b;

    /* renamed from: a, reason: collision with root package name */
    public final Deque<Runnable> f11527a = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public final b f11529c = new b();

    /* renamed from: d, reason: collision with root package name */
    public WorkerRunningState f11530d = WorkerRunningState.IDLE;

    /* renamed from: e, reason: collision with root package name */
    public long f11531e = 0;

    public enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f11532a;

        public a(Runnable runnable) {
            this.f11532a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11532a.run();
        }
    }

    public final class b implements Runnable {
        public b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x003b, code lost:
        
            if (r1 == false) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0044, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0045, code lost:
        
            r3.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x004b, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:
        
            D.C0761b0.d("SequentialExecutor", "Exception while executing runnable " + r3, r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:?, code lost:
        
            return;
         */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0034 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a() {
            /*
                r9 = this;
                r0 = 0
                r1 = r0
            L2:
                androidx.camera.core.impl.utils.executor.SequentialExecutor r2 = androidx.camera.core.impl.utils.executor.SequentialExecutor.this     // Catch: java.lang.Throwable -> L49
                java.util.Deque<java.lang.Runnable> r2 = r2.f11527a     // Catch: java.lang.Throwable -> L49
                monitor-enter(r2)     // Catch: java.lang.Throwable -> L49
                if (r0 != 0) goto L28
                androidx.camera.core.impl.utils.executor.SequentialExecutor r0 = androidx.camera.core.impl.utils.executor.SequentialExecutor.this     // Catch: java.lang.Throwable -> L1c
                androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r3 = r0.f11530d     // Catch: java.lang.Throwable -> L1c
                androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r4 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.RUNNING     // Catch: java.lang.Throwable -> L1c
                if (r3 != r4) goto L1e
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
                if (r1 == 0) goto L3e
            L14:
                java.lang.Thread r9 = java.lang.Thread.currentThread()
                r9.interrupt()
                goto L3e
            L1c:
                r9 = move-exception
                goto L63
            L1e:
                long r5 = r0.f11531e     // Catch: java.lang.Throwable -> L1c
                r7 = 1
                long r5 = r5 + r7
                r0.f11531e = r5     // Catch: java.lang.Throwable -> L1c
                r0.f11530d = r4     // Catch: java.lang.Throwable -> L1c
                r0 = 1
            L28:
                androidx.camera.core.impl.utils.executor.SequentialExecutor r3 = androidx.camera.core.impl.utils.executor.SequentialExecutor.this     // Catch: java.lang.Throwable -> L1c
                java.util.Deque<java.lang.Runnable> r3 = r3.f11527a     // Catch: java.lang.Throwable -> L1c
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L1c
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L1c
                if (r3 != 0) goto L3f
                androidx.camera.core.impl.utils.executor.SequentialExecutor r9 = androidx.camera.core.impl.utils.executor.SequentialExecutor.this     // Catch: java.lang.Throwable -> L1c
                androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r0 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.IDLE     // Catch: java.lang.Throwable -> L1c
                r9.f11530d = r0     // Catch: java.lang.Throwable -> L1c
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
                if (r1 == 0) goto L3e
                goto L14
            L3e:
                return
            L3f:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
                boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L49
                r1 = r1 | r2
                r3.run()     // Catch: java.lang.Throwable -> L49 java.lang.RuntimeException -> L4b
                goto L2
            L49:
                r9 = move-exception
                goto L65
            L4b:
                r2 = move-exception
                java.lang.String r4 = "SequentialExecutor"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L49
                r5.<init>()     // Catch: java.lang.Throwable -> L49
                java.lang.String r6 = "Exception while executing runnable "
                r5.append(r6)     // Catch: java.lang.Throwable -> L49
                r5.append(r3)     // Catch: java.lang.Throwable -> L49
                java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L49
                D.C0761b0.d(r4, r3, r2)     // Catch: java.lang.Throwable -> L49
                goto L2
            L63:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
                throw r9     // Catch: java.lang.Throwable -> L49
            L65:
                if (r1 == 0) goto L6e
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L6e:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.executor.SequentialExecutor.b.a():void");
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a();
            } catch (Error e10) {
                synchronized (SequentialExecutor.this.f11527a) {
                    SequentialExecutor.this.f11530d = WorkerRunningState.IDLE;
                    throw e10;
                }
            }
        }
    }

    public SequentialExecutor(Executor executor) {
        this.f11528b = (Executor) h.f(executor);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x005f  */
    @Override // java.util.concurrent.Executor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void execute(java.lang.Runnable r8) {
        /*
            r7 = this;
            B0.h.f(r8)
            java.util.Deque<java.lang.Runnable> r0 = r7.f11527a
            monitor-enter(r0)
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r1 = r7.f11530d     // Catch: java.lang.Throwable -> L6b
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r2 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.RUNNING     // Catch: java.lang.Throwable -> L6b
            if (r1 == r2) goto L6d
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r2 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.QUEUED     // Catch: java.lang.Throwable -> L6b
            if (r1 != r2) goto L11
            goto L6d
        L11:
            long r3 = r7.f11531e     // Catch: java.lang.Throwable -> L6b
            androidx.camera.core.impl.utils.executor.SequentialExecutor$a r1 = new androidx.camera.core.impl.utils.executor.SequentialExecutor$a     // Catch: java.lang.Throwable -> L6b
            r1.<init>(r8)     // Catch: java.lang.Throwable -> L6b
            java.util.Deque<java.lang.Runnable> r8 = r7.f11527a     // Catch: java.lang.Throwable -> L6b
            r8.add(r1)     // Catch: java.lang.Throwable -> L6b
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r8 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.QUEUING     // Catch: java.lang.Throwable -> L6b
            r7.f11530d = r8     // Catch: java.lang.Throwable -> L6b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6b
            java.util.concurrent.Executor r0 = r7.f11528b     // Catch: java.lang.Throwable -> L44
            androidx.camera.core.impl.utils.executor.SequentialExecutor$b r5 = r7.f11529c     // Catch: java.lang.Throwable -> L44
            r0.execute(r5)     // Catch: java.lang.Throwable -> L44
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r0 = r7.f11530d
            if (r0 == r8) goto L2e
            return
        L2e:
            java.util.Deque<java.lang.Runnable> r0 = r7.f11527a
            monitor-enter(r0)
            long r5 = r7.f11531e     // Catch: java.lang.Throwable -> L3e
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 != 0) goto L40
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r1 = r7.f11530d     // Catch: java.lang.Throwable -> L3e
            if (r1 != r8) goto L40
            r7.f11530d = r2     // Catch: java.lang.Throwable -> L3e
            goto L40
        L3e:
            r7 = move-exception
            goto L42
        L40:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            return
        L42:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            throw r7
        L44:
            r8 = move-exception
            java.util.Deque<java.lang.Runnable> r2 = r7.f11527a
            monitor-enter(r2)
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r0 = r7.f11530d     // Catch: java.lang.Throwable -> L53
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r3 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.IDLE     // Catch: java.lang.Throwable -> L53
            if (r0 == r3) goto L55
            androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState r3 = androidx.camera.core.impl.utils.executor.SequentialExecutor.WorkerRunningState.QUEUING     // Catch: java.lang.Throwable -> L53
            if (r0 != r3) goto L5f
            goto L55
        L53:
            r7 = move-exception
            goto L69
        L55:
            java.util.Deque<java.lang.Runnable> r7 = r7.f11527a     // Catch: java.lang.Throwable -> L53
            boolean r7 = r7.removeLastOccurrence(r1)     // Catch: java.lang.Throwable -> L53
            if (r7 == 0) goto L5f
            r7 = 1
            goto L60
        L5f:
            r7 = 0
        L60:
            boolean r0 = r8 instanceof java.util.concurrent.RejectedExecutionException     // Catch: java.lang.Throwable -> L53
            if (r0 == 0) goto L68
            if (r7 != 0) goto L68
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L53
            return
        L68:
            throw r8     // Catch: java.lang.Throwable -> L53
        L69:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L53
            throw r7
        L6b:
            r7 = move-exception
            goto L74
        L6d:
            java.util.Deque<java.lang.Runnable> r7 = r7.f11527a     // Catch: java.lang.Throwable -> L6b
            r7.add(r8)     // Catch: java.lang.Throwable -> L6b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6b
            return
        L74:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6b
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.executor.SequentialExecutor.execute(java.lang.Runnable):void");
    }
}
