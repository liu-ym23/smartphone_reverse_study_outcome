package com.stepos.ailauncher.chat.api;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JK\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/stepos/ailauncher/chat/api/SafetyReviewRequest;", "", "packageId", "", "bizType", "async", "", "onlyMachineAudit", "userInfo", "Lcom/stepos/ailauncher/chat/api/SafetyReviewUserInfo;", "resources", "", "Lcom/stepos/ailauncher/chat/api/SafetyReviewResource;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZLcom/stepos/ailauncher/chat/api/SafetyReviewUserInfo;Ljava/util/List;)V", "getPackageId", "()Ljava/lang/String;", "getBizType", "getAsync", "()Z", "getOnlyMachineAudit", "getUserInfo", "()Lcom/stepos/ailauncher/chat/api/SafetyReviewUserInfo;", "getResources", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "", "toString", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SafetyReviewRequest {
    private final boolean async;
    private final String bizType;
    private final boolean onlyMachineAudit;
    private final String packageId;
    private final List<SafetyReviewResource> resources;
    private final SafetyReviewUserInfo userInfo;

    public SafetyReviewRequest(String packageId, String bizType, boolean z10, boolean z11, SafetyReviewUserInfo userInfo, List<SafetyReviewResource> resources) {
        p.i(packageId, "packageId");
        p.i(bizType, "bizType");
        p.i(userInfo, "userInfo");
        p.i(resources, "resources");
        this.packageId = packageId;
        this.bizType = bizType;
        this.async = z10;
        this.onlyMachineAudit = z11;
        this.userInfo = userInfo;
        this.resources = resources;
    }

    public static /* synthetic */ SafetyReviewRequest copy$default(SafetyReviewRequest safetyReviewRequest, String str, String str2, boolean z10, boolean z11, SafetyReviewUserInfo safetyReviewUserInfo, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = safetyReviewRequest.packageId;
        }
        if ((i10 & 2) != 0) {
            str2 = safetyReviewRequest.bizType;
        }
        if ((i10 & 4) != 0) {
            z10 = safetyReviewRequest.async;
        }
        if ((i10 & 8) != 0) {
            z11 = safetyReviewRequest.onlyMachineAudit;
        }
        if ((i10 & 16) != 0) {
            safetyReviewUserInfo = safetyReviewRequest.userInfo;
        }
        if ((i10 & 32) != 0) {
            list = safetyReviewRequest.resources;
        }
        SafetyReviewUserInfo safetyReviewUserInfo2 = safetyReviewUserInfo;
        List list2 = list;
        return safetyReviewRequest.copy(str, str2, z10, z11, safetyReviewUserInfo2, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPackageId() {
        return this.packageId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getAsync() {
        return this.async;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getOnlyMachineAudit() {
        return this.onlyMachineAudit;
    }

    /* renamed from: component5, reason: from getter */
    public final SafetyReviewUserInfo getUserInfo() {
        return this.userInfo;
    }

    public final List<SafetyReviewResource> component6() {
        return this.resources;
    }

    public final SafetyReviewRequest copy(String packageId, String bizType, boolean async, boolean onlyMachineAudit, SafetyReviewUserInfo userInfo, List<SafetyReviewResource> resources) {
        p.i(packageId, "packageId");
        p.i(bizType, "bizType");
        p.i(userInfo, "userInfo");
        p.i(resources, "resources");
        return new SafetyReviewRequest(packageId, bizType, async, onlyMachineAudit, userInfo, resources);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SafetyReviewRequest)) {
            return false;
        }
        SafetyReviewRequest safetyReviewRequest = (SafetyReviewRequest) other;
        return p.d(this.packageId, safetyReviewRequest.packageId) && p.d(this.bizType, safetyReviewRequest.bizType) && this.async == safetyReviewRequest.async && this.onlyMachineAudit == safetyReviewRequest.onlyMachineAudit && p.d(this.userInfo, safetyReviewRequest.userInfo) && p.d(this.resources, safetyReviewRequest.resources);
    }

    public final boolean getAsync() {
        return this.async;
    }

    public final String getBizType() {
        return this.bizType;
    }

    public final boolean getOnlyMachineAudit() {
        return this.onlyMachineAudit;
    }

    public final String getPackageId() {
        return this.packageId;
    }

    public final List<SafetyReviewResource> getResources() {
        return this.resources;
    }

    public final SafetyReviewUserInfo getUserInfo() {
        return this.userInfo;
    }

    public int hashCode() {
        return (((((((((this.packageId.hashCode() * 31) + this.bizType.hashCode()) * 31) + Boolean.hashCode(this.async)) * 31) + Boolean.hashCode(this.onlyMachineAudit)) * 31) + this.userInfo.hashCode()) * 31) + this.resources.hashCode();
    }

    public String toString() {
        return "SafetyReviewRequest(packageId=" + this.packageId + ", bizType=" + this.bizType + ", async=" + this.async + ", onlyMachineAudit=" + this.onlyMachineAudit + ", userInfo=" + this.userInfo + ", resources=" + this.resources + ")";
    }

    public /* synthetic */ SafetyReviewRequest(String str, String str2, boolean z10, boolean z11, SafetyReviewUserInfo safetyReviewUserInfo, List list, int i10, i iVar) {
        this(str, str2, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? true : z11, safetyReviewUserInfo, list);
    }
}
