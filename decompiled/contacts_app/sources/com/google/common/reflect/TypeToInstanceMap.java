package com.google.common.reflect;

import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface TypeToInstanceMap<B> extends Map<TypeToken<? extends B>, B> {
    @Nullable
    <T extends B> T getInstance(TypeToken<T> r1);

    @Nullable
    <T extends B> T getInstance(Class<T> r1);

    @Nullable
    <T extends B> T putInstance(TypeToken<T> r1, @Nullable T r2);

    @Nullable
    <T extends B> T putInstance(Class<T> r1, @Nullable T r2);
}
