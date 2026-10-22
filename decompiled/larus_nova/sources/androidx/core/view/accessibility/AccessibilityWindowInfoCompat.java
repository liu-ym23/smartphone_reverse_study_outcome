package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.LocaleList;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.core.os.LocaleListCompat;

/* JADX INFO: loaded from: classes17.dex */
public class AccessibilityWindowInfoCompat {
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_MAGNIFICATION_OVERLAY = 6;
    public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = -1;
    private final Object mInfo;

    public static class Api21Impl {
        public static AccessibilityWindowInfo obtain() {
            return AccessibilityWindowInfo.obtain();
        }

        private Api21Impl() {
        }

        public static int getChildCount(AccessibilityWindowInfo r100) {
            return r100.getChildCount();
        }

        public static int getId(AccessibilityWindowInfo r100) {
            return r100.getId();
        }

        public static int getLayer(AccessibilityWindowInfo r100) {
            return r100.getLayer();
        }

        public static AccessibilityWindowInfo getParent(AccessibilityWindowInfo r100) {
            return r100.getParent();
        }

        public static AccessibilityNodeInfo getRoot(AccessibilityWindowInfo r100) {
            return r100.getRoot();
        }

        public static int getType(AccessibilityWindowInfo r100) {
            return r100.getType();
        }

        public static boolean isAccessibilityFocused(AccessibilityWindowInfo r100) {
            return r100.isAccessibilityFocused();
        }

        public static boolean isActive(AccessibilityWindowInfo r100) {
            return r100.isActive();
        }

        public static boolean isFocused(AccessibilityWindowInfo r100) {
            return r100.isFocused();
        }

        public static AccessibilityWindowInfo obtain(AccessibilityWindowInfo r100) {
            return AccessibilityWindowInfo.obtain(r100);
        }

        public static void getBoundsInScreen(AccessibilityWindowInfo r100, Rect r101) {
            r100.getBoundsInScreen(r101);
        }

        public static AccessibilityWindowInfo getChild(AccessibilityWindowInfo r100, int r101) {
            return r100.getChild(r101);
        }
    }

    public static class Api24Impl {
        private Api24Impl() {
        }

        public static AccessibilityNodeInfo getAnchor(AccessibilityWindowInfo r100) {
            return r100.getAnchor();
        }

