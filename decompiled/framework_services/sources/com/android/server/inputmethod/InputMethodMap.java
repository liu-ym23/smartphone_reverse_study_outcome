package com.android.server.inputmethod;

import android.util.ArrayMap;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodSubtype;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class InputMethodMap {
    private static final ArrayMap<String, InputMethodInfo> EMPTY_MAP = null;
    private final ArrayMap<String, InputMethodInfo> mMap;

    static {
        EMPTY_MAP = new ArrayMap();
    }

    static InputMethodMap emptyMap() {
        return new InputMethodMap(EMPTY_MAP);
    }

    static InputMethodMap of(ArrayMap<String, InputMethodInfo> map) {
        return new InputMethodMap(map);
    }

    private InputMethodMap(ArrayMap<String, InputMethodInfo> map) {
        if (map.isEmpty() == false) goto L5;
        ArrayMap<String, InputMethodInfo> r0 = EMPTY_MAP;
    L6:
        this.mMap = r0;
        return;
    L5:
        r0 = new ArrayMap(map);
        goto L6
    }

    InputMethodInfo get(String imeId) {
        return this.mMap.get(imeId);
    }

    List<InputMethodInfo> values() {
        return List.copyOf(this.mMap.values());
    }

    InputMethodInfo valueAt(int index) {
        return this.mMap.valueAt(index);
    }

    boolean containsKey(String imeId) {
        return this.mMap.containsKey(imeId);
    }

    int size() {
        return this.mMap.size();
    }

    public InputMethodMap applyAdditionalSubtypes(AdditionalSubtypeMap additionalSubtypeMap) {
        if (additionalSubtypeMap.isEmpty() == false) goto L5;
        return this;
    L5:
        int size = size();
        ArrayMap<String, InputMethodInfo> newMethodMap = new ArrayMap(size);
        boolean updated = false;
        int i = 0;
    L6:
        if (i >= size) goto L16;
        InputMethodInfo imi = valueAt(i);
        String imeId = imi.getId();
        List<InputMethodSubtype> newAdditionalSubtypes = additionalSubtypeMap.get(imeId);
        if (newAdditionalSubtypes != null) goto L10;
    L13:
        newMethodMap.put(imi.getId(), imi);
    L14:
        i = i + 1;
        goto L6
    L10:
        if (newAdditionalSubtypes.isEmpty() == true) goto L13;
        newMethodMap.put(imi.getId(), new InputMethodInfo(imi, newAdditionalSubtypes));
        updated = true;
        goto L14
    L16:
        if (updated == false) goto L19;
        return of(newMethodMap);
    L19:
        return this;
    }

    static boolean areSame(InputMethodMap map1, InputMethodMap map2) {
        if (map1 != map2) goto L5;
        return true;
    L5:
        int size = map1.size();
        if (size == map2.size()) goto L8;
        return false;
    L8:
        int i = 0;
    L9:
        if (i >= size) goto L18;
        InputMethodInfo imi1 = map1.valueAt(i);
        String imeId = imi1.getId();
        InputMethodInfo imi2 = map2.get(imeId);
        if (imi2 == null) goto L12;
        byte[] marshaled1 = InputMethodInfoUtils.marshal(imi1);
        byte[] marshaled2 = InputMethodInfoUtils.marshal(imi2);
        if (Arrays.equals(marshaled1, marshaled2) == false) goto L15;
        i = i + 1;
        goto L9
    L15:
        return false;
    L12:
        return false;
    L18:
        return true;
    }
}
