package com.bytedance.crash.dumper;

import java.io.File;

/* JADX INFO: compiled from: RepairInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class p {
    public static void a(File r2) {
        com.bytedance.crash.k.a.b(2, new File(r2, "signal_monitor.txt").getAbsolutePath());     // Catch: Throwable -> L4
        return;
    }
}
