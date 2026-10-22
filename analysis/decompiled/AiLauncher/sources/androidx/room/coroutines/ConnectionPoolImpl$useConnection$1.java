package androidx.room.coroutines;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@InterfaceC4112d(c = "androidx.room.coroutines.ConnectionPoolImpl", f = "ConnectionPoolImpl.kt", l = {131, 135, 154, 159}, m = "useConnection")
/* loaded from: classes.dex */
public final class ConnectionPoolImpl$useConnection$1<R> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public boolean f14668a;

    /* renamed from: b, reason: collision with root package name */
    public Object f14669b;

    /* renamed from: c, reason: collision with root package name */
    public Object f14670c;

    /* renamed from: d, reason: collision with root package name */
    public Object f14671d;

    /* renamed from: e, reason: collision with root package name */
    public Object f14672e;

    /* renamed from: f, reason: collision with root package name */
    public Object f14673f;

    /* renamed from: g, reason: collision with root package name */
    public Object f14674g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f14675h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ ConnectionPoolImpl f14676i;

    /* renamed from: j, reason: collision with root package name */
    public int f14677j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectionPoolImpl$useConnection$1(ConnectionPoolImpl connectionPoolImpl, InterfaceC4014c<? super ConnectionPoolImpl$useConnection$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f14676i = connectionPoolImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f14675h = obj;
        this.f14677j |= Integer.MIN_VALUE;
        return this.f14676i.y(false, null, this);
    }
}
