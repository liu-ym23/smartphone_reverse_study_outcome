package t;

import Z8.C1168p;
import android.hardware.camera2.CameraCharacteristics;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\u001a\u0019\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u001b\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\n\u001a\u00020\u0007*\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0019\u0010\f\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\u0004\"\u001b\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\r*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u001b\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\r*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f\"\u001b\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\r*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0015"}, d2 = {"Landroidx/camera/camera2/pipe/g;", "", "preferredMode", "e", "(Landroidx/camera/camera2/pipe/g;I)I", Const.INTENT_KEY_UMID, "aeMode", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroidx/camera/camera2/pipe/g;I)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroidx/camera/camera2/pipe/g;)Z", "f", "", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/camera2/pipe/g;)Ljava/util/List;", "availableAfModes", Const.INTENT_KEY_APIKEY, "availableAeModes", "c", "availableAwbModes", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: t.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5492t {
    public static final List<Integer> a(androidx.camera.camera2.pipe.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        CameraCharacteristics.Key CONTROL_AE_AVAILABLE_MODES = CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES;
        kotlin.jvm.internal.p.h(CONTROL_AE_AVAILABLE_MODES, "CONTROL_AE_AVAILABLE_MODES");
        Object objH1 = gVar.h1(CONTROL_AE_AVAILABLE_MODES, new int[]{0});
        kotlin.jvm.internal.p.h(objH1, "getOrDefault(...)");
        return C1168p.c((int[]) objH1);
    }

    public static final List<Integer> b(androidx.camera.camera2.pipe.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        CameraCharacteristics.Key CONTROL_AF_AVAILABLE_MODES = CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES;
        kotlin.jvm.internal.p.h(CONTROL_AF_AVAILABLE_MODES, "CONTROL_AF_AVAILABLE_MODES");
        Object objH1 = gVar.h1(CONTROL_AF_AVAILABLE_MODES, new int[]{0});
        kotlin.jvm.internal.p.h(objH1, "getOrDefault(...)");
        return C1168p.c((int[]) objH1);
    }

    public static final List<Integer> c(androidx.camera.camera2.pipe.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        CameraCharacteristics.Key CONTROL_AWB_AVAILABLE_MODES = CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES;
        kotlin.jvm.internal.p.h(CONTROL_AWB_AVAILABLE_MODES, "CONTROL_AWB_AVAILABLE_MODES");
        Object objH1 = gVar.h1(CONTROL_AWB_AVAILABLE_MODES, new int[]{0});
        kotlin.jvm.internal.p.h(objH1, "getOrDefault(...)");
        return C1168p.c((int[]) objH1);
    }

    public static final int d(androidx.camera.camera2.pipe.g gVar, int i10) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        return a(gVar).contains(Integer.valueOf(i10)) ? i10 : a(gVar).contains(1) ? 1 : 0;
    }

    public static final int e(androidx.camera.camera2.pipe.g gVar, int i10) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        if (b(gVar).contains(Integer.valueOf(i10))) {
            return i10;
        }
        if (b(gVar).contains(4)) {
            return 4;
        }
        return b(gVar).contains(1) ? 1 : 0;
    }

    public static final int f(androidx.camera.camera2.pipe.g gVar, int i10) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        return c(gVar).contains(Integer.valueOf(i10)) ? i10 : c(gVar).contains(1) ? 1 : 0;
    }

    public static final boolean g(androidx.camera.camera2.pipe.g gVar, int i10) {
        return d(gVar, i10) == i10;
    }

    public static final boolean h(androidx.camera.camera2.pipe.g gVar) {
        kotlin.jvm.internal.p.i(gVar, "<this>");
        return g(gVar, 5);
    }
}
