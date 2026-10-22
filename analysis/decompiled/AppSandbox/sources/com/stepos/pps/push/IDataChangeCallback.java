package com.stepos.pps.push;

import java.io.PrintWriter;

/* loaded from: classes.dex */
public interface IDataChangeCallback {
    public static final int BROADCAST_OPTIMIZATION = 1;

    void dataChange(int i, Object obj);

    void functionDump(PrintWriter printWriter);
}
