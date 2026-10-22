package com.stepos.policy.sdk.bean;

import ai.onnxruntime.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DeleteInfoBean {
    private String bindId;
    private String keyInfo;
    private String serviceId;

    public DeleteInfoBean() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ DeleteInfoBean copy$default(DeleteInfoBean deleteInfoBean, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = deleteInfoBean.serviceId;
        }
        if ((i10 & 2) != 0) {
            str2 = deleteInfoBean.bindId;
        }
        if ((i10 & 4) != 0) {
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

    public final DeleteInfoBean copy(String serviceId, String bindId, String keyInfo) {
        g.f(serviceId, "serviceId");
        g.f(bindId, "bindId");
        g.f(keyInfo, "keyInfo");
        return new DeleteInfoBean(serviceId, bindId, keyInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeleteInfoBean)) {
            return false;
        }
        DeleteInfoBean deleteInfoBean = (DeleteInfoBean) obj;
        return g.b(this.serviceId, deleteInfoBean.serviceId) && g.b(this.bindId, deleteInfoBean.bindId) && g.b(this.keyInfo, deleteInfoBean.keyInfo);
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
        return this.keyInfo.hashCode() + d.a(this.serviceId.hashCode() * 31, 31, this.bindId);
    }

    public final void setBindId(String str) {
        g.f(str, "<set-?>");
        this.bindId = str;
    }

    public final void setKeyInfo(String str) {
        g.f(str, "<set-?>");
        this.keyInfo = str;
    }

    public final void setServiceId(String str) {
        g.f(str, "<set-?>");
        this.serviceId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("DeleteInfoBean(serviceId=");
        sb2.append(this.serviceId);
        sb2.append(", bindId=");
        sb2.append(this.bindId);
        sb2.append(", keyInfo=");
        return a.n(sb2, this.keyInfo, ')');
    }

    public DeleteInfoBean(String serviceId, String bindId, String keyInfo) {
        g.f(serviceId, "serviceId");
        g.f(bindId, "bindId");
        g.f(keyInfo, "keyInfo");
        this.serviceId = serviceId;
        this.bindId = bindId;
        this.keyInfo = keyInfo;
    }

    public /* synthetic */ DeleteInfoBean(String str, String str2, String str3, int i10, e eVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3);
    }
}
