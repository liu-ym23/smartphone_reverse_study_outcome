package com.stepos.agentframework.chatcore.agents;

import Ua.C1060i;
import Ua.C1073o0;
import Ua.InterfaceC1083u;
import Ua.Y;
import Z8.C1173v;
import Z8.Z;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.ApiManager;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.adapter.netcore.InquiryAnswerResult;
import com.stepos.agentframework.chatcore.agents.AgentDispatcher;
import com.stepos.agentframework.chatcore.agents.AgentOpenClawClient;
import com.stepos.agentframework.chatcore.agents.u;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.agentframework.chatcore.session.AgentError;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.common.FunctionCall;
import e9.InterfaceC4014c;
import h8.C4148a;
import io.ktor.sse.ServerSentEventKt;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
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
import kotlin.jvm.internal.Ref$ObjectRef;
import n4.AbstractC4939a;
import o4.C5001b;
import o4.InterfaceC5002c;
import t4.InterfaceC5507a;
import u4.AgentResponse;
import w4.C5732a;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\u0003J\u0017\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u0013\u0010\u0014JZ\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u001d\u0010\u001eJ8\u0010%\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H\u0096@¢\u0006\u0004\b%\u0010&J'\u0010)\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000fH\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-J.\u00100\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b0\u00101J(\u00102\u001a\u00020+2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b2\u00101J(\u00103\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b3\u00101J0\u00105\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b5\u00106R\u001a\u00107\u001a\u00020\u000f8\u0006X\u0086D¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R)\u0010>\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0<0;8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A¨\u0006B"}, d2 = {"Lcom/stepos/agentframework/chatcore/agents/AgentOpenClawClient;", "Lcom/stepos/agentframework/chatcore/agents/u;", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/agents/y;", "parameter", "Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;", "callback", "Lo4/c;", ExifInterface.LATITUDE_SOUTH, "(Lcom/stepos/agentframework/chatcore/agents/y;Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;)Lo4/c;", "LY8/t;", "close", "Y", "(Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;)V", "", "agentId", "secretKey", "Lw4/a;", "r", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "messageId", "sessionId", "", "likeStatus", "taskId", DidiCardProvider.KEY_TRACE_ID, "questionType", "questionDesc", "n", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "fileInfo", "Lt4/a;", "listener", "x", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/file/FileInfo;Lt4/a;Le9/c;)Ljava/lang/Object;", "toolCallId", "toolLikeStatus", "H", "(Ljava/lang/String;ILjava/lang/String;)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Z", "", "Lp4/a;", "N", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "K", "s", "newTitle", "I", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "X", "()Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "callbackCache", "Ljava/util/concurrent/ConcurrentHashMap;", "getCallbackCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentOpenClawClient implements u {
    private final String TAG = " [AgentOpenClawClient] ";
    private final ConcurrentHashMap<AgentDispatcher.b, Set<Object>> callbackCache = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/agentframework/chatcore/agents/AgentOpenClawClient$a", "Lo4/b$a;", "LY8/t;", "cancel", "()V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements C5001b.a {
        final /* synthetic */ AgentDispatcher.b $callback;
        final /* synthetic */ AtomicReference<com.stepos.agentframework.adapter.netcore.n> $cancelHandleRef;
        final /* synthetic */ AtomicBoolean $pendingCancel;

        public a(AtomicBoolean atomicBoolean, AtomicReference<com.stepos.agentframework.adapter.netcore.n> atomicReference, AgentDispatcher.b bVar) {
            this.$pendingCancel = atomicBoolean;
            this.$cancelHandleRef = atomicReference;
            this.$callback = bVar;
        }

        @Override // o4.C5001b.a
        public void cancel() {
            C4148a.k(AgentOpenClawClient.this.getTAG(), "Cancel request start.", false, 4, null);
            this.$pendingCancel.set(true);
            com.stepos.agentframework.adapter.netcore.n nVar = this.$cancelHandleRef.get();
            if (nVar == null) {
                C4148a.k(AgentOpenClawClient.this.getTAG(), "Cancel request pending, waiting for cancelHandle.", false, 4, null);
            } else if (com.stepos.agentframework.adapter.netcore.n.a(nVar, null, 1, null)) {
                C4148a.k(AgentOpenClawClient.this.getTAG(), "Cancel request success.", false, 4, null);
            } else {
                C4148a.k(AgentOpenClawClient.this.getTAG(), "Cancel request failed.", false, 4, null);
            }
            AgentOpenClawClient.this.Y(this.$callback);
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"com/stepos/agentframework/chatcore/agents/AgentOpenClawClient$b", "Lcom/stepos/agentframework/adapter/netcore/h;", "LK6/n;", "chatRequestInfo", "LY8/t;", "f", "(LK6/n;)V", "LK6/m;", "chatReplyInfo", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LK6/n;LK6/m;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "", "code", "", "message", Const.INTENT_KEY_PKGNAME, "(LK6/n;Ljava/lang/Integer;Ljava/lang/String;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements com.stepos.agentframework.adapter.netcore.h {
        final /* synthetic */ AgentDispatcher.b $callback;
        final /* synthetic */ Ref$ObjectRef<C0917m> $lastReplyInfo;

        public b(Ref$ObjectRef<C0917m> ref$ObjectRef, AgentDispatcher.b bVar) {
            this.$lastReplyInfo = ref$ObjectRef;
            this.$callback = bVar;
        }

        public static final List l(C0917m chatReplyInfo, AgentResponse agentResponse) {
            kotlin.jvm.internal.p.i(chatReplyInfo, "chatReplyInfo");
            kotlin.jvm.internal.p.i(agentResponse, "agentResponse");
            FunctionCall functionCall = chatReplyInfo.getFunctionCall();
            kotlin.jvm.internal.p.f(functionCall);
            return C1173v.s(ExtKt.w(functionCall, false));
        }

        @Override // com.stepos.agentframework.adapter.netcore.h
        public /* bridge */ void a() {
            super.a();
        }

        @Override // com.stepos.agentframework.adapter.netcore.h
        public void b(C0918n chatRequestInfo, Integer code, String message) {
            kotlin.jvm.internal.p.i(chatRequestInfo, "chatRequestInfo");
            C4148a.k(AgentOpenClawClient.this.getTAG(), "onFailure:" + code + ServerSentEventKt.COLON + message, false, 4, null);
            if (code != null && code.intValue() == -201) {
                AgentDispatcher.b bVar = this.$callback;
                if (message == null || message.length() == 0) {
                    message = "未绑定 ZeroClaw 服务（请安装主应用 ZeroClaw 并使用相同签名）";
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
            AgentOpenClawClient.this.Y(this.$callback);
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
                if (event != null && event.intValue() == 2) {
                    C4148a.d(AgentOpenClawClient.this.getTAG(), "get tool", false, 4, null);
                    this.$callback.l(ExtKt.t(chatReplyInfo, new p9.p() { // from class: com.stepos.agentframework.chatcore.agents.s
                        @Override // p9.p
                        public final Object invoke(Object obj, Object obj2) {
                            return AgentOpenClawClient.b.l((C0917m) obj, (AgentResponse) obj2);
                        }
                    }));
                    return;
                }
                return;
            }
            String tag = AgentOpenClawClient.this.getTAG();
            List<AbstractC0913i> listN = chatReplyInfo.n();
            C4148a.d(tag, "get contentParts=" + (listN != null ? listN.size() : 0), false, 4, null);
            this.$lastReplyInfo.f34820a = chatReplyInfo;
            this.$callback.l(ExtKt.i(ExtKt.h(ExtKt.u(chatReplyInfo, null, 1, null), chatReplyInfo), chatReplyInfo));
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
            String tag = AgentOpenClawClient.this.getTAG();
            List<AbstractC0913i> listJ = chatRequestInfo.j();
            int size = listJ != null ? listJ.size() : 0;
            C0917m c0917m = this.$lastReplyInfo.f34820a;
            C4148a.k(tag, "onClosed: contentParts=" + size + " lastReplyParts=" + ((c0917m == null || (listN = c0917m.n()) == null) ? 0 : listN.size()) + " lastReplyInfo is null:" + (this.$lastReplyInfo.f34820a == null), false, 4, null);
            C0917m c0917m2 = this.$lastReplyInfo.f34820a;
            if (c0917m2 != null) {
                AgentDispatcher.b bVar = this.$callback;
                AgentResponse agentResponseU = ExtKt.u(c0917m2, null, 1, null);
                agentResponseU.F("");
                agentResponseU.V(null);
                agentResponseU.R(EReplyStatus.COMPLETED);
                bVar.l(agentResponseU);
            } else {
                C4148a.k(AgentOpenClawClient.this.getTAG(), "onClosed:lastReplyInfo is null", false, 4, null);
            }
            AgentOpenClawClient.this.Y(this.$callback);
        }
    }

    public static final Y8.t Z(AgentOpenClawClient agentOpenClawClient, InterfaceC1083u interfaceC1083u, boolean z10, FileInfo fileInfo, InterfaceC5507a interfaceC5507a, AbstractC4939a status) {
        kotlin.jvm.internal.p.i(status, "status");
        if (status instanceof AbstractC4939a.Progress) {
            Function2.b(new AgentOpenClawClient$uploadFile$2$1(agentOpenClawClient, status, interfaceC5507a, fileInfo, null));
        } else if (status instanceof AbstractC4939a.Failed) {
            AbstractC4939a.Failed failed = (AbstractC4939a.Failed) status;
            C4148a.h(agentOpenClawClient.TAG, "Upload Failed: " + failed.getCode() + " - " + failed.getMessage(), false, 4, null);
            Function2.b(new AgentOpenClawClient$uploadFile$2$2(status, interfaceC5507a, fileInfo, null));
            interfaceC1083u.complete(Boolean.FALSE);
        } else {
            if (!(status instanceof AbstractC4939a.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            if (z10) {
                AbstractC4939a.Success success = (AbstractC4939a.Success) status;
                C4148a.d(agentOpenClawClient.TAG, "upload success fileId: " + success.getFileId(), false, 4, null);
                fileInfo.setFileId(success.getFileId());
            } else {
                AbstractC4939a.Success success2 = (AbstractC4939a.Success) status;
                C4148a.d(agentOpenClawClient.TAG, "upload success fileUrl: " + success2.getFileUrl(), false, 4, null);
                String fileUrl = success2.getFileUrl();
                if (fileUrl == null) {
                    fileUrl = "";
                }
                fileInfo.setFileUrl(fileUrl);
                if (success2.getFileId().length() > 0) {
                    fileInfo.setFileId(success2.getFileId());
                }
            }
            Function2.b(new AgentOpenClawClient$uploadFile$2$3(interfaceC5507a, fileInfo, null));
            interfaceC1083u.complete(Boolean.TRUE);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t a0(AgentOpenClawClient agentOpenClawClient, Throwable th) {
        if (th != null) {
            C4148a.k(agentOpenClawClient.TAG, "uploadFile failed: " + th, false, 4, null);
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
        C4148a.k(this.TAG, "OpenClaw 不支持工具点赞", false, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v8 */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object I(java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, e9.InterfaceC4014c<? super Y8.t> r13) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r13 instanceof com.stepos.agentframework.chatcore.agents.AgentOpenClawClient$renameConversationRemote$1
            if (r0 == 0) goto L13
            r0 = r13
            com.stepos.agentframework.chatcore.agents.AgentOpenClawClient$renameConversationRemote$1 r0 = (com.stepos.agentframework.chatcore.agents.AgentOpenClawClient$renameConversationRemote$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.AgentOpenClawClient$renameConversationRemote$1 r0 = new com.stepos.agentframework.chatcore.agents.AgentOpenClawClient$renameConversationRemote$1
            r0.<init>(r8, r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 4
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L46
            if (r2 != r6) goto L3e
            java.lang.Object r9 = r0.L$3
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r9 = r0.L$2
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r9 = r0.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r9 = r0.L$0
            java.lang.String r9 = (java.lang.String) r9
            kotlin.C4849c.b(r13)     // Catch: java.lang.Exception -> L3c
            goto Laa
        L3c:
            r9 = move-exception
            goto L94
        L3e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L46:
            kotlin.C4849c.b(r13)
            java.lang.String r13 = r8.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r7 = "renameConversationRemote: agentId="
            r2.append(r7)
            r2.append(r9)
            java.lang.String r7 = ", sessionId="
            r2.append(r7)
            r2.append(r11)
            java.lang.String r7 = ", newTitle="
            r2.append(r7)
            r2.append(r12)
            java.lang.String r2 = r2.toString()
            h8.C4148a.k(r13, r2, r5, r4, r3)
            com.stepos.agentframework.adapter.ApiManager r13 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Exception -> L3c
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.OPENCLAW     // Catch: java.lang.Exception -> L3c
            java.lang.Object r9 = g9.h.a(r9)     // Catch: java.lang.Exception -> L3c
            r0.L$0 = r9     // Catch: java.lang.Exception -> L3c
            java.lang.Object r9 = g9.h.a(r10)     // Catch: java.lang.Exception -> L3c
            r0.L$1 = r9     // Catch: java.lang.Exception -> L3c
            java.lang.Object r9 = g9.h.a(r11)     // Catch: java.lang.Exception -> L3c
            r0.L$2 = r9     // Catch: java.lang.Exception -> L3c
            java.lang.Object r9 = g9.h.a(r12)     // Catch: java.lang.Exception -> L3c
            r0.L$3 = r9     // Catch: java.lang.Exception -> L3c
            r0.label = r6     // Catch: java.lang.Exception -> L3c
            java.lang.Object r8 = r13.h0(r2, r11, r12, r0)     // Catch: java.lang.Exception -> L3c
            if (r8 != r1) goto Laa
            return r1
        L94:
            java.lang.String r8 = r8.TAG
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "renameConversationRemote failed: "
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            h8.C4148a.h(r8, r9, r5, r4, r3)
        Laa:
            Y8.t r8 = Y8.t.f7040a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentOpenClawClient.I(java.lang.String, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object K(java.lang.String r9, java.lang.String r10, java.lang.String r11, e9.InterfaceC4014c<? super java.lang.Boolean> r12) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r12 instanceof com.stepos.agentframework.chatcore.agents.AgentOpenClawClient$deleteConversationRemote$1
            if (r0 == 0) goto L13
            r0 = r12
            com.stepos.agentframework.chatcore.agents.AgentOpenClawClient$deleteConversationRemote$1 r0 = (com.stepos.agentframework.chatcore.agents.AgentOpenClawClient$deleteConversationRemote$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.AgentOpenClawClient$deleteConversationRemote$1 r0 = new com.stepos.agentframework.chatcore.agents.AgentOpenClawClient$deleteConversationRemote$1
            r0.<init>(r8, r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 4
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L42
            if (r2 != r5) goto L3a
            java.lang.Object r9 = r0.L$2
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r9 = r0.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r9 = r0.L$0
            java.lang.String r9 = (java.lang.String) r9
            kotlin.C4849c.b(r12)     // Catch: java.lang.Exception -> L38
            goto L82
        L38:
            r9 = move-exception
            goto L89
        L3a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L42:
            kotlin.C4849c.b(r12)
            java.lang.String r12 = r8.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r7 = "deleteConversationRemote: agentId="
            r2.append(r7)
            r2.append(r9)
            java.lang.String r7 = ", sessionId="
            r2.append(r7)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            h8.C4148a.k(r12, r2, r6, r4, r3)
            com.stepos.agentframework.adapter.ApiManager r12 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Exception -> L38
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.OPENCLAW     // Catch: java.lang.Exception -> L38
            java.lang.Object r9 = g9.h.a(r9)     // Catch: java.lang.Exception -> L38
            r0.L$0 = r9     // Catch: java.lang.Exception -> L38
            java.lang.Object r9 = g9.h.a(r10)     // Catch: java.lang.Exception -> L38
            r0.L$1 = r9     // Catch: java.lang.Exception -> L38
            java.lang.Object r9 = g9.h.a(r11)     // Catch: java.lang.Exception -> L38
            r0.L$2 = r9     // Catch: java.lang.Exception -> L38
            r0.label = r5     // Catch: java.lang.Exception -> L38
            java.lang.Object r12 = r12.E(r2, r11, r0)     // Catch: java.lang.Exception -> L38
            if (r12 != r1) goto L82
            return r1
        L82:
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch: java.lang.Exception -> L38
            boolean r6 = r12.booleanValue()     // Catch: java.lang.Exception -> L38
            goto L9f
        L89:
            java.lang.String r8 = r8.TAG
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "deleteConversationRemote failed: "
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            h8.C4148a.h(r8, r9, r6, r4, r3)
        L9f:
            java.lang.Boolean r8 = g9.C4109a.a(r6)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentOpenClawClient.K(java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object N(java.lang.String r11, java.lang.String r12, java.lang.String r13, e9.InterfaceC4014c<? super java.util.List<p4.AgentRemoteChatMessage>> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentOpenClawClient.N(java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public InterfaceC5002c S(RequestParameter parameter, AgentDispatcher.b callback) {
        kotlin.jvm.internal.p.i(parameter, "parameter");
        kotlin.jvm.internal.p.i(callback, "callback");
        C5001b c5001b = new C5001b();
        AtomicReference atomicReference = new AtomicReference(null);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        c5001b.b(new a(atomicBoolean, atomicReference, callback));
        b bVar = new b(new Ref$ObjectRef(), callback);
        ConcurrentHashMap<AgentDispatcher.b, Set<Object>> concurrentHashMap = this.callbackCache;
        Set<Object> linkedHashSet = concurrentHashMap.get(callback);
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet<>();
        }
        concurrentHashMap.put(callback, Z.p(linkedHashSet, bVar));
        C1060i.d(C1073o0.f6391a, Y.b(), null, new AgentOpenClawClient$send$2(parameter, bVar, atomicReference, atomicBoolean, this, callback, null), 2, null);
        return c5001b;
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
        C4148a.k(this.TAG, "close call", false, 4, null);
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
    public boolean h() {
        return ApiManager.INSTANCE.S(ApiType.OPENCLAW);
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

    /* JADX WARN: Removed duplicated region for block: B:23:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x011d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object n(java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, int r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, e9.InterfaceC4014c<? super Y8.t> r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentOpenClawClient.n(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ void q(u.a aVar) {
        super.q(aVar);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public Object r(String str, String str2, InterfaceC4014c<? super C5732a> interfaceC4014c) {
        return new C5732a(str, "OpenClawAgent", "This is an OpenClaw agent", "", "This is a prologue", null, 32, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v8 */
    @Override // com.stepos.agentframework.chatcore.agents.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object s(java.lang.String r9, java.lang.String r10, java.lang.String r11, e9.InterfaceC4014c<? super Y8.t> r12) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r12 instanceof com.stepos.agentframework.chatcore.agents.AgentOpenClawClient$clearConversationRemote$1
            if (r0 == 0) goto L13
            r0 = r12
            com.stepos.agentframework.chatcore.agents.AgentOpenClawClient$clearConversationRemote$1 r0 = (com.stepos.agentframework.chatcore.agents.AgentOpenClawClient$clearConversationRemote$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.chatcore.agents.AgentOpenClawClient$clearConversationRemote$1 r0 = new com.stepos.agentframework.chatcore.agents.AgentOpenClawClient$clearConversationRemote$1
            r0.<init>(r8, r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 4
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L42
            if (r2 != r6) goto L3a
            java.lang.Object r9 = r0.L$2
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r9 = r0.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r9 = r0.L$0
            java.lang.String r9 = (java.lang.String) r9
            kotlin.C4849c.b(r12)     // Catch: java.lang.Exception -> L38
            goto L98
        L38:
            r9 = move-exception
            goto L82
        L3a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L42:
            kotlin.C4849c.b(r12)
            java.lang.String r12 = r8.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r7 = "clearConversationRemote: agentId="
            r2.append(r7)
            r2.append(r9)
            java.lang.String r7 = ", sessionId="
            r2.append(r7)
            r2.append(r11)
            java.lang.String r2 = r2.toString()
            h8.C4148a.k(r12, r2, r5, r4, r3)
            com.stepos.agentframework.adapter.ApiManager r12 = com.stepos.agentframework.adapter.ApiManager.INSTANCE     // Catch: java.lang.Exception -> L38
            com.stepos.agentframework.adapter.netcore.ApiType r2 = com.stepos.agentframework.adapter.netcore.ApiType.OPENCLAW     // Catch: java.lang.Exception -> L38
            java.lang.Object r9 = g9.h.a(r9)     // Catch: java.lang.Exception -> L38
            r0.L$0 = r9     // Catch: java.lang.Exception -> L38
            java.lang.Object r9 = g9.h.a(r10)     // Catch: java.lang.Exception -> L38
            r0.L$1 = r9     // Catch: java.lang.Exception -> L38
            java.lang.Object r9 = g9.h.a(r11)     // Catch: java.lang.Exception -> L38
            r0.L$2 = r9     // Catch: java.lang.Exception -> L38
            r0.label = r6     // Catch: java.lang.Exception -> L38
            java.lang.Object r8 = r12.y(r2, r11, r0)     // Catch: java.lang.Exception -> L38
            if (r8 != r1) goto L98
            return r1
        L82:
            java.lang.String r8 = r8.TAG
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "clearConversationRemote failed: "
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            h8.C4148a.h(r8, r9, r5, r4, r3)
        L98:
            Y8.t r8 = Y8.t.f7040a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentOpenClawClient.s(java.lang.String, java.lang.String, java.lang.String, e9.c):java.lang.Object");
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
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.agents.AgentOpenClawClient.x(android.content.Context, java.lang.String, java.lang.String, com.stepos.agentframework.chatcore.file.FileInfo, t4.a, e9.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ void y(u.a aVar) {
        super.y(aVar);
    }
}
