package androidx.camera.core;

import androidx.camera.core.CameraState;

/* loaded from: classes.dex */
public final class b extends CameraState {

    /* renamed from: a, reason: collision with root package name */
    public final CameraState.Type f11275a;

    /* renamed from: b, reason: collision with root package name */
    public final CameraState.a f11276b;

    public b(CameraState.Type type, CameraState.a aVar) {
        if (type == null) {
            throw new NullPointerException("Null type");
        }
        this.f11275a = type;
        this.f11276b = aVar;
    }

    @Override // androidx.camera.core.CameraState
    public CameraState.a b() {
        return this.f11276b;
    }

    @Override // androidx.camera.core.CameraState
    public CameraState.Type c() {
        return this.f11275a;
    }

    public boolean equals(Object obj) {
        CameraState.a aVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof CameraState) {
            CameraState cameraState = (CameraState) obj;
            if (this.f11275a.equals(cameraState.c()) && ((aVar = this.f11276b) != null ? aVar.equals(cameraState.b()) : cameraState.b() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f11275a.hashCode() ^ 1000003) * 1000003;
        CameraState.a aVar = this.f11276b;
        return (aVar == null ? 0 : aVar.hashCode()) ^ iHashCode;
    }

    public String toString() {
        return "CameraState{type=" + this.f11275a + ", error=" + this.f11276b + "}";
    }
}
