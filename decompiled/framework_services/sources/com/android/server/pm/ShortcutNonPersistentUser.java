package com.android.server.pm;

import android.util.ArrayMap;
import android.util.ArraySet;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class ShortcutNonPersistentUser {
    private final ArraySet<String> mHostPackageSet;
    private final ArrayMap<String, String> mHostPackages;
    private final int mUserId;

    public ShortcutNonPersistentUser(int userId) {
        this.mHostPackages = new ArrayMap();
        this.mHostPackageSet = new ArraySet();
        this.mUserId = userId;
    }

    public int getUserId() {
        return this.mUserId;
    }

    public void setShortcutHostPackage(String type, String packageName) {
        if (packageName == null) goto L4;
        this.mHostPackages.put(type, packageName);
    L5:
        this.mHostPackageSet.clear();
        int i = 0;
    L7:
        if (i >= this.mHostPackages.size()) goto L10;
        this.mHostPackageSet.add(this.mHostPackages.valueAt(i));
        i = i + 1;
        goto L7
    L10:
        return;
    L4:
        this.mHostPackages.remove(type);
        goto L5
    }

    public boolean hasHostPackage(String packageName) {
        return this.mHostPackageSet.contains(packageName);
    }

    public void dump(PrintWriter pw, String prefix, ShortcutService.DumpFilter filter) {
        if (filter.shouldDumpDetails() == true) goto L5;
        return;
    L5:
        if (this.mHostPackages.size() <= 0) goto L14;
        pw.print(prefix);
        pw.print("Non-persistent: user ID:");
        pw.println(this.mUserId);
        pw.print(prefix);
        pw.println("  Host packages:");
        int i = 0;
    L8:
        if (i >= this.mHostPackages.size()) goto L10;
        pw.print(prefix);
        pw.print("    ");
        pw.print(this.mHostPackages.keyAt(i));
        pw.print(": ");
        pw.println(this.mHostPackages.valueAt(i));
        i = i + 1;
        goto L8
    L10:
        pw.println();
        return;
    }
}
