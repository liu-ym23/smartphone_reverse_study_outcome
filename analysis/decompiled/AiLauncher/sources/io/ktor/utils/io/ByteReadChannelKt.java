package io.ktor.utils.io;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "LY8/t;", "cancel", "(Lio/ktor/utils/io/ByteReadChannel;)V", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ByteReadChannelKt {
    public static final void cancel(ByteReadChannel byteReadChannel) {
        p.i(byteReadChannel, "<this>");
        byteReadChannel.cancel(new IOException("Channel was cancelled"));
    }
}
