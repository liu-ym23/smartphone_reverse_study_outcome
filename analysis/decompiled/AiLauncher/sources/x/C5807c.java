package x;

import android.hardware.camera2.CameraConstrainedHighSpeedCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.os.Trace;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.util.List;
import kotlin.Metadata;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B)\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0016\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0013*\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lx/c;", "Lx/b;", "Lx/f0;", "Landroidx/camera/camera2/pipe/compat/p;", Parameters.DEVICE, "Landroid/hardware/camera2/CameraConstrainedHighSpeedCaptureSession;", "session", "LB/c;", "cameraErrorListener", "Landroid/os/Handler;", "callbackHandler", "<init>", "(Landroidx/camera/camera2/pipe/compat/p;Landroid/hardware/camera2/CameraConstrainedHighSpeedCaptureSession;LB/c;Landroid/os/Handler;)V", "Landroid/hardware/camera2/CaptureRequest;", "request", "", "Z", "(Landroid/hardware/camera2/CaptureRequest;)Ljava/util/List;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "type", "R0", "(Lw9/d;)Ljava/lang/Object;", "f", "Landroid/hardware/camera2/CameraConstrainedHighSpeedCaptureSession;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5807c extends C5805b implements InterfaceC5814f0 {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final CameraConstrainedHighSpeedCaptureSession session;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5807c(androidx.camera.camera2.pipe.compat.p device, CameraConstrainedHighSpeedCaptureSession session, B.c cameraErrorListener, Handler callbackHandler) {
        super(device, session, cameraErrorListener, callbackHandler);
        kotlin.jvm.internal.p.i(device, "device");
        kotlin.jvm.internal.p.i(session, "session");
        kotlin.jvm.internal.p.i(cameraErrorListener, "cameraErrorListener");
        kotlin.jvm.internal.p.i(callbackHandler, "callbackHandler");
        this.session = session;
    }

    @Override // x.C5805b, w.U
    public <T> T R0(InterfaceC5745d<T> type) {
        kotlin.jvm.internal.p.i(type, "type");
        return kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(CameraConstrainedHighSpeedCaptureSession.class)) ? (T) this.session : (T) super.R0(type);
    }

    @Override // x.InterfaceC5814f0
    public List<CaptureRequest> Z(CaptureRequest request) {
        kotlin.jvm.internal.p.i(request, "request");
        try {
            z.h hVar = z.h.f44503a;
            try {
                Trace.beginSection("CXCP#createHighSpeedRequestList");
                return this.session.createHighSpeedRequestList(request);
            } finally {
                Trace.endSection();
            }
        } catch (IllegalArgumentException unused) {
            if (!z.k.f44508a.d()) {
                return null;
            }
            Log.w("CXCP", "Failed to createHighSpeedRequestList from " + getDevice() + " because the output surface was destroyed before calling createHighSpeedRequestList.");
            return null;
        } catch (IllegalStateException unused2) {
            if (!z.k.f44508a.d()) {
                return null;
            }
            Log.w("CXCP", "Failed to createHighSpeedRequestList. " + getDevice() + " may be closed.");
            return null;
        } catch (UnsupportedOperationException unused3) {
            if (!z.k.f44508a.d()) {
                return null;
            }
            Log.w("CXCP", "Failed to createHighSpeedRequestList from " + getDevice() + " because the output surface was not available.");
            return null;
        }
    }
}
