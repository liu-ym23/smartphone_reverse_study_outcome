package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0018\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a7\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\"\u0004\b\u0000\u0010\u000b*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\f\u001a\u0002H\u000bH\u0002¢\u0006\u0002\u0010\r\u001a)\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u000f\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001aL\u0010\u0011\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\b\b\u0002\u0010\u0013\u001a\u00020\u00012\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00160\u0015H\u0082\b¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"MAX_BRANCHING_FACTOR", "", "LOG_MAX_BRANCHING_FACTOR", "MAX_BRANCHING_FACTOR_MINUS_ONE", "MAX_SHIFT", "indexSegment", "index", "shift", "addElementAtIndex", "", "", ExifInterface.LONGITUDE_EAST, "element", "([Ljava/lang/Object;ILjava/lang/Object;)[Ljava/lang/Object;", "removeCellAtIndex", "cellIndex", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "filterTo", "newArray", "newArrayOffset", "predicate", "Lkotlin/Function1;", "", "([Ljava/lang/Object;[Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)I", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TrieNodeKt {
    public static final int LOG_MAX_BRANCHING_FACTOR = 5;
    public static final int MAX_BRANCHING_FACTOR = 32;
    public static final int MAX_BRANCHING_FACTOR_MINUS_ONE = 31;
    public static final int MAX_SHIFT = 30;

    public static final int indexSegment(int r100, int r101) {
        return (r100 >> r101) & 31;
    }

    public static final /* synthetic */ Object[] access$removeCellAtIndex(Object[] r100, int r101) {
        return removeCellAtIndex(r100, r101);
    }

    private static final Object[] removeCellAtIndex(Object[] r100, int r101) {
        Object[] r102 = new Object[r100.length - 1];
        ArraysKt.copyInto$default(r100, r102, 0, 0, r101, 6, null);
        ArraysKt.copyInto(r100, r102, r101, r101 + 1, r100.length);
        return r102;
    }

    public static final /* synthetic */ Object[] access$addElementAtIndex(Object[] r100, int r101, Object r102) {
        return addElementAtIndex(r100, r101, r102);
    }

    private static final <E> Object[] addElementAtIndex(Object[] r100, int r101, E r110) {
        Object[] r102 = new Object[r100.length + 1];
        ArraysKt.copyInto$default(r100, r102, 0, 0, r101, 6, null);
        ArraysKt.copyInto(r100, r102, r101 + 1, r101, r100.length);
        r102[r101] = r110;
        return r102;
    }

    private static final int filterTo(Object[] r100, Object[] r101, int r102, Function1<Object, Boolean> r103) {
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r104 >= r100.length) goto L17;
        boolean r106 = true;
        if (r105 > r104) goto L8;
        boolean r107 = true;
    L9:
        CommonFunctionsKt.m4281assert(r107);
        if (r103.invoke(r100[r104]).booleanValue() == false) goto L16;
        r101[r102 + r105] = r100[r104];
        r105 = r105 + 1;
        if ((r102 + r105) <= r101.length) goto L15;
        r106 = false;
    L15:
        CommonFunctionsKt.m4281assert(r106);
    L16:
        r104 = r104 + 1;
        goto L4
    L8:
        r107 = false;
        goto L9
    L17:
        return r105;
    }

    public static /* synthetic */ int filterTo$default(Object[] r100, Object[] r101, int r102, Function1 r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = AnonymousClass1.INSTANCE;
    L8:
        int r106 = 0;
        int r107 = 0;
    L10:
        if (r106 >= r100.length) goto L23;
        boolean r108 = true;
        if (r107 > r106) goto L14;
        boolean r109 = true;
    L15:
        CommonFunctionsKt.m4281assert(r109);
        if (((Boolean) r103.invoke(r100[r106])).booleanValue() == false) goto L22;
        r101[r102 + r107] = r100[r106];
        r107 = r107 + 1;
        if ((r102 + r107) <= r101.length) goto L21;
        r108 = false;
    L21:
        CommonFunctionsKt.m4281assert(r108);
    L22:
        r106 = r106 + 1;
        goto L10
    L14:
        r109 = false;
        goto L15
    L23:
        return r107;
    }
}
