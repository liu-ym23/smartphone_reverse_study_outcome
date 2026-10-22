package org.tukaani.xz.index;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.zip.CheckedInputStream;
import org.tukaani.xz.CorruptedInputException;
import org.tukaani.xz.XZIOException;
import org.tukaani.xz.check.CRC32;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.check.SHA256;
import org.tukaani.xz.common.DecoderUtil;

/* JADX INFO: loaded from: classes3.dex */
public class IndexHash extends IndexBase {
    private Check hash;

    @Override // org.tukaani.xz.index.IndexBase
    public /* bridge */ /* synthetic */ long getIndexSize() {
        return super.getIndexSize();
    }

    @Override // org.tukaani.xz.index.IndexBase
    public /* bridge */ /* synthetic */ long getStreamSize() {
        return super.getStreamSize();
    }

    public IndexHash() {
        super(new CorruptedInputException());
        this.hash = new SHA256();     // Catch: NoSuchAlgorithmException -> L5
        return;
    L6:
        this.hash = new CRC32();
    }

    @Override // org.tukaani.xz.index.IndexBase
    public void add(long unpaddedSize, long uncompressedSize) throws XZIOException {
        super.add(unpaddedSize, uncompressedSize);
        ByteBuffer buf = ByteBuffer.allocate(16);
        buf.putLong(unpaddedSize);
        buf.putLong(uncompressedSize);
        this.hash.update(buf.array());
    }

    public void validate(InputStream in) throws IOException {
        java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
        crc32.update(0);
        CheckedInputStream inChecked = new CheckedInputStream(in, crc32);
        long storedRecordCount = DecoderUtil.decodeVLI(inChecked);
        if (storedRecordCount != this.recordCount) goto L49;
        IndexHash stored = new IndexHash();
        long i = 0;
    L6:
        if (i >= this.recordCount) goto L21;
        long unpaddedSize = DecoderUtil.decodeVLI(inChecked);
        long uncompressedSize = DecoderUtil.decodeVLI(inChecked);
        stored.add(unpaddedSize, uncompressedSize);     // Catch: XZIOException -> L18
        java.util.zip.CRC32 crc33 = crc32;
        if (stored.blocksSum > this.blocksSum) goto L17;
        if (stored.uncompressedSum > this.uncompressedSum) goto L17;
        if (stored.indexListSize > this.indexListSize) goto L17;
        i = i + 1;
        crc32 = crc33;
    L17:
        throw new CorruptedInputException("XZ Index is corrupt");
    L20:
        throw new CorruptedInputException("XZ Index is corrupt");
    L21:
        java.util.zip.CRC32 crc34 = crc32;
        if (stored.blocksSum != this.blocksSum) goto L47;
        if (stored.uncompressedSum != this.uncompressedSum) goto L47;
        if (stored.indexListSize != this.indexListSize) goto L47;
        if (Arrays.equals(stored.hash.finish(), this.hash.finish()) == false) goto L47;
        DataInputStream inData = new DataInputStream(inChecked);
        int i2 = getIndexPaddingSize();
    L30:
        if (i2 <= 0) goto L36;
        if (inData.readUnsignedByte() != 0) goto L35;
        i2 = i2 - 1;
        goto L30
    L35:
        throw new CorruptedInputException("XZ Index is corrupt");
    L36:
        long value = crc34.getValue();
        int i3 = 0;
    L38:
        if (i3 >= 4) goto L45;
        if (((value >>> (i3 * 8)) & 255) != inData.readUnsignedByte()) goto L43;
        i3 = i3 + 1;
        goto L38
    L43:
        throw new CorruptedInputException("XZ Index is corrupt");
    L45:
        return;
    L47:
        throw new CorruptedInputException("XZ Index is corrupt");
    L49:
        throw new CorruptedInputException("XZ Block Header or the start of XZ Index is corrupt");
    }
}
