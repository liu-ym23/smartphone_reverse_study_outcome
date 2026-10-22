package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.ApiCompat;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class OutputConfigurationCompat {
    public static final int STREAM_USE_CASE_NONE = -1;
    public static final int SURFACE_GROUP_ID_NONE = -1;
    private final OutputConfigurationCompatImpl mImpl;

    public interface OutputConfigurationCompatImpl {
        void addSurface(Surface r100);

        void enableSurfaceSharing();

        long getDynamicRangeProfile();

        int getMaxSharedSurfaceCount();

        int getMirrorMode();

        Object getOutputConfiguration();

        String getPhysicalCameraId();

        long getStreamUseCase();

        Surface getSurface();

        int getSurfaceGroupId();

        List<Surface> getSurfaces();

        void removeSurface(Surface r100);

        void setDynamicRangeProfile(long r100);

        void setMirrorMode(int r100);

        void setPhysicalCameraId(String r100);

        void setStreamUseCase(long r100);
    }

    public void enableSurfaceSharing() {
        this.mImpl.enableSurfaceSharing();
    }

    public long getDynamicRangeProfile() {
        return this.mImpl.getDynamicRangeProfile();
    }

    public int getMaxSharedSurfaceCount() {
        return this.mImpl.getMaxSharedSurfaceCount();
    }

    public int getMirrorMode() {
        return this.mImpl.getMirrorMode();
    }

    public String getPhysicalCameraId() {
        return this.mImpl.getPhysicalCameraId();
    }

    public long getStreamUseCase() {
        return this.mImpl.getStreamUseCase();
    }

    public Surface getSurface() {
        return this.mImpl.getSurface();
    }

    public int getSurfaceGroupId() {
        return this.mImpl.getSurfaceGroupId();
    }

    public List<Surface> getSurfaces() {
        return this.mImpl.getSurfaces();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public Object unwrap() {
        return this.mImpl.getOutputConfiguration();
    }

    public OutputConfigurationCompat(OutputConfiguration r100) {
        this.mImpl = OutputConfigurationCompatApi33Impl.wrap(r100);
    }

    public static OutputConfigurationCompat wrap(Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 33) goto L9;
        OutputConfigurationCompatImpl r102 = OutputConfigurationCompatApi33Impl.wrap((OutputConfiguration) r100);
    L18:
        if (r102 != null) goto L21;
        return null;
    L21:
        return new OutputConfigurationCompat(r102);
    L9:
        if (r101 < 28) goto L12;
        r102 = OutputConfigurationCompatApi28Impl.wrap((OutputConfiguration) r100);
        goto L18
    L12:
        if (r101 < 26) goto L15;
        r102 = OutputConfigurationCompatApi26Impl.wrap((OutputConfiguration) r100);
        goto L18
    L15:
        if (r101 < 24) goto L17;
        r102 = OutputConfigurationCompatApi24Impl.wrap((OutputConfiguration) r100);
        goto L18
    L17:
        r102 = null;
        goto L18
    }

    public void addSurface(Surface r100) {
        this.mImpl.addSurface(r100);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof OutputConfigurationCompat) == true) goto L7;
        return false;
    L7:
        return this.mImpl.equals(((OutputConfigurationCompat) r100).mImpl);
    }

    public void removeSurface(Surface r100) {
        this.mImpl.removeSurface(r100);
    }

    public void setDynamicRangeProfile(long r100) {
        this.mImpl.setDynamicRangeProfile(r100);
    }

    public void setMirrorMode(int r100) {
        this.mImpl.setMirrorMode(r100);
    }

    public void setPhysicalCameraId(String r100) {
        this.mImpl.setPhysicalCameraId(r100);
    }

    public void setStreamUseCase(long r100) {
        this.mImpl.setStreamUseCase(r100);
    }

    private OutputConfigurationCompat(OutputConfigurationCompatImpl r100) {
        this.mImpl = r100;
    }

    public OutputConfigurationCompat(Surface r100) {
        this(-1, r100);
    }

    public OutputConfigurationCompat(int r100, Surface r101) {
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 33) goto L6;
        this.mImpl = new OutputConfigurationCompatApi33Impl(r100, r101);
        return;
    L6:
        if (r102 < 28) goto L9;
        this.mImpl = new OutputConfigurationCompatApi28Impl(r100, r101);
        return;
    L9:
        if (r102 < 26) goto L12;
        this.mImpl = new OutputConfigurationCompatApi26Impl(r100, r101);
        return;
    L12:
        if (r102 < 24) goto L14;
        this.mImpl = new OutputConfigurationCompatApi24Impl(r100, r101);
        return;
    L14:
        this.mImpl = new OutputConfigurationCompatBaseImpl(r101);
    }

    public <T> OutputConfigurationCompat(Size r100, Class<T> r101) {
        OutputConfiguration r102 = ApiCompat.Api26Impl.newOutputConfiguration(r100, r101);
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 33) goto L6;
        this.mImpl = OutputConfigurationCompatApi33Impl.wrap(r102);
        return;
    L6:
        if (r103 < 28) goto L8;
        this.mImpl = OutputConfigurationCompatApi28Impl.wrap(r102);
        return;
    L8:
        this.mImpl = OutputConfigurationCompatApi26Impl.wrap(r102);
    }
}
