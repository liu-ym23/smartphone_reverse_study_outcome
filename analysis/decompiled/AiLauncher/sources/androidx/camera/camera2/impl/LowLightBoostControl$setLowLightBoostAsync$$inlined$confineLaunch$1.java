package androidx.camera.camera2.impl;

import Ua.InterfaceC1083u;
import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.LowLightBoostControl$setLowLightBoostAsync$$inlined$confineLaunch$1", f = "LowLightBoostControl.kt", l = {201}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class LowLightBoostControl$setLowLightBoostAsync$$inlined$confineLaunch$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9806a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LowLightBoostControl f9807b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InterfaceC1083u f9808c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f9809d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f9810e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LowLightBoostControl$setLowLightBoostAsync$$inlined$confineLaunch$1(InterfaceC4014c interfaceC4014c, LowLightBoostControl lowLightBoostControl, InterfaceC1083u interfaceC1083u, boolean z10, boolean z11) {
        super(2, interfaceC4014c);
        this.f9807b = lowLightBoostControl;
        this.f9808c = interfaceC1083u;
        this.f9809d = z10;
        this.f9810e = z11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new LowLightBoostControl$setLowLightBoostAsync$$inlined$confineLaunch$1(interfaceC4014c, this.f9807b, this.f9808c, this.f9809d, this.f9810e);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((LowLightBoostControl$setLowLightBoostAsync$$inlined$confineLaunch$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c0  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r4.f9806a
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L18
            if (r1 != r3) goto L10
            kotlin.C4849c.b(r5)
            goto L2c
        L10:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L18:
            kotlin.C4849c.b(r5)
            androidx.camera.camera2.impl.LowLightBoostControl r5 = r4.f9807b
            Ua.Q r5 = r5.n()
            if (r5 == 0) goto L33
            r4.f9806a = r3
            java.lang.Object r5 = r5.a1(r4)
            if (r5 != r0) goto L2c
            return r0
        L2c:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            goto L34
        L33:
            r5 = r2
        L34:
            r0 = -1
            if (r5 == 0) goto L50
            androidx.camera.camera2.impl.LowLightBoostControl r5 = r4.f9807b
            androidx.lifecycle.y r1 = androidx.camera.camera2.impl.LowLightBoostControl.e(r5)
            androidx.camera.camera2.impl.LowLightBoostControl.i(r5, r1, r0)
            androidx.camera.camera2.impl.LowLightBoostControl r5 = r4.f9807b
            Ua.u r4 = r4.f9808c
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Low Light Boost is disabled when expected frame rate range exceeds 30."
            r0.<init>(r1)
            androidx.camera.camera2.impl.LowLightBoostControl.a(r5, r4, r0)
            goto Ld0
        L50:
            androidx.camera.camera2.impl.LowLightBoostControl r5 = r4.f9807b
            boolean r1 = r4.f9809d
            androidx.camera.camera2.impl.LowLightBoostControl.j(r5, r1)
            boolean r5 = r4.f9809d
            if (r5 != 0) goto L64
            androidx.camera.camera2.impl.LowLightBoostControl r5 = r4.f9807b
            androidx.lifecycle.y r1 = androidx.camera.camera2.impl.LowLightBoostControl.e(r5)
            androidx.camera.camera2.impl.LowLightBoostControl.i(r5, r1, r0)
        L64:
            androidx.camera.camera2.impl.LowLightBoostControl r5 = r4.f9807b
            androidx.camera.camera2.impl.UseCaseCameraRequestControl r5 = r5.get_requestControl()
            if (r5 == 0) goto Lc0
            boolean r5 = r4.f9809d
            if (r5 == 0) goto L79
            androidx.camera.camera2.impl.LowLightBoostControl r5 = r4.f9807b
            androidx.lifecycle.y r0 = androidx.camera.camera2.impl.LowLightBoostControl.e(r5)
            androidx.camera.camera2.impl.LowLightBoostControl.i(r5, r0, r2)
        L79:
            boolean r5 = r4.f9810e
            if (r5 == 0) goto L83
            androidx.camera.camera2.impl.LowLightBoostControl r5 = r4.f9807b
            androidx.camera.camera2.impl.LowLightBoostControl.l(r5)
            goto L90
        L83:
            androidx.camera.camera2.impl.LowLightBoostControl r5 = r4.f9807b
            Ua.u r5 = androidx.camera.camera2.impl.LowLightBoostControl.g(r5)
            if (r5 == 0) goto L90
            Ua.u r0 = r4.f9808c
            androidx.camera.camera2.adapter.CoroutineAdaptersKt.s(r0, r5)
        L90:
            androidx.camera.camera2.impl.LowLightBoostControl r5 = r4.f9807b
            Ua.u r0 = r4.f9808c
            androidx.camera.camera2.impl.LowLightBoostControl.k(r5, r0)
            androidx.camera.camera2.impl.LowLightBoostControl r5 = r4.f9807b
            androidx.camera.camera2.impl.State3AControl r5 = androidx.camera.camera2.impl.LowLightBoostControl.d(r5)
            boolean r0 = r4.f9809d
            if (r0 == 0) goto La7
            r0 = 6
            java.lang.Integer r0 = g9.C4109a.f(r0)
            goto La8
        La7:
            r0 = 0
        La8:
            Ua.Q r5 = r5.s(r0)
            Ua.u r0 = r4.f9808c
            androidx.camera.camera2.adapter.CoroutineAdaptersKt.s(r5, r0)
            Ua.u r5 = r4.f9808c
            androidx.camera.camera2.impl.LowLightBoostControl$b r0 = new androidx.camera.camera2.impl.LowLightBoostControl$b
            androidx.camera.camera2.impl.LowLightBoostControl r1 = r4.f9807b
            r0.<init>(r5, r1)
            Ua.a0 r5 = r5.J(r0)
            if (r5 != 0) goto Ld0
        Lc0:
            androidx.camera.camera2.impl.LowLightBoostControl r5 = r4.f9807b
            Ua.u r4 = r4.f9808c
            androidx.camera.core.CameraControl$OperationCanceledException r0 = new androidx.camera.core.CameraControl$OperationCanceledException
            java.lang.String r1 = "Camera is not active."
            r0.<init>(r1)
            androidx.camera.camera2.impl.LowLightBoostControl.a(r5, r4, r0)
            Y8.t r4 = Y8.t.f7040a
        Ld0:
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.LowLightBoostControl$setLowLightBoostAsync$$inlined$confineLaunch$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
