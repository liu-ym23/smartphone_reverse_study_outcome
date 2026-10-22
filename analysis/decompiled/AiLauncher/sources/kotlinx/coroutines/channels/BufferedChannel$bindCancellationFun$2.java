package kotlinx.coroutines.channels;

import Y8.t;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.q;

/* JADX INFO: Add missing generic type declarations: [E] */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* synthetic */ class BufferedChannel$bindCancellationFun$2<E> extends FunctionReferenceImpl implements q<Throwable, E, d, t> {
    public BufferedChannel$bindCancellationFun$2(Object obj) {
        super(3, obj, BufferedChannel.class, "onCancellationImplDoNotCall", "onCancellationImplDoNotCall(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p9.q
    public /* bridge */ /* synthetic */ t invoke(Throwable th, Object obj, d dVar) {
        l(th, obj, dVar);
        return t.f7040a;
    }

    public final void l(Throwable th, E e10, d dVar) {
        ((BufferedChannel) this.receiver).G0(th, e10, dVar);
    }
}
