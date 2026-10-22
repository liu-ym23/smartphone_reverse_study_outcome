package com.stepos.agentframework.chatcore.session;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.C0917m;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import u4.AgentResponse;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.PushMessageCenter$handlePushToolCall$3", f = "PushMessageCenter.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class PushMessageCenter$handlePushToolCall$3 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ C0917m $chatReplyInfo;
    final /* synthetic */ AgentResponse $response;
    final /* synthetic */ AgentRole $role;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushMessageCenter$handlePushToolCall$3(AgentResponse agentResponse, C0917m c0917m, AgentRole agentRole, InterfaceC4014c<? super PushMessageCenter$handlePushToolCall$3> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$response = agentResponse;
        this.$chatReplyInfo = c0917m;
        this.$role = agentRole;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        PushMessageCenter$handlePushToolCall$3 pushMessageCenter$handlePushToolCall$3 = new PushMessageCenter$handlePushToolCall$3(this.$response, this.$chatReplyInfo, this.$role, interfaceC4014c);
        pushMessageCenter$handlePushToolCall$3.L$0 = obj;
        return pushMessageCenter$handlePushToolCall$3;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((PushMessageCenter$handlePushToolCall$3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0242  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r36) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 866
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.PushMessageCenter$handlePushToolCall$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
