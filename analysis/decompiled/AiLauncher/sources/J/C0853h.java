package J;

import J.W;

/* renamed from: J.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0853h extends W.b {

    /* renamed from: a, reason: collision with root package name */
    public final X f3633a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.camera.core.i f3634b;

    public C0853h(X x10, androidx.camera.core.i iVar) {
        if (x10 == null) {
            throw new NullPointerException("Null processingRequest");
        }
        this.f3633a = x10;
        if (iVar == null) {
            throw new NullPointerException("Null imageProxy");
        }
        this.f3634b = iVar;
    }

    @Override // J.W.b
    public androidx.camera.core.i a() {
        return this.f3634b;
    }

    @Override // J.W.b
    public X b() {
        return this.f3633a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof W.b) {
            W.b bVar = (W.b) obj;
            if (this.f3633a.equals(bVar.b()) && this.f3634b.equals(bVar.a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f3634b.hashCode() ^ ((this.f3633a.hashCode() ^ 1000003) * 1000003);
    }

    public String toString() {
        return "InputPacket{processingRequest=" + this.f3633a + ", imageProxy=" + this.f3634b + "}";
    }
}
