package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import qb.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface ReceiveChannel<E> {
    void cancel(CancellationException cancellationException);

    ChannelIterator<E> iterator();

    Object receive(b<? super E> bVar);

    /* renamed from: receiveCatching-JP2dKIU */
    Object mo147receiveCatchingJP2dKIU(b<? super ChannelResult<? extends E>> bVar);

    /* renamed from: tryReceive-PtdJZtk */
    Object mo148tryReceivePtdJZtk();
}
