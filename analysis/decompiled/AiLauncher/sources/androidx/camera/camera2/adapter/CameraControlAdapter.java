package androidx.camera.camera2.adapter;

import J.InterfaceC0857l;
import Ua.C1060i;
import Ua.M;
import Y8.t;
import android.annotation.SuppressLint;
import androidx.camera.camera2.impl.FlashControl;
import androidx.camera.camera2.impl.LowLightBoostControl;
import androidx.camera.camera2.impl.StillCaptureRequestControl;
import androidx.camera.camera2.impl.d;
import androidx.camera.camera2.impl.f;
import androidx.camera.camera2.impl.g;
import androidx.camera.core.CameraControl$OperationCanceledException;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.h;
import androidx.camera.core.impl.l;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import g3.InterfaceFutureC4095a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.p;
import o.Q;
import t.C0;
import t.InterfaceC5494v;
import t.S;
import t.i0;
import t.y0;
import t.z0;
import v.C5644a;
import v.C5649f;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001Bq\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020 H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u001eH\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020 2\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u0019\u0010-\u001a\u00020 2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020 2\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020 H\u0016¢\u0006\u0004\b3\u0010$J;\u0010;\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010:04092\f\u00106\u001a\b\u0012\u0004\u0012\u000205042\u0006\u00107\u001a\u00020'2\u0006\u00108\u001a\u00020'H\u0016¢\u0006\u0004\b;\u0010<J%\u0010>\u001a\b\u0012\u0004\u0012\u00020=092\u0006\u00107\u001a\u00020'2\u0006\u00108\u001a\u00020'H\u0016¢\u0006\u0004\b>\u0010?R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010@R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010AR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010BR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010CR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010DR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010ER\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010FR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010GR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0017\u0010\u0015\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010S¨\u0006T"}, d2 = {"Landroidx/camera/camera2/adapter/CameraControlAdapter;", "Landroidx/camera/core/impl/h;", "Lt/v;", "cameraProperties", "Lt/S;", "evCompControl", "Landroidx/camera/camera2/impl/FlashControl;", "flashControl", "Landroidx/camera/camera2/impl/d;", "focusMeteringControl", "Landroidx/camera/camera2/impl/StillCaptureRequestControl;", "stillCaptureRequestControl", "Landroidx/camera/camera2/impl/f;", "torchControl", "Landroidx/camera/camera2/impl/LowLightBoostControl;", "lowLightBoostControl", "Lt/C0;", "zoomControl", "Lo/Q;", "zslControl", "Lv/a;", "camera2cameraControl", "Landroidx/camera/camera2/impl/g;", "useCaseManager", "Lt/y0;", "threads", "Lt/z0;", "videoUsageControl", "<init>", "(Lt/v;Lt/S;Landroidx/camera/camera2/impl/FlashControl;Landroidx/camera/camera2/impl/d;Landroidx/camera/camera2/impl/StillCaptureRequestControl;Landroidx/camera/camera2/impl/f;Landroidx/camera/camera2/impl/LowLightBoostControl;Lt/C0;Lo/Q;Lv/a;Landroidx/camera/camera2/impl/g;Lt/y0;Lt/z0;)V", "Landroidx/camera/core/impl/Config;", "config", "LY8/t;", "f", "(Landroidx/camera/core/impl/Config;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()V", "e", "()Landroidx/camera/core/impl/Config;", "", "flashMode", Const.INTENT_KEY_UMID, "(I)V", "Landroidx/camera/core/ImageCapture$h;", "screenFlash", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroidx/camera/core/ImageCapture$h;)V", "Landroidx/camera/core/impl/SessionConfig$b;", "sessionConfigBuilder", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/core/impl/SessionConfig$b;)V", Const.INTENT_KEY_APIKEY, "", "Landroidx/camera/core/impl/l;", "captureConfigs", "captureMode", "flashType", "Lg3/a;", "Ljava/lang/Void;", "c", "(Ljava/util/List;II)Lg3/a;", "LJ/l;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(II)Lg3/a;", "Lt/v;", "Lt/S;", "Landroidx/camera/camera2/impl/FlashControl;", "Landroidx/camera/camera2/impl/d;", "Landroidx/camera/camera2/impl/StillCaptureRequestControl;", "Landroidx/camera/camera2/impl/f;", "Landroidx/camera/camera2/impl/LowLightBoostControl;", "Lt/C0;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Lo/Q;", "k", "Lv/a;", "getCamera2cameraControl", "()Lv/a;", "l", "Landroidx/camera/camera2/impl/g;", "m", "Lt/y0;", "n", "Lt/z0;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"UnsafeOptInUsageError"})
/* loaded from: classes.dex */
public final class CameraControlAdapter implements h {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5494v cameraProperties;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final S evCompControl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final FlashControl flashControl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final d focusMeteringControl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final StillCaptureRequestControl stillCaptureRequestControl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final f torchControl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final LowLightBoostControl lowLightBoostControl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final C0 zoomControl;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final Q zslControl;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final C5644a camera2cameraControl;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final g useCaseManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final y0 threads;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final z0 videoUsageControl;

