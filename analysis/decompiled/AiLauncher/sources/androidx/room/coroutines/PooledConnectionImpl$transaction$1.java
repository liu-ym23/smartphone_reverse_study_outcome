package androidx.room.coroutines;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@InterfaceC4112d(c = "androidx.room.coroutines.PooledConnectionImpl", f = "ConnectionPoolImpl.kt", l = {464, 468, 482, 482, 482}, m = "transaction")
/* loaded from: classes.dex */
public final class PooledConnectionImpl$transaction$1<R> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f14772a;

    /* renamed from: b, reason: collision with root package name */
    public Object f14773b;

    /* renamed from: c, reason: collision with root package name */
    public int f14774c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f14775d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ PooledConnectionImpl f14776e;

    /* renamed from: f, reason: collision with root package name */
    public int f14777f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PooledConnectionImpl$transaction$1(PooledConnectionImpl pooledConnectionImpl, InterfaceC4014c<? super PooledConnectionImpl$transaction$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f14776e = pooledConnectionImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f14775d = obj;
        this.f14777f |= Integer.MIN_VALUE;
        return this.f14776e.o(null, null, this);
    }
}
