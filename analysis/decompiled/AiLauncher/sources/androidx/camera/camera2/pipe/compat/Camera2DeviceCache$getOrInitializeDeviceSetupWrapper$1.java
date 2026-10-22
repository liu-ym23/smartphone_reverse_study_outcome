package androidx.camera.camera2.pipe.compat;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.Camera2DeviceCache", f = "Camera2DeviceCache.kt", l = {169}, m = "getOrInitializeDeviceSetupWrapper-0r8Bogc", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f10379a;

    /* renamed from: b, reason: collision with root package name */
    public Object f10380b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f10381c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Camera2DeviceCache f10382d;

    /* renamed from: e, reason: collision with root package name */
    public int f10383e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1(Camera2DeviceCache camera2DeviceCache, InterfaceC4014c<? super Camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f10382d = camera2DeviceCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10381c = obj;
        this.f10383e |= Integer.MIN_VALUE;
        return this.f10382d.v(null, this);
    }
}
