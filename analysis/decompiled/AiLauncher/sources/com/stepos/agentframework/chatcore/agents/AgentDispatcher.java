package com.stepos.agentframework.chatcore.agents;

import Z8.C1173v;
import Z8.C1174w;
import Z8.Q;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.agents.u;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.session.AgentError;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatcore.session.R0;
import com.stepos.agentframework.chatcore.session.SessionConfig;
import com.stepos.agentframework.chatcore.session.W;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.ReferenceSource;
import kotlin.Result;
import o4.InterfaceC5002c;
import s4.C5442c;
import t4.InterfaceC5507a;
import u4.AgentModeration;
import u4.AgentResponse;
import u4.AgentTask;
import u4.AgentTaskComplete;
import u4.AgentTaskError;
import u4.AgentTaskPlan;
import w4.C5732a;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003UVWB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\r\u001a\u00060\fR\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0012\u001a\u00060\fR\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u0018J8\u0010!\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020 H\u0086@¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0016¢\u0006\u0004\b#\u0010$J\"\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fH\u0086@¢\u0006\u0004\b&\u0010'JH\u0010/\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000fH\u0086@¢\u0006\u0004\b/\u00100J(\u00103\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u00020*2\u0006\u0010,\u001a\u00020\u000fH\u0086@¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\u00162\u0006\u00106\u001a\u000205H\u0002¢\u0006\u0004\b7\u00108J3\u0010>\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010=0<2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109H\u0002¢\u0006\u0004\b>\u0010?R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010ER\u0014\u0010F\u001a\u00020\u000f8\u0002X\u0082D¢\u0006\u0006\n\u0004\bF\u0010GR\u0017\u0010I\u001a\u00020H8\u0006¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR8\u0010P\u001a&\u0012\f\u0012\n N*\u0004\u0018\u00010\u00140\u0014 N*\u0012\u0012\f\u0012\n N*\u0004\u0018\u00010\u00140\u0014\u0018\u00010O0M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010S\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010T¨\u0006X"}, d2 = {"Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher;", "", "Lcom/stepos/agentframework/chatcore/session/SessionConfig;", "config", "Lcom/stepos/agentframework/chatcore/agents/m;", "clientFactory", "<init>", "(Lcom/stepos/agentframework/chatcore/session/SessionConfig;Lcom/stepos/agentframework/chatcore/agents/m;)V", "Lcom/stepos/agentframework/chatcore/agents/y;", "parameter", "Lcom/stepos/agentframework/chatcore/session/W;", "callback", "Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$RequestWrapper;", "o", "(Lcom/stepos/agentframework/chatcore/agents/y;Lcom/stepos/agentframework/chatcore/session/W;)Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$RequestWrapper;", "", "sessionId", "outboundId", "e", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/W;)Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$RequestWrapper;", "Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$a;", "listener", "LY8/t;", Const.INTENT_KEY_UMID, "(Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$a;)V", "n", "Landroid/content/Context;", "context", "agentId", "secretKey", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "fileInfo", "Lt4/a;", "q", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/file/FileInfo;Lt4/a;Le9/c;)Ljava/lang/Object;", "m", "()V", "Lw4/a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", DidiCardProvider.KEY_TRACE_ID, "messageId", "", "likeStatus", "taskId", "questionType", "questionDesc", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "toolCallId", "toolLikeStatus", "p", "(Ljava/lang/String;ILjava/lang/String;Le9/c;)Ljava/lang/Object;", "Lu4/d;", UxipConstants.f30685x, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lu4/d;)V", "", "Lcom/stepos/agentframework/chatcore/intent/e;", "toolList", "", "", "f", "(Ljava/util/List;)Ljava/util/List;", "Lcom/stepos/agentframework/chatcore/session/SessionConfig;", "l", "()Lcom/stepos/agentframework/chatcore/session/SessionConfig;", "setConfig", "(Lcom/stepos/agentframework/chatcore/session/SessionConfig;)V", "Lcom/stepos/agentframework/chatcore/agents/m;", "TAG", "Ljava/lang/String;", "Lcom/stepos/agentframework/chatcore/agents/u;", "client", "Lcom/stepos/agentframework/chatcore/agents/u;", "k", "()Lcom/stepos/agentframework/chatcore/agents/u;", "", "kotlin.jvm.PlatformType", "", "globalTaskListeners", "Ljava/util/Set;", "Lcom/stepos/agentframework/chatcore/agents/u$a;", "clientTaskListener", "Lcom/stepos/agentframework/chatcore/agents/u$a;", Const.INTENT_KEY_APIKEY, "RequestWrapper", Const.INTENT_KEY_PKGNAME, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentDispatcher {
    private final String TAG;
    private final u client;
    private final m clientFactory;
    private final u.a clientTaskListener;
    private SessionConfig config;
    private final Set<a> globalTaskListeners;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R*\u0010*\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u00068"}, d2 = {"Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$RequestWrapper;", "", "<init>", "(Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher;)V", "Lcom/stepos/agentframework/chatcore/agents/y;", "parameter", "Lcom/stepos/agentframework/chatcore/session/W;", "callback", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/agentframework/chatcore/agents/y;Lcom/stepos/agentframework/chatcore/session/W;)V", "", "sessionId", "outboundId", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/W;)V", "agentId", "Lu4/d;", UxipConstants.f30685x, "e", "(Lcom/stepos/agentframework/chatcore/agents/y;Ljava/lang/String;Lu4/d;Lcom/stepos/agentframework/chatcore/session/W;)V", "reason", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", Const.INTENT_KEY_UMID, "()V", "Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;", "flowCallBack", "Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;", "getFlowCallBack", "()Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;", "setFlowCallBack", "(Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;)V", "Lo4/c;", "request", "Lo4/c;", "f", "()Lo4/c;", "setRequest", "(Lo4/c;)V", "", "Lcom/stepos/agentframework/chatcore/intent/e;", "tools", "Ljava/util/List;", "getTools", "()Ljava/util/List;", "setTools", "(Ljava/util/List;)V", "", "isCancelled", "Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", "setCancelled", "(Z)V", "DispatchCallback", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class RequestWrapper {
        private b flowCallBack;
        private boolean isCancelled;
        private InterfaceC5002c request;
        private List<AgentTool> tools;

        @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u001bJ%\u0010 \u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016¢\u0006\u0004\b \u0010!J'\u0010$\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010(R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00063"}, d2 = {"Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$RequestWrapper$DispatchCallback;", "Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;", "Lcom/stepos/agentframework/chatcore/agents/y;", "parameter", "", "agentId", "Lcom/stepos/agentframework/chatcore/session/W;", "callback", "<init>", "(Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$RequestWrapper;Lcom/stepos/agentframework/chatcore/agents/y;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/W;)V", "Lu4/d;", UxipConstants.f30685x, "LY8/t;", "l", "(Lu4/d;)V", "Lcom/stepos/agentframework/chatcore/session/AgentError;", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/agentframework/chatcore/session/AgentError;)V", "", "success", "", "code", "message", Const.INTENT_KEY_PKGNAME, "(ZLjava/lang/Integer;Ljava/lang/String;)V", "n", "()V", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, "", "LK6/A;", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/util/List;)V", "name", "resultJson", "m", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/agentframework/chatcore/agents/y;", Const.INTENT_KEY_UMID, "()Lcom/stepos/agentframework/chatcore/agents/y;", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "setAgentId", "(Ljava/lang/String;)V", "Lcom/stepos/agentframework/chatcore/session/W;", "c", "()Lcom/stepos/agentframework/chatcore/session/W;", "setCallback", "(Lcom/stepos/agentframework/chatcore/session/W;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public final class DispatchCallback implements b {
            private String agentId;
            private W callback;
            private final RequestParameter parameter;
            final /* synthetic */ RequestWrapper this$0;

            public DispatchCallback(RequestWrapper requestWrapper, RequestParameter parameter, String agentId, W callback) {
                kotlin.jvm.internal.p.i(parameter, "parameter");
                kotlin.jvm.internal.p.i(agentId, "agentId");
                kotlin.jvm.internal.p.i(callback, "callback");
                this.this$0 = requestWrapper;
                this.parameter = parameter;
                this.agentId = agentId;
                this.callback = callback;
            }

            /* renamed from: a, reason: from getter */
            public final String getAgentId() {
                return this.agentId;
            }

            @Override // com.stepos.agentframework.chatcore.agents.AgentDispatcher.b
            public void b(boolean success, Integer code, String message) {
                if (this.this$0.getIsCancelled()) {
                    return;
                }
                Function2.b(new AgentDispatcher$RequestWrapper$DispatchCallback$onSendAck$1(this, success, code, message, null));
            }

            /* renamed from: c, reason: from getter */
            public final W getCallback() {
                return this.callback;
            }

            /* renamed from: d, reason: from getter */
            public final RequestParameter getParameter() {
                return this.parameter;
            }

            @Override // com.stepos.agentframework.chatcore.agents.AgentDispatcher.b
            public void e() {
                if (this.this$0.getIsCancelled()) {
                    return;
                }
                Function2.b(new AgentDispatcher$RequestWrapper$DispatchCallback$onNetworkReconnected$1(this, null));
            }

            @Override // com.stepos.agentframework.chatcore.agents.AgentDispatcher.b
            public void g(String runId, List<ReferenceSource> sources) {
                kotlin.jvm.internal.p.i(runId, "runId");
                kotlin.jvm.internal.p.i(sources, "sources");
                if (this.this$0.getIsCancelled()) {
                    return;
                }
                Function2.b(new AgentDispatcher$RequestWrapper$DispatchCallback$onReference$1(this, runId, sources, null));
            }

            @Override // com.stepos.agentframework.chatcore.agents.AgentDispatcher.b
            public void i(AgentError e10) {
                kotlin.jvm.internal.p.i(e10, "e");
                Function2.b(new AgentDispatcher$RequestWrapper$DispatchCallback$onFailed$1(this, e10, null));
            }

            @Override // com.stepos.agentframework.chatcore.agents.AgentDispatcher.b
            public void l(AgentResponse response) {
                kotlin.jvm.internal.p.i(response, "response");
                Function2.b(new AgentDispatcher$RequestWrapper$DispatchCallback$onResponse$1(this.this$0, this, response, null));
            }

            @Override // com.stepos.agentframework.chatcore.agents.AgentDispatcher.b
            public void m(String runId, String name, String resultJson) {
                kotlin.jvm.internal.p.i(runId, "runId");
                kotlin.jvm.internal.p.i(name, "name");
                kotlin.jvm.internal.p.i(resultJson, "resultJson");
                if (this.this$0.getIsCancelled()) {
                    return;
                }
                Function2.b(new AgentDispatcher$RequestWrapper$DispatchCallback$onCard$1(this, runId, name, resultJson, null));
            }

            @Override // com.stepos.agentframework.chatcore.agents.AgentDispatcher.b
            public void n() {
                if (this.this$0.getIsCancelled()) {
                    return;
                }
                Function2.b(new AgentDispatcher$RequestWrapper$DispatchCallback$onNetworkDisconnected$1(this, null));
            }
        }

        public RequestWrapper() {
        }

        public static /* synthetic */ void c(RequestWrapper requestWrapper, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = "user.abort";
            }
            requestWrapper.b(str);
        }

        public final void a(String sessionId, String outboundId, W callback) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            kotlin.jvm.internal.p.i(outboundId, "outboundId");
            kotlin.jvm.internal.p.i(callback, "callback");
            RequestParameter yVar = new RequestParameter();
            AgentDispatcher agentDispatcher = AgentDispatcher.this;
            yVar.A(sessionId);
            yVar.r(agentDispatcher.getConfig().getAgentId());
            yVar.B(true);
            if (this.flowCallBack == null) {
                this.flowCallBack = new DispatchCallback(this, yVar, yVar.getAgentId(), callback);
            }
            u client = AgentDispatcher.this.getClient();
            b bVar = this.flowCallBack;
            kotlin.jvm.internal.p.f(bVar);
            this.request = client.w(sessionId, outboundId, bVar);
        }

        public final void b(String reason) {
            kotlin.jvm.internal.p.i(reason, "reason");
            C4148a.k(AgentDispatcher.this.TAG, "cancel reason=" + reason, false, 4, null);
            this.isCancelled = true;
            C5442c.l(C5442c.INSTANCE, null, "request", Q.f(Y8.j.a("reason", reason)), null, "AgentDispatcher.RequestWrapper.cancel", 8, null);
            InterfaceC5002c interfaceC5002c = this.request;
            if (interfaceC5002c != null) {
                interfaceC5002c.a(reason);
            }
            d();
        }

        public final void d() {
            b bVar = this.flowCallBack;
            FlowCallback flowCallback = bVar instanceof FlowCallback ? (FlowCallback) bVar : null;
            if (flowCallback != null) {
                flowCallback.close();
            }
        }

        public final void e(RequestParameter parameter, String agentId, AgentResponse response, W callback) {
            kotlin.jvm.internal.p.i(parameter, "parameter");
            kotlin.jvm.internal.p.i(agentId, "agentId");
            kotlin.jvm.internal.p.i(response, "response");
            kotlin.jvm.internal.p.i(callback, "callback");
            String strO = parameter.getTraceId();
            if (strO.length() == 0) {
                strO = response.getSessionId();
            }
            String str = strO;
            C5442c c5442c = C5442c.INSTANCE;
            C5442c.l(c5442c, str, UxipConstants.f30685x, response, null, "AgentDispatcher.dispatchMessage", 8, null);
            C4148a.c(AgentDispatcher.this.TAG, "RequestWrapper onResponse: " + response, true);
            if (this.isCancelled) {
                return;
            }
            if (response.getSessionId().length() > 0) {
                callback.onSessionCreated(response.getSessionId());
            }
            if (response.getType() == AgentMessageType.TASK_PLAN) {
                if (response.getTaskPlan() != null) {
                    AgentTaskPlan taskPlan = response.getTaskPlan();
                    kotlin.jvm.internal.p.f(taskPlan);
                    taskPlan.b(response.getSessionId());
                    AgentTaskPlan taskPlan2 = response.getTaskPlan();
                    kotlin.jvm.internal.p.f(taskPlan2);
                    callback.a(taskPlan2);
                    return;
                }
                return;
            }
            if (response.getType() == AgentMessageType.TASK_UPDATE) {
                if (response.getTaskUpdate() != null) {
                    AgentTask taskUpdate = response.getTaskUpdate();
                    kotlin.jvm.internal.p.f(taskUpdate);
                    callback.f(taskUpdate);
                    return;
                }
                return;
            }
            if (response.getType() == AgentMessageType.WORK_ERROR) {
                if (response.getWorkError() != null) {
                    AgentTaskError workError = response.getWorkError();
                    kotlin.jvm.internal.p.f(workError);
                    callback.i(workError);
                    return;
                }
                return;
            }
            if (response.getType() == AgentMessageType.WORK_COMPLETE) {
                if (response.getWorkComplete() != null) {
                    AgentTaskComplete workComplete = response.getWorkComplete();
                    kotlin.jvm.internal.p.f(workComplete);
                    callback.h(workComplete);
                    return;
                }
                return;
            }
            if (response.getType() == AgentMessageType.MODERATION) {
                AgentModeration moderation = response.getModeration();
                if (moderation != null) {
                    C5442c.l(c5442c, str, "moderation", moderation, null, "AgentDispatcher.dispatchMessage", 8, null);
                    callback.d(moderation);
                    return;
                }
                return;
            }
            if (response.getType() == AgentMessageType.TOOL_SHOW) {
                this.tools = p.d(this.tools, response.y());
                C5442c.l(c5442c, str, "AgentDispatcher", kotlin.collections.a.m(Y8.j.a("type", "TOOL_SHOW"), Y8.j.a("messageId", response.getMessageId()), Y8.j.a("sessionId", response.getSessionId()), Y8.j.a("status", response.getStatus().name()), Y8.j.a("tools", AgentDispatcher.this.f(response.y()))), null, "AgentDispatcher.dispatchMessage", 8, null);
                List<AgentTool> list = this.tools;
                if (list != null && !list.isEmpty()) {
                    List<AgentTool> list2 = this.tools;
                    kotlin.jvm.internal.p.f(list2);
                    callback.k(list2);
                }
                if (response.getStatus() == EReplyStatus.COMPLETED || response.getStatus() == EReplyStatus.ERROR || response.getStatus() == EReplyStatus.CANCELED) {
                    callback.l(response);
                    return;
                }
                return;
            }
            if (response.getType() != AgentMessageType.TOOL_RESULT) {
                if (response.getType() != AgentMessageType.TOOL) {
                    if (response.getMessageId().length() != 0) {
                        callback.l(response);
                        return;
                    } else {
                        C4148a.h(AgentDispatcher.this.TAG, "onResponse messageId is empty", false, 4, null);
                        callback.j(response);
                        return;
                    }
                }
                return;
            }
            C5442c.l(c5442c, str, "receive", AgentDispatcher.this.f(response.y()), null, "AgentDispatcher.dispatchMessage", 8, null);
            List<AgentTool> list3 = this.tools;
            if (list3 != null && !list3.isEmpty()) {
                List<AgentTool> list4 = this.tools;
                kotlin.jvm.internal.p.f(list4);
                List<AgentTool> listY = response.y();
                if (listY == null) {
                    listY = C1173v.m();
                }
                if (p.b(list4, listY)) {
                    callback.k(list4);
                }
            }
            List<AgentTool> listY2 = response.y();
            if ((listY2 == null || listY2.isEmpty()) && (response.getStatus() == EReplyStatus.COMPLETED || response.getStatus() == EReplyStatus.ERROR || response.getStatus() == EReplyStatus.CANCELED)) {
                this.tools = null;
            }
            if (response.getStatus() == EReplyStatus.COMPLETED || response.getStatus() == EReplyStatus.ERROR || response.getStatus() == EReplyStatus.CANCELED) {
                callback.l(response);
            }
        }

        /* renamed from: f, reason: from getter */
        public final InterfaceC5002c getRequest() {
            return this.request;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getIsCancelled() {
            return this.isCancelled;
        }

        public final void h(RequestParameter parameter, W callback) {
            b dispatchCallback;
            kotlin.jvm.internal.p.i(parameter, "parameter");
            kotlin.jvm.internal.p.i(callback, "callback");
            if (this.flowCallBack == null) {
                if (parameter.getStream()) {
                    dispatchCallback = new FlowCallback(new DispatchCallback(this, parameter, parameter.getAgentId(), callback), null, 0L, 6, null);
                } else {
                    dispatchCallback = new DispatchCallback(this, parameter, parameter.getAgentId(), callback);
                }
                this.flowCallBack = dispatchCallback;
            }
            u client = AgentDispatcher.this.getClient();
            b bVar = this.flowCallBack;
            kotlin.jvm.internal.p.f(bVar);
            this.request = client.S(parameter, bVar);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$a;", "", "Lu4/d;", UxipConstants.f30685x, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lu4/d;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        void a(AgentResponse response);
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u001e¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;", "", "Lu4/d;", UxipConstants.f30685x, "LY8/t;", "l", "(Lu4/d;)V", "Lcom/stepos/agentframework/chatcore/session/AgentError;", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/agentframework/chatcore/session/AgentError;)V", "", "success", "", "code", "", "message", Const.INTENT_KEY_PKGNAME, "(ZLjava/lang/Integer;Ljava/lang/String;)V", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, "", "LK6/A;", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/util/List;)V", "name", "resultJson", "m", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "n", "()V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface b {
        default void b(boolean success, Integer code, String message) {
        }

        default void e() {
        }

        default void g(String runId, List<ReferenceSource> sources) {
            kotlin.jvm.internal.p.i(runId, "runId");
            kotlin.jvm.internal.p.i(sources, "sources");
        }

        void i(AgentError e10);

        void l(AgentResponse response);

        default void m(String runId, String name, String resultJson) {
            kotlin.jvm.internal.p.i(runId, "runId");
            kotlin.jvm.internal.p.i(name, "name");
            kotlin.jvm.internal.p.i(resultJson, "resultJson");
        }

        default void n() {
        }
    }

    public AgentDispatcher(SessionConfig config, m clientFactory) {
        kotlin.jvm.internal.p.i(config, "config");
        kotlin.jvm.internal.p.i(clientFactory, "clientFactory");
        this.config = config;
        this.clientFactory = clientFactory;
        this.TAG = "AgentDispatcher";
        u uVarA = clientFactory.a(config);
        this.client = uVarA;
        this.globalTaskListeners = Collections.newSetFromMap(new ConcurrentHashMap());
        u.a aVar = new u.a() { // from class: com.stepos.agentframework.chatcore.agents.n
            @Override // com.stepos.agentframework.chatcore.agents.u.a
            public final void a(AgentResponse agentResponse) {
                AgentDispatcher.g(this.f22404a, agentResponse);
            }
        };
        this.clientTaskListener = aVar;
        if (R0.a()) {
            C4148a.k("AgentDispatcher", "skip client GlobalTaskListener: TaskIngress enabled", false, 4, null);
        } else {
            uVarA.y(aVar);
        }
    }

    public static final void g(AgentDispatcher agentDispatcher, AgentResponse response) {
        kotlin.jvm.internal.p.i(response, "response");
        agentDispatcher.h(response);
    }

    public final void d(a listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.globalTaskListeners.add(listener);
    }

    public final RequestWrapper e(String sessionId, String outboundId, W callback) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(outboundId, "outboundId");
        kotlin.jvm.internal.p.i(callback, "callback");
        RequestWrapper requestWrapper = new RequestWrapper();
        requestWrapper.a(sessionId, outboundId, callback);
        return requestWrapper;
    }

    public final List<Map<String, Object>> f(List<AgentTool> toolList) {
        List<AgentTool> list = toolList;
        if (list == null || list.isEmpty()) {
            return C1173v.m();
        }
        List<AgentTool> list2 = toolList;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        for (AgentTool agentTool : list2) {
            arrayList.add(kotlin.collections.a.m(Y8.j.a("toolCallId", agentTool.getToolCallId()), Y8.j.a("toolId", agentTool.getToolId()), Y8.j.a("name", agentTool.getName()), Y8.j.a("apiName", agentTool.getApiName()), Y8.j.a("status", agentTool.getIsFinished() ? "FINISHED" : "RUNNING"), Y8.j.a("parameter", agentTool.getParameter()), Y8.j.a("result", agentTool.getResult())));
        }
        return arrayList;
    }

    public final void h(AgentResponse response) {
        Object objB;
        if (response.getType() != AgentMessageType.TASK || response.getTaskEvent() == null) {
            return;
        }
        Set<a> globalTaskListeners = this.globalTaskListeners;
        kotlin.jvm.internal.p.h(globalTaskListeners, "globalTaskListeners");
        for (a aVar : globalTaskListeners) {
            try {
                Result.Companion companion = Result.INSTANCE;
                aVar.a(response.clone());
                objB = Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.u(this.TAG, "global task listener failed: " + thE.getMessage(), false, 4, null);
            }
        }
    }

    public final Object i(String str, String str2, String str3, int i10, String str4, String str5, String str6, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objN = this.client.n(this.config.getAgentId(), str2, str3, this.config.getSecretKey(), i10, str4, str, str5, str6, interfaceC4014c);
        return objN == C4063a.g() ? objN : Y8.t.f7040a;
    }

    public final Object j(String str, String str2, InterfaceC4014c<? super C5732a> interfaceC4014c) {
        return this.client.r(str, str2, interfaceC4014c);
    }

    /* renamed from: k, reason: from getter */
    public final u getClient() {
        return this.client;
    }

    /* renamed from: l, reason: from getter */
    public final SessionConfig getConfig() {
        return this.config;
    }

    public final void m() {
        this.client.q(this.clientTaskListener);
        this.globalTaskListeners.clear();
        this.client.close();
    }

    public final void n(a listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.globalTaskListeners.remove(listener);
    }

    public final RequestWrapper o(RequestParameter parameter, W callback) {
        kotlin.jvm.internal.p.i(parameter, "parameter");
        kotlin.jvm.internal.p.i(callback, "callback");
        RequestWrapper requestWrapper = new RequestWrapper();
        requestWrapper.h(parameter, callback);
        return requestWrapper;
    }

    public final Object p(String str, int i10, String str2, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        this.client.H(str, i10, str2);
        return Y8.t.f7040a;
    }

    public final Object q(Context context, String str, String str2, FileInfo fileInfo, InterfaceC5507a interfaceC5507a, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objX = this.client.x(context, str, str2, fileInfo, interfaceC5507a, interfaceC4014c);
        return objX == C4063a.g() ? objX : Y8.t.f7040a;
    }

    public /* synthetic */ AgentDispatcher(SessionConfig sessionConfig, m mVar, int i10, kotlin.jvm.internal.i iVar) {
        this(sessionConfig, (i10 & 2) != 0 ? new t() : mVar);
    }
}
