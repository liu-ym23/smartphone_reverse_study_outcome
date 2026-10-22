package com.android.server.appop;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface AppOpMigrationHelper {
    Map<Integer, Map<String, Integer>> getLegacyAppIdAppOpModes(int r1);

    int getLegacyAppOpVersion();

    Map<String, Map<String, Integer>> getLegacyPackageAppOpModes(int r1);

    boolean hasLegacyAppOpState();
}
