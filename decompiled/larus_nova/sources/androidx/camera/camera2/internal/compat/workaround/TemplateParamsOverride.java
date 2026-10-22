package androidx.camera.camera2.internal.compat.workaround;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.compat.quirk.CaptureIntentPreviewQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailedForVideoSnapshotQuirk;
import androidx.camera.core.impl.Quirks;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class TemplateParamsOverride {
    private final boolean mWorkaroundByCaptureIntentPreview;
    private final boolean mWorkaroundByCaptureIntentStillCapture;

    public TemplateParamsOverride(Quirks r100) {
        this.mWorkaroundByCaptureIntentPreview = CaptureIntentPreviewQuirk.CC.workaroundByCaptureIntentPreview(r100);
        this.mWorkaroundByCaptureIntentStillCapture = r100.contains(ImageCaptureFailedForVideoSnapshotQuirk.class);
    }

    public Map<CaptureRequest.Key<?>, Object> getOverrideParams(int r100) {
        if (r100 != 3) goto L9;
        if (this.mWorkaroundByCaptureIntentPreview == false) goto L9;
        HashMap r101 = new HashMap();
        r101.put(CaptureRequest.CONTROL_CAPTURE_INTENT, 1);
        return Collections.unmodifiableMap(r101);
    L9:
        if (r100 != 4) goto L15;
        if (this.mWorkaroundByCaptureIntentStillCapture == false) goto L15;
        HashMap r102 = new HashMap();
        r102.put(CaptureRequest.CONTROL_CAPTURE_INTENT, 2);
        return Collections.unmodifiableMap(r102);
    L15:
        return Collections.emptyMap();
    }
}
