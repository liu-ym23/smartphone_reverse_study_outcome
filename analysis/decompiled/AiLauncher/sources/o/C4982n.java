package o;

import D.C0761b0;
import K.InterfaceC0896t;
import K.SurfaceStreamSpecQueryResult;
import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.camera.camera2.adapter.SupportedSurfaceCombination;
import androidx.camera.camera2.impl.FeatureCombinationQueryImpl;
import androidx.camera.camera2.pipe.DoNotDisturbException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraUpdateException;
import androidx.camera.core.impl.StreamUseCase;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.stabilization.VideoStabilization;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import s.InterfaceC5426a;
import t.C5473b;
import w.C5708n;
import w.InterfaceC5705k;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJk\u0010)\u001a\u00020(2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000b2\u001c\u0010\"\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u000b0 2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u001bH\u0016¢\u0006\u0004\b)\u0010*J)\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020,0 2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0002¢\u0006\u0004\b-\u0010.R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010/R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u00101R\u0014\u00105\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\"\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020,0 8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u00069"}, d2 = {"Lo/n;", "LK/t;", "Landroid/content/Context;", "context", "", "cameraComponent", "", "", "availableCameraIds", "<init>", "(Landroid/content/Context;Ljava/lang/Object;Ljava/util/Set;)V", "", "cameraIds", "LY8/t;", "f", "(Ljava/util/List;)V", "", "cameraMode", "cameraId", "imageFormat", "Landroid/util/Size;", ContentDisposition.Parameters.Size, "Landroidx/camera/core/impl/StreamUseCase;", "streamUseCase", "Landroidx/camera/core/impl/SurfaceConfig;", Const.INTENT_KEY_APIKEY, "(ILjava/lang/String;ILandroid/util/Size;Landroidx/camera/core/impl/StreamUseCase;)Landroidx/camera/core/impl/SurfaceConfig;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)Z", "Landroidx/camera/core/impl/b;", "existingSurfaces", "", "Landroidx/camera/core/impl/z;", "newUseCaseConfigsSupportedSizeMap", "Landroidx/camera/core/impl/stabilization/VideoStabilization;", "videoStabilization", "hasVideoCapture", "isFeatureComboInvocation", "findMaxSupportedFrameRate", "LK/D0;", Const.INTENT_KEY_PKGNAME, "(ILjava/lang/String;Ljava/util/List;Ljava/util/Map;Landroidx/camera/core/impl/stabilization/VideoStabilization;ZZZ)LK/D0;", "cameraIdsToBuild", "Landroidx/camera/camera2/adapter/SupportedSurfaceCombination;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/List;)Ljava/util/Map;", "Landroid/content/Context;", "Ls/a;", "Ls/a;", "component", "c", "Ljava/lang/Object;", "lock", Const.INTENT_KEY_UMID, "Ljava/util/Map;", "supportedSurfaceCombinationMap", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: o.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4982n implements InterfaceC0896t {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5426a component;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public Map<String, SupportedSurfaceCombination> supportedSurfaceCombinationMap;

    public C4982n(Context context, Object obj, Set<String> availableCameraIds) throws InitializationException {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(availableCameraIds, "availableCameraIds");
        this.context = context;
        kotlin.jvm.internal.p.g(obj, "null cannot be cast to non-null type androidx.camera.camera2.config.CameraAppComponent");
        this.component = (InterfaceC5426a) obj;
        this.lock = new Object();
        this.supportedSurfaceCombinationMap = kotlin.collections.a.i();
        try {
            f(Z8.F.m1(availableCameraIds));
        } catch (CameraUpdateException e10) {
            throw new InitializationException(e10);
        }
    }

    @Override // K.InterfaceC0896t
    public SurfaceConfig a(int cameraMode, String cameraId, int imageFormat, Size size, StreamUseCase streamUseCase) {
        SupportedSurfaceCombination supportedSurfaceCombination;
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        kotlin.jvm.internal.p.i(size, "size");
        kotlin.jvm.internal.p.i(streamUseCase, "streamUseCase");
        B0.h.b(j(cameraId), "No such camera id in supported combination list: " + cameraId);
        synchronized (this.lock) {
            supportedSurfaceCombination = this.supportedSurfaceCombinationMap.get(cameraId);
        }
        if (supportedSurfaceCombination != null) {
            return supportedSurfaceCombination.m0(cameraMode, imageFormat, size, streamUseCase);
        }
        throw new IllegalArgumentException("No such camera id in supported combination list: " + cameraId);
    }

    @Override // K.InterfaceC0896t
    public SurfaceStreamSpecQueryResult b(int cameraMode, String cameraId, List<? extends androidx.camera.core.impl.b> existingSurfaces, Map<androidx.camera.core.impl.z<?>, ? extends List<Size>> newUseCaseConfigsSupportedSizeMap, VideoStabilization videoStabilization, boolean hasVideoCapture, boolean isFeatureComboInvocation, boolean findMaxSupportedFrameRate) {
        SupportedSurfaceCombination supportedSurfaceCombination;
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        kotlin.jvm.internal.p.i(existingSurfaces, "existingSurfaces");
        kotlin.jvm.internal.p.i(newUseCaseConfigsSupportedSizeMap, "newUseCaseConfigsSupportedSizeMap");
        kotlin.jvm.internal.p.i(videoStabilization, "videoStabilization");
        B0.h.b(j(cameraId), "No such camera id in supported combination list: " + cameraId);
        synchronized (this.lock) {
            supportedSurfaceCombination = this.supportedSurfaceCombinationMap.get(cameraId);
        }
        if (supportedSurfaceCombination != null) {
            return supportedSurfaceCombination.U(cameraMode, existingSurfaces, newUseCaseConfigsSupportedSizeMap, videoStabilization, hasVideoCapture, isFeatureComboInvocation, findMaxSupportedFrameRate);
        }
        throw new IllegalArgumentException("No such camera id in supported combination list: " + cameraId);
    }

    @Override // K.InterfaceC0876c0
    public void f(List<String> cameraIds) throws CameraUpdateException {
        List<String> listN0;
        kotlin.jvm.internal.p.i(cameraIds, "cameraIds");
        synchronized (this.lock) {
            listN0 = Z8.F.N0(cameraIds, this.supportedSurfaceCombinationMap.keySet());
            Y8.t tVar = Y8.t.f7040a;
        }
        if (!listN0.isEmpty()) {
            C5473b c5473b = C5473b.f41865a;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "Creating new surface combinations for: " + listN0);
            }
        }
        Map<String, SupportedSurfaceCombination> mapI = i(listN0);
        synchronized (this.lock) {
            try {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (String str : cameraIds) {
                    if (this.supportedSurfaceCombinationMap.containsKey(str)) {
                        SupportedSurfaceCombination supportedSurfaceCombination = this.supportedSurfaceCombinationMap.get(str);
                        kotlin.jvm.internal.p.f(supportedSurfaceCombination);
                        linkedHashMap.put(str, supportedSurfaceCombination);
                    }
                }
                linkedHashMap.putAll(mapI);
                this.supportedSurfaceCombinationMap = linkedHashMap;
                C5473b c5473b2 = C5473b.f41865a;
                if (C0761b0.f("CXCP")) {
                    Log.d(C5473b.TRUNCATED_TAG, "Committed new surface combination map. Total cameras: " + linkedHashMap.size());
                }
                Y8.t tVar2 = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Map<String, SupportedSurfaceCombination> i(List<String> cameraIdsToBuild) throws CameraUpdateException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!cameraIdsToBuild.isEmpty()) {
            try {
                for (String str : cameraIdsToBuild) {
                    androidx.camera.camera2.pipe.g gVarA = InterfaceC5705k.a(this.component.b(), C5708n.b(str), null, 2, null);
                    if (gVarA != null) {
                        CameraCharacteristics.Key SCALER_STREAM_CONFIGURATION_MAP = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
                        kotlin.jvm.internal.p.h(SCALER_STREAM_CONFIGURATION_MAP, "SCALER_STREAM_CONFIGURATION_MAP");
                        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) gVarA.e0(SCALER_STREAM_CONFIGURATION_MAP);
                        androidx.camera.camera2.compat.quirk.a aVar = new androidx.camera.camera2.compat.quirk.a(gVarA, new p.q(streamConfigurationMap, new r.y(gVarA, streamConfigurationMap)));
                        linkedHashMap.put(str, new SupportedSurfaceCombination(this.context, gVarA, s.o.INSTANCE.d(str, aVar), Build.VERSION.SDK_INT >= 35 ? new FeatureCombinationQueryImpl(gVarA, this.component.a(), aVar) : androidx.camera.core.featuregroup.impl.a.f11304b));
                    }
                }
            } catch (DoNotDisturbException e10) {
                throw new CameraUpdateException("Failed to query camera metadata", e10);
            } catch (Exception e11) {
                throw new CameraUpdateException("Failed to build surface combinations", e11);
            }
        }
        return linkedHashMap;
    }

    public final boolean j(String cameraId) {
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        return this.supportedSurfaceCombinationMap.containsKey(cameraId);
    }
}
