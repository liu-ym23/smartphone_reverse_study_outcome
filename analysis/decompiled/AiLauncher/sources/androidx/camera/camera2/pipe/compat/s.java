package androidx.camera.camera2.pipe.compat;

import A.StreamGraph;
import Z8.F;
import android.hardware.camera2.params.OutputConfiguration;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.compat.h;
import androidx.camera.camera2.pipe.s;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import w.C5708n;
import w.G;
import w.Q;
import x.OutputConfigurations;
import x.w0;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0001¢\u0006\u0004\b\t\u0010\n\u001a7\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/camera/camera2/pipe/CameraGraph$b;", "graphConfig", "LA/q;", "streamGraph", "", "Lw/Q;", "Landroid/view/Surface;", "surfaces", "Lx/x0;", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/camera2/pipe/CameraGraph$b;LA/q;Ljava/util/Map;)Lx/x0;", "Lw/G;", "c", "(Ljava/util/Map;LA/q;)Ljava/util/Map;", "camera-camera2-pipe"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class s {
    public static final OutputConfigurations b(CameraGraph.b graphConfig, StreamGraph streamGraph, Map<Q, ? extends Surface> surfaces) {
        kotlin.jvm.internal.p.i(graphConfig, "graphConfig");
        kotlin.jvm.internal.p.i(streamGraph, "streamGraph");
        kotlin.jvm.internal.p.i(surfaces, "surfaces");
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry<Q, C.l> entry : streamGraph.k0().entrySet()) {
            int value = entry.getKey().getValue();
            C.l value2 = entry.getValue();
            androidx.camera.camera2.pipe.k kVarB = streamGraph.b(value);
            if (kVarB == null) {
                throw new IllegalStateException("Required value was null.");
            }
            List<androidx.camera.camera2.pipe.s> listB = kVarB.b();
            if (listB.size() != 1) {
                Object objR0 = value2.R0(kotlin.jvm.internal.t.b(C.d.class));
                if (objR0 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                List<OutputConfiguration> listU1 = ((C.d) objR0).u1();
                if (listU1.size() != listB.size()) {
                    throw new IllegalStateException("Check failed.");
                }
                int size = listB.size();
                for (int i10 = 0; i10 < size; i10++) {
                    androidx.camera.camera2.pipe.s sVar = listB.get(i10);
                    OutputConfiguration outputConfiguration = listU1.get(i10);
                    StreamGraph.c cVar = streamGraph.v0().get(sVar);
                    if (cVar == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    StreamGraph.c cVar2 = cVar;
                    if (cVar2.getExternalOutputConfig() != null) {
                        throw new IllegalStateException("External OutputConfiguration shouldn't be set in multi-output streams configured with ImageSource.Config");
                    }
                    linkedHashMap3.put(cVar2, outputConfiguration);
                }
            }
        }
        for (androidx.camera.camera2.pipe.k kVar : streamGraph.d()) {
            List<androidx.camera.camera2.pipe.s> listB2 = kVar.b();
            if (listB2.size() == 1) {
                Surface surface = surfaces.get(Q.a(kVar.getId()));
                if (surface != null) {
                    linkedHashMap2.put(G.a(((androidx.camera.camera2.pipe.s) F.X0(listB2)).getId()), surface);
                }
            } else {
                for (androidx.camera.camera2.pipe.s sVar2 : listB2) {
                    StreamGraph.c cVar3 = streamGraph.v0().get(sVar2);
                    if (cVar3 == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    StreamGraph.c cVar4 = cVar3;
                    OutputConfiguration externalOutputConfig = cVar4.getExternalOutputConfig();
                    if (externalOutputConfig == null) {
                        externalOutputConfig = (OutputConfiguration) linkedHashMap3.get(cVar4);
                    }
                    Surface surface2 = externalOutputConfig != null ? externalOutputConfig.getSurface() : surfaces.get(Q.a(kVar.getId()));
                    if (surface2 != null) {
                        linkedHashMap2.put(G.a(sVar2.getId()), surface2);
                    }
                }
            }
        }
        w0 w0Var = null;
        for (StreamGraph.c cVar5 : streamGraph.D0()) {
            List<androidx.camera.camera2.pipe.k> listN = cVar5.n();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = listN.iterator();
            while (it.hasNext()) {
                Surface surface3 = surfaces.get(Q.a(((androidx.camera.camera2.pipe.k) it.next()).getId()));
                if (surface3 != null) {
                    arrayList2.add(surface3);
                }
            }
            OutputConfiguration externalOutputConfig2 = cVar5.getExternalOutputConfig();
            if (externalOutputConfig2 == null) {
                externalOutputConfig2 = (OutputConfiguration) linkedHashMap3.get(cVar5);
            }
            OutputConfiguration outputConfiguration2 = externalOutputConfig2;
            if (outputConfiguration2 != null) {
                if (arrayList2.size() != cVar5.n().size()) {
                    List<androidx.camera.camera2.pipe.k> listN2 = cVar5.n();
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj : listN2) {
                        if (!surfaces.containsKey(Q.a(((androidx.camera.camera2.pipe.k) obj).getId()))) {
                            arrayList3.add(obj);
                        }
                    }
                    throw new IllegalStateException(("Surfaces are not yet available for " + cVar5 + "! Missing surfaces for " + arrayList3 + '!').toString());
                }
                arrayList.add(new h(outputConfiguration2, false, 1, null, null));
            } else if (cVar5.b() && arrayList2.size() != cVar5.n().size()) {
                h.Companion companion = h.INSTANCE;
                Size size2 = cVar5.getSize();
                s.d deferredOutputType = cVar5.getDeferredOutputType();
                kotlin.jvm.internal.p.f(deferredOutputType);
                s.c mirrorMode = cVar5.getMirrorMode();
                cVar5.p();
                s.b dynamicRangeProfile = cVar5.getDynamicRangeProfile();
                s.f streamUseCase = cVar5.getStreamUseCase();
                List<s.e> listI = cVar5.i();
                boolean zO = cVar5.o();
                Integer groupNumber = cVar5.getGroupNumber();
                w0 w0VarB = h.Companion.b(companion, null, null, deferredOutputType, mirrorMode, null, dynamicRangeProfile, streamUseCase, listI, size2, zO, groupNumber != null ? groupNumber.intValue() : -1, !C5708n.d(cVar5.getCamera(), graphConfig.getCamera()) ? cVar5.getCamera() : null, 2, null);
                if (w0VarB != null) {
                    arrayList.add(w0VarB);
                    Iterator<androidx.camera.camera2.pipe.k> it2 = cVar5.k().iterator();
                    while (it2.hasNext()) {
                        linkedHashMap.put(Q.a(it2.next().getId()), w0VarB);
                    }
                } else if (z.k.f44508a.d()) {
                    Log.w("CXCP", "Failed to create AndroidOutputConfiguration for " + cVar5);
                }
            } else {
                if (arrayList2.size() != cVar5.n().size()) {
                    List<androidx.camera.camera2.pipe.k> listN3 = cVar5.n();
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj2 : listN3) {
                        if (!surfaces.containsKey(Q.a(((androidx.camera.camera2.pipe.k) obj2).getId()))) {
                            arrayList4.add(obj2);
                        }
                    }
                    throw new IllegalStateException(("Surfaces are not yet available for " + cVar5 + "! Missing surfaces for " + arrayList4 + '!').toString());
                }
                h.Companion companion2 = h.INSTANCE;
                Surface surface4 = (Surface) F.q0(arrayList2);
                s.c mirrorMode2 = cVar5.getMirrorMode();
                cVar5.p();
                s.b dynamicRangeProfile2 = cVar5.getDynamicRangeProfile();
                s.f streamUseCase2 = cVar5.getStreamUseCase();
                List<s.e> listI2 = cVar5.i();
                Size size3 = cVar5.getSize();
                boolean zO2 = cVar5.o();
                Integer groupNumber2 = cVar5.getGroupNumber();
                w0 w0VarB2 = h.Companion.b(companion2, surface4, null, null, mirrorMode2, null, dynamicRangeProfile2, streamUseCase2, listI2, size3, zO2, groupNumber2 != null ? groupNumber2.intValue() : -1, !C5708n.d(cVar5.getCamera(), graphConfig.getCamera()) ? cVar5.getCamera() : null, 6, null);
                if (w0VarB2 != null) {
                    Iterator it3 = F.h0(arrayList2, 1).iterator();
                    while (it3.hasNext()) {
                        w0VarB2.n((Surface) it3.next());
                    }
                    if (graphConfig.getPostviewStream() != null) {
                        androidx.camera.camera2.pipe.k kVarI = streamGraph.i(graphConfig.getPostviewStream());
                        if (kVarI == null) {
                            throw new IllegalStateException("Postview Stream in StreamGraph cannot be null for reprocessing request");
                        }
                        if (w0Var == null && cVar5.n().contains(kVarI)) {
                            w0Var = w0VarB2;
                        } else {
                            arrayList.add(w0VarB2);
                        }
                    } else {
                        arrayList.add(w0VarB2);
                    }
                } else if (z.k.f44508a.d()) {
                    Log.w("CXCP", "Failed to create AndroidOutputConfiguration for " + cVar5);
                }
            }
        }
        return new OutputConfigurations(arrayList, linkedHashMap, w0Var, linkedHashMap2);
    }

    public static final Map<G, Surface> c(Map<Q, ? extends Surface> map, StreamGraph streamGraph) {
        Map mapC = Z8.Q.c();
        for (androidx.camera.camera2.pipe.k kVar : streamGraph.d()) {
            Surface surface = map.get(Q.a(kVar.getId()));
            if (surface != null) {
                Iterator<androidx.camera.camera2.pipe.s> it = kVar.b().iterator();
                while (it.hasNext()) {
                    mapC.put(G.a(it.next().getId()), surface);
                }
            }
        }
        return Z8.Q.b(mapC);
    }
}
