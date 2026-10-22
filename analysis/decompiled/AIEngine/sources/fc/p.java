package fc;

import androidx.datastore.preferences.protobuf.b1;
import fc.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.EmptyList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class p extends m {
    public static <T> List<T> A(i<? extends T> iVar) {
        Iterator<? extends T> it = iVar.iterator();
        if (!it.hasNext()) {
            return EmptyList.f10001a;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return b1.P(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static String y(i iVar, String str, androidx.compose.runtime.i iVar2, int i10) {
        String str2 = (i10 & 2) != 0 ? "" : "{";
        String str3 = (i10 & 4) == 0 ? "}" : "";
        if ((i10 & 32) != 0) {
            iVar2 = null;
        }
        kotlin.jvm.internal.g.f(iVar, "<this>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) str2);
        int i11 = 0;
        for (Object obj : iVar) {
            i11++;
            if (i11 > 1) {
                sb2.append((CharSequence) str);
            }
            b1.f(sb2, obj, iVar2);
        }
        sb2.append((CharSequence) str3);
        return sb2.toString();
    }

    public static Comparable z(f fVar) {
        f.a aVar = new f.a(fVar);
        if (!aVar.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) aVar.next();
        while (aVar.hasNext()) {
            Comparable comparable2 = (Comparable) aVar.next();
            if (comparable.compareTo(comparable2) > 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }
}
