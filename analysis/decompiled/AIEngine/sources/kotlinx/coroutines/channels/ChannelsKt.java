package kotlinx.coroutines.channels;

/* loaded from: classes.dex */
public final class ChannelsKt {
    public static final void cancelConsumed(ReceiveChannel<?> receiveChannel, Throwable th) {
        ChannelsKt__Channels_commonKt.cancelConsumed(receiveChannel, th);
    }

    public static final <E> Object trySendBlocking(SendChannel<? super E> sendChannel, E e10) {
        return ChannelsKt__ChannelsKt.trySendBlocking(sendChannel, e10);
    }
}
