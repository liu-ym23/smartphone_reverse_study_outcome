package com.stepos.aiengine.algorithm.riskclassify;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/stepos/aiengine/algorithm/riskclassify/RiskClassifyResult;", "", "", "decision", "errorMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/aiengine/algorithm/riskclassify/RiskClassifyResult;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getDecision", Const.INTENT_KEY_PKGNAME, "getErrorMessage", "Companion", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class RiskClassifyResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DECISION_BLOCK = "BLOCK";
    public static final String DECISION_PASS = "PASS";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String decision;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String errorMessage;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/aiengine/algorithm/riskclassify/RiskClassifyResult$Companion;", "", "<init>", "()V", "DECISION_PASS", "", "DECISION_BLOCK", "error", "Lcom/stepos/aiengine/algorithm/riskclassify/RiskClassifyResult;", "message", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final RiskClassifyResult error(String message) {
            p.i(message, "message");
            return new RiskClassifyResult("", message);
        }

        public Companion() {
        }
    }

    public RiskClassifyResult(String decision, String str) {
        p.i(decision, "decision");
        this.decision = decision;
        this.errorMessage = str;
    }

    public static /* synthetic */ RiskClassifyResult copy$default(RiskClassifyResult riskClassifyResult, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = riskClassifyResult.decision;
        }
        if ((i10 & 2) != 0) {
            str2 = riskClassifyResult.errorMessage;
        }
        return riskClassifyResult.copy(str, str2);
    }

    public static final RiskClassifyResult error(String str) {
        return INSTANCE.error(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDecision() {
        return this.decision;
    }

    /* renamed from: component2, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final RiskClassifyResult copy(String decision, String errorMessage) {
        p.i(decision, "decision");
        return new RiskClassifyResult(decision, errorMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RiskClassifyResult)) {
            return false;
        }
        RiskClassifyResult riskClassifyResult = (RiskClassifyResult) other;
        return p.d(this.decision, riskClassifyResult.decision) && p.d(this.errorMessage, riskClassifyResult.errorMessage);
    }

    public final String getDecision() {
        return this.decision;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public int hashCode() {
        int iHashCode = this.decision.hashCode() * 31;
        String str = this.errorMessage;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "RiskClassifyResult(decision=" + this.decision + ", errorMessage=" + this.errorMessage + ")";
    }

    public /* synthetic */ RiskClassifyResult(String str, String str2, int i10, i iVar) {
        this(str, (i10 & 2) != 0 ? null : str2);
    }
}
