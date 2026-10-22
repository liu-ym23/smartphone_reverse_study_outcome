package com.stepos.policy.sdk.bean;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JY\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006$"}, d2 = {"Lcom/stepos/policy/sdk/bean/PolicyServiceConfigBean;", "", "id", "", "serviceId", "code", "", "businessType", "appId", "idType", "publicFlag", "deleteType", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getAppId", "()Ljava/lang/String;", "getBusinessType", "getCode", "getDeleteType", "()I", "getIdType", "getPublicFlag", "getServiceId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class PolicyServiceConfigBean {
    private final String appId;
    private final String businessType;
    private final String code;
    private final int deleteType;
    private int id;
    private final String idType;
    private final int publicFlag;
    private final int serviceId;

    public PolicyServiceConfigBean() {
        this(0, 0, null, null, null, null, 0, 0, 255, null);
    }

    /* renamed from: component1, reason: from getter */
    private final int getId() {
        return this.id;
    }

    public static /* synthetic */ PolicyServiceConfigBean copy$default(PolicyServiceConfigBean policyServiceConfigBean, int i10, int i11, String str, String str2, String str3, String str4, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = policyServiceConfigBean.id;
        }
        if ((i14 & 2) != 0) {
            i11 = policyServiceConfigBean.serviceId;
        }
        if ((i14 & 4) != 0) {
            str = policyServiceConfigBean.code;
        }
        if ((i14 & 8) != 0) {
            str2 = policyServiceConfigBean.businessType;
        }
        if ((i14 & 16) != 0) {
            str3 = policyServiceConfigBean.appId;
        }
        if ((i14 & 32) != 0) {
            str4 = policyServiceConfigBean.idType;
        }
        if ((i14 & 64) != 0) {
            i12 = policyServiceConfigBean.publicFlag;
        }
        if ((i14 & 128) != 0) {
            i13 = policyServiceConfigBean.deleteType;
        }
        int i15 = i12;
        int i16 = i13;
        String str5 = str3;
        String str6 = str4;
        return policyServiceConfigBean.copy(i10, i11, str, str2, str5, str6, i15, i16);
    }

    /* renamed from: component2, reason: from getter */
    public final int getServiceId() {
        return this.serviceId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: component4, reason: from getter */
    public final String getBusinessType() {
        return this.businessType;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getIdType() {
        return this.idType;
    }

    /* renamed from: component7, reason: from getter */
    public final int getPublicFlag() {
        return this.publicFlag;
    }

    /* renamed from: component8, reason: from getter */
    public final int getDeleteType() {
        return this.deleteType;
    }

    public final PolicyServiceConfigBean copy(int id, int serviceId, String code, String businessType, String appId, String idType, int publicFlag, int deleteType) {
        p.i(code, "code");
        p.i(businessType, "businessType");
        p.i(appId, "appId");
        p.i(idType, "idType");
        return new PolicyServiceConfigBean(id, serviceId, code, businessType, appId, idType, publicFlag, deleteType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PolicyServiceConfigBean)) {
            return false;
        }
        PolicyServiceConfigBean policyServiceConfigBean = (PolicyServiceConfigBean) other;
        return this.id == policyServiceConfigBean.id && this.serviceId == policyServiceConfigBean.serviceId && p.d(this.code, policyServiceConfigBean.code) && p.d(this.businessType, policyServiceConfigBean.businessType) && p.d(this.appId, policyServiceConfigBean.appId) && p.d(this.idType, policyServiceConfigBean.idType) && this.publicFlag == policyServiceConfigBean.publicFlag && this.deleteType == policyServiceConfigBean.deleteType;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getBusinessType() {
        return this.businessType;
    }

    public final String getCode() {
        return this.code;
    }

    public final int getDeleteType() {
        return this.deleteType;
    }

    public final String getIdType() {
        return this.idType;
    }

    public final int getPublicFlag() {
        return this.publicFlag;
    }

    public final int getServiceId() {
        return this.serviceId;
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.serviceId)) * 31) + this.code.hashCode()) * 31) + this.businessType.hashCode()) * 31) + this.appId.hashCode()) * 31) + this.idType.hashCode()) * 31) + Integer.hashCode(this.publicFlag)) * 31) + Integer.hashCode(this.deleteType);
    }

    public String toString() {
        return "PolicyServiceConfigBean(id=" + this.id + ", serviceId=" + this.serviceId + ", code=" + this.code + ", businessType=" + this.businessType + ", appId=" + this.appId + ", idType=" + this.idType + ", publicFlag=" + this.publicFlag + ", deleteType=" + this.deleteType + ')';
    }

    public PolicyServiceConfigBean(int i10, int i11, String code, String businessType, String appId, String idType, int i12, int i13) {
        p.i(code, "code");
        p.i(businessType, "businessType");
        p.i(appId, "appId");
        p.i(idType, "idType");
        this.id = i10;
        this.serviceId = i11;
        this.code = code;
        this.businessType = businessType;
        this.appId = appId;
        this.idType = idType;
        this.publicFlag = i12;
        this.deleteType = i13;
    }

    public /* synthetic */ PolicyServiceConfigBean(int i10, int i11, String str, String str2, String str3, String str4, int i12, int i13, int i14, i iVar) {
        this((i14 & 1) != 0 ? 0 : i10, (i14 & 2) != 0 ? 0 : i11, (i14 & 4) != 0 ? "" : str, (i14 & 8) != 0 ? "" : str2, (i14 & 16) != 0 ? "" : str3, (i14 & 32) != 0 ? "" : str4, (i14 & 64) != 0 ? 0 : i12, (i14 & 128) != 0 ? 0 : i13);
    }
}
