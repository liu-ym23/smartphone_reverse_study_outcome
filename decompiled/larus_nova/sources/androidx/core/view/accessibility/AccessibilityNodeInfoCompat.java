package androidx.core.view.accessibility;

import android.R;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes17.dex */
public class AccessibilityNodeInfoCompat {
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
    public static final String ACTION_ARGUMENT_DIRECTION_INT = "androidx.core.view.accessibility.action.ARGUMENT_DIRECTION_INT";
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_X = "ACTION_ARGUMENT_MOVE_WINDOW_X";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_Y = "ACTION_ARGUMENT_MOVE_WINDOW_Y";
    public static final String ACTION_ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT = "android.view.accessibility.action.ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT";
    public static final String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
    public static final String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
    public static final String ACTION_ARGUMENT_SCROLL_AMOUNT_FLOAT = "androidx.core.view.accessibility.action.ARGUMENT_SCROLL_AMOUNT_FLOAT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 524288;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_DISMISS = 1048576;
    public static final int ACTION_EXPAND = 262144;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int ACTION_SET_TEXT = 2097152;
    private static final int BOOLEAN_PROPERTY_ACCESSIBILITY_DATA_SENSITIVE = 64;
    private static final int BOOLEAN_PROPERTY_HAS_REQUEST_INITIAL_ACCESSIBILITY_FOCUS = 32;
    private static final int BOOLEAN_PROPERTY_IS_HEADING = 2;
    private static final int BOOLEAN_PROPERTY_IS_SHOWING_HINT = 4;
    private static final int BOOLEAN_PROPERTY_IS_TEXT_ENTRY_KEY = 8;
    private static final String BOOLEAN_PROPERTY_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
    private static final int BOOLEAN_PROPERTY_SCREEN_READER_FOCUSABLE = 1;
    private static final int BOOLEAN_PROPERTY_SUPPORTS_GRANULAR_SCROLLING = 67108864;
    private static final int BOOLEAN_PROPERTY_TEXT_SELECTABLE = 8388608;
    private static final String BOUNDS_IN_WINDOW_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY";
    private static final String CONTAINER_TITLE_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY";
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH = "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH";
    public static final int EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH = 20000;
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX = "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX";
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY = "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY";
    public static final int FLAG_PREFETCH_ANCESTORS = 1;
    public static final int FLAG_PREFETCH_DESCENDANTS_BREADTH_FIRST = 16;
    public static final int FLAG_PREFETCH_DESCENDANTS_DEPTH_FIRST = 8;
    public static final int FLAG_PREFETCH_DESCENDANTS_HYBRID = 4;
    public static final int FLAG_PREFETCH_SIBLINGS = 2;
    public static final int FLAG_PREFETCH_UNINTERRUPTIBLE = 32;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    private static final String HINT_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY";
    public static final int MAX_NUMBER_OF_PREFETCHED_NODES = 50;
    private static final String MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY";
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    private static final String PANE_TITLE_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY";
    private static final String ROLE_DESCRIPTION_KEY = "AccessibilityNodeInfo.roleDescription";
    private static final String SPANS_ACTION_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY";
    private static final String SPANS_END_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY";
    private static final String SPANS_FLAGS_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY";
    private static final String SPANS_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY";
    private static final String SPANS_START_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY";
    private static final String STATE_DESCRIPTION_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY";
    private static final String TOOLTIP_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY";
    private static final String UNIQUE_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY";
    private static int sClickableSpanId;
    private final AccessibilityNodeInfo mInfo;
    public int mParentVirtualDescendantId;
    private int mVirtualDescendantId;

    public static class AccessibilityActionCompat {
        public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS = null;
        public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS = null;
        public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS = null;
        public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION = null;
        public static final AccessibilityActionCompat ACTION_CLICK = null;
        public static final AccessibilityActionCompat ACTION_COLLAPSE = null;
        public static final AccessibilityActionCompat ACTION_CONTEXT_CLICK = null;
        public static final AccessibilityActionCompat ACTION_COPY = null;
        public static final AccessibilityActionCompat ACTION_CUT = null;
        public static final AccessibilityActionCompat ACTION_DISMISS = null;
        public static final AccessibilityActionCompat ACTION_DRAG_CANCEL = null;
        public static final AccessibilityActionCompat ACTION_DRAG_DROP = null;
        public static final AccessibilityActionCompat ACTION_DRAG_START = null;
        public static final AccessibilityActionCompat ACTION_EXPAND = null;
        public static final AccessibilityActionCompat ACTION_FOCUS = null;
        public static final AccessibilityActionCompat ACTION_HIDE_TOOLTIP = null;
        public static final AccessibilityActionCompat ACTION_IME_ENTER = null;
        public static final AccessibilityActionCompat ACTION_LONG_CLICK = null;
        public static final AccessibilityActionCompat ACTION_MOVE_WINDOW = null;
        public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY = null;
        public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT = null;
        public static final AccessibilityActionCompat ACTION_PAGE_DOWN = null;
        public static final AccessibilityActionCompat ACTION_PAGE_LEFT = null;
        public static final AccessibilityActionCompat ACTION_PAGE_RIGHT = null;
        public static final AccessibilityActionCompat ACTION_PAGE_UP = null;
        public static final AccessibilityActionCompat ACTION_PASTE = null;
        public static final AccessibilityActionCompat ACTION_PRESS_AND_HOLD = null;
        public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = null;
        public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_DOWN = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_IN_DIRECTION = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_LEFT = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_RIGHT = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_TO_POSITION = null;
        public static final AccessibilityActionCompat ACTION_SCROLL_UP = null;
        public static final AccessibilityActionCompat ACTION_SELECT = null;
        public static final AccessibilityActionCompat ACTION_SET_PROGRESS = null;
        public static final AccessibilityActionCompat ACTION_SET_SELECTION = null;
        public static final AccessibilityActionCompat ACTION_SET_TEXT = null;
        public static final AccessibilityActionCompat ACTION_SHOW_ON_SCREEN = null;
        public static final AccessibilityActionCompat ACTION_SHOW_TEXT_SUGGESTIONS = null;
        public static final AccessibilityActionCompat ACTION_SHOW_TOOLTIP = null;
        private static final String TAG = "A11yActionCompat";
        final Object mAction;
        protected final AccessibilityViewCommand mCommand;
        private final int mId;
        private final Class<? extends AccessibilityViewCommand.CommandArguments> mViewCommandArgumentClass;

