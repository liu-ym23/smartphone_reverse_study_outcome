package com.stepos.policy.sdk.bean;

import B7.a;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/stepos/policy/sdk/bean/DeleteInfoBean;", "", "serviceId", "", "bindId", "keyInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBindId", "()Ljava/lang/String;", "setBindId", "(Ljava/lang/String;)V", "getKeyInfo", "setKeyInfo", "getServiceId", "setServiceId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DeleteInfoBean {
    private String bindId;
    private String keyInfo;
    private String serviceId;

    public DeleteInfoBean() {
        this(null, null, null, 7, null);
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

    /* renamed from: component1, reason: from getter */
    public final String getServiceId() {
        return this.serviceId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBindId() {
        return this.bindId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getKeyInfo() {
        return this.keyInfo;
    }

    public final DeleteInfoBean copy(String serviceId, String bindId, String keyInfo) {
        k.f(serviceId, "serviceId");
        k.f(bindId, "bindId");
        k.f(keyInfo, "keyInfo");
        return new DeleteInfoBean(serviceId, bindId, keyInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeleteInfoBean)) {
            return false;
        }
        DeleteInfoBean deleteInfoBean = (DeleteInfoBean) other;
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
        return this.keyInfo.hashCode() + a.c(this.serviceId.hashCode() * 31, 31, this.bindId);
    }

    public final void setBindId(String str) {
        k.f(str, "<set-?>");
        this.bindId = str;
    }

    public final void setKeyInfo(String str) {
        k.f(str, "<set-?>");
        this.keyInfo = str;
    }

    public final void setServiceId(String str) {
        k.f(str, "<set-?>");
        this.serviceId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DeleteInfoBean(serviceId=");
        sb.append(this.serviceId);
        sb.append(", bindId=");
        sb.append(this.bindId);
        sb.append(", keyInfo=");
        return a.g(')', this.keyInfo, sb);
    }

    public DeleteInfoBean(String serviceId, String bindId, String keyInfo) {
        k.f(serviceId, "serviceId");
        k.f(bindId, "bindId");
        k.f(keyInfo, "keyInfo");
        this.serviceId = serviceId;
        this.bindId = bindId;
        this.keyInfo = keyInfo;
    }

    public /* synthetic */ DeleteInfoBean(String str, String str2, String str3, int i, e eVar) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }
}
