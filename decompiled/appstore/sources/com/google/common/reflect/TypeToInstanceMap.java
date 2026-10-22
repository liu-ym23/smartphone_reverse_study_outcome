package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
public interface TypeToInstanceMap<B> extends Map<TypeToken<? extends B>, B> {
    @NullableDecl
    <T extends B> T getInstance(TypeToken<T> r10);

    @NullableDecl
    <T extends B> T getInstance(Class<T> r10);

    @CanIgnoreReturnValue
    @NullableDecl
    <T extends B> T putInstance(TypeToken<T> r10, @NullableDecl T r11);

    @CanIgnoreReturnValue
    @NullableDecl
    <T extends B> T putInstance(Class<T> r10, @NullableDecl T r11);
}
