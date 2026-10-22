package com.stepos.ailauncher.taskstore.livenotification;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.NetworkPhase;
import com.stepos.ailauncher.contract.api.livenotification.RiskLiveButton;
import com.stepos.ame.sdk.SkillStoreKt;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b.\b\u0080\b\u0018\u00002\u00020\u0001Bé\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010'\u001a\u00020\u00192\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010#R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010)\u001a\u0004\b+\u0010#R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010)\u001a\u0004\b,\u0010#R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010)\u001a\u0004\b-\u0010#R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010)\u001a\u0004\b.\u0010#R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010)\u001a\u0004\b/\u0010#R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010)\u001a\u0004\b0\u0010#R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010)\u001a\u0004\b1\u0010#R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u00102\u001a\u0004\b3\u0010%R\u0017\u0010\r\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\r\u00102\u001a\u0004\b4\u0010%R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010)\u001a\u0004\b5\u0010#R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u000f\u00106\u001a\u0004\b7\u00108R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u0010\u00106\u001a\u0004\b9\u00108R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010:\u001a\u0004\b;\u0010<R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b=\u0010#R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006¢\u0006\f\n\u0004\b\u0016\u0010>\u001a\u0004\b?\u0010@R\u0017\u0010\u0017\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\bA\u0010#R\u0017\u0010\u0018\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010)\u001a\u0004\bB\u0010#R\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010C\u001a\u0004\bD\u0010ER\u0017\u0010\u001b\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001b\u0010C\u001a\u0004\bF\u0010ER\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010)\u001a\u0004\bG\u0010#R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010)\u001a\u0004\bH\u0010#R\u0017\u0010\u001f\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010I\u001a\u0004\bJ\u0010K¨\u0006L"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/f;", "", "", "sessionId", "type", "title", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "capsuleText", "customTitle", "customContent", "status", "", "capsuleContentColor", "capsuleBgColor", "statusText", "cardImageRes", "iconOverlayRes", "Lcom/stepos/ailauncher/common/utils/NetworkPhase;", "networkPhase", "riskRequestId", "", "Lcom/stepos/ailauncher/contract/api/livenotification/RiskLiveButton;", "riskButtons", "riskBody", "riskLevel", "", "contentOnly", "floatOverlay", "clickAppLink", "clickSessionId", "", "timeoutAfterMs", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/stepos/ailauncher/common/utils/NetworkPhase;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;J)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "r", "w", "v", Const.INTENT_KEY_BACKGROUND_COMMAND, "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "s", "I", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "t", "Ljava/lang/Integer;", Const.INTENT_KEY_UMID, "()Ljava/lang/Integer;", "l", "Lcom/stepos/ailauncher/common/utils/NetworkPhase;", "m", "()Lcom/stepos/ailauncher/common/utils/NetworkPhase;", "q", "Ljava/util/List;", "o", "()Ljava/util/List;", "n", "p", "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Z", "k", "e", "f", "J", "u", "()J", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.livenotification.f, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class LiveNotificationParams {
    private final int capsuleBgColor;
    private final int capsuleContentColor;
    private final String capsuleText;
    private final Integer cardImageRes;
    private final String clickAppLink;
    private final String clickSessionId;
    private final String content;
    private final boolean contentOnly;
    private final String customContent;
    private final String customTitle;
    private final boolean floatOverlay;
    private final Integer iconOverlayRes;
    private final NetworkPhase networkPhase;
    private final String riskBody;
    private final List<RiskLiveButton> riskButtons;
    private final String riskLevel;
    private final String riskRequestId;
    private final String sessionId;
    private final String status;
    private final String statusText;
    private final long timeoutAfterMs;
    private final String title;
    private final String type;

    public LiveNotificationParams(String sessionId, String type, String title, String content, String capsuleText, String customTitle, String customContent, String status, int i10, int i11, String statusText, Integer num, Integer num2, NetworkPhase networkPhase, String str, List<RiskLiveButton> riskButtons, String riskBody, String riskLevel, boolean z10, boolean z11, String str2, String str3, long j10) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(type, "type");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(content, "content");
        kotlin.jvm.internal.p.i(capsuleText, "capsuleText");
        kotlin.jvm.internal.p.i(customTitle, "customTitle");
        kotlin.jvm.internal.p.i(customContent, "customContent");
        kotlin.jvm.internal.p.i(status, "status");
        kotlin.jvm.internal.p.i(statusText, "statusText");
        kotlin.jvm.internal.p.i(networkPhase, "networkPhase");
        kotlin.jvm.internal.p.i(riskButtons, "riskButtons");
        kotlin.jvm.internal.p.i(riskBody, "riskBody");
        kotlin.jvm.internal.p.i(riskLevel, "riskLevel");
        this.sessionId = sessionId;
        this.type = type;
        this.title = title;
        this.content = content;
        this.capsuleText = capsuleText;
        this.customTitle = customTitle;
        this.customContent = customContent;
        this.status = status;
        this.capsuleContentColor = i10;
        this.capsuleBgColor = i11;
        this.statusText = statusText;
        this.cardImageRes = num;
        this.iconOverlayRes = num2;
        this.networkPhase = networkPhase;
        this.riskRequestId = str;
        this.riskButtons = riskButtons;
        this.riskBody = riskBody;
        this.riskLevel = riskLevel;
        this.contentOnly = z10;
        this.floatOverlay = z11;
        this.clickAppLink = str2;
        this.clickSessionId = str3;
        this.timeoutAfterMs = j10;
    }

    /* renamed from: a, reason: from getter */
    public final int getCapsuleBgColor() {
        return this.capsuleBgColor;
    }

    /* renamed from: b, reason: from getter */
    public final int getCapsuleContentColor() {
        return this.capsuleContentColor;
    }

    /* renamed from: c, reason: from getter */
    public final String getCapsuleText() {
        return this.capsuleText;
    }

    /* renamed from: d, reason: from getter */
    public final Integer getCardImageRes() {
        return this.cardImageRes;
    }

    /* renamed from: e, reason: from getter */
    public final String getClickAppLink() {
        return this.clickAppLink;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiveNotificationParams)) {
            return false;
        }
        LiveNotificationParams liveNotificationParams = (LiveNotificationParams) other;
        return kotlin.jvm.internal.p.d(this.sessionId, liveNotificationParams.sessionId) && kotlin.jvm.internal.p.d(this.type, liveNotificationParams.type) && kotlin.jvm.internal.p.d(this.title, liveNotificationParams.title) && kotlin.jvm.internal.p.d(this.content, liveNotificationParams.content) && kotlin.jvm.internal.p.d(this.capsuleText, liveNotificationParams.capsuleText) && kotlin.jvm.internal.p.d(this.customTitle, liveNotificationParams.customTitle) && kotlin.jvm.internal.p.d(this.customContent, liveNotificationParams.customContent) && kotlin.jvm.internal.p.d(this.status, liveNotificationParams.status) && this.capsuleContentColor == liveNotificationParams.capsuleContentColor && this.capsuleBgColor == liveNotificationParams.capsuleBgColor && kotlin.jvm.internal.p.d(this.statusText, liveNotificationParams.statusText) && kotlin.jvm.internal.p.d(this.cardImageRes, liveNotificationParams.cardImageRes) && kotlin.jvm.internal.p.d(this.iconOverlayRes, liveNotificationParams.iconOverlayRes) && this.networkPhase == liveNotificationParams.networkPhase && kotlin.jvm.internal.p.d(this.riskRequestId, liveNotificationParams.riskRequestId) && kotlin.jvm.internal.p.d(this.riskButtons, liveNotificationParams.riskButtons) && kotlin.jvm.internal.p.d(this.riskBody, liveNotificationParams.riskBody) && kotlin.jvm.internal.p.d(this.riskLevel, liveNotificationParams.riskLevel) && this.contentOnly == liveNotificationParams.contentOnly && this.floatOverlay == liveNotificationParams.floatOverlay && kotlin.jvm.internal.p.d(this.clickAppLink, liveNotificationParams.clickAppLink) && kotlin.jvm.internal.p.d(this.clickSessionId, liveNotificationParams.clickSessionId) && this.timeoutAfterMs == liveNotificationParams.timeoutAfterMs;
    }

    /* renamed from: f, reason: from getter */
    public final String getClickSessionId() {
        return this.clickSessionId;
    }

    /* renamed from: g, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getContentOnly() {
        return this.contentOnly;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((this.sessionId.hashCode() * 31) + this.type.hashCode()) * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31) + this.capsuleText.hashCode()) * 31) + this.customTitle.hashCode()) * 31) + this.customContent.hashCode()) * 31) + this.status.hashCode()) * 31) + Integer.hashCode(this.capsuleContentColor)) * 31) + Integer.hashCode(this.capsuleBgColor)) * 31) + this.statusText.hashCode()) * 31;
        Integer num = this.cardImageRes;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.iconOverlayRes;
        int iHashCode3 = (((iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31) + this.networkPhase.hashCode()) * 31;
        String str = this.riskRequestId;
        int iHashCode4 = (((((((((((iHashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.riskButtons.hashCode()) * 31) + this.riskBody.hashCode()) * 31) + this.riskLevel.hashCode()) * 31) + Boolean.hashCode(this.contentOnly)) * 31) + Boolean.hashCode(this.floatOverlay)) * 31;
        String str2 = this.clickAppLink;
        int iHashCode5 = (iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.clickSessionId;
        return ((iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31) + Long.hashCode(this.timeoutAfterMs);
    }

    /* renamed from: i, reason: from getter */
    public final String getCustomContent() {
        return this.customContent;
    }

    /* renamed from: j, reason: from getter */
    public final String getCustomTitle() {
        return this.customTitle;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getFloatOverlay() {
        return this.floatOverlay;
    }

    /* renamed from: l, reason: from getter */
    public final Integer getIconOverlayRes() {
        return this.iconOverlayRes;
    }

    /* renamed from: m, reason: from getter */
    public final NetworkPhase getNetworkPhase() {
        return this.networkPhase;
    }

    /* renamed from: n, reason: from getter */
    public final String getRiskBody() {
        return this.riskBody;
    }

    public final List<RiskLiveButton> o() {
        return this.riskButtons;
    }

    /* renamed from: p, reason: from getter */
    public final String getRiskLevel() {
        return this.riskLevel;
    }

    /* renamed from: q, reason: from getter */
    public final String getRiskRequestId() {
        return this.riskRequestId;
    }

    /* renamed from: r, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: s, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: t, reason: from getter */
    public final String getStatusText() {
        return this.statusText;
    }

    public String toString() {
        return "LiveNotificationParams(sessionId=" + this.sessionId + ", type=" + this.type + ", title=" + this.title + ", content=" + this.content + ", capsuleText=" + this.capsuleText + ", customTitle=" + this.customTitle + ", customContent=" + this.customContent + ", status=" + this.status + ", capsuleContentColor=" + this.capsuleContentColor + ", capsuleBgColor=" + this.capsuleBgColor + ", statusText=" + this.statusText + ", cardImageRes=" + this.cardImageRes + ", iconOverlayRes=" + this.iconOverlayRes + ", networkPhase=" + this.networkPhase + ", riskRequestId=" + this.riskRequestId + ", riskButtons=" + this.riskButtons + ", riskBody=" + this.riskBody + ", riskLevel=" + this.riskLevel + ", contentOnly=" + this.contentOnly + ", floatOverlay=" + this.floatOverlay + ", clickAppLink=" + this.clickAppLink + ", clickSessionId=" + this.clickSessionId + ", timeoutAfterMs=" + this.timeoutAfterMs + ")";
    }

    /* renamed from: u, reason: from getter */
    public final long getTimeoutAfterMs() {
        return this.timeoutAfterMs;
    }

    /* renamed from: v, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: w, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public /* synthetic */ LiveNotificationParams(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i10, int i11, String str9, Integer num, Integer num2, NetworkPhase networkPhase, String str10, List list, String str11, String str12, boolean z10, boolean z11, String str13, String str14, long j10, int i12, kotlin.jvm.internal.i iVar) {
        this(str, str2, str3, str4, str5, str6, str7, str8, i10, i11, (i12 & 1024) != 0 ? "" : str9, (i12 & 2048) != 0 ? null : num, (i12 & 4096) != 0 ? null : num2, (i12 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? NetworkPhase.AVAILABLE : networkPhase, (i12 & 16384) != 0 ? null : str10, (32768 & i12) != 0 ? C1173v.m() : list, (65536 & i12) != 0 ? "" : str11, (131072 & i12) != 0 ? "" : str12, (262144 & i12) != 0 ? false : z10, (524288 & i12) != 0 ? true : z11, (1048576 & i12) != 0 ? null : str13, (2097152 & i12) != 0 ? null : str14, (i12 & 4194304) != 0 ? 14400000L : j10);
    }
}
