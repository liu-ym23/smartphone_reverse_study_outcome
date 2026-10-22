package com.stepos.ailauncher.chat.view.sla;

import Ua.M;
import Y8.t;
import com.stepos.agentframework.chatcore.send.SendContext;
import com.stepos.ailauncher.chat.view.sla.a;
import com.stepos.ailauncher.sla.SlaGate;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C0919o;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.sla.SlaChatController$armSendTimeout$1", f = "SlaChatController.kt", l = {659, 660}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SlaChatController$armSendTimeout$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ long $budgetMs;
    int label;
    final /* synthetic */ SlaChatController this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.sla.SlaChatController$armSendTimeout$1$1", f = "SlaChatController.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.view.sla.SlaChatController$armSendTimeout$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ long $budgetMs;
        int label;
        final /* synthetic */ SlaChatController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SlaChatController slaChatController, long j10, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = slaChatController;
            this.$budgetMs = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.this$0, this.$budgetMs, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            SendContext sendContext;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            com.stepos.agentframework.chatcore.send.k kVar = this.this$0.pendingArbitrateCb;
            if (kVar != null && (sendContext = this.this$0.pendingArbitrateCtx) != null) {
                C4148a.u("SlaChatController", "arbitrate 全局超时 " + this.$budgetMs + "ms, 强制路由云端", false, 4, null);
                C0919o.c(SlaGate.TAG, "全局超时,强制放行上云", true);
                String str = this.this$0.pendingTraceId;
                this.this$0.T0(new a.Expand(str, "controllerTimeout", true));
                kVar.a(SendContext.b(sendContext, null, null, null, null, kotlin.collections.a.s(sendContext.d(), Y8.j.a("trace_id", str)), false, null, null, 239, null));
                this.this$0.W0(true);
                this.this$0.pendingArbitrateCtx = null;
                this.this$0.pendingArbitrateCb = null;
                return t.f7040a;
            }
            return t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlaChatController$armSendTimeout$1(long j10, SlaChatController slaChatController, InterfaceC4014c<? super SlaChatController$armSendTimeout$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$budgetMs = j10;
        this.this$0 = slaChatController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SlaChatController$armSendTimeout$1(this.$budgetMs, this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((SlaChatController$armSendTimeout$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
    
        if (Ua.C1056g.j(r8, r1, r7) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.C4849c.b(r8)
            goto L43
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1a:
            kotlin.C4849c.b(r8)
            goto L2c
        L1e:
            kotlin.C4849c.b(r8)
            long r4 = r7.$budgetMs
            r7.label = r3
            java.lang.Object r8 = Ua.U.a(r4, r7)
            if (r8 != r0) goto L2c
            goto L42
        L2c:
            Ua.A0 r8 = Ua.Y.c()
            com.stepos.ailauncher.chat.view.sla.SlaChatController$armSendTimeout$1$1 r1 = new com.stepos.ailauncher.chat.view.sla.SlaChatController$armSendTimeout$1$1
            com.stepos.ailauncher.chat.view.sla.SlaChatController r3 = r7.this$0
            long r4 = r7.$budgetMs
            r6 = 0
            r1.<init>(r3, r4, r6)
            r7.label = r2
            java.lang.Object r7 = Ua.C1056g.j(r8, r1, r7)
            if (r7 != r0) goto L43
        L42:
            return r0
        L43:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.sla.SlaChatController$armSendTimeout$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
