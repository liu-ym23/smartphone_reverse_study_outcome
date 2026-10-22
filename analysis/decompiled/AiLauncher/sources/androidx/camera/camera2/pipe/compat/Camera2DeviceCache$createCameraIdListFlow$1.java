package androidx.camera.camera2.pipe.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.channels.ProduceKt;
import p9.InterfaceC5063a;
import w.C5708n;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LWa/p;", "", "Lw/n;", "LY8/t;", "<anonymous>", "(LWa/p;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.Camera2DeviceCache$createCameraIdListFlow$1", f = "Camera2DeviceCache.kt", l = {235}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class Camera2DeviceCache$createCameraIdListFlow$1 extends SuspendLambda implements p9.p<Wa.p<? super List<? extends C5708n>>, InterfaceC4014c<? super Y8.t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10366a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10367b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Camera2DeviceCache f10368c;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"androidx/camera/camera2/pipe/compat/Camera2DeviceCache$createCameraIdListFlow$1$a", "Landroid/hardware/camera2/CameraManager$AvailabilityCallback;", "", "cameraId", "LY8/t;", "onCameraAvailable", "(Ljava/lang/String;)V", "onCameraUnavailable", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends CameraManager.AvailabilityCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Camera2DeviceCache f10369a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Wa.p<List<C5708n>> f10370b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Camera2DeviceCache camera2DeviceCache, Wa.p<? super List<C5708n>> pVar) {
            this.f10369a = camera2DeviceCache;
            this.f10370b = pVar;
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(String cameraId) throws CameraAccessException {
            kotlin.jvm.internal.p.i(cameraId, "cameraId");
            this.f10369a.y(this.f10370b, cameraId, true);
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraUnavailable(String cameraId) throws CameraAccessException {
            kotlin.jvm.internal.p.i(cameraId, "cameraId");
            this.f10369a.y(this.f10370b, cameraId, false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Camera2DeviceCache$createCameraIdListFlow$1(Camera2DeviceCache camera2DeviceCache, InterfaceC4014c<? super Camera2DeviceCache$createCameraIdListFlow$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10368c = camera2DeviceCache;
    }

    public static final Y8.t h(CameraManager cameraManager, a aVar) {
        cameraManager.unregisterAvailabilityCallback(aVar);
        return Y8.t.f7040a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        Camera2DeviceCache$createCameraIdListFlow$1 camera2DeviceCache$createCameraIdListFlow$1 = new Camera2DeviceCache$createCameraIdListFlow$1(this.f10368c, interfaceC4014c);
        camera2DeviceCache$createCameraIdListFlow$1.f10367b = obj;
        return camera2DeviceCache$createCameraIdListFlow$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Wa.p<? super List<C5708n>> pVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((Camera2DeviceCache$createCameraIdListFlow$1) create(pVar, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List list;
        Object objG = C4063a.g();
        int i10 = this.f10366a;
        if (i10 == 0) {
            C4849c.b(obj);
            Wa.p pVar = (Wa.p) this.f10367b;
            final a aVar = new a(this.f10368c, pVar);
            final CameraManager cameraManager = (CameraManager) this.f10368c.cameraManager.get();
            cameraManager.registerAvailabilityCallback(aVar, this.f10368c.threads.i());
            Object obj2 = this.f10368c.lock;
            Camera2DeviceCache camera2DeviceCache = this.f10368c;
            synchronized (obj2) {
                list = camera2DeviceCache.openableCameras;
            }
            if (list != null) {
                this.f10368c.A(pVar, list);
            } else {
                List listZ = this.f10368c.z();
                if (listZ != null) {
                    this.f10368c.A(pVar, listZ);
                }
            }
            InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: androidx.camera.camera2.pipe.compat.m
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Camera2DeviceCache$createCameraIdListFlow$1.h(cameraManager, aVar);
                }
            };
            this.f10366a = 1;
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

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(Wa.p<? super List<? extends C5708n>> pVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return invoke2((Wa.p<? super List<C5708n>>) pVar, interfaceC4014c);
    }
}
