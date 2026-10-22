package com.stepos.agentframework.adapter.agentspace;

import C7.r;
import D7.q;
import D7.v;
import F9.AbstractC0226d;
import F9.B;
import F9.E;
import F9.F;
import F9.I;
import F9.J;
import F9.K;
import F9.M;
import F9.P;
import J7.c;
import J9.i;
import M.a;
import S7.n;
import S7.p;
import V4.A;
import V4.AbstractC0255b;
import V4.C;
import V4.C0254a;
import V4.D;
import V4.G;
import V4.H;
import V4.l;
import V4.x;
import V4.y;
import V4.z;
import android.content.Context;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.gson.Gson;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.adapter.netcore.EventListener;
import com.stepos.agentframework.adapter.netcore.ICancelHandle;
import com.stepos.agentframework.adapter.netcore.ICoreAgentClient;
import com.stepos.agentframework.adapter.netcore.ILogger;
import com.stepos.agentframework.adapter.netcore.Logger;
import com.stepos.statsrpk.d;
import j9.m;
import j9.t;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.b;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 22\u00020\u0001:\u00012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0096@¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u001aH\u0086@¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u001dH\u0086@¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010!R\u001a\u0010#\u001a\u00020\"8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/stepos/agentframework/adapter/agentspace/AgentSpaceCoreAgentClient;", "Lcom/stepos/agentframework/adapter/netcore/ICoreAgentClient;", "", "timeOutSeconds", AppAgent.CONSTRUCT, "(J)V", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/adapter/netcore/ILogger;", "logger", "LC7/r;", "init", "(Landroid/content/Context;Lcom/stepos/agentframework/adapter/netcore/ILogger;)V", "", "token", "onAuthTokenChanged", "(Ljava/lang/String;)V", "LV4/l;", "request", "Lcom/stepos/agentframework/adapter/netcore/EventListener;", "listener", "Lcom/stepos/agentframework/adapter/netcore/ICancelHandle;", "chat", "(LV4/l;Lcom/stepos/agentframework/adapter/netcore/EventListener;LH7/c;)Ljava/lang/Object;", "destroy", "()V", "", "fetchFeedbackDislikeReasons", "(LH7/c;)Ljava/lang/Object;", "Lcom/stepos/agentframework/adapter/agentspace/AgentSpaceVoteRequest;", "", "submitVote", "(Lcom/stepos/agentframework/adapter/agentspace/AgentSpaceVoteRequest;LH7/c;)Ljava/lang/Object;", "J", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "type", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "getType", "()Lcom/stepos/agentframework/adapter/netcore/ApiType;", "Lcom/stepos/agentframework/adapter/netcore/ILogger;", "appContext", "Landroid/content/Context;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "bearerToken", "Ljava/lang/String;", "LF9/F;", "okHttpClient", "LF9/F;", "Companion", "adapter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentSpaceCoreAgentClient implements ICoreAgentClient {
    public static final String CONFIG_QUERY_PATH = "api/v1/query";
    private static final B JSON_MEDIA;
    private static final String TAG = "AgentSpaceCoreAgentClient";
    public static final String VOTE_ACTION_PATH = "task-engine/vote/action";
    private Context appContext;
    private volatile String bearerToken;
    private F okHttpClient;
    private final long timeOutSeconds;
    private final ApiType type = ApiType.AGENT_SPACE;
    private ILogger logger = Logger.INSTANCE;
    private final Gson gson = new Gson();

    @c(c = "com.stepos.agentframework.adapter.agentspace.AgentSpaceCoreAgentClient$fetchFeedbackDislikeReasons$2", f = "AgentSpaceCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "", "", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.agentspace.AgentSpaceCoreAgentClient$fetchFeedbackDislikeReasons$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        int label;

        public AnonymousClass2(H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return AgentSpaceCoreAgentClient.this.new AnonymousClass2(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AgentSpaceConfigQueryResponse agentSpaceConfigQueryResponse;
            String value;
            Object objI0;
            EmptyList emptyList;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            Context context = AgentSpaceCoreAgentClient.this.appContext;
            if (context == null) {
                return EmptyList.f4893a;
            }
            try {
                String str = m.T0(a.X(context).e(), JsonPointer.SEPARATOR) + "/api/v1/query";
                Object obj2 = null;
                String json = AgentSpaceCoreAgentClient.this.gson.toJson(new AgentSpaceConfigQueryRequest(null, null, 3, null));
                J j5 = K.Companion;
                k.c(json);
                B b = AgentSpaceCoreAgentClient.JSON_MEDIA;
                j5.getClass();
                I iB = J.b(json, b);
                K1.a aVar = new K1.a();
                aVar.s(str);
                aVar.i(iB);
                String str2 = AgentSpaceCoreAgentClient.this.bearerToken;
                if (str2 != null) {
                    aVar.g("Authorization", "Bearer ".concat(str2));
                }
                d.D(AgentSpaceCoreAgentClient.TAG, "fetchFeedbackDislikeReasons request: url=" + str + ", authorization=" + ((str2 == null || m.s0(str2)) ? "null" : "Bearer ***") + ", body=" + json);
                F f = AgentSpaceCoreAgentClient.this.okHttpClient;
                if (f == null) {
                    k.n("okHttpClient");
                    throw null;
                }
                M mD = new i(f, aVar.d()).d();
                int i = mD.d;
                AgentSpaceCoreAgentClient agentSpaceCoreAgentClient = AgentSpaceCoreAgentClient.this;
                try {
                    P p = mD.g;
                    String strG = p != null ? p.g() : null;
                    if (strG == null) {
                        strG = "";
                    }
                    d.D(AgentSpaceCoreAgentClient.TAG, "fetchFeedbackDislikeReasons response: code=" + i + ", body=" + strG);
                    if (!mD.c()) {
                        d.u(AgentSpaceCoreAgentClient.TAG, "fetchFeedbackDislikeReasons HTTP " + i);
                        emptyList = EmptyList.f4893a;
                    } else if (m.s0(strG) || (agentSpaceConfigQueryResponse = (AgentSpaceConfigQueryResponse) agentSpaceCoreAgentClient.gson.fromJson(strG, AgentSpaceConfigQueryResponse.class)) == null) {
                        emptyList = EmptyList.f4893a;
                    } else if (agentSpaceConfigQueryResponse.getCode() != 200) {
                        d.u(AgentSpaceCoreAgentClient.TAG, "fetchFeedbackDislikeReasons code=" + agentSpaceConfigQueryResponse.getCode() + " msg=" + agentSpaceConfigQueryResponse.getMsg());
                        emptyList = EmptyList.f4893a;
                    } else {
                        List<AgentSpaceConfigItem> data = agentSpaceConfigQueryResponse.getData();
                        if (data == null) {
                            emptyList = EmptyList.f4893a;
                        } else {
                            Iterator<T> it = data.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                Object next = it.next();
                                if (k.b(((AgentSpaceConfigItem) next).getKey(), "feedback_options")) {
                                    obj2 = next;
                                    break;
                                }
                            }
                            AgentSpaceConfigItem agentSpaceConfigItem = (AgentSpaceConfigItem) obj2;
                            if ((agentSpaceConfigItem != null || (agentSpaceConfigItem = (AgentSpaceConfigItem) v.C0(data)) != null) && (value = agentSpaceConfigItem.getValue()) != null) {
                                try {
                                    Object objFromJson = agentSpaceCoreAgentClient.gson.fromJson(value, (Class<Object>) String[].class);
                                    k.e(objFromJson, "fromJson(...)");
                                    objI0 = q.I0((Object[]) objFromJson);
                                } catch (Exception e) {
                                    d.v(AgentSpaceCoreAgentClient.TAG, "parse value: " + e.getMessage(), e);
                                    objI0 = EmptyList.f4893a;
                                }
                                mD.close();
                                return objI0;
                            }
                            emptyList = EmptyList.f4893a;
                        }
                    }
                    mD.close();
                    return emptyList;
                } finally {
                }
            } catch (Exception e6) {
                d.v(AgentSpaceCoreAgentClient.TAG, "fetchFeedbackDislikeReasons: " + e6.getMessage(), e6);
                return EmptyList.f4893a;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<String>> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.agentframework.adapter.agentspace.AgentSpaceCoreAgentClient$submitVote$2", f = "AgentSpaceCoreAgentClient.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Z"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentframework.adapter.agentspace.AgentSpaceCoreAgentClient$submitVote$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10822 extends SuspendLambda implements n {
        final /* synthetic */ AgentSpaceVoteRequest $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10822(AgentSpaceVoteRequest agentSpaceVoteRequest, H7.c<? super C10822> cVar) {
            super(2, cVar);
            this.$request = agentSpaceVoteRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return AgentSpaceCoreAgentClient.this.new C10822(this.$request, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AgentSpaceVoteResponse agentSpaceVoteResponse;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            Context context = AgentSpaceCoreAgentClient.this.appContext;
            if (context == null) {
                return Boolean.FALSE;
            }
            try {
                String str = m.T0(a.X(context).e(), JsonPointer.SEPARATOR) + "/task-engine/vote/action";
                String json = AgentSpaceCoreAgentClient.this.gson.toJson(this.$request);
                J j5 = K.Companion;
                k.c(json);
                B b = AgentSpaceCoreAgentClient.JSON_MEDIA;
                j5.getClass();
                I iB = J.b(json, b);
                K1.a aVar = new K1.a();
                aVar.s(str);
                aVar.i(iB);
                String str2 = AgentSpaceCoreAgentClient.this.bearerToken;
                if (str2 != null) {
                    aVar.g("Authorization", "Bearer ".concat(str2));
                }
                d.D(AgentSpaceCoreAgentClient.TAG, "submitVote request: url=" + str + ", authorization=" + ((str2 == null || m.s0(str2)) ? "null" : "Bearer ***") + ", body=" + json);
                F f = AgentSpaceCoreAgentClient.this.okHttpClient;
                if (f == null) {
                    k.n("okHttpClient");
                    throw null;
                }
                M mD = new i(f, aVar.d()).d();
                AgentSpaceCoreAgentClient agentSpaceCoreAgentClient = AgentSpaceCoreAgentClient.this;
                try {
                    P p = mD.g;
                    String strG = p != null ? p.g() : null;
                    if (strG == null) {
                        strG = "";
                    }
                    d.D(AgentSpaceCoreAgentClient.TAG, "submitVote response: code=" + mD.d + ", body=" + strG);
                    Boolean boolValueOf = (!mD.c() || m.s0(strG) || (agentSpaceVoteResponse = (AgentSpaceVoteResponse) agentSpaceCoreAgentClient.gson.fromJson(strG, AgentSpaceVoteResponse.class)) == null) ? Boolean.FALSE : Boolean.valueOf(t.X(agentSpaceVoteResponse.getStatus(), "success"));
                    mD.close();
                    return boolValueOf;
                } finally {
                }
            } catch (Exception e) {
                d.v(AgentSpaceCoreAgentClient.TAG, "submitVote: " + e.getMessage(), e);
                return Boolean.FALSE;
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Boolean> cVar) {
            return ((C10822) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    static {
        Pattern pattern = B.e;
        JSON_MEDIA = AbstractC0226d.g("application/json; charset=utf-8");
    }

    public AgentSpaceCoreAgentClient(long j5) {
        this.timeOutSeconds = j5;
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object batchDeleteTasks(A a3, H7.c<? super Boolean> cVar) {
        return super.batchDeleteTasks(a3, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object cancelTask(V4.B b, H7.c<? super Boolean> cVar) {
        return super.cancelTask(b, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public Object chat(l lVar, EventListener eventListener, H7.c<? super ICancelHandle> cVar) {
        return null;
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
        F f;
        try {
            f = this.okHttpClient;
        } catch (Exception e) {
            d.v(TAG, "destroy: " + e.getMessage(), e);
            this.logger.e(TAG, "destroy: " + e.getMessage());
        }
        if (f == null) {
            k.n("okHttpClient");
            throw null;
        }
        f.f616a.a();
        F f7 = this.okHttpClient;
        if (f7 == null) {
            k.n("okHttpClient");
            throw null;
        }
        f7.b.a();
        this.appContext = null;
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object feedback(V4.q qVar, H7.c<? super Boolean> cVar) {
        return super.feedback(qVar, cVar);
    }

    public final Object fetchFeedbackDislikeReasons(H7.c<? super List<String>> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new AnonymousClass2(null), cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object getAgentDetail(AbstractC0255b abstractC0255b, H7.c<? super C0254a> cVar) {
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
        this.logger = logger;
        this.appContext = context.getApplicationContext();
        long j5 = this.timeOutSeconds;
        if (j5 < 1) {
            j5 = 1;
        }
        E e = new E();
        Context applicationContext = context.getApplicationContext();
        k.e(applicationContext, "getApplicationContext(...)");
        e.a(new AgentHeaderInterceptor(applicationContext));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e.b(j5, timeUnit);
        e.c(j5, timeUnit);
        e.e(j5, timeUnit);
        e.f = true;
        this.okHttpClient = new F(e);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object interactTask(D d, H7.c<? super Boolean> cVar) {
        return super.interactTask(d, cVar);
    }

    public final void onAuthTokenChanged(String token) {
        if (token == null || m.s0(token)) {
            token = null;
        }
        this.bearerToken = token;
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ void onNetworkChanged(boolean z10) {
        super.onNetworkChanged(z10);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object pauseTask(V4.F f, H7.c<? super Boolean> cVar) {
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
    public /* bridge */ Object renameTask(V4.E e, H7.c<? super Boolean> cVar) {
        return super.renameTask(e, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object resumeTask(V4.F f, H7.c<? super Boolean> cVar) {
        return super.resumeTask(f, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object retryTask(G g, H7.c<? super Boolean> cVar) {
        return super.retryTask(g, cVar);
    }

    public final Object submitVote(AgentSpaceVoteRequest agentSpaceVoteRequest, H7.c<? super Boolean> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C10822(agentSpaceVoteRequest, null), cVar);
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
    public /* bridge */ Object uploadFile(Context context, H h, p pVar, H7.c<? super r> cVar) {
        return super.uploadFile(context, h, pVar, cVar);
    }

    @Override // com.stepos.agentframework.adapter.netcore.ICoreAgentClient
    public /* bridge */ Object vote(V4.I i, H7.c<? super Boolean> cVar) {
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
