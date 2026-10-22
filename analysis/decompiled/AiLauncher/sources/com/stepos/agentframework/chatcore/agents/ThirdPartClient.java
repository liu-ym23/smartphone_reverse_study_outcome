package com.stepos.agentframework.chatcore.agents;

import Ua.C1060i;
import Ua.C1073o0;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.amap.api.services.core.AMapException;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.ApiManager;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.adapter.netcore.InquiryAnswerResult;
import com.stepos.agentframework.chatcore.agents.AgentDispatcher;
import com.stepos.agentframework.chatcore.agents.u;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.agentframework.chatcore.session.AgentError;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import e9.InterfaceC4014c;
import f9.C4063a;
import h8.C4148a;
import io.ktor.sse.ServerSentEventKt;
import java.io.File;
import java.util.List;
import kotlin.AbstractC0913i;
import kotlin.C0917m;
import kotlin.C0918n;
import kotlin.FeedbackRequest;
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
import kotlin.UploadFileRequest;
import kotlin.jvm.internal.Ref$ObjectRef;
import n4.AbstractC4939a;
import o4.C5005f;
import o4.InterfaceC5002c;
import p4.AgentRemoteChatMessage;
import p9.InterfaceC5074l;
import t4.InterfaceC5507a;
import u4.AgentResponse;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\u0003J\"\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0096@¢\u0006\u0004\b\u0011\u0010\u0012JZ\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH\u0096@¢\u0006\u0004\b\u001b\u0010\u001cJ8\u0010#\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0096@¢\u0006\u0004\b#\u0010$J'\u0010'\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\rH\u0016¢\u0006\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\r8\u0006X\u0086D¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/stepos/agentframework/chatcore/agents/ThirdPartClient;", "Lcom/stepos/agentframework/chatcore/agents/u;", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/agents/y;", "parameter", "Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;", "callback", "Lo4/c;", ExifInterface.LATITUDE_SOUTH, "(Lcom/stepos/agentframework/chatcore/agents/y;Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;)Lo4/c;", "LY8/t;", "close", "", "agentId", "secretKey", "Lw4/a;", "r", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "messageId", "sessionId", "", "likeStatus", "taskId", DidiCardProvider.KEY_TRACE_ID, "questionType", "questionDesc", "n", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "fileInfo", "Lt4/a;", "listener", "x", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/file/FileInfo;Lt4/a;Le9/c;)Ljava/lang/Object;", "toolCallId", "toolLikeStatus", "H", "(Ljava/lang/String;ILjava/lang/String;)V", "TAG", "Ljava/lang/String;", ExifInterface.LONGITUDE_WEST, "()Ljava/lang/String;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ThirdPartClient implements u {
    private final String TAG = " [ThirdPartClient] ";

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"com/stepos/agentframework/chatcore/agents/ThirdPartClient$a", "Lcom/stepos/agentframework/adapter/netcore/h;", "LK6/n;", "chatRequestInfo", "LY8/t;", "f", "(LK6/n;)V", "LK6/m;", "chatReplyInfo", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LK6/n;LK6/m;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "", "code", "", "message", Const.INTENT_KEY_PKGNAME, "(LK6/n;Ljava/lang/Integer;Ljava/lang/String;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements com.stepos.agentframework.adapter.netcore.h {
        final /* synthetic */ AgentDispatcher.b $callback;
        final /* synthetic */ Ref$ObjectRef<C0917m> $lastReplyInfo;

        public a(Ref$ObjectRef<C0917m> ref$ObjectRef, AgentDispatcher.b bVar) {
            this.$lastReplyInfo = ref$ObjectRef;
            this.$callback = bVar;
        }

        @Override // com.stepos.agentframework.adapter.netcore.h
        public /* bridge */ void a() {
            super.a();
        }

        @Override // com.stepos.agentframework.adapter.netcore.h
        public void b(C0918n chatRequestInfo, Integer code, String message) {
            kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
            C4148a.k(ThirdPartClient.this.getTAG(), "onFailure:" + code + ServerSentEventKt.COLON + message, false, 4, null);
            if (code != null && code.intValue() == -201) {
                AgentDispatcher.b bVar = this.$callback;
                if (message == null || message.length() == 0) {
                    message = AMapException.AMAP_CLIENT_UNKNOWN_ERROR;
                }
                bVar.i(new AgentError(AgentError.ERROR_CODE_STREAM_CANCEL, message, null, 4, null));
                return;
            }
            AgentDispatcher.b bVar2 = this.$callback;
            int iIntValue = code != null ? code.intValue() : AgentError.ERROR_CODE_UNKNOWN;
            if (message == null) {
                message = "";
            }
            bVar2.i(new AgentError(iIntValue, message, null, 4, null));
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
        public void f(C0918n chatRequestInfo) {
            kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.stepos.agentframework.adapter.netcore.h
        public void g(C0918n chatRequestInfo, C0917m chatReplyInfo) {
            kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
            kotlin.jvm.internal.p.i(chatReplyInfo, "chatReplyInfo");
            Integer event = chatReplyInfo.getEvent();
            if (event == null || event.intValue() != 0) {
                Integer event2 = chatReplyInfo.getEvent();
                if (event2 != null && event2.intValue() == 2) {
                    C4148a.d(ThirdPartClient.this.getTAG(), "get tool", false, 4, null);
                    this.$callback.l(ExtKt.u(chatReplyInfo, null, 1, null));
                    return;
                }
                return;
            }
            String tag = ThirdPartClient.this.getTAG();
            List<AbstractC0913i> listN = chatReplyInfo.n();
            int size = listN != null ? listN.size() : 0;
            C4148a.d(tag, "get contentParts=" + size + ", answerType=" + chatReplyInfo.getAnswerType(), false, 4, null);
            if (kotlin.jvm.internal.p.d(chatReplyInfo.getAnswerType(), "answer")) {
                this.$lastReplyInfo.f34820a = chatReplyInfo;
                this.$callback.l(ExtKt.i(ExtKt.h(ExtKt.u(chatReplyInfo, null, 1, null), chatReplyInfo), chatReplyInfo));
                return;
            }
            if (kotlin.jvm.internal.p.d(chatReplyInfo.getAnswerType(), "function_call")) {
                AgentResponse agentResponseU = ExtKt.u(chatReplyInfo, null, 1, null);
                C4148a.k(ThirdPartClient.this.getTAG(), "function_call type=" + agentResponseU.getType() + " status=" + agentResponseU.getStatus(), false, 4, null);
                this.$callback.l(agentResponseU);
                return;
            }
            if (kotlin.jvm.internal.p.d(chatReplyInfo.getAnswerType(), "tool_response")) {
                AgentResponse agentResponseU2 = ExtKt.u(chatReplyInfo, null, 1, null);
                C4148a.k(ThirdPartClient.this.getTAG(), "function_call_over type=" + agentResponseU2.getType() + " status=" + agentResponseU2.getStatus(), false, 4, null);
                this.$callback.l(agentResponseU2);
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
        public void j(C0918n chatRequestInfo) {
            List<AbstractC0913i> listN;
            kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
            String tag = ThirdPartClient.this.getTAG();
            List<AbstractC0913i> listJ = chatRequestInfo.j();
            int size = listJ != null ? listJ.size() : 0;
            C0917m c0917m = this.$lastReplyInfo.f34820a;
            C4148a.k(tag, "onClosed: contentParts=" + size + " lastReplyParts=" + ((c0917m == null || (listN = c0917m.n()) == null) ? 0 : listN.size()) + " lastReplyInfo is null:" + (this.$lastReplyInfo.f34820a == null), false, 4, null);
            C0917m c0917m2 = this.$lastReplyInfo.f34820a;
            if (c0917m2 == null) {
                C4148a.k(ThirdPartClient.this.getTAG(), "onClosed:lastReplyInfo is null", false, 4, null);
                return;
            }
            AgentDispatcher.b bVar = this.$callback;
            AgentResponse agentResponseU = ExtKt.u(c0917m2, null, 1, null);
            agentResponseU.F("");
            agentResponseU.V(null);
            agentResponseU.R(EReplyStatus.COMPLETED);
            bVar.l(agentResponseU);
        }
    }

    public static final Y8.t X(ThirdPartClient thirdPartClient, boolean z10, FileInfo fileInfo, InterfaceC5507a interfaceC5507a, AbstractC4939a status) {
        kotlin.jvm.internal.p.i(status, "status");
        if (status instanceof AbstractC4939a.Progress) {
            Function2.b(new ThirdPartClient$uploadFile$2$1(thirdPartClient, status, interfaceC5507a, fileInfo, null));
        } else if (status instanceof AbstractC4939a.Failed) {
            AbstractC4939a.Failed failed = (AbstractC4939a.Failed) status;
            C4148a.h(thirdPartClient.TAG, "Upload Failed: " + failed.getCode() + " - " + failed.getMessage(), false, 4, null);
            Function2.b(new ThirdPartClient$uploadFile$2$2(status, interfaceC5507a, fileInfo, null));
        } else {
            if (!(status instanceof AbstractC4939a.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            if (z10) {
                AbstractC4939a.Success success = (AbstractC4939a.Success) status;
                C4148a.d(thirdPartClient.TAG, "upload success fileId: " + success.getFileId(), false, 4, null);
                fileInfo.setFileId(success.getFileId());
            } else {
                AbstractC4939a.Success success2 = (AbstractC4939a.Success) status;
                C4148a.d(thirdPartClient.TAG, "upload success fileUrl: " + success2.getFileUrl(), false, 4, null);
                String fileUrl = success2.getFileUrl();
                if (fileUrl == null) {
                    fileUrl = "";
                }
                fileInfo.setFileUrl(fileUrl);
                if (success2.getFileId().length() > 0) {
                    fileInfo.setFileId(success2.getFileId());
                }
            }
            Function2.b(new ThirdPartClient$uploadFile$2$3(interfaceC5507a, fileInfo, null));
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
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        kotlin.jvm.internal.p.i(taskId, "taskId");
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

    @Override // com.stepos.agentframework.chatcore.agents.u
    public InterfaceC5002c S(RequestParameter parameter, AgentDispatcher.b callback) {
        kotlin.jvm.internal.p.i(parameter, "parameter");
        kotlin.jvm.internal.p.i(callback, "callback");
        a aVar = new a(new Ref$ObjectRef(), callback);
        C5005f c5005f = new C5005f();
        C1060i.d(C1073o0.f6391a, null, null, new ThirdPartClient$send$1(parameter, c5005f, aVar, callback, null), 3, null);
        return c5005f;
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object U(String str, String str2, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return super.U(str, str2, interfaceC4014c);
    }

    /* renamed from: W, reason: from getter */
    public final String getTAG() {
        return this.TAG;
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
        C4148a.k(this.TAG, "close call", false, 4, null);
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

    @Override // com.stepos.agentframework.chatcore.agents.u
    public Object n(String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7, String str8, InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        Object objG = ApiManager.INSTANCE.G(ApiType.COZE, new FeedbackRequest(str4, str, str3, i10), interfaceC4014c);
        return objG == C4063a.g() ? objG : Y8.t.f7040a;
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ void q(u.a aVar) {
        super.q(aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object r(java.lang.String r5, java.lang.String r6, e9.InterfaceC4014c<? super w4.C5732a> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.stepos.agentframework.chatcore.agents.ThirdPartClient$getAgentInfo$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.agentframework.chatcore.agents.ThirdPartClient$getAgentInfo$1 r0 = (com.stepos.agentframework.chatcore.agents.ThirdPartClient$getAgentInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.ThirdPartClient$getAgentInfo$1 r0 = new com.stepos.agentframework.chatcore.agents.ThirdPartClient$getAgentInfo$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r4 = r0.result
            java.lang.Object r7 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r4)
            goto L5a
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            kotlin.C4849c.b(r4)
            com.stepos.agentframework.adapter.ApiManager r4 = com.stepos.agentframework.adapter.ApiManager.INSTANCE
            com.stepos.agentframework.adapter.netcore.ApiType r1 = com.stepos.agentframework.adapter.netcore.ApiType.COZE
            K6.b r3 = new K6.b
            r3.<init>(r6, r5)
            java.lang.Object r5 = g9.h.a(r5)
            r0.L$0 = r5
            java.lang.Object r5 = g9.h.a(r6)
            r0.L$1 = r5
            r0.label = r2
            java.lang.Object r4 = r4.I(r1, r3, r0)
            if (r4 != r7) goto L5a
            return r7
        L5a:
            K6.a r4 = (kotlin.C0905a) r4
            w4.a$a r5 = w4.C5732a.INSTANCE
            w4.a r4 = r5.a(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.ThirdPartClient.r(java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object s(String str, String str2, String str3, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return super.s(str, str2, str3, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ InterfaceC5002c w(String str, String str2, AgentDispatcher.b bVar) {
        return super.w(str, str2, bVar);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public Object x(Context context, String str, String str2, final FileInfo fileInfo, final InterfaceC5507a interfaceC5507a, InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        C4148a.d(this.TAG, "uploadFile: " + fileInfo.getFilePath(), false, 4, null);
        final boolean z10 = true;
        Object objP0 = ApiManager.INSTANCE.p0(context, ApiType.COZE, new UploadFileRequest(str2, new File(fileInfo.getFilePath()), null, true), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatcore.agents.z
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return ThirdPartClient.X(this.f22417a, z10, fileInfo, interfaceC5507a, (AbstractC4939a) obj);
            }
        }, interfaceC4014c);
        return objP0 == C4063a.g() ? objP0 : Y8.t.f7040a;
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ void y(u.a aVar) {
        super.y(aVar);
    }
}
