package com.stepos.ailauncher.chat.api;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003JQ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/chat/api/SafetyReviewReason;", "", "riskLevel", "", "code", "riskText", "firstLabel", "Lcom/stepos/ailauncher/chat/api/SafetyLabelInfo;", "secondLabel", "thirdLabel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/chat/api/SafetyLabelInfo;Lcom/stepos/ailauncher/chat/api/SafetyLabelInfo;Lcom/stepos/ailauncher/chat/api/SafetyLabelInfo;)V", "getRiskLevel", "()Ljava/lang/String;", "getCode", "getRiskText", "getFirstLabel", "()Lcom/stepos/ailauncher/chat/api/SafetyLabelInfo;", "getSecondLabel", "getThirdLabel", "component1", "component2", "component3", "component4", "component5", "component6", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SafetyReviewReason {
    private final String code;
    private final SafetyLabelInfo firstLabel;
    private final String riskLevel;
    private final String riskText;
    private final SafetyLabelInfo secondLabel;
    private final SafetyLabelInfo thirdLabel;

    public SafetyReviewReason() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ SafetyReviewReason copy$default(SafetyReviewReason safetyReviewReason, String str, String str2, String str3, SafetyLabelInfo safetyLabelInfo, SafetyLabelInfo safetyLabelInfo2, SafetyLabelInfo safetyLabelInfo3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = safetyReviewReason.riskLevel;
        }
        if ((i10 & 2) != 0) {
            str2 = safetyReviewReason.code;
        }
        if ((i10 & 4) != 0) {
            str3 = safetyReviewReason.riskText;
        }
        if ((i10 & 8) != 0) {
            safetyLabelInfo = safetyReviewReason.firstLabel;
        }
        if ((i10 & 16) != 0) {
            safetyLabelInfo2 = safetyReviewReason.secondLabel;
        }
        if ((i10 & 32) != 0) {
            safetyLabelInfo3 = safetyReviewReason.thirdLabel;
        }
        SafetyLabelInfo safetyLabelInfo4 = safetyLabelInfo2;
        SafetyLabelInfo safetyLabelInfo5 = safetyLabelInfo3;
        return safetyReviewReason.copy(str, str2, str3, safetyLabelInfo, safetyLabelInfo4, safetyLabelInfo5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRiskLevel() {
        return this.riskLevel;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRiskText() {
        return this.riskText;
    }

    /* renamed from: component4, reason: from getter */
    public final SafetyLabelInfo getFirstLabel() {
        return this.firstLabel;
    }

    /* renamed from: component5, reason: from getter */
    public final SafetyLabelInfo getSecondLabel() {
        return this.secondLabel;
    }

    /* renamed from: component6, reason: from getter */
    public final SafetyLabelInfo getThirdLabel() {
        return this.thirdLabel;
    }

    public final SafetyReviewReason copy(String riskLevel, String code, String riskText, SafetyLabelInfo firstLabel, SafetyLabelInfo secondLabel, SafetyLabelInfo thirdLabel) {
        return new SafetyReviewReason(riskLevel, code, riskText, firstLabel, secondLabel, thirdLabel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SafetyReviewReason)) {
            return false;
        }
        SafetyReviewReason safetyReviewReason = (SafetyReviewReason) other;
        return p.d(this.riskLevel, safetyReviewReason.riskLevel) && p.d(this.code, safetyReviewReason.code) && p.d(this.riskText, safetyReviewReason.riskText) && p.d(this.firstLabel, safetyReviewReason.firstLabel) && p.d(this.secondLabel, safetyReviewReason.secondLabel) && p.d(this.thirdLabel, safetyReviewReason.thirdLabel);
    }

    public final String getCode() {
        return this.code;
    }

    public final SafetyLabelInfo getFirstLabel() {
        return this.firstLabel;
    }

    public final String getRiskLevel() {
        return this.riskLevel;
    }

    public final String getRiskText() {
        return this.riskText;
    }

    public final SafetyLabelInfo getSecondLabel() {
        return this.secondLabel;
    }

    public final SafetyLabelInfo getThirdLabel() {
        return this.thirdLabel;
    }

    public int hashCode() {
        String str = this.riskLevel;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.code;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.riskText;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        SafetyLabelInfo safetyLabelInfo = this.firstLabel;
        int iHashCode4 = (iHashCode3 + (safetyLabelInfo == null ? 0 : safetyLabelInfo.hashCode())) * 31;
        SafetyLabelInfo safetyLabelInfo2 = this.secondLabel;
        int iHashCode5 = (iHashCode4 + (safetyLabelInfo2 == null ? 0 : safetyLabelInfo2.hashCode())) * 31;
        SafetyLabelInfo safetyLabelInfo3 = this.thirdLabel;
        return iHashCode5 + (safetyLabelInfo3 != null ? safetyLabelInfo3.hashCode() : 0);
    }

    public String toString() {
        return "SafetyReviewReason(riskLevel=" + this.riskLevel + ", code=" + this.code + ", riskText=" + this.riskText + ", firstLabel=" + this.firstLabel + ", secondLabel=" + this.secondLabel + ", thirdLabel=" + this.thirdLabel + ")";
    }

    public SafetyReviewReason(String str, String str2, String str3, SafetyLabelInfo safetyLabelInfo, SafetyLabelInfo safetyLabelInfo2, SafetyLabelInfo safetyLabelInfo3) {
        this.riskLevel = str;
        this.code = str2;
        this.riskText = str3;
        this.firstLabel = safetyLabelInfo;
        this.secondLabel = safetyLabelInfo2;
        this.thirdLabel = safetyLabelInfo3;
    }

    public /* synthetic */ SafetyReviewReason(String str, String str2, String str3, SafetyLabelInfo safetyLabelInfo, SafetyLabelInfo safetyLabelInfo2, SafetyLabelInfo safetyLabelInfo3, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : safetyLabelInfo, (i10 & 16) != 0 ? null : safetyLabelInfo2, (i10 & 32) != 0 ? null : safetyLabelInfo3);
    }
}
