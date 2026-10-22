package androidx.collection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\u001a\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0016\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\u001a2\u0010\u0012\u001a\u00020\u00032\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a:\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00062\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"EmptyIntLongMap", "Landroidx/collection/MutableIntLongMap;", "emptyIntLongMap", "Landroidx/collection/IntLongMap;", "intLongMapOf", "key1", "", "value1", "", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableIntLongMapOf", "buildIntLongMap", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IntLongMapKt {
    private static final MutableIntLongMap EmptyIntLongMap = null;

    static {
        EmptyIntLongMap = new MutableIntLongMap(0);
    }

    public static final MutableIntLongMap mutableIntLongMapOf() {
        return new MutableIntLongMap(0, 1, null);
    }

    public static final IntLongMap emptyIntLongMap() {
        return EmptyIntLongMap;
    }

    public static final IntLongMap intLongMapOf() {
        return EmptyIntLongMap;
    }

    public static final IntLongMap buildIntLongMap(Function1<? super MutableIntLongMap, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "builderAction");
        MutableIntLongMap r101 = new MutableIntLongMap(0, 1, null);
        r100.invoke(r101);
        return r101;
    }

    public static final IntLongMap buildIntLongMap(int r100, Function1<? super MutableIntLongMap, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "builderAction");
        MutableIntLongMap r102 = new MutableIntLongMap(r100);
        r101.invoke(r102);
        return r102;
    }

    public static final IntLongMap intLongMapOf(int r100, long r101) {
        MutableIntLongMap r102 = new MutableIntLongMap(0, 1, null);
        r102.set(r100, r101);
        return r102;
    }

    public static final MutableIntLongMap mutableIntLongMapOf(int r100, long r101) {
        MutableIntLongMap r102 = new MutableIntLongMap(0, 1, null);
        r102.set(r100, r101);
        return r102;
    }

    public static final IntLongMap intLongMapOf(int r100, long r101, int r102, long r103) {
        MutableIntLongMap r104 = new MutableIntLongMap(0, 1, null);
        r104.set(r100, r101);
        r104.set(r102, r103);
        return r104;
    }

    public static final MutableIntLongMap mutableIntLongMapOf(int r100, long r101, int r102, long r103) {
        MutableIntLongMap r104 = new MutableIntLongMap(0, 1, null);
        r104.set(r100, r101);
        r104.set(r102, r103);
        return r104;
    }

    public static final IntLongMap intLongMapOf(int r100, long r101, int r102, long r103, int r110, long r111) {
        MutableIntLongMap r104 = new MutableIntLongMap(0, 1, null);
        r104.set(r100, r101);
        r104.set(r102, r103);
        r104.set(r110, r111);
        return r104;
    }

    public static final MutableIntLongMap mutableIntLongMapOf(int r100, long r101, int r102, long r103, int r110, long r111) {
        MutableIntLongMap r104 = new MutableIntLongMap(0, 1, null);
        r104.set(r100, r101);
        r104.set(r102, r103);
        r104.set(r110, r111);
        return r104;
    }

    public static final IntLongMap intLongMapOf(int r100, long r101, int r102, long r103, int r110, long r111, int r112, long r113) {
        MutableIntLongMap r104 = new MutableIntLongMap(0, 1, null);
        r104.set(r100, r101);
        r104.set(r102, r103);
        r104.set(r110, r111);
        r104.set(r112, r113);
        return r104;
    }

    public static final MutableIntLongMap mutableIntLongMapOf(int r100, long r101, int r102, long r103, int r110, long r111, int r112, long r113) {
        MutableIntLongMap r104 = new MutableIntLongMap(0, 1, null);
        r104.set(r100, r101);
        r104.set(r102, r103);
        r104.set(r110, r111);
        r104.set(r112, r113);
        return r104;
    }

    public static final IntLongMap intLongMapOf(int r100, long r101, int r102, long r103, int r110, long r111, int r112, long r113, int r114, long r115) {
        MutableIntLongMap r104 = new MutableIntLongMap(0, 1, null);
        r104.set(r100, r101);
        r104.set(r102, r103);
        r104.set(r110, r111);
        r104.set(r112, r113);
        r104.set(r114, r115);
        return r104;
    }

    public static final MutableIntLongMap mutableIntLongMapOf(int r100, long r101, int r102, long r103, int r110, long r111, int r112, long r113, int r114, long r115) {
        MutableIntLongMap r104 = new MutableIntLongMap(0, 1, null);
        r104.set(r100, r101);
        r104.set(r102, r103);
        r104.set(r110, r111);
        r104.set(r112, r113);
        r104.set(r114, r115);
        return r104;
    }
}
