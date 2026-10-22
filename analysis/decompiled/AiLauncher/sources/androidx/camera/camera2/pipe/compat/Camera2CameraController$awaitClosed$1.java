package androidx.camera.camera2.pipe.compat;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.Camera2CameraController", f = "Camera2CameraController.kt", l = {340}, m = "awaitClosed", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Camera2CameraController$awaitClosed$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f10304a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraController f10305b;

    /* renamed from: c, reason: collision with root package name */
    public int f10306c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Camera2CameraController$awaitClosed$1(Camera2CameraController camera2CameraController, InterfaceC4014c<? super Camera2CameraController$awaitClosed$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f10305b = camera2CameraController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10304a = obj;
        this.f10306c |= Integer.MIN_VALUE;
        return this.f10305b.b(this);
    }
}
