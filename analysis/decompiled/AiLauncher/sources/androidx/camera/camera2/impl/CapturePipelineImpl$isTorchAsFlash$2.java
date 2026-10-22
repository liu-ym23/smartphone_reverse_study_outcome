package androidx.camera.camera2.impl;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;
import w.x;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lw/x;", "<anonymous>", "()Lw/x;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.CapturePipelineImpl$isTorchAsFlash$2", f = "CapturePipeline.kt", l = {808}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CapturePipelineImpl$isTorchAsFlash$2 extends SuspendLambda implements InterfaceC5074l<InterfaceC4014c<? super x>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9658a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CapturePipelineImpl f9659b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturePipelineImpl$isTorchAsFlash$2(CapturePipelineImpl capturePipelineImpl, InterfaceC4014c<? super CapturePipelineImpl$isTorchAsFlash$2> interfaceC4014c) {
        super(1, interfaceC4014c);
        this.f9659b = capturePipelineImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(InterfaceC4014c<?> interfaceC4014c) {
        return new CapturePipelineImpl$isTorchAsFlash$2(this.f9659b, interfaceC4014c);
    }

    @Override // p9.InterfaceC5074l
    public final Object invoke(InterfaceC4014c<? super x> interfaceC4014c) {
        return ((CapturePipelineImpl$isTorchAsFlash$2) create(interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f9658a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        CapturePipelineImpl capturePipelineImpl = this.f9659b;
        this.f9658a = 1;
        Object objG2 = capturePipelineImpl.G(this);
        return objG2 == objG ? objG : objG2;
    }
}
