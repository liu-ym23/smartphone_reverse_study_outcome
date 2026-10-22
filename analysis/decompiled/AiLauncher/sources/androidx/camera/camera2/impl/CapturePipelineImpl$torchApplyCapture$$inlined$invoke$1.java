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
@InterfaceC4112d(c = "androidx.camera.camera2.impl.CapturePipelineImpl$torchApplyCapture$$inlined$invoke$1", f = "CapturePipeline.kt", l = {312, 898, 900, 907}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CapturePipelineImpl$torchApplyCapture$$inlined$invoke$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9585a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f9586b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f9587c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CapturePipelineImpl f9588d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f9589e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f9590f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f9591g;

    /* renamed from: h, reason: collision with root package name */
    public Object f9592h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturePipelineImpl$torchApplyCapture$$inlined$invoke$1(List list, InterfaceC4014c interfaceC4014c, boolean z10, CapturePipelineImpl capturePipelineImpl, boolean z11, boolean z12, int i10) {
        super(2, interfaceC4014c);
        this.f9586b = list;
        this.f9587c = z10;
        this.f9588d = capturePipelineImpl;
        this.f9589e = z11;
        this.f9590f = z12;
        this.f9591g = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CapturePipelineImpl$torchApplyCapture$$inlined$invoke$1(this.f9586b, interfaceC4014c, this.f9587c, this.f9588d, this.f9589e, this.f9590f, this.f9591g);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((CapturePipelineImpl$torchApplyCapture$$inlined$invoke$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0113, code lost:
    
        if (r15.W(r3, r14) == r0) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00dd  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl$torchApplyCapture$$inlined$invoke$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
