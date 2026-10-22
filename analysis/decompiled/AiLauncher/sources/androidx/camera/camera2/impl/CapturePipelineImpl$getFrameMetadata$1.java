package androidx.camera.camera2.impl;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", l = {176}, m = "getFrameMetadata", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CapturePipelineImpl$getFrameMetadata$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f9634a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f9635b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CapturePipelineImpl f9636c;

    /* renamed from: d, reason: collision with root package name */
    public int f9637d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturePipelineImpl$getFrameMetadata$1(CapturePipelineImpl capturePipelineImpl, InterfaceC4014c<? super CapturePipelineImpl$getFrameMetadata$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f9636c = capturePipelineImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f9635b = obj;
        this.f9637d |= Integer.MIN_VALUE;
        return this.f9636c.G(this);
    }
}
