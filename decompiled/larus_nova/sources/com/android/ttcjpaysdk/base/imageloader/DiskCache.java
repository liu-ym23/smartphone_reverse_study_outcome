package com.android.ttcjpaysdk.base.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0016J8\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u00152\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0015H\u0002J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u0019\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/base/imageloader/DiskCache;", "Lcom/android/ttcjpaysdk/base/imageloader/Cache;", "()V", "cachePath", "", "maxFileCount", "", "maxKeepTime", "checkAndClearDisk", "", "checkFileMaxNum", "checkFileTimeOut", "deleteFile", "", "filePath", "getBitmap", "Landroid/graphics/Bitmap;", "key", "listFileSortByModifyTime", "Ljava/util/ArrayList;", "Ljava/io/File;", "Lkotlin/collections/ArrayList;", "list", "md5Encrypt", "string", "setBitmap", "value", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DiskCache implements Cache {
    private String cachePath;
    private final int maxFileCount;
    private final int maxKeepTime;

    private final void checkFileMaxNum() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.cachePath);     // Catch: Exception -> L14
        if (r100.isDirectory() == true) goto L5;
        return;
    L5:
        if (r100.exists() == false) goto L21;
        List r101 = ArraysKt.toList(r100.listFiles());     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.util.ArrayList<java.io.File>{ kotlin.collections.TypeAliasesKt.ArrayList<java.io.File> }");     // Catch: Exception -> L14
        ArrayList<File> r102 = listFileSortByModifyTime((ArrayList) r101);     // Catch: Exception -> L14
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.size() <= this.maxFileCount) goto L23;
        int r103 = r102.size() - this.maxFileCount;     // Catch: Exception -> L14
        int r104 = 0;
    L11:
        if (r104 >= r103) goto L24;
        ((File) ListProtector.get(r102, r104)).delete();     // Catch: Exception -> L14
        r104 = r104 + 1;
        goto L11
    L24:
        return;
    L23:
        return;
    L21:
        return;
    L14:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("DiskCache#checkFileMaxNum", e);
        CJBasicCommonUtils.logCatch("CJCatch", "DiskCache#checkFileMaxNum", e);
        e.printStackTrace();
    }

    private final void checkFileTimeOut() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.cachePath);     // Catch: Exception -> L12
        if (r100.isDirectory() == true) goto L5;
        return;
    L5:
        if (r100.exists() == false) goto L21;
        File[] r101 = r100.listFiles();     // Catch: Exception -> L12
        int r102 = r101.length;     // Catch: Exception -> L12
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L22;
        File r104 = r101[r103];     // Catch: Exception -> L12
        if ((System.currentTimeMillis() - r104.lastModified()) <= this.maxKeepTime) goto L11;
        r104.delete();     // Catch: Exception -> L12
    L11:
        r103 = r103 + 1;
        goto L7
    L22:
        return;
    L21:
        return;
    L12:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("DiskCache#checkFileTimeOut", e);
        CJBasicCommonUtils.logCatch("CJCatch", "DiskCache#checkFileTimeOut", e);
        e.printStackTrace();
    }

    public DiskCache() {
        this.maxFileCount = 20;
        this.maxKeepTime = BaseConstants.Time.DAY;
        StringBuilder r100 = new StringBuilder();     // Catch: Exception -> L11
        Context r101 = CJPayHostInfo.applicationContext;     // Catch: Exception -> L11
        if (r101 == null) goto L8;
        File r102 = r101.getCacheDir();     // Catch: Exception -> L11
        if (r102 == null) goto L8;
        String r103 = r102.getAbsolutePath();     // Catch: Exception -> L11
    L9:
        r100.append(r103);     // Catch: Exception -> L11
        r100.append("/CJPayImageLoader");     // Catch: Exception -> L11
        this.cachePath = r100.toString();     // Catch: Exception -> L11
        return;
    L8:
        r103 = null;
    L11:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("DiskCache#unknown", e);
        CJBasicCommonUtils.logCatch("CJCatch", "DiskCache#unknown", e);
    }

    public final void checkAndClearDisk() {
        checkFileTimeOut();
        checkFileMaxNum();
    }

    private final boolean deleteFile(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.isFile() == true) goto L5;
        return false;
    L5:
        if (r101.exists() == true) goto L7;
        return false;
    L7:
        return r101.delete();
    }

    private final ArrayList<File> listFileSortByModifyTime(ArrayList<File> r100) {
        if (r100 != null) goto L4;
    L6:
        return r100;
    L4:
        if (r100.size() <= 0) goto L6;
        Collections.sort(r100, AnonymousClass1.INSTANCE);
        goto L6
    }

    private final String md5Encrypt(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L16;
        return "";
    L16:
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L13
        Intrinsics.checkNotNull(r100);     // Catch: NoSuchAlgorithmException -> L13
        byte[] r102 = r101.digest(r100.getBytes(Charsets.UTF_8));     // Catch: NoSuchAlgorithmException -> L13
        StringBuilder r103 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L13
        int r104 = r102.length;     // Catch: NoSuchAlgorithmException -> L13
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L11;
        String r106 = Integer.toHexString(r102[r105] & UByte.MAX_VALUE);     // Catch: NoSuchAlgorithmException -> L13
        if (r106.length() != 1) goto L10;
        r106 = '0' + r106;     // Catch: NoSuchAlgorithmException -> L13
    L10:
        r103.append(r106);     // Catch: NoSuchAlgorithmException -> L13
        r105 = r105 + 1;     // Catch: NoSuchAlgorithmException -> L13
        goto L6
    L11:
        return r103.toString();
    L13:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("DiskCache#md5Encrypt", e);
        CJBasicCommonUtils.logCatch("CJCatch", "DiskCache#md5Encrypt", e);
        e.printStackTrace();
        return "";
    }

    @Override // com.android.ttcjpaysdk.base.imageloader.Cache
    public Bitmap getBitmap(String r100) {
        checkFileMaxNum();
        String r101 = md5Encrypt(r100);     // Catch: Exception -> L15
        PolarisFileWrapper r102 = new PolarisFileWrapper(this.cachePath, r101);     // Catch: Exception -> L13
        if (r102.exists() == false) goto L20;
        Bitmap r103 = BitmapFactory.decodeStream(new PolarisFileInputStreamWrapper(r102));     // Catch: Exception -> L13
        boolean r104 = false;
        if (r103 == null) goto L11;
        if (r103.isRecycled() == true) goto L11;
        r104 = true;
    L11:
        if (r104 == false) goto L20;
        return r103;
    L20:
        return null;
    L13:
        e = e;
    L17:
        CJBasicCommonUtils.logCatch("CJCatch", "DiskCache#getBitmap", e);
        e.printStackTrace();
        if (r101 == null) goto L20;
        deleteFile(this.cachePath + '/' + r101);
    L15:
        e = e;
        r101 = null;
        goto L17
    }

    @Override // com.android.ttcjpaysdk.base.imageloader.Cache
    public void setBitmap(String r100, Bitmap r101) {
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == false) goto L23;
        return;
    L23:
        String r103 = md5Encrypt(r100);     // Catch: Exception -> L20
        if (r103 != null) goto L12;
        return;
    L12:
        PolarisFileWrapper r104 = new PolarisFileWrapper(this.cachePath, r103);     // Catch: Exception -> L20
        File r105 = r104.getParentFile();     // Catch: Exception -> L20
        if (r105 != null) goto L15;
    L17:
        if (r101 == null) goto L25;
        r101.compress(Bitmap.CompressFormat.PNG, 100, new PolarisFileOutputStreamWrapper(r104));     // Catch: Exception -> L20
        return;
    L25:
        return;
    L15:
        if (r105.exists() == true) goto L17;
        r105.mkdirs();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("DiskCache#setBitmap", e);
        CJBasicCommonUtils.logCatch("CJCatch", "DiskCache#setBitmap", e);
        e.printStackTrace();
        return;
    L5:
        if (r101.isRecycled() != true) goto L7;
        r102 = true;
        goto L7
    }
}
