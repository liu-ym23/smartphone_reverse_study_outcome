package androidx.camera.camera2.pipe.compat;

import Ua.M;
import android.util.Log;
import com.stepos.agentframework.chatui.view.AssistantImageCardView;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import w.C5706l;
import w.C5708n;
import x.InterfaceC5818h0;
import x.OpenCameraResult;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lx/v0;", "<anonymous>", "(LUa/M;)Lx/v0;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.CameraStateOpener$tryOpenCamera$2$cameraOpenDeferred$1", f = "RetryingCameraStateOpener.kt", l = {AssistantImageCardView.MAX_WIDTH_DP}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CameraStateOpener$tryOpenCamera$2$cameraOpenDeferred$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super OpenCameraResult>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10437a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CameraStateOpener f10438b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f10439c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AndroidCameraState f10440d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraStateOpener$tryOpenCamera$2$cameraOpenDeferred$1(CameraStateOpener cameraStateOpener, String str, AndroidCameraState androidCameraState, InterfaceC4014c<? super CameraStateOpener$tryOpenCamera$2$cameraOpenDeferred$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10438b = cameraStateOpener;
        this.f10439c = str;
        this.f10440d = androidCameraState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CameraStateOpener$tryOpenCamera$2$cameraOpenDeferred$1(this.f10438b, this.f10439c, this.f10440d, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super OpenCameraResult> interfaceC4014c) {
        return ((CameraStateOpener$tryOpenCamera$2$cameraOpenDeferred$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f10437a;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                InterfaceC5818h0 interfaceC5818h0 = this.f10438b.cameraOpener;
                String str = this.f10439c;
                AndroidCameraState androidCameraState = this.f10440d;
                this.f10437a = 1;
                Object objA = interfaceC5818h0.a(str, androidCameraState, this);
                this = objA;
                if (objA == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                this = this;
            }
        } catch (Exception e10) {
            z.k kVar = z.k.f44508a;
            String str2 = this.f10439c;
            if (kVar.d()) {
                Log.w("CXCP", "Failed to open " + ((Object) C5708n.f(str2)), e10);
            }
            this.f10440d.h(e10);
            new OpenCameraResult(null, C5706l.o(C5706l.INSTANCE.c(e10)), 1, null);
        }
        return null;
    }
}
