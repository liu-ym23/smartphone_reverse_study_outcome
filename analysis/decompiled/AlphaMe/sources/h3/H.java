package h3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.Util;

/* loaded from: classes2.dex */
public final class H implements Iterable, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public final String[] f12712a;

    public H(String[] strArr) {
        this.f12712a = strArr;
    }

    public final String a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String[] strArr = this.f12712a;
        int length = strArr.length - 2;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(length, 0, -2);
        if (progressionLastElement <= length) {
            while (true) {
                int i4 = length - 2;
                if (StringsKt__StringsJVMKt.equals(name, strArr[length], true)) {
                    return strArr[length + 1];
                }
                if (length == progressionLastElement) {
                    break;
                }
                length = i4;
            }
        }
        return null;
    }

    public final String c(int i4) {
        return this.f12712a[i4 * 2];
    }

    public final G d() {
        G g4 = new G();
        CollectionsKt__MutableCollectionsKt.addAll(g4.f12711a, this.f12712a);
        return g4;
    }

    public final TreeMap e() {
        TreeMap treeMap = new TreeMap(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        int size = size();
        int i4 = 0;
        while (i4 < size) {
            int i5 = i4 + 1;
            String strC = c(i4);
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = strC.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(f(i4));
            i4 = i5;
        }
        return treeMap;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof H) {
            if (Arrays.equals(this.f12712a, ((H) obj).f12712a)) {
                return true;
            }
        }
        return false;
    }

    public final String f(int i4) {
        return this.f12712a[(i4 * 2) + 1];
    }

    public final List g(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        int size = size();
        ArrayList arrayList = null;
        int i4 = 0;
        while (i4 < size) {
            int i5 = i4 + 1;
            if (StringsKt__StringsJVMKt.equals(name, c(i4), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(f(i4));
            }
            i4 = i5;
        }
        if (arrayList == null) {
            return CollectionsKt.emptyList();
        }
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "{\n      Collections.unmodifiableList(result)\n    }");
        return listUnmodifiableList;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f12712a);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i4 = 0; i4 < size; i4++) {
            pairArr[i4] = TuplesKt.to(c(i4), f(i4));
        }
        return ArrayIteratorKt.iterator(pairArr);
    }

    public final int size() {
        return this.f12712a.length / 2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        int i4 = 0;
        while (i4 < size) {
            int i5 = i4 + 1;
            String strC = c(i4);
            String strF = f(i4);
            sb.append(strC);
            sb.append(": ");
            if (Util.isSensitiveHeader(strC)) {
                strF = "██";
            }
            sb.append(strF);
            sb.append("\n");
            i4 = i5;
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
