package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ReplaceWith;

/* JADX INFO: loaded from: classes17.dex */
public final class ViewGroupCompat {
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static int getNestedScrollAxes(ViewGroup r100) {
            return r100.getNestedScrollAxes();
        }

        public static boolean isTransitionGroup(ViewGroup r100) {
            return r100.isTransitionGroup();
        }

        public static void setTransitionGroup(ViewGroup r100, boolean r101) {
            r100.setTransitionGroup(r101);
        }
    }

    private ViewGroupCompat() {
    }

    @ReplaceWith(expression = "group.getLayoutMode()")
    public static int getLayoutMode(ViewGroup r100) {
        return r100.getLayoutMode();
    }

    public static int getNestedScrollAxes(ViewGroup r100) {
        return Api21Impl.getNestedScrollAxes(r100);
    }

    public static boolean isTransitionGroup(ViewGroup r100) {
        return Api21Impl.isTransitionGroup(r100);
    }

    @ReplaceWith(expression = "group.setLayoutMode(mode)")
    public static void setLayoutMode(ViewGroup r100, int r101) {
        r100.setLayoutMode(r101);
    }

    @ReplaceWith(expression = "group.setMotionEventSplittingEnabled(split)")
    public static void setMotionEventSplittingEnabled(ViewGroup r100, boolean r101) {
        r100.setMotionEventSplittingEnabled(r101);
    }

    public static void setTransitionGroup(ViewGroup r100, boolean r101) {
        Api21Impl.setTransitionGroup(r100, r101);
    }

    @ReplaceWith(expression = "group.onRequestSendAccessibilityEvent(child, event)")
    public static boolean onRequestSendAccessibilityEvent(ViewGroup r100, View r101, AccessibilityEvent r102) {
        return r100.onRequestSendAccessibilityEvent(r101, r102);
    }
}
