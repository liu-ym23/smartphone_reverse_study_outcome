package A;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import com.autonavi.aps.amapapi.config.Const;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import w.C5695a;
import w.C5696b;
import w.C5697c;
import w.C5713t;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a#\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"LA/p;", "", "Landroid/hardware/camera2/CaptureRequest$Key;", "", Const.INTENT_KEY_APIKEY, "(LA/p;)Ljava/util/Map;", "camera-camera2-pipe"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class k {
    public static final Map<CaptureRequest.Key<?>, Object> a(State3A state3A) {
        kotlin.jvm.internal.p.i(state3A, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C5695a aeMode = state3A.getAeMode();
        if (aeMode != null) {
            int value = aeMode.getValue();
            CaptureRequest.Key CONTROL_AE_MODE = CaptureRequest.CONTROL_AE_MODE;
            kotlin.jvm.internal.p.h(CONTROL_AE_MODE, "CONTROL_AE_MODE");
            linkedHashMap.put(CONTROL_AE_MODE, Integer.valueOf(value));
        }
        C5696b afMode = state3A.getAfMode();
        if (afMode != null) {
            int value2 = afMode.getValue();
            CaptureRequest.Key CONTROL_AF_MODE = CaptureRequest.CONTROL_AF_MODE;
            kotlin.jvm.internal.p.h(CONTROL_AF_MODE, "CONTROL_AF_MODE");
            linkedHashMap.put(CONTROL_AF_MODE, Integer.valueOf(value2));
        }
        C5697c awbMode = state3A.getAwbMode();
        if (awbMode != null) {
            int value3 = awbMode.getValue();
            CaptureRequest.Key CONTROL_AWB_MODE = CaptureRequest.CONTROL_AWB_MODE;
            kotlin.jvm.internal.p.h(CONTROL_AWB_MODE, "CONTROL_AWB_MODE");
            linkedHashMap.put(CONTROL_AWB_MODE, Integer.valueOf(value3));
        }
        C5713t flashMode = state3A.getFlashMode();
        if (flashMode != null) {
            int value4 = flashMode.getValue();
            CaptureRequest.Key FLASH_MODE = CaptureRequest.FLASH_MODE;
            kotlin.jvm.internal.p.h(FLASH_MODE, "FLASH_MODE");
            linkedHashMap.put(FLASH_MODE, Integer.valueOf(value4));
        }
        List<MeteringRectangle> listD = state3A.d();
        if (listD != null) {
            CaptureRequest.Key CONTROL_AE_REGIONS = CaptureRequest.CONTROL_AE_REGIONS;
            kotlin.jvm.internal.p.h(CONTROL_AE_REGIONS, "CONTROL_AE_REGIONS");
            linkedHashMap.put(CONTROL_AE_REGIONS, listD.toArray(new MeteringRectangle[0]));
        }
        List<MeteringRectangle> listG = state3A.g();
        if (listG != null) {
            CaptureRequest.Key CONTROL_AF_REGIONS = CaptureRequest.CONTROL_AF_REGIONS;
            kotlin.jvm.internal.p.h(CONTROL_AF_REGIONS, "CONTROL_AF_REGIONS");
            linkedHashMap.put(CONTROL_AF_REGIONS, listG.toArray(new MeteringRectangle[0]));
        }
        List<MeteringRectangle> listJ = state3A.j();
        if (listJ != null) {
            CaptureRequest.Key CONTROL_AWB_REGIONS = CaptureRequest.CONTROL_AWB_REGIONS;
            kotlin.jvm.internal.p.h(CONTROL_AWB_REGIONS, "CONTROL_AWB_REGIONS");
            linkedHashMap.put(CONTROL_AWB_REGIONS, listJ.toArray(new MeteringRectangle[0]));
        }
        Boolean aeLock = state3A.getAeLock();
        if (aeLock != null) {
            CaptureRequest.Key CONTROL_AE_LOCK = CaptureRequest.CONTROL_AE_LOCK;
            kotlin.jvm.internal.p.h(CONTROL_AE_LOCK, "CONTROL_AE_LOCK");
            linkedHashMap.put(CONTROL_AE_LOCK, aeLock);
        }
        Boolean awbLock = state3A.getAwbLock();
        if (awbLock != null) {
            CaptureRequest.Key CONTROL_AWB_LOCK = CaptureRequest.CONTROL_AWB_LOCK;
            kotlin.jvm.internal.p.h(CONTROL_AWB_LOCK, "CONTROL_AWB_LOCK");
            linkedHashMap.put(CONTROL_AWB_LOCK, awbLock);
        }
        return linkedHashMap;
    }
}
