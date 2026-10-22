package com.stepos.policy.sdk.bean;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012(\b\u0002\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J)\u0010\u0011\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006HÆ\u0003J=\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032(\b\u0002\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R:\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/stepos/policy/sdk/bean/DeleteInfoEncryptMultiBean;", "", "serviceId", "", "bindMap", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "(Ljava/lang/String;Ljava/util/LinkedHashMap;)V", "getBindMap", "()Ljava/util/LinkedHashMap;", "setBindMap", "(Ljava/util/LinkedHashMap;)V", "getServiceId", "()Ljava/lang/String;", "setServiceId", "(Ljava/lang/String;)V", "component1", "component2", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DeleteInfoEncryptMultiBean {
    private LinkedHashMap<String, String> bindMap;
    private String serviceId;

    /* JADX WARN: Multi-variable type inference failed */
    public DeleteInfoEncryptMultiBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeleteInfoEncryptMultiBean copy$default(DeleteInfoEncryptMultiBean deleteInfoEncryptMultiBean, String str, LinkedHashMap linkedHashMap, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = deleteInfoEncryptMultiBean.serviceId;
        }
        if ((i10 & 2) != 0) {
            linkedHashMap = deleteInfoEncryptMultiBean.bindMap;
        }
        return deleteInfoEncryptMultiBean.copy(str, linkedHashMap);
    }

    /* renamed from: component1, reason: from getter */
    public final String getServiceId() {
        return this.serviceId;
    }

    public final LinkedHashMap<String, String> component2() {
        return this.bindMap;
    }

    public final DeleteInfoEncryptMultiBean copy(String serviceId, LinkedHashMap<String, String> bindMap) {
        p.i(serviceId, "serviceId");
        return new DeleteInfoEncryptMultiBean(serviceId, bindMap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeleteInfoEncryptMultiBean)) {
            return false;
        }
        DeleteInfoEncryptMultiBean deleteInfoEncryptMultiBean = (DeleteInfoEncryptMultiBean) other;
        return p.d(this.serviceId, deleteInfoEncryptMultiBean.serviceId) && p.d(this.bindMap, deleteInfoEncryptMultiBean.bindMap);
    }

    public final LinkedHashMap<String, String> getBindMap() {
        return this.bindMap;
    }

    public final String getServiceId() {
        return this.serviceId;
    }

    public int hashCode() {
        int iHashCode = this.serviceId.hashCode() * 31;
        LinkedHashMap<String, String> linkedHashMap = this.bindMap;
        return iHashCode + (linkedHashMap == null ? 0 : linkedHashMap.hashCode());
    }

    public final void setBindMap(LinkedHashMap<String, String> linkedHashMap) {
        this.bindMap = linkedHashMap;
    }

    public final void setServiceId(String str) {
        p.i(str, "<set-?>");
        this.serviceId = str;
    }

    public String toString() {
        return "DeleteInfoEncryptMultiBean(serviceId=" + this.serviceId + ", bindMap=" + this.bindMap + ')';
    }

    public DeleteInfoEncryptMultiBean(String serviceId, LinkedHashMap<String, String> linkedHashMap) {
        p.i(serviceId, "serviceId");
        this.serviceId = serviceId;
        this.bindMap = linkedHashMap;
    }

    public /* synthetic */ DeleteInfoEncryptMultiBean(String str, LinkedHashMap linkedHashMap, int i10, i iVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? null : linkedHashMap);
    }
}
