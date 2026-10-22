package com.android.server.pm;

import android.util.ArrayMap;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class PendingPackageBroadcasts {
    private final Object mLock;
    final SparseArray<ArrayMap<String, ArrayList<String>>> mUidMap;

    /* JADX INFO: renamed from: $r8$lambda$9nG6-eBrPYjz2uZJRNRLXlBSuy4, reason: not valid java name */
    public static /* synthetic */ ArrayList m6878$r8$lambda$9nG6eBrPYjz2uZJRNRLXlBSuy4(String r0) {
        return lambda$getOrAllocate$0(r0);
    }

    public PendingPackageBroadcasts() {
        this.mLock = new PackageManagerTracedLock();
        this.mUidMap = new SparseArray(2);
    }

    public boolean hasPackage(int userId, String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayMap<String, ArrayList<String>> packages = this.mUidMap.get(userId);     // Catch: Throwable -> L9
        if (packages != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (packages.containsKey(packageName) == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    public void put(int userId, String packageName, ArrayList<String> components) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayMap<String, ArrayList<String>> packages = getOrAllocate(userId);     // Catch: Throwable -> L7
        packages.put(packageName, components);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addComponent(int userId, String packageName, String componentClassName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList<String> components = getOrAllocate(userId, packageName);     // Catch: Throwable -> L7
        if (components.contains(componentClassName) == true) goto L9;
        components.add(componentClassName);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addComponents(int userId, String packageName, List<String> componentClassNames) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList<String> components = getOrAllocate(userId, packageName);     // Catch: Throwable -> L10
        int index = 0;
    L6:
        if (index >= componentClassNames.size()) goto L14;
        String componentClassName = componentClassNames.get(index);     // Catch: Throwable -> L10
        if (components.contains(componentClassName) == true) goto L12;
        components.add(componentClassName);     // Catch: Throwable -> L10
    L12:
        index = index + 1;     // Catch: Throwable -> L10
        goto L6
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void remove(int userId, String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayMap<String, ArrayList<String>> packages = this.mUidMap.get(userId);     // Catch: Throwable -> L7
        if (packages == null) goto L9;
        packages.remove(packageName);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void remove(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUidMap.remove(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public SparseArray<ArrayMap<String, ArrayList<String>>> copiedMap() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        SparseArray<ArrayMap<String, ArrayList<String>>> copy = new SparseArray();     // Catch: Throwable -> L11
        int userIdIndex = 0;
    L6:
        if (userIdIndex >= this.mUidMap.size()) goto L15;
        ArrayMap<String, ArrayList<String>> packages = this.mUidMap.valueAt(userIdIndex);     // Catch: Throwable -> L11
        ArrayMap<String, ArrayList<String>> packagesCopy = new ArrayMap();     // Catch: Throwable -> L11
        int packagesIndex = 0;
    L9:
        if (packagesIndex >= packages.size()) goto L13;
        packagesCopy.put(packages.keyAt(packagesIndex), new ArrayList(packages.valueAt(packagesIndex)));     // Catch: Throwable -> L11
        packagesIndex = packagesIndex + 1;     // Catch: Throwable -> L11
        goto L9
    L13:
        copy.put(this.mUidMap.keyAt(userIdIndex), packagesCopy);     // Catch: Throwable -> L11
        userIdIndex = userIdIndex + 1;     // Catch: Throwable -> L11
        goto L6
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return copy;
    L11:
        th = move-exception;
        throw th;
    }

    public void clear() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mUidMap.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private ArrayMap<String, ArrayList<String>> getOrAllocate(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayMap<String, ArrayList<String>> map = this.mUidMap.get(userId);     // Catch: Throwable -> L7
        if (map != null) goto L9;
        map = new ArrayMap();     // Catch: Throwable -> L7
        this.mUidMap.put(userId, map);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return map;
    L7:
        th = move-exception;
        throw th;
    }

    private ArrayList<String> getOrAllocate(int userId, String packageName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayMap<String, ArrayList<String>> map = this.mUidMap.get(userId);     // Catch: Throwable -> L7
        if (map != null) goto L9;
        map = new ArrayMap();     // Catch: Throwable -> L7
        this.mUidMap.put(userId, map);     // Catch: Throwable -> L7
    L9:
        ArrayList<String> r2 = map.computeIfAbsent(packageName, new PendingPackageBroadcasts$$ExternalSyntheticLambda0());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ ArrayList lambda$getOrAllocate$0(String k) {
        return new ArrayList();
    }
}
