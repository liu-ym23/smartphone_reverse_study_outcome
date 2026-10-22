package com.stepos.policy.sdk.bean;

import androidx.activity.b;
import yb.f;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyServiceConfigBean {
    private final String appId;
    private final String businessType;
    private final String code;
    private final int deleteType;

    /* renamed from: id, reason: collision with root package name */
    private int f2788id;
    private final String idType;
    private final int publicFlag;
    private final int serviceId;

    public /* synthetic */ PolicyServiceConfigBean(int i, int i3, String str, String str2, String str3, String str4, int i10, int i11, int i12, f fVar) {
        this((i12 & 1) != 0 ? 0 : i, (i12 & 2) != 0 ? 0 : i3, (i12 & 4) != 0 ? "" : str, (i12 & 8) != 0 ? "" : str2, (i12 & 16) != 0 ? "" : str3, (i12 & 32) != 0 ? "" : str4, (i12 & 64) != 0 ? 0 : i10, (i12 & 128) != 0 ? 0 : i11);
    }

    private final int component1() {
        return this.f2788id;
    }

    public static /* synthetic */ PolicyServiceConfigBean copy$default(PolicyServiceConfigBean policyServiceConfigBean, int i, int i3, String str, String str2, String str3, String str4, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = policyServiceConfigBean.f2788id;
        }
        if ((i12 & 2) != 0) {
            i3 = policyServiceConfigBean.serviceId;
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
        return policyServiceConfigBean.copy(i, i3, str, str2, str5, str6, i13, i14);
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

    public final PolicyServiceConfigBean copy(int i, int i3, String str, String str2, String str3, String str4, int i10, int i11) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        return new PolicyServiceConfigBean(i, i3, str, str2, str3, str4, i10, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyServiceConfigBean)) {
            return false;
        }
        PolicyServiceConfigBean policyServiceConfigBean = (PolicyServiceConfigBean) obj;
        return this.f2788id == policyServiceConfigBean.f2788id && this.serviceId == policyServiceConfigBean.serviceId && k.a(this.code, policyServiceConfigBean.code) && k.a(this.businessType, policyServiceConfigBean.businessType) && k.a(this.appId, policyServiceConfigBean.appId) && k.a(this.idType, policyServiceConfigBean.idType) && this.publicFlag == policyServiceConfigBean.publicFlag && this.deleteType == policyServiceConfigBean.deleteType;
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
        return Integer.hashCode(this.deleteType) + s.f.b(this.publicFlag, b.d(b.d(b.d(b.d(s.f.b(this.serviceId, Integer.hashCode(this.f2788id) * 31, 31), 31, this.code), 31, this.businessType), 31, this.appId), 31, this.idType), 31);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PolicyServiceConfigBean(id=");
        sb2.append(this.f2788id);
        sb2.append(", serviceId=");
        sb2.append(this.serviceId);
        sb2.append(", code=");
        sb2.append(this.code);
        sb2.append(", businessType=");
        sb2.append(this.businessType);
        sb2.append(", appId=");
        sb2.append(this.appId);
        sb2.append(", idType=");
        sb2.append(this.idType);
        sb2.append(", publicFlag=");
        sb2.append(this.publicFlag);
        sb2.append(", deleteType=");
        return b.l(sb2, this.deleteType, ')');
    }

    public PolicyServiceConfigBean(int i, int i3, String str, String str2, String str3, String str4, int i10, int i11) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        this.f2788id = i;
        this.serviceId = i3;
        this.code = str;
        this.businessType = str2;
        this.appId = str3;
        this.idType = str4;
        this.publicFlag = i10;
        this.deleteType = i11;
    }

    public PolicyServiceConfigBean() {
        this(0, 0, null, null, null, null, 0, 0, 255, null);
    }
}
