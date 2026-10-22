package com.stepos.ailauncher.taskstore.livenotification;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ailauncher.contract.api.livenotification.RiskLiveButton;
import com.stepos.ailauncher.contract.model.search.SessionActivityState;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b(\b\u0080\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u009e\u0001\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0014HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010 \u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u001cR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b'\u0010\u001cR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b+\u0010\u001cR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010/\u001a\u0004\b0\u00101R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\"\u001a\u0004\b2\u0010\u001cR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0011\u00103\u001a\u0004\b4\u00105R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b6\u0010\u001cR\u0017\u0010\u0013\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b7\u0010\u001cR\u0017\u0010\u0015\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u00108\u001a\u0004\b9\u0010:R\u0017\u0010\u0016\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0016\u00108\u001a\u0004\b;\u0010:¨\u0006<"}, d2 = {"Lcom/stepos/ailauncher/taskstore/livenotification/r;", "", "", "sessionId", "Lcom/stepos/ailauncher/taskstore/livenotification/SessionLiveCategory;", QueryAlgorithmBundle.KEY_CATEGORY, "title", "Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "phase", "dynamicText", "", "iconRes", "", "updatedAt", "riskRequestId", "", "Lcom/stepos/ailauncher/contract/api/livenotification/RiskLiveButton;", "riskButtons", "riskBody", "riskLevel", "", "riskAfterglow", "continueTaskAfterTakeover", "<init>", "(Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/livenotification/SessionLiveCategory;Ljava/lang/String;Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;Ljava/lang/String;Ljava/lang/Integer;JLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZZ)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/livenotification/SessionLiveCategory;Ljava/lang/String;Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;Ljava/lang/String;Ljava/lang/Integer;JLjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZZ)Lcom/stepos/ailauncher/taskstore/livenotification/r;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "m", "Lcom/stepos/ailauncher/taskstore/livenotification/SessionLiveCategory;", "c", "()Lcom/stepos/ailauncher/taskstore/livenotification/SessionLiveCategory;", "n", "Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lcom/stepos/ailauncher/contract/model/search/SessionActivityState;", "e", "Ljava/lang/Integer;", "f", "()Ljava/lang/Integer;", "J", "o", "()J", "l", "Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "k", "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Z", Const.INTENT_KEY_UMID, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.livenotification.r, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SessionLiveState {
    private final SessionLiveCategory category;
    private final boolean continueTaskAfterTakeover;
    private final String dynamicText;
    private final Integer iconRes;
    private final SessionActivityState phase;
    private final boolean riskAfterglow;
    private final String riskBody;
    private final List<RiskLiveButton> riskButtons;
    private final String riskLevel;
    private final String riskRequestId;
    private final String sessionId;
    private final String title;
    private final long updatedAt;

    public SessionLiveState(String sessionId, SessionLiveCategory category, String title, SessionActivityState sessionActivityState, String dynamicText, Integer num, long j10, String str, List<RiskLiveButton> riskButtons, String riskBody, String riskLevel, boolean z10, boolean z11) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(category, "category");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(dynamicText, "dynamicText");
        kotlin.jvm.internal.p.i(riskButtons, "riskButtons");
        kotlin.jvm.internal.p.i(riskBody, "riskBody");
        kotlin.jvm.internal.p.i(riskLevel, "riskLevel");
        this.sessionId = sessionId;
        this.category = category;
        this.title = title;
        this.phase = sessionActivityState;
        this.dynamicText = dynamicText;
        this.iconRes = num;
        this.updatedAt = j10;
        this.riskRequestId = str;
        this.riskButtons = riskButtons;
        this.riskBody = riskBody;
        this.riskLevel = riskLevel;
        this.riskAfterglow = z10;
        this.continueTaskAfterTakeover = z11;
    }

    public final SessionLiveState a(String sessionId, SessionLiveCategory category, String title, SessionActivityState phase, String dynamicText, Integer iconRes, long updatedAt, String riskRequestId, List<RiskLiveButton> riskButtons, String riskBody, String riskLevel, boolean riskAfterglow, boolean continueTaskAfterTakeover) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(category, "category");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(dynamicText, "dynamicText");
        kotlin.jvm.internal.p.i(riskButtons, "riskButtons");
        kotlin.jvm.internal.p.i(riskBody, "riskBody");
        kotlin.jvm.internal.p.i(riskLevel, "riskLevel");
        return new SessionLiveState(sessionId, category, title, phase, dynamicText, iconRes, updatedAt, riskRequestId, riskButtons, riskBody, riskLevel, riskAfterglow, continueTaskAfterTakeover);
    }

    /* renamed from: c, reason: from getter */
    public final SessionLiveCategory getCategory() {
        return this.category;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getContinueTaskAfterTakeover() {
        return this.continueTaskAfterTakeover;
    }

    /* renamed from: e, reason: from getter */
    public final String getDynamicText() {
        return this.dynamicText;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionLiveState)) {
            return false;
        }
        SessionLiveState sessionLiveState = (SessionLiveState) other;
        return kotlin.jvm.internal.p.d(this.sessionId, sessionLiveState.sessionId) && this.category == sessionLiveState.category && kotlin.jvm.internal.p.d(this.title, sessionLiveState.title) && this.phase == sessionLiveState.phase && kotlin.jvm.internal.p.d(this.dynamicText, sessionLiveState.dynamicText) && kotlin.jvm.internal.p.d(this.iconRes, sessionLiveState.iconRes) && this.updatedAt == sessionLiveState.updatedAt && kotlin.jvm.internal.p.d(this.riskRequestId, sessionLiveState.riskRequestId) && kotlin.jvm.internal.p.d(this.riskButtons, sessionLiveState.riskButtons) && kotlin.jvm.internal.p.d(this.riskBody, sessionLiveState.riskBody) && kotlin.jvm.internal.p.d(this.riskLevel, sessionLiveState.riskLevel) && this.riskAfterglow == sessionLiveState.riskAfterglow && this.continueTaskAfterTakeover == sessionLiveState.continueTaskAfterTakeover;
    }

    /* renamed from: f, reason: from getter */
    public final Integer getIconRes() {
        return this.iconRes;
    }

    /* renamed from: g, reason: from getter */
    public final SessionActivityState getPhase() {
        return this.phase;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getRiskAfterglow() {
        return this.riskAfterglow;
    }

    public int hashCode() {
        int iHashCode = ((((this.sessionId.hashCode() * 31) + this.category.hashCode()) * 31) + this.title.hashCode()) * 31;
        SessionActivityState sessionActivityState = this.phase;
        int iHashCode2 = (((iHashCode + (sessionActivityState == null ? 0 : sessionActivityState.hashCode())) * 31) + this.dynamicText.hashCode()) * 31;
        Integer num = this.iconRes;
        int iHashCode3 = (((iHashCode2 + (num == null ? 0 : num.hashCode())) * 31) + Long.hashCode(this.updatedAt)) * 31;
        String str = this.riskRequestId;
        return ((((((((((iHashCode3 + (str != null ? str.hashCode() : 0)) * 31) + this.riskButtons.hashCode()) * 31) + this.riskBody.hashCode()) * 31) + this.riskLevel.hashCode()) * 31) + Boolean.hashCode(this.riskAfterglow)) * 31) + Boolean.hashCode(this.continueTaskAfterTakeover);
    }

    /* renamed from: i, reason: from getter */
    public final String getRiskBody() {
        return this.riskBody;
    }

    public final List<RiskLiveButton> j() {
        return this.riskButtons;
    }

    /* renamed from: k, reason: from getter */
    public final String getRiskLevel() {
        return this.riskLevel;
    }

    /* renamed from: l, reason: from getter */
    public final String getRiskRequestId() {
        return this.riskRequestId;
    }

    /* renamed from: m, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: n, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: o, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public String toString() {
        return "SessionLiveState(sessionId=" + this.sessionId + ", category=" + this.category + ", title=" + this.title + ", phase=" + this.phase + ", dynamicText=" + this.dynamicText + ", iconRes=" + this.iconRes + ", updatedAt=" + this.updatedAt + ", riskRequestId=" + this.riskRequestId + ", riskButtons=" + this.riskButtons + ", riskBody=" + this.riskBody + ", riskLevel=" + this.riskLevel + ", riskAfterglow=" + this.riskAfterglow + ", continueTaskAfterTakeover=" + this.continueTaskAfterTakeover + ")";
    }

    public /* synthetic */ SessionLiveState(String str, SessionLiveCategory sessionLiveCategory, String str2, SessionActivityState sessionActivityState, String str3, Integer num, long j10, String str4, List list, String str5, String str6, boolean z10, boolean z11, int i10, kotlin.jvm.internal.i iVar) {
        this(str, sessionLiveCategory, str2, sessionActivityState, (i10 & 16) != 0 ? "" : str3, (i10 & 32) != 0 ? null : num, (i10 & 64) != 0 ? 0L : j10, (i10 & 128) != 0 ? null : str4, (i10 & 256) != 0 ? C1173v.m() : list, (i10 & 512) != 0 ? "" : str5, (i10 & 1024) != 0 ? "" : str6, (i10 & 2048) != 0 ? false : z10, (i10 & 4096) != 0 ? false : z11);
    }
}
