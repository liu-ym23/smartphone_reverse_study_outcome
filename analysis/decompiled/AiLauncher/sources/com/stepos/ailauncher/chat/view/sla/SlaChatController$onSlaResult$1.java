package com.stepos.ailauncher.chat.view.sla;

import Ua.M;
import Y8.t;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.send.LocalExecResult;
import com.stepos.agentframework.chatcore.send.SendContext;
import com.stepos.agentframework.chatcore.send.SlaSessionAnchor;
import com.stepos.aiengine.algorithm.sla.SlaResult;
import com.stepos.ailauncher.chat.view.sla.SlaChatController$onSlaResult$1;
import com.stepos.ailauncher.chat.view.sla.a;
import com.stepos.ailauncher.sla.G;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.sla.SlaChatController$onSlaResult$1", f = "SlaChatController.kt", l = {775, 821, 837}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class SlaChatController$onSlaResult$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ List<String> $actionJsons;
    final /* synthetic */ SlaSessionAnchor $anchor;
    final /* synthetic */ List<AgentTool> $appUITools;
    final /* synthetic */ com.stepos.agentframework.chatcore.send.k $cb;
    final /* synthetic */ SendContext $ctx;
    final /* synthetic */ String $displayQuery;
    final /* synthetic */ String $query;
    final /* synthetic */ String $replyText;
    final /* synthetic */ SlaResult $result;
    final /* synthetic */ int $scene;
    final /* synthetic */ String $traceId;
    final /* synthetic */ String $userMessageId;
    long J$0;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    final /* synthetic */ SlaChatController this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.sla.SlaChatController$onSlaResult$1$1", f = "SlaChatController.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.view.sla.SlaChatController$onSlaResult$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ List<String> $actionJsons;
        final /* synthetic */ SlaSessionAnchor $anchor;
        final /* synthetic */ List<AgentTool> $appUITools;
        final /* synthetic */ com.stepos.agentframework.chatcore.send.k $cb;
        final /* synthetic */ SendContext $ctx;
        final /* synthetic */ String $injectQuery;
        final /* synthetic */ String $replyText;
        final /* synthetic */ SlaResult $result;
        final /* synthetic */ int $scene;
        final /* synthetic */ String $traceId;
        final /* synthetic */ long $userBubbleTime;
        final /* synthetic */ String $userMessageId;
        int label;
        final /* synthetic */ SlaChatController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SlaChatController slaChatController, String str, String str2, String str3, int i10, List<AgentTool> list, SlaSessionAnchor slaSessionAnchor, long j10, String str4, com.stepos.agentframework.chatcore.send.k kVar, SendContext sendContext, List<String> list2, SlaResult slaResult, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = slaChatController;
            this.$userMessageId = str;
            this.$injectQuery = str2;
            this.$replyText = str3;
            this.$scene = i10;
            this.$appUITools = list;
            this.$anchor = slaSessionAnchor;
            this.$userBubbleTime = j10;
            this.$traceId = str4;
            this.$cb = kVar;
            this.$ctx = sendContext;
            this.$actionJsons = list2;
            this.$result = slaResult;
        }

        public static final t h(SlaChatController slaChatController, String str, String str2, int i10, List list, SlaSessionAnchor slaSessionAnchor, String str3, long j10, String str4, com.stepos.agentframework.chatcore.send.k kVar, SendContext sendContext, List list2, SlaResult slaResult) {
            slaChatController.u0(str, str2, i10, list, slaSessionAnchor, str3, j10);
            if (i10 == 2) {
                C4148a.d("SlaChatController", "onSlaResult sla_scene=2 -> 触发关闭半弹窗", false, 4, null);
                slaChatController.T0(new a.Close(str4));
            } else {
                slaChatController.T0(new a.Expand(str4, "success(scene=" + i10 + ")", false, 4, null));
            }
            if (kVar == null || sendContext == null) {
                slaChatController.sessionHandler.H3(slaChatController.d0(), false);
            } else {
                kVar.b(sendContext, new LocalExecResult(str2, i10, null, 4, null));
            }
            slaChatController.n0();
            G.INSTANCE.c(slaChatController.d0(), i10 == 2 ? "page_jump" : !list.isEmpty() ? "card" : "chatview_reply", slaChatController.m0(list2, i10, slaResult.getDecision().getFunction()), "yes");
            return t.f7040a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.this$0, this.$userMessageId, this.$injectQuery, this.$replyText, this.$scene, this.$appUITools, this.$anchor, this.$userBubbleTime, this.$traceId, this.$cb, this.$ctx, this.$actionJsons, this.$result, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            final SlaChatController slaChatController = this.this$0;
            final String str = this.$userMessageId;
            final String str2 = this.$injectQuery;
            final String str3 = this.$replyText;
            final int i10 = this.$scene;
            final List<AgentTool> list = this.$appUITools;
            final SlaSessionAnchor slaSessionAnchor = this.$anchor;
            final long j10 = this.$userBubbleTime;
            final String str4 = this.$traceId;
            final com.stepos.agentframework.chatcore.send.k kVar = this.$cb;
            final SendContext sendContext = this.$ctx;
            final List<String> list2 = this.$actionJsons;
            final SlaResult slaResult = this.$result;
            slaChatController.P(str, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.sla.o
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return SlaChatController$onSlaResult$1.AnonymousClass1.h(slaChatController, str2, str3, i10, list, slaSessionAnchor, str, j10, str4, kVar, sendContext, list2, slaResult);
                }
            });
            return t.f7040a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.sla.SlaChatController$onSlaResult$1$2", f = "SlaChatController.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.view.sla.SlaChatController$onSlaResult$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ SlaSessionAnchor $anchor;
        final /* synthetic */ String $displayQuery;
        final /* synthetic */ long $userBubbleTime;
        final /* synthetic */ String $userMessageId;
        int label;
        final /* synthetic */ SlaChatController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SlaChatController slaChatController, String str, String str2, SlaSessionAnchor slaSessionAnchor, long j10, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.this$0 = slaChatController;
            this.$userMessageId = str;
            this.$displayQuery = str2;
            this.$anchor = slaSessionAnchor;
            this.$userBubbleTime = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.this$0, this.$userMessageId, this.$displayQuery, this.$anchor, this.$userBubbleTime, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            this.this$0.R0(this.$userMessageId, this.$displayQuery, this.$anchor, this.$userBubbleTime);
            return t.f7040a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlaChatController$onSlaResult$1(SlaChatController slaChatController, String str, String str2, SendContext sendContext, String str3, String str4, int i10, List<AgentTool> list, SlaSessionAnchor slaSessionAnchor, String str5, com.stepos.agentframework.chatcore.send.k kVar, List<String> list2, SlaResult slaResult, InterfaceC4014c<? super SlaChatController$onSlaResult$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = slaChatController;
        this.$query = str;
        this.$displayQuery = str2;
        this.$ctx = sendContext;
        this.$userMessageId = str3;
        this.$replyText = str4;
        this.$scene = i10;
        this.$appUITools = list;
        this.$anchor = slaSessionAnchor;
        this.$traceId = str5;
        this.$cb = kVar;
        this.$actionJsons = list2;
        this.$result = slaResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new SlaChatController$onSlaResult$1(this.this$0, this.$query, this.$displayQuery, this.$ctx, this.$userMessageId, this.$replyText, this.$scene, this.$appUITools, this.$anchor, this.$traceId, this.$cb, this.$actionJsons, this.$result, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((SlaChatController$onSlaResult$1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0190, code lost:
    
        if (Ua.C1056g.j(r13, r4, r26) == r1) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0035 A[PHI: r2 r3 r4 r7
      0x0035: PHI (r2v4 boolean) = (r2v3 boolean), (r2v7 boolean) binds: [B:45:0x0117, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x0035: PHI (r3v8 java.lang.Object) = (r3v7 java.lang.Object), (r3v11 java.lang.Object) binds: [B:45:0x0117, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x0035: PHI (r4v4 long) = (r4v3 long), (r4v12 long) binds: [B:45:0x0117, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x0035: PHI (r7v13 java.lang.String) = (r7v12 java.lang.String), (r7v19 java.lang.String) binds: [B:45:0x0117, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.sla.SlaChatController$onSlaResult$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
