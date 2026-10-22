package com.stepos.ailauncher.chat.session;

import Ua.M;
import Y8.t;
import com.stepos.agentframework.chatcore.session.list.SessionPendingActionKind;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.session.ChatRoundUserDecisionHold$persistPending$1", f = "ChatRoundUserDecisionHold.kt", l = {95, 104}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ChatRoundUserDecisionHold$persistPending$1 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ long $expiresAt;
    final /* synthetic */ SessionPendingActionKind $kind;
    final /* synthetic */ long $now;
    final /* synthetic */ String $requestId;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ long $timeoutMs;
    final /* synthetic */ boolean $viewing;
    final /* synthetic */ String $visible;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatRoundUserDecisionHold$persistPending$1(String str, String str2, boolean z10, long j10, String str3, SessionPendingActionKind sessionPendingActionKind, long j11, long j12, InterfaceC4014c<? super ChatRoundUserDecisionHold$persistPending$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$visible = str;
        this.$sessionId = str2;
        this.$viewing = z10;
        this.$now = j10;
        this.$requestId = str3;
        this.$kind = sessionPendingActionKind;
        this.$expiresAt = j11;
        this.$timeoutMs = j12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ChatRoundUserDecisionHold$persistPending$1(this.$visible, this.$sessionId, this.$viewing, this.$now, this.$requestId, this.$kind, this.$expiresAt, this.$timeoutMs, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((ChatRoundUserDecisionHold$persistPending$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d9, code lost:
    
        if (r2.c(r4, r16) == r9) goto L35;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.session.ChatRoundUserDecisionHold$persistPending$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
