package com.stepos.agentframework.adapter.openclaw;

import Ua.C1056g;
import Ua.Y;
import Z8.C1173v;
import Z8.F;
import Z8.Q;
import android.content.Context;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import c8.InterfaceC1505c;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.netcore.ApiType;
import com.stepos.agentframework.adapter.netcore.B;
import com.stepos.agentframework.adapter.netcore.FileStorageUploadHelper;
import com.stepos.agentframework.adapter.netcore.InquiryAnswerResult;
import com.stepos.agentframework.adapter.netcore.h;
import com.stepos.agentframework.adapter.netcore.n;
import com.stepos.agentframework.adapter.netcore.o;
import com.stepos.agentframework.adapter.netcore.p;
import com.stepos.agentframework.adapter.netcore.s;
import com.stepos.agentframework.adapter.netcore.t;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.common.FunctionCall;
import com.zyql.agentfront.bean.CancelMessageRequest;
import com.zyql.agentfront.bean.Message;
import com.zyql.agentfront.bean.MessageContent;
import com.zyql.agentfront.bean.ToolCallRequest;
import com.zyql.agentfront.bean.ToolResultRequest;
import com.zyql.agentfront.sdk.client.AgentFrontClient;
import com.zyql.agentfront.sdk.client.j;
import e9.InterfaceC4014c;
import f9.C4063a;
import h8.C4148a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.AbstractC0913i;
import kotlin.AgentDetailRequest;
import kotlin.C0905a;
import kotlin.C0917m;
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
import m4.AbstractC4898a;

