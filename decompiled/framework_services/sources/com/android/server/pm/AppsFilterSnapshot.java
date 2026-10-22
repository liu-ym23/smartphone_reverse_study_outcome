package com.android.server.pm;

import android.util.ArrayMap;
import android.util.SparseArray;
import com.android.internal.util.function.QuadFunction;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.snapshot.PackageDataSnapshot;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public interface AppsFilterSnapshot {
    boolean canQueryPackage(AndroidPackage r1, String r2);

    void dumpQueries(PrintWriter r1, Integer r2, DumpState r3, int[] r4, QuadFunction<Integer, Integer, Integer, Boolean, String[]> r5);

    SparseArray<int[]> getVisibilityAllowList(PackageDataSnapshot r1, PackageStateInternal r2, int[] r3, ArrayMap<String, ? extends PackageStateInternal> r4);

    boolean shouldFilterApplication(PackageDataSnapshot r1, int r2, Object r3, PackageStateInternal r4, int r5);
}
