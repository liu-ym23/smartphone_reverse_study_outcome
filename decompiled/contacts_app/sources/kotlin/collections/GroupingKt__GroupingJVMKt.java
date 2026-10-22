package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: GroupingJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\u001a0\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u0005H\u0007\u001aZ\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\b*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u00072\u001e\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\f\u0012\u0004\u0012\u0002H\b0\u000bH\u0081\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"eachCount", "", "K", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/Grouping;", "mapValuesInPlace", "", "R", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "f", "Lkotlin/Function1;", "", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/collections/GroupingKt")
class GroupingKt__GroupingJVMKt {
    public GroupingKt__GroupingJVMKt() {
    }

    public static final <T, K> Map<K, Integer> eachCount(Grouping<T, ? extends K> r6) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<T> r1 = r6.sourceIterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        K r2 = r6.keyOf(r1.next());
        Object r3 = r0.get(r2);
        if (r3 == null) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == false) goto L13;
        r3 = new Ref.IntRef();
    L13:
        Ref.IntRef r4 = (Ref.IntRef) r3;
        r4.element++;
        r0.put(r2, r4);
        goto L4
    L8:
        if (r0.containsKey(r2) == true) goto L10;
        r5 = true;
        goto L11
    L14:
        Iterator<T> r7 = r0.entrySet().iterator();
    L16:
        if (r7.hasNext() == false) goto L19;
        Map.Entry r8 = (Map.Entry) r7.next();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4>");
        TypeIntrinsics.asMutableMapEntry(r8).setValue(Integer.valueOf(((Ref.IntRef) r8.getValue()).element));
        goto L16
    L19:
        return TypeIntrinsics.asMutableMap(r0);
    }

    private static final <K, V, R> Map<K, R> mapValuesInPlace(Map<K, V> r3, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "f");
        Iterator<T> r0 = r3.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        Map.Entry r1 = (Map.Entry) r0.next();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4>");
        TypeIntrinsics.asMutableMapEntry(r1).setValue(r4.invoke(r1));
        goto L4
    L7:
        return TypeIntrinsics.asMutableMap(r3);
    }
}
