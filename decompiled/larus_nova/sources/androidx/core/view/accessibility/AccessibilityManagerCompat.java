package androidx.core.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.ReplaceWith;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public final class AccessibilityManagerCompat {

    public interface AccessibilityStateChangeListener {
        void onAccessibilityStateChanged(boolean r100);
    }

    public static abstract class AccessibilityStateChangeListenerCompat implements AccessibilityStateChangeListener {
        public AccessibilityStateChangeListenerCompat() {
        }
    }

    public static class AccessibilityStateChangeListenerWrapper implements AccessibilityManager.AccessibilityStateChangeListener {
        AccessibilityStateChangeListener mListener;

        public int hashCode() {
            return this.mListener.hashCode();
        }

        public AccessibilityStateChangeListenerWrapper(AccessibilityStateChangeListener r100) {
            this.mListener = r100;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof AccessibilityStateChangeListenerWrapper) == true) goto L10;
            return false;
        L10:
            return this.mListener.equals(((AccessibilityStateChangeListenerWrapper) r100).mListener);
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean r100) {
            this.mListener.onAccessibilityStateChanged(r100);
        }
    }

    public static class Api34Impl {
        private Api34Impl() {
        }

        public static boolean isRequestFromAccessibilityTool(AccessibilityManager r100) {
            return r100.isRequestFromAccessibilityTool();
        }
    }

    public interface TouchExplorationStateChangeListener {
        void onTouchExplorationStateChanged(boolean r100);
    }

    public static final class TouchExplorationStateChangeListenerWrapper implements AccessibilityManager.TouchExplorationStateChangeListener {
        final TouchExplorationStateChangeListener mListener;

        public int hashCode() {
            return this.mListener.hashCode();
        }

        public TouchExplorationStateChangeListenerWrapper(TouchExplorationStateChangeListener r100) {
            this.mListener = r100;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof TouchExplorationStateChangeListenerWrapper) == true) goto L10;
            return false;
        L10:
            return this.mListener.equals(((TouchExplorationStateChangeListenerWrapper) r100).mListener);
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean r100) {
            this.mListener.onTouchExplorationStateChanged(r100);
        }
    }

    private AccessibilityManagerCompat() {
    }

    @ReplaceWith(expression = "manager.getInstalledAccessibilityServiceList()")
    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager r100) {
        return r100.getInstalledAccessibilityServiceList();
    }

    public static boolean isRequestFromAccessibilityTool(AccessibilityManager r100) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return true;
    L5:
        return Api34Impl.isRequestFromAccessibilityTool(r100);
    }

    @ReplaceWith(expression = "manager.isTouchExplorationEnabled()")
    public static boolean isTouchExplorationEnabled(AccessibilityManager r100) {
        return r100.isTouchExplorationEnabled();
    }

    public static boolean addAccessibilityStateChangeListener(AccessibilityManager r100, AccessibilityStateChangeListener r101) {
        if (r101 != null) goto L6;
        return false;
    L6:
        return r100.addAccessibilityStateChangeListener(new AccessibilityStateChangeListenerWrapper(r101));
    }

    @ReplaceWith(expression = "manager.addTouchExplorationStateChangeListener(listener)")
    public static boolean addTouchExplorationStateChangeListener(AccessibilityManager r100, TouchExplorationStateChangeListener r101) {
        return r100.addTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper(r101));
    }

    @ReplaceWith(expression = "manager.getEnabledAccessibilityServiceList(feedbackTypeFlags)")
    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager r100, int r101) {
        return r100.getEnabledAccessibilityServiceList(r101);
    }

    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager r100, AccessibilityStateChangeListener r101) {
        if (r101 != null) goto L6;
        return false;
    L6:
        return r100.removeAccessibilityStateChangeListener(new AccessibilityStateChangeListenerWrapper(r101));
    }

    @ReplaceWith(expression = "manager.removeTouchExplorationStateChangeListener(listener)")
    public static boolean removeTouchExplorationStateChangeListener(AccessibilityManager r100, TouchExplorationStateChangeListener r101) {
        return r100.removeTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper(r101));
    }
}
