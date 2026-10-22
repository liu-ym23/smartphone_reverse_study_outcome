package com.android.server.appop;

import android.os.PackageTagsList;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public interface AppOpsRestrictions {

    public interface AppOpsRestrictionRemovedListener {
        void onAppOpsRestrictionRemoved(int r1);
    }

    boolean clearGlobalRestrictions(Object r1);

    boolean clearUserRestrictions(Object r1);

    boolean clearUserRestrictions(Object r1, Integer r2);

    void dumpRestrictions(PrintWriter r1, int r2, String r3, boolean r4);

    boolean getGlobalRestriction(Object r1, int r2);

    boolean getUserRestriction(Object r1, int r2, int r3, String r4, String r5, boolean r6);

    PackageTagsList getUserRestrictionExclusions(Object r1, int r2);

    boolean hasGlobalRestrictions(Object r1);

    boolean hasUserRestrictions(Object r1);

    boolean setGlobalRestriction(Object r1, int r2, boolean r3);

    boolean setUserRestriction(Object r1, int r2, int r3, boolean r4, PackageTagsList r5);
}
