package androidx.camera.camera2.compat.workaround;

import Ua.M;
import Ua.Q;
import Y8.t;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection$submitStillCaptures$2", f = "CapturePipelineTorchCorrection.kt", l = {86, 88, 89}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CapturePipelineTorchCorrection$submitStillCaptures$2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9519a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<Q<Void>> f9520b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CapturePipelineTorchCorrection f9521c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CapturePipelineTorchCorrection$submitStillCaptures$2(List<? extends Q<Void>> list, CapturePipelineTorchCorrection capturePipelineTorchCorrection, InterfaceC4014c<? super CapturePipelineTorchCorrection$submitStillCaptures$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f9520b = list;
        this.f9521c = capturePipelineTorchCorrection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CapturePipelineTorchCorrection$submitStillCaptures$2(this.f9520b, this.f9521c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((CapturePipelineTorchCorrection$submitStillCaptures$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x007f, code lost:
    
        if (r12.T0(r11) != r0) goto L24;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r11.f9519a
            java.lang.String r2 = "CXCP"
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L27
            if (r1 == r5) goto L23
            if (r1 == r4) goto L1f
            if (r1 != r3) goto L17
            kotlin.C4849c.b(r12)
            goto L82
        L17:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L1f:
            kotlin.C4849c.b(r12)
            goto L65
        L23:
            kotlin.C4849c.b(r12)
            goto L37
        L27:
            kotlin.C4849c.b(r12)
            java.util.List<Ua.Q<java.lang.Void>> r12 = r11.f9520b
            java.util.Collection r12 = (java.util.Collection) r12
            r11.f9519a = r5
            java.lang.Object r12 = kotlinx.coroutines.AwaitKt.b(r12, r11)
            if (r12 != r0) goto L37
            goto L81
        L37:
            t.b r12 = t.C5473b.f41865a
            boolean r12 = D.C0761b0.f(r2)
            if (r12 == 0) goto L48
            java.lang.String r12 = t.C5473b.a()
            java.lang.String r1 = "Re-enable Torch to correct the Torch state"
            android.util.Log.d(r12, r1)
        L48:
            androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection r12 = r11.f9521c
            androidx.camera.camera2.impl.f r5 = androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection.f(r12)
            androidx.camera.camera2.impl.f$a$a r12 = androidx.camera.camera2.impl.f.a.INSTANCE
            int r6 = r12.a()
            r9 = 6
            r10 = 0
            r7 = 0
            r8 = 0
            Ua.Q r12 = androidx.camera.camera2.impl.f.n(r5, r6, r7, r8, r9, r10)
            r11.f9519a = r4
            java.lang.Object r12 = r12.T0(r11)
            if (r12 != r0) goto L65
            goto L81
        L65:
            androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection r12 = r11.f9521c
            androidx.camera.camera2.impl.f r4 = androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection.f(r12)
            androidx.camera.camera2.impl.f$a$a r12 = androidx.camera.camera2.impl.f.a.INSTANCE
            int r5 = r12.c()
            r8 = 6
            r9 = 0
            r6 = 0
            r7 = 0
            Ua.Q r12 = androidx.camera.camera2.impl.f.n(r4, r5, r6, r7, r8, r9)
            r11.f9519a = r3
            java.lang.Object r11 = r12.T0(r11)
            if (r11 != r0) goto L82
        L81:
            return r0
        L82:
            t.b r11 = t.C5473b.f41865a
            boolean r11 = D.C0761b0.f(r2)
            if (r11 == 0) goto L93
            java.lang.String r11 = t.C5473b.a()
            java.lang.String r12 = "Re-enable Torch to correct the Torch state, done"
            android.util.Log.d(r11, r12)
        L93:
            Y8.t r11 = Y8.t.f7040a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection$submitStillCaptures$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
