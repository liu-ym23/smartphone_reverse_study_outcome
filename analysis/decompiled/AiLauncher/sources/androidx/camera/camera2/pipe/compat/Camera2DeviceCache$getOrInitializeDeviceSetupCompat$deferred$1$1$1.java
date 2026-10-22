package androidx.camera.camera2.pipe.compat;

import Ua.M;
import android.hardware.camera2.CameraAccessException;
import android.util.Log;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import w.C5706l;
import w.C5708n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LZ/e;", "<anonymous>", "(LUa/M;)LZ/e;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.Camera2DeviceCache$getOrInitializeDeviceSetupCompat$deferred$1$1$1", f = "Camera2DeviceCache.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class Camera2DeviceCache$getOrInitializeDeviceSetupCompat$deferred$1$1$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Z.e>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10376a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f10377b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Camera2DeviceCache f10378c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Camera2DeviceCache$getOrInitializeDeviceSetupCompat$deferred$1$1$1(String str, Camera2DeviceCache camera2DeviceCache, InterfaceC4014c<? super Camera2DeviceCache$getOrInitializeDeviceSetupCompat$deferred$1$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10377b = str;
        this.f10378c = camera2DeviceCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new Camera2DeviceCache$getOrInitializeDeviceSetupCompat$deferred$1$1$1(this.f10377b, this.f10378c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Z.e> interfaceC4014c) {
        return ((Camera2DeviceCache$getOrInitializeDeviceSetupCompat$deferred$1$1$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Exception {
        C4063a.g();
        if (this.f10376a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        z.k kVar = z.k.f44508a;
        String str = this.f10377b;
        if (kVar.a()) {
            Log.d("CXCP", "Initializing CameraDeviceSetupCompat for " + ((Object) C5708n.f(str)));
        }
        String str2 = this.f10377b;
        B.c cVar = this.f10378c.cameraErrorListener;
        try {
            return this.f10378c.s().a(this.f10377b);
        } catch (Exception e10) {
            if (e10 instanceof CameraAccessException) {
                if (z.k.f44508a.d()) {
                    Log.w("CXCP", "Failed to execute call: Camera encountered an error: " + e10.getMessage());
                }
                cVar.a(str2, C5706l.INSTANCE.b((CameraAccessException) e10), true);
                return null;
            }
            if (!(e10 instanceof IllegalArgumentException) && !(e10 instanceof SecurityException) && !(e10 instanceof UnsupportedOperationException) && !(e10 instanceof NullPointerException)) {
                if (!(e10 instanceof IllegalStateException)) {
                    throw e10;
                }
                if (!z.k.f44508a.a()) {
                    return null;
                }
                Log.d("CXCP", "Failed to execute call: Camera may be closed");
                return null;
            }
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to execute call: Unexpected exception: " + e10.getMessage());
            }
            cVar.a(str2, C5706l.INSTANCE.m(), false);
            return null;
        }
    }
}