        static {
            AccessibilityNodeInfo.AccessibilityAction r100 = null;
            ACTION_FOCUS = new AccessibilityActionCompat(1, null);
            ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, null);
            ACTION_SELECT = new AccessibilityActionCompat(4, null);
            ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, null);
            ACTION_CLICK = new AccessibilityActionCompat(16, null);
            ACTION_LONG_CLICK = new AccessibilityActionCompat(32, null);
            ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, null);
            ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128, null);
            ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256, null, AccessibilityViewCommand.MoveAtGranularityArguments.class);
            ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512, null, AccessibilityViewCommand.MoveAtGranularityArguments.class);
            ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024, null, AccessibilityViewCommand.MoveHtmlArguments.class);
            ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048, null, AccessibilityViewCommand.MoveHtmlArguments.class);
            ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, null);
            ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192, null);
            ACTION_COPY = new AccessibilityActionCompat(16384, null);
            ACTION_PASTE = new AccessibilityActionCompat(32768, null);
            ACTION_CUT = new AccessibilityActionCompat(65536, null);
            ACTION_SET_SELECTION = new AccessibilityActionCompat(131072, null, AccessibilityViewCommand.SetSelectionArguments.class);
            ACTION_EXPAND = new AccessibilityActionCompat(262144, null);
            ACTION_COLLAPSE = new AccessibilityActionCompat(524288, null);
            ACTION_DISMISS = new AccessibilityActionCompat(1048576, null);
            ACTION_SET_TEXT = new AccessibilityActionCompat(2097152, null, AccessibilityViewCommand.SetTextArguments.class);
            int r101 = Build.VERSION.SDK_INT;
            if (r101 < 23) goto L5;
            AccessibilityNodeInfo.AccessibilityAction r102 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
        L6:
            ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(r102, R.id.accessibilityActionShowOnScreen, null, null, null);
            if (r101 < 23) goto L9;
            AccessibilityNodeInfo.AccessibilityAction r110 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
        L10:
            ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(r110, R.id.accessibilityActionScrollToPosition, null, null, AccessibilityViewCommand.ScrollToPositionArguments.class);
            if (r101 < 23) goto L13;
            AccessibilityNodeInfo.AccessibilityAction r103 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
        L14:
            ACTION_SCROLL_UP = new AccessibilityActionCompat(r103, R.id.accessibilityActionScrollUp, null, null, null);
            if (r101 < 23) goto L17;
            AccessibilityNodeInfo.AccessibilityAction r111 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
        L18:
            ACTION_SCROLL_LEFT = new AccessibilityActionCompat(r111, R.id.accessibilityActionScrollLeft, null, null, null);
            if (r101 < 23) goto L21;
            AccessibilityNodeInfo.AccessibilityAction r104 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
        L22:
            ACTION_SCROLL_DOWN = new AccessibilityActionCompat(r104, R.id.accessibilityActionScrollDown, null, null, null);
            if (r101 < 23) goto L25;
            AccessibilityNodeInfo.AccessibilityAction r112 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
        L26:
            ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(r112, R.id.accessibilityActionScrollRight, null, null, null);
            if (r101 < 29) goto L29;
            AccessibilityNodeInfo.AccessibilityAction r105 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
        L30:
            ACTION_PAGE_UP = new AccessibilityActionCompat(r105, R.id.accessibilityActionPageUp, null, null, null);
            if (r101 < 29) goto L33;
            AccessibilityNodeInfo.AccessibilityAction r113 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
        L34:
            ACTION_PAGE_DOWN = new AccessibilityActionCompat(r113, R.id.accessibilityActionPageDown, null, null, null);
            if (r101 < 29) goto L37;
            AccessibilityNodeInfo.AccessibilityAction r106 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
        L38:
            ACTION_PAGE_LEFT = new AccessibilityActionCompat(r106, R.id.accessibilityActionPageLeft, null, null, null);
            if (r101 < 29) goto L41;
            AccessibilityNodeInfo.AccessibilityAction r114 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
        L42:
            ACTION_PAGE_RIGHT = new AccessibilityActionCompat(r114, R.id.accessibilityActionPageRight, null, null, null);
            if (r101 < 23) goto L45;
            AccessibilityNodeInfo.AccessibilityAction r107 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
        L46:
            ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(r107, R.id.accessibilityActionContextClick, null, null, null);
            if (r101 < 24) goto L49;
            AccessibilityNodeInfo.AccessibilityAction r115 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
        L50:
            ACTION_SET_PROGRESS = new AccessibilityActionCompat(r115, R.id.accessibilityActionSetProgress, null, null, AccessibilityViewCommand.SetProgressArguments.class);
            if (r101 < 26) goto L53;
            AccessibilityNodeInfo.AccessibilityAction r108 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
        L54:
            ACTION_MOVE_WINDOW = new AccessibilityActionCompat(r108, R.id.accessibilityActionMoveWindow, null, null, AccessibilityViewCommand.MoveWindowArguments.class);
            if (r101 < 28) goto L57;
            AccessibilityNodeInfo.AccessibilityAction r116 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
        L58:
            ACTION_SHOW_TOOLTIP = new AccessibilityActionCompat(r116, R.id.accessibilityActionShowTooltip, null, null, null);
            if (r101 < 28) goto L61;
            AccessibilityNodeInfo.AccessibilityAction r109 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
        L62:
            ACTION_HIDE_TOOLTIP = new AccessibilityActionCompat(r109, R.id.accessibilityActionHideTooltip, null, null, null);
            if (r101 < 30) goto L65;
            AccessibilityNodeInfo.AccessibilityAction r117 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
        L66:
            ACTION_PRESS_AND_HOLD = new AccessibilityActionCompat(r117, R.id.accessibilityActionPressAndHold, null, null, null);
            if (r101 < 30) goto L69;
            AccessibilityNodeInfo.AccessibilityAction r118 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
        L70:
            ACTION_IME_ENTER = new AccessibilityActionCompat(r118, R.id.accessibilityActionImeEnter, null, null, null);
            if (r101 < 32) goto L73;
            AccessibilityNodeInfo.AccessibilityAction r119 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START;
        L74:
            ACTION_DRAG_START = new AccessibilityActionCompat(r119, R.id.accessibilityActionDragStart, null, null, null);
            if (r101 < 32) goto L77;
            AccessibilityNodeInfo.AccessibilityAction r120 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
        L78:
            ACTION_DRAG_DROP = new AccessibilityActionCompat(r120, R.id.accessibilityActionDragDrop, null, null, null);
            if (r101 < 32) goto L81;
            AccessibilityNodeInfo.AccessibilityAction r121 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
        L82:
            ACTION_DRAG_CANCEL = new AccessibilityActionCompat(r121, R.id.accessibilityActionDragCancel, null, null, null);
            if (r101 < 33) goto L85;
            AccessibilityNodeInfo.AccessibilityAction r122 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
        L86:
            ACTION_SHOW_TEXT_SUGGESTIONS = new AccessibilityActionCompat(r122, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            if (r101 < 34) goto L89;
            r100 = Api34Impl.getActionScrollInDirection();
        L89:
            ACTION_SCROLL_IN_DIRECTION = new AccessibilityActionCompat(r100, R.id.accessibilityActionScrollInDirection, null, null, null);
            return;
        L85:
            r122 = null;
            goto L86
        L81:
            r121 = null;
            goto L82
        L77:
            r120 = null;
            goto L78
        L73:
            r119 = null;
            goto L74
        L69:
            r118 = null;
            goto L70
        L65:
            r117 = null;
            goto L66
        L61:
            r109 = null;
            goto L62
        L57:
            r116 = null;
            goto L58
        L53:
            r108 = null;
            goto L54
        L49:
            r115 = null;
            goto L50
        L45:
            r107 = null;
            goto L46
        L41:
            r114 = null;
            goto L42
        L37:
            r106 = null;
            goto L38
        L33:
            r113 = null;
            goto L34
        L29:
            r105 = null;
            goto L30
        L25:
            r112 = null;
            goto L26
        L21:
            r104 = null;
            goto L22
        L17:
            r111 = null;
            goto L18
        L13:
            r103 = null;
            goto L14
        L9:
            r110 = null;
            goto L10
        L5:
            r102 = null;
            goto L6
        }

        public int getId() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.mAction).getId();
        }

        public CharSequence getLabel() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.mAction).getLabel();
        }

        public int hashCode() {
            Object r100 = this.mAction;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public String toString() {
            StringBuilder r100 = new StringBuilder("AccessibilityActionCompat: ");
            String r101 = AccessibilityNodeInfoCompat.getActionSymbolicName(this.mId);
            if (r101.equals("ACTION_UNKNOWN") == true) goto L5;
        L7:
            r100.append(r101);
            return r100.toString();
        L5:
            if (getLabel() == null) goto L7;
            r101 = getLabel().toString();
            goto L7
        }

        public AccessibilityActionCompat(Object r100) {
            this(r100, 0, null, null, null);
        }

        public boolean equals(Object r100) {
            if (r100 != null) goto L6;
            return false;
        L6:
            if ((r100 instanceof AccessibilityActionCompat) == true) goto L8;
            return false;
        L8:
            AccessibilityActionCompat r101 = (AccessibilityActionCompat) r100;
            Object r102 = this.mAction;
            if (r102 != null) goto L14;
            if (r101.mAction == null) goto L16;
            return false;
        L16:
            return true;
        L14:
            if (r102.equals(r101.mAction) == true) goto L18;
            return false;
        L18:
            return true;
        }

        public AccessibilityActionCompat(int r100, CharSequence r101) {
            this(null, r100, r101, null, null);
        }

        public AccessibilityActionCompat createReplacementAction(CharSequence r100, AccessibilityViewCommand r101) {
            return new AccessibilityActionCompat(null, this.mId, r100, r101, this.mViewCommandArgumentClass);
        }

        public boolean perform(View r100, Bundle r101) {
            if (this.mCommand == null) goto L18;
            Class<? extends AccessibilityViewCommand.CommandArguments> r102 = this.mViewCommandArgumentClass;
            AccessibilityViewCommand.CommandArguments r103 = null;
            if (r102 == null) goto L17;
            AccessibilityViewCommand.CommandArguments r104 = r102.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L10
            r104.setBundle(r101);     // Catch: Exception -> L9
            r103 = r104;
        L9:
            r103 = r104;
        L11:
            Class<? extends AccessibilityViewCommand.CommandArguments> r105 = this.mViewCommandArgumentClass;
            if (r105 == null) goto L17;
            r105.getName();
        L17:
            return this.mCommand.perform(r100, r103);
        L18:
            return false;
        }

        public AccessibilityActionCompat(int r100, CharSequence r101, AccessibilityViewCommand r102) {
            this(null, r100, r101, r102, null);
        }

        private AccessibilityActionCompat(int r100, CharSequence r101, Class<? extends AccessibilityViewCommand.CommandArguments> r102) {
            this(null, r100, r101, null, r102);
        }

        public AccessibilityActionCompat(Object r100, int r101, CharSequence r102, AccessibilityViewCommand r103, Class<? extends AccessibilityViewCommand.CommandArguments> r104) {
            this.mId = r101;
            this.mCommand = r103;
            if (r100 != null) goto L5;
            this.mAction = new AccessibilityNodeInfo.AccessibilityAction(r101, r102);
        L6:
            this.mViewCommandArgumentClass = r104;
            return;
        L5:
            this.mAction = r100;
            goto L6
        }
    }

    public static class Api30Impl {
        private Api30Impl() {
        }

        public static CharSequence getStateDescription(AccessibilityNodeInfo r100) {
            return r100.getStateDescription();
        }

        public static void setStateDescription(AccessibilityNodeInfo r100, CharSequence r101) {
            r100.setStateDescription(r101);
        }

        public static Object createRangeInfo(int r100, float r101, float r102, float r103) {
            return new AccessibilityNodeInfo.RangeInfo(r100, r101, r102, r103);
        }
    }

    public static class Api33Impl {
        private Api33Impl() {
        }

        public static String getCollectionItemColumnTitle(Object r100) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) r100).getColumnTitle();
        }

        public static String getCollectionItemRowTitle(Object r100) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) r100).getRowTitle();
        }

        public static AccessibilityNodeInfo.ExtraRenderingInfo getExtraRenderingInfo(AccessibilityNodeInfo r100) {
            return r100.getExtraRenderingInfo();
        }

        public static String getUniqueId(AccessibilityNodeInfo r100) {
            return r100.getUniqueId();
        }

        public static boolean isTextSelectable(AccessibilityNodeInfo r100) {
            return r100.isTextSelectable();
        }

        public static AccessibilityNodeInfoCompat getParent(AccessibilityNodeInfo r100, int r101) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(r100.getParent(r101));
        }

        public static void setTextSelectable(AccessibilityNodeInfo r100, boolean r101) {
            r100.setTextSelectable(r101);
        }

        public static void setUniqueId(AccessibilityNodeInfo r100, String r101) {
            r100.setUniqueId(r101);
        }

        public static AccessibilityNodeInfoCompat getChild(AccessibilityNodeInfo r100, int r101, int r102) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(r100.getChild(r101, r102));
        }

        public static CollectionItemInfoCompat buildCollectionItemInfoCompat(boolean r100, int r101, int r102, int r103, int r104, boolean r105, String r106, String r107) {
            return new CollectionItemInfoCompat(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(r100).setColumnIndex(r101).setRowIndex(r102).setColumnSpan(r103).setRowSpan(r104).setSelected(r105).setRowTitle(r106).setColumnTitle(r107).build());
        }
    }

    public static class Api34Impl {
        private Api34Impl() {
        }

        public static AccessibilityNodeInfo.AccessibilityAction getActionScrollInDirection() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        public static CharSequence getContainerTitle(AccessibilityNodeInfo r100) {
            return r100.getContainerTitle();
        }

        public static long getMinDurationBetweenContentChangeMillis(AccessibilityNodeInfo r100) {
            return r100.getMinDurationBetweenContentChanges().toMillis();
        }

        public static boolean hasRequestInitialAccessibilityFocus(AccessibilityNodeInfo r100) {
            return r100.hasRequestInitialAccessibilityFocus();
        }

        public static boolean isAccessibilityDataSensitive(AccessibilityNodeInfo r100) {
            return r100.isAccessibilityDataSensitive();
        }

        public static void getBoundsInWindow(AccessibilityNodeInfo r100, Rect r101) {
            r100.getBoundsInWindow(r101);
        }

        public static void setAccessibilityDataSensitive(AccessibilityNodeInfo r100, boolean r101) {
            r100.setAccessibilityDataSensitive(r101);
        }

        public static void setBoundsInWindow(AccessibilityNodeInfo r100, Rect r101) {
            r100.setBoundsInWindow(r101);
        }

        public static void setContainerTitle(AccessibilityNodeInfo r100, CharSequence r101) {
            r100.setContainerTitle(r101);
        }

        public static void setMinDurationBetweenContentChangeMillis(AccessibilityNodeInfo r100, long r101) {
            r100.setMinDurationBetweenContentChanges(Duration.ofMillis(r101));
        }

        public static void setRequestInitialAccessibilityFocus(AccessibilityNodeInfo r100, boolean r101) {
            r100.setRequestInitialAccessibilityFocus(r101);
        }

        public static void setQueryFromAppProcessEnabled(AccessibilityNodeInfo r100, View r101, boolean r102) {
            r100.setQueryFromAppProcessEnabled(r101, r102);
        }
    }

    public static class Api35Impl {
        private Api35Impl() {
        }

        public static int getImportantForAccessibilityItemCount(Object r100) {
            return ((AccessibilityNodeInfo.CollectionInfo) r100).getImportantForAccessibilityItemCount();
        }

        public static int getItemCount(Object r100) {
            return ((AccessibilityNodeInfo.CollectionInfo) r100).getItemCount();
        }

        public static CollectionInfoCompat buildCollectionInfoCompat(int r100, int r101, boolean r102, int r103, int r104, int r105) {
            return new CollectionInfoCompat.Builder().setRowCount(r100).setColumnCount(r101).setHierarchical(r102).setSelectionMode(r103).setItemCount(r104).setImportantForAccessibilityItemCount(r105).build();
        }
    }

    public static class CollectionInfoCompat {
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;
        public static final int UNDEFINED = -1;
        final Object mInfo;

        public static final class Builder {
            private int mColumnCount;
            private boolean mHierarchical;
            private int mImportantForAccessibilityItemCount;
            private int mItemCount;
            private int mRowCount;
            private int mSelectionMode;

            public CollectionInfoCompat build() {
                if (Build.VERSION.SDK_INT < 35) goto L7;
                return Api35Impl.buildCollectionInfoCompat(this.mRowCount, this.mColumnCount, this.mHierarchical, this.mSelectionMode, this.mItemCount, this.mImportantForAccessibilityItemCount);
            L7:
                return CollectionInfoCompat.obtain(this.mRowCount, this.mColumnCount, this.mHierarchical, this.mSelectionMode);
            }

            public Builder() {
                this.mRowCount = 0;
                this.mColumnCount = 0;
                this.mHierarchical = false;
                this.mItemCount = -1;
                this.mImportantForAccessibilityItemCount = -1;
            }

            public Builder setColumnCount(int r100) {
                this.mColumnCount = r100;
                return this;
            }

            public Builder setHierarchical(boolean r100) {
                this.mHierarchical = r100;
                return this;
            }

            public Builder setImportantForAccessibilityItemCount(int r100) {
                this.mImportantForAccessibilityItemCount = r100;
                return this;
            }

            public Builder setItemCount(int r100) {
                this.mItemCount = r100;
                return this;
            }

            public Builder setRowCount(int r100) {
                this.mRowCount = r100;
                return this;
            }

            public Builder setSelectionMode(int r100) {
                this.mSelectionMode = r100;
                return this;
            }
        }

        public int getColumnCount() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getColumnCount();
        }

        public int getImportantForAccessibilityItemCount() {
            if (Build.VERSION.SDK_INT >= 35) goto L5;
            return -1;
        L5:
            return Api35Impl.getImportantForAccessibilityItemCount(this.mInfo);
        }

        public int getItemCount() {
            if (Build.VERSION.SDK_INT >= 35) goto L5;
            return -1;
        L5:
            return Api35Impl.getItemCount(this.mInfo);
        }

        public int getRowCount() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getRowCount();
        }

        public int getSelectionMode() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).getSelectionMode();
        }

        public boolean isHierarchical() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.mInfo).isHierarchical();
        }

        public CollectionInfoCompat(Object r100) {
            this.mInfo = r100;
        }

        public static CollectionInfoCompat obtain(int r100, int r101, boolean r102) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(r100, r101, r102));
        }

        public static CollectionInfoCompat obtain(int r100, int r101, boolean r102, int r103) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(r100, r101, r102, r103));
        }
    }

    public static class CollectionItemInfoCompat {
        final Object mInfo;

        public static final class Builder {
            private int mColumnIndex;
            private int mColumnSpan;
            private String mColumnTitle;
            private boolean mHeading;
            private int mRowIndex;
            private int mRowSpan;
            private String mRowTitle;
            private boolean mSelected;

            public CollectionItemInfoCompat build() {
                if (Build.VERSION.SDK_INT < 33) goto L7;
                return Api33Impl.buildCollectionItemInfoCompat(this.mHeading, this.mColumnIndex, this.mRowIndex, this.mColumnSpan, this.mRowSpan, this.mSelected, this.mRowTitle, this.mColumnTitle);
            L7:
                return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(this.mRowIndex, this.mRowSpan, this.mColumnIndex, this.mColumnSpan, this.mHeading, this.mSelected));
            }

            public Builder() {
            }

            public Builder setColumnIndex(int r100) {
                this.mColumnIndex = r100;
                return this;
            }

            public Builder setColumnSpan(int r100) {
                this.mColumnSpan = r100;
                return this;
            }

            public Builder setColumnTitle(String r100) {
                this.mColumnTitle = r100;
                return this;
            }

            public Builder setHeading(boolean r100) {
                this.mHeading = r100;
                return this;
            }

            public Builder setRowIndex(int r100) {
                this.mRowIndex = r100;
                return this;
            }

            public Builder setRowSpan(int r100) {
                this.mRowSpan = r100;
                return this;
            }

            public Builder setRowTitle(String r100) {
                this.mRowTitle = r100;
                return this;
            }

            public Builder setSelected(boolean r100) {
                this.mSelected = r100;
                return this;
            }
        }

        public int getColumnIndex() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getColumnIndex();
        }

        public int getColumnSpan() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getColumnSpan();
        }

        public String getColumnTitle() {
            if (Build.VERSION.SDK_INT >= 33) goto L5;
            return null;
        L5:
            return Api33Impl.getCollectionItemColumnTitle(this.mInfo);
        }

        public int getRowIndex() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getRowIndex();
        }

        public int getRowSpan() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).getRowSpan();
        }

        public String getRowTitle() {
            if (Build.VERSION.SDK_INT >= 33) goto L5;
            return null;
        L5:
            return Api33Impl.getCollectionItemRowTitle(this.mInfo);
        }

        public boolean isHeading() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).isHeading();
        }

        public boolean isSelected() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.mInfo).isSelected();
        }

        public CollectionItemInfoCompat(Object r100) {
            this.mInfo = r100;
        }

        public static CollectionItemInfoCompat obtain(int r100, int r101, int r102, int r103, boolean r104) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(r100, r101, r102, r103, r104));
        }

        public static CollectionItemInfoCompat obtain(int r100, int r101, int r102, int r103, boolean r104, boolean r105) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(r100, r101, r102, r103, r104, r105));
        }
    }

    public static class RangeInfoCompat {
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;
        final Object mInfo;

        public float getCurrent() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getCurrent();
        }

        public float getMax() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getMax();
        }

        public float getMin() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getMin();
        }

        public int getType() {
            return ((AccessibilityNodeInfo.RangeInfo) this.mInfo).getType();
        }

        public RangeInfoCompat(Object r100) {
            this.mInfo = r100;
        }

        public RangeInfoCompat(int r100, float r101, float r102, float r103) {
            if (Build.VERSION.SDK_INT < 30) goto L5;
            this.mInfo = Api30Impl.createRangeInfo(r100, r101, r102, r103);
            return;
        L5:
            this.mInfo = AccessibilityNodeInfo.RangeInfo.obtain(r100, r101, r102, r103);
        }

        public static RangeInfoCompat obtain(int r100, float r101, float r102, float r103) {
            return new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(r100, r101, r102, r103));
        }
    }

    public static final class TouchDelegateInfoCompat {
        final AccessibilityNodeInfo.TouchDelegateInfo mInfo;

        public int getRegionCount() {
            if (Build.VERSION.SDK_INT >= 29) goto L5;
            return 0;
        L5:
            return this.mInfo.getRegionCount();
        }

        public TouchDelegateInfoCompat(Map<Region, View> r100) {
            if (Build.VERSION.SDK_INT < 29) goto L5;
            this.mInfo = new AccessibilityNodeInfo.TouchDelegateInfo(r100);
            return;
        L5:
            this.mInfo = null;
        }

        public Region getRegionAt(int r100) {
            if (Build.VERSION.SDK_INT >= 29) goto L5;
            return null;
        L5:
            return this.mInfo.getRegionAt(r100);
        }

        public AccessibilityNodeInfoCompat getTargetForRegion(Region r100) {
            if (Build.VERSION.SDK_INT < 29) goto L8;
            AccessibilityNodeInfo r101 = this.mInfo.getTargetForRegion(r100);
            if (r101 != null) goto L7;
            return null;
        L7:
            return AccessibilityNodeInfoCompat.wrap(r101);
        L8:
            return null;
        }

        public TouchDelegateInfoCompat(AccessibilityNodeInfo.TouchDelegateInfo r100) {
            this.mInfo = r100;
        }
    }

    public static String getActionSymbolicName(int r100) {
        if (r100 != 1) goto L5;
        return "ACTION_FOCUS";
    L5:
        if (r100 == 2) goto L92;
        switch(r100) {
            case 4: goto L90;
            case 8: goto L88;
            case 16: goto L86;
            case 32: goto L84;
            case 64: goto L82;
            case 128: goto L80;
            case 256: goto L78;
            case 512: goto L76;
            case 1024: goto L74;
            case 2048: goto L72;
            case 4096: goto L70;
            case 8192: goto L68;
            case 16384: goto L66;
            case 32768: goto L64;
            case 65536: goto L62;
            case 131072: goto L60;
            case 262144: goto L58;
            case 524288: goto L56;
            case 2097152: goto L54;
            case 16908354: goto L52;
            case 16908382: goto L50;
            default: goto L7;
        };
    L7:
        switch(r100) {
            case 16908342: goto L48;
            case 16908343: goto L46;
            case 16908344: goto L44;
            case 16908345: goto L42;
            case 16908346: goto L40;
            case 16908347: goto L38;
            case 16908348: goto L36;
            case 16908349: goto L34;
            default: goto L8;
        };
    L8:
        switch(r100) {
            case 16908356: goto L32;
            case 16908357: goto L30;
            case 16908358: goto L28;
            case 16908359: goto L26;
            case 16908360: goto L24;
            case 16908361: goto L22;
            case 16908362: goto L20;
            default: goto L9;
        };
    L9:
        switch(r100) {
            case 16908372: goto L18;
            case 16908373: goto L16;
            case 16908374: goto L14;
            case 16908375: goto L12;
            default: goto L10;
        };
    L10:
        return "ACTION_UNKNOWN";
    L12:
        return "ACTION_DRAG_CANCEL";
    L14:
        return "ACTION_DRAG_DROP";
    L16:
        return "ACTION_DRAG_START";
    L18:
        return "ACTION_IME_ENTER";
    L20:
        return "ACTION_PRESS_AND_HOLD";
    L22:
        return "ACTION_PAGE_RIGHT";
    L24:
        return "ACTION_PAGE_LEFT";
    L26:
        return "ACTION_PAGE_DOWN";
    L28:
        return "ACTION_PAGE_UP";
    L30:
        return "ACTION_HIDE_TOOLTIP";
    L32:
        return "ACTION_SHOW_TOOLTIP";
    L34:
        return "ACTION_SET_PROGRESS";
    L36:
        return "ACTION_CONTEXT_CLICK";
    L38:
        return "ACTION_SCROLL_RIGHT";
    L40:
        return "ACTION_SCROLL_DOWN";
    L42:
        return "ACTION_SCROLL_LEFT";
    L44:
        return "ACTION_SCROLL_UP";
    L46:
        return "ACTION_SCROLL_TO_POSITION";
    L48:
        return "ACTION_SHOW_ON_SCREEN";
    L50:
        return "ACTION_SCROLL_IN_DIRECTION";
    L52:
        return "ACTION_MOVE_WINDOW";
    L54:
        return "ACTION_SET_TEXT";
    L56:
        return "ACTION_COLLAPSE";
    L58:
        return "ACTION_EXPAND";
    L60:
        return "ACTION_SET_SELECTION";
    L62:
        return "ACTION_CUT";
    L64:
        return "ACTION_PASTE";
    L66:
        return "ACTION_COPY";
    L68:
        return "ACTION_SCROLL_BACKWARD";
    L70:
        return "ACTION_SCROLL_FORWARD";
    L72:
        return "ACTION_PREVIOUS_HTML_ELEMENT";
    L74:
        return "ACTION_NEXT_HTML_ELEMENT";
    L76:
        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
    L78:
        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
    L80:
        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
    L82:
        return "ACTION_ACCESSIBILITY_FOCUS";
    L84:
        return "ACTION_LONG_CLICK";
    L86:
        return "ACTION_CLICK";
    L88:
        return "ACTION_CLEAR_SELECTION";
    L90:
        return "ACTION_SELECT";
    L92:
        return "ACTION_CLEAR_FOCUS";
    }

    public void recycle() {
    }

    private void clearExtrasSpans() {
        this.mInfo.getExtras().remove(SPANS_START_KEY);
        this.mInfo.getExtras().remove(SPANS_END_KEY);
        this.mInfo.getExtras().remove(SPANS_FLAGS_KEY);
        this.mInfo.getExtras().remove(SPANS_ID_KEY);
    }

    private boolean hasSpans() {
        return !extrasIntList(SPANS_START_KEY).isEmpty();
    }

    public boolean canOpenPopup() {
        return this.mInfo.canOpenPopup();
    }

    public List<AccessibilityActionCompat> getActionList() {
        List<AccessibilityNodeInfo.AccessibilityAction> r100 = this.mInfo.getActionList();
        ArrayList r101 = new ArrayList();
        int r102 = r100.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101.add(new AccessibilityActionCompat(ListProtector.get(r100, r103)));
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    public int getActions() {
        return this.mInfo.getActions();
    }

    public List<String> getAvailableExtraData() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return this.mInfo.getAvailableExtraData();
    L7:
        return Collections.emptyList();
    }

    public int getChildCount() {
        return this.mInfo.getChildCount();
    }

    public CharSequence getClassName() {
        return this.mInfo.getClassName();
    }

    public CollectionInfoCompat getCollectionInfo() {
        AccessibilityNodeInfo.CollectionInfo r100 = this.mInfo.getCollectionInfo();
        if (r100 != null) goto L5;
        return null;
    L5:
        return new CollectionInfoCompat(r100);
    }

    public CollectionItemInfoCompat getCollectionItemInfo() {
        AccessibilityNodeInfo.CollectionItemInfo r100 = this.mInfo.getCollectionItemInfo();
        if (r100 != null) goto L5;
        return null;
    L5:
        return new CollectionItemInfoCompat(r100);
    }

    public CharSequence getContainerTitle() {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.getContainerTitle(this.mInfo);
    L7:
        return this.mInfo.getExtras().getCharSequence(CONTAINER_TITLE_KEY);
    }

    public CharSequence getContentDescription() {
        return this.mInfo.getContentDescription();
    }

    public int getDrawingOrder() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return 0;
    L5:
        return this.mInfo.getDrawingOrder();
    }

    public CharSequence getError() {
        return this.mInfo.getError();
    }

    public AccessibilityNodeInfo.ExtraRenderingInfo getExtraRenderingInfo() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return null;
    L5:
        return Api33Impl.getExtraRenderingInfo(this.mInfo);
    }

    public Bundle getExtras() {
        return this.mInfo.getExtras();
    }

    public CharSequence getHintText() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return this.mInfo.getHintText();
    L7:
        return this.mInfo.getExtras().getCharSequence(HINT_TEXT_KEY);
    }

    public int getInputType() {
        return this.mInfo.getInputType();
    }

    public AccessibilityNodeInfoCompat getLabelFor() {
        return wrapNonNullInstance(this.mInfo.getLabelFor());
    }

    public AccessibilityNodeInfoCompat getLabeledBy() {
        return wrapNonNullInstance(this.mInfo.getLabeledBy());
    }

    public int getLiveRegion() {
        return this.mInfo.getLiveRegion();
    }

    public int getMaxTextLength() {
        return this.mInfo.getMaxTextLength();
    }

    public long getMinDurationBetweenContentChangesMillis() {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.getMinDurationBetweenContentChangeMillis(this.mInfo);
    L7:
        return this.mInfo.getExtras().getLong(MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY);
    }

    public int getMovementGranularities() {
        return this.mInfo.getMovementGranularities();
    }

    public CharSequence getPackageName() {
        return this.mInfo.getPackageName();
    }

    public CharSequence getPaneTitle() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return this.mInfo.getPaneTitle();
    L7:
        return this.mInfo.getExtras().getCharSequence(PANE_TITLE_KEY);
    }

    public AccessibilityNodeInfoCompat getParent() {
        return wrapNonNullInstance(this.mInfo.getParent());
    }

    public RangeInfoCompat getRangeInfo() {
        AccessibilityNodeInfo.RangeInfo r100 = this.mInfo.getRangeInfo();
        if (r100 != null) goto L5;
        return null;
    L5:
        return new RangeInfoCompat(r100);
    }

    public CharSequence getRoleDescription() {
        return this.mInfo.getExtras().getCharSequence(ROLE_DESCRIPTION_KEY);
    }

    public CharSequence getStateDescription() {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return Api30Impl.getStateDescription(this.mInfo);
    L7:
        return this.mInfo.getExtras().getCharSequence(STATE_DESCRIPTION_KEY);
    }

    public int getTextSelectionEnd() {
        return this.mInfo.getTextSelectionEnd();
    }

    public int getTextSelectionStart() {
        return this.mInfo.getTextSelectionStart();
    }

    public CharSequence getTooltipText() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return this.mInfo.getTooltipText();
    L7:
        return this.mInfo.getExtras().getCharSequence(TOOLTIP_TEXT_KEY);
    }

    public TouchDelegateInfoCompat getTouchDelegateInfo() {
        if (Build.VERSION.SDK_INT < 29) goto L8;
        AccessibilityNodeInfo.TouchDelegateInfo r100 = this.mInfo.getTouchDelegateInfo();
        if (r100 != null) goto L7;
        return null;
    L7:
        return new TouchDelegateInfoCompat(r100);
    L8:
        return null;
    }

    public AccessibilityNodeInfoCompat getTraversalAfter() {
        if (Build.VERSION.SDK_INT >= 22) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(this.mInfo.getTraversalAfter());
    }

    public AccessibilityNodeInfoCompat getTraversalBefore() {
        if (Build.VERSION.SDK_INT >= 22) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(this.mInfo.getTraversalBefore());
    }

    public String getUniqueId() {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return Api33Impl.getUniqueId(this.mInfo);
    L7:
        return this.mInfo.getExtras().getString(UNIQUE_ID_KEY);
    }

    public String getViewIdResourceName() {
        return this.mInfo.getViewIdResourceName();
    }

    public AccessibilityWindowInfoCompat getWindow() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(this.mInfo.getWindow());
    }

    public int getWindowId() {
        return this.mInfo.getWindowId();
    }

    public boolean hasRequestInitialAccessibilityFocus() {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.hasRequestInitialAccessibilityFocus(this.mInfo);
    L7:
        return getBooleanProperty(32);
    }

    public int hashCode() {
        AccessibilityNodeInfo r100 = this.mInfo;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public boolean isAccessibilityDataSensitive() {
        if (Build.VERSION.SDK_INT < 34) goto L7;
        return Api34Impl.isAccessibilityDataSensitive(this.mInfo);
    L7:
        return getBooleanProperty(64);
    }

    public boolean isAccessibilityFocused() {
        return this.mInfo.isAccessibilityFocused();
    }

    public boolean isCheckable() {
        return this.mInfo.isCheckable();
    }

    public boolean isChecked() {
        return this.mInfo.isChecked();
    }

    public boolean isClickable() {
        return this.mInfo.isClickable();
    }

    public boolean isContentInvalid() {
        return this.mInfo.isContentInvalid();
    }

    public boolean isContextClickable() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        return this.mInfo.isContextClickable();
    }

    public boolean isDismissable() {
        return this.mInfo.isDismissable();
    }

    public boolean isEditable() {
        return this.mInfo.isEditable();
    }

    public boolean isEnabled() {
        return this.mInfo.isEnabled();
    }

    public boolean isFocusable() {
        return this.mInfo.isFocusable();
    }

    public boolean isFocused() {
        return this.mInfo.isFocused();
    }

    public boolean isGranularScrollingSupported() {
        return getBooleanProperty(67108864);
    }

    public boolean isHeading() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return this.mInfo.isHeading();
    L7:
        if (getBooleanProperty(2) == false) goto L9;
        return true;
    L9:
        CollectionItemInfoCompat r100 = getCollectionItemInfo();
        if (r100 != null) goto L12;
    L14:
        return false;
    L12:
        if (r100.isHeading() == false) goto L14;
        return true;
    }

    public boolean isImportantForAccessibility() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return true;
    L5:
        return this.mInfo.isImportantForAccessibility();
    }

    public boolean isLongClickable() {
        return this.mInfo.isLongClickable();
    }

    public boolean isMultiLine() {
        return this.mInfo.isMultiLine();
    }

    public boolean isPassword() {
        return this.mInfo.isPassword();
    }

    public boolean isScreenReaderFocusable() {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return this.mInfo.isScreenReaderFocusable();
    L7:
        return getBooleanProperty(1);
    }

    public boolean isScrollable() {
        return this.mInfo.isScrollable();
    }

    public boolean isSelected() {
        return this.mInfo.isSelected();
    }

    public boolean isShowingHintText() {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return this.mInfo.isShowingHintText();
    L7:
        return getBooleanProperty(4);
    }

    public boolean isTextEntryKey() {
        if (Build.VERSION.SDK_INT < 29) goto L7;
        return this.mInfo.isTextEntryKey();
    L7:
        return getBooleanProperty(8);
    }

    public boolean isTextSelectable() {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return Api33Impl.isTextSelectable(this.mInfo);
    L7:
        return getBooleanProperty(8388608);
    }

    public boolean isVisibleToUser() {
        return this.mInfo.isVisibleToUser();
    }

    public boolean refresh() {
        return this.mInfo.refresh();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(super.toString());
        Rect r101 = new Rect();
        getBoundsInParent(r101);
        r100.append("; boundsInParent: " + r101);
        getBoundsInScreen(r101);
        r100.append("; boundsInScreen: " + r101);
        getBoundsInWindow(r101);
        r100.append("; boundsInWindow: " + r101);
        r100.append("; packageName: ");
        r100.append(getPackageName());
        r100.append("; className: ");
        r100.append(getClassName());
        r100.append("; text: ");
        r100.append(getText());
        r100.append("; error: ");
        r100.append(getError());
        r100.append("; maxTextLength: ");
        r100.append(getMaxTextLength());
        r100.append("; stateDescription: ");
        r100.append(getStateDescription());
        r100.append("; contentDescription: ");
        r100.append(getContentDescription());
        r100.append("; tooltipText: ");
        r100.append(getTooltipText());
        r100.append("; viewIdResName: ");
        r100.append(getViewIdResourceName());
        r100.append("; uniqueId: ");
        r100.append(getUniqueId());
        r100.append("; checkable: ");
        r100.append(isCheckable());
        r100.append("; checked: ");
        r100.append(isChecked());
        r100.append("; focusable: ");
        r100.append(isFocusable());
        r100.append("; focused: ");
        r100.append(isFocused());
        r100.append("; selected: ");
        r100.append(isSelected());
        r100.append("; clickable: ");
        r100.append(isClickable());
        r100.append("; longClickable: ");
        r100.append(isLongClickable());
        r100.append("; contextClickable: ");
        r100.append(isContextClickable());
        r100.append("; enabled: ");
        r100.append(isEnabled());
        r100.append("; password: ");
        r100.append(isPassword());
        r100.append("; scrollable: " + isScrollable());
        r100.append("; containerTitle: ");
        r100.append(getContainerTitle());
        r100.append("; granularScrollingSupported: ");
        r100.append(isGranularScrollingSupported());
        r100.append("; importantForAccessibility: ");
        r100.append(isImportantForAccessibility());
        r100.append("; visible: ");
        r100.append(isVisibleToUser());
        r100.append("; isTextSelectable: ");
        r100.append(isTextSelectable());
        r100.append("; accessibilityDataSensitive: ");
        r100.append(isAccessibilityDataSensitive());
        r100.append("; [");
        List<AccessibilityActionCompat> r102 = getActionList();
        int r103 = 0;
    L4:
        if (r103 >= r102.size()) goto L14;
        AccessibilityActionCompat r104 = (AccessibilityActionCompat) ListProtector.get(r102, r103);
        String r105 = getActionSymbolicName(r104.getId());
        if (r105.equals("ACTION_UNKNOWN") == true) goto L8;
    L10:
        r100.append(r105);
        if (r103 == (r102.size() - 1)) goto L13;
        r100.append(", ");
    L13:
        r103 = r103 + 1;
        goto L4
    L8:
        if (r104.getLabel() == null) goto L10;
        r105 = r104.getLabel().toString();
        goto L10
    L14:
        r100.append("]");
        return r100.toString();
    }

    public static AccessibilityNodeInfoCompat obtain() {
        return wrap(AccessibilityNodeInfo.obtain());
    }

    public CharSequence getText() {
        if (hasSpans() == false) goto L10;
        List<Integer> r100 = extrasIntList(SPANS_START_KEY);
        List<Integer> r101 = extrasIntList(SPANS_END_KEY);
        List<Integer> r102 = extrasIntList(SPANS_FLAGS_KEY);
        List<Integer> r103 = extrasIntList(SPANS_ID_KEY);
        int r104 = 0;
        SpannableString r105 = new SpannableString(TextUtils.substring(this.mInfo.getText(), 0, this.mInfo.getText().length()));
    L6:
        if (r104 >= r100.size()) goto L8;
        r105.setSpan(new AccessibilityClickableSpanCompat(((Integer) ListProtector.get(r103, r104)).intValue(), this, getExtras().getInt(SPANS_ACTION_ID_KEY)), ((Integer) ListProtector.get(r100, r104)).intValue(), ((Integer) ListProtector.get(r101, r104)).intValue(), ((Integer) ListProtector.get(r102, r104)).intValue());
        r104 = r104 + 1;
        goto L6
    L8:
        return r105;
    L10:
        return this.mInfo.getText();
    }

    public Object getInfo() {
        return this.mInfo;
    }

    public AccessibilityNodeInfo unwrap() {
        return this.mInfo;
    }

    public AccessibilityNodeInfoCompat(Object r100) {
        this.mParentVirtualDescendantId = -1;
        this.mVirtualDescendantId = -1;
        this.mInfo = (AccessibilityNodeInfo) r100;
    }

    private List<Integer> extrasIntList(String r100) {
        ArrayList<Integer> r101 = this.mInfo.getExtras().getIntegerArrayList(r100);
        if (r101 != null) goto L6;
        ArrayList<Integer> r102 = new ArrayList();
        this.mInfo.getExtras().putIntegerArrayList(r100, r102);
        return r102;
    L6:
        return r101;
    }

    private boolean getBooleanProperty(int r100) {
        Bundle r101 = getExtras();
        if (r101 != null) goto L6;
        return false;
    L6:
        if ((r101.getInt(BOOLEAN_PROPERTY_KEY, 0) & r100) != r100) goto L9;
        return true;
    L9:
        return false;
    }

    public static ClickableSpan[] getClickableSpans(CharSequence r100) {
        if ((r100 instanceof Spanned) == true) goto L5;
        return null;
    L5:
        return (ClickableSpan[]) ((Spanned) r100).getSpans(0, r100.length(), ClickableSpan.class);
    }

    private SparseArray<WeakReference<ClickableSpan>> getOrCreateSpansFromViewTags(View r100) {
        SparseArray<WeakReference<ClickableSpan>> r101 = getSpansFromViewTags(r100);
        if (r101 != null) goto L6;
        SparseArray<WeakReference<ClickableSpan>> r102 = new SparseArray();
        r100.setTag(com.larus.nova.R.id.tag_accessibility_clickable_spans, r102);
        return r102;
    L6:
        return r101;
    }

    private SparseArray<WeakReference<ClickableSpan>> getSpansFromViewTags(View r100) {
        return (SparseArray) r100.getTag(com.larus.nova.R.id.tag_accessibility_clickable_spans);
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat r100) {
        return wrap(AccessibilityNodeInfo.obtain(r100.mInfo));
    }

    private void removeCollectedSpans(View r100) {
        SparseArray<WeakReference<ClickableSpan>> r101 = getSpansFromViewTags(r100);
        if (r101 == null) goto L14;
        ArrayList r102 = new ArrayList();
        int r103 = 0;
        int r104 = 0;
    L6:
        if (r104 >= r101.size()) goto L12;
        if (r101.valueAt(r104).get() != null) goto L10;
        r102.add(Integer.valueOf(r104));
    L10:
        r104 = r104 + 1;
    L12:
        if (r103 >= r102.size()) goto L19;
        r101.remove(((Integer) ListProtector.get(r102, r103)).intValue());
        r103 = r103 + 1;
        goto L12
    L19:
        return;
    }

    public static AccessibilityNodeInfoCompat wrap(AccessibilityNodeInfo r100) {
        return new AccessibilityNodeInfoCompat(r100);
    }

    public static AccessibilityNodeInfoCompat wrapNonNullInstance(Object r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return new AccessibilityNodeInfoCompat(r100);
    }

    public void addAction(AccessibilityActionCompat r100) {
        this.mInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) r100.mAction);
    }

    public void addChild(View r100) {
        this.mInfo.addChild(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if ((r100 instanceof AccessibilityNodeInfoCompat) == true) goto L11;
        return false;
    L11:
        AccessibilityNodeInfoCompat r101 = (AccessibilityNodeInfoCompat) r100;
        AccessibilityNodeInfo r102 = this.mInfo;
        if (r102 != null) goto L17;
        if (r101.mInfo == null) goto L20;
        return false;
    L20:
        if (this.mVirtualDescendantId == r101.mVirtualDescendantId) goto L23;
        return false;
    L23:
        if (this.mParentVirtualDescendantId == r101.mParentVirtualDescendantId) goto L25;
        return false;
    L25:
        return true;
    L17:
        if (r102.equals(r101.mInfo) == true) goto L20;
        return false;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String r100) {
        ArrayList r101 = new ArrayList();
        List<AccessibilityNodeInfo> r102 = this.mInfo.findAccessibilityNodeInfosByText(r100);
        int r103 = r102.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r101.add(wrap((AccessibilityNodeInfo) ListProtector.get(r102, r104)));
        r104 = r104 + 1;
        goto L3
    L5:
        return r101;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String r100) {
        List<AccessibilityNodeInfo> r101 = this.mInfo.findAccessibilityNodeInfosByViewId(r100);
        ArrayList r102 = new ArrayList();
        Iterator<AccessibilityNodeInfo> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(wrap(r103.next()));
        goto L4
    L6:
        return r102;
    }

    public AccessibilityNodeInfoCompat findFocus(int r100) {
        return wrapNonNullInstance(this.mInfo.findFocus(r100));
    }

    public AccessibilityNodeInfoCompat focusSearch(int r100) {
        return wrapNonNullInstance(this.mInfo.focusSearch(r100));
    }

    public void getBoundsInParent(Rect r100) {
        this.mInfo.getBoundsInParent(r100);
    }

    public void getBoundsInScreen(Rect r100) {
        this.mInfo.getBoundsInScreen(r100);
    }

    public void getBoundsInWindow(Rect r100) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.getBoundsInWindow(this.mInfo, r100);
        return;
    L5:
        Rect r101 = (Rect) this.mInfo.getExtras().getParcelable(BOUNDS_IN_WINDOW_KEY);
        if (r101 == null) goto L10;
        r100.set(r101.left, r101.top, r101.right, r101.bottom);
        return;
    }

    public AccessibilityNodeInfoCompat getChild(int r100) {
        return wrapNonNullInstance(this.mInfo.getChild(r100));
    }

    public AccessibilityNodeInfoCompat getParent(int r100) {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return Api33Impl.getParent(this.mInfo, r100);
    L7:
        return getParent();
    }

    public boolean performAction(int r100) {
        return this.mInfo.performAction(r100);
    }

    public boolean removeAction(AccessibilityActionCompat r100) {
        return this.mInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) r100.mAction);
    }

    public boolean removeChild(View r100) {
        return this.mInfo.removeChild(r100);
    }

    public void setAccessibilityDataSensitive(boolean r100) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.setAccessibilityDataSensitive(this.mInfo, r100);
        return;
    L5:
        setBooleanProperty(64, r100);
    }

    public void setAccessibilityFocused(boolean r100) {
        this.mInfo.setAccessibilityFocused(r100);
    }

    public void setAvailableExtraData(List<String> r100) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        this.mInfo.setAvailableExtraData(r100);
        return;
    }

    public void setBoundsInParent(Rect r100) {
        this.mInfo.setBoundsInParent(r100);
    }

    public void setBoundsInScreen(Rect r100) {
        this.mInfo.setBoundsInScreen(r100);
    }

    public void setBoundsInWindow(Rect r100) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.setBoundsInWindow(this.mInfo, r100);
        return;
    L5:
        this.mInfo.getExtras().putParcelable(BOUNDS_IN_WINDOW_KEY, r100);
    }

    public void setCanOpenPopup(boolean r100) {
        this.mInfo.setCanOpenPopup(r100);
    }

    public void setCheckable(boolean r100) {
        this.mInfo.setCheckable(r100);
    }

    public void setChecked(boolean r100) {
        this.mInfo.setChecked(r100);
    }

    public void setClassName(CharSequence r100) {
        this.mInfo.setClassName(r100);
    }

    public void setClickable(boolean r100) {
        this.mInfo.setClickable(r100);
    }

    public void setCollectionInfo(Object r100) {
        AccessibilityNodeInfo r101 = this.mInfo;
        if (r100 != null) goto L5;
        AccessibilityNodeInfo.CollectionInfo r102 = null;
    L6:
        r101.setCollectionInfo(r102);
        return;
    L5:
        r102 = (AccessibilityNodeInfo.CollectionInfo) ((CollectionInfoCompat) r100).mInfo;
        goto L6
    }

    public void setCollectionItemInfo(Object r100) {
        AccessibilityNodeInfo r101 = this.mInfo;
        if (r100 != null) goto L5;
        AccessibilityNodeInfo.CollectionItemInfo r102 = null;
    L6:
        r101.setCollectionItemInfo(r102);
        return;
    L5:
        r102 = (AccessibilityNodeInfo.CollectionItemInfo) ((CollectionItemInfoCompat) r100).mInfo;
        goto L6
    }

    public void setContainerTitle(CharSequence r100) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.setContainerTitle(this.mInfo, r100);
        return;
    L5:
        this.mInfo.getExtras().putCharSequence(CONTAINER_TITLE_KEY, r100);
    }

    public void setContentDescription(CharSequence r100) {
        this.mInfo.setContentDescription(r100);
    }

    public void setContentInvalid(boolean r100) {
        this.mInfo.setContentInvalid(r100);
    }

    public void setContextClickable(boolean r100) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        this.mInfo.setContextClickable(r100);
        return;
    }

    public void setDismissable(boolean r100) {
        this.mInfo.setDismissable(r100);
    }

    public void setDrawingOrder(int r100) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        this.mInfo.setDrawingOrder(r100);
        return;
    }

    public void setEditable(boolean r100) {
        this.mInfo.setEditable(r100);
    }

    public void setEnabled(boolean r100) {
        this.mInfo.setEnabled(r100);
    }

    public void setError(CharSequence r100) {
        this.mInfo.setError(r100);
    }

    public void setFocusable(boolean r100) {
        this.mInfo.setFocusable(r100);
    }

    public void setFocused(boolean r100) {
        this.mInfo.setFocused(r100);
    }

    public void setGranularScrollingSupported(boolean r100) {
        setBooleanProperty(67108864, r100);
    }

    public void setHeading(boolean r100) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        this.mInfo.setHeading(r100);
        return;
    L5:
        setBooleanProperty(2, r100);
    }

    public void setHintText(CharSequence r100) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        this.mInfo.setHintText(r100);
        return;
    L5:
        this.mInfo.getExtras().putCharSequence(HINT_TEXT_KEY, r100);
    }

    public void setImportantForAccessibility(boolean r100) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        this.mInfo.setImportantForAccessibility(r100);
        return;
    }

    public void setInputType(int r100) {
        this.mInfo.setInputType(r100);
    }

    public void setLabelFor(View r100) {
        this.mInfo.setLabelFor(r100);
    }

    public void setLabeledBy(View r100) {
        this.mInfo.setLabeledBy(r100);
    }

    public void setLiveRegion(int r100) {
        this.mInfo.setLiveRegion(r100);
    }

    public void setLongClickable(boolean r100) {
        this.mInfo.setLongClickable(r100);
    }

    public void setMaxTextLength(int r100) {
        this.mInfo.setMaxTextLength(r100);
    }

    public void setMinDurationBetweenContentChangesMillis(long r100) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.setMinDurationBetweenContentChangeMillis(this.mInfo, r100);
        return;
    L5:
        this.mInfo.getExtras().putLong(MIN_DURATION_BETWEEN_CONTENT_CHANGES_KEY, r100);
    }

    public void setMovementGranularities(int r100) {
        this.mInfo.setMovementGranularities(r100);
    }

    public void setMultiLine(boolean r100) {
        this.mInfo.setMultiLine(r100);
    }

    public void setPackageName(CharSequence r100) {
        this.mInfo.setPackageName(r100);
    }

    public void setPaneTitle(CharSequence r100) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        this.mInfo.setPaneTitle(r100);
        return;
    L5:
        this.mInfo.getExtras().putCharSequence(PANE_TITLE_KEY, r100);
    }

    public void setParent(View r100) {
        this.mParentVirtualDescendantId = -1;
        this.mInfo.setParent(r100);
    }

    public void setPassword(boolean r100) {
        this.mInfo.setPassword(r100);
    }

    public void setRangeInfo(RangeInfoCompat r100) {
        this.mInfo.setRangeInfo((AccessibilityNodeInfo.RangeInfo) r100.mInfo);
    }

    public void setRequestInitialAccessibilityFocus(boolean r100) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.setRequestInitialAccessibilityFocus(this.mInfo, r100);
        return;
    L5:
        setBooleanProperty(32, r100);
    }

    public void setRoleDescription(CharSequence r100) {
        this.mInfo.getExtras().putCharSequence(ROLE_DESCRIPTION_KEY, r100);
    }

    public void setScreenReaderFocusable(boolean r100) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        this.mInfo.setScreenReaderFocusable(r100);
        return;
    L5:
        setBooleanProperty(1, r100);
    }

    public void setScrollable(boolean r100) {
        this.mInfo.setScrollable(r100);
    }

    public void setSelected(boolean r100) {
        this.mInfo.setSelected(r100);
    }

    public void setShowingHintText(boolean r100) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        this.mInfo.setShowingHintText(r100);
        return;
    L5:
        setBooleanProperty(4, r100);
    }

    public void setSource(View r100) {
        this.mVirtualDescendantId = -1;
        this.mInfo.setSource(r100);
    }

    public void setStateDescription(CharSequence r100) {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        Api30Impl.setStateDescription(this.mInfo, r100);
        return;
    L5:
        this.mInfo.getExtras().putCharSequence(STATE_DESCRIPTION_KEY, r100);
    }

    public void setText(CharSequence r100) {
        this.mInfo.setText(r100);
    }

    public void setTextEntryKey(boolean r100) {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        this.mInfo.setTextEntryKey(r100);
        return;
    L5:
        setBooleanProperty(8, r100);
    }

    public void setTextSelectable(boolean r100) {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        Api33Impl.setTextSelectable(this.mInfo, r100);
        return;
    L5:
        setBooleanProperty(8388608, r100);
    }

    public void setTooltipText(CharSequence r100) {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        this.mInfo.setTooltipText(r100);
        return;
    L5:
        this.mInfo.getExtras().putCharSequence(TOOLTIP_TEXT_KEY, r100);
    }

    public void setTouchDelegateInfo(TouchDelegateInfoCompat r100) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        this.mInfo.setTouchDelegateInfo(r100.mInfo);
        return;
    }

    public void setTraversalAfter(View r100) {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        this.mInfo.setTraversalAfter(r100);
        return;
    }

    public void setTraversalBefore(View r100) {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        this.mInfo.setTraversalBefore(r100);
        return;
    }

    public void setUniqueId(String r100) {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        Api33Impl.setUniqueId(this.mInfo, r100);
        return;
    L5:
        this.mInfo.getExtras().putString(UNIQUE_ID_KEY, r100);
    }

    public void setViewIdResourceName(String r100) {
        this.mInfo.setViewIdResourceName(r100);
    }

    public void setVisibleToUser(boolean r100) {
        this.mInfo.setVisibleToUser(r100);
    }

    private AccessibilityNodeInfoCompat(AccessibilityNodeInfo r100) {
        this.mParentVirtualDescendantId = -1;
        this.mVirtualDescendantId = -1;
        this.mInfo = r100;
    }

    public static AccessibilityNodeInfoCompat obtain(View r100) {
        return wrap(AccessibilityNodeInfo.obtain(r100));
    }

    public void addAction(int r100) {
        this.mInfo.addAction(r100);
    }

    private int idForClickableSpan(ClickableSpan r100, SparseArray<WeakReference<ClickableSpan>> r101) {
        if (r101 == null) goto L11;
        int r102 = 0;
    L5:
        if (r102 >= r101.size()) goto L11;
        if (r100.equals(r101.valueAt(r102).get()) == true) goto L9;
        r102 = r102 + 1;
        goto L5
    L9:
        return r101.keyAt(r102);
    L11:
        int r103 = sClickableSpanId;
        sClickableSpanId = r103 + 1;
        return r103;
    }

    public static AccessibilityNodeInfoCompat obtain(View r100, int r101) {
        return wrapNonNullInstance(AccessibilityNodeInfo.obtain(r100, r101));
    }

    private void setBooleanProperty(int r100, boolean r101) {
        Bundle r102 = getExtras();
        if (r102 == null) goto L10;
        int r103 = r102.getInt(BOOLEAN_PROPERTY_KEY, 0) & (~r100);
        if (r101 == true) goto L8;
        r100 = 0;
    L8:
        r102.putInt(BOOLEAN_PROPERTY_KEY, r100 | r103);
        return;
    }

    public void addChild(View r100, int r101) {
        this.mInfo.addChild(r100, r101);
    }

    public void addSpansToExtras(CharSequence r100, View r101) {
        if (Build.VERSION.SDK_INT >= 26) goto L12;
        clearExtrasSpans();
        removeCollectedSpans(r101);
        ClickableSpan[] r102 = getClickableSpans(r100);
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.length <= 0) goto L15;
        getExtras().putInt(SPANS_ACTION_ID_KEY, com.larus.nova.R.id.accessibility_action_clickable_span);
        SparseArray<WeakReference<ClickableSpan>> r103 = getOrCreateSpansFromViewTags(r101);
        int r104 = 0;
    L10:
        if (r104 >= r102.length) goto L16;
        int r105 = idForClickableSpan(r102[r104], r103);
        r103.put(r105, new WeakReference(r102[r104]));
        addSpanLocationToExtras(r102[r104], (Spanned) r100, r105);
        r104 = r104 + 1;
        goto L10
    L16:
        return;
    L15:
        return;
    }

    public AccessibilityNodeInfoCompat getChild(int r100, int r101) {
        if (Build.VERSION.SDK_INT < 33) goto L7;
        return Api33Impl.getChild(this.mInfo, r100, r101);
    L7:
        return getChild(r100);
    }

    public boolean performAction(int r100, Bundle r101) {
        return this.mInfo.performAction(r100, r101);
    }

    public boolean removeChild(View r100, int r101) {
        return this.mInfo.removeChild(r100, r101);
    }

    public void setLabelFor(View r100, int r101) {
        this.mInfo.setLabelFor(r100, r101);
    }

    public void setLabeledBy(View r100, int r101) {
        this.mInfo.setLabeledBy(r100, r101);
    }

    public void setParent(View r100, int r101) {
        this.mParentVirtualDescendantId = r101;
        this.mInfo.setParent(r100, r101);
    }

    public void setQueryFromAppProcessEnabled(View r100, boolean r101) {
        if (Build.VERSION.SDK_INT < 34) goto L6;
        Api34Impl.setQueryFromAppProcessEnabled(this.mInfo, r100, r101);
        return;
    }

    public void setSource(View r100, int r101) {
        this.mVirtualDescendantId = r101;
        this.mInfo.setSource(r100, r101);
    }

    public void setTextSelection(int r100, int r101) {
        this.mInfo.setTextSelection(r100, r101);
    }

    public void setTraversalAfter(View r100, int r101) {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        this.mInfo.setTraversalAfter(r100, r101);
        return;
    }

    public void setTraversalBefore(View r100, int r101) {
        if (Build.VERSION.SDK_INT < 22) goto L6;
        this.mInfo.setTraversalBefore(r100, r101);
        return;
    }

    private void addSpanLocationToExtras(ClickableSpan r100, Spanned r101, int r102) {
        extrasIntList(SPANS_START_KEY).add(Integer.valueOf(r101.getSpanStart(r100)));
        extrasIntList(SPANS_END_KEY).add(Integer.valueOf(r101.getSpanEnd(r100)));
        extrasIntList(SPANS_FLAGS_KEY).add(Integer.valueOf(r101.getSpanFlags(r100)));
        extrasIntList(SPANS_ID_KEY).add(Integer.valueOf(r102));
    }
}
