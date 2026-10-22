package com.android.server;

import android.content.Context;
import android.os.IVold;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public interface IZswStorageManagerService {
    void createFstrimLogFile(File r1);

    void runZteIdleMaint(IVold r1, Runnable r2, int r3, int r4, int r5);

    boolean shouldTrimZte(Context r1);

    void writeFstrimLogFile(String r1);
}
