package D;

import K.C0877d;
import K.C0895s;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010JC\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJK\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001dR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001eR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001fR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"LD/r;", "LD/q;", "LK/N;", "cameraRepository", "LE/a;", "cameraCoordinator", "Landroidx/camera/core/impl/UseCaseConfigFactory;", "useCaseConfigFactory", "LP/i;", "streamSpecsCalculator", "<init>", "(LK/N;LE/a;Landroidx/camera/core/impl/UseCaseConfigFactory;LP/i;)V", "", "cameraId", "Landroidx/camera/core/internal/CameraUseCaseAdapter;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Landroidx/camera/core/internal/CameraUseCaseAdapter;", "Landroidx/camera/core/impl/CameraInternal;", C3081a.CAMERA_FOCUS, "secondaryCamera", "LK/d;", "adapterCameraInfo", "secondaryAdapterCameraInfo", "LD/A;", "compositionSettings", "secondaryCompositionSettings", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/core/impl/CameraInternal;Landroidx/camera/core/impl/CameraInternal;LK/d;LK/d;LD/A;LD/A;)Landroidx/camera/core/internal/CameraUseCaseAdapter;", "c", "LK/N;", "LE/a;", "Landroidx/camera/core/impl/UseCaseConfigFactory;", Const.INTENT_KEY_UMID, "LP/i;", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class r implements InterfaceC0780q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final K.N cameraRepository;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final E.a cameraCoordinator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final UseCaseConfigFactory useCaseConfigFactory;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final P.i streamSpecsCalculator;

    public r(K.N cameraRepository, E.a cameraCoordinator, UseCaseConfigFactory useCaseConfigFactory, P.i streamSpecsCalculator) {
        kotlin.jvm.internal.p.i(cameraRepository, "cameraRepository");
        kotlin.jvm.internal.p.i(cameraCoordinator, "cameraCoordinator");
        kotlin.jvm.internal.p.i(useCaseConfigFactory, "useCaseConfigFactory");
        kotlin.jvm.internal.p.i(streamSpecsCalculator, "streamSpecsCalculator");
        this.cameraRepository = cameraRepository;
        this.cameraCoordinator = cameraCoordinator;
        this.useCaseConfigFactory = useCaseConfigFactory;
        this.streamSpecsCalculator = streamSpecsCalculator;
    }

    public static /* synthetic */ CameraUseCaseAdapter d(r rVar, CameraInternal cameraInternal, CameraInternal cameraInternal2, C0877d c0877d, C0877d c0877d2, A DEFAULT, A DEFAULT2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            cameraInternal2 = null;
        }
        if ((i10 & 8) != 0) {
            c0877d2 = null;
        }
        if ((i10 & 16) != 0) {
            DEFAULT = A.f1988d;
            kotlin.jvm.internal.p.h(DEFAULT, "DEFAULT");
        }
        if ((i10 & 32) != 0) {
            DEFAULT2 = A.f1988d;
            kotlin.jvm.internal.p.h(DEFAULT2, "DEFAULT");
        }
        return rVar.c(cameraInternal, cameraInternal2, c0877d, c0877d2, DEFAULT, DEFAULT2);
    }

    @Override // D.InterfaceC0780q
    public CameraUseCaseAdapter a(String cameraId) throws IllegalArgumentException {
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        CameraInternal cameraInternalL = this.cameraRepository.l(cameraId);
        kotlin.jvm.internal.p.h(cameraInternalL, "getCamera(...)");
        return d(this, cameraInternalL, null, new C0877d(cameraInternalL.i(), C0895s.a()), null, null, null, 58, null);
    }

    @Override // D.InterfaceC0780q
    public CameraUseCaseAdapter b(CameraInternal camera, CameraInternal secondaryCamera, C0877d adapterCameraInfo, C0877d secondaryAdapterCameraInfo, A compositionSettings, A secondaryCompositionSettings) {
        kotlin.jvm.internal.p.i(camera, "camera");
        kotlin.jvm.internal.p.i(adapterCameraInfo, "adapterCameraInfo");
        kotlin.jvm.internal.p.i(compositionSettings, "compositionSettings");
        kotlin.jvm.internal.p.i(secondaryCompositionSettings, "secondaryCompositionSettings");
        return c(camera, secondaryCamera, adapterCameraInfo, secondaryAdapterCameraInfo, compositionSettings, secondaryCompositionSettings);
    }

    public final CameraUseCaseAdapter c(CameraInternal camera, CameraInternal secondaryCamera, C0877d adapterCameraInfo, C0877d secondaryAdapterCameraInfo, A compositionSettings, A secondaryCompositionSettings) {
        return new CameraUseCaseAdapter(camera, secondaryCamera, adapterCameraInfo, secondaryAdapterCameraInfo, compositionSettings, secondaryCompositionSettings, this.cameraCoordinator, this.streamSpecsCalculator, this.useCaseConfigFactory);
    }
}
