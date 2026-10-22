package x;

import androidx.camera.camera2.pipe.compat.VirtualCameraState;
import com.autonavi.aps.amapapi.config.Const;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import w.AbstractC5689A;
import w.C5708n;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u00148\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015¨\u0006\u0017"}, d2 = {"Lx/b0;", "LB/c;", "<init>", "()V", "Lw/n;", "cameraId", "Lw/l;", "cameraError", "", "willAttemptRetry", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;IZ)V", "Landroidx/camera/camera2/pipe/compat/VirtualCameraState;", "virtualCameraState", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Landroidx/camera/camera2/pipe/compat/VirtualCameraState;)V", "", "Ljava/lang/Object;", "lock", "", "Ljava/util/Map;", "virtualCameraStateMap", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.b0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5806b0 implements B.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Object lock = new Object();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Map<C5708n, VirtualCameraState> virtualCameraStateMap = new LinkedHashMap();

    @Override // B.c
    public void a(String cameraId, int cameraError, boolean willAttemptRetry) {
        VirtualCameraState virtualCameraState;
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        synchronized (this.lock) {
            virtualCameraState = this.virtualCameraStateMap.get(C5708n.a(cameraId));
        }
        if (virtualCameraState == null) {
            return;
        }
        virtualCameraState.getGraphListener().c(new AbstractC5689A.a(cameraError, willAttemptRetry, null));
    }

    public final void b(String cameraId, VirtualCameraState virtualCameraState) {
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        kotlin.jvm.internal.p.i(virtualCameraState, "virtualCameraState");
        synchronized (this.lock) {
            this.virtualCameraStateMap.put(C5708n.a(cameraId), virtualCameraState);
            Y8.t tVar = Y8.t.f7040a;
        }
    }
}
