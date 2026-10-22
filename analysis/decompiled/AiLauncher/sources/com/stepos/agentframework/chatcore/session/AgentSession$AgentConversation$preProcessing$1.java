package com.stepos.agentframework.chatcore.session;

import com.stepos.agentframework.chatcore.session.AgentSession;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import u4.AgentMessage;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation$preProcessing$1", f = "AgentSession.kt", l = {4237, 4243, 4266}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class AgentSession$AgentConversation$preProcessing$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ boolean $deepThinking;
    final /* synthetic */ List<AgentMessage> $messages;
    final /* synthetic */ Map<String, String> $meta;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ AgentSession.AgentConversation this$0;
    final /* synthetic */ AgentSession this$1;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation$preProcessing$1$3", f = "AgentSession.kt", l = {4282}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation$preProcessing$1$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ boolean $deepThinking;
        final /* synthetic */ List<AgentMessage> $messages;
        final /* synthetic */ Map<String, String> $meta;
        int label;
        final /* synthetic */ AgentSession.AgentConversation this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AgentSession.AgentConversation agentConversation, List<AgentMessage> list, boolean z10, Map<String, String> map, InterfaceC4014c<? super AnonymousClass3> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = agentConversation;
            this.$messages = list;
            this.$deepThinking = z10;
            this.$meta = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass3(this.this$0, this.$messages, this.$deepThinking, this.$meta, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass3) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                AgentSession.AgentConversation agentConversation = this.this$0;
                List<AgentMessage> list = this.$messages;
                boolean z10 = this.$deepThinking;
                Map<String, String> map = this.$meta;
                this.label = 1;
                if (agentConversation.h0(list, z10, map, this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation$preProcessing$1$4", f = "AgentSession.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation$preProcessing$1$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;
        final /* synthetic */ AgentSession.AgentConversation this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(AgentSession.AgentConversation agentConversation, InterfaceC4014c<? super AnonymousClass4> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = agentConversation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass4(this.this$0, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass4) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            ChatRound chatRound = this.this$0.chatRound;
            kotlin.jvm.internal.p.f(chatRound);
            chatRound.c(new AgentError(AgentError.ERROR_CODE_CONTENT_PREPROCESSING_ERROR, "preProcessing error", null, 4, null));
            return Y8.t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentSession$AgentConversation$preProcessing$1(List<AgentMessage> list, AgentSession.AgentConversation agentConversation, AgentSession agentSession, boolean z10, Map<String, String> map, InterfaceC4014c<? super AgentSession$AgentConversation$preProcessing$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$messages = list;
        this.this$0 = agentConversation;
        this.this$1 = agentSession;
        this.$deepThinking = z10;
        this.$meta = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentSession$AgentConversation$preProcessing$1(this.$messages, this.this$0, this.this$1, this.$deepThinking, this.$meta, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentSession$AgentConversation$preProcessing$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x018f, code lost:
    
        r3 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x018f, code lost:
    
        r3 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009e A[Catch: Exception -> 0x0034, TryCatch #0 {Exception -> 0x0034, blocks: (B:8:0x002e, B:79:0x0282, B:55:0x01c4, B:57:0x01ca, B:59:0x01d5, B:64:0x01e9, B:66:0x01f2, B:71:0x01ff, B:75:0x0212, B:70:0x01fc, B:82:0x0294, B:15:0x0059, B:50:0x018c, B:22:0x0098, B:24:0x009e, B:26:0x00ad, B:28:0x00b6, B:32:0x00c0, B:35:0x00cb, B:37:0x00f9, B:43:0x012b, B:45:0x0130, B:47:0x013a, B:52:0x0194, B:54:0x01ba, B:18:0x007a, B:21:0x0083), top: B:87:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0194 A[Catch: Exception -> 0x0034, TryCatch #0 {Exception -> 0x0034, blocks: (B:8:0x002e, B:79:0x0282, B:55:0x01c4, B:57:0x01ca, B:59:0x01d5, B:64:0x01e9, B:66:0x01f2, B:71:0x01ff, B:75:0x0212, B:70:0x01fc, B:82:0x0294, B:15:0x0059, B:50:0x018c, B:22:0x0098, B:24:0x009e, B:26:0x00ad, B:28:0x00b6, B:32:0x00c0, B:35:0x00cb, B:37:0x00f9, B:43:0x012b, B:45:0x0130, B:47:0x013a, B:52:0x0194, B:54:0x01ba, B:18:0x007a, B:21:0x0083), top: B:87:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ca A[Catch: Exception -> 0x0034, TryCatch #0 {Exception -> 0x0034, blocks: (B:8:0x002e, B:79:0x0282, B:55:0x01c4, B:57:0x01ca, B:59:0x01d5, B:64:0x01e9, B:66:0x01f2, B:71:0x01ff, B:75:0x0212, B:70:0x01fc, B:82:0x0294, B:15:0x0059, B:50:0x018c, B:22:0x0098, B:24:0x009e, B:26:0x00ad, B:28:0x00b6, B:32:0x00c0, B:35:0x00cb, B:37:0x00f9, B:43:0x012b, B:45:0x0130, B:47:0x013a, B:52:0x0194, B:54:0x01ba, B:18:0x007a, B:21:0x0083), top: B:87:0x000c }] */
    /* JADX WARN: Type inference failed for: r5v17, types: [java.lang.Iterable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0188 -> B:50:0x018c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x027c -> B:79:0x0282). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0290 -> B:81:0x0291). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 724
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.AgentSession$AgentConversation$preProcessing$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
