package androidx.room.util;

import S7.k;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a[\u0010\n\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u001e\u0010\t\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001aE\u0010\r\u001a\u00020\b\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0004\b\r\u0010\u000e\"\u0014\u0010\u0010\u001a\u00020\u000f8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "map", "", "isRelationCollection", "Lkotlin/Function1;", "LC7/r;", "fetchBlock", "recursiveFetchMap", "(Ljava/util/Map;ZLS7/k;)V", "Landroidx/collection/LongSparseArray;", "recursiveFetchLongSparseArray", "(Landroidx/collection/LongSparseArray;ZLS7/k;)V", "", "MAX_BIND_PARAMETER_CNT", "I", "room-runtime"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "androidx/room/util/RelationUtil")
/* loaded from: classes2.dex */
final /* synthetic */ class RelationUtil__RelationUtilKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <V> void recursiveFetchLongSparseArray(LongSparseArray<V> map, boolean z10, k fetchBlock) {
        kotlin.jvm.internal.k.f(map, "map");
        kotlin.jvm.internal.k.f(fetchBlock, "fetchBlock");
        LongSparseArray<? extends V> longSparseArray = new LongSparseArray<>(999);
        int size = map.size();
        int i = 0;
        int i6 = 0;
        while (i < size) {
            if (z10) {
                longSparseArray.put(map.keyAt(i), map.valueAt(i));
            } else {
                longSparseArray.put(map.keyAt(i), null);
            }
            i++;
            i6++;
            if (i6 == 999) {
                fetchBlock.invoke(longSparseArray);
                if (!z10) {
                    map.putAll(longSparseArray);
                }
                longSparseArray.clear();
                i6 = 0;
            }
        }
        if (i6 > 0) {
            fetchBlock.invoke(longSparseArray);
            if (z10) {
                return;
            }
            map.putAll(longSparseArray);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchMap(Map<K, V> map, boolean z10, k fetchBlock) {
        int i;
        kotlin.jvm.internal.k.f(map, "map");
        kotlin.jvm.internal.k.f(fetchBlock, "fetchBlock");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        loop0: while (true) {
            i = 0;
            for (K k : map.keySet()) {
                if (z10) {
                    linkedHashMap.put(k, map.get(k));
                } else {
                    linkedHashMap.put(k, null);
                }
                i++;
                if (i == 999) {
                    fetchBlock.invoke(linkedHashMap);
                    if (!z10) {
                        map.putAll(linkedHashMap);
                    }
                    linkedHashMap.clear();
                }
            }
            break loop0;
        }
        if (i > 0) {
            fetchBlock.invoke(linkedHashMap);
            if (z10) {
                return;
            }
            map.putAll(linkedHashMap);
        }
    }
}
