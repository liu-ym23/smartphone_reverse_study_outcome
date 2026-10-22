package com.stepos.agentframework.adapter.bff;

import C7.f;
import C7.r;
import D6.i;
import J7.c;
import N9.j;
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
import V4.q;
import V4.x;
import V4.y;
import V4.z;
import android.content.Context;
import androidx.core.view.PointerIconCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.adapter.netcore.EventListener;
import com.stepos.agentframework.adapter.netcore.ICoreAgentClient;
import com.stepos.agentframework.adapter.netcore.ILogger;
import com.stepos.agentframework.adapter.netcore.Logger;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\u0010!\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u0001JB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0016H\u0096@¢\u0006\u0004\b\u0018\u0010\u0019JH\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u001a2&\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\n0\u001bH\u0096@¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0010\u001a\u00020!H\u0096@¢\u0006\u0004\b#\u0010$J\u0015\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u0018\u0010*\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020)H\u0096@¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0017H\u0016¢\u0006\u0004\b-\u0010.J\u001f\u00101\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102R\u001a\u00104\u001a\u0002038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010=Rl\u0010B\u001aZ\u0012\f\u0012\n ?*\u0004\u0018\u00010\u00110\u0011\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020/ ?*\n\u0012\u0004\u0012\u00020/\u0018\u00010@0@ ?*,\u0012\f\u0012\n ?*\u0004\u0018\u00010\u00110\u0011\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020/ ?*\n\u0012\u0004\u0012\u00020/\u0018\u00010@0@\u0018\u00010A0>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u001b\u0010I\u001a\u00020D8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H¨\u0006K"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/BffCoreAgentClient;", "Lcom/stepos/agentframework/adapter/netcore/ICoreAgentClient;", "", "timeOut", AppAgent.CONSTRUCT, "(J)V", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/adapter/netcore/ILogger;", "log", "LC7/r;", "init", "(Landroid/content/Context;Lcom/stepos/agentframework/adapter/netcore/ILogger;)V", "destroy", "()V", "LV4/l;", "request", "Lcom/stepos/agentframework/adapter/netcore/EventListener;", "listener", "Lcom/stepos/agentframework/adapter/netcore/ICancelHandle;", "chat", "(LV4/l;Lcom/stepos/agentframework/adapter/netcore/EventListener;LH7/c;)Ljava/lang/Object;", "LV4/q;", "", "feedback", "(LV4/q;LH7/c;)Ljava/lang/Object;", "LV4/H;", "Lkotlin/Function4;", "", "", GuiTaskProgressKt.GuiTaskProgress_VALUE_METHOD_ONPRGRESS, "uploadFile", "(Landroid/content/Context;LV4/H;LS7/p;LH7/c;)Ljava/lang/Object;", "LV4/b;", "LV4/a;", "getAgentDetail", "(LV4/b;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/agentframework/adapter/bff/AuthInfo;", "authInfo", "updateAuth", "(Lcom/stepos/agentframework/adapter/bff/AuthInfo;)V", "LV4/I;", "vote", "(LV4/I;LH7/c;)Ljava/lang/Object;", "isAvailable", "onNetworkChanged", "(Z)V", "Lcom/stepos/agentframework/adapter/bff/IDataCallback;", "callback", "cleanGuard", "(Lcom/stepos/agentframework/adapter/netcore/EventListener;Lcom/stepos/agentframework/adapter/bff/IDataCallback;)V", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "type", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "getType", "()Lcom/stepos/agentframework/adapter/netcore/ApiType;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "logger", "Lcom/stepos/agentframework/adapter/netcore/ILogger;", "Landroid/content/Context;", "", "kotlin.jvm.PlatformType", "", "", "lifecycleGuardMap", "Ljava/util/Map;", "Lcom/stepos/agentframework/adapter/bff/BffClient;", "internalClient$delegate", "LC7/f;", "getInternalClient", "()Lcom/stepos/agentframework/adapter/bff/BffClient;", "internalClient", "Companion", "bff_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BffCoreAgentClient implements ICoreAgentClient {
    private static final String TAG = " [BffCoreAgentClient] ";
    private Context context;
    private final ApiType type = ApiType.BFF;
    private final Gson gson = new Gson();
    private ILogger logger = Logger.INSTANCE;
    private final Map<EventListener, List<IDataCallback>> lifecycleGuardMap = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: internalClient$delegate, reason: from kotlin metadata */
    private final f internalClient = kotlin.a.a(new i(this, 20));

    @c(c = "com.stepos.agentframework.adapter.bff.BffCoreAgentClient", f = "BffCoreAgentClient.kt", l = {205}, m = "vote", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.bff.BffCoreAgentClient$vote$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BffCoreAgentClient.this.vote(null, this);
        }
    }

    public BffCoreAgentClient(long j5) {
    }

    private final void cleanGuard(EventListener listener, IDataCallback callback) {
        List<IDataCallback> list = this.lifecycleGuardMap.get(listener);
        if (list != null) {
            list.remove(callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final BffClient internalClient_delegate$lambda$0(BffCoreAgentClient bffCoreAgentClient) throws Throwable {
        String strI = M.a.X(bffCoreAgentClient.context).i();
        Context context = bffCoreAgentClient.context;
        k.c(context);
        String strY = j.y(context.getApplicationContext());
        if (strY == null) {
            strY = "";
        }
        return new BffClient(new Option(strI, strY, new AuthInfo("token", "uid", null, null, 0, null, null, null, null, null, PointerIconCompat.TYPE_GRAB, null), null, null, true, false, 0L, false, 472, 0 == true ? 1 : 0));
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object batchDeleteTasks(A a3, H7.c<? super Boolean> cVar) {
        return super.batchDeleteTasks(a3, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object cancelTask(B b, H7.c<? super Boolean> cVar) {
        return super.cancelTask(b, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0075  */
    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object chat(final V4.l r9, final com.stepos.agentframework.adapter.netcore.EventListener r10, H7.c<? super com.stepos.agentframework.adapter.netcore.ICancelHandle> r11) {
        /*
            r8 = this;
            com.stepos.agentframework.adapter.bff.BffCoreAgentClient$chat$callback$1 r11 = new com.stepos.agentframework.adapter.bff.BffCoreAgentClient$chat$callback$1
            r11.<init>()
            r10.onHandle(r11)
            java.util.Map<com.stepos.agentframework.adapter.netcore.EventListener, java.util.List<com.stepos.agentframework.adapter.bff.IDataCallback>> r0 = r8.lifecycleGuardMap
            java.lang.String r1 = "lifecycleGuardMap"
            kotlin.jvm.internal.k.e(r0, r1)
            java.lang.Object r1 = r0.get(r10)
            if (r1 != 0) goto L1d
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0.put(r10, r1)
        L1d:
            java.util.List r1 = (java.util.List) r1
            r1.add(r11)
            r9.getClass()
            r10 = 0
            java.lang.String r10 = g1.AbstractC1451a.I(r9, r10)
            java.lang.String r0 = ""
            if (r10 != 0) goto L2f
            r10 = r0
        L2f:
            boolean r1 = j9.m.s0(r10)
            r2 = 0
            if (r1 != 0) goto L37
            goto L38
        L37:
            r10 = r2
        L38:
            if (r10 != 0) goto L3c
            java.lang.String r10 = "Task"
        L3c:
            r1 = 1
            java.lang.String r1 = g1.AbstractC1451a.I(r9, r1)
            if (r1 != 0) goto L44
            goto L45
        L44:
            r0 = r1
        L45:
            boolean r1 = j9.m.s0(r0)
            if (r1 != 0) goto L4c
            goto L4d
        L4c:
            r0 = r2
        L4d:
            if (r0 != 0) goto L51
            java.lang.String r0 = "Invoke"
        L51:
            r1 = 2
            java.lang.String r1 = g1.AbstractC1451a.I(r9, r1)
            if (r1 == 0) goto L62
            boolean r3 = j9.m.s0(r1)
            if (r3 != 0) goto L5f
            goto L60
        L5f:
            r1 = r2
        L60:
            if (r1 != 0) goto L64
        L62:
            java.lang.String r1 = "Omni"
        L64:
            r3 = 3
            java.lang.String r3 = g1.AbstractC1451a.I(r9, r3)
            if (r3 == 0) goto L75
            boolean r4 = j9.m.s0(r3)
            if (r4 != 0) goto L72
            goto L73
        L72:
            r3 = r2
        L73:
            if (r3 != 0) goto L77
        L75:
            java.lang.String r3 = "Chat"
        L77:
            com.stepos.agentframework.adapter.netcore.ILogger r4 = r8.logger
            java.lang.String r5 = ",  bizCommand:"
            java.lang.String r6 = ", aiModule:"
            java.lang.String r7 = "Bff router: bizModule:"
            java.lang.StringBuilder r5 = B7.a.w(r7, r10, r5, r0, r6)
            java.lang.String r6 = ", aiCommand:"
            java.lang.String r5 = androidx.constraintlayout.core.dsl.a.j(r5, r1, r6, r3)
            java.lang.String r6 = " [BffCoreAgentClient] "
            r4.i(r6, r5)
            com.stepos.agentframework.adapter.bff.BffRouter r4 = new com.stepos.agentframework.adapter.bff.BffRouter
            r4.<init>(r10, r0, r1, r3)
            com.stepos.agentframework.adapter.bff.BffClient r8 = r8.getInternalClient()
            r8.chat(r4, r9, r11)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.bff.BffCoreAgentClient.chat(V4.l, com.stepos.agentframework.adapter.netcore.EventListener, H7.c):java.lang.Object");
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
        this.lifecycleGuardMap.clear();
        getInternalClient().close();
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public Object feedback(q qVar, H7.c<? super Boolean> cVar) {
        return super.feedback(qVar, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public Object getAgentDetail(AbstractC0255b abstractC0255b, H7.c<? super C0254a> cVar) {
        return super.getAgentDetail(abstractC0255b, cVar);
    }

    public final BffClient getInternalClient() {
        return (BffClient) this.internalClient.getF4884a();
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public ApiType getType() {
        return this.type;
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public void init(Context context, ILogger log) {
        k.f(context, "context");
        k.f(log, "log");
        this.context = context;
        this.logger = log;
        getInternalClient().init();
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object interactTask(D d, H7.c<? super Boolean> cVar) {
        return super.interactTask(d, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public void onNetworkChanged(boolean isAvailable) {
        getInternalClient().onNetworkChanged(isAvailable);
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

    public final void updateAuth(AuthInfo authInfo) {
        k.f(authInfo, "authInfo");
        getInternalClient().updateAuth(authInfo);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public Object uploadFile(Context context, H h, p pVar, H7.c<? super r> cVar) {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object vote(V4.I r12, H7.c<? super java.lang.Boolean> r13) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.bff.BffCoreAgentClient.vote(V4.I, H7.c):java.lang.Object");
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
