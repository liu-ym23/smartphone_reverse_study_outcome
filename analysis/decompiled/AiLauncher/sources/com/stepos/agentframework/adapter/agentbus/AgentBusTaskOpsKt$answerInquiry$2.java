package com.stepos.agentframework.adapter.agentbus;

import com.stepos.agentframework.adapter.netcore.InquiryAnswerResult;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/agentframework/adapter/netcore/q;", "<anonymous>", "(LUa/M;)Lcom/stepos/agentframework/adapter/netcore/q;"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.adapter.agentbus.AgentBusTaskOpsKt$answerInquiry$2", f = "AgentBusTaskOps.kt", l = {111, 112}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentBusTaskOpsKt$answerInquiry$2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super InquiryAnswerResult>, Object> {
    final /* synthetic */ List<String> $answers;
    final /* synthetic */ String $inquiryId;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ ClawChannelAgentBusBinding $this_answerInquiry;
    final /* synthetic */ long $timeoutMs;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentBusTaskOpsKt$answerInquiry$2(String str, String str2, List<String> list, ClawChannelAgentBusBinding clawChannelAgentBusBinding, long j10, InterfaceC4014c<? super AgentBusTaskOpsKt$answerInquiry$2> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$sessionId = str;
        this.$inquiryId = str2;
        this.$answers = list;
        this.$this_answerInquiry = clawChannelAgentBusBinding;
        this.$timeoutMs = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentBusTaskOpsKt$answerInquiry$2(this.$sessionId, this.$inquiryId, this.$answers, this.$this_answerInquiry, this.$timeoutMs, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super InquiryAnswerResult> interfaceC4014c) {
        return ((AgentBusTaskOpsKt$answerInquiry$2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0078, code lost:
    
        if (r8 == r0) goto L15;
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
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L2a
            if (r1 == r2) goto L22
            if (r1 != r3) goto L1a
            java.lang.Object r0 = r7.L$1
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r7.L$0
            java.util.Map r0 = (java.util.Map) r0
            kotlin.C4849c.b(r8)
            goto L7b
        L1a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L22:
            java.lang.Object r1 = r7.L$0
            java.util.Map r1 = (java.util.Map) r1
            kotlin.C4849c.b(r8)
            goto L60
        L2a:
            kotlin.C4849c.b(r8)
            java.lang.String r8 = "sessionKey"
            java.lang.String r1 = r7.$sessionId
            kotlin.Pair r8 = Y8.j.a(r8, r1)
            java.lang.String r1 = "inquiryId"
            java.lang.String r4 = r7.$inquiryId
            kotlin.Pair r1 = Y8.j.a(r1, r4)
            java.lang.String r4 = "answers"
            java.util.List<java.lang.String> r5 = r7.$answers
            kotlin.Pair r4 = Y8.j.a(r4, r5)
            kotlin.Pair[] r8 = new kotlin.Pair[]{r8, r1, r4}
            java.util.Map r1 = kotlin.collections.a.m(r8)
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r8 = r7.$this_answerInquiry
            java.lang.Object r4 = g9.h.a(r1)
            r7.L$0 = r4
            r7.label = r2
            java.lang.String r4 = "stepclaw.tasks.v2.inquiry.answer"
            java.lang.Object r8 = r8.N(r4, r1, r7)
            if (r8 != r0) goto L60
            goto L7a
        L60:
            java.lang.String r8 = (java.lang.String) r8
            com.stepos.agentframework.adapter.agentbus.ClawChannelAgentBusBinding r4 = r7.$this_answerInquiry
            long r5 = r7.$timeoutMs
            java.lang.Object r1 = g9.h.a(r1)
            r7.L$0 = r1
            java.lang.Object r1 = g9.h.a(r8)
            r7.L$1 = r1
            r7.label = r3
            java.lang.Object r8 = r4.o(r8, r5, r7)
            if (r8 != r0) goto L7b
        L7a:
            return r0
        L7b:
            org.json.JSONObject r8 = (org.json.JSONObject) r8
            r0 = 0
            r1 = 0
            if (r8 != 0) goto L87
            com.stepos.agentframework.adapter.netcore.q r7 = new com.stepos.agentframework.adapter.netcore.q
            r7.<init>(r0, r1, r3, r1)
            return r7
        L87:
            java.lang.String r4 = "ok"
            boolean r4 = r8.optBoolean(r4, r0)
            if (r4 != 0) goto Lc6
            java.lang.String r7 = r7.$inquiryId
            java.lang.String r2 = "error"
            org.json.JSONObject r8 = r8.optJSONObject(r2)
            if (r8 == 0) goto La0
            java.lang.String r2 = "code"
            java.lang.String r8 = r8.optString(r2)
            goto La1
        La0:
            r8 = r1
        La1:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "answerInquiry rejected inquiryId="
            r2.append(r4)
            r2.append(r7)
            java.lang.String r7 = " error="
            r2.append(r7)
            r2.append(r8)
            java.lang.String r7 = r2.toString()
            r8 = 4
            java.lang.String r2 = "ClawChannelAgentBusBinding"
            h8.C4148a.u(r2, r7, r0, r8, r1)
            com.stepos.agentframework.adapter.netcore.q r7 = new com.stepos.agentframework.adapter.netcore.q
            r7.<init>(r0, r1, r3, r1)
            return r7
        Lc6:
            java.lang.String r7 = "payload"
            org.json.JSONObject r7 = r8.optJSONObject(r7)
            if (r7 == 0) goto Ldd
            java.lang.String r8 = "message"
            java.lang.String r7 = r7.optString(r8)
            if (r7 == 0) goto Ldd
            boolean r8 = La.H.x0(r7)
            if (r8 != 0) goto Ldd
            r1 = r7
        Ldd:
            com.stepos.agentframework.adapter.netcore.q r7 = new com.stepos.agentframework.adapter.netcore.q
            r7.<init>(r2, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.AgentBusTaskOpsKt$answerInquiry$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
