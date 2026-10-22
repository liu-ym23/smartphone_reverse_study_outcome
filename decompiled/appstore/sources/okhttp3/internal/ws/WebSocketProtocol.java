package okhttp3.internal.ws;

import okio.Buffer;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class WebSocketProtocol {
    static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    static final int B0_FLAG_FIN = 128;
    static final int B0_FLAG_RSV1 = 64;
    static final int B0_FLAG_RSV2 = 32;
    static final int B0_FLAG_RSV3 = 16;
    static final int B0_MASK_OPCODE = 15;
    static final int B1_FLAG_MASK = 128;
    static final int B1_MASK_LENGTH = 127;
    static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    static final long CLOSE_MESSAGE_MAX = 123;
    static final int CLOSE_NO_STATUS_CODE = 1005;
    static final int OPCODE_BINARY = 2;
    static final int OPCODE_CONTINUATION = 0;
    static final int OPCODE_CONTROL_CLOSE = 8;
    static final int OPCODE_CONTROL_PING = 9;
    static final int OPCODE_CONTROL_PONG = 10;
    static final int OPCODE_FLAG_CONTROL = 8;
    static final int OPCODE_TEXT = 1;
    static final long PAYLOAD_BYTE_MAX = 125;
    static final int PAYLOAD_LONG = 127;
    static final int PAYLOAD_SHORT = 126;
    static final long PAYLOAD_SHORT_MAX = 65535;

    private WebSocketProtocol() {
        throw new AssertionError("No instances.");
    }

    public static String acceptHeader(String r10) {
        return ByteString.encodeUtf8(r10 + ACCEPT_MAGIC).sha1().base64();
    }

    public static String closeCodeExceptionMessage(int r10) {
        if (r10 < 1000) goto L20;
        if (r10 >= 5000) goto L20;
        if (r10 < 1004) goto L12;
        if (r10 > 1006) goto L12;
    L16:
        return "Code " + r10 + " is reserved and may not be used.";
    L12:
        if (r10 >= 1012) goto L14;
        return null;
    L14:
        if (r10 <= 2999) goto L16;
        return null;
    L20:
        return "Code must be in range [1000,5000): " + r10;
    }

    public static void toggleMask(Buffer.UnsafeCursor r10, byte[] r11) {
        int r12 = r11.length;
        int r13 = 0;
    L3:
        byte[] r14 = r10.f23026e;
        int r15 = r10.f23027f;
        int r16 = r10.f23028g;
    L4:
        if (r15 >= r16) goto L7;
        int r17 = r13 % r12;
        r14[r15] = (byte) (r14[r15] ^ r11[r17]);
        r15 = r15 + 1;
        r13 = r17 + 1;
        goto L4
    L7:
        if (r10.a() != (-1)) goto L3;
    }

    public static void validateCloseCode(int r10) {
        String r11 = closeCodeExceptionMessage(r10);
        if (r11 != null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(r11);
    }
}
