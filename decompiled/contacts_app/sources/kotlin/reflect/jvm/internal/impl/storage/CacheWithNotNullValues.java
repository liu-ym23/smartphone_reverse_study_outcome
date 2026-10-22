package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: storage.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface CacheWithNotNullValues<K, V> {
    V computeIfAbsent(K r1, Function0<? extends V> r2);
}
