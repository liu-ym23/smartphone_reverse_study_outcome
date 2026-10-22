package androidx.camera.camera2.impl;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", l = {528}, m = "screenFlashCapture", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CapturePipelineImpl$screenFlashCapture$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f9666a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9667b;

    /* renamed from: c, reason: collision with root package name */
    public Object f9668c;

    /* renamed from: d, reason: collision with root package name */
    public Object f9669d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f9670e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ CapturePipelineImpl f9671f;

    /* renamed from: g, reason: collision with root package name */
    public int f9672g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturePipelineImpl$screenFlashCapture$1(CapturePipelineImpl capturePipelineImpl, InterfaceC4014c<? super CapturePipelineImpl$screenFlashCapture$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f9671f = capturePipelineImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f9670e = obj;
        this.f9672g |= Integer.MIN_VALUE;
        return this.f9671f.R(null, 0, null, this);
    }
}
