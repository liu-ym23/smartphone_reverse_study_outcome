package okhttp3.internal.http2;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
class Huffman {
    private static final int[] CODES = null;
    private static final byte[] CODE_LENGTHS = null;
    private static final Huffman INSTANCE = null;
    private final Node root;

    public static final class Node {
        final Node[] children;
        final int symbol;
        final int terminalBits;

        public Node() {
            this.children = new Node[256];
            this.symbol = 0;
            this.terminalBits = 0;
        }

        public Node(int r10, int r11) {
            this.children = null;
            this.symbol = r10;
            int r12 = r11 & 7;
            if (r12 != 0) goto L5;
            r12 = 8;
        L5:
            this.terminalBits = r12;
        }
    }

    static {
        CODES = new int[]{8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
        CODE_LENGTHS = new byte[]{Ascii.CR, Ascii.ETB, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.CAN, Ascii.RS, Ascii.FS, Ascii.FS, Ascii.RS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.RS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, Ascii.FS, 6, 10, 10, Ascii.FF, Ascii.CR, 6, 8, Ascii.VT, 10, 10, 8, Ascii.VT, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, Ascii.SI, 6, Ascii.FF, 10, Ascii.CR, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, Ascii.CR, 19, Ascii.CR, Ascii.SO, 6, Ascii.SI, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, Ascii.SI, Ascii.VT, Ascii.SO, Ascii.CR, Ascii.FS, Ascii.DC4, Ascii.SYN, Ascii.DC4, Ascii.DC4, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.CAN, Ascii.ETB, Ascii.CAN, Ascii.CAN, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.ETB, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.CAN, Ascii.SYN, Ascii.NAK, Ascii.DC4, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.NAK, Ascii.ETB, Ascii.SYN, Ascii.SYN, Ascii.CAN, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.NAK, Ascii.NAK, Ascii.SYN, Ascii.NAK, Ascii.ETB, Ascii.SYN, Ascii.ETB, Ascii.ETB, Ascii.DC4, Ascii.SYN, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.SYN, Ascii.ETB, Ascii.SUB, Ascii.SUB, Ascii.DC4, 19, Ascii.SYN, Ascii.ETB, Ascii.SYN, Ascii.EM, Ascii.SUB, Ascii.SUB, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.SUB, Ascii.CAN, Ascii.EM, 19, Ascii.NAK, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.SUB, Ascii.ESC, Ascii.CAN, Ascii.NAK, Ascii.NAK, Ascii.SUB, Ascii.SUB, Ascii.FS, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.DC4, Ascii.CAN, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.NAK, Ascii.NAK, Ascii.ETB, Ascii.SYN, Ascii.SYN, Ascii.EM, Ascii.EM, Ascii.CAN, Ascii.CAN, Ascii.SUB, Ascii.ETB, Ascii.SUB, Ascii.ESC, Ascii.SUB, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.FS, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.SUB};
        INSTANCE = new Huffman();
    }

    private Huffman() {
        this.root = new Node();
        buildTree();
    }

    private void addCode(int r10, int r11, byte r12) {
        Node r13 = new Node(r10, r12);
        Node r14 = this.root;
    L4:
        if (r12 <= 8) goto L13;
        r12 = (byte) (r12 - 8);
        int r15 = (r11 >>> r12) & PrivateKeyType.INVALID;
        Node[] r16 = r14.children;
        if (r16 == null) goto L12;
        if (r16[r15] != null) goto L10;
        r16[r15] = new Node();
    L10:
        r14 = r14.children[r15];
        goto L4
    L12:
        throw new IllegalStateException("invalid dictionary: prefix not unique");
    L13:
        int r17 = 8 - r12;
        int r18 = (r11 << r17) & PrivateKeyType.INVALID;
        int r19 = 1 << r17;
        int r20 = r18;
    L15:
        if (r20 >= (r18 + r19)) goto L17;
        r14.children[r20] = r13;
        r20 = r20 + 1;
        goto L15
    }

    private void buildTree() {
        int r10 = 0;
    L3:
        byte[] r11 = CODE_LENGTHS;
        if (r10 >= r11.length) goto L6;
        addCode(r10, CODES[r10], r11[r10]);
        r10 = r10 + 1;
        goto L3
    }

    public static Huffman get() {
        return INSTANCE;
    }

    public byte[] decode(byte[] r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        Node r12 = this.root;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r13 >= r10.length) goto L13;
        r14 = (r14 << 8) | (r10[r13] & UnsignedBytes.MAX_VALUE);
        r15 = r15 + 8;
    L7:
        if (r15 < 8) goto L12;
        r12 = r12.children[(r14 >>> (r15 - 8)) & PrivateKeyType.INVALID];
        if (r12.children == null) goto L10;
        r15 = r15 - 8;
        goto L7
    L10:
        r11.write(r12.symbol);
        r15 = r15 - r12.terminalBits;
        r12 = this.root;
        goto L7
    L12:
        r13 = r13 + 1;
    L13:
        if (r15 <= 0) goto L21;
        Node r16 = r12.children[(r14 << (8 - r15)) & PrivateKeyType.INVALID];
        if (r16.children != null) goto L21;
        if (r16.terminalBits > r15) goto L21;
        r11.write(r16.symbol);
        r15 = r15 - r16.terminalBits;
        r12 = this.root;
    L21:
        return r11.toByteArray();
    }

    public void encode(ByteString r10, BufferedSink r11) throws IOException {
        int r12 = 0;
        long r13 = 0;
        int r14 = 0;
    L4:
        if (r12 >= r10.size()) goto L10;
        int r15 = r10.getByte(r12) & UnsignedBytes.MAX_VALUE;
        int r16 = CODES[r15];
        byte r17 = CODE_LENGTHS[r15];
        r13 = (r13 << r17) | ((long) r16);
        r14 = r14 + r17;
    L7:
        if (r14 < 8) goto L9;
        r14 = r14 - 8;
        r11.writeByte((int) (r13 >> r14));
        goto L7
    L9:
        r12 = r12 + 1;
        goto L4
    L10:
        if (r14 <= 0) goto L15;
        r11.writeByte((int) ((r13 << (8 - r14)) | ((long) (PrivateKeyType.INVALID >>> r14))));
        return;
    }

    public int encodedLength(ByteString r10) {
        long r11 = 0;
        int r12 = 0;
    L4:
        if (r12 >= r10.size()) goto L7;
        int r13 = r10.getByte(r12) & UnsignedBytes.MAX_VALUE;
        r11 = r11 + ((long) CODE_LENGTHS[r13]);
        r12 = r12 + 1;
        goto L4
    L7:
        return (int) ((r11 + 7) >> 3);
    }
}
