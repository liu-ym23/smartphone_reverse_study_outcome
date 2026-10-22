package com.android.server.connectivity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.mifavor.MFVUtils;
import android.net.NetworkInfo;
import android.os.Binder;
import android.os.Process;
import android.util.Range;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
public interface IZswVpn {
    public static final String TAG = "IZswVpn";

    void updateState(int r1, NetworkInfo.DetailedState r2);

    static void appendUid_DoubleLay(Context context, String app, int userId, SortedSet<Integer> uids) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == false) goto L12;
        if (userId != 0) goto L13;
        int uid = getAppUid(context, app, 999);
        if (uid == (-1)) goto L9;
        uids.add(Integer.valueOf(uid));
    L9:
        if (Process.isApplicationUid(uid) == false) goto L14;
        uids.add(Integer.valueOf(Process.toSdkSandboxUid(uid)));
        return;
    L14:
        return;
    L13:
        return;
    }

    static void appendUidRangeForDoubleLay(Set<Range<Integer>> ranges, int userId) {
        if (MFVUtils.MFV_FEATURE_DOUBLEAPP == false) goto L7;
        if (userId != 0) goto L8;
        ranges.add(Vpn.createUidRangeForUser(999));
        return;
    L8:
        return;
    }

    private static int getAppUid(Context context, String app, int userId) {
        if ("[Legacy VPN]".equals(app) == true) goto L5;
        PackageManager pm = context.getPackageManager();
        long token = Binder.clearCallingIdentity();
        int r3 = pm.getPackageUidAsUser(app, userId);     // Catch: Throwable -> L10 PackageManager.NameNotFoundException -> L13
        Binder.restoreCallingIdentity(token);
        return r3;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L14:
        Binder.restoreCallingIdentity(token);
        return -1;
    L5:
        return Process.myUid();
    }
}
