package com.android.server.wm;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes3.dex */
public interface IZswWindowManagerInternal {
    boolean IsUidShowingFloatWindow(int r1);

    int getWindowVisibleBounds(String r1, Rect[] r2, int r3);

    boolean getWindowVisibleBounds(String r1, Rect r2);
}
