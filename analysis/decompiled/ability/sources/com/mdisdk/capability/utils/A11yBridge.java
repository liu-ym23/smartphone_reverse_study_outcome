package com.mdisdk.capability.utils;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public final class A11yBridge {
    public static final String CN_ANDROID_COMPOSE_VIEW = "androidx.compose.ui.platform.AndroidComposeView";
    public static final int HOST_VIEW_ID = -1;
    private static final String TAG = "APEX-A11yBridge";
    private static final Method sGetChildIdMethod;
    private static final Method sGetVirtualDescendantIdMethod;

    static {
        Method method;
        Method declaredMethod;
        Method declaredMethod2 = null;
        try {
            declaredMethod = AccessibilityNodeInfo.class.getDeclaredMethod("getChildId", Integer.TYPE);
        } catch (NoSuchMethodException e) {
            e = e;
            method = null;
        }
        try {
            declaredMethod.setAccessible(true);
            declaredMethod2 = AccessibilityNodeInfo.class.getDeclaredMethod("getVirtualDescendantId", Long.TYPE);
            declaredMethod2.setAccessible(true);
        } catch (NoSuchMethodException e6) {
            e = e6;
            method = declaredMethod2;
            declaredMethod2 = declaredMethod;
            Log.w(TAG, "reflection init failed, A11y virtual tree disabled: " + e);
            Method method2 = method;
            declaredMethod = declaredMethod2;
            declaredMethod2 = method2;
            sGetChildIdMethod = declaredMethod;
            sGetVirtualDescendantIdMethod = declaredMethod2;
        }
        sGetChildIdMethod = declaredMethod;
        sGetVirtualDescendantIdMethod = declaredMethod2;
    }

    private A11yBridge() {
    }

    @Nullable
    public static View findComposeHostAt(@Nullable View view, int i, int i6) {
        if (view != null && view.isShown()) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i10 = iArr[0];
            if (i >= i10 && i6 >= iArr[1] && i < view.getWidth() + i10) {
                if (i6 < view.getHeight() + iArr[1]) {
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                            View viewFindComposeHostAt = findComposeHostAt(viewGroup.getChildAt(childCount), i, i6);
                            if (viewFindComposeHostAt != null) {
                                return viewFindComposeHostAt;
                            }
                        }
                    }
                    if (isComposeHost(view)) {
                        return view;
                    }
                }
            }
        }
        return null;
    }

    public static int findEditableVirtualNodeAt(@Nullable View view, int i, int i6) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        AccessibilityNodeInfo accessibilityNodeInfoCreateAccessibilityNodeInfo;
        if (view == null || !isComposeHost(view) || !isReflectionReady() || (accessibilityNodeProvider = view.getAccessibilityNodeProvider()) == null || (accessibilityNodeInfoCreateAccessibilityNodeInfo = accessibilityNodeProvider.createAccessibilityNodeInfo(-1)) == null) {
            return -1;
        }
        return searchEditable(accessibilityNodeInfoCreateAccessibilityNodeInfo, -1, accessibilityNodeProvider, i, i6);
    }

    public static long getChildLongId(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, int i) {
        Method method = sGetChildIdMethod;
        if (method == null) {
            return 0L;
        }
        try {
            return ((Long) method.invoke(accessibilityNodeInfo, Integer.valueOf(i))).longValue();
        } catch (Throwable th) {
            Log.w(TAG, "getChildId(" + i + ") failed: " + th);
            return 0L;
        }
    }

    public static boolean isComposeHost(@Nullable View view) {
        if (view == null) {
            return false;
        }
        for (Class<?> superclass = view.getClass(); superclass != null && superclass != View.class; superclass = superclass.getSuperclass()) {
            if (CN_ANDROID_COMPOSE_VIEW.equals(superclass.getName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isReflectionReady() {
        return (sGetChildIdMethod == null || sGetVirtualDescendantIdMethod == null) ? false : true;
    }

    private static int searchEditable(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, int i, @NonNull AccessibilityNodeProvider accessibilityNodeProvider, int i6, int i10) {
        AccessibilityNodeInfo accessibilityNodeInfoCreateAccessibilityNodeInfo;
        int iSearchEditable;
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        if (!rect.contains(i6, i10)) {
            return -1;
        }
        int childCount = accessibilityNodeInfo.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            int iUnpackVirtualId = unpackVirtualId(getChildLongId(accessibilityNodeInfo, i11));
            try {
                accessibilityNodeInfoCreateAccessibilityNodeInfo = accessibilityNodeProvider.createAccessibilityNodeInfo(iUnpackVirtualId);
            } catch (Throwable th) {
                Log.w(TAG, "createAccessibilityNodeInfo(" + iUnpackVirtualId + ") failed: " + th);
            }
            if (accessibilityNodeInfoCreateAccessibilityNodeInfo != null && (iSearchEditable = searchEditable(accessibilityNodeInfoCreateAccessibilityNodeInfo, iUnpackVirtualId, accessibilityNodeProvider, i6, i10)) != -1) {
                return iSearchEditable;
            }
        }
        if (accessibilityNodeInfo.isEditable()) {
            return i;
        }
        return -1;
    }

    public static boolean setTextViaAction(@NonNull View view, int i, @NonNull CharSequence charSequence) {
        AccessibilityNodeProvider accessibilityNodeProvider = view.getAccessibilityNodeProvider();
        if (accessibilityNodeProvider == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putCharSequence(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, charSequence);
        try {
            return accessibilityNodeProvider.performAction(i, 2097152, bundle);
        } catch (Throwable th) {
            Log.w(TAG, "performAction ACTION_SET_TEXT failed: " + th);
            return false;
        }
    }

    public static int unpackVirtualId(long j5) {
        Method method = sGetVirtualDescendantIdMethod;
        if (method == null) {
            return -1;
        }
        try {
            return ((Integer) method.invoke(null, Long.valueOf(j5))).intValue();
        } catch (Throwable th) {
            Log.w(TAG, "getVirtualDescendantId failed: " + th);
            return -1;
        }
    }
}
