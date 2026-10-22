package B;

import android.os.Trace;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import w.C5699e;
import w.C5708n;
import w.InterfaceC5700f;
import w.InterfaceC5705k;
import z.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0010\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000f\u0018\u00010\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"LB/b;", "Lw/k;", "Lw/f;", "cameraBackends", "<init>", "(Lw/f;)V", "Lw/e;", "cameraBackendId", "LXa/b;", "", "Lw/n;", "e", "(Ljava/lang/String;)LXa/b;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/util/List;", "", "c", "(Ljava/lang/String;)Ljava/util/Set;", "cameraId", "Landroidx/camera/camera2/pipe/g;", "f", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/camera/camera2/pipe/g;", "Landroidx/camera/camera2/pipe/b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)Landroidx/camera/camera2/pipe/b;", Const.INTENT_KEY_APIKEY, "Lw/f;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class b implements InterfaceC5705k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5700f cameraBackends;

    public b(InterfaceC5700f cameraBackends) {
        p.i(cameraBackends, "cameraBackends");
        this.cameraBackends = cameraBackends;
    }

    @Override // w.InterfaceC5705k
    public List<C5708n> b(String cameraBackendId) {
        androidx.camera.camera2.pipe.b bVarJ = j(cameraBackendId);
        List<C5708n> listG = bVarJ.g();
        if (listG == null && k.f44508a.d()) {
            Log.w("CXCP", "Failed to load cameraIds from " + ((Object) C5699e.f(bVarJ.e())));
        }
        return listG;
    }

    @Override // w.InterfaceC5705k
    public Set<Set<C5708n>> c(String cameraBackendId) {
        return j(cameraBackendId).c();
    }

    @Override // w.InterfaceC5705k
    public Xa.b<List<C5708n>> e(String cameraBackendId) {
        return j(cameraBackendId).f();
    }

    @Override // w.InterfaceC5705k
    public androidx.camera.camera2.pipe.g f(String cameraId, String cameraBackendId) {
        p.i(cameraId, "cameraId");
        androidx.camera.camera2.pipe.b bVarJ = j(cameraBackendId);
        androidx.camera.camera2.pipe.g gVarA = bVarJ.a(cameraId);
        if (gVarA == null && k.f44508a.d()) {
            Log.w("CXCP", "Failed to load metadata for " + ((Object) C5708n.f(cameraId)) + " from " + ((Object) C5699e.f(bVarJ.e())));
        }
        return gVarA;
    }

    public final androidx.camera.camera2.pipe.b j(String cameraBackendId) {
        z.h hVar = z.h.f44503a;
        try {
            Trace.beginSection("getCameraBackend");
            if (cameraBackendId == null) {
                cameraBackendId = this.cameraBackends.getDefault().e();
            }
            androidx.camera.camera2.pipe.b bVarA = this.cameraBackends.a(cameraBackendId);
            if (bVarA != null) {
                return bVarA;
            }
            throw new IllegalStateException(("Failed to load CameraBackend " + ((Object) C5699e.f(cameraBackendId))).toString());
        } finally {
            Trace.endSection();
        }
    }
}
