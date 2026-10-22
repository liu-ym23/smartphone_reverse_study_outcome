package androidx.camera.camera2.impl;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", l = {408, 895, 416, 421, 436, 440}, m = "torchApplyCapture", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CapturePipelineImpl$torchApplyCapture$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f9673a;

    /* renamed from: b, reason: collision with root package name */
    public int f9674b;

    /* renamed from: c, reason: collision with root package name */
    public int f9675c;

    /* renamed from: d, reason: collision with root package name */
    public long f9676d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9677e;

    /* renamed from: f, reason: collision with root package name */
    public Object f9678f;

    /* renamed from: g, reason: collision with root package name */
    public Object f9679g;

    /* renamed from: h, reason: collision with root package name */
    public Object f9680h;

    /* renamed from: i, reason: collision with root package name */
    public Object f9681i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f9682j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ CapturePipelineImpl f9683k;

    /* renamed from: l, reason: collision with root package name */
    public int f9684l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturePipelineImpl$torchApplyCapture$1(CapturePipelineImpl capturePipelineImpl, InterfaceC4014c<? super CapturePipelineImpl$torchApplyCapture$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f9683k = capturePipelineImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f9682j = obj;
        this.f9684l |= Integer.MIN_VALUE;
        return this.f9683k.U(null, 0, 0L, null, false, this);
    }
}
