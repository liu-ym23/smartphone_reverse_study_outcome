package z;

import La.H;
import Z8.C1173v;
import Z8.F;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.s;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5074l;
import w.C5693E;
import w.C5708n;
import w.ConcurrentCameraGraphs;
import w.G;
import w.M;
import w.P;
import w.Q;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\t\u001a\u00020\b2\u0012\u0010\u0005\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J7\u0010\u0018\u001a\u00020\u00172\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010\u0016\u001a\u00020\b2\u0012\u0010\u0005\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J5\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u001b0\u001a2\u0012\u0010\u0005\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\"\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\"\u0010 R\u001a\u0010(\u001a\u00020#8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lz/h;", "", "<init>", "()V", "", "parameters", "", "limit", "", "e", "(Ljava/util/Map;I)Ljava/lang/String;", "Landroidx/camera/camera2/pipe/g;", "metadata", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "graphConfig", "Landroidx/camera/camera2/pipe/CameraGraph;", "cameraGraph", Const.INTENT_KEY_UMID, "(Landroidx/camera/camera2/pipe/g;Landroidx/camera/camera2/pipe/CameraGraph$b;Landroidx/camera/camera2/pipe/CameraGraph;)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "name", "LY8/t;", "c", "(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/util/Map;)V", "", "Lkotlin/Pair;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/Map;)Ljava/util/List;", "key", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/Object;)Ljava/lang/String;", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Lz/t;", Const.INTENT_KEY_PKGNAME, "Lz/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lz/t;", "systemTimeSource", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f44503a = new h();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final t systemTimeSource = new t();

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return b9.b.d((String) ((Pair) t10).e(), (String) ((Pair) t11).e());
        }
    }

    public static final CharSequence f(Pair it) {
        kotlin.jvm.internal.p.i(it, "it");
        return ((String) it.e()) + '=' + ((String) it.f());
    }

    public static final CharSequence k(Object obj) {
        return f44503a.j(obj);
    }

    public final void c(StringBuilder builder, String name, Map<?, ? extends Object> parameters) {
        if (parameters.isEmpty()) {
            builder.append(name + ": (None)\n");
            return;
        }
        builder.append(name + '\n');
        Iterator<T> it = f44503a.i(parameters).iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            builder.append("  " + H.H0((String) pair.e(), 50, ' ') + ' ' + ((String) pair.f()) + '\n');
        }
    }

    public final String d(androidx.camera.camera2.pipe.g metadata, CameraGraph.b graphConfig, CameraGraph cameraGraph) {
        kotlin.jvm.internal.p.i(metadata, "metadata");
        kotlin.jvm.internal.p.i(graphConfig, "graphConfig");
        kotlin.jvm.internal.p.i(cameraGraph, "cameraGraph");
        ConcurrentCameraGraphs concurrentCameraGraphs = graphConfig.getConcurrentCameraGraphs();
        Set<C5708n> setB = concurrentCameraGraphs != null ? concurrentCameraGraphs.b() : null;
        CameraCharacteristics.Key LENS_FACING = CameraCharacteristics.LENS_FACING;
        kotlin.jvm.internal.p.h(LENS_FACING, "LENS_FACING");
        Integer num = (Integer) metadata.e0(LENS_FACING);
        String str = "External";
        String str2 = "Unknown";
        String str3 = (num != null && num.intValue() == 0) ? "Front" : (num != null && num.intValue() == 1) ? "Back" : (num != null && num.intValue() == 2) ? "External" : "Unknown";
        CameraCharacteristics.Key INFO_SUPPORTED_HARDWARE_LEVEL = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
        kotlin.jvm.internal.p.h(INFO_SUPPORTED_HARDWARE_LEVEL, "INFO_SUPPORTED_HARDWARE_LEVEL");
        Integer num2 = (Integer) metadata.e0(INFO_SUPPORTED_HARDWARE_LEVEL);
        if (num2 != null && num2.intValue() == 0) {
            str = "Limited";
        } else if (num2 != null && num2.intValue() == 1) {
            str = "Full";
        } else if (num2 != null && num2.intValue() == 2) {
            str = "Legacy";
        } else if (num2 != null && num2.intValue() == 3) {
            str = "Level 3";
        } else if (num2 == null || num2.intValue() != 4) {
            str = "Unknown";
        }
        int sessionMode = graphConfig.getSessionMode();
        CameraGraph.e.Companion companion = CameraGraph.e.INSTANCE;
        if (CameraGraph.e.f(sessionMode, companion.c())) {
            str2 = "High Speed";
        } else if (CameraGraph.e.f(sessionMode, companion.d())) {
            str2 = "Normal";
        } else if (CameraGraph.e.f(sessionMode, companion.b())) {
            str2 = "Extension";
        }
        CameraCharacteristics.Key REQUEST_AVAILABLE_CAPABILITIES = CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES;
        kotlin.jvm.internal.p.h(REQUEST_AVAILABLE_CAPABILITIES, "REQUEST_AVAILABLE_CAPABILITIES");
        int[] iArr = (int[]) metadata.e0(REQUEST_AVAILABLE_CAPABILITIES);
        String str4 = (iArr == null || !Z8.r.P(iArr, 11)) ? "Physical" : "Logical";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cameraGraph + " (Camera " + graphConfig.getCamera() + ")\n");
        if (setB != null) {
            sb2.append("  Concurrent: " + setB + '\n');
        }
        sb2.append("  Facing:    " + str3 + " (" + str4 + ", " + str + ")\n");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("  Mode:      ");
        sb3.append(str2);
        sb3.append('\n');
        sb2.append(sb3.toString());
        sb2.append("Outputs:\n");
        Iterator<androidx.camera.camera2.pipe.k> it = cameraGraph.d().d().iterator();
        while (it.hasNext()) {
            int i10 = 0;
            for (Object obj : it.next().b()) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    C1173v.w();
                }
                androidx.camera.camera2.pipe.s sVar = (androidx.camera.camera2.pipe.s) obj;
                sb2.append("  ");
                sb2.append(H.H0(i10 == 0 ? Q.f(sVar.k().getId()) : "", 12, ' '));
                sb2.append(H.H0(G.f(sVar.getId()), 12, ' '));
                String string = sVar.getSize().toString();
                kotlin.jvm.internal.p.h(string, "toString(...)");
                sb2.append(H.H0(string, 12, ' '));
                sb2.append(H.H0(P.g(sVar.getFormat()), 16, ' '));
                s.c cVarI = sVar.getMirrorMode();
                if (cVarI != null) {
                    sb2.append(" [" + ((Object) s.c.e(cVarI.getValue())) + ']');
                }
                sVar.d();
                s.b bVarJ = sVar.getDynamicRangeProfile();
                if (bVarJ != null) {
                    sb2.append(" [" + ((Object) s.b.f(bVarJ.getValue())) + ']');
                }
                s.f fVarH = sVar.getStreamUseCase();
                if (fVarH != null) {
                    sb2.append(" [" + ((Object) s.f.i(fVarH.getValue())) + ']');
                }
                s.g gVarA = sVar.getStreamUseHint();
                if (gVarA != null) {
                    sb2.append(" [" + ((Object) s.g.h(gVarA.getValue())) + ']');
                }
                if (!C5708n.d(sVar.getCamera(), graphConfig.getCamera())) {
                    sb2.append(" [");
                    sb2.append(C5708n.a(sVar.getCamera()));
                    sb2.append("]");
                }
                sb2.append("\n");
                i10 = i11;
            }
        }
        if (!cameraGraph.d().l().isEmpty()) {
            sb2.append("Inputs:\n");
            for (androidx.camera.camera2.pipe.p pVar : cameraGraph.d().l()) {
                sb2.append(" ");
                sb2.append(H.H0(C5693E.b(pVar.getId()), 12, ' '));
                sb2.append(H.H0(P.i(pVar.getFormat()), 12, ' '));
                sb2.append(H.H0(String.valueOf(pVar.getMaxImages()), 12, ' '));
                sb2.append("\n");
            }
        }
        sb2.append("Session Template: " + M.e(graphConfig.getSessionTemplate()) + '\n');
        h hVar = f44503a;
        hVar.c(sb2, "Session Parameters", graphConfig.p());
        sb2.append("Default Template: " + M.e(graphConfig.getDefaultTemplate()) + '\n');
        hVar.c(sb2, "Default Parameters", graphConfig.f());
        hVar.c(sb2, "Required Parameters", graphConfig.m());
        String string2 = sb2.toString();
        kotlin.jvm.internal.p.h(string2, "toString(...)");
        return string2;
    }

    public final String e(Map<?, ? extends Object> parameters, int limit) {
        kotlin.jvm.internal.p.i(parameters, "parameters");
        return F.A0(i(parameters), null, Const.STR_MART_JSON_BEGIN, "}", limit, null, new InterfaceC5074l() { // from class: z.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return h.f((Pair) obj);
            }
        }, 17, null);
    }

    public final t g() {
        return systemTimeSource;
    }

    public final String h(Object key) {
        if (key instanceof CameraCharacteristics.Key) {
            String name = ((CameraCharacteristics.Key) key).getName();
            kotlin.jvm.internal.p.h(name, "getName(...)");
            return name;
        }
        if (key instanceof CaptureRequest.Key) {
            String name2 = ((CaptureRequest.Key) key).getName();
            kotlin.jvm.internal.p.h(name2, "getName(...)");
            return name2;
        }
        if (!(key instanceof CaptureResult.Key)) {
            return String.valueOf(key);
        }
        String name3 = ((CaptureResult.Key) key).getName();
        kotlin.jvm.internal.p.h(name3, "getName(...)");
        return name3;
    }

    public final List<Pair<String, String>> i(Map<?, ? extends Object> parameters) {
        ArrayList arrayList = new ArrayList(parameters.size());
        for (Map.Entry<?, ? extends Object> entry : parameters.entrySet()) {
            h hVar = f44503a;
            arrayList.add(Y8.j.a(hVar.h(entry.getKey()), hVar.j(entry.getValue())));
        }
        return F.c1(arrayList, new a());
    }

    public final String j(Object value) {
        return value instanceof Object[] ? Z8.r.w0((Object[]) value, null, "[", "]", 0, null, new InterfaceC5074l() { // from class: z.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return h.k(obj);
            }
        }, 25, null) : String.valueOf(value);
    }
}
