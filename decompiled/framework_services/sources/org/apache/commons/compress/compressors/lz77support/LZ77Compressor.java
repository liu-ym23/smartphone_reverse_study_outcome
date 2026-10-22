package org.apache.commons.compress.compressors.lz77support;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class LZ77Compressor {
    private static final int HASH_MASK = 32767;
    private static final int HASH_SIZE = 32768;
    private static final int H_SHIFT = 5;
    private static final int NO_MATCH = -1;
    static final int NUMBER_OF_BYTES_IN_HASH = 3;
    private static final Block THE_EOD = null;
    private int blockStart;
    private final Callback callback;
    private int currentPosition;
    private final int[] head;
    private boolean initialized;
    private int insertHash;
    private int lookahead;
    private int matchStart;
    private int missedInserts;
    private final Parameters params;
    private final int[] prev;
    private final int wMask;
    private final byte[] window;

    public static final class BackReference extends Block {
        private final int length;
        private final int offset;

        public BackReference(int offset, int length) {
            this.offset = offset;
            this.length = length;
        }

        public int getOffset() {
            return this.offset;
        }

        public int getLength() {
            return this.length;
        }

        @Override // org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block
        public Block.BlockType getType() {
            return Block.BlockType.BACK_REFERENCE;
        }

        public String toString() {
            return "BackReference with offset " + this.offset + " and length " + this.length;
        }
    }

    public static abstract class Block {

        public static final enum BlockType extends Enum<BlockType> {
            private static final /* synthetic */ BlockType[] $VALUES = null;
            public static final BlockType BACK_REFERENCE = null;
            public static final BlockType EOD = null;
            public static final BlockType LITERAL = null;

            private static /* synthetic */ BlockType[] $values() {
                return new BlockType[]{LITERAL, BACK_REFERENCE, EOD};
            }

            private BlockType(String r1, int r2) {
                super(r1, r2);
            }

            public static BlockType valueOf(String name) {
                return (BlockType) Enum.valueOf(BlockType.class, name);
            }

            public static BlockType[] values() {
                return (BlockType[]) $VALUES.clone();
            }

            static {
                LITERAL = new BlockType("LITERAL", 0);
                BACK_REFERENCE = new BlockType("BACK_REFERENCE", 1);
                EOD = new BlockType("EOD", 2);
                $VALUES = $values();
            }
        }

        public abstract BlockType getType();

        public Block() {
        }
    }

    public interface Callback {
        void accept(Block r1) throws IOException;
    }

    public static final class EOD extends Block {
        public EOD() {
        }

        @Override // org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block
        public Block.BlockType getType() {
            return Block.BlockType.EOD;
        }
    }

    public static final class LiteralBlock extends Block {
        private final byte[] data;
        private final int length;
        private final int offset;

        public LiteralBlock(byte[] data, int offset, int length) {
            this.data = data;
            this.offset = offset;
            this.length = length;
        }

        public byte[] getData() {
            return this.data;
        }

        public int getOffset() {
            return this.offset;
        }

        public int getLength() {
            return this.length;
        }

        @Override // org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block
        public Block.BlockType getType() {
            return Block.BlockType.LITERAL;
        }

        public String toString() {
            return "LiteralBlock starting at " + this.offset + " with length " + this.length;
        }
    }

    static {
        THE_EOD = new EOD();
    }

    public LZ77Compressor(Parameters params, Callback callback) {
        this.initialized = false;
        this.lookahead = 0;
        this.insertHash = 0;
        this.blockStart = 0;
        this.matchStart = -1;
        this.missedInserts = 0;
        if (params == null) goto L10;
        if (callback == null) goto L8;
        this.params = params;
        this.callback = callback;
        int wSize = params.getWindowSize();
        this.window = new byte[wSize * 2];
        this.wMask = wSize - 1;
        this.head = new int[32768];
        Arrays.fill(this.head, -1);
        this.prev = new int[wSize];
        return;
    L8:
        throw new NullPointerException("callback must not be null");
    L10:
        throw new NullPointerException("params must not be null");
    }

    public void compress(byte[] data) throws IOException {
        compress(data, 0, data.length);
    }

    public void compress(byte[] data, int off, int len) throws IOException {
        int wSize = this.params.getWindowSize();
    L3:
        if (len <= wSize) goto L5;
        doCompress(data, off, wSize);
        off = off + wSize;
        len = len - wSize;
        goto L3
    L5:
        if (len <= 0) goto L9;
        doCompress(data, off, len);
        return;
    }

    public void finish() throws IOException {
        if (this.blockStart == this.currentPosition) goto L5;
    L6:
        this.currentPosition += this.lookahead;
        flushLiteralBlock();
    L7:
        this.callback.accept(THE_EOD);
        return;
    L5:
        if (this.lookahead <= 0) goto L7;
        goto L6
    }

    public void prefill(byte[] data) {
        if (this.currentPosition != 0) goto L16;
        if (this.lookahead != 0) goto L16;
        int len = Math.min(this.params.getWindowSize(), data.length);
        System.arraycopy(data, data.length - len, this.window, 0, len);
        if (len < 3) goto L12;
        initialize();
        int stop = (len - 3) + 1;
        int i = 0;
    L9:
        if (i >= stop) goto L11;
        insertString(i);
        i = i + 1;
        goto L9
    L11:
        this.missedInserts = 2;
    L13:
        this.currentPosition = len;
        this.blockStart = len;
        return;
    L12:
        this.missedInserts = len;
    L16:
        throw new IllegalStateException("the compressor has already started to accept data, can't prefill anymore");
    }

    private int nextHash(int oldHash, byte nextByte) {
        int nextVal = nextByte & CecDeviceType.INACTIVE;
        return ((oldHash << 5) ^ nextVal) & HASH_MASK;
    }

    private void doCompress(byte[] data, int off, int len) throws IOException {
        int spaceLeft = (this.window.length - this.currentPosition) - this.lookahead;
        if (len <= spaceLeft) goto L5;
        slide();
    L5:
        System.arraycopy(data, off, this.window, this.currentPosition + this.lookahead, len);
        this.lookahead += len;
        if (this.initialized == true) goto L11;
        if (this.lookahead < this.params.getMinBackReferenceLength()) goto L11;
        initialize();
    L11:
        if (this.initialized == false) goto L14;
        compress();
        return;
    }

    private void slide() throws IOException {
        int wSize = this.params.getWindowSize();
        if (this.blockStart != this.currentPosition) goto L5;
    L7:
        System.arraycopy(this.window, wSize, this.window, 0, wSize);
        this.currentPosition -= wSize;
        this.matchStart -= wSize;
        this.blockStart -= wSize;
        int i = 0;
    L8:
        int r3 = -1;
        if (i >= 32768) goto L14;
        int h = this.head[i];
        int[] r4 = this.head;
        if (h < wSize) goto L13;
        r3 = h - wSize;
    L13:
        r4[i] = r3;
        i = i + 1;
        goto L8
    L14:
        int i2 = 0;
    L15:
        if (i2 >= wSize) goto L22;
        int p = this.prev[i2];
        int[] r5 = this.prev;
        if (p < wSize) goto L19;
        int r6 = p - wSize;
    L20:
        r5[i2] = r6;
        i2 = i2 + 1;
        goto L15
    L19:
        r6 = -1;
        goto L20
    L22:
        return;
    L5:
        if (this.blockStart >= wSize) goto L7;
        flushLiteralBlock();
        this.blockStart = this.currentPosition;
        goto L7
    }

    private void initialize() {
        int i = 0;
    L4:
        if (i >= 2) goto L6;
        this.insertHash = nextHash(this.insertHash, this.window[i]);
        i = i + 1;
        goto L4
    L6:
        this.initialized = true;
    }

    private void compress() throws IOException {
        int minMatch = this.params.getMinBackReferenceLength();
        boolean lazy = this.params.getLazyMatching();
        int lazyThreshold = this.params.getLazyMatchingThreshold();
    L4:
        if (this.lookahead < minMatch) goto L24;
        catchUpMissedInserts();
        int matchLength = 0;
        int hashHead = insertString(this.currentPosition);
        if (hashHead != (-1)) goto L8;
    L15:
        if (matchLength >= minMatch) goto L17;
        this.lookahead--;
        this.currentPosition++;
        if ((this.currentPosition - this.blockStart) < this.params.getMaxLiteralLength()) goto L4;
        flushLiteralBlock();
        this.blockStart = this.currentPosition;
        goto L4
    L17:
        if (this.blockStart == this.currentPosition) goto L19;
        flushLiteralBlock();
        this.blockStart = -1;
    L19:
        flushBackReference(matchLength);
        insertStringsInMatch(matchLength);
        this.lookahead -= matchLength;
        this.currentPosition += matchLength;
        this.blockStart = this.currentPosition;
        goto L4
    L8:
        if ((hashHead - this.currentPosition) > this.params.getMaxOffset()) goto L15;
        matchLength = longestMatch(hashHead);
        if (lazy == false) goto L15;
        if (matchLength > lazyThreshold) goto L15;
        if (this.lookahead <= minMatch) goto L15;
        matchLength = longestMatchForNextPosition(matchLength);
        goto L15
    }

    private int insertString(int pos) {
        this.insertHash = nextHash(this.insertHash, this.window[(pos - 1) + 3]);
        int hashHead = this.head[this.insertHash];
        this.prev[this.wMask & pos] = hashHead;
        this.head[this.insertHash] = pos;
        return hashHead;
    }

    private int longestMatchForNextPosition(int prevMatchLength) {
        int prevMatchStart = this.matchStart;
        int prevInsertHash = this.insertHash;
        this.lookahead--;
        this.currentPosition++;
        int hashHead = insertString(this.currentPosition);
        int prevHashHead = this.prev[this.currentPosition & this.wMask];
        int matchLength = longestMatch(hashHead);
        if (matchLength > prevMatchLength) goto L6;
        this.matchStart = prevMatchStart;
        this.head[this.insertHash] = prevHashHead;
        this.insertHash = prevInsertHash;
        this.currentPosition--;
        this.lookahead++;
        return prevMatchLength;
    L6:
        return matchLength;
    }

    private void insertStringsInMatch(int matchLength) {
        int stop = Math.min(matchLength - 1, this.lookahead - 3);
        int i = 1;
    L3:
        if (i > stop) goto L5;
        insertString(this.currentPosition + i);
        i = i + 1;
        goto L3
    L5:
        int i2 = matchLength - stop;
        this.missedInserts = i2 - 1;
    }

    private void catchUpMissedInserts() {
    L3:
        if (this.missedInserts <= 0) goto L5;
        int r0 = this.currentPosition;
        int r1 = this.missedInserts;
        this.missedInserts = r1 - 1;
        insertString(r0 - r1);
        goto L3
    }

    private void flushBackReference(int matchLength) throws IOException {
        this.callback.accept(new BackReference(this.currentPosition - this.matchStart, matchLength));
    }

    private void flushLiteralBlock() throws IOException {
        this.callback.accept(new LiteralBlock(this.window, this.blockStart, this.currentPosition - this.blockStart));
    }

    private int longestMatch(int matchHead) {
        int minLength = this.params.getMinBackReferenceLength();
        int longestMatchLength = minLength - 1;
        int maxPossibleLength = Math.min(this.params.getMaxBackReferenceLength(), this.lookahead);
        int minIndex = Math.max(0, this.currentPosition - this.params.getMaxOffset());
        int niceBackReferenceLength = Math.min(maxPossibleLength, this.params.getNiceBackReferenceLength());
        int maxCandidates = this.params.getMaxCandidates();
        int candidates = 0;
    L3:
        if (candidates >= maxCandidates) goto L16;
        if (matchHead < minIndex) goto L16;
        int currentLength = 0;
        int i = 0;
    L6:
        if (i >= maxPossibleLength) goto L11;
        if (this.window[matchHead + i] != this.window[this.currentPosition + i]) goto L11;
        currentLength = currentLength + 1;
        i = i + 1;
    L11:
        if (currentLength <= longestMatchLength) goto L15;
        longestMatchLength = currentLength;
        this.matchStart = matchHead;
        if (currentLength >= niceBackReferenceLength) goto L16;
    L15:
        matchHead = this.prev[this.wMask & matchHead];
        candidates = candidates + 1;
    L16:
        return longestMatchLength;
    }
}
