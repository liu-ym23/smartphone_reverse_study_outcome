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
import w.InterfaceC5703i;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.Camera2CameraController$tryRestart$2", f = "Camera2CameraController.kt", l = {181}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class Camera2CameraController$tryRestart$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10314a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f10315b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraController f10316c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Camera2CameraController$tryRestart$2(long j10, Camera2CameraController camera2CameraController, InterfaceC4014c<? super Camera2CameraController$tryRestart$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10315b = j10;
        this.f10316c = camera2CameraController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new Camera2CameraController$tryRestart$2(this.f10315b, this.f10316c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((Camera2CameraController$tryRestart$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f10314a;
        if (i10 == 0) {
            C4849c.b(obj);
            long j10 = this.f10315b;
            this.f10314a = 1;
            if (U.a(j10, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        Object obj2 = this.f10316c.lock;
        Camera2CameraController camera2CameraController = this.f10316c;
        synchronized (obj2) {
            try {
                if (!camera2CameraController.z() && !kotlin.jvm.internal.p.d(camera2CameraController.getControllerState(), InterfaceC5703i.a.g.f43005a) && !kotlin.jvm.internal.p.d(camera2CameraController.getControllerState(), InterfaceC5703i.a.f.f43004a)) {
                    if (z.k.f44508a.a()) {
                        Log.d("CXCP", "Restarting " + camera2CameraController + "...");
                    }
                    camera2CameraController.surfaceTracker.e();
                    camera2CameraController.F();
                    camera2CameraController.D();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return Y8.t.f7040a;
    }
}
