package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGroupCompat {
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    static class Api18Impl {
        private Api18Impl() {
        }

        static int getLayoutMode(ViewGroup r0) {
            return r0.getLayoutMode();
        }

        static void setLayoutMode(ViewGroup r0, int r1) {
            r0.setLayoutMode(r1);
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static void setTransitionGroup(ViewGroup r0, boolean r1) {
            r0.setTransitionGroup(r1);
        }

        static boolean isTransitionGroup(ViewGroup r0) {
            return r0.isTransitionGroup();
        }

        static int getNestedScrollAxes(ViewGroup r0) {
            return r0.getNestedScrollAxes();
        }
    }

    private ViewGroupCompat() {
    }

    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup r0, View r1, AccessibilityEvent r2) {
        return r0.onRequestSendAccessibilityEvent(r1, r2);
    }

    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup r0, boolean r1) {
        r0.setMotionEventSplittingEnabled(r1);
    }

    public static int getLayoutMode(ViewGroup r0) {
        return Api18Impl.getLayoutMode(r0);
    }

    public static void setLayoutMode(ViewGroup r0, int r1) {
        Api18Impl.setLayoutMode(r0, r1);
    }

    public static void setTransitionGroup(ViewGroup r0, boolean r1) {
        Api21Impl.setTransitionGroup(r0, r1);
    }

    public static boolean isTransitionGroup(ViewGroup r0) {
        return Api21Impl.isTransitionGroup(r0);
    }

    public static int getNestedScrollAxes(ViewGroup r0) {
        return Api21Impl.getNestedScrollAxes(r0);
    }
}
