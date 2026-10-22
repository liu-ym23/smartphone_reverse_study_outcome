package com.google.common.collect;

import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface ClassToInstanceMap<B> extends Map<Class<? extends B>, B> {
    <T extends B> T getInstance(Class<T> r1);

    <T extends B> T putInstance(Class<T> r1, @Nullable T r2);
}
