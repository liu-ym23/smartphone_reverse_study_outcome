package androidx.camera.camera2.impl;

import Ua.Q;
import Y8.t;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import androidx.camera.core.impl.Config;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/Q;", "LY8/t;", "<anonymous>", "()LUa/Q;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$setParametersAsync$1$1", f = "UseCaseCameraRequestControl.kt", l = {351}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class UseCaseCameraRequestControlImpl$setParametersAsync$1$1 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super Q<? extends t>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9946a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UseCaseCameraRequestControlImpl f9947b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UseCaseCameraRequestControl.Type f9948c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Map<CaptureRequest.Key<?>, Object> f9949d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Config.OptionPriority f9950e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UseCaseCameraRequestControlImpl$setParametersAsync$1$1(UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl, UseCaseCameraRequestControl.Type type, Map<CaptureRequest.Key<?>, ? extends Object> map, Config.OptionPriority optionPriority, InterfaceC4014c<? super UseCaseCameraRequestControlImpl$setParametersAsync$1$1> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.f9947b = useCaseCameraRequestControlImpl;
        this.f9948c = type;
        this.f9949d = map;
        this.f9950e = optionPriority;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new UseCaseCameraRequestControlImpl$setParametersAsync$1$1(this.f9947b, this.f9948c, this.f9949d, this.f9950e, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(InterfaceC4014c<? super Q<t>> interfaceC4014c) {
        return ((UseCaseCameraRequestControlImpl$setParametersAsync$1$1) create(interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f9946a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.f9947b;
        UseCaseCameraRequestControl.Type type = this.f9948c;
        Map<CaptureRequest.Key<?>, Object> map = this.f9949d;
        Config.OptionPriority optionPriority = this.f9950e;
        this.f9946a = 1;
        Object objL = useCaseCameraRequestControlImpl.L(type, map, optionPriority, this);
        return objL == objG ? objG : objL;
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ Object invoke(InterfaceC4014c<? super Q<? extends t>> interfaceC4014c) {
        return invoke2((InterfaceC4014c<? super Q<t>>) interfaceC4014c);
    }
}
