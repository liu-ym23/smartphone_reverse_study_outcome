package androidx.camera.camera2.impl;

import D.C0761b0;
import Ua.M;
import Y8.t;
import android.util.Log;
import androidx.camera.camera2.adapter.SessionConfigAdapter;
import androidx.camera.camera2.impl.UseCaseCameraImpl;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.core.impl.DeferrableSurface;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import t.C5473b;
import w.Q;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.UseCaseCameraImpl$start$$inlined$confineLaunch$1", f = "UseCaseCamera.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class UseCaseCameraImpl$start$$inlined$confineLaunch$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9903a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UseCaseCameraImpl f9904b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UseCaseCameraImpl$start$$inlined$confineLaunch$1(InterfaceC4014c interfaceC4014c, UseCaseCameraImpl useCaseCameraImpl) {
        super(2, interfaceC4014c);
        this.f9904b = useCaseCameraImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new UseCaseCameraImpl$start$$inlined$confineLaunch$1(interfaceC4014c, this.f9904b);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((UseCaseCameraImpl$start$$inlined$confineLaunch$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f9903a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        if (this.f9904b.closed.b()) {
            C5473b c5473b = C5473b.f41865a;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "UseCaseCamera is closed before starting the CameraGraph, skipping setup.");
            }
        } else {
            CameraGraph cameraGraphF = this.f9904b.useCaseGraphContext.f();
            this.f9904b.useCaseGraphContext.e();
            cameraGraphF.start();
            Map<DeferrableSurface, Q> mapH = this.f9904b.useCaseGraphContext.h();
            Q qP = this.f9904b.p();
            C5473b c5473b2 = C5473b.f41865a;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "Setting up Surfaces with UseCaseSurfaceManager");
            }
            if (this.f9904b.r().p()) {
                UseCaseSurfaceManager useCaseSurfaceManagerS = this.f9904b.s();
                kotlin.jvm.internal.p.h(useCaseSurfaceManagerS, "access$getUseCaseSurfaceManager(...)");
                SessionConfigAdapter sessionConfigAdapterR = this.f9904b.r();
                kotlin.jvm.internal.p.h(sessionConfigAdapterR, "access$getSessionConfigAdapter(...)");
                UseCaseSurfaceManager.p(useCaseSurfaceManagerS, cameraGraphF, sessionConfigAdapterR, mapH, 0L, 8, null).J(UseCaseCameraImpl.b.f9908a);
            } else if (C0761b0.g("CXCP")) {
                Log.e(C5473b.TRUNCATED_TAG, "Unable to create capture session due to conflicting configurations");
            }
            this.f9904b.u(qP, cameraGraphF);
        }
        return t.f7040a;
    }
}
