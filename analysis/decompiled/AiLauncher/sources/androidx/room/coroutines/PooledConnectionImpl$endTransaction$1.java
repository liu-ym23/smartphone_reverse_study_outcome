package androidx.room.coroutines;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.room.coroutines.PooledConnectionImpl", f = "ConnectionPoolImpl.kt", l = {629}, m = "endTransaction")
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PooledConnectionImpl$endTransaction$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public boolean f14767a;

    /* renamed from: b, reason: collision with root package name */
    public Object f14768b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f14769c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ PooledConnectionImpl f14770d;

    /* renamed from: e, reason: collision with root package name */
    public int f14771e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PooledConnectionImpl$endTransaction$1(PooledConnectionImpl pooledConnectionImpl, InterfaceC4014c<? super PooledConnectionImpl$endTransaction$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f14770d = pooledConnectionImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f14769c = obj;
        this.f14771e |= Integer.MIN_VALUE;
        return this.f14770d.j(false, this);
    }
}
