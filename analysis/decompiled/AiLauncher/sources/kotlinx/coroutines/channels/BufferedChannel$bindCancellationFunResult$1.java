package kotlinx.coroutines.channels;

import Y8.t;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.q;

/* JADX INFO: Add missing generic type declarations: [E] */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class BufferedChannel$bindCancellationFunResult$1<E> extends FunctionReferenceImpl implements q<Throwable, a<? extends E>, d, t> {
    public BufferedChannel$bindCancellationFunResult$1(Object obj) {
        super(3, obj, BufferedChannel.class, "onCancellationChannelResultImplDoNotCall", "onCancellationChannelResultImplDoNotCall-5_sEAP8(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0);
    }

    @Override // p9.q
    public /* bridge */ /* synthetic */ t invoke(Throwable th, Object obj, d dVar) {
        l(th, ((a) obj).getHolder(), dVar);
        return t.f7040a;
    }

    public final void l(Throwable th, Object obj, d dVar) {
        ((BufferedChannel) this.receiver).F0(th, obj, dVar);
    }
}
