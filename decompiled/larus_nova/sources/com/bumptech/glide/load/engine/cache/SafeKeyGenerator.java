package com.bumptech.glide.load.engine.cache;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import com.ss.android.lark.log.Log;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes39.dex */
public class SafeKeyGenerator {
    private static final String TAG = "SafeKeyGenerator";
    private final Pools.Pool<PoolableDigestContainer> digestPool;
    private IKeyGeneratorHandler handler;
    private final LruCache<Key, String> loadIdToSafeHash;

    public interface IKeyGeneratorHandler {
        String generateSafeKey(Key r100);

        boolean handleDataCacheKey(Key r100);

        boolean handleResourceCacheKey(Key r100);
    }

    public static final class PoolableDigestContainer implements FactoryPools.Poolable {
        final MessageDigest messageDigest;
        private final StateVerifier stateVerifier;

        @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
        public StateVerifier getVerifier() {
            return this.stateVerifier;
        }

        public PoolableDigestContainer(MessageDigest r100) {
            this.stateVerifier = StateVerifier.newInstance();
            this.messageDigest = r100;
        }
    }

    public SafeKeyGenerator() {
        this.loadIdToSafeHash = new LruCache(1000);
        this.digestPool = FactoryPools.threadSafe(10, new AnonymousClass1(this));
    }

    public SafeKeyGenerator(IKeyGeneratorHandler r100) {
        this.loadIdToSafeHash = new LruCache(1000);
        this.digestPool = FactoryPools.threadSafe(10, new AnonymousClass1(this));
        this.handler = r100;
    }

    private String calculateHexStringDigest(Key r100) {
        IKeyGeneratorHandler r101 = this.handler;
        if (r101 != null) goto L5;
    L8:
        PoolableDigestContainer r102 = (PoolableDigestContainer) Preconditions.checkNotNull(this.digestPool.acquire());
        r100.updateDiskCacheKey(r102.messageDigest);     // Catch: Throwable -> L12
        String r103 = Util.sha256BytesToHex(r102.messageDigest.digest());     // Catch: Throwable -> L12
        this.digestPool.release(r102);
        return r103;
    L12:
        th = move-exception;
        this.digestPool.release(r102);
        throw th;
    L5:
        if (r101.handleDataCacheKey(r100) == false) goto L8;
        Log.i(TAG, "Get: Calculated safe key for data cache key: " + r100);
        return this.handler.generateSafeKey(r100);
    }

    public String getSafeKey(Key r100) {
        LruCache<Key, String> r101 = this.loadIdToSafeHash;
        monitor-enter(r101);
        String r102 = this.loadIdToSafeHash.get(r100);     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
        if (r102 != null) goto L8;
        r102 = calculateHexStringDigest(r100);
    L8:
        LruCache<Key, String> r103 = this.loadIdToSafeHash;
        monitor-enter(r103);
        this.loadIdToSafeHash.put(r100, r102);     // Catch: Throwable -> L13
        monitor-exit(r103);     // Catch: Throwable -> L13
        return r102;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        throw th;
    }
}
