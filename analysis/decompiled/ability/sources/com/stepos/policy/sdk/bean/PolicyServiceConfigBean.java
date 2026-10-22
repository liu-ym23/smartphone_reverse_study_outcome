package com.stepos.policy.sdk.bean;

import androidx.constraintlayout.core.dsl.a;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JY\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006$"}, d2 = {"Lcom/stepos/policy/sdk/bean/PolicyServiceConfigBean;", "", "id", "", "serviceId", "code", "", "businessType", "appId", "idType", "publicFlag", "deleteType", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getAppId", "()Ljava/lang/String;", "getBusinessType", "getCode", "getDeleteType", "()I", "getIdType", "getPublicFlag", "getServiceId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    public static /* synthetic */ PolicyServiceConfigBean copy$default(PolicyServiceConfigBean policyServiceConfigBean, int i, int i6, String str, String str2, String str3, String str4, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = policyServiceConfigBean.id;
        }
        if ((i12 & 2) != 0) {
            i6 = policyServiceConfigBean.serviceId;
        }
        if ((i12 & 4) != 0) {
            str = policyServiceConfigBean.code;
        }
        if ((i12 & 8) != 0) {
            str2 = policyServiceConfigBean.businessType;
        }
        if ((i12 & 16) != 0) {
            str3 = policyServiceConfigBean.appId;
        }
        if ((i12 & 32) != 0) {
            str4 = policyServiceConfigBean.idType;
        }
        if ((i12 & 64) != 0) {
            i10 = policyServiceConfigBean.publicFlag;
        }
        if ((i12 & 128) != 0) {
            i11 = policyServiceConfigBean.deleteType;
        }
        int i13 = i10;
        int i14 = i11;
        String str5 = str3;
        String str6 = str4;
        return policyServiceConfigBean.copy(i, i6, str, str2, str5, str6, i13, i14);
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
        k.f(code, "code");
        k.f(businessType, "businessType");
        k.f(appId, "appId");
        k.f(idType, "idType");
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
        return this.id == policyServiceConfigBean.id && this.serviceId == policyServiceConfigBean.serviceId && k.b(this.code, policyServiceConfigBean.code) && k.b(this.businessType, policyServiceConfigBean.businessType) && k.b(this.appId, policyServiceConfigBean.appId) && k.b(this.idType, policyServiceConfigBean.idType) && this.publicFlag == policyServiceConfigBean.publicFlag && this.deleteType == policyServiceConfigBean.deleteType;
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
        return Integer.hashCode(this.deleteType) + a.a(this.publicFlag, B7.a.c(B7.a.c(B7.a.c(B7.a.c(a.a(this.serviceId, Integer.hashCode(this.id) * 31, 31), 31, this.code), 31, this.businessType), 31, this.appId), 31, this.idType), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PolicyServiceConfigBean(id=");
        sb.append(this.id);
        sb.append(", serviceId=");
        sb.append(this.serviceId);
        sb.append(", code=");
        sb.append(this.code);
        sb.append(", businessType=");
        sb.append(this.businessType);
        sb.append(", appId=");
        sb.append(this.appId);
        sb.append(", idType=");
        sb.append(this.idType);
        sb.append(", publicFlag=");
        sb.append(this.publicFlag);
        sb.append(", deleteType=");
        return B7.a.o(sb, this.deleteType, ')');
    }

    public PolicyServiceConfigBean(int i, int i6, String code, String businessType, String appId, String idType, int i10, int i11) {
        k.f(code, "code");
        k.f(businessType, "businessType");
        k.f(appId, "appId");
        k.f(idType, "idType");
        this.id = i;
        this.serviceId = i6;
        this.code = code;
        this.businessType = businessType;
        this.appId = appId;
        this.idType = idType;
        this.publicFlag = i10;
        this.deleteType = i11;
    }

    public /* synthetic */ PolicyServiceConfigBean(int i, int i6, String str, String str2, String str3, String str4, int i10, int i11, int i12, e eVar) {
        this((i12 & 1) != 0 ? 0 : i, (i12 & 2) != 0 ? 0 : i6, (i12 & 4) != 0 ? "" : str, (i12 & 8) != 0 ? "" : str2, (i12 & 16) != 0 ? "" : str3, (i12 & 32) != 0 ? "" : str4, (i12 & 64) != 0 ? 0 : i10, (i12 & 128) != 0 ? 0 : i11);
    }
}
