package io.ktor.http;

import Z8.C1173v;
import Z8.C1174w;
import io.ktor.http.ContentRange;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import v9.C5683l;
import v9.C5685n;

@Metadata(d1 = {"\u0000$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005*\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0005*\b\u0012\u0004\u0012\u00020\t0\u0005H\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"", "rangeSpec", "Lio/ktor/http/RangesSpecifier;", "parseRangesSpecifier", "(Ljava/lang/String;)Lio/ktor/http/RangesSpecifier;", "", "Lio/ktor/http/ContentRange;", "", "contentLength", "Lv9/l;", "toLongRanges", "(Ljava/util/List;J)Ljava/util/List;", "mergeRangesKeepOrder", "(Ljava/util/List;)Ljava/util/List;", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RangesKt {
    public static final List<C5683l> mergeRangesKeepOrder(List<C5683l> list) {
        kotlin.jvm.internal.p.i(list, "<this>");
        List<C5683l> listC1 = Z8.F.c1(list, new Comparator() { // from class: io.ktor.http.RangesKt$mergeRangesKeepOrder$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t10, T t11) {
                return b9.b.d(Long.valueOf(((C5683l) t10).getFirst()), Long.valueOf(((C5683l) t11).getFirst()));
            }
        });
        ArrayList arrayList = new ArrayList(list.size());
        for (C5683l c5683l : listC1) {
            if (arrayList.isEmpty()) {
                arrayList.add(c5683l);
            } else if (((C5683l) Z8.F.C0(arrayList)).getLast() < c5683l.getFirst() - 1) {
                arrayList.add(c5683l);
            } else {
                C5683l c5683l2 = (C5683l) Z8.F.C0(arrayList);
                arrayList.set(C1173v.o(arrayList), new C5683l(c5683l2.getFirst(), Math.max(c5683l2.getLast(), c5683l.getLast())));
            }
        }
        C5683l[] c5683lArr = new C5683l[list.size()];
        Iterator it = arrayList.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            kotlin.jvm.internal.p.h(next, "next(...)");
            C5683l c5683l3 = (C5683l) next;
            int size = list.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    break;
                }
                if (io.ktor.util.RangesKt.contains(c5683l3, list.get(i10))) {
                    c5683lArr[i10] = c5683l3;
                    break;
                }
                i10++;
            }
        }
        return Z8.r.V(c5683lArr);
    }

    public static final RangesSpecifier parseRangesSpecifier(String rangeSpec) {
        int iU0;
        Pair pairA;
        ContentRange bounded;
        kotlin.jvm.internal.p.i(rangeSpec, "rangeSpec");
        try {
            iU0 = La.H.u0(rangeSpec, "=", 0, false, 6, null);
        } catch (Throwable unused) {
        }
        if (iU0 == -1) {
            return null;
        }
        String strSubstring = rangeSpec.substring(0, iU0);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        String strSubstring2 = rangeSpec.substring(iU0 + 1);
        kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
        Pair pairA2 = Y8.j.a(strSubstring, strSubstring2);
        String str = (String) pairA2.a();
        List<String> listA1 = La.H.a1((String) pairA2.b(), new char[]{','}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList(C1174w.x(listA1, 10));
        for (String str2 : listA1) {
            if (La.D.X(str2, O6.l.DATE_SEPARATOR, false, 2, null)) {
                bounded = new ContentRange.Suffix(Long.parseLong(La.H.R0(str2, O6.l.DATE_SEPARATOR)));
            } else {
                int iU02 = La.H.u0(str2, O6.l.DATE_SEPARATOR, 0, false, 6, null);
                if (iU02 == -1) {
                    pairA = Y8.j.a("", "");
                } else {
                    String strSubstring3 = str2.substring(0, iU02);
                    kotlin.jvm.internal.p.h(strSubstring3, "substring(...)");
                    String strSubstring4 = str2.substring(iU02 + 1);
                    kotlin.jvm.internal.p.h(strSubstring4, "substring(...)");
                    pairA = Y8.j.a(strSubstring3, strSubstring4);
                }
                String str3 = (String) pairA.a();
                String str4 = (String) pairA.b();
                bounded = str4.length() > 0 ? new ContentRange.Bounded(Long.parseLong(str3), Long.parseLong(str4)) : new ContentRange.TailFrom(Long.parseLong(str3));
            }
            arrayList.add(bounded);
        }
        if (!arrayList.isEmpty() && str.length() != 0) {
            RangesSpecifier rangesSpecifier = new RangesSpecifier(str, arrayList);
            if (RangesSpecifier.isValid$default(rangesSpecifier, null, 1, null)) {
                return rangesSpecifier;
            }
        }
        return null;
    }

    public static final List<C5683l> toLongRanges(List<? extends ContentRange> list, long j10) {
        C5683l c5683lT;
        kotlin.jvm.internal.p.i(list, "<this>");
        List<? extends ContentRange> list2 = list;
        ArrayList arrayList = new ArrayList(C1174w.x(list2, 10));
        for (ContentRange contentRange : list2) {
            if (contentRange instanceof ContentRange.Bounded) {
                ContentRange.Bounded bounded = (ContentRange.Bounded) contentRange;
                c5683lT = new C5683l(bounded.getFrom(), C5685n.k(bounded.getTo(), j10 - 1));
            } else if (contentRange instanceof ContentRange.TailFrom) {
                c5683lT = C5685n.t(((ContentRange.TailFrom) contentRange).getFrom(), j10);
            } else {
                if (!(contentRange instanceof ContentRange.Suffix)) {
                    throw new NoWhenBranchMatchedException();
                }
                c5683lT = C5685n.t(C5685n.g(j10 - ((ContentRange.Suffix) contentRange).getLastCount(), 0L), j10);
            }
            arrayList.add(c5683lT);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!((C5683l) obj).isEmpty()) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }
}
