package com.android.server.inputmethod;

import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodSubtype;
import com.android.internal.inputmethod.InputMethodSubtypeHandle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class HardwareKeyboardShortcutController {
    private final ArrayList<InputMethodSubtypeHandle> mSubtypeHandles;

    HardwareKeyboardShortcutController() {
        this.mSubtypeHandles = new ArrayList();
    }

    void update(InputMethodSettings settings) {
        this.mSubtypeHandles.clear();
        List<InputMethodInfo> inputMethods = settings.getEnabledInputMethodList();
        int i = 0;
    L4:
        if (i >= inputMethods.size()) goto L20;
        InputMethodInfo imi = inputMethods.get(i);
        if (imi.shouldShowInInputMethodPicker() == false) goto L18;
        List<InputMethodSubtype> subtypes = settings.getEnabledInputMethodSubtypeList(imi, true);
        if (subtypes.isEmpty() == false) goto L11;
        this.mSubtypeHandles.add(InputMethodSubtypeHandle.of(imi, null));
        goto L18
    L11:
        Iterator<InputMethodSubtype> r4 = subtypes.iterator();
    L13:
        if (r4.hasNext() == false) goto L18;
        InputMethodSubtype subtype = r4.next();
        if (subtype.isSuitableForPhysicalKeyboardLayoutMapping() == false) goto L13;
        this.mSubtypeHandles.add(InputMethodSubtypeHandle.of(imi, subtype));
    L18:
        i = i + 1;
        goto L4
    }

    static <T> T getNeighborItem(List<T> list, T value, boolean next) {
        int size = list.size();
        int i = 0;
    L3:
        if (i >= size) goto L12;
        if (Objects.equals(value, list.get(i)) == true) goto L6;
        i = i + 1;
        goto L3
    L6:
        if (next == false) goto L8;
        int r2 = 1;
    L9:
        int nextIndex = ((r2 + i) + size) % size;
        return list.get(nextIndex);
    L8:
        r2 = -1;
        goto L9
    L12:
        return null;
    }

    InputMethodSubtypeHandle onSubtypeSwitch(InputMethodSubtypeHandle currentImeAndSubtype, boolean forward) {
        return (InputMethodSubtypeHandle) getNeighborItem(this.mSubtypeHandles, currentImeAndSubtype, forward);
    }
}
