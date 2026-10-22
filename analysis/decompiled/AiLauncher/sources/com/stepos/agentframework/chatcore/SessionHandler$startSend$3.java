package com.stepos.agentframework.chatcore;

import Ua.M;
import com.stepos.agentframework.chatcore.send.SendContext;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.TimeoutKt;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.SessionHandler$startSend$3", f = "SessionHandler.kt", l = {3314}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionHandler$startSend$3 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ p9.q<String, String, InterfaceC4014c<? super Y8.t>, Object> $cancelTasks;
    final /* synthetic */ SendContext $ctx;
    final /* synthetic */ InterfaceC5074l<InterfaceC4014c<? super Y8.t>, Object> $hook;
    int label;
    final /* synthetic */ SessionHandler this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.chatcore.SessionHandler$startSend$3$1", f = "SessionHandler.kt", l = {3317, 3319}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.chatcore.SessionHandler$startSend$3$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ p9.q<String, String, InterfaceC4014c<? super Y8.t>, Object> $cancelTasks;
        final /* synthetic */ InterfaceC5074l<InterfaceC4014c<? super Y8.t>, Object> $hook;
        Object L$0;
        int label;
        final /* synthetic */ SessionHandler this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(SessionHandler sessionHandler, p9.q<? super String, ? super String, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> qVar, InterfaceC5074l<? super InterfaceC4014c<? super Y8.t>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = sessionHandler;
            this.$cancelTasks = qVar;
            this.$hook = interfaceC5074l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.this$0, this.$cancelTasks, this.$hook, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
        
            if (r9.invoke(r8) == r0) goto L31;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                r8 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r8.label
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L27
                if (r1 == r4) goto L1f
                if (r1 != r3) goto L17
                java.lang.Object r8 = r8.L$0
                com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation r8 = (com.stepos.agentframework.chatcore.session.AgentSession.AgentConversation) r8
                kotlin.C4849c.b(r9)
                goto L72
            L17:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L1f:
                java.lang.Object r1 = r8.L$0
                com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation r1 = (com.stepos.agentframework.chatcore.session.AgentSession.AgentConversation) r1
                kotlin.C4849c.b(r9)
                goto L5f
            L27:
                kotlin.C4849c.b(r9)
                com.stepos.agentframework.chatcore.SessionHandler r9 = r8.this$0
                com.stepos.agentframework.chatcore.session.AgentSession r9 = com.stepos.agentframework.chatcore.SessionHandler.Y(r9)
                if (r9 == 0) goto L38
                com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation r9 = r9.getTopConversation()
                r1 = r9
                goto L39
            L38:
                r1 = r2
            L39:
                if (r1 == 0) goto L5f
                p9.q<java.lang.String, java.lang.String, e9.c<? super Y8.t>, java.lang.Object> r9 = r8.$cancelTasks
                if (r9 == 0) goto L5f
                java.lang.String r5 = r1.getSessionId()
                java.lang.String r6 = ""
                if (r5 != 0) goto L48
                r5 = r6
            L48:
                java.lang.String r7 = r1.getTempSessionId()
                if (r7 != 0) goto L4f
                goto L50
            L4f:
                r6 = r7
            L50:
                java.lang.Object r7 = g9.h.a(r1)
                r8.L$0 = r7
                r8.label = r4
                java.lang.Object r9 = r9.invoke(r5, r6, r8)
                if (r9 != r0) goto L5f
                goto L71
            L5f:
                p9.l<e9.c<? super Y8.t>, java.lang.Object> r9 = r8.$hook
                if (r9 == 0) goto L75
                java.lang.Object r1 = g9.h.a(r1)
                r8.L$0 = r1
                r8.label = r3
                java.lang.Object r8 = r9.invoke(r8)
                if (r8 != r0) goto L72
            L71:
                return r0
            L72:
                Y8.t r8 = Y8.t.f7040a
                return r8
            L75:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.SessionHandler$startSend$3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SessionHandler$startSend$3(SessionHandler sessionHandler, SendContext sendContext, p9.q<? super String, ? super String, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> qVar, InterfaceC5074l<? super InterfaceC4014c<? super Y8.t>, ? extends Object> interfaceC5074l, InterfaceC4014c<? super SessionHandler$startSend$3> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = sessionHandler;
        this.$ctx = sendContext;
        this.$cancelTasks = qVar;
        this.$hook = interfaceC5074l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionHandler$startSend$3(this.this$0, this.$ctx, this.$cancelTasks, this.$hook, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SessionHandler$startSend$3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$cancelTasks, this.$hook, null);
            this.label = 1;
            if (TimeoutKt.e(2000L, anonymousClass1, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        this.this$0.G0(this.$ctx);
        return Y8.t.f7040a;
    }
}
