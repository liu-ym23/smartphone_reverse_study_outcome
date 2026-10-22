package androidx.camera.camera2.impl;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", l = {216, 217, 218, 220}, m = "invokeCaptureTasks", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CapturePipelineImpl$invokeCaptureTasks$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f9638a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9639b;

    /* renamed from: c, reason: collision with root package name */
    public int f9640c;

    /* renamed from: d, reason: collision with root package name */
    public int f9641d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f9642e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ CapturePipelineImpl f9643f;

    /* renamed from: g, reason: collision with root package name */
    public int f9644g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturePipelineImpl$invokeCaptureTasks$1(CapturePipelineImpl capturePipelineImpl, InterfaceC4014c<? super CapturePipelineImpl$invokeCaptureTasks$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f9643f = capturePipelineImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f9642e = obj;
        this.f9644g |= Integer.MIN_VALUE;
        return this.f9643f.L(null, 0, 0, 0, null, this);
    }
}
