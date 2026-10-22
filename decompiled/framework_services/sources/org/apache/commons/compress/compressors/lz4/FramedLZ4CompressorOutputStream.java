package org.apache.commons.compress.compressors.lz4;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes3.dex */
public class FramedLZ4CompressorOutputStream extends CompressorOutputStream {
    private static final byte[] END_MARK = null;
    private final byte[] blockData;
    private byte[] blockDependencyBuffer;
    private final XXHash32 blockHash;
    private int collectedBlockDependencyBytes;
    private final XXHash32 contentHash;
    private int currentIndex;
    private boolean finished;
    private final byte[] oneByte;
    private final OutputStream out;
    private final Parameters params;

    public static final enum BlockSize extends Enum<BlockSize> {
        private static final /* synthetic */ BlockSize[] $VALUES = null;
        public static final BlockSize K256 = null;
        public static final BlockSize K64 = null;
        public static final BlockSize M1 = null;
        public static final BlockSize M4 = null;
        private final int index;
        private final int size;

        private static /* synthetic */ BlockSize[] $values() {
            return new BlockSize[]{K64, K256, M1, M4};
        }

        public static BlockSize valueOf(String name) {
            return (BlockSize) Enum.valueOf(BlockSize.class, name);
        }

        public static BlockSize[] values() {
            return (BlockSize[]) $VALUES.clone();
        }

        static {
            K64 = new BlockSize("K64", 0, 65536, 4);
            K256 = new BlockSize("K256", 1, 262144, 5);
            M1 = new BlockSize("M1", 2, 1048576, 6);
            M4 = new BlockSize("M4", 3, 4194304, 7);
            $VALUES = $values();
        }

        private BlockSize(String r1, int r2, int size, int index) {
            super(r1, r2);
            this.size = size;
            this.index = index;
        }

        int getSize() {
            return this.size;
        }

        int getIndex() {
            return this.index;
        }
    }

    public static class Parameters {
        public static final Parameters DEFAULT = null;
        private final BlockSize blockSize;
        private final org.apache.commons.compress.compressors.lz77support.Parameters lz77params;
        private final boolean withBlockChecksum;
        private final boolean withBlockDependency;
        private final boolean withContentChecksum;

        static /* synthetic */ BlockSize access$000(Parameters x0) {
            return x0.blockSize;
        }

        static /* synthetic */ boolean access$100(Parameters x0) {
            return x0.withBlockChecksum;
        }

        static /* synthetic */ boolean access$200(Parameters x0) {
            return x0.withBlockDependency;
        }

        static /* synthetic */ boolean access$300(Parameters x0) {
            return x0.withContentChecksum;
        }

        static /* synthetic */ org.apache.commons.compress.compressors.lz77support.Parameters access$400(Parameters x0) {
            return x0.lz77params;
        }

        static {
            DEFAULT = new Parameters(BlockSize.M4, true, false, false);
        }

        public Parameters(BlockSize blockSize) {
            this(blockSize, true, false, false);
        }

        public Parameters(BlockSize blockSize, org.apache.commons.compress.compressors.lz77support.Parameters lz77params) {
            this(blockSize, true, false, false, lz77params);
        }

        public Parameters(BlockSize blockSize, boolean withContentChecksum, boolean withBlockChecksum, boolean withBlockDependency) {
            this(blockSize, withContentChecksum, withBlockChecksum, withBlockDependency, BlockLZ4CompressorOutputStream.createParameterBuilder().build());
        }

        public Parameters(BlockSize blockSize, boolean withContentChecksum, boolean withBlockChecksum, boolean withBlockDependency, org.apache.commons.compress.compressors.lz77support.Parameters lz77params) {
            this.blockSize = blockSize;
            this.withContentChecksum = withContentChecksum;
            this.withBlockChecksum = withBlockChecksum;
            this.withBlockDependency = withBlockDependency;
            this.lz77params = lz77params;
        }

        public String toString() {
            return "LZ4 Parameters with BlockSize " + this.blockSize + ", withContentChecksum " + this.withContentChecksum + ", withBlockChecksum " + this.withBlockChecksum + ", withBlockDependency " + this.withBlockDependency;
        }
    }

    static {
        END_MARK = new byte[4];
    }

    public FramedLZ4CompressorOutputStream(OutputStream out) throws IOException {
        this(out, Parameters.DEFAULT);
    }

    public FramedLZ4CompressorOutputStream(OutputStream out, Parameters params) throws IOException {
        this.oneByte = new byte[1];
        this.finished = false;
        this.currentIndex = 0;
        this.contentHash = new XXHash32();
        this.params = params;
        this.blockData = new byte[Parameters.access$000(params).getSize()];
        this.out = out;
        byte[] r1 = null;
        if (Parameters.access$100(params) == false) goto L5;
        XXHash32 r0 = new XXHash32();
    L6:
        this.blockHash = r0;
        out.write(FramedLZ4CompressorInputStream.LZ4_SIGNATURE);
        writeFrameDescriptor();
        if (Parameters.access$200(params) == false) goto L10;
        r1 = new byte[65536];
    L10:
        this.blockDependencyBuffer = r1;
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        this.oneByte[0] = (byte) (b & 255);
        write(this.oneByte);
    }

