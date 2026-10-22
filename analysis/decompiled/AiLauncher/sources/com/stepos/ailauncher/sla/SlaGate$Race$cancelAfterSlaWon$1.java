package com.stepos.ailauncher.sla;

import Ua.U;
import com.stepos.ailauncher.sla.SlaGate;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.sla.SlaGate$Race$cancelAfterSlaWon$1", f = "SlaGate.kt", l = {1220}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SlaGate$Race$cancelAfterSlaWon$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;
    final /* synthetic */ SlaGate.Race this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlaGate$Race$cancelAfterSlaWon$1(SlaGate.Race race, InterfaceC4014c<? super SlaGate$Race$cancelAfterSlaWon$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = race;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SlaGate$Race$cancelAfterSlaWon$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SlaGate$Race$cancelAfterSlaWon$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            this.label = 1;
            if (U.a(600L, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        if (this.this$0.query == null && !this.this$0.resultDispatchedToHost.get()) {
            C4148a.u(SlaGate.TAG, "[#" + this.this$0.id + "] 迟到 ASR 文案未在 600ms 内到达 -> 空 query 配信", false, 4, null);
            E5.a.b("[SLA][traceId=" + this.this$0.traceId + "] lateAsrGraceExpired graceMs=600");
        }
        this.this$0.cancelledAfterSlaWin = true;
        this.this$0.U();
        return Y8.t.f7040a;
    }
}
