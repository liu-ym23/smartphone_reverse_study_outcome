package androidx.room.util;

import C7.r;
import D7.N;
import H7.h;
import J7.c;
import S7.k;
import S7.n;
import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.TransactionElement;
import androidx.room.coroutines.RunBlockingUninterruptible_androidKt;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.driver.SupportSQLiteConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001aB\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006H\u0087@¢\u0006\u0004\b\t\u0010\n\u001aA\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a<\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0006H\u0087@¢\u0006\u0004\b\u000f\u0010\u0010\u001aB\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00032\u001e\b\u0004\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0006H\u0082H¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001c\u0010\u0015\u001a\u00020\u0014*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\u0080@¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a1\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0007¢\u0006\u0004\b\u001b\u0010\u001f\u001a\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020 H\u0007¢\u0006\u0004\b\"\u0010#\u001a\u001f\u0010&\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020 2\u0006\u0010%\u001a\u00020$H\u0007¢\u0006\u0004\b&\u0010'\u001a\u0017\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020(H\u0007¢\u0006\u0004\b+\u0010,\u001a\u000f\u0010-\u001a\u00020\u001dH\u0007¢\u0006\u0004\b-\u0010.\u001a\u0017\u0010/\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020 H\u0007¢\u0006\u0004\b/\u00100¨\u00061"}, d2 = {"R", "Landroidx/room/RoomDatabase;", "db", "", "isReadOnly", "inTransaction", "Lkotlin/Function1;", "Landroidx/sqlite/SQLiteConnection;", "block", "performSuspending", "(Landroidx/room/RoomDatabase;ZZLS7/k;LH7/c;)Ljava/lang/Object;", "performBlocking", "(Landroidx/room/RoomDatabase;ZZLS7/k;)Ljava/lang/Object;", "LH7/c;", "", "performInTransactionSuspending", "(Landroidx/room/RoomDatabase;LS7/k;LH7/c;)Ljava/lang/Object;", "compatCoroutineExecute$DBUtil__DBUtil_androidKt", "(Landroidx/room/RoomDatabase;ZLS7/k;LH7/c;)Ljava/lang/Object;", "compatCoroutineExecute", "LH7/h;", "getCoroutineContext", "(Landroidx/room/RoomDatabase;ZLH7/c;)Ljava/lang/Object;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "sqLiteQuery", "maybeCopy", "Landroid/database/Cursor;", "query", "(Landroidx/room/RoomDatabase;Landroidx/sqlite/db/SupportSQLiteQuery;Z)Landroid/database/Cursor;", "Landroid/os/CancellationSignal;", "signal", "(Landroidx/room/RoomDatabase;Landroidx/sqlite/db/SupportSQLiteQuery;ZLandroid/os/CancellationSignal;)Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "LC7/r;", "dropFtsSyncTriggers", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "", "tableName", "foreignKeyCheck", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/lang/String;)V", "Ljava/io/File;", "databaseFile", "", "readVersion", "(Ljava/io/File;)I", "createCancellationSignal", "()Landroid/os/CancellationSignal;", "toSQLiteConnection", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)Landroidx/sqlite/SQLiteConnection;", "room-runtime"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "androidx/room/util/DBUtil")
/* loaded from: classes2.dex */
final /* synthetic */ class DBUtil__DBUtil_androidKt {

    @c(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performBlocking$1", f = "DBUtil.android.kt", l = {72}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {"R", "Lm9/z;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
    /* renamed from: androidx.room.util.DBUtil__DBUtil_androidKt$performBlocking$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ k $block;
        final /* synthetic */ h $context;
        final /* synthetic */ RoomDatabase $db;
        final /* synthetic */ boolean $inTransaction;
        final /* synthetic */ boolean $isReadOnly;
        int label;

        @c(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performBlocking$1$1", f = "DBUtil.android.kt", l = {260}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {"R", "Lm9/z;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
        /* renamed from: androidx.room.util.DBUtil__DBUtil_androidKt$performBlocking$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01321 extends SuspendLambda implements n {
            final /* synthetic */ k $block;
            final /* synthetic */ RoomDatabase $db;
            final /* synthetic */ boolean $inTransaction;
            final /* synthetic */ boolean $isReadOnly;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01321(RoomDatabase roomDatabase, boolean z10, boolean z11, k kVar, H7.c<? super C01321> cVar) {
                super(2, cVar);
                this.$db = roomDatabase;
                this.$inTransaction = z10;
                this.$isReadOnly = z11;
                this.$block = kVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new C01321(this.$db, this.$inTransaction, this.$isReadOnly, this.$block, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
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
                boolean z10 = !(this.$db.inCompatibilityMode() && this.$db.inTransaction()) && this.$inTransaction;
                RoomDatabase roomDatabase = this.$db;
                boolean z11 = this.$isReadOnly;
                DBUtil__DBUtil_androidKt$performBlocking$1$1$invokeSuspend$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performBlocking$1$1$invokeSuspend$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performBlocking$1$1$invokeSuspend$$inlined$internalPerform$1(z10, z11, roomDatabase, null, this.$block);
                this.label = 1;
                Object objUseConnection = roomDatabase.useConnection(z11, dBUtil__DBUtil_androidKt$performBlocking$1$1$invokeSuspend$$inlined$internalPerform$1, this);
                return objUseConnection == coroutineSingletons ? coroutineSingletons : objUseConnection;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super R> cVar) {
                return ((C01321) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(h hVar, RoomDatabase roomDatabase, boolean z10, boolean z11, k kVar, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$context = hVar;
            this.$db = roomDatabase;
            this.$inTransaction = z10;
            this.$isReadOnly = z11;
            this.$block = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass1(this.$context, this.$db, this.$inTransaction, this.$isReadOnly, this.$block, cVar);
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
            h hVar = this.$context;
            C01321 c01321 = new C01321(this.$db, this.$inTransaction, this.$isReadOnly, this.$block, null);
            this.label = 1;
            Object objW = AbstractC1683A.w(hVar, c01321, this);
            return objW == coroutineSingletons ? coroutineSingletons : objW;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super R> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "androidx.room.util.DBUtil__DBUtil_androidKt", f = "DBUtil.android.kt", l = {97, 262, 264, 264}, m = "performInTransactionSuspending")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$1, reason: invalid class name and case insensitive filesystem */
    public static final class C08081<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C08081(H7.c<? super C08081> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DBUtil.performInTransactionSuspending(null, null, this);
        }
    }

    @c(c = "androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$2", f = "DBUtil.android.kt", l = {260}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n"}, d2 = {"<anonymous>", "R"}, k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements k {
        final /* synthetic */ k $block;
        final /* synthetic */ RoomDatabase $db;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(RoomDatabase roomDatabase, k kVar, H7.c<? super AnonymousClass2> cVar) {
            super(1, cVar);
            this.$db = roomDatabase;
            this.$block = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(H7.c<?> cVar) {
            return new AnonymousClass2(this.$db, this.$block, cVar);
        }

        @Override // S7.k
        public final Object invoke(H7.c<? super R> cVar) {
            return ((AnonymousClass2) create(cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
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
            RoomDatabase roomDatabase = this.$db;
            DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1 dBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1 = new DBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1(true, false, roomDatabase, null, this.$block);
            this.label = 1;
            Object objUseConnection = roomDatabase.useConnection(false, dBUtil__DBUtil_androidKt$performInTransactionSuspending$2$invokeSuspend$$inlined$internalPerform$1, this);
            return objUseConnection == coroutineSingletons ? coroutineSingletons : objUseConnection;
        }
    }

    @c(c = "androidx.room.util.DBUtil__DBUtil_androidKt", f = "DBUtil.android.kt", l = {262, 264, 264}, m = "performSuspending")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1, reason: invalid class name and case insensitive filesystem */
    public static final class C08091<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        public C08091(H7.c<? super C08091> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DBUtil.performSuspending(null, false, false, null, this);
        }
    }

    private static final <R> Object compatCoroutineExecute$DBUtil__DBUtil_androidKt(RoomDatabase roomDatabase, boolean z10, k kVar, H7.c<? super R> cVar) {
        return (roomDatabase.inCompatibilityMode() && roomDatabase.isOpenInternal$room_runtime() && roomDatabase.inTransaction()) ? kVar.invoke(cVar) : AbstractC1683A.w((h) DBUtil.getCoroutineContext(roomDatabase, z10, cVar), new DBUtil__DBUtil_androidKt$compatCoroutineExecute$2(kVar, null), cVar);
    }

    @C7.c
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final CancellationSignal createCancellationSignal() {
        return new CancellationSignal();
    }

    @C7.c
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final void dropFtsSyncTriggers(SupportSQLiteDatabase db) {
        kotlin.jvm.internal.k.f(db, "db");
        DBUtil.dropFtsSyncTriggers(new SupportSQLiteConnection(db));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final void foreignKeyCheck(SupportSQLiteDatabase db, String tableName) {
        kotlin.jvm.internal.k.f(db, "db");
        kotlin.jvm.internal.k.f(tableName, "tableName");
        DBUtil.foreignKeyCheck(new SupportSQLiteConnection(db), tableName);
    }

    public static final Object getCoroutineContext(RoomDatabase roomDatabase, boolean z10, H7.c<? super h> cVar) {
        TransactionElement transactionElement = (TransactionElement) cVar.getContext().get(TransactionElement.INSTANCE);
        h transactionDispatcher = transactionElement != null ? transactionElement.getTransactionDispatcher() : null;
        if (roomDatabase.inCompatibilityMode()) {
            return transactionDispatcher != null ? roomDatabase.getQueryContext().plus(transactionDispatcher) : z10 ? roomDatabase.getTransactionContext$room_runtime() : roomDatabase.getQueryContext();
        }
        h queryContext = roomDatabase.getQueryContext();
        if (transactionDispatcher == null) {
            transactionDispatcher = EmptyCoroutineContext.f4908a;
        }
        return queryContext.plus(transactionDispatcher);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <R> R performBlocking(RoomDatabase db, boolean z10, boolean z11, k block) {
        kotlin.jvm.internal.k.f(db, "db");
        kotlin.jvm.internal.k.f(block, "block");
        db.assertNotMainThread();
        db.assertNotSuspendingTransaction();
        h hVar = db.getSuspendingTransactionContext().get();
        if (hVar == null) {
            hVar = EmptyCoroutineContext.f4908a;
        }
        return (R) RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new AnonymousClass1(hVar, db, z11, z10, block, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <R> java.lang.Object performInTransactionSuspending(androidx.room.RoomDatabase r11, S7.k r12, H7.c<? super R> r13) throws java.lang.Throwable {
        /*
            boolean r1 = r13 instanceof androidx.room.util.DBUtil__DBUtil_androidKt.C08081
            if (r1 == 0) goto L14
            r1 = r13
            androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$1 r1 = (androidx.room.util.DBUtil__DBUtil_androidKt.C08081) r1
            int r2 = r1.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r2 & r4
            if (r6 == 0) goto L14
            int r2 = r2 - r4
            r1.label = r2
        L12:
            r6 = r1
            goto L1a
        L14:
            androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$1 r1 = new androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$1
            r1.<init>(r13)
            goto L12
        L1a:
            java.lang.Object r0 = r6.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r6.label
            r2 = 4
            r4 = 3
            r8 = 2
            r9 = 1
            r10 = 0
            if (r1 == 0) goto L4f
            if (r1 == r9) goto L4b
            if (r1 == r8) goto L47
            if (r1 == r4) goto L3b
            if (r1 != r2) goto L33
            kotlin.b.b(r0)
            return r0
        L33:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3b:
            java.lang.Object r1 = r6.L$1
            S7.k r1 = (S7.k) r1
            java.lang.Object r3 = r6.L$0
            androidx.room.RoomDatabase r3 = (androidx.room.RoomDatabase) r3
            kotlin.b.b(r0)
            goto L9d
        L47:
            kotlin.b.b(r0)
            return r0
        L4b:
            kotlin.b.b(r0)
            return r0
        L4f:
            kotlin.b.b(r0)
            boolean r0 = r11.inCompatibilityMode()
            if (r0 == 0) goto L67
            androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$2 r0 = new androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$2
            r0.<init>(r11, r12, r10)
            r6.label = r9
            java.lang.Object r0 = androidx.room.RoomDatabaseKt.withTransactionContext(r11, r0, r6)
            if (r0 != r7) goto L66
            goto Lb0
        L66:
            return r0
        L67:
            boolean r0 = r11.inCompatibilityMode()
            if (r0 == 0) goto L8e
            boolean r0 = r11.isOpenInternal$room_runtime()
            if (r0 == 0) goto L8e
            boolean r0 = r11.inTransaction()
            if (r0 == 0) goto L8e
            androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1 r0 = new androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$lambda$3$$inlined$internalPerform$1
            r2 = 0
            r4 = 0
            r1 = 1
            r3 = r11
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            r6.label = r8
            r1 = 0
            java.lang.Object r0 = r11.useConnection(r1, r0, r6)
            if (r0 != r7) goto L8d
            goto Lb0
        L8d:
            return r0
        L8e:
            r6.L$0 = r11
            r6.L$1 = r12
            r6.label = r4
            java.lang.Object r0 = androidx.room.util.DBUtil.getCoroutineContext(r11, r9, r6)
            if (r0 != r7) goto L9b
            goto Lb0
        L9b:
            r3 = r11
            r1 = r12
        L9d:
            H7.h r0 = (H7.h) r0
            androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1 r4 = new androidx.room.util.DBUtil__DBUtil_androidKt$performInTransactionSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1
            r4.<init>(r10, r3, r1)
            r6.L$0 = r10
            r6.L$1 = r10
            r6.label = r2
            java.lang.Object r0 = m9.AbstractC1683A.w(r0, r4, r6)
            if (r0 != r7) goto Lb1
        Lb0:
            return r7
        Lb1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil__DBUtil_androidKt.performInTransactionSuspending(androidx.room.RoomDatabase, S7.k, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <R> java.lang.Object performSuspending(androidx.room.RoomDatabase r14, boolean r15, boolean r16, S7.k r17, H7.c<? super R> r18) throws java.lang.Throwable {
        /*
            r0 = r18
            boolean r1 = r0 instanceof androidx.room.util.DBUtil__DBUtil_androidKt.C08091
            if (r1 == 0) goto L16
            r1 = r0
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1 r1 = (androidx.room.util.DBUtil__DBUtil_androidKt.C08091) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.label = r2
        L14:
            r6 = r1
            goto L1c
        L16:
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1 r1 = new androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1
            r1.<init>(r0)
            goto L14
        L1c:
            java.lang.Object r0 = r6.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r6.label
            r2 = 3
            r3 = 2
            r8 = 1
            if (r1 == 0) goto L51
            if (r1 == r8) goto L4d
            if (r1 == r3) goto L39
            if (r1 != r2) goto L31
            kotlin.b.b(r0)
            return r0
        L31:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L39:
            boolean r14 = r6.Z$1
            boolean r15 = r6.Z$0
            java.lang.Object r1 = r6.L$1
            S7.k r1 = (S7.k) r1
            java.lang.Object r3 = r6.L$0
            androidx.room.RoomDatabase r3 = (androidx.room.RoomDatabase) r3
            kotlin.b.b(r0)
            r12 = r14
            r13 = r1
            r10 = r3
        L4b:
            r11 = r15
            goto L97
        L4d:
            kotlin.b.b(r0)
            return r0
        L51:
            kotlin.b.b(r0)
            boolean r0 = r14.inCompatibilityMode()
            if (r0 == 0) goto L7d
            boolean r0 = r14.isOpenInternal$room_runtime()
            if (r0 == 0) goto L7d
            boolean r0 = r14.inTransaction()
            if (r0 == 0) goto L7d
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 r0 = new androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1
            r4 = 0
            r3 = r14
            r2 = r15
            r1 = r16
            r5 = r17
            r0.<init>(r1, r2, r3, r4, r5)
            r2 = r0
            r6.label = r8
            java.lang.Object r14 = r14.useConnection(r15, r2, r6)
            if (r14 != r7) goto L7c
            goto Lac
        L7c:
            return r14
        L7d:
            r4 = r16
            r6.L$0 = r14
            r5 = r17
            r6.L$1 = r5
            r6.Z$0 = r15
            r6.Z$1 = r4
            r6.label = r3
            java.lang.Object r3 = androidx.room.util.DBUtil.getCoroutineContext(r14, r4, r6)
            if (r3 != r7) goto L92
            goto Lac
        L92:
            r10 = r14
            r0 = r3
            r12 = r4
            r13 = r5
            goto L4b
        L97:
            H7.h r0 = (H7.h) r0
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1 r8 = new androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1
            r9 = 0
            r8.<init>(r9, r10, r11, r12, r13)
            r14 = 0
            r6.L$0 = r14
            r6.L$1 = r14
            r6.label = r2
            java.lang.Object r14 = m9.AbstractC1683A.w(r0, r8, r6)
            if (r14 != r7) goto Lad
        Lac:
            return r7
        Lad:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil__DBUtil_androidKt.performSuspending(androidx.room.RoomDatabase, boolean, boolean, S7.k, H7.c):java.lang.Object");
    }

    @C7.c
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final Cursor query(RoomDatabase db, SupportSQLiteQuery sqLiteQuery, boolean z10) {
        kotlin.jvm.internal.k.f(db, "db");
        kotlin.jvm.internal.k.f(sqLiteQuery, "sqLiteQuery");
        return DBUtil.query(db, sqLiteQuery, z10, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int readVersion(File databaseFile) throws IOException {
        kotlin.jvm.internal.k.f(databaseFile, "databaseFile");
        FileChannel channel = new FileInputStream(databaseFile).getChannel();
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(byteBufferAllocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            byteBufferAllocate.rewind();
            int i = byteBufferAllocate.getInt();
            N.t(channel, null);
            return i;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                N.t(channel, th);
                throw th2;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final SQLiteConnection toSQLiteConnection(SupportSQLiteDatabase db) {
        kotlin.jvm.internal.k.f(db, "db");
        return new SupportSQLiteConnection(db);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final Cursor query(RoomDatabase db, SupportSQLiteQuery sqLiteQuery, boolean z10, CancellationSignal cancellationSignal) {
        kotlin.jvm.internal.k.f(db, "db");
        kotlin.jvm.internal.k.f(sqLiteQuery, "sqLiteQuery");
        Cursor cursorQuery = db.query(sqLiteQuery, cancellationSignal);
        if (!z10 || !(cursorQuery instanceof AbstractWindowedCursor)) {
            return cursorQuery;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) cursorQuery;
        int count = abstractWindowedCursor.getCount();
        return (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count ? CursorUtil.copyAndClose(cursorQuery) : cursorQuery;
    }
}
