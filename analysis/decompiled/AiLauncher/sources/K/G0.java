package K;

import D.InterfaceC0780q;
import G.ResolvedFeatureGroup;
import androidx.camera.core.UseCase;
import androidx.camera.core.internal.CalculatedUseCaseInfo;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\r\u0010\u000eR(\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0087.¢\u0006\u0018\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0010\u0010\u0014¨\u0006\u0017"}, d2 = {"LK/G0;", "", "<init>", "()V", "LK/v;", "cameraInfoInternal", "LD/o0;", "sessionConfig", "", "findMaxSupportedFrameRate", "LG/a;", "resolvedFeatureGroup", "Landroidx/camera/core/internal/a;", "c", "(LK/v;LD/o0;ZLG/a;)Landroidx/camera/core/internal/a;", "LD/q;", Const.INTENT_KEY_PKGNAME, "LD/q;", Const.INTENT_KEY_APIKEY, "()LD/q;", "(LD/q;)V", "getCameraUseCaseAdapterProvider$annotations", "cameraUseCaseAdapterProvider", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class G0 {

    /* renamed from: a, reason: collision with root package name */
    public static final G0 f3886a = new G0();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static InterfaceC0780q cameraUseCaseAdapterProvider;

    public static final InterfaceC0780q a() {
        InterfaceC0780q interfaceC0780q = cameraUseCaseAdapterProvider;
        if (interfaceC0780q != null) {
            return interfaceC0780q;
        }
        kotlin.jvm.internal.p.A("cameraUseCaseAdapterProvider");
        return null;
    }

    public static final void b(InterfaceC0780q interfaceC0780q) {
        kotlin.jvm.internal.p.i(interfaceC0780q, "<set-?>");
        cameraUseCaseAdapterProvider = interfaceC0780q;
    }

    public static final CalculatedUseCaseInfo c(InterfaceC0898v cameraInfoInternal, D.o0 sessionConfig, boolean findMaxSupportedFrameRate, ResolvedFeatureGroup resolvedFeatureGroup) throws IllegalStateException, CameraUseCaseAdapter.CameraException {
        kotlin.jvm.internal.p.i(cameraInfoInternal, "cameraInfoInternal");
        kotlin.jvm.internal.p.i(sessionConfig, "sessionConfig");
        if (cameraUseCaseAdapterProvider == null) {
            throw new IllegalStateException("mCameraUseCaseAdapterProvider must be initialized first!");
        }
        InterfaceC0780q interfaceC0780qA = a();
        String strH = cameraInfoInternal.h();
        kotlin.jvm.internal.p.h(strH, "getCameraId(...)");
        CameraUseCaseAdapter cameraUseCaseAdapterA = interfaceC0780qA.a(strH);
        sessionConfig.n();
        cameraUseCaseAdapterA.i0(null);
        cameraUseCaseAdapterA.e0(sessionConfig.d());
        cameraUseCaseAdapterA.h0(sessionConfig.getSessionType());
        cameraUseCaseAdapterA.g0(sessionConfig.g());
        List<UseCase> listM = sessionConfig.m();
        if (resolvedFeatureGroup == null) {
            resolvedFeatureGroup = ResolvedFeatureGroup.Companion.c(ResolvedFeatureGroup.INSTANCE, sessionConfig, cameraInfoInternal, null, 2, null);
        }
        CalculatedUseCaseInfo aVarK0 = cameraUseCaseAdapterA.k0(listM, resolvedFeatureGroup, findMaxSupportedFrameRate);
        kotlin.jvm.internal.p.h(aVarK0, "simulateAddUseCases(...)");
        return aVarK0;
    }
}
