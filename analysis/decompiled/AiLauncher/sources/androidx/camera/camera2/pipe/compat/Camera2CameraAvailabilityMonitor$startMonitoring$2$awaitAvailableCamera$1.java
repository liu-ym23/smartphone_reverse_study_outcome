package androidx.camera.camera2.pipe.compat;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.Camera2CameraAvailabilityMonitor$startMonitoring$2", f = "RetryingCameraStateOpener.kt", l = {184}, m = "awaitAvailableCamera", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f10259a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10260b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraAvailabilityMonitor$startMonitoring$2 f10261c;

    /* renamed from: d, reason: collision with root package name */
    public int f10262d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1(Camera2CameraAvailabilityMonitor$startMonitoring$2 camera2CameraAvailabilityMonitor$startMonitoring$2, InterfaceC4014c<? super Camera2CameraAvailabilityMonitor$startMonitoring$2$awaitAvailableCamera$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f10261c = camera2CameraAvailabilityMonitor$startMonitoring$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10260b = obj;
        this.f10262d |= Integer.MIN_VALUE;
        return this.f10261c.c0(0L, this);
    }
}
