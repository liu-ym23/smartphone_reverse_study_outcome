package w;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J'\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\t\u0010\nJ)\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b\u0018\u00010\u000b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lw/k;", "", "Lw/e;", "cameraBackendId", "LXa/b;", "", "Lw/n;", "e", "(Ljava/lang/String;)LXa/b;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/util/List;", "", "c", "(Ljava/lang/String;)Ljava/util/Set;", "cameraId", "Landroidx/camera/camera2/pipe/g;", "f", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/camera/camera2/pipe/g;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: w.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC5705k {
    static /* synthetic */ androidx.camera.camera2.pipe.g a(InterfaceC5705k interfaceC5705k, String str, String str2, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitCameraMetadata-FpsL5FU");
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return interfaceC5705k.f(str, str2);
    }

    static /* synthetic */ Set d(InterfaceC5705k interfaceC5705k, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitConcurrentCameraIds-SeavPBo");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        return interfaceC5705k.c(str);
    }

    static /* synthetic */ List g(InterfaceC5705k interfaceC5705k, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitCameraIds-SeavPBo");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        return interfaceC5705k.b(str);
    }

    static /* synthetic */ Xa.b h(InterfaceC5705k interfaceC5705k, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cameraIdsFlow-SeavPBo");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        return interfaceC5705k.e(str);
    }

    List<C5708n> b(String cameraBackendId);

    Set<Set<C5708n>> c(String cameraBackendId);

    Xa.b<List<C5708n>> e(String cameraBackendId);

    androidx.camera.camera2.pipe.g f(String cameraId, String cameraBackendId);
}
