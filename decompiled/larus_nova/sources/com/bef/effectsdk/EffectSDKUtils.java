package com.bef.effectsdk;

import android.content.Context;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes39.dex */
public class EffectSDKUtils {
    private static List<String> assetFiles;
    private static Set<File> localFiles;
    private static Set<File> needRemoveFiles;

    public EffectSDKUtils() {
    }

    private static native String nativeGetSdkVersion();

    static {
        localFiles = new HashSet();
        assetFiles = ModelsList.list;
        needRemoveFiles = new HashSet();
    }

    private static void deleteNoUseModel() {
        Iterator<File> r100 = localFiles.iterator();
    L4:
        if (r100.hasNext() == false) goto L10;
        File r101 = r100.next();
        if (needRemoveFiles.contains(r101) == false) goto L4;
        if (r101.exists() == false) goto L4;
        r101.delete();
        goto L4
    }

    public static String getSdkVersion() {
        return nativeGetSdkVersion();
    }

    public static /* synthetic */ void access$000(Closeable r100) {
        closeQuietly(r100);
    }

    private static void closeQuietly(Closeable r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        r100.close();     // Catch: RuntimeException -> L5 Exception -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        throw e;
    }

    private static String getAssetRelativePath(String r100) {
        int r101 = r100.indexOf("model/");
        if (r101 >= 0) goto L5;
        return r100;
    L5:
        return r100.substring(r101 + 6, r100.length());
    }

    private static String getFileName(String r100) {
        int r101 = r100.lastIndexOf(HTTP.URL_DEFAULT);
        if (r101 != (-1)) goto L5;
        return "";
    L5:
        return r100.substring(r101 + 1, r100.length());
    }

    public static void flushAlgorithmModelFiles(Context r100, String r101) throws Throwable {
        if (localFiles.isEmpty() == true) goto L5;
        localFiles.clear();
    L5:
        scanRecursive(r101, localFiles);
        copyAssets(r100, r101, null, false);
        deleteNoUseModel();
        localFiles.clear();
    }

    public static boolean needUpdate(final Context r100, String r101) {
        if (localFiles.isEmpty() == true) goto L5;
        localFiles.clear();
    L5:
        scanRecursive(r101, localFiles);
    L17:
        th = move-exception;
        th.printStackTrace();
        return true;
    L7:
        if (assetFiles.size() <= localFiles.size()) goto L9;
        return true;
    L9:
        Iterator<String> r102 = assetFiles.iterator();     // Catch: Throwable -> L17
    L11:
        if (r102.hasNext() == false) goto L15;
        final String r103 = r102.next();     // Catch: Throwable -> L17
        if (takeFirstMatchingOrNull(localFiles, new AnonymousClass1(r103, r100)) != null) goto L11;
        return true;
    L15:
        return false;
    }

    private static void scanRecursive(String r100, Set<File> r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L5;
        return;
    L5:
        File[] r103 = r102.listFiles();
        if (r103 == null) goto L14;
        int r104 = r103.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L18;
        File r106 = r103[r105];
        if (r106.isDirectory() == false) goto L12;
        scanRecursive(r106.getAbsolutePath(), r101);
    L13:
        r105 = r105 + 1;
        goto L8
    L12:
        r101.add(r106);
        goto L13
    L18:
        return;
    }

    private static File takeFirstMatchingOrNull(Set<File> r100, FileFilter r101) {
        Iterator<File> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        File r103 = r102.next();
        if (r101.accept(r103) == false) goto L4;
        return r103;
    L8:
        return null;
    }

    private static void copyFile(Context r100, String r101, String r102) throws Throwable {
        InputStream r103 = null;
        InputStream r104 = r100.getAssets().open(r101);     // Catch: Throwable -> L28
        String r105 = r102 + r101.substring(r101.indexOf(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL) + 6, r101.lastIndexOf(HTTP.URL_DEFAULT));     // Catch: Throwable -> L26
        PolarisFileWrapper r106 = new PolarisFileWrapper(r105);     // Catch: Throwable -> L26
        if (r106.exists() == false) goto L7;
    L11:
        PolarisFileOutputStreamWrapper r107 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r105 + HTTP.URL_DEFAULT + getFileName(r101)));     // Catch: Throwable -> L26
        byte[] r108 = new byte[1024];     // Catch: Throwable -> L24
    L14:
        int r109 = r104.read(r108);     // Catch: Throwable -> L24
        if (r109 <= 0) goto L41;
        r107.write(r108, 0, r109);     // Catch: Throwable -> L24
        goto L14
    L41:
        closeQuietly(r104);     // Catch: Throwable -> L21
        closeQuietly(r107);
        return;
    L21:
        th = move-exception;
        closeQuietly(r107);
        throw th;
    L24:
        th = move-exception;
        r103 = r104;
        PolarisFileOutputStreamWrapper r110 = r107;
        th = th;
    L36:
        closeQuietly(r103);     // Catch: Throwable -> L33
        closeQuietly(r110);
        throw th;
    L33:
        th = move-exception;
        closeQuietly(r110);
        throw th;
    L7:
        if (r106.mkdirs() == true) goto L11;
        throw new IOException("Can not mkdirs " + r106.getPath());     // Catch: Throwable -> L26
    L26:
        th = th;
        r103 = r104;
        r110 = null;
    L28:
        th = th;
        r110 = null;
        goto L36
    }

    private static void copyAssets(Context r100, String r101, String[] r110, boolean r111) throws Throwable {
        if (needRemoveFiles.isEmpty() == true) goto L5;
        needRemoveFiles.clear();
    L5:
        needRemoveFiles.addAll(localFiles);
        if (r101.endsWith(HTTP.URL_DEFAULT) == true) goto L8;
        r101 = r101.concat(HTTP.URL_DEFAULT);
    L8:
        Iterator<String> r102 = assetFiles.iterator();
    L10:
        if (r102.hasNext() == false) goto L33;
        String r103 = r102.next();
        final String r104 = getFileName(r103);
        File r105 = takeFirstMatchingOrNull(needRemoveFiles, new AnonymousClass2(r104));
        boolean r106 = false;
        if (r105 != null) goto L14;
    L16:
        boolean r107 = true;
    L17:
        if (r107 == false) goto L10;
        if (r110 != null) goto L20;
    L27:
        if (r106 == false) goto L30;
        if (r111 == false) goto L30;
        copyFile(r100, r103, r101);
    L30:
        if (r106 == true) goto L10;
        if (r111 == true) goto L10;
        copyFile(r100, r103, r101);
        goto L10
    L20:
        if (TextUtils.isEmpty(r104) == true) goto L27;
        int r108 = r110.length;
        int r109 = 0;
    L22:
        if (r109 >= r108) goto L27;
        if (r104.equals(r110[r109]) == true) goto L25;
        r109 = r109 + 1;
        goto L22
    L25:
        r106 = true;
        goto L27
    L14:
        if (new PolarisFileWrapper(r101, getAssetRelativePath(r103)).exists() == false) goto L16;
        needRemoveFiles.remove(r105);
        r107 = false;
        goto L17
    }

    public static void flushAlgorithmModelFiles(Context r100, String r101, String[] r102, boolean r103) throws Throwable {
        if (localFiles.isEmpty() == true) goto L5;
        localFiles.clear();
    L5:
        scanRecursive(r101, localFiles);
        copyAssets(r100, r101, r102, r103);
        deleteNoUseModel();
        localFiles.clear();
    }
}
