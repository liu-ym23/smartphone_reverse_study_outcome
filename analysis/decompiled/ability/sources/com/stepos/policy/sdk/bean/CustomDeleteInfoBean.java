package com.stepos.policy.sdk.bean;

import B7.a;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/stepos/policy/sdk/bean/CustomDeleteInfoBean;", "", "serviceId", "", "bindIdKey", "bindIdValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBindIdKey", "()Ljava/lang/String;", "setBindIdKey", "(Ljava/lang/String;)V", "getBindIdValue", "setBindIdValue", "getServiceId", "setServiceId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CustomDeleteInfoBean {
    private String bindIdKey;
    private String bindIdValue;
    private String serviceId;

    public CustomDeleteInfoBean() {
        this(null, null, null, 7, null);
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

    /* renamed from: component1, reason: from getter */
    public final String getServiceId() {
        return this.serviceId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBindIdKey() {
        return this.bindIdKey;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBindIdValue() {
        return this.bindIdValue;
    }

    public final CustomDeleteInfoBean copy(String serviceId, String bindIdKey, String bindIdValue) {
        k.f(serviceId, "serviceId");
        k.f(bindIdKey, "bindIdKey");
        k.f(bindIdValue, "bindIdValue");
        return new CustomDeleteInfoBean(serviceId, bindIdKey, bindIdValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomDeleteInfoBean)) {
            return false;
        }
        CustomDeleteInfoBean customDeleteInfoBean = (CustomDeleteInfoBean) other;
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
        return this.bindIdValue.hashCode() + a.c(this.serviceId.hashCode() * 31, 31, this.bindIdKey);
    }

    public final void setBindIdKey(String str) {
        k.f(str, "<set-?>");
        this.bindIdKey = str;
    }

    public final void setBindIdValue(String str) {
        k.f(str, "<set-?>");
        this.bindIdValue = str;
    }

    public final void setServiceId(String str) {
        k.f(str, "<set-?>");
        this.serviceId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CustomDeleteInfoBean(serviceId=");
        sb.append(this.serviceId);
        sb.append(", bindIdKey=");
        sb.append(this.bindIdKey);
        sb.append(", bindIdValue=");
        return a.g(')', this.bindIdValue, sb);
    }

    public CustomDeleteInfoBean(String serviceId, String bindIdKey, String bindIdValue) {
        k.f(serviceId, "serviceId");
        k.f(bindIdKey, "bindIdKey");
        k.f(bindIdValue, "bindIdValue");
        this.serviceId = serviceId;
        this.bindIdKey = bindIdKey;
        this.bindIdValue = bindIdValue;
    }

    public /* synthetic */ CustomDeleteInfoBean(String str, String str2, String str3, int i, e eVar) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }
}
