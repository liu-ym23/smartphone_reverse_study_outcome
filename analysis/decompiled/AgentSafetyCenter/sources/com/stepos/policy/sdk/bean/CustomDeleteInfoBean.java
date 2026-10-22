package com.stepos.policy.sdk.bean;

import androidx.activity.b;
import k0.a;
import yb.f;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class CustomDeleteInfoBean {
    private String bindIdKey;
    private String bindIdValue;
    private String serviceId;

    public /* synthetic */ CustomDeleteInfoBean(String str, String str2, String str3, int i, f fVar) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public static /* synthetic */ CustomDeleteInfoBean copy$default(CustomDeleteInfoBean customDeleteInfoBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = customDeleteInfoBean.serviceId;
        }
        if ((i & 2) != 0) {
            str2 = customDeleteInfoBean.bindIdKey;
        }
        if ((i & 4) != 0) {
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
        str.getClass();
        str2.getClass();
        str3.getClass();
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
        return k.a(this.serviceId, customDeleteInfoBean.serviceId) && k.a(this.bindIdKey, customDeleteInfoBean.bindIdKey) && k.a(this.bindIdValue, customDeleteInfoBean.bindIdValue);
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
        return this.bindIdValue.hashCode() + b.d(this.serviceId.hashCode() * 31, 31, this.bindIdKey);
    }

    public final void setBindIdKey(String str) {
        str.getClass();
        this.bindIdKey = str;
    }

    public final void setBindIdValue(String str) {
        str.getClass();
        this.bindIdValue = str;
    }

    public final void setServiceId(String str) {
        str.getClass();
        this.serviceId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("CustomDeleteInfoBean(serviceId=");
        sb2.append(this.serviceId);
        sb2.append(", bindIdKey=");
        sb2.append(this.bindIdKey);
        sb2.append(", bindIdValue=");
        return a.s(sb2, this.bindIdValue, ')');
    }

    public CustomDeleteInfoBean(String str, String str2, String str3) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        this.serviceId = str;
        this.bindIdKey = str2;
        this.bindIdValue = str3;
    }

    public CustomDeleteInfoBean() {
        this(null, null, null, 7, null);
    }
}
