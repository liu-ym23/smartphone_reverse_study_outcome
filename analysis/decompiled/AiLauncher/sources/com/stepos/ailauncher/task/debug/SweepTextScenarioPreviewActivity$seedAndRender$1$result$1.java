package com.stepos.ailauncher.task.debug;

import Ua.M;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lkotlin/Result;", "", "<anonymous>", "(LUa/M;)Lkotlin/Result;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.task.debug.SweepTextScenarioPreviewActivity$seedAndRender$1$result$1", f = "SweepTextScenarioPreviewActivity.kt", l = {105}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SweepTextScenarioPreviewActivity$seedAndRender$1$result$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Result<? extends Integer>>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public SweepTextScenarioPreviewActivity$seedAndRender$1$result$1(InterfaceC4014c<? super SweepTextScenarioPreviewActivity$seedAndRender$1$result$1> interfaceC4014c) {
        super(2, interfaceC4014c);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SweepTextScenarioPreviewActivity$seedAndRender$1$result$1 sweepTextScenarioPreviewActivity$seedAndRender$1$result$1 = new SweepTextScenarioPreviewActivity$seedAndRender$1$result$1(interfaceC4014c);
        sweepTextScenarioPreviewActivity$seedAndRender$1$result$1.L$0 = obj;
        return sweepTextScenarioPreviewActivity$seedAndRender$1$result$1;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(M m10, InterfaceC4014c<? super Result<Integer>> interfaceC4014c) {
        return ((SweepTextScenarioPreviewActivity$seedAndRender$1$result$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        M m10 = (M) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        try {
            if (i10 == 0) {
                C4849c.b(obj);
                Result.Companion companion = Result.INSTANCE;
                m mVar = m.INSTANCE;
                this.L$0 = g9.h.a(m10);
                this.L$1 = g9.h.a(m10);
                this.I$0 = 0;
                this.label = 1;
                obj = mVar.f(this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            objB = Result.b(C4109a.f(((Number) obj).intValue()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return Result.a(objB);
    }

    @Override // p9.p
    public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super Result<? extends Integer>> interfaceC4014c) {
        return invoke2(m10, (InterfaceC4014c<? super Result<Integer>>) interfaceC4014c);
    }
}
