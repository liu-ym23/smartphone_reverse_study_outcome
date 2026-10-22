package com.android.server.wm;

import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes3.dex */
public interface IObricWindowContainer extends IObricBase {
    default boolean inObricVirtualDisplay() {
        return false;
    }

    default DisplayContent getTopFocusedDisplayContent(int displayId) {
        return null;
    }
}
