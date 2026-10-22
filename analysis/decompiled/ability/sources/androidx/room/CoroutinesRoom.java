package androidx.room;

import B9.Q;
import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import androidx.room.coroutines.FlowUtil;
import androidx.sqlite.SQLiteConnection;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/room/CoroutinesRoom;", "", AppAgent.CONSTRUCT, "()V", "Companion", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes2.dex */
public final class CoroutinesRoom {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0087@¢\u0006\u0004\b\u000b\u0010\fJ>\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0087@¢\u0006\u0004\b\u000b\u0010\u000fJG\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0007¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/room/CoroutinesRoom$Companion;", "", AppAgent.CONSTRUCT, "()V", "R", "Landroidx/room/RoomDatabase;", "db", "", "inTransaction", "Ljava/util/concurrent/Callable;", "callable", "execute", "(Landroidx/room/RoomDatabase;ZLjava/util/concurrent/Callable;LH7/c;)Ljava/lang/Object;", "Landroid/os/CancellationSignal;", "cancellationSignal", "(Landroidx/room/RoomDatabase;ZLandroid/os/CancellationSignal;Ljava/util/concurrent/Callable;LH7/c;)Ljava/lang/Object;", "", "", "tableNames", "Lp9/c;", "createFlow", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lp9/c;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object createFlow$lambda$1(Callable callable, SQLiteConnection it) {
            k.f(it, "it");
            return callable.call();
        }

        @C7.c
        public final <R> p9.c createFlow(RoomDatabase db, boolean inTransaction, String[] tableNames, Callable<R> callable) {
            k.f(db, "db");
            k.f(tableNames, "tableNames");
            k.f(callable, "callable");
            return FlowUtil.createFlow(db, inTransaction, tableNames, new Q(callable, 17));
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @C7.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final <R> java.lang.Object execute(androidx.room.RoomDatabase r5, boolean r6, java.util.concurrent.Callable<R> r7, H7.c<? super R> r8) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r8 instanceof androidx.room.CoroutinesRoom$Companion$execute$1
                if (r0 == 0) goto L13
                r0 = r8
                androidx.room.CoroutinesRoom$Companion$execute$1 r0 = (androidx.room.CoroutinesRoom$Companion$execute$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.room.CoroutinesRoom$Companion$execute$1 r0 = new androidx.room.CoroutinesRoom$Companion$execute$1
                r0.<init>(r4, r8)
            L18:
                java.lang.Object r4 = r0.result
                kotlin.coroutines.intrinsics.CoroutineSingletons r8 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r0.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L3b
                if (r1 == r3) goto L32
                if (r1 != r2) goto L2a
                kotlin.b.b(r4)
                return r4
            L2a:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L32:
                java.lang.Object r5 = r0.L$0
                r7 = r5
                java.util.concurrent.Callable r7 = (java.util.concurrent.Callable) r7
                kotlin.b.b(r4)
                goto L5a
            L3b:
                kotlin.b.b(r4)
                boolean r4 = r5.isOpenInternal$room_runtime()
                if (r4 == 0) goto L4f
                boolean r4 = r5.inTransaction()
                if (r4 == 0) goto L4f
                java.lang.Object r4 = r7.call()
                return r4
            L4f:
                r0.L$0 = r7
                r0.label = r3
                java.lang.Object r4 = androidx.room.util.DBUtil.getCoroutineContext(r5, r6, r0)
                if (r4 != r8) goto L5a
                goto L6c
            L5a:
                H7.h r4 = (H7.h) r4
                androidx.room.CoroutinesRoom$Companion$execute$2 r5 = new androidx.room.CoroutinesRoom$Companion$execute$2
                r6 = 0
                r5.<init>(r7, r6)
                r0.L$0 = r6
                r0.label = r2
                java.lang.Object r4 = m9.AbstractC1683A.w(r4, r5, r0)
                if (r4 != r8) goto L6d
            L6c:
                return r8
            L6d:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.CoroutinesRoom.Companion.execute(androidx.room.RoomDatabase, boolean, java.util.concurrent.Callable, H7.c):java.lang.Object");
        }

        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @C7.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final <R> java.lang.Object execute(androidx.room.RoomDatabase r5, boolean r6, final android.os.CancellationSignal r7, java.util.concurrent.Callable<R> r8, H7.c<? super R> r9) {
            /*
                r4 = this;
                boolean r0 = r9 instanceof androidx.room.CoroutinesRoom$Companion$execute$3
                if (r0 == 0) goto L13
                r0 = r9
                androidx.room.CoroutinesRoom$Companion$execute$3 r0 = (androidx.room.CoroutinesRoom$Companion$execute$3) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                androidx.room.CoroutinesRoom$Companion$execute$3 r0 = new androidx.room.CoroutinesRoom$Companion$execute$3
                r0.<init>(r4, r9)
            L18:
                java.lang.Object r4 = r0.result
                kotlin.coroutines.intrinsics.CoroutineSingletons r9 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r0.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L54
                if (r1 == r3) goto L42
                if (r1 != r2) goto L3a
                java.lang.Object r5 = r0.L$3
                H7.h r5 = (H7.h) r5
                java.lang.Object r5 = r0.L$2
                java.util.concurrent.Callable r5 = (java.util.concurrent.Callable) r5
                java.lang.Object r5 = r0.L$1
                android.os.CancellationSignal r5 = (android.os.CancellationSignal) r5
                java.lang.Object r5 = r0.L$0
                androidx.room.RoomDatabase r5 = (androidx.room.RoomDatabase) r5
                kotlin.b.b(r4)
                return r4
            L3a:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L42:
                java.lang.Object r5 = r0.L$2
                r8 = r5
                java.util.concurrent.Callable r8 = (java.util.concurrent.Callable) r8
                java.lang.Object r5 = r0.L$1
                r7 = r5
                android.os.CancellationSignal r7 = (android.os.CancellationSignal) r7
                java.lang.Object r5 = r0.L$0
                androidx.room.RoomDatabase r5 = (androidx.room.RoomDatabase) r5
                kotlin.b.b(r4)
                goto L77
            L54:
                kotlin.b.b(r4)
                boolean r4 = r5.isOpenInternal$room_runtime()
                if (r4 == 0) goto L68
                boolean r4 = r5.inTransaction()
                if (r4 == 0) goto L68
                java.lang.Object r4 = r8.call()
                return r4
            L68:
                r0.L$0 = r5
                r0.L$1 = r7
                r0.L$2 = r8
                r0.label = r3
                java.lang.Object r4 = androidx.room.util.DBUtil.getCoroutineContext(r5, r6, r0)
                if (r4 != r9) goto L77
                goto Lab
            L77:
                H7.h r4 = (H7.h) r4
                r0.L$0 = r5
                r0.L$1 = r7
                r0.L$2 = r8
                r0.L$3 = r4
                r0.label = r2
                m9.k r6 = new m9.k
                H7.c r0 = U7.a.I(r0)
                r6.<init>(r3, r0)
                r6.y()
                m9.z r5 = r5.getCoroutineScope()
                androidx.room.CoroutinesRoom$Companion$execute$4$job$1 r0 = new androidx.room.CoroutinesRoom$Companion$execute$4$job$1
                r1 = 0
                r0.<init>(r8, r6, r1)
                m9.q0 r4 = m9.AbstractC1683A.n(r5, r4, r0, r2)
                androidx.room.CoroutinesRoom$Companion$execute$4$1 r5 = new androidx.room.CoroutinesRoom$Companion$execute$4$1
                r5.<init>()
                r6.j(r5)
                java.lang.Object r4 = r6.x()
                if (r4 != r9) goto Lac
            Lab:
                return r9
            Lac:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.CoroutinesRoom.Companion.execute(androidx.room.RoomDatabase, boolean, android.os.CancellationSignal, java.util.concurrent.Callable, H7.c):java.lang.Object");
        }
    }

    private CoroutinesRoom() {
    }

    @C7.c
    public static final <R> p9.c createFlow(RoomDatabase roomDatabase, boolean z10, String[] strArr, Callable<R> callable) {
        return INSTANCE.createFlow(roomDatabase, z10, strArr, callable);
    }

    @C7.c
    public static final <R> Object execute(RoomDatabase roomDatabase, boolean z10, CancellationSignal cancellationSignal, Callable<R> callable, H7.c<? super R> cVar) {
        return INSTANCE.execute(roomDatabase, z10, cancellationSignal, callable, cVar);
    }

    @C7.c
    public static final <R> Object execute(RoomDatabase roomDatabase, boolean z10, Callable<R> callable, H7.c<? super R> cVar) {
        return INSTANCE.execute(roomDatabase, z10, callable, cVar);
    }
}
