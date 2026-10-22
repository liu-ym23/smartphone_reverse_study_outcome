package r;

import D.C0761b0;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.util.Log;
import android.util.Range;
import androidx.camera.camera2.compat.quirk.ControlZoomRatioRangeAssertionErrorQuirk;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import t.C5473b;
import u.C5565m;
import w.C5708n;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u001b\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/camera/camera2/pipe/g;", "Landroid/util/Range;", "", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/g;)Landroid/util/Range;", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: r.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5186d {
    public static final Range<Float> a(androidx.camera.camera2.pipe.g gVar) {
        Float f10;
        Float fValueOf = Float.valueOf(1.0f);
        kotlin.jvm.internal.p.i(gVar, "<this>");
        try {
            CameraCharacteristics.Key CONTROL_ZOOM_RATIO_RANGE = CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE;
            kotlin.jvm.internal.p.h(CONTROL_ZOOM_RATIO_RANGE, "CONTROL_ZOOM_RATIO_RANGE");
            Range range = (Range) gVar.e0(CONTROL_ZOOM_RATIO_RANGE);
            if (range == null) {
                C5473b c5473b = C5473b.f41865a;
                if (C0761b0.k("CXCP")) {
                    Log.w(C5473b.TRUNCATED_TAG, "Failed to read CONTROL_ZOOM_RATIO_RANGE for " + ((Object) C5708n.f(gVar.b())) + '!');
                }
                return new Range<>(fValueOf, fValueOf);
            }
            C5565m c5565m = C5565m.f42386a;
            Object lower = range.getLower();
            kotlin.jvm.internal.p.h(lower, "getLower(...)");
            if (c5565m.a(((Number) lower).floatValue()) || ((Number) range.getLower()).floatValue() < 0.0f) {
                C5473b c5473b2 = C5473b.f41865a;
                if (C0761b0.k("CXCP")) {
                    Log.w(C5473b.TRUNCATED_TAG, "Invalid lower zoom range detected: " + range.getLower());
                }
                f10 = fValueOf;
            } else {
                f10 = (Float) range.getLower();
            }
            Object upper = range.getUpper();
            kotlin.jvm.internal.p.h(upper, "getUpper(...)");
            if (c5565m.a(((Number) upper).floatValue()) || ((Number) range.getUpper()).floatValue() < 0.0f) {
                C5473b c5473b3 = C5473b.f41865a;
                if (C0761b0.k("CXCP")) {
                    Log.w(C5473b.TRUNCATED_TAG, "Invalid upper zoom range detected: " + range.getUpper());
                }
            } else {
                fValueOf = (Float) range.getUpper();
            }
            return new Range<>(f10, fValueOf);
        } catch (AssertionError e10) {
            if (q.f.f38470a.c(ControlZoomRatioRangeAssertionErrorQuirk.class) != null) {
                C5473b c5473b4 = C5473b.f41865a;
                if (C0761b0.f("CXCP")) {
                    Log.d(C5473b.TRUNCATED_TAG, "Device is known to throw an exception while retrieving the value for CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE. CONTROL_ZOOM_RATIO_RANGE is not supported. [Manufacturer: " + Build.MANUFACTURER + ", Model: " + Build.MODEL + ", API Level: " + Build.VERSION.SDK_INT + "].");
                }
            } else {
                C5473b c5473b5 = C5473b.f41865a;
                if (C0761b0.g("CXCP")) {
                    Log.e(C5473b.TRUNCATED_TAG, "Exception thrown while retrieving the value for CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE on devices not known to throw exceptions during this operation. Please file an issue at https://issuetracker.google.com/issues/new?component=618491&template=1257717 with this error message [Manufacturer: " + Build.MANUFACTURER + ", Model: " + Build.MODEL + ", API Level: " + Build.VERSION.SDK_INT + "]. CONTROL_ZOOM_RATIO_RANGE is not available.", e10);
                }
            }
            if (!C0761b0.k("CXCP")) {
                return null;
            }
            Log.w(C5473b.TRUNCATED_TAG, "AssertionError: failed to get CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE", e10);
            return null;
        }
    }
}
