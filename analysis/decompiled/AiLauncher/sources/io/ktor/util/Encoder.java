package io.ktor.util;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u0006\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\tJ!\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u0007¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lio/ktor/util/Encoder;", "", "Lio/ktor/utils/io/ByteReadChannel;", "source", "Lkotlin/coroutines/d;", "coroutineContext", "encode", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/d;)Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/d;)Lio/ktor/utils/io/ByteWriteChannel;", "decode", "ktor-utils"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface Encoder {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ ByteReadChannel decode$default(Encoder encoder, ByteReadChannel byteReadChannel, kotlin.coroutines.d dVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        }
        if ((i10 & 2) != 0) {
            dVar = EmptyCoroutineContext.f34779a;
        }
        return encoder.decode(byteReadChannel, dVar);
    }

    static /* synthetic */ ByteReadChannel encode$default(Encoder encoder, ByteReadChannel byteReadChannel, kotlin.coroutines.d dVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
        }
        if ((i10 & 2) != 0) {
            dVar = EmptyCoroutineContext.f34779a;
        }
        return encoder.encode(byteReadChannel, dVar);
    }

    ByteReadChannel decode(ByteReadChannel source, kotlin.coroutines.d coroutineContext);

    ByteReadChannel encode(ByteReadChannel source, kotlin.coroutines.d coroutineContext);

    ByteWriteChannel encode(ByteWriteChannel source, kotlin.coroutines.d coroutineContext);

    static /* synthetic */ ByteWriteChannel encode$default(Encoder encoder, ByteWriteChannel byteWriteChannel, kotlin.coroutines.d dVar, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
        }
        if ((i10 & 2) != 0) {
            dVar = EmptyCoroutineContext.f34779a;
        }
        return encoder.encode(byteWriteChannel, dVar);
    }
}
