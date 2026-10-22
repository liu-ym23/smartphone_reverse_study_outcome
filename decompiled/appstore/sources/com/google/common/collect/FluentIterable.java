package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public abstract class FluentIterable<E> implements Iterable<E> {
    private final Optional<Iterable<E>> iterableDelegate;

    public static class FromIterableFunction<E> implements Function<Iterable<E>, FluentIterable<E>> {
        private FromIterableFunction() {
        }

        @Override // com.google.common.base.Function
        public /* bridge */ /* synthetic */ Object apply(Object r10) {
            return apply((Iterable) r10);
        }

        public FluentIterable<E> apply(Iterable<E> r10) {
            return FluentIterable.from(r10);
        }
    }

    public FluentIterable() {
        this.iterableDelegate = Optional.absent();
    }

    @Beta
    public static <T> FluentIterable<T> concat(Iterable<? extends T> r10, Iterable<? extends T> r11) {
        return concatNoDefensiveCopy(new Iterable[]{r10, r11});
    }

    private static <T> FluentIterable<T> concatNoDefensiveCopy(final Iterable<? extends T>... r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        Preconditions.checkNotNull(r10[r12]);
        r12 = r12 + 1;
        goto L3
    L6:
        return new AnonymousClass3(r10);
    }

    public static <E> FluentIterable<E> from(final Iterable<E> r10) {
        if ((r10 instanceof FluentIterable) == false) goto L6;
        return (FluentIterable) r10;
    L6:
        return new AnonymousClass1(r10, r10);
    }

    private Iterable<E> getDelegate() {
        return this.iterableDelegate.or(this);
    }

    @Beta
    public static <E> FluentIterable<E> of() {
        return from(ImmutableList.of());
    }

    public final boolean allMatch(Predicate<? super E> r10) {
        return Iterables.all(getDelegate(), r10);
    }

    public final boolean anyMatch(Predicate<? super E> r10) {
        return Iterables.any(getDelegate(), r10);
    }

    @Beta
    public final FluentIterable<E> append(Iterable<? extends E> r10) {
        return concat(getDelegate(), r10);
    }

    public final boolean contains(@NullableDecl Object r10) {
        return Iterables.contains(getDelegate(), r10);
    }

    @CanIgnoreReturnValue
    public final <C extends Collection<? super E>> C copyInto(C r10) {
        Preconditions.checkNotNull(r10);
        Iterable<E> r11 = getDelegate();
        if ((r11 instanceof Collection) == false) goto L5;
        r10.addAll(Collections2.cast(r11));
    L9:
        return r10;
    L5:
        Iterator<E> r12 = r11.iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        r10.add(r12.next());
        goto L7
    }

    public final FluentIterable<E> cycle() {
        return from(Iterables.cycle(getDelegate()));
    }

    public final FluentIterable<E> filter(Predicate<? super E> r10) {
        return from(Iterables.filter(getDelegate(), r10));
    }

    public final Optional<E> first() {
        Iterator<E> r10 = getDelegate().iterator();
        if (r10.hasNext() == false) goto L6;
        return Optional.of(r10.next());
    L6:
        return Optional.absent();
    }

    public final Optional<E> firstMatch(Predicate<? super E> r10) {
        return Iterables.tryFind(getDelegate(), r10);
    }

    public final E get(int r10) {
        return (E) Iterables.get(getDelegate(), r10);
    }

    public final <K> ImmutableListMultimap<K, E> index(Function<? super E, K> r10) {
        return Multimaps.index(getDelegate(), r10);
    }

    public final boolean isEmpty() {
        return !getDelegate().iterator().hasNext();
    }

    @Beta
    public final String join(Joiner r10) {
        return r10.join(this);
    }

    public final Optional<E> last() {
        Iterable<E> r10 = getDelegate();
        if ((r10 instanceof List) == false) goto L10;
        List r11 = (List) r10;
        if (r11.isEmpty() == false) goto L9;
        return Optional.absent();
    L9:
        return Optional.of(r11.get(r11.size() - 1));
    L10:
        Iterator<E> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L15;
        return Optional.absent();
    L15:
        if ((r10 instanceof SortedSet) == true) goto L17;
    L18:
        E r13 = r12.next();
        if (r12.hasNext() == true) goto L18;
        return Optional.of(r13);
    L17:
        return Optional.of(((SortedSet) r10).last());
    }

    public final FluentIterable<E> limit(int r10) {
        return from(Iterables.limit(getDelegate(), r10));
    }

    public final int size() {
        return Iterables.size(getDelegate());
    }

    public final FluentIterable<E> skip(int r10) {
        return from(Iterables.skip(getDelegate(), r10));
    }

    @GwtIncompatible
    public final E[] toArray(Class<E> r10) {
        return (E[]) Iterables.toArray(getDelegate(), r10);
    }

    public final ImmutableList<E> toList() {
        return ImmutableList.copyOf(getDelegate());
    }

    public final <V> ImmutableMap<E, V> toMap(Function<? super E, V> r10) {
        return Maps.toMap(getDelegate(), r10);
    }

    public final ImmutableMultiset<E> toMultiset() {
        return ImmutableMultiset.copyOf(getDelegate());
    }

    public final ImmutableSet<E> toSet() {
        return ImmutableSet.copyOf(getDelegate());
    }

    public final ImmutableList<E> toSortedList(Comparator<? super E> r10) {
        return Ordering.from(r10).immutableSortedCopy(getDelegate());
    }

    public final ImmutableSortedSet<E> toSortedSet(Comparator<? super E> r10) {
        return ImmutableSortedSet.copyOf(r10, getDelegate());
    }

    public String toString() {
        return Iterables.toString(getDelegate());
    }

    public final <T> FluentIterable<T> transform(Function<? super E, T> r10) {
        return from(Iterables.transform(getDelegate(), r10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> FluentIterable<T> transformAndConcat(Function<? super E, ? extends Iterable<? extends T>> r10) {
        return concat(transform(r10));
    }

    public final <K> ImmutableMap<K, E> uniqueIndex(Function<? super E, K> r10) {
        return Maps.uniqueIndex(getDelegate(), r10);
    }

    @Beta
    public static <T> FluentIterable<T> concat(Iterable<? extends T> r10, Iterable<? extends T> r11, Iterable<? extends T> r12) {
        return concatNoDefensiveCopy(new Iterable[]{r10, r11, r12});
    }

    @Beta
    public static <E> FluentIterable<E> from(E[] r10) {
        return from(Arrays.asList(r10));
    }

    @Beta
    public static <E> FluentIterable<E> of(@NullableDecl E r10, E... r11) {
        return from(Lists.asList(r10, r11));
    }

    @Beta
    public final FluentIterable<E> append(E... r10) {
        return concat(getDelegate(), Arrays.asList(r10));
    }

    @GwtIncompatible
    public final <T> FluentIterable<T> filter(Class<T> r10) {
        return from(Iterables.filter(getDelegate(), r10));
    }

    public FluentIterable(Iterable<E> r10) {
        Preconditions.checkNotNull(r10);
        if (this != r10) goto L6;
        r10 = null;
    L6:
        this.iterableDelegate = Optional.fromNullable(r10);
    }

    @Beta
    public static <T> FluentIterable<T> concat(Iterable<? extends T> r10, Iterable<? extends T> r11, Iterable<? extends T> r12, Iterable<? extends T> r13) {
        return concatNoDefensiveCopy(new Iterable[]{r10, r11, r12, r13});
    }

    @Deprecated
    public static <E> FluentIterable<E> from(FluentIterable<E> r10) {
        return (FluentIterable) Preconditions.checkNotNull(r10);
    }

    @Beta
    public static <T> FluentIterable<T> concat(Iterable<? extends T>... r10) {
        return concatNoDefensiveCopy((Iterable[]) Arrays.copyOf(r10, r10.length));
    }

    @Beta
    public static <T> FluentIterable<T> concat(final Iterable<? extends Iterable<? extends T>> r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass2(r10);
    }
}
