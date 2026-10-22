package androidx.camera.camera2.impl;

import Ua.M;
import Ua.Q;
import Y8.t;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import androidx.camera.core.impl.Config;
import androidx.exifinterface.media.ExifInterface;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LUa/M;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.DeferredUseCaseCameraRequestControl$submitParameters$$inlined$runOnSequential$1", f = "DeferredUseCaseCameraRequestControl.kt", l = {90}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class DeferredUseCaseCameraRequestControl$submitParameters$$inlined$runOnSequential$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9735a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DeferredUseCaseCameraRequestControl f9736b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f9737c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ UseCaseCameraRequestControl.Type f9738d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Config.OptionPriority f9739e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeferredUseCaseCameraRequestControl$submitParameters$$inlined$runOnSequential$1(DeferredUseCaseCameraRequestControl deferredUseCaseCameraRequestControl, InterfaceC4014c interfaceC4014c, Map map, UseCaseCameraRequestControl.Type type, Config.OptionPriority optionPriority) {
        super(2, interfaceC4014c);
        this.f9736b = deferredUseCaseCameraRequestControl;
        this.f9737c = map;
        this.f9738d = type;
        this.f9739e = optionPriority;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new DeferredUseCaseCameraRequestControl$submitParameters$$inlined$runOnSequential$1(this.f9736b, interfaceC4014c, this.f9737c, this.f9738d, this.f9739e);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((DeferredUseCaseCameraRequestControl$submitParameters$$inlined$runOnSequential$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f9735a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        Q<t> qL = this.f9736b.p().l(this.f9737c, this.f9738d, this.f9739e);
        this.f9735a = 1;
        Object objA1 = qL.a1(this);
        return objA1 == objG ? objG : objA1;
    }
}
