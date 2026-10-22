package com.android.server.appop;

import android.util.SparseBooleanArray;
import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes.dex */
public interface AppOpsCheckingServiceInterface {

    public interface AppOpsModeChangedListener {
        void onPackageModeChanged(String r1, int r2, int r3, int r4);

        void onUidModeChanged(int r1, int r2, int r3, String r4);
    }

    boolean addAppOpsModeChangedListener(AppOpsModeChangedListener r1);

    void clearAllModes();

    SparseBooleanArray getForegroundOps(int r1, String r2);

    SparseBooleanArray getForegroundOps(String r1, int r2);

    SparseIntArray getNonDefaultPackageModes(String r1, int r2);

    SparseIntArray getNonDefaultUidModes(int r1, String r2);

    int getPackageMode(String r1, int r2, int r3);

    int getUidMode(int r1, String r2, int r3);

    void readState();

    boolean removeAppOpsModeChangedListener(AppOpsModeChangedListener r1);

    boolean removePackage(String r1, int r2);

    void removeUid(int r1);

    void setPackageMode(String r1, int r2, int r3, int r4);

    boolean setUidMode(int r1, String r2, int r3, int r4);

    void shutdown();

    void systemReady();

    void writeState();
}
