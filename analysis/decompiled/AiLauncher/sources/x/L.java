package x;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b`\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0010H&¢\u0006\u0004\b\u0019\u0010\u001aø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001bÀ\u0006\u0001"}, d2 = {"Lx/L;", "", "Landroid/hardware/camera2/CaptureRequest;", "captureRequest", "", "captureFrameNumber", "captureTimestamp", "LY8/t;", "f", "(Landroid/hardware/camera2/CaptureRequest;JJ)V", "Landroid/hardware/camera2/TotalCaptureResult;", "captureResult", "Lw/y;", "frameNumber", "c", "(Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/TotalCaptureResult;J)V", "", "progress", Const.INTENT_KEY_UMID, "(Landroid/hardware/camera2/CaptureRequest;I)V", "e", "(Landroid/hardware/camera2/CaptureRequest;J)V", "captureSequenceId", Const.INTENT_KEY_APIKEY, "(IJ)V", Const.INTENT_KEY_PKGNAME, "(I)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface L {
    void a(int captureSequenceId, long captureFrameNumber);

    void b(int captureSequenceId);

    void c(CaptureRequest captureRequest, TotalCaptureResult captureResult, long frameNumber);

    void d(CaptureRequest captureRequest, int progress);

    void e(CaptureRequest captureRequest, long frameNumber);

    void f(CaptureRequest captureRequest, long captureFrameNumber, long captureTimestamp);
}
