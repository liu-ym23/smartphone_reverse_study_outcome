package com.stepos.ailauncher.chat.api;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003Jo\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010¨\u0006("}, d2 = {"Lcom/stepos/ailauncher/chat/api/SafetyReviewResourceResult;", "", "id", "", "name", "type", HomeGestureEligibilityContract.EXTRA_SCENE, "decision", "riskLevel", "reason", "", "Lcom/stepos/ailauncher/chat/api/SafetyReviewReason;", "suggestText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getType", "getScene", "getDecision", "getRiskLevel", "getReason", "()Ljava/util/List;", "getSuggestText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SafetyReviewResourceResult {
    private final String decision;
    private final String id;
    private final String name;
    private final List<SafetyReviewReason> reason;
    private final String riskLevel;
    private final String scene;
    private final String suggestText;
    private final String type;

    public SafetyReviewResourceResult() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ SafetyReviewResourceResult copy$default(SafetyReviewResourceResult safetyReviewResourceResult, String str, String str2, String str3, String str4, String str5, String str6, List list, String str7, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = safetyReviewResourceResult.id;
        }
        if ((i10 & 2) != 0) {
            str2 = safetyReviewResourceResult.name;
        }
        if ((i10 & 4) != 0) {
            str3 = safetyReviewResourceResult.type;
        }
        if ((i10 & 8) != 0) {
            str4 = safetyReviewResourceResult.scene;
        }
        if ((i10 & 16) != 0) {
            str5 = safetyReviewResourceResult.decision;
        }
        if ((i10 & 32) != 0) {
            str6 = safetyReviewResourceResult.riskLevel;
        }
        if ((i10 & 64) != 0) {
            list = safetyReviewResourceResult.reason;
        }
        if ((i10 & 128) != 0) {
            str7 = safetyReviewResourceResult.suggestText;
        }
        List list2 = list;
        String str8 = str7;
        String str9 = str5;
        String str10 = str6;
        return safetyReviewResourceResult.copy(str, str2, str3, str4, str9, str10, list2, str8);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final String getScene() {
        return this.scene;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDecision() {
        return this.decision;
    }

    /* renamed from: component6, reason: from getter */
    public final String getRiskLevel() {
        return this.riskLevel;
    }

    public final List<SafetyReviewReason> component7() {
        return this.reason;
    }

    /* renamed from: component8, reason: from getter */
    public final String getSuggestText() {
        return this.suggestText;
    }

    public final SafetyReviewResourceResult copy(String id, String name, String type, String scene, String decision, String riskLevel, List<SafetyReviewReason> reason, String suggestText) {
        return new SafetyReviewResourceResult(id, name, type, scene, decision, riskLevel, reason, suggestText);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SafetyReviewResourceResult)) {
            return false;
        }
        SafetyReviewResourceResult safetyReviewResourceResult = (SafetyReviewResourceResult) other;
        return p.d(this.id, safetyReviewResourceResult.id) && p.d(this.name, safetyReviewResourceResult.name) && p.d(this.type, safetyReviewResourceResult.type) && p.d(this.scene, safetyReviewResourceResult.scene) && p.d(this.decision, safetyReviewResourceResult.decision) && p.d(this.riskLevel, safetyReviewResourceResult.riskLevel) && p.d(this.reason, safetyReviewResourceResult.reason) && p.d(this.suggestText, safetyReviewResourceResult.suggestText);
    }

    public final String getDecision() {
        return this.decision;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final List<SafetyReviewReason> getReason() {
        return this.reason;
    }

    public final String getRiskLevel() {
        return this.riskLevel;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getSuggestText() {
        return this.suggestText;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.type;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.scene;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.decision;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.riskLevel;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<SafetyReviewReason> list = this.reason;
        int iHashCode7 = (iHashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        String str7 = this.suggestText;
        return iHashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "SafetyReviewResourceResult(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ", scene=" + this.scene + ", decision=" + this.decision + ", riskLevel=" + this.riskLevel + ", reason=" + this.reason + ", suggestText=" + this.suggestText + ")";
    }

    public SafetyReviewResourceResult(String str, String str2, String str3, String str4, String str5, String str6, List<SafetyReviewReason> list, String str7) {
        this.id = str;
        this.name = str2;
        this.type = str3;
        this.scene = str4;
        this.decision = str5;
        this.riskLevel = str6;
        this.reason = list;
        this.suggestText = str7;
    }

    public /* synthetic */ SafetyReviewResourceResult(String str, String str2, String str3, String str4, String str5, String str6, List list, String str7, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6, (i10 & 64) != 0 ? null : list, (i10 & 128) != 0 ? null : str7);
    }
}
