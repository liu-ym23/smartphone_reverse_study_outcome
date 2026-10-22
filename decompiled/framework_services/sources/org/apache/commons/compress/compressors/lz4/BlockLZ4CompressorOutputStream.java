package org.apache.commons.compress.compressors.lz4;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.apache.commons.compress.compressors.lz77support.Parameters;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes3.dex */
public class BlockLZ4CompressorOutputStream extends CompressorOutputStream {
    private static final int MIN_BACK_REFERENCE_LENGTH = 4;
    private static final int MIN_OFFSET_OF_LAST_BACK_REFERENCE = 12;
    private final LZ77Compressor compressor;
    private Deque<byte[]> expandedBlocks;
    private boolean finished;
    private final byte[] oneByte;
    private final OutputStream os;
    private Deque<Pair> pairs;

    /* JADX INFO: renamed from: org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType = null;

        static {
            $SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType = new int[LZ77Compressor.Block.BlockType.values().length];
            $SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType[LZ77Compressor.Block.BlockType.LITERAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L17:
            $SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType[LZ77Compressor.Block.BlockType.BACK_REFERENCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L13:
            $SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType[LZ77Compressor.Block.BlockType.EOD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static final class Pair {
        private int brLength;
        private int brOffset;
        private final Deque<byte[]> literals;
        private boolean written;

        Pair() {
            this.literals = new LinkedList();
        }

        static /* synthetic */ boolean access$300(Pair x0) {
            return x0.hasBeenWritten();
        }

        static /* synthetic */ void access$400(Pair x0, byte[] x1) {
            x0.prependLiteral(x1);
        }

        static /* synthetic */ int access$500(Pair x0) {
            return x0.backReferenceLength();
        }

        static /* synthetic */ Pair access$600(Pair x0, int x1) {
            return x0.splitWithNewBackReferenceLengthOf(x1);
        }

        static /* synthetic */ void access$700(Pair x0, Pair x1) {
            x0.prependTo(x1);
        }

        private void prependLiteral(byte[] data) {
            this.literals.addFirst(data);
        }

        byte[] addLiteral(LZ77Compressor.LiteralBlock block) {
            byte[] copy = Arrays.copyOfRange(block.getData(), block.getOffset(), block.getOffset() + block.getLength());
            this.literals.add(copy);
            return copy;
        }

        void setBackReference(LZ77Compressor.BackReference block) {
            if (hasBackReference() == true) goto L7;
            this.brOffset = block.getOffset();
            this.brLength = block.getLength();
            return;
        L7:
            throw new IllegalStateException();
        }

