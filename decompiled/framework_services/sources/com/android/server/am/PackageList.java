package com.android.server.am;

import android.content.pm.VersionedPackage;
import android.util.ArrayMap;
import com.android.internal.app.procstats.ProcessStats;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
final class PackageList {
    private final ArrayMap<String, ProcessStats.ProcessStateHolder> mPkgList;
    private final ProcessRecord mProcess;

    PackageList(ProcessRecord app) {
        this.mPkgList = new ArrayMap();
        this.mProcess = app;
    }

    ProcessStats.ProcessStateHolder put(String key, ProcessStats.ProcessStateHolder value) {
        monitor-enter(this);
        this.mProcess.getWindowProcessController().addPackage(key);     // Catch: Throwable -> L6
        ProcessStats.ProcessStateHolder r0 = this.mPkgList.put(key, value);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    void clear() {
        monitor-enter(this);
        this.mPkgList.clear();     // Catch: Throwable -> L6
        this.mProcess.getWindowProcessController().clearPackageList();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    int size() {
        monitor-enter(this);
        int r0 = this.mPkgList.size();     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    boolean containsKey(Object key) {
        monitor-enter(this);
        boolean r0 = this.mPkgList.containsKey(key);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    ProcessStats.ProcessStateHolder get(String pkgName) {
        monitor-enter(this);
        ProcessStats.ProcessStateHolder r0 = this.mPkgList.get(pkgName);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    void forEachPackage(Consumer<String> callback) {
        monitor-enter(this);
        int i = 0;
        int size = this.mPkgList.size();     // Catch: Throwable -> L7
    L5:
        if (i >= size) goto L10;
        callback.accept(this.mPkgList.keyAt(i));     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void forEachPackage(BiConsumer<String, ProcessStats.ProcessStateHolder> callback) {
        monitor-enter(this);
        int i = 0;
        int size = this.mPkgList.size();     // Catch: Throwable -> L7
    L5:
        if (i >= size) goto L10;
        callback.accept(this.mPkgList.keyAt(i), this.mPkgList.valueAt(i));     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    <R> R searchEachPackage(Function<String, R> callback) {
        monitor-enter(this);
        int i = 0;
        int size = this.mPkgList.size();     // Catch: Throwable -> L10
    L5:
        if (i >= size) goto L14;
        R r = callback.apply(this.mPkgList.keyAt(i));     // Catch: Throwable -> L10
        if (r != null) goto L8;
        i = i + 1;     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
        return r;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L10
        return null;
    L10:
        th = move-exception;
        throw th;
    }

    void forEachPackageProcessStats(Consumer<ProcessStats.ProcessStateHolder> callback) {
        monitor-enter(this);
        int i = 0;
        int size = this.mPkgList.size();     // Catch: Throwable -> L7
    L5:
        if (i >= size) goto L10;
        callback.accept(this.mPkgList.valueAt(i));     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    ArrayMap<String, ProcessStats.ProcessStateHolder> getPackageListLocked() {
        return this.mPkgList;
    }

    String[] getPackageList() {
        monitor-enter(this);
        int size = this.mPkgList.size();     // Catch: Throwable -> L8
        if (size != 0) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return null;
    L10:
        String[] list = new String[size];     // Catch: Throwable -> L8
        int i = 0;
    L11:
        if (i >= size) goto L14;
        list[i] = this.mPkgList.keyAt(i);     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L11
    L14:
        monitor-exit(this);     // Catch: Throwable -> L8
        return list;
    L8:
        th = move-exception;
        throw th;
    }

    List<VersionedPackage> getPackageListWithVersionCode() {
        monitor-enter(this);
        int size = this.mPkgList.size();     // Catch: Throwable -> L8
        if (size != 0) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return null;
    L10:
        List<VersionedPackage> list = new ArrayList();     // Catch: Throwable -> L8
        int i = 0;
    L11:
        if (i >= size) goto L14;
        list.add(new VersionedPackage(this.mPkgList.keyAt(i), this.mPkgList.valueAt(i).appVersion));     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L11
    L14:
        monitor-exit(this);     // Catch: Throwable -> L8
        return list;
    L8:
        th = move-exception;
        throw th;
    }

    void dump(PrintWriter pw, String prefix) {
        monitor-enter(this);
        pw.print(prefix);     // Catch: Throwable -> L7
        pw.print("packageList={");     // Catch: Throwable -> L7
        int i = 0;
        int size = this.mPkgList.size();     // Catch: Throwable -> L7
    L4:
        if (i >= size) goto L10;
        if (i <= 0) goto L9;
        pw.print(", ");     // Catch: Throwable -> L7
    L9:
        pw.print(this.mPkgList.keyAt(i));     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L4
    L10:
        pw.println("}");     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
