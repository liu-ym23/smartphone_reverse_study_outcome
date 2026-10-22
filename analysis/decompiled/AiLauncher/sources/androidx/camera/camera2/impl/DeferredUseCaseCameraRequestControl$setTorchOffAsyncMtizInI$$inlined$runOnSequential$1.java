package androidx.camera.camera2.impl;

import Ua.M;
import Ua.Q;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import w.Result3A;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LUa/M;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.DeferredUseCaseCameraRequestControl$setTorchOffAsync-MtizInI$$inlined$runOnSequential$1", f = "DeferredUseCaseCameraRequestControl.kt", l = {90}, m = "invokeSuspend", v = 1)
/* renamed from: androidx.camera.camera2.impl.DeferredUseCaseCameraRequestControl$setTorchOffAsync-MtizInI$$inlined$runOnSequential$1, reason: invalid class name */
/* loaded from: classes.dex */
public final class DeferredUseCaseCameraRequestControl$setTorchOffAsyncMtizInI$$inlined$runOnSequential$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super Result3A>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9730a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DeferredUseCaseCameraRequestControl f9731b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9732c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeferredUseCaseCameraRequestControl$setTorchOffAsyncMtizInI$$inlined$runOnSequential$1(DeferredUseCaseCameraRequestControl deferredUseCaseCameraRequestControl, InterfaceC4014c interfaceC4014c, int i10) {
        super(2, interfaceC4014c);
        this.f9731b = deferredUseCaseCameraRequestControl;
        this.f9732c = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new DeferredUseCaseCameraRequestControl$setTorchOffAsyncMtizInI$$inlined$runOnSequential$1(this.f9731b, interfaceC4014c, this.f9732c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Result3A> interfaceC4014c) {
        return ((DeferredUseCaseCameraRequestControl$setTorchOffAsyncMtizInI$$inlined$runOnSequential$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f9730a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        Q<Result3A> qJ = this.f9731b.p().j(this.f9732c);
        this.f9730a = 1;
        Object objA1 = qJ.a1(this);
        return objA1 == objG ? objG : objA1;
    }
}