    @Override // java.io.OutputStream
    public void write(byte[] data, int off, int len) throws IOException {
        if (Parameters.access$300(this.params) == false) goto L6;
        this.contentHash.update(data, off, len);
    L6:
        if ((this.currentIndex + len) <= this.blockData.length) goto L11;
        flushBlock();
    L9:
        if (len <= this.blockData.length) goto L11;
        System.arraycopy(data, off, this.blockData, 0, this.blockData.length);
        off = off + this.blockData.length;
        len = len - this.blockData.length;
        this.currentIndex = this.blockData.length;
        flushBlock();
    L11:
        System.arraycopy(data, off, this.blockData, this.currentIndex, len);
        this.currentIndex += len;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        finish();     // Catch: Throwable -> L5
        this.out.close();
        return;
    L5:
        th = move-exception;
        this.out.close();
        throw th;
    }

    public void finish() throws IOException {
        if (this.finished == false) goto L5;
        return;
    L5:
        if (this.currentIndex <= 0) goto L7;
        flushBlock();
    L7:
        writeTrailer();
        this.finished = true;
    }

    private void writeFrameDescriptor() throws IOException {
        int flags = 64;
        if (Parameters.access$200(this.params) == true) goto L6;
        flags = 64 | 32;
    L6:
        if (Parameters.access$300(this.params) == false) goto L9;
        flags = flags | 4;
    L9:
        if (Parameters.access$100(this.params) == false) goto L11;
        flags = flags | 16;
    L11:
        this.out.write(flags);
        this.contentHash.update(flags);
        int bd = (Parameters.access$000(this.params).getIndex() << 4) & 112;
        this.out.write(bd);
        this.contentHash.update(bd);
        this.out.write((int) ((this.contentHash.getValue() >> 8) & 255));
        this.contentHash.reset();
    }

    private void flushBlock() throws IOException {
        boolean withBlockDependency = Parameters.access$200(this.params);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BlockLZ4CompressorOutputStream o = new BlockLZ4CompressorOutputStream(baos, Parameters.access$400(this.params));
        if (withBlockDependency == true) goto L31;
    L7:
        o.write(this.blockData, 0, this.currentIndex);     // Catch: Throwable -> L5
        o.close();
        if (withBlockDependency == false) goto L11;
        appendToBlockDependencyBuffer(this.blockData, 0, this.currentIndex);
    L11:
        byte[] b = baos.toByteArray();
        if (b.length <= this.currentIndex) goto L16;
        ByteUtils.toLittleEndian(this.out, this.currentIndex | Integer.MIN_VALUE, 4);
        this.out.write(this.blockData, 0, this.currentIndex);
        if (Parameters.access$100(this.params) == false) goto L20;
        this.blockHash.update(this.blockData, 0, this.currentIndex);
    L20:
        if (Parameters.access$100(this.params) == false) goto L22;
        ByteUtils.toLittleEndian(this.out, this.blockHash.getValue(), 4);
        this.blockHash.reset();
    L22:
        this.currentIndex = 0;
        return;
    L16:
        ByteUtils.toLittleEndian(this.out, b.length, 4);
        this.out.write(b);
        if (Parameters.access$100(this.params) == false) goto L20;
        this.blockHash.update(b, 0, b.length);
    L5:
        th = move-exception;
        o.close();     // Catch: Throwable -> L26
    L28:
        throw th;
    L26:
        th = move-exception;
        th.addSuppressed(th);
        goto L28
    L31:
        o.prefill(this.blockDependencyBuffer, this.blockDependencyBuffer.length - this.collectedBlockDependencyBytes, this.collectedBlockDependencyBytes);     // Catch: Throwable -> L5
        goto L7
    }

    private void writeTrailer() throws IOException {
        this.out.write(END_MARK);
        if (Parameters.access$300(this.params) == false) goto L6;
        ByteUtils.toLittleEndian(this.out, this.contentHash.getValue(), 4);
        return;
    }

    private void appendToBlockDependencyBuffer(byte[] b, int off, int len) {
        int len2 = Math.min(len, this.blockDependencyBuffer.length);
        if (len2 <= 0) goto L9;
        int keep = this.blockDependencyBuffer.length - len2;
        if (keep <= 0) goto L7;
        System.arraycopy(this.blockDependencyBuffer, len2, this.blockDependencyBuffer, 0, keep);
    L7:
        System.arraycopy(b, off, this.blockDependencyBuffer, keep, len2);
        this.collectedBlockDependencyBytes = Math.min(this.collectedBlockDependencyBytes + len2, this.blockDependencyBuffer.length);
        return;
    }
}
