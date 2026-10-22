package com.stepos.agentframework.adapter.coze;

import C7.r;
import H4.o;
import J7.c;
import S7.p;
import V4.A;
import V4.AbstractC0262i;
import V4.B;
import V4.C;
import V4.C0260g;
import V4.D;
import V4.E;
import V4.F;
import V4.G;
import V4.H;
import V4.I;
import V4.x;
import V4.y;
import V4.z;
import android.content.Context;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.agentframework.adapter.coze.CozeClient;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.adapter.netcore.EventSourceState;
import com.stepos.agentframework.adapter.netcore.ICoreAgentClient;
import com.stepos.agentframework.adapter.netcore.ILogger;
import com.stepos.statsrpk.d;
import j9.m;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 =2\u00020\u0001:\u0001=B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0016H\u0096@¢\u0006\u0004\b\u0018\u0010\u0019JH\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u001a2&\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\n0\u001bH\u0096@¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0010\u001a\u00020!H\u0096@¢\u0006\u0004\b#\u0010$JH\u0010%\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u001a2&\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\n0\u001bH\u0082@¢\u0006\u0004\b%\u0010 JH\u0010&\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u001a2&\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\n0\u001bH\u0082@¢\u0006\u0004\b&\u0010 J\u0017\u0010)\u001a\u00020\n2\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u001f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,2\b\u0010+\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b.\u0010/R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00100R\u001a\u00102\u001a\u0002018\u0016X\u0096\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R \u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0:098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/CozeCoreAgentClient;", "Lcom/stepos/agentframework/adapter/netcore/ICoreAgentClient;", "", "timeOut", AppAgent.CONSTRUCT, "(J)V", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/adapter/netcore/ILogger;", "logger", "LC7/r;", "init", "(Landroid/content/Context;Lcom/stepos/agentframework/adapter/netcore/ILogger;)V", "destroy", "()V", "LV4/l;", "request", "Lcom/stepos/agentframework/adapter/netcore/EventListener;", "listener", "Lcom/stepos/agentframework/adapter/netcore/ICancelHandle;", "chat", "(LV4/l;Lcom/stepos/agentframework/adapter/netcore/EventListener;LH7/c;)Ljava/lang/Object;", "LV4/q;", "", "feedback", "(LV4/q;LH7/c;)Ljava/lang/Object;", "LV4/H;", "Lkotlin/Function4;", "", "", GuiTaskProgressKt.GuiTaskProgress_VALUE_METHOD_ONPRGRESS, "uploadFile", "(Landroid/content/Context;LV4/H;LS7/p;LH7/c;)Ljava/lang/Object;", "LV4/b;", "LV4/a;", "getAgentDetail", "(LV4/b;LH7/c;)Ljava/lang/Object;", "uploadToCozeAPI", "uploadToTOS", "Lcom/stepos/agentframework/adapter/netcore/EventSourceState;", "eventSourceState", "addEventSourceState", "(Lcom/stepos/agentframework/adapter/netcore/EventSourceState;)V", "text", "", "LV4/i;", "generateContent", "(Ljava/lang/String;)Ljava/util/List;", "J", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "type", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "getType", "()Lcom/stepos/agentframework/adapter/netcore/ApiType;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "", "Ljava/lang/ref/WeakReference;", "eventSourceStates", "Ljava/util/Set;", "Companion", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CozeCoreAgentClient implements ICoreAgentClient {
    private static final String TAG = "CozeCoreAgentClient";
    private final long timeOut;
    private final ApiType type = ApiType.COZE;
    private final Gson gson = new Gson();
    private final Set<WeakReference<EventSourceState>> eventSourceStates = new LinkedHashSet();

    @c(c = "com.stepos.agentframework.adapter.coze.CozeCoreAgentClient", f = "CozeCoreAgentClient.kt", l = {53}, m = "chat", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$chat$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CozeCoreAgentClient.this.chat(null, null, this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.coze.CozeCoreAgentClient", f = "CozeCoreAgentClient.kt", l = {185}, m = "feedback", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$feedback$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10861 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10861(H7.c<? super C10861> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CozeCoreAgentClient.this.feedback(null, this);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.coze.CozeCoreAgentClient", f = "CozeCoreAgentClient.kt", l = {248}, m = "getAgentDetail", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$getAgentDetail$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10871 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C10871(H7.c<? super C10871> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CozeCoreAgentClient.this.getAgentDetail(null, this);
        }
    }

    public CozeCoreAgentClient(long j5) {
        this.timeOut = j5;
    }

    private final void addEventSourceState(EventSourceState eventSourceState) {
        this.eventSourceStates.add(new WeakReference<>(eventSourceState));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<AbstractC0262i> generateContent(String text) {
        return (text == null || m.s0(text)) ? EmptyList.f4893a : o.M(new C0260g(text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object uploadToCozeAPI(Context context, H h, p pVar, H7.c<? super r> cVar) {
        d.D(TAG, "Uploading to Coze API (fileId mode)");
        throw null;
    }

    private static final r uploadToCozeAPI$lambda$0(p pVar, int i, boolean z10, String fileId) {
        k.f(fileId, "fileId");
        pVar.invoke(Integer.valueOf(i), Boolean.valueOf(z10), fileId, null);
        return r.f317a;
    }

    private static final r uploadToCozeAPI$lambda$1(p pVar, int i, boolean z10, String fileId) {
        k.f(fileId, "fileId");
        pVar.invoke(Integer.valueOf(i), Boolean.valueOf(z10), fileId, null);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object uploadToTOS(Context context, H h, p pVar, H7.c<? super r> cVar) {
        d.D(TAG, "Uploading to TOS cloud storage (URL mode)");
        throw null;
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object batchDeleteTasks(A a3, H7.c<? super Boolean> cVar) {
        return super.batchDeleteTasks(a3, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object cancelTask(B b, H7.c<? super Boolean> cVar) {
        return super.cancelTask(b, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object chat(final V4.l r18, final com.stepos.agentframework.adapter.netcore.EventListener r19, H7.c<? super com.stepos.agentframework.adapter.netcore.ICancelHandle> r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r20
            boolean r3 = r2 instanceof com.stepos.agentframework.adapter.coze.CozeCoreAgentClient.AnonymousClass1
            if (r3 == 0) goto L1a
            r3 = r2
            com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$chat$1 r3 = (com.stepos.agentframework.adapter.coze.CozeCoreAgentClient.AnonymousClass1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L1a
            int r4 = r4 - r5
            r3.label = r4
        L18:
            r14 = r3
            goto L20
        L1a:
            com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$chat$1 r3 = new com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$chat$1
            r3.<init>(r2)
            goto L18
        L20:
            java.lang.Object r2 = r14.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r4 = r14.label
            r5 = 1
            if (r4 == 0) goto L3f
            if (r4 != r5) goto L37
            java.lang.Object r1 = r14.L$1
            com.stepos.agentframework.adapter.netcore.EventListener r1 = (com.stepos.agentframework.adapter.netcore.EventListener) r1
            java.lang.Object r1 = r14.L$0
            V4.l r1 = (V4.l) r1
            kotlin.b.b(r2)
            goto L79
        L37:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3f:
            kotlin.b.b(r2)
            com.stepos.agentframework.adapter.coze.CozeClient$Companion r2 = com.stepos.agentframework.adapter.coze.CozeClient.INSTANCE
            com.stepos.agentframework.adapter.coze.CozeClient r4 = r2.getInstance()
            java.lang.String r2 = r1.f1364a
            java.lang.String r6 = r1.b
            java.lang.String r7 = r1.e
            if (r7 != 0) goto L52
            java.lang.String r7 = ""
        L52:
            java.util.List r8 = r1.c
            java.lang.String r11 = r1.i
            com.stepos.agentframework.adapter.coze.bean.Thinking r12 = new com.stepos.agentframework.adapter.coze.bean.Thinking
            java.lang.String r9 = "disabled"
            r12.<init>(r9)
            com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$chat$eventSource$1 r13 = new com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$chat$eventSource$1
            r9 = r19
            r13.<init>()
            r1 = 0
            r14.L$0 = r1
            r14.L$1 = r1
            r14.label = r5
            r9 = 0
            r10 = 0
            r15 = 16
            r16 = 0
            r5 = r2
            java.lang.Object r2 = com.stepos.agentframework.adapter.coze.CozeClient.requestChatStreaming$default(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            if (r2 != r3) goto L79
            return r3
        L79:
            R9.a r2 = (R9.a) r2
            com.stepos.agentframework.adapter.netcore.EventSourceState r1 = new com.stepos.agentframework.adapter.netcore.EventSourceState
            r1.<init>(r2)
            r0.addEventSourceState(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.coze.CozeCoreAgentClient.chat(V4.l, com.stepos.agentframework.adapter.netcore.EventListener, H7.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object clearSession(String str, H7.c<? super r> cVar) {
        return super.clearSession(str, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object createSession(H7.c<? super String> cVar) {
        return super.createSession(cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object deleteSession(String str, H7.c<? super r> cVar) {
        return super.deleteSession(str, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object deleteTask(C c, H7.c<? super Boolean> cVar) {
        return super.deleteTask(c, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public void destroy() {
        super.destroy();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object feedback(V4.q r4, H7.c<? super java.lang.Boolean> r5) {
        /*
            r3 = this;
            boolean r4 = r5 instanceof com.stepos.agentframework.adapter.coze.CozeCoreAgentClient.C10861
            if (r4 == 0) goto L13
            r4 = r5
            com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$feedback$1 r4 = (com.stepos.agentframework.adapter.coze.CozeCoreAgentClient.C10861) r4
            int r0 = r4.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r4.label = r0
            goto L18
        L13:
            com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$feedback$1 r4 = new com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$feedback$1
            r4.<init>(r5)
        L18:
            java.lang.Object r3 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r5 = r4.label
            if (r5 == 0) goto L3f
            r0 = 1
            if (r5 != r0) goto L37
            java.lang.Object r5 = r4.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r4 = r4.L$0
            if (r4 != 0) goto L31
            kotlin.b.b(r3)
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            return r3
        L31:
            java.lang.ClassCastException r3 = new java.lang.ClassCastException
            r3.<init>()
            throw r3
        L37:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L3f:
            kotlin.b.b(r3)
            r3 = 0
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.coze.CozeCoreAgentClient.feedback(V4.q, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getAgentDetail(V4.AbstractC0255b r4, H7.c<? super V4.C0254a> r5) {
        /*
            r3 = this;
            boolean r4 = r5 instanceof com.stepos.agentframework.adapter.coze.CozeCoreAgentClient.C10871
            if (r4 == 0) goto L13
            r4 = r5
            com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$getAgentDetail$1 r4 = (com.stepos.agentframework.adapter.coze.CozeCoreAgentClient.C10871) r4
            int r0 = r4.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r4.label = r0
            goto L18
        L13:
            com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$getAgentDetail$1 r4 = new com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$getAgentDetail$1
            r4.<init>(r5)
        L18:
            java.lang.Object r3 = r4.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r5 = r4.label
            r0 = 0
            if (r5 == 0) goto L6c
            r1 = 1
            if (r5 != r1) goto L64
            java.lang.Object r4 = r4.L$0
            if (r4 != 0) goto L5e
            kotlin.b.b(r3)
            com.stepos.agentframework.adapter.coze.bean.AgentDetailResult r3 = (com.stepos.agentframework.adapter.coze.bean.AgentDetailResult) r3
            com.stepos.agentframework.adapter.coze.bean.AgentDetailResult$Data r3 = r3.getData()
            V4.a r4 = new V4.a
            r4.<init>()
            r3.getName()
            r3.getBot_id()
            r3.getIcon_url()
            com.stepos.agentframework.adapter.coze.bean.AgentDetailResult$Data$OnboardingInfo r5 = r3.getOnboarding_info()
            if (r5 == 0) goto L48
            r5.getPrologue()
        L48:
            com.stepos.agentframework.adapter.coze.bean.AgentDetailResult$Data$OnboardingInfo r5 = r3.getOnboarding_info()
            if (r5 == 0) goto L52
            java.util.List r0 = r5.getSuggested_questions()
        L52:
            r4.f1362a = r0
            com.stepos.agentframework.adapter.coze.bean.AgentDetailResult$Data$MediaConfig r3 = r3.getMedia_config()
            if (r3 == 0) goto L5d
            r3.is_voice_call_closed()
        L5d:
            return r4
        L5e:
            java.lang.ClassCastException r3 = new java.lang.ClassCastException
            r3.<init>()
            throw r3
        L64:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L6c:
            kotlin.b.b(r3)
            com.stepos.agentframework.adapter.coze.CozeClient$Companion r3 = com.stepos.agentframework.adapter.coze.CozeClient.INSTANCE
            r3.getInstance()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.coze.CozeCoreAgentClient.getAgentDetail(V4.b, H7.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public ApiType getType() {
        return this.type;
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public void init(Context context, ILogger logger) {
        k.f(context, "context");
        k.f(logger, "logger");
        CozeClient.Companion companion = CozeClient.INSTANCE;
        companion.getInstance().init(context, this.timeOut, companion.getURL(), logger);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object interactTask(D d, H7.c<? super Boolean> cVar) {
        return super.interactTask(d, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ void onNetworkChanged(boolean z10) {
        super.onNetworkChanged(z10);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object pauseTask(F f, H7.c<? super Boolean> cVar) {
        return super.pauseTask(f, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object readCoreFile(String str, H7.c<? super String> cVar) {
        return super.readCoreFile(str, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object readFile(String str, H7.c<? super String> cVar) {
        return super.readFile(str, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object renameSession(String str, String str2, H7.c<? super r> cVar) {
        return super.renameSession(str, str2, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object renameTask(E e, H7.c<? super Boolean> cVar) {
        return super.renameTask(e, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object resumeTask(F f, H7.c<? super Boolean> cVar) {
        return super.resumeTask(f, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object retryTask(G g, H7.c<? super Boolean> cVar) {
        return super.retryTask(g, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object syncConversations(H7.c<? super x> cVar) {
        return super.syncConversations(cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object syncHistory(y yVar, H7.c<? super z> cVar) {
        return super.syncHistory(yVar, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public Object uploadFile(Context context, H h, p pVar, H7.c<? super r> cVar) {
        throw null;
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object vote(I i, H7.c<? super Boolean> cVar) {
        return super.vote(i, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object writeCoreFile(String str, String str2, H7.c<? super Boolean> cVar) {
        return super.writeCoreFile(str, str2, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object writeFile(String str, String str2, H7.c<? super Boolean> cVar) {
        return super.writeFile(str, str2, cVar);
    }
}
