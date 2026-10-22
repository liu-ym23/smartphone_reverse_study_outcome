package com.android.server.am;

import android.content.pm.ApplicationInfo;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public interface IZswProcessErrorStateRecord {
    void appNotResponding(String r1, ProcessRecord r2, ApplicationInfo r3);

    void renameTraceName(File r1, ProcessRecord r2, int r3);

    boolean shouldDoDump(ArrayList<Integer> r1, ProcessRecord r2, ProcessRecord r3, boolean r4);
}
