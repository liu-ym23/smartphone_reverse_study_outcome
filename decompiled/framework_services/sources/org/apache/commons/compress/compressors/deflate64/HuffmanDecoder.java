package org.apache.commons.compress.compressors.deflate64;

import com.android.internal.util.FrameworkStatsLog;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.apache.commons.compress.utils.BitInputStream;

/* JADX INFO: loaded from: classes3.dex */
class HuffmanDecoder implements Closeable {
    private static final int[] CODE_LENGTHS_ORDER = null;
    private static final int[] DISTANCE_TABLE = null;
    private static final int[] FIXED_DISTANCE = null;
    private static final int[] FIXED_LITERALS = null;
    private static final short[] RUN_LENGTH_TABLE = null;
    private boolean finalBlock;
    private final InputStream in;
    private final DecodingMemory memory;
    private BitInputStream reader;
    private DecoderState state;

    /* JADX INFO: renamed from: org.apache.commons.compress.compressors.deflate64.HuffmanDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class BinaryTreeNode {
        private final int bits;
        BinaryTreeNode leftNode;
        int literal;
        BinaryTreeNode rightNode;

        /* synthetic */ BinaryTreeNode(int x0, AnonymousClass1 x1) {
            this(x0);
        }

        private BinaryTreeNode(int bits) {
            this.literal = -1;
            this.bits = bits;
        }

        void leaf(int symbol) {
            this.literal = symbol;
            this.leftNode = null;
            this.rightNode = null;
        }

        BinaryTreeNode left() {
            if (this.leftNode != null) goto L8;
            if (this.literal != (-1)) goto L8;
            this.leftNode = new BinaryTreeNode(this.bits + 1);
        L8:
            return this.leftNode;
        }

