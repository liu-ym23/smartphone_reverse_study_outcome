package t;

import D.F0;
import Ua.C1087w;
import Ua.InterfaceC1083u;
import androidx.camera.camera2.adapter.CoroutineAdaptersKt;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import androidx.camera.core.CameraControl$OperationCanceledException;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import g3.InterfaceFutureC4095a;
import kotlin.C4848b;
import kotlin.Metadata;
import o.ZoomValue;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u001b\u0010%\u001a\u00020 8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R!\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u001e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u00102R(\u00107\u001a\u0004\u0018\u00010-2\b\u0010\u0012\u001a\u0004\u0018\u00010-8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b\u0018\u00106¨\u00068"}, d2 = {"Lt/C0;", "Lt/j0;", "Lp/t;", "zoomCompat", "<init>", "(Lp/t;)V", "LY8/t;", "reset", "()V", "LD/F0;", "zoomState", "", "cancelPreviousTask", "shouldUpdateParameters", "Lg3/a;", "Ljava/lang/Void;", "e", "(LD/F0;ZZ)Lg3/a;", UxipConstants.f30680s, "k", "(LD/F0;)V", Const.INTENT_KEY_APIKEY, "Lp/t;", "", Const.INTENT_KEY_PKGNAME, "F", "getMinZoomRatio", "()F", "minZoomRatio", "c", "getMaxZoomRatio", "maxZoomRatio", "Lo/P;", Const.INTENT_KEY_UMID, "LY8/h;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lo/P;", "defaultZoomState", "Landroidx/lifecycle/y;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Landroidx/lifecycle/y;", "_zoomState", "f", "Z", "isInitialized", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "_requestControl", "LUa/u;", "LUa/u;", "updateSignal", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)V", "requestControl", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class C0 implements j0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final p.t zoomCompat;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final float minZoomRatio;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final float maxZoomRatio;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Y8.h defaultZoomState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Y8.h _zoomState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean isInitialized;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public UseCaseCameraRequestControl _requestControl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public InterfaceC1083u<Y8.t> updateSignal;

    public C0(p.t zoomCompat) {
        kotlin.jvm.internal.p.i(zoomCompat, "zoomCompat");
        this.zoomCompat = zoomCompat;
        this.minZoomRatio = zoomCompat.getMinZoomRatio();
        this.maxZoomRatio = zoomCompat.getMaxZoomRatio();
        this.defaultZoomState = C4848b.b(new InterfaceC5063a() { // from class: t.A0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C0.g(this.f41789a);
            }
        });
        this._zoomState = C4848b.b(new InterfaceC5063a() { // from class: t.B0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C0.d(this.f41794a);
            }
        });
    }

    public static final android.view.y d(C0 c02) {
        return new android.view.y(c02.h());
    }

    public static /* synthetic */ InterfaceFutureC4095a f(C0 c02, F0 f02, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        if ((i10 & 4) != 0) {
            z11 = true;
        }
        return c02.e(f02, z10, z11);
    }

    public static final ZoomValue g(C0 c02) {
        return new ZoomValue(1.0f, c02.minZoomRatio, c02.maxZoomRatio);
    }

    @Override // t.j0
    public void b(UseCaseCameraRequestControl useCaseCameraRequestControl) {
        this._requestControl = useCaseCameraRequestControl;
        F0 f0E = j().e();
        if (f0E == null) {
            f0E = h();
        }
        e(f0E, false, this.isInitialized || f0E.getZoomRatio() != 1.0f);
        this.isInitialized = true;
    }

    public final InterfaceFutureC4095a<Void> e(F0 zoomState, boolean cancelPreviousTask, boolean shouldUpdateParameters) {
        kotlin.jvm.internal.p.i(zoomState, "zoomState");
        InterfaceC1083u<Y8.t> interfaceC1083uC = C1087w.c(null, 1, null);
        InterfaceC1083u<Y8.t> interfaceC1083u = this.updateSignal;
        if (interfaceC1083u != null) {
            if (cancelPreviousTask) {
                interfaceC1083u.e(new CameraControl$OperationCanceledException("Cancelled due to another zoom value being set."));
            } else {
                CoroutineAdaptersKt.s(interfaceC1083uC, interfaceC1083u);
            }
        }
        this.updateSignal = interfaceC1083uC;
        k(zoomState);
        UseCaseCameraRequestControl useCaseCameraRequestControl = get_requestControl();
        if (useCaseCameraRequestControl != null) {
            CoroutineAdaptersKt.s(shouldUpdateParameters ? this.zoomCompat.c(zoomState.getZoomRatio(), useCaseCameraRequestControl) : this.zoomCompat.b(useCaseCameraRequestControl), interfaceC1083uC);
        } else {
            interfaceC1083uC.e(new CameraControl$OperationCanceledException("Camera is not active."));
        }
        kotlin.jvm.internal.p.g(interfaceC1083uC, "null cannot be cast to non-null type kotlinx.coroutines.Job");
        InterfaceFutureC4095a<Void> interfaceFutureC4095aI = O.f.i(CoroutineAdaptersKt.j(interfaceC1083uC, null, 1, null));
        kotlin.jvm.internal.p.h(interfaceFutureC4095aI, "nonCancellationPropagating(...)");
        return interfaceFutureC4095aI;
    }

    public final ZoomValue h() {
        return (ZoomValue) this.defaultZoomState.getValue();
    }

    /* renamed from: i, reason: from getter */
    public UseCaseCameraRequestControl get_requestControl() {
        return this._requestControl;
    }

    public final android.view.y<F0> j() {
        return (android.view.y) this._zoomState.getValue();
    }

    public final void k(F0 value) {
        if (M.n.d()) {
            j().k(value);
        } else {
            j().i(value);
        }
    }

    @Override // t.j0
    public void reset() {
        f(this, h(), false, false, 6, null);
    }
}
