package com.stepos.ailauncher.sla;

import com.stepos.aiengine.algorithm.sla.SlaListener;
import com.stepos.ailauncher.sla.SlaGate;
import com.stepos.ailauncher.sla.SlaRouter;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.sla.SlaGate$Race$start$1", f = "SlaGate.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SlaGate$Race$start$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ InterfaceC5074l<SlaListener, SlaRouter.a> $starter;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SlaGate.Race this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SlaGate$Race$start$1(SlaGate.Race race, InterfaceC5074l<? super SlaListener, SlaRouter.a> interfaceC5074l, InterfaceC4014c<? super SlaGate$Race$start$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = race;
        this.$starter = interfaceC5074l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SlaGate$Race$start$1 slaGate$Race$start$1 = new SlaGate$Race$start$1(this.this$0, this.$starter, interfaceC4014c);
        slaGate$Race$start$1.L$0 = obj;
        return slaGate$Race$start$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SlaGate$Race$start$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objB;
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        InterfaceC5074l<SlaListener, SlaRouter.a> interfaceC5074l = this.$starter;
        SlaGate.Race race = this.this$0;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(interfaceC5074l.invoke(race.listener));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        SlaRouter.a aVar = (SlaRouter.a) objB;
        if (aVar == null) {
            C4148a.u(SlaGate.TAG, "[#" + this.this$0.id + "] recognize 未受理 -> fallback", false, 4, null);
            this.this$0.S(-1002);
        } else {
            this.this$0.H(aVar);
        }
        return Y8.t.f7040a;
    }
}