        boolean hasBackReference() {
            if (this.brOffset <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean canBeWritten(int lengthOfBlocksAfterThisPair) {
            if (hasBackReference() == true) goto L5;
        L7:
            return false;
        L5:
            if (lengthOfBlocksAfterThisPair < 16) goto L7;
            return true;
        }

        int length() {
            return literalLength() + this.brLength;
        }

        private boolean hasBeenWritten() {
            return this.written;
        }

        void writeTo(OutputStream out) throws IOException {
            int litLength = literalLength();
            out.write(lengths(litLength, this.brLength));
            if (litLength < 15) goto L5;
            writeLength(litLength - 15, out);
        L5:
            Iterator<byte[]> r2 = this.literals.iterator();
        L7:
            if (r2.hasNext() == false) goto L10;
            byte[] b = r2.next();
            out.write(b);
            goto L7
        L10:
            if (hasBackReference() == false) goto L14;
            ByteUtils.toLittleEndian(out, this.brOffset, 2);
            if ((this.brLength - 4) < 15) goto L14;
            writeLength((this.brLength - 4) - 15, out);
        L14:
            this.written = true;
        }

        private int literalLength() {
            int length = 0;
            Iterator<byte[]> r1 = this.literals.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            byte[] b = r1.next();
            length = length + b.length;
            goto L4
        L6:
            return length;
        }

        private static int lengths(int litLength, int brLength) {
            int br = 15;
            if (litLength >= 15) goto L5;
            int l = litLength;
        L7:
            if (brLength >= 4) goto L10;
            br = 0;
        L13:
            return (l << 4) | br;
        L10:
            if (brLength >= 19) goto L13;
            br = brLength - 4;
            goto L13
        L5:
            l = 15;
            goto L7
        }

        private static void writeLength(int length, OutputStream out) throws IOException {
        L3:
            if (length < 255) goto L5;
            out.write(255);
            length = length - 255;
            goto L3
        L5:
            out.write(length);
        }

        private int backReferenceLength() {
            return this.brLength;
        }

        private void prependTo(Pair other) {
            Iterator<byte[]> listBackwards = this.literals.descendingIterator();
        L4:
            if (listBackwards.hasNext() == false) goto L6;
            other.prependLiteral(listBackwards.next());
            goto L4
        }

        private Pair splitWithNewBackReferenceLengthOf(int newBackReferenceLength) {
            Pair p = new Pair();
            p.literals.addAll(this.literals);
            p.brOffset = this.brOffset;
            p.brLength = newBackReferenceLength;
            return p;
        }
    }

    static /* synthetic */ void access$000(BlockLZ4CompressorOutputStream x0, LZ77Compressor.LiteralBlock x1) throws IOException {
        x0.addLiteralBlock(x1);
    }

    static /* synthetic */ void access$100(BlockLZ4CompressorOutputStream x0, LZ77Compressor.BackReference x1) throws IOException {
        x0.addBackReference(x1);
    }

    static /* synthetic */ void access$200(BlockLZ4CompressorOutputStream x0) throws IOException {
        x0.writeFinalLiteralBlock();
    }

    public BlockLZ4CompressorOutputStream(OutputStream os) throws IOException {
        this(os, createParameterBuilder().build());
    }

    public BlockLZ4CompressorOutputStream(OutputStream os, Parameters params) throws IOException {
        this.oneByte = new byte[1];
        this.finished = false;
        this.pairs = new LinkedList();
        this.expandedBlocks = new LinkedList();
        this.os = os;
        this.compressor = new LZ77Compressor(params, new AnonymousClass1(this));
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        this.oneByte[0] = (byte) (b & 255);
        write(this.oneByte);
    }

    @Override // java.io.OutputStream
    public void write(byte[] data, int off, int len) throws IOException {
        this.compressor.compress(data, off, len);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        finish();     // Catch: Throwable -> L5
        this.os.close();
        return;
    L5:
        th = move-exception;
        this.os.close();
        throw th;
    }

    public void finish() throws IOException {
        if (this.finished == true) goto L6;
        this.compressor.finish();
        this.finished = true;
        return;
    }

    public void prefill(byte[] data, int off, int len) {
        if (len <= 0) goto L5;
        byte[] b = Arrays.copyOfRange(data, off, off + len);
        this.compressor.prefill(b);
        recordLiteral(b);
        return;
    }

    private void addLiteralBlock(LZ77Compressor.LiteralBlock block) throws IOException {
        Pair last = writeBlocksAndReturnUnfinishedPair(block.getLength());
        recordLiteral(last.addLiteral(block));
        clearUnusedBlocksAndPairs();
    }

    private void addBackReference(LZ77Compressor.BackReference block) throws IOException {
        Pair last = writeBlocksAndReturnUnfinishedPair(block.getLength());
        last.setBackReference(block);
        recordBackReference(block);
        clearUnusedBlocksAndPairs();
    }

    private Pair writeBlocksAndReturnUnfinishedPair(int length) throws IOException {
        writeWritablePairs(length);
        Pair last = this.pairs.peekLast();
        if (last != null) goto L5;
    L6:
        Pair last2 = new Pair();
        this.pairs.addLast(last2);
        return last2;
    L5:
        if (last.hasBackReference() == true) goto L6;
        return last;
    }

    private void recordLiteral(byte[] b) {
        this.expandedBlocks.addFirst(b);
    }

    private void clearUnusedBlocksAndPairs() {
        clearUnusedBlocks();
        clearUnusedPairs();
    }

    private void clearUnusedBlocks() {
        int blockLengths = 0;
        int blocksToKeep = 0;
        Iterator<byte[]> r2 = this.expandedBlocks.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        byte[] b = r2.next();
        blocksToKeep = blocksToKeep + 1;
        blockLengths = blockLengths + b.length;
        if (blockLengths < 65536) goto L4;
    L9:
        int size = this.expandedBlocks.size();
        int i = blocksToKeep;
    L10:
        if (i >= size) goto L13;
        this.expandedBlocks.removeLast();
        i = i + 1;
        goto L10
    }

    private void recordBackReference(LZ77Compressor.BackReference block) {
        this.expandedBlocks.addFirst(expand(block.getOffset(), block.getLength()));
    }

    private byte[] expand(int offset, int length) {
        byte[] expanded = new byte[length];
        if (offset != 1) goto L8;
        byte[] block = this.expandedBlocks.peekFirst();
        byte b = block[block.length - 1];
        if (b == 0) goto L9;
        Arrays.fill(expanded, b);
    L9:
        return expanded;
    L8:
        expandFromList(expanded, offset, length);
        goto L9
    }

    private void expandFromList(byte[] expanded, int offset, int length) {
        int offsetRemaining = offset;
        int lengthRemaining = length;
        int writeOffset = 0;
    L3:
        if (lengthRemaining <= 0) goto L19;
        byte[] block = null;
        if (offsetRemaining <= 0) goto L17;
        int blockOffset = 0;
        Iterator<byte[]> r5 = this.expandedBlocks.iterator();
    L8:
        if (r5.hasNext() == false) goto L13;
        byte[] b = r5.next();
        if ((b.length + blockOffset) >= offsetRemaining) goto L11;
        blockOffset = blockOffset + b.length;
        goto L8
    L11:
        block = b;
    L13:
        if (block == null) goto L16;
        int copyOffset = (block.length + blockOffset) - offsetRemaining;
        int blockOffset2 = Math.min(lengthRemaining, block.length - copyOffset);
    L18:
        System.arraycopy(block, copyOffset, expanded, writeOffset, blockOffset2);
        offsetRemaining = offsetRemaining - blockOffset2;
        lengthRemaining = lengthRemaining - blockOffset2;
        writeOffset = writeOffset + blockOffset2;
        goto L3
    L16:
        throw new IllegalStateException("failed to find a block containing offset " + offset);
    L17:
        block = expanded;
        copyOffset = -offsetRemaining;
        blockOffset2 = Math.min(lengthRemaining, writeOffset + offsetRemaining);
        goto L18
    }

    private void clearUnusedPairs() {
        int pairLengths = 0;
        int pairsToKeep = 0;
        Iterator<Pair> it = this.pairs.descendingIterator();
    L4:
        if (it.hasNext() == false) goto L9;
        Pair p = it.next();
        pairsToKeep = pairsToKeep + 1;
        pairLengths = pairLengths + p.length();
        if (pairLengths < 65536) goto L4;
    L9:
        int size = this.pairs.size();
        int i = pairsToKeep;
    L10:
        if (i >= size) goto L14;
        Pair p2 = this.pairs.peekFirst();
        if (Pair.access$300(p2) == false) goto L20;
        this.pairs.removeFirst();
        i = i + 1;
        goto L10
    L20:
        return;
    }

    private void writeFinalLiteralBlock() throws IOException {
        rewriteLastPairs();
        Iterator<Pair> r0 = this.pairs.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Pair p = r0.next();
        if (Pair.access$300(p) == true) goto L4;
        p.writeTo(this.os);
        goto L4
    L9:
        this.pairs.clear();
    }

    private void writeWritablePairs(int lengthOfBlocksAfterLastPair) throws IOException {
        int unwrittenLength = lengthOfBlocksAfterLastPair;
        Iterator<Pair> it = this.pairs.descendingIterator();
    L4:
        if (it.hasNext() == false) goto L9;
        Pair p = it.next();
        if (Pair.access$300(p) == true) goto L9;
        unwrittenLength = unwrittenLength + p.length();
    L9:
        Iterator<Pair> r1 = this.pairs.iterator();
    L11:
        if (r1.hasNext() == false) goto L18;
        Pair p2 = r1.next();
        if (Pair.access$300(p2) == true) goto L11;
        unwrittenLength = unwrittenLength - p2.length();
        if (p2.canBeWritten(unwrittenLength) == false) goto L27;
        p2.writeTo(this.os);
        goto L11
    L27:
        return;
    }

    private void rewriteLastPairs() {
        LinkedList<Pair> lastPairs = new LinkedList();
        LinkedList<Integer> pairLength = new LinkedList();
        int offset = 0;
        Iterator<Pair> it = this.pairs.descendingIterator();
    L4:
        if (it.hasNext() == false) goto L12;
        Pair p = it.next();
        if (Pair.access$300(p) == true) goto L12;
        int len = p.length();
        pairLength.addFirst(Integer.valueOf(len));
        lastPairs.addFirst(p);
        offset = offset + len;
        if (offset < 12) goto L4;
    L12:
        Iterator<Pair> it2 = lastPairs.iterator();
    L14:
        if (it2.hasNext() == false) goto L16;
        Pair p2 = it2.next();
        this.pairs.remove(p2);
        goto L14
    L16:
        int lastPairsSize = lastPairs.size();
        int toExpand = 0;
        int i = 1;
    L17:
        if (i >= lastPairsSize) goto L19;
        toExpand = toExpand + pairLength.get(i).intValue();
        i = i + 1;
        goto L17
    L19:
        Pair replacement = new Pair();
        if (toExpand <= 0) goto L22;
        Pair.access$400(replacement, expand(toExpand, toExpand));
    L22:
        int brLen = 0;
        Pair splitCandidate = lastPairs.get(0);
        int stillNeeded = 12 - toExpand;
        if (splitCandidate.hasBackReference() == false) goto L26;
        brLen = Pair.access$500(splitCandidate);
    L26:
        if (splitCandidate.hasBackReference() == false) goto L31;
        if (brLen < (stillNeeded + 4)) goto L31;
        Pair.access$400(replacement, expand(toExpand + stillNeeded, stillNeeded));
        this.pairs.add(Pair.access$600(splitCandidate, brLen - stillNeeded));
    L34:
        this.pairs.add(replacement);
        return;
    L31:
        if (splitCandidate.hasBackReference() == false) goto L33;
        Pair.access$400(replacement, expand(toExpand + brLen, brLen));
    L33:
        Pair.access$700(splitCandidate, replacement);
        goto L34
    }

    public static Parameters.Builder createParameterBuilder() {
        return Parameters.builder(65536).withMinBackReferenceLength(4).withMaxBackReferenceLength(65535).withMaxOffset(65535).withMaxLiteralLength(65535);
    }
}
