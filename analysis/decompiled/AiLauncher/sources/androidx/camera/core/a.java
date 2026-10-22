package androidx.camera.core;

import D.T;
import D.Z;
import K.E0;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.i;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class a implements i {

    /* renamed from: a, reason: collision with root package name */
    public final Image f11271a;

    /* renamed from: b, reason: collision with root package name */
    public final C0145a[] f11272b;

    /* renamed from: c, reason: collision with root package name */
    public final T f11273c;

    /* renamed from: androidx.camera.core.a$a, reason: collision with other inner class name */
    public static final class C0145a implements i.a {

        /* renamed from: a, reason: collision with root package name */
        public final Image.Plane f11274a;

        public C0145a(Image.Plane plane) {
            this.f11274a = plane;
        }

        @Override // androidx.camera.core.i.a
        public ByteBuffer a() {
            return this.f11274a.getBuffer();
        }

        @Override // androidx.camera.core.i.a
        public int b() {
            return this.f11274a.getRowStride();
        }

        @Override // androidx.camera.core.i.a
        public int c() {
            return this.f11274a.getPixelStride();
        }
    }

    public a(Image image) {
        this.f11271a = image;
        Image.Plane[] planes = image.getPlanes();
        if (planes != null) {
            this.f11272b = new C0145a[planes.length];
            for (int i10 = 0; i10 < planes.length; i10++) {
                this.f11272b[i10] = new C0145a(planes[i10]);
            }
        } else {
            this.f11272b = new C0145a[0];
        }
        this.f11273c = Z.b(E0.b(), image.getTimestamp(), 0, new Matrix(), 0);
    }

    @Override // androidx.camera.core.i
    public void S(Rect rect) {
        this.f11271a.setCropRect(rect);
    }

    @Override // androidx.camera.core.i
    public T Z0() {
        return this.f11273c;
    }

    @Override // androidx.camera.core.i, java.lang.AutoCloseable
    public void close() {
        this.f11271a.close();
    }

    @Override // androidx.camera.core.i
    public Image g1() {
        return this.f11271a;
    }

    @Override // androidx.camera.core.i
    public int getFormat() {
        return this.f11271a.getFormat();
    }

    @Override // androidx.camera.core.i
    public int getHeight() {
        return this.f11271a.getHeight();
    }

    @Override // androidx.camera.core.i
    public int getWidth() {
        return this.f11271a.getWidth();
    }

    @Override // androidx.camera.core.i
    public i.a[] w0() {
        return this.f11272b;
    }
}
