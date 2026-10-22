package androidx.camera.camera2.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class Camera2ImplConfig extends CaptureRequestOptions {
    public static final String CAPTURE_REQUEST_ID_STEM = "camera2.captureRequest.option.";
    public static final Config.Option<Object> CAPTURE_REQUEST_TAG_OPTION = null;
    public static final Config.Option<CameraDevice.StateCallback> DEVICE_STATE_CALLBACK_OPTION = null;
    public static final Config.Option<CameraCaptureSession.CaptureCallback> SESSION_CAPTURE_CALLBACK_OPTION = null;
    public static final Config.Option<String> SESSION_PHYSICAL_CAMERA_ID_OPTION = null;
    public static final Config.Option<CameraCaptureSession.StateCallback> SESSION_STATE_CALLBACK_OPTION = null;
    public static final Config.Option<Long> STREAM_USE_CASE_OPTION = null;
    public static final Config.Option<Integer> TEMPLATE_TYPE_OPTION = null;

    public static final class Builder implements ExtendableBuilder<Camera2ImplConfig> {
        private final MutableOptionsBundle mMutableOptionsBundle;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.camera.core.ExtendableBuilder
        public Camera2ImplConfig build() {
            return new Camera2ImplConfig(OptionsBundle.from(this.mMutableOptionsBundle));
        }

        public Builder() {
            this.mMutableOptionsBundle = MutableOptionsBundle.create();
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public MutableConfig getMutableConfig() {
            return this.mMutableOptionsBundle;
        }

        @Override // androidx.camera.core.ExtendableBuilder
        public /* bridge */ /* synthetic */ Camera2ImplConfig build() {
            return build();
        }

        public Builder insertAllOptions(Config r100) {
            insertAllOptions(r100, Config.OptionPriority.OPTIONAL);
            return this;
        }

        public Builder insertAllOptions(Config r100, Config.OptionPriority r101) {
            Iterator<Config.Option<?>> r102 = r100.listOptions().iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            Config.Option<?> r103 = r102.next();
            this.mMutableOptionsBundle.insertOption(r103, r101, r100.retrieveOption(r103));
            goto L4
        L6:
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <ValueT> Builder setCaptureRequestOption(CaptureRequest.Key<ValueT> r100, ValueT r101) {
            Config.Option<Object> r102 = Camera2ImplConfig.createCaptureRequestOption(r100);
            this.mMutableOptionsBundle.insertOption(r102, r101);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <ValueT> Builder setCaptureRequestOptionWithPriority(CaptureRequest.Key<ValueT> r100, ValueT r101, Config.OptionPriority r102) {
            Config.Option<Object> r103 = Camera2ImplConfig.createCaptureRequestOption(r100);
            this.mMutableOptionsBundle.insertOption(r103, r102, r101);
            return this;
        }
    }

    static {
        TEMPLATE_TYPE_OPTION = Config.Option.create("camera2.captureRequest.templateType", Integer.TYPE);
        STREAM_USE_CASE_OPTION = Config.Option.create("camera2.cameraCaptureSession.streamUseCase", Long.TYPE);
        DEVICE_STATE_CALLBACK_OPTION = Config.Option.create("camera2.cameraDevice.stateCallback", CameraDevice.StateCallback.class);
        SESSION_STATE_CALLBACK_OPTION = Config.Option.create("camera2.cameraCaptureSession.stateCallback", CameraCaptureSession.StateCallback.class);
        SESSION_CAPTURE_CALLBACK_OPTION = Config.Option.create("camera2.cameraCaptureSession.captureCallback", CameraCaptureSession.CaptureCallback.class);
        CAPTURE_REQUEST_TAG_OPTION = Config.Option.create("camera2.captureRequest.tag", Object.class);
        SESSION_PHYSICAL_CAMERA_ID_OPTION = Config.Option.create("camera2.cameraCaptureSession.physicalCameraId", String.class);
    }

    public CaptureRequestOptions getCaptureRequestOptions() {
        return CaptureRequestOptions.Builder.from(getConfig()).build();
    }

    public Camera2ImplConfig(Config r100) {
        super(r100);
    }

    public static Config.Option<Object> createCaptureRequestOption(CaptureRequest.Key<?> r100) {
        return Config.Option.create(CAPTURE_REQUEST_ID_STEM + r100.getName(), Object.class, r100);
    }

    public Object getCaptureRequestTag(Object r100) {
        return getConfig().retrieveOption(CAPTURE_REQUEST_TAG_OPTION, r100);
    }

    public int getCaptureRequestTemplate(int r100) {
        return ((Integer) getConfig().retrieveOption(TEMPLATE_TYPE_OPTION, Integer.valueOf(r100))).intValue();
    }

    public CameraDevice.StateCallback getDeviceStateCallback(CameraDevice.StateCallback r100) {
        return (CameraDevice.StateCallback) getConfig().retrieveOption(DEVICE_STATE_CALLBACK_OPTION, r100);
    }

    public String getPhysicalCameraId(String r100) {
        return (String) getConfig().retrieveOption(SESSION_PHYSICAL_CAMERA_ID_OPTION, r100);
    }

    public CameraCaptureSession.CaptureCallback getSessionCaptureCallback(CameraCaptureSession.CaptureCallback r100) {
        return (CameraCaptureSession.CaptureCallback) getConfig().retrieveOption(SESSION_CAPTURE_CALLBACK_OPTION, r100);
    }

    public CameraCaptureSession.StateCallback getSessionStateCallback(CameraCaptureSession.StateCallback r100) {
        return (CameraCaptureSession.StateCallback) getConfig().retrieveOption(SESSION_STATE_CALLBACK_OPTION, r100);
    }

    public long getStreamUseCase(long r100) {
        return ((Long) getConfig().retrieveOption(STREAM_USE_CASE_OPTION, Long.valueOf(r100))).longValue();
    }
}
