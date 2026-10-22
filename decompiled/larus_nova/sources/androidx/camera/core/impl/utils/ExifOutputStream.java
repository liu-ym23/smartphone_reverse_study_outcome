package androidx.camera.core.impl.utils;

import androidx.core.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.BufferedOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ExifOutputStream extends FilterOutputStream {
    private static final short BYTE_ALIGN_II = 18761;
    private static final short BYTE_ALIGN_MM = 19789;
    private static final boolean DEBUG = false;
    private static final byte[] IDENTIFIER_EXIF_APP1 = null;
    private static final int IFD_OFFSET = 8;
    private static final byte START_CODE = 42;
    private static final int STATE_FRAME_HEADER = 1;
    private static final int STATE_JPEG_DATA = 2;
    private static final int STATE_SOI = 0;
    private static final int STREAMBUFFER_SIZE = 65536;
    private static final String TAG = "ExifOutputStream";
    private final ByteBuffer mBuffer;
    private int mByteToCopy;
    private int mByteToSkip;
    private final ExifData mExifData;
    private final byte[] mSingleByteArray;
    private int mState;

    public static final class JpegHeader {
        public static final short APP1 = -31;
        public static final short DAC = -52;
        public static final short DHT = -60;
        public static final short EOI = -39;
        public static final short JPG = -56;
        public static final short SOF0 = -64;
        public static final short SOF15 = -49;
        public static final short SOI = -40;

        private JpegHeader() {
        }

        public static boolean isSofMarker(short r100) {
            if (r100 >= (-64)) goto L5;
        L13:
            return false;
        L5:
            if (r100 > (-49)) goto L13;
            if (r100 == (-60)) goto L13;
            if (r100 == (-56)) goto L13;
            if (r100 == (-52)) goto L13;
            return true;
        }
    }

    static {
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(ExifAttribute.ASCII);
    }

    private void writeExifSegment(ByteOrderedDataOutputStream r110) throws IOException {
        ExifTag[][] r100 = ExifData.EXIF_TAGS;
        int[] r101 = new int[r100.length];
        int[] r102 = new int[r100.length];
        ExifTag[] r103 = ExifData.EXIF_POINTER_TAGS;
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L10;
        ExifTag r106 = r103[r105];
        int r107 = 0;
    L6:
        if (r107 >= ExifData.EXIF_TAGS.length) goto L8;
        this.mExifData.getAttributes(r107).remove(r106.name);
        r107 = r107 + 1;
        goto L6
    L8:
        r105 = r105 + 1;
        goto L3
    L10:
        if (this.mExifData.getAttributes(1).isEmpty() == true) goto L13;
        this.mExifData.getAttributes(0).put(ExifData.EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(0, this.mExifData.getByteOrder()));
    L13:
        if (this.mExifData.getAttributes(2).isEmpty() == true) goto L16;
        this.mExifData.getAttributes(0).put(ExifData.EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(0, this.mExifData.getByteOrder()));
    L16:
        if (this.mExifData.getAttributes(3).isEmpty() == true) goto L18;
        this.mExifData.getAttributes(1).put(ExifData.EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(0, this.mExifData.getByteOrder()));
    L18:
        int r108 = 0;
    L20:
        if (r108 >= ExifData.EXIF_TAGS.length) goto L28;
        Iterator<Map.Entry<String, ExifAttribute>> r109 = this.mExifData.getAttributes(r108).entrySet().iterator();
        int r111 = 0;
    L23:
        if (r109.hasNext() == false) goto L27;
        int r112 = r109.next().getValue().size();
        if (r112 <= 4) goto L23;
        r111 = r111 + r112;
        goto L23
    L27:
        r102[r108] = r102[r108] + r111;
        r108 = r108 + 1;
        goto L20
    L28:
        int r113 = 0;
        int r114 = 8;
    L30:
        if (r113 >= ExifData.EXIF_TAGS.length) goto L35;
        if (this.mExifData.getAttributes(r113).isEmpty() == true) goto L34;
        r101[r113] = r114;
        r114 = r114 + ((((this.mExifData.getAttributes(r113).size() * 12) + 2) + 4) + r102[r113]);
    L34:
        r113 = r113 + 1;
        goto L30
    L35:
        int r115 = r114 + 8;
        if (this.mExifData.getAttributes(1).isEmpty() == true) goto L39;
        this.mExifData.getAttributes(0).put(ExifData.EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(r101[1], this.mExifData.getByteOrder()));
    L39:
        if (this.mExifData.getAttributes(2).isEmpty() == true) goto L42;
        this.mExifData.getAttributes(0).put(ExifData.EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(r101[2], this.mExifData.getByteOrder()));
    L42:
        if (this.mExifData.getAttributes(3).isEmpty() == true) goto L44;
        this.mExifData.getAttributes(1).put(ExifData.EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(r101[3], this.mExifData.getByteOrder()));
    L44:
        r110.writeUnsignedShort(r115);
        r110.write(IDENTIFIER_EXIF_APP1);
        if (this.mExifData.getByteOrder() != ByteOrder.BIG_ENDIAN) goto L47;
        short r116 = BYTE_ALIGN_MM;
    L48:
        r110.writeShort(r116);
        r110.setByteOrder(this.mExifData.getByteOrder());
        r110.writeUnsignedShort(42);
        r110.writeUnsignedInt(8);
        int r117 = 0;
    L50:
        if (r117 >= ExifData.EXIF_TAGS.length) goto L70;
        if (this.mExifData.getAttributes(r117).isEmpty() == true) goto L69;
        r110.writeUnsignedShort(this.mExifData.getAttributes(r117).size());
        int r118 = ((r101[r117] + 2) + (this.mExifData.getAttributes(r117).size() * 12)) + 4;
        Iterator<Map.Entry<String, ExifAttribute>> r119 = this.mExifData.getAttributes(r117).entrySet().iterator();
    L55:
        if (r119.hasNext() == false) goto L63;
        Map.Entry<String, ExifAttribute> r120 = r119.next();
        int r121 = ((ExifTag) Preconditions.checkNotNull((ExifTag) ((HashMap) ListProtector.get(ExifData.Builder.sExifTagMapsForWriting, r117)).get(r120.getKey()), "Tag not supported: " + r120.getKey() + ". Tag needs to be ported from ExifInterface to ExifData.")).number;
        ExifAttribute r122 = r120.getValue();
        int r123 = r122.size();
        r110.writeUnsignedShort(r121);
        r110.writeUnsignedShort(r122.format);
        r110.writeInt(r122.numberOfComponents);
        if (r123 > 4) goto L58;
        r110.write(r122.bytes);
        if (r123 >= 4) goto L55;
    L61:
        if (r123 >= 4) goto L55;
        r110.writeByte(0);
        r123 = r123 + 1;
        goto L61
    L58:
        r110.writeUnsignedInt(r118);
        r118 = r118 + r123;
        goto L55
    L63:
        r110.writeUnsignedInt(0);
        Iterator<Map.Entry<String, ExifAttribute>> r124 = this.mExifData.getAttributes(r117).entrySet().iterator();
    L65:
        if (r124.hasNext() == false) goto L69;
        byte[] r125 = r124.next().getValue().bytes;
        if (r125.length <= 4) goto L65;
        r110.write(r125, 0, r125.length);
    L69:
        r117 = r117 + 1;
        goto L50
    L70:
        r110.setByteOrder(ByteOrder.BIG_ENDIAN);
        return;
    L47:
        r116 = BYTE_ALIGN_II;
        goto L48
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r100) throws IOException {
        byte[] r101 = this.mSingleByteArray;
        r101[0] = (byte) (r100 & 255);
        write(r101);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r100) throws IOException {
        write(r100, 0, r100.length);
    }

    public ExifOutputStream(OutputStream r100, ExifData r101) {
        super(new BufferedOutputStream(r100, 65536));
        this.mSingleByteArray = new byte[1];
        this.mBuffer = ByteBuffer.allocate(4);
        this.mState = 0;
        this.mExifData = r101;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r100, int r101, int r102) throws IOException {
    L2:
        int r103 = this.mByteToSkip;
        if (r103 <= 0) goto L5;
    L8:
        if (r102 <= 0) goto L44;
        if (r103 <= 0) goto L11;
        int r104 = Math.min(r102, r103);
        r102 = r102 - r104;
        this.mByteToSkip -= r104;
        r101 = r101 + r104;
    L11:
        int r105 = this.mByteToCopy;
        if (r105 <= 0) goto L14;
        int r106 = Math.min(r102, r105);
        ((FilterOutputStream) this).out.write(r100, r101, r106);
        r102 = r102 - r106;
        this.mByteToCopy -= r106;
        r101 = r101 + r106;
    L14:
        if (r102 == 0) goto L15;
        int r107 = this.mState;
        if (r107 != 0) goto L18;
        int r108 = requestByteToBuffer(2, r100, r101, r102);
        r101 = r101 + r108;
        r102 = r102 - r108;
        if (this.mBuffer.position() < 2) goto L38;
        this.mBuffer.rewind();
        if (this.mBuffer.getShort() != (-40)) goto L43;
        ((FilterOutputStream) this).out.write(this.mBuffer.array(), 0, 2);
        this.mState = 1;
        this.mBuffer.rewind();
        ByteOrderedDataOutputStream r109 = new ByteOrderedDataOutputStream(((FilterOutputStream) this).out, ByteOrder.BIG_ENDIAN);
        r109.writeShort(-31);
        writeExifSegment(r109);
        goto L2
    L43:
        throw new IOException("Not a valid jpeg image, cannot write exif");
    L38:
        return;
    L18:
        if (r107 != 1) goto L2;
        int r110 = requestByteToBuffer(4, r100, r101, r102);
        r101 = r101 + r110;
        r102 = r102 - r110;
        if (this.mBuffer.position() != 2) goto L26;
        if (this.mBuffer.getShort() != (-39)) goto L26;
        ((FilterOutputStream) this).out.write(this.mBuffer.array(), 0, 2);
        this.mBuffer.rewind();
    L26:
        if (this.mBuffer.position() < 4) goto L27;
        this.mBuffer.rewind();
        short r111 = this.mBuffer.getShort();
        if (r111 != (-31)) goto L32;
        this.mByteToSkip = (this.mBuffer.getShort() & 65535) - 2;
        this.mState = 2;
    L35:
        this.mBuffer.rewind();
        goto L2
    L32:
        if (JpegHeader.isSofMarker(r111) == true) goto L34;
        ((FilterOutputStream) this).out.write(this.mBuffer.array(), 0, 4);
        this.mByteToCopy = (this.mBuffer.getShort() & 65535) - 2;
        goto L35
    L34:
        ((FilterOutputStream) this).out.write(this.mBuffer.array(), 0, 4);
        this.mState = 2;
        goto L35
    L27:
        return;
    L15:
        return;
    L44:
        if (r102 <= 0) goto L60;
        ((FilterOutputStream) this).out.write(r100, r101, r102);
        return;
    L60:
        return;
    L5:
        if (this.mByteToCopy > 0) goto L8;
        if (this.mState == 2) goto L44;
        goto L8
    }

    private int requestByteToBuffer(int r100, byte[] r101, int r102, int r103) {
        int r104 = Math.min(r103, r100 - this.mBuffer.position());
        this.mBuffer.put(r101, r102, r104);
        return r104;
    }
}
