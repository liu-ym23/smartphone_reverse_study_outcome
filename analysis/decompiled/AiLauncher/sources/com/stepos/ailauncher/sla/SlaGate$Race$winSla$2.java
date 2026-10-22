package com.stepos.ailauncher.sla;

import Ua.U;
import com.stepos.ailauncher.sla.SlaGate;
import com.stepos.net.exception.ApiErrorCode;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.sla.SlaGate$Race$winSla$2", f = "SlaGate.kt", l = {1314}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SlaGate$Race$winSla$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ int $actionCount;
    final /* synthetic */ long $budgetMs;
    int label;
    final /* synthetic */ SlaGate.Race this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlaGate$Race$winSla$2(long j10, SlaGate.Race race, int i10, InterfaceC4014c<? super SlaGate$Race$winSla$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$budgetMs = j10;
        this.this$0 = race;
        this.$actionCount = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SlaGate$Race$winSla$2(this.$budgetMs, this.this$0, this.$actionCount, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SlaGate$Race$winSla$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            long j10 = this.$budgetMs;
            this.label = 1;
            if (U.a(j10, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        C4148a.u(SlaGate.TAG, "[#" + this.this$0.id + "] SLA 执行超时 " + this.$budgetMs + "ms (actionCount=" + this.$actionCount + ") -> terminateWithoutResult", false, 4, null);
        this.this$0.m0(ApiErrorCode.CANCELED);
        return Y8.t.f7040a;
    }
}
