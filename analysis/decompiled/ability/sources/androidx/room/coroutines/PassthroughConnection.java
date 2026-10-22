package androidx.room.coroutines;

import C7.r;
import H7.c;
import S7.k;
import S7.n;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.TransactionScope;
import androidx.room.Transactor;
import androidx.room.coroutines.ConnectionPool;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.task.executor.e;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import v7.o;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001+BQ\u0012@\u0010\b\u001a<\b\u0001\u0012\u0018\u0012\u0016\b\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003j\b\u0012\u0002\b\u0003\u0018\u0001`\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJH\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000f\u001a\u00020\u000e2(\u0010\u0011\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003H\u0082@¢\u0006\u0004\b\u0012\u0010\u0013J2\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00028\u00000\u0004H\u0096@¢\u0006\u0004\b\u0017\u0010\u0018JH\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000f\u001a\u00020\u000e2(\u0010\u0011\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003H\u0096@¢\u0006\u0004\b\u0019\u0010\u0013J\u0010\u0010\u001b\u001a\u00020\u001aH\u0096@¢\u0006\u0004\b\u001b\u0010\u001cRQ\u0010\b\u001a<\b\u0001\u0012\u0018\u0012\u0016\b\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003j\b\u0012\u0002\b\u0003\u0018\u0001`\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010%\u001a\u00060#j\u0002`$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\"¨\u0006,"}, d2 = {"Landroidx/room/coroutines/PassthroughConnection;", "Landroidx/room/Transactor;", "Landroidx/room/coroutines/RawConnectionAccessor;", "Lkotlin/Function2;", "Lkotlin/Function1;", "LH7/c;", "", "Landroidx/room/coroutines/TransactionWrapper;", "transactionWrapper", "Landroidx/sqlite/SQLiteConnection;", "delegate", AppAgent.CONSTRUCT, "(LS7/n;Landroidx/sqlite/SQLiteConnection;)V", "R", "Landroidx/room/Transactor$SQLiteTransactionType;", "type", "Landroidx/room/TransactionScope;", "block", "transaction", "(Landroidx/room/Transactor$SQLiteTransactionType;LS7/n;LH7/c;)Ljava/lang/Object;", "", "sql", "Landroidx/sqlite/SQLiteStatement;", "usePrepared", "(Ljava/lang/String;LS7/k;LH7/c;)Ljava/lang/Object;", "withTransaction", "", "inTransaction", "(LH7/c;)Ljava/lang/Object;", "LS7/n;", "getTransactionWrapper", "()LS7/n;", "Landroidx/sqlite/SQLiteConnection;", "getDelegate", "()Landroidx/sqlite/SQLiteConnection;", "Ljava/util/concurrent/atomic/AtomicInteger;", "Landroidx/room/concurrent/AtomicInt;", "nestedTransactionCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "currentTransactionType", "Landroidx/room/Transactor$SQLiteTransactionType;", "getRawConnection", "rawConnection", "PassthroughTransactor", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class PassthroughConnection implements Transactor, RawConnectionAccessor {
    private Transactor.SQLiteTransactionType currentTransactionType;
    private final SQLiteConnection delegate;
    private AtomicInteger nestedTransactionCount;
    private final n transactionWrapper;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\f\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00062\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00010\tH\u0096@¢\u0006\u0004\b\f\u0010\rJ@\u0010\u0011\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00062(\u0010\u000b\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000eH\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Landroidx/room/coroutines/PassthroughConnection$PassthroughTransactor;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/room/TransactionScope;", "Landroidx/room/coroutines/RawConnectionAccessor;", AppAgent.CONSTRUCT, "(Landroidx/room/coroutines/PassthroughConnection;)V", "R", "", "sql", "Lkotlin/Function1;", "Landroidx/sqlite/SQLiteStatement;", "block", "usePrepared", "(Ljava/lang/String;LS7/k;LH7/c;)Ljava/lang/Object;", "Lkotlin/Function2;", "LH7/c;", "", "withNestedTransaction", "(LS7/n;LH7/c;)Ljava/lang/Object;", "result", "", "rollback", "(Ljava/lang/Object;LH7/c;)Ljava/lang/Object;", "Landroidx/sqlite/SQLiteConnection;", "getRawConnection", "()Landroidx/sqlite/SQLiteConnection;", "rawConnection", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class PassthroughTransactor<T> implements TransactionScope<T>, RawConnectionAccessor {
        public PassthroughTransactor() {
        }

        @Override // androidx.room.coroutines.RawConnectionAccessor
        public SQLiteConnection getRawConnection() {
            return PassthroughConnection.this.getRawConnection();
        }

        @Override // androidx.room.TransactionScope
        public Object rollback(T t9, c<?> cVar) throws ConnectionPool.RollbackException {
            throw new ConnectionPool.RollbackException(t9);
        }

        @Override // androidx.room.PooledConnection
        public <R> Object usePrepared(String str, k kVar, c<? super R> cVar) {
            return PassthroughConnection.this.usePrepared(str, kVar, cVar);
        }

        @Override // androidx.room.TransactionScope
        public <R> Object withNestedTransaction(n nVar, c<? super R> cVar) {
            PassthroughConnection passthroughConnection = PassthroughConnection.this;
            Transactor.SQLiteTransactionType sQLiteTransactionType = passthroughConnection.currentTransactionType;
            if (sQLiteTransactionType != null) {
                return passthroughConnection.transaction(sQLiteTransactionType, nVar, cVar);
            }
            throw new IllegalStateException("Required value was null.");
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Transactor.SQLiteTransactionType.values().length];
            try {
                iArr[Transactor.SQLiteTransactionType.DEFERRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.IMMEDIATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Transactor.SQLiteTransactionType.EXCLUSIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @J7.c(c = "androidx.room.coroutines.PassthroughConnection", f = "PassthroughConnectionPool.kt", l = {127}, m = "transaction")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.coroutines.PassthroughConnection$transaction$1, reason: invalid class name */
    public static final class AnonymousClass1<R> extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PassthroughConnection.this.transaction(null, null, this);
        }
    }

    @J7.c(c = "androidx.room.coroutines.PassthroughConnection", f = "PassthroughConnectionPool.kt", l = {89, 91}, m = "usePrepared")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.coroutines.PassthroughConnection$usePrepared$1, reason: invalid class name and case insensitive filesystem */
    public static final class C07911<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C07911(c<? super C07911> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PassthroughConnection.this.usePrepared(null, null, this);
        }
    }

    @J7.c(c = "androidx.room.coroutines.PassthroughConnection$usePrepared$2", f = "PassthroughConnectionPool.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.coroutines.PassthroughConnection$usePrepared$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements k {
        final /* synthetic */ k $block;
        final /* synthetic */ String $sql;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, k kVar, c<? super AnonymousClass2> cVar) {
            super(1, cVar);
            this.$sql = str;
            this.$block = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<r> create(c<?> cVar) {
            return PassthroughConnection.this.new AnonymousClass2(this.$sql, this.$block, cVar);
        }

        @Override // S7.k
        public final Object invoke(c<Object> cVar) {
            return ((AnonymousClass2) create(cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            SQLiteStatement sQLiteStatementPrepare = PassthroughConnection.this.getDelegate().prepare(this.$sql);
            try {
                Object objInvoke = this.$block.invoke(sQLiteStatementPrepare);
                e.s(sQLiteStatementPrepare, null);
                return objInvoke;
            } finally {
            }
        }
    }

    @J7.c(c = "androidx.room.coroutines.PassthroughConnection$withTransaction$2", f = "PassthroughConnectionPool.kt", l = {o.META_DATA_FIELD_NUMBER}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.coroutines.PassthroughConnection$withTransaction$2, reason: invalid class name and case insensitive filesystem */
    public static final class C07922 extends SuspendLambda implements k {
        final /* synthetic */ n $block;
        final /* synthetic */ Transactor.SQLiteTransactionType $type;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07922(Transactor.SQLiteTransactionType sQLiteTransactionType, n nVar, c<? super C07922> cVar) {
            super(1, cVar);
            this.$type = sQLiteTransactionType;
            this.$block = nVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<r> create(c<?> cVar) {
            return PassthroughConnection.this.new C07922(this.$type, this.$block, cVar);
        }

        @Override // S7.k
        public final Object invoke(c<Object> cVar) {
            return ((C07922) create(cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            PassthroughConnection passthroughConnection = PassthroughConnection.this;
            Transactor.SQLiteTransactionType sQLiteTransactionType = this.$type;
            n nVar = this.$block;
            this.label = 1;
            Object objTransaction = passthroughConnection.transaction(sQLiteTransactionType, nVar, this);
            return objTransaction == coroutineSingletons ? coroutineSingletons : objTransaction;
        }
    }

    public PassthroughConnection(n nVar, SQLiteConnection delegate) {
        kotlin.jvm.internal.k.f(delegate, "delegate");
        this.transactionWrapper = nVar;
        this.delegate = delegate;
        this.nestedTransactionCount = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <R> java.lang.Object transaction(androidx.room.Transactor.SQLiteTransactionType r8, S7.n r9, H7.c<? super R> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PassthroughConnection.transaction(androidx.room.Transactor$SQLiteTransactionType, S7.n, H7.c):java.lang.Object");
    }

    public final SQLiteConnection getDelegate() {
        return this.delegate;
    }

    @Override // androidx.room.coroutines.RawConnectionAccessor
    public SQLiteConnection getRawConnection() {
        return this.delegate;
    }

    public final n getTransactionWrapper() {
        return this.transactionWrapper;
    }

    @Override // androidx.room.Transactor
    public Object inTransaction(c<? super Boolean> cVar) {
        return Boolean.valueOf(this.currentTransactionType != null || this.delegate.inTransaction());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.room.PooledConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <R> java.lang.Object usePrepared(java.lang.String r6, S7.k r7, H7.c<? super R> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.room.coroutines.PassthroughConnection.C07911
            if (r0 == 0) goto L13
            r0 = r8
            androidx.room.coroutines.PassthroughConnection$usePrepared$1 r0 = (androidx.room.coroutines.PassthroughConnection.C07911) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.coroutines.PassthroughConnection$usePrepared$1 r0 = new androidx.room.coroutines.PassthroughConnection$usePrepared$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.b.b(r8)
            return r8
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            java.lang.Object r6 = r0.L$1
            r7 = r6
            S7.k r7 = (S7.k) r7
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.b.b(r8)
            goto L4f
        L3f:
            kotlin.b.b(r8)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r5.inTransaction(r0)
            if (r8 != r1) goto L4f
            goto L6d
        L4f:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            r2 = 0
            if (r8 == 0) goto L6f
            S7.n r8 = r5.transactionWrapper
            if (r8 == 0) goto L6f
            androidx.room.coroutines.PassthroughConnection$usePrepared$2 r4 = new androidx.room.coroutines.PassthroughConnection$usePrepared$2
            r4.<init>(r6, r7, r2)
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r5 = r8.invoke(r4, r0)
            if (r5 != r1) goto L6e
        L6d:
            return r1
        L6e:
            return r5
        L6f:
            androidx.sqlite.SQLiteConnection r5 = r5.delegate
            androidx.sqlite.SQLiteStatement r5 = r5.prepare(r6)
            java.lang.Object r6 = r7.invoke(r5)     // Catch: java.lang.Throwable -> L7d
            com.stepos.ability.task.executor.e.s(r5, r2)
            return r6
        L7d:
            r6 = move-exception
            throw r6     // Catch: java.lang.Throwable -> L7f
        L7f:
            r7 = move-exception
            com.stepos.ability.task.executor.e.s(r5, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.PassthroughConnection.usePrepared(java.lang.String, S7.k, H7.c):java.lang.Object");
    }

    @Override // androidx.room.Transactor
    public <R> Object withTransaction(Transactor.SQLiteTransactionType sQLiteTransactionType, n nVar, c<? super R> cVar) {
        n nVar2 = this.transactionWrapper;
        if (nVar2 == null) {
            return transaction(sQLiteTransactionType, nVar, cVar);
        }
        Object objInvoke = nVar2.invoke(new C07922(sQLiteTransactionType, nVar, null), cVar);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objInvoke;
    }
}
