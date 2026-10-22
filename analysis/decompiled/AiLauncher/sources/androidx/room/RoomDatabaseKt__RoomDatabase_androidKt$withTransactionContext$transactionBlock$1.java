package androidx.room;

import Ua.M;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {"R", "LUa/M;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.room.RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1", f = "RoomDatabase.android.kt", l = {2058}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1<R> extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super R>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f14539a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f14540b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InterfaceC5074l<InterfaceC4014c<? super R>, Object> f14541c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1(InterfaceC5074l<? super InterfaceC4014c<? super R>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f14541c = interfaceC5074l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1 = new RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1(this.f14541c, interfaceC4014c);
        roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1.f14540b = obj;
        return roomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super R> interfaceC4014c) {
        return ((RoomDatabaseKt__RoomDatabase_androidKt$withTransactionContext$transactionBlock$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f14539a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        if (((M) this.f14540b).getCoroutineContext().get(y.INSTANCE) == null) {
            throw new IllegalStateException("Expected a TransactionElement in the CoroutineContext but none was found.");
        }
        InterfaceC5074l<InterfaceC4014c<? super R>, Object> interfaceC5074l = this.f14541c;
        this.f14539a = 1;
        Object objInvoke = interfaceC5074l.invoke(this);
        return objInvoke == objG ? objG : objInvoke;
    }
}
