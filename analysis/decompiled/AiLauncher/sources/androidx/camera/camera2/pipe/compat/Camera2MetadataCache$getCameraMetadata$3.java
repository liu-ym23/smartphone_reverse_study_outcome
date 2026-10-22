package androidx.camera.camera2.pipe.compat;

import Ua.M;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Landroidx/camera/camera2/pipe/g;", "<anonymous>", "(LUa/M;)Landroidx/camera/camera2/pipe/g;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.Camera2MetadataCache$getCameraMetadata$3", f = "Camera2MetadataCache.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class Camera2MetadataCache$getCameraMetadata$3 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super androidx.camera.camera2.pipe.g>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10406a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Camera2MetadataCache f10407b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f10408c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Camera2MetadataCache$getCameraMetadata$3(Camera2MetadataCache camera2MetadataCache, String str, InterfaceC4014c<? super Camera2MetadataCache$getCameraMetadata$3> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10407b = camera2MetadataCache;
        this.f10408c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new Camera2MetadataCache$getCameraMetadata$3(this.f10407b, this.f10408c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super androidx.camera.camera2.pipe.g> interfaceC4014c) {
        return ((Camera2MetadataCache$getCameraMetadata$3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.f10406a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        return this.f10407b.a(this.f10408c);
    }
}
