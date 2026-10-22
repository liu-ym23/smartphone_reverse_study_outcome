package androidx.camera.core.impl;

/* JADX INFO: loaded from: classes2.dex */
public interface CaptureStage {

    public static final class DefaultCaptureStage implements CaptureStage {
        private final CaptureConfig mCaptureConfig;

        @Override // androidx.camera.core.impl.CaptureStage
        public int getId() {
            return 0;
        }

        public DefaultCaptureStage() {
            this.mCaptureConfig = new CaptureConfig.Builder().build();
        }

        @Override // androidx.camera.core.impl.CaptureStage
        public CaptureConfig getCaptureConfig() {
            return this.mCaptureConfig;
        }
    }

    CaptureConfig getCaptureConfig();

    int getId();
}
