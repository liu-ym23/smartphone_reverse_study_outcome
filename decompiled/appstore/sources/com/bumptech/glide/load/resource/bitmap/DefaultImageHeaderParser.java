package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
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

        public ByteBufferReader(ByteBuffer r10) {
            this.byteBuffer = r10;
            r10.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getByte() {
            if (this.byteBuffer.remaining() >= 1) goto L7;
            return -1;
        L7:
            return this.byteBuffer.get();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getUInt16() {
            int r10 = (getByte() << 8) & 65280;
            return (getByte() & PrivateKeyType.INVALID) | r10;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short getUInt8() {
            return (short) (getByte() & PrivateKeyType.INVALID);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] r10, int r11) {
            int r12 = Math.min(r11, this.byteBuffer.remaining());
            if (r12 != 0) goto L6;
            return -1;
        L6:
            this.byteBuffer.get(r10, 0, r12);
            return r12;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long r10) {
            int r11 = (int) Math.min(this.byteBuffer.remaining(), r10);
            ByteBuffer r12 = this.byteBuffer;
            r12.position(r12.position() + r11);
            return r11;
        }
    }

    public static final class RandomAccessReader {
        private final ByteBuffer data;

        public RandomAccessReader(byte[] r10, int r11) {
            this.data = (ByteBuffer) ByteBuffer.wrap(r10).order(ByteOrder.BIG_ENDIAN).limit(r11);
        }

        private boolean isAvailable(int r10, int r11) {
            if ((this.data.remaining() - r10) < r11) goto L5;
            return true;
        L5:
            return false;
        }

        public short getInt16(int r10) {
            if (isAvailable(r10, 2) == true) goto L7;
            return -1;
        L7:
            return this.data.getShort(r10);
        }

        public int getInt32(int r10) {
            if (isAvailable(r10, 4) == true) goto L7;
            return -1;
        L7:
            return this.data.getInt(r10);
        }

        public int length() {
            return this.data.remaining();
        }

        public void order(ByteOrder r10) {
            this.data.order(r10);
        }
    }

    public interface Reader {
        int getByte() throws IOException;

        int getUInt16() throws IOException;

        short getUInt8() throws IOException;

        int read(byte[] r10, int r11) throws IOException;

        long skip(long r10) throws IOException;
    }

    public static final class StreamReader implements Reader {
        private final InputStream is;

        public StreamReader(InputStream r10) {
            this.is = r10;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getByte() throws IOException {
            return this.is.read();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getUInt16() throws IOException {
            int r10 = (this.is.read() << 8) & 65280;
            return (this.is.read() & PrivateKeyType.INVALID) | r10;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short getUInt8() throws IOException {
            return (short) (this.is.read() & PrivateKeyType.INVALID);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] r10, int r11) throws IOException {
            int r12 = r11;
        L3:
            if (r12 <= 0) goto L8;
            int r13 = this.is.read(r10, r11 - r12, r12);
            if (r13 == (-1)) goto L8;
            r12 = r12 - r13;
        L8:
            return r11 - r12;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long r10) throws IOException {
            if (r10 >= 0) goto L5;
            return 0;
        L5:
            long r11 = r10;
        L7:
            if (r11 <= 0) goto L16;
            long r12 = this.is.skip(r11);
            if (r12 > 0) goto L10;
            if (this.is.read() == (-1)) goto L16;
            r12 = 1;
        L10:
            r11 = r11 - r12;
        L16:
            return r10 - r11;
        }
    }

    static {
        JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(Charset.forName("UTF-8"));
        BYTES_PER_FORMAT = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    }

    public DefaultImageHeaderParser() {
    }

    private static int calcTagOffset(int r10, int r11) {
        return (r10 + 2) + (r11 * 12);
    }

    private static boolean handles(int r10) {
        if ((r10 & EXIF_MAGIC_NUMBER) != EXIF_MAGIC_NUMBER) goto L5;
    L10:
        return true;
    L5:
        if (r10 == MOTOROLA_TIFF_MAGIC_NUMBER) goto L10;
        if (r10 == INTEL_TIFF_MAGIC_NUMBER) goto L10;
        return false;
    }

    private boolean hasJpegExifPreamble(byte[] r10, int r11) {
        if (r10 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == false) goto L17;
        int r13 = 0;
    L10:
        byte[] r14 = JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
        if (r13 >= r14.length) goto L17;
        if (r10[r13] != r14[r13]) goto L20;
        r13 = r13 + 1;
        goto L10
    L20:
        return false;
    L17:
        return r12;
    L5:
        if (r11 <= JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length) goto L7;
        r12 = true;
        goto L8
    }

    private int moveToExifSegmentAndGetLength(Reader r10) throws IOException {
    L2:
        short r11 = r10.getUInt8();
        if (r11 != 255) goto L5;
        short r12 = r10.getUInt8();
        if (r12 == SEGMENT_SOS) goto L10;
        if (r12 == MARKER_EOI) goto L14;
        int r13 = r10.getUInt16() - 2;
        if (r12 == EXIF_SEGMENT_TYPE) goto L25;
        long r14 = r13;
        long r15 = r10.skip(r14);
        if (r15 == r14) goto L2;
        if (Log.isLoggable(TAG, 3) == false) goto L24;
        Log.d(TAG, "Unable to skip enough data, type: " + r12 + ", wanted to skip: " + r13 + ", but actually skipped: " + r15);
    L24:
        return -1;
    L25:
        return r13;
    L14:
        if (Log.isLoggable(TAG, 3) == false) goto L16;
        Log.d(TAG, "Found MARKER_EOI in exif segment");
    L16:
        return -1;
    L10:
        return -1;
    L5:
        if (Log.isLoggable(TAG, 3) == false) goto L7;
        Log.d(TAG, "Unknown segmentId=" + r11);
    L7:
        return -1;
    }

    private int parseExifSegment(Reader r10, byte[] r11, int r12) throws IOException {
        int r13 = r10.read(r11, r12);
        if (r13 == r12) goto L9;
        if (Log.isLoggable(TAG, 3) == false) goto L7;
        Log.d(TAG, "Unable to read exif segment data, length: " + r12 + ", actually read: " + r13);
    L7:
        return -1;
    L9:
        if (hasJpegExifPreamble(r11, r12) == false) goto L13;
        return parseExifSegment(new RandomAccessReader(r11, r12));
    L13:
        if (Log.isLoggable(TAG, 3) == false) goto L15;
        Log.d(TAG, "Missing jpeg exif preamble");
    L15:
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(@NonNull InputStream r10, @NonNull ArrayPool r11) throws IOException {
        return getOrientation(new StreamReader((InputStream) Preconditions.checkNotNull(r10)), (ArrayPool) Preconditions.checkNotNull(r11));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull InputStream r10) throws IOException {
        return getType(new StreamReader((InputStream) Preconditions.checkNotNull(r10)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull ByteBuffer r10) throws IOException {
        return getType(new ByteBufferReader((ByteBuffer) Preconditions.checkNotNull(r10)));
    }

    @NonNull
    private ImageHeaderParser.ImageType getType(Reader r10) throws IOException {
        int r11 = r10.getUInt16();
        if (r11 == EXIF_MAGIC_NUMBER) goto L5;
        int r12 = ((r11 << 16) & (-65536)) | (r10.getUInt16() & SupportMenu.USER_MASK);
        if (r12 != PNG_HEADER) goto L14;
        r10.skip(21);
        if (r10.getByte() < 3) goto L12;
        return ImageHeaderParser.ImageType.PNG_A;
    L12:
        return ImageHeaderParser.ImageType.PNG;
    L14:
        if ((r12 >> 8) != GIF_HEADER) goto L18;
        return ImageHeaderParser.ImageType.GIF;
    L18:
        if (r12 != RIFF_HEADER) goto L20;
        r10.skip(4);
        if ((((r10.getUInt16() << 16) & (-65536)) | (r10.getUInt16() & SupportMenu.USER_MASK)) != WEBP_HEADER) goto L24;
        int r13 = ((r10.getUInt16() << 16) & (-65536)) | (r10.getUInt16() & SupportMenu.USER_MASK);
        if ((r13 & VP8_HEADER_MASK) != VP8_HEADER) goto L28;
        int r14 = r13 & PrivateKeyType.INVALID;
        if (r14 != 88) goto L37;
        r10.skip(4);
        if ((r10.getByte() & 16) == 0) goto L35;
        return ImageHeaderParser.ImageType.WEBP_A;
    L35:
        return ImageHeaderParser.ImageType.WEBP;
    L37:
        if (r14 != 76) goto L44;
        r10.skip(4);
        if ((r10.getByte() & 8) == 0) goto L42;
        return ImageHeaderParser.ImageType.WEBP_A;
    L42:
        return ImageHeaderParser.ImageType.WEBP;
    L44:
        return ImageHeaderParser.ImageType.WEBP;
    L28:
        return ImageHeaderParser.ImageType.UNKNOWN;
    L24:
        return ImageHeaderParser.ImageType.UNKNOWN;
    L20:
        return ImageHeaderParser.ImageType.UNKNOWN;
    L5:
        return ImageHeaderParser.ImageType.JPEG;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(@NonNull ByteBuffer r10, @NonNull ArrayPool r11) throws IOException {
        return getOrientation(new ByteBufferReader((ByteBuffer) Preconditions.checkNotNull(r10)), (ArrayPool) Preconditions.checkNotNull(r11));
    }

    private int getOrientation(Reader r10, ArrayPool r11) throws IOException {
        int r12 = r10.getUInt16();
        if (handles(r12) == false) goto L5;
        int r13 = moveToExifSegmentAndGetLength(r10);
        if (r13 == (-1)) goto L11;
        byte[] r14 = (byte[]) r11.get(r13, byte[].class);
        int r15 = parseExifSegment(r10, r14, r13);     // Catch: Throwable -> L18
        r11.put(r14);
        return r15;
    L18:
        th = move-exception;
        r11.put(r14);
        throw th;
    L11:
        if (Log.isLoggable(TAG, 3) == false) goto L13;
        Log.d(TAG, "Failed to parse exif segment length, or exif segment not found");
    L13:
        return -1;
    L5:
        if (Log.isLoggable(TAG, 3) == false) goto L7;
        Log.d(TAG, "Parser doesn't handle magic number: " + r12);
    L7:
        return -1;
    }

    private static int parseExifSegment(RandomAccessReader r12) {
        short r10 = r12.getInt16(6);
        if (r10 != INTEL_TIFF_MAGIC_NUMBER) goto L5;
        ByteOrder r11 = ByteOrder.LITTLE_ENDIAN;
    L12:
        r12.order(r11);
        int r13 = r12.getInt32(10) + 6;
        short r14 = r12.getInt16(r13);
        int r15 = 0;
    L13:
        if (r15 >= r14) goto L56;
        int r16 = calcTagOffset(r13, r15);
        short r17 = r12.getInt16(r16);
        if (r17 != ORIENTATION_TAG_TYPE) goto L55;
        short r18 = r12.getInt16(r16 + 2);
        if (r18 < 1) goto L53;
        if (r18 > 12) goto L53;
        int r19 = r12.getInt32(r16 + 4);
        if (r19 >= 0) goto L28;
        if (Log.isLoggable(TAG, 3) == false) goto L55;
        Log.d(TAG, "Negative tiff component count");
        goto L55
    L28:
        if (Log.isLoggable(TAG, 3) == false) goto L30;
        Log.d(TAG, "Got tagIndex=" + r15 + " tagType=" + r17 + " formatCode=" + r18 + " componentCount=" + r19);
    L30:
        int r20 = r19 + BYTES_PER_FORMAT[r18];
        if (r20 > 4) goto L33;
        int r21 = r16 + 8;
        if (r21 < 0) goto L50;
        if (r21 > r12.length()) goto L50;
        if (r20 < 0) goto L47;
        if ((r20 + r21) > r12.length()) goto L47;
        return r12.getInt16(r21);
    L47:
        if (Log.isLoggable(TAG, 3) == false) goto L55;
        Log.d(TAG, "Illegal number of bytes for TI tag data tagType=" + r17);
    L50:
        if (Log.isLoggable(TAG, 3) == false) goto L55;
        Log.d(TAG, "Illegal tagValueOffset=" + r21 + " tagType=" + r17);
        goto L55
    L33:
        if (Log.isLoggable(TAG, 3) == false) goto L55;
        Log.d(TAG, "Got byte count > 4, not orientation, continuing, formatCode=" + r18);
    L53:
        if (Log.isLoggable(TAG, 3) == false) goto L55;
        Log.d(TAG, "Got invalid format code = " + r18);
    L55:
        r15 = r15 + 1;
        goto L13
    L56:
        return -1;
    L5:
        if (r10 != MOTOROLA_TIFF_MAGIC_NUMBER) goto L7;
        r11 = ByteOrder.BIG_ENDIAN;
        goto L12
    L7:
        if (Log.isLoggable(TAG, 3) == false) goto L9;
        Log.d(TAG, "Unknown endianness = " + r10);
    L9:
        r11 = ByteOrder.BIG_ENDIAN;
        goto L12
    }
}
