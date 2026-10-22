package kotlinx.coroutines.channels;

import ai.onnxruntime.a;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import lb.n;
import qb.b;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ConflatedBufferedChannel<E> extends BufferedChannel<E> {
    private final int capacity;
    private final BufferOverflow onBufferOverflow;

    public ConflatedBufferedChannel(int i10, BufferOverflow bufferOverflow, l<? super E, n> lVar) {
        super(i10, lVar);
        this.capacity = i10;
        this.onBufferOverflow = bufferOverflow;
        if (bufferOverflow != BufferOverflow.SUSPEND) {
            if (i10 < 1) {
                throw new IllegalArgumentException(a.g(i10, "Buffered channel capacity must be at least 1, but ", " was specified").toString());
            }
        } else {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + i.a(BufferedChannel.class).c() + " instead").toString());
        }
    }

    public static /* synthetic */ <E> Object send$suspendImpl(ConflatedBufferedChannel<E> conflatedBufferedChannel, E e10, b<? super n> bVar) throws Throwable {
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        Object objM167trySendImplMj0NB7M = conflatedBufferedChannel.m167trySendImplMj0NB7M(e10, true);
        if (!(objM167trySendImplMj0NB7M instanceof ChannelResult.Closed)) {
            return n.f10413a;
        }
        ChannelResult.m155exceptionOrNullimpl(objM167trySendImplMj0NB7M);
        l<E, n> lVar = conflatedBufferedChannel.onUndeliveredElement;
        if (lVar == null || (undeliveredElementExceptionCallUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(lVar, e10, null, 2, null)) == null) {
            throw conflatedBufferedChannel.getSendException();
        }
        jd.b.c(undeliveredElementExceptionCallUndeliveredElementCatchingException$default, conflatedBufferedChannel.getSendException());
        throw undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
    }

    /* renamed from: trySendDropLatest-Mj0NB7M, reason: not valid java name */
    private final Object m166trySendDropLatestMj0NB7M(E e10, boolean z) {
        l<E, n> lVar;
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        Object objMo149trySendJP2dKIU = super.mo149trySendJP2dKIU(e10);
        if (ChannelResult.m160isSuccessimpl(objMo149trySendJP2dKIU) || ChannelResult.m158isClosedimpl(objMo149trySendJP2dKIU)) {
            return objMo149trySendJP2dKIU;
        }
        if (!z || (lVar = this.onUndeliveredElement) == null || (undeliveredElementExceptionCallUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(lVar, e10, null, 2, null)) == null) {
            return ChannelResult.Companion.m165successJP2dKIU(n.f10413a);
        }
        throw undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
    }

    /* renamed from: trySendImpl-Mj0NB7M, reason: not valid java name */
    private final Object m167trySendImplMj0NB7M(E e10, boolean z) {
        return this.onBufferOverflow == BufferOverflow.DROP_LATEST ? m166trySendDropLatestMj0NB7M(e10, z) : m150trySendDropOldestJP2dKIU(e10);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean isConflatedDropOldest() {
        return this.onBufferOverflow == BufferOverflow.DROP_OLDEST;
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public Object send(E e10, b<? super n> bVar) {
        return send$suspendImpl((ConflatedBufferedChannel) this, (Object) e10, bVar);
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo149trySendJP2dKIU(E e10) {
        return m167trySendImplMj0NB7M(e10, false);
    }
}
