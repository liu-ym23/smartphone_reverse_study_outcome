package androidx.camera.core.impl;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_CameraThreadConfig extends CameraThreadConfig {
    private final Executor cameraExecutor;
    private final Handler schedulerHandler;

    public int hashCode() {
        return ((this.cameraExecutor.hashCode() ^ 1000003) * 1000003) ^ this.schedulerHandler.hashCode();
    }

    public String toString() {
        return "CameraThreadConfig{cameraExecutor=" + this.cameraExecutor + ", schedulerHandler=" + this.schedulerHandler + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.impl.CameraThreadConfig
    public Executor getCameraExecutor() {
        return this.cameraExecutor;
    }

    @Override // androidx.camera.core.impl.CameraThreadConfig
    public Handler getSchedulerHandler() {
        return this.schedulerHandler;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof CameraThreadConfig) == false) goto L14;
        CameraThreadConfig r101 = (CameraThreadConfig) r100;
        if (this.cameraExecutor.equals(r101.getCameraExecutor()) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.schedulerHandler.equals(r101.getSchedulerHandler()) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public AutoValue_CameraThreadConfig(Executor r100, Handler r101) {
        if (r100 == null) goto L11;
        this.cameraExecutor = r100;
        if (r101 == null) goto L9;
        this.schedulerHandler = r101;
        return;
    L9:
        throw new NullPointerException("Null schedulerHandler");
    L11:
        throw new NullPointerException("Null cameraExecutor");
    }
}
