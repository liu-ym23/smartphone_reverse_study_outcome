package androidx.camera.core.processing.concurrent;

import androidx.camera.core.processing.util.OutConfig;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DualOutConfig {
    public DualOutConfig() {
    }

    public abstract OutConfig getPrimaryOutConfig();

    public abstract OutConfig getSecondaryOutConfig();

    public static DualOutConfig of(OutConfig r100, OutConfig r101) {
        return new AutoValue_DualOutConfig(r100, r101);
    }
}
