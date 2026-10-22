package com.android.server.am;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public interface IProcessStatsServiceOptEx {
    default void init(ProcessStatsService service) {
    }

    default void pendingCommit() {
    }

    default void saveData(Parcel data) {
    }

    default void addNativeMemUsage(String name, int uid, int pid, long pss, long uss, long rss) {
    }

    default void saveDataDaily() {
    }
}
