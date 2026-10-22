package androidx.camera.camera2.impl;

import Ua.M;
import Y8.t;
import androidx.camera.camera2.impl.StillCaptureRequestControl;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.StillCaptureRequestControl$propagateResultOrEnqueueRequest$1$1", f = "StillCaptureRequestControl.kt", l = {183, 222}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class StillCaptureRequestControl$propagateResultOrEnqueueRequest$1$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Object f9858a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9859b;

    /* renamed from: c, reason: collision with root package name */
    public Object f9860c;

    /* renamed from: d, reason: collision with root package name */
    public Object f9861d;

    /* renamed from: e, reason: collision with root package name */
    public int f9862e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ StillCaptureRequestControl f9863f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ UseCaseCameraRequestControl f9864g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ StillCaptureRequestControl.CaptureRequest f9865h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StillCaptureRequestControl$propagateResultOrEnqueueRequest$1$1(StillCaptureRequestControl stillCaptureRequestControl, UseCaseCameraRequestControl useCaseCameraRequestControl, StillCaptureRequestControl.CaptureRequest captureRequest, InterfaceC4014c<? super StillCaptureRequestControl$propagateResultOrEnqueueRequest$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f9863f = stillCaptureRequestControl;
        this.f9864g = useCaseCameraRequestControl;
        this.f9865h = captureRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new StillCaptureRequestControl$propagateResultOrEnqueueRequest$1$1(this.f9863f, this.f9864g, this.f9865h, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((StillCaptureRequestControl$propagateResultOrEnqueueRequest$1$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0077 A[PHI: r6
      0x0077: PHI (r6v1 kotlin.jvm.internal.Ref$BooleanRef) = 
      (r6v0 kotlin.jvm.internal.Ref$BooleanRef)
      (r6v0 kotlin.jvm.internal.Ref$BooleanRef)
      (r6v2 kotlin.jvm.internal.Ref$BooleanRef)
     binds: [B:11:0x004c, B:13:0x0058, B:18:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ae  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r8.f9862e
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L3c
            if (r1 == r3) goto L28
            if (r1 != r2) goto L20
            java.lang.Object r0 = r8.f9860c
            androidx.camera.camera2.impl.StillCaptureRequestControl$a r0 = (androidx.camera.camera2.impl.StillCaptureRequestControl.CaptureRequest) r0
            java.lang.Object r1 = r8.f9859b
            androidx.camera.camera2.impl.StillCaptureRequestControl r1 = (androidx.camera.camera2.impl.StillCaptureRequestControl) r1
            java.lang.Object r2 = r8.f9858a
            eb.a r2 = (eb.InterfaceC4021a) r2
            kotlin.C4849c.b(r9)
            goto L98
        L20:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L28:
            java.lang.Object r1 = r8.f9861d
            androidx.camera.camera2.impl.StillCaptureRequestControl r1 = (androidx.camera.camera2.impl.StillCaptureRequestControl) r1
            java.lang.Object r3 = r8.f9860c
            androidx.camera.camera2.impl.UseCaseCameraRequestControl r3 = (androidx.camera.camera2.impl.UseCaseCameraRequestControl) r3
            java.lang.Object r5 = r8.f9859b
            androidx.camera.camera2.impl.StillCaptureRequestControl$a r5 = (androidx.camera.camera2.impl.StillCaptureRequestControl.CaptureRequest) r5
            java.lang.Object r6 = r8.f9858a
            kotlin.jvm.internal.Ref$BooleanRef r6 = (kotlin.jvm.internal.Ref$BooleanRef) r6
            kotlin.C4849c.b(r9)
            goto L6f
        L3c:
            kotlin.C4849c.b(r9)
            kotlin.jvm.internal.Ref$BooleanRef r6 = new kotlin.jvm.internal.Ref$BooleanRef
            r6.<init>()
            r6.f34815a = r3
            androidx.camera.camera2.impl.StillCaptureRequestControl r9 = r8.f9863f
            androidx.camera.camera2.impl.UseCaseCameraRequestControl r9 = r9.get_requestControl()
            if (r9 == 0) goto L77
            androidx.camera.camera2.impl.UseCaseCameraRequestControl r1 = r8.f9864g
            androidx.camera.camera2.impl.StillCaptureRequestControl r5 = r8.f9863f
            androidx.camera.camera2.impl.StillCaptureRequestControl$a r7 = r8.f9865h
            boolean r1 = kotlin.jvm.internal.p.d(r1, r9)
            if (r1 != 0) goto L77
            r8.f9858a = r6
            r8.f9859b = r7
            r8.f9860c = r9
            r8.f9861d = r5
            r8.f9862e = r3
            java.lang.Object r1 = androidx.camera.camera2.impl.StillCaptureRequestControl.f(r5, r7, r9, r8)
            if (r1 != r0) goto L6b
            goto L95
        L6b:
            r3 = r9
            r9 = r1
            r1 = r5
            r5 = r7
        L6f:
            Ua.Q r9 = (Ua.Q) r9
            androidx.camera.camera2.impl.StillCaptureRequestControl.e(r1, r9, r5, r3)
            r9 = 0
            r6.f34815a = r9
        L77:
            boolean r9 = r6.f34815a
            if (r9 == 0) goto Ld1
            androidx.camera.camera2.impl.StillCaptureRequestControl r9 = r8.f9863f
            eb.a r9 = androidx.camera.camera2.impl.StillCaptureRequestControl.c(r9)
            androidx.camera.camera2.impl.StillCaptureRequestControl r1 = r8.f9863f
            androidx.camera.camera2.impl.StillCaptureRequestControl$a r3 = r8.f9865h
            r8.f9858a = r9
            r8.f9859b = r1
            r8.f9860c = r3
            r8.f9861d = r4
            r8.f9862e = r2
            java.lang.Object r2 = r9.m(r4, r8)
            if (r2 != r0) goto L96
        L95:
            return r0
        L96:
            r2 = r9
            r0 = r3
        L98:
            java.util.LinkedList r9 = androidx.camera.camera2.impl.StillCaptureRequestControl.d(r1)     // Catch: java.lang.Throwable -> Lcc
            r9.add(r0)     // Catch: java.lang.Throwable -> Lcc
            r2.l(r4)
            t.b r9 = t.C5473b.f41865a
            androidx.camera.camera2.impl.StillCaptureRequestControl$a r8 = r8.f9865h
            java.lang.String r9 = "CXCP"
            boolean r9 = D.C0761b0.f(r9)
            if (r9 == 0) goto Ld1
            java.lang.String r9 = t.C5473b.a()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "StillCaptureRequestControl: failed to submit "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = ", will be retried with a future UseCaseCamera"
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            android.util.Log.d(r9, r8)
            goto Ld1
        Lcc:
            r8 = move-exception
            r2.l(r4)
            throw r8
        Ld1:
            Y8.t r8 = Y8.t.f7040a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.StillCaptureRequestControl$propagateResultOrEnqueueRequest$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
