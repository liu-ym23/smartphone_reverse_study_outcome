package com.stepos.policy.sdk.bean;

import ai.onnxruntime.a;
import com.stepos.core.common.util.TraceIdKeys;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyServiceConfigBean {
    private final String appId;
    private final String businessType;
    private final String code;
    private final int deleteType;

    /* renamed from: id, reason: collision with root package name */
    private int f7963id;
    private final String idType;
    private final int publicFlag;
    private final int serviceId;

    public PolicyServiceConfigBean() {
        this(0, 0, null, null, null, null, 0, 0, 255, null);
    }

    private final int component1() {
        return this.f7963id;
    }

    public static /* synthetic */ PolicyServiceConfigBean copy$default(PolicyServiceConfigBean policyServiceConfigBean, int i10, int i11, String str, String str2, String str3, String str4, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = policyServiceConfigBean.f7963id;
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
        if ((i14 & TraceIdKeys.MAX_LENGTH) != 0) {
            i13 = policyServiceConfigBean.deleteType;
        }
        int i15 = i12;
        int i16 = i13;
        String str5 = str3;
        String str6 = str4;
        return policyServiceConfigBean.copy(i10, i11, str, str2, str5, str6, i15, i16);
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

    public final PolicyServiceConfigBean copy(int i10, int i11, String code, String businessType, String appId, String idType, int i12, int i13) {
        g.f(code, "code");
        g.f(businessType, "businessType");
        g.f(appId, "appId");
        g.f(idType, "idType");
        return new PolicyServiceConfigBean(i10, i11, code, businessType, appId, idType, i12, i13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PolicyServiceConfigBean)) {
            return false;
        }
        PolicyServiceConfigBean policyServiceConfigBean = (PolicyServiceConfigBean) obj;
        return this.f7963id == policyServiceConfigBean.f7963id && this.serviceId == policyServiceConfigBean.serviceId && g.b(this.code, policyServiceConfigBean.code) && g.b(this.businessType, policyServiceConfigBean.businessType) && g.b(this.appId, policyServiceConfigBean.appId) && g.b(this.idType, policyServiceConfigBean.idType) && this.publicFlag == policyServiceConfigBean.publicFlag && this.deleteType == policyServiceConfigBean.deleteType;
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
        return Integer.hashCode(this.deleteType) + a.d(this.publicFlag, d.a(d.a(d.a(d.a(a.d(this.serviceId, Integer.hashCode(this.f7963id) * 31, 31), 31, this.code), 31, this.businessType), 31, this.appId), 31, this.idType), 31);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PolicyServiceConfigBean(id=");
        sb2.append(this.f7963id);
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
        return a0.a.l(sb2, this.deleteType, ')');
    }

    public PolicyServiceConfigBean(int i10, int i11, String code, String businessType, String appId, String idType, int i12, int i13) {
        g.f(code, "code");
        g.f(businessType, "businessType");
        g.f(appId, "appId");
        g.f(idType, "idType");
        this.f7963id = i10;
        this.serviceId = i11;
        this.code = code;
        this.businessType = businessType;
        this.appId = appId;
        this.idType = idType;
        this.publicFlag = i12;
        this.deleteType = i13;
    }

    public /* synthetic */ PolicyServiceConfigBean(int i10, int i11, String str, String str2, String str3, String str4, int i12, int i13, int i14, e eVar) {
        this((i14 & 1) != 0 ? 0 : i10, (i14 & 2) != 0 ? 0 : i11, (i14 & 4) != 0 ? "" : str, (i14 & 8) != 0 ? "" : str2, (i14 & 16) != 0 ? "" : str3, (i14 & 32) != 0 ? "" : str4, (i14 & 64) != 0 ? 0 : i12, (i14 & TraceIdKeys.MAX_LENGTH) != 0 ? 0 : i13);
    }
}
