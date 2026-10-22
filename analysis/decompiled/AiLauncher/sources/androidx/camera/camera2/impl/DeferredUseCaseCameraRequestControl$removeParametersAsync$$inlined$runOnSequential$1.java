package androidx.camera.camera2.impl;

import Ua.M;
import Ua.Q;
import Y8.t;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LUa/M;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.DeferredUseCaseCameraRequestControl$removeParametersAsync$$inlined$runOnSequential$1", f = "DeferredUseCaseCameraRequestControl.kt", l = {90}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class DeferredUseCaseCameraRequestControl$removeParametersAsync$$inlined$runOnSequential$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9721a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DeferredUseCaseCameraRequestControl f9722b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f9723c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ UseCaseCameraRequestControl.Type f9724d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeferredUseCaseCameraRequestControl$removeParametersAsync$$inlined$runOnSequential$1(DeferredUseCaseCameraRequestControl deferredUseCaseCameraRequestControl, InterfaceC4014c interfaceC4014c, List list, UseCaseCameraRequestControl.Type type) {
        super(2, interfaceC4014c);
        this.f9722b = deferredUseCaseCameraRequestControl;
        this.f9723c = list;
        this.f9724d = type;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new DeferredUseCaseCameraRequestControl$removeParametersAsync$$inlined$runOnSequential$1(this.f9722b, interfaceC4014c, this.f9723c, this.f9724d);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((DeferredUseCaseCameraRequestControl$removeParametersAsync$$inlined$runOnSequential$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f9721a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        Q<t> qI = this.f9722b.p().i(this.f9723c, this.f9724d);
        this.f9721a = 1;
        Object objA1 = qI.a1(this);
        return objA1 == objG ? objG : objA1;
    }
}
