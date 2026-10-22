package K0;

import C0.v;
import K0.g;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import z0.C1341g;
import z0.C1342h;
import z0.EnumC1336b;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: f, reason: collision with root package name */
    public static final C1341g<EnumC1336b> f3532f = C1341g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", EnumC1336b.f24038c);

    /* renamed from: g, reason: collision with root package name */
    @Deprecated
    public static final C1341g<g> f3533g = g.f3528h;

    /* renamed from: h, reason: collision with root package name */
    public static final C1341g<Boolean> f3534h;

    /* renamed from: i, reason: collision with root package name */
    public static final C1341g<Boolean> f3535i;

    /* renamed from: j, reason: collision with root package name */
    private static final Set<String> f3536j;

    /* renamed from: k, reason: collision with root package name */
    private static final b f3537k;

    /* renamed from: l, reason: collision with root package name */
    private static final Set<ImageHeaderParser.ImageType> f3538l;

    /* renamed from: m, reason: collision with root package name */
    private static final Queue<BitmapFactory.Options> f3539m;

    /* renamed from: a, reason: collision with root package name */
    private final D0.d f3540a;

    /* renamed from: b, reason: collision with root package name */
    private final DisplayMetrics f3541b;

    /* renamed from: c, reason: collision with root package name */
    private final D0.b f3542c;

    /* renamed from: d, reason: collision with root package name */
    private final List<ImageHeaderParser> f3543d;

    /* renamed from: e, reason: collision with root package name */
    private final l f3544e = l.a();

    class a implements b {
        a() {
        }

        @Override // K0.h.b
        public void a(D0.d dVar, Bitmap bitmap) {
        }

        @Override // K0.h.b
        public void b() {
        }
    }

    public interface b {
        void a(D0.d dVar, Bitmap bitmap);

        void b();
    }

    static {
        Boolean bool = Boolean.FALSE;
        f3534h = C1341g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f3535i = C1341g.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        f3536j = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f3537k = new a();
        f3538l = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        f3539m = X0.k.f(0);
    }

    public h(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, D0.d dVar, D0.b bVar) {
        this.f3543d = list;
        this.f3541b = (DisplayMetrics) X0.j.d(displayMetrics);
        this.f3540a = (D0.d) X0.j.d(dVar);
        this.f3542c = (D0.b) X0.j.d(bVar);
    }

    private static int a(double d6) {
        return t((d6 / (r1 / r0)) * t(j(d6) * d6));
    }

    private void b(InputStream inputStream, EnumC1336b enumC1336b, boolean z5, boolean z6, BitmapFactory.Options options, int i5, int i6) {
        boolean zHasAlpha;
        if (this.f3544e.c(i5, i6, options, enumC1336b, z5, z6)) {
            return;
        }
        if (enumC1336b == EnumC1336b.PREFER_ARGB_8888) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        try {
            zHasAlpha = com.bumptech.glide.load.a.b(this.f3543d, inputStream, this.f3542c).hasAlpha();
        } catch (IOException e6) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + enumC1336b, e6);
            }
            zHasAlpha = false;
        }
        Bitmap.Config config = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    private static void c(ImageHeaderParser.ImageType imageType, InputStream inputStream, b bVar, D0.d dVar, g gVar, int i5, int i6, int i7, int i8, int i9, BitmapFactory.Options options) throws IOException {
        boolean z5;
        int i10;
        int iFloor;
        int iFloor2;
        if (i6 <= 0 || i7 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i8 + "x" + i9 + "]");
                return;
            }
            return;
        }
        float fB = (i5 == 90 || i5 == 270) ? gVar.b(i7, i6, i8, i9) : gVar.b(i6, i7, i8, i9);
        if (fB <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + fB + " from: " + gVar + ", source: [" + i6 + "x" + i7 + "], target: [" + i8 + "x" + i9 + "]");
        }
        g.EnumC0049g enumC0049gA = gVar.a(i6, i7, i8, i9);
        if (enumC0049gA == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f5 = i6;
        int iT = t(fB * f5);
        float f6 = i7;
        int iT2 = t(fB * f6);
        int i11 = i6 / iT;
        int i12 = i7 / iT2;
        g.EnumC0049g enumC0049g = g.EnumC0049g.MEMORY;
        int iMax = Math.max(1, Integer.highestOneBit(enumC0049gA == enumC0049g ? Math.max(i11, i12) : Math.min(i11, i12)));
        if (enumC0049gA == enumC0049g && iMax < 1.0f / fB) {
            iMax <<= 1;
        }
        options.inSampleSize = iMax;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float fMin = Math.min(iMax, 8);
            z5 = true;
            i10 = 0;
            iFloor = (int) Math.ceil(f5 / fMin);
            iFloor2 = (int) Math.ceil(f6 / fMin);
            int i13 = iMax / 8;
            if (i13 > 0) {
                iFloor /= i13;
                iFloor2 /= i13;
            }
        } else {
            z5 = true;
            i10 = 0;
            if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
                float f7 = iMax;
                iFloor = (int) Math.floor(f5 / f7);
                iFloor2 = (int) Math.floor(f6 / f7);
            } else if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                float f8 = iMax;
                iFloor = Math.round(f5 / f8);
                iFloor2 = Math.round(f6 / f8);
            } else if (i6 % iMax == 0 && i7 % iMax == 0) {
                iFloor = i6 / iMax;
                iFloor2 = i7 / iMax;
            } else {
                int[] iArrK = k(inputStream, options, bVar, dVar);
                iFloor = iArrK[0];
                iFloor2 = iArrK[1];
            }
        }
        double dB = gVar.b(iFloor, iFloor2, i8, i9);
        options.inTargetDensity = a(dB);
        options.inDensity = j(dB);
        if (o(options)) {
            options.inScaled = z5;
        } else {
            options.inTargetDensity = i10;
            options.inDensity = i10;
        }
        if (Log.isLoggable("Downsampler", 2)) {
            Log.v("Downsampler", "Calculate scaling, source: [" + i6 + "x" + i7 + "], target: [" + i8 + "x" + i9 + "], power of two scaled: [" + iFloor + "x" + iFloor2 + "], exact scale factor: " + fB + ", power of 2 sample size: " + iMax + ", adjusted scale factor: " + dB + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    private Bitmap f(InputStream inputStream, BitmapFactory.Options options, g gVar, EnumC1336b enumC1336b, boolean z5, int i5, int i6, boolean z6, b bVar) throws IOException {
        int i7;
        int i8;
        BitmapFactory.Options options2;
        Bitmap bitmap;
        long jB = X0.f.b();
        int[] iArrK = k(inputStream, options, bVar, this.f3540a);
        int i9 = iArrK[0];
        int i10 = iArrK[1];
        String str = options.outMimeType;
        boolean z7 = (i9 == -1 || i10 == -1) ? false : z5;
        int iA = com.bumptech.glide.load.a.a(this.f3543d, inputStream, this.f3542c);
        int iD = q.d(iA);
        boolean zG = q.g(iA);
        int i11 = i5 == Integer.MIN_VALUE ? i9 : i5;
        if (i6 == Integer.MIN_VALUE) {
            i8 = i11;
            i7 = i10;
        } else {
            int i12 = i11;
            i7 = i6;
            i8 = i12;
        }
        ImageHeaderParser.ImageType imageTypeB = com.bumptech.glide.load.a.b(this.f3543d, inputStream, this.f3542c);
        c(imageTypeB, inputStream, bVar, this.f3540a, gVar, iD, i9, i10, i8, i7, options);
        int i13 = i8;
        int i14 = i7;
        b(inputStream, enumC1336b, z7, zG, options, i13, i14);
        if (v(imageTypeB)) {
            if (i9 < 0 || i10 < 0 || !z6) {
                float f5 = o(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i15 = options.inSampleSize;
                float f6 = i9;
                float f7 = i15;
                int iCeil = (int) Math.ceil(f6 / f7);
                int iCeil2 = (int) Math.ceil(i10 / f7);
                int iRound = Math.round(iCeil * f5);
                int iRound2 = Math.round(iCeil2 * f5);
                if (Log.isLoggable("Downsampler", 2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Calculated target [");
                    sb.append(iRound);
                    sb.append("x");
                    sb.append(iRound2);
                    sb.append("] for source [");
                    sb.append(i9);
                    sb.append("x");
                    sb.append(i10);
                    sb.append("], sampleSize: ");
                    sb.append(i15);
                    sb.append(", targetDensity: ");
                    options2 = options;
                    sb.append(options2.inTargetDensity);
                    sb.append(", density: ");
                    sb.append(options2.inDensity);
                    sb.append(", density multiplier: ");
                    sb.append(f5);
                    Log.v("Downsampler", sb.toString());
                } else {
                    options2 = options;
                }
                i13 = iRound;
                i14 = iRound2;
            } else {
                options2 = options;
            }
            if (i13 > 0 && i14 > 0) {
                u(options2, this.f3540a, i13, i14);
            }
        } else {
            options2 = options;
        }
        Bitmap bitmapG = g(inputStream, options2, bVar, this.f3540a);
        bVar.a(this.f3540a, bitmapG);
        if (Log.isLoggable("Downsampler", 2)) {
            bitmap = bitmapG;
            p(i9, i10, str, options2, bitmap, i5, i6, jB);
        } else {
            bitmap = bitmapG;
        }
        if (bitmap == null) {
            return null;
        }
        bitmap.setDensity(this.f3541b.densityDpi);
        Bitmap bitmapH = q.h(this.f3540a, bitmap, iA);
        if (!bitmap.equals(bitmapH)) {
            this.f3540a.c(bitmap);
        }
        return bitmapH;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Bitmap g(java.io.InputStream r6, android.graphics.BitmapFactory.Options r7, K0.h.b r8, D0.d r9) throws java.io.IOException {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r7.inJustDecodeBounds
            if (r1 == 0) goto Lc
            r1 = 10485760(0xa00000, float:1.469368E-38)
            r6.mark(r1)
            goto Lf
        Lc:
            r8.b()
        Lf:
            int r1 = r7.outWidth
            int r2 = r7.outHeight
            java.lang.String r3 = r7.outMimeType
            java.util.concurrent.locks.Lock r4 = K0.q.c()
            r4.lock()
            r4 = 0
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeStream(r6, r4, r7)     // Catch: java.lang.IllegalArgumentException -> L30 java.lang.Throwable -> L5d
            java.util.concurrent.locks.Lock r9 = K0.q.c()
            r9.unlock()
            boolean r7 = r7.inJustDecodeBounds
            if (r7 == 0) goto L2f
            r6.reset()
        L2f:
            return r8
        L30:
            r5 = move-exception
            java.io.IOException r1 = q(r5, r1, r2, r3, r7)     // Catch: java.lang.Throwable -> L5d
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch: java.lang.Throwable -> L5d
            if (r2 == 0) goto L41
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch: java.lang.Throwable -> L5d
        L41:
            android.graphics.Bitmap r0 = r7.inBitmap     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L5c
            r6.reset()     // Catch: java.io.IOException -> L5b java.lang.Throwable -> L5d
            android.graphics.Bitmap r0 = r7.inBitmap     // Catch: java.io.IOException -> L5b java.lang.Throwable -> L5d
            r9.c(r0)     // Catch: java.io.IOException -> L5b java.lang.Throwable -> L5d
            r7.inBitmap = r4     // Catch: java.io.IOException -> L5b java.lang.Throwable -> L5d
            android.graphics.Bitmap r6 = g(r6, r7, r8, r9)     // Catch: java.io.IOException -> L5b java.lang.Throwable -> L5d
            java.util.concurrent.locks.Lock r7 = K0.q.c()
            r7.unlock()
            return r6
        L5b:
            throw r1     // Catch: java.lang.Throwable -> L5d
        L5c:
            throw r1     // Catch: java.lang.Throwable -> L5d
        L5d:
            r6 = move-exception
            java.util.concurrent.locks.Lock r7 = K0.q.c()
            r7.unlock()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: K0.h.g(java.io.InputStream, android.graphics.BitmapFactory$Options, K0.h$b, D0.d):android.graphics.Bitmap");
    }

    private static String h(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    private static synchronized BitmapFactory.Options i() {
        BitmapFactory.Options optionsPoll;
        Queue<BitmapFactory.Options> queue = f3539m;
        synchronized (queue) {
            optionsPoll = queue.poll();
        }
        if (optionsPoll == null) {
            optionsPoll = new BitmapFactory.Options();
            s(optionsPoll);
        }
        return optionsPoll;
    }

    private static int j(double d6) {
        if (d6 > 1.0d) {
            d6 = 1.0d / d6;
        }
        return (int) Math.round(d6 * 2.147483647E9d);
    }

    private static int[] k(InputStream inputStream, BitmapFactory.Options options, b bVar, D0.d dVar) throws IOException {
        options.inJustDecodeBounds = true;
        g(inputStream, options, bVar, dVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String l(BitmapFactory.Options options) {
        return h(options.inBitmap);
    }

    private static boolean o(BitmapFactory.Options options) {
        int i5;
        int i6 = options.inTargetDensity;
        return i6 > 0 && (i5 = options.inDensity) > 0 && i6 != i5;
    }

    private static void p(int i5, int i6, String str, BitmapFactory.Options options, Bitmap bitmap, int i7, int i8, long j5) {
        Log.v("Downsampler", "Decoded " + h(bitmap) + " from [" + i5 + "x" + i6 + "] " + str + " with inBitmap " + l(options) + " for [" + i7 + "x" + i8 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + X0.f.a(j5));
    }

    private static IOException q(IllegalArgumentException illegalArgumentException, int i5, int i6, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i5 + ", outHeight: " + i6 + ", outMimeType: " + str + ", inBitmap: " + l(options), illegalArgumentException);
    }

    private static void r(BitmapFactory.Options options) {
        s(options);
        Queue<BitmapFactory.Options> queue = f3539m;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void s(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int t(double d6) {
        return (int) (d6 + 0.5d);
    }

    private static void u(BitmapFactory.Options options, D0.d dVar, int i5, int i6) {
        Bitmap.Config config = options.inPreferredConfig;
        if (config == Bitmap.Config.HARDWARE) {
            return;
        }
        Bitmap.Config config2 = options.outConfig;
        if (config2 != null) {
            config = config2;
        }
        options.inBitmap = dVar.e(i5, i6, config);
    }

    private boolean v(ImageHeaderParser.ImageType imageType) {
        return true;
    }

    public v<Bitmap> d(InputStream inputStream, int i5, int i6, C1342h c1342h) {
        return e(inputStream, i5, i6, c1342h, f3537k);
    }

    public v<Bitmap> e(InputStream inputStream, int i5, int i6, C1342h c1342h, b bVar) {
        X0.j.a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.f3542c.d(65536, byte[].class);
        BitmapFactory.Options optionsI = i();
        optionsI.inTempStorage = bArr;
        EnumC1336b enumC1336b = (EnumC1336b) c1342h.c(f3532f);
        g gVar = (g) c1342h.c(g.f3528h);
        boolean zBooleanValue = ((Boolean) c1342h.c(f3534h)).booleanValue();
        C1341g<Boolean> c1341g = f3535i;
        try {
            return d.f(f(inputStream, optionsI, gVar, enumC1336b, c1342h.c(c1341g) != null && ((Boolean) c1342h.c(c1341g)).booleanValue(), i5, i6, zBooleanValue, bVar), this.f3540a);
        } finally {
            r(optionsI);
            this.f3542c.put(bArr);
        }
    }

    public boolean m(InputStream inputStream) {
        return true;
    }

    public boolean n(ByteBuffer byteBuffer) {
        return true;
    }
}
