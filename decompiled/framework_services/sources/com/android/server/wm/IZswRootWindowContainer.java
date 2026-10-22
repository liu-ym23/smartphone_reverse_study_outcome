package com.android.server.wm;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes3.dex */
public interface IZswRootWindowContainer {
    int getWindowVisibleBounds(RootWindowContainer r1, String r2, Rect[] r3, int r4);

    boolean getWindowVisibleBounds(RootWindowContainer r1, String r2, Rect r3);

    boolean isZteAnyNonToastWindowVisibleForUid(int r1);

    void startHomeOnTaskDisplayArea();
}
