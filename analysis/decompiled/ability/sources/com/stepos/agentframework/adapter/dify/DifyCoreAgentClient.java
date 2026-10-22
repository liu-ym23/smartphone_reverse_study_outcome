package com.stepos.agentframework.adapter.dify;

import C7.r;
import H7.c;
import S7.p;
import V4.A;
import V4.AbstractC0255b;
import V4.B;
import V4.C;
import V4.C0254a;
import V4.D;
import V4.E;
import V4.F;
import V4.G;
import V4.H;
import V4.I;
import V4.q;
import V4.x;
import V4.y;
import V4.z;
import android.content.Context;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.agentframework.adapter.dify.DifyClient;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.adapter.netcore.EventSourceState;
import com.stepos.agentframework.adapter.netcore.ICoreAgentClient;
import com.stepos.agentframework.adapter.netcore.ILogger;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0096@¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u001aH\u0096@¢\u0006\u0004\b\u001c\u0010\u001dJH\u0010#\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u001e2&\u0010\"\u001a\"\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020!\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020\b0\u001fH\u0096@¢\u0006\u0004\b#\u0010$J\u001a\u0010'\u001a\u0004\u0018\u00010&2\u0006\u0010\u0014\u001a\u00020%H\u0096@¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010)R\u001a\u0010+\u001a\u00020*8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R \u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0006000/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00063"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/DifyCoreAgentClient;", "Lcom/stepos/agentframework/adapter/netcore/ICoreAgentClient;", "", "timeOut", AppAgent.CONSTRUCT, "(J)V", "Lcom/stepos/agentframework/adapter/netcore/EventSourceState;", "eventSourceState", "LC7/r;", "addEventSourceState", "(Lcom/stepos/agentframework/adapter/netcore/EventSourceState;)V", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/adapter/netcore/ILogger;", "logger", "init", "(Landroid/content/Context;Lcom/stepos/agentframework/adapter/netcore/ILogger;)V", "destroy", "()V", "LV4/l;", "request", "Lcom/stepos/agentframework/adapter/netcore/EventListener;", "listener", "Lcom/stepos/agentframework/adapter/netcore/ICancelHandle;", "chat", "(LV4/l;Lcom/stepos/agentframework/adapter/netcore/EventListener;LH7/c;)Ljava/lang/Object;", "LV4/q;", "", "feedback", "(LV4/q;LH7/c;)Ljava/lang/Object;", "LV4/H;", "Lkotlin/Function4;", "", "", GuiTaskProgressKt.GuiTaskProgress_VALUE_METHOD_ONPRGRESS, "uploadFile", "(Landroid/content/Context;LV4/H;LS7/p;LH7/c;)Ljava/lang/Object;", "LV4/b;", "LV4/a;", "getAgentDetail", "(LV4/b;LH7/c;)Ljava/lang/Object;", "J", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "type", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "getType", "()Lcom/stepos/agentframework/adapter/netcore/ApiType;", "", "Ljava/lang/ref/WeakReference;", "eventSourceStates", "Ljava/util/Set;", "dify_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DifyCoreAgentClient implements ICoreAgentClient {
    private final long timeOut;
    private final ApiType type = ApiType.DIFY;
    private final Set<WeakReference<EventSourceState>> eventSourceStates = new LinkedHashSet();

    public DifyCoreAgentClient(long j5) {
        this.timeOut = j5;
    }

    private final void addEventSourceState(EventSourceState eventSourceState) {
        this.eventSourceStates.add(new WeakReference<>(eventSourceState));
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object batchDeleteTasks(A a3, c<? super Boolean> cVar) {
        return super.batchDeleteTasks(a3, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object cancelTask(B b, c<? super Boolean> cVar) {
        return super.cancelTask(b, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object chat(final V4.l r12, final com.stepos.agentframework.adapter.netcore.EventListener r13, H7.c<? super com.stepos.agentframework.adapter.netcore.ICancelHandle> r14) {
        /*
            r11 = this;
            kotlin.jvm.internal.Ref$ObjectRef r14 = new kotlin.jvm.internal.Ref$ObjectRef
            r14.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            com.stepos.agentframework.adapter.dify.DifyClient$Companion r1 = com.stepos.agentframework.adapter.dify.DifyClient.INSTANCE
            com.stepos.agentframework.adapter.dify.DifyClient r2 = r1.getInstance()
            java.lang.String r3 = r12.f1364a
            java.util.List r1 = r12.c
            if (r1 == 0) goto L3e
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r1 = r1.iterator()
        L21:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L33
            java.lang.Object r5 = r1.next()
            boolean r6 = r5 instanceof V4.C0260g
            if (r6 == 0) goto L21
            r4.add(r5)
            goto L21
        L33:
            java.lang.Object r1 = D7.v.C0(r4)
            V4.g r1 = (V4.C0260g) r1
            if (r1 == 0) goto L3e
            java.lang.String r1 = r1.b
            goto L3f
        L3e:
            r1 = 0
        L3f:
            java.lang.String r4 = ""
            if (r1 != 0) goto L45
            r5 = r4
            goto L46
        L45:
            r5 = r1
        L46:
            java.lang.String r1 = r12.e
            if (r1 != 0) goto L4c
            r6 = r4
            goto L4d
        L4c:
            r6 = r1
        L4d:
            com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1 r8 = new com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1
            r8.<init>()
            r9 = 16
            r10 = 0
            r4 = 0
            r7 = 0
            R9.a r12 = com.stepos.agentframework.adapter.dify.DifyClient.requestChatStreaming$default(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            com.stepos.agentframework.adapter.netcore.EventSourceState r13 = new com.stepos.agentframework.adapter.netcore.EventSourceState
            r13.<init>(r12)
            r11.addEventSourceState(r13)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.dify.DifyCoreAgentClient.chat(V4.l, com.stepos.agentframework.adapter.netcore.EventListener, H7.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object clearSession(String str, c<? super r> cVar) {
        return super.clearSession(str, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object createSession(c<? super String> cVar) {
        return super.createSession(cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object deleteSession(String str, c<? super r> cVar) {
        return super.deleteSession(str, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object deleteTask(C c, c<? super Boolean> cVar) {
        return super.deleteTask(c, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public void destroy() {
        super.destroy();
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public Object feedback(q qVar, c<? super Boolean> cVar) {
        return super.feedback(qVar, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public Object getAgentDetail(AbstractC0255b abstractC0255b, c<? super C0254a> cVar) {
        return super.getAgentDetail(abstractC0255b, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public ApiType getType() {
        return this.type;
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public void init(Context context, ILogger logger) {
        k.f(context, "context");
        k.f(logger, "logger");
        DifyClient.Companion companion = DifyClient.INSTANCE;
        companion.getInstance().init(context, this.timeOut, companion.getURL());
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object interactTask(D d, c<? super Boolean> cVar) {
        return super.interactTask(d, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ void onNetworkChanged(boolean z10) {
        super.onNetworkChanged(z10);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object pauseTask(F f, c<? super Boolean> cVar) {
        return super.pauseTask(f, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object readCoreFile(String str, c<? super String> cVar) {
        return super.readCoreFile(str, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object readFile(String str, c<? super String> cVar) {
        return super.readFile(str, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object renameSession(String str, String str2, c<? super r> cVar) {
        return super.renameSession(str, str2, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object renameTask(E e, c<? super Boolean> cVar) {
        return super.renameTask(e, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object resumeTask(F f, c<? super Boolean> cVar) {
        return super.resumeTask(f, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object retryTask(G g, c<? super Boolean> cVar) {
        return super.retryTask(g, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object syncConversations(c<? super x> cVar) {
        return super.syncConversations(cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object syncHistory(y yVar, c<? super z> cVar) {
        return super.syncHistory(yVar, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public Object uploadFile(Context context, H h, p pVar, c<? super r> cVar) {
        Object objUploadFile = super.uploadFile(context, h, pVar, cVar);
        return objUploadFile == CoroutineSingletons.f4909a ? objUploadFile : r.f317a;
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object vote(I i, c<? super Boolean> cVar) {
        return super.vote(i, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object writeCoreFile(String str, String str2, c<? super Boolean> cVar) {
        return super.writeCoreFile(str, str2, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object writeFile(String str, String str2, c<? super Boolean> cVar) {
        return super.writeFile(str, str2, cVar);
    }
}
