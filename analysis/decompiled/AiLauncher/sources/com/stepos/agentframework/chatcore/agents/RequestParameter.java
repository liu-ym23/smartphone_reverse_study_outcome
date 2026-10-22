package com.stepos.agentframework.chatcore.agents;

import I4.ResultBean;
import La.K;
import Z8.C1173v;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.AbstractC0913i;
import kotlin.Metadata;
import r4.C5218a;
import u4.AgentMessage;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0015\u0018\u0000 T2\u00020\u0001:\u0001UB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\u000bR(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\u000bR\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\b\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\u000bR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R>\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020)0(j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020)`*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00101\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010>\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010 \u001a\u0004\b?\u0010\"\"\u0004\b@\u0010$R0\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010H\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010\b\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\u000bR$\u0010K\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010\b\u001a\u0004\bL\u0010\u0006\"\u0004\bM\u0010\u000bR\"\u0010N\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010\b\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\u000bR$\u0010Q\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010\b\u001a\u0004\bR\u0010\u0006\"\u0004\bS\u0010\u000b¨\u0006V"}, d2 = {"Lcom/stepos/agentframework/chatcore/agents/y;", "", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "agentId", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "r", "(Ljava/lang/String;)V", "deviceId", "e", "u", "", "LK6/i;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Ljava/util/List;", Const.INTENT_KEY_UMID, "()Ljava/util/List;", "s", "(Ljava/util/List;)V", "secretkey$1", "k", "z", "secretkey", "sessionId", "l", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "isDeepThink", "Z", "p", "()Z", "t", "(Z)V", "isToolResult", "q", "C", "Ljava/util/HashMap;", "LI4/a;", "Lkotlin/collections/HashMap;", "toolResult", "Ljava/util/HashMap;", "n", "()Ljava/util/HashMap;", "setToolResult", "(Ljava/util/HashMap;)V", "extra", "Ljava/lang/Object;", "f", "()Ljava/lang/Object;", "setExtra", "(Ljava/lang/Object;)V", "LK6/i$b;", "audio", "LK6/i$b;", "c", "()LK6/i$b;", "setAudio", "(LK6/i$b;)V", "stream", "m", "B", "", "meta", "Ljava/util/Map;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/util/Map;", "x", "(Ljava/util/Map;)V", DidiCardProvider.KEY_TRACE_ID, "o", "D", "messageId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "w", "guiAgentModelName", Const.INTENT_KEY_BACKGROUND_COMMAND, "v", "regenerateRunId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "y", "Companion", Const.INTENT_KEY_APIKEY, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.agents.y, reason: from toString */
/* loaded from: classes2.dex */
public final class RequestParameter {
    public static final String META_KEY_ACTIVE_FILE_ID = "active_file_id";
    public static final String META_KEY_ACTIVE_FILE_PATH = "active_file_path";
    public static final String META_KEY_FILE_MESSAGE_ID = "file_message_id";
    public static final String META_KEY_IMAGE_MESSAGE_ID = "image_message_id";
    public static final String META_KEY_MESSAGE_ID = "message_id";
    public static final String META_KEY_MSG_SOURCE = "msg_source";
    private AbstractC0913i.AudioStream audio;
    private String deviceId;
    private Object extra;
    private boolean isDeepThink;
    private boolean isToolResult;
    private String messageId;
    private Map<String, String> meta;
    private String regenerateRunId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String secretkey = "sat_5n8vHo96TRLBdygUqZnwCjLc33jd9LxkY2sZSq5FwxvBUiVVTISaOkoO1DjvEr9d";
    private static final String TAG = "RequestParameter";
    private String agentId = "";
    private List<? extends AbstractC0913i> content = C1173v.m();

    /* renamed from: secretkey$1, reason: from kotlin metadata */
    private String secretkey = "sat_5n8vHo96TRLBdygUqZnwCjLc33jd9LxkY2sZSq5FwxvBUiVVTISaOkoO1DjvEr9d";
    private String sessionId = "";
    private HashMap<String, ResultBean> toolResult = new HashMap<>();
    private boolean stream = true;
    private String traceId = "";
    private String guiAgentModelName = "doubao-1.5-ui-tars";

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJm\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u001dR\u0014\u0010!\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\u001dR\u0014\u0010\"\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\u001dR\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b#\u0010\u001d¨\u0006$"}, d2 = {"Lcom/stepos/agentframework/chatcore/agents/y$a;", "", "<init>", "()V", "", UxipConstants.f30680s, "c", "(Ljava/lang/String;)Ljava/lang/String;", "", "Lu4/a;", "messages", "", "deepThinking", "LK6/i;", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;Ljava/lang/Boolean;)Ljava/util/List;", "agentId", "sessionId", "stream", "", "meta", DidiCardProvider.KEY_TRACE_ID, "deviceId", "Lcom/stepos/agentframework/chatcore/agents/y;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZLjava/util/Map;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/agents/y;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Boolean;)Ljava/lang/String;", "META_KEY_MESSAGE_ID", "Ljava/lang/String;", "META_KEY_IMAGE_MESSAGE_ID", "META_KEY_FILE_MESSAGE_ID", "META_KEY_MSG_SOURCE", "META_KEY_ACTIVE_FILE_ID", "META_KEY_ACTIVE_FILE_PATH", "TAG", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatcore.agents.y$a, reason: from kotlin metadata */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.agentframework.chatcore.agents.y$a$a, reason: collision with other inner class name */
        public static final /* synthetic */ class C0249a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AgentMessageType.values().length];
                try {
                    iArr[AgentMessageType.TEXT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AgentMessageType.IMAGE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AgentMessageType.FILE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AgentMessageType.AUDIO.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final String a(Boolean deepThinking) {
            return deepThinking == null ? "" : deepThinking.booleanValue() ? "深度思考:" : "极速模式";
        }

        public final List<AbstractC0913i> b(List<AgentMessage> messages, Boolean deepThinking) {
            kotlin.jvm.internal.p.i(messages, "messages");
            ArrayList arrayList = new ArrayList();
            for (AgentMessage agentMessage : messages) {
                C4148a.d(RequestParameter.TAG, "fromAgentMessage it.type: " + agentMessage.getType(), false, 4, null);
                int i10 = C0249a.$EnumSwitchMapping$0[agentMessage.getType().ordinal()];
                if (i10 == 1) {
                    String strB = O6.f.INSTANCE.b(agentMessage.getContent().h());
                    arrayList.add(new AbstractC0913i.Text(RequestParameter.INSTANCE.a(deepThinking) + strB));
                } else if (i10 == 2) {
                    C4148a.d(RequestParameter.TAG, "fromAgentMessage IMAGE hiddenInUi=" + agentMessage.getHiddenInUi() + " fileId=" + agentMessage.getContent().f() + " url=" + agentMessage.getContent().g(), false, 4, null);
                    arrayList.add(new AbstractC0913i.Image(agentMessage.getContent().f(), null, null, null, null, agentMessage.getContent().g(), null, 94, null));
                } else if (i10 == 3) {
                    arrayList.add(new AbstractC0913i.File(agentMessage.getContent().d(), null, agentMessage.getContent().e(), null, null, null, null, 122, null));
                }
            }
            return arrayList;
        }

        public final String c(String value) {
            kotlin.jvm.internal.p.i(value, "value");
            if (value.length() == 0) {
                return "";
            }
            if (value.length() <= 8) {
                return "***";
            }
            return K.R1(value, 4) + "***" + K.S1(value, 4);
        }

        public final RequestParameter d(String agentId, String sessionId, List<AgentMessage> messages, boolean deepThinking, boolean stream, Map<String, String> meta, String traceId, String deviceId) {
            kotlin.jvm.internal.p.i(agentId, "agentId");
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            kotlin.jvm.internal.p.i(messages, "messages");
            kotlin.jvm.internal.p.i(traceId, "traceId");
            RequestParameter requestParameter = new RequestParameter();
            requestParameter.C(false);
            requestParameter.r(agentId);
            requestParameter.u(deviceId);
            requestParameter.s(RequestParameter.INSTANCE.b(messages, null));
            requestParameter.A(sessionId);
            requestParameter.t(deepThinking);
            requestParameter.B(stream);
            requestParameter.D(traceId);
            C5218a.Companion companion = C5218a.INSTANCE;
            if (companion.b() != null || meta != null) {
                Map<String, String> mapB = companion.b();
                if (mapB == null) {
                    mapB = kotlin.collections.a.i();
                }
                requestParameter.x(kotlin.collections.a.r(mapB, meta == null ? kotlin.collections.a.i() : meta));
            }
            requestParameter.w(meta != null ? meta.get(RequestParameter.META_KEY_MESSAGE_ID) : null);
            requestParameter.v(companion.a());
            return requestParameter;
        }

        public Companion() {
        }
    }

    public final void A(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.sessionId = str;
    }

    public final void B(boolean z10) {
        this.stream = z10;
    }

    public final void C(boolean z10) {
        this.isToolResult = z10;
    }

    public final void D(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.traceId = str;
    }

    /* renamed from: b, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: c, reason: from getter */
    public final AbstractC0913i.AudioStream getAudio() {
        return this.audio;
    }

    public final List<AbstractC0913i> d() {
        return this.content;
    }

    /* renamed from: e, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: f, reason: from getter */
    public final Object getExtra() {
        return this.extra;
    }

    /* renamed from: g, reason: from getter */
    public final String getGuiAgentModelName() {
        return this.guiAgentModelName;
    }

    /* renamed from: h, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    public final Map<String, String> i() {
        return this.meta;
    }

    /* renamed from: j, reason: from getter */
    public final String getRegenerateRunId() {
        return this.regenerateRunId;
    }

    /* renamed from: k, reason: from getter */
    public final String getSecretkey() {
        return this.secretkey;
    }

    /* renamed from: l, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getStream() {
        return this.stream;
    }

    public final HashMap<String, ResultBean> n() {
        return this.toolResult;
    }

    /* renamed from: o, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getIsDeepThink() {
        return this.isDeepThink;
    }

    /* renamed from: q, reason: from getter */
    public final boolean getIsToolResult() {
        return this.isToolResult;
    }

    public final void r(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.agentId = str;
    }

    public final void s(List<? extends AbstractC0913i> list) {
        kotlin.jvm.internal.p.i(list, "<set-?>");
        this.content = list;
    }

    public final void t(boolean z10) {
        this.isDeepThink = z10;
    }

    public String toString() {
        return "RequestParameter(agentId='" + this.agentId + "', contentParts=" + this.content.size() + ", secretkey='" + INSTANCE.c(this.secretkey) + "', sessionId='" + this.sessionId + "', isDeepThink=" + this.isDeepThink + ", isToolResult=" + this.isToolResult + ", toolResultSize=" + this.toolResult.size() + ", extra=" + this.extra + ", audio=" + this.audio + ", stream=" + this.stream + ", meta=" + this.meta + ", traceId='" + this.traceId + "', guiAgentModelName='" + this.guiAgentModelName + "')";
    }

    public final void u(String str) {
        this.deviceId = str;
    }

    public final void v(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.guiAgentModelName = str;
    }

    public final void w(String str) {
        this.messageId = str;
    }

    public final void x(Map<String, String> map) {
        this.meta = map;
    }

    public final void y(String str) {
        this.regenerateRunId = str;
    }

    public final void z(String str) {
        kotlin.jvm.internal.p.i(str, "<set-?>");
        this.secretkey = str;
    }
}
