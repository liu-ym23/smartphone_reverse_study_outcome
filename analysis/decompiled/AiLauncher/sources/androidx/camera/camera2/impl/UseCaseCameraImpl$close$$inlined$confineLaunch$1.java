package androidx.camera.camera2.impl;

import D.C0761b0;
import K.z0;
import Ua.M;
import Ua.Q;
import Y8.t;
import android.util.Log;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import t.C5473b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.UseCaseCameraImpl$close$$inlined$confineLaunch$1", f = "UseCaseCamera.kt", l = {208}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class UseCaseCameraImpl$close$$inlined$confineLaunch$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9898a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UseCaseCameraImpl f9899b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UseCaseCameraImpl$close$$inlined$confineLaunch$1(InterfaceC4014c interfaceC4014c, UseCaseCameraImpl useCaseCameraImpl) {
        super(2, interfaceC4014c);
        this.f9899b = useCaseCameraImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new UseCaseCameraImpl$close$$inlined$confineLaunch$1(interfaceC4014c, this.f9899b);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((UseCaseCameraImpl$close$$inlined$confineLaunch$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Exception {
        Object objG = C4063a.g();
        int i10 = this.f9898a;
        if (i10 == 0) {
            C4849c.b(obj);
            C5473b c5473b = C5473b.f41865a;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "Closing " + this.f9899b);
            }
            z0 z0Var = this.f9899b.sessionProcessor;
            if (z0Var != null) {
                z0Var.d(null);
            }
            this.f9899b.useCaseGraphContext.d();
            Q<t> qR = this.f9899b.s().r();
            this.f9898a = 1;
            if (qR.a1(this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return t.f7040a;
    }
}
