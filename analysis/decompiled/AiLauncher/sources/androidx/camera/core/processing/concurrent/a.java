package androidx.camera.core.processing.concurrent;

import U.M;
import V.c;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessorNode;
import java.util.List;

/* loaded from: classes.dex */
public final class a extends DualSurfaceProcessorNode.b {

    /* renamed from: a, reason: collision with root package name */
    public final M f11664a;

    /* renamed from: b, reason: collision with root package name */
    public final M f11665b;

    /* renamed from: c, reason: collision with root package name */
    public final List<c> f11666c;

    public a(M m10, M m11, List<c> list) {
        if (m10 == null) {
            throw new NullPointerException("Null primarySurfaceEdge");
        }
        this.f11664a = m10;
        if (m11 == null) {
            throw new NullPointerException("Null secondarySurfaceEdge");
        }
        this.f11665b = m11;
        if (list == null) {
            throw new NullPointerException("Null outConfigs");
        }
        this.f11666c = list;
    }

    @Override // androidx.camera.core.processing.concurrent.DualSurfaceProcessorNode.b
    public List<c> a() {
        return this.f11666c;
    }

    @Override // androidx.camera.core.processing.concurrent.DualSurfaceProcessorNode.b
    public M b() {
        return this.f11664a;
    }

    @Override // androidx.camera.core.processing.concurrent.DualSurfaceProcessorNode.b
    public M c() {
        return this.f11665b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DualSurfaceProcessorNode.b) {
            DualSurfaceProcessorNode.b bVar = (DualSurfaceProcessorNode.b) obj;
            if (this.f11664a.equals(bVar.b()) && this.f11665b.equals(bVar.c()) && this.f11666c.equals(bVar.a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f11666c.hashCode() ^ ((((this.f11664a.hashCode() ^ 1000003) * 1000003) ^ this.f11665b.hashCode()) * 1000003);
    }

    public String toString() {
        return "In{primarySurfaceEdge=" + this.f11664a + ", secondarySurfaceEdge=" + this.f11665b + ", outConfigs=" + this.f11666c + "}";
    }
}
