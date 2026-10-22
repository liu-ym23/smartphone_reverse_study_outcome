package com.android.server.game;

import android.hardware.input.IInputKeyboardMouseActionChangeListener;
import android.view.InputEvent;
import com.zte.game.keymouse.KeyMouseMapInfo;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class KeyMouseStub {
    private static final String TAG = "KeyMouseStub";

    @FunctionalInterface
    public interface SetMouseMode {
        void accept(int r1);
    }

    @FunctionalInterface
    public interface SetMousePointerPosAndRange {
        void accept(int r1, int r2, int r3);
    }

    @FunctionalInterface
    public interface SetPointerPosition {
        void accept(int r1, int r2);
    }

    @FunctionalInterface
    public interface SetSensitivity {
        void accept(float r1);
    }

    public KeyMouseStub() {
    }

    public void setPointerPositionFunction(SetPointerPosition function) {
    }

    public void setSensitivityFunction(SetSensitivity function) {
    }

    public void setMouseModeFunction(SetMouseMode function) {
    }

    public void setMousePointerPosAndRangeFunction(SetMousePointerPosAndRange function) {
    }

    public boolean handleExtendInputEvent(InputEvent event, int policyFlags) {
        return false;
    }

    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
    }

    public void setKeyMouseMapInfo(KeyMouseMapInfo info) {
    }

    public void registerInputKeyboardMouseActionChangeListener(IInputKeyboardMouseActionChangeListener listener) {
    }

    public void unregisterInputKeyboardMouseActionChangeListener(IInputKeyboardMouseActionChangeListener listener) {
    }
}
