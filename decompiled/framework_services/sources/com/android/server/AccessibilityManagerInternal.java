package com.android.server;

import android.util.ArraySet;
import android.util.SparseArray;
import android.view.inputmethod.EditorInfo;
import com.android.internal.inputmethod.IAccessibilityInputMethodSession;
import com.android.internal.inputmethod.IRemoteAccessibilityInputConnection;

/* JADX INFO: loaded from: classes.dex */
public abstract class AccessibilityManagerInternal {
    private static final AccessibilityManagerInternal NOP = null;

    public abstract void bindInput();

    public abstract void createImeSession(ArraySet<Integer> r1);

    public abstract boolean isTouchExplorationEnabled(int r1);

    public abstract void performSystemAction(int r1);

    public abstract void setImeSessionEnabled(SparseArray<IAccessibilityInputMethodSession> r1, boolean r2);

    public abstract void startInput(IRemoteAccessibilityInputConnection r1, EditorInfo r2, boolean r3);

    public abstract void unbindInput();

    public AccessibilityManagerInternal() {
    }

    static {
        NOP = new AnonymousClass1();
    }

    public static AccessibilityManagerInternal get() {
        AccessibilityManagerInternal instance = (AccessibilityManagerInternal) LocalServices.getService(AccessibilityManagerInternal.class);
        if (instance == null) goto L6;
        return instance;
    L6:
        return NOP;
    }
}
