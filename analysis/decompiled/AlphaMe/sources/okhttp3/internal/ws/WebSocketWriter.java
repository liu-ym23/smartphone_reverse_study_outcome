package okhttp3.internal.ws;

import com.alibaba.fastjson.asm.Opcodes;
import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import k3.C0692g;
import k3.C0694i;
import k3.InterfaceC0695j;
import k3.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010!\u001a\u00020\u0014\u0012\u0006\u0010\"\u001a\u00020\u0014\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b4\u00105J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000e\u0010\bJ\u001d\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0016R\u0014\u0010\"\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0016R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010(R\u0016\u0010*\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010\u0016R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u0004\u0018\u00010.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0004\u0018\u0001018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00066"}, d2 = {"Lokhttp3/internal/ws/WebSocketWriter;", "Ljava/io/Closeable;", "", "opcode", "Lk3/l;", "payload", "", "writeControlFrame", "(ILk3/l;)V", "writePing", "(Lk3/l;)V", "writePong", "code", "reason", "writeClose", "formatOpcode", "data", "writeMessageFrame", "close", "()V", "", "isClient", "Z", "Lk3/j;", "sink", "Lk3/j;", "getSink", "()Lk3/j;", "Ljava/util/Random;", "random", "Ljava/util/Random;", "getRandom", "()Ljava/util/Random;", "perMessageDeflate", "noContextTakeover", "", "minimumDeflateSize", "J", "Lk3/i;", "messageBuffer", "Lk3/i;", "sinkBuffer", "writerClosed", "Lokhttp3/internal/ws/MessageDeflater;", "messageDeflater", "Lokhttp3/internal/ws/MessageDeflater;", "", "maskKey", "[B", "Lk3/g;", "maskCursor", "Lk3/g;", "<init>", "(ZLk3/j;Ljava/util/Random;ZZJ)V", "okhttp"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class WebSocketWriter implements Closeable {
    private final boolean isClient;

    @Nullable
    private final C0692g maskCursor;

    @Nullable
    private final byte[] maskKey;

    @NotNull
    private final C0694i messageBuffer;

    @Nullable
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;

    @NotNull
    private final Random random;

    @NotNull
    private final InterfaceC0695j sink;

    @NotNull
    private final C0694i sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean z4, @NotNull InterfaceC0695j sink, @NotNull Random random, boolean z5, boolean z6, long j4) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(random, "random");
        this.isClient = z4;
        this.sink = sink;
        this.random = random;
        this.perMessageDeflate = z5;
        this.noContextTakeover = z6;
        this.minimumDeflateSize = j4;
        this.messageBuffer = new C0694i();
        this.sinkBuffer = sink.f();
        this.maskKey = z4 ? new byte[4] : null;
        this.maskCursor = z4 ? new C0692g() : null;
    }

    private final void writeControlFrame(int opcode, l payload) throws IOException {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int iC = payload.c();
        if (iC > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125".toString());
        }
        this.sinkBuffer.V(opcode | 128);
        if (this.isClient) {
            this.sinkBuffer.V(iC | 128);
            Random random = this.random;
            byte[] bArr = this.maskKey;
            Intrinsics.checkNotNull(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.U(this.maskKey);
            if (iC > 0) {
                C0694i c0694i = this.sinkBuffer;
                long j4 = c0694i.f13357b;
                c0694i.T(payload);
                C0694i c0694i2 = this.sinkBuffer;
                C0692g c0692g = this.maskCursor;
                Intrinsics.checkNotNull(c0692g);
                c0694i2.C(c0692g);
                this.maskCursor.b(j4);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.V(iC);
            this.sinkBuffer.T(payload);
        }
        this.sink.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        MessageDeflater messageDeflater = this.messageDeflater;
        if (messageDeflater == null) {
            return;
        }
        messageDeflater.close();
    }

    @NotNull
    public final Random getRandom() {
        return this.random;
    }

    @NotNull
    public final InterfaceC0695j getSink() {
        return this.sink;
    }

    public final void writeClose(int code, @Nullable l reason) throws IOException {
        l lVarI = l.f13358d;
        if (code != 0 || reason != null) {
            if (code != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(code);
            }
            C0694i c0694i = new C0694i();
            c0694i.a0(code);
            if (reason != null) {
                c0694i.T(reason);
            }
            lVarI = c0694i.i(c0694i.f13357b);
        }
        try {
            writeControlFrame(8, lVarI);
        } finally {
            this.writerClosed = true;
        }
    }

    public final void writeMessageFrame(int formatOpcode, @NotNull l data) throws IOException {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        this.messageBuffer.T(data);
        int i4 = formatOpcode | 128;
        if (this.perMessageDeflate && data.c() >= this.minimumDeflateSize) {
            MessageDeflater messageDeflater = this.messageDeflater;
            if (messageDeflater == null) {
                messageDeflater = new MessageDeflater(this.noContextTakeover);
                this.messageDeflater = messageDeflater;
            }
            messageDeflater.deflate(this.messageBuffer);
            i4 = formatOpcode | Opcodes.CHECKCAST;
        }
        long j4 = this.messageBuffer.f13357b;
        this.sinkBuffer.V(i4);
        int i5 = this.isClient ? 128 : 0;
        if (j4 <= 125) {
            this.sinkBuffer.V(i5 | ((int) j4));
        } else if (j4 <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            this.sinkBuffer.V(i5 | 126);
            this.sinkBuffer.a0((int) j4);
        } else {
            this.sinkBuffer.V(i5 | 127);
            this.sinkBuffer.Z(j4);
        }
        if (this.isClient) {
            Random random = this.random;
            byte[] bArr = this.maskKey;
            Intrinsics.checkNotNull(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.U(this.maskKey);
            if (j4 > 0) {
                C0694i c0694i = this.messageBuffer;
                C0692g c0692g = this.maskCursor;
                Intrinsics.checkNotNull(c0692g);
                c0694i.C(c0692g);
                this.maskCursor.b(0L);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        this.sinkBuffer.write(this.messageBuffer, j4);
        this.sink.k();
    }

    public final void writePing(@NotNull l payload) throws IOException {
        Intrinsics.checkNotNullParameter(payload, "payload");
        writeControlFrame(9, payload);
    }

    public final void writePong(@NotNull l payload) throws IOException {
        Intrinsics.checkNotNullParameter(payload, "payload");
        writeControlFrame(10, payload);
    }
}
