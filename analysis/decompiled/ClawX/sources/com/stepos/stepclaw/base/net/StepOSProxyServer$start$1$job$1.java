package com.stepos.stepclaw.base.net;

import a6.f0;
import b5.a0;
import f5.c;
import h5.e;
import h5.i;
import java.net.Socket;
import kotlin.Metadata;
import org.bouncycastle.asn1.x509.DisplayText;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.stepos.stepclaw.base.net.StepOSProxyServer$start$1$job$1", f = "StepOSProxyServer.kt", l = {518, DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class StepOSProxyServer$start$1$job$1 extends i implements p {
    final /* synthetic */ Socket $client;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ StepOSProxyServer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSProxyServer$start$1$job$1(StepOSProxyServer stepOSProxyServer, Socket socket, c cVar) {
        super(2, cVar);
        this.this$0 = stepOSProxyServer;
        this.$client = socket;
    }

    @Override // h5.a
    public final c create(Object obj, c cVar) {
        return new StepOSProxyServer$start$1$job$1(this.this$0, this.$client, cVar);
    }

    @Override // p5.p
    public final Object invoke(f0 f0Var, c cVar) {
        return ((StepOSProxyServer$start$1$job$1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
    
        r8.h(r2, r5.f3163b);
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0092  */
    @Override // h5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            g5.a r0 = g5.a.f2984a
            int r1 = r11.label
            b5.a0 r2 = b5.a0.f883a
            r3 = 0
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L36
            if (r1 == r5) goto L23
            if (r1 != r4) goto L1b
            java.lang.Object r11 = r11.L$0
            i6.e r11 = (i6.e) r11
            a.a.c0(r12)     // Catch: java.lang.Throwable -> L18
            goto Lac
        L18:
            r12 = move-exception
            goto Lb6
        L1b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L23:
            int r1 = r11.I$0
            java.lang.Object r5 = r11.L$2
            java.net.Socket r5 = (java.net.Socket) r5
            java.lang.Object r6 = r11.L$1
            com.stepos.stepclaw.base.net.StepOSProxyServer r6 = (com.stepos.stepclaw.base.net.StepOSProxyServer) r6
            java.lang.Object r7 = r11.L$0
            i6.e r7 = (i6.e) r7
            a.a.c0(r12)
            r12 = r7
            goto L94
        L36:
            a.a.c0(r12)
            com.stepos.stepclaw.base.net.StepOSProxyServer r12 = r11.this$0
            i6.e r12 = com.stepos.stepclaw.base.net.StepOSProxyServer.access$getConnectionSemaphore$p(r12)
            com.stepos.stepclaw.base.net.StepOSProxyServer r6 = r11.this$0
            java.net.Socket r1 = r11.$client
            r11.L$0 = r12
            r11.L$1 = r6
            r11.L$2 = r1
            r11.I$0 = r3
            r11.label = r5
            r5 = r12
            i6.h r5 = (i6.h) r5
            r5.getClass()
            int r7 = r5.f3162a
        L55:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r8 = i6.h.f3161g
            int r8 = r8.getAndDecrement(r5)
            if (r8 > r7) goto L55
            if (r8 <= 0) goto L61
        L5f:
            r5 = r2
            goto L8f
        L61:
            f5.c r8 = b8.h.u(r11)
            a6.m r8 = a6.i0.m(r8)
            boolean r9 = r5.a(r8)     // Catch: java.lang.Throwable -> Lbc
            if (r9 != 0) goto L85
        L6f:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r9 = i6.h.f3161g     // Catch: java.lang.Throwable -> Lbc
            int r9 = r9.getAndDecrement(r5)     // Catch: java.lang.Throwable -> Lbc
            if (r9 > r7) goto L6f
            if (r9 <= 0) goto L7f
            a6.l r5 = r5.f3163b     // Catch: java.lang.Throwable -> Lbc
            r8.h(r2, r5)     // Catch: java.lang.Throwable -> Lbc
            goto L85
        L7f:
            boolean r9 = r5.a(r8)     // Catch: java.lang.Throwable -> Lbc
            if (r9 == 0) goto L6f
        L85:
            java.lang.Object r5 = r8.s()
            if (r5 != r0) goto L8c
            goto L8d
        L8c:
            r5 = r2
        L8d:
            if (r5 != r0) goto L5f
        L8f:
            if (r5 != r0) goto L92
            goto Laa
        L92:
            r5 = r1
            r1 = r3
        L94:
            kotlin.jvm.internal.p.b(r5)     // Catch: java.lang.Throwable -> Lb2
            r11.L$0 = r12     // Catch: java.lang.Throwable -> Lb2
            r7 = 0
            r11.L$1 = r7     // Catch: java.lang.Throwable -> Lb2
            r11.L$2 = r7     // Catch: java.lang.Throwable -> Lb2
            r11.I$0 = r1     // Catch: java.lang.Throwable -> Lb2
            r11.I$1 = r3     // Catch: java.lang.Throwable -> Lb2
            r11.label = r4     // Catch: java.lang.Throwable -> Lb2
            java.lang.Object r11 = com.stepos.stepclaw.base.net.StepOSProxyServer.access$handleClient(r6, r5, r11)     // Catch: java.lang.Throwable -> Lb2
            if (r11 != r0) goto Lab
        Laa:
            return r0
        Lab:
            r11 = r12
        Lac:
            i6.h r11 = (i6.h) r11
            r11.b()
            return r2
        Lb2:
            r11 = move-exception
            r10 = r12
            r12 = r11
            r11 = r10
        Lb6:
            i6.h r11 = (i6.h) r11
            r11.b()
            throw r12
        Lbc:
            r11 = move-exception
            r8.A()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.base.net.StepOSProxyServer$start$1$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
