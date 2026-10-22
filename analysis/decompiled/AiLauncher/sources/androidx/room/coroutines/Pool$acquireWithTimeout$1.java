package androidx.room.coroutines;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.room.coroutines.Pool", f = "ConnectionPoolImpl.kt", l = {231}, m = "acquireWithTimeout-KLykuaI")
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Pool$acquireWithTimeout$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public long f14740a;

    /* renamed from: b, reason: collision with root package name */
    public Object f14741b;

    /* renamed from: c, reason: collision with root package name */
    public Object f14742c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f14743d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Pool f14744e;

    /* renamed from: f, reason: collision with root package name */
    public int f14745f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pool$acquireWithTimeout$1(Pool pool, InterfaceC4014c<? super Pool$acquireWithTimeout$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f14744e = pool;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f14743d = obj;
        this.f14745f |= Integer.MIN_VALUE;
        return this.f14744e.b(0L, null, this);
    }
}
