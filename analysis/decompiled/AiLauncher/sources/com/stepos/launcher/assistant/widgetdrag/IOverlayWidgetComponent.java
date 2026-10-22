package com.stepos.launcher.assistant.widgetdrag;

import android.os.Bundle;
import com.stepos.launcher.client.libraries.ILauncherWidgetDragCallback;

/* loaded from: classes.dex */
public interface IOverlayWidgetComponent {
    Bundle onReceiveWidgetDragBundle(Bundle bundle);

    void setWidgetDragProxyCallbacks(ILauncherWidgetDragCallback iLauncherWidgetDragCallback);
}
