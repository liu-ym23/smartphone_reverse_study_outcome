package com.stepos.launcher.assistant.widgetdrag;

import android.view.DragEvent;
import com.stepos.launcher.assistant.widgetdrag.DragBundleParser;

/* loaded from: classes.dex */
public interface IOverlayWidgetCallBack extends DragBundleParser.WidgetDragEventCallBack {
    default boolean isAssistantWidgetDragEnable() {
        return true;
    }

    DragEvent onGetDragEvent(int i10);
}
