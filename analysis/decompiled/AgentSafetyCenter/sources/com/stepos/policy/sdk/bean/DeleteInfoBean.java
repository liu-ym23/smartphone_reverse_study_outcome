package com.stepos.policy.sdk.bean;

import androidx.activity.b;
import k0.a;
import yb.f;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class DeleteInfoBean {
    private String bindId;
    private String keyInfo;
    private String serviceId;

    public /* synthetic */ DeleteInfoBean(String str, String str2, String str3, int i, f fVar) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public static /* synthetic */ DeleteInfoBean copy$default(DeleteInfoBean deleteInfoBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deleteInfoBean.serviceId;
        }
        if ((i & 2) != 0) {
            str2 = deleteInfoBean.bindId;
        }
        if ((i & 4) != 0) {
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
        str.getClass();
        str2.getClass();
        str3.getClass();
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
        return k.a(this.serviceId, deleteInfoBean.serviceId) && k.a(this.bindId, deleteInfoBean.bindId) && k.a(this.keyInfo, deleteInfoBean.keyInfo);
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
        return this.keyInfo.hashCode() + b.d(this.serviceId.hashCode() * 31, 31, this.bindId);
    }

    public final void setBindId(String str) {
        str.getClass();
        this.bindId = str;
    }

    public final void setKeyInfo(String str) {
        str.getClass();
        this.keyInfo = str;
    }

    public final void setServiceId(String str) {
        str.getClass();
        this.serviceId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("DeleteInfoBean(serviceId=");
        sb2.append(this.serviceId);
        sb2.append(", bindId=");
        sb2.append(this.bindId);
        sb2.append(", keyInfo=");
        return a.s(sb2, this.keyInfo, ')');
    }

    public DeleteInfoBean(String str, String str2, String str3) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        this.serviceId = str;
        this.bindId = str2;
        this.keyInfo = str3;
    }

    public DeleteInfoBean() {
        this(null, null, null, 7, null);
    }
}
