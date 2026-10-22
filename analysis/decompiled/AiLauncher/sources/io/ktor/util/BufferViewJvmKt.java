package io.ktor.util;

import Y8.t;
import fb.C4074a;
import io.ktor.utils.io.InternalAPI;
import io.ktor.utils.io.core.internal.ChunkBufferJvmKt;
import io.ktor.utils.io.core.internal.ChunkBufferKt;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ljava/nio/channels/ReadableByteChannel;", "Lfb/a;", "buffer", "", "read", "(Ljava/nio/channels/ReadableByteChannel;Lfb/a;)I", "Ljava/nio/channels/WritableByteChannel;", "write", "(Ljava/nio/channels/WritableByteChannel;Lfb/a;)I", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BufferViewJvmKt {
    public static final int read(final ReadableByteChannel readableByteChannel, C4074a buffer) {
        kotlin.jvm.internal.p.i(readableByteChannel, "<this>");
        kotlin.jvm.internal.p.i(buffer, "buffer");
        if (ChunkBufferKt.getWriteRemaining(buffer) == 0) {
            return 0;
        }
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ChunkBufferJvmKt.writeDirect(buffer, 1, new InterfaceC5074l() { // from class: io.ktor.util.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BufferViewJvmKt.read$lambda$0(ref$IntRef, readableByteChannel, (ByteBuffer) obj);
            }
        });
        return ref$IntRef.f34818a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t read$lambda$0(Ref$IntRef ref$IntRef, ReadableByteChannel readableByteChannel, ByteBuffer bb2) {
        kotlin.jvm.internal.p.i(bb2, "bb");
        ref$IntRef.f34818a = readableByteChannel.read(bb2);
        return t.f7040a;
    }

    @InternalAPI
    public static final int write(final WritableByteChannel writableByteChannel, C4074a buffer) throws EOFException {
        kotlin.jvm.internal.p.i(writableByteChannel, "<this>");
        kotlin.jvm.internal.p.i(buffer, "buffer");
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ChunkBufferJvmKt.readDirect(buffer, new InterfaceC5074l() { // from class: io.ktor.util.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return BufferViewJvmKt.write$lambda$1(ref$IntRef, writableByteChannel, (ByteBuffer) obj);
            }
        });
        return ref$IntRef.f34818a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t write$lambda$1(Ref$IntRef ref$IntRef, WritableByteChannel writableByteChannel, ByteBuffer bb2) {
        kotlin.jvm.internal.p.i(bb2, "bb");
        ref$IntRef.f34818a = writableByteChannel.write(bb2);
        return t.f7040a;
    }
}
