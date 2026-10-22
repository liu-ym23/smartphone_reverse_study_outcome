package com.stepos.policy.sdk.bean;

import j4.g;
import j4.k;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class CustomDeleteInfoBean {
    private String bindIdKey;
    private String bindIdValue;
    private String serviceId;

    public CustomDeleteInfoBean() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CustomDeleteInfoBean copy$default(CustomDeleteInfoBean customDeleteInfoBean, String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = customDeleteInfoBean.serviceId;
        }
        if ((i5 & 2) != 0) {
            str2 = customDeleteInfoBean.bindIdKey;
        }
        if ((i5 & 4) != 0) {
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

    public final CustomDeleteInfoBean copy(String str, String str2, String str3) {
        k.g(str, "serviceId");
        k.g(str2, "bindIdKey");
        k.g(str3, "bindIdValue");
        return new CustomDeleteInfoBean(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomDeleteInfoBean)) {
            return false;
        }
        CustomDeleteInfoBean customDeleteInfoBean = (CustomDeleteInfoBean) obj;
        return k.b(this.serviceId, customDeleteInfoBean.serviceId) && k.b(this.bindIdKey, customDeleteInfoBean.bindIdKey) && k.b(this.bindIdValue, customDeleteInfoBean.bindIdValue);
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
        return (((this.serviceId.hashCode() * 31) + this.bindIdKey.hashCode()) * 31) + this.bindIdValue.hashCode();
    }

    public final void setBindIdKey(String str) {
        k.g(str, "<set-?>");
        this.bindIdKey = str;
    }

    public final void setBindIdValue(String str) {
        k.g(str, "<set-?>");
        this.bindIdValue = str;
    }

    public final void setServiceId(String str) {
        k.g(str, "<set-?>");
        this.serviceId = str;
    }

    public String toString() {
        return "CustomDeleteInfoBean(serviceId=" + this.serviceId + ", bindIdKey=" + this.bindIdKey + ", bindIdValue=" + this.bindIdValue + ')';
    }

    public CustomDeleteInfoBean(String str, String str2, String str3) {
        k.g(str, "serviceId");
        k.g(str2, "bindIdKey");
        k.g(str3, "bindIdValue");
        this.serviceId = str;
        this.bindIdKey = str2;
        this.bindIdValue = str3;
    }

    public /* synthetic */ CustomDeleteInfoBean(String str, String str2, String str3, int i5, g gVar) {
        this((i5 & 1) != 0 ? BuildConfig.FLAVOR : str, (i5 & 2) != 0 ? BuildConfig.FLAVOR : str2, (i5 & 4) != 0 ? BuildConfig.FLAVOR : str3);
    }
}
