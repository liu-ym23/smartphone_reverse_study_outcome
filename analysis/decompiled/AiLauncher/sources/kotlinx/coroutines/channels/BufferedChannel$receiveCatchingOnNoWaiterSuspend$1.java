package kotlinx.coroutines.channels;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", l = {3093}, m = "receiveCatchingOnNoWaiterSuspend-GKJJFZk", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f36310a;

    /* renamed from: b, reason: collision with root package name */
    public int f36311b;

    /* renamed from: c, reason: collision with root package name */
    public int f36312c;

    /* renamed from: d, reason: collision with root package name */
    public long f36313d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f36314e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ BufferedChannel<E> f36315f;

    /* renamed from: g, reason: collision with root package name */
    public int f36316g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(BufferedChannel<E> bufferedChannel, InterfaceC4014c<? super BufferedChannel$receiveCatchingOnNoWaiterSuspend$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f36315f = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f36314e = obj;
        this.f36316g |= Integer.MIN_VALUE;
        Object objX0 = this.f36315f.X0(null, 0, 0L, this);
        return objX0 == C4063a.g() ? objX0 : a.b(objX0);
    }
}
