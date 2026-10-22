package org.apache.commons.compress.compressors.gzip;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.CharsetNames;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes3.dex */
public class GzipCompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int FCOMMENT = 16;
    private static final int FEXTRA = 4;
    private static final int FHCRC = 2;
    private static final int FNAME = 8;
    private static final int FRESERVED = 224;
    private final byte[] buf;
    private int bufUsed;
    private final CountingInputStream countingStream;
    private final CRC32 crc;
    private final boolean decompressConcatenated;
    private boolean endReached;
    private final InputStream in;
    private Inflater inf;
    private final byte[] oneByte;
    private final GzipParameters parameters;

    static {
    }

    public GzipCompressorInputStream(InputStream inputStream) throws IOException {
        this(inputStream, false);
    }

    public GzipCompressorInputStream(InputStream inputStream, boolean decompressConcatenated) throws IOException {
        this.buf = new byte[8192];
        this.inf = new Inflater(true);
        this.crc = new CRC32();
        this.endReached = false;
        this.oneByte = new byte[1];
        this.parameters = new GzipParameters();
        this.countingStream = new CountingInputStream(inputStream);
        if (this.countingStream.markSupported() == false) goto L5;
        this.in = this.countingStream;
    L6:
        this.decompressConcatenated = decompressConcatenated;
        init(true);
        return;
    L5:
        this.in = new BufferedInputStream(this.countingStream);
        goto L6
    }

    public GzipParameters getMetaData() {
        return this.parameters;
    }

    private boolean init(boolean isFirstMember) throws IOException {
        int magic0 = this.in.read();
        int magic1 = this.in.read();
        if (magic0 != (-1)) goto L8;
        if (isFirstMember == true) goto L8;
        return false;
    L8:
        if (magic0 != 31) goto L43;
        if (magic1 != 139) goto L43;
        DataInput inData = new DataInputStream(this.in);
        int method = inData.readUnsignedByte();
        if (method != 8) goto L41;
        int flg = inData.readUnsignedByte();
        if ((flg & 224) != 0) goto L39;
        this.parameters.setModificationTime(ByteUtils.fromLittleEndian(inData, 4) * 1000);
        switch(inData.readUnsignedByte()) {
            case 2: goto L20;
            case 3: goto L21;
            case 4: goto L19;
            default: goto L21;
        };
    L19:
        this.parameters.setCompressionLevel(1);
        goto L21
    L20:
        this.parameters.setCompressionLevel(9);
    L21:
        this.parameters.setOperatingSystem(inData.readUnsignedByte());
        if ((flg & 4) == 0) goto L28;
        int xlen = inData.readUnsignedByte();
        int xlen2 = (inData.readUnsignedByte() << 8) | xlen;
    L24:
        int xlen3 = xlen2 - 1;
        if (xlen2 <= 0) goto L28;
        inData.readUnsignedByte();
        xlen2 = xlen3;
    L28:
        if ((flg & 8) == 0) goto L31;
        this.parameters.setFilename(new String(readToNull(inData), CharsetNames.ISO_8859_1));
    L31:
        if ((flg & 16) == 0) goto L34;
        this.parameters.setComment(new String(readToNull(inData), CharsetNames.ISO_8859_1));
    L34:
        if ((flg & 2) == 0) goto L36;
        inData.readShort();
    L36:
        this.inf.reset();
        this.crc.reset();
        return true;
    L39:
        throw new IOException("Reserved flags are set in the .gz header");
    L41:
        throw new IOException("Unsupported compression method " + method + " in the .gz header");
    L43:
        if (isFirstMember == false) goto L45;
        String r3 = "Input is not in the .gz format";
    L47:
        throw new IOException(r3);
    L45:
        r3 = "Garbage after a valid .gz stream";
        goto L47
    }

    private static byte[] readToNull(DataInput inData) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
    L3:
        int b = inData.readUnsignedByte();
        if (b == 0) goto L7;
        bos.write(b);
        goto L3
    L7:
        return bos.toByteArray();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.oneByte, 0, 1) != (-1)) goto L6;
        return -1;
    L6:
        return this.oneByte[0] & CecDeviceType.INACTIVE;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        if (this.endReached == false) goto L5;
        return -1;
    L5:
        int off2 = off;
        int len2 = len;
        int size = 0;
    L6:
        if (len2 <= 0) goto L42;
        if (this.inf.needsInput() == false) goto L43;
        this.in.mark(this.buf.length);
        this.bufUsed = this.in.read(this.buf);
        if (this.bufUsed == (-1)) goto L13;
        this.inf.setInput(this.buf, 0, this.bufUsed);
        goto L43
    L13:
        throw new EOFException();
    L43:
        int ret = this.inf.inflate(b, off2, len2);     // Catch: DataFormatException -> L39
        this.crc.update(b, off2, ret);
        off2 = off2 + ret;
        len2 = len2 - ret;
        size = size + ret;
        count(ret);
        if (this.inf.finished() == false) goto L6;
        this.in.reset();
        int skipAmount = this.bufUsed - this.inf.getRemaining();
        if (IOUtils.skip(this.in, skipAmount) != skipAmount) goto L37;
        this.bufUsed = 0;
        DataInput inData = new DataInputStream(this.in);
        long crcStored = ByteUtils.fromLittleEndian(inData, 4);
        if (crcStored != this.crc.getValue()) goto L35;
        long isize = ByteUtils.fromLittleEndian(inData, 4);
        if (isize != (this.inf.getBytesWritten() & 4294967295L)) goto L33;
        if (this.decompressConcatenated == false) goto L27;
        if (init(false) == true) goto L6;
    L27:
        this.inf.end();
        this.inf = null;
        this.endReached = true;
        if (size != 0) goto L31;
        return -1;
    L31:
        return size;
    L33:
        throw new IOException("Gzip-compressed data is corrupt(uncompressed size mismatch)");
    L35:
        throw new IOException("Gzip-compressed data is corrupt (CRC32 error)");
    L37:
        throw new IOException();
    L41:
        throw new IOException("Gzip-compressed data is corrupt");
    L42:
        return size;
    }

    public static boolean matches(byte[] signature, int length) {
        if (length >= 2) goto L5;
        return false;
    L5:
        if (signature[0] == 31) goto L7;
        return false;
    L7:
        if (signature[1] == (-117)) goto L9;
        return false;
    L9:
        return true;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.inf == null) goto L6;
        this.inf.end();
        this.inf = null;
    L6:
        if (this.in == System.in) goto L9;
        this.in.close();
        return;
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.countingStream.getBytesRead();
    }
}
