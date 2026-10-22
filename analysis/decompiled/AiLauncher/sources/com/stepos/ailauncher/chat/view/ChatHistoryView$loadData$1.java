package com.stepos.ailauncher.chat.view;

import Ua.InterfaceC1066l;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import com.stepos.ailauncher.contract.model.search.SidebarSession;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.ChatHistoryView$loadData$1", f = "ChatHistoryView.kt", l = {245, 263}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class ChatHistoryView$loadData$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $currentSessionId;
    final /* synthetic */ InterfaceC5063a<Y8.t> $onUpdated;
    final /* synthetic */ boolean $refreshAgents;
    boolean Z$0;
    int label;
    final /* synthetic */ ChatHistoryView this$0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"LUa/M;", "Lkotlin/Pair;", "", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$SidebarAgent;", "<anonymous>", "(LUa/M;)Lkotlin/Pair;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.view.ChatHistoryView$loadData$1$1", f = "ChatHistoryView.kt", l = {265, 1445}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.view.ChatHistoryView$loadData$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Pair<? extends List<? extends SidebarSession>, ? extends List<? extends IExternalAgentBindService.SidebarAgent>>>, Object> {
        final /* synthetic */ String $currentSessionId;
        final /* synthetic */ boolean $refreshAgents;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        final /* synthetic */ ChatHistoryView this$0;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.view.ChatHistoryView$loadData$1$1$a */
        public static final class a implements InterfaceC5074l<Map<String, ? extends Boolean>, Y8.t> {
            final /* synthetic */ InterfaceC1066l<Map<String, Boolean>> $cont;

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: com.stepos.ailauncher.chat.view.ChatHistoryView$loadData$1$1$a$a, reason: collision with other inner class name */
            public static final class C0296a implements InterfaceC5074l<Throwable, Y8.t> {
                public static final C0296a INSTANCE = new C0296a();

                public final void a(Throwable it) {
                    kotlin.jvm.internal.p.i(it, "it");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ Y8.t invoke(Throwable th) {
                    a(th);
                    return Y8.t.f7040a;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public a(InterfaceC1066l<? super Map<String, Boolean>> interfaceC1066l) {
                this.$cont = interfaceC1066l;
            }

            public final void a(Map<String, Boolean> result) {
                kotlin.jvm.internal.p.i(result, "result");
                if (this.$cont.b()) {
                    this.$cont.v(result, C0296a.INSTANCE);
                }
            }

            @Override // p9.InterfaceC5074l
            public /* bridge */ /* synthetic */ Y8.t invoke(Map<String, ? extends Boolean> map) {
                a(map);
                return Y8.t.f7040a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z10, ChatHistoryView chatHistoryView, String str, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$refreshAgents = z10;
            this.this$0 = chatHistoryView;
            this.$currentSessionId = str;
        }

        public static final boolean i(String str, ChatHistoryView chatHistoryView, SidebarSession sidebarSession) {
            return (sidebarSession.getSendFailed() || kotlin.jvm.internal.p.d(sidebarSession.getSessionId(), str) || sidebarSession.getUpdatedAt() > sidebarSession.getCreatedAt() || chatHistoryView.sessionHandler.i2(sidebarSession.getSessionId())) ? false : true;
        }

        public static final String n(SidebarSession sidebarSession) {
            return sidebarSession.getSessionId();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$refreshAgents, this.this$0, this.$currentSessionId, interfaceC4014c);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Ua.M m10, InterfaceC4014c<? super Pair<? extends List<SidebarSession>, ? extends List<IExternalAgentBindService.SidebarAgent>>> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0072 A[Catch: all -> 0x0044, TryCatch #2 {all -> 0x0044, blocks: (B:14:0x0040, B:24:0x006c, B:27:0x0072, B:28:0x0076, B:19:0x004a, B:21:0x0058), top: B:99:0x000f }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x008d  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00a4  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00d4  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x013b  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0153  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x015f  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x01ed  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x019e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 508
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.ChatHistoryView$loadData$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(Ua.M m10, InterfaceC4014c<? super Pair<? extends List<? extends SidebarSession>, ? extends List<? extends IExternalAgentBindService.SidebarAgent>>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super Pair<? extends List<SidebarSession>, ? extends List<IExternalAgentBindService.SidebarAgent>>>) interfaceC4014c);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.ChatHistoryView$loadData$1$5, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements InterfaceC5074l<String, Boolean> {
        public AnonymousClass5(Object obj) {
            super(1, obj, SessionHandler.class, "isSessionActive", "isSessionActive(Ljava/lang/String;)Z", 0);
        }

        @Override // p9.InterfaceC5074l
        public final Boolean invoke(String p02) {
            kotlin.jvm.internal.p.i(p02, "p0");
            return Boolean.valueOf(((SessionHandler) this.receiver).i2(p02));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatHistoryView$loadData$1(ChatHistoryView chatHistoryView, InterfaceC5063a<Y8.t> interfaceC5063a, String str, boolean z10, InterfaceC4014c<? super ChatHistoryView$loadData$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = chatHistoryView;
        this.$onUpdated = interfaceC5063a;
        this.$currentSessionId = str;
        this.$refreshAgents = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new ChatHistoryView$loadData$1(this.this$0, this.$onUpdated, this.$currentSessionId, this.$refreshAgents, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((ChatHistoryView$loadData$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00aa, code lost:
    
        if (r10 == r0) goto L26;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 395
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.ChatHistoryView$loadData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
