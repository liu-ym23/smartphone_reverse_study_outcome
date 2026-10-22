package com.stepos.agentframework.chatcore.session;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$sendApproval$2", f = "AgentSession.kt", l = {1942, 1942}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$sendApproval$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $askUserQuestion;
    final /* synthetic */ String $decision;
    final /* synthetic */ InterfaceC5074l<Boolean, Y8.t> $onResult;
    final /* synthetic */ String $reason;
    final /* synthetic */ String $requestId;
    final /* synthetic */ String $sessionId;
    int label;
    final /* synthetic */ AgentSession this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$sendApproval$2$1", f = "AgentSession.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.chatcore.session.AgentSession$sendApproval$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ boolean $accepted;
        final /* synthetic */ InterfaceC5074l<Boolean, Y8.t> $onResult;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l, boolean z10, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$onResult = interfaceC5074l;
            this.$accepted = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$onResult, this.$accepted, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.$onResult.invoke(C4109a.a(this.$accepted));
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AgentSession$sendApproval$2(AgentSession agentSession, String str, String str2, String str3, String str4, String str5, InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l, InterfaceC4014c<? super AgentSession$sendApproval$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentSession;
        this.$sessionId = str;
        this.$requestId = str2;
        this.$decision = str3;
        this.$reason = str4;
        this.$askUserQuestion = str5;
        this.$onResult = interfaceC5074l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSession$sendApproval$2(this.this$0, this.$sessionId, this.$requestId, this.$decision, this.$reason, this.$askUserQuestion, this.$onResult, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSession$sendApproval$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(2:37|(1:(5:6|7|24|31|32)(2:11|12))(1:13))(5:15|33|16|(1:18)|23)|19|20|35|21|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        if (r11 == r0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
    
        r0 = e;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L24
            if (r1 == r3) goto L20
            if (r1 != r2) goto L18
            kotlin.C4849c.b(r11)     // Catch: java.lang.Exception -> L13
            r9 = r10
            goto L4e
        L13:
            r0 = move-exception
            r11 = r0
            r9 = r10
        L16:
            r2 = r11
            goto L5b
        L18:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L20:
            kotlin.C4849c.b(r11)     // Catch: java.lang.Exception -> L13
            goto L34
        L24:
            kotlin.C4849c.b(r11)
            com.stepos.agentframework.chatcore.session.AgentSession r11 = r10.this$0     // Catch: java.lang.Exception -> L58
            java.lang.String r1 = r10.$sessionId     // Catch: java.lang.Exception -> L58
            r10.label = r3     // Catch: java.lang.Exception -> L58
            java.lang.Object r11 = r11.e1(r1, r10)     // Catch: java.lang.Exception -> L58
            if (r11 != r0) goto L34
            goto L4d
        L34:
            com.stepos.agentframework.chatcore.agents.AgentDispatcher r11 = (com.stepos.agentframework.chatcore.agents.AgentDispatcher) r11     // Catch: java.lang.Exception -> L58
            com.stepos.agentframework.chatcore.agents.u r3 = r11.getClient()     // Catch: java.lang.Exception -> L58
            java.lang.String r4 = r10.$sessionId     // Catch: java.lang.Exception -> L58
            java.lang.String r5 = r10.$requestId     // Catch: java.lang.Exception -> L58
            java.lang.String r6 = r10.$decision     // Catch: java.lang.Exception -> L58
            java.lang.String r7 = r10.$reason     // Catch: java.lang.Exception -> L58
            java.lang.String r8 = r10.$askUserQuestion     // Catch: java.lang.Exception -> L58
            r10.label = r2     // Catch: java.lang.Exception -> L58
            r9 = r10
            java.lang.Object r11 = r3.c(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L55
            if (r11 != r0) goto L4e
        L4d:
            return r0
        L4e:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch: java.lang.Exception -> L55
            boolean r10 = r11.booleanValue()     // Catch: java.lang.Exception -> L55
            goto L7e
        L55:
            r0 = move-exception
        L56:
            r11 = r0
            goto L16
        L58:
            r0 = move-exception
            r9 = r10
            goto L56
        L5b:
            com.stepos.agentframework.chatcore.session.AgentSession r10 = r9.this$0
            java.lang.String r0 = com.stepos.agentframework.chatcore.session.AgentSession.H(r10)
            java.lang.String r10 = r2.getMessage()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r1 = "❌ sendApproval 失败: "
            r11.append(r1)
            r11.append(r10)
            java.lang.String r1 = r11.toString()
            r4 = 8
            r5 = 0
            r3 = 0
            h8.C4148a.g(r0, r1, r2, r3, r4, r5)
            r10 = 0
        L7e:
            com.stepos.agentframework.chatcore.session.AgentSession$sendApproval$2$1 r11 = new com.stepos.agentframework.chatcore.session.AgentSession$sendApproval$2$1
            p9.l<java.lang.Boolean, Y8.t> r0 = r9.$onResult
            r1 = 0
            r11.<init>(r0, r10, r1)
            kotlin.Function2.b(r11)
            Y8.t r10 = Y8.t.f7040a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession$sendApproval$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
