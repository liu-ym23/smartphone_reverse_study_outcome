package K0;

import C0.v;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import z0.C1341g;
import z0.C1342h;

/* loaded from: classes.dex */
public class s<T> implements z0.i<T, Bitmap> {

    /* renamed from: d, reason: collision with root package name */
    public static final C1341g<Long> f3572d = C1341g.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* renamed from: e, reason: collision with root package name */
    public static final C1341g<Integer> f3573e = C1341g.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* renamed from: f, reason: collision with root package name */
    private static final d f3574f = new d();

    /* renamed from: a, reason: collision with root package name */
    private final e<T> f3575a;

    /* renamed from: b, reason: collision with root package name */
    private final D0.d f3576b;

    /* renamed from: c, reason: collision with root package name */
    private final d f3577c;

    class a implements C1341g.b<Long> {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f3578a = ByteBuffer.allocate(8);

        a() {
        }

        @Override // z0.C1341g.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr, Long l5, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f3578a) {
                this.f3578a.position(0);
                messageDigest.update(this.f3578a.putLong(l5.longValue()).array());
            }
        }
    }

    class b implements C1341g.b<Integer> {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f3579a = ByteBuffer.allocate(4);

        b() {
        }

        @Override // z0.C1341g.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f3579a) {
                this.f3579a.position(0);
                messageDigest.update(this.f3579a.putInt(num.intValue()).array());
            }
        }
    }

    private static final class c implements e<AssetFileDescriptor> {
        private c() {
        }

        @Override // K0.s.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    static class d {
        d() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    interface e<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t5);
    }

    static final class f implements e<ParcelFileDescriptor> {
        f() {
        }

        @Override // K0.s.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    s(D0.d dVar, e<T> eVar) {
        this(dVar, eVar, f3574f);
    }

    public static z0.i<AssetFileDescriptor, Bitmap> c(D0.d dVar) {
        return new s(dVar, new c(null));
    }

    private static Bitmap d(MediaMetadataRetriever mediaMetadataRetriever, long j5, int i5, int i6, int i7, g gVar) {
        Bitmap bitmapF = (i6 == Integer.MIN_VALUE || i7 == Integer.MIN_VALUE || gVar == g.f3526f) ? null : f(mediaMetadataRetriever, j5, i5, i6, i7, gVar);
        return bitmapF == null ? e(mediaMetadataRetriever, j5, i5) : bitmapF;
    }

    private static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long j5, int i5) {
        return mediaMetadataRetriever.getFrameAtTime(j5, i5);
    }

    private static Bitmap f(MediaMetadataRetriever mediaMetadataRetriever, long j5, int i5, int i6, int i7, g gVar) {
        try {
            int i8 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i9 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i10 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i10 == 90 || i10 == 270) {
                i9 = i8;
                i8 = i9;
            }
            float fB = gVar.b(i8, i9, i6, i7);
            return mediaMetadataRetriever.getScaledFrameAtTime(j5, i5, Math.round(i8 * fB), Math.round(fB * i9));
        } catch (Throwable th) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", th);
            return null;
        }
    }

    public static z0.i<ParcelFileDescriptor, Bitmap> g(D0.d dVar) {
        return new s(dVar, new f());
    }

    @Override // z0.i
    public v<Bitmap> a(T t5, int i5, int i6, C1342h c1342h) throws IOException {
        long jLongValue = ((Long) c1342h.c(f3572d)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        Integer num = (Integer) c1342h.c(f3573e);
        if (num == null) {
            num = 2;
        }
        g gVar = (g) c1342h.c(g.f3528h);
        if (gVar == null) {
            gVar = g.f3527g;
        }
        g gVar2 = gVar;
        MediaMetadataRetriever mediaMetadataRetrieverA = this.f3577c.a();
        try {
            try {
                this.f3575a.a(mediaMetadataRetrieverA, t5);
                Bitmap bitmapD = d(mediaMetadataRetrieverA, jLongValue, num.intValue(), i5, i6, gVar2);
                mediaMetadataRetrieverA.release();
                return K0.d.f(bitmapD, this.f3576b);
            } catch (RuntimeException e6) {
                throw new IOException(e6);
            }
        } catch (Throwable th) {
            mediaMetadataRetrieverA.release();
            throw th;
        }
    }

    @Override // z0.i
    public boolean b(T t5, C1342h c1342h) {
        return true;
    }

    s(D0.d dVar, e<T> eVar, d dVar2) {
        this.f3576b = dVar;
        this.f3575a = eVar;
        this.f3577c = dVar2;
    }
}
