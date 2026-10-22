package androidx.collection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u0005\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000b\u001a7\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000e\u001aG\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0002\u0010\u0011\u001aW\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u0002H\u00052\u0006\u0010\u0013\u001a\u00020\n¢\u0006\u0002\u0010\u0014\u001ag\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u0002H\u00052\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0015\u001a\u0002H\u00052\u0006\u0010\u0016\u001a\u00020\n¢\u0006\u0002\u0010\u0017\u001a\u0012\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u0005\u001a'\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u0019\u001a7\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u001a\u001aG\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0002\u0010\u001b\u001aW\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u0002H\u00052\u0006\u0010\u0013\u001a\u00020\n¢\u0006\u0002\u0010\u001c\u001ag\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u00052\u0006\u0010\b\u001a\u0002H\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u0002H\u00052\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u0002H\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u0002H\u00052\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0015\u001a\u0002H\u00052\u0006\u0010\u0016\u001a\u00020\n¢\u0006\u0002\u0010\u001d\u001aD\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u001d\u0010\u001f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0001\u0012\u0004\u0012\u00020!0 ¢\u0006\u0002\b\"H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001aL\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010#\u001a\u00020$2\u001d\u0010\u001f\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0001\u0012\u0004\u0012\u00020!0 ¢\u0006\u0002\b\"H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\"\u0016\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006%"}, d2 = {"EmptyObjectFloatMap", "Landroidx/collection/MutableObjectFloatMap;", "", "emptyObjectFloatMap", "Landroidx/collection/ObjectFloatMap;", "K", "objectFloatMap", "objectFloatMapOf", "key1", "value1", "", "(Ljava/lang/Object;F)Landroidx/collection/ObjectFloatMap;", "key2", "value2", "(Ljava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/ObjectFloatMap;", "key3", "value3", "(Ljava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/ObjectFloatMap;", "key4", "value4", "(Ljava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/ObjectFloatMap;", "key5", "value5", "(Ljava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/ObjectFloatMap;", "mutableObjectFloatMapOf", "(Ljava/lang/Object;F)Landroidx/collection/MutableObjectFloatMap;", "(Ljava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/MutableObjectFloatMap;", "(Ljava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/MutableObjectFloatMap;", "(Ljava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/MutableObjectFloatMap;", "(Ljava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/MutableObjectFloatMap;", "buildObjectFloatMap", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ObjectFloatMapKt {
    private static final MutableObjectFloatMap<Object> EmptyObjectFloatMap = null;

    static {
        EmptyObjectFloatMap = new MutableObjectFloatMap(0);
    }

    public static final <K> ObjectFloatMap<K> emptyObjectFloatMap() {
        MutableObjectFloatMap<Object> r100 = EmptyObjectFloatMap;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.collection.ObjectFloatMap<K of androidx.collection.ObjectFloatMapKt.emptyObjectFloatMap>");
        return r100;
    }

    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf() {
        return new MutableObjectFloatMap(0, 1, null);
    }

    public static final <K> ObjectFloatMap<K> objectFloatMap() {
        MutableObjectFloatMap<Object> r100 = EmptyObjectFloatMap;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.collection.ObjectFloatMap<K of androidx.collection.ObjectFloatMapKt.objectFloatMap>");
        return r100;
    }

    public static final <K> ObjectFloatMap<K> buildObjectFloatMap(Function1<? super MutableObjectFloatMap<K>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "builderAction");
        MutableObjectFloatMap r101 = new MutableObjectFloatMap(0, 1, null);
        r100.invoke(r101);
        return r101;
    }

    public static final <K> ObjectFloatMap<K> buildObjectFloatMap(int r100, Function1<? super MutableObjectFloatMap<K>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "builderAction");
        MutableObjectFloatMap r102 = new MutableObjectFloatMap(r100);
        r101.invoke(r102);
        return r102;
    }

    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K r100, float r101) {
        MutableObjectFloatMap<K> r102 = new MutableObjectFloatMap(0, 1, null);
        r102.set(r100, r101);
        return r102;
    }

    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K r100, float r101) {
        MutableObjectFloatMap r102 = new MutableObjectFloatMap(0, 1, null);
        r102.set(r100, r101);
        return r102;
    }

    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K r100, float r101, K r102, float r103) {
        MutableObjectFloatMap<K> r104 = new MutableObjectFloatMap(0, 1, null);
        r104.set(r100, r101);
        r104.set(r102, r103);
        return r104;
    }

    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K r100, float r101, K r102, float r103) {
        MutableObjectFloatMap r104 = new MutableObjectFloatMap(0, 1, null);
        r104.set(r100, r101);
        r104.set(r102, r103);
        return r104;
    }

    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K r100, float r101, K r102, float r103, K r104, float r105) {
        MutableObjectFloatMap<K> r106 = new MutableObjectFloatMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        return r106;
    }

    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K r100, float r101, K r102, float r103, K r104, float r105) {
        MutableObjectFloatMap r106 = new MutableObjectFloatMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        return r106;
    }

    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K r100, float r101, K r102, float r103, K r104, float r105, K r110, float r111) {
        MutableObjectFloatMap<K> r106 = new MutableObjectFloatMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        r106.set(r110, r111);
        return r106;
    }

    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K r100, float r101, K r102, float r103, K r104, float r105, K r110, float r111) {
        MutableObjectFloatMap r106 = new MutableObjectFloatMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        r106.set(r110, r111);
        return r106;
    }

    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K r100, float r101, K r102, float r103, K r104, float r105, K r110, float r111, K r112, float r113) {
        MutableObjectFloatMap<K> r106 = new MutableObjectFloatMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        r106.set(r110, r111);
        r106.set(r112, r113);
        return r106;
    }

    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K r100, float r101, K r102, float r103, K r104, float r105, K r110, float r111, K r112, float r113) {
        MutableObjectFloatMap r106 = new MutableObjectFloatMap(0, 1, null);
        r106.set(r100, r101);
        r106.set(r102, r103);
        r106.set(r104, r105);
        r106.set(r110, r111);
        r106.set(r112, r113);
        return r106;
    }
}
