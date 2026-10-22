package com.android.server.am;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class ZswNetworkAlignManagerInternal {
    public abstract int getNetworkAlignTimeFiveMin();

    public abstract int getNetworkAlignTimeNoneMin();

    public abstract int getNetworkAlignTimeOneMin();

    public abstract int getUidAlignType(int r1);

    public abstract boolean networkAlignEnable();

    public abstract void releaseAllBlackedUids();

    public abstract void releaseNetworkLimitUids(ArrayList<Integer> r1, int r2, int r3);

    public abstract void setNetworkLimitUidList(ArrayList<Integer> r1, int r2, int r3);

    public ZswNetworkAlignManagerInternal() {
    }
}
