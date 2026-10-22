package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FluentIterable<E> implements Iterable<E> {
    private final Iterable<E> iterable;

    private static class FromIterableFunction<E> implements Function<Iterable<E>, FluentIterable<E>> {
        private FromIterableFunction() {
        }

        @Override // com.google.common.base.Function
        public /* bridge */ /* synthetic */ Object apply(Object r1) {
            return apply((Iterable) r1);
        }

        public FluentIterable<E> apply(Iterable<E> r1) {
            return FluentIterable.from(r1);
        }
    }

    protected FluentIterable() {
        this.iterable = this;
    }

    FluentIterable(Iterable<E> r1) {
        this.iterable = (Iterable) Preconditions.checkNotNull(r1);
    }

    public static <E> FluentIterable<E> from(final Iterable<E> r1) {
        if ((r1 instanceof FluentIterable) == false) goto L6;
        return (FluentIterable) r1;
    L6:
        return new AnonymousClass1(r1, r1);
    }

    @Deprecated
    public static <E> FluentIterable<E> from(FluentIterable<E> r0) {
        return (FluentIterable) Preconditions.checkNotNull(r0);
    }

    public static <E> FluentIterable<E> of(E[] r0) {
        return from(Lists.newArrayList(r0));
    }

    public String toString() {
        return Iterables.toString(this.iterable);
    }

    public final int size() {
        return Iterables.size(this.iterable);
    }

    public final boolean contains(@Nullable Object r1) {
        return Iterables.contains(this.iterable, r1);
    }

    @CheckReturnValue
    public final FluentIterable<E> cycle() {
        return from(Iterables.cycle(this.iterable));
    }

    @CheckReturnValue
    public final FluentIterable<E> append(Iterable<? extends E> r1) {
        return from(Iterables.concat(this.iterable, r1));
    }

    @CheckReturnValue
    public final FluentIterable<E> append(E... r1) {
        return from(Iterables.concat(this.iterable, Arrays.asList(r1)));
    }

    @CheckReturnValue
    public final FluentIterable<E> filter(Predicate<? super E> r1) {
        return from(Iterables.filter(this.iterable, r1));
    }

    @CheckReturnValue
    public final <T> FluentIterable<T> filter(Class<T> r1) {
        return from(Iterables.filter(this.iterable, r1));
    }

    public final boolean anyMatch(Predicate<? super E> r1) {
        return Iterables.any(this.iterable, r1);
    }

    public final boolean allMatch(Predicate<? super E> r1) {
        return Iterables.all(this.iterable, r1);
    }

    public final Optional<E> firstMatch(Predicate<? super E> r1) {
        return Iterables.tryFind(this.iterable, r1);
    }

    public final <T> FluentIterable<T> transform(Function<? super E, T> r1) {
        return from(Iterables.transform(this.iterable, r1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> FluentIterable<T> transformAndConcat(Function<? super E, ? extends Iterable<? extends T>> r1) {
        return from(Iterables.concat(transform(r1)));
    }

    public final Optional<E> first() {
        Iterator<E> r1 = this.iterable.iterator();
        if (r1.hasNext() == false) goto L6;
        return Optional.of(r1.next());
    L6:
        return Optional.absent();
    }

    public final Optional<E> last() {
        Iterable<E> r0 = this.iterable;
        if ((r0 instanceof List) == false) goto L10;
        List r1 = (List) r0;
        if (r1.isEmpty() == false) goto L9;
        return Optional.absent();
    L9:
        return Optional.of(r1.get(r1.size() - 1));
    L10:
        Iterator<E> r2 = r0.iterator();
        if (r2.hasNext() == false) goto L13;
        Iterable<E> r3 = this.iterable;
        if ((r3 instanceof SortedSet) == true) goto L17;
    L18:
        E r4 = r2.next();
        if (r2.hasNext() == true) goto L18;
        return Optional.of(r4);
    L17:
        return Optional.of(((SortedSet) r3).last());
    L13:
        return Optional.absent();
    }

    @CheckReturnValue
    public final FluentIterable<E> skip(int r1) {
        return from(Iterables.skip(this.iterable, r1));
    }

    @CheckReturnValue
    public final FluentIterable<E> limit(int r1) {
        return from(Iterables.limit(this.iterable, r1));
    }

    public final boolean isEmpty() {
        return !this.iterable.iterator().hasNext();
    }

    public final ImmutableList<E> toList() {
        return ImmutableList.copyOf(this.iterable);
    }

    public final ImmutableList<E> toSortedList(Comparator<? super E> r1) {
        return Ordering.from(r1).immutableSortedCopy(this.iterable);
    }

    public final ImmutableSet<E> toSet() {
        return ImmutableSet.copyOf(this.iterable);
    }

    public final ImmutableSortedSet<E> toSortedSet(Comparator<? super E> r1) {
        return ImmutableSortedSet.copyOf(r1, this.iterable);
    }

    public final <V> ImmutableMap<E, V> toMap(Function<? super E, V> r1) {
        return Maps.toMap(this.iterable, r1);
    }

    public final <K> ImmutableListMultimap<K, E> index(Function<? super E, K> r1) {
        return Multimaps.index(this.iterable, r1);
    }

    public final <K> ImmutableMap<K, E> uniqueIndex(Function<? super E, K> r1) {
        return Maps.uniqueIndex(this.iterable, r1);
    }

    public final E[] toArray(Class<E> r1) {
        return (E[]) Iterables.toArray(this.iterable, r1);
    }

    public final <C extends Collection<? super E>> C copyInto(C r2) {
        Preconditions.checkNotNull(r2);
        Iterable<E> r1 = this.iterable;
        if ((r1 instanceof Collection) == false) goto L5;
        r2.addAll(Collections2.cast(r1));
    L9:
        return r2;
    L5:
        Iterator<E> r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r2.add(r3.next());
        goto L7
    }

    public final String join(Joiner r1) {
        return r1.join(this);
    }

    public final E get(int r1) {
        return (E) Iterables.get(this.iterable, r1);
    }
}