@Metadata(d1 = {"\u0000Ã\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\t*\u0001d\u0018\u0000 r2\u00020\u0001:\u0004stuvB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b$\u0010%JE\u0010*\u001a\u00020\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u00112\b\u0010)\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0014H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0017H\u0002¢\u0006\u0004\b.\u0010/J\u001f\u00102\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\"2\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\u00172\b\u0010\u000e\u001a\u0004\u0018\u000104¢\u0006\u0004\b5\u00106J\"\u00107\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0096@¢\u0006\u0004\b7\u00108J\u0017\u0010;\u001a\u00020\u00172\u0006\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u000209H\u0016¢\u0006\u0004\b=\u0010>J\u0018\u0010A\u001a\u00020@2\u0006\u0010\u0007\u001a\u00020?H\u0096@¢\u0006\u0004\bA\u0010BJ\u0018\u0010D\u001a\u0002092\u0006\u0010C\u001a\u00020\u0011H\u0096@¢\u0006\u0004\bD\u0010EJ\u0018\u0010F\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u0011H\u0096@¢\u0006\u0004\bF\u0010EJ \u0010H\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\u0011H\u0096@¢\u0006\u0004\bH\u0010IJP\u0010N\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0007\u001a\u00020J2.\u0010M\u001a*\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00170KH\u0096@¢\u0006\u0004\bN\u0010OJ\u0018\u0010Q\u001a\u0002092\u0006\u0010\u0007\u001a\u00020PH\u0096@¢\u0006\u0004\bQ\u0010RR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010SR\u001a\u0010T\u001a\u00020\u00118\u0006X\u0086D¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u001a\u0010Y\u001a\u00020X8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u0016\u0010]\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010_R\u0018\u0010`\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010b\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0014\u0010e\u001a\u00020d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fRT\u0010j\u001aB\u0012\f\u0012\n h*\u0004\u0018\u00010\u00110\u0011\u0012\f\u0012\n h*\u0004\u0018\u00010\u00110\u0011 h* \u0012\f\u0012\n h*\u0004\u0018\u00010\u00110\u0011\u0012\f\u0012\n h*\u0004\u0018\u00010\u00110\u0011\u0018\u00010i0g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR8\u0010o\u001a&\u0012\f\u0012\n h*\u0004\u0018\u00010m0m h*\u0012\u0012\f\u0012\n h*\u0004\u0018\u00010m0m\u0018\u00010n0l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pRT\u0010q\u001aB\u0012\f\u0012\n h*\u0004\u0018\u00010\u00110\u0011\u0012\f\u0012\n h*\u0004\u0018\u00010909 h* \u0012\f\u0012\n h*\u0004\u0018\u00010\u00110\u0011\u0012\f\u0012\n h*\u0004\u0018\u00010909\u0018\u00010i0g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010k¨\u0006w"}, d2 = {"Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient;", "Lcom/stepos/agentframework/adapter/netcore/o;", "", "timeOut", "<init>", "(J)V", "LK6/n;", "request", "Lcom/zyql/agentfront/sdk/client/AgentFrontClient;", "client", "Lcom/stepos/agentframework/adapter/netcore/n;", "G0", "(LK6/n;Lcom/zyql/agentfront/sdk/client/AgentFrontClient;)Lcom/stepos/agentframework/adapter/netcore/n;", "Lcom/stepos/agentframework/adapter/netcore/h;", "listener", "A0", "(LK6/n;Lcom/stepos/agentframework/adapter/netcore/h;Lcom/zyql/agentfront/sdk/client/AgentFrontClient;)Lcom/stepos/agentframework/adapter/netcore/n;", "", "messageId", DidiCardProvider.KEY_TRACE_ID, "Lcom/zyql/agentfront/bean/Message;", "w0", "(LK6/n;Ljava/lang/String;Ljava/lang/String;)Lcom/zyql/agentfront/bean/Message;", "LY8/t;", "J0", "(LK6/n;Lcom/zyql/agentfront/sdk/client/AgentFrontClient;)V", "Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$d;", "requestInfo", "Lcom/zyql/agentfront/sdk/client/j;", "x0", "(Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$d;)Lcom/zyql/agentfront/sdk/client/j;", "message", "D0", "(Lcom/zyql/agentfront/bean/Message;Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$d;)V", "Landroid/content/Context;", "context", "z0", "(Landroid/content/Context;)Lcom/zyql/agentfront/sdk/client/AgentFrontClient;", "toolCallId", "conversationId", "toolName", "arguments", "F0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "B0", "(Lcom/zyql/agentfront/bean/Message;)V", "H0", "()V", "Lcom/stepos/agentframework/adapter/netcore/p;", com.stepos.statsapp.v3.lib.plugin.events.b.f30786f, "r", "(Landroid/content/Context;Lcom/stepos/agentframework/adapter/netcore/p;)V", "Lcom/stepos/agentframework/adapter/netcore/t;", "I0", "(Lcom/stepos/agentframework/adapter/netcore/t;)V", ExifInterface.LONGITUDE_EAST, "(LK6/n;Lcom/stepos/agentframework/adapter/netcore/h;Le9/c;)Ljava/lang/Object;", "", "isAvailable", "b0", "(Z)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Z", "LK6/C;", "LK6/D;", "K", "(LK6/C;Le9/c;)Ljava/lang/Object;", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "a0", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "L", "title", ExifInterface.LONGITUDE_WEST, "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "LK6/M;", "Lkotlin/Function5;", "", "onProgress", "o", "(Landroid/content/Context;LK6/M;Lp9/s;Le9/c;)Ljava/lang/Object;", "LK6/O;", "u", "(LK6/O;Le9/c;)Ljava/lang/Object;", "J", "CHAT_ID", "Ljava/lang/String;", "y0", "()Ljava/lang/String;", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "type", "Lcom/stepos/agentframework/adapter/netcore/ApiType;", "getType", "()Lcom/stepos/agentframework/adapter/netcore/ApiType;", "logger", "Lcom/stepos/agentframework/adapter/netcore/p;", "Landroid/content/Context;", "agentFrontClient", "Lcom/zyql/agentfront/sdk/client/AgentFrontClient;", "pushMessageListener", "Lcom/stepos/agentframework/adapter/netcore/t;", "com/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$g", "sdkPushMessageListener", "Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$g;", "", "kotlin.jvm.PlatformType", "", "conversationAgentMap", "Ljava/util/Map;", "", "Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$c;", "", "pendingQueue", "Ljava/util/List;", "activeRequests", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "c", "protocol_openclaw_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OpenClawCoreAgentClient implements o {
    private static final int DELETE_SESSION_ATTEMPTS = 3;
    private static final long DELETE_SESSION_RETRY_DELAY_MS = 400;
    private static final String TAG = "OpenClawCoreAgentClient";
    private AgentFrontClient agentFrontClient;
    private Context context;
    private volatile t pushMessageListener;
    private final long timeOut;
    private final String CHAT_ID = "111";
    private final ApiType type = ApiType.OPENCLAW;
    private p logger = s.INSTANCE;
    private final g sdkPushMessageListener = new g();
    private final Map<String, String> conversationAgentMap = Collections.synchronizedMap(new LinkedHashMap());
    private final List<PendingRequest> pendingQueue = Collections.synchronizedList(new ArrayList());
    private final Map<String, Boolean> activeRequests = Collections.synchronizedMap(new LinkedHashMap());

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0016\u0010\r\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$b;", "Lcom/stepos/agentframework/adapter/netcore/n;", "", "messageId", "<init>", "(Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient;Ljava/lang/String;)V", "reason", "", "cancel", "(Ljava/lang/String;)Z", "isCancelled", "()Z", "Ljava/lang/String;", "cancelled", "Z", "protocol_openclaw_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class b implements n {
        private volatile boolean cancelled;
        private final String messageId;
        final /* synthetic */ OpenClawCoreAgentClient this$0;

        public b(OpenClawCoreAgentClient openClawCoreAgentClient, String messageId) {
            kotlin.jvm.internal.p.i(messageId, "messageId");
            this.this$0 = openClawCoreAgentClient;
            this.messageId = messageId;
        }

        @Override // com.stepos.agentframework.adapter.netcore.n
        public boolean cancel(String reason) {
            kotlin.jvm.internal.p.i(reason, "reason");
            if (this.cancelled) {
                return false;
            }
            this.cancelled = true;
            Map map = this.this$0.activeRequests;
            kotlin.jvm.internal.p.h(map, "access$getActiveRequests$p(...)");
            map.put(this.messageId, Boolean.TRUE);
            this.this$0.logger.c(OpenClawCoreAgentClient.TAG, "Request cancelled: messageId=" + this.messageId + " reason=" + reason);
            try {
                AgentFrontClient agentFrontClient = this.this$0.agentFrontClient;
                if (agentFrontClient != null) {
                    agentFrontClient.R(new CancelMessageRequest(this.messageId, null, null, 6, null));
                }
                this.this$0.logger.c(OpenClawCoreAgentClient.TAG, "Request cancelled success. messageId=" + this.messageId);
            } catch (Exception e10) {
                p pVar = this.this$0.logger;
                String str = this.messageId;
                String message = e10.getMessage();
                e10.printStackTrace();
                pVar.b(OpenClawCoreAgentClient.TAG, "Request cancelled failed. messageId:" + str + ". msg=" + message + ". e=" + Y8.t.f7040a);
            }
            return true;
        }

        @Override // com.stepos.agentframework.adapter.netcore.n
        /* renamed from: isCancelled */
        public boolean getCancelled() {
            return this.cancelled || kotlin.jvm.internal.p.d(this.this$0.activeRequests.get(this.messageId), Boolean.TRUE);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$c;", "", "", "requestId", DidiCardProvider.KEY_TRACE_ID, "Lcom/zyql/agentfront/bean/Message;", "message", "Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$d;", "requestInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/zyql/agentfront/bean/Message;Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$d;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "getTraceId", "Lcom/zyql/agentfront/bean/Message;", Const.INTENT_KEY_APIKEY, "()Lcom/zyql/agentfront/bean/Message;", "Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$d;", "c", "()Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$d;", "protocol_openclaw_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$c, reason: from toString */
    public static final /* data */ class PendingRequest {
        private final Message message;
        private final String requestId;
        private final RequestInfo requestInfo;
        private final String traceId;

        public PendingRequest(String requestId, String str, Message message, RequestInfo requestInfo) {
            kotlin.jvm.internal.p.i(requestId, "requestId");
            kotlin.jvm.internal.p.i(message, "message");
            kotlin.jvm.internal.p.i(requestInfo, "requestInfo");
            this.requestId = requestId;
            this.traceId = str;
            this.message = message;
            this.requestInfo = requestInfo;
        }

        /* renamed from: a, reason: from getter */
        public final Message getMessage() {
            return this.message;
        }

        /* renamed from: b, reason: from getter */
        public final String getRequestId() {
            return this.requestId;
        }

        /* renamed from: c, reason: from getter */
        public final RequestInfo getRequestInfo() {
            return this.requestInfo;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingRequest)) {
                return false;
            }
            PendingRequest pendingRequest = (PendingRequest) other;
            return kotlin.jvm.internal.p.d(this.requestId, pendingRequest.requestId) && kotlin.jvm.internal.p.d(this.traceId, pendingRequest.traceId) && kotlin.jvm.internal.p.d(this.message, pendingRequest.message) && kotlin.jvm.internal.p.d(this.requestInfo, pendingRequest.requestInfo);
        }

        public int hashCode() {
            int iHashCode = this.requestId.hashCode() * 31;
            String str = this.traceId;
            return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.message.hashCode()) * 31) + this.requestInfo.hashCode();
        }

        public String toString() {
            return "PendingRequest(requestId=" + this.requestId + ", traceId=" + this.traceId + ", message=" + this.message + ", requestInfo=" + this.requestInfo + ")";
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\u0010\b\u001a\u00060\u0006R\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\b\u001a\u00060\u0006R\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$d;", "", "LK6/n;", "request", "Lcom/stepos/agentframework/adapter/netcore/h;", "listener", "Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$b;", "Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient;", "cancelHandle", "<init>", "(LK6/n;Lcom/stepos/agentframework/adapter/netcore/h;Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$b;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "LK6/n;", "c", "()LK6/n;", "Lcom/stepos/agentframework/adapter/netcore/h;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/adapter/netcore/h;", "Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$b;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$b;", "protocol_openclaw_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$d, reason: from toString */
    public static final /* data */ class RequestInfo {
        private final b cancelHandle;
        private final h listener;
        private final C0918n request;

        public RequestInfo(C0918n request, h listener, b cancelHandle) {
            kotlin.jvm.internal.p.i(request, "request");
            kotlin.jvm.internal.p.i(listener, "listener");
            kotlin.jvm.internal.p.i(cancelHandle, "cancelHandle");
            this.request = request;
            this.listener = listener;
            this.cancelHandle = cancelHandle;
        }

        /* renamed from: a, reason: from getter */
        public final b getCancelHandle() {
            return this.cancelHandle;
        }

        /* renamed from: b, reason: from getter */
        public final h getListener() {
            return this.listener;
        }

        /* renamed from: c, reason: from getter */
        public final C0918n getRequest() {
            return this.request;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RequestInfo)) {
                return false;
            }
            RequestInfo requestInfo = (RequestInfo) other;
            return kotlin.jvm.internal.p.d(this.request, requestInfo.request) && kotlin.jvm.internal.p.d(this.listener, requestInfo.listener) && kotlin.jvm.internal.p.d(this.cancelHandle, requestInfo.cancelHandle);
        }

        public int hashCode() {
            return (((this.request.hashCode() * 31) + this.listener.hashCode()) * 31) + this.cancelHandle.hashCode();
        }

        public String toString() {
            return "RequestInfo(request=" + this.request + ", listener=" + this.listener + ", cancelHandle=" + this.cancelHandle + ")";
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"com/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$e", "Lcom/zyql/agentfront/sdk/client/j;", "", "messageId", "LY8/t;", "onSuccess", "(Ljava/lang/String;)V", "error", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/zyql/agentfront/bean/Message;", "message", Const.INTENT_KEY_UMID, "(Lcom/zyql/agentfront/bean/Message;)V", "Lcom/zyql/agentfront/bean/ToolCallRequest;", "request", Const.INTENT_KEY_PKGNAME, "(Lcom/zyql/agentfront/bean/ToolCallRequest;)V", "protocol_openclaw_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e implements j {
        final /* synthetic */ RequestInfo $requestInfo;

        public e(RequestInfo requestInfo) {
            this.$requestInfo = requestInfo;
        }

        public static final CharSequence f(MessageContent it) {
            kotlin.jvm.internal.p.i(it, "it");
            String text = it.getText();
            return text != null ? text : "";
        }

        @Override // com.zyql.agentfront.sdk.client.j
        public void a(String messageId, String error) {
            kotlin.jvm.internal.p.i(messageId, "messageId");
            kotlin.jvm.internal.p.i(error, "error");
            if (this.$requestInfo.getCancelHandle().getCancelled()) {
                OpenClawCoreAgentClient.this.logger.a(OpenClawCoreAgentClient.TAG, "onError: request already cancelled, messageId=" + messageId);
                OpenClawCoreAgentClient.this.activeRequests.remove(messageId);
                return;
            }
            OpenClawCoreAgentClient.this.logger.b(OpenClawCoreAgentClient.TAG, "onError: messageId=" + messageId + ", error=" + error);
            OpenClawCoreAgentClient.this.activeRequests.remove(messageId);
            this.$requestInfo.getListener().b(this.$requestInfo.getRequest(), Integer.valueOf(AbstractC4898a.ERROR_AGENT_INTERNAL_ERROR), error);
        }

        @Override // com.zyql.agentfront.sdk.client.j
        public void b(ToolCallRequest request) {
            kotlin.jvm.internal.p.i(request, "request");
            if (this.$requestInfo.getCancelHandle().getCancelled()) {
                OpenClawCoreAgentClient.this.logger.a(OpenClawCoreAgentClient.TAG, "onToolCall: request already cancelled, toolCallId=" + request.getToolCallId());
                return;
            }
            String traceId = request.getTraceId();
            OpenClawCoreAgentClient.this.logger.a(OpenClawCoreAgentClient.TAG, "onToolCall: toolCallId=" + request.getToolCallId() + ", originMessageId=" + request.getOriginMessageId() + ", conversationId=" + request.getConversationId() + ", traceId=" + traceId + ",  toolName=" + request.getToolName());
            try {
                String toolName = request.getToolName();
                String toolCallId = request.getToolCallId();
                String toolName2 = request.getToolName();
                String arguments = request.getArguments();
                if (arguments == null) {
                    arguments = "{}";
                }
                FunctionCall functionCall = new FunctionCall(null, toolName2, arguments, toolName, null, null, null, null, null, null, toolCallId, null, false, null, 15345, null);
                String originMessageId = request.getOriginMessageId();
                this.$requestInfo.getListener().g(this.$requestInfo.getRequest(), new C0917m(null, "assistant", request.getConversationId(), "tool_call", 0, false, Q.f(Y8.j.a("toolName", request.getToolName())), 0, null, 0L, 0, 0, false, this.$requestInfo.getRequest().getAgentId(), this.$requestInfo.getRequest().getSecretkey(), null, 4, false, null, 0, Integer.valueOf(this.$requestInfo.getRequest().get_id()), 0, null, 2, null, null, "normal", null, null, originMessageId, null, functionCall, null, null, request.getConversationId(), null, null, null, traceId, null, null, null, null, null, null, 1533845425, 8123, null));
            } catch (Exception e10) {
                OpenClawCoreAgentClient.this.logger.b(OpenClawCoreAgentClient.TAG, "Failed to parse tool call: " + e10.getMessage());
            }
        }

        @Override // com.zyql.agentfront.sdk.client.j
        public /* bridge */ void c(List<ToolCallRequest> list) {
            super.c(list);
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x01b9  */
        @Override // com.zyql.agentfront.sdk.client.j
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void d(com.zyql.agentfront.bean.Message r54) {
            /*
                Method dump skipped, instructions count: 676
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient.e.d(com.zyql.agentfront.bean.Message):void");
        }

        @Override // com.zyql.agentfront.sdk.client.j
        public void onSuccess(String messageId) {
            kotlin.jvm.internal.p.i(messageId, "messageId");
            OpenClawCoreAgentClient.this.logger.a(OpenClawCoreAgentClient.TAG, "onSuccess: messageId=" + messageId);
            OpenClawCoreAgentClient.this.activeRequests.remove(messageId);
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$f", "Lc8/c;", "LY8/t;", "onConnected", "()V", "onDisconnected", "", "reason", "onBindFailed", "(Ljava/lang/String;)V", "", "retryCount", "maxRetry", Const.INTENT_KEY_APIKEY, "(II)V", "protocol_openclaw_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f implements InterfaceC1505c {
        public f() {
        }

        @Override // c8.InterfaceC1505c
        public void a(int retryCount, int maxRetry) {
            OpenClawCoreAgentClient.this.logger.c(OpenClawCoreAgentClient.TAG, "AgentFront retrying connecting: " + retryCount + "/" + maxRetry);
        }

        @Override // c8.InterfaceC1505c
        public void onBindFailed(String reason) {
            OpenClawCoreAgentClient.this.logger.b(OpenClawCoreAgentClient.TAG, "AgentFront bind failed: " + reason);
            if (reason == null) {
                reason = "无法绑定 AgentFront 服务（请安装应用）";
            }
            List list = OpenClawCoreAgentClient.this.pendingQueue;
            kotlin.jvm.internal.p.h(list, "access$getPendingQueue$p(...)");
            OpenClawCoreAgentClient openClawCoreAgentClient = OpenClawCoreAgentClient.this;
            synchronized (list) {
                try {
                    List<PendingRequest> list2 = openClawCoreAgentClient.pendingQueue;
                    kotlin.jvm.internal.p.h(list2, "access$getPendingQueue$p(...)");
                    for (PendingRequest pendingRequest : list2) {
                        pendingRequest.getRequestInfo().getListener().b(pendingRequest.getRequestInfo().getRequest(), Integer.valueOf(AbstractC4898a.ERROR_CLIENT_NOT_FOUND), reason);
                    }
                    openClawCoreAgentClient.pendingQueue.clear();
                    Y8.t tVar = Y8.t.f7040a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // c8.InterfaceC1505c
        public void onConnected() {
            OpenClawCoreAgentClient.this.logger.c(OpenClawCoreAgentClient.TAG, "AgentFront connected");
            OpenClawCoreAgentClient.this.H0();
        }

        @Override // c8.InterfaceC1505c
        public void onDisconnected() {
            OpenClawCoreAgentClient.this.logger.c(OpenClawCoreAgentClient.TAG, "AgentFront disconnected");
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/agentframework/adapter/openclaw/OpenClawCoreAgentClient$g", "Lcom/zyql/agentfront/sdk/client/o;", "Lcom/zyql/agentfront/bean/Message;", "message", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/zyql/agentfront/bean/Message;)V", "Lcom/zyql/agentfront/bean/ToolCallRequest;", "request", "c", "(Lcom/zyql/agentfront/bean/ToolCallRequest;)V", "protocol_openclaw_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g implements com.zyql.agentfront.sdk.client.o {
        public g() {
        }

        @Override // com.zyql.agentfront.sdk.client.o
        public void a(Message message) {
            kotlin.jvm.internal.p.i(message, "message");
            OpenClawCoreAgentClient.this.logger.c(OpenClawCoreAgentClient.TAG, "PushMessageListener onPushMessage");
            OpenClawCoreAgentClient.this.B0(message);
        }

        @Override // com.zyql.agentfront.sdk.client.o
        public /* bridge */ void b(List<ToolCallRequest> list) {
            super.b(list);
        }

        @Override // com.zyql.agentfront.sdk.client.o
        public void c(ToolCallRequest request) {
            kotlin.jvm.internal.p.i(request, "request");
            OpenClawCoreAgentClient.this.logger.c(OpenClawCoreAgentClient.TAG, "PushMessageListener onPushToolCall: toolCallId=" + request.getToolCallId() + " msgId=" + request.getOriginMessageId() + ", cId=" + request.getConversationId() + ", traceId=" + request.getTraceId());
            OpenClawCoreAgentClient.this.F0(request.getOriginMessageId(), request.getToolCallId(), request.getConversationId(), request.getToolName(), request.getArguments(), request.getTraceId());
        }
    }

    public OpenClawCoreAgentClient(long j10) {
        this.timeOut = j10;
    }

    public static final CharSequence C0(MessageContent it) {
        kotlin.jvm.internal.p.i(it, "it");
        String text = it.getText();
        return text != null ? text : "";
    }

    public static final CharSequence E0(MessageContent it) {
        kotlin.jvm.internal.p.i(it, "it");
        String text = it.getText();
        return text != null ? text : "";
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object A(AgentDetailRequest agentDetailRequest, InterfaceC4014c<? super C0905a> interfaceC4014c) {
        return super.A(agentDetailRequest, interfaceC4014c);
    }

    public final n A0(C0918n request, h listener, AgentFrontClient client) {
        String conversationId = request.getConversationId();
        if (conversationId != null && conversationId.length() != 0 && request.getAgentId().length() > 0) {
            Map<String, String> conversationAgentMap = this.conversationAgentMap;
            kotlin.jvm.internal.p.h(conversationAgentMap, "conversationAgentMap");
            conversationAgentMap.put(conversationId, request.getAgentId());
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        b bVar = new b(this, strValueOf);
        RequestInfo requestInfo = new RequestInfo(request, listener, bVar);
        String traceId = request.getTraceId();
        Map<String, Boolean> activeRequests = this.activeRequests;
        kotlin.jvm.internal.p.h(activeRequests, "activeRequests");
        activeRequests.put(strValueOf, Boolean.FALSE);
        Message messageW0 = w0(request, strValueOf, traceId);
        this.logger.a(TAG, "chat: requestId=" + strValueOf + ", traceId=" + traceId + " connected=" + client.r());
        if (!client.r()) {
            this.logger.c(TAG, "AgentFront not connected, queuing message: " + strValueOf);
            this.pendingQueue.add(new PendingRequest(strValueOf, traceId, messageW0, requestInfo));
            try {
                client.V();
                return bVar;
            } catch (Exception e10) {
                this.logger.b(TAG, "Failed to reconnect: " + e10.getMessage());
                return bVar;
            }
        }
        this.logger.a(TAG, "Sending message, requestId=" + strValueOf + ", traceId=" + traceId);
        try {
            client.i0(messageW0, x0(requestInfo));
            return bVar;
        } catch (Exception e11) {
            this.logger.b(TAG, "Failed to send message: " + e11.getMessage());
            this.activeRequests.remove(strValueOf);
            Integer numValueOf = Integer.valueOf(AbstractC4898a.ERROR_AGENT_INTERNAL_ERROR);
            String message = e11.getMessage();
            if (message == null) {
                message = "发送消息失败";
            }
            listener.b(request, numValueOf, message);
            return null;
        }
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object B(C0918n c0918n, String str, h hVar, InterfaceC4014c<? super n> interfaceC4014c) {
        return super.B(c0918n, str, hVar, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B0(com.zyql.agentfront.bean.Message r57) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient.B0(com.zyql.agentfront.bean.Message):void");
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object C(FeedbackRequest feedbackRequest, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return super.C(feedbackRequest, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ boolean D() {
        return super.D();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D0(com.zyql.agentfront.bean.Message r54, com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient.RequestInfo r55) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient.D0(com.zyql.agentfront.bean.Message, com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$d):void");
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public Object E(C0918n c0918n, h hVar, InterfaceC4014c<? super n> interfaceC4014c) {
        C4148a.j(TAG, "request:" + com.stepos.agentframework.adapter.netcore.j.b(c0918n), true);
        return C1056g.j(Y.b(), new OpenClawCoreAgentClient$chat$2(this, c0918n, hVar, null), interfaceC4014c);
    }

    public final void F0(String messageId, String toolCallId, String conversationId, String toolName, String arguments, String traceId) {
        String str;
        FunctionCall functionCall;
        String str2;
        OpenClawCoreAgentClient openClawCoreAgentClient = this;
        openClawCoreAgentClient.logger.c(TAG, "handleToolCall: toolCallId=" + toolCallId + ", toolName=" + toolName + " messageId=" + messageId + ", traceId=" + traceId);
        try {
            try {
                functionCall = new FunctionCall(null, toolName, arguments == null ? "{}" : arguments, toolName, null, null, null, null, null, null, toolCallId, null, false, null, 15345, null);
                str2 = openClawCoreAgentClient.conversationAgentMap.get(conversationId);
                if (str2 == null) {
                    str2 = "";
                }
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Exception e11) {
            e = e11;
            str = TAG;
        }
        try {
            C0918n c0918n = new C0918n(C1173v.m(), null, conversationId, null, 0, false, null, 0, null, 0L, 0, 0, false, null, null, null, false, false, null, null, null, null, null, null, null, 33554426, null);
            c0918n.I(traceId);
            c0918n.d(str2);
            c0918n.f("");
            c0918n.J((int) System.currentTimeMillis());
            int i10 = c0918n.get_id();
            Map mapF = Q.f(Y8.j.a("toolName", toolName));
            Integer numValueOf = Integer.valueOf(i10);
            str = conversationId;
            C0917m c0917m = new C0917m(null, "assistant", str, "tool_call", 0, false, mapF, 0, null, 0L, 0, 0, false, null, null, null, 4, false, null, 0, numValueOf, 0, null, 2, null, null, "normal", null, null, messageId, null, functionCall, null, null, conversationId, null, null, null, traceId, null, null, null, null, null, null, 1533870001, 8123, null);
            c0917m.d(str2);
            c0917m.f("");
            openClawCoreAgentClient = this;
            t tVar = openClawCoreAgentClient.pushMessageListener;
            try {
                if (tVar == null) {
                    openClawCoreAgentClient.logger.d(TAG, "handleToolCall: no PushMessageListener set, tool call not handled");
                } else {
                    openClawCoreAgentClient.logger.a(TAG, "handleToolCall: notifying PushMessageListener");
                    tVar.b(c0917m, openClawCoreAgentClient.getType());
                }
            } catch (Exception e12) {
                e = e12;
                openClawCoreAgentClient.logger.b(str, "Failed to handle tool call: " + e.getMessage());
            }
        } catch (Exception e13) {
            e = e13;
            openClawCoreAgentClient = this;
            str = TAG;
            openClawCoreAgentClient.logger.b(str, "Failed to handle tool call: " + e.getMessage());
        }
    }

    public final n G0(C0918n request, AgentFrontClient client) {
        String conversationId = request.getConversationId();
        if (conversationId != null && conversationId.length() != 0 && request.getAgentId().length() > 0) {
            Map<String, String> conversationAgentMap = this.conversationAgentMap;
            kotlin.jvm.internal.p.h(conversationAgentMap, "conversationAgentMap");
            conversationAgentMap.put(conversationId, request.getAgentId());
        }
        String chatId = request.getChatId();
        if (chatId == null || chatId.length() == 0) {
            this.logger.d(TAG, "submitToolOutputs: request.chatId is null or empty");
            J0(request, client);
            return null;
        }
        this.logger.c(TAG, "submitToolOutputs: originalMessageId=" + chatId + ", agentId=" + request.getAgentId());
        if (!this.activeRequests.containsKey(chatId)) {
            Map<String, Boolean> activeRequests = this.activeRequests;
            kotlin.jvm.internal.p.h(activeRequests, "activeRequests");
            activeRequests.put(chatId, Boolean.FALSE);
        }
        b bVar = new b(this, chatId);
        J0(request, client);
        return bVar;
    }

    public final void H0() {
        List<PendingRequest> pendingQueue = this.pendingQueue;
        kotlin.jvm.internal.p.h(pendingQueue, "pendingQueue");
        synchronized (pendingQueue) {
            if (this.pendingQueue.isEmpty()) {
                return;
            }
            this.logger.c(TAG, "Processing pending queue, size=" + this.pendingQueue.size());
            AgentFrontClient agentFrontClient = this.agentFrontClient;
            if (agentFrontClient == null) {
                return;
            }
            if (!agentFrontClient.r()) {
                this.logger.d(TAG, "Client not connected, cannot process pending queue");
                return;
            }
            Iterator<PendingRequest> it = this.pendingQueue.iterator();
            while (it.hasNext()) {
                PendingRequest next = it.next();
                try {
                    this.logger.a(TAG, "Sending pending message: " + next.getRequestId());
                    agentFrontClient.i0(next.getMessage(), x0(next.getRequestInfo()));
                    it.remove();
                } catch (Exception e10) {
                    this.logger.b(TAG, "Failed to send pending message: " + e10.getMessage());
                    h listener = next.getRequestInfo().getListener();
                    C0918n request = next.getRequestInfo().getRequest();
                    Integer numValueOf = Integer.valueOf(AbstractC4898a.ERROR_AGENT_INTERNAL_ERROR);
                    String message = e10.getMessage();
                    if (message == null) {
                        message = "发送消息失败";
                    }
                    listener.b(request, numValueOf, message);
                    it.remove();
                }
            }
            this.logger.c(TAG, "Pending queue processed, remaining size=" + this.pendingQueue.size());
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object I(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return super.I(str, interfaceC4014c);
    }

    public final void I0(t listener) {
        this.pushMessageListener = listener;
        Context context = this.context;
        if (context == null) {
            this.logger.b(TAG, "setPushMessageCallback failed. " + (listener != null) + "  ctx is null");
            return;
        }
        z0(context).m0(listener != null ? this.sdkPushMessageListener : null);
        this.logger.a(TAG, "setPushMessageCallback: " + (listener != null));
    }

    public final void J0(C0918n request, AgentFrontClient client) {
        String str;
        HashMap<String, Object> mapS = request.s();
        if (mapS == null) {
            return;
        }
        Map<String, String> mapM = request.m();
        if (mapM == null || (str = mapM.get("toolName")) == null) {
            str = "";
        }
        String str2 = str;
        String traceId = request.getTraceId();
        this.logger.a(TAG, "submitToolOutputs: size=" + mapS.size() + ", toolName=" + str2 + ", traceId=" + traceId);
        for (Map.Entry<String, Object> entry : mapS.entrySet()) {
            String key = entry.getKey();
            try {
                String string = entry.getValue().toString();
                this.logger.a(TAG, "submitToolResult: toolCallId=" + key + ", toolName=" + str2 + ", result=" + string);
                client.o0(new ToolResultRequest(key, str2, string, null, null, traceId, 24, null));
            } catch (Exception e10) {
                this.logger.b(TAG, "Failed to submit tool output for " + key + ": " + e10.getMessage());
            }
        }
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public Object K(SyncHistoryRequest syncHistoryRequest, InterfaceC4014c<? super SyncHistoryResult> interfaceC4014c) {
        return C1056g.j(Y.b(), new OpenClawCoreAgentClient$syncHistory$2(this, syncHistoryRequest, null), interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public Object L(String str, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objJ = C1056g.j(Y.b(), new OpenClawCoreAgentClient$clearSession$2(this, str, null), interfaceC4014c);
        return objJ == C4063a.g() ? objJ : Y8.t.f7040a;
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
    public Object W(String str, String str2, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objJ = C1056g.j(Y.b(), new OpenClawCoreAgentClient$renameSession$2(this, str, str2, null), interfaceC4014c);
        return objJ == C4063a.g() ? objJ : Y8.t.f7040a;
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
    public Object a0(String str, InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return C1056g.j(Y.b(), new OpenClawCoreAgentClient$deleteSession$2(this, str, null), interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ Object b(String str, InterfaceC4014c<? super String> interfaceC4014c) {
        return super.b(str, interfaceC4014c);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public void b0(boolean isAvailable) {
        this.logger.a(TAG, "Network changed: " + isAvailable);
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
    public boolean h() {
        AgentFrontClient agentFrontClient = this.agentFrontClient;
        return agentFrontClient != null && agentFrontClient.r();
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
    public void r(Context context, p log) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(log, "log");
        this.logger = log;
        this.context = context.getApplicationContext();
        this.logger.c(TAG, "OpenClawCoreAgentClient initialized");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.stepos.agentframework.adapter.netcore.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object u(kotlin.VoteRequest r9, e9.InterfaceC4014c<? super java.lang.Boolean> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$vote$1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$vote$1 r0 = (com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$vote$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$vote$1 r0 = new com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient$vote$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r10 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 4
            r3 = 1
            r4 = 0
            r5 = 0
            java.lang.String r6 = "OpenClawCoreAgentClient"
            if (r1 == 0) goto L3c
            if (r1 != r3) goto L34
            java.lang.Object r9 = r0.L$0
            K6.O r9 = (kotlin.VoteRequest) r9
            kotlin.C4849c.b(r8)     // Catch: java.lang.Exception -> L32
            goto L6a
        L32:
            r8 = move-exception
            goto La2
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3c:
            kotlin.C4849c.b(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L32
            r8.<init>()     // Catch: java.lang.Exception -> L32
            java.lang.String r1 = "vote request: "
            r8.append(r1)     // Catch: java.lang.Exception -> L32
            r8.append(r9)     // Catch: java.lang.Exception -> L32
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Exception -> L32
            h8.C4148a.k(r6, r8, r5, r2, r4)     // Catch: java.lang.Exception -> L32
            com.stepos.net.HttpManager r8 = com.stepos.net.HttpManager.INSTANCE     // Catch: java.lang.Exception -> L32
            java.lang.String r1 = "__default__"
            java.lang.Class<com.stepos.agentframework.adapter.netcore.service.a> r7 = com.stepos.agentframework.adapter.netcore.service.a.class
            java.lang.Object r8 = r8.create(r7, r1)     // Catch: java.lang.Exception -> L32
            com.stepos.agentframework.adapter.netcore.service.a r8 = (com.stepos.agentframework.adapter.netcore.service.a) r8     // Catch: java.lang.Exception -> L32
            r0.L$0 = r9     // Catch: java.lang.Exception -> L32
            r0.label = r3     // Catch: java.lang.Exception -> L32
            java.lang.Object r8 = r8.a(r4, r9, r0)     // Catch: java.lang.Exception -> L32
            if (r8 != r10) goto L6a
            return r10
        L6a:
            yc.v r8 = (yc.v) r8     // Catch: java.lang.Exception -> L32
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L32
            r10.<init>()     // Catch: java.lang.Exception -> L32
            java.lang.String r0 = " [Vote-4-Response] 服务器响应成功: response="
            r10.append(r0)     // Catch: java.lang.Exception -> L32
            r10.append(r8)     // Catch: java.lang.Exception -> L32
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Exception -> L32
            h8.C4148a.j(r6, r10, r3)     // Catch: java.lang.Exception -> L32
            java.lang.String r9 = r9.getTaskId()     // Catch: java.lang.Exception -> L32
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L32
            r10.<init>()     // Catch: java.lang.Exception -> L32
            java.lang.String r0 = " [Vote-4] HTTP请求成功! task_id="
            r10.append(r0)     // Catch: java.lang.Exception -> L32
            r10.append(r9)     // Catch: java.lang.Exception -> L32
            java.lang.String r9 = " 已上报到后端服务器"
            r10.append(r9)     // Catch: java.lang.Exception -> L32
            java.lang.String r9 = r10.toString()     // Catch: java.lang.Exception -> L32
            h8.C4148a.k(r6, r9, r5, r2, r4)     // Catch: java.lang.Exception -> L32
            boolean r5 = r8.f()     // Catch: java.lang.Exception -> L32
            goto Lba
        La2:
            java.lang.String r8 = r8.getMessage()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = " [Vote-4] HTTP请求失败: "
            r9.append(r10)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            h8.C4148a.h(r6, r8, r5, r2, r4)
        Lba:
            java.lang.Boolean r8 = g9.C4109a.a(r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.openclaw.OpenClawCoreAgentClient.u(K6.O, e9.c):java.lang.Object");
    }

    public final Message w0(C0918n request, String messageId, String traceId) {
        List listM;
        String type;
        MessageContent messageContent;
        List<AbstractC0913i> listJ = request.j();
        if (listJ != null) {
            listM = new ArrayList();
            for (AbstractC0913i abstractC0913i : listJ) {
                if (abstractC0913i instanceof AbstractC0913i.Text) {
                    messageContent = new MessageContent("text", ((AbstractC0913i.Text) abstractC0913i).getText(), null, null, null, null, null, null, null, null, null, null, null, false, null, null, 65532, null);
                } else if (abstractC0913i instanceof AbstractC0913i.Image) {
                    AbstractC0913i.Image image = (AbstractC0913i.Image) abstractC0913i;
                    messageContent = new MessageContent("image", null, null, image.getUri(), image.getUrl(), null, null, null, null, null, null, null, null, false, null, null, 65510, null);
                } else if (abstractC0913i instanceof AbstractC0913i.Audio) {
                    messageContent = new MessageContent("audio", null, null, ((AbstractC0913i.Audio) abstractC0913i).getUri(), null, null, null, null, null, null, null, null, null, false, null, null, 65526, null);
                } else if (abstractC0913i instanceof AbstractC0913i.Video) {
                    AbstractC0913i.Video video = (AbstractC0913i.Video) abstractC0913i;
                    messageContent = new MessageContent("video", null, null, video.getUri(), video.getUri(), null, null, null, null, null, null, null, null, false, null, null, 65510, null);
                } else if (abstractC0913i instanceof AbstractC0913i.File) {
                    AbstractC0913i.File file = (AbstractC0913i.File) abstractC0913i;
                    messageContent = new MessageContent(Const.STR_FILE, null, null, file.getUri(), null, null, null, null, file.getFileName(), null, file.getMimeType(), null, null, false, null, null, 64246, null);
                } else {
                    messageContent = null;
                }
                if (messageContent != null) {
                    listM.add(messageContent);
                }
            }
        } else {
            listM = C1173v.m();
        }
        List list = listM;
        String conversationId = request.getConversationId();
        if (list.size() > 1) {
            type = "multi";
        } else {
            MessageContent messageContent2 = (MessageContent) F.s0(list);
            if (messageContent2 == null || (type = messageContent2.getType()) == null) {
                type = "text";
            }
        }
        return new Message(null, messageId, false, conversationId, "user", "normal", type, list, null, null, 0, false, false, 0L, null, null, null, null, null, traceId, 524037, null);
    }

    public final j x0(RequestInfo requestInfo) {
        return new e(requestInfo);
    }

    @Override // com.stepos.agentframework.adapter.netcore.o
    public /* bridge */ void y(B b10) {
        super.y(b10);
    }

    /* renamed from: y0, reason: from getter */
    public final String getCHAT_ID() {
        return this.CHAT_ID;
    }

    public final AgentFrontClient z0(Context context) {
        AgentFrontClient agentFrontClient = this.agentFrontClient;
        if (agentFrontClient != null) {
            return agentFrontClient;
        }
        AgentFrontClient agentFrontClient2 = new AgentFrontClient(context, null, 2, null);
        this.agentFrontClient = agentFrontClient2;
        AgentFrontClient.INSTANCE.d(a.INSTANCE);
        agentFrontClient2.m0(this.sdkPushMessageListener);
        agentFrontClient2.z(new f());
        return agentFrontClient2;
    }
}
