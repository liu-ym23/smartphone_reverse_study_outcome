package kotlin.sequences;

import D7.t;
import H4.o;
import O7.h;
import androidx.room.c;
import com.stepos.statsrpk.d;
import com.uxsense.parse.b;
import i9.C1566a;
import i9.C1567b;
import i9.C1569d;
import i9.InterfaceC1568c;
import i9.f;
import i9.g;
import i9.i;
import i9.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public abstract class a extends U7.a {
    public static i c0(Iterator it) {
        k.f(it, "<this>");
        return new C1566a(new t(it, 4));
    }

    public static int d0(i iVar) {
        k.f(iVar, "<this>");
        Iterator it = iVar.iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
            if (i < 0) {
                o.W();
                throw null;
            }
        }
        return i;
    }

    public static i e0(i iVar, int i) {
        if (i >= 0) {
            return i == 0 ? iVar : iVar instanceof InterfaceC1568c ? ((InterfaceC1568c) iVar).a(i) : new C1567b(iVar, i, 0);
        }
        throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(i, "Requested element count ", " is less than zero.").toString());
    }

    public static f f0(i iVar, S7.k predicate) {
        k.f(iVar, "<this>");
        k.f(predicate, "predicate");
        return new f(iVar, true, predicate);
    }

    public static f g0(i iVar, S7.k predicate) {
        k.f(predicate, "predicate");
        return new f(iVar, false, predicate);
    }

    public static g h0(i iVar, S7.k kVar) {
        return new g(iVar, kVar, SequencesKt___SequencesKt$flatMap$2.f5166a);
    }

    public static final g i0(i iVar) {
        b bVar = new b(19);
        if (!(iVar instanceof i9.o)) {
            return new g(iVar, new b(20), bVar);
        }
        i9.o oVar = (i9.o) iVar;
        return new g(oVar.f4627a, oVar.b, bVar);
    }

    public static i j0(S7.a aVar) {
        return new C1566a(new h(aVar, new c(1, aVar)));
    }

    public static i k0(S7.k nextFunction, Object obj) {
        k.f(nextFunction, "nextFunction");
        return obj == null ? C1569d.f4618a : new h(new l(obj, 0), nextFunction);
    }

    public static String l0(i iVar, String str) {
        k.f(iVar, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int i = 0;
        for (Object obj : iVar) {
            i++;
            if (i > 1) {
                sb.append((CharSequence) str);
            }
            d.h(sb, obj, null);
        }
        sb.append((CharSequence) "");
        return sb.toString();
    }

    public static i9.o m0(i iVar, S7.k transform) {
        k.f(transform, "transform");
        return new i9.o(iVar, transform);
    }

    public static f n0(i iVar, S7.k kVar) {
        return g0(new i9.o(iVar, kVar), new b(21));
    }

    public static List o0(i iVar) {
        k.f(iVar, "<this>");
        Iterator it = iVar.iterator();
        if (!it.hasNext()) {
            return EmptyList.f4893a;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return o.M(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
