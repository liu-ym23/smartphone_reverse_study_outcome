package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class SafeKeyGenerator {
    private final Pools$Pool<PoolableDigestContainer> digestPool;
    private final LruCache<Key, String> loadIdToSafeHash;

    public static final class PoolableDigestContainer implements FactoryPools.Poolable {
        final MessageDigest messageDigest;
        private final StateVerifier stateVerifier;

        public PoolableDigestContainer(MessageDigest r10) {
            this.stateVerifier = StateVerifier.newInstance();
            this.messageDigest = r10;
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
        @NonNull
        public StateVerifier getVerifier() {
            return this.stateVerifier;
        }
    }

    public SafeKeyGenerator() {
        this.loadIdToSafeHash = new LruCache(1000);
        this.digestPool = FactoryPools.threadSafe(10, new AnonymousClass1(this));
    }

    private String calculateHexStringDigest(Key r10) {
        PoolableDigestContainer r11 = (PoolableDigestContainer) Preconditions.checkNotNull(this.digestPool.acquire());
        r10.updateDiskCacheKey(r11.messageDigest);     // Catch: Throwable -> L6
        String r12 = Util.sha256BytesToHex(r11.messageDigest.digest());     // Catch: Throwable -> L6
        this.digestPool.release(r11);
        return r12;
    L6:
        th = move-exception;
        this.digestPool.release(r11);
        throw th;
    }

    public String getSafeKey(Key r10) {
        LruCache<Key, String> r11 = this.loadIdToSafeHash;
        monitor-enter(r11);
        String r12 = this.loadIdToSafeHash.get(r10);     // Catch: Throwable -> L16
        monitor-exit(r11);     // Catch: Throwable -> L16
        if (r12 != null) goto L8;
        r12 = calculateHexStringDigest(r10);
    L8:
        LruCache<Key, String> r13 = this.loadIdToSafeHash;
        monitor-enter(r13);
        this.loadIdToSafeHash.put(r10, r12);     // Catch: Throwable -> L13
        monitor-exit(r13);     // Catch: Throwable -> L13
        return r12;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        throw th;
    }
}
