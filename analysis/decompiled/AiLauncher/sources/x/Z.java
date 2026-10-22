package x;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import w.C5706l;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lx/Z;", "Lx/a0;", "Landroid/hardware/camera2/CameraDevice$CameraDeviceSetup;", "cameraDeviceSetup", "Lw/n;", "cameraId", "LB/c;", "cameraErrorListener", "<init>", "(Landroid/hardware/camera2/CameraDevice$CameraDeviceSetup;Ljava/lang/String;LB/c;Lkotlin/jvm/internal/i;)V", "", "templateType", "Landroid/hardware/camera2/CaptureRequest$Builder;", Const.INTENT_KEY_APIKEY, "(I)Landroid/hardware/camera2/CaptureRequest$Builder;", "Landroid/hardware/camera2/CameraDevice$CameraDeviceSetup;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "c", "LB/c;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Z implements InterfaceC5804a0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final CameraDevice.CameraDeviceSetup cameraDeviceSetup;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String cameraId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final B.c cameraErrorListener;

    public /* synthetic */ Z(CameraDevice.CameraDeviceSetup cameraDeviceSetup, String str, B.c cVar, kotlin.jvm.internal.i iVar) {
        this(cameraDeviceSetup, str, cVar);
    }

    @Override // x.InterfaceC5804a0
    public CaptureRequest.Builder a(int templateType) throws Exception {
        String str = this.cameraId;
        B.c cVar = this.cameraErrorListener;
        try {
            return this.cameraDeviceSetup.createCaptureRequest(templateType);
        } catch (Exception e10) {
            if (e10 instanceof CameraAccessException) {
                if (z.k.f44508a.d()) {
                    Log.w("CXCP", "Failed to execute call: Camera encountered an error: " + e10.getMessage());
                }
                cVar.a(str, C5706l.INSTANCE.b((CameraAccessException) e10), true);
                return null;
            }
            if (!(e10 instanceof IllegalArgumentException) && !(e10 instanceof SecurityException) && !(e10 instanceof UnsupportedOperationException) && !(e10 instanceof NullPointerException)) {
                if (!(e10 instanceof IllegalStateException)) {
                    throw e10;
                }
                if (!z.k.f44508a.a()) {
                    return null;
                }
                Log.d("CXCP", "Failed to execute call: Camera may be closed");
                return null;
            }
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to execute call: Unexpected exception: " + e10.getMessage());
            }
            cVar.a(str, C5706l.INSTANCE.m(), false);
            return null;
        }
    }

    public Z(CameraDevice.CameraDeviceSetup cameraDeviceSetup, String cameraId, B.c cameraErrorListener) {
        kotlin.jvm.internal.p.i(cameraDeviceSetup, "cameraDeviceSetup");
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        kotlin.jvm.internal.p.i(cameraErrorListener, "cameraErrorListener");
        this.cameraDeviceSetup = cameraDeviceSetup;
        this.cameraId = cameraId;
        this.cameraErrorListener = cameraErrorListener;
    }
}
