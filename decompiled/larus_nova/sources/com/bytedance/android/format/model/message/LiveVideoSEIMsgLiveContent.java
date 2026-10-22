package com.bytedance.android.format.model.message;

import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0005/0123B\u0007¢\u0006\u0004\b-\u0010.R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001d\u0010\u000bR\u001a\u0010\u001e\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u001f\u0010\t\u001a\u0004\b \u0010\u000bR\u001a\u0010!\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\f\n\u0004\b!\u0010\u0010\u001a\u0004\b\"\u0010\u0012R\u001c\u0010$\u001a\u0004\u0018\u00010#8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010)\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,¨\u00064"}, d2 = {"Lcom/bytedance/android/format/model/message/LiveVideoSEIMsgLiveContent;", "", "", "contentId", "Ljava/lang/String;", "getContentId", "()Ljava/lang/String;", "", "mode", "I", "getMode", "()I", "text", "getText", "", "loading", "Z", "getLoading", "()Z", RemoteMessageConst.MSGID, "getMsgId", "respForMsgId", "getRespForMsgId", "", "respForMsgIdList", "Ljava/util/List;", "getRespForMsgIdList", "()Ljava/util/List;", "triggerType", "getTriggerType", "isDescText", "contentType", "getContentType", "hasAudio", "getHasAudio", "Lcom/bytedance/android/format/model/message/LiveVideoSEIMsgLiveContent$b;", "respForUserInfo", "Lcom/bytedance/android/format/model/message/LiveVideoSEIMsgLiveContent$b;", "getRespForUserInfo", "()Lcom/bytedance/android/format/model/message/LiveVideoSEIMsgLiveContent$b;", "Lcom/bytedance/android/format/model/message/LiveVideoSEIMsgLiveContent$a;", "agentToolInfo", "Lcom/bytedance/android/format/model/message/LiveVideoSEIMsgLiveContent$a;", "getAgentToolInfo", "()Lcom/bytedance/android/format/model/message/LiveVideoSEIMsgLiveContent$a;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LiveContentPresentMode", "LiveContentReplyType", "LiveContentTriggerType", "b", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveVideoSEIMsgLiveContent {

    @SerializedName("agent_tool_info")
    private final a agentToolInfo;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID)
    private final String contentId;

    @SerializedName("content_type")
    private final int contentType;

    @SerializedName("has_audio")
    private final boolean hasAudio;

    @SerializedName("is_desc_text")
    private final boolean isDescText;

    @SerializedName("loading")
    private final boolean loading;

    @SerializedName("mode")
    private final int mode;

    @SerializedName("msg_id")
    private final String msgId;

    @SerializedName("resp_for_msg_id")
    private final String respForMsgId;

    @SerializedName("resp_for_msg_id_list")
    private final List<String> respForMsgIdList;

    @SerializedName("resp_for_user_info")
    private final b respForUserInfo;

    @SerializedName("text")
    private final String text;

    @SerializedName("trigger_type")
    private final int triggerType;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/format/model/message/LiveVideoSEIMsgLiveContent$LiveContentPresentMode;", "", "", "mode", "I", "getMode", "()I", "LiveContentPresentMode_SelfTalk", "LiveContentPresentMode_Subtitle", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LiveContentPresentMode extends Enum<LiveContentPresentMode> {
        public static final LiveContentPresentMode LiveContentPresentMode_SelfTalk = null;
        public static final LiveContentPresentMode LiveContentPresentMode_Subtitle = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LiveContentPresentMode[] f51358a = null;
        private final int mode;

        static {
            LiveContentPresentMode r100 = new LiveContentPresentMode("LiveContentPresentMode_SelfTalk", 0, 1);
            LiveContentPresentMode_SelfTalk = r100;
            LiveContentPresentMode r101 = new LiveContentPresentMode("LiveContentPresentMode_Subtitle", 1, 2);
            LiveContentPresentMode_Subtitle = r101;
            f51358a = new LiveContentPresentMode[]{r100, r101};
        }

        public static LiveContentPresentMode valueOf(String r100) {
            return (LiveContentPresentMode) r27.a.a(LiveContentPresentMode.class, r100);
        }

        public static LiveContentPresentMode[] values() {
            return (LiveContentPresentMode[]) f51358a.clone();
        }

        public final int getMode() {
            return this.mode;
        }

        public LiveContentPresentMode(String r100, int r101, int r102) {
            super(r100, r101);
            this.mode = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/format/model/message/LiveVideoSEIMsgLiveContent$LiveContentReplyType;", "", "", "mode", "I", "getMode", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LiveContentType_Default", "LiveContentType_OpeningChat", "LiveContentType_PreCohesion", "LiveContentType_PostCohesion", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LiveContentReplyType extends Enum<LiveContentReplyType> {
        public static final a Companion = null;
        public static final LiveContentReplyType LiveContentType_Default = null;
        public static final LiveContentReplyType LiveContentType_OpeningChat = null;
        public static final LiveContentReplyType LiveContentType_PostCohesion = null;
        public static final LiveContentReplyType LiveContentType_PreCohesion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LiveContentReplyType[] f51359a = null;
        private final int mode;

        public static final class a {
            public a() {
            }
        }

        static {
            LiveContentReplyType r100 = new LiveContentReplyType("LiveContentType_Default", 0, 0);
            LiveContentType_Default = r100;
            LiveContentReplyType r101 = new LiveContentReplyType("LiveContentType_OpeningChat", 1, 1);
            LiveContentType_OpeningChat = r101;
            LiveContentReplyType r102 = new LiveContentReplyType("LiveContentType_PreCohesion", 2, 2);
            LiveContentType_PreCohesion = r102;
            LiveContentReplyType r103 = new LiveContentReplyType("LiveContentType_PostCohesion", 3, 3);
            LiveContentType_PostCohesion = r103;
            f51359a = new LiveContentReplyType[]{r100, r101, r102, r103};
            Companion = new a();
        }

        public static LiveContentReplyType valueOf(String r100) {
            return (LiveContentReplyType) r27.a.a(LiveContentReplyType.class, r100);
        }

        public static LiveContentReplyType[] values() {
            return (LiveContentReplyType[]) f51359a.clone();
        }

        public final int getMode() {
            return this.mode;
        }

        public LiveContentReplyType(String r100, int r101, int r102) {
            super(r100, r101);
            this.mode = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/format/model/message/LiveVideoSEIMsgLiveContent$LiveContentTriggerType;", "", "", "mode", "I", "getMode", "()I", "LiveContentTriggerType_Invalid", "LiveContentTriggerType_Next", "LiveContentTriggerType_Interrupt", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LiveContentTriggerType extends Enum<LiveContentTriggerType> {
        public static final LiveContentTriggerType LiveContentTriggerType_Interrupt = null;
        public static final LiveContentTriggerType LiveContentTriggerType_Invalid = null;
        public static final LiveContentTriggerType LiveContentTriggerType_Next = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LiveContentTriggerType[] f51360a = null;
        private final int mode;

        static {
            LiveContentTriggerType r100 = new LiveContentTriggerType("LiveContentTriggerType_Invalid", 0, 0);
            LiveContentTriggerType_Invalid = r100;
            LiveContentTriggerType r101 = new LiveContentTriggerType("LiveContentTriggerType_Next", 1, 1);
            LiveContentTriggerType_Next = r101;
            LiveContentTriggerType r102 = new LiveContentTriggerType("LiveContentTriggerType_Interrupt", 2, 2);
            LiveContentTriggerType_Interrupt = r102;
            f51360a = new LiveContentTriggerType[]{r100, r101, r102};
        }

        public static LiveContentTriggerType valueOf(String r100) {
            return (LiveContentTriggerType) r27.a.a(LiveContentTriggerType.class, r100);
        }

        public static LiveContentTriggerType[] values() {
            return (LiveContentTriggerType[]) f51360a.clone();
        }

        public final int getMode() {
            return this.mode;
        }

        public LiveContentTriggerType(String r100, int r101, int r102) {
            super(r100, r101);
            this.mode = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/format/model/message/LiveVideoSEIMsgLiveContent$a;", "", "", "toolType", "Ljava/lang/String;", "getToolType", "()Ljava/lang/String;", "setToolType", "(Ljava/lang/String;)V", "toolId", "getToolId", "setToolId", "description", "getDescription", "setDescription", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("description")
        private String description;

        @SerializedName("tool_id")
        private String toolId;

        @SerializedName("tool_type")
        private String toolType;

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/format/model/message/LiveVideoSEIMsgLiveContent$b;", "", "", "userId", "Ljava/lang/Long;", "getUserId", "()Ljava/lang/Long;", "setUserId", "(Ljava/lang/Long;)V", "", "userName", "Ljava/lang/String;", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("user_id")
        private Long userId;

        @SerializedName(ITwitterService.ResponseConstants.USER_NAME)
        private String userName;

        public b() {
        }
    }

    public LiveVideoSEIMsgLiveContent() {
    }
}
