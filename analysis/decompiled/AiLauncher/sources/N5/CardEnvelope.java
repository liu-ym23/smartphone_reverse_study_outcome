package N5;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.taskstore.provider.c;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001Bë\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0015\u0012\u0018\b\u0002\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bJô\u0001\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00152\u0018\b\u0002\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\tHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010\u001fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010&\u001a\u0004\b(\u0010\u001fR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b)\u0010\u001fR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010&\u001a\u0004\b*\u0010\u001fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010&\u001a\u0004\b+\u0010\u001fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b,\u0010\u001fR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010-\u001a\u0004\b.\u0010/R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010&\u001a\u0004\b0\u0010\u001fR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010&\u001a\u0004\b1\u0010\u001fR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00102\u001a\u0004\b3\u00104R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u00105\u001a\u0004\b6\u00107R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u00108\u001a\u0004\b9\u0010:R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010;\u001a\u0004\b<\u0010=R'\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010>\u001a\u0004\b?\u0010@R'\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\u0017\u0010>\u001a\u0004\bA\u0010@R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010&\u001a\u0004\bB\u0010\u001fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\bC\u0010\u001f¨\u0006D"}, d2 = {"LN5/i;", "", "", "templateType", "taskId", "sessionId", "messageId", "toolCallId", "taskTitle", "", D6.a.KEY_TASK_STATUS, "displayMode", "bizChannel", "LN5/e;", "bizChannelIcon", "LN5/x;", c.a.COL_SUMMARY, "LN5/m;", "links", "LN5/w;", "searchSource", "", "businessData", "error", "platformOrderId", "clientRenderSource", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;LN5/e;LN5/x;LN5/m;LN5/w;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;LN5/e;LN5/x;LN5/m;LN5/w;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)LN5/i;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "r", "o", "m", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "s", "q", "Ljava/lang/Integer;", "p", "()Ljava/lang/Integer;", Const.INTENT_KEY_BACKGROUND_COMMAND, "c", "LN5/e;", Const.INTENT_KEY_UMID, "()LN5/e;", "LN5/x;", "n", "()LN5/x;", "LN5/m;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()LN5/m;", "LN5/w;", "l", "()LN5/w;", "Ljava/util/Map;", "e", "()Ljava/util/Map;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "k", "f", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: N5.i, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class CardEnvelope {
    private final String bizChannel;
    private final BizChannelIcon bizChannelIcon;
    private final Map<String, Object> businessData;

    @SerializedName("__client_render_source")
    private final String clientRenderSource;
    private final String displayMode;
    private final Map<String, Object> error;
    private final CardLinks links;
    private final String messageId;
    private final String platformOrderId;
    private final CardSearchSource searchSource;
    private final String sessionId;
    private final CardSummary summary;
    private final String taskId;
    private final Integer taskStatus;
    private final String taskTitle;

    @SerializedName(alternate = {"templateId"}, value = "templateType")
    private final String templateType;
    private final String toolCallId;

    public CardEnvelope() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    public static /* synthetic */ CardEnvelope b(CardEnvelope cardEnvelope, String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, BizChannelIcon bizChannelIcon, CardSummary cardSummary, CardLinks cardLinks, CardSearchSource cardSearchSource, Map map, Map map2, String str9, String str10, int i10, Object obj) {
        String str11;
        String str12;
        String str13;
        CardEnvelope cardEnvelope2;
        Map map3;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        Integer num2;
        String str19;
        String str20;
        BizChannelIcon bizChannelIcon2;
        CardSummary cardSummary2;
        CardLinks cardLinks2;
        CardSearchSource cardSearchSource2;
        Map map4;
        String str21 = (i10 & 1) != 0 ? cardEnvelope.templateType : str;
        String str22 = (i10 & 2) != 0 ? cardEnvelope.taskId : str2;
        String str23 = (i10 & 4) != 0 ? cardEnvelope.sessionId : str3;
        String str24 = (i10 & 8) != 0 ? cardEnvelope.messageId : str4;
        String str25 = (i10 & 16) != 0 ? cardEnvelope.toolCallId : str5;
        String str26 = (i10 & 32) != 0 ? cardEnvelope.taskTitle : str6;
        Integer num3 = (i10 & 64) != 0 ? cardEnvelope.taskStatus : num;
        String str27 = (i10 & 128) != 0 ? cardEnvelope.displayMode : str7;
        String str28 = (i10 & 256) != 0 ? cardEnvelope.bizChannel : str8;
        BizChannelIcon bizChannelIcon3 = (i10 & 512) != 0 ? cardEnvelope.bizChannelIcon : bizChannelIcon;
        CardSummary cardSummary3 = (i10 & 1024) != 0 ? cardEnvelope.summary : cardSummary;
        CardLinks cardLinks3 = (i10 & 2048) != 0 ? cardEnvelope.links : cardLinks;
        CardSearchSource cardSearchSource3 = (i10 & 4096) != 0 ? cardEnvelope.searchSource : cardSearchSource;
        Map map5 = (i10 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? cardEnvelope.businessData : map;
        String str29 = str21;
        Map map6 = (i10 & 16384) != 0 ? cardEnvelope.error : map2;
        String str30 = (i10 & 32768) != 0 ? cardEnvelope.platformOrderId : str9;
        if ((i10 & 65536) != 0) {
            str12 = str30;
            str11 = cardEnvelope.clientRenderSource;
            map3 = map6;
            str14 = str22;
            str15 = str23;
            str16 = str24;
            str17 = str25;
            str18 = str26;
            num2 = num3;
            str19 = str27;
            str20 = str28;
            bizChannelIcon2 = bizChannelIcon3;
            cardSummary2 = cardSummary3;
            cardLinks2 = cardLinks3;
            cardSearchSource2 = cardSearchSource3;
            map4 = map5;
            str13 = str29;
            cardEnvelope2 = cardEnvelope;
        } else {
            str11 = str10;
            str12 = str30;
            str13 = str29;
            cardEnvelope2 = cardEnvelope;
            map3 = map6;
            str14 = str22;
            str15 = str23;
            str16 = str24;
            str17 = str25;
            str18 = str26;
            num2 = num3;
            str19 = str27;
            str20 = str28;
            bizChannelIcon2 = bizChannelIcon3;
            cardSummary2 = cardSummary3;
            cardLinks2 = cardLinks3;
            cardSearchSource2 = cardSearchSource3;
            map4 = map5;
        }
        return cardEnvelope2.a(str13, str14, str15, str16, str17, str18, num2, str19, str20, bizChannelIcon2, cardSummary2, cardLinks2, cardSearchSource2, map4, map3, str12, str11);
    }

    public final CardEnvelope a(String templateType, String taskId, String sessionId, String messageId, String toolCallId, String taskTitle, Integer taskStatus, String displayMode, String bizChannel, BizChannelIcon bizChannelIcon, CardSummary summary, CardLinks links, CardSearchSource searchSource, Map<String, ? extends Object> businessData, Map<String, ? extends Object> error, String platformOrderId, String clientRenderSource) {
        kotlin.jvm.internal.p.i(templateType, "templateType");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        return new CardEnvelope(templateType, taskId, sessionId, messageId, toolCallId, taskTitle, taskStatus, displayMode, bizChannel, bizChannelIcon, summary, links, searchSource, businessData, error, platformOrderId, clientRenderSource);
    }

    /* renamed from: c, reason: from getter */
    public final String getBizChannel() {
        return this.bizChannel;
    }

    /* renamed from: d, reason: from getter */
    public final BizChannelIcon getBizChannelIcon() {
        return this.bizChannelIcon;
    }

    public final Map<String, Object> e() {
        return this.businessData;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardEnvelope)) {
            return false;
        }
        CardEnvelope cardEnvelope = (CardEnvelope) other;
        return kotlin.jvm.internal.p.d(this.templateType, cardEnvelope.templateType) && kotlin.jvm.internal.p.d(this.taskId, cardEnvelope.taskId) && kotlin.jvm.internal.p.d(this.sessionId, cardEnvelope.sessionId) && kotlin.jvm.internal.p.d(this.messageId, cardEnvelope.messageId) && kotlin.jvm.internal.p.d(this.toolCallId, cardEnvelope.toolCallId) && kotlin.jvm.internal.p.d(this.taskTitle, cardEnvelope.taskTitle) && kotlin.jvm.internal.p.d(this.taskStatus, cardEnvelope.taskStatus) && kotlin.jvm.internal.p.d(this.displayMode, cardEnvelope.displayMode) && kotlin.jvm.internal.p.d(this.bizChannel, cardEnvelope.bizChannel) && kotlin.jvm.internal.p.d(this.bizChannelIcon, cardEnvelope.bizChannelIcon) && kotlin.jvm.internal.p.d(this.summary, cardEnvelope.summary) && kotlin.jvm.internal.p.d(this.links, cardEnvelope.links) && kotlin.jvm.internal.p.d(this.searchSource, cardEnvelope.searchSource) && kotlin.jvm.internal.p.d(this.businessData, cardEnvelope.businessData) && kotlin.jvm.internal.p.d(this.error, cardEnvelope.error) && kotlin.jvm.internal.p.d(this.platformOrderId, cardEnvelope.platformOrderId) && kotlin.jvm.internal.p.d(this.clientRenderSource, cardEnvelope.clientRenderSource);
    }

    /* renamed from: f, reason: from getter */
    public final String getClientRenderSource() {
        return this.clientRenderSource;
    }

    /* renamed from: g, reason: from getter */
    public final String getDisplayMode() {
        return this.displayMode;
    }

    public final Map<String, Object> h() {
        return this.error;
    }

    public int hashCode() {
        int iHashCode = ((this.templateType.hashCode() * 31) + this.taskId.hashCode()) * 31;
        String str = this.sessionId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.messageId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.toolCallId;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.taskTitle;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.taskStatus;
        int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.displayMode;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.bizChannel;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        BizChannelIcon bizChannelIcon = this.bizChannelIcon;
        int iHashCode9 = (iHashCode8 + (bizChannelIcon == null ? 0 : bizChannelIcon.hashCode())) * 31;
        CardSummary cardSummary = this.summary;
        int iHashCode10 = (iHashCode9 + (cardSummary == null ? 0 : cardSummary.hashCode())) * 31;
        CardLinks cardLinks = this.links;
        int iHashCode11 = (iHashCode10 + (cardLinks == null ? 0 : cardLinks.hashCode())) * 31;
        CardSearchSource cardSearchSource = this.searchSource;
        int iHashCode12 = (iHashCode11 + (cardSearchSource == null ? 0 : cardSearchSource.hashCode())) * 31;
        Map<String, Object> map = this.businessData;
        int iHashCode13 = (iHashCode12 + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, Object> map2 = this.error;
        int iHashCode14 = (iHashCode13 + (map2 == null ? 0 : map2.hashCode())) * 31;
        String str7 = this.platformOrderId;
        int iHashCode15 = (iHashCode14 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.clientRenderSource;
        return iHashCode15 + (str8 != null ? str8.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final CardLinks getLinks() {
        return this.links;
    }

    /* renamed from: j, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: k, reason: from getter */
    public final String getPlatformOrderId() {
        return this.platformOrderId;
    }

    /* renamed from: l, reason: from getter */
    public final CardSearchSource getSearchSource() {
        return this.searchSource;
    }

    /* renamed from: m, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: n, reason: from getter */
    public final CardSummary getSummary() {
        return this.summary;
    }

    /* renamed from: o, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: p, reason: from getter */
    public final Integer getTaskStatus() {
        return this.taskStatus;
    }

    /* renamed from: q, reason: from getter */
    public final String getTaskTitle() {
        return this.taskTitle;
    }

    /* renamed from: r, reason: from getter */
    public final String getTemplateType() {
        return this.templateType;
    }

    /* renamed from: s, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    public String toString() {
        return "CardEnvelope(templateType=" + this.templateType + ", taskId=" + this.taskId + ", sessionId=" + this.sessionId + ", messageId=" + this.messageId + ", toolCallId=" + this.toolCallId + ", taskTitle=" + this.taskTitle + ", taskStatus=" + this.taskStatus + ", displayMode=" + this.displayMode + ", bizChannel=" + this.bizChannel + ", bizChannelIcon=" + this.bizChannelIcon + ", summary=" + this.summary + ", links=" + this.links + ", searchSource=" + this.searchSource + ", businessData=" + this.businessData + ", error=" + this.error + ", platformOrderId=" + this.platformOrderId + ", clientRenderSource=" + this.clientRenderSource + ")";
    }

    public CardEnvelope(String templateType, String taskId, String str, String str2, String str3, String str4, Integer num, String str5, String str6, BizChannelIcon bizChannelIcon, CardSummary cardSummary, CardLinks cardLinks, CardSearchSource cardSearchSource, Map<String, ? extends Object> map, Map<String, ? extends Object> map2, String str7, String str8) {
        kotlin.jvm.internal.p.i(templateType, "templateType");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        this.templateType = templateType;
        this.taskId = taskId;
        this.sessionId = str;
        this.messageId = str2;
        this.toolCallId = str3;
        this.taskTitle = str4;
        this.taskStatus = num;
        this.displayMode = str5;
        this.bizChannel = str6;
        this.bizChannelIcon = bizChannelIcon;
        this.summary = cardSummary;
        this.links = cardLinks;
        this.searchSource = cardSearchSource;
        this.businessData = map;
        this.error = map2;
        this.platformOrderId = str7;
        this.clientRenderSource = str8;
    }

    public /* synthetic */ CardEnvelope(String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, String str8, BizChannelIcon bizChannelIcon, CardSummary cardSummary, CardLinks cardLinks, CardSearchSource cardSearchSource, Map map, Map map2, String str9, String str10, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) == 0 ? str2 : "", (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6, (i10 & 64) != 0 ? null : num, (i10 & 128) != 0 ? null : str7, (i10 & 256) != 0 ? null : str8, (i10 & 512) != 0 ? null : bizChannelIcon, (i10 & 1024) != 0 ? null : cardSummary, (i10 & 2048) != 0 ? null : cardLinks, (i10 & 4096) != 0 ? null : cardSearchSource, (i10 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? null : map, (i10 & 16384) != 0 ? null : map2, (i10 & 32768) != 0 ? null : str9, (i10 & 65536) != 0 ? null : str10);
    }
}
