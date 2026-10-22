package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraManager;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.channels.ProduceKt;
import p9.InterfaceC5063a;
import w.C5708n;
import x.C5823k;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LWa/p;", "Lw/n;", "LY8/t;", "<anonymous>", "(LWa/p;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.Camera2CameraAvailabilityMonitor$availableCameraFlow$1", f = "RetryingCameraStateOpener.kt", l = {158}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class Camera2CameraAvailabilityMonitor$availableCameraFlow$1 extends SuspendLambda implements p9.p<Wa.p<? super C5708n>, InterfaceC4014c<? super Y8.t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10247a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10248b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraAvailabilityMonitor f10249c;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"androidx/camera/camera2/pipe/compat/Camera2CameraAvailabilityMonitor$availableCameraFlow$1$a", "Landroid/hardware/camera2/CameraManager$AvailabilityCallback;", "", "cameraIdString", "LY8/t;", "onCameraAvailable", "(Ljava/lang/String;)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends CameraManager.AvailabilityCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Wa.p<C5708n> f10250a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Wa.p<? super C5708n> pVar) {
            this.f10250a = pVar;
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(String cameraIdString) {
            kotlin.jvm.internal.p.i(cameraIdString, "cameraIdString");
            Wa.l.b(this.f10250a, C5708n.a(C5708n.b(cameraIdString)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Camera2CameraAvailabilityMonitor$availableCameraFlow$1(Camera2CameraAvailabilityMonitor camera2CameraAvailabilityMonitor, InterfaceC4014c<? super Camera2CameraAvailabilityMonitor$availableCameraFlow$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10249c = camera2CameraAvailabilityMonitor;
    }

    public static final Y8.t h(CameraManager cameraManager, a aVar) {
        cameraManager.unregisterAvailabilityCallback(aVar);
        return Y8.t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        Camera2CameraAvailabilityMonitor$availableCameraFlow$1 camera2CameraAvailabilityMonitor$availableCameraFlow$1 = new Camera2CameraAvailabilityMonitor$availableCameraFlow$1(this.f10249c, interfaceC4014c);
        camera2CameraAvailabilityMonitor$availableCameraFlow$1.f10248b = obj;
        return camera2CameraAvailabilityMonitor$availableCameraFlow$1;
    }

    @Override // p9.p
    public final Object invoke(Wa.p<? super C5708n> pVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((Camera2CameraAvailabilityMonitor$availableCameraFlow$1) create(pVar, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f10247a;
        if (i10 == 0) {
            C4849c.b(obj);
            Wa.p pVar = (Wa.p) this.f10248b;
            final a aVar = new a(pVar);
            final CameraManager cameraManager = (CameraManager) this.f10249c.cameraManager.get();
            kotlin.jvm.internal.p.f(cameraManager);
            C5823k.h(cameraManager, this.f10249c.threads.h(), aVar);
            InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: androidx.camera.camera2.pipe.compat.k
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Camera2CameraAvailabilityMonitor$availableCameraFlow$1.h(cameraManager, aVar);
                }
            };
            this.f10247a = 1;
            if (ProduceKt.a(pVar, interfaceC5063a, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return Y8.t.f7040a;
    }
}