    public CameraControlAdapter(InterfaceC5494v cameraProperties, S evCompControl, FlashControl flashControl, d focusMeteringControl, StillCaptureRequestControl stillCaptureRequestControl, f torchControl, LowLightBoostControl lowLightBoostControl, C0 zoomControl, Q zslControl, C5644a camera2cameraControl, g useCaseManager, y0 threads, z0 videoUsageControl) {
        p.i(cameraProperties, "cameraProperties");
        p.i(evCompControl, "evCompControl");
        p.i(flashControl, "flashControl");
        p.i(focusMeteringControl, "focusMeteringControl");
        p.i(stillCaptureRequestControl, "stillCaptureRequestControl");
        p.i(torchControl, "torchControl");
        p.i(lowLightBoostControl, "lowLightBoostControl");
        p.i(zoomControl, "zoomControl");
        p.i(zslControl, "zslControl");
        p.i(camera2cameraControl, "camera2cameraControl");
        p.i(useCaseManager, "useCaseManager");
        p.i(threads, "threads");
        p.i(videoUsageControl, "videoUsageControl");
        this.cameraProperties = cameraProperties;
        this.evCompControl = evCompControl;
        this.flashControl = flashControl;
        this.focusMeteringControl = focusMeteringControl;
        this.stillCaptureRequestControl = stillCaptureRequestControl;
        this.torchControl = torchControl;
        this.lowLightBoostControl = lowLightBoostControl;
        this.zoomControl = zoomControl;
        this.zslControl = zslControl;
        this.camera2cameraControl = camera2cameraControl;
        this.useCaseManager = useCaseManager;
        this.threads = threads;
        this.videoUsageControl = videoUsageControl;
    }

    @Override // androidx.camera.core.impl.h
    public void a() {
        this.zslControl.a();
    }

    @Override // androidx.camera.core.impl.h
    public void b(SessionConfig.b sessionConfigBuilder) {
        p.i(sessionConfigBuilder, "sessionConfigBuilder");
        this.zslControl.b(sessionConfigBuilder);
    }

    @Override // androidx.camera.core.impl.h
    public InterfaceFutureC4095a<List<Void>> c(List<l> captureConfigs, int captureMode, int flashType) {
        p.i(captureConfigs, "captureConfigs");
        return this.stillCaptureRequestControl.h(captureConfigs, captureMode, flashType);
    }

    @Override // androidx.camera.core.impl.h
    public void d(int flashMode) {
        FlashControl.p(this.flashControl, flashMode, false, 2, null);
        this.zslControl.d(flashMode == 1 || flashMode == 0);
    }

    @Override // androidx.camera.core.impl.h
    public Config e() {
        return this.camera2cameraControl.d();
    }

    @Override // androidx.camera.core.impl.h
    public void f(Config config) {
        p.i(config, "config");
        this.camera2cameraControl.a(C5649f.a.INSTANCE.b(config).b());
    }

