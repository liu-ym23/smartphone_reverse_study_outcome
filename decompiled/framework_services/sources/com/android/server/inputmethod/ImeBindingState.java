package com.android.server.inputmethod;

import android.os.IBinder;
import android.util.Printer;
import android.util.proto.ProtoOutputStream;
import android.view.inputmethod.EditorInfo;
import com.android.internal.inputmethod.InputMethodDebug;
import com.android.server.am.ProcessList;
import com.android.server.wm.WindowManagerInternal;

/* JADX INFO: loaded from: classes2.dex */
final class ImeBindingState {
    final IBinder mFocusedWindow;
    final ClientState mFocusedWindowClient;
    final EditorInfo mFocusedWindowEditorInfo;
    final int mFocusedWindowSoftInputMode;
    final int mUserId;

    void dumpDebug(ProtoOutputStream proto, WindowManagerInternal windowManagerInternal) {
        proto.write(1138166333444L, windowManagerInternal.getWindowName(this.mFocusedWindow));
        proto.write(1138166333446L, InputMethodDebug.softInputModeToString(this.mFocusedWindowSoftInputMode));
    }

    void dump(Printer p, String prefix) {
        p.println(prefix + "mFocusedWindow=" + this.mFocusedWindow);
        p.println(prefix + "mFocusedWindowSoftInputMode=" + InputMethodDebug.softInputModeToString(this.mFocusedWindowSoftInputMode));
        p.println(prefix + "mFocusedWindowClient=" + this.mFocusedWindowClient);
    }

    static ImeBindingState newEmptyState() {
        return new ImeBindingState(ProcessList.INVALID_ADJ, null, 0, null, null);
    }

    ImeBindingState(int userId, IBinder focusedWindow, int focusedWindowSoftInputMode, ClientState focusedWindowClient, EditorInfo focusedWindowEditorInfo) {
        this.mUserId = userId;
        this.mFocusedWindow = focusedWindow;
        this.mFocusedWindowSoftInputMode = focusedWindowSoftInputMode;
        this.mFocusedWindowClient = focusedWindowClient;
        this.mFocusedWindowEditorInfo = focusedWindowEditorInfo;
    }
}
