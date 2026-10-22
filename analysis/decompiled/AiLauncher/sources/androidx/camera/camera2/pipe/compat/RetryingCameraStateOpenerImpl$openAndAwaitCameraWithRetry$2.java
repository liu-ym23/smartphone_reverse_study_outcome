package androidx.camera.camera2.pipe.compat;

import Ua.M;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import x.AwaitOpenCameraResult;
import x.W;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lx/x;", "<anonymous>", "(LUa/M;)Lx/x;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.pipe.compat.RetryingCameraStateOpenerImpl$openAndAwaitCameraWithRetry$2", f = "RetryingCameraStateOpener.kt", l = {497, 503}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class RetryingCameraStateOpenerImpl$openAndAwaitCameraWithRetry$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super AwaitOpenCameraResult>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f10582a;

    /* renamed from: b, reason: collision with root package name */
    public int f10583b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RetryingCameraStateOpenerImpl f10584c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f10585d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ W f10586e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetryingCameraStateOpenerImpl$openAndAwaitCameraWithRetry$2(RetryingCameraStateOpenerImpl retryingCameraStateOpenerImpl, String str, W w10, InterfaceC4014c<? super RetryingCameraStateOpenerImpl$openAndAwaitCameraWithRetry$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f10584c = retryingCameraStateOpenerImpl;
        this.f10585d = str;
        this.f10586e = w10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new RetryingCameraStateOpenerImpl$openAndAwaitCameraWithRetry$2(this.f10584c, this.f10585d, this.f10586e, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super AwaitOpenCameraResult> interfaceC4014c) {
        return ((RetryingCameraStateOpenerImpl$openAndAwaitCameraWithRetry$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0085, code lost:
    
        if (r1 == r7) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            r13 = this;
            java.lang.Object r7 = f9.C4063a.g()
            int r0 = r13.f10583b
            r8 = 33
            java.lang.String r9 = "Failed to open "
            r10 = 2
            r1 = 1
            java.lang.String r11 = "CXCP"
            r12 = 0
            if (r0 == 0) goto L2b
            if (r0 == r1) goto L26
            if (r0 != r10) goto L1e
            java.lang.Object r0 = r13.f10582a
            androidx.camera.camera2.pipe.compat.AndroidCameraState r0 = (androidx.camera.camera2.pipe.compat.AndroidCameraState) r0
            kotlin.C4849c.b(r14)
            r1 = r14
            goto L88
        L1e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L26:
            kotlin.C4849c.b(r14)
            r0 = r14
            goto L43
        L2b:
            kotlin.C4849c.b(r14)
            androidx.camera.camera2.pipe.compat.RetryingCameraStateOpenerImpl r0 = r13.f10584c
            java.lang.String r2 = r13.f10585d
            r3 = r2
            x.W r2 = r13.f10586e
            r13.f10583b = r1
            r1 = r3
            r3 = 0
            r5 = 4
            r6 = 0
            r4 = r13
            java.lang.Object r0 = x.G0.d(r0, r1, r2, r3, r4, r5, r6)
            if (r0 != r7) goto L43
            goto L87
        L43:
            x.v0 r0 = (x.OpenCameraResult) r0
            androidx.camera.camera2.pipe.compat.AndroidCameraState r0 = r0.getCameraState()
            if (r0 != 0) goto L74
            z.k r0 = z.k.f44508a
            java.lang.String r1 = r13.f10585d
            boolean r0 = r0.b()
            if (r0 == 0) goto L6e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r9)
            java.lang.String r1 = w.C5708n.f(r1)
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r11, r0)
        L6e:
            x.x r0 = new x.x
            r0.<init>(r12, r12)
            return r0
        L74:
            Xa.t r1 = r0.l()
            androidx.camera.camera2.pipe.compat.RetryingCameraStateOpenerImpl$openAndAwaitCameraWithRetry$2$cameraState$1 r2 = new androidx.camera.camera2.pipe.compat.RetryingCameraStateOpenerImpl$openAndAwaitCameraWithRetry$2$cameraState$1
            r2.<init>(r12)
            r13.f10582a = r0
            r13.f10583b = r10
            java.lang.Object r1 = Xa.d.z(r1, r2, r13)
            if (r1 != r7) goto L88
        L87:
            return r7
        L88:
            x.k0 r1 = (x.AbstractC5824k0) r1
            boolean r2 = r1 instanceof x.CameraStateOpen
            if (r2 == 0) goto Lbc
            z.k r2 = z.k.f44508a
            java.lang.String r3 = r13.f10585d
            boolean r2 = r2.c()
            if (r2 == 0) goto Lb0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = w.C5708n.f(r3)
            r2.append(r3)
            java.lang.String r3 = " opened successfully."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.i(r11, r2)
        Lb0:
            x.x r2 = new x.x
            x.n0 r1 = (x.CameraStateOpen) r1
            androidx.camera.camera2.pipe.compat.p r1 = r1.getCameraDevice()
            r2.<init>(r1, r0)
            return r2
        Lbc:
            z.k r0 = z.k.f44508a
            java.lang.String r1 = r13.f10585d
            boolean r0 = r0.b()
            if (r0 == 0) goto Ldf
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r9)
            java.lang.String r1 = w.C5708n.f(r1)
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r11, r0)
        Ldf:
            x.x r0 = new x.x
            r0.<init>(r12, r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.RetryingCameraStateOpenerImpl$openAndAwaitCameraWithRetry$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
