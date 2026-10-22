package com.stepos.agentframework.adapter.agentspace;

import Ua.C1056g;
import Ua.Y;
import Y8.t;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.adapter.netcore.B;
import com.stepos.agentframework.adapter.netcore.InquiryAnswerResult;
import com.stepos.agentframework.adapter.netcore.h;
import com.stepos.agentframework.adapter.netcore.n;
import com.stepos.agentframework.adapter.netcore.o;
import com.stepos.agentframework.adapter.netcore.p;
import com.stepos.agentframework.adapter.netcore.s;
import e9.InterfaceC4014c;
import java.util.List;
import java.util.concurrent.TimeUnit;
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
import tb.x;
import tb.z;
import v9.C5685n;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0086@¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u00198\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/stepos/agentframework/adapter/agentspace/AgentSpaceCoreAgentClient;", "Lcom/stepos/agentframework/adapter/netcore/o;", "", "timeOutSeconds", "<init>", "(J)V", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/adapter/netcore/p;", "logger", "LY8/t;", "r", "(Landroid/content/Context;Lcom/stepos/agentframework/adapter/netcore/p;)V", "LK6/n;", "request", "Lcom/stepos/agentframework/adapter/netcore/h;", "listener", "Lcom/stepos/agentframework/adapter/netcore/n;", ExifInterface.LONGITUDE_EAST, "(LK6/n;Lcom/stepos/agentframework/adapter/netcore/h;Le9/c;)Ljava/lang/Object;", "", "", "n0", "(Le9/c;)Ljava/lang/Object;", "J", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "type", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "getType", "()Lcom/stepos/agentframework/adapter/netcore/ApiType;", "Lcom/stepos/agentframework/adapter/netcore/p;", "appContext", "Landroid/content/Context;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "bearerToken", "Ljava/lang/String;", "Ltb/z;", "okHttpClient", "Ltb/z;", "Companion", Const.INTENT_KEY_APIKEY, "business_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentSpaceCoreAgentClient implements o {
    public static final String CONFIG_QUERY_PATH = "dictionary/api/v1/get/key";
    private static final x JSON_MEDIA = x.INSTANCE.a("application/json; charset=utf-8");
    private static final String TAG = "AgentSpaceCoreAgentClient";
    public static final String VOTE_ACTION_PATH = "task-engine/vote/action";
    private Context appContext;
    private volatile String bearerToken;
    private z okHttpClient;
    private final long timeOutSeconds;
    private final ApiType type = ApiType.AGENT_SPACE;
    private p logger = s.INSTANCE;
    private final Gson gson = new Gson();

    public AgentSpaceCoreAgentClient(long j10) {
        this.timeOutSeconds = j10;
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object A(AgentDetailRequest agentDetailRequest, InterfaceC4014c<? super C0905a> interfaceC4014c) {
        return super.A(agentDetailRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object B(C0918n c0918n, String str, h hVar, InterfaceC4014c<? super n> interfaceC4014c) {
        return super.B(c0918n, str, hVar, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object C(FeedbackRequest feedbackRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.C(feedbackRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ boolean D() {
        return super.D();
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public Object E(C0918n c0918n, h hVar, InterfaceC4014c<? super n> interfaceC4014c) {
        return null;
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object I(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return super.I(str, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object K(SyncHistoryRequest syncHistoryRequest, InterfaceC4014c<? super SyncHistoryResult> interfaceC4014c) {
        return super.K(syncHistoryRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object L(String str, InterfaceC4014c<? super t> interfaceC4014c) {
        return super.L(str, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object N(String str, String str2, String str3, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.N(str, str2, str3, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object Q(String str, String str2, InterfaceC4014c<? super String> interfaceC4014c) {
        return super.Q(str, str2, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object T(String str, String str2, InterfaceC4014c<? super t> interfaceC4014c) {
        return super.T(str, str2, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object W(String str, String str2, InterfaceC4014c<? super t> interfaceC4014c) {
        return super.W(str, str2, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object Z(String str, String str2, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.Z(str, str2, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object a(TaskInteractRequest taskInteractRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.a(taskInteractRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object a0(String str, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.a0(str, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object b(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return super.b(str, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ void b0(boolean z10) {
        super.b0(z10);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object c(String str, String str2, String str3, String str4, String str5, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.c(str, str2, str3, str4, str5, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object d(TranscriptAppendRequest transcriptAppendRequest, InterfaceC4014c<? super TranscriptAppendResult> interfaceC4014c) {
        return super.d(transcriptAppendRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object e(TaskCancelRequest taskCancelRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.e(taskCancelRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object f(TaskDeleteRequest taskDeleteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.f(taskDeleteRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object g(TaskBatchDeleteRequest taskBatchDeleteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.g(taskBatchDeleteRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public ApiType getType() {
        return this.type;
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ boolean h() {
        return super.h();
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object i(InterfaceC4014c<? super String> interfaceC4014c) {
        return super.i(interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object j(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return super.j(str, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object k(String str, String str2, List<String> list, InterfaceC4014c<? super InquiryAnswerResult> interfaceC4014c) {
        return super.k(str, str2, list, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object l(TaskSyncRemoteRequest taskSyncRemoteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.l(taskSyncRemoteRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object m(InterfaceC4014c<? super String> interfaceC4014c) {
        return super.m(interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ void n(B b10) {
        super.n(b10);
    }

    public final Object n0(InterfaceC4014c<? super List<String>> interfaceC4014c) {
        return C1056g.j(Y.b(), new AgentSpaceCoreAgentClient$fetchFeedbackDislikeReasons$2(this, null), interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object o(Context context, UploadFileRequest uploadFileRequest, p9.s<? super Integer, ? super Boolean, ? super String, ? super String, ? super Long, t> sVar, InterfaceC4014c<? super t> interfaceC4014c) {
        return super.o(context, uploadFileRequest, sVar, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public void r(Context context, p logger) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(logger, "logger");
        this.logger = logger;
        this.appContext = context.getApplicationContext();
        long jG = C5685n.g(this.timeOutSeconds, 1L);
        z.a aVar = new z.a();
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
        z.a aVarA = aVar.a(new a(applicationContext));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.okHttpClient = aVarA.g(jG, timeUnit).T(jG, timeUnit).W(jG, timeUnit).U(true).d();
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object u(VoteRequest voteRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.u(voteRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ void y(B b10) {
        super.y(b10);
    }
}
