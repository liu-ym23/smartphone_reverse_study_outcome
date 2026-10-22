package io.ktor.utils.io.jvm.nio;

import Ua.Y;
import fb.InterfaceC4084k;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.RawSourceChannel;
import java.nio.channels.ReadableByteChannel;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ljava/nio/channels/ReadableByteChannel;", "Lkotlin/coroutines/d;", "context", "Lio/ktor/utils/io/ByteReadChannel;", "toByteReadChannel", "(Ljava/nio/channels/ReadableByteChannel;Lkotlin/coroutines/d;)Lio/ktor/utils/io/ByteReadChannel;", "Lfb/k;", "asSource", "(Ljava/nio/channels/ReadableByteChannel;)Lfb/k;", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ReadingKt {
    public static final InterfaceC4084k asSource(ReadableByteChannel readableByteChannel) {
        p.i(readableByteChannel, "<this>");
        return new ReadableByteChannelSource(readableByteChannel);
    }

    public static final ByteReadChannel toByteReadChannel(ReadableByteChannel readableByteChannel, d context) {
        p.i(readableByteChannel, "<this>");
        p.i(context, "context");
        return new RawSourceChannel(asSource(readableByteChannel), context);
    }

    public static /* synthetic */ ByteReadChannel toByteReadChannel$default(ReadableByteChannel readableByteChannel, d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            dVar = Y.b();
        }
        return toByteReadChannel(readableByteChannel, dVar);
    }
}