    @Override // androidx.camera.core.impl.h
    public InterfaceFutureC4095a<InterfaceC0857l> g(final int captureMode, final int flashType) {
        final i0 i0VarT = this.useCaseManager.t();
        if (i0VarT == null) {
            InterfaceFutureC4095a<InterfaceC0857l> interfaceFutureC4095aF = O.f.f(new CameraControl$OperationCanceledException("Camera is not active."));
            p.h(interfaceFutureC4095aF, "immediateFailedFuture(...)");
            return interfaceFutureC4095aF;
        }
        final M sequentialScope = this.threads.getSequentialScope();
        InterfaceFutureC4095a<InterfaceC0857l> interfaceFutureC4095aA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.camera.camera2.adapter.CameraControlAdapter$getCameraCapturePipelineAsync$$inlined$future$1

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
            @InterfaceC4112d(c = "androidx.camera.camera2.adapter.CameraControlAdapter$getCameraCapturePipelineAsync$$inlined$future$1$1", f = "CameraControlAdapter.kt", l = {106, 104}, m = "invokeSuspend", v = 1)
            /* renamed from: androidx.camera.camera2.adapter.CameraControlAdapter$getCameraCapturePipelineAsync$$inlined$future$1$1, reason: invalid class name */
            public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {

                /* renamed from: a, reason: collision with root package name */
                public Object f9297a;

                /* renamed from: b, reason: collision with root package name */
                public int f9298b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ CallbackToFutureAdapter.a f9299c;

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ i0 f9300d;

                /* renamed from: e, reason: collision with root package name */
                public final /* synthetic */ int f9301e;

                /* renamed from: f, reason: collision with root package name */
                public final /* synthetic */ CameraControlAdapter f9302f;

                /* renamed from: g, reason: collision with root package name */
                public final /* synthetic */ int f9303g;

                /* renamed from: h, reason: collision with root package name */
                public Object f9304h;

                /* renamed from: i, reason: collision with root package name */
                public int f9305i;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(CallbackToFutureAdapter.a aVar, InterfaceC4014c interfaceC4014c, i0 i0Var, int i10, CameraControlAdapter cameraControlAdapter, int i11) {
                    super(2, interfaceC4014c);
                    this.f9299c = aVar;
                    this.f9300d = i0Var;
                    this.f9301e = i10;
                    this.f9302f = cameraControlAdapter;
                    this.f9303g = i11;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                    return new AnonymousClass1(this.f9299c, interfaceC4014c, this.f9300d, this.f9301e, this.f9302f, this.f9303g);
                }

                @Override // p9.p
                public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
                    return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    CallbackToFutureAdapter.a aVar;
                    Object objH;
                    i0 i0Var;
                    int i10;
                    CallbackToFutureAdapter.a aVar2;
                    Object objG = C4063a.g();
                    int i11 = this.f9298b;
                    if (i11 == 0) {
                        C4849c.b(obj);
                        aVar = this.f9299c;
                        i0 i0Var2 = this.f9300d;
                        int i12 = this.f9301e;
                        FlashControl flashControl = this.f9302f.flashControl;
                        this.f9297a = aVar;
                        this.f9304h = i0Var2;
                        this.f9305i = i12;
                        this.f9298b = 1;
                        objH = flashControl.h(this);
                        if (objH != objG) {
                            i0Var = i0Var2;
                            i10 = i12;
                        }
                        return objG;
                    }
                    if (i11 != 1) {
                        if (i11 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        CallbackToFutureAdapter.a aVar3 = (CallbackToFutureAdapter.a) this.f9297a;
                        C4849c.b(obj);
                        aVar2 = aVar3;
                        aVar2.c(obj);
                        return t.f7040a;
                    }
                    i10 = this.f9305i;
                    i0 i0Var3 = (i0) this.f9304h;
                    CallbackToFutureAdapter.a aVar4 = (CallbackToFutureAdapter.a) this.f9297a;
                    C4849c.b(obj);
                    objH = obj;
                    aVar = aVar4;
                    i0Var = i0Var3;
                    int iIntValue = ((Number) objH).intValue();
                    int i13 = this.f9303g;
                    this.f9297a = aVar;
                    this.f9304h = null;
                    this.f9298b = 2;
                    Object objA = i0Var.a(i10, iIntValue, i13, this);
                    if (objA != objG) {
                        CallbackToFutureAdapter.a aVar5 = aVar;
                        obj = objA;
                        aVar2 = aVar5;
                        aVar2.c(obj);
                        return t.f7040a;
                    }
                    return objG;
                }
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a<T> completer) {
                p.i(completer, "completer");
                return C1060i.d(sequentialScope, null, null, new AnonymousClass1(completer, null, i0VarT, captureMode, this, flashType), 3, null);
            }
        });
        p.h(interfaceFutureC4095aA, "getFuture(...)");
        return interfaceFutureC4095aA;
    }

    @Override // androidx.camera.core.impl.h
    public void h(ImageCapture.h screenFlash) {
        this.flashControl.q(screenFlash);
    }

    @Override // androidx.camera.core.impl.h
    public void i() {
        this.camera2cameraControl.c();
    }
}
