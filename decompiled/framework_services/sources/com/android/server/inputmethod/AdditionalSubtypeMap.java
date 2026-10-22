package com.android.server.inputmethod;

import android.util.ArrayMap;
import android.view.inputmethod.InputMethodSubtype;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class AdditionalSubtypeMap {
    static final AdditionalSubtypeMap EMPTY_MAP = null;
    private final ArrayMap<String, List<InputMethodSubtype>> mMap;

    static {
        EMPTY_MAP = new AdditionalSubtypeMap(new ArrayMap());
    }

    private static AdditionalSubtypeMap createOrEmpty(ArrayMap<String, List<InputMethodSubtype>> map) {
        if (map.isEmpty() == false) goto L6;
        return EMPTY_MAP;
    L6:
        return new AdditionalSubtypeMap(map);
    }

    static AdditionalSubtypeMap of(ArrayMap<String, List<InputMethodSubtype>> map) {
        return createOrEmpty(map);
    }

    AdditionalSubtypeMap cloneWithRemoveOrSelf(String key) {
        if (isEmpty() == false) goto L5;
    L9:
        return this;
    L5:
        if (containsKey(key) == false) goto L9;
        ArrayMap<String, List<InputMethodSubtype>> newMap = new ArrayMap(this.mMap);
        newMap.remove(key);
        return createOrEmpty(newMap);
    }

    AdditionalSubtypeMap cloneWithRemoveOrSelf(Collection<String> keys) {
        if (isEmpty() == false) goto L5;
        return this;
    L5:
        ArrayMap<String, List<InputMethodSubtype>> newMap = new ArrayMap(this.mMap);
        if (newMap.removeAll(keys) == false) goto L9;
        return createOrEmpty(newMap);
    L9:
        return this;
    }

    AdditionalSubtypeMap cloneWithPut(String key, List<InputMethodSubtype> value) {
        ArrayMap<String, List<InputMethodSubtype>> newMap = new ArrayMap(this.mMap);
        newMap.put(key, value);
        return new AdditionalSubtypeMap(newMap);
    }

    private AdditionalSubtypeMap(ArrayMap<String, List<InputMethodSubtype>> map) {
        this.mMap = map;
    }

    List<InputMethodSubtype> get(String key) {
        return this.mMap.get(key);
    }

    boolean containsKey(String key) {
        return this.mMap.containsKey(key);
    }

    boolean isEmpty() {
        return this.mMap.isEmpty();
    }

    Collection<String> keySet() {
        return this.mMap.keySet();
    }

    int size() {
        return this.mMap.size();
    }
}
