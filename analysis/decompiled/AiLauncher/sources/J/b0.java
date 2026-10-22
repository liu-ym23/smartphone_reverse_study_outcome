package J;

import K.E0;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.i;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.internal.utils.ImageUtil;
import java.nio.ByteBuffer;
import java.util.Objects;

/* loaded from: classes.dex */
public final class b0 implements androidx.camera.core.i {

    /* renamed from: a, reason: collision with root package name */
    public final Object f3604a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3605b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3606c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f3607d;

    /* renamed from: e, reason: collision with root package name */
    public i.a[] f3608e;

    /* renamed from: f, reason: collision with root package name */
    public final D.T f3609f;

    public class a implements i.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f3610a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f3611b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f3612c;

        public a(int i10, int i11, ByteBuffer byteBuffer) {
            this.f3610a = i10;
            this.f3611b = i11;
            this.f3612c = byteBuffer;
        }

        @Override // androidx.camera.core.i.a
        public ByteBuffer a() {
            return this.f3612c;
        }

        @Override // androidx.camera.core.i.a
        public int b() {
            return this.f3610a;
        }

        @Override // androidx.camera.core.i.a
        public int c() {
            return this.f3611b;
        }
    }

    public class b implements D.T {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f3613a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f3614b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Matrix f3615c;

        public b(long j10, int i10, Matrix matrix) {
            this.f3613a = j10;
            this.f3614b = i10;
            this.f3615c = matrix;
        }

        @Override // D.T
        public void c(ExifData.b bVar) {
            throw new UnsupportedOperationException("Custom ImageProxy does not contain Exif data.");
        }

        @Override // D.T
        public E0 e() {
            throw new UnsupportedOperationException("Custom ImageProxy does not contain TagBundle");
        }

        @Override // D.T
        public int f() {
            return this.f3614b;
        }

        @Override // D.T
        public long getTimestamp() {
            return this.f3613a;
        }
    }

    public b0(U.A<Bitmap> a10) {
        this(a10.c(), a10.b(), a10.f(), a10.g(), a10.a().getTimestamp());
    }

    public static D.T e(long j10, int i10, Matrix matrix) {
        return new b(j10, i10, matrix);
    }

    public static i.a g(ByteBuffer byteBuffer, int i10, int i11) {
        return new a(i10, i11, byteBuffer);
    }

    @Override // androidx.camera.core.i
    public void S(Rect rect) {
        synchronized (this.f3604a) {
            try {
                b();
                if (rect != null) {
                    this.f3607d.set(rect);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.i
    public D.T Z0() {
        D.T t10;
        synchronized (this.f3604a) {
            b();
            t10 = this.f3609f;
        }
        return t10;
    }

    public final void b() {
        synchronized (this.f3604a) {
            B0.h.i(this.f3608e != null, "The image is closed.");
        }
    }

    @Override // androidx.camera.core.i, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f3604a) {
            b();
            this.f3608e = null;
        }
    }

    @Override // androidx.camera.core.i
    public Image g1() {
        synchronized (this.f3604a) {
            b();
        }
        return null;
    }

    @Override // androidx.camera.core.i
    public int getFormat() {
        synchronized (this.f3604a) {
            b();
        }
        return 1;
    }

    @Override // androidx.camera.core.i
    public int getHeight() {
        int i10;
        synchronized (this.f3604a) {
            b();
            i10 = this.f3606c;
        }
        return i10;
    }

    @Override // androidx.camera.core.i
    public int getWidth() {
        int i10;
        synchronized (this.f3604a) {
            b();
            i10 = this.f3605b;
        }
        return i10;
    }

    @Override // androidx.camera.core.i
    public i.a[] w0() {
        i.a[] aVarArr;
        synchronized (this.f3604a) {
            b();
            i.a[] aVarArr2 = this.f3608e;
            Objects.requireNonNull(aVarArr2);
            aVarArr = aVarArr2;
        }
        return aVarArr;
    }

    public b0(Bitmap bitmap, Rect rect, int i10, Matrix matrix, long j10) {
        this(ImageUtil.e(bitmap), 4, bitmap.getWidth(), bitmap.getHeight(), rect, i10, matrix, j10);
    }

    public b0(ByteBuffer byteBuffer, int i10, int i11, int i12, Rect rect, int i13, Matrix matrix, long j10) {
        this.f3604a = new Object();
        this.f3605b = i11;
        this.f3606c = i12;
        this.f3607d = rect;
        this.f3609f = e(j10, i13, matrix);
        byteBuffer.rewind();
        this.f3608e = new i.a[]{g(byteBuffer, i11 * i10, i10)};
    }
}
