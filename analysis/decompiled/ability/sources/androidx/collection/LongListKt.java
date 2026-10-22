package androidx.collection;

import S7.k;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0002\u001a\u0015\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\u0006\u001a\u001d\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\b\u001a%\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\n\u001a\u0019\u0010\u0003\u001a\u00020\u00002\n\u0010\f\u001a\u00020\u000b\"\u00020\u0004¢\u0006\u0004\b\u0003\u0010\r\u001a\u0010\u0010\u000f\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0011\u001a\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0012\u001a%\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0013\u001a\u001c\u0010\u000f\u001a\u00020\u000e2\n\u0010\f\u001a\u00020\u000b\"\u00020\u0004H\u0086\b¢\u0006\u0004\b\u000f\u0010\u0014\u001a4\u0010\u0018\u001a\u00020\u00002\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00160\u0015H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0018\u0010\u0019\u001a<\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00160\u0015H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0018\u0010\u001c\"\u0014\u0010\u001d\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"Landroidx/collection/LongList;", "emptyLongList", "()Landroidx/collection/LongList;", "longListOf", "", "element1", "(J)Landroidx/collection/LongList;", "element2", "(JJ)Landroidx/collection/LongList;", "element3", "(JJJ)Landroidx/collection/LongList;", "", "elements", "([J)Landroidx/collection/LongList;", "Landroidx/collection/MutableLongList;", "mutableLongListOf", "()Landroidx/collection/MutableLongList;", "(J)Landroidx/collection/MutableLongList;", "(JJ)Landroidx/collection/MutableLongList;", "(JJJ)Landroidx/collection/MutableLongList;", "([J)Landroidx/collection/MutableLongList;", "Lkotlin/Function1;", "LC7/r;", "builderAction", "buildLongList", "(LS7/k;)Landroidx/collection/LongList;", "", "initialCapacity", "(ILS7/k;)Landroidx/collection/LongList;", "EmptyLongList", "Landroidx/collection/LongList;", "collection"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LongListKt {
    private static final LongList EmptyLongList = new MutableLongList(0);

    public static final LongList buildLongList(k builderAction) {
        kotlin.jvm.internal.k.f(builderAction, "builderAction");
        MutableLongList mutableLongList = new MutableLongList(0, 1, null);
        builderAction.invoke(mutableLongList);
        return mutableLongList;
    }

    public static final LongList emptyLongList() {
        return EmptyLongList;
    }

    public static final LongList longListOf() {
        return EmptyLongList;
    }

    public static final MutableLongList mutableLongListOf() {
        return new MutableLongList(0, 1, null);
    }

    public static final LongList buildLongList(int i, k builderAction) {
        kotlin.jvm.internal.k.f(builderAction, "builderAction");
        MutableLongList mutableLongList = new MutableLongList(i);
        builderAction.invoke(mutableLongList);
        return mutableLongList;
    }

    public static final LongList longListOf(long j5) {
        return mutableLongListOf(j5);
    }

    public static final MutableLongList mutableLongListOf(long j5) {
        MutableLongList mutableLongList = new MutableLongList(1);
        mutableLongList.add(j5);
        return mutableLongList;
    }

    public static final LongList longListOf(long j5, long j6) {
        return mutableLongListOf(j5, j6);
    }

    public static final LongList longListOf(long j5, long j6, long j10) {
        return mutableLongListOf(j5, j6, j10);
    }

    public static final MutableLongList mutableLongListOf(long j5, long j6) {
        MutableLongList mutableLongList = new MutableLongList(2);
        mutableLongList.add(j5);
        mutableLongList.add(j6);
        return mutableLongList;
    }

    public static final LongList longListOf(long... elements) {
        kotlin.jvm.internal.k.f(elements, "elements");
        MutableLongList mutableLongList = new MutableLongList(elements.length);
        mutableLongList.addAll(mutableLongList._size, elements);
        return mutableLongList;
    }

    public static final MutableLongList mutableLongListOf(long j5, long j6, long j10) {
        MutableLongList mutableLongList = new MutableLongList(3);
        mutableLongList.add(j5);
        mutableLongList.add(j6);
        mutableLongList.add(j10);
        return mutableLongList;
    }

    public static final MutableLongList mutableLongListOf(long... elements) {
        kotlin.jvm.internal.k.f(elements, "elements");
        MutableLongList mutableLongList = new MutableLongList(elements.length);
        mutableLongList.addAll(mutableLongList._size, elements);
        return mutableLongList;
    }
}
