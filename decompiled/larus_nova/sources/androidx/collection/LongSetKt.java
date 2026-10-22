package androidx.collection;

import com.amap.api.col.s.ce;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import faceverify.w;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0006\u0010\b\u001a\u00020\u0007\u001a\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n\u001a\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n\u001a\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a\u0012\u0010\b\u001a\u00020\u00072\n\u0010\r\u001a\u00020\u0003\"\u00020\n\u001a\u0006\u0010\u000e\u001a\u00020\u0001\u001a\u000e\u0010\u000e\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n\u001a\u001e\u0010\u000e\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a\u0012\u0010\u000e\u001a\u00020\u00012\n\u0010\r\u001a\u00020\u0003\"\u00020\n\u001a2\u0010\u000f\u001a\u00020\u00072\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u0013H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a:\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\b\u0013H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a\u0011\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\nH\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"EmptyLongSet", "Landroidx/collection/MutableLongSet;", "EmptyLongArray", "", "getEmptyLongArray", "()[J", "emptyLongSet", "Landroidx/collection/LongSet;", "longSetOf", "element1", "", "element2", "element3", SlcElement.KEY_ELEMENTS, "mutableLongSetOf", "buildLongSet", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", w.BLOB_ELEM_IMAGE_HASHCODE, ce.f26396k, "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LongSetKt {
    private static final long[] EmptyLongArray = null;
    private static final MutableLongSet EmptyLongSet = null;

    public static final int hash(long r100) {
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * ScatterMapKt.MurmurHashC1;
        return (r101 << 16) ^ r101;
    }

    static {
        EmptyLongSet = new MutableLongSet(0);
        EmptyLongArray = new long[0];
    }

    public static final MutableLongSet mutableLongSetOf() {
        int r100 = 0;
        return new MutableLongSet(r100, 1, null);
    }

    public static final LongSet emptyLongSet() {
        return EmptyLongSet;
    }

    public static final long[] getEmptyLongArray() {
        return EmptyLongArray;
    }

    public static final LongSet longSetOf() {
        return EmptyLongSet;
    }

    public static final LongSet buildLongSet(Function1<? super MutableLongSet, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "builderAction");
        int r101 = 0;
        MutableLongSet r102 = new MutableLongSet(r101, 1, null);
        r100.invoke(r102);
        return r102;
    }

    public static final LongSet longSetOf(long... r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        MutableLongSet r101 = new MutableLongSet(r100.length);
        r101.plusAssign(r100);
        return r101;
    }

    public static final MutableLongSet mutableLongSetOf(long... r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        MutableLongSet r101 = new MutableLongSet(r100.length);
        r101.plusAssign(r100);
        return r101;
    }

    public static final LongSet longSetOf(long r100) {
        return mutableLongSetOf(r100);
    }

    public static final MutableLongSet mutableLongSetOf(long r100) {
        MutableLongSet r101 = new MutableLongSet(1);
        r101.plusAssign(r100);
        return r101;
    }

    public static final LongSet buildLongSet(int r100, Function1<? super MutableLongSet, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "builderAction");
        MutableLongSet r102 = new MutableLongSet(r100);
        r101.invoke(r102);
        return r102;
    }

    public static final LongSet longSetOf(long r100, long r101) {
        return mutableLongSetOf(r100, r101);
    }

    public static final MutableLongSet mutableLongSetOf(long r100, long r101) {
        MutableLongSet r102 = new MutableLongSet(2);
        r102.plusAssign(r100);
        r102.plusAssign(r101);
        return r102;
    }

    public static final LongSet longSetOf(long r100, long r101, long r102) {
        return mutableLongSetOf(r100, r101, r102);
    }

    public static final MutableLongSet mutableLongSetOf(long r100, long r101, long r102) {
        MutableLongSet r103 = new MutableLongSet(3);
        r103.plusAssign(r100);
        r103.plusAssign(r101);
        r103.plusAssign(r102);
        return r103;
    }
}
