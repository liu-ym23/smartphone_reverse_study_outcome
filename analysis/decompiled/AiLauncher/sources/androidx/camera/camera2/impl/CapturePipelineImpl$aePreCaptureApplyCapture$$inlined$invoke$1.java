package androidx.camera.camera2.impl;

import Ua.M;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.CapturePipelineImpl$aePreCaptureApplyCapture$$inlined$invoke$1", f = "CapturePipeline.kt", l = {312, 885, 892}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CapturePipelineImpl$aePreCaptureApplyCapture$$inlined$invoke$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9543a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f9544b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CapturePipelineImpl f9545c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f9546d;

    /* renamed from: e, reason: collision with root package name */
    public Object f9547e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturePipelineImpl$aePreCaptureApplyCapture$$inlined$invoke$1(List list, InterfaceC4014c interfaceC4014c, CapturePipelineImpl capturePipelineImpl, int i10) {
        super(2, interfaceC4014c);
        this.f9544b = list;
        this.f9545c = capturePipelineImpl;
        this.f9546d = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CapturePipelineImpl$aePreCaptureApplyCapture$$inlined$invoke$1(this.f9544b, interfaceC4014c, this.f9545c, this.f9546d);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((CapturePipelineImpl$aePreCaptureApplyCapture$$inlined$invoke$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0090 A[Catch: all -> 0x009a, TryCatch #0 {all -> 0x009a, blocks: (B:32:0x0085, B:34:0x0090, B:37:0x009f, B:41:0x00a5), top: B:55:0x0085 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b9 A[Catch: all -> 0x001c, TryCatch #2 {all -> 0x001c, blocks: (B:8:0x0017, B:45:0x00b1, B:47:0x00b9, B:48:0x00c2), top: B:59:0x0017 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Exception {
        /*
            r8 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r8.f9543a
            r2 = 3
            r3 = 2
            r4 = 1
            java.lang.String r5 = "CXCP"
            if (r1 == 0) goto L2f
            if (r1 == r4) goto L2b
            if (r1 == r3) goto L27
            if (r1 != r2) goto L1f
            java.lang.Object r8 = r8.f9547e
            java.lang.AutoCloseable r8 = (java.lang.AutoCloseable) r8
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L1c
            goto Lb1
        L1c:
            r9 = move-exception
            goto Lcb
        L1f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L27:
            kotlin.C4849c.b(r9)
            goto L83
        L2b:
            kotlin.C4849c.b(r9)
            goto L50
        L2f:
            kotlin.C4849c.b(r9)
            t.b r9 = t.C5473b.f41865a
            boolean r9 = D.C0761b0.f(r5)
            if (r9 == 0) goto L43
            java.lang.String r9 = t.C5473b.a()
            java.lang.String r1 = "CapturePipeline#List<PipelineTask>.invoke: Waiting for POST_CAPTURE signal"
            android.util.Log.d(r9, r1)
        L43:
            java.util.List r9 = r8.f9544b
            java.util.Collection r9 = (java.util.Collection) r9
            r8.f9543a = r4
            java.lang.Object r9 = kotlinx.coroutines.AwaitKt.b(r9, r8)
            if (r9 != r0) goto L50
            goto Laf
        L50:
            t.b r9 = t.C5473b.f41865a
            boolean r9 = D.C0761b0.f(r5)
            if (r9 == 0) goto L61
            java.lang.String r9 = t.C5473b.a()
            java.lang.String r1 = "CapturePipeline#List<PipelineTask>.invoke: Waiting for POST_CAPTURE signal done"
            android.util.Log.d(r9, r1)
        L61:
            boolean r9 = D.C0761b0.f(r5)
            if (r9 == 0) goto L70
            java.lang.String r9 = t.C5473b.a()
            java.lang.String r1 = "CapturePipeline#aePreCaptureApplyCapture: Acquiring session for unlocking 3A"
            android.util.Log.d(r9, r1)
        L70:
            androidx.camera.camera2.impl.CapturePipelineImpl r9 = r8.f9545c
            s.J r9 = androidx.camera.camera2.impl.CapturePipelineImpl.r(r9)
            androidx.camera.camera2.pipe.CameraGraph r9 = r9.f()
            r8.f9543a = r3
            java.lang.Object r9 = r9.A0(r8)
            if (r9 != r0) goto L83
            goto Laf
        L83:
            java.lang.AutoCloseable r9 = (java.lang.AutoCloseable) r9
            r1 = r9
            androidx.camera.camera2.pipe.CameraGraph$f r1 = (androidx.camera.camera2.pipe.CameraGraph.f) r1     // Catch: java.lang.Throwable -> L9a
            t.b r3 = t.C5473b.f41865a     // Catch: java.lang.Throwable -> L9a
            boolean r3 = D.C0761b0.f(r5)     // Catch: java.lang.Throwable -> L9a
            if (r3 == 0) goto L9f
            java.lang.String r3 = t.C5473b.a()     // Catch: java.lang.Throwable -> L9a
            java.lang.String r6 = "CapturePipeline#aePreCaptureApplyCapture: Unlocking 3A"
            android.util.Log.d(r3, r6)     // Catch: java.lang.Throwable -> L9a
            goto L9f
        L9a:
            r8 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto Lcb
        L9f:
            int r3 = r8.f9546d     // Catch: java.lang.Throwable -> L9a
            if (r3 != 0) goto La4
            goto La5
        La4:
            r4 = 0
        La5:
            r8.f9547e = r9     // Catch: java.lang.Throwable -> L9a
            r8.f9543a = r2     // Catch: java.lang.Throwable -> L9a
            java.lang.Object r8 = r1.J0(r4, r8)     // Catch: java.lang.Throwable -> L9a
            if (r8 != r0) goto Lb0
        Laf:
            return r0
        Lb0:
            r8 = r9
        Lb1:
            t.b r9 = t.C5473b.f41865a     // Catch: java.lang.Throwable -> L1c
            boolean r9 = D.C0761b0.f(r5)     // Catch: java.lang.Throwable -> L1c
            if (r9 == 0) goto Lc2
            java.lang.String r9 = t.C5473b.a()     // Catch: java.lang.Throwable -> L1c
            java.lang.String r0 = "CapturePipeline#aePreCaptureApplyCapture: Unlocking 3A done"
            android.util.Log.d(r9, r0)     // Catch: java.lang.Throwable -> L1c
        Lc2:
            Y8.t r9 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L1c
            r9 = 0
            n9.C4946a.a(r8, r9)
            Y8.t r8 = Y8.t.f7040a
            return r8
        Lcb:
            throw r9     // Catch: java.lang.Throwable -> Lcc
        Lcc:
            r0 = move-exception
            n9.C4946a.a(r8, r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl$aePreCaptureApplyCapture$$inlined$invoke$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
