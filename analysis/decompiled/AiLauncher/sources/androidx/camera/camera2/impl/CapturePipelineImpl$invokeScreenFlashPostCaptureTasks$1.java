package androidx.camera.camera2.impl;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", l = {563, 875, 570}, m = "invokeScreenFlashPostCaptureTasks", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CapturePipelineImpl$invokeScreenFlashPostCaptureTasks$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f9645a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9646b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f9647c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CapturePipelineImpl f9648d;

    /* renamed from: e, reason: collision with root package name */
    public int f9649e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturePipelineImpl$invokeScreenFlashPostCaptureTasks$1(CapturePipelineImpl capturePipelineImpl, InterfaceC4014c<? super CapturePipelineImpl$invokeScreenFlashPostCaptureTasks$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f9648d = capturePipelineImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f9647c = obj;
        this.f9649e |= Integer.MIN_VALUE;
        return this.f9648d.M(0, this);
    }
}
