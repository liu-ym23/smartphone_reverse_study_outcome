package androidx.room.coroutines;

import Ua.M;
import Y8.t;
import androidx.room.Transactor;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {"R", "LUa/M;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.room.coroutines.ConnectionPoolImpl$useConnection$2", f = "ConnectionPoolImpl.kt", l = {132}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ConnectionPoolImpl$useConnection$2<R> extends SuspendLambda implements p<M, InterfaceC4014c<? super R>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f14678a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p<Transactor, InterfaceC4014c<? super R>, Object> f14679b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PooledConnectionImpl f14680c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ConnectionPoolImpl$useConnection$2(p<? super Transactor, ? super InterfaceC4014c<? super R>, ? extends Object> pVar, PooledConnectionImpl pooledConnectionImpl, InterfaceC4014c<? super ConnectionPoolImpl$useConnection$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f14679b = pVar;
        this.f14680c = pooledConnectionImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ConnectionPoolImpl$useConnection$2(this.f14679b, this.f14680c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super R> interfaceC4014c) {
        return ((ConnectionPoolImpl$useConnection$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f14678a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        p<Transactor, InterfaceC4014c<? super R>, Object> pVar = this.f14679b;
        PooledConnectionImpl pooledConnectionImpl = this.f14680c;
        this.f14678a = 1;
        Object objInvoke = pVar.invoke(pooledConnectionImpl, this);
        return objInvoke == objG ? objG : objInvoke;
    }
}
