package com.ttnet.org.chromium.base;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PathUtils {
    private static final String TAG = "PathUtils";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37644a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f37645b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static FutureTask<String[]> f37646c;

    static {
        f37645b = new AtomicBoolean();
    }

    private PathUtils() {
    }

    private static String[] a() {
        if (f37646c.isDone() == true) goto L22;
        s r0 = s.b();
        f37646c.run();     // Catch: Throwable -> L8
        if (r0 == null) goto L22;
        r0.close();
    L8:
        th = move-exception;
        if (r0 != null) goto L24;
    L14:
        throw th;
    L24:
        r0.close();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.addSuppressed(th);
    L22:
        return (String[]) ZeusTransformUtils.preCheckCast(f37646c.get(), String[].class, "com.obric.aiagent.plugin");
    L17:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static String a(int r1) {
        return a()[r1];
    }

    public static String getDataDirectory() {
        if (f37644a == true) goto L10;
        if (f37646c != null) goto L10;
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    L10:
        return a(0);
    }

    public static String getCacheDirectory() {
        if (f37644a == true) goto L10;
        if (f37646c != null) goto L10;
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    L10:
        return a(2);
    }

    public static String getThumbnailCacheDirectory() {
        if (f37644a == true) goto L10;
        if (f37646c != null) goto L10;
        throw new AssertionError("setDataDirectorySuffix must be called first.");
    L10:
        return a(1);
    }

    public static String getDownloadsDirectory() {
        s r0 = s.c();
    L22:
        th = move-exception;
        if (r0 != null) goto L29;
    L28:
        throw th;
    L29:
        r0.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        th.addSuppressed(th);
        goto L28
    L4:
        if (Build.VERSION.SDK_INT < 29) goto L18;
        String[] r1 = getAllPrivateDownloadsDirectories();     // Catch: Throwable -> L22
        if (f37644a == true) goto L12;
        if (r1 != null) goto L12;
        throw new AssertionError();     // Catch: Throwable -> L22
    L12:
        if (r1.length != 0) goto L14;
        String r2 = "";
    L15:
        if (r0 == null) goto L17;
        r0.close();
    L17:
        return r2;
    L14:
        r2 = r1[0];     // Catch: Throwable -> L22
        goto L15
    L18:
        String r3 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();     // Catch: Throwable -> L22
        if (r0 == null) goto L21;
        r0.close();
    L21:
        return r3;
    }

    public static String[] getAllPrivateDownloadsDirectories() {
        List r1 = new ArrayList();
        s r2 = s.b();
        File[] r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getExternalFilesDirs(Environment.DIRECTORY_DOWNLOADS);     // Catch: Throwable -> L11
        if (r0 == null) goto L7;
        r1 = Arrays.asList(r0);     // Catch: Throwable -> L11
    L7:
        if (r2 == null) goto L10;
        r2.close();
    L10:
        return a(r1);
    L11:
        th = move-exception;
        if (r2 != null) goto L20;
    L17:
        throw th;
    L20:
        r2.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);
        goto L17
    }

    public static String[] getExternalDownloadVolumesNames() {
        ArrayList r0 = new ArrayList();
        Iterator<String> r1 = com.ttnet.org.chromium.base.compat.e.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r3) == true) goto L4;
        if (r3.contains("external_primary") == true) goto L4;
        File r4 = com.ttnet.org.chromium.base.compat.f.a((StorageManager) ZeusTransformUtils.preCheckCast(com.ttnet.org.chromium.base.compat.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), StorageManager.class), StorageManager.class, "com.obric.aiagent.plugin"), MediaStore.Files.getContentUri(r3));
        File r5 = new File(r4, Environment.DIRECTORY_DOWNLOADS);
        if (r5.isDirectory() == true) goto L12;
        j.d(TAG, "Download dir missing: %s, parent dir:%s, isDirectory:%s", new Object[]{r5.getAbsolutePath(), r4.getAbsolutePath(), Boolean.valueOf(r4.isDirectory())});
    L12:
        r0.add(r5);
        goto L4
    L14:
        return a(r0);
    }

    private static String[] a(List<File> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L12;
        File r2 = (File) ZeusTransformUtils.preCheckCast(r6.next(), File.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L4;
        if (TextUtils.isEmpty(r2.getAbsolutePath()) == true) goto L4;
        r0.add(r2.getAbsolutePath());
        goto L4
    L12:
        return (String[]) ZeusTransformUtils.preCheckCast(r0.toArray(new String[r0.size()]), String[].class, "com.obric.aiagent.plugin");
    }

    private static String getNativeLibraryDirectory() {
        ApplicationInfo r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationInfo();
        if ((r0.flags & 128) != 0) goto L10;
        if ((r0.flags & 1) == 0) goto L10;
        return "/system/lib/";
    L10:
        return r0.nativeLibraryDir;
    }

    public static String getAppExternalCacheDirectory() {
        File r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getExternalCacheDir();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0.getAbsolutePath();
    }

    public static String getExternalStorageDirectory() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }
}
