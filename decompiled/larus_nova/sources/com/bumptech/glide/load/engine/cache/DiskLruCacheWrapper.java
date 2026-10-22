package com.bumptech.glide.load.engine.cache;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.GlideCacheUtils;
import com.bumptech.glide.util.GlideLogUtil;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.lark.android.encryption.exception.DecryptException;
import gbb.a;
import gbb.g;
import gbb.h;
import gbb.i;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public class DiskLruCacheWrapper implements DiskCache {
    private static final int APP_VERSION = 1;
    private static final String TAG = "DiskLruCacheWrapper";
    private static final int VALUE_COUNT = 1;
    private static DiskLruCacheWrapper wrapper;
    private final File avatarDirectory;
    private g avatarDiskLruCache;
    private final File directory;
    private g diskLruCache;
    private SafeKeyGenerator.IKeyGeneratorHandler handler;
    private final long maxSize;
    private final SafeKeyGenerator safeKeyGenerator;
    private final DiskCacheWriteLocker writeLocker;

    private synchronized g getDiskCache() throws IOException {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.diskLruCache != null) goto L6;
        this.diskLruCache = new i(this.directory.getPath(), this.maxSize).a();     // Catch: Throwable -> L9
    L6:
        g r100 = this.diskLruCache;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    private synchronized void resetDiskCache() {
        monitor-enter(this);
        this.diskLruCache = null;     // Catch: Throwable -> L7
        this.avatarDiskLruCache = null;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public synchronized void clear() {
        monitor-enter(this);
        getDiskCache().delete();     // Catch: Throwable -> L6 IOException -> L8
    L4:
        resetDiskCache();     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        resetDiskCache();     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L8:
        e = move-exception;
        GlideLogUtil.e(TAG, "Unable to clear disk cache or disk cache cleared externally", e);     // Catch: Throwable -> L6
    L15:
        th = move-exception;
        throw th;
    }

    private synchronized g getDiskCache(Key r100) throws IOException {
        monitor-enter(this);
        SafeKeyGenerator.IKeyGeneratorHandler r101 = this.handler;     // Catch: Throwable -> L28
        if (r101 == null) goto L23;
        if (r101.handleDataCacheKey(r100) == false) goto L23;
        if (this.avatarDiskLruCache != null) goto L19;
        i r102 = new i(this.avatarDirectory.getPath(), this.maxSize);     // Catch: Throwable -> L28
        h r103 = (h) r102.f480808c;     // Catch: Throwable -> L28
        r103.getClass();     // Catch: Throwable -> L28
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103.f480805a);     // Catch: Throwable -> L28
        if (r104.mkdirs() == false) goto L12;
    L17:
        a r105 = new a(r104, r102.f480807b, r102.f480806a);     // Catch: Throwable -> L28
    L18:
        this.avatarDiskLruCache = r105;     // Catch: Throwable -> L28
        goto L19
    L12:
        if (r104.exists() == true) goto L14;
    L16:
        r105 = null;
        goto L18
    L14:
        if (r104.isDirectory() == false) goto L16;
    L19:
        g r106 = this.avatarDiskLruCache;     // Catch: Throwable -> L28
        monitor-exit(this);
        return r106;
    L23:
        if (this.diskLruCache != null) goto L25;
        this.diskLruCache = new i(this.directory.getPath(), this.maxSize).a();     // Catch: Throwable -> L28
    L25:
        g r107 = this.diskLruCache;     // Catch: Throwable -> L28
        monitor-exit(this);
        return r107;
    L28:
        th = move-exception;
        throw th;
    }

    private boolean isAvatarCache(g r100) {
        File r101 = r100.b();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(r101.getPath(), this.avatarDirectory.getPath()) == false) goto L7;
        return true;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key r100) {
        String r101 = this.safeKeyGenerator.getSafeKey(r100);
        getDiskCache(r100).remove(r101);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        GlideLogUtil.e(TAG, "Unable to delete from disk cache", e);
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public File get(Key r110) {
        String r100 = this.safeKeyGenerator.getSafeKey(r110);
        long r101 = System.currentTimeMillis();
        g r102 = getDiskCache(r110);     // Catch: IOException -> L8 DecryptException -> L10
        if (isAvatarCache(r102) == false) goto L6;
        File r103 = r102.c(r100);     // Catch: IOException -> L8 DecryptException -> L10
    L24:
    L13:
        long r104 = System.currentTimeMillis() - r101;
        if (r103 != null) goto L16;
    L18:
        boolean r105 = false;
    L19:
        if (r105 == false) goto L21;
        long r106 = r103.length();
    L22:
        GlideLogUtil.i(TAG, "Get: Obtained: " + r100 + ", for Key: " + r110 + ", result: " + r103 + ", isResultExists: " + r105 + ", length: " + r106 + ", costTime: " + r104);
        return r103;
    L21:
        r106 = 0;
        goto L22
    L16:
        if (r103.exists() == false) goto L18;
        r105 = true;
        goto L19
    L6:
        r103 = r102.a(r100);     // Catch: IOException -> L8 DecryptException -> L10
    L10:
        e = move-exception;
        GlideLogUtil.e(TAG, "Unable to get from disk cache cipher", e);
    L12:
        r103 = null;
    L8:
        e = move-exception;
        GlideLogUtil.e(TAG, "Unable to get from disk cache", e);
        goto L12
    }

    public DiskLruCacheWrapper(File r100, long r101) {
        this.writeLocker = new DiskCacheWriteLocker();
        this.directory = r100;
        this.avatarDirectory = r100;
        this.maxSize = r101;
        this.safeKeyGenerator = new SafeKeyGenerator();
    }

    private boolean containCache(g r100, String r101) {
        if (r100.a(r101) == null) goto L15;
        return true;
    L15:
        return false;
    L9:
        e = move-exception;
        GlideLogUtil.e(TAG, "Unable to get disk cache cipher", e);
        return false;
    L7:
        e = move-exception;
        GlideLogUtil.e(TAG, "Unable to get disk cache", e);
        return false;
    }

    public static DiskCache create(File r100, long r101) {
        return new DiskLruCacheWrapper(r100, r101);
    }

    public static synchronized DiskCache get(File r100, long r101) {
        monitor-enter(DiskLruCacheWrapper.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (wrapper != null) goto L7;
        wrapper = new DiskLruCacheWrapper(r100, r101);     // Catch: Throwable -> L10
    L7:
        DiskLruCacheWrapper r102 = wrapper;     // Catch: Throwable -> L10
        monitor-exit(DiskLruCacheWrapper.class);
        return r102;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void put(Key r100, final DiskCache.Writer r101) {
        String r102 = this.safeKeyGenerator.getSafeKey(r100);
        this.writeLocker.acquire(r102);
        GlideLogUtil.i(TAG, "Put: Obtained: " + r102 + " for for Key: " + r100);     // Catch: Throwable -> L24
        SafeKeyGenerator.IKeyGeneratorHandler r103 = this.handler;     // Catch: IOException -> L20 Throwable -> L24
        if (r103 != null) goto L7;
    L10:
        SafeKeyGenerator.IKeyGeneratorHandler r104 = this.handler;     // Catch: IOException -> L20 Throwable -> L24
        if (r104 != null) goto L13;
    L15:
        g r105 = getDiskCache(r100);     // Catch: IOException -> L20 Throwable -> L24
        if (containCache(r105, r102) == true) goto L8;
        r105.d(r102, new AnonymousClass1(this, r101));     // Catch: IOException -> L20 Throwable -> L24
    L22:
        this.writeLocker.release(r102);
        return;
    L8:
        this.writeLocker.release(r102);
        return;
    L13:
        if (r104.handleDataCacheKey(r100) == false) goto L15;
    L7:
        if (r103.handleResourceCacheKey(r100) == false) goto L10;
    L20:
        e = move-exception;
        GlideCacheUtils.onWriteCacheFailed(e);     // Catch: Throwable -> L24
        GlideLogUtil.e(TAG, "Unable to put to disk cache", e);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        this.writeLocker.release(r102);
        throw th;
    }

    public DiskLruCacheWrapper(File r100, File r101, long r102, SafeKeyGenerator.IKeyGeneratorHandler r103) {
        this.writeLocker = new DiskCacheWriteLocker();
        this.directory = r100;
        this.avatarDirectory = r101;
        this.maxSize = r102;
        this.handler = r103;
        this.safeKeyGenerator = new SafeKeyGenerator(r103);
    }

    public static DiskCache create(File r100, File r101, long r102, SafeKeyGenerator.IKeyGeneratorHandler r110) {
        return new DiskLruCacheWrapper(r100, r101, r102, r110);
    }
}
