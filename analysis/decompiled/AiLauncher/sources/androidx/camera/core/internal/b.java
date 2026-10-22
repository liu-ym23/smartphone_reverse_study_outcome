package androidx.camera.core.internal;

import D.B;
import K.InterfaceC0896t;
import K.InterfaceC0898v;
import K.SurfaceStreamSpecQueryResult;
import M.o;
import M.q;
import P.StreamSpecQueryResult;
import P.i;
import P.k;
import Y.f;
import android.graphics.Rect;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.g;
import androidx.camera.core.impl.stabilization.VideoStabilization;
import androidx.camera.core.impl.y;
import androidx.camera.core.impl.z;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001\tB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJi\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJQ\u0010\"\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020 0\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00100\u001f0\u001e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b\"\u0010#Je\u0010'\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00100\u001f2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020%0\u001f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010+¨\u0006,"}, d2 = {"Landroidx/camera/core/internal/b;", "LP/i;", "Landroidx/camera/core/impl/UseCaseConfigFactory;", "useCaseConfigFactory", "LK/t;", "cameraDeviceSurfaceManager", "<init>", "(Landroidx/camera/core/impl/UseCaseConfigFactory;LK/t;)V", "LY8/t;", Const.INTENT_KEY_APIKEY, "(LK/t;)V", "", "cameraMode", "LK/v;", "cameraInfoInternal", "", "Landroidx/camera/core/UseCase;", "newUseCases", "attachedUseCases", "Landroidx/camera/core/impl/g;", "cameraConfig", "sessionType", "Landroid/util/Range;", "targetFrameRate", "", "isFeatureComboInvocation", "findMaxSupportedFrameRate", "LP/h;", Const.INTENT_KEY_PKGNAME, "(ILK/v;Ljava/util/List;Ljava/util/List;Landroidx/camera/core/impl/g;ILandroid/util/Range;ZZ)LP/h;", "Landroid/util/Pair;", "", "Landroidx/camera/core/impl/y;", "Landroidx/camera/core/impl/b;", Const.INTENT_KEY_UMID, "(ILK/v;Ljava/util/List;)Landroid/util/Pair;", "attachedSurfaceInfoToUseCaseMap", "Landroidx/camera/core/internal/CameraUseCaseAdapter$a;", "configPairMap", "e", "(ILK/v;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;ZZ)LP/h;", "c", "Landroidx/camera/core/impl/UseCaseConfigFactory;", "LK/t;", "camera-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class b implements i {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final UseCaseConfigFactory useCaseConfigFactory;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public InterfaceC0896t cameraDeviceSurfaceManager;

    public b(UseCaseConfigFactory useCaseConfigFactory, InterfaceC0896t interfaceC0896t) {
        p.i(useCaseConfigFactory, "useCaseConfigFactory");
        this.useCaseConfigFactory = useCaseConfigFactory;
        this.cameraDeviceSurfaceManager = interfaceC0896t;
    }

    public static final z f(Map map, InterfaceC0898v interfaceC0898v, UseCase it) {
        p.i(it, "it");
        Object obj = map.get(it);
        if (obj == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        CameraUseCaseAdapter.a aVar = (CameraUseCaseAdapter.a) obj;
        z<?> zVarI = it.I(interfaceC0898v, aVar.f11578a, aVar.f11579b);
        p.h(zVarI, "mergeConfigs(...)");
        return zVarI;
    }

    @Override // P.i
    public void a(InterfaceC0896t cameraDeviceSurfaceManager) {
        p.i(cameraDeviceSurfaceManager, "cameraDeviceSurfaceManager");
        this.cameraDeviceSurfaceManager = cameraDeviceSurfaceManager;
    }

    @Override // P.i
    public StreamSpecQueryResult b(int cameraMode, InterfaceC0898v cameraInfoInternal, List<? extends UseCase> newUseCases, List<? extends UseCase> attachedUseCases, g cameraConfig, int sessionType, Range<Integer> targetFrameRate, boolean isFeatureComboInvocation, boolean findMaxSupportedFrameRate) {
        p.i(cameraInfoInternal, "cameraInfoInternal");
        p.i(newUseCases, "newUseCases");
        p.i(attachedUseCases, "attachedUseCases");
        p.i(cameraConfig, "cameraConfig");
        p.i(targetFrameRate, "targetFrameRate");
        Pair<Map<UseCase, y>, Map<androidx.camera.core.impl.b, UseCase>> pairD = d(cameraMode, cameraInfoInternal, attachedUseCases);
        Object second = pairD.second;
        p.h(second, "second");
        Map<UseCase, CameraUseCaseAdapter.a> mapJ = CameraUseCaseAdapter.J(newUseCases, cameraConfig.k(), this.useCaseConfigFactory, sessionType, targetFrameRate);
        p.h(mapJ, "getConfigs(...)");
        StreamSpecQueryResult streamSpecQueryResultE = e(cameraMode, cameraInfoInternal, newUseCases, (Map) second, mapJ, isFeatureComboInvocation, findMaxSupportedFrameRate);
        Object first = pairD.first;
        p.h(first, "first");
        return new StreamSpecQueryResult(kotlin.collections.a.r((Map) first, streamSpecQueryResultE.b()), streamSpecQueryResultE.getMaxSupportedFrameRate());
    }

    public final Pair<Map<UseCase, y>, Map<androidx.camera.core.impl.b, UseCase>> d(int cameraMode, InterfaceC0898v cameraInfoInternal, List<? extends UseCase> attachedUseCases) {
        ArrayList arrayList = new ArrayList();
        String strH = cameraInfoInternal.h();
        p.h(strH, "getCameraId(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (UseCase useCase : attachedUseCases) {
            y yVarG = useCase.g();
            if (yVarG == null) {
                throw new IllegalArgumentException("Attached stream spec cannot be null for already attached use cases.");
            }
            InterfaceC0896t interfaceC0896t = this.cameraDeviceSurfaceManager;
            if (interfaceC0896t == null) {
                throw new IllegalStateException("Required value was null.");
            }
            int iP = useCase.p();
            Size sizeH = useCase.h();
            if (sizeH == null) {
                throw new IllegalArgumentException("Attached surface resolution cannot be null for already attached use cases.");
            }
            SurfaceConfig surfaceConfigA = interfaceC0896t.a(cameraMode, strH, iP, sizeH, useCase.l().U());
            p.h(surfaceConfigA, "transformSurfaceConfig(...)");
            int iP2 = useCase.p();
            Size sizeH2 = useCase.h();
            p.f(sizeH2);
            B b10 = yVarG.b();
            List<UseCaseConfigFactory.CaptureType> listR0 = f.r0(useCase);
            Config configD = yVarG.d();
            int iN = useCase.l().n(0);
            Range<Integer> rangeA = useCase.l().A(y.f11539a);
            if (rangeA == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            boolean zG = useCase.l().G();
            z<?> zVarL = useCase.l();
            Size sizeH3 = useCase.h();
            p.f(sizeH3);
            androidx.camera.core.impl.b bVarA = androidx.camera.core.impl.b.a(surfaceConfigA, iP2, sizeH2, b10, listR0, configD, iN, rangeA, zG, zVarL.W(sizeH3));
            p.h(bVarA, "create(...)");
            arrayList.add(bVarA);
            linkedHashMap2.put(bVarA, useCase);
            linkedHashMap.put(useCase, yVarG);
        }
        return new Pair<>(linkedHashMap, linkedHashMap2);
    }

    public final StreamSpecQueryResult e(int cameraMode, final InterfaceC0898v cameraInfoInternal, List<? extends UseCase> newUseCases, Map<androidx.camera.core.impl.b, ? extends UseCase> attachedSurfaceInfoToUseCaseMap, final Map<UseCase, ? extends CameraUseCaseAdapter.a> configPairMap, boolean isFeatureComboInvocation, boolean findMaxSupportedFrameRate) {
        int maxSupportedFrameRate;
        Rect rectJ;
        String strH = cameraInfoInternal.h();
        p.h(strH, "getCameraId(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (newUseCases.isEmpty()) {
            maxSupportedFrameRate = Integer.MAX_VALUE;
        } else {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            try {
                rectJ = cameraInfoInternal.j();
            } catch (NullPointerException unused) {
                rectJ = null;
            }
            k kVar = new k(cameraInfoInternal, rectJ != null ? o.l(rectJ) : null);
            for (UseCase useCase : newUseCases) {
                CameraUseCaseAdapter.a aVar = configPairMap.get(useCase);
                if (aVar == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                CameraUseCaseAdapter.a aVar2 = aVar;
                z<?> zVarI = useCase.I(cameraInfoInternal, aVar2.f11578a, aVar2.f11579b);
                p.h(zVarI, "mergeConfigs(...)");
                linkedHashMap2.put(zVarI, useCase);
                linkedHashMap3.put(zVarI, kVar.m(zVarI));
            }
            List<? extends UseCase> list = newUseCases;
            VideoStabilization videoStabilizationD = q.d(list, new InterfaceC5074l() { // from class: P.j
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return androidx.camera.core.internal.b.f(configPairMap, cameraInfoInternal, (UseCase) obj);
                }
            });
            InterfaceC0896t interfaceC0896t = this.cameraDeviceSurfaceManager;
            if (interfaceC0896t == null) {
                throw new IllegalStateException("Required value was null.");
            }
            SurfaceStreamSpecQueryResult surfaceStreamSpecQueryResultB = interfaceC0896t.b(cameraMode, strH, new ArrayList(attachedSurfaceInfoToUseCaseMap.keySet()), linkedHashMap3, videoStabilizationD, q.b(list), isFeatureComboInvocation, findMaxSupportedFrameRate);
            p.h(surfaceStreamSpecQueryResultB, "getSuggestedStreamSpecs(...)");
            Map<z<?>, y> mapA = surfaceStreamSpecQueryResultB.a();
            Map<androidx.camera.core.impl.b, y> mapB = surfaceStreamSpecQueryResultB.b();
            maxSupportedFrameRate = surfaceStreamSpecQueryResultB.getMaxSupportedFrameRate();
            for (Map.Entry entry : linkedHashMap2.entrySet()) {
                Object value = entry.getValue();
                y yVar = mapA.get(entry.getKey());
                if (yVar == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                linkedHashMap.put(value, yVar);
            }
            for (Map.Entry<androidx.camera.core.impl.b, y> entry2 : mapB.entrySet()) {
                if (attachedSurfaceInfoToUseCaseMap.containsKey(entry2.getKey())) {
                    UseCase useCase2 = attachedSurfaceInfoToUseCaseMap.get(entry2.getKey());
                    if (useCase2 == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    linkedHashMap.put(useCase2, entry2.getValue());
                }
            }
        }
        return new StreamSpecQueryResult(linkedHashMap, maxSupportedFrameRate);
    }
}
