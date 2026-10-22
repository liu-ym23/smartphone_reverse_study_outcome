package com.stepos.ailauncher.sla;

import com.stepos.aiengine.algorithm.sla.SlaDecision;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.sla.SlaGate$replayCachedDecision$2", f = "SlaGate.kt", l = {192}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SlaGate$replayCachedDecision$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ SlaDecision $decision;
    final /* synthetic */ String $function;
    final /* synthetic */ InterfaceC5063a<Y8.t> $proceed;
    final /* synthetic */ String $query;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ String $traceId;
    int label;
    final /* synthetic */ SlaGate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlaGate$replayCachedDecision$2(SlaGate slaGate, SlaDecision slaDecision, String str, String str2, String str3, String str4, InterfaceC5063a<Y8.t> interfaceC5063a, InterfaceC4014c<? super SlaGate$replayCachedDecision$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = slaGate;
        this.$decision = slaDecision;
        this.$function = str;
        this.$sessionId = str2;
        this.$traceId = str3;
        this.$query = str4;
        this.$proceed = interfaceC5063a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SlaGate$replayCachedDecision$2(this.this$0, this.$decision, this.$function, this.$sessionId, this.$traceId, this.$query, this.$proceed, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SlaGate$replayCachedDecision$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0099  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r9.label
            r2 = 1
            if (r1 == 0) goto L1d
            if (r1 != r2) goto L15
            kotlin.C4849c.b(r10)     // Catch: java.lang.Throwable -> L10
            goto L96
        L10:
            r0 = move-exception
            r10 = r0
            r8 = r9
        L13:
            r2 = r10
            goto L3f
        L15:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L1d:
            kotlin.C4849c.b(r10)
            com.stepos.ailauncher.sla.SlaGate r1 = r9.this$0     // Catch: java.lang.Throwable -> L3c
            r10 = r2
            com.stepos.aiengine.algorithm.sla.SlaDecision r2 = r9.$decision     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = r9.$function     // Catch: java.lang.Throwable -> L3c
            java.lang.String r4 = r9.$sessionId     // Catch: java.lang.Throwable -> L3c
            java.lang.String r5 = r9.$traceId     // Catch: java.lang.Throwable -> L3c
            java.lang.String r6 = r9.$query     // Catch: java.lang.Throwable -> L3c
            p9.a<Y8.t> r7 = r9.$proceed     // Catch: java.lang.Throwable -> L3c
            r9.label = r10     // Catch: java.lang.Throwable -> L3c
            r8 = r9
            java.lang.Object r9 = com.stepos.ailauncher.sla.SlaGate.v(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L39
            if (r9 != r0) goto L96
            return r0
        L39:
            r0 = move-exception
        L3a:
            r10 = r0
            goto L13
        L3c:
            r0 = move-exception
            r8 = r9
            goto L3a
        L3f:
            boolean r9 = r2 instanceof java.util.concurrent.CancellationException
            if (r9 != 0) goto L99
            java.lang.String r9 = r2.getMessage()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "replayCachedDecision crashed: "
            r10.append(r0)
            r10.append(r9)
            java.lang.String r1 = r10.toString()
            r4 = 8
            r5 = 0
            java.lang.String r0 = "SLA"
            r3 = 0
            h8.C4148a.g(r0, r1, r2, r3, r4, r5)
            java.lang.String r9 = r8.$traceId
            java.lang.Class r10 = r2.getClass()
            java.lang.String r10 = r10.getSimpleName()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "[SLA][traceId="
            r0.append(r1)
            r0.append(r9)
            java.lang.String r9 = "] replayCrashed "
            r0.append(r9)
            r0.append(r10)
            java.lang.String r9 = r0.toString()
            E5.a.b(r9)
            com.stepos.ailauncher.sla.SlaGate r9 = r8.this$0
            p9.a<Y8.t> r10 = r8.$proceed
            java.lang.String r0 = r8.$traceId
            java.lang.String r1 = r8.$query
            java.lang.String r2 = "replay-exception"
            com.stepos.ailauncher.sla.SlaGate.u(r9, r10, r0, r1, r2)
        L96:
            Y8.t r9 = Y8.t.f7040a
            return r9
        L99:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.sla.SlaGate$replayCachedDecision$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
