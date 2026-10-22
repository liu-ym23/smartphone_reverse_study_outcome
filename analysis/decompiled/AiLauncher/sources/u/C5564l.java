package u;

import D.C0761b0;
import Z8.C1173v;
import Z8.Q;
import Z8.X;
import Z8.Y;
import android.hardware.camera2.CameraCharacteristics;
import android.util.Log;
import androidx.camera.camera2.adapter.SupportedSurfaceCombination;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.q;
import androidx.camera.core.impl.r;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.y;
import androidx.camera.core.impl.z;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import t.C5473b;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u000e\u001a\u00020\r2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00112\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJO\u0010#\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0016\u0010!\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020 0\t2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020 0\t¢\u0006\u0004\b#\u0010$J#\u0010'\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u001d¢\u0006\u0004\b'\u0010(JI\u0010.\u001a\u00020\u00162\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020*\u0012\u0006\u0012\u0004\u0018\u00010\u001e0)2\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070)2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020%0\u001d¢\u0006\u0004\b.\u0010/Js\u00100\u001a\u00020\r2\u0016\u0010!\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020 0\t2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020 0\t2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001e0)2\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070)2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020%0\u001d¢\u0006\u0004\b0\u00101J-\u00103\u001a\u00020\u00162\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0010\u00102\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u001d¢\u0006\u0004\b3\u00104J-\u00109\u001a\u00020\u00162\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u00020\u000b2\f\u00108\u001a\b\u0012\u0004\u0012\u0002050\u001dH\u0002¢\u0006\u0004\b9\u0010:J#\u0010=\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020;2\b\u00107\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b=\u0010>J\u001f\u0010@\u001a\u00020\u00162\u0006\u0010?\u001a\u00020;2\u0006\u00106\u001a\u000205H\u0002¢\u0006\u0004\b@\u0010AJ+\u0010E\u001a\u00020\u00162\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u000b0B2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u000b0BH\u0002¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\rH\u0002¢\u0006\u0004\bG\u0010\u0003J=\u0010I\u001a\u00020\u00162\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0010\u00102\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u001d2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u000b0BH\u0002¢\u0006\u0004\bI\u0010JJ\u001f\u0010L\u001a\u00020*2\u0006\u00106\u001a\u0002052\u0006\u0010K\u001a\u00020*H\u0003¢\u0006\u0004\bL\u0010MR&\u0010S\u001a\b\u0012\u0004\u0012\u00020\u000b0N8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bE\u0010O\u0012\u0004\bR\u0010\u0003\u001a\u0004\bP\u0010QR&\u0010U\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002050B0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010TR&\u0010V\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002050B0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010T¨\u0006W"}, d2 = {"Lu/l;", "", "<init>", "()V", "", "Landroidx/camera/core/impl/SessionConfig;", "sessionConfigs", "Landroidx/camera/core/impl/z;", "useCaseConfigs", "", "Landroidx/camera/core/impl/DeferrableSurface;", "", "streamUseCaseMap", "LY8/t;", "n", "(Ljava/util/Collection;Ljava/util/Collection;Ljava/util/Map;)V", "useCaseConfig", "Landroidx/camera/camera2/impl/a;", "f", "(Landroidx/camera/core/impl/z;)Landroidx/camera/camera2/impl/a;", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroidx/camera/camera2/pipe/g;)Z", "Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$c;", "featureSettings", "o", "(Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$c;)Z", "", "Landroidx/camera/core/impl/b;", "attachedSurfaces", "Landroidx/camera/core/impl/y;", "suggestedStreamSpecMap", "attachedSurfaceStreamSpecMap", "l", "(Landroidx/camera/camera2/pipe/g;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;)Z", "Landroidx/camera/core/impl/SurfaceConfig;", "surfaceConfigs", "c", "(Landroidx/camera/camera2/pipe/g;Ljava/util/List;)Z", "", "", "surfaceConfigIndexAttachedSurfaceInfoMap", "surfaceConfigIndexUseCaseConfigMap", "surfaceConfigsWithStreamUseCase", Const.INTENT_KEY_APIKEY, "(Ljava/util/Map;Ljava/util/Map;Ljava/util/List;)Z", "m", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;)V", "newUseCaseConfigs", Const.INTENT_KEY_UMID, "(Ljava/util/List;Ljava/util/List;)Z", "Landroidx/camera/core/impl/UseCaseConfigFactory$CaptureType;", "captureType", "streamUseCase", "streamSharingTypes", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroidx/camera/core/impl/UseCaseConfigFactory$CaptureType;JLjava/util/List;)Z", "Landroidx/camera/core/impl/Config;", "oldImplementationOptions", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroidx/camera/core/impl/Config;Ljava/lang/Long;)Landroidx/camera/core/impl/Config;", "config", "k", "(Landroidx/camera/core/impl/Config;Landroidx/camera/core/impl/UseCaseConfigFactory$CaptureType;)Z", "", "availableStreamUseCasesSet", "streamUseCases", Const.INTENT_KEY_PKGNAME, "(Ljava/util/Set;Ljava/util/Set;)Z", "p", "availableStreamUseCases", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/util/List;Ljava/util/List;Ljava/util/Set;)Z", "captureMode", "e", "(Landroidx/camera/core/impl/UseCaseConfigFactory$CaptureType;I)I", "Landroidx/camera/core/impl/Config$a;", "Landroidx/camera/core/impl/Config$a;", "getSTREAM_USE_CASE_STREAM_SPEC_OPTION", "()Landroidx/camera/core/impl/Config$a;", "getSTREAM_USE_CASE_STREAM_SPEC_OPTION$annotations", "STREAM_USE_CASE_STREAM_SPEC_OPTION", "Ljava/util/Map;", "STREAM_USE_CASE_TO_ELIGIBLE_CAPTURE_TYPES_MAP", "STREAM_USE_CASE_TO_ELIGIBLE_STREAM_SHARING_CHILDREN_TYPES_MAP", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: u.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5564l {

    /* renamed from: a, reason: collision with root package name */
    public static final C5564l f42381a = new C5564l();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Config.a<Long> STREAM_USE_CASE_STREAM_SPEC_OPTION;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Map<Long, Set<UseCaseConfigFactory.CaptureType>> STREAM_USE_CASE_TO_ELIGIBLE_CAPTURE_TYPES_MAP;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Map<Long, Set<UseCaseConfigFactory.CaptureType>> STREAM_USE_CASE_TO_ELIGIBLE_STREAM_SHARING_CHILDREN_TYPES_MAP;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: u.l$a */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42385a;

        static {
            int[] iArr = new int[UseCaseConfigFactory.CaptureType.values().length];
            try {
                iArr[UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UseCaseConfigFactory.CaptureType.STREAM_SHARING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UseCaseConfigFactory.CaptureType.PREVIEW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f42385a = iArr;
        }
    }

    static {
        Class cls = Long.TYPE;
        p.f(cls);
        Config.a<Long> aVarA = Config.a.a("camera2.streamSpec.streamUseCase", cls);
        p.h(aVarA, "create(...)");
        STREAM_USE_CASE_STREAM_SPEC_OPTION = aVarA;
        Map mapC = Q.c();
        UseCaseConfigFactory.CaptureType captureType = UseCaseConfigFactory.CaptureType.PREVIEW;
        UseCaseConfigFactory.CaptureType captureType2 = UseCaseConfigFactory.CaptureType.METERING_REPEATING;
        UseCaseConfigFactory.CaptureType captureType3 = UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS;
        mapC.put(4L, Y.j(captureType, captureType2, captureType3));
        mapC.put(1L, Y.j(captureType, captureType2, captureType3));
        UseCaseConfigFactory.CaptureType captureType4 = UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE;
        mapC.put(2L, X.d(captureType4));
        UseCaseConfigFactory.CaptureType captureType5 = UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE;
        mapC.put(3L, X.d(captureType5));
        STREAM_USE_CASE_TO_ELIGIBLE_CAPTURE_TYPES_MAP = Q.b(mapC);
        Map mapC2 = Q.c();
        mapC2.put(4L, Y.j(captureType, captureType4, captureType5));
        mapC2.put(3L, Y.j(captureType, captureType5));
        STREAM_USE_CASE_TO_ELIGIBLE_STREAM_SHARING_CHILDREN_TYPES_MAP = Q.b(mapC2);
    }

    public final boolean a(Map<Integer, ? extends androidx.camera.core.impl.b> surfaceConfigIndexAttachedSurfaceInfoMap, Map<Integer, ? extends z<?>> surfaceConfigIndexUseCaseConfigMap, List<SurfaceConfig> surfaceConfigsWithStreamUseCase) {
        List<UseCaseConfigFactory.CaptureType> listM;
        p.i(surfaceConfigIndexAttachedSurfaceInfoMap, "surfaceConfigIndexAttachedSurfaceInfoMap");
        p.i(surfaceConfigIndexUseCaseConfigMap, "surfaceConfigIndexUseCaseConfigMap");
        p.i(surfaceConfigsWithStreamUseCase, "surfaceConfigsWithStreamUseCase");
        int size = surfaceConfigsWithStreamUseCase.size();
        for (int i10 = 0; i10 < size; i10++) {
            long value = surfaceConfigsWithStreamUseCase.get(i10).getStreamUseCase().getValue();
            if (surfaceConfigIndexAttachedSurfaceInfoMap.containsKey(Integer.valueOf(i10))) {
                androidx.camera.core.impl.b bVar = surfaceConfigIndexAttachedSurfaceInfoMap.get(Integer.valueOf(i10));
                p.f(bVar);
                UseCaseConfigFactory.CaptureType captureType = bVar.b().size() == 1 ? bVar.b().get(0) : UseCaseConfigFactory.CaptureType.STREAM_SHARING;
                p.f(captureType);
                List<UseCaseConfigFactory.CaptureType> listB = bVar.b();
                p.h(listB, "getCaptureTypes(...)");
                if (!h(captureType, value, listB)) {
                    return false;
                }
            } else {
                if (!surfaceConfigIndexUseCaseConfigMap.containsKey(Integer.valueOf(i10))) {
                    throw new AssertionError("SurfaceConfig does not map to any use case");
                }
                z<?> zVar = surfaceConfigIndexUseCaseConfigMap.get(Integer.valueOf(i10));
                p.f(zVar);
                z<?> zVar2 = zVar;
                UseCaseConfigFactory.CaptureType captureTypeV = zVar2.V();
                p.h(captureTypeV, "getCaptureType(...)");
                if (zVar2.V() == UseCaseConfigFactory.CaptureType.STREAM_SHARING) {
                    listM = ((Y.h) zVar2).h0();
                    p.h(listM, "getCaptureTypes(...)");
                } else {
                    listM = C1173v.m();
                }
                if (!h(captureTypeV, value, listM)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean b(Set<Long> availableStreamUseCasesSet, Set<Long> streamUseCases) {
        Iterator<Long> it = streamUseCases.iterator();
        while (it.hasNext()) {
            if (!availableStreamUseCasesSet.contains(Long.valueOf(it.next().longValue()))) {
                return false;
            }
        }
        return true;
    }

    public final boolean c(androidx.camera.camera2.pipe.g cameraMetadata, List<SurfaceConfig> surfaceConfigs) {
        p.i(cameraMetadata, "cameraMetadata");
        p.i(surfaceConfigs, "surfaceConfigs");
        CameraCharacteristics.Key SCALER_AVAILABLE_STREAM_USE_CASES = CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES;
        p.h(SCALER_AVAILABLE_STREAM_USE_CASES, "SCALER_AVAILABLE_STREAM_USE_CASES");
        long[] jArr = (long[]) cameraMetadata.e0(SCALER_AVAILABLE_STREAM_USE_CASES);
        if (jArr == null || jArr.length == 0) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (long j10 : jArr) {
            hashSet.add(Long.valueOf(j10));
        }
        Iterator<SurfaceConfig> it = surfaceConfigs.iterator();
        while (it.hasNext()) {
            if (!hashSet.contains(Long.valueOf(it.next().getStreamUseCase().getValue()))) {
                return false;
            }
        }
        return true;
    }

    public final boolean d(List<? extends androidx.camera.core.impl.b> attachedSurfaces, List<? extends z<?>> newUseCaseConfigs) {
        p.i(attachedSurfaces, "attachedSurfaces");
        p.i(newUseCaseConfigs, "newUseCaseConfigs");
        for (androidx.camera.core.impl.b bVar : attachedSurfaces) {
            List<UseCaseConfigFactory.CaptureType> listB = bVar.b();
            p.h(listB, "getCaptureTypes(...)");
            UseCaseConfigFactory.CaptureType captureType = listB.get(0);
            Config configF = bVar.f();
            p.f(configF);
            p.f(captureType);
            if (k(configF, captureType)) {
                return true;
            }
        }
        for (z<?> zVar : newUseCaseConfigs) {
            UseCaseConfigFactory.CaptureType captureTypeV = zVar.V();
            p.h(captureTypeV, "getCaptureType(...)");
            if (k(zVar, captureTypeV)) {
                return true;
            }
        }
        return false;
    }

    public final int e(UseCaseConfigFactory.CaptureType captureType, int captureMode) {
        int i10 = a.f42385a[captureType.ordinal()];
        return i10 != 1 ? (i10 == 2 || i10 == 3) ? 3 : 1 : captureMode == 2 ? 5 : 1;
    }

    public final androidx.camera.camera2.impl.a f(z<?> useCaseConfig) {
        p.i(useCaseConfig, "useCaseConfig");
        u uVarK0 = u.k0();
        p.h(uVarK0, "create(...)");
        Config.a<?> aVar = androidx.camera.camera2.impl.a.f10034X;
        if (useCaseConfig.b(aVar)) {
            uVarK0.t(aVar, useCaseConfig.a(aVar));
        }
        Config.a<?> aVar2 = z.f11549J;
        if (useCaseConfig.b(aVar2)) {
            uVarK0.t(aVar2, useCaseConfig.a(aVar2));
        }
        Config.a<?> aVar3 = q.f11469S;
        if (useCaseConfig.b(aVar3)) {
            uVarK0.t(aVar3, useCaseConfig.a(aVar3));
        }
        Config.a<?> aVar4 = r.f11483n;
        if (useCaseConfig.b(aVar4)) {
            uVarK0.t(aVar4, useCaseConfig.a(aVar4));
        }
        return new androidx.camera.camera2.impl.a(uVarK0);
    }

    public final Config g(Config oldImplementationOptions, Long streamUseCase) {
        Config.a<Long> aVar = STREAM_USE_CASE_STREAM_SPEC_OPTION;
        if (oldImplementationOptions.b(aVar) && p.d(oldImplementationOptions.a(aVar), streamUseCase)) {
            return null;
        }
        u uVarL0 = u.l0(oldImplementationOptions);
        p.h(uVarL0, "from(...)");
        uVarL0.t(aVar, streamUseCase);
        return new androidx.camera.camera2.impl.a(uVarL0);
    }

    public final boolean h(UseCaseConfigFactory.CaptureType captureType, long streamUseCase, List<? extends UseCaseConfigFactory.CaptureType> streamSharingTypes) {
        if (captureType != UseCaseConfigFactory.CaptureType.STREAM_SHARING) {
            Map<Long, Set<UseCaseConfigFactory.CaptureType>> map = STREAM_USE_CASE_TO_ELIGIBLE_CAPTURE_TYPES_MAP;
            if (map.containsKey(Long.valueOf(streamUseCase))) {
                Set<UseCaseConfigFactory.CaptureType> set = map.get(Long.valueOf(streamUseCase));
                p.f(set);
                if (set.contains(captureType)) {
                    return true;
                }
            }
            return false;
        }
        Map<Long, Set<UseCaseConfigFactory.CaptureType>> map2 = STREAM_USE_CASE_TO_ELIGIBLE_STREAM_SHARING_CHILDREN_TYPES_MAP;
        if (!map2.containsKey(Long.valueOf(streamUseCase))) {
            return false;
        }
        Set<UseCaseConfigFactory.CaptureType> set2 = map2.get(Long.valueOf(streamUseCase));
        p.f(set2);
        Set<UseCaseConfigFactory.CaptureType> set3 = set2;
        if (streamSharingTypes.size() != set3.size()) {
            return false;
        }
        Iterator<? extends UseCaseConfigFactory.CaptureType> it = streamSharingTypes.iterator();
        while (it.hasNext()) {
            if (!set3.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean i(androidx.camera.camera2.pipe.g cameraMetadata) {
        p.i(cameraMetadata, "cameraMetadata");
        CameraCharacteristics.Key SCALER_AVAILABLE_STREAM_USE_CASES = CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES;
        p.h(SCALER_AVAILABLE_STREAM_USE_CASES, "SCALER_AVAILABLE_STREAM_USE_CASES");
        long[] jArr = (long[]) cameraMetadata.e0(SCALER_AVAILABLE_STREAM_USE_CASES);
        return (jArr == null || jArr.length == 0) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean j(java.util.List<? extends androidx.camera.core.impl.b> r10, java.util.List<? extends androidx.camera.core.impl.z<?>> r11, java.util.Set<java.lang.Long> r12) {
        /*
            r9 = this;
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r0.<init>()
            java.util.Iterator r10 = r10.iterator()
            boolean r1 = r10.hasNext()
            r2 = 0
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L47
            java.lang.Object r10 = r10.next()
            androidx.camera.core.impl.b r10 = (androidx.camera.core.impl.b) r10
            androidx.camera.core.impl.Config r1 = r10.f()
            kotlin.jvm.internal.p.f(r1)
            androidx.camera.core.impl.Config$a<java.lang.Long> r6 = androidx.camera.camera2.impl.a.f10034X
            boolean r1 = r1.b(r6)
            if (r1 != 0) goto L2b
        L28:
            r1 = r4
            r10 = r5
            goto L49
        L2b:
            androidx.camera.core.impl.Config r10 = r10.f()
            kotlin.jvm.internal.p.f(r10)
            java.lang.Object r10 = r10.a(r6)
            kotlin.jvm.internal.p.f(r10)
            java.lang.Number r10 = (java.lang.Number) r10
            long r6 = r10.longValue()
            int r10 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r10 != 0) goto L44
            goto L28
        L44:
            r10 = r4
            r1 = r5
            goto L49
        L47:
            r10 = r5
            r1 = r10
        L49:
            java.util.Iterator r11 = r11.iterator()
        L4d:
            boolean r6 = r11.hasNext()
            if (r6 == 0) goto L8d
            java.lang.Object r6 = r11.next()
            androidx.camera.core.impl.z r6 = (androidx.camera.core.impl.z) r6
            androidx.camera.core.impl.Config$a<java.lang.Long> r7 = androidx.camera.camera2.impl.a.f10034X
            boolean r8 = r6.b(r7)
            if (r8 != 0) goto L68
            if (r10 == 0) goto L66
            r9.p()
        L66:
            r1 = r4
            goto L4d
        L68:
            java.lang.Object r6 = r6.a(r7)
            kotlin.jvm.internal.p.f(r6)
            java.lang.Number r6 = (java.lang.Number) r6
            long r6 = r6.longValue()
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 != 0) goto L7f
            if (r10 == 0) goto L66
            r9.p()
            goto L66
        L7f:
            if (r1 == 0) goto L84
            r9.p()
        L84:
            java.lang.Long r10 = java.lang.Long.valueOf(r6)
            r0.add(r10)
            r10 = r4
            goto L4d
        L8d:
            if (r1 != 0) goto L96
            boolean r9 = r9.b(r12, r0)
            if (r9 == 0) goto L96
            return r4
        L96:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: u.C5564l.j(java.util.List, java.util.List, java.util.Set):boolean");
    }

    public final boolean k(Config config, UseCaseConfigFactory.CaptureType captureType) {
        Object objG = config.g(z.f11549J, Boolean.FALSE);
        p.f(objG);
        if (((Boolean) objG).booleanValue()) {
            return false;
        }
        Config.a<Integer> aVar = q.f11469S;
        if (!config.b(aVar)) {
            return false;
        }
        Object objA = config.a(aVar);
        p.f(objA);
        return e(captureType, ((Number) objA).intValue()) == 5;
    }

    public final boolean l(androidx.camera.camera2.pipe.g cameraMetadata, List<? extends androidx.camera.core.impl.b> attachedSurfaces, Map<z<?>, y> suggestedStreamSpecMap, Map<androidx.camera.core.impl.b, y> attachedSurfaceStreamSpecMap) {
        p.i(cameraMetadata, "cameraMetadata");
        p.i(attachedSurfaces, "attachedSurfaces");
        p.i(suggestedStreamSpecMap, "suggestedStreamSpecMap");
        p.i(attachedSurfaceStreamSpecMap, "attachedSurfaceStreamSpecMap");
        ArrayList arrayList = new ArrayList(suggestedStreamSpecMap.keySet());
        Iterator<? extends androidx.camera.core.impl.b> it = attachedSurfaces.iterator();
        while (it.hasNext()) {
            if (it.next().f() == null) {
                throw new IllegalStateException("Required value was null.");
            }
        }
        Iterator<? extends z<?>> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            y yVar = suggestedStreamSpecMap.get(it2.next());
            if (yVar == null) {
                throw new IllegalStateException("Required value was null.");
            }
            if (yVar.d() == null) {
                throw new IllegalStateException("Required value was null.");
            }
        }
        CameraCharacteristics.Key SCALER_AVAILABLE_STREAM_USE_CASES = CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES;
        p.h(SCALER_AVAILABLE_STREAM_USE_CASES, "SCALER_AVAILABLE_STREAM_USE_CASES");
        long[] jArr = (long[]) cameraMetadata.e0(SCALER_AVAILABLE_STREAM_USE_CASES);
        if (jArr != null && jArr.length != 0) {
            HashSet hashSet = new HashSet();
            for (long j10 : jArr) {
                hashSet.add(Long.valueOf(j10));
            }
            if (j(attachedSurfaces, arrayList, hashSet)) {
                for (androidx.camera.core.impl.b bVar : attachedSurfaces) {
                    Config configF = bVar.f();
                    p.f(configF);
                    Config configG = g(configF, (Long) configF.a(androidx.camera.camera2.impl.a.f10034X));
                    if (configG != null) {
                        attachedSurfaceStreamSpecMap.put(bVar, bVar.l(configG));
                    }
                }
                for (z<?> zVar : arrayList) {
                    y yVar2 = suggestedStreamSpecMap.get(zVar);
                    p.f(yVar2);
                    Config configD = yVar2.d();
                    p.f(configD);
                    Config configG2 = g(configD, (Long) configD.a(androidx.camera.camera2.impl.a.f10034X));
                    if (configG2 != null) {
                        suggestedStreamSpecMap.put(zVar, yVar2.i().d(configG2).a());
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void m(Map<z<?>, y> suggestedStreamSpecMap, Map<androidx.camera.core.impl.b, y> attachedSurfaceStreamSpecMap, Map<Integer, ? extends androidx.camera.core.impl.b> surfaceConfigIndexAttachedSurfaceInfoMap, Map<Integer, ? extends z<?>> surfaceConfigIndexUseCaseConfigMap, List<SurfaceConfig> surfaceConfigsWithStreamUseCase) {
        p.i(suggestedStreamSpecMap, "suggestedStreamSpecMap");
        p.i(attachedSurfaceStreamSpecMap, "attachedSurfaceStreamSpecMap");
        p.i(surfaceConfigIndexAttachedSurfaceInfoMap, "surfaceConfigIndexAttachedSurfaceInfoMap");
        p.i(surfaceConfigIndexUseCaseConfigMap, "surfaceConfigIndexUseCaseConfigMap");
        p.i(surfaceConfigsWithStreamUseCase, "surfaceConfigsWithStreamUseCase");
        int size = surfaceConfigsWithStreamUseCase.size();
        for (int i10 = 0; i10 < size; i10++) {
            long value = surfaceConfigsWithStreamUseCase.get(i10).getStreamUseCase().getValue();
            if (surfaceConfigIndexAttachedSurfaceInfoMap.containsKey(Integer.valueOf(i10))) {
                androidx.camera.core.impl.b bVar = surfaceConfigIndexAttachedSurfaceInfoMap.get(Integer.valueOf(i10));
                p.f(bVar);
                Config configF = bVar.f();
                p.f(configF);
                Config configG = g(configF, Long.valueOf(value));
                if (configG != null) {
                    attachedSurfaceStreamSpecMap.put(bVar, bVar.l(configG));
                }
            } else {
                if (!surfaceConfigIndexUseCaseConfigMap.containsKey(Integer.valueOf(i10))) {
                    throw new AssertionError("SurfaceConfig does not map to any use case");
                }
                z<?> zVar = surfaceConfigIndexUseCaseConfigMap.get(Integer.valueOf(i10));
                p.f(zVar);
                z<?> zVar2 = zVar;
                y yVar = suggestedStreamSpecMap.get(zVar2);
                p.f(yVar);
                Config configD = yVar.d();
                p.f(configD);
                Config configG2 = g(configD, Long.valueOf(value));
                if (configG2 != null) {
                    y yVarA = yVar.i().d(configG2).a();
                    p.h(yVarA, "build(...)");
                    suggestedStreamSpecMap.put(zVar2, yVarA);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n(Collection<SessionConfig> sessionConfigs, Collection<? extends z<?>> useCaseConfigs, Map<DeferrableSurface, Long> streamUseCaseMap) {
        p.i(sessionConfigs, "sessionConfigs");
        p.i(useCaseConfigs, "useCaseConfigs");
        p.i(streamUseCaseMap, "streamUseCaseMap");
        ArrayList arrayList = new ArrayList(useCaseConfigs);
        Iterator<SessionConfig> it = sessionConfigs.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SessionConfig next = it.next();
            Config configG = next.g();
            Config.a<Long> aVar = STREAM_USE_CASE_STREAM_SPEC_OPTION;
            if (configG.b(aVar) && next.p().size() != 1) {
                C5473b c5473b = C5473b.f41865a;
                if (C0761b0.g("CXCP")) {
                    Log.e(C5473b.TRUNCATED_TAG, "StreamUseCaseUtil: SessionConfig has stream use case but also contains " + next.p().size() + " surfaces, abort populateSurfaceToStreamUseCaseMapping().");
                    return;
                }
                return;
            }
            if (next.g().b(aVar)) {
                int i10 = 0;
                for (SessionConfig sessionConfig : sessionConfigs) {
                    if (((z) arrayList.get(i10)).V() == UseCaseConfigFactory.CaptureType.METERING_REPEATING) {
                        p.h(sessionConfig.p(), "getSurfaces(...)");
                        B0.h.i(!r3.isEmpty(), "MeteringRepeating should contain a surface");
                        streamUseCaseMap.put(sessionConfig.p().get(0), 1L);
                    } else {
                        Config configG2 = sessionConfig.g();
                        Config.a<Long> aVar2 = STREAM_USE_CASE_STREAM_SPEC_OPTION;
                        if (configG2.b(aVar2)) {
                            List<DeferrableSurface> listP = sessionConfig.p();
                            p.h(listP, "getSurfaces(...)");
                            if (!listP.isEmpty()) {
                                DeferrableSurface deferrableSurface = sessionConfig.p().get(0);
                                Object objA = sessionConfig.g().a(aVar2);
                                p.f(objA);
                                streamUseCaseMap.put(deferrableSurface, objA);
                            }
                        }
                    }
                    i10++;
                }
            }
        }
        C5473b c5473b2 = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "populateSurfaceToStreamUseCaseMapping() - streamUseCaseMap = " + streamUseCaseMap);
        }
    }

    public final boolean o(SupportedSurfaceCombination.FeatureSettings featureSettings) {
        p.i(featureSettings, "featureSettings");
        return featureSettings.getCameraMode() == 0 && featureSettings.getRequiredMaxBitDepth() == 8 && !featureSettings.getIsHighSpeedOn();
    }

    public final void p() {
        throw new IllegalArgumentException("Either all use cases must have non-default stream use case assigned or none should have it");
    }
}
