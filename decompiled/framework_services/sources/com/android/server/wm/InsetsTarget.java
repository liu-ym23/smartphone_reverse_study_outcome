package com.android.server.wm;

import android.os.IBinder;

/* JADX INFO: loaded from: classes3.dex */
public interface InsetsTarget {
    int getRequestedVisibleTypes();

    IBinder getWindowToken();

    boolean isRequestedVisible(int r1);
}
