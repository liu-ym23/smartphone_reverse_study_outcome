package Z8;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u001f\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u001d\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\t\u001a-\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a-\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\t\u001a/\u0010\u000b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\n¢\u0006\u0004\b\u000b\u0010\f\u001a%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a-\u0010\u0010\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0010\u0010\u0006\u001a-\u0010\u0011\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0011\u0010\u0006\u001a1\u0010\u0015\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0013¢\u0006\u0004\b\u0015\u0010\u0016\u001a1\u0010\u0017\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0013¢\u0006\u0004\b\u0017\u0010\u0016\u001a;\u0010\u0019\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001f\u0010\u001c\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001f\u0010\u001e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0007¢\u0006\u0004\b\u001e\u0010\u001d\u001a!\u0010\u001f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0007¢\u0006\u0004\b\u001f\u0010\u001d\u001a1\u0010 \u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0013¢\u0006\u0004\b \u0010!\u001a;\u0010\"\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "", "elements", "", ExifInterface.LONGITUDE_EAST, "(Ljava/util/Collection;Ljava/lang/Iterable;)Z", "LKa/j;", "D", "(Ljava/util/Collection;LKa/j;)Z", "", "F", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "", "G", "(Ljava/lang/Iterable;)Ljava/util/Collection;", "K", "Q", "", "Lkotlin/Function1;", "predicate", "J", "(Ljava/lang/Iterable;Lp9/l;)Z", "P", "predicateResultToRemove", "H", "(Ljava/lang/Iterable;Lp9/l;Z)Z", "", "M", "(Ljava/util/List;)Ljava/lang/Object;", "N", "O", "L", "(Ljava/util/List;Lp9/l;)Z", "I", "(Ljava/util/List;Lp9/l;Z)Z", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
/* loaded from: classes4.dex */
public class A extends C1177z {
    public static <T> boolean D(Collection<? super T> collection, Ka.j<? extends T> elements) {
        kotlin.jvm.internal.p.i(collection, "<this>");
        kotlin.jvm.internal.p.i(elements, "elements");
        Iterator<? extends T> it = elements.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    public static <T> boolean E(Collection<? super T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.p.i(collection, "<this>");
        kotlin.jvm.internal.p.i(elements, "elements");
        if (elements instanceof Collection) {
            return collection.addAll((Collection) elements);
        }
        Iterator<? extends T> it = elements.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    public static <T> boolean F(Collection<? super T> collection, T[] elements) {
        kotlin.jvm.internal.p.i(collection, "<this>");
        kotlin.jvm.internal.p.i(elements, "elements");
        return collection.addAll(C1168p.d(elements));
    }

    public static final <T> Collection<T> G(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        return iterable instanceof Collection ? (Collection) iterable : F.m1(iterable);
    }

    public static final <T> boolean H(Iterable<? extends T> iterable, InterfaceC5074l<? super T, Boolean> interfaceC5074l, boolean z10) {
        Iterator<? extends T> it = iterable.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            if (interfaceC5074l.invoke(it.next()).booleanValue() == z10) {
                it.remove();
                z11 = true;
            }
        }
        return z11;
    }

    public static final <T> boolean I(List<T> list, InterfaceC5074l<? super T, Boolean> interfaceC5074l, boolean z10) {
        int i10;
        if (!(list instanceof RandomAccess)) {
            kotlin.jvm.internal.p.g(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return H(kotlin.jvm.internal.z.b(list), interfaceC5074l, z10);
        }
        int iO = C1173v.o(list);
        if (iO >= 0) {
            int i11 = 0;
            i10 = 0;
            while (true) {
                T t10 = list.get(i11);
                if (interfaceC5074l.invoke(t10).booleanValue() != z10) {
                    if (i10 != i11) {
                        list.set(i10, t10);
                    }
                    i10++;
                }
                if (i11 == iO) {
                    break;
                }
                i11++;
            }
        } else {
            i10 = 0;
        }
        if (i10 >= list.size()) {
            return false;
        }
        int iO2 = C1173v.o(list);
        if (i10 > iO2) {
            return true;
        }
        while (true) {
            list.remove(iO2);
            if (iO2 == i10) {
                return true;
            }
            iO2--;
        }
    }

    public static <T> boolean J(Iterable<? extends T> iterable, InterfaceC5074l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        kotlin.jvm.internal.p.i(predicate, "predicate");
        return H(iterable, predicate, true);
    }

    public static <T> boolean K(Collection<? super T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.p.i(collection, "<this>");
        kotlin.jvm.internal.p.i(elements, "elements");
        return collection.removeAll(G(elements));
    }

    public static <T> boolean L(List<T> list, InterfaceC5074l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.p.i(list, "<this>");
        kotlin.jvm.internal.p.i(predicate, "predicate");
        return I(list, predicate, true);
    }

    public static <T> T M(List<T> list) {
        kotlin.jvm.internal.p.i(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(0);
    }

    public static <T> T N(List<T> list) {
        kotlin.jvm.internal.p.i(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.remove(C1173v.o(list));
    }

    public static <T> T O(List<T> list) {
        kotlin.jvm.internal.p.i(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(C1173v.o(list));
    }

    public static <T> boolean P(Iterable<? extends T> iterable, InterfaceC5074l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.p.i(iterable, "<this>");
        kotlin.jvm.internal.p.i(predicate, "predicate");
        return H(iterable, predicate, false);
    }

    public static final <T> boolean Q(Collection<? super T> collection, Iterable<? extends T> elements) {
        kotlin.jvm.internal.p.i(collection, "<this>");
        kotlin.jvm.internal.p.i(elements, "elements");
        return collection.retainAll(G(elements));
    }
}
