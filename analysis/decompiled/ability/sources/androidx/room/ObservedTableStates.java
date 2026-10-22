package androidx.room;

import S7.k;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\r\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\t0\u0006H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0018\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u001a\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0019\u0010\u0017R\u0018\u0010\u001d\u001a\u00060\u001bj\u0002`\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006("}, d2 = {"Landroidx/room/ObservedTableStates;", "", "", "size", AppAgent.CONSTRUCT, "(I)V", "Lkotlin/Function1;", "", "Landroidx/room/ObservedTableStates$ObserveOp;", "LC7/r;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "onSync$room_runtime", "(LS7/k;)V", "onSync", "", "tableIds", "", "onObserverAdded$room_runtime", "([I)Z", "onObserverAdded", "onObserverRemoved$room_runtime", "onObserverRemoved", "resetTriggerState$room_runtime", "()V", "resetTriggerState", "forceNeedSync$room_runtime", "forceNeedSync", "Ljava/util/concurrent/locks/ReentrantLock;", "Landroidx/room/concurrent/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "", "tableObserversCount", "[J", "", "tableObservedState", "[Z", "needsSync", "Z", "ObserveOp", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ObservedTableStates {
    private final ReentrantLock lock = new ReentrantLock();
    private volatile boolean needsSync;
    private final boolean[] tableObservedState;
    private final long[] tableObserversCount;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/ObservedTableStates$ObserveOp;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "NO_OP", "ADD", "REMOVE", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ObserveOp {
        private static final /* synthetic */ K7.a $ENTRIES;
        private static final /* synthetic */ ObserveOp[] $VALUES;
        public static final ObserveOp NO_OP = new ObserveOp("NO_OP", 0);
        public static final ObserveOp ADD = new ObserveOp("ADD", 1);
        public static final ObserveOp REMOVE = new ObserveOp("REMOVE", 2);

        private static final /* synthetic */ ObserveOp[] $values() {
            return new ObserveOp[]{NO_OP, ADD, REMOVE};
        }

        static {
            ObserveOp[] observeOpArr$values = $values();
            $VALUES = observeOpArr$values;
            $ENTRIES = kotlin.enums.a.a(observeOpArr$values);
        }

        private ObserveOp(String str, int i) {
        }

        public static K7.a getEntries() {
            return $ENTRIES;
        }

        public static ObserveOp valueOf(String str) {
            return (ObserveOp) Enum.valueOf(ObserveOp.class, str);
        }

        public static ObserveOp[] values() {
            return (ObserveOp[]) $VALUES.clone();
        }
    }

    public ObservedTableStates(int i) {
        this.tableObserversCount = new long[i];
        this.tableObservedState = new boolean[i];
    }

    public final void forceNeedSync$room_runtime() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.needsSync = true;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onObserverAdded$room_runtime(int[] r13) {
        /*
            r12 = this;
            java.lang.String r0 = "tableIds"
            kotlin.jvm.internal.k.f(r13, r0)
            java.util.concurrent.locks.ReentrantLock r0 = r12.lock
            r0.lock()
            int r1 = r13.length     // Catch: java.lang.Throwable -> L26
            r2 = 0
            r3 = r2
            r4 = r3
        Le:
            r5 = 1
            if (r3 >= r1) goto L2b
            r6 = r13[r3]     // Catch: java.lang.Throwable -> L26
            long[] r7 = r12.tableObserversCount     // Catch: java.lang.Throwable -> L26
            r8 = r7[r6]     // Catch: java.lang.Throwable -> L26
            r10 = 1
            long r10 = r10 + r8
            r7[r6] = r10     // Catch: java.lang.Throwable -> L26
            r6 = 0
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 != 0) goto L28
            r12.needsSync = r5     // Catch: java.lang.Throwable -> L26
            r4 = r5
            goto L28
        L26:
            r12 = move-exception
            goto L36
        L28:
            int r3 = r3 + 1
            goto Le
        L2b:
            if (r4 != 0) goto L31
            boolean r12 = r12.needsSync     // Catch: java.lang.Throwable -> L26
            if (r12 == 0) goto L32
        L31:
            r2 = r5
        L32:
            r0.unlock()
            return r2
        L36:
            r0.unlock()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.ObservedTableStates.onObserverAdded$room_runtime(int[]):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onObserverRemoved$room_runtime(int[] r15) {
        /*
            r14 = this;
            java.lang.String r0 = "tableIds"
            kotlin.jvm.internal.k.f(r15, r0)
            java.util.concurrent.locks.ReentrantLock r0 = r14.lock
            r0.lock()
            int r1 = r15.length     // Catch: java.lang.Throwable -> L25
            r2 = 0
            r3 = r2
            r4 = r3
        Le:
            r5 = 1
            if (r3 >= r1) goto L2a
            r6 = r15[r3]     // Catch: java.lang.Throwable -> L25
            long[] r7 = r14.tableObserversCount     // Catch: java.lang.Throwable -> L25
            r8 = r7[r6]     // Catch: java.lang.Throwable -> L25
            r10 = 1
            long r12 = r8 - r10
            r7[r6] = r12     // Catch: java.lang.Throwable -> L25
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 != 0) goto L27
            r14.needsSync = r5     // Catch: java.lang.Throwable -> L25
            r4 = r5
            goto L27
        L25:
            r14 = move-exception
            goto L35
        L27:
            int r3 = r3 + 1
            goto Le
        L2a:
            if (r4 != 0) goto L30
            boolean r14 = r14.needsSync     // Catch: java.lang.Throwable -> L25
            if (r14 == 0) goto L31
        L30:
            r2 = r5
        L31:
            r0.unlock()
            return r2
        L35:
            r0.unlock()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.ObservedTableStates.onObserverRemoved$room_runtime(int[]):boolean");
    }

    public final void onSync$room_runtime(k action) {
        ObserveOp observeOp;
        kotlin.jvm.internal.k.f(action, "action");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!this.needsSync) {
                reentrantLock.unlock();
                return;
            }
            this.needsSync = false;
            int length = this.tableObserversCount.length;
            ObserveOp[] observeOpArr = new ObserveOp[length];
            int i = 0;
            boolean z10 = false;
            while (i < length) {
                boolean z11 = true;
                boolean z12 = this.tableObserversCount[i] > 0;
                if (z12 != this.tableObservedState[i]) {
                    this.tableObservedState[i] = z12;
                    observeOp = z12 ? ObserveOp.ADD : ObserveOp.REMOVE;
                } else {
                    z11 = z10;
                    observeOp = ObserveOp.NO_OP;
                }
                observeOpArr[i] = observeOp;
                i++;
                z10 = z11;
            }
            if (z10) {
                action.invoke(observeOpArr);
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void resetTriggerState$room_runtime() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            boolean[] zArr = this.tableObservedState;
            int length = zArr.length;
            kotlin.jvm.internal.k.f(zArr, "<this>");
            Arrays.fill(zArr, 0, length, false);
            this.needsSync = true;
        } finally {
            reentrantLock.unlock();
        }
    }
}
