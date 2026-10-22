package W;

import android.opengl.EGLSurface;

/* loaded from: classes.dex */
public final class c extends f {

    /* renamed from: a, reason: collision with root package name */
    public final EGLSurface f6580a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6581b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6582c;

    public c(EGLSurface eGLSurface, int i10, int i11) {
        if (eGLSurface == null) {
            throw new NullPointerException("Null eglSurface");
        }
        this.f6580a = eGLSurface;
        this.f6581b = i10;
        this.f6582c = i11;
    }

    @Override // W.f
    public EGLSurface a() {
        return this.f6580a;
    }

    @Override // W.f
    public int b() {
        return this.f6582c;
    }

    @Override // W.f
    public int c() {
        return this.f6581b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f6580a.equals(fVar.a()) && this.f6581b == fVar.c() && this.f6582c == fVar.b()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f6582c ^ ((((this.f6580a.hashCode() ^ 1000003) * 1000003) ^ this.f6581b) * 1000003);
    }

    public String toString() {
        return "OutputSurface{eglSurface=" + this.f6580a + ", width=" + this.f6581b + ", height=" + this.f6582c + "}";
    }
}
