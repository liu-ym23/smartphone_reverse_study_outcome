package com.stepos.policy.sdk.bean;

import java.util.LinkedHashMap;
import yb.f;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class DeleteInfoEncryptMultiBean {
    private LinkedHashMap<String, String> bindMap;
    private String serviceId;

    public /* synthetic */ DeleteInfoEncryptMultiBean(String str, LinkedHashMap linkedHashMap, int i, f fVar) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeleteInfoEncryptMultiBean copy$default(DeleteInfoEncryptMultiBean deleteInfoEncryptMultiBean, String str, LinkedHashMap linkedHashMap, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deleteInfoEncryptMultiBean.serviceId;
        }
        if ((i & 2) != 0) {
            linkedHashMap = deleteInfoEncryptMultiBean.bindMap;
        }
        return deleteInfoEncryptMultiBean.copy(str, linkedHashMap);
    }

    public final String component1() {
        return this.serviceId;
    }

    public final LinkedHashMap<String, String> component2() {
        return this.bindMap;
    }

    public final DeleteInfoEncryptMultiBean copy(String str, LinkedHashMap<String, String> linkedHashMap) {
        str.getClass();
        return new DeleteInfoEncryptMultiBean(str, linkedHashMap);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeleteInfoEncryptMultiBean)) {
            return false;
        }
        DeleteInfoEncryptMultiBean deleteInfoEncryptMultiBean = (DeleteInfoEncryptMultiBean) obj;
        return k.a(this.serviceId, deleteInfoEncryptMultiBean.serviceId) && k.a(this.bindMap, deleteInfoEncryptMultiBean.bindMap);
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
        str.getClass();
        this.serviceId = str;
    }

    public String toString() {
        return "DeleteInfoEncryptMultiBean(serviceId=" + this.serviceId + ", bindMap=" + this.bindMap + ')';
    }

    public DeleteInfoEncryptMultiBean(String str, LinkedHashMap<String, String> linkedHashMap) {
        str.getClass();
        this.serviceId = str;
        this.bindMap = linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeleteInfoEncryptMultiBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }
}
