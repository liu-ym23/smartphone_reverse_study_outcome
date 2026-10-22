package com.android.server.pm;

import android.content.pm.SharedLibraryInfo;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.SharedLibraryWrapper;
import com.android.server.utils.WatchedLongSparseArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class SharedLibraryUtils {
    SharedLibraryUtils() {
    }

    public static boolean addSharedLibraryToPackageVersionMap(Map<String, WatchedLongSparseArray<SharedLibraryInfo>> target, SharedLibraryInfo library) {
        String name = library.getName();
        if (target.containsKey(name) == true) goto L5;
        target.put(name, new WatchedLongSparseArray());
    L11:
        target.get(name).put(library.getLongVersion(), library);
        return true;
    L5:
        if (library.getType() == 2) goto L8;
        return false;
    L8:
        if (target.get(name).indexOfKey(library.getLongVersion()) < 0) goto L11;
        return false;
    }

    public static SharedLibraryInfo getSharedLibraryInfo(String name, long version, Map<String, WatchedLongSparseArray<SharedLibraryInfo>> existingLibraries, Map<String, WatchedLongSparseArray<SharedLibraryInfo>> newLibraries) {
        if (newLibraries == null) goto L8;
        WatchedLongSparseArray<SharedLibraryInfo> versionedLib = newLibraries.get(name);
        SharedLibraryInfo info = null;
        if (versionedLib == null) goto L6;
        SharedLibraryInfo info2 = versionedLib.get(version);
        info = info2;
    L6:
        if (info == null) goto L8;
        return info;
    L8:
        WatchedLongSparseArray<SharedLibraryInfo> versionedLib2 = existingLibraries.get(name);
        if (versionedLib2 != null) goto L13;
        return null;
    L13:
        return versionedLib2.get(version);
    }

    public static List<SharedLibraryInfo> findSharedLibraries(PackageStateInternal pkgSetting) {
        if (pkgSetting.getTransientState().getUsesLibraryInfos().isEmpty() == true) goto L10;
        ArrayList<SharedLibraryInfo> retValue = new ArrayList();
        Set<String> collectedNames = new HashSet();
        Iterator<SharedLibraryWrapper> r2 = pkgSetting.getTransientState().getUsesLibraryInfos().iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        SharedLibraryWrapper info = r2.next();
        findSharedLibrariesRecursive(info.getInfo(), retValue, collectedNames);
        goto L6
    L8:
        return retValue;
    L10:
        return Collections.emptyList();
    }

    private static void findSharedLibrariesRecursive(SharedLibraryInfo info, ArrayList<SharedLibraryInfo> collected, Set<String> collectedNames) {
        if (collectedNames.contains(info.getName()) == true) goto L10;
        collectedNames.add(info.getName());
        collected.add(info);
        if (info.getDependencies() == null) goto L12;
        Iterator r0 = info.getDependencies().iterator();
    L8:
        if (r0.hasNext() == false) goto L13;
        SharedLibraryInfo dep = (SharedLibraryInfo) r0.next();
        findSharedLibrariesRecursive(dep, collected, collectedNames);
        goto L8
    L13:
        return;
    L12:
        return;
    }
}
