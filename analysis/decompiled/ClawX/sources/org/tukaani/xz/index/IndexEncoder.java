package org.tukaani.xz.index;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import org.tukaani.xz.XZIOException;
import org.tukaani.xz.common.EncoderUtil;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class IndexEncoder extends IndexBase {
    private final ArrayList<IndexRecord> records;

    public IndexEncoder() {
        super(new XZIOException("XZ Stream or its Index has grown too big"));
        this.records = new ArrayList<>();
    }

    @Override // org.tukaani.xz.index.IndexBase
    public void add(long j4, long j8) throws XZIOException {
        super.add(j4, j8);
        this.records.add(new IndexRecord(j4, j8));
    }

    public void encode(OutputStream outputStream) throws IOException {
        CRC32 crc32 = new CRC32();
        CheckedOutputStream checkedOutputStream = new CheckedOutputStream(outputStream, crc32);
        checkedOutputStream.write(0);
        EncoderUtil.encodeVLI(checkedOutputStream, this.recordCount);
        ArrayList<IndexRecord> arrayList = this.records;
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            IndexRecord indexRecord = arrayList.get(i8);
            i8++;
            IndexRecord indexRecord2 = indexRecord;
            EncoderUtil.encodeVLI(checkedOutputStream, indexRecord2.unpadded);
            EncoderUtil.encodeVLI(checkedOutputStream, indexRecord2.uncompressed);
        }
        for (int indexPaddingSize = getIndexPaddingSize(); indexPaddingSize > 0; indexPaddingSize--) {
            checkedOutputStream.write(0);
        }
        long value = crc32.getValue();
        for (int i9 = 0; i9 < 4; i9++) {
            outputStream.write((byte) (value >>> (i9 * 8)));
        }
    }

    @Override // org.tukaani.xz.index.IndexBase
    public /* bridge */ /* synthetic */ long getIndexSize() {
        return super.getIndexSize();
    }

    @Override // org.tukaani.xz.index.IndexBase
    public /* bridge */ /* synthetic */ long getStreamSize() {
        return super.getStreamSize();
    }
}
