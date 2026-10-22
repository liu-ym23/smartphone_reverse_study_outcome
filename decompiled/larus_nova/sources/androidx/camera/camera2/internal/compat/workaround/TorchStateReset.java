package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.TorchIsClosedAfterImageCapturingQuirk;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TorchStateReset {
    private final boolean mIsImageCaptureTorchIsClosedQuirkEnabled;

    public TorchStateReset() {
        if (DeviceQuirks.get(TorchIsClosedAfterImageCapturingQuirk.class) == null) goto L5;
        boolean r100 = true;
    L6:
        this.mIsImageCaptureTorchIsClosedQuirkEnabled = r100;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public CaptureConfig createTorchResetRequest(CaptureConfig r100) {
        CaptureConfig.Builder r101 = new CaptureConfig.Builder();
        r101.setTemplateType(r100.getTemplateType());
        Iterator<DeferrableSurface> r102 = r100.getSurfaces().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.addSurface(r102.next());
        goto L4
    L6:
        r101.addImplementationOptions(r100.getImplementationOptions());
        Camera2ImplConfig.Builder r103 = new Camera2ImplConfig.Builder();
        r103.setCaptureRequestOption(CaptureRequest.FLASH_MODE, 0);
        r101.addImplementationOptions(r103.build());
        return r101.build();
    }

    public boolean isTorchResetRequired(List<CaptureRequest> r100, boolean r101) {
        if (this.mIsImageCaptureTorchIsClosedQuirkEnabled == false) goto L14;
        if (r101 == false) goto L22;
        Iterator<CaptureRequest> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L23;
        Integer r103 = (Integer) r102.next().get(CaptureRequest.FLASH_MODE);
        if (r103 == null) goto L7;
        if (r103.intValue() != 2) goto L7;
        return true;
    L23:
        return false;
    L22:
        return false;
    L14:
        return false;
    }
}
