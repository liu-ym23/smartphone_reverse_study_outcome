package com.android.server.wm;

import android.os.Looper;
import android.util.Slog;
import android.view.InputChannel;
import android.view.InputEvent;
import android.view.InputEventReceiver;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes3.dex */
class DragInputEventReceiver extends InputEventReceiver {
    private final DragDropController mDragDropController;
    private boolean mIsStartEvent;
    private boolean mMuteInput;
    private boolean mStylusButtonDownAtStart;

    DragInputEventReceiver(InputChannel inputChannel, Looper looper, DragDropController controller) {
        super(inputChannel, looper);
        this.mIsStartEvent = true;
        this.mMuteInput = false;
        this.mDragDropController = controller;
    }

    public void onInputEvent(InputEvent event) {
        boolean handled = false;
    L19:
        e = move-exception;
        Slog.e("WindowManager", "Exception caught by drag handleMotion", e);     // Catch: Throwable -> L17
    L46:
        finishInputEvent(event, handled);
        return;
    L4:
        if ((event instanceof MotionEvent) == true) goto L6;
    L52:
        finishInputEvent(event, false);
        return;
    L6:
        if ((event.getSource() & 2) == 0) goto L52;
        if (this.mMuteInput == true) goto L52;
        MotionEvent motionEvent = (MotionEvent) event;     // Catch: Throwable -> L17 Exception -> L19
        int displayId = motionEvent.getDisplayId();     // Catch: Throwable -> L17 Exception -> L19
        float newX = motionEvent.getRawX();     // Catch: Throwable -> L17 Exception -> L19
        float newY = motionEvent.getRawY();     // Catch: Throwable -> L17 Exception -> L19
        boolean r7 = false;
        if ((motionEvent.getButtonState() & 32) == 0) goto L13;
        boolean isStylusButtonDown = true;
    L15:
        if (this.mIsStartEvent == false) goto L23;
        this.mStylusButtonDownAtStart = isStylusButtonDown;     // Catch: Throwable -> L17 Exception -> L19
        this.mIsStartEvent = false;     // Catch: Throwable -> L17 Exception -> L19
    L23:
        switch(motionEvent.getAction()) {
            case 0: goto L48;
            case 1: goto L38;
            case 2: goto L31;
            case 3: goto L27;
            default: goto L24;
        };
    L24:
        finishInputEvent(event, false);
        return;
    L27:
        if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L29;
        Slog.d("WindowManager", "Drag cancelled!");     // Catch: Throwable -> L17 Exception -> L19
    L29:
        this.mMuteInput = true;     // Catch: Throwable -> L17 Exception -> L19
    L41:
        DragDropController r9 = this.mDragDropController;     // Catch: Throwable -> L17 Exception -> L19
        if (this.mMuteInput == true) goto L44;
        r7 = true;
    L44:
        r9.handleMotionEvent(r7, displayId, newX, newY);     // Catch: Throwable -> L17 Exception -> L19
        handled = true;
        goto L46
    L31:
        if (this.mStylusButtonDownAtStart == false) goto L41;
        if (isStylusButtonDown == true) goto L41;
        if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L36;
        Slog.d("WindowManager", "Button no longer pressed; dropping at " + newX + "," + newY);     // Catch: Throwable -> L17 Exception -> L19
    L36:
        this.mMuteInput = true;     // Catch: Throwable -> L17 Exception -> L19
        goto L41
    L38:
        if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L40;
        Slog.d("WindowManager", "Got UP on move channel; dropping at " + newX + "," + newY);     // Catch: Throwable -> L17 Exception -> L19
    L40:
        this.mMuteInput = true;     // Catch: Throwable -> L17 Exception -> L19
        goto L41
    L48:
        if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L50;
        Slog.w("WindowManager", "Unexpected ACTION_DOWN in drag layer");     // Catch: Throwable -> L17 Exception -> L19
    L50:
        finishInputEvent(event, false);
        return;
    L13:
        isStylusButtonDown = false;
    L17:
        th = move-exception;
        finishInputEvent(event, false);
        throw th;
    }
}
