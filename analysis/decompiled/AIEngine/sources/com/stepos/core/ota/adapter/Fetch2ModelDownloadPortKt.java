package com.stepos.core.ota.adapter;

import com.stepos.core.ota.downloader.DownloadTask;
import gc.o;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import wb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Fetch2ModelDownloadPortKt {
    public static final boolean downloadFileHasBytes(String path) {
        g.f(path, "path");
        return downloadFileLength(path) > 0;
    }

    public static final long downloadFileLength(String path) {
        g.f(path, "path");
        File file = new File(path);
        if (!file.isFile()) {
            file = null;
        }
        if (file != null) {
            return file.length();
        }
        return 0L;
    }

    public static final boolean sameDownloadFile(String left, String right) {
        Object objA;
        g.f(left, "left");
        g.f(right, "right");
        if (left.equals(right)) {
            return true;
        }
        try {
            objA = Boolean.valueOf(g.b(new File(left).getCanonicalPath(), new File(right).getCanonicalPath()));
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }

    public static final DownloadTask selectDownloadTask(List<DownloadTask> tasks, String targetFilePath) {
        Object obj;
        Object next;
        g.f(tasks, "tasks");
        g.f(targetFilePath, "targetFilePath");
        Iterator<T> it = tasks.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (sameDownloadFile(((DownloadTask) next).getFile(), targetFilePath)) {
                break;
            }
        }
        DownloadTask downloadTask = (DownloadTask) next;
        if (downloadTask != null) {
            return downloadTask;
        }
        String name = new File(targetFilePath).getName();
        Iterator<T> it2 = tasks.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (g.b(new File(((DownloadTask) next2).getFile()).getName(), name)) {
                obj = next2;
                break;
            }
        }
        return (DownloadTask) obj;
    }

    public static final DownloadTask selectResumeTask(List<DownloadTask> tasks, String defaultFilePath) throws IOException {
        Object obj;
        g.f(tasks, "tasks");
        g.f(defaultFilePath, "defaultFilePath");
        File canonicalFile = new File(defaultFilePath).getCanonicalFile();
        g.c(canonicalFile);
        String strConcat = d.V(canonicalFile).concat("-retry-");
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : tasks) {
            DownloadTask downloadTask = (DownloadTask) obj2;
            File canonicalFile2 = new File(downloadTask.getFile()).getCanonicalFile();
            if (g.b(canonicalFile2.getParentFile(), canonicalFile.getParentFile()) && downloadFileHasBytes(downloadTask.getFile())) {
                if (!g.b(canonicalFile2.getName(), canonicalFile.getName())) {
                    String name = canonicalFile2.getName();
                    g.e(name, "getName(...)");
                    if (!o.k0(name, strConcat, false) || !d.U(canonicalFile2).equals("zip")) {
                    }
                }
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                long createdAtMillis = ((DownloadTask) next).getCreatedAtMillis();
                do {
                    Object next2 = it.next();
                    long createdAtMillis2 = ((DownloadTask) next2).getCreatedAtMillis();
                    if (createdAtMillis < createdAtMillis2) {
                        next = next2;
                        createdAtMillis = createdAtMillis2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (DownloadTask) obj;
    }
}
