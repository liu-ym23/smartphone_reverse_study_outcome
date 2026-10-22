package com.stepos.agentframework.chatcore;

import Ua.M;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.SessionHandler$replayAssistantWithTyping$1", f = "SessionHandler.kt", l = {2888}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class SessionHandler$replayAssistantWithTyping$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ int $chunk;
    final /* synthetic */ String $fullText;
    final /* synthetic */ ChatMessage $message;
    final /* synthetic */ int $start;
    int I$0;
    int label;
    final /* synthetic */ SessionHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionHandler$replayAssistantWithTyping$1(int i10, int i11, String str, SessionHandler sessionHandler, ChatMessage chatMessage, InterfaceC4014c<? super SessionHandler$replayAssistantWithTyping$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$start = i10;
        this.$chunk = i11;
        this.$fullText = str;
        this.this$0 = sessionHandler;
        this.$message = chatMessage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SessionHandler$replayAssistantWithTyping$1(this.$start, this.$chunk, this.$fullText, this.this$0, this.$message, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((SessionHandler$replayAssistantWithTyping$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0055 -> B:6:0x0010). Please report as a decompilation issue!!! */
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
            if (r1 == 0) goto L1a
            if (r1 != r2) goto L12
            int r1 = r7.I$0
            kotlin.C4849c.b(r8)
        L10:
            r8 = r1
            goto L1f
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L1a:
            kotlin.C4849c.b(r8)
            int r8 = r7.$start
        L1f:
            int r1 = r7.$chunk
            int r1 = r1 + r8
            java.lang.String r8 = r7.$fullText
            int r8 = r8.length()
            if (r1 >= r8) goto L58
            com.stepos.agentframework.chatcore.SessionHandler r8 = r7.this$0
            com.stepos.agentframework.chatcore.c r8 = r8.getChatView()
            if (r8 == 0) goto L4b
            com.stepos.agentframework.chatcore.SessionHandler r3 = r7.this$0
            w4.c r4 = r7.$message
            java.lang.String r5 = r7.$fullText
            r6 = 0
            java.lang.String r5 = r5.substring(r6, r1)
            java.lang.String r6 = "substring(...)"
            kotlin.jvm.internal.p.h(r5, r6)
            com.stepos.agentframework.chatcore.session.EReplyStatus r6 = com.stepos.agentframework.chatcore.session.EReplyStatus.REPLYING
            w4.c r3 = com.stepos.agentframework.chatcore.SessionHandler.N(r3, r4, r5, r6)
            r8.r(r3)
        L4b:
            r7.I$0 = r1
            r7.label = r2
            r3 = 260(0x104, double:1.285E-321)
            java.lang.Object r8 = Ua.U.a(r3, r7)
            if (r8 != r0) goto L10
            return r0
        L58:
            w4.c r8 = r7.$message
            com.stepos.agentframework.chatcore.session.EReplyStatus r0 = com.stepos.agentframework.chatcore.session.EReplyStatus.COMPLETED
            r8.U(r0)
            com.stepos.agentframework.chatcore.SessionHandler r8 = r7.this$0
            com.stepos.agentframework.chatcore.c r8 = r8.getChatView()
            if (r8 == 0) goto L6c
            w4.c r7 = r7.$message
            r8.r(r7)
        L6c:
            Y8.t r7 = Y8.t.f7040a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.SessionHandler$replayAssistantWithTyping$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
