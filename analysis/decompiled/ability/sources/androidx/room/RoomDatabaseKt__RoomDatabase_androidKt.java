package androidx.room;

import C7.r;
import H7.d;
import H7.e;
import H7.f;
import H7.h;
import S7.k;
import S7.n;
import java.util.Arrays;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.C1718k;
import m9.InterfaceC1717j;
import m9.InterfaceC1733z;
import s9.s;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0004\u001a8\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007\u001a8\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0080@¢\u0006\u0004\b\b\u0010\u0007\u001a>\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\tH\u0082@¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u0014\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a=\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u001b0\u001a*\u00020\u00012\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a8\u0010\u001e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0080@¢\u0006\u0004\b\u001e\u0010\u0007¨\u0006\u001f"}, d2 = {"R", "Landroidx/room/RoomDatabase;", "Lkotlin/Function1;", "LH7/c;", "", "block", "withTransaction", "(Landroidx/room/RoomDatabase;LS7/k;LH7/c;)Ljava/lang/Object;", "withTransactionContext", "Lkotlin/Function2;", "Lm9/z;", "transactionBlock", "startTransactionCoroutine$RoomDatabaseKt__RoomDatabase_androidKt", "(Landroidx/room/RoomDatabase;LS7/n;LH7/c;)Ljava/lang/Object;", "startTransactionCoroutine", "LH7/e;", "dispatcher", "LH7/h;", "createTransactionContext$RoomDatabaseKt__RoomDatabase_androidKt", "(Landroidx/room/RoomDatabase;LH7/e;)LH7/h;", "createTransactionContext", "", "", "tables", "", "emitInitialState", "Lp9/c;", "", "invalidationTrackerFlow", "(Landroidx/room/RoomDatabase;[Ljava/lang/String;Z)Lp9/c;", "compatTransactionCoroutineExecute", "room-runtime"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "androidx/room/RoomDatabaseKt")
/* loaded from: classes2.dex */
final /* synthetic */ class RoomDatabaseKt__RoomDatabase_androidKt {

    @J7.c(c = "androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2", f = "RoomDatabase.android.kt", l = {2044}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n"}, d2 = {"<anonymous>", "R"}, k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$withTransaction$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements k {
        final /* synthetic */ k $block;
        final /* synthetic */ RoomDatabase $this_withTransaction;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(RoomDatabase roomDatabase, k kVar, H7.c<? super AnonymousClass2> cVar) {
            super(1, cVar);
            this.$this_withTransaction = roomDatabase;
            this.$block = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(H7.c<?> cVar) {
            return new AnonymousClass2(this.$this_withTransaction, this.$block, cVar);
        }

        @Override // S7.k
        public final Object invoke(H7.c<? super R> cVar) {
            return ((AnonymousClass2) create(cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            try {
                if (i == 0) {
                    kotlin.b.b(obj);
                    this.$this_withTransaction.beginTransaction();
                    k kVar = this.$block;
                    this.label = 1;
                    obj = kVar.invoke(this);
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.b.b(obj);
                }
                this.$this_withTransaction.setTransactionSuccessful();
                return obj;
            } finally {
                this.$this_withTransaction.endTransaction();
            }
        }
    }

    public static final <R> Object compatTransactionCoroutineExecute(RoomDatabase roomDatabase, k kVar, H7.c<? super R> cVar) {
        if ((!roomDatabase.inCompatibilityMode() || !roomDatabase.isOpenInternal$room_runtime() || !roomDatabase.inTransaction()) && cVar.getContext().get(RoomExternalOperationElement.INSTANCE) != null) {
            return RoomDatabaseKt.withTransactionContext(roomDatabase, kVar, cVar);
        }
        return kVar.invoke(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h createTransactionContext$RoomDatabaseKt__RoomDatabase_androidKt(RoomDatabase roomDatabase, e eVar) {
        h hVarPlus = eVar.plus(new TransactionElement(eVar));
        return hVarPlus.plus(new s(roomDatabase.getSuspendingTransactionContext(), hVarPlus));
    }

    @C7.c
    public static final p9.c invalidationTrackerFlow(RoomDatabase roomDatabase, String[] tables, boolean z10) {
        kotlin.jvm.internal.k.f(roomDatabase, "<this>");
        kotlin.jvm.internal.k.f(tables, "tables");
        return roomDatabase.getInvalidationTracker().createFlow((String[]) Arrays.copyOf(tables, tables.length), z10);
    }

    public static /* synthetic */ p9.c invalidationTrackerFlow$default(RoomDatabase roomDatabase, String[] strArr, boolean z10, int i, Object obj) {
        if ((i & 2) != 0) {
            z10 = true;
        }
        return RoomDatabaseKt.invalidationTrackerFlow(roomDatabase, strArr, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <R> Object startTransactionCoroutine$RoomDatabaseKt__RoomDatabase_androidKt(final RoomDatabase roomDatabase, final n nVar, H7.c<? super R> cVar) {
        final C1718k c1718k = new C1718k(1, U7.a.I(cVar));
        c1718k.y();
        try {
            roomDatabase.getTransactionExecutor().execute(new Runnable() { // from class: androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1

                @J7.c(c = "androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1$1", f = "RoomDatabase.android.kt", l = {2087}, m = "invokeSuspend")
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
                /* renamed from: androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$startTransactionCoroutine$2$1$1, reason: invalid class name */
                public static final class AnonymousClass1 extends SuspendLambda implements n {
                    final /* synthetic */ InterfaceC1717j $continuation;
                    final /* synthetic */ RoomDatabase $this_startTransactionCoroutine;
                    final /* synthetic */ n $transactionBlock;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(RoomDatabase roomDatabase, InterfaceC1717j interfaceC1717j, n nVar, H7.c<? super AnonymousClass1> cVar) {
                        super(2, cVar);
                        this.$this_startTransactionCoroutine = roomDatabase;
                        this.$continuation = interfaceC1717j;
                        this.$transactionBlock = nVar;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_startTransactionCoroutine, this.$continuation, this.$transactionBlock, cVar);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) throws Throwable {
                        H7.c cVar;
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                        int i = this.label;
                        if (i == 0) {
                            kotlin.b.b(obj);
                            f fVar = ((InterfaceC1733z) this.L$0).getCoroutineContext().get(d.f758a);
                            kotlin.jvm.internal.k.c(fVar);
                            h hVarCreateTransactionContext$RoomDatabaseKt__RoomDatabase_androidKt = RoomDatabaseKt__RoomDatabase_androidKt.createTransactionContext$RoomDatabaseKt__RoomDatabase_androidKt(this.$this_startTransactionCoroutine, (e) fVar);
                            InterfaceC1717j interfaceC1717j = this.$continuation;
                            n nVar = this.$transactionBlock;
                            this.L$0 = interfaceC1717j;
                            this.label = 1;
                            obj = AbstractC1683A.w(hVarCreateTransactionContext$RoomDatabaseKt__RoomDatabase_androidKt, nVar, this);
                            if (obj == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            cVar = interfaceC1717j;
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            cVar = (H7.c) this.L$0;
                            kotlin.b.b(obj);
                        }
                        cVar.resumeWith(obj);
                        return r.f317a;
                    }

                    @Override // S7.n
                    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                        return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        AbstractC1683A.r(c1718k.getContext().minusKey(d.f758a), new AnonymousClass1(roomDatabase, c1718k, nVar, null));
                    } catch (Throwable th) {
                        c1718k.l(th);
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            c1718k.l(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e));
        }
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
    }

    public static final <R> Object withTransaction(RoomDatabase roomDatabase, k kVar, H7.c<? super R> cVar) {
        return RoomDatabaseKt.withTransactionContext(roomDatabase, new AnonymousClass2(roomDatabase, kVar, null), cVar);
    }

    public static final <R> Object withTransactionContext(RoomDatabase roomDatabase, k kVar, H7.c<? super R> cVar) {
        RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1(kVar, null);
        TransactionElement transactionElement = (TransactionElement) cVar.getContext().get(TransactionElement.INSTANCE);
        e transactionDispatcher = transactionElement != null ? transactionElement.getTransactionDispatcher() : null;
        return transactionDispatcher != null ? AbstractC1683A.w(transactionDispatcher, roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1, cVar) : startTransactionCoroutine$RoomDatabaseKt__RoomDatabase_androidKt(roomDatabase, roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1, cVar);
    }
}
