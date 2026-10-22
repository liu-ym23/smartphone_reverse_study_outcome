package androidx.collection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001a'\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u0002H\u0005¢\u0006\u0002\u0010\n\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u0002H\u0005¢\u0006\u0002\u0010\r\u001aG\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0010\u001aW\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0013\u001ag\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u0002H\u00052\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0016\u001a\u0012\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u0005\u001a'\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0018\u001a7\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u0002H\u0005¢\u0006\u0002\u0010\u0019\u001aG\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u0002H\u0005¢\u0006\u0002\u0010\u001a\u001aW\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u0002H\u0005¢\u0006\u0002\u0010\u001b\u001ag\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u0002H\u00052\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u0002H\u00052\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u0002H\u0005¢\u0006\u0002\u0010\u001c\u001aD\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u001d\u0010\u001e\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0001\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0002\b!H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001aL\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\"\u001a\u00020#2\u001d\u0010\u001e\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0001\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0002\b!H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, d2 = {"EmptyFloatObjectMap", "Landroidx/collection/MutableFloatObjectMap;", "", "emptyFloatObjectMap", "Landroidx/collection/FloatObjectMap;", "V", "floatObjectMapOf", "key1", "", "value1", "(FLjava/lang/Object;)Landroidx/collection/FloatObjectMap;", "key2", "value2", "(FLjava/lang/Object;FLjava/lang/Object;)Landroidx/collection/FloatObjectMap;", "key3", "value3", "(FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;)Landroidx/collection/FloatObjectMap;", "key4", "value4", "(FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;)Landroidx/collection/FloatObjectMap;", "key5", "value5", "(FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;)Landroidx/collection/FloatObjectMap;", "mutableFloatObjectMapOf", "(FLjava/lang/Object;)Landroidx/collection/MutableFloatObjectMap;", "(FLjava/lang/Object;FLjava/lang/Object;)Landroidx/collection/MutableFloatObjectMap;", "(FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;)Landroidx/collection/MutableFloatObjectMap;", "(FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;)Landroidx/collection/MutableFloatObjectMap;", "(FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;)Landroidx/collection/MutableFloatObjectMap;", "buildFloatObjectMap", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FloatObjectMapKt {
    private static final MutableFloatObjectMap EmptyFloatObjectMap = null;

    static {
        EmptyFloatObjectMap = new MutableFloatObjectMap(0);
    }

    public static final <V> FloatObjectMap<V> emptyFloatObjectMap() {
        MutableFloatObjectMap r100 = EmptyFloatObjectMap;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.collection.FloatObjectMap<V of androidx.collection.FloatObjectMapKt.emptyFloatObjectMap>");
        return r100;
    }

    public static final <V> FloatObjectMap<V> floatObjectMapOf() {
        MutableFloatObjectMap r100 = EmptyFloatObjectMap;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.collection.FloatObjectMap<V of androidx.collection.FloatObjectMapKt.floatObjectMapOf>");
        return r100;
    }

    public static final <V> MutableFloatObjectMap<V> mutableFloatObjectMapOf() {
        return new MutableFloatObjectMap(0, 1, null);
    }

    public static final <V> FloatObjectMap<V> buildFloatObjectMap(Function1<? super MutableFloatObjectMap<V>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "builderAction");
        MutableFloatObjectMap r101 = new MutableFloatObjectMap(0, 1, null);
        r100.invoke(r101);
        return r101;
    }

    public static final <V> FloatObjectMap<V> buildFloatObjectMap(int r100, Function1<? super MutableFloatObjectMap<V>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "builderAction");
        MutableFloatObjectMap r102 = new MutableFloatObjectMap(r100);
        r101.invoke(r102);
        return r102;
    }

    public static final <V> FloatObjectMap<V> floatObjectMapOf(float r100, V r101) {
        MutableFloatObjectMap r102 = new MutableFloatObjectMap(0, 1, null);
        r102.set(r100, r101);
        return r102;
    }

    public static final <V> MutableFloatObjectMap<V> mutableFloatObjectMapOf(float r100, V r101) {
        MutableFloatObjectMap<V> r102 = new MutableFloatObjectMap(0, 1, null);
        r102.set(r100, r101);
        return r102;
    }

    public static final <V> FloatObjectMap<V> floatObjectMapOf(float r100, V r101, float r102, V r103) {
        MutableFloatObjectMap r104 = new MutableFloatObjectMap(0, 1, null);
        r104.set(r100, r101);
        r104.set(r102, r103);
        return r104;
    }

    public static final <V> MutableFloatObjectMap<V> mutableFloatObjectMapOf(float r100, V r101, float r102, V r103) {
        MutableFloatObjectMap<V> r104 = new MutableFloatObjectMap(0, 1, null);
        r104.set(r100, r101);
        r104.set(r102, r103);
        return r104;
    }

    public static final <V> FloatObjectMap<V> floatObjectMapOf(float r100, V r101, float r102, V r103, float r104, V r105) {
        MutableFloatObjectMap r106 = new MutableFloatObjectMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        return r106;
    }

    public static final <V> MutableFloatObjectMap<V> mutableFloatObjectMapOf(float r100, V r101, float r102, V r103, float r104, V r105) {
        MutableFloatObjectMap<V> r106 = new MutableFloatObjectMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        return r106;
    }

    public static final <V> FloatObjectMap<V> floatObjectMapOf(float r100, V r101, float r102, V r103, float r104, V r105, float r110, V r111) {
        MutableFloatObjectMap r106 = new MutableFloatObjectMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        r106.set(r110, r111);
        return r106;
    }

    public static final <V> MutableFloatObjectMap<V> mutableFloatObjectMapOf(float r100, V r101, float r102, V r103, float r104, V r105, float r110, V r111) {
        MutableFloatObjectMap<V> r106 = new MutableFloatObjectMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        r106.set(r110, r111);
        return r106;
    }

    public static final <V> FloatObjectMap<V> floatObjectMapOf(float r100, V r101, float r102, V r103, float r104, V r105, float r110, V r111, float r112, V r113) {
        MutableFloatObjectMap r106 = new MutableFloatObjectMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        r106.set(r110, r111);
        r106.set(r112, r113);
        return r106;
    }

    public static final <V> MutableFloatObjectMap<V> mutableFloatObjectMapOf(float r100, V r101, float r102, V r103, float r104, V r105, float r110, V r111, float r112, V r113) {
        MutableFloatObjectMap<V> r106 = new MutableFloatObjectMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        r106.set(r110, r111);
        r106.set(r112, r113);
        return r106;
    }
}
