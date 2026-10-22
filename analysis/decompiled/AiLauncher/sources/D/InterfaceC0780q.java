package D;

import K.C0877d;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006JC\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"LD/q;", "", "", "cameraId", "Landroidx/camera/core/internal/CameraUseCaseAdapter;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Landroidx/camera/core/internal/CameraUseCaseAdapter;", "Landroidx/camera/core/impl/CameraInternal;", C3081a.CAMERA_FOCUS, "secondaryCamera", "LK/d;", "adapterCameraInfo", "secondaryAdapterCameraInfo", "LD/A;", "compositionSettings", "secondaryCompositionSettings", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/core/impl/CameraInternal;Landroidx/camera/core/impl/CameraInternal;LK/d;LK/d;LD/A;LD/A;)Landroidx/camera/core/internal/CameraUseCaseAdapter;", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: D.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0780q {
    CameraUseCaseAdapter a(String cameraId) throws IllegalArgumentException;

    CameraUseCaseAdapter b(CameraInternal camera, CameraInternal secondaryCamera, C0877d adapterCameraInfo, C0877d secondaryAdapterCameraInfo, A compositionSettings, A secondaryCompositionSettings);
}
