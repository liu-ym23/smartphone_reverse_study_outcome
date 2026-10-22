package com.bytedance.applet.event;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common.apphost.AppHost;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.larus.utils.gson.TimeTransformAdapter;
import com.larus.utils.o0;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002./B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\b\u0010 \u001a\u00020\tH\u0016J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJb\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0018\u0010\u000fR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0019\u0010\u000fR\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d¨\u00060"}, d2 = {"Lcom/bytedance/applet/event/IMAppAction;", "", "appType", "", "messageId", "", "questionId", "createTime", "content", "", "messageType", "timeoutMs", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAppType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessageId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getQuestionId", "getCreateTime", "getContent", "()Ljava/lang/String;", "getMessageType", "getTimeoutMs", "mpParam", "Lcom/bytedance/applet/event/IMAppAction$IMMpParams;", "getMpParam", "()Lcom/bytedance/applet/event/IMAppAction$IMMpParams;", "mpParam$delegate", "Lkotlin/Lazy;", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/applet/event/IMAppAction;", "equals", "", "other", "hashCode", "Companion", "IMMpParams", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IMAppAction {
    public static final int ACTION_TYPE_SERVER_ACTION = 1;
    public static final int ACTION_TYPE_UI_ACTION = 2;
    public static final int ACTION_TYPE_UNDEFINED = 0;
    public static final int APP_TYPE_APPLET = 2;
    public static final int APP_TYPE_NATIVE = 1;
    public static final int APP_TYPE_RESERVED = 0;
    public static final a Companion = null;
    public static final int MESSAGE_TYPE_ACK = 2;
    public static final int MESSAGE_TYPE_MSG = 1;
    private static final Lazy<Gson> gson$delegate = null;

    @SerializedName("app_type")
    private final Integer appType;

    @SerializedName("content")
    private final String content;

    @SerializedName("create_time")
    @JsonAdapter(TimeTransformAdapter.class)
    private final Long createTime;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final Long messageId;

    @SerializedName("message_type")
    private final Integer messageType;
    private final Lazy mpParam$delegate;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID)
    private final Long questionId;

    @SerializedName(LocationMonitorConst.TIMEOUT_MS)
    private final Integer timeoutMs;

    public static final class a {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0017\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010HÆ\u0003Jª\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0007HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b \u0010\u0018R$\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00066"}, d2 = {"Lcom/bytedance/applet/event/IMAppAction$IMMpParams;", "", "botId", "", "conversationId", "mpAppId", ReportConstant.COMMON_ACTION_TYPE, "", "eventName", "data", "apiName", "pluginName", "toolName", "param", "timeoutMs", "featureMap", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)V", "getBotId", "()Ljava/lang/String;", "getConversationId", "getMpAppId", "getActionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEventName", "getData", "getApiName", "getPluginName", "getToolName", "getParam", "getTimeoutMs", "getFeatureMap", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)Lcom/bytedance/applet/event/IMAppAction$IMMpParams;", "equals", "", "other", "hashCode", "toString", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("action_type")
        private final Integer actionType;

        @SerializedName("api_name")
        private final String apiName;

        @SerializedName("bot_id")
        private final String botId;

        @SerializedName("conversation_id")
        private final String conversationId;

        @SerializedName("data")
        private final String data;

        @SerializedName(ReportCardMonitorPlugin.EVENT_NAME)
        private final String eventName;

        @SerializedName("feature_map")
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private final Map<String, String> featureMap;

        @SerializedName("mp_app_id")
        private final String mpAppId;

        @SerializedName("param")
        private final String param;

        @SerializedName("plugin_name")
        private final String pluginName;

        @SerializedName(LocationMonitorConst.TIMEOUT_MS)
        private final Integer timeoutMs;

        @SerializedName("tool_name")
        private final String toolName;

        public b() {
            this.botId = "";
            this.conversationId = "";
            this.mpAppId = "";
            this.actionType = 0;
            this.eventName = "";
            this.data = "";
            this.apiName = "";
            this.pluginName = "";
            this.toolName = "";
            this.param = "";
            this.timeoutMs = 0;
            this.featureMap = null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.mpAppId, r101.mpAppId) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.actionType, r101.actionType) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.eventName, r101.eventName) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.data, r101.data) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.apiName, r101.apiName) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.pluginName, r101.pluginName) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.toolName, r101.toolName) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.param, r101.param) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.timeoutMs, r101.timeoutMs) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.featureMap, r101.featureMap) == true) goto L44;
            return false;
        L44:
            return true;
        }

        public final int hashCode() {
            String r100 = this.botId;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.conversationId;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.mpAppId;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            Integer r110 = this.actionType;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.eventName;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.data;
            if (r116 != null) goto L25;
            int r117 = 0;
        L26:
            int r118 = (r115 + r117) * 31;
            String r119 = this.apiName;
            if (r119 != null) goto L29;
            int r120 = 0;
        L30:
            int r121 = (r118 + r120) * 31;
            String r122 = this.pluginName;
            if (r122 != null) goto L33;
            int r123 = 0;
        L34:
            int r124 = (r121 + r123) * 31;
            String r125 = this.toolName;
            if (r125 != null) goto L37;
            int r126 = 0;
        L38:
            int r127 = (r124 + r126) * 31;
            String r128 = this.param;
            if (r128 != null) goto L41;
            int r129 = 0;
        L42:
            int r130 = (r127 + r129) * 31;
            Integer r131 = this.timeoutMs;
            if (r131 != null) goto L45;
            int r132 = 0;
        L46:
            int r133 = (r130 + r132) * 31;
            Map<String, String> r134 = this.featureMap;
            if (r134 == null) goto L51;
            r101 = r134.hashCode();
        L51:
            return r133 + r101;
        L45:
            r132 = r131.hashCode();
            goto L46
        L41:
            r129 = r128.hashCode();
            goto L42
        L37:
            r126 = r125.hashCode();
            goto L38
        L33:
            r123 = r122.hashCode();
            goto L34
        L29:
            r120 = r119.hashCode();
            goto L30
        L25:
            r117 = r116.hashCode();
            goto L26
        L21:
            r114 = r113.hashCode();
            goto L22
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "IMMpParams(botId=" + this.botId + ", conversationId=" + this.conversationId + ", mpAppId=" + this.mpAppId + ", actionType=" + this.actionType + ", eventName=" + this.eventName + ", data=" + this.data + ", apiName=" + this.apiName + ", pluginName=" + this.pluginName + ", toolName=" + this.toolName + ", param=" + this.param + ", timeoutMs=" + this.timeoutMs + ", featureMap=" + this.featureMap + ')';
        }

        public final Integer a() {
            return this.actionType;
        }

        public final String b() {
            return this.apiName;
        }

        public final String c() {
            return this.botId;
        }

        public final String d() {
            return this.conversationId;
        }

        public final String e() {
            return this.data;
        }

        public final String f() {
            return this.eventName;
        }

        public final Map<String, String> g() {
            return this.featureMap;
        }

        public final String h() {
            return this.mpAppId;
        }

        public final String i() {
            return this.param;
        }

        public final String j() {
            return this.pluginName;
        }

        public final Integer k() {
            return this.timeoutMs;
        }

        public final String l() {
            return this.toolName;
        }
    }

    public IMAppAction() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ b a(IMAppAction r100) {
        return mpParam_delegate$lambda$0(r100);
    }

    public static /* synthetic */ Gson b() {
        return gson_delegate$lambda$1();
    }

    public static /* synthetic */ IMAppAction copy$default(IMAppAction r100, Integer r101, Long r102, Long r103, Long r104, String r110, Integer r111, Integer r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.appType;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.messageId;
    L8:
        Long r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.questionId;
    L11:
        Long r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.createTime;
    L14:
        Long r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.content;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.messageType;
    L20:
        Integer r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.timeoutMs;
    L23:
        Integer r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final Integer component1() {
        return this.appType;
    }

    public final Long component2() {
        return this.messageId;
    }

    public final Long component3() {
        return this.questionId;
    }

    public final Long component4() {
        return this.createTime;
    }

    public final String component5() {
        return this.content;
    }

    public final Integer component6() {
        return this.messageType;
    }

    public final Integer component7() {
        return this.timeoutMs;
    }

    public final IMAppAction copy(Integer r110, Long r111, Long r112, Long r113, String r114, Integer r115, Integer r116) {
        return new IMAppAction(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IMAppAction) == true) goto L8;
        return false;
    L8:
        IMAppAction r101 = (IMAppAction) r100;
        if (Intrinsics.areEqual(this.appType, r101.appType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.questionId, r101.questionId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.createTime, r101.createTime) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.messageType, r101.messageType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.timeoutMs, r101.timeoutMs) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.appType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.messageId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.questionId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.createTime;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.content;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.messageType;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.timeoutMs;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    static {
        Companion = new a();
        gson$delegate = LazyKt.lazy(new l());
    }

    private static final Gson gson_delegate$lambda$1() {
        return new Gson();
    }

    public final b getMpParam() {
        return (b) this.mpParam$delegate.getValue();
    }

    public String toString() {
        return "[appType=" + this.appType + ". messageId=" + this.messageId + ", questionId=" + this.questionId + ". msgType=" + this.messageType + ", timeoutMs=" + this.timeoutMs + ". content=" + this.content + ". ]";
    }

    public static final /* synthetic */ Lazy access$getGson$delegate$cp() {
        return gson$delegate;
    }

    public final Integer getAppType() {
        return this.appType;
    }

    public final String getContent() {
        return this.content;
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final Long getMessageId() {
        return this.messageId;
    }

    public final Integer getMessageType() {
        return this.messageType;
    }

    public final Long getQuestionId() {
        return this.questionId;
    }

    public final Integer getTimeoutMs() {
        return this.timeoutMs;
    }

    private static final b mpParam_delegate$lambda$0(IMAppAction r100) {
        String r101 = r100.content;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == false) goto L9;
        Companion.getClass();
        return (b) GsonProtectorUtils.fromJson((Gson) access$getGson$delegate$cp().getValue(), r100.content, b.class);
    L9:
        return null;
    L5:
        if (o0.d(r101) != true) goto L7;
        r102 = true;
        goto L7
    }

    public IMAppAction(Integer r100, Long r101, Long r102, Long r103, String r104, Integer r105, Integer r106) {
        this.appType = r100;
        this.messageId = r101;
        this.questionId = r102;
        this.createTime = r103;
        this.content = r104;
        this.messageType = r105;
        this.timeoutMs = r106;
        this.mpParam$delegate = LazyKt.lazy(new m(this));
    }

    public /* synthetic */ IMAppAction(Integer r100, Long r101, Long r102, Long r103, String r110, Integer r111, Integer r112, int r113, DefaultConstructorMarker r114) {
        String r104 = null;
        if ((r113 & 1) == 0) goto L5;
        Integer r115 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        Long r105 = null;
    L11:
        if ((r113 & 4) == 0) goto L13;
        Long r106 = null;
    L15:
        if ((r113 & 8) == 0) goto L17;
        r103 = Long.valueOf(AppHost.f326268a.getAppClock().currentTimeMillis());
    L17:
        Long r107 = r103;
        if ((r113 & 16) != 0) goto L22;
        r104 = r110;
    L22:
        if ((r113 & 32) == 0) goto L24;
        r111 = 1;
    L24:
        Integer r108 = r111;
        if ((r113 & 64) == 0) goto L27;
        r112 = 0;
    L27:
        this(r115, r105, r106, r107, r104, r108, r112);
        return;
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r115 = r100;
        goto L7
    }
}
