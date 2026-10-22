package L;

import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class d {
    @DoNotInline
    public static f a(boolean z4, int i4, int i5, int i6, int i7, boolean z5, String str, String str2) {
        return new f(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z4).setColumnIndex(i4).setRowIndex(i5).setColumnSpan(i6).setRowSpan(i7).setSelected(z5).setRowTitle(str).setColumnTitle(str2).build());
    }

    @DoNotInline
    public static g b(AccessibilityNodeInfo accessibilityNodeInfo, int i4, int i5) {
        AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i4, i5);
        if (child != null) {
            return new g(child, 0);
        }
        return null;
    }

    @DoNotInline
    public static String c(Object obj) {
        return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnTitle();
    }

    @DoNotInline
    public static String d(Object obj) {
        return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowTitle();
    }

    @DoNotInline
    public static AccessibilityNodeInfo.ExtraRenderingInfo e(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getExtraRenderingInfo();
    }

    @DoNotInline
    public static g f(AccessibilityNodeInfo accessibilityNodeInfo, int i4) {
        AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent(i4);
        if (parent != null) {
            return new g(parent, 0);
        }
        return null;
    }

    @DoNotInline
    public static String g(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getUniqueId();
    }

    @DoNotInline
    public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isTextSelectable();
    }

    @DoNotInline
    public static void i(AccessibilityNodeInfo accessibilityNodeInfo, boolean z4) {
        accessibilityNodeInfo.setTextSelectable(z4);
    }

    @DoNotInline
    public static void j(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        accessibilityNodeInfo.setUniqueId(str);
    }
}
