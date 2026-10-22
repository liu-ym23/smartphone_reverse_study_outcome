package com.stepos.policy.sdk.bean;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DeleteInfoEncryptMultiBean {
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

    public final String component1() {
        return this.serviceId;
    }

    public final LinkedHashMap<String, String> component2() {
        return this.bindMap;
    }

    public final DeleteInfoEncryptMultiBean copy(String serviceId, LinkedHashMap<String, String> linkedHashMap) {
        g.f(serviceId, "serviceId");
        return new DeleteInfoEncryptMultiBean(serviceId, linkedHashMap);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeleteInfoEncryptMultiBean)) {
            return false;
        }
        DeleteInfoEncryptMultiBean deleteInfoEncryptMultiBean = (DeleteInfoEncryptMultiBean) obj;
        return g.b(this.serviceId, deleteInfoEncryptMultiBean.serviceId) && g.b(this.bindMap, deleteInfoEncryptMultiBean.bindMap);
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
        g.f(str, "<set-?>");
        this.serviceId = str;
    }

    public String toString() {
        return "DeleteInfoEncryptMultiBean(serviceId=" + this.serviceId + ", bindMap=" + this.bindMap + ')';
    }

    public DeleteInfoEncryptMultiBean(String serviceId, LinkedHashMap<String, String> linkedHashMap) {
        g.f(serviceId, "serviceId");
        this.serviceId = serviceId;
        this.bindMap = linkedHashMap;
    }

    public /* synthetic */ DeleteInfoEncryptMultiBean(String str, LinkedHashMap linkedHashMap, int i10, e eVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? null : linkedHashMap);
    }
}
