package androidx.camera.camera2.pipe.compat;

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
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.CameraStateOpener$tryOpenCamera$2$result$1$4", f = "RetryingCameraStateOpener.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CameraStateOpener$tryOpenCamera$2$result$1$4 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super OpenCameraResult>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10453a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<kotlinx.coroutines.g> f10454b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraStateOpener$tryOpenCamera$2$result$1$4(Ref$ObjectRef<kotlinx.coroutines.g> ref$ObjectRef, InterfaceC4014c<? super CameraStateOpener$tryOpenCamera$2$result$1$4> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.f10454b = ref$ObjectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new CameraStateOpener$tryOpenCamera$2$result$1$4(this.f10454b, interfaceC4014c);
    }

    @Override // p9.InterfaceC5074l
    public final Object invoke(InterfaceC4014c<? super OpenCameraResult> interfaceC4014c) {
        return ((CameraStateOpener$tryOpenCamera$2$result$1$4) create(interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f10453a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        if (z.k.f44508a.a()) {
            Log.d("CXCP", "tryOpenCamera: Camera open cancelled");
        }
        this.f10454b.f34820a = null;
        return new OpenCameraResult(null, C5706l.o(C5706l.INSTANCE.j()), 1, null);
    }
}
