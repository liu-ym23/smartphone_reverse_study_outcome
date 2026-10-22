package com.stepos.policy.sdk.bean;

import ai.onnxruntime.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CustomDeleteInfoBean {
    private String bindIdKey;
    private String bindIdValue;
    private String serviceId;

    public CustomDeleteInfoBean() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CustomDeleteInfoBean copy$default(CustomDeleteInfoBean customDeleteInfoBean, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = customDeleteInfoBean.serviceId;
        }
        if ((i10 & 2) != 0) {
            str2 = customDeleteInfoBean.bindIdKey;
        }
        if ((i10 & 4) != 0) {
            str3 = customDeleteInfoBean.bindIdValue;
        }
        return customDeleteInfoBean.copy(str, str2, str3);
    }

    public final String component1() {
        return this.serviceId;
    }

    public final String component2() {
        return this.bindIdKey;
    }

    public final String component3() {
        return this.bindIdValue;
    }

    public final CustomDeleteInfoBean copy(String serviceId, String bindIdKey, String bindIdValue) {
        g.f(serviceId, "serviceId");
        g.f(bindIdKey, "bindIdKey");
        g.f(bindIdValue, "bindIdValue");
        return new CustomDeleteInfoBean(serviceId, bindIdKey, bindIdValue);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomDeleteInfoBean)) {
            return false;
        }
        CustomDeleteInfoBean customDeleteInfoBean = (CustomDeleteInfoBean) obj;
        return g.b(this.serviceId, customDeleteInfoBean.serviceId) && g.b(this.bindIdKey, customDeleteInfoBean.bindIdKey) && g.b(this.bindIdValue, customDeleteInfoBean.bindIdValue);
    }

    public final String getBindIdKey() {
        return this.bindIdKey;
    }

    public final String getBindIdValue() {
        return this.bindIdValue;
    }

    public final String getServiceId() {
        return this.serviceId;
    }

    public int hashCode() {
        return this.bindIdValue.hashCode() + d.a(this.serviceId.hashCode() * 31, 31, this.bindIdKey);
    }

    public final void setBindIdKey(String str) {
        g.f(str, "<set-?>");
        this.bindIdKey = str;
    }

    public final void setBindIdValue(String str) {
        g.f(str, "<set-?>");
        this.bindIdValue = str;
    }

    public final void setServiceId(String str) {
        g.f(str, "<set-?>");
        this.serviceId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("CustomDeleteInfoBean(serviceId=");
        sb2.append(this.serviceId);
        sb2.append(", bindIdKey=");
        sb2.append(this.bindIdKey);
        sb2.append(", bindIdValue=");
        return a.n(sb2, this.bindIdValue, ')');
    }

    public CustomDeleteInfoBean(String serviceId, String bindIdKey, String bindIdValue) {
        g.f(serviceId, "serviceId");
        g.f(bindIdKey, "bindIdKey");
        g.f(bindIdValue, "bindIdValue");
        this.serviceId = serviceId;
        this.bindIdKey = bindIdKey;
        this.bindIdValue = bindIdValue;
    }

    public /* synthetic */ CustomDeleteInfoBean(String str, String str2, String str3, int i10, e eVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3);
    }
}
