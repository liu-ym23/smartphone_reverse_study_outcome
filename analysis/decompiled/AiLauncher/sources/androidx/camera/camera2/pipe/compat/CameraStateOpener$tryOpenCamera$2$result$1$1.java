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
import w.C5708n;
import x.OpenCameraResult;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lx/v0;", "it", "<anonymous>", "(Lx/v0;)Lx/v0;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.CameraStateOpener$tryOpenCamera$2$result$1$1", f = "RetryingCameraStateOpener.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CameraStateOpener$tryOpenCamera$2$result$1$1 extends SuspendLambda implements p9.p<OpenCameraResult, InterfaceC4014c<? super OpenCameraResult>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10441a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10442b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<Q<OpenCameraResult>> f10443c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f10444d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraStateOpener$tryOpenCamera$2$result$1$1(Ref$ObjectRef<Q<OpenCameraResult>> ref$ObjectRef, String str, InterfaceC4014c<? super CameraStateOpener$tryOpenCamera$2$result$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10443c = ref$ObjectRef;
        this.f10444d = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        CameraStateOpener$tryOpenCamera$2$result$1$1 cameraStateOpener$tryOpenCamera$2$result$1$1 = new CameraStateOpener$tryOpenCamera$2$result$1$1(this.f10443c, this.f10444d, interfaceC4014c);
        cameraStateOpener$tryOpenCamera$2$result$1$1.f10442b = obj;
        return cameraStateOpener$tryOpenCamera$2$result$1$1;
    }

    @Override // p9.p
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final Object invoke(OpenCameraResult openCameraResult, InterfaceC4014c<? super OpenCameraResult> interfaceC4014c) {
        return ((CameraStateOpener$tryOpenCamera$2$result$1$1) create(openCameraResult, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f10441a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        OpenCameraResult openCameraResult = (OpenCameraResult) this.f10442b;
        z.k kVar = z.k.f44508a;
        String str = this.f10444d;
        if (kVar.a()) {
            Log.d("CXCP", "tryOpenCamera: openCamera() for " + ((Object) C5708n.f(str)) + " returned");
        }
        this.f10443c.f34820a = null;
        return openCameraResult;
    }
}
