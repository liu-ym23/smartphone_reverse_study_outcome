package com.android.server.wm;

import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes3.dex */
public interface IObricActivityAssistInfo extends IObricBase {
    default int getWindowMode() {
        return 0;
    }

    default void setWindowMode(int mode) {
    }
}
