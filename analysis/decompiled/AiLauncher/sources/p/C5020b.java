package p;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lp/b;", "", "<init>", "()V", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "callback", "Landroid/hardware/camera2/CameraCaptureSession;", "session", "Landroid/hardware/camera2/CaptureRequest;", "request", "Landroid/view/Surface;", "surface", "", "frameNumber", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;Landroid/hardware/camera2/CameraCaptureSession;Landroid/hardware/camera2/CaptureRequest;Landroid/view/Surface;J)V", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: p.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5020b {

    /* renamed from: a, reason: collision with root package name */
    public static final C5020b f37964a = new C5020b();

    public static final void a(CameraCaptureSession.CaptureCallback callback, CameraCaptureSession session, CaptureRequest request, Surface surface, long frameNumber) {
        kotlin.jvm.internal.p.i(callback, "callback");
        kotlin.jvm.internal.p.i(session, "session");
        kotlin.jvm.internal.p.i(request, "request");
        kotlin.jvm.internal.p.i(surface, "surface");
        callback.onCaptureBufferLost(session, request, surface, frameNumber);
    }
}
