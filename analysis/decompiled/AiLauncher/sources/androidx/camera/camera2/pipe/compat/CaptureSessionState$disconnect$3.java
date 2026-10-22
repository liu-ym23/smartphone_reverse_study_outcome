package androidx.camera.camera2.pipe.compat;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LY8/t;", "<anonymous>", "()V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.CaptureSessionState$disconnect$3", f = "CaptureSessionState.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CaptureSessionState$disconnect$3 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super Y8.t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10501a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CaptureSessionState f10502b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptureSessionState$disconnect$3(CaptureSessionState captureSessionState, InterfaceC4014c<? super CaptureSessionState$disconnect$3> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.f10502b = captureSessionState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new CaptureSessionState$disconnect$3(this.f10502b, interfaceC4014c);
    }

    @Override // p9.InterfaceC5074l
    public final Object invoke(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((CaptureSessionState$disconnect$3) create(interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f10501a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        this.f10502b.captureSessionAttemptCompleted.await();
        return Y8.t.f7040a;
    }
}
