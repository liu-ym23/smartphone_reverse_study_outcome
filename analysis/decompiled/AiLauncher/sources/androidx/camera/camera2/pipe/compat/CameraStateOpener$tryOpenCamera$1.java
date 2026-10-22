package androidx.camera.camera2.pipe.compat;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.CameraStateOpener", f = "RetryingCameraStateOpener.kt", l = {236, 275}, m = "tryOpenCamera-7pD7j80$camera_camera2_pipe", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CameraStateOpener$tryOpenCamera$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f10418a;

    /* renamed from: b, reason: collision with root package name */
    public Object f10419b;

    /* renamed from: c, reason: collision with root package name */
    public Object f10420c;

    /* renamed from: d, reason: collision with root package name */
    public int f10421d;

    /* renamed from: e, reason: collision with root package name */
    public long f10422e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f10423f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ CameraStateOpener f10424g;

    /* renamed from: h, reason: collision with root package name */
    public int f10425h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraStateOpener$tryOpenCamera$1(CameraStateOpener cameraStateOpener, InterfaceC4014c<? super CameraStateOpener$tryOpenCamera$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f10424g = cameraStateOpener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10423f = obj;
        this.f10425h |= Integer.MIN_VALUE;
        return this.f10424g.d(null, 0, 0L, null, null, this);
    }
}
