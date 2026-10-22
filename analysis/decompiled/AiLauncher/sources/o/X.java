package o;

import D.C0761b0;
import K.AbstractC0889l;
import K.C0874b0;
import K.InterfaceC0872a0;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.compat.quirk.ZslDisablerQuirk;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import t.C5473b;
import t.C5476c0;
import t.InterfaceC5494v;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001\u001cB\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0017\u0010\u0014J\u000f\u0010\u0018\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001f\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010 R\u0014\u0010#\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b&\u0010'R \u0010.\u001a\u00020)8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0017\u0010*\u0012\u0004\b-\u0010\u001d\u001a\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010/R\u0016\u00101\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010/R\u0016\u00102\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010/R*\u0010:\u001a\u0004\u0018\u0001038\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\b\u0018\u00104\u0012\u0004\b9\u0010\u001d\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006C"}, d2 = {"Lo/X;", "Lo/Q;", "Lt/v;", "cameraProperties", "<init>", "(Lt/v;)V", "Landroidx/camera/core/impl/SessionConfig$b;", "sessionConfigBuilder", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/core/impl/SessionConfig$b;)V", "Landroidx/camera/core/impl/DeferrableSurface;", "surface", "Landroidx/camera/core/impl/SessionConfig;", "sessionConfig", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroidx/camera/core/impl/DeferrableSurface;Landroidx/camera/core/impl/SessionConfig;)Z", "disabled", "e", "(Z)V", "c", "()Z", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroidx/camera/core/i;", "f", "()Landroidx/camera/core/i;", Const.INTENT_KEY_APIKEY, "()V", "r", "p", "Lt/v;", "Landroidx/camera/camera2/pipe/g;", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "Landroid/hardware/camera2/params/StreamConfigurationMap;", "LY8/h;", "q", "()Landroid/hardware/camera2/params/StreamConfigurationMap;", "streamConfigurationMap", "LT/e;", "LT/e;", "getZslRingBuffer$camera_camera2", "()LT/e;", "getZslRingBuffer$camera_camera2$annotations", "zslRingBuffer", "Z", "isZslDisabledByUseCaseConfig", "isZslDisabledByFlashMode", "isZslDisabledByQuirks", "Landroidx/camera/core/m;", "Landroidx/camera/core/m;", "getReprocessingImageReader$camera_camera2", "()Landroidx/camera/core/m;", "setReprocessingImageReader$camera_camera2", "(Landroidx/camera/core/m;)V", "getReprocessingImageReader$camera_camera2$annotations", "reprocessingImageReader", "LK/l;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "LK/l;", "metadataMatchingCaptureCallback", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Landroidx/camera/core/impl/DeferrableSurface;", "reprocessingImageDeferrableSurface", "k", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class X implements Q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5494v cameraProperties;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.g cameraMetadata;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Y8.h streamConfigurationMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final T.e zslRingBuffer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean isZslDisabledByUseCaseConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean isZslDisabledByFlashMode;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public boolean isZslDisabledByQuirks;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public androidx.camera.core.m reprocessingImageReader;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public AbstractC0889l metadataMatchingCaptureCallback;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public DeferrableSurface reprocessingImageDeferrableSurface;

    public X(InterfaceC5494v cameraProperties) {
        kotlin.jvm.internal.p.i(cameraProperties, "cameraProperties");
        this.cameraProperties = cameraProperties;
        this.cameraMetadata = cameraProperties.getMetadata();
        this.streamConfigurationMap = C4848b.b(new InterfaceC5063a() { // from class: o.S
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return X.t(this.f37329a);
            }
        });
        this.zslRingBuffer = new T.e(3, new T.b() { // from class: o.T
            @Override // T.b
            public final void a(Object obj) {
                X.u((androidx.camera.core.i) obj);
            }
        });
        this.isZslDisabledByQuirks = q.f.f38470a.c(ZslDisablerQuirk.class) != null;
    }

    public static final void n(X x10, InterfaceC0872a0 reader) {
        kotlin.jvm.internal.p.i(reader, "reader");
        try {
            androidx.camera.core.i iVarD = reader.d();
            if (iVarD != null) {
                x10.zslRingBuffer.d(iVarD);
            }
        } catch (IllegalStateException unused) {
            C5473b c5473b = C5473b.f41865a;
            if (C0761b0.g("CXCP")) {
                Log.e(C5473b.TRUNCATED_TAG, "Failed to acquire latest image");
            }
        }
    }

    public static final void o(androidx.camera.core.m mVar) {
        mVar.j();
    }

    public static final void s(androidx.camera.core.m mVar) {
        mVar.j();
    }

    public static final StreamConfigurationMap t(X x10) {
        androidx.camera.camera2.pipe.g gVar = x10.cameraMetadata;
        CameraCharacteristics.Key SCALER_STREAM_CONFIGURATION_MAP = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
        kotlin.jvm.internal.p.h(SCALER_STREAM_CONFIGURATION_MAP, "SCALER_STREAM_CONFIGURATION_MAP");
        Object objE0 = gVar.e0(SCALER_STREAM_CONFIGURATION_MAP);
        if (objE0 != null) {
            return (StreamConfigurationMap) objE0;
        }
        throw new IllegalStateException("Required value was null.");
    }

    public static final void u(androidx.camera.core.i imageProxy) {
        kotlin.jvm.internal.p.i(imageProxy, "imageProxy");
        imageProxy.close();
    }

    @Override // o.Q
    public void a() {
        r();
    }

    @Override // o.Q
    public void b(SessionConfig.b sessionConfigBuilder) {
        kotlin.jvm.internal.p.i(sessionConfigBuilder, "sessionConfigBuilder");
        r();
        if (this.isZslDisabledByUseCaseConfig) {
            sessionConfigBuilder.x(1);
            return;
        }
        if (this.isZslDisabledByQuirks) {
            sessionConfigBuilder.x(1);
            return;
        }
        if (!androidx.camera.camera2.pipe.g.INSTANCE.h(this.cameraMetadata)) {
            C5473b c5473b = C5473b.f41865a;
            if (C0761b0.h("CXCP")) {
                Log.i(C5473b.TRUNCATED_TAG, "ZslControlImpl: Private reprocessing isn't supported");
            }
            sessionConfigBuilder.x(1);
            return;
        }
        Size[] inputSizes = q().getInputSizes(34);
        kotlin.jvm.internal.p.h(inputSizes, "getInputSizes(...)");
        Iterator it = Z8.r.T0(inputSizes).iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            Size size = (Size) next;
            kotlin.jvm.internal.p.f(size);
            int iA = C5476c0.a(size);
            do {
                Object next2 = it.next();
                Size size2 = (Size) next2;
                kotlin.jvm.internal.p.f(size2);
                int iA2 = C5476c0.a(size2);
                if (iA < iA2) {
                    next = next2;
                    iA = iA2;
                }
            } while (it.hasNext());
        }
        Size size3 = (Size) next;
        if (size3 == null) {
            C5473b c5473b2 = C5473b.f41865a;
            if (C0761b0.k("CXCP")) {
                Log.w(C5473b.TRUNCATED_TAG, "ZslControlImpl: Unable to find a supported size for ZSL");
                return;
            }
            return;
        }
        C5473b c5473b3 = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "ZslControlImpl: Selected ZSL size: " + size3);
        }
        int[] validOutputFormatsForInput = q().getValidOutputFormatsForInput(34);
        kotlin.jvm.internal.p.h(validOutputFormatsForInput, "getValidOutputFormatsForInput(...)");
        if (!Z8.r.P(validOutputFormatsForInput, 256)) {
            if (C0761b0.k("CXCP")) {
                Log.w(C5473b.TRUNCATED_TAG, "ZslControlImpl: JPEG isn't valid output for ZSL format");
                return;
            }
            return;
        }
        androidx.camera.core.j jVar = new androidx.camera.core.j(size3.getWidth(), size3.getHeight(), 34, 9);
        AbstractC0889l abstractC0889lM = jVar.m();
        kotlin.jvm.internal.p.h(abstractC0889lM, "getCameraCaptureCallback(...)");
        final androidx.camera.core.m mVar = new androidx.camera.core.m(jVar);
        jVar.b(new InterfaceC0872a0.a() { // from class: o.U
            @Override // K.InterfaceC0872a0.a
            public final void a(InterfaceC0872a0 interfaceC0872a0) {
                X.n(this.f37330a, interfaceC0872a0);
            }
        }, N.a.c());
        Surface surface = mVar.getSurface();
        if (surface == null) {
            throw new IllegalStateException("Required value was null.");
        }
        C0874b0 c0874b0 = new C0874b0(surface, new Size(mVar.getWidth(), mVar.getHeight()), 34);
        c0874b0.k().a(new Runnable() { // from class: o.V
            @Override // java.lang.Runnable
            public final void run() {
                X.o(mVar);
            }
        }, N.a.d());
        sessionConfigBuilder.l(c0874b0);
        sessionConfigBuilder.e(abstractC0889lM);
        sessionConfigBuilder.t(new InputConfiguration(mVar.getWidth(), mVar.getHeight(), mVar.e()));
        this.metadataMatchingCaptureCallback = abstractC0889lM;
        this.reprocessingImageReader = mVar;
        this.reprocessingImageDeferrableSurface = c0874b0;
    }

    @Override // o.Q
    /* renamed from: c, reason: from getter */
    public boolean getIsZslDisabledByUseCaseConfig() {
        return this.isZslDisabledByUseCaseConfig;
    }

    @Override // o.Q
    public void d(boolean disabled) {
        this.isZslDisabledByFlashMode = disabled;
    }

    @Override // o.Q
    public void e(boolean disabled) {
        if (this.isZslDisabledByUseCaseConfig != disabled && disabled) {
            p();
        }
        this.isZslDisabledByUseCaseConfig = disabled;
    }

    @Override // o.Q
    public androidx.camera.core.i f() {
        try {
            return this.zslRingBuffer.a();
        } catch (NoSuchElementException unused) {
            C5473b c5473b = C5473b.f41865a;
            if (!C0761b0.k("CXCP")) {
                return null;
            }
            Log.w(C5473b.TRUNCATED_TAG, "ZslControlImpl#dequeueImageFromBuffer: No such element");
            return null;
        }
    }

    @Override // o.Q
    public boolean g(DeferrableSurface surface, SessionConfig sessionConfig) {
        kotlin.jvm.internal.p.i(surface, "surface");
        kotlin.jvm.internal.p.i(sessionConfig, "sessionConfig");
        InputConfiguration inputConfigurationH = sessionConfig.h();
        return inputConfigurationH != null && surface.i() == inputConfigurationH.getFormat() && surface.h().getWidth() == inputConfigurationH.getWidth() && surface.h().getHeight() == inputConfigurationH.getHeight();
    }

    @Override // o.Q
    /* renamed from: h, reason: from getter */
    public boolean getIsZslDisabledByFlashMode() {
        return this.isZslDisabledByFlashMode;
    }

    public final void p() {
        T.e eVar = this.zslRingBuffer;
        while (!eVar.c()) {
            eVar.a().close();
        }
    }

    public final StreamConfigurationMap q() {
        return (StreamConfigurationMap) this.streamConfigurationMap.getValue();
    }

    public final void r() {
        DeferrableSurface deferrableSurface = this.reprocessingImageDeferrableSurface;
        if (deferrableSurface != null) {
            final androidx.camera.core.m mVar = this.reprocessingImageReader;
            if (mVar != null) {
                deferrableSurface.k().a(new Runnable() { // from class: o.W
                    @Override // java.lang.Runnable
                    public final void run() {
                        X.s(mVar);
                    }
                }, N.a.d());
                mVar.f();
                this.reprocessingImageReader = null;
            }
            deferrableSurface.d();
            this.reprocessingImageDeferrableSurface = null;
        }
        p();
    }
}
