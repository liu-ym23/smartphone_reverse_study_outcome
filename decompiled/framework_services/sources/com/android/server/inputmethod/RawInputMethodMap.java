package com.android.server.inputmethod;

import android.util.ArrayMap;
import android.util.Slog;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodSubtype;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class RawInputMethodMap {
    private static final ArrayMap<String, InputMethodInfo> EMPTY_MAP = null;
    static final String TAG = "RawInputMethodMap";
    private final ArrayMap<String, InputMethodInfo> mMap;

    static {
        EMPTY_MAP = new ArrayMap();
    }

    static RawInputMethodMap emptyMap() {
        return new RawInputMethodMap(EMPTY_MAP);
    }

    static RawInputMethodMap of(ArrayMap<String, InputMethodInfo> map) {
        return new RawInputMethodMap(map);
    }

    private RawInputMethodMap(ArrayMap<String, InputMethodInfo> map) {
        if (map.isEmpty() == false) goto L5;
        ArrayMap<String, InputMethodInfo> r0 = EMPTY_MAP;
    L6:
        this.mMap = r0;
        return;
    L5:
        r0 = new ArrayMap(map);
        goto L6
    }

    List<InputMethodInfo> values() {
        return List.copyOf(this.mMap.values());
    }

    InputMethodMap toInputMethodMap(AdditionalSubtypeMap additionalSubtypeMap, int directBootAwareness, boolean userUnlocked) {
        int size = this.mMap.size();
        ArrayMap<String, InputMethodInfo> newMap = new ArrayMap(size);
        switch(directBootAwareness) {
            case 0: goto L6;
            case 1: goto L5;
            default: goto L4;
        };
    L4:
        boolean requireDirectBootAwareFlag = !userUnlocked;
        Slog.e(TAG, "Unknown directBootAwareness=" + directBootAwareness + ". Falling back to DirectBootAwareness.AUTO");
    L7:
        boolean updated = false;
        int i = 0;
    L8:
        if (i >= size) goto L23;
        String imeId = this.mMap.keyAt(i);
        InputMethodInfo imi = this.mMap.valueAt(i);
        if (requireDirectBootAwareFlag == true) goto L12;
    L14:
        List<InputMethodSubtype> newAdditionalSubtypes = additionalSubtypeMap.get(imeId);
        if (newAdditionalSubtypes != null) goto L17;
    L20:
        newMap.put(imi.getId(), imi);
    L21:
        i = i + 1;
        goto L8
    L17:
        if (newAdditionalSubtypes.isEmpty() == true) goto L20;
        updated = true;
        newMap.put(imi.getId(), new InputMethodInfo(imi, newAdditionalSubtypes));
        goto L21
    L12:
        if (imi.getServiceInfo().directBootAware == true) goto L14;
        updated = true;
        goto L21
    L23:
        if (updated == false) goto L25;
        ArrayMap<String, InputMethodInfo> r4 = newMap;
    L27:
        return InputMethodMap.of(r4);
    L25:
        r4 = this.mMap;
        goto L27
    L5:
        requireDirectBootAwareFlag = false;
        goto L7
    L6:
        requireDirectBootAwareFlag = !userUnlocked;
        goto L7
    }
}
