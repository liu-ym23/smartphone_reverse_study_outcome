package io.modelcontextprotocol.kotlin.sdk.shared;

import fb.C4074a;
import fb.C4076c;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.modelcontextprotocol.kotlin.sdk.JSONRPCMessage;
import java.io.EOFException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u0003R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/shared/ReadBuffer;", "", "<init>", "()V", "", "chunk", "LY8/t;", "append", "([B)V", "Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;", "readMessage", "()Lio/modelcontextprotocol/kotlin/sdk/JSONRPCMessage;", "clear", "Lfb/a;", "buffer", "Lfb/a;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ReadBuffer {
    private final C4074a buffer = new C4074a();

    public final void append(byte[] chunk) {
        kotlin.jvm.internal.p.i(chunk, "chunk");
        BytePacketBuilderKt.writeFully$default(this.buffer, chunk, 0, 0, 6, null);
    }

    public final void clear() throws EOFException {
        this.buffer.b();
    }

    public final JSONRPCMessage readMessage() throws EOFException {
        int i10;
        if (this.buffer.k()) {
            return null;
        }
        long jB = C4076c.b(this.buffer, (byte) 10, 0L, 0L, 6, null);
        if (jB == -1) {
            return null;
        }
        if (jB == 0) {
            this.buffer.skip(1L);
            return null;
        }
        long j10 = jB - 1;
        if (this.buffer.l(j10) == 13) {
            i10 = 2;
            jB = j10;
        } else {
            i10 = 1;
        }
        String strD = fb.y.d(this.buffer, jB);
        this.buffer.skip(i10);
        return ReadBufferKt.deserializeMessage(strD);
    }
}
