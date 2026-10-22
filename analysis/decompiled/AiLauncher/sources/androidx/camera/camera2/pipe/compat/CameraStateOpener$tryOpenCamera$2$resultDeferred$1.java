package androidx.camera.camera2.pipe.compat;

import Ua.M;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import x.AbstractC5824k0;
import x.CameraStateClosed;
import x.CameraStateClosing;
import x.CameraStateOpen;
import x.OpenCameraResult;
import x.o0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lx/v0;", "<anonymous>", "(LUa/M;)Lx/v0;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.CameraStateOpener$tryOpenCamera$2$resultDeferred$1", f = "RetryingCameraStateOpener.kt", l = {291}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CameraStateOpener$tryOpenCamera$2$resultDeferred$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super OpenCameraResult>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10455a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AndroidCameraState f10456b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraStateOpener$tryOpenCamera$2$resultDeferred$1(AndroidCameraState androidCameraState, InterfaceC4014c<? super CameraStateOpener$tryOpenCamera$2$resultDeferred$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10456b = androidCameraState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CameraStateOpener$tryOpenCamera$2$resultDeferred$1(this.f10456b, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super OpenCameraResult> interfaceC4014c) {
        return ((CameraStateOpener$tryOpenCamera$2$resultDeferred$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f10455a;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.t<AbstractC5824k0> tVarL = this.f10456b.l();
            CameraStateOpener$tryOpenCamera$2$resultDeferred$1$result$1 cameraStateOpener$tryOpenCamera$2$resultDeferred$1$result$1 = new CameraStateOpener$tryOpenCamera$2$resultDeferred$1$result$1(null);
            this.f10455a = 1;
            obj = Xa.d.z(tVarL, cameraStateOpener$tryOpenCamera$2$resultDeferred$1$result$1, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        AbstractC5824k0 abstractC5824k0 = (AbstractC5824k0) obj;
        if (abstractC5824k0 instanceof CameraStateOpen) {
            return new OpenCameraResult(this.f10456b, null, 2, null);
        }
        if (abstractC5824k0 instanceof CameraStateClosing) {
            this.f10456b.f();
            return new OpenCameraResult(null, ((CameraStateClosing) abstractC5824k0).getCameraErrorCode(), 1, null);
        }
        if (abstractC5824k0 instanceof CameraStateClosed) {
            this.f10456b.f();
            return new OpenCameraResult(null, ((CameraStateClosed) abstractC5824k0).getCameraErrorCode(), 1, null);
        }
        if (!(abstractC5824k0 instanceof o0)) {
            throw new NoWhenBranchMatchedException();
        }
        this.f10456b.f();
        throw new IllegalStateException("Unexpected CameraState: " + abstractC5824k0);
    }
}
