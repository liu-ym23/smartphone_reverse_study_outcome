package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class Iterables {

    public static final class UnmodifiableIterable<T> extends FluentIterable<T> {
        private final Iterable<? extends T> iterable;

        public /* synthetic */ UnmodifiableIterable(Iterable r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.unmodifiableIterator(this.iterable.iterator());
        }

        @Override // com.google.common.collect.FluentIterable
        public String toString() {
            return this.iterable.toString();
        }

        private UnmodifiableIterable(Iterable<? extends T> r10) {
            this.iterable = r10;
        }
    }

    private Iterables() {
    }

    @CanIgnoreReturnValue
    public static <T> boolean addAll(Collection<T> r10, Iterable<? extends T> r11) {
        if ((r11 instanceof Collection) == false) goto L7;
        return r10.addAll(Collections2.cast(r11));
    L7:
        return Iterators.addAll(r10, ((Iterable) Preconditions.checkNotNull(r11)).iterator());
    }

    public static <T> boolean all(Iterable<T> r10, Predicate<? super T> r11) {
        return Iterators.all(r10.iterator(), r11);
    }

    public static <T> boolean any(Iterable<T> r10, Predicate<? super T> r11) {
        return Iterators.any(r10.iterator(), r11);
    }

    private static <E> Collection<E> castOrCopyToCollection(Iterable<E> r10) {
        if ((r10 instanceof Collection) == false) goto L6;
        return (Collection) r10;
    L6:
        return Lists.newArrayList(r10.iterator());
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> r10, Iterable<? extends T> r11) {
        return FluentIterable.concat(r10, r11);
    }

    public static <T> Iterable<T> consumingIterable(final Iterable<T> r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass8(r10);
    }

    public static boolean contains(Iterable<?> r10, @NullableDecl Object r11) {
        if ((r10 instanceof Collection) == false) goto L7;
        return Collections2.safeContains((Collection) r10, r11);
    L7:
        return Iterators.contains(r10.iterator(), r11);
    }

    public static <T> Iterable<T> cycle(final Iterable<T> r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass1(r10);
    }

    public static boolean elementsEqual(Iterable<?> r10, Iterable<?> r11) {
        if ((r10 instanceof Collection) == false) goto L11;
        if ((r11 instanceof Collection) == false) goto L11;
        if (((Collection) r10).size() == ((Collection) r11).size()) goto L11;
        return false;
    L11:
        return Iterators.elementsEqual(r10.iterator(), r11.iterator());
    }

    public static <T> Iterable<T> filter(final Iterable<T> r10, final Predicate<? super T> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        return new AnonymousClass4(r10, r11);
    }

    public static <T> T find(Iterable<T> r10, Predicate<? super T> r11) {
        return (T) Iterators.find(r10.iterator(), r11);
    }

    public static int frequency(Iterable<?> r10, @NullableDecl Object r11) {
        if ((r10 instanceof Multiset) == false) goto L7;
        return ((Multiset) r10).count(r11);
    L7:
        if ((r10 instanceof Set) == false) goto L11;
        return ((Set) r10).contains(r11) ? 1 : 0;
    L11:
        return Iterators.frequency(r10.iterator(), r11);
    }

    public static <T> T get(Iterable<T> r10, int r11) {
        Preconditions.checkNotNull(r10);
        if ((r10 instanceof List) == false) goto L6;
        return (T) ((List) r10).get(r11);
    L6:
        return (T) Iterators.get(r10.iterator(), r11);
    }

    @NullableDecl
    public static <T> T getFirst(Iterable<? extends T> r10, @NullableDecl T r11) {
        return (T) Iterators.getNext(r10.iterator(), r11);
    }

    public static <T> T getLast(Iterable<T> r10) {
        if ((r10 instanceof List) == false) goto L11;
        List r11 = (List) r10;
        if (r11.isEmpty() == true) goto L9;
        return (T) getLastInNonemptyList(r11);
    L9:
        throw new NoSuchElementException();
    L11:
        return (T) Iterators.getLast(r10.iterator());
    }

    private static <T> T getLastInNonemptyList(List<T> r10) {
        return r10.get(r10.size() - 1);
    }

    public static <T> T getOnlyElement(Iterable<T> r10) {
        return (T) Iterators.getOnlyElement(r10.iterator());
    }

    public static <T> int indexOf(Iterable<T> r10, Predicate<? super T> r11) {
        return Iterators.indexOf(r10.iterator(), r11);
    }

    public static boolean isEmpty(Iterable<?> r10) {
        if ((r10 instanceof Collection) == false) goto L7;
        return ((Collection) r10).isEmpty();
    L7:
        return !r10.iterator().hasNext();
    }

    public static <T> Iterable<T> limit(final Iterable<T> r10, final int r11) {
        Preconditions.checkNotNull(r10);
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12, "limit is negative");
        return new AnonymousClass7(r10, r11);
    L5:
        r12 = false;
        goto L6
    }

    @Beta
    public static <T> Iterable<T> mergeSorted(final Iterable<? extends Iterable<? extends T>> r10, final Comparator<? super T> r11) {
        Preconditions.checkNotNull(r10, "iterables");
        Preconditions.checkNotNull(r11, "comparator");
        return new UnmodifiableIterable(new AnonymousClass9(r10, r11), null);
    }

    public static <T> Iterable<List<T>> paddedPartition(final Iterable<T> r10, final int r11) {
        Preconditions.checkNotNull(r10);
        if (r11 <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        return new AnonymousClass3(r10, r11);
    L5:
        r12 = false;
        goto L6
    }

    public static <T> Iterable<List<T>> partition(final Iterable<T> r10, final int r11) {
        Preconditions.checkNotNull(r10);
        if (r11 <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        return new AnonymousClass2(r10, r11);
    L5:
        r12 = false;
        goto L6
    }

    @CanIgnoreReturnValue
    public static boolean removeAll(Iterable<?> r10, Collection<?> r11) {
        if ((r10 instanceof Collection) == false) goto L6;
        return ((Collection) r10).removeAll((Collection) Preconditions.checkNotNull(r11));
    L6:
        return Iterators.removeAll(r10.iterator(), r11);
    }

    @NullableDecl
    public static <T> T removeFirstMatching(Iterable<T> r10, Predicate<? super T> r11) {
        Preconditions.checkNotNull(r11);
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        T r13 = r12.next();
        if (r11.apply(r13) == false) goto L4;
        r12.remove();
        return r13;
    L9:
        return null;
    }

    @CanIgnoreReturnValue
    public static <T> boolean removeIf(Iterable<T> r10, Predicate<? super T> r11) {
        if ((r10 instanceof RandomAccess) == false) goto L9;
        if ((r10 instanceof List) == false) goto L9;
        return removeIfFromRandomAccessList((List) r10, (Predicate) Preconditions.checkNotNull(r11));
    L9:
        return Iterators.removeIf(r10.iterator(), r11);
    }

    private static <T> boolean removeIfFromRandomAccessList(List<T> r10, Predicate<? super T> r11) {
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r12 >= r10.size()) goto L16;
        T r14 = r10.get(r12);
        if (r11.apply(r14) == true) goto L15;
        if (r12 > r13) goto L20;
    L14:
        r13 = r13 + 1;
        goto L15
    L20:
        r10.set(r13, r14);     // Catch: IllegalArgumentException -> L10 UnsupportedOperationException -> L12
    L10:
        slowRemoveIfForRemainingElements(r10, r11, r13, r12);
        return true;
    L12:
        slowRemoveIfForRemainingElements(r10, r11, r13, r12);
        return true;
    L15:
        r12 = r12 + 1;
        goto L4
    L16:
        r10.subList(r13, r10.size()).clear();
        if (r12 != r13) goto L19;
        return false;
    L19:
        return true;
    }

    @CanIgnoreReturnValue
    public static boolean retainAll(Iterable<?> r10, Collection<?> r11) {
        if ((r10 instanceof Collection) == false) goto L6;
        return ((Collection) r10).retainAll((Collection) Preconditions.checkNotNull(r11));
    L6:
        return Iterators.retainAll(r10.iterator(), r11);
    }

    public static int size(Iterable<?> r10) {
        if ((r10 instanceof Collection) == false) goto L6;
        return ((Collection) r10).size();
    L6:
        return Iterators.size(r10.iterator());
    }

    public static <T> Iterable<T> skip(final Iterable<T> r10, final int r11) {
        Preconditions.checkNotNull(r10);
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12, "number to skip cannot be negative");
        return new AnonymousClass6(r10, r11);
    L5:
        r12 = false;
        goto L6
    }

    private static <T> void slowRemoveIfForRemainingElements(List<T> r10, Predicate<? super T> r11, int r12, int r13) {
        int r14 = r10.size() - 1;
    L3:
        if (r14 <= r13) goto L8;
        if (r11.apply(r10.get(r14)) == false) goto L7;
        r10.remove(r14);
    L7:
        r14 = r14 - 1;
        goto L3
    L8:
        int r15 = r13 - 1;
    L9:
        if (r15 < r12) goto L11;
        r10.remove(r15);
        r15 = r15 - 1;
        goto L9
    }

    @GwtIncompatible
    public static <T> T[] toArray(Iterable<? extends T> r10, Class<T> r11) {
        return (T[]) toArray(r10, ObjectArrays.newArray(r11, 0));
    }

    public static <T> Function<Iterable<? extends T>, Iterator<? extends T>> toIterator() {
        return new AnonymousClass10();
    }

    public static String toString(Iterable<?> r10) {
        return Iterators.toString(r10.iterator());
    }

    public static <F, T> Iterable<T> transform(final Iterable<F> r10, final Function<? super F, ? extends T> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        return new AnonymousClass5(r10, r11);
    }

    public static <T> Optional<T> tryFind(Iterable<T> r10, Predicate<? super T> r11) {
        return Iterators.tryFind(r10.iterator(), r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Iterable<T> unmodifiableIterable(Iterable<? extends T> r10) {
        Preconditions.checkNotNull(r10);
        if ((r10 instanceof UnmodifiableIterable) == false) goto L5;
    L9:
        return r10;
    L5:
        if ((r10 instanceof ImmutableCollection) == true) goto L9;
        return new UnmodifiableIterable(r10, null);
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> r10, Iterable<? extends T> r11, Iterable<? extends T> r12) {
        return FluentIterable.concat(r10, r11, r12);
    }

    @NullableDecl
    public static <T> T find(Iterable<? extends T> r10, Predicate<? super T> r11, @NullableDecl T r12) {
        return (T) Iterators.find(r10.iterator(), r11, r12);
    }

    @NullableDecl
    public static <T> T getOnlyElement(Iterable<? extends T> r10, @NullableDecl T r11) {
        return (T) Iterators.getOnlyElement(r10.iterator(), r11);
    }

    public static <T> T[] toArray(Iterable<? extends T> r10, T[] r11) {
        return (T[]) castOrCopyToCollection(r10).toArray(r11);
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> r10, Iterable<? extends T> r11, Iterable<? extends T> r12, Iterable<? extends T> r13) {
        return FluentIterable.concat(r10, r11, r12, r13);
    }

    @SafeVarargs
    public static <T> Iterable<T> cycle(T... r10) {
        return cycle(Lists.newArrayList(r10));
    }

    @SafeVarargs
    public static <T> Iterable<T> concat(Iterable<? extends T>... r10) {
        return FluentIterable.concat(r10);
    }

    @GwtIncompatible
    public static <T> Iterable<T> filter(Iterable<?> r10, Class<T> r11) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        return filter(r10, Predicates.instanceOf(r11));
    }

    public static Object[] toArray(Iterable<?> r10) {
        return castOrCopyToCollection(r10).toArray();
    }

    @Deprecated
    public static <E> Iterable<E> unmodifiableIterable(ImmutableCollection<E> r10) {
        return (Iterable) Preconditions.checkNotNull(r10);
    }

    public static <T> Iterable<T> concat(Iterable<? extends Iterable<? extends T>> r10) {
        return FluentIterable.concat(r10);
    }

    @NullableDecl
    public static <T> T get(Iterable<? extends T> r10, int r11, @NullableDecl T r12) {
        Preconditions.checkNotNull(r10);
        Iterators.checkNonnegative(r11);
        if ((r10 instanceof List) == false) goto L8;
        List r13 = Lists.cast(r10);
        if (r11 < r13.size()) goto L7;
        return r12;
    L7:
        return (T) r13.get(r11);
    L8:
        Iterator<? extends T> r14 = r10.iterator();
        Iterators.advance(r14, r11);
        return (T) Iterators.getNext(r14, r12);
    }

    @NullableDecl
    public static <T> T getLast(Iterable<? extends T> r10, @NullableDecl T r11) {
        if ((r10 instanceof Collection) == false) goto L12;
        if (Collections2.cast(r10).isEmpty() == false) goto L8;
        return r11;
    L8:
        if ((r10 instanceof List) == false) goto L12;
        return (T) getLastInNonemptyList(Lists.cast(r10));
    L12:
        return (T) Iterators.getLast(r10.iterator(), r11);
    }
}
