package com.android.server.wm;

import android.content.ClipData;
import android.content.ClipDescription;

/* JADX INFO: loaded from: classes3.dex */
public interface IZswDragState {
    boolean isFloatAssistExcludeDrop(WindowState r1, boolean r2, ClipDescription r3);

    boolean isNotifiedWindowsExceedLimit(int r1);

    void notifyTranslateDataToTS(float r1, float r2, boolean r3, ClipDescription r4, float r5, ClipData r6);
}
