package com.stepos.agentframework.adapter.coze;

import La.H;
import Y8.t;
import Z8.C1172u;
import Z8.C1173v;
import android.content.Context;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.stepos.agentframework.adapter.coze.CozeClient;
import com.stepos.agentframework.adapter.coze.bean.Type;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.adapter.netcore.B;
import com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper;
import com.stepos.agentframework.adapter.netcore.InquiryAnswerResult;
import com.stepos.agentframework.adapter.netcore.h;
import com.stepos.agentframework.adapter.netcore.i;
import com.stepos.agentframework.adapter.netcore.n;
import com.stepos.agentframework.adapter.netcore.o;
import com.stepos.common.FunctionCall;
import com.stepos.common.MetaData;
import com.stepos.common.RequiredAction;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g4.C4102g;
import g4.ChatEventData;
import g4.ErrorResult;
import h4.InterfaceC4143a;
import h8.C4148a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.AbstractC0913i;
import kotlin.C0917m;
import kotlin.C0918n;
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
import kotlin.jvm.internal.p;
import p9.q;
import p9.s;
import tb.C5530C;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ;2\u00020\u0001:\u0001<B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005JP\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2.\u0010\u000f\u001a*\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u000e0\nH\u0082@¢\u0006\u0004\b\u0010\u0010\u0011JP\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2.\u0010\u000f\u001a*\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u000e0\nH\u0082@¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\"\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\t\u001a\u00020 2\u0006\u0010\"\u001a\u00020!H\u0096@¢\u0006\u0004\b$\u0010%J\u0018\u0010'\u001a\u00020\f2\u0006\u0010\t\u001a\u00020&H\u0096@¢\u0006\u0004\b'\u0010(JP\u0010)\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2.\u0010\u000f\u001a*\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u000e0\nH\u0096@¢\u0006\u0004\b)\u0010\u0011J\u001a\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010\t\u001a\u00020*H\u0096@¢\u0006\u0004\b,\u0010-R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010.R\u001a\u00100\u001a\u00020/8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R \u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001308078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/stepos/agentframework/adapter/coze/CozeCoreAgentClient;", "Lcom/stepos/agentframework/adapter/netcore/o;", "", "timeOut", "<init>", "(J)V", "Landroid/content/Context;", "context", "LK6/M;", "request", "Lkotlin/Function5;", "", "", "", "LY8/t;", "onProgress", "o0", "(Landroid/content/Context;LK6/M;Lp9/s;Le9/c;)Ljava/lang/Object;", "r0", "Lcom/stepos/agentframework/adapter/netcore/i;", "eventSourceState", "m0", "(Lcom/stepos/agentframework/adapter/netcore/i;)V", "text", "", "LK6/i;", "n0", "(Ljava/lang/String;)Ljava/util/List;", "Lcom/stepos/agentframework/adapter/netcore/p;", "logger", "r", "(Landroid/content/Context;Lcom/stepos/agentframework/adapter/netcore/p;)V", "LK6/n;", "Lcom/stepos/agentframework/adapter/netcore/h;", "listener", "Lcom/stepos/agentframework/adapter/netcore/n;", ExifInterface.LONGITUDE_EAST, "(LK6/n;Lcom/stepos/agentframework/adapter/netcore/h;Le9/c;)Ljava/lang/Object;", "LK6/s;", "C", "(LK6/s;Le9/c;)Ljava/lang/Object;", "o", "LK6/b;", "LK6/a;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(LK6/b;Le9/c;)Ljava/lang/Object;", "J", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "type", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "getType", "()Lcom/stepos/agentframework/adapter/netcore/ApiType;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "", "Ljava/lang/ref/WeakReference;", "eventSourceStates", "Ljava/util/Set;", "Companion", Const.INTENT_KEY_APIKEY, "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CozeCoreAgentClient implements o {
    private static final String TAG = "CozeCoreAgentClient";
    private final long timeOut;
    private final ApiType type = ApiType.COZE;
    private final Gson gson = new Gson();
    private final Set<WeakReference<i>> eventSourceStates = new LinkedHashSet();

    @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJG\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001e¨\u0006\""}, d2 = {"com/stepos/agentframework/adapter/coze/CozeCoreAgentClient$b", "Lh4/a;", "LKb/a;", com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30739f, "Ltb/C;", UxipConstants.f30685x, "", "tag", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(LKb/a;Ltb/C;Ljava/lang/Object;)V", "Lg4/b;", com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30740g, "", "type", "data", "conversationId", "c", "(LKb/a;Lg4/b;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "(LKb/a;Ljava/lang/Object;)V", "Lg4/f;", "errorResult", Const.INTENT_KEY_UMID, "(LKb/a;Lg4/f;Ltb/C;Ljava/lang/Object;)V", "_conversationId", "Ljava/lang/String;", "get_conversationId", "()Ljava/lang/String;", "set_conversationId", "(Ljava/lang/String;)V", "viewSpliteId", "getViewSpliteId", "setViewSpliteId", "protocol_coze_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements InterfaceC4143a {
        final /* synthetic */ h $listener;
        final /* synthetic */ C0918n $request;
        private String _conversationId = "";
        final /* synthetic */ CozeCoreAgentClient this$0;
        private String viewSpliteId;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Type.values().length];
                try {
                    iArr[Type.FUNCTION_CALL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Type.TOOL_RESPONSE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public b(h hVar, C0918n c0918n, CozeCoreAgentClient cozeCoreAgentClient) {
            this.$listener = hVar;
            this.$request = c0918n;
            this.this$0 = cozeCoreAgentClient;
        }

        @Override // h4.InterfaceC4143a
        public void a(Kb.a eventSource, Object tag) {
            p.i(eventSource, "eventSource");
            C4148a.k(CozeCoreAgentClient.TAG, "onClosed  " + Thread.currentThread(), false, 4, null);
            this.$listener.j(this.$request);
        }

        @Override // h4.InterfaceC4143a
        public void b(Kb.a eventSource, C5530C response, Object tag) {
            p.i(eventSource, "eventSource");
            p.i(response, "response");
            C4148a.k(CozeCoreAgentClient.TAG, "onOpen", false, 4, null);
            this.$listener.f(this.$request);
        }

        @Override // h4.InterfaceC4143a
        public void c(Kb.a eventSource, ChatEventData eventData, String type, String data, Object tag, String conversationId) {
            RequiredAction requiredAction;
            FunctionCall functionCall;
            String content;
            Type type2;
            String conversationId2;
            p.i(eventSource, "eventSource");
            p.i(data, "data");
            if (eventData != null && (conversationId2 = eventData.getConversationId()) != null && (!H.x0(conversationId2))) {
                this._conversationId = eventData.getConversationId();
            }
            String agentId = this.$request.getAgentId();
            String secretkey = this.$request.getSecretkey();
            C4102g c4102g = C4102g.INSTANCE;
            int i10 = 0;
            if (!p.d(type, c4102g.g()) && !p.d(type, c4102g.f())) {
                if (p.d(type, c4102g.e())) {
                    i10 = 2;
                } else if (p.d(type, c4102g.a())) {
                    i10 = 1;
                }
            }
            String conversationId3 = eventData != null ? eventData.getConversationId() : null;
            String id = eventData != null ? eventData.getId() : null;
            int i11 = this.$request.get_id();
            String id2 = eventData != null ? eventData.getId() : null;
            ArrayList<String> arrayListG = eventData != null ? eventData.g() : null;
            String event = (eventData == null || (type2 = eventData.getType()) == null) ? null : type2.getEvent();
            try {
                requiredAction = (RequiredAction) this.this$0.gson.fromJson(this.this$0.gson.toJson(eventData != null ? eventData.getRequired_action() : null), RequiredAction.class);
            } catch (Exception e10) {
                e10.printStackTrace();
                requiredAction = null;
            }
            C0917m c0917m = new C0917m(null, "assistant", conversationId3, "text", 0, false, null, 0, null, 0L, 0, 0, false, agentId, secretkey, null, 3, false, null, 0, Integer.valueOf(i11), 0, null, Integer.valueOf(i10), null, null, "normal", arrayListG, null, id2, null, null, event, requiredAction, id, eventData != null ? eventData.getId() : null, eventData != null ? eventData.getReasoning_content() : null, eventData != null ? eventData.getMeta_data() : null, null, null, null, null, null, null, null, -747855887, 8128, null);
            Type type3 = eventData != null ? eventData.getType() : null;
            int i12 = type3 == null ? -1 : a.$EnumSwitchMapping$0[type3.ordinal()];
            String str = "";
            if (i12 == 1) {
                try {
                    Gson gson = this.this$0.gson;
                    String content2 = eventData.getContent();
                    if (content2 != null) {
                        str = content2;
                    }
                    functionCall = (FunctionCall) gson.fromJson(str, FunctionCall.class);
                } catch (Exception e11) {
                    e11.printStackTrace();
                    functionCall = null;
                }
                c0917m.R(functionCall);
                FunctionCall functionCall2 = c0917m.getFunctionCall();
                if (functionCall2 != null) {
                    MetaData meta_data = eventData.getMeta_data();
                    functionCall2.setToolId(meta_data != null ? meta_data.getCall_id() : null);
                }
            } else if (i12 != 2) {
                CozeCoreAgentClient cozeCoreAgentClient = this.this$0;
                if (eventData != null && (content = eventData.getContent()) != null) {
                    str = content;
                }
                c0917m.N(cozeCoreAgentClient.n0(str));
            } else {
                MetaData meta_data2 = eventData.getMeta_data();
                c0917m.R(new FunctionCall(null, null, null, null, null, null, null, null, null, null, meta_data2 != null ? meta_data2.getCall_id() : null, eventData.getContent(), false, null, 13311, null));
            }
            this.$listener.g(this.$request, c0917m);
        }

        @Override // h4.InterfaceC4143a
        public void d(Kb.a eventSource, ErrorResult errorResult, C5530C response, Object tag) {
            p.i(eventSource, "eventSource");
            p.i(errorResult, "errorResult");
            this.$listener.b(this.$request, -1, errorResult.getMessage());
        }
    }

    public CozeCoreAgentClient(long j10) {
        this.timeOut = j10;
    }

    public static final t p0(s sVar, int i10, boolean z10, String fileId) {
        p.i(fileId, "fileId");
        sVar.invoke(Integer.valueOf(i10), Boolean.valueOf(z10), fileId, null, null);
        return t.f7040a;
    }

    public static final t q0(s sVar, int i10, boolean z10, String fileId) {
        p.i(fileId, "fileId");
        sVar.invoke(Integer.valueOf(i10), Boolean.valueOf(z10), fileId, null, null);
        return t.f7040a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object A(kotlin.AgentDetailRequest r5, e9.InterfaceC4014c<? super kotlin.C0905a> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$getAgentDetail$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$getAgentDetail$1 r0 = (com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$getAgentDetail$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$getAgentDetail$1 r0 = new com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$getAgentDetail$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r4 = r0.result
            java.lang.Object r6 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            java.lang.Object r5 = r0.L$0
            K6.b r5 = (kotlin.AgentDetailRequest) r5
            kotlin.C4849c.b(r4)
            goto L55
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.C4849c.b(r4)
            com.stepos.agentframework.adapter.coze.CozeClient$a r4 = com.stepos.agentframework.adapter.coze.CozeClient.INSTANCE
            com.stepos.agentframework.adapter.coze.CozeClient r4 = r4.a()
            java.lang.String r1 = r5.getSecretKey()
            java.lang.String r3 = r5.getAgentId()
            java.lang.Object r5 = g9.h.a(r5)
            r0.L$0 = r5
            r0.label = r2
            java.lang.Object r4 = r4.g(r1, r3, r0)
            if (r4 != r6) goto L55
            return r6
        L55:
            com.stepos.agentframework.adapter.coze.bean.AgentDetailResult r4 = (com.stepos.agentframework.adapter.coze.bean.AgentDetailResult) r4
            com.stepos.agentframework.adapter.coze.bean.AgentDetailResult$Data r4 = r4.getData()
            K6.a r5 = new K6.a
            r5.<init>()
            java.lang.String r6 = r4.getName()
            r5.h(r6)
            java.lang.String r6 = r4.getBot_id()
            r5.f(r6)
            java.lang.String r6 = r4.getIcon_url()
            r5.g(r6)
            com.stepos.agentframework.adapter.coze.bean.AgentDetailResult$Data$OnboardingInfo r6 = r4.getOnboarding_info()
            r0 = 0
            if (r6 == 0) goto L81
            java.lang.String r6 = r6.getPrologue()
            goto L82
        L81:
            r6 = r0
        L82:
            r5.i(r6)
            com.stepos.agentframework.adapter.coze.bean.AgentDetailResult$Data$OnboardingInfo r6 = r4.getOnboarding_info()
            if (r6 == 0) goto L8f
            java.util.List r0 = r6.getSuggested_questions()
        L8f:
            r5.j(r0)
            com.stepos.agentframework.adapter.coze.bean.AgentDetailResult$Data$MediaConfig r4 = r4.getMedia_config()
            if (r4 == 0) goto L9d
            boolean r4 = r4.is_voice_call_closed()
            goto L9e
        L9d:
            r4 = 0
        L9e:
            r5.k(r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.coze.CozeCoreAgentClient.A(K6.b, e9.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object B(C0918n c0918n, String str, h hVar, InterfaceC4014c<? super n> interfaceC4014c) {
        return super.B(c0918n, str, hVar, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object C(kotlin.FeedbackRequest r9, e9.InterfaceC4014c<? super java.lang.Boolean> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$feedback$1
            if (r0 == 0) goto L14
            r0 = r10
            com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$feedback$1 r0 = (com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$feedback$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$feedback$1 r0 = new com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$feedback$1
            r0.<init>(r8, r10)
            goto L12
        L1a:
            java.lang.Object r8 = r6.result
            java.lang.Object r10 = f9.C4063a.g()
            int r0 = r6.label
            r7 = 1
            if (r0 == 0) goto L3b
            if (r0 != r7) goto L33
            java.lang.Object r9 = r6.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r9 = r6.L$0
            K6.s r9 = (kotlin.FeedbackRequest) r9
            kotlin.C4849c.b(r8)
            goto L72
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3b:
            kotlin.C4849c.b(r8)
            int r8 = r9.getVoteType()
            if (r8 != r7) goto L48
            java.lang.String r8 = "like"
        L46:
            r5 = r8
            goto L4b
        L48:
            java.lang.String r8 = "unlike"
            goto L46
        L4b:
            com.stepos.agentframework.adapter.coze.CozeClient$a r8 = com.stepos.agentframework.adapter.coze.CozeClient.INSTANCE
            com.stepos.agentframework.adapter.coze.CozeClient r1 = r8.a()
            java.lang.String r2 = r9.getSecretKey()
            java.lang.String r3 = r9.getConversationId()
            java.lang.String r4 = r9.getMessageId()
            java.lang.Object r8 = g9.h.a(r9)
            r6.L$0 = r8
            java.lang.Object r8 = g9.h.a(r5)
            r6.L$1 = r8
            r6.label = r7
            java.lang.Object r8 = r1.f(r2, r3, r4, r5, r6)
            if (r8 != r10) goto L72
            return r10
        L72:
            java.lang.Boolean r8 = g9.C4109a.a(r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.coze.CozeCoreAgentClient.C(K6.s, e9.c):java.lang.Object");
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ boolean D() {
        return super.D();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object E(kotlin.C0918n r17, com.stepos.agentframework.adapter.netcore.h r18, e9.InterfaceC4014c<? super com.stepos.agentframework.adapter.netcore.n> r19) throws java.lang.Throwable {
        /*
            r16 = this;
            r0 = r16
            r1 = r19
            boolean r2 = r1 instanceof com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$chat$1
            if (r2 == 0) goto L18
            r2 = r1
            com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$chat$1 r2 = (com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$chat$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.label = r3
        L16:
            r13 = r2
            goto L1e
        L18:
            com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$chat$1 r2 = new com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$chat$1
            r2.<init>(r0, r1)
            goto L16
        L1e:
            java.lang.Object r1 = r13.result
            java.lang.Object r2 = f9.C4063a.g()
            int r3 = r13.label
            r4 = 1
            if (r3 == 0) goto L3f
            if (r3 != r4) goto L37
            java.lang.Object r2 = r13.L$1
            com.stepos.agentframework.adapter.netcore.h r2 = (com.stepos.agentframework.adapter.netcore.h) r2
            java.lang.Object r2 = r13.L$0
            K6.n r2 = (kotlin.C0918n) r2
            kotlin.C4849c.b(r1)
            goto L97
        L37:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3f:
            kotlin.C4849c.b(r1)
            com.stepos.agentframework.adapter.coze.CozeClient$a r1 = com.stepos.agentframework.adapter.coze.CozeClient.INSTANCE
            com.stepos.agentframework.adapter.coze.CozeClient r3 = r1.a()
            java.lang.String r1 = r17.getAgentId()
            java.lang.String r5 = r17.getSecretkey()
            java.lang.String r6 = r17.getConversationId()
            if (r6 != 0) goto L58
            java.lang.String r6 = ""
        L58:
            java.util.List r7 = r17.j()
            java.util.HashMap r9 = r17.s()
            java.lang.String r10 = r17.getChatId()
            g4.j r11 = new g4.j
            boolean r8 = r17.getThinking()
            if (r8 == 0) goto L6f
            java.lang.String r8 = "enabled"
            goto L71
        L6f:
            java.lang.String r8 = "disabled"
        L71:
            r11.<init>(r8)
            com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$b r12 = new com.stepos.agentframework.adapter.coze.CozeCoreAgentClient$b
            r8 = r17
            r14 = r18
            r12.<init>(r14, r8, r0)
            java.lang.Object r8 = g9.h.a(r8)
            r13.L$0 = r8
            java.lang.Object r8 = g9.h.a(r14)
            r13.L$1 = r8
            r13.label = r4
            r8 = 0
            r14 = 16
            r15 = 0
            r4 = r1
            java.lang.Object r1 = com.stepos.agentframework.adapter.coze.CozeClient.q(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            if (r1 != r2) goto L97
            return r2
        L97:
            Kb.a r1 = (Kb.a) r1
            com.stepos.agentframework.adapter.netcore.i r2 = new com.stepos.agentframework.adapter.netcore.i
            r2.<init>(r1)
            r0.m0(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.coze.CozeCoreAgentClient.E(K6.n, com.stepos.agentframework.adapter.netcore.h, e9.c):java.lang.Object");
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

    public final void m0(i eventSourceState) {
        this.eventSourceStates.add(new WeakReference<>(eventSourceState));
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ void n(B b10) {
        super.n(b10);
    }

    public final List<AbstractC0913i> n0(String text) {
        return (text == null || H.x0(text)) ? C1173v.m() : C1172u.e(new AbstractC0913i.Text(text));
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public Object o(Context context, UploadFileRequest uploadFileRequest, s<? super Integer, ? super Boolean, ? super String, ? super String, ? super Long, t> sVar, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        if (uploadFileRequest.getUseFileId()) {
            Object objO0 = o0(context, uploadFileRequest, sVar, interfaceC4014c);
            return objO0 == C4063a.g() ? objO0 : t.f7040a;
        }
        Object objR0 = r0(context, uploadFileRequest, sVar, interfaceC4014c);
        return objR0 == C4063a.g() ? objR0 : t.f7040a;
    }

    public final Object o0(Context context, UploadFileRequest uploadFileRequest, final s<? super Integer, ? super Boolean, ? super String, ? super String, ? super Long, t> sVar, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        C4148a.k(TAG, "Uploading to Coze API (fileId mode)", false, 4, null);
        if (uploadFileRequest.getUri() != null) {
            CozeClient cozeClientA = CozeClient.INSTANCE.a();
            String secretKey = uploadFileRequest.getSecretKey();
            Uri uri = uploadFileRequest.getUri();
            p.f(uri);
            Object objS = cozeClientA.s(context, secretKey, uri, new q() { // from class: com.stepos.agentframework.adapter.coze.d
                @Override // p9.q
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CozeCoreAgentClient.p0(sVar, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue(), (String) obj3);
                }
            }, interfaceC4014c);
            return objS == C4063a.g() ? objS : t.f7040a;
        }
        if (uploadFileRequest.getFile() == null) {
            throw new IllegalArgumentException("No file or uri provided");
        }
        CozeClient cozeClientA2 = CozeClient.INSTANCE.a();
        String secretKey2 = uploadFileRequest.getSecretKey();
        File file = uploadFileRequest.getFile();
        p.f(file);
        Object objT = cozeClientA2.t(context, secretKey2, file, new q() { // from class: com.stepos.agentframework.adapter.coze.e
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return CozeCoreAgentClient.q0(sVar, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue(), (String) obj3);
            }
        }, interfaceC4014c);
        return objT == C4063a.g() ? objT : t.f7040a;
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public void r(Context context, com.stepos.agentframework.adapter.netcore.p logger) {
        p.i(context, "context");
        p.i(logger, "logger");
        CozeClient.Companion companion = CozeClient.INSTANCE;
        companion.a().l(context, this.timeOut, companion.b(), logger);
    }

    public final Object r0(Context context, UploadFileRequest uploadFileRequest, s<? super Integer, ? super Boolean, ? super String, ? super String, ? super Long, t> sVar, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        C4148a.k(TAG, "Uploading via FileStorage (URL mode)", false, 4, null);
        if (uploadFileRequest.getFile() != null) {
            FileStorageUploadHelper fileStorageUploadHelper = FileStorageUploadHelper.INSTANCE;
            File file = uploadFileRequest.getFile();
            p.f(file);
            Object objL = fileStorageUploadHelper.l(context, file, sVar, interfaceC4014c);
            return objL == C4063a.g() ? objL : t.f7040a;
        }
        if (uploadFileRequest.getUri() == null) {
            throw new IllegalArgumentException("No file or uri provided");
        }
        FileStorageUploadHelper fileStorageUploadHelper2 = FileStorageUploadHelper.INSTANCE;
        Uri uri = uploadFileRequest.getUri();
        p.f(uri);
        Object objN = fileStorageUploadHelper2.n(context, uri, sVar, interfaceC4014c);
        return objN == C4063a.g() ? objN : t.f7040a;
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
