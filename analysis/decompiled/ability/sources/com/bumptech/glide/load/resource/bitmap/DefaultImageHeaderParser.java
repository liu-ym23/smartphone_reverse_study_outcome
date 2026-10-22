package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {
    static final int APP2_SEGMENT_TYPE = 226;
    private static final int AVIF_BRAND = 1635150182;
    private static final int AVIS_BRAND = 1635150195;
    static final int EXIF_MAGIC_NUMBER = 65496;
    static final int EXIF_SEGMENT_TYPE = 225;
    private static final int FTYP_HEADER = 1718909296;
    private static final int GIF_HEADER = 4671814;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
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
    private static final int WEBP_EXTENDED_ANIMATION_FLAG = 2;
    private static final int WEBP_HEADER = 1464156752;
    private static final int WEBP_LOSSLESS_ALPHA_FLAG = 8;
    private static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(Charset.forName("UTF-8"));
    private static final String JPEG_MPF_SEGMENT_PREAMBLE = "MPF";
    static final byte[] JPEG_MPF_SEGMENT_PREAMBLE_BYTES = JPEG_MPF_SEGMENT_PREAMBLE.getBytes(Charset.forName("UTF-8"));
    private static final int[] BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public static final class ByteBufferReader implements Reader {
        private final ByteBuffer byteBuffer;

        public ByteBufferReader(ByteBuffer byteBuffer) {
            this.byteBuffer = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getUInt16() throws Reader.EndOfFileException {
            return getUInt8() | (getUInt8() << 8);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short getUInt8() throws Reader.EndOfFileException {
            if (this.byteBuffer.remaining() >= 1) {
                return (short) (this.byteBuffer.get() & 255);
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] bArr, int i) {
            int iMin = Math.min(i, this.byteBuffer.remaining());
            if (iMin == 0) {
                return -1;
            }
            this.byteBuffer.get(bArr, 0, iMin);
            return iMin;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j5) {
            int iMin = (int) Math.min(this.byteBuffer.remaining(), j5);
            ByteBuffer byteBuffer = this.byteBuffer;
            byteBuffer.position(byteBuffer.position() + iMin);
            return iMin;
        }
    }

    public static final class RandomAccessReader {
        private final ByteBuffer data;

        public RandomAccessReader(byte[] bArr, int i) {
            this.data = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        private boolean isAvailable(int i, int i6) {
            return this.data.remaining() - i >= i6;
        }

        public short getInt16(int i) {
            if (isAvailable(i, 2)) {
                return this.data.getShort(i);
            }
            return (short) -1;
        }

        public int getInt32(int i) {
            if (isAvailable(i, 4)) {
                return this.data.getInt(i);
            }
            return -1;
        }

        public int length() {
            return this.data.remaining();
        }

        public void order(ByteOrder byteOrder) {
            this.data.order(byteOrder);
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

        int read(byte[] bArr, int i) throws IOException;

        long skip(long j5) throws IOException;
    }

    public static final class StreamReader implements Reader {
        private final InputStream is;

        public StreamReader(InputStream inputStream) {
            this.is = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getUInt16() throws IOException {
            return getUInt8() | (getUInt8() << 8);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short getUInt8() throws IOException {
            int i = this.is.read();
            if (i != -1) {
                return (short) i;
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] bArr, int i) throws IOException {
            int i6 = 0;
            int i10 = 0;
            while (i6 < i && (i10 = this.is.read(bArr, i6, i - i6)) != -1) {
                i6 += i10;
            }
            if (i6 == 0 && i10 == -1) {
                throw new Reader.EndOfFileException();
            }
            return i6;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j5) throws IOException {
            if (j5 < 0) {
                return 0L;
            }
            long j6 = j5;
            while (j6 > 0) {
                long jSkip = this.is.skip(j6);
                if (jSkip <= 0) {
                    if (this.is.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j6 -= jSkip;
            }
            return j5 - j6;
        }
    }

    private static int calcTagOffset(int i, int i6) {
        return (i6 * 12) + i + 2;
    }

    private static boolean handles(int i) {
        return (i & EXIF_MAGIC_NUMBER) == EXIF_MAGIC_NUMBER || i == MOTOROLA_TIFF_MAGIC_NUMBER || i == INTEL_TIFF_MAGIC_NUMBER;
    }

    private boolean hasJpegExifPreamble(byte[] bArr, int i) {
        return hasMatchingBytes(bArr, i, JPEG_EXIF_SEGMENT_PREAMBLE_BYTES);
    }

    private boolean hasJpegMpfPreamble(Reader reader, byte[] bArr, int i) throws IOException {
        int i6 = reader.read(bArr, i);
        if (i6 == i) {
            return hasMatchingBytes(bArr, i, JPEG_MPF_SEGMENT_PREAMBLE_BYTES);
        }
        if (!Log.isLoggable(TAG, 3)) {
            return false;
        }
        Log.d(TAG, "Unable to read APP2 segment data, length: " + i + ", actually read: " + i6);
        return false;
    }

    private boolean hasMatchingBytes(byte[] bArr, int i, byte[] bArr2) {
        boolean z10 = (bArr == null || bArr2 == null || i <= bArr2.length) ? false : true;
        if (z10) {
            for (int i6 = 0; i6 < bArr2.length; i6++) {
                if (bArr[i6] != bArr2[i6]) {
                    return false;
                }
            }
        }
        return z10;
    }

    private int moveToApp2SegmentAndGetLength(Reader reader) throws IOException {
        return moveToSegmentAndGetLength(reader, APP2_SEGMENT_TYPE);
    }

    private int moveToExifSegmentAndGetLength(Reader reader) throws IOException {
        return moveToSegmentAndGetLength(reader, EXIF_SEGMENT_TYPE);
    }

    private int moveToSegmentAndGetLength(Reader reader, int i) throws IOException {
        short uInt8;
        int uInt16;
        long j5;
        long jSkip;
        do {
            short uInt82 = reader.getUInt8();
            if (uInt82 != 255) {
                if (Log.isLoggable(TAG, 3)) {
                    androidx.constraintlayout.core.dsl.a.p(uInt82, "Unknown segmentId=", TAG);
                }
                return -1;
            }
            uInt8 = reader.getUInt8();
            if (uInt8 == SEGMENT_SOS) {
                return -1;
            }
            if (uInt8 == MARKER_EOI) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Found MARKER_EOI in " + i + " segment");
                }
                return -1;
            }
            uInt16 = reader.getUInt16() - 2;
            if (uInt8 == i) {
                return uInt16;
            }
            j5 = uInt16;
            jSkip = reader.skip(j5);
        } while (jSkip == j5);
        if (Log.isLoggable(TAG, 3)) {
            StringBuilder sbS = androidx.appfunctions.metadata.a.s(uInt8, "Unable to skip enough data, type: ", uInt16, ", wanted to skip: ", ", but actually skipped: ");
            sbS.append(jSkip);
            Log.d(TAG, sbS.toString());
        }
        return -1;
    }

    private int parseExifSegment(Reader reader, byte[] bArr, int i) throws IOException {
        int i6 = reader.read(bArr, i);
        if (i6 == i) {
            if (hasJpegExifPreamble(bArr, i)) {
                return parseExifSegment(new RandomAccessReader(bArr, i));
            }
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Missing jpeg exif preamble");
            }
            return -1;
        }
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "Unable to read exif segment data, length: " + i + ", actually read: " + i6);
        }
        return -1;
    }

    private ImageHeaderParser.ImageType sniffAvif(Reader reader, int i) throws IOException {
        if (((reader.getUInt16() << 16) | reader.getUInt16()) != FTYP_HEADER) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int uInt16 = (reader.getUInt16() << 16) | reader.getUInt16();
        if (uInt16 == AVIS_BRAND) {
            return ImageHeaderParser.ImageType.ANIMATED_AVIF;
        }
        int i6 = 0;
        boolean z10 = uInt16 == AVIF_BRAND;
        reader.skip(4L);
        int i10 = i - 16;
        if (i10 % 4 == 0) {
            while (i6 < 5 && i10 > 0) {
                int uInt162 = (reader.getUInt16() << 16) | reader.getUInt16();
                if (uInt162 == AVIS_BRAND) {
                    return ImageHeaderParser.ImageType.ANIMATED_AVIF;
                }
                if (uInt162 == AVIF_BRAND) {
                    z10 = true;
                }
                i6++;
                i10 -= 4;
            }
        }
        return z10 ? ImageHeaderParser.ImageType.AVIF : ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        return getOrientation(new StreamReader((InputStream) Preconditions.checkNotNull(inputStream)), (ArrayPool) Preconditions.checkNotNull(arrayPool));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull InputStream inputStream) throws IOException {
        return getType(new StreamReader((InputStream) Preconditions.checkNotNull(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public boolean hasJpegMpf(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException {
        return hasJpegMpf(new StreamReader((InputStream) Preconditions.checkNotNull(inputStream)), (ArrayPool) Preconditions.checkNotNull(arrayPool));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull ByteBuffer byteBuffer) throws IOException {
        return getType(new ByteBufferReader((ByteBuffer) Preconditions.checkNotNull(byteBuffer)));
    }

    @NonNull
    private ImageHeaderParser.ImageType getType(Reader reader) throws IOException {
        try {
            int uInt16 = reader.getUInt16();
            if (uInt16 == EXIF_MAGIC_NUMBER) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int uInt8 = (uInt16 << 8) | reader.getUInt8();
            if (uInt8 == GIF_HEADER) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int uInt82 = (uInt8 << 8) | reader.getUInt8();
            if (uInt82 == PNG_HEADER) {
                reader.skip(21L);
                try {
                    return reader.getUInt8() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (Reader.EndOfFileException unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (uInt82 != RIFF_HEADER) {
                return sniffAvif(reader, uInt82);
            }
            reader.skip(4L);
            if (((reader.getUInt16() << 16) | reader.getUInt16()) != WEBP_HEADER) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int uInt162 = (reader.getUInt16() << 16) | reader.getUInt16();
            if ((uInt162 & (-256)) != VP8_HEADER) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i = uInt162 & 255;
            if (i != VP8_HEADER_TYPE_EXTENDED) {
                if (i == VP8_HEADER_TYPE_LOSSLESS) {
                    reader.skip(4L);
                    return (reader.getUInt8() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
                }
                return ImageHeaderParser.ImageType.WEBP;
            }
            reader.skip(4L);
            short uInt83 = reader.getUInt8();
            if ((uInt83 & 2) != 0) {
                return ImageHeaderParser.ImageType.ANIMATED_WEBP;
            }
            if ((uInt83 & 16) != 0) {
                return ImageHeaderParser.ImageType.WEBP_A;
            }
            return ImageHeaderParser.ImageType.WEBP;
        } catch (Reader.EndOfFileException unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(@NonNull ByteBuffer byteBuffer, @NonNull ArrayPool arrayPool) throws IOException {
        return getOrientation(new ByteBufferReader((ByteBuffer) Preconditions.checkNotNull(byteBuffer)), (ArrayPool) Preconditions.checkNotNull(arrayPool));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public boolean hasJpegMpf(@NonNull ByteBuffer byteBuffer, @NonNull ArrayPool arrayPool) throws IOException {
        return hasJpegMpf(new ByteBufferReader((ByteBuffer) Preconditions.checkNotNull(byteBuffer)), (ArrayPool) Preconditions.checkNotNull(arrayPool));
    }

    private int getOrientation(Reader reader, ArrayPool arrayPool) throws IOException {
        try {
            int uInt16 = reader.getUInt16();
            if (!handles(uInt16)) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Parser doesn't handle magic number: " + uInt16);
                }
                return -1;
            }
            int iMoveToExifSegmentAndGetLength = moveToExifSegmentAndGetLength(reader);
            if (iMoveToExifSegmentAndGetLength == -1) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) arrayPool.get(iMoveToExifSegmentAndGetLength, byte[].class);
            try {
                return parseExifSegment(reader, bArr, iMoveToExifSegmentAndGetLength);
            } finally {
                arrayPool.put(bArr);
            }
        } catch (Reader.EndOfFileException unused) {
            return -1;
        }
    }

    private boolean hasJpegMpf(@NonNull Reader reader, @NonNull ArrayPool arrayPool) throws IOException {
        if (getType(reader) != ImageHeaderParser.ImageType.JPEG) {
            return false;
        }
        int iMoveToApp2SegmentAndGetLength = moveToApp2SegmentAndGetLength(reader);
        while (iMoveToApp2SegmentAndGetLength > 0) {
            byte[] bArr = (byte[]) arrayPool.get(iMoveToApp2SegmentAndGetLength, byte[].class);
            try {
                if (hasJpegMpfPreamble(reader, bArr, iMoveToApp2SegmentAndGetLength)) {
                    arrayPool.put(bArr);
                    return true;
                }
                arrayPool.put(bArr);
                iMoveToApp2SegmentAndGetLength = moveToApp2SegmentAndGetLength(reader);
            } catch (Throwable th) {
                arrayPool.put(bArr);
                throw th;
            }
        }
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "hasMpf: Failed to parse APP2 segment length, or no APP2 segment with MPF metadata not found");
        }
        return false;
    }

    private static int parseExifSegment(RandomAccessReader randomAccessReader) {
        ByteOrder byteOrder;
        short int16 = randomAccessReader.getInt16(6);
        if (int16 != INTEL_TIFF_MAGIC_NUMBER) {
            if (int16 != MOTOROLA_TIFF_MAGIC_NUMBER && Log.isLoggable(TAG, 3)) {
                androidx.constraintlayout.core.dsl.a.p(int16, "Unknown endianness = ", TAG);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        randomAccessReader.order(byteOrder);
        int int32 = randomAccessReader.getInt32(10) + 6;
        short int162 = randomAccessReader.getInt16(int32);
        for (int i = 0; i < int162; i++) {
            int iCalcTagOffset = calcTagOffset(int32, i);
            short int163 = randomAccessReader.getInt16(iCalcTagOffset);
            if (int163 == ORIENTATION_TAG_TYPE) {
                short int164 = randomAccessReader.getInt16(iCalcTagOffset + 2);
                if (int164 >= 1 && int164 <= 12) {
                    int int322 = randomAccessReader.getInt32(iCalcTagOffset + 4);
                    if (int322 < 0) {
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "Negative tiff component count");
                        }
                    } else {
                        if (Log.isLoggable(TAG, 3)) {
                            StringBuilder sbS = androidx.appfunctions.metadata.a.s(i, "Got tagIndex=", int163, " tagType=", " formatCode=");
                            sbS.append((int) int164);
                            sbS.append(" componentCount=");
                            sbS.append(int322);
                            Log.d(TAG, sbS.toString());
                        }
                        int i6 = int322 + BYTES_PER_FORMAT[int164];
                        if (i6 > 4) {
                            if (Log.isLoggable(TAG, 3)) {
                                androidx.constraintlayout.core.dsl.a.p(int164, "Got byte count > 4, not orientation, continuing, formatCode=", TAG);
                            }
                        } else {
                            int i10 = iCalcTagOffset + 8;
                            if (i10 >= 0 && i10 <= randomAccessReader.length()) {
                                if (i6 >= 0 && i6 + i10 <= randomAccessReader.length()) {
                                    return randomAccessReader.getInt16(i10);
                                }
                                if (Log.isLoggable(TAG, 3)) {
                                    androidx.constraintlayout.core.dsl.a.p(int163, "Illegal number of bytes for TI tag data tagType=", TAG);
                                }
                            } else if (Log.isLoggable(TAG, 3)) {
                                Log.d(TAG, "Illegal tagValueOffset=" + i10 + " tagType=" + ((int) int163));
                            }
                        }
                    }
                } else if (Log.isLoggable(TAG, 3)) {
                    androidx.constraintlayout.core.dsl.a.p(int164, "Got invalid format code = ", TAG);
                }
            }
        }
        return -1;
    }
}
