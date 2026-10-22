package com.stepos.ailauncher.chat.view.sla;

import Ua.M;
import Y8.t;
import com.stepos.agentframework.chatcore.send.SlaSessionAnchor;
import com.stepos.aiengine.algorithm.sla.SlaResult;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.sla.SlaChatController$onSlaResult$2", f = "SlaChatController.kt", l = {849, 850}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SlaChatController$onSlaResult$2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ SlaSessionAnchor $anchor;
    final /* synthetic */ String $query;
    final /* synthetic */ SlaResult $result;
    final /* synthetic */ String $traceId;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SlaChatController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlaChatController$onSlaResult$2(SlaChatController slaChatController, String str, SlaSessionAnchor slaSessionAnchor, SlaResult slaResult, String str2, InterfaceC4014c<? super SlaChatController$onSlaResult$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = slaChatController;
        this.$query = str;
        this.$anchor = slaSessionAnchor;
        this.$result = slaResult;
        this.$traceId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        SlaChatController$onSlaResult$2 slaChatController$onSlaResult$2 = new SlaChatController$onSlaResult$2(this.this$0, this.$query, this.$anchor, this.$result, this.$traceId, interfaceC4014c);
        slaChatController$onSlaResult$2.L$0 = obj;
        return slaChatController$onSlaResult$2;
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((SlaChatController$onSlaResult$2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0062, code lost:
    
        if (r4.S0(r5, r6, r7, r8, r10) == r1) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = r10.L$0
            Ua.M r0 = (Ua.M) r0
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r10.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L26
            if (r2 == r4) goto L22
            if (r2 != r3) goto L1a
            java.lang.Object r10 = r10.L$1
            Ua.M r10 = (Ua.M) r10
            kotlin.C4849c.b(r11)     // Catch: java.lang.Throwable -> L6b
            goto L65
        L1a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L22:
            kotlin.C4849c.b(r11)
            goto L40
        L26:
            kotlin.C4849c.b(r11)
            com.stepos.ailauncher.chat.view.sla.SlaChatController r11 = r10.this$0
            java.lang.String r2 = r10.$query
            r5 = 50
            java.lang.String r2 = La.K.R1(r2, r5)
            com.stepos.agentframework.chatcore.send.l r5 = r10.$anchor
            r10.L$0 = r0
            r10.label = r4
            java.lang.Object r11 = com.stepos.ailauncher.chat.view.sla.SlaChatController.x(r11, r2, r5, r10)
            if (r11 != r1) goto L40
            goto L64
        L40:
            com.stepos.ailauncher.chat.view.sla.SlaChatController r4 = r10.this$0
            java.lang.String r5 = r10.$query
            com.stepos.aiengine.algorithm.sla.SlaResult r6 = r10.$result
            java.lang.String r7 = r10.$traceId
            com.stepos.agentframework.chatcore.send.l r8 = r10.$anchor
            kotlin.Result$a r11 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L6b
            java.lang.Object r11 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L6b
            r10.L$0 = r11     // Catch: java.lang.Throwable -> L6b
            java.lang.Object r11 = g9.h.a(r0)     // Catch: java.lang.Throwable -> L6b
            r10.L$1 = r11     // Catch: java.lang.Throwable -> L6b
            r11 = 0
            r10.I$0 = r11     // Catch: java.lang.Throwable -> L6b
            r10.label = r3     // Catch: java.lang.Throwable -> L6b
            r9 = r10
            java.lang.Object r10 = com.stepos.ailauncher.chat.view.sla.SlaChatController.J(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L6b
            if (r10 != r1) goto L65
        L64:
            return r1
        L65:
            Y8.t r10 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L6b
            kotlin.Result.b(r10)     // Catch: java.lang.Throwable -> L6b
            goto L76
        L6b:
            r0 = move-exception
            r10 = r0
            kotlin.Result$a r11 = kotlin.Result.INSTANCE
            java.lang.Object r10 = kotlin.C4849c.a(r10)
            kotlin.Result.b(r10)
        L76:
            Y8.t r10 = Y8.t.f7040a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.sla.SlaChatController$onSlaResult$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
