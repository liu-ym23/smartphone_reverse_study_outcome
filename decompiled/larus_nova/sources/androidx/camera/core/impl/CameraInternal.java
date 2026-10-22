package androidx.camera.core.impl;

import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase;
import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public interface CameraInternal extends Camera, UseCase.StateChangeCallback {

    /* JADX INFO: renamed from: androidx.camera.core.impl.CameraInternal$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$getHasTransform(CameraInternal r100) {
            return true;
        }

        public static void $default$setActiveResumingMode(CameraInternal r100, boolean r101) {
        }

        public static void $default$setExtendedConfig(CameraInternal r100, CameraConfig r101) {
        }

        public static void $default$setPrimary(CameraInternal r100, boolean r101) {
        }

        public static CameraControl $default$getCameraControl(CameraInternal r100) {
            return r100.getCameraControlInternal();
        }

        public static CameraInfo $default$getCameraInfo(CameraInternal r100) {
            return r100.getCameraInfoInternal();
        }

        public static CameraConfig $default$getExtendedConfig(CameraInternal r100) {
            return CameraConfigs.defaultConfig();
        }

        public static boolean $default$isFrontFacing(CameraInternal r100) {
            if (r100.getCameraInfo().getLensFacing() != 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State CLOSED = null;
        public static final State CLOSING = null;
        public static final State CONFIGURED = null;
        public static final State OPEN = null;
        public static final State OPENING = null;
        public static final State PENDING_OPEN = null;
        public static final State RELEASED = null;
        public static final State RELEASING = null;
        private final boolean mHoldsCameraSlot;

        private static /* synthetic */ State[] $values() {
            return new State[]{RELEASED, RELEASING, CLOSED, PENDING_OPEN, CLOSING, OPENING, OPEN, CONFIGURED};
        }

        static {
            RELEASED = new State("RELEASED", 0, false);
            RELEASING = new State("RELEASING", 1, true);
            CLOSED = new State(ErrorCode.CLOSED, 2, false);
            PENDING_OPEN = new State("PENDING_OPEN", 3, false);
            CLOSING = new State("CLOSING", 4, true);
            OPENING = new State("OPENING", 5, true);
            OPEN = new State("OPEN", 6, true);
            CONFIGURED = new State("CONFIGURED", 7, true);
            $VALUES = $values();
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public boolean holdsCameraSlot() {
            return this.mHoldsCameraSlot;
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        private State(String r100, int r101, boolean r102) {
            super(r100, r101);
            this.mHoldsCameraSlot = r102;
        }
    }

    void attachUseCases(Collection<UseCase> r100);

    void close();

    void detachUseCases(Collection<UseCase> r100);

    @Override // androidx.camera.core.Camera
    CameraControl getCameraControl();

    CameraControlInternal getCameraControlInternal();

    @Override // androidx.camera.core.Camera
    CameraInfo getCameraInfo();

    CameraInfoInternal getCameraInfoInternal();

    Observable<State> getCameraState();

    @Override // androidx.camera.core.Camera
    CameraConfig getExtendedConfig();

    boolean getHasTransform();

    boolean isFrontFacing();

    void open();

    ListenableFuture<Void> release();

    void setActiveResumingMode(boolean r100);

    void setExtendedConfig(CameraConfig r100);

    void setPrimary(boolean r100);
}
