package com.android.server;

import com.zte.performance.defend.DefendManager;
import com.zte.performance.defend.ZteHprofDumpHelper;

/* JADX INFO: loaded from: classes.dex */
public interface IZswWatchdog {
    static void run() {
        if (DefendManager.ZTE_FEATURE_DEFEND == true) goto L5;
        return;
    L5:
        if (ZteHprofDumpHelper.shouldDumpHProfile() == true) goto L7;
        return;
    L7:
        if (ZteHprofDumpHelper.needDumpWhenThreshold() == false) goto L12;
        ZteHprofDumpHelper.dumpHprof();
        return;
    }
}
