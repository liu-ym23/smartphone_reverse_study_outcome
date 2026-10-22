package com.stepos.ailauncher.sla;

import com.stepos.aiengine.algorithm.sla.SlaResult;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.sla.SlaGate$replayCachedDecisionAfterLedger$3", f = "SlaGate.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SlaGate$replayCachedDecisionAfterLedger$3 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $query;
    final /* synthetic */ SlaResult $result;
    final /* synthetic */ InterfaceC5063a<Y8.t> $routeToBackend;
    final /* synthetic */ String $traceId;
    int label;
    final /* synthetic */ SlaGate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlaGate$replayCachedDecisionAfterLedger$3(SlaGate slaGate, String str, String str2, SlaResult slaResult, InterfaceC5063a<Y8.t> interfaceC5063a, InterfaceC4014c<? super SlaGate$replayCachedDecisionAfterLedger$3> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = slaGate;
        this.$traceId = str;
        this.$query = str2;
        this.$result = slaResult;
        this.$routeToBackend = interfaceC5063a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SlaGate$replayCachedDecisionAfterLedger$3(this.this$0, this.$traceId, this.$query, this.$result, this.$routeToBackend, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SlaGate$replayCachedDecisionAfterLedger$3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        this.this$0.callbacks.f(this.$traceId, this.$query, this.$result, this.$routeToBackend);
        return Y8.t.f7040a;
    }
}
