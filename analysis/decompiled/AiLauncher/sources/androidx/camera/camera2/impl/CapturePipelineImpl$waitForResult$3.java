package androidx.camera.camera2.impl;

import Ua.M;
import Ua.Q;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;
import t.C5474b0;
import w.w;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lw/w;", "<anonymous>", "(LUa/M;)Lw/w;"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.CapturePipelineImpl$waitForResult$3", f = "CapturePipeline.kt", l = {796}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CapturePipelineImpl$waitForResult$3 extends SuspendLambda implements p<M, InterfaceC4014c<? super w>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9700a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C5474b0 f9701b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturePipelineImpl$waitForResult$3(C5474b0 c5474b0, InterfaceC4014c<? super CapturePipelineImpl$waitForResult$3> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f9701b = c5474b0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CapturePipelineImpl$waitForResult$3(this.f9701b, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super w> interfaceC4014c) {
        return ((CapturePipelineImpl$waitForResult$3) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f9700a;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        Q<w> qA = this.f9701b.a();
        this.f9700a = 1;
        Object objA1 = qA.a1(this);
        return objA1 == objG ? objG : objA1;
    }
}