        public static CharSequence getTitle(AccessibilityWindowInfo r100) {
            return r100.getTitle();
        }
    }

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static boolean isInPictureInPictureMode(AccessibilityWindowInfo r100) {
            return r100.isInPictureInPictureMode();
        }
    }

    public static class Api30Impl {
        public static AccessibilityWindowInfo instantiateAccessibilityWindowInfo() {
            return new AccessibilityWindowInfo();
        }

        private Api30Impl() {
        }
    }

    public static class Api33Impl {
        private Api33Impl() {
        }

        public static int getDisplayId(AccessibilityWindowInfo r100) {
            return r100.getDisplayId();
        }

        public static void getRegionInScreen(AccessibilityWindowInfo r100, Region r101) {
            r100.getRegionInScreen(r101);
        }

        public static AccessibilityNodeInfoCompat getRoot(Object r100, int r101) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(((AccessibilityWindowInfo) r100).getRoot(r101));
        }
    }

    public static class Api34Impl {
        private Api34Impl() {
        }

        public static LocaleList getLocales(AccessibilityWindowInfo r100) {
            return r100.getLocales();
        }

        public static long getTransitionTimeMillis(AccessibilityWindowInfo r100) {
            return r100.getTransitionTimeMillis();
        }
    }

    private static String typeToString(int r100) {
        if (r100 != 1) goto L5;
        return "TYPE_APPLICATION";
    L5:
        if (r100 != 2) goto L7;
        return "TYPE_INPUT_METHOD";
    L7:
        if (r100 != 3) goto L9;
        return "TYPE_SYSTEM";
    L9:
        if (r100 == 4) goto L12;
        return "<UNKNOWN>";
    L12:
        return "TYPE_ACCESSIBILITY_OVERLAY";
    }

    public void recycle() {
    }

    public AccessibilityNodeInfoCompat getAnchor() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return null;
    L5:
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(Api24Impl.getAnchor((AccessibilityWindowInfo) this.mInfo));
    }

    public int getChildCount() {
        return Api21Impl.getChildCount((AccessibilityWindowInfo) this.mInfo);
    }

    public int getDisplayId() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return 0;
    L5:
        return Api33Impl.getDisplayId((AccessibilityWindowInfo) this.mInfo);
    }

    public int getId() {
        return Api21Impl.getId((AccessibilityWindowInfo) this.mInfo);
    }

    public int getLayer() {
        return Api21Impl.getLayer((AccessibilityWindowInfo) this.mInfo);
    }

    public LocaleListCompat getLocales() {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return LocaleListCompat.wrap(Api34Impl.getLocales((AccessibilityWindowInfo) this.mInfo));
    L7:
        return LocaleListCompat.getEmptyLocaleList();
    }

    public AccessibilityWindowInfoCompat getParent() {
        return wrapNonNullInstance(Api21Impl.getParent((AccessibilityWindowInfo) this.mInfo));
    }

    public AccessibilityNodeInfoCompat getRoot() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(Api21Impl.getRoot((AccessibilityWindowInfo) this.mInfo));
    }

    public CharSequence getTitle() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return null;
    L5:
        return Api24Impl.getTitle((AccessibilityWindowInfo) this.mInfo);
    }

    public long getTransitionTimeMillis() {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return 0;
    L5:
        return Api34Impl.getTransitionTimeMillis((AccessibilityWindowInfo) this.mInfo);
    }

    public int getType() {
        return Api21Impl.getType((AccessibilityWindowInfo) this.mInfo);
    }

    public int hashCode() {
        Object r100 = this.mInfo;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public boolean isAccessibilityFocused() {
        return Api21Impl.isAccessibilityFocused((AccessibilityWindowInfo) this.mInfo);
    }

    public boolean isActive() {
        return Api21Impl.isActive((AccessibilityWindowInfo) this.mInfo);
    }

    public boolean isFocused() {
        return Api21Impl.isFocused((AccessibilityWindowInfo) this.mInfo);
    }

    public boolean isInPictureInPictureMode() {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return false;
    L5:
        return Api26Impl.isInPictureInPictureMode((AccessibilityWindowInfo) this.mInfo);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("AccessibilityWindowInfo[id=");
        Rect r101 = new Rect();
        getBoundsInScreen(r101);
        r100.append(getId());
        r100.append(", type=");
        r100.append(typeToString(getType()));
        r100.append(", layer=");
        r100.append(getLayer());
        r100.append(", bounds=");
        r100.append(r101);
        r100.append(", focused=");
        r100.append(isFocused());
        r100.append(", active=");
        r100.append(isActive());
        r100.append(", hasParent=");
        boolean r102 = true;
        if (getParent() == null) goto L5;
        boolean r103 = true;
    L6:
        r100.append(r103);
        r100.append(", hasChildren=");
        if (getChildCount() > 0) goto L10;
        r102 = false;
    L10:
        r100.append(r102);
        r100.append(", transitionTime=");
        r100.append(getTransitionTimeMillis());
        r100.append(", locales=");
        r100.append(getLocales());
        r100.append(']');
        return r100.toString();
    L5:
        r103 = false;
        goto L6
    }

    public AccessibilityWindowInfo unwrap() {
        return (AccessibilityWindowInfo) this.mInfo;
    }

    public AccessibilityWindowInfoCompat() {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        this.mInfo = Api30Impl.instantiateAccessibilityWindowInfo();
        return;
    L5:
        this.mInfo = null;
    }

    public static AccessibilityWindowInfoCompat obtain() {
        return wrapNonNullInstance(Api21Impl.obtain());
    }

    private AccessibilityWindowInfoCompat(Object r100) {
        this.mInfo = r100;
    }

    public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(Api21Impl.obtain((AccessibilityWindowInfo) r100.mInfo));
    }

    public static AccessibilityWindowInfoCompat wrapNonNullInstance(Object r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return new AccessibilityWindowInfoCompat(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if ((r100 instanceof AccessibilityWindowInfoCompat) == true) goto L11;
        return false;
    L11:
        AccessibilityWindowInfoCompat r101 = (AccessibilityWindowInfoCompat) r100;
        Object r102 = this.mInfo;
        if (r102 != null) goto L19;
        if (r101.mInfo == null) goto L20;
        return false;
    L20:
        return true;
    L19:
        return r102.equals(r101.mInfo);
    }

    public void getBoundsInScreen(Rect r100) {
        Api21Impl.getBoundsInScreen((AccessibilityWindowInfo) this.mInfo, r100);
    }

    public AccessibilityWindowInfoCompat getChild(int r100) {
        return wrapNonNullInstance(Api21Impl.getChild((AccessibilityWindowInfo) this.mInfo, r100));
    }

    public void getRegionInScreen(Region r100) {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        Api33Impl.getRegionInScreen((AccessibilityWindowInfo) this.mInfo, r100);
        return;
    L5:
        Rect r101 = new Rect();
        Api21Impl.getBoundsInScreen((AccessibilityWindowInfo) this.mInfo, r101);
        r100.set(r101);
    }

    public AccessibilityNodeInfoCompat getRoot(int r100) {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return Api33Impl.getRoot(this.mInfo, r100);
    L7:
        return getRoot();
    }
}
