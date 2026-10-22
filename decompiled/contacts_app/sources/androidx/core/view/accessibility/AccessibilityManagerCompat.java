package androidx.core.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityManagerCompat {

    @Deprecated
    public interface AccessibilityStateChangeListener {
        @Deprecated
        void onAccessibilityStateChanged(boolean r1);
    }

    @Deprecated
    public static abstract class AccessibilityStateChangeListenerCompat implements AccessibilityStateChangeListener {
        public AccessibilityStateChangeListenerCompat() {
        }
    }

    private static class AccessibilityStateChangeListenerWrapper implements AccessibilityManager.AccessibilityStateChangeListener {
        AccessibilityStateChangeListener mListener;

        AccessibilityStateChangeListenerWrapper(AccessibilityStateChangeListener r1) {
            this.mListener = r1;
        }

        public int hashCode() {
            return this.mListener.hashCode();
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L6;
            return true;
        L6:
            if ((r2 instanceof AccessibilityStateChangeListenerWrapper) == true) goto L10;
            return false;
        L10:
            return this.mListener.equals(((AccessibilityStateChangeListenerWrapper) r2).mListener);
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean r1) {
            this.mListener.onAccessibilityStateChanged(r1);
        }
    }

    static class Api19Impl {
        private Api19Impl() {
        }

        static boolean addTouchExplorationStateChangeListenerWrapper(AccessibilityManager r1, TouchExplorationStateChangeListener r2) {
            return r1.addTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper(r2));
        }

        static boolean removeTouchExplorationStateChangeListenerWrapper(AccessibilityManager r1, TouchExplorationStateChangeListener r2) {
            return r1.removeTouchExplorationStateChangeListener(new TouchExplorationStateChangeListenerWrapper(r2));
        }
    }

    public interface TouchExplorationStateChangeListener {
        void onTouchExplorationStateChanged(boolean r1);
    }

    private static final class TouchExplorationStateChangeListenerWrapper implements AccessibilityManager.TouchExplorationStateChangeListener {
        final TouchExplorationStateChangeListener mListener;

        TouchExplorationStateChangeListenerWrapper(TouchExplorationStateChangeListener r1) {
            this.mListener = r1;
        }

        public int hashCode() {
            return this.mListener.hashCode();
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L6;
            return true;
        L6:
            if ((r2 instanceof TouchExplorationStateChangeListenerWrapper) == true) goto L10;
            return false;
        L10:
            return this.mListener.equals(((TouchExplorationStateChangeListenerWrapper) r2).mListener);
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean r1) {
            this.mListener.onTouchExplorationStateChanged(r1);
        }
    }

    @Deprecated
    public static boolean addAccessibilityStateChangeListener(AccessibilityManager r1, AccessibilityStateChangeListener r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        return r1.addAccessibilityStateChangeListener(new AccessibilityStateChangeListenerWrapper(r2));
    }

    @Deprecated
    public static boolean removeAccessibilityStateChangeListener(AccessibilityManager r1, AccessibilityStateChangeListener r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        return r1.removeAccessibilityStateChangeListener(new AccessibilityStateChangeListenerWrapper(r2));
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager r0) {
        return r0.getInstalledAccessibilityServiceList();
    }

    @Deprecated
    public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager r0, int r1) {
        return r0.getEnabledAccessibilityServiceList(r1);
    }

    @Deprecated
    public static boolean isTouchExplorationEnabled(AccessibilityManager r0) {
        return r0.isTouchExplorationEnabled();
    }

    public static boolean addTouchExplorationStateChangeListener(AccessibilityManager r0, TouchExplorationStateChangeListener r1) {
        return Api19Impl.addTouchExplorationStateChangeListenerWrapper(r0, r1);
    }

    public static boolean removeTouchExplorationStateChangeListener(AccessibilityManager r0, TouchExplorationStateChangeListener r1) {
        return Api19Impl.removeTouchExplorationStateChangeListenerWrapper(r0, r1);
    }

    private AccessibilityManagerCompat() {
    }
}
