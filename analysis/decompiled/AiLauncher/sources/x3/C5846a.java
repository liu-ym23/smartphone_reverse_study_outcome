package x3;

import A2.B5;
import A2.D5;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import android.os.SystemClock;
import com.google.android.gms.common.internal.C1669j;
import java.nio.ByteBuffer;
import r3.InterfaceC5213g;
import y3.c;

/* renamed from: x3.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C5846a implements InterfaceC5213g {

    /* renamed from: a, reason: collision with root package name */
    public volatile Bitmap f43474a;

    /* renamed from: b, reason: collision with root package name */
    public volatile ByteBuffer f43475b;

    /* renamed from: c, reason: collision with root package name */
    public volatile C5847b f43476c;

    /* renamed from: d, reason: collision with root package name */
    public final int f43477d;

    /* renamed from: e, reason: collision with root package name */
    public final int f43478e;

    /* renamed from: f, reason: collision with root package name */
    public final int f43479f;

    /* renamed from: g, reason: collision with root package name */
    public final int f43480g;

    /* renamed from: h, reason: collision with root package name */
    public final Matrix f43481h;

    public C5846a(Bitmap bitmap, int i10) {
        this.f43474a = (Bitmap) C1669j.k(bitmap);
        this.f43477d = bitmap.getWidth();
        this.f43478e = bitmap.getHeight();
        k(i10);
        this.f43479f = i10;
        this.f43480g = -1;
        this.f43481h = null;
    }

    public static C5846a a(Image image, int i10) {
        return l(image, i10, null);
    }

    public static int k(int i10) {
        boolean z10 = true;
        if (i10 != 0 && i10 != 90 && i10 != 180) {
            if (i10 == 270) {
                i10 = 270;
            } else {
                z10 = false;
            }
        }
        C1669j.b(z10, "Invalid rotation. Only 0, 90, 180, 270 are supported currently.");
        return i10;
    }

    public static C5846a l(Image image, int i10, Matrix matrix) {
        Image image2;
        int i11;
        int iLimit;
        C5846a c5846a;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C1669j.l(image, "Please provide a valid image");
        k(i10);
        boolean z10 = true;
        if (image.getFormat() != 256 && image.getFormat() != 35) {
            z10 = false;
        }
        C1669j.b(z10, "Only JPEG and YUV_420_888 are supported now");
        Image.Plane[] planes = image.getPlanes();
        if (image.getFormat() == 256) {
            iLimit = image.getPlanes()[0].getBuffer().limit();
            image2 = image;
            i11 = i10;
            c5846a = new C5846a(c.d().b(image, i10), 0);
        } else {
            for (Image.Plane plane : planes) {
                if (plane.getBuffer() != null) {
                    plane.getBuffer().rewind();
                }
            }
            image2 = image;
            i11 = i10;
            C5846a c5846a2 = new C5846a(image2, image.getWidth(), image.getHeight(), i11, matrix);
            iLimit = (image2.getPlanes()[0].getBuffer().limit() * 3) / 2;
            c5846a = c5846a2;
        }
        m(image2.getFormat(), 5, jElapsedRealtime, image2.getHeight(), image2.getWidth(), iLimit, i11);
        return c5846a;
    }

    public static void m(int i10, int i11, long j10, int i12, int i13, int i14, int i15) {
        D5.a(B5.b("vision-common"), i10, i11, j10, i12, i13, i14, i15);
    }

    public Bitmap b() {
        return this.f43474a;
    }

    public ByteBuffer c() {
        return this.f43475b;
    }

    public Matrix d() {
        return this.f43481h;
    }

    public int e() {
        return this.f43480g;
    }

    public int f() {
        return this.f43478e;
    }

    public Image g() {
        if (this.f43476c == null) {
            return null;
        }
        return this.f43476c.a();
    }

    public Image.Plane[] h() {
        if (this.f43476c == null) {
            return null;
        }
        return this.f43476c.b();
    }

    public int i() {
        return this.f43479f;
    }

    public int j() {
        return this.f43477d;
    }

    public C5846a(Image image, int i10, int i11, int i12, Matrix matrix) {
        C1669j.k(image);
        this.f43476c = new C5847b(image);
        this.f43477d = i10;
        this.f43478e = i11;
        k(i12);
        this.f43479f = i12;
        this.f43480g = 35;
        this.f43481h = matrix;
    }
}
