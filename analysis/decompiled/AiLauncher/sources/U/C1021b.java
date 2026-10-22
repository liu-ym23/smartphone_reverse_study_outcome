package U;

import K.InterfaceC0891n;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;

/* renamed from: U.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1021b<T> extends A<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f6089a;

    /* renamed from: b, reason: collision with root package name */
    public final M.f f6090b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6091c;

    /* renamed from: d, reason: collision with root package name */
    public final Size f6092d;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f6093e;

    /* renamed from: f, reason: collision with root package name */
    public final int f6094f;

    /* renamed from: g, reason: collision with root package name */
    public final Matrix f6095g;

    /* renamed from: h, reason: collision with root package name */
    public final InterfaceC0891n f6096h;

    public C1021b(T t10, M.f fVar, int i10, Size size, Rect rect, int i11, Matrix matrix, InterfaceC0891n interfaceC0891n) {
        if (t10 == null) {
            throw new NullPointerException("Null data");
        }
        this.f6089a = t10;
        this.f6090b = fVar;
        this.f6091c = i10;
        if (size == null) {
            throw new NullPointerException("Null size");
        }
        this.f6092d = size;
        if (rect == null) {
            throw new NullPointerException("Null cropRect");
        }
        this.f6093e = rect;
        this.f6094f = i11;
        if (matrix == null) {
            throw new NullPointerException("Null sensorToBufferTransform");
        }
        this.f6095g = matrix;
        if (interfaceC0891n == null) {
            throw new NullPointerException("Null cameraCaptureResult");
        }
        this.f6096h = interfaceC0891n;
    }

    @Override // U.A
    public InterfaceC0891n a() {
        return this.f6096h;
    }

    @Override // U.A
    public Rect b() {
        return this.f6093e;
    }

    @Override // U.A
    public T c() {
        return this.f6089a;
    }

    @Override // U.A
    public M.f d() {
        return this.f6090b;
    }

    @Override // U.A
    public int e() {
        return this.f6091c;
    }

    public boolean equals(Object obj) {
        M.f fVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof A) {
            A a10 = (A) obj;
            if (this.f6089a.equals(a10.c()) && ((fVar = this.f6090b) != null ? fVar.equals(a10.d()) : a10.d() == null) && this.f6091c == a10.e() && this.f6092d.equals(a10.h()) && this.f6093e.equals(a10.b()) && this.f6094f == a10.f() && this.f6095g.equals(a10.g()) && this.f6096h.equals(a10.a())) {
                return true;
            }
        }
        return false;
    }

    @Override // U.A
    public int f() {
        return this.f6094f;
    }

    @Override // U.A
    public Matrix g() {
        return this.f6095g;
    }

    @Override // U.A
    public Size h() {
        return this.f6092d;
    }

    public int hashCode() {
        int iHashCode = (this.f6089a.hashCode() ^ 1000003) * 1000003;
        M.f fVar = this.f6090b;
        return this.f6096h.hashCode() ^ ((((((((((((iHashCode ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003) ^ this.f6091c) * 1000003) ^ this.f6092d.hashCode()) * 1000003) ^ this.f6093e.hashCode()) * 1000003) ^ this.f6094f) * 1000003) ^ this.f6095g.hashCode()) * 1000003);
    }

    public String toString() {
        return "Packet{data=" + this.f6089a + ", exif=" + this.f6090b + ", format=" + this.f6091c + ", size=" + this.f6092d + ", cropRect=" + this.f6093e + ", rotationDegrees=" + this.f6094f + ", sensorToBufferTransform=" + this.f6095g + ", cameraCaptureResult=" + this.f6096h + "}";
    }
}
