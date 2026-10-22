package com.stepos.launcher.assistant.slidepanel;

/* loaded from: classes.dex */
public final class OverlayIndicatorState {
    public static final String KEY_ACTIVE_PAGE = "overlay_indicator_active_page";
    public static final String KEY_ALL_TASKS_ENTRY_VISIBLE = "overlay_all_tasks_entry_visible";
    public static final String KEY_BOTTOM_MARGIN = "overlay_indicator_bottom_margin";
    public static final String KEY_DOT_RADIUS_PX = "overlay_indicator_dot_radius_px";
    public static final String KEY_INDICATOR_COLOR = "overlay_indicator_color";
    public static final String KEY_OVERLAY_PROGRESS = "overlay_indicator_overlay_progress";
    public static final String KEY_PAGE_COUNT = "overlay_indicator_page_count";
    public static final String KEY_PILL_CORNER_RADIUS_PX = "overlay_indicator_pill_corner_radius_px";
    public static final String KEY_PILL_HEIGHT_PX = "overlay_indicator_pill_height_px";
    public static final String KEY_PILL_PADDING_HORIZONTAL_PX = "overlay_indicator_pill_padding_h_px";
    public static final String KEY_PILL_PADDING_VERTICAL_PX = "overlay_indicator_pill_padding_v_px";
    public static final String KEY_PILL_WIDTH_PX = "overlay_indicator_pill_width_px";
    public static final String KEY_SCROLL_COLOR = "overlay_indicator_scroll_color";
    public static final String KEY_TWO_DOT_GAP_PX = "overlay_indicator_two_dot_gap_px";
    public static final String KEY_TWO_DOT_RADIUS_PX = "overlay_indicator_two_dot_radius_px";
    public static final String KEY_TWO_DOT_ROW_WIDTH_PX = "overlay_indicator_two_dot_row_width_px";
    public static final String KEY_WORKSPACE_PAGE_COUNT = "overlay_indicator_workspace_page_count";
    public static final float MINUS_ONE_DISENGAGE_PROGRESS = 0.98f;
    public static final int OVERLAY_ADJACENT_PAGE_DOT_INDEX = 1;
    public static final int OVERLAY_ADJACENT_WORKSPACE_PAGE = 0;
    public static final int OVERLAY_DOT_INDEX = 0;
    public static final float PILL_HANDOFF_PROGRESS = 0.5f;
    public static final float PROGRESS_SYNC_EPSILON = 0.003f;
    public static final float REST_PROGRESS_EPSILON = 0.001f;

    private OverlayIndicatorState() {
    }

    public static boolean isLauncherGlassRestProgress(float f10) {
        return f10 <= 0.001f;
    }

    public static boolean isLauncherPillHandoffOwner(float f10) {
        return f10 < 0.5f;
    }

    public static boolean isOverlayGlassRestProgress(float f10) {
        return f10 >= 0.999f;
    }

    public static boolean isOverlayPillHandoffOwner(float f10) {
        return f10 >= 0.5f;
    }

    public static boolean isTransitionProgress(float f10) {
        return f10 > 0.001f && f10 < 0.999f;
    }
}
