package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.CameraInternal;
import androidx.core.util.Consumer;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public interface SurfaceOutput extends Closeable {

    /* JADX INFO: renamed from: androidx.camera.core.SurfaceOutput$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$getFormat(SurfaceOutput r100) {
            return 34;
        }

        public static void $default$updateTransformMatrix(SurfaceOutput r100, float[] r101, float[] r102, boolean r103) {
        }

        public static Matrix $default$getSensorToBufferTransform(SurfaceOutput r100) {
            return new Matrix();
        }
    }

    public static abstract class CameraInputInfo {
        public CameraInputInfo() {
        }

        public abstract CameraInternal getCameraInternal();

        public abstract Rect getInputCropRect();

        public abstract Size getInputSize();

        public abstract boolean getMirroring();

        public abstract int getRotationDegrees();

        public static CameraInputInfo of(Size r100, Rect r101, CameraInternal r102, int r110, boolean r111) {
            return new AutoValue_SurfaceOutput_CameraInputInfo(r100, r101, r102, r110, r111);
        }
    }

    public static abstract class Event {
        public static final int EVENT_REQUEST_CLOSE = 0;

        @Retention(RetentionPolicy.SOURCE)
        public @interface EventCode {
        }

        public abstract int getEventCode();

        public abstract SurfaceOutput getSurfaceOutput();

        public Event() {
        }

        public static Event of(int r100, SurfaceOutput r101) {
            return new AutoValue_SurfaceOutput_Event(r100, r101);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int getFormat();

    Matrix getSensorToBufferTransform();

    Size getSize();

    Surface getSurface(Executor r100, Consumer<Event> r101);

    int getTargets();

    void updateTransformMatrix(float[] r100, float[] r101);

    void updateTransformMatrix(float[] r100, float[] r101, boolean r102);
}
