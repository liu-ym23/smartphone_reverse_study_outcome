package androidx.camera.core;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_CameraState_StateError extends CameraState.StateError {
    private final Throwable cause;
    private final int code;

    public int hashCode() {
        int r100 = (this.code ^ 1000003) * 1000003;
        Throwable r101 = this.cause;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 ^ r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "StateError{code=" + this.code + ", cause=" + this.cause + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.CameraState.StateError
    public Throwable getCause() {
        return this.cause;
    }

    @Override // androidx.camera.core.CameraState.StateError
    public int getCode() {
        return this.code;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof CameraState.StateError) == false) goto L19;
        CameraState.StateError r101 = (CameraState.StateError) r100;
        if (this.code != r101.getCode()) goto L17;
        Throwable r102 = this.cause;
        if (r102 != null) goto L15;
        if (r101.getCause() != null) goto L17;
        return true;
    L15:
        if (r102.equals(r101.getCause()) == false) goto L17;
        return true;
    L17:
        return false;
    L19:
        return false;
    }

    public AutoValue_CameraState_StateError(int r100, Throwable r101) {
        this.code = r100;
        this.cause = r101;
    }
}
