package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureResult;
import android.os.Build;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;
import java.nio.BufferUnderflowException;

/* JADX INFO: loaded from: classes2.dex */
public class Camera2CameraCaptureResult implements CameraCaptureResult {
    private static final String TAG = "C2CameraCaptureResult";
    private final CaptureResult mCaptureResult;
    private final TagBundle mTagBundle;

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AeMode getAeMode() {
        Integer r100 = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AE_MODE);
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
        if (r101 == 0) goto L35;
        if (r101 == 1) goto L33;
        if (r101 == 2) goto L31;
        if (r101 == 3) goto L29;
        if (r101 == 4) goto L27;
        if (r101 == 5) goto L21;
        return CameraCaptureMetaData.AeMode.UNKNOWN;
    L21:
        if (Build.VERSION.SDK_INT < 28) goto L25;
        return CameraCaptureMetaData.AeMode.ON_EXTERNAL_FLASH;
    L25:
        return CameraCaptureMetaData.AeMode.UNKNOWN;
    L27:
        return CameraCaptureMetaData.AeMode.ON_AUTO_FLASH_REDEYE;
    L29:
        return CameraCaptureMetaData.AeMode.ON_ALWAYS_FLASH;
    L31:
        return CameraCaptureMetaData.AeMode.ON_AUTO_FLASH;
    L33:
        return CameraCaptureMetaData.AeMode.ON;
    L35:
        return CameraCaptureMetaData.AeMode.OFF;
    L5:
        return CameraCaptureMetaData.AeMode.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AeState getAeState() {
        Integer r100 = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
        if (r101 == 0) goto L29;
        if (r101 == 1) goto L27;
        if (r101 == 2) goto L25;
        if (r101 == 3) goto L23;
        if (r101 == 4) goto L21;
        if (r101 == 5) goto L27;
        Logger.e(TAG, "Undefined ae state: " + r100);
        return CameraCaptureMetaData.AeState.UNKNOWN;
    L21:
        return CameraCaptureMetaData.AeState.FLASH_REQUIRED;
    L23:
        return CameraCaptureMetaData.AeState.LOCKED;
    L25:
        return CameraCaptureMetaData.AeState.CONVERGED;
    L27:
        return CameraCaptureMetaData.AeState.SEARCHING;
    L29:
        return CameraCaptureMetaData.AeState.INACTIVE;
    L5:
        return CameraCaptureMetaData.AeState.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AfMode getAfMode() {
        Integer r100 = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AF_MODE);
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
        if (r101 == 0) goto L25;
        if (r101 == 1) goto L23;
        if (r101 == 2) goto L23;
        if (r101 == 3) goto L21;
        if (r101 == 4) goto L21;
        if (r101 == 5) goto L25;
        Logger.e(TAG, "Undefined af mode: " + r100);
        return CameraCaptureMetaData.AfMode.UNKNOWN;
    L21:
        return CameraCaptureMetaData.AfMode.ON_CONTINUOUS_AUTO;
    L23:
        return CameraCaptureMetaData.AfMode.ON_MANUAL_AUTO;
    L25:
        return CameraCaptureMetaData.AfMode.OFF;
    L5:
        return CameraCaptureMetaData.AfMode.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AfState getAfState() {
        Integer r100 = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        if (r100 != null) goto L7;
        return CameraCaptureMetaData.AfState.UNKNOWN;
    L7:
        switch(r100.intValue()) {
            case 0: goto L21;
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L19;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            default: goto L8;
        };
    L8:
        Logger.e(TAG, "Undefined af state: " + r100);
        return CameraCaptureMetaData.AfState.UNKNOWN;
    L11:
        return CameraCaptureMetaData.AfState.PASSIVE_NOT_FOCUSED;
    L13:
        return CameraCaptureMetaData.AfState.LOCKED_NOT_FOCUSED;
    L15:
        return CameraCaptureMetaData.AfState.LOCKED_FOCUSED;
    L17:
        return CameraCaptureMetaData.AfState.PASSIVE_FOCUSED;
    L19:
        return CameraCaptureMetaData.AfState.SCANNING;
    L21:
        return CameraCaptureMetaData.AfState.INACTIVE;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AwbMode getAwbMode() {
        Integer r100 = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AWB_MODE);
        if (r100 != null) goto L7;
        return CameraCaptureMetaData.AwbMode.UNKNOWN;
    L7:
        switch(r100.intValue()) {
            case 0: goto L27;
            case 1: goto L25;
            case 2: goto L23;
            case 3: goto L21;
            case 4: goto L19;
            case 5: goto L17;
            case 6: goto L15;
            case 7: goto L13;
            case 8: goto L11;
            default: goto L9;
        };
    L9:
        return CameraCaptureMetaData.AwbMode.UNKNOWN;
    L11:
        return CameraCaptureMetaData.AwbMode.SHADE;
    L13:
        return CameraCaptureMetaData.AwbMode.TWILIGHT;
    L15:
        return CameraCaptureMetaData.AwbMode.CLOUDY_DAYLIGHT;
    L17:
        return CameraCaptureMetaData.AwbMode.DAYLIGHT;
    L19:
        return CameraCaptureMetaData.AwbMode.WARM_FLUORESCENT;
    L21:
        return CameraCaptureMetaData.AwbMode.FLUORESCENT;
    L23:
        return CameraCaptureMetaData.AwbMode.INCANDESCENT;
    L25:
        return CameraCaptureMetaData.AwbMode.AUTO;
    L27:
        return CameraCaptureMetaData.AwbMode.OFF;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.AwbState getAwbState() {
        Integer r100 = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
        if (r101 == 0) goto L23;
        if (r101 == 1) goto L21;
        if (r101 == 2) goto L19;
        if (r101 == 3) goto L17;
        Logger.e(TAG, "Undefined awb state: " + r100);
        return CameraCaptureMetaData.AwbState.UNKNOWN;
    L17:
        return CameraCaptureMetaData.AwbState.LOCKED;
    L19:
        return CameraCaptureMetaData.AwbState.CONVERGED;
    L21:
        return CameraCaptureMetaData.AwbState.METERING;
    L23:
        return CameraCaptureMetaData.AwbState.INACTIVE;
    L5:
        return CameraCaptureMetaData.AwbState.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CameraCaptureMetaData.FlashState getFlashState() {
        Integer r100 = (Integer) this.mCaptureResult.get(CaptureResult.FLASH_STATE);
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
        if (r101 == 0) goto L23;
        if (r101 == 1) goto L23;
        if (r101 == 2) goto L21;
        if (r101 == 3) goto L19;
        if (r101 == 4) goto L19;
        Logger.e(TAG, "Undefined flash state: " + r100);
        return CameraCaptureMetaData.FlashState.UNKNOWN;
    L19:
        return CameraCaptureMetaData.FlashState.FIRED;
    L21:
        return CameraCaptureMetaData.FlashState.READY;
    L23:
        return CameraCaptureMetaData.FlashState.NONE;
    L5:
        return CameraCaptureMetaData.FlashState.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public long getTimestamp() {
        Long r100 = (Long) this.mCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP);
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.longValue();
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public CaptureResult getCaptureResult() {
        return this.mCaptureResult;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public TagBundle getTagBundle() {
        return this.mTagBundle;
    }

    public Camera2CameraCaptureResult(CaptureResult r100) {
        this(TagBundle.emptyBundle(), r100);
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public void populateExifData(ExifData.Builder r100) {
        CameraCaptureResult.CC.$default$populateExifData(this, r100);
        Integer r101 = (Integer) this.mCaptureResult.get(CaptureResult.JPEG_ORIENTATION);     // Catch: BufferUnderflowException -> L7
        if (r101 == null) goto L8;
        r100.setOrientationDegrees(r101.intValue());     // Catch: BufferUnderflowException -> L7
    L8:
        Long r102 = (Long) this.mCaptureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
        if (r102 == null) goto L11;
        r100.setExposureTimeNanos(r102.longValue());
    L11:
        Float r103 = (Float) this.mCaptureResult.get(CaptureResult.LENS_APERTURE);
        if (r103 == null) goto L14;
        r100.setLensFNumber(r103.floatValue());
    L14:
        Integer r104 = (Integer) this.mCaptureResult.get(CaptureResult.SENSOR_SENSITIVITY);
        if (r104 != null) goto L17;
    L22:
        Float r105 = (Float) this.mCaptureResult.get(CaptureResult.LENS_FOCAL_LENGTH);
        if (r105 == null) goto L25;
        r100.setFocalLength(r105.floatValue());
    L25:
        Integer r106 = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_AWB_MODE);
        if (r106 == null) goto L34;
        ExifData.WhiteBalanceMode r107 = ExifData.WhiteBalanceMode.AUTO;
        if (r106.intValue() != 0) goto L30;
        r107 = ExifData.WhiteBalanceMode.MANUAL;
    L30:
        r100.setWhiteBalanceMode(r107);
        return;
    L34:
        return;
    L17:
        if (Build.VERSION.SDK_INT < 24) goto L21;
        Integer r108 = (Integer) this.mCaptureResult.get(CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST);
        if (r108 == null) goto L21;
        r104 = Integer.valueOf(r104.intValue() * ((int) (r108.intValue() / 100.0f)));
    L21:
        r100.setIso(r104.intValue());
    L7:
        Logger.w(TAG, "Failed to get JPEG orientation.");
        goto L8
    }

    public Camera2CameraCaptureResult(TagBundle r100, CaptureResult r101) {
        this.mTagBundle = r100;
        this.mCaptureResult = r101;
    }
}
