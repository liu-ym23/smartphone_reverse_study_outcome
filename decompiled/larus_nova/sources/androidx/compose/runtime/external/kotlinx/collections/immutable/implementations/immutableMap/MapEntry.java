package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import com.alipay.sdk.m.n.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0016\u0010\u0004\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\t¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/MapEntry;", "K", "V", "", "key", "value", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "hashCode", "", "equals", "", "other", "", "toString", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class MapEntry<K, V> implements Map.Entry<K, V>, KMappedMarker {
    public static final int $stable = 0;
    private final K key;
    private final V value;

    @Override // java.util.Map.Entry
    public V setValue(V r100) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(getKey());
        r100.append(a.f25612h);
        r100.append(getValue());
        return r100.toString();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        K r100 = getKey();
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        V r103 = getValue();
        if (r103 == null) goto L10;
        r101 = r103.hashCode();
    L10:
        return r102 ^ r101;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object r100) {
        if ((r100 instanceof Map.Entry) == false) goto L5;
        Map.Entry r101 = (Map.Entry) r100;
    L7:
        if (r101 != null) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r101.getKey(), getKey()) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(r101.getValue(), getValue()) == true) goto L13;
        return false;
    L13:
        return true;
    L5:
        r101 = null;
        goto L7
    }

    public MapEntry(K r100, V r101) {
        this.key = r100;
        this.value = r101;
    }
}
