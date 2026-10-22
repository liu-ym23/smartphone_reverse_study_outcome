package androidx.camera.camera2.pipe.compat;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import x.AbstractC5824k0;
import x.o0;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lx/k0;", "it", "", "<anonymous>", "(Lx/k0;)Z"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.CameraStateOpener$tryOpenCamera$2$resultDeferred$1$result$1", f = "RetryingCameraStateOpener.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CameraStateOpener$tryOpenCamera$2$resultDeferred$1$result$1 extends SuspendLambda implements p9.p<AbstractC5824k0, InterfaceC4014c<? super Boolean>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10457a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10458b;

    public CameraStateOpener$tryOpenCamera$2$resultDeferred$1$result$1(InterfaceC4014c<? super CameraStateOpener$tryOpenCamera$2$resultDeferred$1$result$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        CameraStateOpener$tryOpenCamera$2$resultDeferred$1$result$1 cameraStateOpener$tryOpenCamera$2$resultDeferred$1$result$1 = new CameraStateOpener$tryOpenCamera$2$resultDeferred$1$result$1(interfaceC4014c);
        cameraStateOpener$tryOpenCamera$2$resultDeferred$1$result$1.f10458b = obj;
        return cameraStateOpener$tryOpenCamera$2$resultDeferred$1$result$1;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(AbstractC5824k0 abstractC5824k0, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return ((CameraStateOpener$tryOpenCamera$2$resultDeferred$1$result$1) create(abstractC5824k0, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f10457a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        return C4109a.a(!(((AbstractC5824k0) this.f10458b) instanceof o0));
    }
}
