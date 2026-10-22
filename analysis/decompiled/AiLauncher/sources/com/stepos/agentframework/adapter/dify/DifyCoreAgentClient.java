package com.stepos.agentframework.adapter.dify;

import Ua.C1060i;
import Ua.C1073o0;
import Ua.Y;
import Y8.t;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.agentframework.adapter.dify.bean.Event;
import com.stepos.agentframework.adapter.dify.c;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.adapter.netcore.B;
import com.stepos.agentframework.adapter.netcore.InquiryAnswerResult;
import com.stepos.agentframework.adapter.netcore.h;
import com.stepos.agentframework.adapter.netcore.i;
import com.stepos.agentframework.adapter.netcore.n;
import com.stepos.agentframework.adapter.netcore.o;
import com.stepos.agentframework.adapter.netcore.s;
import e9.InterfaceC4014c;
import f9.C4063a;
import j4.ErrorResult;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k4.InterfaceC4813a;
import kotlin.AgentDetailRequest;
import kotlin.C0905a;
import kotlin.C0914j;
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
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.p;
import tb.C5530C;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0096@¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0018H\u0096@¢\u0006\u0004\b\u001a\u0010\u001bJP\u0010!\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u001c2.\u0010 \u001a*\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\b0\u001dH\u0096@¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\u0012\u001a\u00020#H\u0096@¢\u0006\u0004\b%\u0010&R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010'R\u001a\u0010)\u001a\u00020(8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R \u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060.0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/stepos/agentframework/adapter/dify/DifyCoreAgentClient;", "Lcom/stepos/agentframework/adapter/netcore/o;", "", "timeOut", "<init>", "(J)V", "Lcom/stepos/agentframework/adapter/netcore/i;", "eventSourceState", "LY8/t;", "i0", "(Lcom/stepos/agentframework/adapter/netcore/i;)V", "Landroid/content/Context;", "context", "Lcom/stepos/agentframework/adapter/netcore/p;", "logger", "r", "(Landroid/content/Context;Lcom/stepos/agentframework/adapter/netcore/p;)V", "LK6/n;", "request", "Lcom/stepos/agentframework/adapter/netcore/h;", "listener", "Lcom/stepos/agentframework/adapter/netcore/n;", ExifInterface.LONGITUDE_EAST, "(LK6/n;Lcom/stepos/agentframework/adapter/netcore/h;Le9/c;)Ljava/lang/Object;", "LK6/s;", "", "C", "(LK6/s;Le9/c;)Ljava/lang/Object;", "LK6/M;", "Lkotlin/Function5;", "", "", "onProgress", "o", "(Landroid/content/Context;LK6/M;Lp9/s;Le9/c;)Ljava/lang/Object;", "LK6/b;", "LK6/a;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(LK6/b;Le9/c;)Ljava/lang/Object;", "J", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "type", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "getType", "()Lcom/stepos/agentframework/adapter/netcore/ApiType;", "", "Ljava/lang/ref/WeakReference;", "eventSourceStates", "Ljava/util/Set;", "protocol_dify_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DifyCoreAgentClient implements o {
    private final long timeOut;
    private final ApiType type = ApiType.DIFY;
    private final Set<WeakReference<i>> eventSourceStates = new LinkedHashSet();

    public DifyCoreAgentClient(long j10) {
        this.timeOut = j10;
    }

    private final void i0(i eventSourceState) {
        this.eventSourceStates.add(new WeakReference<>(eventSourceState));
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public Object A(AgentDetailRequest agentDetailRequest, InterfaceC4014c<? super C0905a> interfaceC4014c) {
        return super.A(agentDetailRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object B(C0918n c0918n, String str, h hVar, InterfaceC4014c<? super n> interfaceC4014c) {
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

    @Override // com.stepos.agentframework.adapter.netcore.o
    public Object E(final C0918n c0918n, final h hVar, InterfaceC4014c<? super n> interfaceC4014c) {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        c cVarA = c.INSTANCE.a();
        String agentId = c0918n.getAgentId();
        Map<String, String> mapM = c0918n.m();
        String strB = C0914j.b(c0918n.j());
        if (strB == null) {
            strB = "";
        }
        String conversationId = c0918n.getConversationId();
        if (conversationId == null) {
            conversationId = "";
        }
        i iVar = new i(c.m(cVarA, agentId, mapM, strB, conversationId, null, new InterfaceC4813a() { // from class: com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1
            private String _conversationId = "";

            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final /* synthetic */ class a {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Event.values().length];
                    try {
                        iArr[Event.MESSAGE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Event.AGENT_MESSAGE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Event.MESSAGE_END.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[Event.MESSAGE_REPLACE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // k4.InterfaceC4813a
            public void a(Kb.a eventSource, Object tag) {
                p.i(eventSource, "eventSource");
                s sVar = s.INSTANCE;
                String str = ref$ObjectRef.f34820a;
                sVar.g("onClosed " + ((Object) str) + "  " + Thread.currentThread());
                C1060i.d(C1073o0.f6391a, Y.c(), null, new DifyCoreAgentClient$chat$eventSource$1$onClosed$1(c0918n, ref$ObjectRef, ref$ObjectRef2, hVar, null), 2, null);
            }

            @Override // k4.InterfaceC4813a
            public void b(Kb.a eventSource, C5530C response, Object tag) {
                p.i(eventSource, "eventSource");
                p.i(response, "response");
                s.INSTANCE.g("onOpen");
                hVar.f(c0918n);
            }

            @Override // k4.InterfaceC4813a
            public void d(Kb.a eventSource, ErrorResult errorResult, C5530C response, Object tag) {
                p.i(eventSource, "eventSource");
                p.i(errorResult, "errorResult");
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:36:0x0074  */
            /* JADX WARN: Type inference failed for: r5v0, types: [K6.m, T] */
            @Override // k4.InterfaceC4813a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void e(Kb.a r56, j4.ChatEventData r57, java.lang.String r58, java.lang.String r59, java.lang.Object r60, java.lang.String r61) {
                /*
                    Method dump skipped, instructions count: 245
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.dify.DifyCoreAgentClient$chat$eventSource$1.e(Kb.a, j4.a, java.lang.String, java.lang.String, java.lang.Object, java.lang.String):void");
            }
        }, 16, null));
        i0(iVar);
        return iVar;
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

    @Override // com.stepos.agentframework.adapter.netcore.o
    public Object o(Context context, UploadFileRequest uploadFileRequest, p9.s<? super Integer, ? super Boolean, ? super String, ? super String, ? super Long, t> sVar, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objO = super.o(context, uploadFileRequest, sVar, interfaceC4014c);
        return objO == C4063a.g() ? objO : t.f7040a;
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public void r(Context context, com.stepos.agentframework.adapter.netcore.p logger) {
        p.i(context, "context");
        p.i(logger, "logger");
        c.Companion companion = c.INSTANCE;
        companion.a().i(context, this.timeOut, companion.b());
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
