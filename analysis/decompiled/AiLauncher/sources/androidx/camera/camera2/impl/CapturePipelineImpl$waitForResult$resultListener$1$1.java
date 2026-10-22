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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "androidx.camera.camera2.impl.CapturePipelineImpl$waitForResult$resultListener$1$1", f = "CapturePipeline.kt", l = {788}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class CapturePipelineImpl$waitForResult$resultListener$1$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public int f9702a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C5474b0 f9703b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CapturePipelineImpl f9704c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CapturePipelineImpl$waitForResult$resultListener$1$1(C5474b0 c5474b0, CapturePipelineImpl capturePipelineImpl, InterfaceC4014c<? super CapturePipelineImpl$waitForResult$resultListener$1$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.f9703b = c5474b0;
        this.f9704c = capturePipelineImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new CapturePipelineImpl$waitForResult$resultListener$1$1(this.f9703b, this.f9704c, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((CapturePipelineImpl$waitForResult$resultListener$1$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.f9702a;
        if (i10 == 0) {
            C4849c.b(obj);
            Q<w> qA = this.f9703b.a();
            this.f9702a = 1;
            if (qA.T0(this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        this.f9704c.requestListener.F(this.f9703b);
        return t.f7040a;
    }
}
