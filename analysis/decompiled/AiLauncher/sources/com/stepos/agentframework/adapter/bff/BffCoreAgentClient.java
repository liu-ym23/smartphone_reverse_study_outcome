package com.stepos.agentframework.adapter.bff;

import android.content.Context;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.adapter.netcore.B;
import com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper;
import com.stepos.agentframework.adapter.netcore.InquiryAnswerResult;
import com.zyql.protobuf.connection.StreamMsg;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.AgentDetailRequest;
import kotlin.C0905a;
import kotlin.C0917m;
import kotlin.C0918n;
import kotlin.C4848b;
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
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\u00020\u0001:\u0001BB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u0014H\u0096@¢\u0006\u0004\b\u0016\u0010\u0017JP\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00182.\u0010\u001c\u001a*\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\n0\u0019H\u0096@¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u000e\u001a\u00020\u001fH\u0096@¢\u0006\u0004\b!\u0010\"J\u0018\u0010$\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020#H\u0096@¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0015H\u0016¢\u0006\u0004\b'\u0010(R\u001a\u0010*\u001a\u00020)8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u00103Rl\u00109\u001aZ\u0012\f\u0012\n 5*\u0004\u0018\u00010\u000f0\u000f\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000207 5*\n\u0012\u0004\u0012\u000207\u0018\u00010606 5*,\u0012\f\u0012\n 5*\u0004\u0018\u00010\u000f0\u000f\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000207 5*\n\u0012\u0004\u0012\u000207\u0018\u00010606\u0018\u000108048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020;8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?¨\u0006C"}, d2 = {"Lcom/stepos/agentframework/adapter/bff/BffCoreAgentClient;", "Lcom/stepos/agentframework/adapter/netcore/o;", "", "timeOut", "<init>", "(J)V", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/adapter/netcore/p;", com.stepos.statsapp.v3.lib.plugin.events.b.f30786f, "LY8/t;", "r", "(Landroid/content/Context;Lcom/stepos/agentframework/adapter/netcore/p;)V", "LK6/n;", "request", "Lcom/stepos/agentframework/adapter/netcore/h;", "listener", "Lcom/stepos/agentframework/adapter/netcore/n;", ExifInterface.LONGITUDE_EAST, "(LK6/n;Lcom/stepos/agentframework/adapter/netcore/h;Le9/c;)Ljava/lang/Object;", "LK6/s;", "", "C", "(LK6/s;Le9/c;)Ljava/lang/Object;", "LK6/M;", "Lkotlin/Function5;", "", "", "onProgress", "o", "(Landroid/content/Context;LK6/M;Lp9/s;Le9/c;)Ljava/lang/Object;", "LK6/b;", "LK6/a;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(LK6/b;Le9/c;)Ljava/lang/Object;", "LK6/O;", "u", "(LK6/O;Le9/c;)Ljava/lang/Object;", "isAvailable", "b0", "(Z)V", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "type", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "getType", "()Lcom/stepos/agentframework/adapter/netcore/ApiType;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "logger", "Lcom/stepos/agentframework/adapter/netcore/p;", "Landroid/content/Context;", "", "kotlin.jvm.PlatformType", "", "Lcom/stepos/agentframework/adapter/bff/p;", "", "lifecycleGuardMap", "Ljava/util/Map;", "Lcom/stepos/agentframework/adapter/bff/BffClient;", "internalClient$delegate", "LY8/h;", "j0", "()Lcom/stepos/agentframework/adapter/bff/BffClient;", "internalClient", "Companion", Const.INTENT_KEY_APIKEY, "protocol_bff_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BffCoreAgentClient implements com.stepos.agentframework.adapter.netcore.o {
    private static final String TAG = " [BffCoreAgentClient] ";
    private Context context;
    private final ApiType type = ApiType.BFF;
    private final Gson gson = new Gson();
    private com.stepos.agentframework.adapter.netcore.p logger = com.stepos.agentframework.adapter.netcore.s.INSTANCE;
    private final Map<com.stepos.agentframework.adapter.netcore.h, List<p>> lifecycleGuardMap = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: internalClient$delegate, reason: from kotlin metadata */
    private final Y8.h internalClient = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.adapter.bff.j
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return BffCoreAgentClient.k0(this.f22351a);
        }
    });

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/stepos/agentframework/adapter/bff/BffCoreAgentClient$b", "Lcom/stepos/agentframework/adapter/bff/p;", "", "sendId", "LK6/m;", "chatReplyInfo", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;LK6/m;)V", "", "code", "reason", "onError", "(Ljava/lang/String;ILjava/lang/String;)V", "protocol_bff_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements p {
        final /* synthetic */ com.stepos.agentframework.adapter.netcore.h $listener;
        final /* synthetic */ C0918n $request;

        public b(C0918n c0918n, com.stepos.agentframework.adapter.netcore.h hVar) {
            this.$request = c0918n;
            this.$listener = hVar;
        }

        @Override // com.stepos.agentframework.adapter.bff.p
        public void a(String sendId, C0917m chatReplyInfo) {
            kotlin.jvm.internal.p.i(sendId, "sendId");
            kotlin.jvm.internal.p.i(chatReplyInfo, "chatReplyInfo");
            chatReplyInfo.d(this.$request.getAgentId());
            this.$listener.g(this.$request, chatReplyInfo);
        }

        @Override // com.stepos.agentframework.adapter.bff.p
        public /* bridge */ boolean b(String str, StreamMsg streamMsg) {
            return super.b(str, streamMsg);
        }

        @Override // com.stepos.agentframework.adapter.bff.p
        public void onError(String sendId, int code, String reason) {
            kotlin.jvm.internal.p.i(sendId, "sendId");
            this.$listener.b(this.$request, Integer.valueOf(code), reason);
        }
    }

    public BffCoreAgentClient(long j10) {
    }

    public static final BffClient k0(BffCoreAgentClient bffCoreAgentClient) {
        String strB = C4.a.INSTANCE.a(bffCoreAgentClient.context).b();
        Context context = bffCoreAgentClient.context;
        kotlin.jvm.internal.p.f(context);
        String strB2 = K7.c.b(context.getApplicationContext());
        if (strB2 == null) {
            strB2 = "";
        }
        return new BffClient(new Option(strB, strB2, new AuthInfo(M5.b.CREDENTIAL_TOKEN, "uid", null, null, 0, null, null, null, null, null, 1020, null), null, null, true, false, 0L, false, 472, null));
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public Object A(AgentDetailRequest agentDetailRequest, InterfaceC4014c<? super C0905a> interfaceC4014c) {
        return super.A(agentDetailRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object B(C0918n c0918n, String str, com.stepos.agentframework.adapter.netcore.h hVar, InterfaceC4014c<? super com.stepos.agentframework.adapter.netcore.n> interfaceC4014c) {
        return super.B(c0918n, str, hVar, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public Object C(FeedbackRequest feedbackRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.C(feedbackRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ boolean D() {
        return super.D();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011d  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object E(kotlin.C0918n r13, com.stepos.agentframework.adapter.netcore.h r14, e9.InterfaceC4014c<? super com.stepos.agentframework.adapter.netcore.n> r15) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.bff.BffCoreAgentClient.E(K6.n, com.stepos.agentframework.adapter.netcore.h, e9.c):java.lang.Object");
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
    public /* bridge */ Object L(String str, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
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
    public /* bridge */ Object T(String str, String str2, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return super.T(str, str2, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object W(String str, String str2, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
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
    public void b0(boolean isAvailable) {
        j0().S(isAvailable);
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

    public final BffClient j0() {
        return (BffClient) this.internalClient.getValue();
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

    @Override // com.stepos.agentframework.adapter.netcore.o
    public Object o(Context context, UploadFileRequest uploadFileRequest, p9.s<? super Integer, ? super Boolean, ? super String, ? super String, ? super Long, Y8.t> sVar, InterfaceC4014c<? super Y8.t> interfaceC4014c) throws Throwable {
        if (uploadFileRequest.getFile() != null) {
            FileStorageUploadHelper fileStorageUploadHelper = FileStorageUploadHelper.INSTANCE;
            File file = uploadFileRequest.getFile();
            kotlin.jvm.internal.p.f(file);
            Object objL = fileStorageUploadHelper.l(context, file, sVar, interfaceC4014c);
            return objL == C4063a.g() ? objL : Y8.t.f7040a;
        }
        if (uploadFileRequest.getUri() == null) {
            throw new IllegalArgumentException("No file or uri provided");
        }
        FileStorageUploadHelper fileStorageUploadHelper2 = FileStorageUploadHelper.INSTANCE;
        Uri uri = uploadFileRequest.getUri();
        kotlin.jvm.internal.p.f(uri);
        Object objN = fileStorageUploadHelper2.n(context, uri, sVar, interfaceC4014c);
        return objN == C4063a.g() ? objN : Y8.t.f7040a;
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public void r(Context context, com.stepos.agentframework.adapter.netcore.p log) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(log, "log");
        this.context = context;
        this.logger = log;
        j0().L();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object u(kotlin.VoteRequest r17, e9.InterfaceC4014c<? super java.lang.Boolean> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.bff.BffCoreAgentClient.u(K6.O, e9.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ void y(B b10) {
        super.y(b10);
    }
}
