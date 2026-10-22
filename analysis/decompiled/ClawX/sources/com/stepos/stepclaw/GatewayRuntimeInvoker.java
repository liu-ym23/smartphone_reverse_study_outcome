package com.stepos.stepclaw;

import com.stepos.stepclaw.bridge.spi.GatewayInvoker;
import com.stepos.stepclaw.gateway.GatewaySession;
import h5.e;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0096@¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/stepclaw/GatewayRuntimeInvoker;", "Lcom/stepos/stepclaw/bridge/spi/GatewayInvoker;", "Lcom/stepos/stepclaw/gateway/GatewaySession;", "session", "<init>", "(Lcom/stepos/stepclaw/gateway/GatewaySession;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "method", "paramsJson", "Lcom/stepos/stepclaw/bridge/spi/InvokeResult;", "invoke", "(Ljava/lang/String;Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "Lcom/stepos/stepclaw/gateway/GatewaySession;", "app_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
final class GatewayRuntimeInvoker implements GatewayInvoker {
    private final GatewaySession session;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @e(c = "com.stepos.stepclaw.GatewayRuntimeInvoker", f = "GatewayRuntime.kt", l = {561}, m = "invoke", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.GatewayRuntimeInvoker$invoke$1, reason: invalid class name */
    public static final class AnonymousClass1 extends h5.c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GatewayRuntimeInvoker.this.invoke(null, null, this);
        }
    }

    public GatewayRuntimeInvoker(GatewaySession session) {
        p.e(session, "session");
        this.session = session;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.stepos.stepclaw.bridge.spi.GatewayInvoker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object invoke(java.lang.String r10, java.lang.String r11, f5.c r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.stepos.stepclaw.GatewayRuntimeInvoker.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r12
            com.stepos.stepclaw.GatewayRuntimeInvoker$invoke$1 r0 = (com.stepos.stepclaw.GatewayRuntimeInvoker.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.stepos.stepclaw.GatewayRuntimeInvoker$invoke$1 r0 = new com.stepos.stepclaw.GatewayRuntimeInvoker$invoke$1
            r0.<init>(r12)
            goto L12
        L1a:
            java.lang.Object r12 = r6.result
            g5.a r0 = g5.a.f2984a
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            java.lang.Object r9 = r6.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r9 = r6.L$0
            java.lang.String r9 = (java.lang.String) r9
            a.a.c0(r12)     // Catch: java.lang.Throwable -> L5b
            goto L52
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L39:
            a.a.c0(r12)
            com.stepos.stepclaw.gateway.GatewaySession r1 = r9.session     // Catch: java.lang.Throwable -> L5b
            r9 = 0
            r6.L$0 = r9     // Catch: java.lang.Throwable -> L5b
            r6.L$1 = r9     // Catch: java.lang.Throwable -> L5b
            r6.label = r2     // Catch: java.lang.Throwable -> L5b
            r4 = 0
            r7 = 4
            r8 = 0
            r2 = r10
            r3 = r11
            java.lang.Object r12 = com.stepos.stepclaw.gateway.GatewaySession.request$default(r1, r2, r3, r4, r6, r7, r8)     // Catch: java.lang.Throwable -> L5b
            if (r12 != r0) goto L52
            return r0
        L52:
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Throwable -> L5b
            com.stepos.stepclaw.bridge.spi.InvokeResult$Companion r9 = com.stepos.stepclaw.bridge.spi.InvokeResult.INSTANCE     // Catch: java.lang.Throwable -> L5b
            com.stepos.stepclaw.bridge.spi.InvokeResult r9 = r9.ok(r12)     // Catch: java.lang.Throwable -> L5b
            return r9
        L5b:
            r0 = move-exception
            r9 = r0
            com.stepos.stepclaw.bridge.spi.InvokeResult$Companion r10 = com.stepos.stepclaw.bridge.spi.InvokeResult.INSTANCE
            java.lang.String r11 = r9.getMessage()
            if (r11 != 0) goto L6d
            java.lang.Class r9 = r9.getClass()
            java.lang.String r11 = r9.getSimpleName()
        L6d:
            java.lang.String r9 = "INVOKE_FAILED"
            com.stepos.stepclaw.bridge.spi.InvokeResult r9 = r10.error(r9, r11)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.GatewayRuntimeInvoker.invoke(java.lang.String, java.lang.String, f5.c):java.lang.Object");
    }
}
