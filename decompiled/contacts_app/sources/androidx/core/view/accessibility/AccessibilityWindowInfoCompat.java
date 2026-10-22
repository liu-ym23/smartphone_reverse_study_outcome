package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import com.android.contacts.common.list.DefaultContactListAdapter;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityWindowInfoCompat {
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = -1;
    private final Object mInfo;

    private static class Api21Impl {
        private Api21Impl() {
        }

        static void getBoundsInScreen(AccessibilityWindowInfo r0, Rect r1) {
            r0.getBoundsInScreen(r1);
        }

        static AccessibilityWindowInfo getChild(AccessibilityWindowInfo r0, int r1) {
            return r0.getChild(r1);
        }

        static int getChildCount(AccessibilityWindowInfo r0) {
            return r0.getChildCount();
        }

        static int getId(AccessibilityWindowInfo r0) {
            return r0.getId();
        }

        static int getLayer(AccessibilityWindowInfo r0) {
            return r0.getLayer();
        }

        static AccessibilityWindowInfo getParent(AccessibilityWindowInfo r0) {
            return r0.getParent();
        }

        static AccessibilityNodeInfo getRoot(AccessibilityWindowInfo r0) {
            return r0.getRoot();
        }

        static int getType(AccessibilityWindowInfo r0) {
            return r0.getType();
        }

        static boolean isAccessibilityFocused(AccessibilityWindowInfo r0) {
            return r0.isAccessibilityFocused();
        }

        static boolean isActive(AccessibilityWindowInfo r0) {
            return r0.isActive();
        }

        static boolean isFocused(AccessibilityWindowInfo r0) {
            return r0.isFocused();
        }

        static AccessibilityWindowInfo obtain() {
            return AccessibilityWindowInfo.obtain();
        }

        static AccessibilityWindowInfo obtain(AccessibilityWindowInfo r0) {
            return AccessibilityWindowInfo.obtain(r0);
        }
    }

    private static class Api24Impl {
        private Api24Impl() {
        }

        static AccessibilityNodeInfo getAnchor(AccessibilityWindowInfo r0) {
            return r0.getAnchor();
        }

        static CharSequence getTitle(AccessibilityWindowInfo r0) {
            return r0.getTitle();
        }
    }

    private static class Api33Impl {
        private Api33Impl() {
        }

        static int getDisplayId(AccessibilityWindowInfo r0) {
            return r0.getDisplayId();
        }

        static void getRegionInScreen(AccessibilityWindowInfo r0, Region r1) {
            r0.getRegionInScreen(r1);
        }

        static boolean isInPictureInPictureMode(AccessibilityWindowInfo r0) {
            return r0.isInPictureInPictureMode();
        }
    }

    private static String typeToString(int r1) {
        if (r1 != 1) goto L5;
        return "TYPE_APPLICATION";
    L5:
        if (r1 != 2) goto L7;
        return "TYPE_INPUT_METHOD";
    L7:
        if (r1 != 3) goto L9;
        return "TYPE_SYSTEM";
    L9:
        if (r1 == 4) goto L12;
        return "<UNKNOWN>";
    L12:
        return "TYPE_ACCESSIBILITY_OVERLAY";
    }

    @Deprecated
    public void recycle() {
    }

    static AccessibilityWindowInfoCompat wrapNonNullInstance(Object r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        return new AccessibilityWindowInfoCompat(r1);
    }

    private AccessibilityWindowInfoCompat(Object r1) {
        this.mInfo = r1;
    }

    public int getType() {
        return Api21Impl.getType((AccessibilityWindowInfo) this.mInfo);
    }

    public int getLayer() {
        return Api21Impl.getLayer((AccessibilityWindowInfo) this.mInfo);
    }

    public AccessibilityNodeInfoCompat getRoot() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(Api21Impl.getRoot((AccessibilityWindowInfo) this.mInfo));
    }

    public boolean isInPictureInPictureMode() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return false;
    L5:
        return Api33Impl.isInPictureInPictureMode((AccessibilityWindowInfo) this.mInfo);
    }

    public AccessibilityWindowInfoCompat getParent() {
        return wrapNonNullInstance(Api21Impl.getParent((AccessibilityWindowInfo) this.mInfo));
    }

    public int getId() {
        return Api21Impl.getId((AccessibilityWindowInfo) this.mInfo);
    }

    public void getRegionInScreen(Region r3) {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        Api33Impl.getRegionInScreen((AccessibilityWindowInfo) this.mInfo, r3);
        return;
    L5:
        Rect r0 = new Rect();
        Api21Impl.getBoundsInScreen((AccessibilityWindowInfo) this.mInfo, r0);
        r3.set(r0);
    }

    public void getBoundsInScreen(Rect r1) {
        Api21Impl.getBoundsInScreen((AccessibilityWindowInfo) this.mInfo, r1);
    }

    public boolean isActive() {
        return Api21Impl.isActive((AccessibilityWindowInfo) this.mInfo);
    }

    public boolean isFocused() {
        return Api21Impl.isFocused((AccessibilityWindowInfo) this.mInfo);
    }

    public boolean isAccessibilityFocused() {
        return Api21Impl.isAccessibilityFocused((AccessibilityWindowInfo) this.mInfo);
    }

    public int getChildCount() {
        return Api21Impl.getChildCount((AccessibilityWindowInfo) this.mInfo);
    }

    public AccessibilityWindowInfoCompat getChild(int r1) {
        return wrapNonNullInstance(Api21Impl.getChild((AccessibilityWindowInfo) this.mInfo, r1));
    }

    public int getDisplayId() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return 0;
    L5:
        return Api33Impl.getDisplayId((AccessibilityWindowInfo) this.mInfo);
    }

    public CharSequence getTitle() {
        return Api24Impl.getTitle((AccessibilityWindowInfo) this.mInfo);
    }

    public AccessibilityNodeInfoCompat getAnchor() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(Api24Impl.getAnchor((AccessibilityWindowInfo) this.mInfo));
    }

    public static AccessibilityWindowInfoCompat obtain() {
        return wrapNonNullInstance(Api21Impl.obtain());
    }

    public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat r0) {
        if (r0 != null) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(Api21Impl.obtain((AccessibilityWindowInfo) r0.mInfo));
    }

    public AccessibilityWindowInfo unwrap() {
        return (AccessibilityWindowInfo) this.mInfo;
    }

    public int hashCode() {
        Object r0 = this.mInfo;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L9;
        return false;
    L9:
        if ((r4 instanceof AccessibilityWindowInfoCompat) == true) goto L11;
        return false;
    L11:
        AccessibilityWindowInfoCompat r5 = (AccessibilityWindowInfoCompat) r4;
        Object r3 = this.mInfo;
        if (r3 != null) goto L19;
        if (r5.mInfo != null) goto L17;
        return true;
    L17:
        return false;
    L19:
        return r3.equals(r5.mInfo);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("AccessibilityWindowInfo[id=");
        Rect r1 = new Rect();
        getBoundsInScreen(r1);
        r0.append(getId());
        r0.append(", type=").append(typeToString(getType()));
        r0.append(", layer=").append(getLayer());
        r0.append(", bounds=").append(r1);
        r0.append(", focused=").append(isFocused());
        r0.append(", active=").append(isActive());
        StringBuilder r2 = r0.append(", hasParent=");
        boolean r3 = true;
        if (getParent() == null) goto L5;
        boolean r4 = true;
    L6:
        r2.append(r4);
        StringBuilder r5 = r0.append(", hasChildren=");
        if (getChildCount() > 0) goto L10;
        r3 = false;
    L10:
        r5.append(r3);
        r0.append(DefaultContactListAdapter.SNIPPET_END_MATCH);
        return r0.toString();
    L5:
        r4 = false;
        goto L6
    }
}
