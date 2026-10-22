package com.android.server.display;

import android.hardware.display.DisplayTopology;

/* JADX INFO: loaded from: classes2.dex */
interface DisplayTopologyStore {
    void reloadTopologies(int r1);

    DisplayTopology restoreTopology(DisplayTopology r1);

    boolean saveTopology(DisplayTopology r1);
}
