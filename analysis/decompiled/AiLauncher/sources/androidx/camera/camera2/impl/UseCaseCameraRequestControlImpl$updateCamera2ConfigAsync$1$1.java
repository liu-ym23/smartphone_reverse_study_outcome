package androidx.camera.camera2.impl;

import D.C0761b0;
import Ua.Q;
import Y8.t;
import android.util.Log;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl;
import androidx.camera.core.impl.Config;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import t.C5473b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/Q;", "LY8/t;", "<anonymous>", "()LUa/Q;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$updateCamera2ConfigAsync$1$1", f = "UseCaseCameraRequestControl.kt", l = {441}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class UseCaseCameraRequestControlImpl$updateCamera2ConfigAsync$1$1 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super Q<? extends t>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9962a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UseCaseCameraRequestControlImpl f9963b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Config f9964c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f9965d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UseCaseCameraRequestControlImpl$updateCamera2ConfigAsync$1$1(UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl, Config config, Map<String, ? extends Object> map, InterfaceC4014c<? super UseCaseCameraRequestControlImpl$updateCamera2ConfigAsync$1$1> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.f9963b = useCaseCameraRequestControlImpl;
        this.f9964c = config;
        this.f9965d = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new UseCaseCameraRequestControlImpl$updateCamera2ConfigAsync$1$1(this.f9963b, this.f9964c, this.f9965d, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(InterfaceC4014c<? super Q<t>> interfaceC4014c) {
        return ((UseCaseCameraRequestControlImpl$updateCamera2ConfigAsync$1$1) create(interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f9962a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "UseCaseCameraRequestControlImpl#updateCamera2ConfigAsync");
        }
        this.f9963b.infoBundleMap.put(UseCaseCameraRequestControl.Type.CAMERA2_CAMERA_CONTROL, new UseCaseCameraRequestControlImpl.InfoBundle(UseCaseCameraRequestControlImpl.INSTANCE.c(this.f9964c), kotlin.collections.a.C(this.f9965d), null, null, 12, null));
        UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl = this.f9963b;
        UseCaseCameraRequestControlImpl.InfoBundle infoBundleI = useCaseCameraRequestControlImpl.I(useCaseCameraRequestControlImpl.infoBundleMap);
        this.f9962a = 1;
        Object objO = UseCaseCameraRequestControlImpl.O(useCaseCameraRequestControlImpl, infoBundleI, null, this, 1, null);
        return objO == objG ? objG : objO;
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ Object invoke(InterfaceC4014c<? super Q<? extends t>> interfaceC4014c) {
        return invoke2((InterfaceC4014c<? super Q<t>>) interfaceC4014c);
    }
}
