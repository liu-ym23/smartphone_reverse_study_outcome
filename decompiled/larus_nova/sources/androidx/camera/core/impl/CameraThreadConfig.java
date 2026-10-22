package androidx.camera.core.impl;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CameraThreadConfig {
    public CameraThreadConfig() {
    }

    public abstract Executor getCameraExecutor();

    public abstract Handler getSchedulerHandler();

    public static CameraThreadConfig create(Executor r100, Handler r101) {
        return new AutoValue_CameraThreadConfig(r100, r101);
    }
}
