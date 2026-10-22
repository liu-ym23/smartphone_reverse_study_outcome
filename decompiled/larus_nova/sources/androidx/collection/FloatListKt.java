package androidx.collection;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u000e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005\u001a\u0012\u0010\u0003\u001a\u00020\u00012\n\u0010\b\u001a\u00020\t\"\u00020\u0005\u001a\t\u0010\n\u001a\u00020\u000bH\u0086\b\u001a\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005\u001a\u0015\u0010\n\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\t\"\u00020\u0005H\u0086\b\u001a2\u0010\f\u001a\u00020\u00012\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\b\u0010H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a:\u0010\f\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\b\u0010H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"EmptyFloatList", "Landroidx/collection/FloatList;", "emptyFloatList", "floatListOf", "element1", "", "element2", "element3", SlcElement.KEY_ELEMENTS, "", "mutableFloatListOf", "Landroidx/collection/MutableFloatList;", "buildFloatList", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FloatListKt {
    private static final FloatList EmptyFloatList = null;

    static {
        EmptyFloatList = new MutableFloatList(0);
    }

    public static final MutableFloatList mutableFloatListOf() {
        return new MutableFloatList(0, 1, null);
    }

    public static final FloatList emptyFloatList() {
        return EmptyFloatList;
    }

    public static final FloatList floatListOf() {
        return EmptyFloatList;
    }

    public static final FloatList buildFloatList(Function1<? super MutableFloatList, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "builderAction");
        MutableFloatList r101 = new MutableFloatList(0, 1, null);
        r100.invoke(r101);
        return r101;
    }

    public static final FloatList floatListOf(float... r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        MutableFloatList r101 = new MutableFloatList(r100.length);
        r101.addAll(r101._size, r100);
        return r101;
    }

    public static final MutableFloatList mutableFloatListOf(float... r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        MutableFloatList r101 = new MutableFloatList(r100.length);
        r101.addAll(r101._size, r100);
        return r101;
    }

    public static final FloatList floatListOf(float r100) {
        return mutableFloatListOf(r100);
    }

    public static final MutableFloatList mutableFloatListOf(float r100) {
        MutableFloatList r101 = new MutableFloatList(1);
        r101.add(r100);
        return r101;
    }

    public static final FloatList buildFloatList(int r100, Function1<? super MutableFloatList, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "builderAction");
        MutableFloatList r102 = new MutableFloatList(r100);
        r101.invoke(r102);
        return r102;
    }

    public static final FloatList floatListOf(float r100, float r101) {
        return mutableFloatListOf(r100, r101);
    }

    public static final MutableFloatList mutableFloatListOf(float r100, float r101) {
        MutableFloatList r102 = new MutableFloatList(2);
        r102.add(r100);
        r102.add(r101);
        return r102;
    }

    public static final FloatList floatListOf(float r100, float r101, float r102) {
        return mutableFloatListOf(r100, r101, r102);
    }

    public static final MutableFloatList mutableFloatListOf(float r100, float r101, float r102) {
        MutableFloatList r103 = new MutableFloatList(3);
        r103.add(r100);
        r103.add(r101);
        r103.add(r102);
        return r103;
    }
}
