package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import D7.q;
import S7.k;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u001a\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a9\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\b\u0000\u0010\u0005*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\t\u0010\n\u001a+\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\f\u0010\r\u001aN\u0010\u0013\u001a\u00020\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00002\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00110\u0010H\u0082\b¢\u0006\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0015\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\"\u0014\u0010\u0017\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016\"\u0014\u0010\u0018\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016\"\u0014\u0010\u0019\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016¨\u0006\u001a"}, d2 = {"", "index", "shift", "indexSegment", "(II)I", ExifInterface.LONGITUDE_EAST, "", "", "element", "addElementAtIndex", "([Ljava/lang/Object;ILjava/lang/Object;)[Ljava/lang/Object;", "cellIndex", "removeCellAtIndex", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "newArray", "newArrayOffset", "Lkotlin/Function1;", "", "predicate", "filterTo", "([Ljava/lang/Object;[Ljava/lang/Object;ILS7/k;)I", "MAX_BRANCHING_FACTOR", "I", "LOG_MAX_BRANCHING_FACTOR", "MAX_BRANCHING_FACTOR_MINUS_ONE", "MAX_SHIFT", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TrieNodeKt {
    public static final int LOG_MAX_BRANCHING_FACTOR = 5;
    public static final int MAX_BRANCHING_FACTOR = 32;
    public static final int MAX_BRANCHING_FACTOR_MINUS_ONE = 31;
    public static final int MAX_SHIFT = 30;

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> Object[] addElementAtIndex(Object[] objArr, int i, E e) {
        Object[] objArr2 = new Object[objArr.length + 1];
        q.b0(objArr, objArr2, 0, 0, i, 6);
        q.X(objArr, objArr2, i + 1, i, objArr.length);
        objArr2[i] = e;
        return objArr2;
    }

    private static final int filterTo(Object[] objArr, Object[] objArr2, int i, k kVar) {
        int i6 = 0;
        int i10 = 0;
        while (i6 < objArr.length) {
            CommonFunctionsKt.m3588assert(i10 <= i6);
            if (((Boolean) kVar.invoke(objArr[i6])).booleanValue()) {
                objArr2[i + i10] = objArr[i6];
                i10++;
                CommonFunctionsKt.m3588assert(i + i10 <= objArr2.length);
            }
            i6++;
        }
        return i10;
    }

    public static /* synthetic */ int filterTo$default(Object[] objArr, Object[] objArr2, int i, k kVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i = 0;
        }
        if ((i6 & 4) != 0) {
            kVar = new k() { // from class: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNodeKt.filterTo.1
                @Override // S7.k
                public final Boolean invoke(Object obj2) {
                    return Boolean.valueOf(obj2 != TrieNode.INSTANCE.getEMPTY$runtime());
                }
            };
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < objArr.length) {
            CommonFunctionsKt.m3588assert(i11 <= i10);
            if (((Boolean) kVar.invoke(objArr[i10])).booleanValue()) {
                objArr2[i + i11] = objArr[i10];
                i11++;
                CommonFunctionsKt.m3588assert(i + i11 <= objArr2.length);
            }
            i10++;
        }
        return i11;
    }

    public static final int indexSegment(int i, int i6) {
        return (i >> i6) & 31;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] removeCellAtIndex(Object[] objArr, int i) {
        Object[] objArr2 = new Object[objArr.length - 1];
        q.b0(objArr, objArr2, 0, 0, i, 6);
        q.X(objArr, objArr2, i, i + 1, objArr.length);
        return objArr2;
    }
}
