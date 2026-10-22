package o;

import D.C0761b0;
import android.hardware.camera2.CaptureResult;
import android.util.Log;
import androidx.camera.core.impl.CameraCaptureMetaData$AeMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.CameraCaptureMetaData$FlashState;
import androidx.camera.core.impl.utils.ExifData;
import com.autonavi.aps.amapapi.config.Const;
import java.nio.BufferUnderflowException;
import kotlin.Metadata;
import t.C5473b;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0000H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\u000b\u001a\u00020\n*\u00020\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\u000e\u001a\u00020\r*\u00020\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0013\u0010\u0011\u001a\u00020\u0010*\u00020\u0000H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0013\u0010\u0014\u001a\u00020\u0013*\u00020\u0000H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0013\u0010\u0017\u001a\u00020\u0016*\u00020\u0000H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001b\u0010\u001c\u001a\u00020\u001b*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lw/x;", "Landroidx/camera/core/impl/CameraCaptureMetaData$AfMode;", "l", "(Lw/x;)Landroidx/camera/core/impl/CameraCaptureMetaData$AfMode;", "Landroidx/camera/core/impl/CameraCaptureMetaData$AfState;", "m", "(Lw/x;)Landroidx/camera/core/impl/CameraCaptureMetaData$AfState;", "Landroidx/camera/core/impl/CameraCaptureMetaData$AeMode;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lw/x;)Landroidx/camera/core/impl/CameraCaptureMetaData$AeMode;", "Landroidx/camera/core/impl/CameraCaptureMetaData$AeState;", "k", "(Lw/x;)Landroidx/camera/core/impl/CameraCaptureMetaData$AeState;", "Landroidx/camera/core/impl/CameraCaptureMetaData$AwbMode;", "n", "(Lw/x;)Landroidx/camera/core/impl/CameraCaptureMetaData$AwbMode;", "Landroidx/camera/core/impl/CameraCaptureMetaData$AwbState;", "o", "(Lw/x;)Landroidx/camera/core/impl/CameraCaptureMetaData$AwbState;", "Landroidx/camera/core/impl/CameraCaptureMetaData$FlashState;", "p", "(Lw/x;)Landroidx/camera/core/impl/CameraCaptureMetaData$FlashState;", "", "q", "(Lw/x;)J", "Landroidx/camera/core/impl/utils/ExifData$b;", "exifData", "LY8/t;", "r", "(Lw/x;Landroidx/camera/core/impl/utils/ExifData$b;)V", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class r {
    public static final CameraCaptureMetaData$AeMode j(w.x xVar) {
        CaptureResult.Key CONTROL_AE_MODE = CaptureResult.CONTROL_AE_MODE;
        kotlin.jvm.internal.p.h(CONTROL_AE_MODE, "CONTROL_AE_MODE");
        Integer num = (Integer) xVar.U(CONTROL_AE_MODE);
        if (num != null && num.intValue() == 0) {
            return CameraCaptureMetaData$AeMode.OFF;
        }
        if (num != null && num.intValue() == 1) {
            return CameraCaptureMetaData$AeMode.ON;
        }
        if (num != null && num.intValue() == 2) {
            return CameraCaptureMetaData$AeMode.ON_AUTO_FLASH;
        }
        if (num != null && num.intValue() == 3) {
            return CameraCaptureMetaData$AeMode.ON_ALWAYS_FLASH;
        }
        if (num != null && num.intValue() == 4) {
            return CameraCaptureMetaData$AeMode.ON_AUTO_FLASH_REDEYE;
        }
        if (num == null) {
            return CameraCaptureMetaData$AeMode.UNKNOWN;
        }
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "Unknown AE mode (" + num.intValue() + ") for " + ((Object) w.y.f(xVar.m1())) + '!');
        }
        return CameraCaptureMetaData$AeMode.UNKNOWN;
    }

    public static final CameraCaptureMetaData$AeState k(w.x xVar) {
        CaptureResult.Key CONTROL_AE_STATE = CaptureResult.CONTROL_AE_STATE;
        kotlin.jvm.internal.p.h(CONTROL_AE_STATE, "CONTROL_AE_STATE");
        Integer num = (Integer) xVar.U(CONTROL_AE_STATE);
        if (num != null && num.intValue() == 0) {
            return CameraCaptureMetaData$AeState.INACTIVE;
        }
        if ((num != null && num.intValue() == 1) || (num != null && num.intValue() == 5)) {
            return CameraCaptureMetaData$AeState.SEARCHING;
        }
        if (num != null && num.intValue() == 4) {
            return CameraCaptureMetaData$AeState.FLASH_REQUIRED;
        }
        if (num != null && num.intValue() == 2) {
            return CameraCaptureMetaData$AeState.CONVERGED;
        }
        if (num != null && num.intValue() == 3) {
            return CameraCaptureMetaData$AeState.LOCKED;
        }
        if (num == null) {
            return CameraCaptureMetaData$AeState.UNKNOWN;
        }
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "Unknown AE state (" + num.intValue() + ") for " + ((Object) w.y.f(xVar.m1())) + '!');
        }
        return CameraCaptureMetaData$AeState.UNKNOWN;
    }

    public static final CameraCaptureMetaData$AfMode l(w.x xVar) {
        CaptureResult.Key CONTROL_AF_MODE = CaptureResult.CONTROL_AF_MODE;
        kotlin.jvm.internal.p.h(CONTROL_AF_MODE, "CONTROL_AF_MODE");
        Integer num = (Integer) xVar.U(CONTROL_AF_MODE);
        if ((num != null && num.intValue() == 0) || (num != null && num.intValue() == 5)) {
            return CameraCaptureMetaData$AfMode.OFF;
        }
        if ((num != null && num.intValue() == 1) || (num != null && num.intValue() == 2)) {
            return CameraCaptureMetaData$AfMode.ON_MANUAL_AUTO;
        }
        if ((num != null && num.intValue() == 4) || (num != null && num.intValue() == 3)) {
            return CameraCaptureMetaData$AfMode.ON_CONTINUOUS_AUTO;
        }
        if (num == null) {
            return CameraCaptureMetaData$AfMode.UNKNOWN;
        }
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "Unknown AF mode (" + num.intValue() + ") for " + ((Object) w.y.f(xVar.m1())) + '!');
        }
        return CameraCaptureMetaData$AfMode.UNKNOWN;
    }

    public static final CameraCaptureMetaData$AfState m(w.x xVar) {
        CaptureResult.Key CONTROL_AF_STATE = CaptureResult.CONTROL_AF_STATE;
        kotlin.jvm.internal.p.h(CONTROL_AF_STATE, "CONTROL_AF_STATE");
        Integer num = (Integer) xVar.U(CONTROL_AF_STATE);
        if (num != null && num.intValue() == 0) {
            return CameraCaptureMetaData$AfState.INACTIVE;
        }
        if ((num != null && num.intValue() == 3) || (num != null && num.intValue() == 1)) {
            return CameraCaptureMetaData$AfState.SCANNING;
        }
        if (num != null && num.intValue() == 4) {
            return CameraCaptureMetaData$AfState.LOCKED_FOCUSED;
        }
        if (num != null && num.intValue() == 5) {
            return CameraCaptureMetaData$AfState.LOCKED_NOT_FOCUSED;
        }
        if (num != null && num.intValue() == 2) {
            return CameraCaptureMetaData$AfState.PASSIVE_FOCUSED;
        }
        if (num != null && num.intValue() == 6) {
            return CameraCaptureMetaData$AfState.PASSIVE_NOT_FOCUSED;
        }
        if (num == null) {
            return CameraCaptureMetaData$AfState.UNKNOWN;
        }
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "Unknown AF state (" + num.intValue() + ") for " + ((Object) w.y.f(xVar.m1())) + '!');
        }
        return CameraCaptureMetaData$AfState.UNKNOWN;
    }

    public static final CameraCaptureMetaData$AwbMode n(w.x xVar) {
        CaptureResult.Key CONTROL_AWB_MODE = CaptureResult.CONTROL_AWB_MODE;
        kotlin.jvm.internal.p.h(CONTROL_AWB_MODE, "CONTROL_AWB_MODE");
        Integer num = (Integer) xVar.U(CONTROL_AWB_MODE);
        if (num != null && num.intValue() == 0) {
            return CameraCaptureMetaData$AwbMode.OFF;
        }
        if (num != null && num.intValue() == 1) {
            return CameraCaptureMetaData$AwbMode.AUTO;
        }
        if (num != null && num.intValue() == 2) {
            return CameraCaptureMetaData$AwbMode.INCANDESCENT;
        }
        if (num != null && num.intValue() == 3) {
            return CameraCaptureMetaData$AwbMode.FLUORESCENT;
        }
        if (num != null && num.intValue() == 4) {
            return CameraCaptureMetaData$AwbMode.WARM_FLUORESCENT;
        }
        if (num != null && num.intValue() == 5) {
            return CameraCaptureMetaData$AwbMode.DAYLIGHT;
        }
        if (num != null && num.intValue() == 6) {
            return CameraCaptureMetaData$AwbMode.CLOUDY_DAYLIGHT;
        }
        if (num != null && num.intValue() == 7) {
            return CameraCaptureMetaData$AwbMode.TWILIGHT;
        }
        if (num != null && num.intValue() == 8) {
            return CameraCaptureMetaData$AwbMode.SHADE;
        }
        if (num == null) {
            return CameraCaptureMetaData$AwbMode.UNKNOWN;
        }
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "Unknown AWB mode (" + num.intValue() + ") for " + ((Object) w.y.f(xVar.m1())) + '!');
        }
        return CameraCaptureMetaData$AwbMode.UNKNOWN;
    }

    public static final CameraCaptureMetaData$AwbState o(w.x xVar) {
        CaptureResult.Key CONTROL_AWB_STATE = CaptureResult.CONTROL_AWB_STATE;
        kotlin.jvm.internal.p.h(CONTROL_AWB_STATE, "CONTROL_AWB_STATE");
        Integer num = (Integer) xVar.U(CONTROL_AWB_STATE);
        if (num != null && num.intValue() == 0) {
            return CameraCaptureMetaData$AwbState.INACTIVE;
        }
        if (num != null && num.intValue() == 1) {
            return CameraCaptureMetaData$AwbState.METERING;
        }
        if (num != null && num.intValue() == 2) {
            return CameraCaptureMetaData$AwbState.CONVERGED;
        }
        if (num != null && num.intValue() == 3) {
            return CameraCaptureMetaData$AwbState.LOCKED;
        }
        if (num == null) {
            return CameraCaptureMetaData$AwbState.UNKNOWN;
        }
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "Unknown AWB state (" + num.intValue() + ") for " + ((Object) w.y.f(xVar.m1())) + '!');
        }
        return CameraCaptureMetaData$AwbState.UNKNOWN;
    }

    public static final CameraCaptureMetaData$FlashState p(w.x xVar) {
        CaptureResult.Key FLASH_STATE = CaptureResult.FLASH_STATE;
        kotlin.jvm.internal.p.h(FLASH_STATE, "FLASH_STATE");
        Integer num = (Integer) xVar.U(FLASH_STATE);
        if ((num != null && num.intValue() == 0) || (num != null && num.intValue() == 1)) {
            return CameraCaptureMetaData$FlashState.NONE;
        }
        if (num != null && num.intValue() == 2) {
            return CameraCaptureMetaData$FlashState.READY;
        }
        if ((num != null && num.intValue() == 3) || (num != null && num.intValue() == 4)) {
            return CameraCaptureMetaData$FlashState.FIRED;
        }
        if (num == null) {
            return CameraCaptureMetaData$FlashState.UNKNOWN;
        }
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "Unknown flash state (" + num.intValue() + ") for " + ((Object) w.y.f(xVar.m1())) + '!');
        }
        return CameraCaptureMetaData$FlashState.UNKNOWN;
    }

    public static final long q(w.x xVar) {
        CaptureResult.Key SENSOR_TIMESTAMP = CaptureResult.SENSOR_TIMESTAMP;
        kotlin.jvm.internal.p.h(SENSOR_TIMESTAMP, "SENSOR_TIMESTAMP");
        Object objA1 = xVar.a1(SENSOR_TIMESTAMP, -1L);
        kotlin.jvm.internal.p.h(objA1, "getOrDefault(...)");
        return ((Number) objA1).longValue();
    }

    public static final void r(w.x xVar, ExifData.b bVar) {
        try {
            CaptureResult.Key JPEG_ORIENTATION = CaptureResult.JPEG_ORIENTATION;
            kotlin.jvm.internal.p.h(JPEG_ORIENTATION, "JPEG_ORIENTATION");
            Integer num = (Integer) xVar.U(JPEG_ORIENTATION);
            if (num != null) {
                bVar.m(num.intValue());
            }
        } catch (BufferUnderflowException unused) {
            C5473b c5473b = C5473b.f41865a;
            if (C0761b0.k("CXCP")) {
                Log.w(C5473b.TRUNCATED_TAG, "Failed to get JPEG orientation.");
            }
        }
        CaptureResult.Key SENSOR_EXPOSURE_TIME = CaptureResult.SENSOR_EXPOSURE_TIME;
        kotlin.jvm.internal.p.h(SENSOR_EXPOSURE_TIME, "SENSOR_EXPOSURE_TIME");
        Long l10 = (Long) xVar.U(SENSOR_EXPOSURE_TIME);
        if (l10 != null) {
            bVar.f(l10.longValue());
        }
        CaptureResult.Key LENS_APERTURE = CaptureResult.LENS_APERTURE;
        kotlin.jvm.internal.p.h(LENS_APERTURE, "LENS_APERTURE");
        Float f10 = (Float) xVar.U(LENS_APERTURE);
        if (f10 != null) {
            bVar.l(f10.floatValue());
        }
        CaptureResult.Key SENSOR_SENSITIVITY = CaptureResult.SENSOR_SENSITIVITY;
        kotlin.jvm.internal.p.h(SENSOR_SENSITIVITY, "SENSOR_SENSITIVITY");
        Integer num2 = (Integer) xVar.U(SENSOR_SENSITIVITY);
        if (num2 != null) {
            int iIntValue = num2.intValue();
            bVar.k(iIntValue);
            CaptureResult.Key CONTROL_POST_RAW_SENSITIVITY_BOOST = CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST;
            kotlin.jvm.internal.p.h(CONTROL_POST_RAW_SENSITIVITY_BOOST, "CONTROL_POST_RAW_SENSITIVITY_BOOST");
            if (((Integer) xVar.U(CONTROL_POST_RAW_SENSITIVITY_BOOST)) != null) {
                bVar.k(iIntValue * ((int) (r1.intValue() / 100.0f)));
            }
        }
        CaptureResult.Key LENS_FOCAL_LENGTH = CaptureResult.LENS_FOCAL_LENGTH;
        kotlin.jvm.internal.p.h(LENS_FOCAL_LENGTH, "LENS_FOCAL_LENGTH");
        Float f11 = (Float) xVar.U(LENS_FOCAL_LENGTH);
        if (f11 != null) {
            bVar.h(f11.floatValue());
        }
        CaptureResult.Key CONTROL_AWB_MODE = CaptureResult.CONTROL_AWB_MODE;
        kotlin.jvm.internal.p.h(CONTROL_AWB_MODE, "CONTROL_AWB_MODE");
        Integer num3 = (Integer) xVar.U(CONTROL_AWB_MODE);
        if (num3 != null) {
            int iIntValue2 = num3.intValue();
            ExifData.WhiteBalanceMode whiteBalanceMode = ExifData.WhiteBalanceMode.AUTO;
            if (iIntValue2 == 0) {
                whiteBalanceMode = ExifData.WhiteBalanceMode.MANUAL;
            }
            bVar.n(whiteBalanceMode);
        }
    }
}
