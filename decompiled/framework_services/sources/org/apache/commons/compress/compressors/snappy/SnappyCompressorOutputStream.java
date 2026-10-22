package org.apache.commons.compress.compressors.snappy;

import com.android.server.usb.descriptors.UsbTerminalTypes;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.apache.commons.compress.compressors.lz77support.Parameters;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes3.dex */
public class SnappyCompressorOutputStream extends CompressorOutputStream {
    private static final int FOUR_BYTE_COPY_TAG = 3;
    private static final int FOUR_SIZE_BYTE_MARKER = 252;
    private static final int MAX_LITERAL_SIZE_WITHOUT_SIZE_BYTES = 60;
    private static final int MAX_LITERAL_SIZE_WITH_ONE_SIZE_BYTE = 256;
    private static final int MAX_LITERAL_SIZE_WITH_THREE_SIZE_BYTES = 16777216;
    private static final int MAX_LITERAL_SIZE_WITH_TWO_SIZE_BYTES = 65536;
    private static final int MAX_MATCH_LENGTH = 64;
    private static final int MAX_MATCH_LENGTH_WITH_ONE_OFFSET_BYTE = 11;
    private static final int MAX_OFFSET_WITH_ONE_OFFSET_BYTE = 1024;
    private static final int MAX_OFFSET_WITH_TWO_OFFSET_BYTES = 32768;
    private static final int MIN_MATCH_LENGTH = 4;
    private static final int MIN_MATCH_LENGTH_WITH_ONE_OFFSET_BYTE = 4;
    private static final int ONE_BYTE_COPY_TAG = 1;
    private static final int ONE_SIZE_BYTE_MARKER = 240;
    private static final int THREE_SIZE_BYTE_MARKER = 248;
    private static final int TWO_BYTE_COPY_TAG = 2;
    private static final int TWO_SIZE_BYTE_MARKER = 244;
    private final LZ77Compressor compressor;
    private final ByteUtils.ByteConsumer consumer;
    private boolean finished;
    private final byte[] oneByte;
    private final OutputStream os;

    /* JADX INFO: renamed from: org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream$2, reason: invalid class name */
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

    static /* synthetic */ void access$000(SnappyCompressorOutputStream x0, LZ77Compressor.LiteralBlock x1) throws IOException {
        x0.writeLiteralBlock(x1);
    }

    static /* synthetic */ void access$100(SnappyCompressorOutputStream x0, LZ77Compressor.BackReference x1) throws IOException {
        x0.writeBackReference(x1);
    }

    public SnappyCompressorOutputStream(OutputStream os, long uncompressedSize) throws IOException {
        this(os, uncompressedSize, 32768);
    }

    public SnappyCompressorOutputStream(OutputStream os, long uncompressedSize, int blockSize) throws IOException {
        this(os, uncompressedSize, createParameterBuilder(blockSize).build());
    }

    public SnappyCompressorOutputStream(OutputStream os, long uncompressedSize, Parameters params) throws IOException {
        this.oneByte = new byte[1];
        this.finished = false;
        this.os = os;
        this.consumer = new ByteUtils.OutputStreamByteConsumer(os);
        this.compressor = new LZ77Compressor(params, new AnonymousClass1(this));
        writeUncompressedSize(uncompressedSize);
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

    private void writeUncompressedSize(long uncompressedSize) throws IOException {
    L3:
        int currentByte = (int) (127 & uncompressedSize);
        if (uncompressedSize <= currentByte) goto L6;
        boolean r2 = true;
    L7:
        boolean more = r2;
        if (more == false) goto L10;
        currentByte = currentByte | 128;
    L10:
        this.os.write(currentByte);
        uncompressedSize = uncompressedSize >> 7;
        if (more == true) goto L3;
        return;
    L6:
        r2 = false;
        goto L7
    }

    private void writeLiteralBlock(LZ77Compressor.LiteralBlock block) throws IOException {
        int len = block.getLength();
        if (len > 60) goto L6;
        writeLiteralBlockNoSizeBytes(block, len);
        return;
    L6:
        if (len > 256) goto L9;
        writeLiteralBlockOneSizeByte(block, len);
        return;
    L9:
        if (len > 65536) goto L12;
        writeLiteralBlockTwoSizeBytes(block, len);
        return;
    L12:
        if (len > 16777216) goto L14;
        writeLiteralBlockThreeSizeBytes(block, len);
        return;
    L14:
        writeLiteralBlockFourSizeBytes(block, len);
    }

    private void writeLiteralBlockNoSizeBytes(LZ77Compressor.LiteralBlock block, int len) throws IOException {
        writeLiteralBlockWithSize((len - 1) << 2, 0, len, block);
    }

    private void writeLiteralBlockOneSizeByte(LZ77Compressor.LiteralBlock block, int len) throws IOException {
        writeLiteralBlockWithSize(240, 1, len, block);
    }

    private void writeLiteralBlockTwoSizeBytes(LZ77Compressor.LiteralBlock block, int len) throws IOException {
        writeLiteralBlockWithSize(244, 2, len, block);
    }

    private void writeLiteralBlockThreeSizeBytes(LZ77Compressor.LiteralBlock block, int len) throws IOException {
        writeLiteralBlockWithSize(248, 3, len, block);
    }

    private void writeLiteralBlockFourSizeBytes(LZ77Compressor.LiteralBlock block, int len) throws IOException {
        writeLiteralBlockWithSize(252, 4, len, block);
    }

    private void writeLiteralBlockWithSize(int tagByte, int sizeBytes, int len, LZ77Compressor.LiteralBlock block) throws IOException {
        this.os.write(tagByte);
        writeLittleEndian(sizeBytes, len - 1);
        this.os.write(block.getData(), block.getOffset(), len);
    }

    private void writeLittleEndian(int numBytes, int num) throws IOException {
        ByteUtils.toLittleEndian(this.consumer, num, numBytes);
    }

    private void writeBackReference(LZ77Compressor.BackReference block) throws IOException {
        int len = block.getLength();
        int offset = block.getOffset();
        if (len < 4) goto L10;
        if (len > 11) goto L10;
        if (offset > 1024) goto L10;
        writeBackReferenceWithOneOffsetByte(len, offset);
        return;
    L10:
        if (offset >= 32768) goto L12;
        writeBackReferenceWithTwoOffsetBytes(len, offset);
        return;
    L12:
        writeBackReferenceWithFourOffsetBytes(len, offset);
    }

    private void writeBackReferenceWithOneOffsetByte(int len, int offset) throws IOException {
        this.os.write((((len - 4) << 2) | 1) | ((offset & UsbTerminalTypes.TERMINAL_EMBED_UNDEFINED) >> 3));
        this.os.write(offset & 255);
    }

    private void writeBackReferenceWithTwoOffsetBytes(int len, int offset) throws IOException {
        writeBackReferenceWithLittleEndianOffset(2, 2, len, offset);
    }

    private void writeBackReferenceWithFourOffsetBytes(int len, int offset) throws IOException {
        writeBackReferenceWithLittleEndianOffset(3, 4, len, offset);
    }

    private void writeBackReferenceWithLittleEndianOffset(int tag, int offsetBytes, int len, int offset) throws IOException {
        this.os.write(((len - 1) << 2) | tag);
        writeLittleEndian(offsetBytes, offset);
    }

    public static Parameters.Builder createParameterBuilder(int blockSize) {
        return Parameters.builder(blockSize).withMinBackReferenceLength(4).withMaxBackReferenceLength(64).withMaxOffset(blockSize).withMaxLiteralLength(blockSize);
    }
}
