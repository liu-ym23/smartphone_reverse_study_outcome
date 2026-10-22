package com.stepos.agentframework.chatcore.agents;

import I4.ResultBean;
import Ua.C1060i;
import Ua.C1073o0;
import Ua.InterfaceC1083u;
import Ua.Y;
import Z8.C1172u;
import Z8.C1173v;
import Z8.Z;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.services.core.AMapException;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.stepos.agentframework.adapter.netcore.InquiryAnswerResult;
import com.stepos.agentframework.adapter.netcore.ToolContent;
import com.stepos.agentframework.adapter.netcore.ToolType;
import com.stepos.agentframework.chatcore.agents.AgentDispatcher;
import com.stepos.agentframework.chatcore.agents.u;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.agentframework.chatcore.session.AgentError;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import e9.InterfaceC4014c;
import h8.C4148a;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.AbstractC0913i;
import kotlin.C0917m;
import kotlin.C0918n;
import kotlin.Function2;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReferenceSource;
import kotlin.TaskBatchDeleteRequest;
import kotlin.TaskCancelRequest;
import kotlin.TaskDeleteRequest;
import kotlin.TaskInteractRequest;
import kotlin.TaskSyncRemoteRequest;
import kotlin.TranscriptAppendRequest;
import kotlin.TranscriptAppendResult;
import kotlin.VoteRequest;
import n4.AbstractC4939a;
import o4.C5004e;
import o4.InterfaceC5002c;
import p4.AgentRemoteChatMessage;
import t4.InterfaceC5507a;
import w4.C5732a;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001;B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\u001b\u0010\u001cJZ\u0010#\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b#\u0010$J8\u0010+\u001a\u00020\r2\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)H\u0096@¢\u0006\u0004\b+\u0010,R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010-R\u001a\u0010.\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b.\u0010-\u001a\u0004\b/\u00100R)\u00104\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020302018\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006<"}, d2 = {"Lcom/stepos/agentframework/chatcore/agents/RemoteClient;", "Lcom/stepos/agentframework/chatcore/agents/u;", "", "deviceId", "<init>", "(Ljava/lang/String;)V", "Lcom/stepos/agentframework/chatcore/agents/y;", "parameter", "Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;", "callback", "Lo4/c;", ExifInterface.LATITUDE_SOUTH, "(Lcom/stepos/agentframework/chatcore/agents/y;Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;)Lo4/c;", "LY8/t;", "Y", "(Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;)V", "toolCallId", "", "toolLikeStatus", "taskId", "H", "(Ljava/lang/String;ILjava/lang/String;)V", "close", "()V", "agentId", "secretKey", "Lw4/a;", "r", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "messageId", "sessionId", "likeStatus", DidiCardProvider.KEY_TRACE_ID, "questionType", "questionDesc", "n", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "fileInfo", "Lt4/a;", "listener", "x", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/file/FileInfo;Lt4/a;Le9/c;)Ljava/lang/Object;", "Ljava/lang/String;", "TAG", "X", "()Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "callbackCache", "Ljava/util/concurrent/ConcurrentHashMap;", "getCallbackCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", Const.INTENT_KEY_APIKEY, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RemoteClient implements u {
    private final String TAG;
    private final ConcurrentHashMap<AgentDispatcher.b, Set<Object>> callbackCache;
    private final String deviceId;
    private Gson gson;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/agentframework/chatcore/agents/RemoteClient$a;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "output", "Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Object;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.agents.RemoteClient$a, reason: from toString */
    public static final /* data */ class ToolOutput {
        private final Object output;

        /* renamed from: a, reason: from getter */
        public final Object getOutput() {
            return this.output;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ToolOutput) && kotlin.jvm.internal.p.d(this.output, ((ToolOutput) other).output);
        }

        public int hashCode() {
            return this.output.hashCode();
        }

        public String toString() {
            return "ToolOutput(output=" + this.output + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/agentframework/chatcore/agents/RemoteClient$b", "Lo4/e$a;", "LY8/t;", "cancel", "()V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements C5004e.a {
        final /* synthetic */ AgentDispatcher.b $callback;

        public b(AgentDispatcher.b bVar) {
            this.$callback = bVar;
        }

        @Override // o4.C5004e.a
        public void cancel() {
            RemoteClient.this.Y(this.$callback);
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/stepos/agentframework/chatcore/agents/RemoteClient$c", "Lcom/stepos/agentframework/adapter/netcore/h;", "LK6/n;", "chatRequestInfo", "LK6/m;", "chatReplyInfo", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LK6/n;LK6/m;)V", "", "code", "", "message", Const.INTENT_KEY_PKGNAME, "(LK6/n;Ljava/lang/Integer;Ljava/lang/String;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c implements com.stepos.agentframework.adapter.netcore.h {
        final /* synthetic */ AgentDispatcher.b $callback;
        final /* synthetic */ RemoteClient this$0;

        public c(AgentDispatcher.b bVar, RemoteClient remoteClient) {
            this.$callback = bVar;
            this.this$0 = remoteClient;
        }

        @Override // com.stepos.agentframework.adapter.netcore.h
        public /* bridge */ void a() {
            super.a();
        }

        @Override // com.stepos.agentframework.adapter.netcore.h
        public void b(C0918n chatRequestInfo, Integer code, String message) {
            kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
            C4148a.h(this.this$0.getTAG(), "Request onFailure: " + code + " - " + message, false, 4, null);
            if (code != null && code.intValue() == -1) {
                AgentDispatcher.b bVar = this.$callback;
                if (message == null || message.length() == 0) {
                    message = AMapException.AMAP_CLIENT_UNKNOWN_ERROR;
                }
                bVar.i(new AgentError(AgentError.ERROR_CODE_STREAM_CANCEL, message, null, 4, null));
            } else {
                AgentDispatcher.b bVar2 = this.$callback;
                int iIntValue = code != null ? code.intValue() : AgentError.ERROR_CODE_UNKNOWN;
                if (message == null) {
                    message = "";
                }
                bVar2.i(new AgentError(iIntValue, message, null, 4, null));
            }
            this.this$0.Y(this.$callback);
        }

        @Override // com.stepos.agentframework.adapter.netcore.h
        public /* bridge */ void c(C0918n c0918n, boolean z10, Integer num, String str) {
            super.c(c0918n, z10, num, str);
        }

        @Override // com.stepos.agentframework.adapter.netcore.h
        public /* bridge */ void d() {
            super.d();
        }

        @Override // com.stepos.agentframework.adapter.netcore.h
        public /* bridge */ void e(C0918n c0918n, String str, List<ReferenceSource> list) {
            super.e(c0918n, str, list);
        }

        @Override // com.stepos.agentframework.adapter.netcore.h
        public /* bridge */ void f(C0918n c0918n) {
            super.f(c0918n);
        }

        @Override // com.stepos.agentframework.adapter.netcore.h
        public void g(C0918n chatRequestInfo, C0917m chatReplyInfo) {
            kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
            kotlin.jvm.internal.p.i(chatReplyInfo, "chatReplyInfo");
            Integer event = chatReplyInfo.getEvent();
            if (event != null && event.intValue() == 0) {
                this.$callback.l(ExtKt.i(ExtKt.h(ExtKt.u(chatReplyInfo, null, 1, null), chatReplyInfo), chatReplyInfo));
            } else if (event != null && event.intValue() == 2) {
                this.$callback.l(ExtKt.u(chatReplyInfo, null, 1, null));
            }
        }

        @Override // com.stepos.agentframework.adapter.netcore.h
        public /* bridge */ void h(C0918n c0918n, String str, String str2, String str3) {
            super.h(c0918n, str, str2, str3);
        }

        @Override // com.stepos.agentframework.adapter.netcore.h
        public /* bridge */ void i(Object obj) {
            super.i(obj);
        }

        @Override // com.stepos.agentframework.adapter.netcore.h
        public /* bridge */ void j(C0918n c0918n) {
            super.j(c0918n);
        }
    }

    public RemoteClient(String deviceId) {
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        this.deviceId = deviceId;
        this.TAG = " [RemoteClient] ";
        this.callbackCache = new ConcurrentHashMap<>();
        this.gson = new Gson();
    }

    public static final Y8.t Z(RemoteClient remoteClient, InterfaceC1083u interfaceC1083u, boolean z10, FileInfo fileInfo, InterfaceC5507a interfaceC5507a, AbstractC4939a status) {
        kotlin.jvm.internal.p.i(status, "status");
        if (status instanceof AbstractC4939a.Progress) {
            Function2.b(new RemoteClient$uploadFile$2$1(remoteClient, status, interfaceC5507a, fileInfo, null));
        } else if (status instanceof AbstractC4939a.Failed) {
            AbstractC4939a.Failed failed = (AbstractC4939a.Failed) status;
            C4148a.h(remoteClient.TAG, "Upload Failed: " + failed.getCode() + " - " + failed.getMessage(), false, 4, null);
            Function2.b(new RemoteClient$uploadFile$2$2(status, interfaceC5507a, fileInfo, null));
            interfaceC1083u.complete(Boolean.FALSE);
        } else {
            if (!(status instanceof AbstractC4939a.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            if (z10) {
                AbstractC4939a.Success success = (AbstractC4939a.Success) status;
                C4148a.d(remoteClient.TAG, "upload success fileId: " + success.getFileId(), false, 4, null);
                fileInfo.setFileId(success.getFileId());
            } else {
                AbstractC4939a.Success success2 = (AbstractC4939a.Success) status;
                C4148a.d(remoteClient.TAG, "upload success fileUrl: " + success2.getFileUrl(), false, 4, null);
                String fileUrl = success2.getFileUrl();
                if (fileUrl == null) {
                    fileUrl = "";
                }
                fileInfo.setFileUrl(fileUrl);
                if (success2.getFileId().length() > 0) {
                    fileInfo.setFileId(success2.getFileId());
                }
            }
            Function2.b(new RemoteClient$uploadFile$2$3(interfaceC5507a, fileInfo, null));
            interfaceC1083u.complete(Boolean.TRUE);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t a0(RemoteClient remoteClient, Throwable th) {
        if (th != null) {
            C4148a.k(remoteClient.TAG, "uploadFile failed: " + th, false, 4, null);
        }
        return Y8.t.f7040a;
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object B(Context context, String str, String str2, String str3, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.B(context, str, str2, str3, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object G(String str, String str2, String str3, InterfaceC4014c<? super String> interfaceC4014c) {
        return super.G(str, str2, str3, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public void H(String toolCallId, int toolLikeStatus, String taskId) {
        int i10;
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        C4148a.k(this.TAG, "📊 [ToolLike-2] RemoteClient收到: toolCallId=" + toolCallId + ", toolLikeStatus=" + toolLikeStatus + ", taskId(来自sessionId)=" + taskId, false, 4, null);
        if (toolLikeStatus != 0) {
            i10 = 1;
            if (toolLikeStatus != 1) {
                i10 = 2;
                if (toolLikeStatus != 2) {
                    C4148a.u(this.TAG, "Invalid toolLikeStatus: " + toolLikeStatus + ", defaulting to cancel", false, 4, null);
                    i10 = 3;
                }
            }
        } else {
            i10 = 3;
        }
        int i11 = i10;
        VoteRequest voteRequest = new VoteRequest(null, taskId, toolCallId, i11, null, null, null, null, 240, null);
        C4148a.k(this.TAG, "📊 [ToolLike-2] 构建VoteRequest: msg_id=null, task_id=" + taskId + ", tool_call_id=" + toolCallId + ", vote_type=" + i11, false, 4, null);
        C1060i.d(C1073o0.f6391a, Y.b(), null, new RemoteClient$toolLikeFeedback$1(voteRequest, this, toolCallId, i11, taskId, null), 2, null);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object I(String str, String str2, String str3, String str4, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return super.I(str, str2, str3, str4, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object K(String str, String str2, String str3, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.K(str, str2, str3, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object N(String str, String str2, String str3, InterfaceC4014c<? super List<AgentRemoteChatMessage>> interfaceC4014c) {
        return super.N(str, str2, str3, interfaceC4014c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.stepos.agentframework.chatcore.agents.u
    public InterfaceC5002c S(RequestParameter parameter, AgentDispatcher.b callback) {
        Class<ToolOutput> cls;
        boolean z10;
        Object toolContent;
        Object objFromJson;
        ToolOutput toolOutput;
        Object objFromJson2;
        Class<ToolOutput> cls2 = ToolOutput.class;
        kotlin.jvm.internal.p.i(parameter, "parameter");
        kotlin.jvm.internal.p.i(callback, "callback");
        C5004e c5004e = new C5004e();
        c5004e.b(new b(callback));
        c cVar = new c(callback, this);
        ConcurrentHashMap<AgentDispatcher.b, Set<Object>> concurrentHashMap = this.callbackCache;
        Set<Object> linkedHashSet = concurrentHashMap.get(callback);
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet<>();
        }
        concurrentHashMap.put(callback, Z.p(linkedHashSet, cVar));
        int i10 = 0;
        Object obj = null;
        C4148a.k(this.TAG, "parameter.originInfo: agentId=" + parameter.getAgentId() + " sessionId=" + parameter.getSessionId() + " contentParts=" + parameter.d().size() + " isToolResult=" + parameter.getIsToolResult(), false, 4, null);
        C0918n c0918nA = ExtKt.A(parameter);
        String str = this.TAG;
        List<AbstractC0913i> listJ = c0918nA.j();
        C4148a.k(str, "parameter.chatRequestInfo: contentParts=" + (listJ != null ? listJ.size() : 0), false, 4, null);
        C4148a.k(this.TAG, "parameter.isToolResult:" + parameter.getIsToolResult(), false, 4, null);
        if (parameter.getIsToolResult()) {
            HashMap<String, Object> map = new HashMap<>();
            C4148a.k(this.TAG, "parameter.isToolResult:" + parameter.n().size(), false, 4, null);
            for (Map.Entry<String, ResultBean> entry : parameter.n().entrySet()) {
                String key = entry.getKey();
                ResultBean value = entry.getValue();
                String str2 = this.TAG;
                String resultRspContent = value.getResultRspContent();
                int length = resultRspContent != null ? resultRspContent.length() : i10;
                C4148a.k(str2, "resultRspContentLen:" + length + ",sucess:" + value.getSuccess(), false, 4, obj);
                if (value.getSuccess()) {
                    String resultRspContent2 = value.getResultRspContent();
                    if (resultRspContent2 != 0) {
                        try {
                            objFromJson = kotlin.jvm.internal.p.d(cls2, String.class) ? (ToolOutput) resultRspContent2 : ExtKt.l().fromJson(resultRspContent2, (Class) cls2);
                            cls = cls2;
                        } catch (Exception e10) {
                            cls = cls2;
                            C4148a.k(ExtKt.TAG, "toAny class:" + e10 + ",valueLen=" + resultRspContent2.length(), false, 4, null);
                            objFromJson = null;
                        }
                        toolOutput = (ToolOutput) objFromJson;
                    } else {
                        cls = cls2;
                        toolOutput = null;
                    }
                    toolContent = toolOutput != null ? toolOutput.getOutput() : null;
                    if (toolContent instanceof String) {
                        if (((CharSequence) toolContent).length() > 0) {
                            String str3 = (String) toolContent;
                            try {
                                objFromJson2 = kotlin.jvm.internal.p.d(ToolContent.class, String.class) ? (ToolContent) str3 : ExtKt.l().fromJson(str3, ToolContent.class);
                            } catch (Exception e11) {
                                C4148a.k(ExtKt.TAG, "toAny class:" + e11 + ",valueLen=" + str3.length(), false, 4, null);
                                objFromJson2 = null;
                            }
                            toolContent = (ToolContent) objFromJson2;
                        } else {
                            toolContent = new ToolContent(C1173v.m(), false);
                        }
                    }
                    z10 = true;
                } else {
                    cls = cls2;
                    z10 = true;
                    toolContent = new ToolContent(C1172u.e(new ToolType("text", value.getMessage())), true);
                }
                C4148a.k(this.TAG, "toolContent present=" + (toolContent != null ? z10 : false), false, 4, null);
                if (toolContent != null) {
                    map.put(key, this.gson.toJson(toolContent));
                }
                i10 = 0;
                cls2 = cls;
                obj = null;
            }
            c0918nA.H(map);
        }
        C1060i.d(C1073o0.f6391a, Y.b(), null, new RemoteClient$send$2(c0918nA, cVar, null), 2, null);
        return c5004e;
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object U(String str, String str2, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return super.U(str, str2, interfaceC4014c);
    }

    /* renamed from: X, reason: from getter */
    public final String getTAG() {
        return this.TAG;
    }

    public void Y(AgentDispatcher.b callback) {
        kotlin.jvm.internal.p.i(callback, "callback");
        this.callbackCache.remove(callback);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object a(TaskInteractRequest taskInteractRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.a(taskInteractRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object b(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return super.b(str, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object c(String str, String str2, String str3, String str4, String str5, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.c(str, str2, str3, str4, str5, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public void close() {
        this.callbackCache.clear();
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object d(TranscriptAppendRequest transcriptAppendRequest, InterfaceC4014c<? super TranscriptAppendResult> interfaceC4014c) {
        return super.d(transcriptAppendRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object e(TaskCancelRequest taskCancelRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.e(taskCancelRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object f(TaskDeleteRequest taskDeleteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.f(taskDeleteRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object g(TaskBatchDeleteRequest taskBatchDeleteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.g(taskBatchDeleteRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ boolean h() {
        return super.h();
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object i(InterfaceC4014c<? super String> interfaceC4014c) {
        return super.i(interfaceC4014c);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object j(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return super.j(str, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object k(String str, String str2, List<String> list, InterfaceC4014c<? super InquiryAnswerResult> interfaceC4014c) {
        return super.k(str, str2, list, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object l(TaskSyncRemoteRequest taskSyncRemoteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.l(taskSyncRemoteRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object m(InterfaceC4014c<? super String> interfaceC4014c) {
        return super.m(interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object n(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, int r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, e9.InterfaceC4014c<? super Y8.t> r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.RemoteClient.n(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ void q(u.a aVar) {
        super.q(aVar);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public Object r(String str, String str2, InterfaceC4014c<? super C5732a> interfaceC4014c) {
        return new C5732a(str, "RemoteAgent", "This is a remote agent", "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimage109.360doc.com%2FDownloadImg%2F2023%2F12%2F0313%2F276318726_4_20231203011211178&refer=http%3A%2F%2Fimage109.360doc.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1764395832&t=671331058f3d9b8f299ee44cc7217220", "This is a prologue", null, 32, null);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object s(String str, String str2, String str3, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return super.s(str, str2, str3, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ InterfaceC5002c w(String str, String str2, AgentDispatcher.b bVar) {
        return super.w(str, str2, bVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0146, code lost:
    
        if (r0 == r9) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object x(android.content.Context r18, java.lang.String r19, java.lang.String r20, final com.stepos.agentframework.chatcore.file.FileInfo r21, final t4.InterfaceC5507a r22, e9.InterfaceC4014c<? super Y8.t> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.RemoteClient.x(android.content.Context, java.lang.String, java.lang.String, com.stepos.agentframework.chatcore.file.FileInfo, t4.a, e9.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ void y(u.a aVar) {
        super.y(aVar);
    }
}
