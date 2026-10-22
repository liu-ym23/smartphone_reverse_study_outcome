package androidx.camera.camera2.impl;

import D.C0761b0;
import Ua.Q;
import Y8.t;
import android.util.Log;
import androidx.camera.camera2.pipe.CameraGraph;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.concurrent.CancellationException;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import n9.C4946a;
import p9.InterfaceC5074l;
import t.C5473b;
import w.Result3A;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/Q;", "Lw/N;", "<anonymous>", "()LUa/Q;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.UseCaseCameraRequestControlImpl$setTorchOnAsync$1$1", f = "UseCaseCameraRequestControl.kt", l = {749}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class UseCaseCameraRequestControlImpl$setTorchOnAsync$1$1 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super Q<? extends Result3A>>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9955a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UseCaseCameraRequestControlImpl f9956b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UseCaseCameraRequestControlImpl$setTorchOnAsync$1$1(UseCaseCameraRequestControlImpl useCaseCameraRequestControlImpl, InterfaceC4014c<? super UseCaseCameraRequestControlImpl$setTorchOnAsync$1$1> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.f9956b = useCaseCameraRequestControlImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new UseCaseCameraRequestControlImpl$setTorchOnAsync$1$1(this.f9956b, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(InterfaceC4014c<? super Q<Result3A>> interfaceC4014c) {
        return ((UseCaseCameraRequestControlImpl$setTorchOnAsync$1$1) create(interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Exception {
        Object objG = C4063a.g();
        int i10 = this.f9955a;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                C5473b c5473b = C5473b.f41865a;
                if (C0761b0.f("CXCP")) {
                    Log.d(C5473b.TRUNCATED_TAG, "UseCaseCameraRequestControlImpl#setTorchOnAsync");
                }
                CameraGraph cameraGraphF = this.f9956b.useCaseGraphContext.f();
                this.f9955a = 1;
                obj = cameraGraphF.A0(this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            AutoCloseable autoCloseable = (AutoCloseable) obj;
            try {
                Q<Result3A> qI = ((CameraGraph.f) autoCloseable).i();
                C4946a.a(autoCloseable, null);
                return qI;
            } finally {
            }
        } catch (CancellationException e10) {
            C5473b c5473b2 = C5473b.f41865a;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "Cannot acquire the CameraGraph.Session", e10);
            }
            return UseCaseCameraRequestControlImpl.f9910m;
        }
    }

    @Override // p9.InterfaceC5074l
    public /* bridge */ /* synthetic */ Object invoke(InterfaceC4014c<? super Q<? extends Result3A>> interfaceC4014c) {
        return invoke2((InterfaceC4014c<? super Q<Result3A>>) interfaceC4014c);
    }
}
