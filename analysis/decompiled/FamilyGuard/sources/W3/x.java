package W3;

import i4.InterfaceC0772l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import org.libpag.BuildConfig;
import q4.InterfaceC0988b;
import r4.C1031n;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends w {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements InterfaceC0988b<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f5761a;

        public a(Iterable iterable) {
            this.f5761a = iterable;
        }

        @Override // q4.InterfaceC0988b
        public Iterator<T> iterator() {
            return this.f5761a.iterator();
        }
    }

    public static final <T> T A(Iterable<? extends T> iterable) {
        j4.k.g(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) B((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T B(List<? extends T> list) {
        j4.k.g(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static <T> T C(Iterable<? extends T> iterable) {
        j4.k.g(iterable, "<this>");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static <T> T D(List<? extends T> list, int i5) {
        j4.k.g(list, "<this>");
        if (i5 < 0 || i5 >= list.size()) {
            return null;
        }
        return list.get(i5);
    }

    public static final <T> int E(Iterable<? extends T> iterable, T t5) {
        j4.k.g(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t5);
        }
        int i5 = 0;
        for (T t6 : iterable) {
            if (i5 < 0) {
                p.q();
            }
            if (j4.k.b(t5, t6)) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static final <T, A extends Appendable> A F(Iterable<? extends T> iterable, A a6, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, InterfaceC0772l<? super T, ? extends CharSequence> interfaceC0772l) throws IOException {
        j4.k.g(iterable, "<this>");
        j4.k.g(a6, "buffer");
        j4.k.g(charSequence, "separator");
        j4.k.g(charSequence2, "prefix");
        j4.k.g(charSequence3, "postfix");
        j4.k.g(charSequence4, "truncated");
        a6.append(charSequence2);
        int i6 = 0;
        for (T t5 : iterable) {
            i6++;
            if (i6 > 1) {
                a6.append(charSequence);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            C1031n.a(a6, t5, interfaceC0772l);
        }
        if (i5 >= 0 && i6 > i5) {
            a6.append(charSequence4);
        }
        a6.append(charSequence3);
        return a6;
    }

    public static /* synthetic */ Appendable G(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, InterfaceC0772l interfaceC0772l, int i6, Object obj) {
        CharSequence charSequence5 = (i6 & 2) != 0 ? ", " : charSequence;
        int i7 = i6 & 4;
        CharSequence charSequence6 = BuildConfig.FLAVOR;
        CharSequence charSequence7 = i7 != 0 ? BuildConfig.FLAVOR : charSequence2;
        if ((i6 & 8) == 0) {
            charSequence6 = charSequence3;
        }
        return F(iterable, appendable, charSequence5, charSequence7, charSequence6, (i6 & 16) != 0 ? -1 : i5, (i6 & 32) != 0 ? "..." : charSequence4, (i6 & 64) != 0 ? null : interfaceC0772l);
    }

    public static final <T> String H(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, InterfaceC0772l<? super T, ? extends CharSequence> interfaceC0772l) {
        j4.k.g(iterable, "<this>");
        j4.k.g(charSequence, "separator");
        j4.k.g(charSequence2, "prefix");
        j4.k.g(charSequence3, "postfix");
        j4.k.g(charSequence4, "truncated");
        return ((StringBuilder) F(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i5, charSequence4, interfaceC0772l)).toString();
    }

    public static /* synthetic */ String I(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, InterfaceC0772l interfaceC0772l, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i6 & 2) != 0) {
            charSequence2 = BuildConfig.FLAVOR;
        }
        if ((i6 & 4) != 0) {
            charSequence3 = BuildConfig.FLAVOR;
        }
        if ((i6 & 8) != 0) {
            i5 = -1;
        }
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i6 & 32) != 0) {
            interfaceC0772l = null;
        }
        CharSequence charSequence5 = charSequence4;
        InterfaceC0772l interfaceC0772l2 = interfaceC0772l;
        return H(iterable, charSequence, charSequence2, charSequence3, i5, charSequence5, interfaceC0772l2);
    }

    public static final <T> T J(Iterable<? extends T> iterable) {
        j4.k.g(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) K((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static <T> T K(List<? extends T> list) {
        j4.k.g(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(p.j(list));
    }

    public static <T extends Comparable<? super T>> T L(Iterable<? extends T> iterable) {
        j4.k.g(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static <T> List<T> M(Collection<? extends T> collection, Iterable<? extends T> iterable) {
        j4.k.g(collection, "<this>");
        j4.k.g(iterable, "elements");
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            u.t(arrayList, iterable);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static <T> List<T> N(Collection<? extends T> collection, T t5) {
        j4.k.g(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t5);
        return arrayList;
    }

    public static <T> T O(Iterable<? extends T> iterable) {
        j4.k.g(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) P((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final <T> T P(List<? extends T> list) {
        j4.k.g(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static <T extends Comparable<? super T>> List<T> Q(Iterable<? extends T> iterable) {
        j4.k.g(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List<T> listV = V(iterable);
            t.s(listV);
            return listV;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return U(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        C0399j.k((Comparable[]) array);
        return C0399j.c(array);
    }

    public static <T> List<T> R(Iterable<? extends T> iterable, int i5) {
        j4.k.g(iterable, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i5 + " is less than zero.").toString());
        }
        if (i5 == 0) {
            return p.h();
        }
        if (iterable instanceof Collection) {
            if (i5 >= ((Collection) iterable).size()) {
                return U(iterable);
            }
            if (i5 == 1) {
                return o.b(A(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i5);
        Iterator<? extends T> it = iterable.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            arrayList.add(it.next());
            i6++;
            if (i6 == i5) {
                break;
            }
        }
        return p.o(arrayList);
    }

    public static final <T, C extends Collection<? super T>> C S(Iterable<? extends T> iterable, C c6) {
        j4.k.g(iterable, "<this>");
        j4.k.g(c6, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c6.add(it.next());
        }
        return c6;
    }

    public static int[] T(Collection<Integer> collection) {
        j4.k.g(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            iArr[i5] = it.next().intValue();
            i5++;
        }
        return iArr;
    }

    public static <T> List<T> U(Iterable<? extends T> iterable) {
        j4.k.g(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return p.o(V(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return p.h();
        }
        if (size != 1) {
            return W(collection);
        }
        return o.b(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static final <T> List<T> V(Iterable<? extends T> iterable) {
        j4.k.g(iterable, "<this>");
        return iterable instanceof Collection ? W((Collection) iterable) : (List) S(iterable, new ArrayList());
    }

    public static <T> List<T> W(Collection<? extends T> collection) {
        j4.k.g(collection, "<this>");
        return new ArrayList(collection);
    }

    public static <T> Set<T> X(Iterable<? extends T> iterable) {
        j4.k.g(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return M.c((Set) S(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return M.b();
        }
        if (size != 1) {
            return (Set) S(iterable, new LinkedHashSet(G.a(collection.size())));
        }
        return L.a(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
    }

    public static <T, R> List<V3.m<T, R>> Y(Iterable<? extends T> iterable, Iterable<? extends R> iterable2) {
        j4.k.g(iterable, "<this>");
        j4.k.g(iterable2, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(q.r(iterable, 10), q.r(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(V3.r.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static <T> InterfaceC0988b<T> w(Iterable<? extends T> iterable) {
        j4.k.g(iterable, "<this>");
        return new a(iterable);
    }

    public static <T> boolean x(Iterable<? extends T> iterable, T t5) {
        j4.k.g(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(t5) : E(iterable, t5) >= 0;
    }

    public static <T> List<T> y(Iterable<? extends T> iterable, int i5) {
        ArrayList arrayList;
        j4.k.g(iterable, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i5 + " is less than zero.").toString());
        }
        if (i5 == 0) {
            return U(iterable);
        }
        if (iterable instanceof Collection) {
            int size = ((Collection) iterable).size() - i5;
            if (size <= 0) {
                return p.h();
            }
            if (size == 1) {
                return o.b(J(iterable));
            }
            arrayList = new ArrayList(size);
            if (iterable instanceof List) {
                if (iterable instanceof RandomAccess) {
                    List list = (List) iterable;
                    int size2 = list.size();
                    while (i5 < size2) {
                        arrayList.add(list.get(i5));
                        i5++;
                    }
                } else {
                    ListIterator listIterator = ((List) iterable).listIterator(i5);
                    while (listIterator.hasNext()) {
                        arrayList.add(listIterator.next());
                    }
                }
                return arrayList;
            }
        } else {
            arrayList = new ArrayList();
        }
        int i6 = 0;
        for (T t5 : iterable) {
            if (i6 >= i5) {
                arrayList.add(t5);
            } else {
                i6++;
            }
        }
        return p.o(arrayList);
    }

    public static <T> List<T> z(List<? extends T> list, int i5) {
        j4.k.g(list, "<this>");
        if (i5 >= 0) {
            return R(list, kotlin.ranges.l.b(list.size() - i5, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i5 + " is less than zero.").toString());
    }
}
