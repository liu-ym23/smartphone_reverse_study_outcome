package com.android.server.wm;

import android.util.proto.ProtoOutputStream;

/* JADX INFO: loaded from: classes3.dex */
interface InputTarget extends InsetsTarget {
    boolean canScreenshotIme();

    void dumpProto(ProtoOutputStream r1, long r2, int r4);

    ActivityRecord getActivityRecord();

    DisplayContent getDisplayContent();

    int getDisplayId();

    InsetsControlTarget getImeControlTarget();

    int getPid();

    int getUid();

    WindowState getWindowState();

    void handleTapOutsideFocusInsideSelf();

    void handleTapOutsideFocusOutsideSelf();

    boolean isInputMethodClientFocus(int r1, int r2);

    boolean receiveFocusFromTapOutside();

    boolean shouldControlIme();
}
