package com.stepos.agentframework.chatcore.session;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$feedback$1", f = "AgentSession.kt", l = {1907, 1907}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$feedback$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ int $likeStatus;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $questionDesc;
    final /* synthetic */ String $questionType;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ String $taskId;
    final /* synthetic */ String $traceId;
    int label;
    final /* synthetic */ AgentSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentSession$feedback$1(AgentSession agentSession, String str, String str2, String str3, int i10, String str4, String str5, String str6, InterfaceC4014c<? super AgentSession$feedback$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentSession;
        this.$sessionId = str;
        this.$traceId = str2;
        this.$messageId = str3;
        this.$likeStatus = i10;
        this.$taskId = str4;
        this.$questionType = str5;
        this.$questionDesc = str6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSession$feedback$1(this.this$0, this.$sessionId, this.$traceId, this.$messageId, this.$likeStatus, this.$taskId, this.$questionType, this.$questionDesc, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSession$feedback$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(2:33|(1:(3:6|29|30)(2:11|12))(1:13))(5:15|34|16|(1:18)|23)|19|20|31|21|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
    
        if (r3.i(r4, r5, r6, r7, r8, r9, r10, r11) == r0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004f, code lost:
    
        r0 = e;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r12.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L24
            if (r1 == r3) goto L20
            if (r1 != r2) goto L18
            kotlin.C4849c.b(r13)     // Catch: java.lang.Exception -> L13
            goto L7a
        L13:
            r0 = move-exception
            r13 = r0
            r11 = r12
        L16:
            r2 = r13
            goto L55
        L18:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L20:
            kotlin.C4849c.b(r13)     // Catch: java.lang.Exception -> L13
            goto L34
        L24:
            kotlin.C4849c.b(r13)
            com.stepos.agentframework.chatcore.session.AgentSession r13 = r12.this$0     // Catch: java.lang.Exception -> L52
            java.lang.String r1 = r12.$sessionId     // Catch: java.lang.Exception -> L52
            r12.label = r3     // Catch: java.lang.Exception -> L52
            java.lang.Object r13 = r13.e1(r1, r12)     // Catch: java.lang.Exception -> L52
            if (r13 != r0) goto L34
            goto L4e
        L34:
            r3 = r13
            com.stepos.agentframework.chatcore.agents.AgentDispatcher r3 = (com.stepos.agentframework.chatcore.agents.AgentDispatcher) r3     // Catch: java.lang.Exception -> L52
            java.lang.String r4 = r12.$traceId     // Catch: java.lang.Exception -> L52
            java.lang.String r5 = r12.$messageId     // Catch: java.lang.Exception -> L52
            java.lang.String r6 = r12.$sessionId     // Catch: java.lang.Exception -> L52
            int r7 = r12.$likeStatus     // Catch: java.lang.Exception -> L52
            java.lang.String r8 = r12.$taskId     // Catch: java.lang.Exception -> L52
            java.lang.String r9 = r12.$questionType     // Catch: java.lang.Exception -> L52
            java.lang.String r10 = r12.$questionDesc     // Catch: java.lang.Exception -> L52
            r12.label = r2     // Catch: java.lang.Exception -> L52
            r11 = r12
            java.lang.Object r12 = r3.i(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L4f
            if (r12 != r0) goto L7a
        L4e:
            return r0
        L4f:
            r0 = move-exception
        L50:
            r13 = r0
            goto L16
        L52:
            r0 = move-exception
            r11 = r12
            goto L50
        L55:
            com.stepos.agentframework.chatcore.session.AgentSession r12 = r11.this$0
            java.lang.String r0 = com.stepos.agentframework.chatcore.session.AgentSession.H(r12)
            java.lang.String r12 = r2.getMessage()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r1 = "❌ Feedback 失败: "
            r13.append(r1)
            r13.append(r12)
            java.lang.String r1 = r13.toString()
            r4 = 8
            r5 = 0
            r3 = 0
            h8.C4148a.g(r0, r1, r2, r3, r4, r5)
            r2.printStackTrace()
        L7a:
            Y8.t r12 = Y8.t.f7040a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession$feedback$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
