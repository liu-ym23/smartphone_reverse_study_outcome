package com.android.server.compilemonitor;

import android.content.Context;
import com.android.server.SystemServiceManager;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public interface ICompileMonitorService {
    default boolean startIfNeeded(SystemServiceManager systemServiceManager, Context context) {
        return false;
    }

    default boolean dumpState(PrintWriter pw) {
        return false;
    }

    default boolean dumpStore(PrintWriter pw, int limit) {
        return false;
    }
}
