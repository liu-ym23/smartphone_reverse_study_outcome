package com.android.server.accounts;

import android.accounts.Account;
import android.util.LruCache;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
class TokenCache {
    private static final int MAX_CACHE_CHARS = 64000;
    private TokenLruCache mCachedTokens;

    private static class Key {
        public final Account account;
        public final String packageName;
        public final byte[] sigDigest;
        public final String tokenType;

        public Key(Account account, String tokenType, String packageName, byte[] sigDigest) {
            this.account = account;
            this.tokenType = tokenType;
            this.packageName = packageName;
            this.sigDigest = sigDigest;
        }

        public boolean equals(Object o) {
            if (o != null) goto L5;
        L17:
            return false;
        L5:
            if ((o instanceof Key) == false) goto L17;
            Key cacheKey = (Key) o;
            if (Objects.equals(this.account, cacheKey.account) == true) goto L9;
            return false;
        L9:
            if (Objects.equals(this.packageName, cacheKey.packageName) == true) goto L11;
            return false;
        L11:
            if (Objects.equals(this.tokenType, cacheKey.tokenType) == true) goto L13;
            return false;
        L13:
            if (Arrays.equals(this.sigDigest, cacheKey.sigDigest) == false) goto L21;
            return true;
        L21:
            return false;
        }

        public int hashCode() {
            return ((this.account.hashCode() ^ this.packageName.hashCode()) ^ this.tokenType.hashCode()) ^ Arrays.hashCode(this.sigDigest);
        }
    }

    private static class TokenLruCache extends LruCache<Key, Value> {
        private HashMap<Account, Evictor> mAccountEvictors;
        private HashMap<Pair<String, String>, Evictor> mTokenEvictors;

        private class Evictor {
            private final List<Key> mKeys;
            final /* synthetic */ TokenLruCache this$0;

            public Evictor(TokenLruCache r1) {
                this.this$0 = r1;
                this.mKeys = new ArrayList();
            }

            public void add(Key k) {
                this.mKeys.add(k);
            }

            public void evict() {
                Iterator<Key> r0 = this.mKeys.iterator();
            L4:
                if (r0.hasNext() == false) goto L6;
                Key k = r0.next();
                this.this$0.remove(k);
                goto L4
            }
        }

        @Override // android.util.LruCache
        protected /* bridge */ /* synthetic */ void entryRemoved(boolean r1, Key r2, Value r3, Value r4) {
            entryRemoved2(r1, r2, r3, r4);
        }

        @Override // android.util.LruCache
        protected /* bridge */ /* synthetic */ int sizeOf(Key r1, Value r2) {
            return sizeOf2(r1, r2);
        }

        public TokenLruCache() {
            super(TokenCache.MAX_CACHE_CHARS);
            this.mTokenEvictors = new HashMap();
            this.mAccountEvictors = new HashMap();
        }

        /* JADX INFO: renamed from: sizeOf, reason: avoid collision after fix types in other method */
        protected int sizeOf2(Key k, Value v) {
            return v.token.length();
        }

        /* JADX INFO: renamed from: entryRemoved, reason: avoid collision after fix types in other method */
        protected void entryRemoved2(boolean evicted, Key k, Value oldVal, Value newVal) {
            if (oldVal == null) goto L8;
            if (newVal != null) goto L9;
            Evictor evictor = this.mTokenEvictors.remove(new Pair(k.account.type, oldVal.token));
            if (evictor == null) goto L10;
            evictor.evict();
            return;
        L10:
            return;
        L9:
            return;
        }

        public void putToken(Key k, Value v) {
            Pair<String, String> mapKey = new Pair(k.account.type, v.token);
            Evictor tokenEvictor = this.mTokenEvictors.get(mapKey);
            if (tokenEvictor != null) goto L5;
            tokenEvictor = new Evictor(this);
        L5:
            tokenEvictor.add(k);
            this.mTokenEvictors.put(mapKey, tokenEvictor);
            Evictor accountEvictor = this.mAccountEvictors.get(k.account);
            if (accountEvictor != null) goto L8;
            accountEvictor = new Evictor(this);
        L8:
            accountEvictor.add(k);
            this.mAccountEvictors.put(k.account, accountEvictor);
            put(k, v);
        }

        public void evict(String accountType, String token) {
            Evictor evictor = this.mTokenEvictors.get(new Pair(accountType, token));
            if (evictor == null) goto L6;
            evictor.evict();
            return;
        }

        public void evict(Account account) {
            Evictor evictor = this.mAccountEvictors.get(account);
            if (evictor == null) goto L6;
            evictor.evict();
            return;
        }
    }

    static class Value {
        public final long expiryEpochMillis;
        public final String token;

        public Value(String token, long expiryEpochMillis) {
            this.token = token;
            this.expiryEpochMillis = expiryEpochMillis;
        }
    }

    TokenCache() {
        this.mCachedTokens = new TokenLruCache();
    }

    public void put(Account account, String token, String tokenType, String packageName, byte[] sigDigest, long expiryMillis) {
        account.getClass();
        if (token != null) goto L5;
        return;
    L5:
        if (System.currentTimeMillis() > expiryMillis) goto L10;
        Key k = new Key(account, tokenType, packageName, sigDigest);
        Value v = new Value(token, expiryMillis);
        this.mCachedTokens.putToken(k, v);
        return;
    }

    public void remove(String accountType, String token) {
        this.mCachedTokens.evict(accountType, token);
    }

    public void remove(Account account) {
        this.mCachedTokens.evict(account);
    }

    public Value get(Account account, String tokenType, String packageName, byte[] sigDigest) {
        Key k = new Key(account, tokenType, packageName, sigDigest);
        Value v = this.mCachedTokens.get(k);
        long currentTime = System.currentTimeMillis();
        if (v != null) goto L5;
    L7:
        if (v == null) goto L11;
        remove(account.type, v.token);
        return null;
    L11:
        return null;
    L5:
        if (currentTime >= v.expiryEpochMillis) goto L7;
        return v;
    }
}
