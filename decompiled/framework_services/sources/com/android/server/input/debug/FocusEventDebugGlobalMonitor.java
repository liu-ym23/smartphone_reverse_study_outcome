package com.android.server.input.debug;

import android.view.InputEvent;
import android.view.InputEventReceiver;
import android.view.MotionEvent;
import com.android.server.UiThread;
import com.android.server.input.InputManagerService;

/* JADX INFO: loaded from: classes2.dex */
class FocusEventDebugGlobalMonitor extends InputEventReceiver {
    private final FocusEventDebugView mDebugView;

    FocusEventDebugGlobalMonitor(FocusEventDebugView debugView, InputManagerService service) {
        super(service.monitorInput("FocusEventDebugGlobalMonitor", 0), UiThread.getHandler().getLooper());
        this.mDebugView = debugView;
    }

    public void onInputEvent(InputEvent event) {
    L7:
        th = move-exception;
        finishInputEvent(event, false);
        throw th;
    L4:
        if ((event instanceof MotionEvent) == false) goto L9;
        this.mDebugView.reportMotionEvent((MotionEvent) event);     // Catch: Throwable -> L7
    L9:
        finishInputEvent(event, false);
    }
}
