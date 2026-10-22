package r;

import K.w0;
import Z8.Q;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.compat.quirk.CaptureIntentPreviewQuirk;
import androidx.camera.camera2.compat.quirk.ImageCaptureFailedForVideoSnapshotQuirk;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\u000b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\n0\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e¨\u0006\u0012"}, d2 = {"Lr/G;", "Lr/E;", "LK/w0;", "quirks", "<init>", "(LK/w0;)V", "Lw/M;", M5.e.FAIL_TEMPLATE, "", "Landroid/hardware/camera2/CaptureRequest$Key;", "", Const.INTENT_KEY_APIKEY, "(Lw/M;)Ljava/util/Map;", "", "Z", "workaroundByCaptureIntentPreview", Const.INTENT_KEY_PKGNAME, "workaroundByCaptureIntentStillCapture", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class G implements E {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final boolean workaroundByCaptureIntentPreview;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final boolean workaroundByCaptureIntentStillCapture;

    public G(w0 quirks) {
        kotlin.jvm.internal.p.i(quirks, "quirks");
        this.workaroundByCaptureIntentPreview = CaptureIntentPreviewQuirk.INSTANCE.a(quirks);
        this.workaroundByCaptureIntentStillCapture = quirks.a(ImageCaptureFailedForVideoSnapshotQuirk.class);
    }

    @Override // r.E
    public Map<CaptureRequest.Key<?>, Object> a(w.M template) {
        return (template != null && template.getValue() == 3 && this.workaroundByCaptureIntentPreview) ? Q.f(Y8.j.a(CaptureRequest.CONTROL_CAPTURE_INTENT, 1)) : (template != null && template.getValue() == 4 && this.workaroundByCaptureIntentStillCapture) ? Q.f(Y8.j.a(CaptureRequest.CONTROL_CAPTURE_INTENT, 2)) : kotlin.collections.a.i();
    }
}
