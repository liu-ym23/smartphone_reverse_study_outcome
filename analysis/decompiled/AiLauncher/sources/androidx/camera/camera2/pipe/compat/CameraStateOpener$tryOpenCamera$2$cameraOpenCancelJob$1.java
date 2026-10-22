package androidx.camera.camera2.pipe.compat;

import Ua.M;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.CameraStateOpener$tryOpenCamera$2$cameraOpenCancelJob$1", f = "RetryingCameraStateOpener.kt", l = {317, 318}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CameraStateOpener$tryOpenCamera$2$cameraOpenCancelJob$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f10435a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CameraStateOpener f10436b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraStateOpener$tryOpenCamera$2$cameraOpenCancelJob$1(CameraStateOpener cameraStateOpener, InterfaceC4014c<? super CameraStateOpener$tryOpenCamera$2$cameraOpenCancelJob$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10436b = cameraStateOpener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CameraStateOpener$tryOpenCamera$2$cameraOpenCancelJob$1(this.f10436b, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((CameraStateOpener$tryOpenCamera$2$cameraOpenCancelJob$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        if (Ua.U.a(2000, r4) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r4.f10435a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.C4849c.b(r5)
            goto L3b
        L12:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L1a:
            kotlin.C4849c.b(r5)
            goto L30
        L1e:
            kotlin.C4849c.b(r5)
            androidx.camera.camera2.pipe.compat.CameraStateOpener r5 = r4.f10436b
            Ua.u r5 = androidx.camera.camera2.pipe.compat.CameraStateOpener.a(r5)
            r4.f10435a = r3
            java.lang.Object r5 = r5.a1(r4)
            if (r5 != r0) goto L30
            goto L3a
        L30:
            r4.f10435a = r2
            r1 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r4 = Ua.U.a(r1, r4)
            if (r4 != r0) goto L3b
        L3a:
            return r0
        L3b:
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.CameraStateOpener$tryOpenCamera$2$cameraOpenCancelJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
