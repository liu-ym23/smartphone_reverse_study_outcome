package com.stepos.agentframework.chatcore.session;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.ChatRound$startCotTimingIfNeeded$1", f = "ChatRound.kt", l = {1186}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class ChatRound$startCotTimingIfNeeded$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int label;
    final /* synthetic */ ChatRound this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatRound$startCotTimingIfNeeded$1(ChatRound chatRound, InterfaceC4014c<? super ChatRound$startCotTimingIfNeeded$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = chatRound;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ChatRound$startCotTimingIfNeeded$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ChatRound$startCotTimingIfNeeded$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x002c -> B:14:0x002f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r11.label
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.C4849c.b(r12)
            goto L2f
        Lf:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L17:
            kotlin.C4849c.b(r12)
        L1a:
            com.stepos.agentframework.chatcore.session.ChatRound r12 = r11.this$0
            com.stepos.agentframework.chatcore.session.TalkPhase r12 = r12.getTalkPhase()
            com.stepos.agentframework.chatcore.session.TalkPhase r1 = com.stepos.agentframework.chatcore.session.TalkPhase.FINISHED
            if (r12 == r1) goto L5d
            r11.label = r2
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r12 = Ua.U.a(r3, r11)
            if (r12 != r0) goto L2f
            return r0
        L2f:
            com.stepos.agentframework.chatcore.session.ChatRound r12 = r11.this$0
            com.stepos.agentframework.chatcore.session.TalkPhase r12 = r12.getTalkPhase()
            com.stepos.agentframework.chatcore.session.TalkPhase r1 = com.stepos.agentframework.chatcore.session.TalkPhase.FINISHED
            if (r12 == r1) goto L5d
            com.stepos.agentframework.chatcore.session.ChatRound r12 = r11.this$0
            com.stepos.agentframework.chatcore.session.AgentSession r12 = com.stepos.agentframework.chatcore.session.ChatRound.E(r12)
            com.stepos.agentframework.chatcore.session.L0$h r3 = new com.stepos.agentframework.chatcore.session.L0$h
            com.stepos.agentframework.chatcore.session.ChatRound r1 = r11.this$0
            java.lang.String r4 = com.stepos.agentframework.chatcore.session.ChatRound.A(r1)
            long r5 = java.lang.System.currentTimeMillis()
            com.stepos.agentframework.chatcore.session.ChatRound r1 = r11.this$0
            long r7 = com.stepos.agentframework.chatcore.session.ChatRound.D(r1)
            long r5 = r5 - r7
            r9 = 4
            r10 = 0
            r7 = 0
            r3.<init>(r4, r5, r7, r9, r10)
            r12.B0(r3)
            goto L1a
        L5d:
            Y8.t r11 = Y8.t.f7040a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.ChatRound$startCotTimingIfNeeded$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
