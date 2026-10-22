package com.stepos.ailauncher.chat.api;

import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\u0087\u0001\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006."}, d2 = {"Lcom/stepos/ailauncher/chat/api/SafetyReviewData;", "", "status", "", C3081a.ERROR_MSG, "packageId", "bizType", "decision", "riskLevel", "suggestText", "requestId", "bizPenetrateData", "resources", "", "Lcom/stepos/ailauncher/chat/api/SafetyReviewResourceResult;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getStatus", "()Ljava/lang/String;", "getErrorMsg", "getPackageId", "getBizType", "getDecision", "getRiskLevel", "getSuggestText", "getRequestId", "getBizPenetrateData", "getResources", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SafetyReviewData {
    private final String bizPenetrateData;
    private final String bizType;
    private final String decision;
    private final String errorMsg;
    private final String packageId;
    private final String requestId;
    private final List<SafetyReviewResourceResult> resources;
    private final String riskLevel;
    private final String status;
    private final String suggestText;

    public SafetyReviewData() {
        this(null, null, null, null, null, null, null, null, null, null, FastDoubleMath.DOUBLE_EXPONENT_BIAS, null);
    }

    public static /* synthetic */ SafetyReviewData copy$default(SafetyReviewData safetyReviewData, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = safetyReviewData.status;
        }
        if ((i10 & 2) != 0) {
            str2 = safetyReviewData.errorMsg;
        }
        if ((i10 & 4) != 0) {
            str3 = safetyReviewData.packageId;
        }
        if ((i10 & 8) != 0) {
            str4 = safetyReviewData.bizType;
        }
        if ((i10 & 16) != 0) {
            str5 = safetyReviewData.decision;
        }
        if ((i10 & 32) != 0) {
            str6 = safetyReviewData.riskLevel;
        }
        if ((i10 & 64) != 0) {
            str7 = safetyReviewData.suggestText;
        }
        if ((i10 & 128) != 0) {
            str8 = safetyReviewData.requestId;
        }
        if ((i10 & 256) != 0) {
            str9 = safetyReviewData.bizPenetrateData;
        }
        if ((i10 & 512) != 0) {
            list = safetyReviewData.resources;
        }
        String str10 = str9;
        List list2 = list;
        String str11 = str7;
        String str12 = str8;
        String str13 = str5;
        String str14 = str6;
        return safetyReviewData.copy(str, str2, str3, str4, str13, str14, str11, str12, str10, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final List<SafetyReviewResourceResult> component10() {
        return this.resources;
    }

    /* renamed from: component2, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPackageId() {
        return this.packageId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDecision() {
        return this.decision;
    }

    /* renamed from: component6, reason: from getter */
    public final String getRiskLevel() {
        return this.riskLevel;
    }

    /* renamed from: component7, reason: from getter */
    public final String getSuggestText() {
        return this.suggestText;
    }

    /* renamed from: component8, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: component9, reason: from getter */
    public final String getBizPenetrateData() {
        return this.bizPenetrateData;
    }

    public final SafetyReviewData copy(String status, String errorMsg, String packageId, String bizType, String decision, String riskLevel, String suggestText, String requestId, String bizPenetrateData, List<SafetyReviewResourceResult> resources) {
        return new SafetyReviewData(status, errorMsg, packageId, bizType, decision, riskLevel, suggestText, requestId, bizPenetrateData, resources);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SafetyReviewData)) {
            return false;
        }
        SafetyReviewData safetyReviewData = (SafetyReviewData) other;
        return p.d(this.status, safetyReviewData.status) && p.d(this.errorMsg, safetyReviewData.errorMsg) && p.d(this.packageId, safetyReviewData.packageId) && p.d(this.bizType, safetyReviewData.bizType) && p.d(this.decision, safetyReviewData.decision) && p.d(this.riskLevel, safetyReviewData.riskLevel) && p.d(this.suggestText, safetyReviewData.suggestText) && p.d(this.requestId, safetyReviewData.requestId) && p.d(this.bizPenetrateData, safetyReviewData.bizPenetrateData) && p.d(this.resources, safetyReviewData.resources);
    }

    public final String getBizPenetrateData() {
        return this.bizPenetrateData;
    }

    public final String getBizType() {
        return this.bizType;
    }

    public final String getDecision() {
        return this.decision;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final String getPackageId() {
        return this.packageId;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final List<SafetyReviewResourceResult> getResources() {
        return this.resources;
    }

    public final String getRiskLevel() {
        return this.riskLevel;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getSuggestText() {
        return this.suggestText;
    }

    public int hashCode() {
        String str = this.status;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.errorMsg;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.packageId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.bizType;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.decision;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.riskLevel;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.suggestText;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.requestId;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.bizPenetrateData;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        List<SafetyReviewResourceResult> list = this.resources;
        return iHashCode9 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "SafetyReviewData(status=" + this.status + ", errorMsg=" + this.errorMsg + ", packageId=" + this.packageId + ", bizType=" + this.bizType + ", decision=" + this.decision + ", riskLevel=" + this.riskLevel + ", suggestText=" + this.suggestText + ", requestId=" + this.requestId + ", bizPenetrateData=" + this.bizPenetrateData + ", resources=" + this.resources + ")";
    }

    public SafetyReviewData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List<SafetyReviewResourceResult> list) {
        this.status = str;
        this.errorMsg = str2;
        this.packageId = str3;
        this.bizType = str4;
        this.decision = str5;
        this.riskLevel = str6;
        this.suggestText = str7;
        this.requestId = str8;
        this.bizPenetrateData = str9;
        this.resources = list;
    }

    public /* synthetic */ SafetyReviewData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list, int i10, i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6, (i10 & 64) != 0 ? null : str7, (i10 & 128) != 0 ? null : str8, (i10 & 256) != 0 ? null : str9, (i10 & 512) != 0 ? null : list);
    }
}
