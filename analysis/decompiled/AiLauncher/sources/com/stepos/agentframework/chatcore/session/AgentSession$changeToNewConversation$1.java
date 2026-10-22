package com.stepos.agentframework.chatcore.session;

import Ua.InterfaceC1083u;
import Z8.C1173v;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatcore.session.L0;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$changeToNewConversation$1", f = "AgentSession.kt", l = {1511, 1519}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$changeToNewConversation$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $agentId;
    final /* synthetic */ InterfaceC1083u<Y8.t> $deferred;
    final /* synthetic */ AgentSession.AgentConversation $newConv;
    int I$0;
    Object L$0;
    boolean Z$0;
    boolean Z$1;
    int label;
    final /* synthetic */ AgentSession this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$changeToNewConversation$1$1", f = "AgentSession.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.chatcore.session.AgentSession$changeToNewConversation$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ boolean $neverConversed;
        final /* synthetic */ AgentSession.AgentConversation $newConv;
        final /* synthetic */ String $newRemoteKey;
        int label;
        final /* synthetic */ AgentSession this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(AgentSession agentSession, AgentSession.AgentConversation agentConversation, String str, boolean z10, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = agentSession;
            this.$newConv = agentConversation;
            this.$newRemoteKey = str;
            this.$neverConversed = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.this$0, this.$newConv, this.$newRemoteKey, this.$neverConversed, interfaceC4014c);
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
            AgentSession.AgentConversation topConversation = this.this$0.getTopConversation();
            AgentSession.AgentConversation agentConversation = this.$newConv;
            boolean z10 = topConversation == agentConversation;
            boolean z11 = agentConversation.B().length() > 0;
            if (z11) {
                C4148a.k(this.this$0.TAG, "changeToNewConversation: conversation bound while creating (key=" + this.$newConv.B() + " remoteKey=" + this.$newRemoteKey + "), keep messages on screen", false, 4, null);
            }
            if (!this.$neverConversed) {
                String str = this.$newRemoteKey;
                if (str == null || str.length() == 0) {
                    if (z10 && !z11) {
                        this.this$0.B0(new L0.ConversationChanged(null, null, C1173v.m(), 0L, 8, null));
                    }
                } else if (z11) {
                    this.this$0.d0(this.$newConv, this.$newRemoteKey);
                } else {
                    this.$newConv.p0(this.$newRemoteKey);
                    this.$newConv.r0("");
                    this.$newConv.q0(false);
                    this.this$0.Z0().put(this.$newRemoteKey, this.$newConv);
                    if (z10) {
                        this.this$0.B0(new L0.ConversationChanged(this.$newRemoteKey, null, C1173v.m(), 0L, 8, null));
                    }
                }
            } else if (z11) {
                this.this$0.d0(this.$newConv, ConversationSessionIds.MAIN_SESSION_ID);
            } else if (z10) {
                this.this$0.e0();
            } else {
                this.$newConv.p0(ConversationSessionIds.MAIN_SESSION_ID);
                this.$newConv.r0("");
                this.$newConv.q0(false);
                this.this$0.Z0().put(ConversationSessionIds.MAIN_SESSION_ID, this.$newConv);
            }
            this.this$0.getHandler().A2();
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentSession$changeToNewConversation$1(AgentSession.AgentConversation agentConversation, AgentSession agentSession, String str, InterfaceC1083u<Y8.t> interfaceC1083u, InterfaceC4014c<? super AgentSession$changeToNewConversation$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$newConv = agentConversation;
        this.this$0 = agentSession;
        this.$agentId = str;
        this.$deferred = interfaceC1083u;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSession$changeToNewConversation$1(this.$newConv, this.this$0, this.$agentId, this.$deferred, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSession$changeToNewConversation$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c7, code lost:
    
        if (Ua.C1056g.j(r12, r5, r13) != r0) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b0  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession$changeToNewConversation$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
