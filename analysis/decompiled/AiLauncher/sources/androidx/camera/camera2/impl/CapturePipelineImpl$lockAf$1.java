package androidx.camera.camera2.impl;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.impl.CapturePipelineImpl", f = "CapturePipeline.kt", l = {871, 585, 594}, m = "lockAf", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CapturePipelineImpl$lockAf$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public long f9660a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9661b;

    /* renamed from: c, reason: collision with root package name */
    public Object f9662c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f9663d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ CapturePipelineImpl f9664e;

    /* renamed from: f, reason: collision with root package name */
    public int f9665f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturePipelineImpl$lockAf$1(CapturePipelineImpl capturePipelineImpl, InterfaceC4014c<? super CapturePipelineImpl$lockAf$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f9664e = capturePipelineImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f9663d = obj;
        this.f9665f |= Integer.MIN_VALUE;
        return this.f9664e.Q(0L, false, this);
    }
}
