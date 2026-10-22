package androidx.camera.camera2.pipe.compat;

import Ua.M;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import x.AbstractC5824k0;
import x.CameraStateOpen;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.VirtualCameraState$connect$2$1", f = "VirtualCamera.kt", l = {177}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class VirtualCameraState$connect$2$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10616a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Xa.b<AbstractC5824k0> f10617b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ VirtualCameraState f10618c;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class a<T> implements Xa.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VirtualCameraState f10619a;

        public a(VirtualCameraState virtualCameraState) {
            this.f10619a = virtualCameraState;
        }

        @Override // Xa.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(AbstractC5824k0 abstractC5824k0, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            Object obj = this.f10619a.lock;
            VirtualCameraState virtualCameraState = this.f10619a;
            synchronized (obj) {
                try {
                    if (abstractC5824k0 instanceof CameraStateOpen) {
                        p cameraDevice = ((CameraStateOpen) abstractC5824k0).getCameraDevice();
                        kotlin.jvm.internal.p.g(cameraDevice, "null cannot be cast to non-null type androidx.camera.camera2.pipe.compat.AndroidCameraDevice");
                        w wVar = new w((AndroidCameraDevice) cameraDevice);
                        virtualCameraState.currentVirtualAndroidCamera = wVar;
                        virtualCameraState.g(new CameraStateOpen(wVar));
                    } else {
                        virtualCameraState.g(abstractC5824k0);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VirtualCameraState$connect$2$1(Xa.b<? extends AbstractC5824k0> bVar, VirtualCameraState virtualCameraState, InterfaceC4014c<? super VirtualCameraState$connect$2$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10617b = bVar;
        this.f10618c = virtualCameraState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new VirtualCameraState$connect$2$1(this.f10617b, this.f10618c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((VirtualCameraState$connect$2$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f10616a;
        if (i10 == 0) {
            C4849c.b(obj);
            Xa.b<AbstractC5824k0> bVar = this.f10617b;
            a aVar = new a(this.f10618c);
            this.f10616a = 1;
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
