package androidx.camera.camera2.pipe.compat;

import B.f;
import android.hardware.camera2.CameraManager;
import android.util.Log;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.a;
import p9.InterfaceC5063a;
import w.C5708n;
import x.C5823k;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LWa/p;", "LB/f$a;", "LY8/t;", "<anonymous>", "(LWa/p;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.Camera2CameraStatusMonitor$cameraStatusFlow$1", f = "Camera2CameraStatusMonitor.kt", l = {114}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class Camera2CameraStatusMonitor$cameraStatusFlow$1 extends SuspendLambda implements p9.p<Wa.p<? super f.a>, InterfaceC4014c<? super Y8.t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10328a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10329b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraStatusMonitor f10330c;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"androidx/camera/camera2/pipe/compat/Camera2CameraStatusMonitor$cameraStatusFlow$1$a", "Landroid/hardware/camera2/CameraManager$AvailabilityCallback;", "LY8/t;", "onCameraAccessPrioritiesChanged", "()V", "", "cameraId", "onCameraAvailable", "(Ljava/lang/String;)V", "onCameraUnavailable", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends CameraManager.AvailabilityCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Wa.p<f.a> f10331a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Camera2CameraStatusMonitor f10332b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Wa.p<? super f.a> pVar, Camera2CameraStatusMonitor camera2CameraStatusMonitor) {
            this.f10331a = pVar;
            this.f10332b = camera2CameraStatusMonitor;
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAccessPrioritiesChanged() {
            z.k kVar = z.k.f44508a;
            if (kVar.a()) {
                Log.d("CXCP", "Camera access priorities have changed");
            }
            Object objB = Wa.l.b(this.f10331a, f.a.b.f1400a);
            if (objB instanceof a.c) {
                kotlinx.coroutines.channels.a.e(objB);
                if (kVar.d()) {
                    Log.w("CXCP", "Failed to emit CameraPrioritiesChanged");
                }
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(String cameraId) {
            kotlin.jvm.internal.p.i(cameraId, "cameraId");
            if (kotlin.jvm.internal.p.d(cameraId, this.f10332b.cameraId)) {
                z.k kVar = z.k.f44508a;
                if (kVar.a()) {
                    Log.d("CXCP", "Camera " + cameraId + " has become available");
                }
                Object objB = Wa.l.b(this.f10331a, new f.a.CameraAvailable(C5708n.b(cameraId), null));
                if (objB instanceof a.c) {
                    kotlinx.coroutines.channels.a.e(objB);
                    if (kVar.d()) {
                        Log.w("CXCP", "Failed to emit CameraAvailable(" + cameraId + ')');
                    }
                }
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraUnavailable(String cameraId) {
            kotlin.jvm.internal.p.i(cameraId, "cameraId");
            if (kotlin.jvm.internal.p.d(cameraId, this.f10332b.cameraId)) {
                z.k kVar = z.k.f44508a;
                if (kVar.a()) {
                    Log.d("CXCP", "Camera " + cameraId + " has become unavailable");
                }
                Object objB = Wa.l.b(this.f10331a, new f.a.CameraUnavailable(C5708n.b(cameraId), null));
                if (objB instanceof a.c) {
                    kotlinx.coroutines.channels.a.e(objB);
                    if (kVar.d()) {
                        Log.w("CXCP", "Failed to emit CameraUnavailable(" + cameraId + ')');
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Camera2CameraStatusMonitor$cameraStatusFlow$1(Camera2CameraStatusMonitor camera2CameraStatusMonitor, InterfaceC4014c<? super Camera2CameraStatusMonitor$cameraStatusFlow$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10330c = camera2CameraStatusMonitor;
    }

    public static final Y8.t h(Camera2CameraStatusMonitor camera2CameraStatusMonitor, a aVar) {
        camera2CameraStatusMonitor.manager.unregisterAvailabilityCallback(aVar);
        return Y8.t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        Camera2CameraStatusMonitor$cameraStatusFlow$1 camera2CameraStatusMonitor$cameraStatusFlow$1 = new Camera2CameraStatusMonitor$cameraStatusFlow$1(this.f10330c, interfaceC4014c);
        camera2CameraStatusMonitor$cameraStatusFlow$1.f10329b = obj;
        return camera2CameraStatusMonitor$cameraStatusFlow$1;
    }

    @Override // p9.p
    public final Object invoke(Wa.p<? super f.a> pVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((Camera2CameraStatusMonitor$cameraStatusFlow$1) create(pVar, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f10328a;
        if (i10 == 0) {
            C4849c.b(obj);
            Wa.p pVar = (Wa.p) this.f10329b;
            final a aVar = new a(pVar, this.f10330c);
            CameraManager cameraManager = this.f10330c.manager;
            kotlin.jvm.internal.p.h(cameraManager, "access$getManager$p(...)");
            C5823k.h(cameraManager, this.f10330c.threads.getLightweightExecutor(), aVar);
            final Camera2CameraStatusMonitor camera2CameraStatusMonitor = this.f10330c;
            InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: androidx.camera.camera2.pipe.compat.l
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Camera2CameraStatusMonitor$cameraStatusFlow$1.h(camera2CameraStatusMonitor, aVar);
                }
            };
            this.f10328a = 1;
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
