package androidx.camera.camera2.impl;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", l = {772}, m = "isPhysicalFlashRequired", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CapturePipelineImpl$isPhysicalFlashRequired$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f9655a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CapturePipelineImpl f9656b;

    /* renamed from: c, reason: collision with root package name */
    public int f9657c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturePipelineImpl$isPhysicalFlashRequired$1(CapturePipelineImpl capturePipelineImpl, InterfaceC4014c<? super CapturePipelineImpl$isPhysicalFlashRequired$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f9656b = capturePipelineImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f9655a = obj;
        this.f9657c |= Integer.MIN_VALUE;
        return this.f9656b.O(0, this);
    }
}
