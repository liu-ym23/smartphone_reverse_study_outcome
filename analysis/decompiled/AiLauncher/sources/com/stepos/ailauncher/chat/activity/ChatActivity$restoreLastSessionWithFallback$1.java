package com.stepos.ailauncher.chat.activity;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.activity.ChatActivity$restoreLastSessionWithFallback$1", f = "ChatActivity.kt", l = {4444, 4445}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ChatActivity$restoreLastSessionWithFallback$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $candidate;
    final /* synthetic */ int $seq;
    Object L$0;
    int label;
    final /* synthetic */ ChatActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatActivity$restoreLastSessionWithFallback$1(ChatActivity chatActivity, String str, int i10, InterfaceC4014c<? super ChatActivity$restoreLastSessionWithFallback$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = chatActivity;
        this.$candidate = str;
        this.$seq = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ChatActivity$restoreLastSessionWithFallback$1(this.this$0, this.$candidate, this.$seq, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ChatActivity$restoreLastSessionWithFallback$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0052, code lost:
    
        if (r9 == r0) goto L15;
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
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L22
            if (r1 == r2) goto L1e
            if (r1 != r3) goto L16
            java.lang.Object r0 = r8.L$0
            com.stepos.agentframework.chatcore.SessionHandler r0 = (com.stepos.agentframework.chatcore.SessionHandler) r0
            kotlin.C4849c.b(r9)
            goto L55
        L16:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L1e:
            kotlin.C4849c.b(r9)
            goto L3c
        L22:
            kotlin.C4849c.b(r9)
            com.stepos.ailauncher.chat.activity.ChatActivity r9 = r8.this$0
            com.stepos.ailauncher.chat.fragment.I0 r9 = com.stepos.ailauncher.chat.activity.ChatActivity.F5(r9)
            Xa.t r9 = r9.l()
            Xa.b r9 = Xa.d.x(r9)
            r8.label = r2
            java.lang.Object r9 = Xa.d.y(r9, r8)
            if (r9 != r0) goto L3c
            goto L54
        L3c:
            com.stepos.ailauncher.chat.fragment.I0$a r9 = (com.stepos.ailauncher.chat.fragment.I0.ChatCoreHandle) r9
            com.stepos.agentframework.chatcore.SessionHandler r9 = r9.getHandler()
            com.stepos.ailauncher.chat.wake.RestoreSessionResolver r1 = com.stepos.ailauncher.chat.wake.RestoreSessionResolver.INSTANCE
            java.lang.String r2 = r8.$candidate
            java.lang.Object r4 = g9.h.a(r9)
            r8.L$0 = r4
            r8.label = r3
            java.lang.Object r9 = r1.a(r2, r9, r8)
            if (r9 != r0) goto L55
        L54:
            return r0
        L55:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 != 0) goto L5c
            Y8.t r8 = Y8.t.f7040a
            return r8
        L5c:
            java.lang.String r0 = r8.$candidate
            boolean r0 = kotlin.jvm.internal.p.d(r9, r0)
            if (r0 == 0) goto L6a
            com.stepos.ailauncher.chat.sheet.C2739j.d(r9)
            Y8.t r8 = Y8.t.f7040a
            return r8
        L6a:
            com.stepos.ailauncher.chat.activity.ChatActivity r0 = r8.this$0
            int r0 = com.stepos.ailauncher.chat.activity.ChatActivity.J5(r0)
            int r1 = r8.$seq
            r2 = 4
            java.lang.String r4 = "ChatActivityRestore"
            r5 = 0
            r6 = 0
            if (r0 == r1) goto L91
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "session switched during resolve, drop fallback="
            r8.append(r0)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            h8.C4148a.k(r4, r8, r6, r2, r5)
            Y8.t r8 = Y8.t.f7040a
            return r8
        L91:
            java.lang.String r0 = r8.$candidate
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r7 = "fallback: candidate="
            r1.append(r7)
            r1.append(r0)
            java.lang.String r0 = " -> "
            r1.append(r0)
            r1.append(r9)
            java.lang.String r0 = r1.toString()
            h8.C4148a.k(r4, r0, r6, r2, r5)
            com.stepos.ailauncher.chat.activity.ChatActivity r8 = r8.this$0
            com.stepos.ailauncher.chat.activity.ChatActivity.ba(r8, r9, r6, r3, r5)
            Y8.t r8 = Y8.t.f7040a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.activity.ChatActivity$restoreLastSessionWithFallback$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
