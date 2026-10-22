package K0;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class f implements ImageHeaderParser {

    /* renamed from: a, reason: collision with root package name */
    static final byte[] f3516a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f3517b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    private static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f3518a;

        a(ByteBuffer byteBuffer) {
            this.f3518a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // K0.f.c
        public int a() {
            return (d() & 255) | ((d() << 8) & 65280);
        }

        @Override // K0.f.c
        public int b(byte[] bArr, int i5) {
            int iMin = Math.min(i5, this.f3518a.remaining());
            if (iMin == 0) {
                return -1;
            }
            this.f3518a.get(bArr, 0, iMin);
            return iMin;
        }

        @Override // K0.f.c
        public short c() {
            return (short) (d() & 255);
        }

        @Override // K0.f.c
        public int d() {
            if (this.f3518a.remaining() < 1) {
                return -1;
            }
            return this.f3518a.get();
        }

        @Override // K0.f.c
        public long skip(long j5) {
            int iMin = (int) Math.min(this.f3518a.remaining(), j5);
            ByteBuffer byteBuffer = this.f3518a;
            byteBuffer.position(byteBuffer.position() + iMin);
            return iMin;
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f3519a;

        b(byte[] bArr, int i5) {
            this.f3519a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i5);
        }

        private boolean c(int i5, int i6) {
            return this.f3519a.remaining() - i5 >= i6;
        }

        short a(int i5) {
            if (c(i5, 2)) {
                return this.f3519a.getShort(i5);
            }
            return (short) -1;
        }

        int b(int i5) {
            if (c(i5, 4)) {
                return this.f3519a.getInt(i5);
            }
            return -1;
        }

        int d() {
            return this.f3519a.remaining();
        }

        void e(ByteOrder byteOrder) {
            this.f3519a.order(byteOrder);
        }
    }

    private interface c {
        int a();

        int b(byte[] bArr, int i5);

        short c();

        int d();

        long skip(long j5);
    }

    private static final class d implements c {

        /* renamed from: a, reason: collision with root package name */
        private final InputStream f3520a;

        d(InputStream inputStream) {
            this.f3520a = inputStream;
        }

        @Override // K0.f.c
        public int a() {
            return (this.f3520a.read() & 255) | ((this.f3520a.read() << 8) & 65280);
        }

        @Override // K0.f.c
        public int b(byte[] bArr, int i5) throws IOException {
            int i6 = i5;
            while (i6 > 0) {
                int i7 = this.f3520a.read(bArr, i5 - i6, i6);
                if (i7 == -1) {
                    break;
                }
                i6 -= i7;
            }
            return i5 - i6;
        }

        @Override // K0.f.c
        public short c() {
            return (short) (this.f3520a.read() & 255);
        }

        @Override // K0.f.c
        public int d() {
            return this.f3520a.read();
        }

        @Override // K0.f.c
        public long skip(long j5) throws IOException {
            if (j5 < 0) {
                return 0L;
            }
            long j6 = j5;
            while (j6 > 0) {
                long jSkip = this.f3520a.skip(j6);
                if (jSkip <= 0) {
                    if (this.f3520a.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j6 -= jSkip;
            }
            return j5 - j6;
        }
    }

    private static int d(int i5, int i6) {
        return i5 + 2 + (i6 * 12);
    }

    private int e(c cVar, D0.b bVar) {
        int iA = cVar.a();
        if (!g(iA)) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + iA);
            }
            return -1;
        }
        int i5 = i(cVar);
        if (i5 == -1) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        byte[] bArr = (byte[]) bVar.d(i5, byte[].class);
        try {
            return k(cVar, bArr, i5);
        } finally {
            bVar.put(bArr);
        }
    }

    private ImageHeaderParser.ImageType f(c cVar) {
        int iA = cVar.a();
        if (iA == 65496) {
            return ImageHeaderParser.ImageType.JPEG;
        }
        int iA2 = ((iA << 16) & (-65536)) | (cVar.a() & ExifInterface.COLOR_SPACE_UNCALIBRATED);
        if (iA2 == -1991225785) {
            cVar.skip(21L);
            return cVar.d() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
        }
        if ((iA2 >> 8) == 4671814) {
            return ImageHeaderParser.ImageType.GIF;
        }
        if (iA2 != 1380533830) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        cVar.skip(4L);
        if ((((cVar.a() << 16) & (-65536)) | (cVar.a() & ExifInterface.COLOR_SPACE_UNCALIBRATED)) != 1464156752) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int iA3 = ((cVar.a() << 16) & (-65536)) | (cVar.a() & ExifInterface.COLOR_SPACE_UNCALIBRATED);
        if ((iA3 & (-256)) != 1448097792) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int i5 = iA3 & 255;
        if (i5 == 88) {
            cVar.skip(4L);
            return (cVar.d() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
        }
        if (i5 != 76) {
            return ImageHeaderParser.ImageType.WEBP;
        }
        cVar.skip(4L);
        return (cVar.d() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
    }

    private static boolean g(int i5) {
        return (i5 & 65496) == 65496 || i5 == 19789 || i5 == 18761;
    }

    private boolean h(byte[] bArr, int i5) {
        boolean z5 = bArr != null && i5 > f3516a.length;
        if (z5) {
            int i6 = 0;
            while (true) {
                byte[] bArr2 = f3516a;
                if (i6 >= bArr2.length) {
                    break;
                }
                if (bArr[i6] != bArr2[i6]) {
                    return false;
                }
                i6++;
            }
        }
        return z5;
    }

    private int i(c cVar) {
        short sC;
        int iA;
        long j5;
        long jSkip;
        do {
            short sC2 = cVar.c();
            if (sC2 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) sC2));
                }
                return -1;
            }
            sC = cVar.c();
            if (sC == 218) {
                return -1;
            }
            if (sC == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            iA = cVar.a() - 2;
            if (sC == 225) {
                return iA;
            }
            j5 = iA;
            jSkip = cVar.skip(j5);
        } while (jSkip == j5);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) sC) + ", wanted to skip: " + iA + ", but actually skipped: " + jSkip);
        }
        return -1;
    }

    private static int j(b bVar) {
        ByteOrder byteOrder;
        short sA = bVar.a(6);
        if (sA != 18761) {
            if (sA != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) sA));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        bVar.e(byteOrder);
        int iB = bVar.b(10) + 6;
        short sA2 = bVar.a(iB);
        for (int i5 = 0; i5 < sA2; i5++) {
            int iD = d(iB, i5);
            short sA3 = bVar.a(iD);
            if (sA3 == 274) {
                short sA4 = bVar.a(iD + 2);
                if (sA4 >= 1 && sA4 <= 12) {
                    int iB2 = bVar.b(iD + 4);
                    if (iB2 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i5 + " tagType=" + ((int) sA3) + " formatCode=" + ((int) sA4) + " componentCount=" + iB2);
                        }
                        int i6 = iB2 + f3517b[sA4];
                        if (i6 <= 4) {
                            int i7 = iD + 8;
                            if (i7 >= 0 && i7 <= bVar.d()) {
                                if (i6 >= 0 && i6 + i7 <= bVar.d()) {
                                    return bVar.a(i7);
                                }
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) sA3));
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i7 + " tagType=" + ((int) sA3));
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) sA4));
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) sA4));
                }
            }
        }
        return -1;
    }

    private int k(c cVar, byte[] bArr, int i5) {
        int iB = cVar.b(bArr, i5);
        if (iB == i5) {
            if (h(bArr, i5)) {
                return j(new b(bArr, i5));
            }
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i5 + ", actually read: " + iB);
        }
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) {
        return f(new a((ByteBuffer) X0.j.d(byteBuffer)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType b(InputStream inputStream) {
        return f(new d((InputStream) X0.j.d(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int c(InputStream inputStream, D0.b bVar) {
        return e(new d((InputStream) X0.j.d(inputStream)), (D0.b) X0.j.d(bVar));
    }
}
