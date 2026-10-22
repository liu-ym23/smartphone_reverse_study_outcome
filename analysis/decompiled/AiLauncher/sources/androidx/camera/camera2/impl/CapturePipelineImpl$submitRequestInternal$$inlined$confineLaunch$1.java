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
@InterfaceC4112d(c = "androidx.camera.camera2.impl.CapturePipelineImpl$submitRequestInternal$$inlined$confineLaunch$1", f = "CapturePipeline.kt", l = {210, 246, 247}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CapturePipelineImpl$submitRequestInternal$$inlined$confineLaunch$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9580a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CapturePipelineImpl f9581b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f9582c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List f9583d;

    /* renamed from: e, reason: collision with root package name */
    public Object f9584e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturePipelineImpl$submitRequestInternal$$inlined$confineLaunch$1(InterfaceC4014c interfaceC4014c, CapturePipelineImpl capturePipelineImpl, List list, List list2) {
        super(2, interfaceC4014c);
        this.f9581b = capturePipelineImpl;
        this.f9582c = list;
        this.f9583d = list2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CapturePipelineImpl$submitRequestInternal$$inlined$confineLaunch$1(interfaceC4014c, this.f9581b, this.f9582c, this.f9583d);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((CapturePipelineImpl$submitRequestInternal$$inlined$confineLaunch$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00bc, code lost:
    
        if (r11.h(r10) != r0) goto L51;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.CapturePipelineImpl$submitRequestInternal$$inlined$confineLaunch$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
