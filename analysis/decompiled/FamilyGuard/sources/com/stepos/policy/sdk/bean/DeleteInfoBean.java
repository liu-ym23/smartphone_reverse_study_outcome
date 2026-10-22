package com.stepos.policy.sdk.bean;

import j4.g;
import j4.k;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class DeleteInfoBean {
    private String bindId;
    private String keyInfo;
    private String serviceId;

    public DeleteInfoBean() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ DeleteInfoBean copy$default(DeleteInfoBean deleteInfoBean, String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = deleteInfoBean.serviceId;
        }
        if ((i5 & 2) != 0) {
            str2 = deleteInfoBean.bindId;
        }
        if ((i5 & 4) != 0) {
            str3 = deleteInfoBean.keyInfo;
        }
        return deleteInfoBean.copy(str, str2, str3);
    }

    public final String component1() {
        return this.serviceId;
    }

    public final String component2() {
        return this.bindId;
    }

    public final String component3() {
        return this.keyInfo;
    }

    public final DeleteInfoBean copy(String str, String str2, String str3) {
        k.g(str, "serviceId");
        k.g(str2, "bindId");
        k.g(str3, "keyInfo");
        return new DeleteInfoBean(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeleteInfoBean)) {
            return false;
        }
        DeleteInfoBean deleteInfoBean = (DeleteInfoBean) obj;
        return k.b(this.serviceId, deleteInfoBean.serviceId) && k.b(this.bindId, deleteInfoBean.bindId) && k.b(this.keyInfo, deleteInfoBean.keyInfo);
    }

    public final String getBindId() {
        return this.bindId;
    }

    public final String getKeyInfo() {
        return this.keyInfo;
    }

    public final String getServiceId() {
        return this.serviceId;
    }

    public int hashCode() {
        return (((this.serviceId.hashCode() * 31) + this.bindId.hashCode()) * 31) + this.keyInfo.hashCode();
    }

    public final void setBindId(String str) {
        k.g(str, "<set-?>");
        this.bindId = str;
    }

    public final void setKeyInfo(String str) {
        k.g(str, "<set-?>");
        this.keyInfo = str;
    }

    public final void setServiceId(String str) {
        k.g(str, "<set-?>");
        this.serviceId = str;
    }

    public String toString() {
        return "DeleteInfoBean(serviceId=" + this.serviceId + ", bindId=" + this.bindId + ", keyInfo=" + this.keyInfo + ')';
    }

    public DeleteInfoBean(String str, String str2, String str3) {
        k.g(str, "serviceId");
        k.g(str2, "bindId");
        k.g(str3, "keyInfo");
        this.serviceId = str;
        this.bindId = str2;
        this.keyInfo = str3;
    }

    public /* synthetic */ DeleteInfoBean(String str, String str2, String str3, int i5, g gVar) {
        this((i5 & 1) != 0 ? BuildConfig.FLAVOR : str, (i5 & 2) != 0 ? BuildConfig.FLAVOR : str2, (i5 & 4) != 0 ? BuildConfig.FLAVOR : str3);
    }
}
