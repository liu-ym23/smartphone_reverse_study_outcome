package androidx.compose.runtime;

import androidx.collection.MutableIntList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\t\b\u0081@\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u000eJ\r\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0013J\r\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010 \u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\"\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006#"}, d2 = {"Landroidx/compose/runtime/PrioritySet;", "", "Landroidx/collection/MutableIntList;", "list", "constructor-impl", "(Landroidx/collection/MutableIntList;)Landroidx/collection/MutableIntList;", "", "value", "LC7/r;", "add-impl", "(Landroidx/collection/MutableIntList;I)V", "add", "", "isEmpty-impl", "(Landroidx/collection/MutableIntList;)Z", "isEmpty", "isNotEmpty-impl", "isNotEmpty", "peek-impl", "(Landroidx/collection/MutableIntList;)I", "peek", "takeMax-impl", "takeMax", "validateHeap-impl", "(Landroidx/collection/MutableIntList;)V", "validateHeap", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/collection/MutableIntList;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PrioritySet {
    private final MutableIntList list;

    private /* synthetic */ PrioritySet(MutableIntList mutableIntList) {
        this.list = mutableIntList;
    }

    /* renamed from: add-impl, reason: not valid java name */
    public static final void m3433addimpl(MutableIntList mutableIntList, int i) {
        if (mutableIntList._size == 0 || !(mutableIntList.get(0) == i || mutableIntList.get(mutableIntList._size - 1) == i)) {
            int i6 = mutableIntList._size;
            mutableIntList.add(i);
            while (i6 > 0) {
                int i10 = ((i6 + 1) >>> 1) - 1;
                int i11 = mutableIntList.get(i10);
                if (i <= i11) {
                    break;
                }
                mutableIntList.set(i6, i11);
                i6 = i10;
            }
            mutableIntList.set(i6, i);
        }
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PrioritySet m3434boximpl(MutableIntList mutableIntList) {
        return new PrioritySet(mutableIntList);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static MutableIntList m3435constructorimpl(MutableIntList mutableIntList) {
        return mutableIntList;
    }

    /* renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ MutableIntList m3436constructorimpl$default(MutableIntList mutableIntList, int i, kotlin.jvm.internal.e eVar) {
        int i6 = 1;
        if ((i & 1) != 0) {
            mutableIntList = new MutableIntList(0, i6, null);
        }
        return m3435constructorimpl(mutableIntList);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3437equalsimpl(MutableIntList mutableIntList, Object obj) {
        return (obj instanceof PrioritySet) && kotlin.jvm.internal.k.b(mutableIntList, ((PrioritySet) obj).getList());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3438equalsimpl0(MutableIntList mutableIntList, MutableIntList mutableIntList2) {
        return kotlin.jvm.internal.k.b(mutableIntList, mutableIntList2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3439hashCodeimpl(MutableIntList mutableIntList) {
        return mutableIntList.hashCode();
    }

    /* renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m3440isEmptyimpl(MutableIntList mutableIntList) {
        return mutableIntList._size == 0;
    }

    /* renamed from: isNotEmpty-impl, reason: not valid java name */
    public static final boolean m3441isNotEmptyimpl(MutableIntList mutableIntList) {
        return mutableIntList._size != 0;
    }

    /* renamed from: peek-impl, reason: not valid java name */
    public static final int m3442peekimpl(MutableIntList mutableIntList) {
        return mutableIntList.first();
    }

    /* renamed from: takeMax-impl, reason: not valid java name */
    public static final int m3443takeMaximpl(MutableIntList mutableIntList) {
        int i;
        int i6 = mutableIntList._size;
        int i10 = mutableIntList.get(0);
        while (mutableIntList._size != 0 && mutableIntList.get(0) == i10) {
            mutableIntList.set(0, mutableIntList.last());
            mutableIntList.removeAt(mutableIntList._size - 1);
            int i11 = mutableIntList._size;
            int i12 = i11 >>> 1;
            int i13 = 0;
            while (i13 < i12) {
                int i14 = mutableIntList.get(i13);
                int i15 = (i13 + 1) * 2;
                int i16 = i15 - 1;
                int i17 = mutableIntList.get(i16);
                if (i15 >= i11 || (i = mutableIntList.get(i15)) <= i17) {
                    if (i17 > i14) {
                        mutableIntList.set(i13, i17);
                        mutableIntList.set(i16, i14);
                        i13 = i16;
                    }
                } else if (i > i14) {
                    mutableIntList.set(i13, i);
                    mutableIntList.set(i15, i14);
                    i13 = i15;
                }
            }
        }
        return i10;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3444toStringimpl(MutableIntList mutableIntList) {
        return "PrioritySet(list=" + mutableIntList + ')';
    }

    /* renamed from: validateHeap-impl, reason: not valid java name */
    public static final void m3445validateHeapimpl(MutableIntList mutableIntList) {
        int i = mutableIntList._size;
        int i6 = i / 2;
        int i10 = 0;
        while (i10 < i6) {
            int i11 = i10 + 1;
            int i12 = i11 * 2;
            boolean z10 = true;
            if (!(mutableIntList.get(i10) >= mutableIntList.get(i12 + (-1)))) {
                PreconditionsKt.throwIllegalStateException("Check failed.");
            }
            if (i12 < i && mutableIntList.get(i10) < mutableIntList.get(i12)) {
                z10 = false;
            }
            if (!z10) {
                PreconditionsKt.throwIllegalStateException("Check failed.");
            }
            i10 = i11;
        }
    }

    public boolean equals(Object other) {
        return m3437equalsimpl(this.list, other);
    }

    public int hashCode() {
        return m3439hashCodeimpl(this.list);
    }

    public String toString() {
        return m3444toStringimpl(this.list);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ MutableIntList getList() {
        return this.list;
    }
}
