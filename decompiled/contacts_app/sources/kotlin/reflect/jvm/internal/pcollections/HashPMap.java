package kotlin.reflect.jvm.internal.pcollections;

/* JADX INFO: loaded from: classes4.dex */
public final class HashPMap<K, V> {
    private static final HashPMap<Object, Object> EMPTY = null;
    private final IntTreePMap<ConsPStack<MapEntry<K, V>>> intMap;
    private final int size;

    private static /* synthetic */ void $$$reportNull$$$0(int r3) {
        Object[] r0 = new Object[2];
        r0[0] = "kotlin/reflect/jvm/internal/pcollections/HashPMap";
        if (r3 == 1) goto L5;
        r0[1] = "empty";
    L7:
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", r0));
    L5:
        r0[1] = "minus";
        goto L7
    }

    static {
        EMPTY = new HashPMap(IntTreePMap.empty(), 0);
    }

    public static <K, V> HashPMap<K, V> empty() {
        HashPMap<K, V> r0 = (HashPMap<K, V>) EMPTY;
        if (r0 != null) goto L5;
        $$$reportNull$$$0(0);
    L5:
        return r0;
    }

    private HashPMap(IntTreePMap<ConsPStack<MapEntry<K, V>>> r1, int r2) {
        this.intMap = r1;
        this.size = r2;
    }

    public int size() {
        return this.size;
    }

    public boolean containsKey(Object r2) {
        if (keyIndexIn(getEntries(r2.hashCode()), r2) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V get(Object r3) {
        ConsPStack r2 = getEntries(r3.hashCode());
    L3:
        if (r2 == null) goto L11;
        if (r2.size() <= 0) goto L16;
        MapEntry r0 = (MapEntry) r2.first;
        if (r0.key.equals(r3) == true) goto L9;
        r2 = r2.rest;
        goto L3
    L9:
        return r0.value;
    L16:
        return null;
    L11:
        return null;
    }

    public HashPMap<K, V> plus(K r5, V r6) {
        ConsPStack<MapEntry<K, V>> r0 = getEntries(r5.hashCode());
        int r1 = r0.size();
        int r2 = keyIndexIn(r0, r5);
        if (r2 == (-1)) goto L5;
        r0 = r0.minus(r2);
    L5:
        ConsPStack<MapEntry<K, V>> r7 = r0.plus(new MapEntry(r5, r6));
        return new HashPMap(this.intMap.plus(r5.hashCode(), r7), (this.size - r1) + r7.size());
    }

    public HashPMap<K, V> minus(Object r4) {
        ConsPStack<MapEntry<K, V>> r0 = getEntries(r4.hashCode());
        int r1 = keyIndexIn(r0, r4);
        if (r1 != (-1)) goto L5;
        return this;
    L5:
        ConsPStack<MapEntry<K, V>> r2 = r0.minus(r1);
        if (r2.size() != 0) goto L10;
        return new HashPMap(this.intMap.minus(r4.hashCode()), this.size - 1);
    L10:
        return new HashPMap(this.intMap.plus(r4.hashCode(), r2), this.size - 1);
    }

    private ConsPStack<MapEntry<K, V>> getEntries(int r1) {
        ConsPStack<MapEntry<K, V>> r0 = this.intMap.get(r1);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return ConsPStack.empty();
    }

    private static <K, V> int keyIndexIn(ConsPStack<MapEntry<K, V>> r2, Object r3) {
        int r0 = 0;
    L3:
        if (r2 == null) goto L10;
        if (r2.size() <= 0) goto L15;
        if (r2.first.key.equals(r3) == true) goto L8;
        r2 = r2.rest;
        r0 = r0 + 1;
        goto L3
    L8:
        return r0;
    L15:
        return -1;
    L10:
        return -1;
    }
}
