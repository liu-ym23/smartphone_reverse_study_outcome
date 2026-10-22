package com.stepos.agentframework.chatcore.session;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$toolLikeFeedback$1", f = "AgentSession.kt", l = {2351, 2351}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$toolLikeFeedback$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $toolCallId;
    final /* synthetic */ int $toolLikeStatus;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AgentSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentSession$toolLikeFeedback$1(AgentSession agentSession, String str, String str2, int i10, InterfaceC4014c<? super AgentSession$toolLikeFeedback$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentSession;
        this.$messageId = str;
        this.$toolCallId = str2;
        this.$toolLikeStatus = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSession$toolLikeFeedback$1(this.this$0, this.$messageId, this.$toolCallId, this.$toolLikeStatus, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSession$toolLikeFeedback$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00c7 A[Catch: Exception -> 0x001b, TryCatch #0 {Exception -> 0x001b, blocks: (B:7:0x0016, B:35:0x00c7, B:36:0x00d5, B:38:0x00db, B:40:0x00e7, B:41:0x00ed, B:43:0x00f3, B:45:0x0103, B:46:0x0107, B:14:0x0030, B:30:0x00ad, B:17:0x0038, B:19:0x0046, B:22:0x004e, B:24:0x0059, B:26:0x005f), top: B:51:0x0008 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession$toolLikeFeedback$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
