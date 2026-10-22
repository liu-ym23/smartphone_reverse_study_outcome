package o;

import K.AbstractC0889l;
import K.C0892o;
import K.InterfaceC0891n;
import Z8.C1172u;
import Z8.C1174w;
import android.hardware.camera2.CaptureRequest;
import android.media.Image;
import androidx.camera.camera2.impl.a;
import androidx.camera.camera2.pipe.t;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import t.C5471a;
import t.InterfaceC5494v;
import t.f0;
import t.y0;
import w.InputRequest;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001\u001eB1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ7\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010 R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010#R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lo/p;", "", "Lt/v;", "cameraProperties", "Ls/J;", "useCaseGraphContext", "Lo/Q;", "zslControl", "Lt/y0;", "threads", "Lr/E;", "templateParamsOverride", "<init>", "(Lt/v;Ls/J;Lo/Q;Lt/y0;Lr/E;)V", "Landroidx/camera/core/impl/l;", "captureConfig", "Lw/M;", "requestTemplate", "Landroidx/camera/core/impl/Config;", "sessionConfigOptions", "", "Landroidx/camera/camera2/pipe/t$a;", "additionalListeners", "Landroidx/camera/camera2/pipe/t;", Const.INTENT_KEY_UMID, "(Landroidx/camera/core/impl/l;ILandroidx/camera/core/impl/Config;Ljava/util/List;)Landroidx/camera/camera2/pipe/t;", "Landroidx/camera/core/i;", "imageProxy", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/core/i;)Landroidx/camera/camera2/pipe/t$a;", Const.INTENT_KEY_APIKEY, "Ls/J;", "Lo/Q;", "c", "Lt/y0;", "Lr/E;", "", "e", "Z", "isLegacyDevice", "f", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: o.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4984p {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final s.J useCaseGraphContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Q zslControl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final y0 threads;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final r.E templateParamsOverride;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final boolean isLegacyDevice;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lo/p$a;", "", "<init>", "()V", "Landroidx/camera/core/impl/l;", "Lw/M;", "sessionTemplate", "", "isLegacyDevice", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/core/impl/l;IZ)I", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: o.p$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final int a(androidx.camera.core.impl.l getStillCaptureTemplate, int i10, boolean z10) {
            kotlin.jvm.internal.p.i(getStillCaptureTemplate, "$this$getStillCaptureTemplate");
            int i11 = (!w.M.d(i10, w.M.b(3)) || z10) ? (getStillCaptureTemplate.j() == -1 || getStillCaptureTemplate.j() == 5) ? 2 : -1 : 4;
            return i11 != -1 ? w.M.b(i11) : w.M.b(getStillCaptureTemplate.j());
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\n¨\u0006\u0015"}, d2 = {"o/p$b", "Landroidx/camera/camera2/pipe/t$a;", "Lw/K;", "requestMetadata", "Lw/y;", "frameNumber", "Lw/w;", "result", "LY8/t;", "g0", "(Lw/K;JLw/w;)V", "Lw/J;", "requestFailure", "Y", "(Lw/K;JLw/J;)V", "Landroidx/camera/camera2/pipe/t;", "request", "G", "(Landroidx/camera/camera2/pipe/t;)V", "totalCaptureResult", "N0", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: o.p$b */
    public static final class b implements t.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference<androidx.camera.core.i> f37433a;

        public b(AtomicReference<androidx.camera.core.i> atomicReference) {
            this.f37433a = atomicReference;
        }

        @Override // androidx.camera.camera2.pipe.t.a
        public void G(androidx.camera.camera2.pipe.t request) {
            kotlin.jvm.internal.p.i(request, "request");
            C4984p.c(this.f37433a);
        }

        @Override // androidx.camera.camera2.pipe.t.a
        public void N0(w.K requestMetadata, long frameNumber, w.w totalCaptureResult) {
            kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
            kotlin.jvm.internal.p.i(totalCaptureResult, "totalCaptureResult");
            C4984p.c(this.f37433a);
        }

        @Override // androidx.camera.camera2.pipe.t.a
        public void Y(w.K requestMetadata, long frameNumber, w.J requestFailure) {
            kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
            kotlin.jvm.internal.p.i(requestFailure, "requestFailure");
            C4984p.c(this.f37433a);
        }

        @Override // androidx.camera.camera2.pipe.t.a
        public void g0(w.K requestMetadata, long frameNumber, w.w result) {
            kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
            kotlin.jvm.internal.p.i(result, "result");
            C4984p.c(this.f37433a);
        }
    }

    public C4984p(InterfaceC5494v cameraProperties, s.J useCaseGraphContext, Q zslControl, y0 threads, r.E templateParamsOverride) {
        kotlin.jvm.internal.p.i(cameraProperties, "cameraProperties");
        kotlin.jvm.internal.p.i(useCaseGraphContext, "useCaseGraphContext");
        kotlin.jvm.internal.p.i(zslControl, "zslControl");
        kotlin.jvm.internal.p.i(threads, "threads");
        kotlin.jvm.internal.p.i(templateParamsOverride, "templateParamsOverride");
        this.useCaseGraphContext = useCaseGraphContext;
        this.zslControl = zslControl;
        this.threads = threads;
        this.templateParamsOverride = templateParamsOverride;
        this.isLegacyDevice = androidx.camera.camera2.pipe.g.INSTANCE.l(cameraProperties.getMetadata());
    }

    public static final void c(AtomicReference<androidx.camera.core.i> atomicReference) {
        androidx.camera.core.i andSet = atomicReference.getAndSet(null);
        if (andSet != null) {
            andSet.close();
        }
    }

    public final t.a b(androidx.camera.core.i imageProxy) {
        return new b(new AtomicReference(imageProxy));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [w.D] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [w.D] */
    /* JADX WARN: Type inference failed for: r7v2 */
    public final androidx.camera.camera2.pipe.t d(androidx.camera.core.impl.l captureConfig, int requestTemplate, Config sessionConfigOptions, List<? extends t.a> additionalListeners) {
        ?? r72;
        androidx.camera.core.i iVarF;
        t.a aVarB;
        kotlin.jvm.internal.p.i(captureConfig, "captureConfig");
        kotlin.jvm.internal.p.i(sessionConfigOptions, "sessionConfigOptions");
        kotlin.jvm.internal.p.i(additionalListeners, "additionalListeners");
        List<DeferrableSurface> listH = captureConfig.h();
        kotlin.jvm.internal.p.h(listH, "getSurfaces(...)");
        if (listH.isEmpty()) {
            throw new IllegalStateException(("Attempted to issue a capture without surfaces using " + captureConfig).toString());
        }
        List<DeferrableSurface> list = listH;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        for (DeferrableSurface deferrableSurface : list) {
            w.Q q10 = this.useCaseGraphContext.h().get(deferrableSurface);
            if (q10 == null) {
                throw new IllegalStateException(("Attempted to issue a capture with an unrecognized surface: " + deferrableSurface).toString());
            }
            arrayList.add(w.Q.a(q10.getValue()));
        }
        androidx.camera.camera2.impl.b bVar = new androidx.camera.camera2.impl.b();
        List<AbstractC0889l> listC = captureConfig.c();
        kotlin.jvm.internal.p.h(listC, "getCameraCaptureCallbacks(...)");
        for (AbstractC0889l abstractC0889l : listC) {
            kotlin.jvm.internal.p.f(abstractC0889l);
            bVar.x(abstractC0889l, this.threads.getSequentialExecutor());
        }
        Config configF = captureConfig.f();
        kotlin.jvm.internal.p.h(configF, "getImplementationOptions(...)");
        a.C0131a c0131a = new a.C0131a();
        c0131a.e(sessionConfigOptions);
        c0131a.e(configF);
        Config.a<Integer> aVar = androidx.camera.core.impl.l.f11441i;
        if (configF.b(aVar)) {
            CaptureRequest.Key JPEG_ORIENTATION = CaptureRequest.JPEG_ORIENTATION;
            kotlin.jvm.internal.p.h(JPEG_ORIENTATION, "JPEG_ORIENTATION");
            Object objA = configF.a(aVar);
            kotlin.jvm.internal.p.f(objA);
            c0131a.g(JPEG_ORIENTATION, objA);
        }
        Config.a<Integer> aVar2 = androidx.camera.core.impl.l.f11442j;
        if (configF.b(aVar2)) {
            CaptureRequest.Key JPEG_QUALITY = CaptureRequest.JPEG_QUALITY;
            kotlin.jvm.internal.p.h(JPEG_QUALITY, "JPEG_QUALITY");
            Object objA2 = configF.a(aVar2);
            kotlin.jvm.internal.p.f(objA2);
            c0131a.g(JPEG_QUALITY, Byte.valueOf((byte) ((Number) objA2).intValue()));
        }
        int iB = w.M.b(captureConfig.j());
        t.a aVar3 = null;
        if (captureConfig.j() != 5 || this.zslControl.getIsZslDisabledByUseCaseConfig() || this.zslControl.getIsZslDisabledByFlashMode() || (iVarF = this.zslControl.f()) == null) {
            r72 = 0;
        } else {
            InterfaceC0891n interfaceC0891nA = C0892o.a(iVarF.Z0());
            if (interfaceC0891nA == null) {
                aVarB = null;
            } else {
                if (!(interfaceC0891nA instanceof C4985q)) {
                    throw new IllegalStateException(("Unexpected capture result type: " + interfaceC0891nA.getClass()).toString());
                }
                Image imageG1 = iVarF.g1();
                if (imageG1 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                C.a aVar4 = new C.a(imageG1);
                Object objR0 = ((C4985q) interfaceC0891nA).R0(kotlin.jvm.internal.t.b(w.w.class));
                if (objR0 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                ?? inputRequest = new InputRequest(aVar4, (w.w) objR0);
                aVarB = b(iVarF);
                aVar3 = inputRequest;
            }
            r72 = aVar3;
            aVar3 = aVarB;
        }
        if (r72 == 0) {
            iB = INSTANCE.a(captureConfig, requestTemplate, this.isLegacyDevice);
        }
        Map mapR = kotlin.collections.a.r(this.templateParamsOverride.a(w.M.a(iB)), C5471a.b(c0131a.c()));
        List listC2 = C1172u.c();
        listC2.add(bVar);
        if (aVar3 != null) {
            listC2.add(aVar3);
        }
        listC2.addAll(additionalListeners);
        return new androidx.camera.camera2.pipe.t(arrayList, mapR, Z8.Q.f(Y8.j.a(f0.a(), captureConfig.i())), C1172u.a(listC2), w.M.a(iB), r72, null);
    }
}
