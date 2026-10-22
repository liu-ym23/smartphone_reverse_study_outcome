package com.android.server.pm;

import android.content.pm.ChangedPackages;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
class ChangedPackagesTracker {
    private int mChangedPackagesSequenceNumber;
    private final SparseArray<Map<String, Integer>> mChangedPackagesSequenceNumbers;
    private final Object mLock;
    private final SparseArray<SparseArray<String>> mUserIdToSequenceToPackage;

    ChangedPackagesTracker() {
        this.mLock = new Object();
        this.mUserIdToSequenceToPackage = new SparseArray();
        this.mChangedPackagesSequenceNumbers = new SparseArray();
    }

    public ChangedPackages getChangedPackages(int sequenceNumber, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ChangedPackages r2 = null;
        if (sequenceNumber < this.mChangedPackagesSequenceNumber) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L10:
        SparseArray<String> changedPackages = this.mUserIdToSequenceToPackage.get(userId);     // Catch: Throwable -> L8
        if (changedPackages != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L14:
        List<String> packageNames = new ArrayList(this.mChangedPackagesSequenceNumber - sequenceNumber);     // Catch: Throwable -> L8
        int i = sequenceNumber;
    L16:
        if (i >= this.mChangedPackagesSequenceNumber) goto L22;
        String packageName = changedPackages.get(i);     // Catch: Throwable -> L8
        if (packageName == null) goto L20;
        packageNames.add(packageName);     // Catch: Throwable -> L8
    L20:
        i = i + 1;     // Catch: Throwable -> L8
        goto L16
    L22:
        if (packageNames.isEmpty() == true) goto L25;
        r2 = new ChangedPackages(this.mChangedPackagesSequenceNumber, packageNames);     // Catch: Throwable -> L8
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    int getSequenceNumber() {
        return this.mChangedPackagesSequenceNumber;
    }

    void iterateAll(BiConsumer<Integer, SparseArray<SparseArray<String>>> sequenceNumberAndValues) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        sequenceNumberAndValues.accept(Integer.valueOf(this.mChangedPackagesSequenceNumber), this.mUserIdToSequenceToPackage);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void updateSequenceNumber(String packageName, int[] userList) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = userList.length - 1;     // Catch: Throwable -> L9
    L5:
        if (i < 0) goto L18;
        int userId = userList[i];     // Catch: Throwable -> L9
        SparseArray<String> changedPackages = this.mUserIdToSequenceToPackage.get(userId);     // Catch: Throwable -> L9
        if (changedPackages != null) goto L11;
        changedPackages = new SparseArray();     // Catch: Throwable -> L9
        this.mUserIdToSequenceToPackage.put(userId, changedPackages);     // Catch: Throwable -> L9
    L11:
        Map<String, Integer> sequenceNumbers = this.mChangedPackagesSequenceNumbers.get(userId);     // Catch: Throwable -> L9
        if (sequenceNumbers != null) goto L14;
        sequenceNumbers = new HashMap();     // Catch: Throwable -> L9
        this.mChangedPackagesSequenceNumbers.put(userId, sequenceNumbers);     // Catch: Throwable -> L9
    L14:
        Integer sequenceNumber = sequenceNumbers.get(packageName);     // Catch: Throwable -> L9
        if (sequenceNumber == null) goto L17;
        changedPackages.remove(sequenceNumber.intValue());     // Catch: Throwable -> L9
    L17:
        changedPackages.put(this.mChangedPackagesSequenceNumber, packageName);     // Catch: Throwable -> L9
        sequenceNumbers.put(packageName, Integer.valueOf(this.mChangedPackagesSequenceNumber));     // Catch: Throwable -> L9
        i = i - 1;     // Catch: Throwable -> L9
        goto L5
    L18:
        int i2 = this.mChangedPackagesSequenceNumber;     // Catch: Throwable -> L9
        this.mChangedPackagesSequenceNumber = i2 + 1;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
