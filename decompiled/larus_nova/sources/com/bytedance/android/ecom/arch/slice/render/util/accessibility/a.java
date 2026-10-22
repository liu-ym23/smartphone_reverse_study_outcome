package com.bytedance.android.ecom.arch.slice.render.util.accessibility;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements AccessibilityManager.AccessibilityStateChangeListener, AccessibilityManager.TouchExplorationStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AccessibilityManager f50727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f50728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f50729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f50730d = null;

    /* JADX INFO: renamed from: com.bytedance.android.ecom.arch.slice.render.util.accessibility.a$a, reason: collision with other inner class name */
    public interface InterfaceC0864a {
        void a(AccessibilityNodeInfoCompat r100);
    }

    public a() {
    }

    static {
        f50730d = new a();
    }

    public static String b(String r100) {
        if (r100 != null) goto L5;
    L19:
        return null;
    L5:
        switch(r100.hashCode()) {
            case -1377687758: goto L17;
            case 3556653: goto L14;
            case 100313435: goto L11;
            case 100358090: goto L8;
            default: goto L19;
        };
    L8:
        if (r100.equals("input") == false) goto L19;
        return AndroidComposeViewAccessibilityDelegateCompat.TextFieldClassName;
    L11:
        if (r100.equals("image") == false) goto L19;
        return "android.widget.ImageView";
    L14:
        if (r100.equals("text") == false) goto L19;
        return AndroidComposeViewAccessibilityDelegateCompat.TextClassName;
    L17:
        if (r100.equals("button") == false) goto L19;
        return "android.widget.Button";
    }

    public final boolean c(Context r100) {
        AccessibilityManager r101 = f50727a;
        if (r101 != null) goto L11;
        Object r102 = r100.getSystemService("accessibility");
        if ((r102 instanceof AccessibilityManager) == true) goto L7;
        r102 = null;
    L7:
        r101 = (AccessibilityManager) r102;
        if (r101 == null) goto L10;
        f50728b = r101.isEnabled();
        f50729c = r101.isTouchExplorationEnabled();
        r101.addAccessibilityStateChangeListener(this);
        r101.addTouchExplorationStateChangeListener(this);
    L10:
        f50727a = r101;
    L11:
        if (r101 != null) goto L13;
    L17:
        return false;
    L13:
        if (f50728b == false) goto L17;
        if (f50729c == false) goto L17;
        return true;
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean r100) {
        f50728b = r100;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean r100) {
        f50729c = r100;
    }

    public static void a(View r100, boolean r101) {
        if (r101 == false) goto L5;
        r100.setImportantForAccessibility(1);
    L9:
        if (Build.VERSION.SDK_INT < 26) goto L12;
        r100.setFocusable(r101 ? 1 : 0);
        return;
    L12:
        return;
    L5:
        if ((r100 instanceof ViewGroup) == false) goto L7;
        ((ViewGroup) r100).setImportantForAccessibility(4);
        goto L9
    L7:
        r100.setImportantForAccessibility(2);
        goto L9
    }
}
