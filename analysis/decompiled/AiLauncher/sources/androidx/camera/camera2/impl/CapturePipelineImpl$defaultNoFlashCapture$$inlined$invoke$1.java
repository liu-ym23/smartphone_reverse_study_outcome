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
@InterfaceC4112d(c = "androidx.camera.camera2.impl.CapturePipelineImpl$defaultNoFlashCapture$$inlined$invoke$1", f = "CapturePipeline.kt", l = {312, 885}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CapturePipelineImpl$defaultNoFlashCapture$$inlined$invoke$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9548a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f9549b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f9550c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CapturePipelineImpl f9551d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturePipelineImpl$defaultNoFlashCapture$$inlined$invoke$1(List list, InterfaceC4014c interfaceC4014c, boolean z10, CapturePipelineImpl capturePipelineImpl) {
        super(2, interfaceC4014c);
        this.f9549b = list;
        this.f9550c = z10;
        this.f9551d = capturePipelineImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CapturePipelineImpl$defaultNoFlashCapture$$inlined$invoke$1(this.f9549b, interfaceC4014c, this.f9550c, this.f9551d);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((CapturePipelineImpl$defaultNoFlashCapture$$inlined$invoke$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
    
        if (r8.W(r5, r7) == r0) goto L26;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r7.f9548a
            r2 = 2
            r3 = 1
            java.lang.String r4 = "CXCP"
            if (r1 == 0) goto L20
            if (r1 == r3) goto L1c
            if (r1 != r2) goto L14
            kotlin.C4849c.b(r8)
            goto L74
        L14:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1c:
            kotlin.C4849c.b(r8)
            goto L41
        L20:
            kotlin.C4849c.b(r8)
            t.b r8 = t.C5473b.f41865a
            boolean r8 = D.C0761b0.f(r4)
            if (r8 == 0) goto L34
            java.lang.String r8 = t.C5473b.a()
            java.lang.String r1 = "CapturePipeline#List<PipelineTask>.invoke: Waiting for POST_CAPTURE signal"
            android.util.Log.d(r8, r1)
        L34:
            java.util.List r8 = r7.f9549b
            java.util.Collection r8 = (java.util.Collection) r8
            r7.f9548a = r3
            java.lang.Object r8 = kotlinx.coroutines.AwaitKt.b(r8, r7)
            if (r8 != r0) goto L41
            goto L73
        L41:
            t.b r8 = t.C5473b.f41865a
            boolean r8 = D.C0761b0.f(r4)
            if (r8 == 0) goto L52
            java.lang.String r8 = t.C5473b.a()
            java.lang.String r1 = "CapturePipeline#List<PipelineTask>.invoke: Waiting for POST_CAPTURE signal done"
            android.util.Log.d(r8, r1)
        L52:
            boolean r8 = r7.f9550c
            if (r8 == 0) goto L85
            boolean r8 = D.C0761b0.f(r4)
            if (r8 == 0) goto L65
            java.lang.String r8 = t.C5473b.a()
            java.lang.String r1 = "CapturePipeline#defaultNoFlashCapture: Unlocking 3A"
            android.util.Log.d(r8, r1)
        L65:
            androidx.camera.camera2.impl.CapturePipelineImpl r8 = r7.f9551d
            long r5 = t.C5467B.a()
            r7.f9548a = r2
            java.lang.Object r7 = androidx.camera.camera2.impl.CapturePipelineImpl.z(r8, r5, r7)
            if (r7 != r0) goto L74
        L73:
            return r0
        L74:
            t.b r7 = t.C5473b.f41865a
            boolean r7 = D.C0761b0.f(r4)
            if (r7 == 0) goto L85
            java.lang.String r7 = t.C5473b.a()
            java.lang.String r8 = "CapturePipeline#defaultNoFlashCapture: Unlocking 3A done"
            android.util.Log.d(r7, r8)
        L85:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl$defaultNoFlashCapture$$inlined$invoke$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
