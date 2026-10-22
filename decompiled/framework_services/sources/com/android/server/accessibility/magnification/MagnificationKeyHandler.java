package com.android.server.accessibility.magnification;

import android.view.KeyEvent;
import com.android.server.accessibility.BaseEventStreamTransformation;

/* JADX INFO: loaded from: classes.dex */
public class MagnificationKeyHandler extends BaseEventStreamTransformation {
    protected final Callback mCallback;
    private boolean mIsKeyboardInteracting;

    public interface Callback {
        void onKeyboardInteractionStop();

        void onPanMagnificationStart(int r1, int r2);

        void onPanMagnificationStop(int r1);

        void onScaleMagnificationStart(int r1, int r2);

        void onScaleMagnificationStop(int r1);
    }

    public MagnificationKeyHandler(Callback callback) {
        this.mIsKeyboardInteracting = false;
        this.mCallback = callback;
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void onKeyEvent(KeyEvent event, int policyFlags) {
        int panDirection = 0;
        if (event.isAltPressed() == true) goto L5;
    L7:
        boolean modifiersPressed = false;
    L8:
        if (modifiersPressed == true) goto L14;
        super.onKeyEvent(event, policyFlags);
        if (this.mIsKeyboardInteracting == false) goto L50;
        this.mCallback.onKeyboardInteractionStop();
        this.mIsKeyboardInteracting = false;
        return;
    L50:
        return;
    L14:
        if (event.getAction() != 0) goto L16;
        boolean isDown = true;
    L17:
        int keyCode = event.getKeyCode();
        if (keyCode != 21) goto L20;
    L40:
        switch(keyCode) {
            case 19: goto L44;
            case 20: goto L41;
            case 21: goto L46;
            case 22: goto L42;
            default: goto L41;
        };
    L41:
        panDirection = 3;
        goto L46
    L42:
        panDirection = 1;
        goto L46
    L44:
        panDirection = 2;
    L46:
        if (isDown == false) goto L48;
        this.mCallback.onPanMagnificationStart(getDisplayId(event), panDirection);
        this.mIsKeyboardInteracting = true;
        return;
    L48:
        this.mCallback.onPanMagnificationStop(panDirection);
        return;
    L20:
        if (keyCode == 22) goto L40;
        if (keyCode == 19) goto L40;
        if (keyCode == 20) goto L40;
        if (keyCode != 70) goto L29;
    L33:
        int zoomDirection = 1;
        if (keyCode != 70) goto L36;
        zoomDirection = 0;
    L36:
        if (isDown == false) goto L38;
        this.mCallback.onScaleMagnificationStart(getDisplayId(event), zoomDirection);
        this.mIsKeyboardInteracting = true;
        return;
    L38:
        this.mCallback.onScaleMagnificationStop(zoomDirection);
        return;
    L29:
        if (keyCode == 69) goto L33;
        super.onKeyEvent(event, policyFlags);
        return;
    L16:
        isDown = false;
        goto L17
    L5:
        if (event.isMetaPressed() == false) goto L7;
        modifiersPressed = true;
        goto L8
    }

    private int getDisplayId(KeyEvent event) {
        if (event.getDisplayId() != (-1)) goto L5;
        return 0;
    L5:
        return event.getDisplayId();
    }
}
