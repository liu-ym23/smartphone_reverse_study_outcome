package com.android.server.input;

import android.graphics.PointF;
import android.hardware.display.DisplayTopologyGraph;
import android.hardware.display.DisplayViewport;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseBooleanArray;
import android.view.InputChannel;
import android.view.inputmethod.InputMethodSubtype;
import com.android.internal.inputmethod.InputMethodSubtypeHandle;
import com.android.internal.policy.IShortcutService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InputManagerInternal {
    public static final int BACKUP_CATEGORY_INPUT_GESTURES = 0;

    public interface AccessibilityPointerMotionFilter {
        float[] filterPointerMotionEvent(float r1, float r2, float r3, float r4, int r5);
    }

    public @interface BackupCategory {
    }

    public interface LidSwitchCallback {
        void notifyLidSwitchChanged(long r1, boolean r3);
    }

    public abstract void addKeyboardLayoutAssociation(String r1, String r2, String r3);

    public abstract void applyBackupPayload(Map<Integer, byte[]> r1, int r2) throws XmlPullParserException, IOException;

    public abstract InputChannel createInputChannel(String r1);

    public abstract void decrementKeyboardBacklight(int r1);

    public abstract Map<Integer, byte[]> getBackupPayload(int r1) throws IOException;

    public abstract PointF getCursorPosition(int r1);

    public abstract int getLastUsedInputDeviceId();

    public abstract void handleKeyGestureInKeyGestureController(int r1, int[] r2, int r3, int r4);

    public abstract void incrementKeyboardBacklight(int r1);

    public abstract void notifyInputMethodConnectionActive(boolean r1);

    public abstract void notifyKeyGestureCompleted(int r1, int[] r2, int r3, int r4);

    public abstract void notifyUserActivity();

    public abstract void onInputMethodSubtypeChangedForKeyboardLayoutMapping(int r1, InputMethodSubtypeHandle r2, InputMethodSubtype r3);

    public abstract void pilferPointers(IBinder r1);

    public abstract void registerAccessibilityPointerMotionFilter(AccessibilityPointerMotionFilter r1);

    public abstract void registerLidSwitchCallback(LidSwitchCallback r1);

    public abstract void registerShortcutKey(long r1, IShortcutService r3) throws RemoteException;

    public abstract void removeKeyboardLayoutAssociation(String r1);

    public abstract void setAccessibilityPointerIconScaleFactor(int r1, float r2);

    public abstract void setCurrentUser(int r1);

    public abstract void setDisplayEligibilityForPointerCapture(int r1, boolean r2);

    public abstract void setDisplayInteractivities(SparseBooleanArray r1);

    public abstract void setDisplayTopology(DisplayTopologyGraph r1);

    public abstract void setDisplayViewports(List<DisplayViewport> r1);

    public abstract boolean setKernelWakeEnabled(int r1, boolean r2);

    public abstract void setMouseScalingEnabled(boolean r1, int r2);

    public abstract void setPointerIconVisible(boolean r1, int r2);

    public abstract void setPulseGestureEnabled(boolean r1);

    public abstract void setStylusButtonMotionEventsEnabled(boolean r1);

    public abstract void setTypeAssociation(String r1, String r2);

    public abstract void toggleCapsLock(int r1);

    public abstract boolean transferTouchGesture(IBinder r1, IBinder r2, boolean r3);

    public abstract void unregisterLidSwitchCallback(LidSwitchCallback r1);

    public abstract void unsetTypeAssociation(String r1);

    public InputManagerInternal() {
    }

    public IObricInputManagerService getObricExt() {
        return null;
    }
}
