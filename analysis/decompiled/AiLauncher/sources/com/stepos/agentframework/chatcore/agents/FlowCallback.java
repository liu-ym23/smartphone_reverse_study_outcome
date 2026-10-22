package com.stepos.agentframework.chatcore.agents;

import La.H;
import Ua.C1060i;
import Ua.C1073o0;
import Ua.I;
import Ua.M;
import Ua.Y;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.agents.AgentDispatcher;
import com.stepos.agentframework.chatcore.session.AgentError;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.io.Closeable;
import java.util.Iterator;
import java.util.List;
import kotlin.C0919o;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.ReferenceSource;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import u4.AgentResponse;
import v9.C5680i;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001EB#\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J,\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ&\u0010!\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u00192\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0096\u0001¢\u0006\u0004\b!\u0010\"J(\u0010%\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0019H\u0096\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b'\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010(\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b(\u0010\u000eJ\u0017\u0010)\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b)\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010-\u001a\u0004\b.\u0010/R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010)\u001a\u0004\b0\u00101R\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\n028\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\u00198\u0006X\u0086D¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006F"}, d2 = {"Lcom/stepos/agentframework/chatcore/agents/FlowCallback;", "Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;", "Ljava/io/Closeable;", "callback", "LUa/M;", "scope", "", UxipConstants.f30643G, "<init>", "(Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;LUa/M;J)V", "Lu4/d;", UxipConstants.f30685x, "LY8/t;", "l", "(Lu4/d;)V", "close", "()V", "Lcom/stepos/agentframework/chatcore/session/AgentError;", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/agentframework/chatcore/session/AgentError;)V", "", "success", "", "code", "", "message", Const.INTENT_KEY_PKGNAME, "(ZLjava/lang/Integer;Ljava/lang/String;)V", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, "", "LK6/A;", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/util/List;)V", "name", "resultJson", "m", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "n", "g0", "J", "Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;", "U", "()Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;", "LUa/M;", "getScope", "()LUa/M;", "Y", "()J", "LXa/j;", "flow", "LXa/j;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()LXa/j;", "Lkotlinx/coroutines/g;", "flowJob", "Lkotlinx/coroutines/g;", "getFlowJob", "()Lkotlinx/coroutines/g;", "setFlowJob", "(Lkotlinx/coroutines/g;)V", "TAG", "Ljava/lang/String;", "e0", "()Ljava/lang/String;", "firstTextFlushed", "Z", "Companion", Const.INTENT_KEY_APIKEY, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FlowCallback implements AgentDispatcher.b, Closeable {
    private static final I singleDispather = I.t1(Y.a(), 1, null, 2, null);
    private final String TAG;
    private final AgentDispatcher.b callback;
    private volatile boolean firstTextFlushed;
    private final Xa.j<AgentResponse> flow;
    private kotlinx.coroutines.g flowJob;
    private final long interval;
    private final M scope;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.chatcore.agents.FlowCallback$1", f = "FlowCallback.kt", l = {43}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.chatcore.agents.FlowCallback$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.agentframework.chatcore.agents.FlowCallback$1$a */
        public static final class a<T> implements Xa.c {
            final /* synthetic */ FlowCallback this$0;

            public a(FlowCallback flowCallback) {
                this.this$0 = flowCallback;
            }

            @Override // Xa.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(AgentResponse agentResponse, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
                if (!this.this$0.firstTextFlushed && agentResponse.getType() == AgentMessageType.TEXT && agentResponse.getContent().length() > 0) {
                    this.this$0.firstTextFlushed = true;
                    C0919o.h();
                }
                this.this$0.getCallback().l(agentResponse);
                if (agentResponse.getStatus() == EReplyStatus.COMPLETED) {
                    C4148a.j(this.this$0.getTAG(), "close by complete :" + agentResponse.getContent() + ", " + this.this$0.hashCode() + Const.STR_MART_COMMA + this.this$0.getCallback().hashCode(), true);
                }
                return Y8.t.f7040a;
            }
        }

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return FlowCallback.this.new AnonymousClass1(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                Xa.b bVarG = ExtKt.g(FlowCallback.this.V(), FlowCallback.this.getInterval());
                a aVar = new a(FlowCallback.this);
                this.label = 1;
                if (bVarG.collect(aVar, this) == objG) {
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

    public FlowCallback(AgentDispatcher.b callback, M scope, long j10) {
        kotlin.jvm.internal.p.i(callback, "callback");
        kotlin.jvm.internal.p.i(scope, "scope");
        this.callback = callback;
        this.scope = scope;
        this.interval = j10;
        this.flow = Xa.p.b(0, 1024, null, 5, null);
        this.TAG = " [FlowCallback] ";
        this.flowJob = C1060i.d(scope, singleDispather, null, new AnonymousClass1(null), 2, null);
    }

    public final void J(AgentResponse response) {
        C1060i.d(this.scope, singleDispather, null, new FlowCallback$enqueueResponse$1(this, response, null), 2, null);
    }

    /* renamed from: U, reason: from getter */
    public final AgentDispatcher.b getCallback() {
        return this.callback;
    }

    public final Xa.j<AgentResponse> V() {
        return this.flow;
    }

    /* renamed from: Y, reason: from getter */
    public final long getInterval() {
        return this.interval;
    }

    @Override // com.stepos.agentframework.chatcore.agents.AgentDispatcher.b
    public void b(boolean success, Integer code, String message) {
        this.callback.b(success, code, message);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            Result.Companion companion = Result.INSTANCE;
            String str = this.TAG;
            kotlinx.coroutines.g gVar = this.flowJob;
            C4148a.k(str, "do close isCancelled:" + (gVar != null ? Boolean.valueOf(gVar.isCancelled()) : null), false, 4, null);
            kotlinx.coroutines.g gVar2 = this.flowJob;
            if (gVar2 != null) {
                kotlinx.coroutines.g.Y0(gVar2, null, 1, null);
            }
            this.flowJob = null;
            Result.b(Y8.t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.b(C4849c.a(th));
        }
    }

    @Override // com.stepos.agentframework.chatcore.agents.AgentDispatcher.b
    public void e() {
        this.callback.e();
    }

    /* renamed from: e0, reason: from getter */
    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.stepos.agentframework.chatcore.agents.AgentDispatcher.b
    public void g(String runId, List<ReferenceSource> sources) {
        kotlin.jvm.internal.p.i(runId, "runId");
        kotlin.jvm.internal.p.i(sources, "sources");
        this.callback.g(runId, sources);
    }

    public final void g0(AgentResponse response) throws CloneNotSupportedException {
        String content = response.getContent();
        boolean z10 = response.getStatus() == EReplyStatus.COMPLETED;
        if (content.length() <= 1) {
            J(response);
            return;
        }
        C4148a.j(this.TAG, "onResponse split:" + response.getContent() + ",status:" + response.getStatus() + ", " + hashCode() + Const.STR_MART_COMMA + this.callback.hashCode(), true);
        Iterator<Integer> it = new C5680i(0, content.length() - 1).iterator();
        while (it.hasNext()) {
            int iNextInt = ((Z8.M) it).nextInt();
            AgentResponse agentResponseClone = response.clone();
            agentResponseClone.F(String.valueOf(content.charAt(iNextInt)));
            agentResponseClone.R((z10 && iNextInt == content.length() - 1) ? EReplyStatus.COMPLETED : EReplyStatus.REPLYING);
            if (agentResponseClone.getStatus() == EReplyStatus.COMPLETED) {
                C4148a.j(this.TAG, "complete :" + agentResponseClone.getContent() + ", " + hashCode() + Const.STR_MART_COMMA + this.callback.hashCode(), true);
            }
            J(agentResponseClone);
        }
    }

    @Override // com.stepos.agentframework.chatcore.agents.AgentDispatcher.b
    public void i(AgentError e10) {
        kotlin.jvm.internal.p.i(e10, "e");
        this.callback.i(e10);
    }

    @Override // com.stepos.agentframework.chatcore.agents.AgentDispatcher.b
    public void l(AgentResponse response) throws CloneNotSupportedException {
        kotlin.jvm.internal.p.i(response, "response");
        C4148a.k(this.TAG, "FlowCallback onResponse status: " + response.getStatus(), false, 4, null);
        if (response.getType() != AgentMessageType.TEXT && response.getType() != AgentMessageType.THINKING_TEXT) {
            C4148a.j(this.TAG, "onResponse queue:" + response.getContent() + ",status:" + response.getStatus() + "， " + hashCode() + Const.STR_MART_COMMA + this.callback.hashCode(), true);
            J(response);
            return;
        }
        String deepThinkingText = response.getDeepThinkingText();
        if (!H.x0(deepThinkingText)) {
            deepThinkingText.length();
        }
        if (H.x0(deepThinkingText)) {
            g0(response);
            return;
        }
        C4148a.j(this.TAG, "deepThinkingMsg:" + deepThinkingText + "， " + hashCode() + Const.STR_MART_COMMA + this.callback.hashCode(), true);
        Iterator<Integer> it = new C5680i(0, deepThinkingText.length() - 1).iterator();
        while (it.hasNext()) {
            int iNextInt = ((Z8.M) it).nextInt();
            AgentResponse agentResponseClone = response.clone();
            agentResponseClone.H(String.valueOf(deepThinkingText.charAt(iNextInt)));
            agentResponseClone.F("");
            agentResponseClone.R(EReplyStatus.REPLYING);
            J(agentResponseClone);
        }
    }

    @Override // com.stepos.agentframework.chatcore.agents.AgentDispatcher.b
    public void m(String runId, String name, String resultJson) {
        kotlin.jvm.internal.p.i(runId, "runId");
        kotlin.jvm.internal.p.i(name, "name");
        kotlin.jvm.internal.p.i(resultJson, "resultJson");
        this.callback.m(runId, name, resultJson);
    }

    @Override // com.stepos.agentframework.chatcore.agents.AgentDispatcher.b
    public void n() {
        this.callback.n();
    }

    public /* synthetic */ FlowCallback(AgentDispatcher.b bVar, M m10, long j10, int i10, kotlin.jvm.internal.i iVar) {
        this(bVar, (i10 & 2) != 0 ? C1073o0.f6391a : m10, (i10 & 4) != 0 ? 20L : j10);
    }
}
