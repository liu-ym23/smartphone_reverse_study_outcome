package kotlin.reflect.jvm.internal.pcollections;

import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
final class MapEntry<K, V> implements Serializable {
    public final K key;
    public final V value;

    public MapEntry(K r1, V r2) {
        this.key = r1;
        this.value = r2;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof MapEntry) == true) goto L5;
        return false;
    L5:
        MapEntry r5 = (MapEntry) r4;
        K r0 = this.key;
        if (r0 != null) goto L11;
        if (r5.key != null) goto L21;
    L12:
        V r3 = this.value;
        if (r3 != null) goto L18;
        if (r5.value != null) goto L23;
    L19:
        return true;
    L23:
        return false;
    L18:
        if (r3.equals(r5.value) == true) goto L19;
        return false;
    L21:
        return false;
    L11:
        if (r0.equals(r5.key) == true) goto L12;
        return false;
    }

    public int hashCode() {
        K r0 = this.key;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        V r3 = this.value;
        if (r3 == null) goto L11;
        r1 = r3.hashCode();
    L11:
        return r2 ^ r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return this.key + "=" + this.value;
    }
}
