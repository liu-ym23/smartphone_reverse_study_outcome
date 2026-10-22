package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements Multiset<E> {

    @LazyInit
    private transient ImmutableList<E> asList;

    @LazyInit
    private transient ImmutableSet<Multiset.Entry<E>> entrySet;

    public static class Builder<E> extends ImmutableCollection.Builder<E> {
        boolean buildInvoked;
        ObjectCountHashMap<E> contents;
        boolean isLinkedHash;

        public Builder() {
            this(4);
        }

        @NullableDecl
        public static <T> ObjectCountHashMap<T> tryGetMap(Iterable<T> r10) {
            if ((r10 instanceof RegularImmutableMultiset) == false) goto L7;
            return ((RegularImmutableMultiset) r10).contents;
        L7:
            if ((r10 instanceof AbstractMapBasedMultiset) == true) goto L9;
            return null;
        L9:
            return ((AbstractMapBasedMultiset) r10).backingMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object r10) {
            return add(r10);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder addAll(Iterable r10) {
            return addAll(r10);
        }

        @CanIgnoreReturnValue
        public Builder<E> addCopies(E r10, int r11) {
            if (r11 != 0) goto L5;
            return this;
        L5:
            if (this.buildInvoked == false) goto L7;
            this.contents = new ObjectCountHashMap(this.contents);
            this.isLinkedHash = false;
        L7:
            this.buildInvoked = false;
            Preconditions.checkNotNull(r10);
            ObjectCountHashMap<E> r12 = this.contents;
            r12.put(r10, r11 + r12.get(r10));
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection build() {
            return build();
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
        @CanIgnoreReturnValue
        public Builder<E> setCount(E r10, int r11) {
            if (r11 != 0) goto L8;
            if (this.isLinkedHash == true) goto L8;
            this.contents = new ObjectCountLinkedHashMap(this.contents);
            this.isLinkedHash = true;
        L10:
            this.buildInvoked = false;
            Preconditions.checkNotNull(r10);
            if (r11 != 0) goto L13;
            this.contents.remove(r10);
        L14:
            return this;
        L13:
            this.contents.put((E) Preconditions.checkNotNull(r10), r11);
        L8:
            if (this.buildInvoked == false) goto L10;
            this.contents = new ObjectCountHashMap(this.contents);
            this.isLinkedHash = false;
            goto L10
        }

        public Builder(int r10) {
            this.buildInvoked = false;
            this.isLinkedHash = false;
            this.contents = ObjectCountHashMap.createWithExpectedSize(r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object[] r10) {
            return add(r10);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder addAll(Iterator r10) {
            return addAll(r10);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ImmutableMultiset<E> build() {
            if (this.contents.size() != 0) goto L7;
            return ImmutableMultiset.of();
        L7:
            if (this.isLinkedHash == false) goto L9;
            this.contents = new ObjectCountHashMap(this.contents);
            this.isLinkedHash = false;
        L9:
            this.buildInvoked = true;
            return new RegularImmutableMultiset(this.contents);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E r10) {
            return addCopies(r10, 1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> r10) {
            if ((r10 instanceof Multiset) == false) goto L13;
            Multiset r11 = Multisets.cast(r10);
            ObjectCountHashMap r12 = tryGetMap(r11);
            if (r12 == null) goto L9;
            ObjectCountHashMap<E> r13 = this.contents;
            r13.ensureCapacity(Math.max(r13.size(), r12.size()));
            int r14 = r12.firstIndex();
        L7:
            if (r14 < 0) goto L14;
            addCopies(r12.getKey(r14), r12.getValue(r14));
            r14 = r12.nextIndex(r14);
        L14:
            return this;
        L9:
            Set<Multiset.Entry<E>> r15 = r11.entrySet();
            ObjectCountHashMap<E> r16 = this.contents;
            r16.ensureCapacity(Math.max(r16.size(), r15.size()));
            Iterator<Multiset.Entry<E>> r17 = r11.entrySet().iterator();
        L11:
            if (r17.hasNext() == false) goto L14;
            Multiset.Entry<E> r18 = r17.next();
            addCopies(r18.getElement(), r18.getCount());
            goto L11
        L13:
            super.addAll(r10);
            goto L14
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... r10) {
            super.add(r10);
            return this;
        }

        public Builder(boolean r10) {
            this.buildInvoked = false;
            this.isLinkedHash = false;
            this.contents = null;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> r10) {
            super.addAll(r10);
            return this;
        }
    }

    public final class EntrySet extends IndexedImmutableSet<Multiset.Entry<E>> {
        private static final long serialVersionUID = 0;
        final /* synthetic */ ImmutableMultiset this$0;

        private EntrySet(ImmutableMultiset r10) {
            this.this$0 = r10;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r10) {
            if ((r10 instanceof Multiset.Entry) == false) goto L11;
            Multiset.Entry r11 = (Multiset.Entry) r10;
            if (r11.getCount() > 0) goto L8;
            return false;
        L8:
            if (this.this$0.count(r11.getElement()) != r11.getCount()) goto L12;
            return true;
        L12:
            return false;
        L11:
            return false;
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.this$0.hashCode();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.this$0.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.elementSet().size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        @GwtIncompatible
        public Object writeReplace() {
            return new EntrySetSerializedForm(this.this$0);
        }

        public /* synthetic */ EntrySet(ImmutableMultiset r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public Multiset.Entry<E> get(int r10) {
            return this.this$0.getEntry(r10);
        }
    }

    @GwtIncompatible
    public static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        public EntrySetSerializedForm(ImmutableMultiset<E> r10) {
            this.multiset = r10;
        }

        public Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    public ImmutableMultiset() {
    }

    public static <E> Builder<E> builder() {
        return new Builder();
    }

    private static <E> ImmutableMultiset<E> copyFromElements(E... r10) {
        return new Builder().add(r10).build();
    }

    public static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends Multiset.Entry<? extends E>> r10) {
        Builder r11 = new Builder(r10.size());
        Iterator<? extends Multiset.Entry<? extends E>> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        Multiset.Entry<? extends E> r13 = r12.next();
        r11.addCopies(r13.getElement(), r13.getCount());
        goto L4
    L7:
        return r11.build();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] r10) {
        return copyFromElements(r10);
    }

    private ImmutableSet<Multiset.Entry<E>> createEntrySet() {
        if (isEmpty() == false) goto L6;
        return ImmutableSet.of();
    L6:
        return new EntrySet(this, null);
    }

    public static <E> ImmutableMultiset<E> of() {
        return RegularImmutableMultiset.EMPTY;
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final int add(E r10, int r11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> r10 = this.asList;
        if (r10 != null) goto L6;
        ImmutableList<E> r11 = super.asList();
        this.asList = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object r10) {
        if (count(r10) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public int copyIntoArray(Object[] r10, int r11) {
        UnmodifiableIterator<Multiset.Entry<E>> r12 = entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Multiset.Entry<E> r13 = r12.next();
        Arrays.fill(r10, r11, r13.getCount() + r11, r13.getElement());
        r11 = r11 + r13.getCount();
        goto L4
    L6:
        return r11;
    }

    public abstract ImmutableSet<E> elementSet();

    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public boolean equals(@NullableDecl Object r10) {
        return Multisets.equalsImpl(this, r10);
    }

    public abstract Multiset.Entry<E> getEntry(int r10);

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        return Sets.hashCodeImpl(entrySet());
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final int remove(Object r10, int r11) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final int setCount(E r10, int r11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.Multiset
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public abstract Object writeReplace();

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> r10) {
        if ((r10 instanceof ImmutableMultiset) == false) goto L7;
        ImmutableMultiset<E> r11 = (ImmutableMultiset) r10;
        if (r11.isPartialView() == true) goto L7;
        return r11;
    L7:
        Builder r12 = new Builder(Multisets.inferDistinctElements(r10));
        r12.addAll(r10);
        return r12.build();
    }

    public static <E> ImmutableMultiset<E> of(E r10) {
        return copyFromElements(new Object[]{r10});
    }

    @Override // com.google.common.collect.Multiset
    public ImmutableSet<Multiset.Entry<E>> entrySet() {
        ImmutableSet<Multiset.Entry<E>> r10 = this.entrySet;
        if (r10 != null) goto L6;
        ImmutableSet<Multiset.Entry<E>> r11 = createEntrySet();
        this.entrySet = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<E> iterator() {
        final UnmodifiableIterator<Multiset.Entry<E>> r10 = entrySet().iterator();
        return new AnonymousClass1(this, r10);
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean setCount(E r10, int r11, int r12) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableMultiset<E> of(E r10, E r11) {
        return copyFromElements(new Object[]{r10, r11});
    }

    public static <E> ImmutableMultiset<E> of(E r10, E r11, E r12) {
        return copyFromElements(new Object[]{r10, r11, r12});
    }

    public static <E> ImmutableMultiset<E> of(E r10, E r11, E r12, E r13) {
        return copyFromElements(new Object[]{r10, r11, r12, r13});
    }

    public static <E> ImmutableMultiset<E> of(E r10, E r11, E r12, E r13, E r14) {
        return copyFromElements(new Object[]{r10, r11, r12, r13, r14});
    }

    public static <E> ImmutableMultiset<E> of(E r10, E r11, E r12, E r13, E r14, E r15, E... r16) {
        return new Builder().add(r10).add(r11).add(r12).add(r13).add(r14).add(r15).add(r16).build();
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> r10) {
        return new Builder().addAll(r10).build();
    }
}
