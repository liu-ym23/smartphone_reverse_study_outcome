package io.ktor.utils.io;

import Ua.M;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/utils/io/ReaderScope;", "LUa/M;", "Lio/ktor/utils/io/ByteReadChannel;", "channel", "Lkotlin/coroutines/d;", "coroutineContext", "<init>", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/d;)V", "Lio/ktor/utils/io/ByteReadChannel;", "getChannel", "()Lio/ktor/utils/io/ByteReadChannel;", "Lkotlin/coroutines/d;", "getCoroutineContext", "()Lkotlin/coroutines/d;", "ktor-io"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ReaderScope implements M {
    private final ByteReadChannel channel;
    private final kotlin.coroutines.d coroutineContext;

    public ReaderScope(ByteReadChannel channel, kotlin.coroutines.d coroutineContext) {
        p.i(channel, "channel");
        p.i(coroutineContext, "coroutineContext");
        this.channel = channel;
        this.coroutineContext = coroutineContext;
    }

    public final ByteReadChannel getChannel() {
        return this.channel;
    }

    @Override // Ua.M
    public kotlin.coroutines.d getCoroutineContext() {
        return this.coroutineContext;
    }
}
