package com.stepos.policy.sdk.bean;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/stepos/policy/sdk/bean/DeleteInfoBean;", "", "serviceId", "", "bindId", "keyInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBindId", "()Ljava/lang/String;", "setBindId", "(Ljava/lang/String;)V", "getKeyInfo", "setKeyInfo", "getServiceId", "setServiceId", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DeleteInfoBean {
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
        p.i(serviceId, "serviceId");
        p.i(bindId, "bindId");
        p.i(keyInfo, "keyInfo");
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
        return p.d(this.serviceId, deleteInfoBean.serviceId) && p.d(this.bindId, deleteInfoBean.bindId) && p.d(this.keyInfo, deleteInfoBean.keyInfo);
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
        p.i(str, "<set-?>");
        this.bindId = str;
    }

    public final void setKeyInfo(String str) {
        p.i(str, "<set-?>");
        this.keyInfo = str;
    }

    public final void setServiceId(String str) {
        p.i(str, "<set-?>");
        this.serviceId = str;
    }

    public String toString() {
        return "DeleteInfoBean(serviceId=" + this.serviceId + ", bindId=" + this.bindId + ", keyInfo=" + this.keyInfo + ')';
    }

    public DeleteInfoBean(String serviceId, String bindId, String keyInfo) {
        p.i(serviceId, "serviceId");
        p.i(bindId, "bindId");
        p.i(keyInfo, "keyInfo");
        this.serviceId = serviceId;
        this.bindId = bindId;
        this.keyInfo = keyInfo;
    }

    public /* synthetic */ DeleteInfoBean(String str, String str2, String str3, int i10, i iVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3);
    }
}
