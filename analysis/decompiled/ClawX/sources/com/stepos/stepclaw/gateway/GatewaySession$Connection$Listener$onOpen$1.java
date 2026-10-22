package com.stepos.stepclaw.gateway;

import a6.f0;
import b5.a0;
import com.stepos.stepclaw.gateway.GatewaySession;
import h5.i;
import kotlin.Metadata;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
@h5.e(c = "com.stepos.stepclaw.gateway.GatewaySession$Connection$Listener$onOpen$1", f = "GatewaySession.kt", l = {407, 408}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class GatewaySession$Connection$Listener$onOpen$1 extends i implements p {
    Object L$0;
    int label;
    final /* synthetic */ GatewaySession.Connection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySession$Connection$Listener$onOpen$1(GatewaySession.Connection connection, f5.c cVar) {
        super(2, cVar);
        this.this$0 = connection;
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        return new GatewaySession$Connection$Listener$onOpen$1(this.this$0, cVar);
    }

    @Override // p5.p
    public final Object invoke(f0 f0Var, f5.c cVar) {
        return ((GatewaySession$Connection$Listener$onOpen$1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
    
        if (r1.sendConnect((java.lang.String) r5, r4) == r0) goto L21;
     */
    @Override // h5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            g5.a r0 = g5.a.f2984a
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r0 = r4.L$0
            java.lang.String r0 = (java.lang.String) r0
            a.a.c0(r5)     // Catch: java.lang.Throwable -> L14
            goto L5d
        L14:
            r5 = move-exception
            goto L40
        L16:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L1e:
            a.a.c0(r5)     // Catch: java.lang.Throwable -> L14
            goto L30
        L22:
            a.a.c0(r5)
            com.stepos.stepclaw.gateway.GatewaySession$Connection r5 = r4.this$0     // Catch: java.lang.Throwable -> L14
            r4.label = r3     // Catch: java.lang.Throwable -> L14
            java.lang.Object r5 = com.stepos.stepclaw.gateway.GatewaySession.Connection.access$awaitConnectNonce(r5, r4)     // Catch: java.lang.Throwable -> L14
            if (r5 != r0) goto L30
            goto L3f
        L30:
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L14
            com.stepos.stepclaw.gateway.GatewaySession$Connection r1 = r4.this$0     // Catch: java.lang.Throwable -> L14
            r3 = 0
            r4.L$0 = r3     // Catch: java.lang.Throwable -> L14
            r4.label = r2     // Catch: java.lang.Throwable -> L14
            java.lang.Object r4 = com.stepos.stepclaw.gateway.GatewaySession.Connection.access$sendConnect(r1, r5, r4)     // Catch: java.lang.Throwable -> L14
            if (r4 != r0) goto L5d
        L3f:
            return r0
        L40:
            com.stepos.stepclaw.gateway.GatewaySession$Connection r0 = r4.this$0
            a6.r r0 = com.stepos.stepclaw.gateway.GatewaySession.Connection.access$getConnectDeferred$p(r0)
            com.stepos.stepclaw.gateway.GatewaySession$BusinessLayerFailure r1 = new com.stepos.stepclaw.gateway.GatewaySession$BusinessLayerFailure
            java.lang.String r2 = r5.getMessage()
            if (r2 != 0) goto L50
            java.lang.String r2 = "connect rejected"
        L50:
            r1.<init>(r2, r5)
            a6.s r0 = (a6.s) r0
            r0.f0(r1)
            com.stepos.stepclaw.gateway.GatewaySession$Connection r4 = r4.this$0
            r4.closeQuietly()
        L5d:
            b5.a0 r4 = b5.a0.f883a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.gateway.GatewaySession$Connection$Listener$onOpen$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
