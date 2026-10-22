package kotlinx.coroutines.channels;

import lb.n;
import qb.b;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface SendChannel<E> {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        public static /* synthetic */ boolean close$default(SendChannel sendChannel, Throwable th, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
            }
            if ((i10 & 1) != 0) {
                th = null;
            }
            return sendChannel.close(th);
        }
    }

    boolean close(Throwable th);

    void invokeOnClose(l<? super Throwable, n> lVar);

    boolean isClosedForSend();

    Object send(E e10, b<? super n> bVar);

    /* renamed from: trySend-JP2dKIU */
    Object mo149trySendJP2dKIU(E e10);
}
