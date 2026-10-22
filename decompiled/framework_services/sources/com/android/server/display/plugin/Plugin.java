package com.android.server.display.plugin;

import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public interface Plugin {
    void dump(PrintWriter r1);

    void onBootCompleted();
}
