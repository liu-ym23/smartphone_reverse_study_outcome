package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class DiskLruCacheWrapper implements DiskCache {
    private static final int APP_VERSION = 1;
    private static final String TAG = "DiskLruCacheWrapper";
    private static final int VALUE_COUNT = 1;
    private static DiskLruCacheWrapper wrapper;
    private final File directory;
    private DiskLruCache diskLruCache;
    private final long maxSize;
    private final SafeKeyGenerator safeKeyGenerator;
    private final DiskCacheWriteLocker writeLocker;

    @Deprecated
    public DiskLruCacheWrapper(File r10, long r11) {
        this.writeLocker = new DiskCacheWriteLocker();
        this.directory = r10;
        this.maxSize = r11;
        this.safeKeyGenerator = new SafeKeyGenerator();
    }

    public static DiskCache create(File r10, long r11) {
        return new DiskLruCacheWrapper(r10, r11);
    }

    @Deprecated
    public static synchronized DiskCache get(File r10, long r11) {
        monitor-enter(DiskLruCacheWrapper.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (wrapper != null) goto L9;
        wrapper = new DiskLruCacheWrapper(r10, r11);     // Catch: Throwable -> L7
    L9:
        DiskLruCacheWrapper r12 = wrapper;     // Catch: Throwable -> L7
        monitor-exit(DiskLruCacheWrapper.class);
        return r12;
    }

    private synchronized DiskLruCache getDiskCache() throws IOException {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.diskLruCache != null) goto L8;
        this.diskLruCache = DiskLruCache.open(this.directory, 1, 1, this.maxSize);     // Catch: Throwable -> L6
    L8:
        DiskLruCache r10 = this.diskLruCache;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    }

    private synchronized void resetDiskCache() {
        monitor-enter(this);
        this.diskLruCache = null;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public synchronized void clear() {
        monitor-enter(this);
        getDiskCache().delete();     // Catch: Throwable -> L8 IOException -> L10
    L4:
        resetDiskCache();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L10:
        e = move-exception;
        if (Log.isLoggable(TAG, 5) == false) goto L4;
        Log.w(TAG, "Unable to clear disk cache or disk cache cleared externally", e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        resetDiskCache();     // Catch: Throwable -> L6
        throw th;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void delete(Key r10) {
        String r11 = this.safeKeyGenerator.getSafeKey(r10);
        getDiskCache().remove(r11);     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        if (Log.isLoggable(TAG, 5) == false) goto L12;
        Log.w(TAG, "Unable to delete from disk cache", e);
        return;
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public void put(Key r10, DiskCache.Writer r11) {
        String r12 = this.safeKeyGenerator.getSafeKey(r10);
        this.writeLocker.acquire(r12);
    L7:
        th = move-exception;
        this.writeLocker.release(r12);
        throw th;
    L4:
        if (Log.isLoggable(TAG, 2) == false) goto L40;
        Log.v(TAG, "Put: Obtained: " + r12 + " for for Key: " + r10);     // Catch: Throwable -> L7
    L40:
        DiskLruCache r13 = getDiskCache();     // Catch: Throwable -> L7 IOException -> L23
        if (r13.get(r12) == null) goto L13;
        this.writeLocker.release(r12);
        return;
    L13:
        DiskLruCache.Editor r14 = r13.edit(r12);     // Catch: Throwable -> L7 IOException -> L23
        if (r14 == null) goto L28;
    L20:
        th = move-exception;
        r14.abortUnlessCommitted();     // Catch: Throwable -> L7 IOException -> L23
        throw th;     // Catch: Throwable -> L7 IOException -> L23
    L17:
        if (r11.write(r14.getFile(0)) == false) goto L22;
        r14.commit();     // Catch: Throwable -> L20
    L22:
        r14.abortUnlessCommitted();     // Catch: Throwable -> L7 IOException -> L23
    L33:
        this.writeLocker.release(r12);
        return;
    L28:
        throw new IllegalStateException("Had two simultaneous puts for: " + r12);     // Catch: Throwable -> L7 IOException -> L23
    L23:
        e = move-exception;
        if (Log.isLoggable(TAG, 5) == false) goto L33;
        Log.w(TAG, "Unable to put to disk cache", e);     // Catch: Throwable -> L7
        goto L33
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache
    public File get(Key r10) {
        String r11 = this.safeKeyGenerator.getSafeKey(r10);
        if (Log.isLoggable(TAG, 2) == false) goto L15;
        Log.v(TAG, "Get: Obtained: " + r11 + " for for Key: " + r10);
    L15:
        DiskLruCache.Value r12 = getDiskCache().get(r11);     // Catch: IOException -> L10
        if (r12 == null) goto L17;
        return r12.getFile(0);
    L17:
        return null;
    L10:
        e = move-exception;
        if (Log.isLoggable(TAG, 5) == false) goto L18;
        Log.w(TAG, "Unable to get from disk cache", e);
        return null;
    L18:
        return null;
    }
}
