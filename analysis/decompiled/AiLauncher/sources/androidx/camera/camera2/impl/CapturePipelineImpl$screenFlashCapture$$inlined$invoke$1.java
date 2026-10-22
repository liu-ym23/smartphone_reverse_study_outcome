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
@InterfaceC4112d(c = "androidx.camera.camera2.impl.CapturePipelineImpl$screenFlashCapture$$inlined$invoke$1", f = "CapturePipeline.kt", l = {312, 879}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CapturePipelineImpl$screenFlashCapture$$inlined$invoke$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9576a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f9577b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CapturePipelineImpl f9578c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f9579d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturePipelineImpl$screenFlashCapture$$inlined$invoke$1(List list, InterfaceC4014c interfaceC4014c, CapturePipelineImpl capturePipelineImpl, int i10) {
        super(2, interfaceC4014c);
        this.f9577b = list;
        this.f9578c = capturePipelineImpl;
        this.f9579d = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CapturePipelineImpl$screenFlashCapture$$inlined$invoke$1(this.f9577b, interfaceC4014c, this.f9578c, this.f9579d);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((CapturePipelineImpl$screenFlashCapture$$inlined$invoke$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005c, code lost:
    
        if (r6.M(r1, r5) == r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r5.f9576a
            java.lang.String r2 = "CXCP"
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L20
            if (r1 == r4) goto L1c
            if (r1 != r3) goto L14
            kotlin.C4849c.b(r6)
            goto L5f
        L14:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L1c:
            kotlin.C4849c.b(r6)
            goto L41
        L20:
            kotlin.C4849c.b(r6)
            t.b r6 = t.C5473b.f41865a
            boolean r6 = D.C0761b0.f(r2)
            if (r6 == 0) goto L34
            java.lang.String r6 = t.C5473b.a()
            java.lang.String r1 = "CapturePipeline#List<PipelineTask>.invoke: Waiting for POST_CAPTURE signal"
            android.util.Log.d(r6, r1)
        L34:
            java.util.List r6 = r5.f9577b
            java.util.Collection r6 = (java.util.Collection) r6
            r5.f9576a = r4
            java.lang.Object r6 = kotlinx.coroutines.AwaitKt.b(r6, r5)
            if (r6 != r0) goto L41
            goto L5e
        L41:
            t.b r6 = t.C5473b.f41865a
            boolean r6 = D.C0761b0.f(r2)
            if (r6 == 0) goto L52
            java.lang.String r6 = t.C5473b.a()
            java.lang.String r1 = "CapturePipeline#List<PipelineTask>.invoke: Waiting for POST_CAPTURE signal done"
            android.util.Log.d(r6, r1)
        L52:
            androidx.camera.camera2.impl.CapturePipelineImpl r6 = r5.f9578c
            int r1 = r5.f9579d
            r5.f9576a = r3
            java.lang.Object r5 = r6.M(r1, r5)
            if (r5 != r0) goto L5f
        L5e:
            return r0
        L5f:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl$screenFlashCapture$$inlined$invoke$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
