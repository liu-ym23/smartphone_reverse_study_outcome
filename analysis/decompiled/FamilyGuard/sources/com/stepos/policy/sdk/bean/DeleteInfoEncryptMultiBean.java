package com.stepos.policy.sdk.bean;

import j4.g;
import j4.k;
import java.util.LinkedHashMap;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class DeleteInfoEncryptMultiBean {
    private LinkedHashMap<String, String> bindMap;
    private String serviceId;

    /* JADX WARN: Multi-variable type inference failed */
    public DeleteInfoEncryptMultiBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeleteInfoEncryptMultiBean copy$default(DeleteInfoEncryptMultiBean deleteInfoEncryptMultiBean, String str, LinkedHashMap linkedHashMap, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = deleteInfoEncryptMultiBean.serviceId;
        }
        if ((i5 & 2) != 0) {
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
        k.g(str, "serviceId");
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
        return k.b(this.serviceId, deleteInfoEncryptMultiBean.serviceId) && k.b(this.bindMap, deleteInfoEncryptMultiBean.bindMap);
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
        k.g(str, "<set-?>");
        this.serviceId = str;
    }

    public String toString() {
        return "DeleteInfoEncryptMultiBean(serviceId=" + this.serviceId + ", bindMap=" + this.bindMap + ')';
    }

    public DeleteInfoEncryptMultiBean(String str, LinkedHashMap<String, String> linkedHashMap) {
        k.g(str, "serviceId");
        this.serviceId = str;
        this.bindMap = linkedHashMap;
    }

    public /* synthetic */ DeleteInfoEncryptMultiBean(String str, LinkedHashMap linkedHashMap, int i5, g gVar) {
        this((i5 & 1) != 0 ? BuildConfig.FLAVOR : str, (i5 & 2) != 0 ? null : linkedHashMap);
    }
}
