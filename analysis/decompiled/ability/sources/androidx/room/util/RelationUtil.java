package androidx.room.util;

import S7.k;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"androidx/room/util/RelationUtil__RelationUtilKt", "androidx/room/util/RelationUtil__RelationUtil_androidKt"}, k = 4, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RelationUtil {
    public static final int MAX_BIND_PARAMETER_CNT = 999;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchArrayMap(ArrayMap<K, V> arrayMap, boolean z10, k kVar) {
        RelationUtil__RelationUtil_androidKt.recursiveFetchArrayMap(arrayMap, z10, kVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchHashMap(HashMap<K, V> map, boolean z10, k kVar) {
        RelationUtil__RelationUtil_androidKt.recursiveFetchHashMap(map, z10, kVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <V> void recursiveFetchLongSparseArray(LongSparseArray<V> longSparseArray, boolean z10, k kVar) {
        RelationUtil__RelationUtilKt.recursiveFetchLongSparseArray(longSparseArray, z10, kVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchMap(Map<K, V> map, boolean z10, k kVar) {
        RelationUtil__RelationUtilKt.recursiveFetchMap(map, z10, kVar);
    }
}
