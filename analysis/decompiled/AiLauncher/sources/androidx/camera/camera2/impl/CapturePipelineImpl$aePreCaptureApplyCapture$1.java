package androidx.camera.camera2.impl;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", l = {887, 494, 499}, m = "aePreCaptureApplyCapture", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CapturePipelineImpl$aePreCaptureApplyCapture$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public long f9596a;

    /* renamed from: b, reason: collision with root package name */
    public int f9597b;

    /* renamed from: c, reason: collision with root package name */
    public Object f9598c;

    /* renamed from: d, reason: collision with root package name */
    public Object f9599d;

    /* renamed from: e, reason: collision with root package name */
    public Object f9600e;

    /* renamed from: f, reason: collision with root package name */
    public Object f9601f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f9602g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ CapturePipelineImpl f9603h;

    /* renamed from: i, reason: collision with root package name */
    public int f9604i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturePipelineImpl$aePreCaptureApplyCapture$1(CapturePipelineImpl capturePipelineImpl, InterfaceC4014c<? super CapturePipelineImpl$aePreCaptureApplyCapture$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f9603h = capturePipelineImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f9602g = obj;
        this.f9604i |= Integer.MIN_VALUE;
        return this.f9603h.B(null, 0L, 0, null, this);
    }
}
