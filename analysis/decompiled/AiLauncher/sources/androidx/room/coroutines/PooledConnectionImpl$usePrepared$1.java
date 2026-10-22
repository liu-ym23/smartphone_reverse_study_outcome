package androidx.room.coroutines;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@InterfaceC4112d(c = "androidx.room.coroutines.PooledConnectionImpl", f = "ConnectionPoolImpl.kt", l = {640}, m = "usePrepared")
/* loaded from: classes.dex */
public final class PooledConnectionImpl$usePrepared$1<R> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f14778a;

    /* renamed from: b, reason: collision with root package name */
    public Object f14779b;

    /* renamed from: c, reason: collision with root package name */
    public Object f14780c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f14781d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ PooledConnectionImpl f14782e;

    /* renamed from: f, reason: collision with root package name */
    public int f14783f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PooledConnectionImpl$usePrepared$1(PooledConnectionImpl pooledConnectionImpl, InterfaceC4014c<? super PooledConnectionImpl$usePrepared$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f14782e = pooledConnectionImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f14781d = obj;
        this.f14783f |= Integer.MIN_VALUE;
        return this.f14782e.d(null, null, this);
    }
}
