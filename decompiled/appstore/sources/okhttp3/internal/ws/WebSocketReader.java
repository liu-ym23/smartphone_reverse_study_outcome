package okhttp3.internal.ws;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
final class WebSocketReader {
    boolean closed;
    private final Buffer controlFrameBuffer;
    final FrameCallback frameCallback;
    long frameLength;
    final boolean isClient;
    boolean isControlFrame;
    boolean isFinalFrame;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Buffer messageFrameBuffer;
    int opcode;
    final BufferedSource source;

    public interface FrameCallback {
        void onReadClose(int r10, String r11);

        void onReadMessage(String r10) throws IOException;

        void onReadMessage(ByteString r10) throws IOException;

        void onReadPing(ByteString r10);

        void onReadPong(ByteString r10);
    }

    public WebSocketReader(boolean r10, BufferedSource r11, FrameCallback r12) {
        this.controlFrameBuffer = new Buffer();
        this.messageFrameBuffer = new Buffer();
        if (r11 == null) goto L18;
        if (r12 == null) goto L16;
        this.isClient = r10;
        this.source = r11;
        this.frameCallback = r12;
        Buffer.UnsafeCursor r13 = null;
        if (r10 == false) goto L8;
        byte[] r14 = null;
    L9:
        this.maskKey = r14;
        if (r10 == true) goto L13;
        r13 = new Buffer.UnsafeCursor();
    L13:
        this.maskCursor = r13;
        return;
    L8:
        r14 = new byte[4];
        goto L9
    L16:
        throw new NullPointerException("frameCallback == null");
    L18:
        throw new NullPointerException("source == null");
    }

    private void readControlFrame() throws IOException {
        long r10 = this.frameLength;
        if (r10 <= 0) goto L8;
        this.source.readFully(this.controlFrameBuffer, r10);
        if (this.isClient == true) goto L8;
        this.controlFrameBuffer.i(this.maskCursor);
        this.maskCursor.b(0);
        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
    L8:
        switch(this.opcode) {
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            default: goto L10;
        };
    L11:
        this.frameCallback.onReadPong(this.controlFrameBuffer.readByteString());
        return;
    L12:
        this.frameCallback.onReadPing(this.controlFrameBuffer.readByteString());
        return;
    L13:
        long r11 = this.controlFrameBuffer.size();
        if (r11 == 1) goto L26;
        if (r11 == 0) goto L22;
        short r12 = this.controlFrameBuffer.readShort();
        String r13 = this.controlFrameBuffer.readUtf8();
        String r14 = WebSocketProtocol.closeCodeExceptionMessage(r12);
        if (r14 != null) goto L21;
    L23:
        this.frameCallback.onReadClose(r12, r13);
        this.closed = true;
        return;
    L21:
        throw new ProtocolException(r14);
    L22:
        r12 = 1005;
        r13 = "";
        goto L23
    L26:
        throw new ProtocolException("Malformed close payload length of 1.");
    L10:
        throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.opcode));
    }

    private void readHeader() throws IOException {
        if (this.closed == true) goto L72;
        long r10 = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        byte r11 = this.source.readByte();     // Catch: Throwable -> L68
        this.source.timeout().timeout(r10, TimeUnit.NANOSECONDS);
        this.opcode = r11 & Ascii.SI;
        boolean r12 = false;
        if ((r11 & UnsignedBytes.MAX_POWER_OF_TWO) == 0) goto L9;
        boolean r13 = true;
    L10:
        this.isFinalFrame = r13;
        if ((r11 & 8) == 0) goto L13;
        boolean r14 = true;
    L14:
        this.isControlFrame = r14;
        if (r14 == false) goto L21;
        if (r13 == true) goto L21;
        throw new ProtocolException("Control frames must be final.");
    L21:
        if ((r11 & SignedBytes.MAX_POWER_OF_TWO) == 0) goto L23;
        boolean r15 = true;
    L25:
        if ((r11 & 32) == 0) goto L27;
        boolean r16 = true;
    L29:
        if ((r11 & Ascii.DLE) == 0) goto L31;
        boolean r17 = true;
    L32:
        if (r15 == true) goto L67;
        if (r16 == true) goto L67;
        if (r17 == true) goto L67;
        byte r18 = this.source.readByte();
        if ((r18 & UnsignedBytes.MAX_POWER_OF_TWO) == 0) goto L39;
        r12 = true;
    L39:
        if (r12 == this.isClient) goto L41;
        long r19 = r18 & Ascii.DEL;
        this.frameLength = r19;
        if (r19 != 126) goto L50;
        this.frameLength = ((long) this.source.readShort()) & 65535;
    L57:
        if (this.isControlFrame == true) goto L59;
    L63:
        if (r12 == false) goto L75;
        this.source.readFully(this.maskKey);
        return;
    L75:
        return;
    L59:
        if (this.frameLength <= 125) goto L63;
        throw new ProtocolException("Control frame must be less than 125B.");
    L50:
        if (r19 != 127) goto L57;
        long r20 = this.source.readLong();
        this.frameLength = r20;
        if (r20 >= 0) goto L57;
        throw new ProtocolException("Frame length 0x" + Long.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
    L41:
        if (this.isClient == false) goto L43;
        String r21 = "Server-sent frames must not be masked.";
    L45:
        throw new ProtocolException(r21);
    L43:
        r21 = "Client-sent frames must be masked.";
    L67:
        throw new ProtocolException("Reserved flags are unsupported.");
    L31:
        r17 = false;
        goto L32
    L27:
        r16 = false;
        goto L29
    L23:
        r15 = false;
        goto L25
    L13:
        r14 = false;
        goto L14
    L9:
        r13 = false;
    L68:
        th = move-exception;
        this.source.timeout().timeout(r10, TimeUnit.NANOSECONDS);
        throw th;
    L72:
        throw new IOException("closed");
    }

    private void readMessage() throws IOException {
    L3:
        if (this.closed == true) goto L18;
        long r10 = this.frameLength;
        if (r10 <= 0) goto L10;
        this.source.readFully(this.messageFrameBuffer, r10);
        if (this.isClient == true) goto L10;
        this.messageFrameBuffer.i(this.maskCursor);
        this.maskCursor.b(this.messageFrameBuffer.size() - this.frameLength);
        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
        this.maskCursor.close();
    L10:
        if (this.isFinalFrame == true) goto L11;
        readUntilNonControlFrame();
        if (this.opcode == 0) goto L3;
        throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.opcode));
    L11:
        return;
    L18:
        throw new IOException("closed");
    }

    private void readMessageFrame() throws IOException {
        int r10 = this.opcode;
        if (r10 != 1) goto L5;
    L9:
        readMessage();
        if (r10 != 1) goto L12;
        this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
        return;
    L12:
        this.frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
        return;
    L5:
        if (r10 == 2) goto L9;
        throw new ProtocolException("Unknown opcode: " + Integer.toHexString(r10));
    }

    private void readUntilNonControlFrame() throws IOException {
    L3:
        if (this.closed == true) goto L8;
        readHeader();
        if (this.isControlFrame == false) goto L11;
        readControlFrame();
        goto L3
    L11:
        return;
    }

    public void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame == false) goto L5;
        readControlFrame();
        return;
    L5:
        readMessageFrame();
    }
}
