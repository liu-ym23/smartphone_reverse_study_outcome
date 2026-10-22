package com.stepos.ailauncher.mcpservice.risk;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u0000 )2\u00020\u0001:\u0001\u001dBY\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u0011R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001b\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001c\u0010\u0011R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001d\u0010\u0011R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b!\u0010\u0011R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\"\u0010\u0011R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010#\u001a\u0004\b$\u0010%R\u0011\u0010(\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/stepos/ailauncher/mcpservice/risk/p;", "", "", "requestId", "riskLevel", "title", "body", "", "Lcom/stepos/ailauncher/mcpservice/risk/RiskStatementButton;", "buttons", HomeGestureEligibilityContract.EXTRA_SCENE, "sessionId", "", "timeoutMs", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_APIKEY, "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "e", "f", "Ljava/lang/Long;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/lang/Long;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Z", "isUnlockScene", "Companion", "mcpservice_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.mcpservice.risk.p, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class RiskStatementParams {
    public static final String SCENE_UNLOCK = "unlock";
    private final String body;
    private final List<RiskStatementButton> buttons;
    private final String requestId;
    private final String riskLevel;
    private final String scene;
    private final String sessionId;
    private final Long timeoutMs;
    private final String title;

    public RiskStatementParams(String requestId, String riskLevel, String title, String body, List<RiskStatementButton> buttons, String str, String str2, Long l10) {
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(riskLevel, "riskLevel");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(body, "body");
        kotlin.jvm.internal.p.i(buttons, "buttons");
        this.requestId = requestId;
        this.riskLevel = riskLevel;
        this.title = title;
        this.body = body;
        this.buttons = buttons;
        this.scene = str;
        this.sessionId = str2;
        this.timeoutMs = l10;
        int size = buttons.size();
        if (2 > size || size >= 4) {
            throw new IllegalArgumentException(("buttons size must be 2 or 3, but was " + buttons.size()).toString());
        }
    }

    /* renamed from: a, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    public final List<RiskStatementButton> b() {
        return this.buttons;
    }

    /* renamed from: c, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: d, reason: from getter */
    public final String getRiskLevel() {
        return this.riskLevel;
    }

    /* renamed from: e, reason: from getter */
    public final String getScene() {
        return this.scene;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RiskStatementParams)) {
            return false;
        }
        RiskStatementParams riskStatementParams = (RiskStatementParams) other;
        return kotlin.jvm.internal.p.d(this.requestId, riskStatementParams.requestId) && kotlin.jvm.internal.p.d(this.riskLevel, riskStatementParams.riskLevel) && kotlin.jvm.internal.p.d(this.title, riskStatementParams.title) && kotlin.jvm.internal.p.d(this.body, riskStatementParams.body) && kotlin.jvm.internal.p.d(this.buttons, riskStatementParams.buttons) && kotlin.jvm.internal.p.d(this.scene, riskStatementParams.scene) && kotlin.jvm.internal.p.d(this.sessionId, riskStatementParams.sessionId) && kotlin.jvm.internal.p.d(this.timeoutMs, riskStatementParams.timeoutMs);
    }

    /* renamed from: f, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: g, reason: from getter */
    public final Long getTimeoutMs() {
        return this.timeoutMs;
    }

    /* renamed from: h, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.requestId.hashCode() * 31) + this.riskLevel.hashCode()) * 31) + this.title.hashCode()) * 31) + this.body.hashCode()) * 31) + this.buttons.hashCode()) * 31;
        String str = this.scene;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.sessionId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l10 = this.timeoutMs;
        return iHashCode3 + (l10 != null ? l10.hashCode() : 0);
    }

    public final boolean i() {
        return kotlin.jvm.internal.p.d(this.scene, SCENE_UNLOCK);
    }

    public String toString() {
        return "RiskStatementParams(requestId=" + this.requestId + ", riskLevel=" + this.riskLevel + ", title=" + this.title + ", body=" + this.body + ", buttons=" + this.buttons + ", scene=" + this.scene + ", sessionId=" + this.sessionId + ", timeoutMs=" + this.timeoutMs + ")";
    }

    public /* synthetic */ RiskStatementParams(String str, String str2, String str3, String str4, List list, String str5, String str6, Long l10, int i10, kotlin.jvm.internal.i iVar) {
        this(str, str2, str3, str4, list, (i10 & 32) != 0 ? null : str5, (i10 & 64) != 0 ? null : str6, (i10 & 128) != 0 ? null : l10);
    }
}
