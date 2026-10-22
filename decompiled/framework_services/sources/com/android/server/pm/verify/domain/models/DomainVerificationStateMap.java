package com.android.server.pm.verify.domain.models;

import android.util.ArrayMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class DomainVerificationStateMap<ValueType> {
    private static final String TAG = "DomainVerificationStateMap";
    private final ArrayMap<UUID, ValueType> mDomainSetIdMap;
    private final ArrayMap<String, ValueType> mPackageNameMap;

    public DomainVerificationStateMap() {
        this.mPackageNameMap = new ArrayMap();
        this.mDomainSetIdMap = new ArrayMap();
    }

    public int size() {
        return this.mPackageNameMap.size();
    }

    public ValueType valueAt(int index) {
        return this.mPackageNameMap.valueAt(index);
    }

    public ValueType get(String packageName) {
        return this.mPackageNameMap.get(packageName);
    }

    public ValueType get(UUID domainSetId) {
        return this.mDomainSetIdMap.get(domainSetId);
    }

    public void put(String packageName, UUID domainSetId, ValueType valueType) {
        if (this.mPackageNameMap.containsKey(packageName) == false) goto L5;
        remove(packageName);
    L5:
        this.mPackageNameMap.put(packageName, valueType);
        this.mDomainSetIdMap.put(domainSetId, valueType);
    }

    public ValueType remove(String packageName) {
        ValueType valueRemoved = this.mPackageNameMap.remove(packageName);
        if (valueRemoved == null) goto L7;
        int index = this.mDomainSetIdMap.indexOfValue(valueRemoved);
        if (index < 0) goto L7;
        this.mDomainSetIdMap.removeAt(index);
    L7:
        return valueRemoved;
    }

    public ValueType remove(UUID domainSetId) {
        ValueType valueRemoved = this.mDomainSetIdMap.remove(domainSetId);
        if (valueRemoved == null) goto L7;
        int index = this.mPackageNameMap.indexOfValue(valueRemoved);
        if (index < 0) goto L7;
        this.mPackageNameMap.removeAt(index);
    L7:
        return valueRemoved;
    }

    public List<String> getPackageNames() {
        return new ArrayList(this.mPackageNameMap.keySet());
    }

    public Collection<ValueType> values() {
        return new ArrayList(this.mPackageNameMap.values());
    }

    public String toString() {
        return "DomainVerificationStateMap{packageNameMap=" + this.mPackageNameMap + ", domainSetIdMap=" + this.mDomainSetIdMap + '}';
    }
}
