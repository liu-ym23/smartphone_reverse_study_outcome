package p;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0013\u001a\u00020\r2\u0016\u0010\u0012\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0012\u0004\u0012\u00020\u00010\u0010H\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lp/c;", "", "<init>", "()V", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "callback", "Landroid/hardware/camera2/CameraCaptureSession;", "session", "Landroid/hardware/camera2/CaptureRequest;", "request", "", "timestamp", "frameNumber", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;Landroid/hardware/camera2/CameraCaptureSession;Landroid/hardware/camera2/CaptureRequest;JJ)V", "", "Landroid/hardware/camera2/CaptureRequest$Key;", "parameters", Const.INTENT_KEY_PKGNAME, "(Ljava/util/Map;)V", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: p.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5021c {

    /* renamed from: a, reason: collision with root package name */
    public static final C5021c f37965a = new C5021c();

    public static final void a(CameraCaptureSession.CaptureCallback callback, CameraCaptureSession session, CaptureRequest request, long timestamp, long frameNumber) {
        kotlin.jvm.internal.p.i(callback, "callback");
        kotlin.jvm.internal.p.i(session, "session");
        kotlin.jvm.internal.p.i(request, "request");
        callback.onReadoutStarted(session, request, timestamp, frameNumber);
    }

    public static final void b(Map<CaptureRequest.Key<?>, Object> parameters) {
        kotlin.jvm.internal.p.i(parameters, "parameters");
        parameters.put(CaptureRequest.CONTROL_SETTINGS_OVERRIDE, 1);
    }
}
