package com.stepos.agentframework.chatcore.agents;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.agentframework.adapter.netcore.InquiryAnswerResult;
import com.stepos.agentframework.chatcore.agents.AgentDispatcher;
import com.stepos.agentframework.chatcore.agents.u;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import e9.InterfaceC4014c;
import java.util.List;
import kotlin.Metadata;
import kotlin.TaskBatchDeleteRequest;
import kotlin.TaskCancelRequest;
import kotlin.TaskDeleteRequest;
import kotlin.TaskInteractRequest;
import kotlin.TaskSyncRemoteRequest;
import kotlin.TranscriptAppendRequest;
import kotlin.TranscriptAppendResult;
import o4.C5003d;
import o4.InterfaceC5002c;
import p4.AgentRemoteChatMessage;
import t4.InterfaceC5507a;
import u4.AgentResponse;
import w4.C5732a;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\u0003J\"\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0096@¢\u0006\u0004\b\u0011\u0010\u0012JZ\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH\u0096@¢\u0006\u0004\b\u001b\u0010\u001cJ8\u0010#\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0096@¢\u0006\u0004\b#\u0010$J'\u0010'\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\rH\u0016¢\u0006\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/stepos/agentframework/chatcore/agents/v;", "Lcom/stepos/agentframework/chatcore/agents/u;", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/agents/y;", "parameter", "Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;", "callback", "Lo4/c;", ExifInterface.LATITUDE_SOUTH, "(Lcom/stepos/agentframework/chatcore/agents/y;Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;)Lo4/c;", "LY8/t;", "close", "", "agentId", "secretKey", "Lw4/a;", "r", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "messageId", "sessionId", "", "likeStatus", "taskId", DidiCardProvider.KEY_TRACE_ID, "questionType", "questionDesc", "n", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "fileInfo", "Lt4/a;", "listener", "x", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/file/FileInfo;Lt4/a;Le9/c;)Ljava/lang/Object;", "toolCallId", "toolLikeStatus", "H", "(Ljava/lang/String;ILjava/lang/String;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class v implements u {
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
        C5003d c5003d = new C5003d();
        String strC = O6.m.INSTANCE.c("msg-local-" + System.currentTimeMillis());
        AgentResponse agentResponse = new AgentResponse(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194303, null);
        agentResponse.N(strC);
        agentResponse.F("本地agent的测试数据");
        agentResponse.W(AgentMessageType.TEXT);
        agentResponse.R(EReplyStatus.COMPLETED);
        callback.l(agentResponse);
        return c5003d;
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ Object U(String str, String str2, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return super.U(str, str2, interfaceC4014c);
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
    public Object n(String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7, String str8, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return Y8.t.f7040a;
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ void q(u.a aVar) {
        super.q(aVar);
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public Object r(String str, String str2, InterfaceC4014c<? super C5732a> interfaceC4014c) {
        return new C5732a(str, "本地测试", "本地测试", "", "本地测试", null, 32, null);
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
    public Object x(Context context, String str, String str2, FileInfo fileInfo, InterfaceC5507a interfaceC5507a, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return Y8.t.f7040a;
    }

    @Override // com.stepos.agentframework.chatcore.agents.u
    public /* bridge */ void y(u.a aVar) {
        super.y(aVar);
    }
}
