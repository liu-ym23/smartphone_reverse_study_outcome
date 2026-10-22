package com.stepos.launcher.assistant.widgetdrag;

import android.view.DragEvent;

/* loaded from: classes.dex */
public interface IOverlayAssistantCallBack {
    DragEvent getDragEvent(int i10);

    boolean isLauncherWidgetDragEnable();

    void sendDropWidgetResult(boolean z10);

    void sendWidgetDropStart();
}
