package com.ttnet.org.chromium.base;

import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
@MainDex
public abstract class PathUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f18278a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static FutureTask f18279b;

    static {
        f18278a = new AtomicBoolean();
    }

    public static String a(int r10) {
        return b()[r10];
    }

    public static String[] b() {
        if (f18279b.isDone() == true) goto L20;
        o r10 = o.c();
        f18279b.run();     // Catch: Throwable -> L8
        if (r10 == null) goto L20;
        r10.close();
    L8:
        th = move-exception;
        if (r10 != null) goto L24;
    L14:
        throw th;
    L24:
        r10.close();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.addSuppressed(th);
    L20:
        return (String[]) f18279b.get();
    L17:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @CalledByNative
    public static String[] getAllPrivateDownloadsDirectories() {
        o r10 = o.c();
        File[] r11 = e.d().getExternalFilesDirs(Environment.DIRECTORY_DOWNLOADS);     // Catch: Throwable -> L18
        if (r10 == null) goto L6;
        r10.close();
    L6:
        ArrayList r12 = new ArrayList();
        int r13 = 0;
    L8:
        if (r13 >= r11.length) goto L17;
        File r14 = r11[r13];
        if (r14 == null) goto L15;
        if (TextUtils.isEmpty(r14.getAbsolutePath()) == true) goto L15;
        r12.add(r11[r13].getAbsolutePath());
    L15:
        r13 = r13 + 1;
        goto L8
    L17:
        return (String[]) r12.toArray(new String[r12.size()]);
    L18:
        th = move-exception;
        if (r10 != null) goto L27;
    L24:
        throw th;
    L27:
        r10.close();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.addSuppressed(th);
        goto L24
    }

    @CalledByNative
    public static String getCacheDirectory() {
        return a(2);
    }

    @CalledByNative
    public static String getDataDirectory() {
        return a(0);
    }

    @NonNull
    @CalledByNative
    private static String getDownloadsDirectory() {
        o r10 = o.b();
    L8:
        th = move-exception;
        if (r10 != null) goto L25;
    L23:
        throw th;
    L25:
        r10.close();     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        th.addSuppressed(th);
        goto L23
    L4:
        if (BuildInfo.b() == false) goto L14;
        String[] r11 = getAllPrivateDownloadsDirectories();     // Catch: Throwable -> L8
        if (getAllPrivateDownloadsDirectories().length != 0) goto L10;
        String r12 = "";
    L11:
        if (r10 == null) goto L13;
        r10.close();
    L13:
        return r12;
    L10:
        r12 = r11[0];     // Catch: Throwable -> L8
        goto L11
    L14:
        String r13 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();     // Catch: Throwable -> L8
        if (r10 == null) goto L17;
        r10.close();
    L17:
        return r13;
    }

    @CalledByNative
    public static String getExternalStorageDirectory() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    @CalledByNative
    private static String getNativeLibraryDirectory() {
        ApplicationInfo r10 = e.d().getApplicationInfo();
        int r11 = r10.flags;
        if ((r11 & 128) != 0) goto L10;
        if ((r11 & 1) == 0) goto L10;
        return "/system/lib/";
    L10:
        return r10.nativeLibraryDir;
    }

    @CalledByNative
    public static String getThumbnailCacheDirectory() {
        return a(1);
    }
}
