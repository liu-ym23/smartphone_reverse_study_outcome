package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u001e\u0010\t\u001a\u00020\u0004*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/CountedByteReadChannel;", "counted", "(Lio/ktor/utils/io/ByteReadChannel;)Lio/ktor/utils/io/CountedByteReadChannel;", "", "getTotalBytesRead", "(Lio/ktor/utils/io/ByteReadChannel;)J", "getTotalBytesRead$annotations", "(Lio/ktor/utils/io/ByteReadChannel;)V", "totalBytesRead", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CountedByteReadChannelKt {
    public static final CountedByteReadChannel counted(ByteReadChannel byteReadChannel) {
        p.i(byteReadChannel, "<this>");
        return new CountedByteReadChannel(byteReadChannel);
    }

    public static final long getTotalBytesRead(ByteReadChannel byteReadChannel) {
        p.i(byteReadChannel, "<this>");
        throw new IllegalStateException("Counter is no longer available on the regular ByteReadChannel. Use CounterByteReadChannel instead.");
    }

    public static /* synthetic */ void getTotalBytesRead$annotations(ByteReadChannel byteReadChannel) {
    }
}
