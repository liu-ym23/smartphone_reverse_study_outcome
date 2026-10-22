package androidx.camera.camera2.pipe.compat;

import B.f;
import Ua.M;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.Camera2CameraStatusMonitor$cameraStatusJob$1", f = "Camera2CameraStatusMonitor.kt", l = {69}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class Camera2CameraStatusMonitor$cameraStatusJob$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10333a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraStatusMonitor f10334b;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class a<T> implements Xa.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Camera2CameraStatusMonitor f10335a;

        public a(Camera2CameraStatusMonitor camera2CameraStatusMonitor) {
            this.f10335a = camera2CameraStatusMonitor;
        }

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(f.a aVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            if (aVar instanceof f.a.CameraAvailable) {
                Object objEmit = this.f10335a._cameraAvailability.emit(aVar, interfaceC4014c);
                return objEmit == C4063a.g() ? objEmit : Y8.t.f7040a;
            }
            if (aVar instanceof f.a.CameraUnavailable) {
                Object objEmit2 = this.f10335a._cameraAvailability.emit(aVar, interfaceC4014c);
                return objEmit2 == C4063a.g() ? objEmit2 : Y8.t.f7040a;
            }
            if (!(aVar instanceof f.a.b)) {
                return Y8.t.f7040a;
            }
            Xa.j jVar = this.f10335a._cameraPriorities;
            Y8.t tVar = Y8.t.f7040a;
            Object objEmit3 = jVar.emit(tVar, interfaceC4014c);
            return objEmit3 == C4063a.g() ? objEmit3 : tVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Camera2CameraStatusMonitor$cameraStatusJob$1(Camera2CameraStatusMonitor camera2CameraStatusMonitor, InterfaceC4014c<? super Camera2CameraStatusMonitor$cameraStatusJob$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10334b = camera2CameraStatusMonitor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new Camera2CameraStatusMonitor$cameraStatusJob$1(this.f10334b, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((Camera2CameraStatusMonitor$cameraStatusJob$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f10333a;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.b bVar = this.f10334b.cameraStatus;
            a aVar = new a(this.f10334b);
            this.f10333a = 1;
            if (bVar.collect(aVar, this) == objG) {
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
