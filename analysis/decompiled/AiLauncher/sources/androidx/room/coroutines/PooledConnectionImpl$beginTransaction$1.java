package androidx.room.coroutines;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.room.coroutines.PooledConnectionImpl", f = "ConnectionPoolImpl.kt", l = {629}, m = "beginTransaction")
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PooledConnectionImpl$beginTransaction$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f14759a;

    /* renamed from: b, reason: collision with root package name */
    public Object f14760b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f14761c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ PooledConnectionImpl f14762d;

    /* renamed from: e, reason: collision with root package name */
    public int f14763e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PooledConnectionImpl$beginTransaction$1(PooledConnectionImpl pooledConnectionImpl, InterfaceC4014c<? super PooledConnectionImpl$beginTransaction$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f14762d = pooledConnectionImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f14761c = obj;
        this.f14763e |= Integer.MIN_VALUE;
        return this.f14762d.i(null, this);
    }
}
