package com.android.server.am;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public interface IResMngService {
    void systemReady(ActivityManagerService r1);

    default void dump(PrintWriter pw, String[] args) {
    }

    default void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
    }
}
