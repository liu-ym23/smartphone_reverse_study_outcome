package r;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.compat.quirk.StillCaptureFlashStopRepeatingQuirk;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "Landroidx/camera/camera2/pipe/t;", "", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Z", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: r.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5180B {
    public static final boolean a(List<androidx.camera.camera2.pipe.t> list) {
        kotlin.jvm.internal.p.i(list, "<this>");
        if (((StillCaptureFlashStopRepeatingQuirk) q.f.f38470a.c(StillCaptureFlashStopRepeatingQuirk.class)) == null) {
            return false;
        }
        boolean z10 = false;
        boolean z11 = false;
        for (androidx.camera.camera2.pipe.t tVar : list) {
            w.M m10 = tVar.getM5.e.FAIL_TEMPLATE java.lang.String();
            if (m10 != null && m10.getValue() == 2) {
                z10 = true;
            }
            CaptureRequest.Key CONTROL_AE_MODE = CaptureRequest.CONTROL_AE_MODE;
            kotlin.jvm.internal.p.h(CONTROL_AE_MODE, "CONTROL_AE_MODE");
            Integer num = (Integer) tVar.a(CONTROL_AE_MODE);
            if ((num != null && num.intValue() == 2) || (num != null && num.intValue() == 3)) {
                z11 = true;
            }
        }
        return z10 && z11;
    }
}
