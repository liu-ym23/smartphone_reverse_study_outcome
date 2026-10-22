package p;

import Ua.C1087w;
import Ua.InterfaceC1083u;
import Ua.Q;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.util.Range;
import android.util.Rational;
import androidx.camera.camera2.adapter.CoroutineAdaptersKt;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import androidx.camera.camera2.pipe.t;
import androidx.camera.core.CameraControl$OperationCanceledException;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import t.InterfaceC5494v;
import t.N;
import t.y0;
import w.K;
import w.w;
import w.x;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u001d8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u0018\u0010\u001fR\u001a\u0010$\u001a\u00020\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001b\u0010#R\u001a\u0010)\u001a\u00020%8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b!\u0010(R\u001e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00062"}, d2 = {"Lp/o;", "Lp/l;", "Lt/v;", "cameraProperties", "Lt/y0;", "threads", "Lt/N;", "comboRequestListener", "<init>", "(Lt/v;Lt/y0;Lt/N;)V", "", "throwable", "LY8/t;", Const.INTENT_KEY_UMID, "(Ljava/lang/Throwable;)V", "", "evCompIndex", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "requestControl", "", "cancelPreviousTask", "LUa/Q;", Const.INTENT_KEY_PKGNAME, "(ILandroidx/camera/camera2/impl/UseCaseCameraRequestControl;Z)LUa/Q;", Const.INTENT_KEY_APIKEY, "Lt/v;", "Lt/y0;", "c", "Lt/N;", "Landroid/util/Range;", "Landroid/util/Range;", "()Landroid/util/Range;", "range", "e", "Z", "()Z", "supported", "Landroid/util/Rational;", "f", "Landroid/util/Rational;", "()Landroid/util/Rational;", "step", "LUa/u;", Const.INTENT_KEY_BACKGROUND_COMMAND, "LUa/u;", "updateSignal", "Landroidx/camera/camera2/pipe/t$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroidx/camera/camera2/pipe/t$a;", "updateListener", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class o implements InterfaceC5030l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5494v cameraProperties;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final y0 threads;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final N comboRequestListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Range<Integer> range;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final boolean supported;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Rational step;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public InterfaceC1083u<Integer> updateSignal;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public t.a updateListener;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"p/o$a", "Landroidx/camera/camera2/pipe/t$a;", "Lw/K;", "requestMetadata", "Lw/y;", "frameNumber", "Lw/w;", "result", "LY8/t;", "g0", "(Lw/K;JLw/w;)V", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements t.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f37992a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1083u<Integer> f37993b;

        public a(int i10, InterfaceC1083u<Integer> interfaceC1083u) {
            this.f37992a = i10;
            this.f37993b = interfaceC1083u;
        }

        @Override // androidx.camera.camera2.pipe.t.a
        public void g0(K requestMetadata, long frameNumber, w result) {
            kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
            kotlin.jvm.internal.p.i(result, "result");
            x metadata = result.getMetadata();
            CaptureResult.Key CONTROL_AE_STATE = CaptureResult.CONTROL_AE_STATE;
            kotlin.jvm.internal.p.h(CONTROL_AE_STATE, "CONTROL_AE_STATE");
            Integer num = (Integer) metadata.U(CONTROL_AE_STATE);
            x metadata2 = result.getMetadata();
            CaptureResult.Key CONTROL_AE_EXPOSURE_COMPENSATION = CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION;
            kotlin.jvm.internal.p.h(CONTROL_AE_EXPOSURE_COMPENSATION, "CONTROL_AE_EXPOSURE_COMPENSATION");
            Integer num2 = (Integer) metadata2.U(CONTROL_AE_EXPOSURE_COMPENSATION);
            if (num == null || num2 == null) {
                if (num2 != null) {
                    if (num2.intValue() == this.f37992a) {
                        this.f37993b.complete(Integer.valueOf(this.f37992a));
                        return;
                    }
                    return;
                }
                return;
            }
            int iIntValue = num.intValue();
            if (iIntValue == 2 || iIntValue == 3 || iIntValue == 4) {
                if (num2.intValue() == this.f37992a) {
                    this.f37993b.complete(Integer.valueOf(this.f37992a));
                }
            }
        }
    }

    public o(InterfaceC5494v cameraProperties, y0 threads, N comboRequestListener) {
        Integer num;
        Rational rational;
        kotlin.jvm.internal.p.i(cameraProperties, "cameraProperties");
        kotlin.jvm.internal.p.i(threads, "threads");
        kotlin.jvm.internal.p.i(comboRequestListener, "comboRequestListener");
        this.cameraProperties = cameraProperties;
        this.threads = threads;
        this.comboRequestListener = comboRequestListener;
        androidx.camera.camera2.pipe.g metadata = cameraProperties.getMetadata();
        CameraCharacteristics.Key CONTROL_AE_COMPENSATION_RANGE = CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE;
        kotlin.jvm.internal.p.h(CONTROL_AE_COMPENSATION_RANGE, "CONTROL_AE_COMPENSATION_RANGE");
        Object objH1 = metadata.h1(CONTROL_AE_COMPENSATION_RANGE, C5031m.a());
        kotlin.jvm.internal.p.h(objH1, "getOrDefault(...)");
        this.range = (Range) objH1;
        Integer num2 = (Integer) a().getUpper();
        this.supported = (num2 == null || num2.intValue() != 0) && ((num = (Integer) a().getLower()) == null || num.intValue() != 0);
        if (getSupported()) {
            androidx.camera.camera2.pipe.g metadata2 = cameraProperties.getMetadata();
            CameraCharacteristics.Key CONTROL_AE_COMPENSATION_STEP = CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP;
            kotlin.jvm.internal.p.h(CONTROL_AE_COMPENSATION_STEP, "CONTROL_AE_COMPENSATION_STEP");
            Object objE0 = metadata2.e0(CONTROL_AE_COMPENSATION_STEP);
            kotlin.jvm.internal.p.f(objE0);
            rational = (Rational) objE0;
        } else {
            rational = Rational.ZERO;
            kotlin.jvm.internal.p.f(rational);
        }
        this.step = rational;
    }

    public static final Y8.t g(o oVar, a aVar, Throwable th) {
        oVar.comboRequestListener.F(aVar);
        return Y8.t.f7040a;
    }

    @Override // p.InterfaceC5030l
    public Range<Integer> a() {
        return this.range;
    }

    @Override // p.InterfaceC5030l
    public Q<Integer> b(int evCompIndex, UseCaseCameraRequestControl requestControl, boolean cancelPreviousTask) {
        kotlin.jvm.internal.p.i(requestControl, "requestControl");
        InterfaceC1083u<Integer> interfaceC1083uC = C1087w.c(null, 1, null);
        InterfaceC1083u<Integer> interfaceC1083u = this.updateSignal;
        if (interfaceC1083u != null) {
            if (cancelPreviousTask) {
                interfaceC1083u.e(new CameraControl$OperationCanceledException("Cancelled by another setExposureCompensationIndex()"));
            } else {
                CoroutineAdaptersKt.s(interfaceC1083uC, interfaceC1083u);
            }
        }
        this.updateSignal = interfaceC1083uC;
        t.a aVar = this.updateListener;
        if (aVar != null) {
            this.comboRequestListener.F(aVar);
            this.updateListener = null;
        }
        UseCaseCameraRequestControl.d(requestControl, Z8.Q.f(Y8.j.a(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(evCompIndex))), null, null, 6, null);
        final a aVar2 = new a(evCompIndex, interfaceC1083uC);
        this.comboRequestListener.s(aVar2, this.threads.getSequentialExecutor());
        interfaceC1083uC.J(new InterfaceC5074l() { // from class: p.n
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return o.g(this.f37982a, aVar2, (Throwable) obj);
            }
        });
        this.updateListener = aVar2;
        return interfaceC1083uC;
    }

    @Override // p.InterfaceC5030l
    /* renamed from: c, reason: from getter */
    public boolean getSupported() {
        return this.supported;
    }

    @Override // p.InterfaceC5030l
    public void d(Throwable throwable) {
        kotlin.jvm.internal.p.i(throwable, "throwable");
        InterfaceC1083u<Integer> interfaceC1083u = this.updateSignal;
        if (interfaceC1083u != null) {
            interfaceC1083u.e(throwable);
        }
    }

    @Override // p.InterfaceC5030l
    /* renamed from: e, reason: from getter */
    public Rational getStep() {
        return this.step;
    }
}
