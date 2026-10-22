package androidx.camera.camera2.impl;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", l = {793}, m = "waitForResult", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CapturePipelineImpl$waitForResult$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f9696a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f9697b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CapturePipelineImpl f9698c;

    /* renamed from: d, reason: collision with root package name */
    public int f9699d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturePipelineImpl$waitForResult$1(CapturePipelineImpl capturePipelineImpl, InterfaceC4014c<? super CapturePipelineImpl$waitForResult$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f9698c = capturePipelineImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f9697b = obj;
        this.f9699d |= Integer.MIN_VALUE;
        return this.f9698c.Y(0L, null, this);
    }
}
