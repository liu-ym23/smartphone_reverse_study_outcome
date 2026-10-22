package kotlinx.coroutines.channels;

import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ChannelKt {
    public static final <E> Channel<E> Channel(int i10, BufferOverflow bufferOverflow, l<? super E, n> lVar) {
        if (i10 == -2) {
            return bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel(Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core(), lVar) : new ConflatedBufferedChannel(1, bufferOverflow, lVar);
        }
        if (i10 != -1) {
            return i10 != 0 ? i10 != Integer.MAX_VALUE ? bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel(i10, lVar) : new ConflatedBufferedChannel(i10, bufferOverflow, lVar) : new BufferedChannel(Integer.MAX_VALUE, lVar) : bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel(0, lVar) : new ConflatedBufferedChannel(1, bufferOverflow, lVar);
        }
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            return new ConflatedBufferedChannel(1, BufferOverflow.DROP_OLDEST, lVar);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
    }

    public static /* synthetic */ Channel Channel$default(int i10, BufferOverflow bufferOverflow, l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        if ((i11 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i11 & 4) != 0) {
            lVar = null;
        }
        return Channel(i10, bufferOverflow, lVar);
    }
}
