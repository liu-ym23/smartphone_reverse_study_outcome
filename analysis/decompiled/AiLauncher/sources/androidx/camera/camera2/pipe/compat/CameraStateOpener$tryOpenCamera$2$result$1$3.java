package androidx.camera.camera2.pipe.compat;

import Ua.Q;
import android.util.Log;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5074l;
import w.C5706l;
import x.OpenCameraResult;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lx/v0;", "<anonymous>", "()Lx/v0;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.CameraStateOpener$tryOpenCamera$2$result$1$3", f = "RetryingCameraStateOpener.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CameraStateOpener$tryOpenCamera$2$result$1$3 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super OpenCameraResult>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10449a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<kotlinx.coroutines.g> f10450b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<Q<OpenCameraResult>> f10451c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AndroidCameraState f10452d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraStateOpener$tryOpenCamera$2$result$1$3(Ref$ObjectRef<kotlinx.coroutines.g> ref$ObjectRef, Ref$ObjectRef<Q<OpenCameraResult>> ref$ObjectRef2, AndroidCameraState androidCameraState, InterfaceC4014c<? super CameraStateOpener$tryOpenCamera$2$result$1$3> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.f10450b = ref$ObjectRef;
        this.f10451c = ref$ObjectRef2;
        this.f10452d = androidCameraState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new CameraStateOpener$tryOpenCamera$2$result$1$3(this.f10450b, this.f10451c, this.f10452d, interfaceC4014c);
    }

    @Override // p9.InterfaceC5074l
    public final Object invoke(InterfaceC4014c<? super OpenCameraResult> interfaceC4014c) {
        return ((CameraStateOpener$tryOpenCamera$2$result$1$3) create(interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f10449a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        z.k kVar = z.k.f44508a;
        if (kVar.a()) {
            Log.d("CXCP", "tryOpenCamera: 3000ms elapsed");
        }
        this.f10450b.f34820a = null;
        if (this.f10451c.f34820a == null) {
            return null;
        }
        if (kVar.b()) {
            Log.e("CXCP", "tryOpenCamera: openCamera() timed out");
        }
        this.f10452d.f();
        return new OpenCameraResult(null, C5706l.o(C5706l.INSTANCE.j()), 1, null);
    }
}
