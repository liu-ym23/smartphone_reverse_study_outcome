package androidx.camera.camera2.pipe.compat;

import Ua.M;
import Ua.U;
import android.util.Log;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.CaptureSessionState$finalizeSession$1", f = "CaptureSessionState.kt", l = {475}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CaptureSessionState$finalizeSession$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10506a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10507b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f10508c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CaptureSessionState f10509d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptureSessionState$finalizeSession$1(long j10, CaptureSessionState captureSessionState, InterfaceC4014c<? super CaptureSessionState$finalizeSession$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10508c = j10;
        this.f10509d = captureSessionState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        CaptureSessionState$finalizeSession$1 captureSessionState$finalizeSession$1 = new CaptureSessionState$finalizeSession$1(this.f10508c, this.f10509d, interfaceC4014c);
        captureSessionState$finalizeSession$1.f10507b = obj;
        return captureSessionState$finalizeSession$1;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((CaptureSessionState$finalizeSession$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f10506a;
        if (i10 == 0) {
            C4849c.b(obj);
            M m10 = (M) this.f10507b;
            z.k kVar = z.k.f44508a;
            long j10 = this.f10508c;
            if (kVar.a()) {
                Log.d("CXCP", "Finalizing " + m10 + " in " + j10 + " ms");
            }
            long j11 = this.f10508c;
            this.f10506a = 1;
            if (U.a(j11, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        this.f10509d.y(0L);
        return Y8.t.f7040a;
    }
}
