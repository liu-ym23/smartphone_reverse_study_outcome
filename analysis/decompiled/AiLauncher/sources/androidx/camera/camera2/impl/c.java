package androidx.camera.camera2.impl;

import D.B;
import D.C0761b0;
import Z8.r;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.util.Log;
import android.util.Size;
import androidx.camera.camera2.compat.quirk.CaptureSessionStuckQuirk;
import androidx.camera.camera2.compat.quirk.DisableAbortCapturesOnStopQuirk;
import androidx.camera.camera2.compat.quirk.DisableAbortCapturesOnStopWithSessionProcessorQuirk;
import androidx.camera.camera2.compat.quirk.FinalizeSessionOnCloseQuirk;
import androidx.camera.camera2.compat.quirk.QuickSuccessiveImageCaptureFailsRepeatingRequestQuirk;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.k;
import androidx.camera.camera2.pipe.s;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.l;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import o.C4961A;
import o.Q;
import p.C5027i;
import r.C5189g;
import r.E;
import s.m;
import t.C5473b;
import t.C5491s;
import t.N;
import u.C5555c;
import w.C5708n;
import w.P;

@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001&B[\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015Jk\u0010&\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 2\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 ¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J#\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010,\u001a\u00020+2\b\u0010-\u001a\u0004\u0018\u00010(H\u0002¢\u0006\u0004\b/\u00100J7\u00104\u001a\u0004\u0018\u0001032\u0006\u00101\u001a\u00020!2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b4\u00105J-\u00107\u001a\u0004\u0018\u0001062\u0006\u00101\u001a\u00020!2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 H\u0002¢\u0006\u0004\b7\u00108J\u001f\u0010;\u001a\u00020:2\u0006\u0010\t\u001a\u00020\b2\u0006\u00109\u001a\u00020\u001aH\u0002¢\u0006\u0004\b;\u0010<J\u0015\u0010?\u001a\u0004\u0018\u00010>*\u00020=H\u0002¢\u0006\u0004\b?\u0010@J\u0013\u0010B\u001a\u00020A*\u00020\u0018H\u0002¢\u0006\u0004\bB\u0010CJ\u0019\u0010F\u001a\u0004\u0018\u00010\u001e2\u0006\u0010E\u001a\u00020DH\u0002¢\u0006\u0004\bF\u0010GR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010HR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010KR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010LR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010MR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010NR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010OR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010PR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010QR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u0004\u0018\u00010V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010X¨\u0006Z"}, d2 = {"Landroidx/camera/camera2/impl/c;", "", "Landroidx/camera/camera2/impl/b;", "callbackMap", "Lt/N;", "requestListener", "Ls/m;", "cameraConfig", "Landroidx/camera/camera2/compat/quirk/a;", "cameraQuirks", "Lo/Q;", "zslControl", "Lr/E;", "templateParamsOverride", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "Landroidx/camera/core/f;", "cameraXConfig", "Lt/s;", "cameraInteropStateCallbackRepository", "<init>", "(Landroidx/camera/camera2/impl/b;Lt/N;Ls/m;Landroidx/camera/camera2/compat/quirk/a;Lo/Q;Lr/E;Landroidx/camera/camera2/pipe/g;Landroidx/camera/core/f;Lt/s;)V", "Landroidx/camera/camera2/pipe/CameraGraph$e;", "operatingMode", "Landroidx/camera/core/impl/SessionConfig;", "sessionConfig", "", "setOutputType", "Lo/A;", "graphStateToCameraStateAdapter", "", "camera2ExtensionMode", "", "Landroidx/camera/core/impl/DeferrableSurface;", "", "surfaceToStreamUseCaseMap", "surfaceToStreamUseHintMap", "Landroidx/camera/camera2/impl/c$a;", Const.INTENT_KEY_APIKEY, "(ILandroidx/camera/core/impl/SessionConfig;ZLo/A;Ljava/lang/Integer;Ljava/util/Map;Ljava/util/Map;)Landroidx/camera/camera2/impl/c$a;", "", "toString", "()Ljava/lang/String;", "Landroidx/camera/core/impl/SessionConfig$f;", "postviewConfig", "physicalCameraIdForAllStreams", "Landroidx/camera/camera2/pipe/k$a;", Const.INTENT_KEY_UMID, "(Landroidx/camera/core/impl/SessionConfig$f;Ljava/lang/String;)Landroidx/camera/camera2/pipe/k$a;", "deferrableSurface", "mapping", "Landroidx/camera/camera2/pipe/s$f;", "e", "(Landroidx/camera/core/impl/DeferrableSurface;Ljava/util/Map;Landroidx/camera/camera2/pipe/g;)Landroidx/camera/camera2/pipe/s$f;", "Landroidx/camera/camera2/pipe/s$g;", "f", "(Landroidx/camera/core/impl/DeferrableSurface;Ljava/util/Map;)Landroidx/camera/camera2/pipe/s$g;", "isExtensions", "Landroidx/camera/camera2/pipe/CameraGraph$d;", "c", "(Landroidx/camera/camera2/compat/quirk/a;Z)Landroidx/camera/camera2/pipe/CameraGraph$d;", "LD/B;", "Landroidx/camera/camera2/pipe/s$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(LD/B;)Landroidx/camera/camera2/pipe/s$b;", "Landroidx/camera/camera2/impl/a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroidx/camera/core/impl/SessionConfig;)Landroidx/camera/camera2/impl/a;", "Landroidx/camera/core/impl/l;", "captureConfig", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroidx/camera/core/impl/l;)Ljava/lang/Integer;", "Landroidx/camera/camera2/impl/b;", Const.INTENT_KEY_PKGNAME, "Lt/N;", "Ls/m;", "Landroidx/camera/camera2/compat/quirk/a;", "Lo/Q;", "Lr/E;", "Landroidx/camera/camera2/pipe/g;", "Landroidx/camera/core/f;", "Lt/s;", "Lr/g;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Lr/g;", "closeCameraOnCameraGraphClose", "Landroid/hardware/camera2/params/DynamicRangeProfiles;", "k", "Landroid/hardware/camera2/params/DynamicRangeProfiles;", "supportedDynamicRangeProfiles", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final b callbackMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final N requestListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final m cameraConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.compat.quirk.a cameraQuirks;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Q zslControl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final E templateParamsOverride;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.g cameraMetadata;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.core.f cameraXConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final C5491s cameraInteropStateCallbackRepository;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final C5189g closeCameraOnCameraGraphClose;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final DynamicRangeProfiles supportedDynamicRangeProfiles;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R#\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroidx/camera/camera2/impl/c$a;", "", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "config", "", "Landroidx/camera/camera2/pipe/k$a;", "Landroidx/camera/core/impl/DeferrableSurface;", "streamConfigMap", "<init>", "(Landroidx/camera/camera2/pipe/CameraGraph$b;Ljava/util/Map;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/CameraGraph$b;", "()Landroidx/camera/camera2/pipe/CameraGraph$b;", Const.INTENT_KEY_PKGNAME, "Ljava/util/Map;", "()Ljava/util/Map;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.impl.c$a, reason: from toString */
    public static final /* data */ class CameraGraphCreationResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final CameraGraph.b config;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final Map<k.a, DeferrableSurface> streamConfigMap;

        /* JADX WARN: Multi-variable type inference failed */
        public CameraGraphCreationResult(CameraGraph.b config, Map<k.a, ? extends DeferrableSurface> streamConfigMap) {
            p.i(config, "config");
            p.i(streamConfigMap, "streamConfigMap");
            this.config = config;
            this.streamConfigMap = streamConfigMap;
        }

        /* renamed from: a, reason: from getter */
        public final CameraGraph.b getConfig() {
            return this.config;
        }

        public final Map<k.a, DeferrableSurface> b() {
            return this.streamConfigMap;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CameraGraphCreationResult)) {
                return false;
            }
            CameraGraphCreationResult cameraGraphCreationResult = (CameraGraphCreationResult) other;
            return p.d(this.config, cameraGraphCreationResult.config) && p.d(this.streamConfigMap, cameraGraphCreationResult.streamConfigMap);
        }

        public int hashCode() {
            return (this.config.hashCode() * 31) + this.streamConfigMap.hashCode();
        }

        public String toString() {
            return "CameraGraphCreationResult(config=" + this.config + ", streamConfigMap=" + this.streamConfigMap + ')';
        }
    }

    public c(b callbackMap, N requestListener, m cameraConfig, androidx.camera.camera2.compat.quirk.a cameraQuirks, Q zslControl, E templateParamsOverride, androidx.camera.camera2.pipe.g gVar, androidx.camera.core.f fVar, C5491s c5491s) {
        C5027i c5027iA;
        p.i(callbackMap, "callbackMap");
        p.i(requestListener, "requestListener");
        p.i(cameraConfig, "cameraConfig");
        p.i(cameraQuirks, "cameraQuirks");
        p.i(zslControl, "zslControl");
        p.i(templateParamsOverride, "templateParamsOverride");
        this.callbackMap = callbackMap;
        this.requestListener = requestListener;
        this.cameraConfig = cameraConfig;
        this.cameraQuirks = cameraQuirks;
        this.zslControl = zslControl;
        this.templateParamsOverride = templateParamsOverride;
        this.cameraMetadata = gVar;
        this.cameraXConfig = fVar;
        this.cameraInteropStateCallbackRepository = c5491s;
        this.closeCameraOnCameraGraphClose = new C5189g();
        this.supportedDynamicRangeProfiles = (gVar == null || (c5027iA = C5027i.INSTANCE.a(gVar)) == null) ? null : c5027iA.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CameraGraphCreationResult b(c cVar, int i10, SessionConfig sessionConfig, boolean z10, C4961A c4961a, Integer num, Map map, Map map2, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            c4961a = null;
        }
        if ((i11 & 16) != 0) {
            num = null;
        }
        if ((i11 & 32) != 0) {
            map = kotlin.collections.a.i();
        }
        if ((i11 & 64) != 0) {
            map2 = kotlin.collections.a.i();
        }
        return cVar.a(i10, sessionConfig, z10, c4961a, num, map, map2);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.camera.camera2.impl.c.CameraGraphCreationResult a(int r35, androidx.camera.core.impl.SessionConfig r36, boolean r37, o.C4961A r38, java.lang.Integer r39, java.util.Map<androidx.camera.core.impl.DeferrableSurface, java.lang.Long> r40, java.util.Map<androidx.camera.core.impl.DeferrableSurface, java.lang.Long> r41) {
        /*
            Method dump skipped, instructions count: 798
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.c.a(int, androidx.camera.core.impl.SessionConfig, boolean, o.A, java.lang.Integer, java.util.Map, java.util.Map):androidx.camera.camera2.impl.c$a");
    }

    public final CameraGraph.Flags c(androidx.camera.camera2.compat.quirk.a cameraQuirks, boolean isExtensions) {
        if (cameraQuirks.b().a(CaptureSessionStuckQuirk.class)) {
            C5473b c5473b = C5473b.f41865a;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "CameraPipe should be enabling CaptureSessionStuckQuirk by default");
            }
        }
        int iA = FinalizeSessionOnCloseQuirk.INSTANCE.a();
        boolean zA = this.closeCameraOnCameraGraphClose.a(isExtensions);
        boolean z10 = false;
        if ((!isExtensions || q.f.f38470a.c(DisableAbortCapturesOnStopWithSessionProcessorQuirk.class) == null) && q.f.f38470a.c(DisableAbortCapturesOnStopQuirk.class) == null) {
            z10 = true;
        }
        return new CameraGraph.Flags(false, z10, new CameraGraph.RepeatingRequestRequirementsBeforeCapture(cameraQuirks.b().a(QuickSuccessiveImageCaptureFailsRepeatingRequestQuirk.class) ? 1 : 0, CameraGraph.RepeatingRequestRequirementsBeforeCapture.CompletionBehavior.AT_LEAST, null), null, iA, true, zA, true, 9, null);
    }

    public final k.a d(SessionConfig.f postviewConfig, String physicalCameraIdForAllStreams) {
        s.c cVarA;
        s.c cVar;
        DeferrableSurface deferrableSurfaceF = postviewConfig.f();
        p.h(deferrableSurfaceF, "getSurface(...)");
        if (physicalCameraIdForAllStreams == null) {
            physicalCameraIdForAllStreams = postviewConfig.d();
        }
        int iC = postviewConfig.c();
        s.a.Companion companion = s.a.INSTANCE;
        Size sizeH = deferrableSurfaceF.h();
        p.h(sizeH, "getPrescribedSize(...)");
        int iD = P.d(deferrableSurfaceF.i());
        String strB = physicalCameraIdForAllStreams == null ? null : C5708n.b(physicalCameraIdForAllStreams);
        if (iC == 0) {
            cVarA = s.c.a(s.c.b(1));
        } else {
            if (iC != 1) {
                cVar = null;
                return k.a.Companion.b(k.a.INSTANCE, s.a.Companion.b(companion, sizeH, iD, strB, null, cVar, null, null, null, null, null, 1000, null), null, 2, null);
            }
            cVarA = s.c.a(s.c.b(2));
        }
        cVar = cVarA;
        return k.a.Companion.b(k.a.INSTANCE, s.a.Companion.b(companion, sizeH, iD, strB, null, cVar, null, null, null, null, null, 1000, null), null, 2, null);
    }

    public final s.f e(DeferrableSurface deferrableSurface, Map<DeferrableSurface, Long> mapping, androidx.camera.camera2.pipe.g cameraMetadata) {
        Long l10 = mapping.get(deferrableSurface);
        s.f fVarD = l10 != null ? s.f.d(s.f.e(l10.longValue())) : null;
        if (fVarD != null && cameraMetadata != null) {
            CameraCharacteristics.Key SCALER_AVAILABLE_STREAM_USE_CASES = CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES;
            p.h(SCALER_AVAILABLE_STREAM_USE_CASES, "SCALER_AVAILABLE_STREAM_USE_CASES");
            long[] jArr = (long[]) cameraMetadata.e0(SCALER_AVAILABLE_STREAM_USE_CASES);
            if (jArr != null && r.Q(jArr, fVarD.getValue())) {
                return fVarD;
            }
        }
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.k("CXCP")) {
            Log.w(C5473b.TRUNCATED_TAG, "Expected stream use case for " + deferrableSurface + ", " + fVarD + " cannot be set!");
        }
        return null;
    }

    public final s.g f(DeferrableSurface deferrableSurface, Map<DeferrableSurface, Long> mapping) {
        Long l10 = mapping.get(deferrableSurface);
        if (l10 != null) {
            return s.g.c(s.g.d(l10.longValue()));
        }
        return null;
    }

    public final Integer g(l captureConfig) {
        int iG = captureConfig.g();
        int iK = captureConfig.k();
        if (iG == 1 || iK == 1) {
            return 0;
        }
        if (iG == 2) {
            return 2;
        }
        return iK == 2 ? 1 : null;
    }

    public final a h(SessionConfig sessionConfig) {
        Config configG = sessionConfig.g();
        p.h(configG, "getImplementationOptions(...)");
        return new a(configG);
    }

    public final s.b i(B b10) {
        s.b bVarB = s.b.b(s.b.INSTANCE.a());
        DynamicRangeProfiles dynamicRangeProfiles = this.supportedDynamicRangeProfiles;
        if (dynamicRangeProfiles != null) {
            Long lA = C5555c.f42362a.a(b10, dynamicRangeProfiles);
            if (lA != null) {
                return s.b.b(s.b.c(lA.longValue()));
            }
            C5473b c5473b = C5473b.f41865a;
            if (C0761b0.g("CXCP")) {
                Log.e(C5473b.TRUNCATED_TAG, "Requested dynamic range is not supported. Defaulting to STANDARD dynamic range profile.\nRequested dynamic range:\n " + b10);
            }
        }
        return bVarB;
    }

    public String toString() {
        return "CameraGraphConfigProvider<" + ((Object) C5708n.f(this.cameraConfig.getCameraId())) + '>';
    }

    public /* synthetic */ c(b bVar, N n10, m mVar, androidx.camera.camera2.compat.quirk.a aVar, Q q10, E e10, androidx.camera.camera2.pipe.g gVar, androidx.camera.core.f fVar, C5491s c5491s, int i10, i iVar) {
        this(bVar, n10, mVar, aVar, q10, e10, gVar, (i10 & 128) != 0 ? null : fVar, (i10 & 256) != 0 ? null : c5491s);
    }
}
