package kotlinx.coroutines.channels;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", l = {736}, m = "receiveCatching-JP2dKIU$suspendImpl", v = 1)
/* loaded from: classes5.dex */
public final class BufferedChannel$receiveCatching$1<E> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f36295a;

    /* renamed from: b, reason: collision with root package name */
    public Object f36296b;

    /* renamed from: c, reason: collision with root package name */
    public Object f36297c;

    /* renamed from: d, reason: collision with root package name */
    public Object f36298d;

    /* renamed from: e, reason: collision with root package name */
    public Object f36299e;

    /* renamed from: f, reason: collision with root package name */
    public int f36300f;

    /* renamed from: g, reason: collision with root package name */
    public int f36301g;

    /* renamed from: h, reason: collision with root package name */
    public int f36302h;

    /* renamed from: i, reason: collision with root package name */
    public int f36303i;

    /* renamed from: j, reason: collision with root package name */
    public long f36304j;

    /* renamed from: k, reason: collision with root package name */
    public long f36305k;

    /* renamed from: l, reason: collision with root package name */
    public long f36306l;

    /* renamed from: m, reason: collision with root package name */
    public /* synthetic */ Object f36307m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ BufferedChannel<E> f36308n;

    /* renamed from: o, reason: collision with root package name */
    public int f36309o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BufferedChannel$receiveCatching$1(BufferedChannel<E> bufferedChannel, InterfaceC4014c<? super BufferedChannel$receiveCatching$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f36308n = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f36307m = obj;
        this.f36309o |= Integer.MIN_VALUE;
        Object objW0 = BufferedChannel.W0(this.f36308n, this);
        return objW0 == C4063a.g() ? objW0 : a.b(objW0);
    }
}
