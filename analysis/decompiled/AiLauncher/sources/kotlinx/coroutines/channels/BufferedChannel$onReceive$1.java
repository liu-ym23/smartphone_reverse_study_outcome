package kotlinx.coroutines.channels;

import Y8.t;
import cb.j;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.q;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class BufferedChannel$onReceive$1 extends FunctionReferenceImpl implements q<BufferedChannel<?>, j<?>, Object, t> {

    /* renamed from: a, reason: collision with root package name */
    public static final BufferedChannel$onReceive$1 f36291a = new BufferedChannel$onReceive$1();

    public BufferedChannel$onReceive$1() {
        super(3, BufferedChannel.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // p9.q
    public /* bridge */ /* synthetic */ t invoke(BufferedChannel<?> bufferedChannel, j<?> jVar, Object obj) {
        l(bufferedChannel, jVar, obj);
        return t.f7040a;
    }

    public final void l(BufferedChannel<?> bufferedChannel, j<?> jVar, Object obj) {
        bufferedChannel.Z0(jVar, obj);
    }
}
