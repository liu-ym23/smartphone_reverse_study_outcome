package com.stepos.agentframework.chatcore.send;

import Ua.Q;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.ailauncher.sla.SlaGate;
import h8.C4148a;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C0919o;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0002-.B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00130)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/stepos/agentframework/chatcore/send/SendPipeline;", "", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "handler", "<init>", "(Lcom/stepos/agentframework/chatcore/SessionHandler;)V", "Lcom/stepos/agentframework/chatcore/send/e;", "rawCtx", "LY8/t;", "p", "(Lcom/stepos/agentframework/chatcore/send/e;)V", "m", "()V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", "Lcom/stepos/agentframework/chatcore/send/AuditStage;", "k", "()Lcom/stepos/agentframework/chatcore/send/AuditStage;", "Lcom/stepos/agentframework/chatcore/send/SendPipeline$b;", "send", "f", "(Lcom/stepos/agentframework/chatcore/send/SendPipeline$b;)V", "ctx", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/agentframework/chatcore/send/e;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "Lcom/stepos/agentframework/chatcore/send/j;", "slaArbiter", "Lcom/stepos/agentframework/chatcore/send/j;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lcom/stepos/agentframework/chatcore/send/j;", "o", "(Lcom/stepos/agentframework/chatcore/send/j;)V", "Lcom/stepos/agentframework/chatcore/send/g;", "sendUiBridge", "Lcom/stepos/agentframework/chatcore/send/g;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lcom/stepos/agentframework/chatcore/send/g;", "n", "(Lcom/stepos/agentframework/chatcore/send/g;)V", "Ljava/util/concurrent/CopyOnWriteArrayList;", "inflight", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SendPipeline {
    private static final a Companion = new a(null);
    private static final String TAG = "SendPipeline";
    private final SessionHandler handler;
    private final CopyOnWriteArrayList<b> inflight;
    private g sendUiBridge;
    private j slaArbiter;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/chatcore/send/SendPipeline$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\n\"\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\n¨\u0006 "}, d2 = {"Lcom/stepos/agentframework/chatcore/send/SendPipeline$b;", "", "Lcom/stepos/agentframework/chatcore/send/e;", "ctx", "Lcom/stepos/agentframework/chatcore/send/AuditStage;", "audit", "<init>", "(Lcom/stepos/agentframework/chatcore/send/e;Lcom/stepos/agentframework/chatcore/send/AuditStage;)V", "", Const.INTENT_KEY_APIKEY, "()Z", "Lcom/stepos/agentframework/chatcore/send/e;", Const.INTENT_KEY_UMID, "()Lcom/stepos/agentframework/chatcore/send/e;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/agentframework/chatcore/send/e;)V", "Lcom/stepos/agentframework/chatcore/send/AuditStage;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/chatcore/send/AuditStage;", "slaRacing", "Z", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Z)V", "slaReported", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/util/concurrent/atomic/AtomicBoolean;", "outcomeClaimed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "c", "committed", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b {
        private final AuditStage audit;
        private SendContext ctx;
        private final AtomicBoolean outcomeClaimed;
        private volatile boolean slaRacing;
        private volatile boolean slaReported;

        public b(SendContext ctx, AuditStage audit) {
            p.i(ctx, "ctx");
            p.i(audit, "audit");
            this.ctx = ctx;
            this.audit = audit;
            this.outcomeClaimed = new AtomicBoolean(false);
        }

        public final boolean a() {
            return this.outcomeClaimed.compareAndSet(false, true);
        }

        /* renamed from: b, reason: from getter */
        public final AuditStage getAudit() {
            return this.audit;
        }

        public final boolean c() {
            return this.outcomeClaimed.get();
        }

        /* renamed from: d, reason: from getter */
        public final SendContext getCtx() {
            return this.ctx;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getSlaRacing() {
            return this.slaRacing;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getSlaReported() {
            return this.slaReported;
        }

        public final void g(SendContext sendContext) {
            p.i(sendContext, "<set-?>");
            this.ctx = sendContext;
        }

        public final void h(boolean z10) {
            this.slaRacing = z10;
        }

        public final void i(boolean z10) {
            this.slaReported = z10;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"com/stepos/agentframework/chatcore/send/SendPipeline$c", "Lcom/stepos/agentframework/chatcore/send/k;", "Lcom/stepos/agentframework/chatcore/send/e;", "ctx", "Lcom/stepos/agentframework/chatcore/send/b;", "result", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/send/e;Lcom/stepos/agentframework/chatcore/send/b;)V", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/send/e;)V", "c", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements k {
        final /* synthetic */ b $send;
        final /* synthetic */ SendPipeline this$0;

        public c(b bVar, SendPipeline sendPipeline) {
            this.$send = bVar;
            this.this$0 = sendPipeline;
        }

        @Override // com.stepos.agentframework.chatcore.send.k
        public void a(SendContext ctx) {
            p.i(ctx, "ctx");
            b bVar = this.$send;
            if (ctx.getSlaAnchor() == null) {
                ctx = SendContext.b(ctx, null, null, null, null, null, false, null, this.$send.getCtx().getSlaAnchor(), 127, null);
            }
            bVar.g(ctx);
            this.$send.h(false);
            this.this$0.f(this.$send);
        }

        @Override // com.stepos.agentframework.chatcore.send.k
        public void b(SendContext ctx, LocalExecResult result) {
            p.i(ctx, "ctx");
            p.i(result, "result");
            if (!this.$send.a()) {
                C4148a.u(SendPipeline.TAG, "onLocalHandled 忽略: 本轮终态已落(已上云)", false, 4, null);
                C0919o.k("框架·重复终态丢弃(onLocalHandled)");
                return;
            }
            this.$send.getAudit().c();
            this.this$0.handler.a1(ctx.getSlaAnchor());
            if (!this.$send.getSlaReported()) {
                this.$send.i(true);
                this.this$0.handler.q3(ctx, result);
            }
            this.this$0.inflight.remove(this.$send);
        }

        @Override // com.stepos.agentframework.chatcore.send.k
        public void c(SendContext ctx) {
            p.i(ctx, "ctx");
            if (!this.$send.a()) {
                C4148a.u(SendPipeline.TAG, "onAborted 忽略: 本轮终态已落", false, 4, null);
                C0919o.k("框架·重复终态丢弃(onAborted)");
                return;
            }
            this.$send.getAudit().c();
            SessionHandler sessionHandler = this.this$0.handler;
            SlaSessionAnchor slaAnchor = ctx.getSlaAnchor();
            if (slaAnchor == null) {
                slaAnchor = this.$send.getCtx().getSlaAnchor();
            }
            sessionHandler.a1(slaAnchor);
            this.this$0.inflight.remove(this.$send);
        }
    }

    public SendPipeline(SessionHandler handler) {
        p.i(handler, "handler");
        this.handler = handler;
        this.inflight = new CopyOnWriteArrayList<>();
    }

    public static final Q l(SendPipeline sendPipeline, InterfaceC5074l block) {
        p.i(block, "block");
        return sendPipeline.handler.z0(new SendPipeline$newAuditStage$1$1(block, null));
    }

    public final void f(b send) {
        if (!send.a()) {
            String text = send.getCtx().getText();
            C4148a.u(TAG, "commit 忽略: 本轮终态已落，不重复上云 text=" + (text != null ? text.length() : 0) + "字", false, 4, null);
            C0919o.k("框架·重复上云丢弃(commit)");
            return;
        }
        SendContext ctx = send.getCtx();
        AuditStage audit = send.getAudit();
        g gVar = this.sendUiBridge;
        C0919o.k("框架·准备发送云(proceed)");
        if (audit.e(ctx)) {
            this.handler.m2(new SendPipeline$commit$2(audit, this, ctx, gVar, send, null));
        } else {
            C0919o.k("框架·安审跳过(未启用/空文本)→直接上云");
            this.handler.m2(new SendPipeline$commit$1(this, ctx, send, null));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(com.stepos.agentframework.chatcore.send.SendContext r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.agentframework.chatcore.send.SendPipeline$commitToCloud$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.agentframework.chatcore.send.SendPipeline$commitToCloud$1 r0 = (com.stepos.agentframework.chatcore.send.SendPipeline$commitToCloud$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.send.SendPipeline$commitToCloud$1 r0 = new com.stepos.agentframework.chatcore.send.SendPipeline$commitToCloud$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r6 = r0.L$0
            com.stepos.agentframework.chatcore.send.e r6 = (com.stepos.agentframework.chatcore.send.SendContext) r6
            kotlin.C4849c.b(r7)
            goto L59
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.C4849c.b(r7)
            com.stepos.agentframework.chatcore.send.g r7 = r5.sendUiBridge
            if (r7 == 0) goto L3f
            r7.A(r6)
        L3f:
            java.lang.String r7 = "框架·组装并上云"
            kotlin.C0919o.k(r7)
            com.stepos.agentframework.chatcore.SessionHandler r7 = r5.handler
            java.util.List r2 = r6.f()
            com.stepos.agentframework.chatcore.send.l r4 = r6.getSlaAnchor()
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.x3(r2, r4, r0)
            if (r7 != r1) goto L59
            return r1
        L59:
            java.util.List r7 = (java.util.List) r7
            java.lang.String r0 = r6.getText()
            java.util.List r7 = com.stepos.agentframework.chatcore.send.c.a(r0, r7)
            com.stepos.agentframework.chatcore.SessionHandler r5 = r5.handler
            boolean r0 = r6.getUseDeepThink()
            java.util.Map r1 = r6.d()
            com.stepos.agentframework.chatcore.send.l r6 = r6.getSlaAnchor()
            r5.s3(r7, r0, r1, r6)
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.send.SendPipeline.g(com.stepos.agentframework.chatcore.send.e, e9.c):java.lang.Object");
    }

    /* renamed from: h, reason: from getter */
    public final g getSendUiBridge() {
        return this.sendUiBridge;
    }

    /* renamed from: i, reason: from getter */
    public final j getSlaArbiter() {
        return this.slaArbiter;
    }

    public final boolean j() {
        return !this.inflight.isEmpty();
    }

    public final AuditStage k() {
        return new AuditStage(new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.send.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return SendPipeline.l(this.f22461a, (InterfaceC5074l) obj);
            }
        }, new SendPipeline$newAuditStage$2(null));
    }

    public final void m() {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = this.inflight;
        ArrayList<b> arrayList = new ArrayList();
        for (Object obj : copyOnWriteArrayList) {
            b bVar = (b) obj;
            if (!bVar.c() && !bVar.getSlaRacing()) {
                arrayList.add(obj);
            }
        }
        for (b bVar2 : arrayList) {
            C0919o.k("框架·detach取消未提交发送");
            bVar2.getAudit().c();
            this.handler.a1(bVar2.getCtx().getSlaAnchor());
            this.inflight.remove(bVar2);
        }
    }

    public final void n(g gVar) {
        this.sendUiBridge = gVar;
    }

    public final void o(j jVar) {
        this.slaArbiter = jVar;
    }

    public final void p(SendContext rawCtx) {
        p.i(rawCtx, "rawCtx");
        if (rawCtx.getSlaAnchor() == null) {
            rawCtx = SendContext.b(rawCtx, null, null, null, null, null, false, null, this.handler.y2(), 127, null);
        }
        b bVar = new b(rawCtx, k());
        this.inflight.add(bVar);
        bVar.getAudit().f(rawCtx);
        this.handler.U3(rawCtx);
        j jVar = this.slaArbiter;
        if (jVar == null || !jVar.d(rawCtx)) {
            C0919o.k("框架·无SLA直接放行");
            f(bVar);
        } else {
            C0919o.b(SlaGate.TAG, "进入竞速拦截");
            bVar.h(true);
            jVar.e(rawCtx, new c(bVar, this));
        }
    }
}
