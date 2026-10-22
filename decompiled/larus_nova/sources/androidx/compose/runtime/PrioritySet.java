package androidx.compose.runtime;

import androidx.collection.MutableIntList;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u000fJ\r\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0014J\r\u0010\u0017\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u001f"}, d2 = {"Landroidx/compose/runtime/PrioritySet;", "", "list", "Landroidx/collection/MutableIntList;", "constructor-impl", "(Landroidx/collection/MutableIntList;)Landroidx/collection/MutableIntList;", "add", "", "value", "", "add-impl", "(Landroidx/collection/MutableIntList;I)V", "isEmpty", "", "isEmpty-impl", "(Landroidx/collection/MutableIntList;)Z", "isNotEmpty", "isNotEmpty-impl", "peek", "peek-impl", "(Landroidx/collection/MutableIntList;)I", "takeMax", "takeMax-impl", "validateHeap", "validateHeap-impl", "(Landroidx/collection/MutableIntList;)V", "equals", "other", "hashCode", "toString", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class PrioritySet {
    private final MutableIntList list;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ PrioritySet m4126boximpl(MutableIntList r100) {
        return new PrioritySet(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static MutableIntList m4127constructorimpl(MutableIntList r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m4129equalsimpl(MutableIntList r100, Object r101) {
        if ((r101 instanceof PrioritySet) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r100, ((PrioritySet) r101).m4138unboximpl()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4130equalsimpl0(MutableIntList r100, MutableIntList r101) {
        return Intrinsics.areEqual(r100, r101);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m4131hashCodeimpl(MutableIntList r100) {
        return r100.hashCode();
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m4136toStringimpl(MutableIntList r100) {
        return "PrioritySet(list=" + r100 + ')';
    }

    public boolean equals(Object r100) {
        return m4129equalsimpl(this.list, r100);
    }

    public int hashCode() {
        return m4131hashCodeimpl(this.list);
    }

    public String toString() {
        return m4136toStringimpl(this.list);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ MutableIntList m4138unboximpl() {
        return this.list;
    }

    private /* synthetic */ PrioritySet(MutableIntList r100) {
        this.list = r100;
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m4132isEmptyimpl(MutableIntList r100) {
        if (r100._size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: isNotEmpty-impl, reason: not valid java name */
    public static final boolean m4133isNotEmptyimpl(MutableIntList r100) {
        if (r100._size == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: peek-impl, reason: not valid java name */
    public static final int m4134peekimpl(MutableIntList r100) {
        return r100.first();
    }

    /* JADX INFO: renamed from: takeMax-impl, reason: not valid java name */
    public static final int m4135takeMaximpl(MutableIntList r110) {
        int r100 = r110._size;
        int r101 = r110.get(0);
    L4:
        if (r110._size == 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L20;
        if (r110.get(0) != r101) goto L20;
        r110.set(0, r110.last());
        r110.removeAt(r110._size - 1);
        int r103 = r110._size;
        int r104 = r103 >>> 1;
        int r105 = 0;
    L11:
        if (r105 >= r104) goto L4;
        int r106 = r110.get(r105);
        int r107 = (r105 + 1) * 2;
        int r108 = r107 - 1;
        int r109 = r110.get(r108);
        if (r107 >= r103) goto L18;
        int r111 = r110.get(r107);
        if (r111 <= r109) goto L18;
        if (r111 <= r106) goto L4;
        r110.set(r105, r111);
        r110.set(r107, r106);
        r105 = r107;
    L18:
        if (r109 <= r106) goto L4;
        r110.set(r105, r109);
        r110.set(r108, r106);
        r105 = r108;
    L20:
        return r101;
    L6:
        r102 = false;
        goto L7
    }

    /* JADX INFO: renamed from: validateHeap-impl, reason: not valid java name */
    public static final void m4137validateHeapimpl(MutableIntList r100) {
        int r101 = r100._size;
        int r102 = r101 / 2;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L19;
        int r104 = r103 + 1;
        int r105 = r104 * 2;
        boolean r106 = true;
        if (r100.get(r103) < r100.get(r105 - 1)) goto L7;
        boolean r107 = true;
    L9:
        if (r107 == true) goto L11;
        PreconditionsKt.throwIllegalStateException("Check failed.");
    L11:
        if (r105 < r101) goto L13;
    L16:
        if (r106 == true) goto L18;
        PreconditionsKt.throwIllegalStateException("Check failed.");
    L18:
        r103 = r104;
        goto L3
    L13:
        if (r100.get(r103) >= r100.get(r105)) goto L16;
        r106 = false;
        goto L16
    L7:
        r107 = false;
        goto L9
    }

    /* JADX INFO: renamed from: add-impl, reason: not valid java name */
    public static final void m4125addimpl(MutableIntList r100, int r101) {
        if (r100._size == 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
    L12:
        int r103 = r100._size;
        r100.add(r101);
    L13:
        if (r103 <= 0) goto L17;
        int r104 = ((r103 + 1) >>> 1) - 1;
        int r105 = r100.get(r104);
        if (r101 <= r105) goto L17;
        r100.set(r103, r105);
        r103 = r104;
    L17:
        r100.set(r103, r101);
        return;
    L8:
        if (r100.get(0) != r101) goto L10;
        return;
    L10:
        if (r100.get(r100._size - 1) != r101) goto L12;
        return;
    L5:
        r102 = false;
        goto L6
    }

    /* JADX INFO: renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ MutableIntList m4128constructorimpl$default(MutableIntList r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L6;
        r100 = new MutableIntList(0, 1, null);
    L6:
        return m4127constructorimpl(r100);
    }
}
