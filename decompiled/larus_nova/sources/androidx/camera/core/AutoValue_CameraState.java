package androidx.camera.core;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_CameraState extends CameraState {
    private final CameraState.StateError error;
    private final CameraState.Type type;

    public int hashCode() {
        int r100 = (this.type.hashCode() ^ 1000003) * 1000003;
        CameraState.StateError r101 = this.error;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 ^ r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "CameraState{type=" + this.type + ", error=" + this.error + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.CameraState
    public CameraState.StateError getError() {
        return this.error;
    }

    @Override // androidx.camera.core.CameraState
    public CameraState.Type getType() {
        return this.type;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof CameraState) == false) goto L19;
        CameraState r101 = (CameraState) r100;
        if (this.type.equals(r101.getType()) == false) goto L17;
        CameraState.StateError r102 = this.error;
        if (r102 != null) goto L15;
        if (r101.getError() != null) goto L17;
        return true;
    L15:
        if (r102.equals(r101.getError()) == false) goto L17;
        return true;
    L17:
        return false;
    L19:
        return false;
    }

    public AutoValue_CameraState(CameraState.Type r100, CameraState.StateError r101) {
        if (r100 == null) goto L7;
        this.type = r100;
        this.error = r101;
        return;
    L7:
        throw new NullPointerException("Null type");
    }
}
