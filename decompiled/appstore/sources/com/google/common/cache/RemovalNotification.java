package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.AbstractMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    private RemovalNotification(@NullableDecl K r10, @NullableDecl V r11, RemovalCause r12) {
        super(r10, r11);
        this.cause = (RemovalCause) Preconditions.checkNotNull(r12);
    }

    public static <K, V> RemovalNotification<K, V> create(@NullableDecl K r10, @NullableDecl V r11, RemovalCause r12) {
        return new RemovalNotification(r10, r11, r12);
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}
