package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableMultiset<E> extends ImmutableCollection<E> implements Multiset<E> {
    private static final ImmutableMultiset<Object> EMPTY = null;
    private transient ImmutableSet<Multiset.Entry<E>> entrySet;

    public static class Builder<E> extends ImmutableCollection.Builder<E> {
        final Multiset<E> contents;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object r1) {
            return add(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object[] r1) {
            return add(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder addAll(Iterable r1) {
            return addAll(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder addAll(Iterator r1) {
            return addAll(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection build() {
            return build();
        }

        public Builder() {
            this(LinkedHashMultiset.create());
        }

        Builder(Multiset<E> r1) {
            this.contents = r1;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> add(E r2) {
            this.contents.add((E) Preconditions.checkNotNull(r2));
            return this;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public Builder<E> addCopies(E r2, int r3) {
            this.contents.add((E) Preconditions.checkNotNull(r2), r3);
            return this;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public Builder<E> setCount(E r2, int r3) {
            this.contents.setCount((E) Preconditions.checkNotNull(r2), r3);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> add(E... r1) {
            super.add(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> addAll(Iterable<? extends E> r3) {
            if ((r3 instanceof Multiset) == false) goto L8;
            Iterator<Multiset.Entry<E>> r4 = Multisets.cast(r3).entrySet().iterator();
        L6:
            if (r4.hasNext() == false) goto L9;
            Multiset.Entry<E> r0 = r4.next();
            addCopies(r0.getElement(), r0.getCount());
        L9:
            return this;
        L8:
            super.addAll(r3);
            goto L9
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> addAll(Iterator<? extends E> r1) {
            super.addAll(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ImmutableMultiset<E> build() {
            return ImmutableMultiset.copyOf(this.contents);
        }
    }

    private final class EntrySet extends ImmutableSet<Multiset.Entry<E>> {
        private static final long serialVersionUID = 0;
        final /* synthetic */ ImmutableMultiset this$0;

        private EntrySet(ImmutableMultiset r1) {
            this.this$0 = r1;
        }

        /* synthetic */ EntrySet(ImmutableMultiset r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return iterator();
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return this.this$0.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<Multiset.Entry<E>> iterator() {
            return asList().iterator();
        }

        @Override // com.google.common.collect.ImmutableCollection
        ImmutableList<Multiset.Entry<E>> createAsList() {
            return new AnonymousClass1(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.elementSet().size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r3) {
            if ((r3 instanceof Multiset.Entry) == false) goto L11;
            Multiset.Entry r4 = (Multiset.Entry) r3;
            if (r4.getCount() > 0) goto L8;
            return false;
        L8:
            if (this.this$0.count(r4.getElement()) != r4.getCount()) goto L12;
            return true;
        L12:
            return false;
        L11:
            return false;
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.this$0.hashCode();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return new EntrySetSerializedForm(this.this$0);
        }
    }

    static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        EntrySetSerializedForm(ImmutableMultiset<E> r1) {
            this.multiset = r1;
        }

        Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final int[] counts;
        final Object[] elements;

        SerializedForm(Multiset<?> r5) {
            int r0 = r5.entrySet().size();
            this.elements = new Object[r0];
            this.counts = new int[r0];
            Iterator<Multiset.Entry<?>> r6 = r5.entrySet().iterator();
            int r1 = 0;
        L4:
            if (r6.hasNext() == false) goto L6;
            Multiset.Entry<?> r2 = r6.next();
            this.elements[r1] = r2.getElement();
            this.counts[r1] = r2.getCount();
            r1 = r1 + 1;
            goto L4
        }

        Object readResolve() {
            LinkedHashMultiset r0 = LinkedHashMultiset.create(this.elements.length);
            int r1 = 0;
        L3:
            Object[] r2 = this.elements;
            if (r1 >= r2.length) goto L7;
            r0.add(r2[r1], this.counts[r1]);
            r1 = r1 + 1;
            goto L3
        L7:
            return ImmutableMultiset.copyOf(r0);
        }
    }

    abstract Multiset.Entry<E> getEntry(int r1);

    @Override // com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    static {
        EMPTY = new RegularImmutableMultiset(ImmutableMap.of(), 0);
    }

    public static <E> ImmutableMultiset<E> of() {
        return (ImmutableMultiset<E>) EMPTY;
    }

    public static <E> ImmutableMultiset<E> of(E r2) {
        return copyOfInternal(new Object[]{r2});
    }

    public static <E> ImmutableMultiset<E> of(E r2, E r3) {
        return copyOfInternal(new Object[]{r2, r3});
    }

    public static <E> ImmutableMultiset<E> of(E r2, E r3, E r4) {
        return copyOfInternal(new Object[]{r2, r3, r4});
    }

    public static <E> ImmutableMultiset<E> of(E r2, E r3, E r4, E r5) {
        return copyOfInternal(new Object[]{r2, r3, r4, r5});
    }

    public static <E> ImmutableMultiset<E> of(E r2, E r3, E r4, E r5, E r6) {
        return copyOfInternal(new Object[]{r2, r3, r4, r5, r6});
    }

    public static <E> ImmutableMultiset<E> of(E r1, E r2, E r3, E r4, E r5, E r6, E... r7) {
        return new Builder().add(r1).add(r2).add(r3).add(r4).add(r5).add(r6).add(r7).build();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] r0) {
        return copyOf(Arrays.asList(r0));
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> r2) {
        if ((r2 instanceof ImmutableMultiset) == false) goto L8;
        ImmutableMultiset<E> r0 = (ImmutableMultiset) r2;
        if (r0.isPartialView() == true) goto L8;
        return r0;
    L8:
        if ((r2 instanceof Multiset) == false) goto L10;
        Multiset r3 = Multisets.cast(r2);
    L12:
        return copyOfInternal(r3);
    L10:
        r3 = LinkedHashMultiset.create(r2);
        goto L12
    }

    private static <E> ImmutableMultiset<E> copyOfInternal(E... r0) {
        return copyOf(Arrays.asList(r0));
    }

    private static <E> ImmutableMultiset<E> copyOfInternal(Multiset<? extends E> r0) {
        return copyFromEntries(r0.entrySet());
    }

    static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends Multiset.Entry<? extends E>> r8) {
        ImmutableMap.Builder r0 = ImmutableMap.builder();
        Iterator<? extends Multiset.Entry<? extends E>> r9 = r8.iterator();
        long r3 = 0;
    L4:
        if (r9.hasNext() == false) goto L9;
        Multiset.Entry<? extends E> r5 = r9.next();
        int r6 = r5.getCount();
        if (r6 <= 0) goto L4;
        r0.put(r5.getElement(), Integer.valueOf(r6));
        r3 = r3 + ((long) r6);
        goto L4
    L9:
        if (r3 != 0) goto L13;
        return of();
    L13:
        return new RegularImmutableMultiset(r0.build(), Ints.saturatedCast(r3));
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> r1) {
        LinkedHashMultiset r0 = LinkedHashMultiset.create();
        Iterators.addAll(r0, r1);
        return copyOfInternal(r0);
    }

    ImmutableMultiset() {
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<E> iterator() {
        final UnmodifiableIterator<Multiset.Entry<E>> r0 = entrySet().iterator();
        return new AnonymousClass1(this, r0);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@Nullable Object r1) {
        if (count(r1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public boolean containsAll(Collection<?> r1) {
        return elementSet().containsAll(r1);
    }

    @Override // com.google.common.collect.Multiset
    @Deprecated
    public final int add(E r1, int r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    @Deprecated
    public final int remove(Object r1, int r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    @Deprecated
    public final int setCount(E r1, int r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    @Deprecated
    public final boolean setCount(E r1, int r2, int r3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] r4, int r5) {
        UnmodifiableIterator<Multiset.Entry<E>> r3 = entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Multiset.Entry<E> r0 = r3.next();
        Arrays.fill(r4, r5, r0.getCount() + r5, r0.getElement());
        r5 = r5 + r0.getCount();
        goto L4
    L6:
        return r5;
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public boolean equals(@Nullable Object r1) {
        return Multisets.equalsImpl(this, r1);
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        return Sets.hashCodeImpl(entrySet());
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.Multiset
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.Multiset
    public ImmutableSet<Multiset.Entry<E>> entrySet() {
        ImmutableSet<Multiset.Entry<E>> r0 = this.entrySet;
        if (r0 != null) goto L6;
        ImmutableSet<Multiset.Entry<E>> r1 = createEntrySet();
        this.entrySet = r1;
        return r1;
    L6:
        return r0;
    }

    private final ImmutableSet<Multiset.Entry<E>> createEntrySet() {
        if (isEmpty() == false) goto L6;
        return ImmutableSet.of();
    L6:
        return new EntrySet(this, null);
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <E> Builder<E> builder() {
        return new Builder();
    }
}
