package androidx.camera.core.processing;

import U.M;
import W.e;
import androidx.camera.core.processing.SurfaceProcessorNode;
import java.util.List;

/* loaded from: classes.dex */
public final class a extends SurfaceProcessorNode.b {

    /* renamed from: a, reason: collision with root package name */
    public final M f11654a;

    /* renamed from: b, reason: collision with root package name */
    public final List<e> f11655b;

    public a(M m10, List<e> list) {
        if (m10 == null) {
            throw new NullPointerException("Null surfaceEdge");
        }
        this.f11654a = m10;
        if (list == null) {
            throw new NullPointerException("Null outConfigs");
        }
        this.f11655b = list;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.b
    public List<e> a() {
        return this.f11655b;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorNode.b
    public M b() {
        return this.f11654a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SurfaceProcessorNode.b) {
            SurfaceProcessorNode.b bVar = (SurfaceProcessorNode.b) obj;
            if (this.f11654a.equals(bVar.b()) && this.f11655b.equals(bVar.a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f11655b.hashCode() ^ ((this.f11654a.hashCode() ^ 1000003) * 1000003);
    }

    public String toString() {
        return "In{surfaceEdge=" + this.f11654a + ", outConfigs=" + this.f11655b + "}";
    }
}
