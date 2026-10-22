package com.stepos.agentframework.chatcore.agents;

import Z8.C1173v;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.netcore.InquiryAnswerResult;
import com.stepos.agentframework.chatcore.agents.AgentDispatcher;
import com.stepos.agentframework.chatcore.file.FileInfo;
import com.stepos.ailauncher.chat.wake.circle.F;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import g9.C4109a;
import java.util.List;
import kotlin.Metadata;
import kotlin.TaskBatchDeleteRequest;
import kotlin.TaskCancelRequest;
import kotlin.TaskDeleteRequest;
import kotlin.TaskInteractRequest;
import kotlin.TaskSyncRemoteRequest;
import kotlin.TranscriptAppendRequest;
import kotlin.TranscriptAppendResult;
import o4.InterfaceC5002c;
import p4.AgentRemoteChatMessage;
import t4.InterfaceC5507a;
import u4.AgentResponse;
import w4.C5732a;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001:\u00018J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH¦@¢\u0006\u0004\b\u0010\u0010\u0011J\\\u0010\u001a\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH¦@¢\u0006\u0004\b\u001a\u0010\u001bJ8\u0010\"\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H¦@¢\u0006\u0004\b\"\u0010#J4\u0010'\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\fH\u0096@¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\t2\u0006\u0010!\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\t2\u0006\u0010!\u001a\u00020)H\u0016¢\u0006\u0004\b,\u0010+J\u0018\u0010/\u001a\u00020&2\u0006\u0010.\u001a\u00020-H\u0096@¢\u0006\u0004\b/\u00100J\u0018\u00102\u001a\u00020&2\u0006\u0010.\u001a\u000201H\u0096@¢\u0006\u0004\b2\u00103J\u0018\u00105\u001a\u00020&2\u0006\u0010.\u001a\u000204H\u0096@¢\u0006\u0004\b5\u00106J\u0018\u00108\u001a\u00020&2\u0006\u0010.\u001a\u000207H\u0096@¢\u0006\u0004\b8\u00109J.\u0010>\u001a\u00020=2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010:\u001a\u00020\f2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\f0;H\u0096@¢\u0006\u0004\b>\u0010?J\u0018\u0010A\u001a\u00020&2\u0006\u0010.\u001a\u00020@H\u0096@¢\u0006\u0004\bA\u0010BJ)\u0010D\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010C\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\bD\u0010EJ'\u0010H\u001a\u00020\t2\u0006\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\fH&¢\u0006\u0004\bH\u0010IJ.\u0010K\u001a\b\u0012\u0004\u0012\u00020J0;2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0096@¢\u0006\u0004\bK\u0010LJ(\u0010M\u001a\u00020&2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0096@¢\u0006\u0004\bM\u0010LJ \u0010N\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0096@¢\u0006\u0004\bN\u0010\u0011J(\u0010O\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0096@¢\u0006\u0004\bO\u0010LJ0\u0010Q\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010P\u001a\u00020\fH\u0096@¢\u0006\u0004\bQ\u0010RJ.\u0010T\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\fH\u0096@¢\u0006\u0004\bT\u0010LJ\u0012\u0010U\u001a\u0004\u0018\u00010\fH\u0096@¢\u0006\u0004\bU\u0010VJ\u001a\u0010W\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\fH\u0096@¢\u0006\u0004\bW\u0010XJ\u0012\u0010Y\u001a\u0004\u0018\u00010\fH\u0096@¢\u0006\u0004\bY\u0010VJ\u001a\u0010Z\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\fH\u0096@¢\u0006\u0004\bZ\u0010XJ\u0018\u0010]\u001a\u00020\\2\u0006\u0010.\u001a\u00020[H\u0096@¢\u0006\u0004\b]\u0010^J\u000f\u0010_\u001a\u00020&H\u0016¢\u0006\u0004\b_\u0010`J>\u0010e\u001a\u00020&2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010a\u001a\u00020\f2\u0006\u0010b\u001a\u00020\f2\b\b\u0002\u0010c\u001a\u00020\f2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\fH\u0096@¢\u0006\u0004\be\u0010f¨\u0006gÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/agents/u;", "", "Lcom/stepos/agentframework/chatcore/agents/y;", "parameter", "Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;", "callback", "Lo4/c;", ExifInterface.LATITUDE_SOUTH, "(Lcom/stepos/agentframework/chatcore/agents/y;Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;)Lo4/c;", "LY8/t;", "close", "()V", "", "agentId", "secretKey", "Lw4/a;", "r", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "messageId", "sessionId", "", "likeStatus", "taskId", DidiCardProvider.KEY_TRACE_ID, "questionType", "questionDesc", "n", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/chatcore/file/FileInfo;", "fileInfo", "Lt4/a;", "listener", "x", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/file/FileInfo;Lt4/a;Le9/c;)Ljava/lang/Object;", "filePath", "mime", "", "B", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/agentframework/chatcore/agents/u$a;", "y", "(Lcom/stepos/agentframework/chatcore/agents/u$a;)V", "q", "LK6/G;", "request", "f", "(LK6/G;Le9/c;)Ljava/lang/Object;", "LK6/E;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LK6/E;Le9/c;)Ljava/lang/Object;", "LK6/F;", "e", "(LK6/F;Le9/c;)Ljava/lang/Object;", "LK6/H;", Const.INTENT_KEY_APIKEY, "(LK6/H;Le9/c;)Ljava/lang/Object;", "inquiryId", "", "answers", "Lcom/stepos/agentframework/adapter/netcore/q;", "k", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Le9/c;)Ljava/lang/Object;", "LK6/I;", "l", "(LK6/I;Le9/c;)Ljava/lang/Object;", "outboundId", "w", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/agents/AgentDispatcher$b;)Lo4/c;", "toolCallId", "toolLikeStatus", "H", "(Ljava/lang/String;ILjava/lang/String;)V", "Lp4/a;", "N", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "K", "U", "s", "newTitle", "I", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "deviceId", "G", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "m", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "LK6/J;", "LK6/K;", Const.INTENT_KEY_UMID, "(LK6/J;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Z", "requestId", "decision", "reason", "askUserQuestion", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface u {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/agents/u$a;", "", "Lu4/d;", UxipConstants.f30685x, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lu4/d;)V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        void a(AgentResponse response);
    }

    static /* synthetic */ Object A(u uVar, String str, String str2, String str3, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return Y8.t.f7040a;
    }

    static /* synthetic */ Object C(u uVar, TaskDeleteRequest taskDeleteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C4109a.a(false);
    }

    static /* synthetic */ Object D(u uVar, TaskCancelRequest taskCancelRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C4109a.a(false);
    }

    static /* synthetic */ Object E(u uVar, TaskBatchDeleteRequest taskBatchDeleteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C4109a.a(false);
    }

    static /* synthetic */ Object F(u uVar, String str, String str2, String str3, InterfaceC4014c<? super String> interfaceC4014c) {
        return null;
    }

    static /* synthetic */ Object J(u uVar, String str, String str2, String str3, String str4, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return Y8.t.f7040a;
    }

    static /* synthetic */ Object L(u uVar, String str, String str2, String str3, String str4, String str5, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C4109a.a(false);
    }

    static /* synthetic */ Object M(u uVar, TaskSyncRemoteRequest taskSyncRemoteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C4109a.a(false);
    }

    static /* synthetic */ Object O(u uVar, InterfaceC4014c<? super String> interfaceC4014c) {
        return null;
    }

    static /* synthetic */ Object P(u uVar, String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return uVar.i(interfaceC4014c);
    }

    static /* synthetic */ Object Q(u uVar, Context context, String str, String str2, String str3, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C4109a.a(true);
    }

    static /* synthetic */ Object R(u uVar, String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return uVar.m(interfaceC4014c);
    }

    static /* synthetic */ Object T(u uVar, TaskInteractRequest taskInteractRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C4109a.a(false);
    }

    static /* synthetic */ Object o(u uVar, InterfaceC4014c<? super String> interfaceC4014c) {
        return null;
    }

    static /* synthetic */ Object p(u uVar, String str, String str2, String str3, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C4109a.a(false);
    }

    static /* synthetic */ Object t(u uVar, String str, String str2, String str3, InterfaceC4014c<? super List<AgentRemoteChatMessage>> interfaceC4014c) {
        return C1173v.m();
    }

    static /* synthetic */ Object u(u uVar, String str, String str2, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return Y8.t.f7040a;
    }

    static /* synthetic */ Object v(u uVar, String str, String str2, List<String> list, InterfaceC4014c<? super InquiryAnswerResult> interfaceC4014c) {
        return new InquiryAnswerResult(false, null, 2, null);
    }

    static /* synthetic */ Object z(u uVar, TranscriptAppendRequest transcriptAppendRequest, InterfaceC4014c<? super TranscriptAppendResult> interfaceC4014c) {
        return new TranscriptAppendResult(false, 0, 0, null, null, null, "unsupported", null, F.GESTURE_WIDTH_DP, null);
    }

    default Object B(Context context, String str, String str2, String str3, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return Q(this, context, str, str2, str3, interfaceC4014c);
    }

    default Object G(String str, String str2, String str3, InterfaceC4014c<? super String> interfaceC4014c) {
        return F(this, str, str2, str3, interfaceC4014c);
    }

    void H(String toolCallId, int toolLikeStatus, String taskId);

    default Object I(String str, String str2, String str3, String str4, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return J(this, str, str2, str3, str4, interfaceC4014c);
    }

    default Object K(String str, String str2, String str3, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return p(this, str, str2, str3, interfaceC4014c);
    }

    default Object N(String str, String str2, String str3, InterfaceC4014c<? super List<AgentRemoteChatMessage>> interfaceC4014c) {
        return t(this, str, str2, str3, interfaceC4014c);
    }

    InterfaceC5002c S(RequestParameter parameter, AgentDispatcher.b callback);

    default Object U(String str, String str2, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return u(this, str, str2, interfaceC4014c);
    }

    default Object a(TaskInteractRequest taskInteractRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return T(this, taskInteractRequest, interfaceC4014c);
    }

    default Object b(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return P(this, str, interfaceC4014c);
    }

    default Object c(String str, String str2, String str3, String str4, String str5, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return L(this, str, str2, str3, str4, str5, interfaceC4014c);
    }

    void close();

    default Object d(TranscriptAppendRequest transcriptAppendRequest, InterfaceC4014c<? super TranscriptAppendResult> interfaceC4014c) {
        return z(this, transcriptAppendRequest, interfaceC4014c);
    }

    default Object e(TaskCancelRequest taskCancelRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return D(this, taskCancelRequest, interfaceC4014c);
    }

    default Object f(TaskDeleteRequest taskDeleteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C(this, taskDeleteRequest, interfaceC4014c);
    }

    default Object g(TaskBatchDeleteRequest taskBatchDeleteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return E(this, taskBatchDeleteRequest, interfaceC4014c);
    }

    default boolean h() {
        return true;
    }

    default Object i(InterfaceC4014c<? super String> interfaceC4014c) {
        return o(this, interfaceC4014c);
    }

    default Object j(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return R(this, str, interfaceC4014c);
    }

    default Object k(String str, String str2, List<String> list, InterfaceC4014c<? super InquiryAnswerResult> interfaceC4014c) {
        return v(this, str, str2, list, interfaceC4014c);
    }

    default Object l(TaskSyncRemoteRequest taskSyncRemoteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return M(this, taskSyncRemoteRequest, interfaceC4014c);
    }

    default Object m(InterfaceC4014c<? super String> interfaceC4014c) {
        return O(this, interfaceC4014c);
    }

    Object n(String str, String str2, String str3, String str4, int i10, String str5, String str6, String str7, String str8, InterfaceC4014c<? super Y8.t> interfaceC4014c);

    default void q(a listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
    }

    Object r(String str, String str2, InterfaceC4014c<? super C5732a> interfaceC4014c);

    default Object s(String str, String str2, String str3, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return A(this, str, str2, str3, interfaceC4014c);
    }

    default InterfaceC5002c w(String sessionId, String outboundId, AgentDispatcher.b callback) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(outboundId, "outboundId");
        kotlin.jvm.internal.p.i(callback, "callback");
        return null;
    }

    Object x(Context context, String str, String str2, FileInfo fileInfo, InterfaceC5507a interfaceC5507a, InterfaceC4014c<? super Y8.t> interfaceC4014c);

    default void y(a listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
    }
}
