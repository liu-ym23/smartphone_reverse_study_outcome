package com.stepos.stepclaw.gateway;

import a6.f0;
import b5.a0;
import com.stepos.stepclaw.gateway.GatewaySession;
import h5.i;
import kotlin.Metadata;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
@h5.e(c = "com.stepos.stepclaw.gateway.GatewaySession$Connection$handleInvokeEvent$1", f = "GatewaySession.kt", l = {680, 685}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class GatewaySession$Connection$handleInvokeEvent$1 extends i implements p {
    final /* synthetic */ String $command;
    final /* synthetic */ String $id;
    final /* synthetic */ String $nodeId;
    final /* synthetic */ String $params;
    final /* synthetic */ Long $timeoutMs;
    final /* synthetic */ String $toolCallId;
    Object L$0;
    int label;
    final /* synthetic */ GatewaySession this$0;
    final /* synthetic */ GatewaySession.Connection this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySession$Connection$handleInvokeEvent$1(GatewaySession gatewaySession, String str, String str2, String str3, String str4, Long l3, String str5, GatewaySession.Connection connection, f5.c cVar) {
        super(2, cVar);
        this.this$0 = gatewaySession;
        this.$id = str;
        this.$nodeId = str2;
        this.$command = str3;
        this.$params = str4;
        this.$timeoutMs = l3;
        this.$toolCallId = str5;
        this.this$1 = connection;
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        return new GatewaySession$Connection$handleInvokeEvent$1(this.this$0, this.$id, this.$nodeId, this.$command, this.$params, this.$timeoutMs, this.$toolCallId, this.this$1, cVar);
    }

    @Override // p5.p
    public final Object invoke(f0 f0Var, f5.c cVar) {
        return ((GatewaySession$Connection$handleInvokeEvent$1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
    
        if (r3.sendInvokeResult(r4, r5, r6, r7, r11) != r1) goto L27;
     */
    @Override // h5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            g5.a r1 = g5.a.f2984a
            int r0 = r11.label
            r2 = 2
            r3 = 1
            if (r0 == 0) goto L23
            if (r0 == r3) goto L1c
            if (r0 != r2) goto L14
            java.lang.Object r11 = r11.L$0
            com.stepos.stepclaw.gateway.GatewaySession$InvokeResult r11 = (com.stepos.stepclaw.gateway.GatewaySession.InvokeResult) r11
            a.a.c0(r12)
            goto L74
        L14:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L1c:
            a.a.c0(r12)     // Catch: java.lang.Throwable -> L20
            goto L48
        L20:
            r0 = move-exception
            r12 = r0
            goto L58
        L23:
            a.a.c0(r12)
            com.stepos.stepclaw.gateway.GatewaySession r12 = r11.this$0     // Catch: java.lang.Throwable -> L20
            p5.p r12 = com.stepos.stepclaw.gateway.GatewaySession.access$getOnInvoke$p(r12)     // Catch: java.lang.Throwable -> L20
            if (r12 == 0) goto L4c
            com.stepos.stepclaw.gateway.GatewaySession$InvokeRequest r4 = new com.stepos.stepclaw.gateway.GatewaySession$InvokeRequest     // Catch: java.lang.Throwable -> L20
            java.lang.String r5 = r11.$id     // Catch: java.lang.Throwable -> L20
            java.lang.String r6 = r11.$nodeId     // Catch: java.lang.Throwable -> L20
            java.lang.String r7 = r11.$command     // Catch: java.lang.Throwable -> L20
            java.lang.String r8 = r11.$params     // Catch: java.lang.Throwable -> L20
            java.lang.Long r9 = r11.$timeoutMs     // Catch: java.lang.Throwable -> L20
            java.lang.String r10 = r11.$toolCallId     // Catch: java.lang.Throwable -> L20
            r4.<init>(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L20
            r11.label = r3     // Catch: java.lang.Throwable -> L20
            java.lang.Object r12 = r12.invoke(r4, r11)     // Catch: java.lang.Throwable -> L20
            if (r12 != r1) goto L48
            goto L73
        L48:
            com.stepos.stepclaw.gateway.GatewaySession$InvokeResult r12 = (com.stepos.stepclaw.gateway.GatewaySession.InvokeResult) r12     // Catch: java.lang.Throwable -> L20
            if (r12 != 0) goto L56
        L4c:
            com.stepos.stepclaw.gateway.GatewaySession$InvokeResult$Companion r12 = com.stepos.stepclaw.gateway.GatewaySession.InvokeResult.INSTANCE     // Catch: java.lang.Throwable -> L20
            java.lang.String r0 = "UNAVAILABLE"
            java.lang.String r3 = "invoke handler missing"
            com.stepos.stepclaw.gateway.GatewaySession$InvokeResult r12 = r12.error(r0, r3)     // Catch: java.lang.Throwable -> L20
        L56:
            r6 = r12
            goto L5f
        L58:
            com.stepos.stepclaw.gateway.GatewaySession$Connection r0 = r11.this$1
            com.stepos.stepclaw.gateway.GatewaySession$InvokeResult r12 = com.stepos.stepclaw.gateway.GatewaySession.Connection.access$invokeErrorFromThrowable(r0, r12)
            goto L56
        L5f:
            com.stepos.stepclaw.gateway.GatewaySession$Connection r3 = r11.this$1
            java.lang.String r4 = r11.$id
            java.lang.String r5 = r11.$nodeId
            java.lang.Long r7 = r11.$timeoutMs
            r12 = 0
            r11.L$0 = r12
            r11.label = r2
            r8 = r11
            java.lang.Object r11 = com.stepos.stepclaw.gateway.GatewaySession.Connection.access$sendInvokeResult(r3, r4, r5, r6, r7, r8)
            if (r11 != r1) goto L74
        L73:
            return r1
        L74:
            b5.a0 r11 = b5.a0.f883a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewaySession$Connection$handleInvokeEvent$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
