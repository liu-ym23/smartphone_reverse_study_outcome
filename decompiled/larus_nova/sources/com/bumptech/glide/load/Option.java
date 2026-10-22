package com.bumptech.glide.load;

import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes39.dex */
public final class Option<T> {
    private static final CacheKeyUpdater<Object> EMPTY_UPDATER = null;
    private final CacheKeyUpdater<T> cacheKeyUpdater;
    private final T defaultValue;
    private final String key;
    private volatile byte[] keyBytes;

    public interface CacheKeyUpdater<T> {
        void update(byte[] r100, T r101, MessageDigest r102);
    }

    static {
        EMPTY_UPDATER = new AnonymousClass1();
    }

    private byte[] getKeyBytes() {
        if (this.keyBytes != null) goto L6;
        this.keyBytes = this.key.getBytes(Key.CHARSET);
    L6:
        return this.keyBytes;
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.key + "'}";
    }

    private static <T> CacheKeyUpdater<T> emptyUpdater() {
        return (CacheKeyUpdater<T>) EMPTY_UPDATER;
    }

    public T getDefaultValue() {
        return this.defaultValue;
    }

    public static <T> Option<T> memory(String r100) {
        return new Option(r100, null, emptyUpdater());
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof Option) == true) goto L5;
        return false;
    L5:
        return this.key.equals(((Option) r100).key);
    }

    public static <T> Option<T> disk(String r100, CacheKeyUpdater<T> r101) {
        return new Option(r100, null, r101);
    }

    public static <T> Option<T> memory(String r100, T r101) {
        return new Option(r100, r101, emptyUpdater());
    }

    public void update(T r100, MessageDigest r101) {
        this.cacheKeyUpdater.update(getKeyBytes(), r100, r101);
    }

    private Option(String r100, T r101, CacheKeyUpdater<T> r102) {
        this.key = Preconditions.checkNotEmpty(r100);
        this.defaultValue = r101;
        this.cacheKeyUpdater = (CacheKeyUpdater) Preconditions.checkNotNull(r102);
    }

    public static <T> Option<T> disk(String r100, T r101, CacheKeyUpdater<T> r102) {
        return new Option(r100, r101, r102);
    }
}
