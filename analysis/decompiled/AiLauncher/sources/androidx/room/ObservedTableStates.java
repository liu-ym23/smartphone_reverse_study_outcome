package androidx.room;

import Z8.C1168p;
import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import io.ktor.http.ContentDisposition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0014\u001a\u00060\u0010j\u0002`\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u00060\u0010j\u0002`\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0013R\u0016\u0010#\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001e¨\u0006%"}, d2 = {"Landroidx/room/ObservedTableStates;", "", "", ContentDisposition.Parameters.Size, "<init>", "(I)V", "", "tableIds", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "([I)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "LY8/t;", "k", "()V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/util/concurrent/locks/ReentrantLock;", "Landroidx/room/concurrent/ReentrantLock;", Const.INTENT_KEY_APIKEY, "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "", Const.INTENT_KEY_PKGNAME, "[J", "tableObserversCount", "", "c", "[Z", "tableObservedState", Const.INTENT_KEY_UMID, "Z", "needsSync", "e", "onSyncLock", "f", "inProgressSync", "ObserveOp", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ObservedTableStates {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final long[] tableObserversCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final boolean[] tableObservedState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public volatile boolean needsSync;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public volatile boolean inProgressSync;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final ReentrantLock lock = new ReentrantLock();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final ReentrantLock onSyncLock = new ReentrantLock();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/room/ObservedTableStates$ObserveOp;", "", "<init>", "(Ljava/lang/String;I)V", "NO_OP", "ADD", "REMOVE", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ObserveOp {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
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

        private ObserveOp(String str, int i10) {
        }

        public static InterfaceC4149a<ObserveOp> getEntries() {
            return $ENTRIES;
        }

        public static ObserveOp valueOf(String str) {
            return (ObserveOp) Enum.valueOf(ObserveOp.class, str);
        }

        public static ObserveOp[] values() {
            return (ObserveOp[]) $VALUES.clone();
        }
    }

    public ObservedTableStates(int i10) {
        this.tableObserversCount = new long[i10];
        this.tableObservedState = new boolean[i10];
    }

    public final void h() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.needsSync = true;
            Y8.t tVar = Y8.t.f7040a;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(int[] r13) {
        /*
            r12 = this;
            java.lang.String r0 = "tableIds"
            kotlin.jvm.internal.p.i(r13, r0)
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
            goto L3a
        L28:
            int r3 = r3 + 1
            goto Le
        L2b:
            if (r4 != 0) goto L35
            boolean r13 = r12.needsSync     // Catch: java.lang.Throwable -> L26
            if (r13 != 0) goto L35
            boolean r12 = r12.inProgressSync     // Catch: java.lang.Throwable -> L26
            if (r12 == 0) goto L36
        L35:
            r2 = r5
        L36:
            r0.unlock()
            return r2
        L3a:
            r0.unlock()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.ObservedTableStates.i(int[]):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean j(int[] r15) {
        /*
            r14 = this;
            java.lang.String r0 = "tableIds"
            kotlin.jvm.internal.p.i(r15, r0)
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
            goto L39
        L27:
            int r3 = r3 + 1
            goto Le
        L2a:
            if (r4 != 0) goto L34
            boolean r15 = r14.needsSync     // Catch: java.lang.Throwable -> L25
            if (r15 != 0) goto L34
            boolean r14 = r14.inProgressSync     // Catch: java.lang.Throwable -> L25
            if (r14 == 0) goto L35
        L34:
            r2 = r5
        L35:
            r0.unlock()
            return r2
        L39:
            r0.unlock()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.ObservedTableStates.j(int[]):boolean");
    }

    public final void k() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            C1168p.C(this.tableObservedState, false, 0, 0, 6, null);
            this.needsSync = true;
            Y8.t tVar = Y8.t.f7040a;
        } finally {
            reentrantLock.unlock();
        }
    }
}
