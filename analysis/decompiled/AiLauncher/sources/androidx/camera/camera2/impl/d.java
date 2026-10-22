package androidx.camera.camera2.impl;

import D.i0;
import Ua.C1087w;
import Ua.InterfaceC1083u;
import Ua.Q;
import android.hardware.camera2.CameraCharacteristics;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.adapter.CoroutineAdaptersKt;
import androidx.camera.camera2.impl.g;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.UseCase;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import p.t;
import r.p;
import t.InterfaceC5494v;
import t.j0;
import t.y0;
import w.C5695a;
import w.C5696b;
import w.Result3A;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0001\u0013B1\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0013\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u001c\u001a\u00020\u001b2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0002¢\u0006\u0004\b \u0010!J'\u0010%\u001a\u00020\u0012\"\u0004\b\u0000\u0010\"*\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010'R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010*R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010+R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001c\u00108\u001a\n 5*\u0004\u0018\u000104048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u001c\u0010:\u001a\n 5*\u0004\u0018\u000104048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00107R\u001c\u0010<\u001a\n 5*\u0004\u0018\u000104048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00107R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u001e\u0010E\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010B\u0018\u00010A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u001e\u0010H\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010F\u0018\u00010A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010DR\u001e\u0010K\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR \u0010M\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010JR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010S\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010PR(\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010T\u001a\u0004\u0018\u00010\u001b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b,\u0010U\"\u0004\b(\u0010V¨\u0006X"}, d2 = {"Landroidx/camera/camera2/impl/d;", "Lt/j0;", "Landroidx/camera/camera2/impl/g$a;", "Lt/v;", "cameraProperties", "Lr/p;", "meteringRegionCorrection", "Landroidx/camera/camera2/impl/State3AControl;", "state3AControl", "Lt/y0;", "threads", "Lp/t;", "zoomCompat", "<init>", "(Lt/v;Lr/p;Landroidx/camera/camera2/impl/State3AControl;Lt/y0;Lp/t;)V", "", "Landroidx/camera/core/UseCase;", "runningUseCases", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/util/Set;)V", "reset", "()V", "LUa/Q;", "Lw/N;", "c", "()LUa/Q;", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "requestControl", "LUa/u;", "", "signalToCancel", Const.INTENT_KEY_UMID, "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;LUa/u;)LUa/Q;", ExifInterface.GPS_DIRECTION_TRUE, "", "message", "f", "(LUa/u;Ljava/lang/String;)V", "Lt/v;", Const.INTENT_KEY_PKGNAME, "Lr/p;", "Landroidx/camera/camera2/impl/State3AControl;", "Lt/y0;", "e", "Lp/t;", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "_requestControl", "Landroid/util/Rational;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroid/util/Rational;", "previewAspectRatio", "", "kotlin.jvm.PlatformType", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/lang/Integer;", "maxAfRegionCount", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "maxAeRegionCount", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "maxAwbRegionCount", "", "k", "Z", "supportsAutoFocusTrigger", "", "Lw/a;", "l", "Ljava/util/List;", "availableAeModes", "Lw/b;", "m", "availableAfModes", "n", "LUa/u;", "updateSignal", "o", "cancelSignal", "Lkotlinx/coroutines/g;", "p", "Lkotlinx/coroutines/g;", "focusTimeoutJob", "q", "autoCancelJob", UxipConstants.f30680s, "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)V", "r", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class d implements j0, g.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5494v cameraProperties;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final p meteringRegionCorrection;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final State3AControl state3AControl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final y0 threads;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final t zoomCompat;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public UseCaseCameraRequestControl _requestControl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public Rational previewAspectRatio;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Integer maxAfRegionCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final Integer maxAeRegionCount;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final Integer maxAwbRegionCount;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final boolean supportsAutoFocusTrigger;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final List<C5695a> availableAeModes;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final List<C5696b> availableAfModes;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public InterfaceC1083u<Object> updateSignal;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public InterfaceC1083u<Result3A> cancelSignal;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public kotlinx.coroutines.g focusTimeoutJob;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public kotlinx.coroutines.g autoCancelJob;

    public d(InterfaceC5494v cameraProperties, p meteringRegionCorrection, State3AControl state3AControl, y0 threads, t zoomCompat) {
        ArrayList arrayList;
        kotlin.jvm.internal.p.i(cameraProperties, "cameraProperties");
        kotlin.jvm.internal.p.i(meteringRegionCorrection, "meteringRegionCorrection");
        kotlin.jvm.internal.p.i(state3AControl, "state3AControl");
        kotlin.jvm.internal.p.i(threads, "threads");
        kotlin.jvm.internal.p.i(zoomCompat, "zoomCompat");
        this.cameraProperties = cameraProperties;
        this.meteringRegionCorrection = meteringRegionCorrection;
        this.state3AControl = state3AControl;
        this.threads = threads;
        this.zoomCompat = zoomCompat;
        androidx.camera.camera2.pipe.g metadata = cameraProperties.getMetadata();
        CameraCharacteristics.Key CONTROL_MAX_REGIONS_AF = CameraCharacteristics.CONTROL_MAX_REGIONS_AF;
        kotlin.jvm.internal.p.h(CONTROL_MAX_REGIONS_AF, "CONTROL_MAX_REGIONS_AF");
        this.maxAfRegionCount = (Integer) metadata.h1(CONTROL_MAX_REGIONS_AF, 0);
        androidx.camera.camera2.pipe.g metadata2 = cameraProperties.getMetadata();
        CameraCharacteristics.Key CONTROL_MAX_REGIONS_AE = CameraCharacteristics.CONTROL_MAX_REGIONS_AE;
        kotlin.jvm.internal.p.h(CONTROL_MAX_REGIONS_AE, "CONTROL_MAX_REGIONS_AE");
        this.maxAeRegionCount = (Integer) metadata2.h1(CONTROL_MAX_REGIONS_AE, 0);
        androidx.camera.camera2.pipe.g metadata3 = cameraProperties.getMetadata();
        CameraCharacteristics.Key CONTROL_MAX_REGIONS_AWB = CameraCharacteristics.CONTROL_MAX_REGIONS_AWB;
        kotlin.jvm.internal.p.h(CONTROL_MAX_REGIONS_AWB, "CONTROL_MAX_REGIONS_AWB");
        this.maxAwbRegionCount = (Integer) metadata3.h1(CONTROL_MAX_REGIONS_AWB, 0);
        this.supportsAutoFocusTrigger = androidx.camera.camera2.pipe.g.INSTANCE.e(cameraProperties.getMetadata());
        androidx.camera.camera2.pipe.g metadata4 = cameraProperties.getMetadata();
        CameraCharacteristics.Key CONTROL_AE_AVAILABLE_MODES = CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES;
        kotlin.jvm.internal.p.h(CONTROL_AE_AVAILABLE_MODES, "CONTROL_AE_AVAILABLE_MODES");
        int[] iArr = (int[]) metadata4.e0(CONTROL_AE_AVAILABLE_MODES);
        ArrayList arrayList2 = null;
        if (iArr != null) {
            arrayList = new ArrayList(iArr.length);
            for (int i10 : iArr) {
                arrayList.add(C5695a.INSTANCE.a(i10));
            }
        } else {
            arrayList = null;
        }
        this.availableAeModes = arrayList;
        androidx.camera.camera2.pipe.g metadata5 = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key CONTROL_AF_AVAILABLE_MODES = CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES;
        kotlin.jvm.internal.p.h(CONTROL_AF_AVAILABLE_MODES, "CONTROL_AF_AVAILABLE_MODES");
        int[] iArr2 = (int[]) metadata5.e0(CONTROL_AF_AVAILABLE_MODES);
        if (iArr2 != null) {
            arrayList2 = new ArrayList(iArr2.length);
            for (int i11 : iArr2) {
                arrayList2.add(C5696b.INSTANCE.a(i11));
            }
        }
        this.availableAfModes = arrayList2;
    }

    @Override // androidx.camera.camera2.impl.g.a
    public void a(Set<? extends UseCase> runningUseCases) {
        Size sizeH;
        kotlin.jvm.internal.p.i(runningUseCases, "runningUseCases");
        this.previewAspectRatio = null;
        for (UseCase useCase : runningUseCases) {
            if ((useCase instanceof i0) && (sizeH = ((i0) useCase).h()) != null) {
                this.previewAspectRatio = new Rational(sizeH.getWidth(), sizeH.getHeight());
            }
        }
    }

    @Override // t.j0
    public void b(UseCaseCameraRequestControl useCaseCameraRequestControl) {
        this._requestControl = useCaseCameraRequestControl;
    }

    public final Q<Result3A> c() {
        InterfaceC1083u<Result3A> interfaceC1083uC = C1087w.c(null, 1, null);
        UseCaseCameraRequestControl useCaseCameraRequestControl = get_requestControl();
        if (useCaseCameraRequestControl == null) {
            interfaceC1083uC.e(new CameraControl$OperationCanceledException("Camera is not active."));
            return interfaceC1083uC;
        }
        kotlinx.coroutines.g gVar = this.focusTimeoutJob;
        if (gVar != null) {
            kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        }
        kotlinx.coroutines.g gVar2 = this.autoCancelJob;
        if (gVar2 != null) {
            kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
        }
        InterfaceC1083u<Result3A> interfaceC1083u = this.cancelSignal;
        if (interfaceC1083u != null) {
            f(interfaceC1083u, "Cancelled by another cancelFocusAndMetering()");
        }
        this.cancelSignal = interfaceC1083uC;
        CoroutineAdaptersKt.s(d(useCaseCameraRequestControl, this.updateSignal), interfaceC1083uC);
        return interfaceC1083uC;
    }

    public final Q<Result3A> d(UseCaseCameraRequestControl requestControl, InterfaceC1083u<Object> signalToCancel) {
        if (signalToCancel != null) {
            f(signalToCancel, "Cancelled by cancelFocusAndMetering()");
        }
        this.state3AControl.t(null);
        return requestControl.f();
    }

    /* renamed from: e, reason: from getter */
    public UseCaseCameraRequestControl get_requestControl() {
        return this._requestControl;
    }

    public final <T> void f(InterfaceC1083u<T> interfaceC1083u, String str) {
        interfaceC1083u.e(new CameraControl$OperationCanceledException(str));
    }

    @Override // t.j0
    public void reset() {
        this.previewAspectRatio = null;
        c();
    }
}
