package com.stepos.launcher.assistant.widgetdrag;

/* loaded from: classes.dex */
public class GlobalDragConstant {
    public static final int DEFAULT_DRAG_DRAG_SURFACE_BG_BLUR_RADIUS = 30;
    public static final String DRAG_CLIP_DESCRIPTION = "stepos_launcher_drag";
    public static final String DRAG_CONFIG_KEY = "stepos_drag_config";
    public static final int DRAG_FLAG = 2817;

    @Deprecated
    public static final int DRAG_FLAG_HIDE_DRAG_SURFACE = Integer.MIN_VALUE;
    public static final String DRAG_TYPE_KEY = "stepos_drag_type";
    public static final String KEY_DRAG_SURFACE = "key_drag_surface";
    public static final String KEY_DRAG_SURFACE_BBQ_WRAPPER = "key_drag_surface_bbq_wrapper";
    public static final String KEY_WIDGET_PICKER_FILTER_SPAN_X = "filter_span_x";
    public static final String KEY_WIDGET_PICKER_FILTER_SPAN_Y = "filter_span_Y";
    public static final String KEY_WIDGET_PICKER_SOURCE = "widget_picker_source";
    public static final String MIME_TYPE = "com.stepos.launcher.drag_and_drop/global";
    public static final String MIME_TYPE_HIDE_SURFACE = "com.stepos.launcher.drag_and_drop/hidesurface";

    public interface DragSource {
        public static final int SOURCE_ASSISTANT = 2;
        public static final int SOURCE_LAUNCHER = 1;
        public static final int SOURCE_NONE = -1;
        public static final int SOURCE_WIDGETS_PICKER_ASSISTANT = 4;
        public static final int SOURCE_WIDGETS_PICKER_LAUNCHER = 3;
        public static final int SOURCE_WIDGETS_STACK_ASSISTANT = 6;
        public static final int SOURCE_WIDGETS_STACK_LAUNCHER = 5;
    }

    public interface DragType {
        public static final int TYPE_APP = 3;
        public static final int TYPE_APP_PAIR = 5;
        public static final int TYPE_FOLDER = 2;
        public static final int TYPE_NONE = -1;
        public static final int TYPE_WIDGET = 1;
        public static final int TYPE_WIDGET_STACK = 4;
    }

    public interface WidgetPickerSource {
        public static final int PICKER_SOURCE_ASSISTANT = 2;
        public static final int PICKER_SOURCE_LAUNCHER = 1;
        public static final int PICKER_SOURCE_NONE = -1;
        public static final int PICKER_SOURCE_STACK_ASSISTANT = 4;
        public static final int PICKER_SOURCE_STACK_LAUNCHER = 3;
    }
}