        BinaryTreeNode right() {
            if (this.rightNode != null) goto L8;
            if (this.literal != (-1)) goto L8;
            this.rightNode = new BinaryTreeNode(this.bits + 1);
        L8:
            return this.rightNode;
        }
    }

    private static abstract class DecoderState {
        abstract int available() throws IOException;

        abstract boolean hasData();

        abstract int read(byte[] r1, int r2, int r3) throws IOException;

        abstract HuffmanState state();

        private DecoderState() {
        }

        /* synthetic */ DecoderState(AnonymousClass1 x0) {
            this();
        }
    }

    private static class DecodingMemory {
        private final int mask;
        private final byte[] memory;
        private int wHead;
        private boolean wrappedAround;

        /* synthetic */ DecodingMemory(AnonymousClass1 x0) {
            this();
        }

        private DecodingMemory() {
            this(16);
        }

        private DecodingMemory(int bits) {
            this.memory = new byte[1 << bits];
            this.mask = this.memory.length - 1;
        }

        byte add(byte b) {
            this.memory[this.wHead] = b;
            this.wHead = incCounter(this.wHead);
            return b;
        }

        void add(byte[] b, int off, int len) {
            int i = off;
        L4:
            if (i >= (off + len)) goto L7;
            add(b[i]);
            i = i + 1;
            goto L4
        }

        void recordToBuffer(int distance, int length, byte[] buff) {
            if (distance > this.memory.length) goto L17;
            int start = (this.wHead - distance) & this.mask;
            if (this.wrappedAround == false) goto L7;
        L11:
            int i = 0;
            int pos = start;
        L12:
            if (i >= length) goto L15;
            buff[i] = add(this.memory[pos]);
            i = i + 1;
            pos = incCounter(pos);
            goto L12
        L15:
            return;
        L7:
            if (start < this.wHead) goto L11;
            throw new IllegalStateException("Attempt to read beyond memory: dist=" + distance);
        L17:
            throw new IllegalStateException("Illegal distance parameter: " + distance);
        }

        private int incCounter(int counter) {
            int newCounter = (counter + 1) & this.mask;
            if (this.wrappedAround == true) goto L6;
            if (newCounter >= counter) goto L6;
            this.wrappedAround = true;
        L6:
            return newCounter;
        }
    }

    private class HuffmanCodes extends DecoderState {
        private final BinaryTreeNode distanceTree;
        private boolean endOfBlock;
        private final BinaryTreeNode lengthTree;
        private byte[] runBuffer;
        private int runBufferLength;
        private int runBufferPos;
        private final HuffmanState state;
        final /* synthetic */ HuffmanDecoder this$0;

        HuffmanCodes(HuffmanDecoder r2, HuffmanState state, int[] lengths, int[] distance) {
            this.this$0 = r2;
            super(null);
            this.endOfBlock = false;
            this.runBufferPos = 0;
            this.runBuffer = new byte[0];
            this.runBufferLength = 0;
            this.state = state;
            this.lengthTree = HuffmanDecoder.access$800(lengths);
            this.distanceTree = HuffmanDecoder.access$800(distance);
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        HuffmanState state() {
            if (this.endOfBlock == false) goto L6;
            return HuffmanState.INITIAL;
        L6:
            return this.state;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        int read(byte[] b, int off, int len) throws IOException {
            return decodeNext(b, off, len);
        }

        private int decodeNext(byte[] b, int off, int len) throws IOException {
            if (this.endOfBlock == false) goto L6;
            return -1;
        L6:
            int result = copyFromRunBuffer(b, off, len);
        L7:
            if (result >= len) goto L19;
            int symbol = HuffmanDecoder.access$900(HuffmanDecoder.access$400(this.this$0), this.lengthTree);
            if (symbol < 256) goto L10;
            if (symbol <= 256) goto L17;
            short r5 = HuffmanDecoder.access$1000()[symbol - 257];
            int runXtra = r5 & 31;
            int run = (int) (((long) (r5 >>> 5)) + HuffmanDecoder.access$500(this.this$0, runXtra));
            int distSym = HuffmanDecoder.access$900(HuffmanDecoder.access$400(this.this$0), this.distanceTree);
            int distMask = HuffmanDecoder.access$1100()[distSym];
            int dist = distMask >>> 4;
            int distXtra = distMask & 15;
            int dist2 = (int) (((long) dist) + HuffmanDecoder.access$500(this.this$0, distXtra));
            if (this.runBuffer.length >= run) goto L15;
            this.runBuffer = new byte[run];
        L15:
            this.runBufferLength = run;
            this.runBufferPos = 0;
            HuffmanDecoder.access$600(this.this$0).recordToBuffer(dist2, run, this.runBuffer);
            result = result + copyFromRunBuffer(b, off + result, len - result);
            goto L7
        L17:
            this.endOfBlock = true;
            return result;
        L10:
            b[off + result] = HuffmanDecoder.access$600(this.this$0).add((byte) symbol);
            result = result + 1;
            goto L7
        L19:
            return result;
        }

        private int copyFromRunBuffer(byte[] b, int off, int len) {
            int bytesInBuffer = this.runBufferLength - this.runBufferPos;
            if (bytesInBuffer <= 0) goto L6;
            int copiedBytes = Math.min(len, bytesInBuffer);
            System.arraycopy(this.runBuffer, this.runBufferPos, b, off, copiedBytes);
            this.runBufferPos += copiedBytes;
            return copiedBytes;
        L6:
            return 0;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        boolean hasData() {
            return !this.endOfBlock;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        int available() {
            return this.runBufferLength - this.runBufferPos;
        }
    }

    private class InitialState extends DecoderState {
        final /* synthetic */ HuffmanDecoder this$0;

        private InitialState(HuffmanDecoder r1) {
            this.this$0 = r1;
            super(null);
        }

        /* synthetic */ InitialState(HuffmanDecoder x0, AnonymousClass1 x1) {
            this(x0);
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        HuffmanState state() {
            return HuffmanState.INITIAL;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        int read(byte[] b, int off, int len) throws IOException {
            throw new IllegalStateException("Cannot read in this state");
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        boolean hasData() {
            return false;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        int available() {
            return 0;
        }
    }

    private class UncompressedState extends DecoderState {
        private final long blockLength;
        private long read;
        final /* synthetic */ HuffmanDecoder this$0;

        /* synthetic */ UncompressedState(HuffmanDecoder x0, long x1, AnonymousClass1 x2) {
            this(x0, x1);
        }

        private UncompressedState(HuffmanDecoder r1, long blockLength) {
            this.this$0 = r1;
            super(null);
            this.blockLength = blockLength;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        HuffmanState state() {
            if (this.read >= this.blockLength) goto L6;
            return HuffmanState.STORED;
        L6:
            return HuffmanState.INITIAL;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        int read(byte[] b, int off, int len) throws IOException {
            int max = (int) Math.min(this.blockLength - this.read, len);
            int readSoFar = 0;
        L3:
            if (readSoFar >= max) goto L13;
            if (HuffmanDecoder.access$400(this.this$0).bitsCached() <= 0) goto L7;
            byte next = (byte) HuffmanDecoder.access$500(this.this$0, 8);
            b[off + readSoFar] = HuffmanDecoder.access$600(this.this$0).add(next);
            int readNow = 1;
        L10:
            this.read += (long) readNow;
            readSoFar = readSoFar + readNow;
            goto L3
        L7:
            readNow = HuffmanDecoder.access$700(this.this$0).read(b, off + readSoFar, max - readSoFar);
            if (readNow == (-1)) goto L12;
            HuffmanDecoder.access$600(this.this$0).add(b, off + readSoFar, readNow);
            goto L10
        L12:
            throw new EOFException("Truncated Deflate64 Stream");
        L13:
            return max;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        boolean hasData() {
            if (this.read >= this.blockLength) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.apache.commons.compress.compressors.deflate64.HuffmanDecoder.DecoderState
        int available() throws IOException {
            return (int) Math.min(this.blockLength - this.read, HuffmanDecoder.access$400(this.this$0).bitsAvailable() / 8);
        }
    }

    static /* synthetic */ short[] access$1000() {
        return RUN_LENGTH_TABLE;
    }

    static /* synthetic */ int[] access$1100() {
        return DISTANCE_TABLE;
    }

    static /* synthetic */ BitInputStream access$400(HuffmanDecoder x0) {
        return x0.reader;
    }

    static /* synthetic */ long access$500(HuffmanDecoder x0, int x1) throws IOException {
        return x0.readBits(x1);
    }

    static /* synthetic */ DecodingMemory access$600(HuffmanDecoder x0) {
        return x0.memory;
    }

    static /* synthetic */ InputStream access$700(HuffmanDecoder x0) {
        return x0.in;
    }

    static /* synthetic */ BinaryTreeNode access$800(int[] x0) {
        return buildTree(x0);
    }

    static /* synthetic */ int access$900(BitInputStream x0, BinaryTreeNode x1) throws IOException {
        return nextSymbol(x0, x1);
    }

    static {
        RUN_LENGTH_TABLE = new short[]{96, 128, 160, 192, 224, 256, 288, 320, 353, 417, 481, 545, 610, 738, 866, 994, 1123, 1379, 1635, 1891, 2148, 2660, 3172, 3684, 4197, 5221, 6245, 7269, 112};
        DISTANCE_TABLE = new int[]{16, 32, 48, 64, 81, 113, 146, 210, 275, 403, 532, 788, 1045, 1557, 2070, 3094, 4119, 6167, 8216, 12312, 16409, 24601, 32794, 49178, 65563, 98331, 131100, 196636, 262173, 393245, 524318, 786462};
        CODE_LENGTHS_ORDER = new int[]{16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15};
        FIXED_LITERALS = new int[288];
        Arrays.fill(FIXED_LITERALS, 0, 144, 8);
        Arrays.fill(FIXED_LITERALS, 144, 256, 9);
        Arrays.fill(FIXED_LITERALS, 256, FrameworkStatsLog.TV_CAS_SESSION_OPEN_STATUS, 7);
        Arrays.fill(FIXED_LITERALS, FrameworkStatsLog.TV_CAS_SESSION_OPEN_STATUS, 288, 8);
        FIXED_DISTANCE = new int[32];
        Arrays.fill(FIXED_DISTANCE, 5);
    }

    HuffmanDecoder(InputStream in) {
        this.finalBlock = false;
        AnonymousClass1 r1 = null;
        this.memory = new DecodingMemory(r1);
        this.reader = new BitInputStream(in, ByteOrder.LITTLE_ENDIAN);
        this.in = in;
        this.state = new InitialState(this, r1);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.state = new InitialState(this, null);
        this.reader = null;
    }

    public int decode(byte[] b) throws IOException {
        return decode(b, 0, b.length);
    }

    public int decode(byte[] b, int off, int len) throws IOException {
    L3:
        if (this.finalBlock == false) goto L10;
        if (this.state.hasData() == true) goto L10;
        return -1;
    L10:
        if (this.state.state() != HuffmanState.INITIAL) goto L24;
        if (readBits(1) != 1) goto L14;
        boolean r1 = true;
    L15:
        this.finalBlock = r1;
        int mode = (int) readBits(2);
        switch(mode) {
            case 0: goto L21;
            case 1: goto L20;
            case 2: goto L19;
            default: goto L18;
        };
    L18:
        throw new IllegalStateException("Unsupported compression: " + mode);
    L20:
        this.state = new HuffmanCodes(this, HuffmanState.FIXED_CODES, FIXED_LITERALS, FIXED_DISTANCE);
        goto L3
    L21:
        switchToUncompressedState();
        goto L3
    L19:
        int[][] tables = readDynamicTables();
        this.state = new HuffmanCodes(this, HuffmanState.DYNAMIC_CODES, tables[0], tables[1]);
        goto L3
    L14:
        r1 = false;
        goto L15
    L24:
        return this.state.read(b, off, len);
    }

    long getBytesRead() {
        return this.reader.getBytesRead();
    }

    private void switchToUncompressedState() throws IOException {
        this.reader.alignWithByteBoundary();
        long bLen = readBits(16);
        long bNLen = readBits(16);
        if ((65535 & (bLen ^ 65535)) != bNLen) goto L7;
        this.state = new UncompressedState(this, bLen, null);
        return;
    L7:
        throw new IllegalStateException("Illegal LEN / NLEN values");
    }

    private int[][] readDynamicTables() throws IOException {
        int literals = (int) (readBits(5) + 257);
        int distances = (int) (readBits(5) + 1);
        int[][] result = {new int[literals], new int[distances]};
        populateDynamicTables(this.reader, result[0], result[1]);
        return result;
    }

    int available() throws IOException {
        return this.state.available();
    }

    private static int nextSymbol(BitInputStream reader, BinaryTreeNode tree) throws IOException {
        BinaryTreeNode node = tree;
    L4:
        if (node == null) goto L12;
        if (node.literal != (-1)) goto L12;
        long bit = readBits(reader, 1);
        if (bit != 0) goto L10;
        BinaryTreeNode r3 = node.leftNode;
    L11:
        node = r3;
        goto L4
    L10:
        r3 = node.rightNode;
    L12:
        if (node != null) goto L14;
        return -1;
    L14:
        return node.literal;
    }

    private static void populateDynamicTables(BitInputStream reader, int[] literals, int[] distances) throws IOException {
        int codeLengths = (int) (readBits(reader, 4) + 4);
        int[] codeLengthValues = new int[19];
        int cLen = 0;
    L4:
        if (cLen >= codeLengths) goto L6;
        codeLengthValues[CODE_LENGTHS_ORDER[cLen]] = (int) readBits(reader, 3);
        cLen = cLen + 1;
        goto L4
    L6:
        BinaryTreeNode codeLengthTree = buildTree(codeLengthValues);
        int[] auxBuffer = new int[literals.length + distances.length];
        int value = -1;
        int length = 0;
        int off = 0;
    L8:
        if (off >= auxBuffer.length) goto L24;
        if (length > 0) goto L10;
        int symbol = nextSymbol(reader, codeLengthTree);
        if (symbol < 16) goto L13;
        if (symbol == 16) goto L16;
        if (symbol == 17) goto L19;
        if (symbol != 18) goto L8;
        value = 0;
        length = (int) (readBits(reader, 7) + 11);
        goto L8
    L19:
        value = 0;
        length = (int) (readBits(reader, 3) + 3);
        goto L8
    L16:
        length = (int) (readBits(reader, 2) + 3);
        goto L8
    L13:
        value = symbol;
        auxBuffer[off] = value;
        off = off + 1;
        goto L8
    L10:
        auxBuffer[off] = value;
        length = length - 1;
        off = off + 1;
        goto L8
    L24:
        System.arraycopy(auxBuffer, 0, literals, 0, literals.length);
        System.arraycopy(auxBuffer, literals.length, distances, 0, distances.length);
    }

    private static BinaryTreeNode buildTree(int[] litTable) {
        int[] literalCodes = getCodes(litTable);
        BinaryTreeNode root = new BinaryTreeNode(0, null);
        int i = 0;
    L4:
        if (i >= litTable.length) goto L18;
        int len = litTable[i];
        if (len == 0) goto L16;
        BinaryTreeNode node = root;
        int lit = literalCodes[len - 1];
        int p = len - 1;
    L9:
        if (p < 0) goto L15;
        int bit = (1 << p) & lit;
        if (bit != 0) goto L13;
        BinaryTreeNode r8 = node.left();
    L14:
        node = r8;
        p = p - 1;
        goto L9
    L13:
        r8 = node.right();
        goto L14
    L15:
        node.leaf(i);
        int r6 = len - 1;
        literalCodes[r6] = literalCodes[r6] + 1;
    L16:
        i = i + 1;
        goto L4
    L18:
        return root;
    }

    private static int[] getCodes(int[] litTable) {
        int max = 0;
        int[] blCount = new int[65];
        int r2 = litTable.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        int aLitTable = litTable[r3];
        max = Math.max(max, aLitTable);
        blCount[aLitTable] = blCount[aLitTable] + 1;
        r3 = r3 + 1;
        goto L3
    L5:
        int[] blCount2 = Arrays.copyOf(blCount, max + 1);
        int code = 0;
        int[] nextCode = new int[max + 1];
        int i = 0;
    L6:
        if (i > max) goto L9;
        code = (blCount2[i] + code) << 1;
        nextCode[i] = code;
        i = i + 1;
        goto L6
    L9:
        return nextCode;
    }

    private long readBits(int numBits) throws IOException {
        return readBits(this.reader, numBits);
    }

    private static long readBits(BitInputStream reader, int numBits) throws IOException {
        long r = reader.readBits(numBits);
        if (r == (-1)) goto L6;
        return r;
    L6:
        throw new EOFException("Truncated Deflate64 Stream");
    }
}
