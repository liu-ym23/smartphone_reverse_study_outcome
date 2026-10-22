package com.android.server.pm;

import android.util.Slog;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: compiled from: SELinuxMMAC.java */
/* JADX INFO: loaded from: classes2.dex */
final class PolicyComparator implements Comparator<Policy> {
    private boolean duplicateFound;

    PolicyComparator() {
        this.duplicateFound = false;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Policy r1, Policy r2) {
        return compare2(r1, r2);
    }

    public boolean foundDuplicate() {
        return this.duplicateFound;
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(Policy p1, Policy p2) {
        if (p1.hasInnerPackages() == p2.hasInnerPackages()) goto L9;
        if (p1.hasInnerPackages() == false) goto L18;
        return -1;
    L18:
        return 1;
    L9:
        if (p1.getSignatures().equals(p2.getSignatures()) == true) goto L11;
        return 0;
    L11:
        if (p1.hasGlobalSeinfo() == false) goto L13;
        this.duplicateFound = true;
        Slog.e("SELinuxMMAC", "Duplicate policy entry: " + p1.toString());
    L13:
        Map<String, String> p1Packages = p1.getInnerPackages();
        Map<String, String> p2Packages = p2.getInnerPackages();
        if (Collections.disjoint(p1Packages.keySet(), p2Packages.keySet()) == true) goto L20;
        this.duplicateFound = true;
        Slog.e("SELinuxMMAC", "Duplicate policy entry: " + p1.toString());
        return 0;
    L20:
        return 0;
    }
}
