package androidx.camera.camera2.impl;

import D.C0761b0;
import Ua.Q;
import Y8.t;
import android.hardware.camera2.CaptureRequest;
import android.util.Log;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import t.C5473b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/Q;", "LY8/t;", "<anonymous>", "()LUa/Q;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$removeParametersAsync$1$1", f = "UseCaseCameraRequestControl.kt", l = {394}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class UseCaseCameraRequestControlImpl$removeParametersAsync$1$1 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super Q<? extends t>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9942a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UseCaseCameraRequestControlImpl f9943b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UseCaseCameraRequestControl.Type f9944c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List<CaptureRequest.Key<?>> f9945d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UseCaseCameraRequestControlImpl$removeParametersAsync$1$1(UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl, UseCaseCameraRequestControl.Type type, List<? extends CaptureRequest.Key<?>> list, InterfaceC4014c<? super UseCaseCameraRequestControlImpl$removeParametersAsync$1$1> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.f9943b = useCaseCameraRequestControlImpl;
        this.f9944c = type;
        this.f9945d = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new UseCaseCameraRequestControlImpl$removeParametersAsync$1$1(this.f9943b, this.f9944c, this.f9945d, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(InterfaceC4014c<? super Q<t>> interfaceC4014c) {
        return ((UseCaseCameraRequestControlImpl$removeParametersAsync$1$1) create(interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f9942a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        C5473b c5473b = C5473b.f41865a;
        UseCaseCameraRequestControl.Type type = this.f9944c;
        List<CaptureRequest.Key<?>> list = this.f9945d;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "UseCaseCameraRequestControlImpl#removeParametersAsync: [" + type + "] keys = " + list);
        }
        Map map = this.f9943b.infoBundleMap;
        UseCaseCameraRequestControl.Type type2 = this.f9944c;
        Object obj2 = map.get(type2);
        if (obj2 == null) {
            UseCaseCameraRequestControlImpl.InfoBundle infoBundle = new UseCaseCameraRequestControlImpl.InfoBundle(null, null, null, null, 15, null);
            map.put(type2, infoBundle);
            obj2 = infoBundle;
        }
        this.f9943b.infoBundleMap.put(this.f9944c, this.f9943b.S((UseCaseCameraRequestControlImpl.InfoBundle) obj2, this.f9945d));
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.f9943b;
        UseCaseCameraRequestControlImpl.InfoBundle infoBundleI = useCaseCameraRequestControlImpl.I(useCaseCameraRequestControlImpl.infoBundleMap);
        this.f9942a = 1;
        Object objO = UseCaseCameraRequestControlImpl.O(useCaseCameraRequestControlImpl, infoBundleI, null, this, 1, null);
        return objO == objG ? objG : objO;
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ Object invoke(InterfaceC4014c<? super Q<? extends t>> interfaceC4014c) {
        return invoke2((InterfaceC4014c<? super Q<t>>) interfaceC4014c);
    }
}
