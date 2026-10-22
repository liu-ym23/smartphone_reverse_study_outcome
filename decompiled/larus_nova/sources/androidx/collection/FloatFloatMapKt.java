package androidx.collection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006\u001a\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0016\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a&\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006\u001a6\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006\u001aF\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006\u001aV\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006\u001a2\u0010\u0011\u001a\u00020\u00032\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\b\u0015H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a:\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\b\u0015H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"EmptyFloatFloatMap", "Landroidx/collection/MutableFloatFloatMap;", "emptyFloatFloatMap", "Landroidx/collection/FloatFloatMap;", "floatFloatMapOf", "key1", "", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableFloatFloatMapOf", "buildFloatFloatMap", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FloatFloatMapKt {
    private static final MutableFloatFloatMap EmptyFloatFloatMap = null;

    static {
        EmptyFloatFloatMap = new MutableFloatFloatMap(0);
    }

    public static final MutableFloatFloatMap mutableFloatFloatMapOf() {
        return new MutableFloatFloatMap(0, 1, null);
    }

    public static final FloatFloatMap emptyFloatFloatMap() {
        return EmptyFloatFloatMap;
    }

    public static final FloatFloatMap floatFloatMapOf() {
        return EmptyFloatFloatMap;
    }

    public static final FloatFloatMap buildFloatFloatMap(Function1<? super MutableFloatFloatMap, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "builderAction");
        MutableFloatFloatMap r101 = new MutableFloatFloatMap(0, 1, null);
        r100.invoke(r101);
        return r101;
    }

    public static final FloatFloatMap buildFloatFloatMap(int r100, Function1<? super MutableFloatFloatMap, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "builderAction");
        MutableFloatFloatMap r102 = new MutableFloatFloatMap(r100);
        r101.invoke(r102);
        return r102;
    }

    public static final FloatFloatMap floatFloatMapOf(float r100, float r101) {
        MutableFloatFloatMap r102 = new MutableFloatFloatMap(0, 1, null);
        r102.set(r100, r101);
        return r102;
    }

    public static final MutableFloatFloatMap mutableFloatFloatMapOf(float r100, float r101) {
        MutableFloatFloatMap r102 = new MutableFloatFloatMap(0, 1, null);
        r102.set(r100, r101);
        return r102;
    }

    public static final FloatFloatMap floatFloatMapOf(float r100, float r101, float r102, float r103) {
        MutableFloatFloatMap r104 = new MutableFloatFloatMap(0, 1, null);
        r104.set(r100, r101);
        r104.set(r102, r103);
        return r104;
    }

    public static final MutableFloatFloatMap mutableFloatFloatMapOf(float r100, float r101, float r102, float r103) {
        MutableFloatFloatMap r104 = new MutableFloatFloatMap(0, 1, null);
        r104.set(r100, r101);
        r104.set(r102, r103);
        return r104;
    }

    public static final FloatFloatMap floatFloatMapOf(float r100, float r101, float r102, float r103, float r104, float r105) {
        MutableFloatFloatMap r106 = new MutableFloatFloatMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        return r106;
    }

    public static final MutableFloatFloatMap mutableFloatFloatMapOf(float r100, float r101, float r102, float r103, float r104, float r105) {
        MutableFloatFloatMap r106 = new MutableFloatFloatMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        return r106;
    }

    public static final FloatFloatMap floatFloatMapOf(float r100, float r101, float r102, float r103, float r104, float r105, float r110, float r111) {
        MutableFloatFloatMap r106 = new MutableFloatFloatMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        r106.set(r110, r111);
        return r106;
    }

    public static final MutableFloatFloatMap mutableFloatFloatMapOf(float r100, float r101, float r102, float r103, float r104, float r105, float r110, float r111) {
        MutableFloatFloatMap r106 = new MutableFloatFloatMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        r106.set(r110, r111);
        return r106;
    }

    public static final FloatFloatMap floatFloatMapOf(float r100, float r101, float r102, float r103, float r104, float r105, float r110, float r111, float r112, float r113) {
        MutableFloatFloatMap r106 = new MutableFloatFloatMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        r106.set(r110, r111);
        r106.set(r112, r113);
        return r106;
    }

    public static final MutableFloatFloatMap mutableFloatFloatMapOf(float r100, float r101, float r102, float r103, float r104, float r105, float r110, float r111, float r112, float r113) {
        MutableFloatFloatMap r106 = new MutableFloatFloatMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        r106.set(r110, r111);
        r106.set(r112, r113);
        return r106;
    }
}
