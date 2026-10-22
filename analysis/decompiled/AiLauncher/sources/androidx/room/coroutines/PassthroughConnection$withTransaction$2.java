package androidx.room.coroutines;

import Y8.t;
import androidx.room.B;
import androidx.room.Transactor;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@InterfaceC4112d(c = "androidx.room.coroutines.PassthroughConnection$withTransaction$2", f = "PassthroughConnectionPool.kt", l = {103}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PassthroughConnection$withTransaction$2 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super Object>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f14715a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PassthroughConnection f14716b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Transactor.SQLiteTransactionType f14717c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ p<B<R>, InterfaceC4014c<? super R>, Object> f14718d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PassthroughConnection$withTransaction$2(PassthroughConnection passthroughConnection, Transactor.SQLiteTransactionType sQLiteTransactionType, p<? super B<R>, ? super InterfaceC4014c<? super R>, ? extends Object> pVar, InterfaceC4014c<? super PassthroughConnection$withTransaction$2> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.f14716b = passthroughConnection;
        this.f14717c = sQLiteTransactionType;
        this.f14718d = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new PassthroughConnection$withTransaction$2(this.f14716b, this.f14717c, this.f14718d, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(InterfaceC4014c<Object> interfaceC4014c) {
        return ((PassthroughConnection$withTransaction$2) create(interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f14715a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        PassthroughConnection passthroughConnection = this.f14716b;
        Transactor.SQLiteTransactionType sQLiteTransactionType = this.f14717c;
        p<B<R>, InterfaceC4014c<? super R>, Object> pVar = this.f14718d;
        this.f14715a = 1;
        Object objG2 = passthroughConnection.g(sQLiteTransactionType, pVar, this);
        return objG2 == objG ? objG : objG2;
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ Object invoke(InterfaceC4014c<? super Object> interfaceC4014c) {
        return invoke2((InterfaceC4014c<Object>) interfaceC4014c);
    }
}
