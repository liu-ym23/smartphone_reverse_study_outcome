package androidx.core.view.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.ReplaceWith;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes17.dex */
public final class AccessibilityEventCompat {
    public static final int CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION = 4;
    public static final int CONTENT_CHANGE_TYPE_CONTENT_INVALID = 1024;
    public static final int CONTENT_CHANGE_TYPE_DRAG_CANCELLED = 512;
    public static final int CONTENT_CHANGE_TYPE_DRAG_DROPPED = 256;
    public static final int CONTENT_CHANGE_TYPE_DRAG_STARTED = 128;
    public static final int CONTENT_CHANGE_TYPE_ENABLED = 4096;
    public static final int CONTENT_CHANGE_TYPE_ERROR = 2048;
    public static final int CONTENT_CHANGE_TYPE_PANE_APPEARED = 16;
    public static final int CONTENT_CHANGE_TYPE_PANE_DISAPPEARED = 32;
    public static final int CONTENT_CHANGE_TYPE_PANE_TITLE = 8;
    public static final int CONTENT_CHANGE_TYPE_STATE_DESCRIPTION = 64;
    public static final int CONTENT_CHANGE_TYPE_SUBTREE = 1;
    public static final int CONTENT_CHANGE_TYPE_TEXT = 2;
    public static final int CONTENT_CHANGE_TYPE_UNDEFINED = 0;
    public static final int TYPES_ALL_MASK = -1;
    public static final int TYPE_ANNOUNCEMENT = 16384;
    public static final int TYPE_ASSIST_READING_CONTEXT = 16777216;
    public static final int TYPE_GESTURE_DETECTION_END = 524288;
    public static final int TYPE_GESTURE_DETECTION_START = 262144;
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 1024;
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 512;
    public static final int TYPE_TOUCH_INTERACTION_END = 2097152;
    public static final int TYPE_TOUCH_INTERACTION_START = 1048576;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 32768;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 65536;
    public static final int TYPE_VIEW_CONTEXT_CLICKED = 8388608;
    public static final int TYPE_VIEW_HOVER_ENTER = 128;
    public static final int TYPE_VIEW_HOVER_EXIT = 256;
    public static final int TYPE_VIEW_SCROLLED = 4096;
    public static final int TYPE_VIEW_TARGETED_BY_SCROLL = 67108864;
    public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 8192;
    public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 131072;
    public static final int TYPE_WINDOWS_CHANGED = 4194304;
    public static final int TYPE_WINDOW_CONTENT_CHANGED = 2048;

    public static class Api34Impl {
        private Api34Impl() {
        }

        public static boolean isAccessibilityDataSensitive(AccessibilityEvent r100) {
            return r100.isAccessibilityDataSensitive();
        }

        public static void setAccessibilityDataSensitive(AccessibilityEvent r100, boolean r101) {
            r100.setAccessibilityDataSensitive(r101);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ContentChangeType {
    }

    private AccessibilityEventCompat() {
    }

    public static AccessibilityRecordCompat asRecord(AccessibilityEvent r100) {
        return new AccessibilityRecordCompat(r100);
    }

    @ReplaceWith(expression = "event.getAction()")
    public static int getAction(AccessibilityEvent r100) {
        return r100.getAction();
    }

    @ReplaceWith(expression = "event.getContentChangeTypes()")
    public static int getContentChangeTypes(AccessibilityEvent r100) {
        return r100.getContentChangeTypes();
    }

    @ReplaceWith(expression = "event.getMovementGranularity()")
    public static int getMovementGranularity(AccessibilityEvent r100) {
        return r100.getMovementGranularity();
    }

    @ReplaceWith(expression = "event.getRecordCount()")
    public static int getRecordCount(AccessibilityEvent r100) {
        return r100.getRecordCount();
    }

    public static boolean isAccessibilityDataSensitive(AccessibilityEvent r100) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return false;
    L5:
        return Api34Impl.isAccessibilityDataSensitive(r100);
    }

    @ReplaceWith(expression = "event.appendRecord(record)")
    public static void appendRecord(AccessibilityEvent r100, AccessibilityRecordCompat r101) {
        r100.appendRecord((AccessibilityRecord) r101.getImpl());
    }

    public static AccessibilityRecordCompat getRecord(AccessibilityEvent r100, int r101) {
        return new AccessibilityRecordCompat(r100.getRecord(r101));
    }

    public static void setAccessibilityDataSensitive(AccessibilityEvent r100, boolean r101) {
        if (Build.VERSION.SDK_INT < 34) goto L6;
        Api34Impl.setAccessibilityDataSensitive(r100, r101);
        return;
    }

    @ReplaceWith(expression = "event.setAction(action)")
    public static void setAction(AccessibilityEvent r100, int r101) {
        r100.setAction(r101);
    }

    @ReplaceWith(expression = "event.setContentChangeTypes(changeTypes)")
    public static void setContentChangeTypes(AccessibilityEvent r100, int r101) {
        r100.setContentChangeTypes(r101);
    }

    @ReplaceWith(expression = "event.setMovementGranularity(granularity)")
    public static void setMovementGranularity(AccessibilityEvent r100, int r101) {
        r100.setMovementGranularity(r101);
    }
}
