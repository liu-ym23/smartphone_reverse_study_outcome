package com.bytedance.android.accessibilityLib_Core.tool;

import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.android.accessibilityLib_Core.config.base.IBaseConfig;

/* JADX INFO: loaded from: classes43.dex */
public final class a {
    public static final String a(IBaseConfig r100) {
        CharSequence r101 = ((AccessibilityNodeInfoCompat) r100.getVirtualNode().f38154d.getValue()).getContentDescription();
        if (r101 == null) goto L7;
        String r102 = r101.toString();
        if (r102 == null) goto L7;
        return r102;
    L7:
        return "";
    }
}
