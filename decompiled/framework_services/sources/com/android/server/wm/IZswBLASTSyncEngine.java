package com.android.server.wm;

import android.util.ArraySet;
import android.util.Slog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public interface IZswBLASTSyncEngine {
    static void printWindowContainers(ArraySet<WindowContainer> rootMembers) {
        int i = rootMembers.size() - 1;
    L3:
        if (i < 0) goto L6;
        WindowContainer<?> wc = rootMembers.valueAt(i);
        Slog.w("DEBU_WC", "WindowContainer[" + i + "]: " + wc);
        i = i + (-1);
        goto L3
    }

    static void printDependencySyncGroup(ArrayList<BLASTSyncEngine.SyncGroup> mDependencies) {
        int i = mDependencies.size() - 1;
    L3:
        if (i < 0) goto L6;
        Slog.w("DEBU_WC", "Dependency[" + i + "] mSyncId = " + mDependencies.get(i).mSyncId);
        printWindowContainers(mDependencies.get(i).mRootMembers);
        i = i + (-1);
        goto L3
    }
}
