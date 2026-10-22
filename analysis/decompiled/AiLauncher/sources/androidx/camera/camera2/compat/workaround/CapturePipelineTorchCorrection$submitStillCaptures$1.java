package androidx.camera.camera2.compat.workaround;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "androidx.camera.camera2.compat.workaround.CapturePipelineTorchCorrection", f = "CapturePipelineTorchCorrection.kt", l = {75}, m = "submitStillCaptures-BvXKQx0", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CapturePipelineTorchCorrection$submitStillCaptures$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public boolean f9515a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f9516b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CapturePipelineTorchCorrection f9517c;

    /* renamed from: d, reason: collision with root package name */
    public int f9518d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturePipelineTorchCorrection$submitStillCaptures$1(CapturePipelineTorchCorrection capturePipelineTorchCorrection, InterfaceC4014c<? super CapturePipelineTorchCorrection$submitStillCaptures$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f9517c = capturePipelineTorchCorrection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f9516b = obj;
        this.f9518d |= Integer.MIN_VALUE;
        return this.f9517c.c(null, 0, null, 0, 0, 0, this);
    }
}
