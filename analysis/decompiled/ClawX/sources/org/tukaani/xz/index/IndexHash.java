package org.tukaani.xz.index;

import java.io.DataInputStream;
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

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class IndexHash extends IndexBase {
    private Check hash;

    public IndexHash() {
        super(new CorruptedInputException());
        try {
            this.hash = new SHA256();
        } catch (NoSuchAlgorithmException unused) {
            this.hash = new CRC32();
        }
    }

    @Override // org.tukaani.xz.index.IndexBase
    public void add(long j4, long j8) throws XZIOException {
        super.add(j4, j8);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
        byteBufferAllocate.putLong(j4);
        byteBufferAllocate.putLong(j8);
        this.hash.update(byteBufferAllocate.array());
    }

    @Override // org.tukaani.xz.index.IndexBase
    public /* bridge */ /* synthetic */ long getIndexSize() {
        return super.getIndexSize();
    }

    @Override // org.tukaani.xz.index.IndexBase
    public /* bridge */ /* synthetic */ long getStreamSize() {
        return super.getStreamSize();
    }

    public void validate(InputStream inputStream) throws CorruptedInputException {
        java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
        crc32.update(0);
        CheckedInputStream checkedInputStream = new CheckedInputStream(inputStream, crc32);
        if (DecoderUtil.decodeVLI(checkedInputStream) != this.recordCount) {
            throw new CorruptedInputException("XZ Block Header or the start of XZ Index is corrupt");
        }
        IndexHash indexHash = new IndexHash();
        for (long j4 = 0; j4 < this.recordCount; j4++) {
            try {
                indexHash.add(DecoderUtil.decodeVLI(checkedInputStream), DecoderUtil.decodeVLI(checkedInputStream));
                if (indexHash.blocksSum > this.blocksSum || indexHash.uncompressedSum > this.uncompressedSum || indexHash.indexListSize > this.indexListSize) {
                    throw new CorruptedInputException("XZ Index is corrupt");
                }
            } catch (XZIOException unused) {
                throw new CorruptedInputException("XZ Index is corrupt");
            }
        }
        if (indexHash.blocksSum != this.blocksSum || indexHash.uncompressedSum != this.uncompressedSum || indexHash.indexListSize != this.indexListSize || !Arrays.equals(indexHash.hash.finish(), this.hash.finish())) {
            throw new CorruptedInputException("XZ Index is corrupt");
        }
        DataInputStream dataInputStream = new DataInputStream(checkedInputStream);
        for (int indexPaddingSize = getIndexPaddingSize(); indexPaddingSize > 0; indexPaddingSize--) {
            if (dataInputStream.readUnsignedByte() != 0) {
                throw new CorruptedInputException("XZ Index is corrupt");
            }
        }
        long value = crc32.getValue();
        for (int i8 = 0; i8 < 4; i8++) {
            if (((value >>> (i8 * 8)) & 255) != dataInputStream.readUnsignedByte()) {
                throw new CorruptedInputException("XZ Index is corrupt");
            }
        }
    }
}
