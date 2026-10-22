package androidx.collection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006\u001a\u0006\u0010\u0010\u001a\u00020\u0001\u001a\u0016\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a&\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006\u001a6\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006\u001aF\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006\u001aV\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006\u001a2\u0010\u0011\u001a\u00020\u00032\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\b\u0015H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a:\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\b\u0015H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, d2 = {"EmptyLongLongMap", "Landroidx/collection/MutableLongLongMap;", "emptyLongLongMap", "Landroidx/collection/LongLongMap;", "longLongMapOf", "key1", "", "value1", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableLongLongMapOf", "buildLongLongMap", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "initialCapacity", "", "collection"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LongLongMapKt {
    private static final MutableLongLongMap EmptyLongLongMap = null;

    static {
        EmptyLongLongMap = new MutableLongLongMap(0);
    }

    public static final MutableLongLongMap mutableLongLongMapOf() {
        return new MutableLongLongMap(0, 1, null);
    }

    public static final LongLongMap emptyLongLongMap() {
        return EmptyLongLongMap;
    }

    public static final LongLongMap longLongMapOf() {
        return EmptyLongLongMap;
    }

    public static final LongLongMap buildLongLongMap(Function1<? super MutableLongLongMap, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "builderAction");
        MutableLongLongMap r101 = new MutableLongLongMap(0, 1, null);
        r100.invoke(r101);
        return r101;
    }

    public static final LongLongMap buildLongLongMap(int r100, Function1<? super MutableLongLongMap, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "builderAction");
        MutableLongLongMap r102 = new MutableLongLongMap(r100);
        r101.invoke(r102);
        return r102;
    }

    public static final LongLongMap longLongMapOf(long r100, long r101) {
        MutableLongLongMap r102 = new MutableLongLongMap(0, 1, null);
        r102.set(r100, r101);
        return r102;
    }

    public static final MutableLongLongMap mutableLongLongMapOf(long r100, long r101) {
        MutableLongLongMap r102 = new MutableLongLongMap(0, 1, null);
        r102.set(r100, r101);
        return r102;
    }

    public static final LongLongMap longLongMapOf(long r100, long r101, long r102, long r110) {
        MutableLongLongMap r103 = new MutableLongLongMap(0, 1, null);
        r103.set(r100, r101);
        r103.set(r102, r110);
        return r103;
    }

    public static final MutableLongLongMap mutableLongLongMapOf(long r100, long r101, long r102, long r110) {
        MutableLongLongMap r103 = new MutableLongLongMap(0, 1, null);
        r103.set(r100, r101);
        r103.set(r102, r110);
        return r103;
    }

    public static final LongLongMap longLongMapOf(long r100, long r101, long r102, long r110, long r111, long r112) {
        MutableLongLongMap r103 = new MutableLongLongMap(0, 1, null);
        r103.set(r100, r101);
        r103.set(r102, r110);
        r103.set(r111, r112);
        return r103;
    }

    public static final MutableLongLongMap mutableLongLongMapOf(long r100, long r101, long r102, long r110, long r111, long r112) {
        MutableLongLongMap r103 = new MutableLongLongMap(0, 1, null);
        r103.set(r100, r101);
        r103.set(r102, r110);
        r103.set(r111, r112);
        return r103;
    }

    public static final LongLongMap longLongMapOf(long r100, long r101, long r102, long r110, long r111, long r112, long r113, long r114) {
        MutableLongLongMap r103 = new MutableLongLongMap(0, 1, null);
        r103.set(r100, r101);
        r103.set(r102, r110);
        r103.set(r111, r112);
        r103.set(r113, r114);
        return r103;
    }

    public static final MutableLongLongMap mutableLongLongMapOf(long r100, long r101, long r102, long r110, long r111, long r112, long r113, long r114) {
        MutableLongLongMap r103 = new MutableLongLongMap(0, 1, null);
        r103.set(r100, r101);
        r103.set(r102, r110);
        r103.set(r111, r112);
        r103.set(r113, r114);
        return r103;
    }

    public static final LongLongMap longLongMapOf(long r100, long r101, long r102, long r110, long r111, long r112, long r113, long r114, long r210, long r211) {
        MutableLongLongMap r103 = new MutableLongLongMap(0, 1, null);
        r103.set(r100, r101);
        r103.set(r102, r110);
        r103.set(r111, r112);
        r103.set(r113, r114);
        r103.set(r210, r211);
        return r103;
    }

    public static final MutableLongLongMap mutableLongLongMapOf(long r100, long r101, long r102, long r110, long r111, long r112, long r113, long r114, long r210, long r211) {
        MutableLongLongMap r103 = new MutableLongLongMap(0, 1, null);
        r103.set(r100, r101);
        r103.set(r102, r110);
        r103.set(r111, r112);
        r103.set(r113, r114);
        r103.set(r210, r211);
        return r103;
    }
}
