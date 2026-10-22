package androidx.camera.camera2.pipe.compat;

import Ua.M;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.util.Log;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import w.C5706l;
import w.C5708n;
import x.Z;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lx/Z;", "<anonymous>", "(LUa/M;)Lx/Z;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.Camera2DeviceCache$getOrInitializeDeviceSetupWrapper$deferred$1$1$1", f = "Camera2DeviceCache.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class Camera2DeviceCache$getOrInitializeDeviceSetupWrapper$deferred$1$1$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Z>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10384a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f10385b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Camera2DeviceCache f10386c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Camera2DeviceCache$getOrInitializeDeviceSetupWrapper$deferred$1$1$1(String str, Camera2DeviceCache camera2DeviceCache, InterfaceC4014c<? super Camera2DeviceCache$getOrInitializeDeviceSetupWrapper$deferred$1$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10385b = str;
        this.f10386c = camera2DeviceCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new Camera2DeviceCache$getOrInitializeDeviceSetupWrapper$deferred$1$1$1(this.f10385b, this.f10386c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Z> interfaceC4014c) {
        return ((Camera2DeviceCache$getOrInitializeDeviceSetupWrapper$deferred$1$1$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Exception {
        Boolean boolA;
        CameraDevice.CameraDeviceSetup cameraDeviceSetup;
        C4063a.g();
        if (this.f10384a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        String str = this.f10385b;
        B.c cVar = this.f10386c.cameraErrorListener;
        try {
            boolA = C4109a.a(((CameraManager) this.f10386c.cameraManager.get()).isCameraDeviceSetupSupported(this.f10385b));
        } catch (Exception e10) {
            if (e10 instanceof CameraAccessException) {
                if (z.k.f44508a.d()) {
                    Log.w("CXCP", "Failed to execute call: Camera encountered an error: " + e10.getMessage());
                }
                cVar.a(str, C5706l.INSTANCE.b((CameraAccessException) e10), true);
            } else if ((e10 instanceof IllegalArgumentException) || (e10 instanceof SecurityException) || (e10 instanceof UnsupportedOperationException) || (e10 instanceof NullPointerException)) {
                if (z.k.f44508a.d()) {
                    Log.w("CXCP", "Failed to execute call: Unexpected exception: " + e10.getMessage());
                }
                cVar.a(str, C5706l.INSTANCE.m(), false);
            } else {
                if (!(e10 instanceof IllegalStateException)) {
                    throw e10;
                }
                if (z.k.f44508a.a()) {
                    Log.d("CXCP", "Failed to execute call: Camera may be closed");
                }
            }
            boolA = null;
        }
        if (!kotlin.jvm.internal.p.d(boolA, C4109a.a(true))) {
            return null;
        }
        z.k kVar = z.k.f44508a;
        String str2 = this.f10385b;
        if (kVar.a()) {
            Log.d("CXCP", "Initializing CameraDeviceSetup for " + ((Object) C5708n.f(str2)));
        }
        String str3 = this.f10385b;
        B.c cVar2 = this.f10386c.cameraErrorListener;
        try {
            cameraDeviceSetup = ((CameraManager) this.f10386c.cameraManager.get()).getCameraDeviceSetup(this.f10385b);
        } catch (Exception e11) {
            if (e11 instanceof CameraAccessException) {
                if (z.k.f44508a.d()) {
                    Log.w("CXCP", "Failed to execute call: Camera encountered an error: " + e11.getMessage());
                }
                cVar2.a(str3, C5706l.INSTANCE.b((CameraAccessException) e11), true);
            } else if ((e11 instanceof IllegalArgumentException) || (e11 instanceof SecurityException) || (e11 instanceof UnsupportedOperationException) || (e11 instanceof NullPointerException)) {
                if (z.k.f44508a.d()) {
                    Log.w("CXCP", "Failed to execute call: Unexpected exception: " + e11.getMessage());
                }
                cVar2.a(str3, C5706l.INSTANCE.m(), false);
            } else {
                if (!(e11 instanceof IllegalStateException)) {
                    throw e11;
                }
                if (z.k.f44508a.a()) {
                    Log.d("CXCP", "Failed to execute call: Camera may be closed");
                }
            }
            cameraDeviceSetup = null;
        }
        if (cameraDeviceSetup != null) {
            return new Z(cameraDeviceSetup, this.f10385b, this.f10386c.cameraErrorListener, null);
        }
        return null;
    }
}
