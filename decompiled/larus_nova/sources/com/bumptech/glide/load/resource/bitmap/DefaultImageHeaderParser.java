package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.GlideLogUtil;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {
    private static final int[] BYTES_PER_FORMAT = null;
    static final int EXIF_MAGIC_NUMBER = 65496;
    static final int EXIF_SEGMENT_TYPE = 225;
    private static final int GIF_HEADER = 4671814;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    private static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = null;
    private static final int MARKER_EOI = 217;
    private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
    private static final int ORIENTATION_TAG_TYPE = 274;
    private static final int PNG_HEADER = -1991225785;
    private static final int RIFF_HEADER = 1380533830;
    private static final int SEGMENT_SOS = 218;
    static final int SEGMENT_START_ID = 255;
    private static final String TAG = "DfltImageHeaderParser";
    private static final int VP8_HEADER = 1448097792;
    private static final int VP8_HEADER_MASK = -256;
    private static final int VP8_HEADER_TYPE_EXTENDED = 88;
    private static final int VP8_HEADER_TYPE_LOSSLESS = 76;
    private static final int VP8_HEADER_TYPE_MASK = 255;
    private static final int WEBP_EXTENDED_ALPHA_FLAG = 16;
    private static final int WEBP_HEADER = 1464156752;
    private static final int WEBP_LOSSLESS_ALPHA_FLAG = 8;

    public static final class ByteBufferReader implements Reader {
        private final ByteBuffer byteBuffer;

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short getUInt8() throws Reader.EndOfFileException {
            if (this.byteBuffer.remaining() < 1) goto L7;
            return (short) (this.byteBuffer.get() & UByte.MAX_VALUE);
        L7:
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getUInt16() throws Reader.EndOfFileException {
            return (getUInt8() << 8) | getUInt8();
        }

        public ByteBufferReader(ByteBuffer r100) {
            this.byteBuffer = r100;
            r100.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long r100) {
            int r101 = (int) Math.min(this.byteBuffer.remaining(), r100);
            ByteBuffer r102 = this.byteBuffer;
            r102.position(r102.position() + r101);
            return r101;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] r100, int r101) {
            int r102 = Math.min(r101, this.byteBuffer.remaining());
            if (r102 != 0) goto L6;
            return -1;
        L6:
            this.byteBuffer.get(r100, 0, r102);
            return r102;
        }
    }

    public static final class RandomAccessReader {
        private final ByteBuffer data;

        public int length() {
            return this.data.remaining();
        }

        public short getInt16(int r100) {
            if (isAvailable(r100, 2) == true) goto L7;
            return -1;
        L7:
            return this.data.getShort(r100);
        }

        public int getInt32(int r100) {
            if (isAvailable(r100, 4) == true) goto L7;
            return -1;
        L7:
            return this.data.getInt(r100);
        }

        public void order(ByteOrder r100) {
            this.data.order(r100);
        }

        public RandomAccessReader(byte[] r100, int r101) {
            this.data = (ByteBuffer) ByteBuffer.wrap(r100).order(ByteOrder.BIG_ENDIAN).limit(r101);
        }

        private boolean isAvailable(int r100, int r101) {
            if ((this.data.remaining() - r100) < r101) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public interface Reader {

        public static final class EndOfFileException extends IOException {
            private static final long serialVersionUID = 1;

            public EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int getUInt16() throws IOException;

        short getUInt8() throws IOException;

        int read(byte[] r100, int r101) throws IOException;

        long skip(long r100) throws IOException;
    }

    public static final class StreamReader implements Reader {

        /* JADX INFO: renamed from: is, reason: collision with root package name */
        private final InputStream f33698is;

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short getUInt8() throws IOException {
            int r100 = this.f33698is.read();
            if (r100 == (-1)) goto L7;
            return (short) r100;
        L7:
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getUInt16() throws IOException {
            return (getUInt8() << 8) | getUInt8();
        }

        public StreamReader(InputStream r100) {
            this.f33698is = r100;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long r100) throws IOException {
            if (r100 >= 0) goto L5;
            return 0;
        L5:
            long r101 = r100;
        L7:
            if (r101 <= 0) goto L16;
            long r102 = this.f33698is.skip(r101);
            if (r102 > 0) goto L10;
            if (this.f33698is.read() == (-1)) goto L16;
            r102 = 1;
        L10:
            r101 = r101 - r102;
        L16:
            return r100 - r101;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] r100, int r101) throws IOException {
            int r102 = 0;
            int r103 = 0;
        L4:
            if (r102 >= r101) goto L8;
            r103 = this.f33698is.read(r100, r102, r101 - r102);
            if (r103 == (-1)) goto L8;
            r102 = r102 + r103;
        L8:
            if (r102 != 0) goto L13;
            if (r103 != (-1)) goto L13;
            throw new Reader.EndOfFileException();
        L13:
            return r102;
        }
    }

    public DefaultImageHeaderParser() {
    }

    private static int calcTagOffset(int r100, int r101) {
        return (r100 + 2) + (r101 * 12);
    }

    private static boolean handles(int r100) {
        if ((r100 & EXIF_MAGIC_NUMBER) != EXIF_MAGIC_NUMBER) goto L5;
    L10:
        return true;
    L5:
        if (r100 == MOTOROLA_TIFF_MAGIC_NUMBER) goto L10;
        if (r100 == INTEL_TIFF_MAGIC_NUMBER) goto L10;
        return false;
    }

    static {
        JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(Charset.forName("UTF-8"));
        BYTES_PER_FORMAT = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    }

    private ImageHeaderParser.ImageType getType(Reader r100) throws IOException {
        int r101 = r100.getUInt16();     // Catch: Reader.EndOfFileException -> L48
        if (r101 == EXIF_MAGIC_NUMBER) goto L5;
        int r102 = (r101 << 8) | r100.getUInt8();     // Catch: Reader.EndOfFileException -> L48
        if (r102 == GIF_HEADER) goto L9;
        int r103 = (r102 << 8) | r100.getUInt8();     // Catch: Reader.EndOfFileException -> L48
        if (r103 != PNG_HEADER) goto L21;
        r100.skip(21);     // Catch: Reader.EndOfFileException -> L48
        if (r100.getUInt8() < 3) goto L17;
        return ImageHeaderParser.ImageType.PNG_A;
    L17:
        return ImageHeaderParser.ImageType.PNG;
    L19:
        return ImageHeaderParser.ImageType.PNG;
    L21:
        if (r103 != RIFF_HEADER) goto L23;
        r100.skip(4);     // Catch: Reader.EndOfFileException -> L48
        if (((r100.getUInt16() << 16) | r100.getUInt16()) != WEBP_HEADER) goto L27;
        int r104 = (r100.getUInt16() << 16) | r100.getUInt16();     // Catch: Reader.EndOfFileException -> L48
        if ((r104 & (-256)) != VP8_HEADER) goto L31;
        int r105 = r104 & 255;     // Catch: Reader.EndOfFileException -> L48
        if (r105 != 88) goto L40;
        r100.skip(4);     // Catch: Reader.EndOfFileException -> L48
        if ((r100.getUInt8() & 16) == 0) goto L38;
        return ImageHeaderParser.ImageType.WEBP_A;
    L38:
        return ImageHeaderParser.ImageType.WEBP;
    L40:
        if (r105 != 76) goto L47;
        r100.skip(4);     // Catch: Reader.EndOfFileException -> L48
        if ((r100.getUInt8() & 8) == 0) goto L45;
        return ImageHeaderParser.ImageType.WEBP_A;
    L45:
        return ImageHeaderParser.ImageType.WEBP;
    L47:
        return ImageHeaderParser.ImageType.WEBP;
    L31:
        return ImageHeaderParser.ImageType.UNKNOWN;
    L27:
        return ImageHeaderParser.ImageType.UNKNOWN;
    L23:
        return ImageHeaderParser.ImageType.UNKNOWN;
    L9:
        return ImageHeaderParser.ImageType.GIF;
    L5:
        return ImageHeaderParser.ImageType.JPEG;
    L49:
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    private int moveToExifSegmentAndGetLength(Reader r110) throws IOException {
    L2:
        short r100 = r110.getUInt8();
        if (r100 != 255) goto L4;
        short r101 = r110.getUInt8();
        if (r101 == 218) goto L8;
        if (r101 == 217) goto L11;
        int r102 = r110.getUInt16() - 2;
        if (r101 == 225) goto L19;
        long r103 = r102;
        long r104 = r110.skip(r103);
        if (r104 == r103) goto L2;
        GlideLogUtil.d(TAG, "Unable to skip enough data, type: " + r101 + ", wanted to skip: " + r102 + ", but actually skipped: " + r104);
        return -1;
    L19:
        return r102;
    L11:
        GlideLogUtil.d(TAG, "Found MARKER_EOI in exif segment");
        return -1;
    L8:
        return -1;
    L4:
        GlideLogUtil.d(TAG, "Unknown segmentId=" + r100);
        return -1;
    }

    private static int parseExifSegment(RandomAccessReader r110) {
        short r100 = r110.getInt16(6);
        if (r100 != INTEL_TIFF_MAGIC_NUMBER) goto L5;
        ByteOrder r101 = ByteOrder.LITTLE_ENDIAN;
    L9:
        r110.order(r101);
        int r102 = r110.getInt32(10) + 6;
        short r103 = r110.getInt16(r102);
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L40;
        int r105 = calcTagOffset(r102, r104);
        short r106 = r110.getInt16(r105);
        if (r106 != 274) goto L39;
        short r107 = r110.getInt16(r105 + 2);
        if (r107 >= 1) goto L17;
    L38:
        GlideLogUtil.d(TAG, "Got invalid format code = " + r107);
        goto L39
    L17:
        if (r107 > 12) goto L38;
        int r108 = r110.getInt32(r105 + 4);
        if (r108 >= 0) goto L22;
        GlideLogUtil.d(TAG, "Negative tiff component count");
        goto L39
    L22:
        GlideLogUtil.d(TAG, "Got tagIndex=" + r104 + " tagType=" + r106 + " formatCode=" + r107 + " componentCount=" + r108);
        int r109 = r108 + BYTES_PER_FORMAT[r107];
        if (r109 <= 4) goto L25;
        GlideLogUtil.d(TAG, "Got byte count > 4, not orientation, continuing, formatCode=" + r107);
        goto L39
    L25:
        int r111 = r105 + 8;
        if (r111 >= 0) goto L28;
    L37:
        GlideLogUtil.d(TAG, "Illegal tagValueOffset=" + r111 + " tagType=" + r106);
        goto L39
    L28:
        if (r111 > r110.length()) goto L37;
        if (r109 >= 0) goto L32;
    L36:
        GlideLogUtil.d(TAG, "Illegal number of bytes for TI tag data tagType=" + r106);
        goto L39
    L32:
        if ((r109 + r111) > r110.length()) goto L36;
        return r110.getInt16(r111);
    L39:
        r104 = r104 + 1;
        goto L10
    L40:
        return -1;
    L5:
        if (r100 == MOTOROLA_TIFF_MAGIC_NUMBER) goto L7;
        GlideLogUtil.d(TAG, "Unknown endianness = " + r100);
        r101 = ByteOrder.BIG_ENDIAN;
        goto L9
    L7:
        r101 = ByteOrder.BIG_ENDIAN;
        goto L9
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(InputStream r100) throws IOException {
        return getType(new StreamReader((InputStream) Preconditions.checkNotNull(r100)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(ByteBuffer r100) throws IOException {
        return getType(new ByteBufferReader((ByteBuffer) Preconditions.checkNotNull(r100)));
    }

    private int getOrientation(Reader r100, ArrayPool r101) throws IOException {
        int r102 = r100.getUInt16();     // Catch: Reader.EndOfFileException -> L19
        if (handles(r102) == true) goto L8;
        GlideLogUtil.d(TAG, "Parser doesn't handle magic number: " + r102);     // Catch: Reader.EndOfFileException -> L19
        return -1;
    L8:
        int r103 = moveToExifSegmentAndGetLength(r100);     // Catch: Reader.EndOfFileException -> L19
        if (r103 != (-1)) goto L12;
        GlideLogUtil.d(TAG, "Failed to parse exif segment length, or exif segment not found");     // Catch: Reader.EndOfFileException -> L19
        return -1;
    L12:
        byte[] r104 = (byte[]) r101.get(r103, byte[].class);     // Catch: Reader.EndOfFileException -> L19
        int r105 = parseExifSegment(r100, r104, r103);     // Catch: Throwable -> L16
        r101.put(r104);     // Catch: Reader.EndOfFileException -> L19
        return r105;
    L16:
        th = move-exception;
        r101.put(r104);     // Catch: Reader.EndOfFileException -> L19
        throw th;     // Catch: Reader.EndOfFileException -> L19
    L19:
        return -1;
    }

    private boolean hasJpegExifPreamble(byte[] r100, int r101) {
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L17;
        int r103 = 0;
    L10:
        byte[] r104 = JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
        if (r103 >= r104.length) goto L17;
        if (r100[r103] != r104[r103]) goto L20;
        r103 = r103 + 1;
        goto L10
    L20:
        return false;
    L17:
        return r102;
    L5:
        if (r101 <= JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(InputStream r100, ArrayPool r101) throws IOException {
        return getOrientation(new StreamReader((InputStream) Preconditions.checkNotNull(r100)), (ArrayPool) Preconditions.checkNotNull(r101));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(ByteBuffer r100, ArrayPool r101) throws IOException {
        return getOrientation(new ByteBufferReader((ByteBuffer) Preconditions.checkNotNull(r100)), (ArrayPool) Preconditions.checkNotNull(r101));
    }

    private int parseExifSegment(Reader r100, byte[] r101, int r102) throws IOException {
        int r103 = r100.read(r101, r102);
        if (r103 == r102) goto L7;
        GlideLogUtil.i(TAG, "Unable to read exif segment data, length: " + r102 + ", actually read: " + r103);
        return -1;
    L7:
        if (hasJpegExifPreamble(r101, r102) == true) goto L9;
        GlideLogUtil.d(TAG, "Missing jpeg exif preamble");
        return -1;
    L9:
        return parseExifSegment(new RandomAccessReader(r101, r102));
    }
}
