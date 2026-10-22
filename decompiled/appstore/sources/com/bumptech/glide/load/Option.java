package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class Option<T> {
    private static final CacheKeyUpdater<Object> EMPTY_UPDATER = null;
    private final CacheKeyUpdater<T> cacheKeyUpdater;
    private final T defaultValue;
    private final String key;
    private volatile byte[] keyBytes;

    public interface CacheKeyUpdater<T> {
        void update(@NonNull byte[] r10, @NonNull T r11, @NonNull MessageDigest r12);
    }

    static {
        EMPTY_UPDATER = new AnonymousClass1();
    }

    private Option(@NonNull String r10, @Nullable T r11, @NonNull CacheKeyUpdater<T> r12) {
        this.key = Preconditions.checkNotEmpty(r10);
        this.defaultValue = r11;
        this.cacheKeyUpdater = (CacheKeyUpdater) Preconditions.checkNotNull(r12);
    }

    @NonNull
    public static <T> Option<T> disk(@NonNull String r10, @NonNull CacheKeyUpdater<T> r11) {
        return new Option(r10, null, r11);
    }

    @NonNull
    private static <T> CacheKeyUpdater<T> emptyUpdater() {
        return (CacheKeyUpdater<T>) EMPTY_UPDATER;
    }

    @NonNull
    private byte[] getKeyBytes() {
        if (this.keyBytes != null) goto L6;
        this.keyBytes = this.key.getBytes(Key.CHARSET);
    L6:
        return this.keyBytes;
    }

    @NonNull
    public static <T> Option<T> memory(@NonNull String r10) {
        return new Option(r10, null, emptyUpdater());
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof Option) == true) goto L5;
        return false;
    L5:
        return this.key.equals(((Option) r10).key);
    }

    @Nullable
    public T getDefaultValue() {
        return this.defaultValue;
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.key + "'}";
    }

    public void update(@NonNull T r10, @NonNull MessageDigest r11) {
        this.cacheKeyUpdater.update(getKeyBytes(), r10, r11);
    }

    @NonNull
    public static <T> Option<T> disk(@NonNull String r10, @Nullable T r11, @NonNull CacheKeyUpdater<T> r12) {
        return new Option(r10, r11, r12);
    }

    @NonNull
    public static <T> Option<T> memory(@NonNull String r10, @NonNull T r11) {
        return new Option(r10, r11, emptyUpdater());
    }
}
