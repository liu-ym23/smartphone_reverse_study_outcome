package io.ktor.utils.io;

import fb.InterfaceC4083j;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lfb/j;", "Lio/ktor/utils/io/ByteWriteChannel;", "asByteWriteChannel", "(Lfb/j;)Lio/ktor/utils/io/ByteWriteChannel;", "ktor-io"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SinkByteWriteChannelKt {
    public static final ByteWriteChannel asByteWriteChannel(InterfaceC4083j interfaceC4083j) {
        p.i(interfaceC4083j, "<this>");
        return new SinkByteWriteChannel(interfaceC4083j);
    }
}
