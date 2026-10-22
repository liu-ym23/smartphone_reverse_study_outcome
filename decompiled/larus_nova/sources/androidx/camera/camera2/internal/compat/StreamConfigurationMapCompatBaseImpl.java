package androidx.camera.camera2.internal.compat;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Size;
import androidx.camera.core.Logger;

/* JADX INFO: loaded from: classes2.dex */
class StreamConfigurationMapCompatBaseImpl implements StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl {
    private static final String TAG = "StreamConfigurationMapCompatBaseImpl";
    final StreamConfigurationMap mStreamConfigurationMap;

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static Size[] getHighResolutionOutputSizes(StreamConfigurationMap r100, int r101) {
            return r100.getHighResolutionOutputSizes(r101);
        }
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public int[] getOutputFormats() {
        return this.mStreamConfigurationMap.getOutputFormats();
    L6:
        e = move-exception;
        Logger.w(TAG, "Failed to get output formats from StreamConfigurationMap", e);
        return null;
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public StreamConfigurationMap unwrap() {
        return this.mStreamConfigurationMap;
    }

    public StreamConfigurationMapCompatBaseImpl(StreamConfigurationMap r100) {
        this.mStreamConfigurationMap = r100;
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public Size[] getHighResolutionOutputSizes(int r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return null;
    L5:
        return Api23Impl.getHighResolutionOutputSizes(this.mStreamConfigurationMap, r100);
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public Size[] getOutputSizes(int r100) {
        if (r100 != 34) goto L6;
        return this.mStreamConfigurationMap.getOutputSizes(SurfaceTexture.class);
    L6:
        return this.mStreamConfigurationMap.getOutputSizes(r100);
    }

    @Override // androidx.camera.camera2.internal.compat.StreamConfigurationMapCompat.StreamConfigurationMapCompatImpl
    public <T> Size[] getOutputSizes(Class<T> r100) {
        return this.mStreamConfigurationMap.getOutputSizes(r100);
    }
}
