package androidx.emoji2.text;

import android.content.res.AssetManager;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
class MetadataListReader {
    private static final int EMJI_TAG = 1164798569;
    private static final int EMJI_TAG_DEPRECATED = 1701669481;
    private static final int META_TABLE_NAME = 1835365473;

    public static class ByteBufferReader implements OpenTypeReader {
        private final ByteBuffer mByteBuffer;

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long getPosition() {
            return this.mByteBuffer.position();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readTag() throws IOException {
            return this.mByteBuffer.getInt();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long readUnsignedInt() throws IOException {
            return MetadataListReader.toUnsignedInt(this.mByteBuffer.getInt());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readUnsignedShort() throws IOException {
            return MetadataListReader.toUnsignedShort(this.mByteBuffer.getShort());
        }

        public ByteBufferReader(ByteBuffer r100) {
            this.mByteBuffer = r100;
            r100.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public void skip(int r100) throws IOException {
            ByteBuffer r101 = this.mByteBuffer;
            r101.position(r101.position() + r100);
        }
    }

    public static class InputStreamOpenTypeReader implements OpenTypeReader {
        private final byte[] mByteArray;
        private final ByteBuffer mByteBuffer;
        private final InputStream mInputStream;
        private long mPosition;

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readTag() throws IOException {
            this.mByteBuffer.position(0);
            read(4);
            return this.mByteBuffer.getInt();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long readUnsignedInt() throws IOException {
            this.mByteBuffer.position(0);
            read(4);
            return MetadataListReader.toUnsignedInt(this.mByteBuffer.getInt());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readUnsignedShort() throws IOException {
            this.mByteBuffer.position(0);
            read(2);
            return MetadataListReader.toUnsignedShort(this.mByteBuffer.getShort());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long getPosition() {
            return this.mPosition;
        }

        public InputStreamOpenTypeReader(InputStream r100) {
            this.mPosition = 0;
            this.mInputStream = r100;
            byte[] r101 = new byte[4];
            this.mByteArray = r101;
            ByteBuffer r102 = ByteBuffer.wrap(r101);
            this.mByteBuffer = r102;
            r102.order(ByteOrder.BIG_ENDIAN);
        }

        private void read(int r100) throws IOException {
            if (this.mInputStream.read(this.mByteArray, 0, r100) != r100) goto L7;
            this.mPosition += (long) r100;
            return;
        L7:
            throw new IOException("read failed");
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public void skip(int r100) throws IOException {
        L2:
            if (r100 <= 0) goto L8;
            int r101 = (int) this.mInputStream.skip(r100);
            if (r101 < 1) goto L7;
            r100 = r100 - r101;
            this.mPosition += (long) r101;
            goto L2
        L7:
            throw new IOException("Skip didn't move at least 1 byte forward");
        }
    }

    public static class OffsetInfo {
        private final long mLength;
        private final long mStartOffset;

        public long getLength() {
            return this.mLength;
        }

        public long getStartOffset() {
            return this.mStartOffset;
        }

        public OffsetInfo(long r100, long r101) {
            this.mStartOffset = r100;
            this.mLength = r101;
        }
    }

    public interface OpenTypeReader {
        public static final int UINT16_BYTE_COUNT = 2;
        public static final int UINT32_BYTE_COUNT = 4;

        long getPosition();

        int readTag() throws IOException;

        long readUnsignedInt() throws IOException;

        int readUnsignedShort() throws IOException;

        void skip(int r100) throws IOException;
    }

    public static long toUnsignedInt(int r100) {
        return ((long) r100) & BodyPartID.bodyIdMax;
    }

    public static int toUnsignedShort(short r100) {
        return r100 & 65535;
    }

    private MetadataListReader() {
    }

    private static OffsetInfo findOffsetInfo(OpenTypeReader r110) throws IOException {
        r110.skip(4);
        int r100 = r110.readUnsignedShort();
        if (r100 > 100) goto L28;
        r110.skip(6);
        int r101 = 0;
        int r102 = 0;
    L6:
        if (r102 >= r100) goto L11;
        int r103 = r110.readTag();
        r110.skip(4);
        long r104 = r110.readUnsignedInt();
        r110.skip(4);
        if (META_TABLE_NAME == r103) goto L13;
        r102 = r102 + 1;
    L13:
        if (r104 == (-1)) goto L26;
        r110.skip((int) (r104 - r110.getPosition()));
        r110.skip(12);
        long r105 = r110.readUnsignedInt();
    L16:
        if (r101 >= r105) goto L26;
        int r106 = r110.readTag();
        long r107 = r110.readUnsignedInt();
        long r111 = r110.readUnsignedInt();
        if (EMJI_TAG == r106) goto L24;
        if (EMJI_TAG_DEPRECATED == r106) goto L24;
        r101 = r101 + 1;
    L24:
        return new OffsetInfo(r107 + r104, r111);
    L26:
        throw new IOException("Cannot read metadata.");
    L11:
        r104 = -1;
        goto L13
    L28:
        throw new IOException("Cannot read metadata.");
    }

    public static MetadataList read(InputStream r100) throws IOException {
        InputStreamOpenTypeReader r101 = new InputStreamOpenTypeReader(r100);
        OffsetInfo r102 = findOffsetInfo(r101);
        r101.skip((int) (r102.getStartOffset() - r101.getPosition()));
        ByteBuffer r103 = ByteBuffer.allocate((int) r102.getLength());
        int r104 = r100.read(r103.array());
        if (r104 != r102.getLength()) goto L7;
        return MetadataList.getRootAsMetadataList(r103);
    L7:
        throw new IOException("Needed " + r102.getLength() + " bytes, got " + r104);
    }

    public static MetadataList read(ByteBuffer r100) throws IOException {
        ByteBuffer r101 = r100.duplicate();
        r101.position((int) findOffsetInfo(new ByteBufferReader(r101)).getStartOffset());
        return MetadataList.getRootAsMetadataList(r101);
    }

    public static MetadataList read(AssetManager r100, String r101) throws IOException {
        InputStream r102 = r100.open(r101);
        MetadataList r103 = read(r102);     // Catch: Throwable -> L7
        if (r102 == null) goto L6;
        r102.close();
    L6:
        return r103;
    L7:
        th = move-exception;
        if (r102 != null) goto L14;
    L13:
        throw th;
    L14:
        r102.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }
}
