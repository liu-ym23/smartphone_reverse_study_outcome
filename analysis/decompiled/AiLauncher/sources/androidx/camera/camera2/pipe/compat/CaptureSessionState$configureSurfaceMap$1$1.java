package androidx.camera.camera2.pipe.compat;

import Ua.M;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.CaptureSessionState$configureSurfaceMap$1$1", f = "CaptureSessionState.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CaptureSessionState$configureSurfaceMap$1$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10494a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CaptureSessionState f10495b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptureSessionState$configureSurfaceMap$1$1(CaptureSessionState captureSessionState, InterfaceC4014c<? super CaptureSessionState$configureSurfaceMap$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10495b = captureSessionState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CaptureSessionState$configureSurfaceMap$1$1(this.f10495b, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((CaptureSessionState$configureSurfaceMap$1$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f10494a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        CaptureSessionState.x(this.f10495b, false, 1, null);
        return Y8.t.f7040a;
    }
}
