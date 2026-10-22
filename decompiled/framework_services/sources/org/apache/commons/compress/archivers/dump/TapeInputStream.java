package org.apache.commons.compress.archivers.dump;

import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: classes3.dex */
class TapeInputStream extends FilterInputStream {
    private static final int RECORD_SIZE = 1024;
    private byte[] blockBuffer;
    private int blockSize;
    private long bytesRead;
    private int currBlkIdx;
    private boolean isCompressed;
    private int readOffset;

    /* JADX INFO: renamed from: org.apache.commons.compress.archivers.dump.TapeInputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE = null;

        static {
            $SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE = new int[DumpArchiveConstants.COMPRESSION_TYPE.values().length];
            $SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE[DumpArchiveConstants.COMPRESSION_TYPE.ZLIB.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L17:
            $SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE[DumpArchiveConstants.COMPRESSION_TYPE.BZLIB.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L13:
            $SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE[DumpArchiveConstants.COMPRESSION_TYPE.LZO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public TapeInputStream(InputStream in) {
        super(in);
        this.blockBuffer = new byte[1024];
        this.currBlkIdx = -1;
        this.blockSize = 1024;
        this.readOffset = 1024;
        this.isCompressed = false;
        this.bytesRead = 0;
    }

    public void resetBlockSize(int recsPerBlock, boolean isCompressed) throws IOException {
        this.isCompressed = isCompressed;
        this.blockSize = recsPerBlock * 1024;
        byte[] oldBuffer = this.blockBuffer;
        this.blockBuffer = new byte[this.blockSize];
        System.arraycopy(oldBuffer, 0, this.blockBuffer, 0, 1024);
        readFully(this.blockBuffer, 1024, this.blockSize - 1024);
        this.currBlkIdx = 0;
        this.readOffset = 1024;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        if (this.readOffset >= this.blockSize) goto L7;
        return this.blockSize - this.readOffset;
    L7:
        return ((FilterInputStream) this).in.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        throw new IllegalArgumentException("all reads must be multiple of record size (1024 bytes.");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        if ((len % 1024) != 0) goto L21;
        int bytes = 0;
    L5:
        if (bytes >= len) goto L19;
        if (this.readOffset != this.blockSize) goto L15;
        readBlock(true);     // Catch: ShortFileException -> L11
    L12:
        return -1;
    L15:
        if ((this.readOffset + (len - bytes)) > this.blockSize) goto L17;
        int n = len - bytes;
    L18:
        System.arraycopy(this.blockBuffer, this.readOffset, b, off, n);
        this.readOffset += n;
        bytes = bytes + n;
        off = off + n;
        goto L5
    L17:
        n = this.blockSize - this.readOffset;
        goto L18
    L19:
        return bytes;
    L21:
        throw new IllegalArgumentException("all reads must be multiple of record size (1024 bytes.");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long len) throws IOException {
        if ((len % DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES) != 0) goto L26;
        long bytes = 0;
    L6:
        if (bytes >= len) goto L24;
        if (this.readOffset != this.blockSize) goto L20;
        if ((len - bytes) >= this.blockSize) goto L13;
        boolean r2 = true;
    L14:
        readBlock(r2);     // Catch: ShortFileException -> L16
    L13:
        r2 = false;
    L17:
        return -1;
    L20:
        if ((((long) this.readOffset) + (len - bytes)) > this.blockSize) goto L22;
        long n = len - bytes;
    L23:
        this.readOffset = (int) (((long) this.readOffset) + n);
        bytes = bytes + n;
        goto L6
    L22:
        n = ((long) this.blockSize) - ((long) this.readOffset);
        goto L23
    L24:
        return bytes;
    L26:
        throw new IllegalArgumentException("all reads must be multiple of record size (1024 bytes.");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (((FilterInputStream) this).in != null) goto L5;
        return;
    L5:
        if (((FilterInputStream) this).in == System.in) goto L9;
        ((FilterInputStream) this).in.close();
        return;
    }

    public byte[] peek() throws IOException {
        if (this.readOffset == this.blockSize) goto L12;
    L10:
        byte[] b = new byte[1024];
        System.arraycopy(this.blockBuffer, this.readOffset, b, 0, b.length);
        return b;
    L12:
        readBlock(true);     // Catch: ShortFileException -> L7
    L8:
        return null;
    }

    public byte[] readRecord() throws IOException {
        byte[] result = new byte[1024];
        if ((-1) == read(result, 0, result.length)) goto L6;
        return result;
    L6:
        throw new ShortFileException();
    }

    private void readBlock(boolean decompress) throws IOException {
        if (((FilterInputStream) this).in == null) goto L43;
        if (this.isCompressed == true) goto L7;
    L39:
        readFully(this.blockBuffer, 0, this.blockSize);
        this.bytesRead += (long) this.blockSize;
    L40:
        this.currBlkIdx++;
        this.readOffset = 0;
        return;
    L7:
        if (this.currBlkIdx == (-1)) goto L39;
        readFully(this.blockBuffer, 0, 4);
        this.bytesRead += 4;
        int h = DumpArchiveUtil.convert32(this.blockBuffer, 0);
        if ((h & 1) != 1) goto L12;
        boolean compressed = true;
    L13:
        if (compressed == true) goto L15;
        readFully(this.blockBuffer, 0, this.blockSize);
        this.bytesRead += (long) this.blockSize;
        goto L40
    L15:
        int flags = (h >> 1) & 7;
        int length = (h >> 4) & 268435455;
        byte[] compBuffer = new byte[length];
        readFully(compBuffer, 0, length);
        this.bytesRead += (long) length;
        if (decompress == true) goto L19;
        Arrays.fill(this.blockBuffer, (byte) 0);
        goto L40
    L19:
        switch(AnonymousClass1.$SwitchMap$org$apache$commons$compress$archivers$dump$DumpArchiveConstants$COMPRESSION_TYPE[DumpArchiveConstants.COMPRESSION_TYPE.find(flags & 3).ordinal()]) {
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L23;
            default: goto L21;
        };
    L26:
        Inflater inflator = new Inflater();
        inflator.setInput(compBuffer, 0, compBuffer.length);     // Catch: Throwable -> L32 DataFormatException -> L34
        if (inflator.inflate(this.blockBuffer) != this.blockSize) goto L31;
        inflator.end();
        goto L40
    L31:
        throw new ShortFileException();     // Catch: Throwable -> L32 DataFormatException -> L34
    L32:
        th = move-exception;
        inflator.end();
        throw th;
    L34:
        e = move-exception;
        throw new DumpArchiveException("bad data", e);     // Catch: Throwable -> L32
    L21:
        throw new UnsupportedCompressionAlgorithmException();
    L23:
        throw new UnsupportedCompressionAlgorithmException("LZO");
    L25:
        throw new UnsupportedCompressionAlgorithmException("BZLIB2");
    L12:
        compressed = false;
        goto L13
    L43:
        throw new IOException("input buffer is closed");
    }

    private void readFully(byte[] b, int off, int len) throws IOException {
        int count = IOUtils.readFully(((FilterInputStream) this).in, b, off, len);
        if (count < len) goto L6;
        return;
    L6:
        throw new ShortFileException();
    }

    public long getBytesRead() {
        return this.bytesRead;
    }
}
