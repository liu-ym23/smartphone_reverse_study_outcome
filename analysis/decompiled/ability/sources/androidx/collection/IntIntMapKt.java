package androidx.collection;

import S7.k;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0002\u001a\u001d\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\u0007\u001a-\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\n\u001a=\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\r\u001aM\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\u0010\u001a]\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\u0013\u001a\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001d\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0017\u001a-\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0018\u001a=\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0019\u001aM\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u001a\u001a]\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u001b\u001a4\u0010\u001f\u001a\u00020\u00002\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001d0\u001cH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u001f\u0010 \u001a<\u0010\u001f\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00042\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001d0\u001cH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u001f\u0010\"\"\u0014\u0010#\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006%"}, d2 = {"Landroidx/collection/IntIntMap;", "emptyIntIntMap", "()Landroidx/collection/IntIntMap;", "intIntMapOf", "", "key1", "value1", "(II)Landroidx/collection/IntIntMap;", "key2", "value2", "(IIII)Landroidx/collection/IntIntMap;", "key3", "value3", "(IIIIII)Landroidx/collection/IntIntMap;", "key4", "value4", "(IIIIIIII)Landroidx/collection/IntIntMap;", "key5", "value5", "(IIIIIIIIII)Landroidx/collection/IntIntMap;", "Landroidx/collection/MutableIntIntMap;", "mutableIntIntMapOf", "()Landroidx/collection/MutableIntIntMap;", "(II)Landroidx/collection/MutableIntIntMap;", "(IIII)Landroidx/collection/MutableIntIntMap;", "(IIIIII)Landroidx/collection/MutableIntIntMap;", "(IIIIIIII)Landroidx/collection/MutableIntIntMap;", "(IIIIIIIIII)Landroidx/collection/MutableIntIntMap;", "Lkotlin/Function1;", "LC7/r;", "builderAction", "buildIntIntMap", "(LS7/k;)Landroidx/collection/IntIntMap;", "initialCapacity", "(ILS7/k;)Landroidx/collection/IntIntMap;", "EmptyIntIntMap", "Landroidx/collection/MutableIntIntMap;", "collection"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IntIntMapKt {
    private static final MutableIntIntMap EmptyIntIntMap = new MutableIntIntMap(0);

    public static final IntIntMap buildIntIntMap(k builderAction) {
        kotlin.jvm.internal.k.f(builderAction, "builderAction");
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        builderAction.invoke(mutableIntIntMap);
        return mutableIntIntMap;
    }

    public static final IntIntMap emptyIntIntMap() {
        return EmptyIntIntMap;
    }

    public static final IntIntMap intIntMapOf() {
        return EmptyIntIntMap;
    }

    public static final MutableIntIntMap mutableIntIntMapOf() {
        return new MutableIntIntMap(0, 1, null);
    }

    public static final IntIntMap buildIntIntMap(int i, k builderAction) {
        kotlin.jvm.internal.k.f(builderAction, "builderAction");
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(i);
        builderAction.invoke(mutableIntIntMap);
        return mutableIntIntMap;
    }

    public static final IntIntMap intIntMapOf(int i, int i6) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i6);
        return mutableIntIntMap;
    }

    public static final MutableIntIntMap mutableIntIntMapOf(int i, int i6) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i6);
        return mutableIntIntMap;
    }

    public static final IntIntMap intIntMapOf(int i, int i6, int i10, int i11) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i6);
        mutableIntIntMap.set(i10, i11);
        return mutableIntIntMap;
    }

    public static final MutableIntIntMap mutableIntIntMapOf(int i, int i6, int i10, int i11) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i6);
        mutableIntIntMap.set(i10, i11);
        return mutableIntIntMap;
    }

    public static final IntIntMap intIntMapOf(int i, int i6, int i10, int i11, int i12, int i13) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i6);
        mutableIntIntMap.set(i10, i11);
        mutableIntIntMap.set(i12, i13);
        return mutableIntIntMap;
    }

    public static final MutableIntIntMap mutableIntIntMapOf(int i, int i6, int i10, int i11, int i12, int i13) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i6);
        mutableIntIntMap.set(i10, i11);
        mutableIntIntMap.set(i12, i13);
        return mutableIntIntMap;
    }

    public static final IntIntMap intIntMapOf(int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i6);
        mutableIntIntMap.set(i10, i11);
        mutableIntIntMap.set(i12, i13);
        mutableIntIntMap.set(i14, i15);
        return mutableIntIntMap;
    }

    public static final MutableIntIntMap mutableIntIntMapOf(int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i6);
        mutableIntIntMap.set(i10, i11);
        mutableIntIntMap.set(i12, i13);
        mutableIntIntMap.set(i14, i15);
        return mutableIntIntMap;
    }

    public static final IntIntMap intIntMapOf(int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i6);
        mutableIntIntMap.set(i10, i11);
        mutableIntIntMap.set(i12, i13);
        mutableIntIntMap.set(i14, i15);
        mutableIntIntMap.set(i16, i17);
        return mutableIntIntMap;
    }

    public static final MutableIntIntMap mutableIntIntMapOf(int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i6);
        mutableIntIntMap.set(i10, i11);
        mutableIntIntMap.set(i12, i13);
        mutableIntIntMap.set(i14, i15);
        mutableIntIntMap.set(i16, i17);
        return mutableIntIntMap;
    }
}
