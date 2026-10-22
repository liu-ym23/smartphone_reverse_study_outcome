package kotlinx.coroutines.scheduling;

import Ua.C1046b;
import Ua.N;
import Y8.t;
import Za.C;
import Za.x;
import androidx.exifinterface.media.ExifInterface;
import bb.AbstractRunnableC1472g;
import bb.C1468c;
import bb.C1474i;
import bb.C1476k;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import h9.InterfaceC4149a;
import io.ktor.util.date.GMTDateParser;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.a;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0003ADWB+\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0018\u00010\u0011R\u00020\u0000H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\u00020\u00032\n\u0010\u0014\u001a\u00060\u0011R\u00020\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0003H\u0002¢\u0006\u0004\b \u0010!J+\u0010#\u001a\u0004\u0018\u00010\f*\b\u0018\u00010\u0011R\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u000eH\u0002¢\u0006\u0004\b#\u0010$J\u0015\u0010%\u001a\b\u0018\u00010\u0011R\u00020\u0000H\u0002¢\u0006\u0004\b%\u0010\u0013J)\u0010(\u001a\u00020\u00182\n\u0010\u0014\u001a\u00060\u0011R\u00020\u00002\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003¢\u0006\u0004\b(\u0010)J\u0019\u0010*\u001a\u00020\u000e2\n\u0010\u0014\u001a\u00060\u0011R\u00020\u0000¢\u0006\u0004\b*\u0010+J\u001b\u0010/\u001a\u00020\u00182\n\u0010.\u001a\u00060,j\u0002`-H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0018H\u0016¢\u0006\u0004\b1\u00102J\u0015\u00104\u001a\u00020\u00182\u0006\u00103\u001a\u00020\u0006¢\u0006\u0004\b4\u0010\u001aJ1\u00108\u001a\u00020\u00182\n\u00105\u001a\u00060,j\u0002`-2\f\b\u0002\u00107\u001a\u00060\u000ej\u0002`62\b\b\u0002\u0010\"\u001a\u00020\u000e¢\u0006\u0004\b8\u00109J%\u0010:\u001a\u00020\f2\n\u00105\u001a\u00060,j\u0002`-2\n\u00107\u001a\u00060\u000ej\u0002`6¢\u0006\u0004\b:\u0010;J\r\u0010<\u001a\u00020\u0018¢\u0006\u0004\b<\u00102J\u000f\u0010=\u001a\u00020\bH\u0016¢\u0006\u0004\b=\u0010>J\u0015\u0010?\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b?\u0010@R\u0014\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bC\u0010BR\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010J\u001a\u00020H8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010IR\u0014\u0010L\u001a\u00020H8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bK\u0010IR\u001e\u0010O\u001a\f\u0012\b\u0012\u00060\u0011R\u00020\u00000M8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b \u0010NR\u0011\u0010P\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\bP\u0010\u001fR\u000b\u0010R\u001a\u00020Q8\u0002X\u0082\u0004R\u000b\u0010S\u001a\u00020Q8\u0002X\u0082\u0004R\u000b\u0010U\u001a\u00020T8\u0002X\u0082\u0004¨\u0006X"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lbb/g;", "task", "", "e", "(Lbb/g;)Z", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;", "e0", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;", "worker", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;)I", "stateSnapshot", "LY8/t;", "I0", "(J)V", VoiceWakeupReceiver.EXTRA_STATE, "T0", "(J)Z", SdCardDbCreator.FIELD_LASTLOC_ID, "()Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "()I", "fair", "R0", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;Lbb/g;Z)Lbb/g;", "m", "oldIndex", "newIndex", "k0", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;II)V", "g0", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;)Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "command", "execute", "(Ljava/lang/Runnable;)V", "close", "()V", "timeout", "D0", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "n", "(Ljava/lang/Runnable;ZZ)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/Runnable;Z)Lbb/g;", "N0", "toString", "()Ljava/lang/String;", "v0", "(Lbb/g;)V", Const.INTENT_KEY_APIKEY, "I", Const.INTENT_KEY_PKGNAME, "c", "J", Const.INTENT_KEY_UMID, "Ljava/lang/String;", "Lbb/c;", "Lbb/c;", "globalCpuQueue", "f", "globalBlockingQueue", "LZa/x;", "LZa/x;", "workers", "isTerminated", "LOa/d;", "parkedWorkersStack", "controlState", "LOa/a;", "_isTerminated", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "WorkerState", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CoroutineScheduler implements Executor, Closeable {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f36777i = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack$volatile");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f36778j = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState$volatile");

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f36779k = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated$volatile");

    /* renamed from: l, reason: collision with root package name */
    public static final C f36780l = new C("NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int corePoolSize;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int maxPoolSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final long idleWorkerKeepAliveNs;
    private volatile /* synthetic */ long controlState$volatile;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String schedulerName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final C1468c globalCpuQueue;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final C1468c globalBlockingQueue;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final x<c> workers;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "<init>", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class WorkerState {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ WorkerState[] $VALUES;
        public static final WorkerState CPU_ACQUIRED = new WorkerState("CPU_ACQUIRED", 0);
        public static final WorkerState BLOCKING = new WorkerState("BLOCKING", 1);
        public static final WorkerState PARKING = new WorkerState("PARKING", 2);
        public static final WorkerState DORMANT = new WorkerState("DORMANT", 3);
        public static final WorkerState TERMINATED = new WorkerState("TERMINATED", 4);

        private static final /* synthetic */ WorkerState[] $values() {
            return new WorkerState[]{CPU_ACQUIRED, BLOCKING, PARKING, DORMANT, TERMINATED};
        }

        static {
            WorkerState[] workerStateArr$values = $values();
            $VALUES = workerStateArr$values;
            $ENTRIES = a.a(workerStateArr$values);
        }

        private WorkerState(String str, int i10) {
        }

        public static InterfaceC4149a<WorkerState> getEntries() {
            return $ENTRIES;
        }

        public static WorkerState valueOf(String str) {
            return (WorkerState) Enum.valueOf(WorkerState.class, str);
        }

        public static WorkerState[] values() {
            return (WorkerState[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36788a;

        static {
            int[] iArr = new int[WorkerState.values().length];
            try {
                iArr[WorkerState.PARKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkerState.BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WorkerState.DORMANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WorkerState.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f36788a = iArr;
        }
    }

    public CoroutineScheduler(int i10, int i11, long j10, String str) {
        this.corePoolSize = i10;
        this.maxPoolSize = i11;
        this.idleWorkerKeepAliveNs = j10;
        this.schedulerName = str;
        if (i10 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i10 + " should be at least 1").toString());
        }
        if (i11 < i10) {
            throw new IllegalArgumentException(("Max pool size " + i11 + " should be greater than or equals to core pool size " + i10).toString());
        }
        if (i11 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i11 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j10 > 0) {
            this.globalCpuQueue = new C1468c();
            this.globalBlockingQueue = new C1468c();
            this.workers = new x<>((i10 + 1) * 2);
            this.controlState$volatile = i10 << 42;
            return;
        }
        throw new IllegalArgumentException(("Idle worker keep alive time " + j10 + " must be positive").toString());
    }

    public static /* synthetic */ void A(CoroutineScheduler coroutineScheduler, Runnable runnable, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            z11 = false;
        }
        coroutineScheduler.n(runnable, z10, z11);
    }

    public static final /* synthetic */ AtomicLongFieldUpdater G() {
        return f36778j;
    }

    public static /* synthetic */ boolean Y0(CoroutineScheduler coroutineScheduler, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = f36778j.get(coroutineScheduler);
        }
        return coroutineScheduler.T0(j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D0(long r8) throws java.lang.InterruptedException {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = U()
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r7, r1, r2)
            if (r0 != 0) goto Ld
            return
        Ld:
            kotlinx.coroutines.scheduling.CoroutineScheduler$c r0 = r7.m()
            Za.x<kotlinx.coroutines.scheduling.CoroutineScheduler$c> r1 = r7.workers
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = b()     // Catch: java.lang.Throwable -> L8f
            long r3 = r3.get(r7)     // Catch: java.lang.Throwable -> L8f
            r5 = 2097151(0x1fffff, double:1.0361303E-317)
            long r3 = r3 & r5
            int r3 = (int) r3
            monitor-exit(r1)
            if (r2 > r3) goto L4d
            r1 = r2
        L25:
            Za.x<kotlinx.coroutines.scheduling.CoroutineScheduler$c> r4 = r7.workers
            java.lang.Object r4 = r4.b(r1)
            kotlin.jvm.internal.p.f(r4)
            kotlinx.coroutines.scheduling.CoroutineScheduler$c r4 = (kotlinx.coroutines.scheduling.CoroutineScheduler.c) r4
            if (r4 == r0) goto L48
        L32:
            java.lang.Thread$State r5 = r4.getState()
            java.lang.Thread$State r6 = java.lang.Thread.State.TERMINATED
            if (r5 == r6) goto L41
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r4.join(r8)
            goto L32
        L41:
            bb.k r4 = r4.localQueue
            bb.c r5 = r7.globalBlockingQueue
            r4.j(r5)
        L48:
            if (r1 == r3) goto L4d
            int r1 = r1 + 1
            goto L25
        L4d:
            bb.c r8 = r7.globalBlockingQueue
            r8.b()
            bb.c r8 = r7.globalCpuQueue
            r8.b()
        L57:
            if (r0 == 0) goto L5f
            bb.g r8 = r0.e(r2)
            if (r8 != 0) goto L8b
        L5f:
            bb.c r8 = r7.globalCpuQueue
            java.lang.Object r8 = r8.e()
            bb.g r8 = (bb.AbstractRunnableC1472g) r8
            if (r8 != 0) goto L8b
            bb.c r8 = r7.globalBlockingQueue
            java.lang.Object r8 = r8.e()
            bb.g r8 = (bb.AbstractRunnableC1472g) r8
            if (r8 != 0) goto L8b
            if (r0 == 0) goto L7a
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r8 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            r0.r(r8)
        L7a:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = J()
            r0 = 0
            r8.set(r7, r0)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = G()
            r8.set(r7, r0)
            return
        L8b:
            r7.v0(r8)
            goto L57
        L8f:
            r7 = move-exception
            monitor-exit(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.D0(long):void");
    }

    public final void I0(long stateSnapshot) {
        if (a1() || T0(stateSnapshot)) {
            return;
        }
        a1();
    }

    public final void N0() {
        if (a1() || Y0(this, 0L, 1, null)) {
            return;
        }
        a1();
    }

    public final AbstractRunnableC1472g R0(c cVar, AbstractRunnableC1472g abstractRunnableC1472g, boolean z10) {
        WorkerState workerState;
        if (cVar == null || (workerState = cVar.state) == WorkerState.TERMINATED) {
            return abstractRunnableC1472g;
        }
        if (!abstractRunnableC1472g.taskContext && workerState == WorkerState.BLOCKING) {
            return abstractRunnableC1472g;
        }
        cVar.mayHaveLocalTasks = true;
        return cVar.localQueue.a(abstractRunnableC1472g, z10);
    }

    public final boolean T0(long state) {
        if (C5685n.f(((int) (2097151 & state)) - ((int) ((state & 4398044413952L) >> 21)), 0) < this.corePoolSize) {
            int iG = g();
            if (iG == 1 && this.corePoolSize > 1) {
                g();
            }
            if (iG > 0) {
                return true;
            }
        }
        return false;
    }

    public final int V(c worker) {
        Object nextParkedWorker = worker.getNextParkedWorker();
        while (nextParkedWorker != f36780l) {
            if (nextParkedWorker == null) {
                return 0;
            }
            c cVar = (c) nextParkedWorker;
            int indexInArray = cVar.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = cVar.getNextParkedWorker();
        }
        return -1;
    }

    public final boolean a1() {
        c cVarE0;
        do {
            cVarE0 = e0();
            if (cVarE0 == null) {
                return false;
            }
        } while (!c.f36789i.compareAndSet(cVarE0, -1, 0));
        LockSupport.unpark(cVarE0);
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        D0(10000L);
    }

    public final boolean e(AbstractRunnableC1472g task) {
        return task.taskContext ? this.globalBlockingQueue.a(task) : this.globalCpuQueue.a(task);
    }

    public final c e0() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f36777i;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            c cVarB = this.workers.b((int) (2097151 & j10));
            if (cVarB == null) {
                return null;
            }
            long j11 = (2097152 + j10) & (-2097152);
            int iV = this.V(cVarB);
            if (iV >= 0) {
                CoroutineScheduler coroutineScheduler = this;
                if (f36777i.compareAndSet(coroutineScheduler, j10, iV | j11)) {
                    cVarB.o(f36780l);
                    return cVarB;
                }
                this = coroutineScheduler;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        A(this, command, false, false, 6, null);
    }

    public final int g() {
        synchronized (this.workers) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                long j10 = f36778j.get(this);
                int i10 = (int) (j10 & 2097151);
                int iF = C5685n.f(i10 - ((int) ((j10 & 4398044413952L) >> 21)), 0);
                if (iF >= this.corePoolSize) {
                    return 0;
                }
                if (i10 >= this.maxPoolSize) {
                    return 0;
                }
                int i11 = ((int) (G().get(this) & 2097151)) + 1;
                if (i11 <= 0 || this.workers.b(i11) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                c cVar = new c(this, i11);
                this.workers.c(i11, cVar);
                if (i11 != ((int) (2097151 & f36778j.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i12 = iF + 1;
                cVar.start();
                return i12;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean g0(c worker) {
        if (worker.getNextParkedWorker() != f36780l) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f36777i;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            int indexInArray = worker.getIndexInArray();
            worker.o(this.workers.b((int) (2097151 & j10)));
            long j11 = ((2097152 + j10) & (-2097152)) | indexInArray;
            CoroutineScheduler coroutineScheduler = this;
            if (f36777i.compareAndSet(coroutineScheduler, j10, j11)) {
                return true;
            }
            this = coroutineScheduler;
        }
    }

    public final AbstractRunnableC1472g i(Runnable block, boolean taskContext) {
        long jA = C1474i.f15387f.a();
        if (!(block instanceof AbstractRunnableC1472g)) {
            return C1474i.b(block, jA, taskContext);
        }
        AbstractRunnableC1472g abstractRunnableC1472g = (AbstractRunnableC1472g) block;
        abstractRunnableC1472g.submissionTime = jA;
        abstractRunnableC1472g.taskContext = taskContext;
        return abstractRunnableC1472g;
    }

    public final boolean isTerminated() {
        return f36779k.get(this) == 1;
    }

    public final void k0(c worker, int oldIndex, int newIndex) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f36777i;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            int iV = (int) (2097151 & j10);
            long j11 = (2097152 + j10) & (-2097152);
            if (iV == oldIndex) {
                iV = newIndex == 0 ? this.V(worker) : newIndex;
            }
            if (iV >= 0) {
                CoroutineScheduler coroutineScheduler = this;
                if (f36777i.compareAndSet(coroutineScheduler, j10, j11 | iV)) {
                    return;
                } else {
                    this = coroutineScheduler;
                }
            }
        }
    }

    public final c m() {
        Thread threadCurrentThread = Thread.currentThread();
        c cVar = threadCurrentThread instanceof c ? (c) threadCurrentThread : null;
        if (cVar == null || !p.d(CoroutineScheduler.this, this)) {
            return null;
        }
        return cVar;
    }

    public final void n(Runnable block, boolean taskContext, boolean fair) {
        C1046b.a();
        AbstractRunnableC1472g abstractRunnableC1472gI = i(block, taskContext);
        boolean z10 = abstractRunnableC1472gI.taskContext;
        long jAddAndGet = z10 ? f36778j.addAndGet(this, 2097152L) : 0L;
        AbstractRunnableC1472g abstractRunnableC1472gR0 = R0(m(), abstractRunnableC1472gI, fair);
        if (abstractRunnableC1472gR0 != null && !e(abstractRunnableC1472gR0)) {
            throw new RejectedExecutionException(this.schedulerName + " was terminated");
        }
        if (z10) {
            I0(jAddAndGet);
        } else {
            N0();
        }
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.workers.a();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 1; i15 < iA; i15++) {
            c cVarB = this.workers.b(i15);
            if (cVarB != null) {
                int i16 = cVarB.localQueue.i();
                int i17 = b.f36788a[cVarB.state.ordinal()];
                if (i17 == 1) {
                    i12++;
                } else if (i17 == 2) {
                    i11++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i16);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (i17 == 3) {
                    i10++;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(i16);
                    sb3.append('c');
                    arrayList.add(sb3.toString());
                } else if (i17 == 4) {
                    i13++;
                    if (i16 > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(i16);
                        sb4.append(GMTDateParser.DAY_OF_MONTH);
                        arrayList.add(sb4.toString());
                    }
                } else {
                    if (i17 != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i14++;
                }
            }
        }
        long j10 = f36778j.get(this);
        return this.schedulerName + '@' + N.b(this) + "[Pool Size {core = " + this.corePoolSize + ", max = " + this.maxPoolSize + "}, Worker States {CPU = " + i10 + ", blocking = " + i11 + ", parked = " + i12 + ", dormant = " + i13 + ", terminated = " + i14 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.globalCpuQueue.c() + ", global blocking queue size = " + this.globalBlockingQueue.c() + ", Control State {created workers= " + ((int) (2097151 & j10)) + ", blocking tasks = " + ((int) ((4398044413952L & j10) >> 21)) + ", CPUs acquired = " + (this.corePoolSize - ((int) ((9223367638808264704L & j10) >> 42))) + "}]";
    }

    public final void v0(AbstractRunnableC1472g task) {
        try {
            task.run();
        } catch (Throwable th) {
            try {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
            } finally {
                C1046b.a();
            }
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u000eJ\u000f\u0010\u0019\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u000eJ\u000f\u0010\u001a\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001a\u0010\u0017J\u0017\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u000eJ\u000f\u0010\u001f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010\u000eJ\u0011\u0010 \u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b \u0010!J\u0019\u0010#\u001a\u0004\u0018\u00010\u00132\u0006\u0010\"\u001a\u00020\tH\u0002¢\u0006\u0004\b#\u0010\u0015J\u0011\u0010$\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b$\u0010!J\u001d\u0010'\u001a\u0004\u0018\u00010\u00132\n\u0010&\u001a\u00060\u0004j\u0002`%H\u0002¢\u0006\u0004\b'\u0010(R*\u0010)\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0014\u00102\u001a\u00020/8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001c\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0013038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u00104R\u0016\u00107\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u00106R\u0016\u0010:\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u00109R$\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0016\u0010B\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u00109R\u0016\u0010C\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010*R\u0016\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b>\u0010DR\b\u0010F\u001a\u00020E8\u0006¨\u0006G"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;", "Ljava/lang/Thread;", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "", "index", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "", "r", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "LY8/t;", "run", "()V", "upperBound", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(I)I", "mayHaveLocalTasks", "Lbb/g;", "e", "(Z)Lbb/g;", "p", "()Z", "m", "q", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "task", Const.INTENT_KEY_PKGNAME, "(Lbb/g;)V", "k", "t", Const.INTENT_KEY_UMID, "()Lbb/g;", "scanLocalQueue", "c", "l", "Lkotlinx/coroutines/scheduling/StealingMode;", "stealingMode", "s", "(I)Lbb/g;", "indexInArray", "I", "f", "()I", "n", "(I)V", "Lbb/k;", Const.INTENT_KEY_APIKEY, "Lbb/k;", "localQueue", "Lkotlin/jvm/internal/Ref$ObjectRef;", "Lkotlin/jvm/internal/Ref$ObjectRef;", "stolenTask", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", VoiceWakeupReceiver.EXTRA_STATE, "", "J", "terminationDeadline", "", "nextParkedWorker", "Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/lang/Object;", "o", "(Ljava/lang/Object;)V", "minDelayUntilStealableTaskNs", "rngState", "Z", "LOa/c;", "workerCtl", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class c extends Thread {

        /* renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f36789i = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl$volatile");

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final C1476k localQueue;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Ref$ObjectRef<AbstractRunnableC1472g> stolenTask;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public WorkerState state;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public long terminationDeadline;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public long minDelayUntilStealableTaskNs;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public int rngState;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public boolean mayHaveLocalTasks;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        private volatile /* synthetic */ int workerCtl$volatile;

        public c() {
            setDaemon(true);
            setContextClassLoader(CoroutineScheduler.this.getClass().getClassLoader());
            this.localQueue = new C1476k();
            this.stolenTask = new Ref$ObjectRef<>();
            this.state = WorkerState.DORMANT;
            this.nextParkedWorker = CoroutineScheduler.f36780l;
            int iNanoTime = (int) System.nanoTime();
            this.rngState = iNanoTime == 0 ? 42 : iNanoTime;
        }

        public final void b(AbstractRunnableC1472g task) {
            this.terminationDeadline = 0L;
            if (this.state == WorkerState.PARKING) {
                this.state = WorkerState.BLOCKING;
            }
            if (!task.taskContext) {
                CoroutineScheduler.this.v0(task);
                return;
            }
            if (r(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.N0();
            }
            CoroutineScheduler.this.v0(task);
            CoroutineScheduler.G().addAndGet(CoroutineScheduler.this, -2097152L);
            if (this.state != WorkerState.TERMINATED) {
                this.state = WorkerState.DORMANT;
            }
        }

        public final AbstractRunnableC1472g c(boolean scanLocalQueue) {
            AbstractRunnableC1472g abstractRunnableC1472gL;
            AbstractRunnableC1472g abstractRunnableC1472gL2;
            if (scanLocalQueue) {
                boolean z10 = j(CoroutineScheduler.this.corePoolSize * 2) == 0;
                if (z10 && (abstractRunnableC1472gL2 = l()) != null) {
                    return abstractRunnableC1472gL2;
                }
                AbstractRunnableC1472g abstractRunnableC1472gK = this.localQueue.k();
                if (abstractRunnableC1472gK != null) {
                    return abstractRunnableC1472gK;
                }
                if (!z10 && (abstractRunnableC1472gL = l()) != null) {
                    return abstractRunnableC1472gL;
                }
            } else {
                AbstractRunnableC1472g abstractRunnableC1472gL3 = l();
                if (abstractRunnableC1472gL3 != null) {
                    return abstractRunnableC1472gL3;
                }
            }
            return s(3);
        }

        public final AbstractRunnableC1472g d() {
            AbstractRunnableC1472g abstractRunnableC1472gL = this.localQueue.l();
            return (abstractRunnableC1472gL == null && (abstractRunnableC1472gL = CoroutineScheduler.this.globalBlockingQueue.e()) == null) ? s(1) : abstractRunnableC1472gL;
        }

        public final AbstractRunnableC1472g e(boolean mayHaveLocalTasks) {
            return p() ? c(mayHaveLocalTasks) : d();
        }

        /* renamed from: f, reason: from getter */
        public final int getIndexInArray() {
            return this.indexInArray;
        }

        /* renamed from: g, reason: from getter */
        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final boolean i() {
            return this.nextParkedWorker != CoroutineScheduler.f36780l;
        }

        public final int j(int upperBound) {
            int i10 = this.rngState;
            int i11 = i10 ^ (i10 << 13);
            int i12 = i11 ^ (i11 >> 17);
            int i13 = i12 ^ (i12 << 5);
            this.rngState = i13;
            int i14 = upperBound - 1;
            return (i14 & upperBound) == 0 ? i14 & i13 : (Integer.MAX_VALUE & i13) % upperBound;
        }

        public final void k() {
            if (this.terminationDeadline == 0) {
                this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
            if (System.nanoTime() - this.terminationDeadline >= 0) {
                this.terminationDeadline = 0L;
                t();
            }
        }

        public final AbstractRunnableC1472g l() {
            if (j(2) == 0) {
                AbstractRunnableC1472g abstractRunnableC1472gE = CoroutineScheduler.this.globalCpuQueue.e();
                return abstractRunnableC1472gE != null ? abstractRunnableC1472gE : CoroutineScheduler.this.globalBlockingQueue.e();
            }
            AbstractRunnableC1472g abstractRunnableC1472gE2 = CoroutineScheduler.this.globalBlockingQueue.e();
            return abstractRunnableC1472gE2 != null ? abstractRunnableC1472gE2 : CoroutineScheduler.this.globalCpuQueue.e();
        }

        public final void m() {
            loop0: while (true) {
                boolean z10 = false;
                while (!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                    AbstractRunnableC1472g abstractRunnableC1472gE = e(this.mayHaveLocalTasks);
                    if (abstractRunnableC1472gE != null) {
                        this.minDelayUntilStealableTaskNs = 0L;
                        b(abstractRunnableC1472gE);
                    } else {
                        this.mayHaveLocalTasks = false;
                        if (this.minDelayUntilStealableTaskNs == 0) {
                            q();
                        } else if (z10) {
                            r(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                            this.minDelayUntilStealableTaskNs = 0L;
                        } else {
                            z10 = true;
                        }
                    }
                }
                break loop0;
            }
            r(WorkerState.TERMINATED);
        }

        public final void n(int i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(CoroutineScheduler.this.schedulerName);
            sb2.append("-worker-");
            sb2.append(i10 == 0 ? "TERMINATED" : String.valueOf(i10));
            setName(sb2.toString());
            this.indexInArray = i10;
        }

        public final void o(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean p() {
            long j10;
            if (this.state == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            AtomicLongFieldUpdater atomicLongFieldUpdaterG = CoroutineScheduler.G();
            do {
                j10 = atomicLongFieldUpdaterG.get(coroutineScheduler);
                if (((int) ((9223367638808264704L & j10) >> 42)) == 0) {
                    return false;
                }
            } while (!CoroutineScheduler.G().compareAndSet(coroutineScheduler, j10, j10 - 4398046511104L));
            this.state = WorkerState.CPU_ACQUIRED;
            return true;
        }

        public final void q() {
            if (!i()) {
                CoroutineScheduler.this.g0(this);
                return;
            }
            f36789i.set(this, -1);
            while (i() && f36789i.get(this) == -1 && !CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                r(WorkerState.PARKING);
                Thread.interrupted();
                k();
            }
        }

        public final boolean r(WorkerState newState) {
            WorkerState workerState = this.state;
            boolean z10 = workerState == WorkerState.CPU_ACQUIRED;
            if (z10) {
                CoroutineScheduler.G().addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState != newState) {
                this.state = newState;
            }
            return z10;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            m();
        }

        public final AbstractRunnableC1472g s(int stealingMode) {
            int i10 = (int) (CoroutineScheduler.G().get(CoroutineScheduler.this) & 2097151);
            if (i10 < 2) {
                return null;
            }
            int iJ = j(i10);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long jMin = Long.MAX_VALUE;
            for (int i11 = 0; i11 < i10; i11++) {
                iJ++;
                if (iJ > i10) {
                    iJ = 1;
                }
                c cVarB = coroutineScheduler.workers.b(iJ);
                if (cVarB != null && cVarB != this) {
                    long jR = cVarB.localQueue.r(stealingMode, this.stolenTask);
                    if (jR == -1) {
                        Ref$ObjectRef<AbstractRunnableC1472g> ref$ObjectRef = this.stolenTask;
                        AbstractRunnableC1472g abstractRunnableC1472g = ref$ObjectRef.f34820a;
                        ref$ObjectRef.f34820a = null;
                        return abstractRunnableC1472g;
                    }
                    if (jR > 0) {
                        jMin = Math.min(jMin, jR);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.minDelayUntilStealableTaskNs = jMin;
            return null;
        }

        public final void t() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.workers) {
                try {
                    if (coroutineScheduler.isTerminated()) {
                        return;
                    }
                    if (((int) (CoroutineScheduler.G().get(coroutineScheduler) & 2097151)) <= coroutineScheduler.corePoolSize) {
                        return;
                    }
                    if (f36789i.compareAndSet(this, -1, 1)) {
                        int i10 = this.indexInArray;
                        n(0);
                        coroutineScheduler.k0(this, i10, 0);
                        int andDecrement = (int) (CoroutineScheduler.G().getAndDecrement(coroutineScheduler) & 2097151);
                        if (andDecrement != i10) {
                            c cVarB = coroutineScheduler.workers.b(andDecrement);
                            p.f(cVarB);
                            c cVar = cVarB;
                            coroutineScheduler.workers.c(i10, cVar);
                            cVar.n(i10);
                            coroutineScheduler.k0(cVar, andDecrement, i10);
                        }
                        coroutineScheduler.workers.c(andDecrement, null);
                        t tVar = t.f7040a;
                        this.state = WorkerState.TERMINATED;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public c(CoroutineScheduler coroutineScheduler, int i10) {
            this();
            n(i10);
        }
    }
}
