package com.stepos.policy.sdk.bean;

import j4.g;
import j4.k;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class PolicyServiceConfigBean {
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

    private final int component1() {
        return this.id;
    }

    public static /* synthetic */ PolicyServiceConfigBean copy$default(PolicyServiceConfigBean policyServiceConfigBean, int i5, int i6, String str, String str2, String str3, String str4, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i5 = policyServiceConfigBean.id;
        }
        if ((i9 & 2) != 0) {
            i6 = policyServiceConfigBean.serviceId;
        }
        if ((i9 & 4) != 0) {
            str = policyServiceConfigBean.code;
        }
        if ((i9 & 8) != 0) {
            str2 = policyServiceConfigBean.businessType;
        }
        if ((i9 & 16) != 0) {
            str3 = policyServiceConfigBean.appId;
        }
        if ((i9 & 32) != 0) {
            str4 = policyServiceConfigBean.idType;
        }
        if ((i9 & 64) != 0) {
            i7 = policyServiceConfigBean.publicFlag;
        }
        if ((i9 & 128) != 0) {
            i8 = policyServiceConfigBean.deleteType;
        }
        int i10 = i7;
        int i11 = i8;
        String str5 = str3;
        String str6 = str4;
        return policyServiceConfigBean.copy(i5, i6, str, str2, str5, str6, i10, i11);
    }

    public final int component2() {
        return this.serviceId;
    }

    public final String component3() {
        return this.code;
    }

    public final String component4() {
        return this.businessType;
    }

    public final String component5() {
        return this.appId;
    }

    public final String component6() {
        return this.idType;
    }

    public final int component7() {
        return this.publicFlag;
    }

    public final int component8() {
        return this.deleteType;
    }

    public final PolicyServiceConfigBean copy(int i5, int i6, String str, String str2, String str3, String str4, int i7, int i8) {
        k.g(str, "code");
        k.g(str2, "businessType");
        k.g(str3, "appId");
        k.g(str4, "idType");
        return new PolicyServiceConfigBean(i5, i6, str, str2, str3, str4, i7, i8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyServiceConfigBean)) {
            return false;
        }
        PolicyServiceConfigBean policyServiceConfigBean = (PolicyServiceConfigBean) obj;
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
        return (((((((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.serviceId)) * 31) + this.code.hashCode()) * 31) + this.businessType.hashCode()) * 31) + this.appId.hashCode()) * 31) + this.idType.hashCode()) * 31) + Integer.hashCode(this.publicFlag)) * 31) + Integer.hashCode(this.deleteType);
    }

    public String toString() {
        return "PolicyServiceConfigBean(id=" + this.id + ", serviceId=" + this.serviceId + ", code=" + this.code + ", businessType=" + this.businessType + ", appId=" + this.appId + ", idType=" + this.idType + ", publicFlag=" + this.publicFlag + ", deleteType=" + this.deleteType + ')';
    }

    public PolicyServiceConfigBean(int i5, int i6, String str, String str2, String str3, String str4, int i7, int i8) {
        k.g(str, "code");
        k.g(str2, "businessType");
        k.g(str3, "appId");
        k.g(str4, "idType");
        this.id = i5;
        this.serviceId = i6;
        this.code = str;
        this.businessType = str2;
        this.appId = str3;
        this.idType = str4;
        this.publicFlag = i7;
        this.deleteType = i8;
    }

    public /* synthetic */ PolicyServiceConfigBean(int i5, int i6, String str, String str2, String str3, String str4, int i7, int i8, int i9, g gVar) {
        this((i9 & 1) != 0 ? 0 : i5, (i9 & 2) != 0 ? 0 : i6, (i9 & 4) != 0 ? BuildConfig.FLAVOR : str, (i9 & 8) != 0 ? BuildConfig.FLAVOR : str2, (i9 & 16) != 0 ? BuildConfig.FLAVOR : str3, (i9 & 32) != 0 ? BuildConfig.FLAVOR : str4, (i9 & 64) != 0 ? 0 : i7, (i9 & 128) != 0 ? 0 : i8);
    }
}
