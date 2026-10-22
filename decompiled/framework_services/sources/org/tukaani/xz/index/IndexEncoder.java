package org.tukaani.xz.index;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import org.tukaani.xz.XZIOException;
import org.tukaani.xz.common.EncoderUtil;

/* JADX INFO: loaded from: classes3.dex */
public class IndexEncoder extends IndexBase {
    private final ArrayList<IndexRecord> records;

    @Override // org.tukaani.xz.index.IndexBase
    public /* bridge */ /* synthetic */ long getIndexSize() {
        return super.getIndexSize();
    }

    @Override // org.tukaani.xz.index.IndexBase
    public /* bridge */ /* synthetic */ long getStreamSize() {
        return super.getStreamSize();
    }

    public IndexEncoder() {
        super(new XZIOException("XZ Stream or its Index has grown too big"));
        this.records = new ArrayList();
    }

    @Override // org.tukaani.xz.index.IndexBase
    public void add(long unpaddedSize, long uncompressedSize) throws XZIOException {
        super.add(unpaddedSize, uncompressedSize);
        this.records.add(new IndexRecord(unpaddedSize, uncompressedSize));
    }

    public void encode(OutputStream out) throws IOException {
        CRC32 crc32 = new CRC32();
        CheckedOutputStream outChecked = new CheckedOutputStream(out, crc32);
        outChecked.write(0);
        EncoderUtil.encodeVLI(outChecked, this.recordCount);
        Iterator<IndexRecord> r3 = this.records.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        IndexRecord record = r3.next();
        EncoderUtil.encodeVLI(outChecked, record.unpadded);
        EncoderUtil.encodeVLI(outChecked, record.uncompressed);
        goto L4
    L6:
        int i = getIndexPaddingSize();
    L7:
        if (i <= 0) goto L9;
        outChecked.write(0);
        i = i - 1;
        goto L7
    L9:
        long value = crc32.getValue();
        int i2 = 0;
    L11:
        if (i2 >= 4) goto L14;
        out.write((byte) (value >>> (i2 * 8)));
        i2 = i2 + 1;
        goto L11
    }
}
