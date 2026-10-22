package com.stepos.ailauncher.task.search;

import Ua.C1056g;
import Ua.C1060i;
import Ua.M;
import Ua.Q;
import Ua.Y;
import Y8.j;
import Y8.t;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.search.ConversationSearchSnapshot;
import com.stepos.agentframework.chatcore.search.TaskSearchHit;
import com.stepos.agentframework.chatcore.session.list.SessionListItem;
import com.stepos.ailauncher.contract.api.search.IUnifiedSessionSearchService;
import com.stepos.ailauncher.contract.model.search.SidebarSession;
import com.stepos.ailauncher.contract.model.search.UnifiedSearchResult;
import com.stepos.ailauncher.taskstore.TaskStoreModule;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.read.TaskReadStateManager;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.i;
import p9.p;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@¢\u0006\u0004\b\b\u0010\tJ \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\nH\u0096@¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/task/search/UnifiedSessionSearchServiceImpl;", "Lcom/stepos/ailauncher/contract/api/search/IUnifiedSessionSearchService;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "getSessionList", "(Le9/c;)Ljava/lang/Object;", "", "query", "", "limitPerGroup", "Lcom/stepos/ailauncher/contract/model/search/UnifiedSearchResult;", "search", "(Ljava/lang/String;ILe9/c;)Ljava/lang/Object;", "taskId", "LY8/t;", "markTaskRead", "(Ljava/lang/String;)V", "sessionId", "markSessionCompletedTasksRead", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Companion", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UnifiedSessionSearchServiceImpl implements IUnifiedSessionSearchService {
    private static final a Companion = new a(null);
    private static final int MAX_RESULTS_PER_GROUP = 50;
    private static final String TAG = "UnifiedSessionSearch";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/task/search/UnifiedSessionSearchServiceImpl$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "", "MAX_RESULTS_PER_GROUP", "I", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "<anonymous>", "(LUa/M;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.task.search.UnifiedSessionSearchServiceImpl$getSessionList$2", f = "UnifiedSessionSearchServiceImpl.kt", l = {52, 53, 65, 78}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.task.search.UnifiedSessionSearchServiceImpl$getSessionList$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super List<? extends SidebarSession>>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"LUa/M;", "Lkotlin/Pair;", "", "Lcom/stepos/agentframework/chatcore/session/list/b;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "<anonymous>", "(LUa/M;)Lkotlin/Pair;"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.task.search.UnifiedSessionSearchServiceImpl$getSessionList$2$1", f = "UnifiedSessionSearchServiceImpl.kt", l = {60, 60}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.task.search.UnifiedSessionSearchServiceImpl$getSessionList$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super Pair<? extends List<? extends SessionListItem>, ? extends List<? extends TaskInfoCard>>>, Object> {
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;

            public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
                super(2, interfaceC4014c);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(interfaceC4014c);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(M m10, InterfaceC4014c<? super Pair<? extends List<SessionListItem>, ? extends List<TaskInfoCard>>> interfaceC4014c) {
                return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Q qB;
                Q q10;
                Object obj2;
                M m10 = (M) this.L$0;
                Object objG = C4063a.g();
                int i10 = this.label;
                if (i10 == 0) {
                    C4849c.b(obj);
                    Q qB2 = C1060i.b(m10, null, null, new UnifiedSessionSearchServiceImpl$getSessionList$2$1$sessions$1(null), 3, null);
                    qB = C1060i.b(m10, null, null, new UnifiedSessionSearchServiceImpl$getSessionList$2$1$tasks$1(null), 3, null);
                    this.L$0 = h.a(m10);
                    this.L$1 = h.a(qB2);
                    this.L$2 = qB;
                    this.label = 1;
                    obj = qB2.a1(this);
                    if (obj != objG) {
                        q10 = qB2;
                    }
                    return objG;
                }
                if (i10 != 1) {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    obj2 = this.L$3;
                    C4849c.b(obj);
                    return j.a(obj2, obj);
                }
                qB = (Q) this.L$2;
                q10 = (Q) this.L$1;
                C4849c.b(obj);
                this.L$0 = h.a(m10);
                this.L$1 = h.a(q10);
                this.L$2 = h.a(qB);
                this.L$3 = obj;
                this.label = 2;
                Object objA1 = qB.a1(this);
                if (objA1 != objG) {
                    obj2 = obj;
                    obj = objA1;
                    return j.a(obj2, obj);
                }
                return objG;
            }

            @Override // p9.p
            public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super Pair<? extends List<? extends SessionListItem>, ? extends List<? extends TaskInfoCard>>> interfaceC4014c) {
                return invoke2(m10, (InterfaceC4014c<? super Pair<? extends List<SessionListItem>, ? extends List<TaskInfoCard>>>) interfaceC4014c);
            }
        }

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super List<SidebarSession>> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00c1 A[LOOP:2: B:25:0x00bb->B:27:0x00c1, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0132  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0154 A[LOOP:0: B:46:0x014e->B:48:0x0154, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0183  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 434
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.search.UnifiedSessionSearchServiceImpl.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super List<? extends SidebarSession>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super List<SidebarSession>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "Lcom/stepos/ailauncher/contract/model/search/UnifiedSearchResult;", "<anonymous>", "(LUa/M;)Lcom/stepos/ailauncher/contract/model/search/UnifiedSearchResult;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.task.search.UnifiedSessionSearchServiceImpl$search$2", f = "UnifiedSessionSearchServiceImpl.kt", l = {94, 96}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.task.search.UnifiedSessionSearchServiceImpl$search$2, reason: invalid class name and case insensitive filesystem */
    public static final class C35732 extends SuspendLambda implements p<M, InterfaceC4014c<? super UnifiedSearchResult>, Object> {
        final /* synthetic */ int $limitPerGroup;
        final /* synthetic */ String $query;
        int I$0;
        Object L$0;
        int label;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a&\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0001*\u00020\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"LUa/M;", "Lkotlin/Triple;", "Lcom/stepos/agentframework/chatcore/search/a;", "", "Lcom/stepos/agentframework/chatcore/search/n;", "", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "<anonymous>", "(LUa/M;)Lkotlin/Triple;"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.task.search.UnifiedSessionSearchServiceImpl$search$2$1", f = "UnifiedSessionSearchServiceImpl.kt", l = {110, 110, 110}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.task.search.UnifiedSessionSearchServiceImpl$search$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super Triple<? extends ConversationSearchSnapshot, ? extends List<? extends TaskSearchHit>, ? extends Map<String, ? extends TaskInfoCard>>>, Object> {
            final /* synthetic */ String $keyword;
            final /* synthetic */ int $limit;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(String str, int i10, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.$keyword = str;
                this.$limit = i10;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$keyword, this.$limit, interfaceC4014c);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(M m10, InterfaceC4014c<? super Triple<ConversationSearchSnapshot, ? extends List<TaskSearchHit>, ? extends Map<String, TaskInfoCard>>> interfaceC4014c) {
                return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
            }

            /* JADX WARN: Removed duplicated region for block: B:24:0x00ea  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
                /*
                    Method dump skipped, instructions count: 243
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.search.UnifiedSessionSearchServiceImpl.C35732.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // p9.p
            public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super Triple<? extends ConversationSearchSnapshot, ? extends List<? extends TaskSearchHit>, ? extends Map<String, ? extends TaskInfoCard>>> interfaceC4014c) {
                return invoke2(m10, (InterfaceC4014c<? super Triple<ConversationSearchSnapshot, ? extends List<TaskSearchHit>, ? extends Map<String, TaskInfoCard>>>) interfaceC4014c);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C35732(String str, int i10, InterfaceC4014c<? super C35732> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$query = str;
            this.$limitPerGroup = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C35732(this.$query, this.$limitPerGroup, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super UnifiedSearchResult> interfaceC4014c) {
            return ((C35732) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x009f A[LOOP:0: B:22:0x0099->B:24:0x009f, LOOP_END] */
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
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L2a
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r7 = r7.L$0
                java.lang.String r7 = (java.lang.String) r7
                kotlin.C4849c.b(r8)
                goto L70
            L17:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1f:
                int r1 = r7.I$0
                java.lang.Object r3 = r7.L$0
                java.lang.String r3 = (java.lang.String) r3
                kotlin.C4849c.b(r8)
                r8 = r3
                goto L5b
            L2a:
                kotlin.C4849c.b(r8)
                java.lang.String r8 = r7.$query
                java.lang.CharSequence r8 = La.H.D1(r8)
                java.lang.String r8 = r8.toString()
                int r1 = r8.length()
                if (r1 != 0) goto L44
                com.stepos.ailauncher.contract.model.search.UnifiedSearchResult r7 = new com.stepos.ailauncher.contract.model.search.UnifiedSearchResult
                r8 = 3
                r7.<init>(r4, r4, r8, r4)
                return r7
            L44:
                int r1 = r7.$limitPerGroup
                r5 = 50
                int r1 = v9.C5685n.n(r1, r3, r5)
                com.stepos.ailauncher.task.search.TaskStoreSearchProjectionBridge r5 = com.stepos.ailauncher.task.search.TaskStoreSearchProjectionBridge.INSTANCE
                r7.L$0 = r8
                r7.I$0 = r1
                r7.label = r3
                java.lang.Object r3 = r5.b(r7)
                if (r3 != r0) goto L5b
                goto L6c
            L5b:
                com.stepos.ailauncher.task.search.UnifiedSessionSearchServiceImpl$search$2$1 r3 = new com.stepos.ailauncher.task.search.UnifiedSessionSearchServiceImpl$search$2$1
                r3.<init>(r8, r1, r4)
                r7.L$0 = r8
                r7.I$0 = r1
                r7.label = r2
                java.lang.Object r7 = kotlinx.coroutines.d.f(r3, r7)
                if (r7 != r0) goto L6d
            L6c:
                return r0
            L6d:
                r6 = r8
                r8 = r7
                r7 = r6
            L70:
                kotlin.Triple r8 = (kotlin.Triple) r8
                java.lang.Object r0 = r8.a()
                com.stepos.agentframework.chatcore.search.a r0 = (com.stepos.agentframework.chatcore.search.ConversationSearchSnapshot) r0
                java.lang.Object r1 = r8.b()
                java.util.List r1 = (java.util.List) r1
                java.lang.Object r8 = r8.c()
                java.util.Map r8 = (java.util.Map) r8
                java.util.List r0 = com.stepos.ailauncher.task.search.d.c(r0, r7)
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.ArrayList r2 = new java.util.ArrayList
                r3 = 10
                int r3 = Z8.C1174w.x(r1, r3)
                r2.<init>(r3)
                java.util.Iterator r1 = r1.iterator()
            L99:
                boolean r3 = r1.hasNext()
                if (r3 == 0) goto Lb7
                java.lang.Object r3 = r1.next()
                com.stepos.agentframework.chatcore.search.n r3 = (com.stepos.agentframework.chatcore.search.TaskSearchHit) r3
                java.lang.String r4 = r3.getTaskId()
                java.lang.Object r4 = r8.get(r4)
                com.stepos.ailauncher.taskstore.entity.TaskInfoCard r4 = (com.stepos.ailauncher.taskstore.entity.TaskInfoCard) r4
                com.stepos.ailauncher.contract.model.search.TaskSearchHit r3 = com.stepos.ailauncher.task.search.d.p(r3, r7, r4)
                r2.add(r3)
                goto L99
            Lb7:
                com.stepos.ailauncher.contract.model.search.UnifiedSearchResult r7 = new com.stepos.ailauncher.contract.model.search.UnifiedSearchResult
                r7.<init>(r0, r2)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.task.search.UnifiedSessionSearchServiceImpl.C35732.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public UnifiedSessionSearchServiceImpl(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        TaskStoreModule taskStoreModule = TaskStoreModule.INSTANCE;
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        taskStoreModule.q(applicationContext);
        TaskStoreSearchProjectionBridge.INSTANCE.c();
    }

    @Override // com.stepos.ailauncher.contract.api.search.IUnifiedSessionSearchService
    public Object getSessionList(InterfaceC4014c<? super List<SidebarSession>> interfaceC4014c) {
        return C1056g.j(Y.b(), new AnonymousClass2(null), interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.contract.api.search.IUnifiedSessionSearchService
    public Object markSessionCompletedTasksRead(String str, InterfaceC4014c<? super Integer> interfaceC4014c) {
        return TaskReadStateManager.INSTANCE.b(str, "UnifiedSessionSearch.sidebarSession", interfaceC4014c);
    }

    @Override // com.stepos.ailauncher.contract.api.search.IUnifiedSessionSearchService
    public void markTaskRead(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        TaskReadStateManager.INSTANCE.a(taskId, "UnifiedSessionSearch.taskResult");
    }

    @Override // com.stepos.ailauncher.contract.api.search.IUnifiedSessionSearchService
    public Object search(String str, int i10, InterfaceC4014c<? super UnifiedSearchResult> interfaceC4014c) {
        return C1056g.j(Y.b(), new C35732(str, i10, null), interfaceC4014c);
    }
}
