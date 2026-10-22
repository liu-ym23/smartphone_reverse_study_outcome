package com.android.server.am;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface ICachedAppOptimizerOptEx {
    default CachedAppOptimizer.CompactProfile downgradeCompactIfNecessary(ProcessRecord app, CachedAppOptimizer.CompactProfile requestedProfile) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return requestedProfile;
    }

    default int downgradeCompactIfNecessary(ProcessRecord app, int requestedAction) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }
}
