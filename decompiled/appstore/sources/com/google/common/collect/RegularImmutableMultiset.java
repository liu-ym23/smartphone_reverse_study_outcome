package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true, serializable = true)
class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    static final RegularImmutableMultiset<Object> EMPTY = null;
    final transient ObjectCountHashMap<E> contents;

    @LazyInit
    private transient ImmutableSet<E> elementSet;
    private final transient int size;

    /* JADX INFO: renamed from: com.google.common.collect.RegularImmutableMultiset$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public final class ElementSet extends IndexedImmutableSet<E> {
        final /* synthetic */ RegularImmutableMultiset this$0;

        private ElementSet(RegularImmutableMultiset r10) {
            this.this$0 = r10;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object r10) {
            return this.this$0.contains(r10);
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public E get(int r10) {
            return this.this$0.contents.getKey(r10);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.contents.size();
        }

        public /* synthetic */ ElementSet(RegularImmutableMultiset r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    @GwtIncompatible
    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final int[] counts;
        final Object[] elements;

        public SerializedForm(Multiset<?> r10) {
            int r11 = r10.entrySet().size();
            this.elements = new Object[r11];
            this.counts = new int[r11];
            Iterator<Multiset.Entry<?>> r12 = r10.entrySet().iterator();
            int r13 = 0;
        L4:
            if (r12.hasNext() == false) goto L6;
            Multiset.Entry<?> r14 = r12.next();
            this.elements[r13] = r14.getElement();
            this.counts[r13] = r14.getCount();
            r13 = r13 + 1;
            goto L4
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Object readResolve() {
            ImmutableMultiset.Builder r10 = new ImmutableMultiset.Builder(this.elements.length);
            int r11 = 0;
        L3:
            Object[] r12 = this.elements;
            if (r11 >= r12.length) goto L7;
            r10.addCopies(r12[r11], this.counts[r11]);
            r11 = r11 + 1;
            goto L3
        L7:
            return r10.build();
        }
    }

    static {
        EMPTY = new RegularImmutableMultiset(ObjectCountHashMap.create());
    }

    public RegularImmutableMultiset(ObjectCountHashMap<E> r10) {
        this.contents = r10;
        long r11 = 0;
        int r12 = 0;
    L4:
        if (r12 >= r10.size()) goto L6;
        r11 = r11 + ((long) r10.getValue(r12));
        r12 = r12 + 1;
        goto L4
    L6:
        this.size = Ints.saturatedCast(r11);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object r10) {
        return this.contents.get(r10);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public Multiset.Entry<E> getEntry(int r10) {
        return this.contents.getEntry(r10);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> r10 = this.elementSet;
        if (r10 != null) goto L6;
        ElementSet r11 = new ElementSet(this, null);
        this.elementSet = r11;
        return r11;
    L6:
        return r10;
    }
}
