package androidx.collection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\u001a\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0016\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\u001a2\u0010\u0012\u001a\u00020\u00032\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a:\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\b2\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"EmptyFloatIntMap", "Landroidx/collection/MutableFloatIntMap;", "emptyFloatIntMap", "Landroidx/collection/FloatIntMap;", "floatIntMapOf", "key1", "", "value1", "", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableFloatIntMapOf", "buildFloatIntMap", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FloatIntMapKt {
    private static final MutableFloatIntMap EmptyFloatIntMap = null;

    static {
        EmptyFloatIntMap = new MutableFloatIntMap(0);
    }

    public static final MutableFloatIntMap mutableFloatIntMapOf() {
        return new MutableFloatIntMap(0, 1, null);
    }

    public static final FloatIntMap emptyFloatIntMap() {
        return EmptyFloatIntMap;
    }

    public static final FloatIntMap floatIntMapOf() {
        return EmptyFloatIntMap;
    }

    public static final FloatIntMap buildFloatIntMap(Function1<? super MutableFloatIntMap, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "builderAction");
        MutableFloatIntMap r101 = new MutableFloatIntMap(0, 1, null);
        r100.invoke(r101);
        return r101;
    }

    public static final FloatIntMap buildFloatIntMap(int r100, Function1<? super MutableFloatIntMap, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "builderAction");
        MutableFloatIntMap r102 = new MutableFloatIntMap(r100);
        r101.invoke(r102);
        return r102;
    }

    public static final FloatIntMap floatIntMapOf(float r100, int r101) {
        MutableFloatIntMap r102 = new MutableFloatIntMap(0, 1, null);
        r102.set(r100, r101);
        return r102;
    }

    public static final MutableFloatIntMap mutableFloatIntMapOf(float r100, int r101) {
        MutableFloatIntMap r102 = new MutableFloatIntMap(0, 1, null);
        r102.set(r100, r101);
        return r102;
    }

    public static final FloatIntMap floatIntMapOf(float r100, int r101, float r102, int r103) {
        MutableFloatIntMap r104 = new MutableFloatIntMap(0, 1, null);
        r104.set(r100, r101);
        r104.set(r102, r103);
        return r104;
    }

    public static final MutableFloatIntMap mutableFloatIntMapOf(float r100, int r101, float r102, int r103) {
        MutableFloatIntMap r104 = new MutableFloatIntMap(0, 1, null);
        r104.set(r100, r101);
        r104.set(r102, r103);
        return r104;
    }

    public static final FloatIntMap floatIntMapOf(float r100, int r101, float r102, int r103, float r104, int r105) {
        MutableFloatIntMap r106 = new MutableFloatIntMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        return r106;
    }

    public static final MutableFloatIntMap mutableFloatIntMapOf(float r100, int r101, float r102, int r103, float r104, int r105) {
        MutableFloatIntMap r106 = new MutableFloatIntMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        return r106;
    }

    public static final FloatIntMap floatIntMapOf(float r100, int r101, float r102, int r103, float r104, int r105, float r110, int r111) {
        MutableFloatIntMap r106 = new MutableFloatIntMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        r106.set(r110, r111);
        return r106;
    }

    public static final MutableFloatIntMap mutableFloatIntMapOf(float r100, int r101, float r102, int r103, float r104, int r105, float r110, int r111) {
        MutableFloatIntMap r106 = new MutableFloatIntMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        r106.set(r110, r111);
        return r106;
    }

    public static final FloatIntMap floatIntMapOf(float r100, int r101, float r102, int r103, float r104, int r105, float r110, int r111, float r112, int r113) {
        MutableFloatIntMap r106 = new MutableFloatIntMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        r106.set(r110, r111);
        r106.set(r112, r113);
        return r106;
    }

    public static final MutableFloatIntMap mutableFloatIntMapOf(float r100, int r101, float r102, int r103, float r104, int r105, float r110, int r111, float r112, int r113) {
        MutableFloatIntMap r106 = new MutableFloatIntMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        r106.set(r110, r111);
        r106.set(r112, r113);
        return r106;
    }
}
