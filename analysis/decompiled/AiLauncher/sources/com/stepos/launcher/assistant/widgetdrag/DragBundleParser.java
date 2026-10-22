package com.stepos.launcher.assistant.widgetdrag;

import android.os.Bundle;

/* loaded from: classes.dex */
public class DragBundleParser {

    public interface Event {
        public static final String CANCEL_DRAG = "cancel_drag";
        public static final String DROP_RESULT = "drop_result";
        public static final String DROP_START = "drop_start";
        public static final String GET_DRAG_EVENT = "get_drag_event";
        public static final String GET_WIDGET_DRAG_ENABLE = "get_widget_drag_enable";
    }

    public interface Key {
        public static final String DRAG_EVENT = "drag_event";
        public static final String DRAG_EVENT_TYPE = "drag_event_type";
        public static final String EVENT = "event";
        public static final String RESULT = "result";
    }

    public interface WidgetDragEventCallBack {
        void onCancelWidgetDrag();

        void onWidgetDropResult(boolean z10);

        void onWidgetDropStart();
    }

    public static Bundle parseCancelDragEvent() {
        return parseEvent(Event.CANCEL_DRAG);
    }

    public static Bundle parseDropResultEvent(boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putString("event", Event.DROP_RESULT);
        bundle.putBoolean("result", z10);
        return bundle;
    }

    private static Bundle parseEvent(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("event", str);
        return bundle;
    }

    public static Bundle parseGetDragEvent(int i10) {
        Bundle bundle = new Bundle();
        bundle.putString("event", Event.GET_DRAG_EVENT);
        bundle.putInt(Key.DRAG_EVENT_TYPE, i10);
        return bundle;
    }

    public static Bundle parseStartDropEvent() {
        return parseEvent(Event.DROP_START);
    }

    public static Bundle parseWidgetDragEnableEvent() {
        return parseEvent(Event.GET_WIDGET_DRAG_ENABLE);
    }
}
