package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.Util;
import okio.ByteString;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes4.dex */
public final class Http2 {
    static final String[] BINARY = null;
    static final ByteString CONNECTION_PREFACE = null;
    static final String[] FLAGS = null;
    static final byte FLAG_ACK = 1;
    static final byte FLAG_COMPRESSED = 32;
    static final byte FLAG_END_HEADERS = 4;
    static final byte FLAG_END_PUSH_PROMISE = 4;
    static final byte FLAG_END_STREAM = 1;
    static final byte FLAG_NONE = 0;
    static final byte FLAG_PADDED = 8;
    static final byte FLAG_PRIORITY = 32;
    private static final String[] FRAME_NAMES = null;
    static final int INITIAL_MAX_FRAME_SIZE = 16384;
    static final byte TYPE_CONTINUATION = 9;
    static final byte TYPE_DATA = 0;
    static final byte TYPE_GOAWAY = 7;
    static final byte TYPE_HEADERS = 1;
    static final byte TYPE_PING = 6;
    static final byte TYPE_PRIORITY = 2;
    static final byte TYPE_PUSH_PROMISE = 5;
    static final byte TYPE_RST_STREAM = 3;
    static final byte TYPE_SETTINGS = 4;
    static final byte TYPE_WINDOW_UPDATE = 8;

    static {
        CONNECTION_PREFACE = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        FRAME_NAMES = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        FLAGS = new String[64];
        BINARY = new String[256];
        int r10 = 0;
        int r11 = 0;
    L3:
        String[] r12 = BINARY;
        if (r11 >= r12.length) goto L6;
        r12[r11] = Util.format("%8s", new Object[]{Integer.toBinaryString(r11)}).replace(TokenParser.SP, '0');
        r11 = r11 + 1;
        goto L3
    L6:
        String[] r13 = FLAGS;
        r13[0] = "";
        r13[1] = "END_STREAM";
        int[] r14 = {1};
        r13[8] = "PADDED";
        int r15 = r14[0];
        r13[r15 | 8] = r13[r15] + "|PADDED";
        r13[4] = "END_HEADERS";
        r13[32] = "PRIORITY";
        r13[36] = "END_HEADERS|PRIORITY";
        int[] r16 = {4, 32, 36};
        int r17 = 0;
    L8:
        if (r17 >= 3) goto L10;
        int r18 = r16[r17];
        int r19 = r14[0];
        String[] r20 = FLAGS;
        int r21 = r19 | r18;
        r20[r21] = r20[r19] + '|' + r20[r18];
        r20[r21 | 8] = r20[r19] + '|' + r20[r18] + "|PADDED";
        r17 = r17 + 1;
    L10:
        String[] r22 = FLAGS;
        if (r10 >= r22.length) goto L16;
        if (r22[r10] != null) goto L15;
        r22[r10] = BINARY[r10];
    L15:
        r10 = r10 + 1;
        goto L10
    }

    private Http2() {
    }

    public static String formatFlags(byte r10, byte r11) {
        if (r11 != 0) goto L6;
        return "";
    L6:
        if (r10 == 2) goto L39;
        if (r10 == 3) goto L39;
        if (r10 == 4) goto L34;
        if (r10 == 6) goto L34;
        if (r10 == 7) goto L39;
        if (r10 == 8) goto L39;
        String[] r12 = FLAGS;
        if (r11 >= r12.length) goto L20;
        String r13 = r12[r11];
    L22:
        if (r10 == 5) goto L24;
    L27:
        if (r10 == 0) goto L29;
    L32:
        return r13;
    L29:
        if ((r11 & 32) == 0) goto L32;
        return r13.replace("PRIORITY", "COMPRESSED");
    L24:
        if ((r11 & 4) == 0) goto L27;
        return r13.replace("HEADERS", "PUSH_PROMISE");
    L20:
        r13 = BINARY[r11];
    L34:
        if (r11 != 1) goto L37;
        return "ACK";
    L37:
        return BINARY[r11];
    L39:
        return BINARY[r11];
    }

    public static String frameLog(boolean r10, int r11, int r12, byte r13, byte r14) {
        String[] r15 = FRAME_NAMES;
        if (r13 >= r15.length) goto L5;
        String r16 = r15[r13];
    L6:
        String r17 = formatFlags(r13, r14);
        if (r10 == false) goto L9;
        String r18 = "<<";
    L11:
        return Util.format("%s 0x%08x %5d %-13s %s", new Object[]{r18, Integer.valueOf(r11), Integer.valueOf(r12), r16, r17});
    L9:
        r18 = ">>";
        goto L11
    L5:
        r16 = Util.format("0x%02x", new Object[]{Byte.valueOf(r13)});
        goto L6
    }

    public static IllegalArgumentException illegalArgument(String r10, Object... r11) {
        throw new IllegalArgumentException(Util.format(r10, r11));
    }

    public static IOException ioException(String r10, Object... r11) throws IOException {
        throw new IOException(Util.format(r10, r11));
    }
}
