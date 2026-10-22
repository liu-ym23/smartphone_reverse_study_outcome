package com.stepos.agentframework.adapter.netcore;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import g9.C4109a;
import java.util.List;
import kotlin.AgentDetailRequest;
import kotlin.C0905a;
import kotlin.C0918n;
import kotlin.FeedbackRequest;
import kotlin.Metadata;
import kotlin.SyncHistoryRequest;
import kotlin.SyncHistoryResult;
import kotlin.TaskBatchDeleteRequest;
import kotlin.TaskCancelRequest;
import kotlin.TaskDeleteRequest;
import kotlin.TaskInteractRequest;
import kotlin.TaskSyncRemoteRequest;
import kotlin.TranscriptAppendRequest;
import kotlin.TranscriptAppendResult;
import kotlin.UploadFileRequest;
import kotlin.VoteRequest;

@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH¦@¢\u0006\u0004\b\u000e\u0010\u000fJ*\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u0017H\u0096@¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u001aH\u0096@¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u001dH\u0016¢\u0006\u0004\b \u0010\u001fJP\u0010&\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020!2.\u0010%\u001a*\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010$\u0012\u0004\u0012\u00020\u00060\"H\u0096@¢\u0006\u0004\b&\u0010'J,\u0010+\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u00102\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0010H\u0096@¢\u0006\u0004\b+\u0010,J\u001a\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010\n\u001a\u00020-H\u0096@¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0014H\u0016¢\u0006\u0004\b2\u00103J\u0018\u00105\u001a\u00020\u00142\u0006\u0010\n\u001a\u000204H\u0096@¢\u0006\u0004\b5\u00106J\u0018\u00108\u001a\u00020\u00142\u0006\u0010\n\u001a\u000207H\u0096@¢\u0006\u0004\b8\u00109J\u0018\u0010;\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020:H\u0096@¢\u0006\u0004\b;\u0010<J\u0018\u0010>\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020=H\u0096@¢\u0006\u0004\b>\u0010?J.\u0010E\u001a\u00020D2\u0006\u0010@\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u00102\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00100BH\u0096@¢\u0006\u0004\bE\u0010FJ\u0018\u0010H\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020GH\u0096@¢\u0006\u0004\bH\u0010IJ\u0018\u0010L\u001a\u00020K2\u0006\u0010\n\u001a\u00020JH\u0096@¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u00020\u0014H\u0016¢\u0006\u0004\bN\u0010\u0016J\u0018\u0010P\u001a\u00020\u00142\u0006\u0010O\u001a\u00020\u0010H\u0096@¢\u0006\u0004\bP\u0010QJ\"\u0010S\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u00102\b\b\u0002\u0010R\u001a\u00020\u0010H\u0096@¢\u0006\u0004\bS\u0010TJ\u0018\u0010U\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u0010H\u0096@¢\u0006\u0004\bU\u0010QJ \u0010W\u001a\u00020\u00062\u0006\u0010O\u001a\u00020\u00102\u0006\u0010V\u001a\u00020\u0010H\u0096@¢\u0006\u0004\bW\u0010TJ\u0012\u0010X\u001a\u0004\u0018\u00010\u0010H\u0096@¢\u0006\u0004\bX\u0010YJ&\u0010\\\u001a\u0004\u0018\u00010\u00102\u0006\u0010Z\u001a\u00020\u00102\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u0010H\u0096@¢\u0006\u0004\b\\\u0010TJ\u001a\u0010^\u001a\u0004\u0018\u00010\u00102\u0006\u0010]\u001a\u00020\u0010H\u0096@¢\u0006\u0004\b^\u0010QJ\u001a\u0010`\u001a\u0004\u0018\u00010\u00102\u0006\u0010_\u001a\u00020\u0010H\u0096@¢\u0006\u0004\b`\u0010QJ \u0010b\u001a\u00020\u00142\u0006\u0010_\u001a\u00020\u00102\u0006\u0010a\u001a\u00020\u0010H\u0096@¢\u0006\u0004\bb\u0010TJ\u0012\u0010c\u001a\u0004\u0018\u00010\u0010H\u0096@¢\u0006\u0004\bc\u0010YJ\u001a\u0010d\u001a\u0004\u0018\u00010\u00102\u0006\u0010]\u001a\u00020\u0010H\u0096@¢\u0006\u0004\bd\u0010QJ\u0018\u0010g\u001a\u00020f2\u0006\u0010\n\u001a\u00020eH\u0096@¢\u0006\u0004\bg\u0010hJ>\u0010l\u001a\u00020\u00142\u0006\u0010@\u001a\u00020\u00102\u0006\u0010i\u001a\u00020\u00102\u0006\u0010j\u001a\u00020\u00102\b\b\u0002\u0010R\u001a\u00020\u00102\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u0010H\u0096@¢\u0006\u0004\bl\u0010mR\u0014\u0010_\u001a\u00020n8&X¦\u0004¢\u0006\u0006\u001a\u0004\bo\u0010p¨\u0006qÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/o;", "", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/adapter/netcore/p;", "logger", "LY8/t;", "r", "(Landroid/content/Context;Lcom/stepos/agentframework/adapter/netcore/p;)V", "LK6/n;", "request", "Lcom/stepos/agentframework/adapter/netcore/h;", "listener", "Lcom/stepos/agentframework/adapter/netcore/n;", ExifInterface.LONGITUDE_EAST, "(LK6/n;Lcom/stepos/agentframework/adapter/netcore/h;Le9/c;)Ljava/lang/Object;", "", "originRunId", "B", "(LK6/n;Ljava/lang/String;Lcom/stepos/agentframework/adapter/netcore/h;Le9/c;)Ljava/lang/Object;", "", "D", "()Z", "LK6/s;", "C", "(LK6/s;Le9/c;)Ljava/lang/Object;", "LK6/O;", "u", "(LK6/O;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/agentframework/adapter/netcore/B;", "n", "(Lcom/stepos/agentframework/adapter/netcore/B;)V", "y", "LK6/M;", "Lkotlin/Function5;", "", "", "onProgress", "o", "(Landroid/content/Context;LK6/M;Lp9/s;Le9/c;)Ljava/lang/Object;", "fileUri", "mime", DidiCardProvider.KEY_TRACE_ID, "N", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "LK6/b;", "LK6/a;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(LK6/b;Le9/c;)Ljava/lang/Object;", "isAvailable", "b0", "(Z)V", "LK6/G;", "f", "(LK6/G;Le9/c;)Ljava/lang/Object;", "LK6/E;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LK6/E;Le9/c;)Ljava/lang/Object;", "LK6/F;", "e", "(LK6/F;Le9/c;)Ljava/lang/Object;", "LK6/H;", Const.INTENT_KEY_APIKEY, "(LK6/H;Le9/c;)Ljava/lang/Object;", "sessionId", "inquiryId", "", "answers", "Lcom/stepos/agentframework/adapter/netcore/q;", "k", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Le9/c;)Ljava/lang/Object;", "LK6/I;", "l", "(LK6/I;Le9/c;)Ljava/lang/Object;", "LK6/C;", "LK6/D;", "K", "(LK6/C;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "a0", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "reason", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "L", "title", ExifInterface.LONGITUDE_WEST, "m", "(Le9/c;)Ljava/lang/Object;", "agent", "deviceId", "Q", "agentId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "type", "I", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_PKGNAME, "LK6/J;", "LK6/K;", Const.INTENT_KEY_UMID, "(LK6/J;Le9/c;)Ljava/lang/Object;", "requestId", "decision", "askUserQuestion", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "getType", "()Lcom/stepos/agentframework/adapter/netcore/ApiType;", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface o {
    static /* synthetic */ Object F(o oVar, TaskCancelRequest taskCancelRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C4109a.a(false);
    }

    static /* synthetic */ Object G(o oVar, TaskInteractRequest taskInteractRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C4109a.a(false);
    }

    static /* synthetic */ Object H(o oVar, String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return oVar.m(interfaceC4014c);
    }

    static /* synthetic */ Object J(o oVar, InterfaceC4014c<? super String> interfaceC4014c) {
        return null;
    }

    static /* synthetic */ Object M(o oVar, String str, String str2, String str3, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C4109a.a(true);
    }

    static /* synthetic */ Object O(o oVar, TaskDeleteRequest taskDeleteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C4109a.a(false);
    }

    static /* synthetic */ Object P(o oVar, String str, String str2, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C4109a.a(false);
    }

    static /* synthetic */ Object R(o oVar, String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return null;
    }

    static /* synthetic */ Object S(o oVar, TaskBatchDeleteRequest taskBatchDeleteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C4109a.a(false);
    }

    static /* synthetic */ Object U(o oVar, String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return oVar.i(interfaceC4014c);
    }

    static /* synthetic */ Object V(o oVar, String str, String str2, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: abortSession");
        }
        if ((i10 & 2) != 0) {
            str2 = "user.abort";
        }
        return oVar.T(str, str2, interfaceC4014c);
    }

    static /* synthetic */ Object X(o oVar, InterfaceC4014c<? super String> interfaceC4014c) {
        return null;
    }

    static /* synthetic */ Object Y(o oVar, String str, String str2, List<String> list, InterfaceC4014c<? super InquiryAnswerResult> interfaceC4014c) {
        return new InquiryAnswerResult(false, null, 2, null);
    }

    static /* synthetic */ Object c0(o oVar, String str, String str2, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return Y8.t.f7040a;
    }

    static /* synthetic */ Object d0(o oVar, FeedbackRequest feedbackRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C4109a.a(false);
    }

    static /* synthetic */ Object e0(o oVar, String str, String str2, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return Y8.t.f7040a;
    }

    static /* synthetic */ Object f0(o oVar, TranscriptAppendRequest transcriptAppendRequest, InterfaceC4014c<? super TranscriptAppendResult> interfaceC4014c) {
        return new TranscriptAppendResult(false, 0, 0, null, null, null, "unsupported", null, com.stepos.ailauncher.chat.wake.circle.F.GESTURE_WIDTH_DP, null);
    }

    static /* synthetic */ Object g0(o oVar, AgentDetailRequest agentDetailRequest, InterfaceC4014c<? super C0905a> interfaceC4014c) {
        return null;
    }

    static /* synthetic */ Object h0(o oVar, Context context, UploadFileRequest uploadFileRequest, p9.s<? super Integer, ? super Boolean, ? super String, ? super String, ? super Long, Y8.t> sVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return Y8.t.f7040a;
    }

    static /* synthetic */ Object p(o oVar, VoteRequest voteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C4109a.a(false);
    }

    static /* synthetic */ Object q(o oVar, String str, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C4109a.a(false);
    }

    static /* synthetic */ Object s(o oVar, String str, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return Y8.t.f7040a;
    }

    static /* synthetic */ Object t(o oVar, C0918n c0918n, String str, h hVar, InterfaceC4014c<? super n> interfaceC4014c) {
        return null;
    }

    static /* synthetic */ Object v(o oVar, SyncHistoryRequest syncHistoryRequest, InterfaceC4014c<? super SyncHistoryResult> interfaceC4014c) {
        return new SyncHistoryResult(null, false, null, null, 15, null);
    }

    static /* synthetic */ Object w(o oVar, String str, String str2, InterfaceC4014c<? super String> interfaceC4014c) {
        return oVar.m(interfaceC4014c);
    }

    static /* synthetic */ Object x(o oVar, String str, String str2, String str3, String str4, String str5, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C4109a.a(false);
    }

    static /* synthetic */ Object z(o oVar, TaskSyncRemoteRequest taskSyncRemoteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C4109a.a(false);
    }

    default Object A(AgentDetailRequest agentDetailRequest, InterfaceC4014c<? super C0905a> interfaceC4014c) {
        return g0(this, agentDetailRequest, interfaceC4014c);
    }

    default Object B(C0918n c0918n, String str, h hVar, InterfaceC4014c<? super n> interfaceC4014c) {
        return t(this, c0918n, str, hVar, interfaceC4014c);
    }

    default Object C(FeedbackRequest feedbackRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return d0(this, feedbackRequest, interfaceC4014c);
    }

    default boolean D() {
        return false;
    }

    Object E(C0918n c0918n, h hVar, InterfaceC4014c<? super n> interfaceC4014c);

    default Object I(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return R(this, str, interfaceC4014c);
    }

    default Object K(SyncHistoryRequest syncHistoryRequest, InterfaceC4014c<? super SyncHistoryResult> interfaceC4014c) {
        return v(this, syncHistoryRequest, interfaceC4014c);
    }

    default Object L(String str, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return s(this, str, interfaceC4014c);
    }

    default Object N(String str, String str2, String str3, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return M(this, str, str2, str3, interfaceC4014c);
    }

    default Object Q(String str, String str2, InterfaceC4014c<? super String> interfaceC4014c) {
        return w(this, str, str2, interfaceC4014c);
    }

    default Object T(String str, String str2, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return e0(this, str, str2, interfaceC4014c);
    }

    default Object W(String str, String str2, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return c0(this, str, str2, interfaceC4014c);
    }

    default Object Z(String str, String str2, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return P(this, str, str2, interfaceC4014c);
    }

    default Object a(TaskInteractRequest taskInteractRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return G(this, taskInteractRequest, interfaceC4014c);
    }

    default Object a0(String str, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return q(this, str, interfaceC4014c);
    }

    default Object b(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return U(this, str, interfaceC4014c);
    }

    default void b0(boolean isAvailable) {
    }

    default Object c(String str, String str2, String str3, String str4, String str5, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return x(this, str, str2, str3, str4, str5, interfaceC4014c);
    }

    default Object d(TranscriptAppendRequest transcriptAppendRequest, InterfaceC4014c<? super TranscriptAppendResult> interfaceC4014c) {
        return f0(this, transcriptAppendRequest, interfaceC4014c);
    }

    default Object e(TaskCancelRequest taskCancelRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return F(this, taskCancelRequest, interfaceC4014c);
    }

    default Object f(TaskDeleteRequest taskDeleteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return O(this, taskDeleteRequest, interfaceC4014c);
    }

    default Object g(TaskBatchDeleteRequest taskBatchDeleteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return S(this, taskBatchDeleteRequest, interfaceC4014c);
    }

    ApiType getType();

    default boolean h() {
        return true;
    }

    default Object i(InterfaceC4014c<? super String> interfaceC4014c) {
        return X(this, interfaceC4014c);
    }

    default Object j(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return H(this, str, interfaceC4014c);
    }

    default Object k(String str, String str2, List<String> list, InterfaceC4014c<? super InquiryAnswerResult> interfaceC4014c) {
        return Y(this, str, str2, list, interfaceC4014c);
    }

    default Object l(TaskSyncRemoteRequest taskSyncRemoteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return z(this, taskSyncRemoteRequest, interfaceC4014c);
    }

    default Object m(InterfaceC4014c<? super String> interfaceC4014c) {
        return J(this, interfaceC4014c);
    }

    default void n(B listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
    }

    default Object o(Context context, UploadFileRequest uploadFileRequest, p9.s<? super Integer, ? super Boolean, ? super String, ? super String, ? super Long, Y8.t> sVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return h0(this, context, uploadFileRequest, sVar, interfaceC4014c);
    }

    default void r(Context context, p logger) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(logger, "logger");
    }

    default Object u(VoteRequest voteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return p(this, voteRequest, interfaceC4014c);
    }

    default void y(B listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
    }
}
