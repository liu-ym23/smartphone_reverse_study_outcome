package androidx.collection;

import com.amap.api.col.s.ce;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import faceverify.w;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0006\u0010\b\u001a\u00020\u0007\u001a\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n\u001a\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n\u001a\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a\u0012\u0010\b\u001a\u00020\u00072\n\u0010\r\u001a\u00020\u0003\"\u00020\n\u001a\u0006\u0010\u000e\u001a\u00020\u0001\u001a\u000e\u0010\u000e\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n\u001a\u001e\u0010\u000e\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a\u0012\u0010\u000e\u001a\u00020\u00012\n\u0010\r\u001a\u00020\u0003\"\u00020\n\u001a2\u0010\u000f\u001a\u00020\u00072\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u0013H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a:\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\n2\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u0013H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a\u0011\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2 = {"EmptyIntSet", "Landroidx/collection/MutableIntSet;", "EmptyIntArray", "", "getEmptyIntArray", "()[I", "emptyIntSet", "Landroidx/collection/IntSet;", "intSetOf", "element1", "", "element2", "element3", SlcElement.KEY_ELEMENTS, "mutableIntSetOf", "buildIntSet", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", w.BLOB_ELEM_IMAGE_HASHCODE, ce.f26396k, "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IntSetKt {
    private static final int[] EmptyIntArray = null;
    private static final MutableIntSet EmptyIntSet = null;

    public static final int hash(int r100) {
        int r101 = r100 * ScatterMapKt.MurmurHashC1;
        return r101 ^ (r101 << 16);
    }

    static {
        EmptyIntSet = new MutableIntSet(0);
        EmptyIntArray = new int[0];
    }

    public static final MutableIntSet mutableIntSetOf() {
        int r100 = 0;
        return new MutableIntSet(r100, 1, null);
    }

    public static final IntSet emptyIntSet() {
        return EmptyIntSet;
    }

    public static final int[] getEmptyIntArray() {
        return EmptyIntArray;
    }

    public static final IntSet intSetOf() {
        return EmptyIntSet;
    }

    public static final IntSet buildIntSet(Function1<? super MutableIntSet, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "builderAction");
        int r101 = 0;
        MutableIntSet r102 = new MutableIntSet(r101, 1, null);
        r100.invoke(r102);
        return r102;
    }

    public static final IntSet intSetOf(int... r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        MutableIntSet r101 = new MutableIntSet(r100.length);
        r101.plusAssign(r100);
        return r101;
    }

    public static final MutableIntSet mutableIntSetOf(int... r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        MutableIntSet r101 = new MutableIntSet(r100.length);
        r101.plusAssign(r100);
        return r101;
    }

    public static final IntSet intSetOf(int r100) {
        return mutableIntSetOf(r100);
    }

    public static final MutableIntSet mutableIntSetOf(int r100) {
        MutableIntSet r101 = new MutableIntSet(1);
        r101.plusAssign(r100);
        return r101;
    }

    public static final IntSet buildIntSet(int r100, Function1<? super MutableIntSet, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "builderAction");
        MutableIntSet r102 = new MutableIntSet(r100);
        r101.invoke(r102);
        return r102;
    }

    public static final IntSet intSetOf(int r100, int r101) {
        return mutableIntSetOf(r100, r101);
    }

    public static final MutableIntSet mutableIntSetOf(int r100, int r101) {
        MutableIntSet r102 = new MutableIntSet(2);
        r102.plusAssign(r100);
        r102.plusAssign(r101);
        return r102;
    }

    public static final IntSet intSetOf(int r100, int r101, int r102) {
        return mutableIntSetOf(r100, r101, r102);
    }

    public static final MutableIntSet mutableIntSetOf(int r100, int r101, int r102) {
        MutableIntSet r103 = new MutableIntSet(3);
        r103.plusAssign(r100);
        r103.plusAssign(r101);
        r103.plusAssign(r102);
        return r103;
    }
}
