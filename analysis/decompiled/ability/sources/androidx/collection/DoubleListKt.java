package androidx.collection;

import S7.k;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0002\u001a\u0015\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\u0006\u001a\u001d\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\b\u001a%\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\n\u001a\u0019\u0010\u0003\u001a\u00020\u00002\n\u0010\f\u001a\u00020\u000b\"\u00020\u0004¢\u0006\u0004\b\u0003\u0010\r\u001a\u0010\u0010\u000f\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0011\u001a\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0012\u001a%\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0013\u001a\u001c\u0010\u000f\u001a\u00020\u000e2\n\u0010\f\u001a\u00020\u000b\"\u00020\u0004H\u0086\b¢\u0006\u0004\b\u000f\u0010\u0014\u001a4\u0010\u0018\u001a\u00020\u00002\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00160\u0015H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a<\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00160\u0015H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0018\u0010\u001c\"\u0014\u0010\u001d\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"Landroidx/collection/DoubleList;", "emptyDoubleList", "()Landroidx/collection/DoubleList;", "doubleListOf", "", "element1", "(D)Landroidx/collection/DoubleList;", "element2", "(DD)Landroidx/collection/DoubleList;", "element3", "(DDD)Landroidx/collection/DoubleList;", "", "elements", "([D)Landroidx/collection/DoubleList;", "Landroidx/collection/MutableDoubleList;", "mutableDoubleListOf", "()Landroidx/collection/MutableDoubleList;", "(D)Landroidx/collection/MutableDoubleList;", "(DD)Landroidx/collection/MutableDoubleList;", "(DDD)Landroidx/collection/MutableDoubleList;", "([D)Landroidx/collection/MutableDoubleList;", "Lkotlin/Function1;", "LC7/r;", "builderAction", "buildDoubleList", "(LS7/k;)Landroidx/collection/DoubleList;", "", "initialCapacity", "(ILS7/k;)Landroidx/collection/DoubleList;", "EmptyDoubleList", "Landroidx/collection/DoubleList;", "collection"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DoubleListKt {
    private static final DoubleList EmptyDoubleList = new MutableDoubleList(0);

    public static final DoubleList buildDoubleList(k builderAction) {
        kotlin.jvm.internal.k.f(builderAction, "builderAction");
        MutableDoubleList mutableDoubleList = new MutableDoubleList(0, 1, null);
        builderAction.invoke(mutableDoubleList);
        return mutableDoubleList;
    }

    public static final DoubleList doubleListOf() {
        return EmptyDoubleList;
    }

    public static final DoubleList emptyDoubleList() {
        return EmptyDoubleList;
    }

    public static final MutableDoubleList mutableDoubleListOf() {
        return new MutableDoubleList(0, 1, null);
    }

    public static final DoubleList buildDoubleList(int i, k builderAction) {
        kotlin.jvm.internal.k.f(builderAction, "builderAction");
        MutableDoubleList mutableDoubleList = new MutableDoubleList(i);
        builderAction.invoke(mutableDoubleList);
        return mutableDoubleList;
    }

    public static final DoubleList doubleListOf(double d) {
        return mutableDoubleListOf(d);
    }

    public static final MutableDoubleList mutableDoubleListOf(double d) {
        MutableDoubleList mutableDoubleList = new MutableDoubleList(1);
        mutableDoubleList.add(d);
        return mutableDoubleList;
    }

    public static final DoubleList doubleListOf(double d, double d6) {
        return mutableDoubleListOf(d, d6);
    }

    public static final DoubleList doubleListOf(double d, double d6, double d10) {
        return mutableDoubleListOf(d, d6, d10);
    }

    public static final MutableDoubleList mutableDoubleListOf(double d, double d6) {
        MutableDoubleList mutableDoubleList = new MutableDoubleList(2);
        mutableDoubleList.add(d);
        mutableDoubleList.add(d6);
        return mutableDoubleList;
    }

    public static final DoubleList doubleListOf(double... elements) {
        kotlin.jvm.internal.k.f(elements, "elements");
        MutableDoubleList mutableDoubleList = new MutableDoubleList(elements.length);
        mutableDoubleList.addAll(mutableDoubleList._size, elements);
        return mutableDoubleList;
    }

    public static final MutableDoubleList mutableDoubleListOf(double d, double d6, double d10) {
        MutableDoubleList mutableDoubleList = new MutableDoubleList(3);
        mutableDoubleList.add(d);
        mutableDoubleList.add(d6);
        mutableDoubleList.add(d10);
        return mutableDoubleList;
    }

    public static final MutableDoubleList mutableDoubleListOf(double... elements) {
        kotlin.jvm.internal.k.f(elements, "elements");
        MutableDoubleList mutableDoubleList = new MutableDoubleList(elements.length);
        mutableDoubleList.addAll(mutableDoubleList._size, elements);
        return mutableDoubleList;
    }
}
