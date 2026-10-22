package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class MultimapBuilder<K0, V0> {
    private static final int DEFAULT_EXPECTED_KEYS = 8;

    public static final class ArrayListSupplier<V> implements Supplier<List<V>>, Serializable {
        private final int expectedValuesPerKey;

        public ArrayListSupplier(int r10) {
            this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(r10, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        @Override // com.google.common.base.Supplier
        public List<V> get() {
            return new ArrayList(this.expectedValuesPerKey);
        }
    }

    public static final class EnumSetSupplier<V extends Enum<V>> implements Supplier<Set<V>>, Serializable {
        private final Class<V> clazz;

        public EnumSetSupplier(Class<V> r10) {
            this.clazz = (Class) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.base.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        @Override // com.google.common.base.Supplier
        public Set<V> get() {
            return EnumSet.noneOf(this.clazz);
        }
    }

    public static final class HashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        public HashSetSupplier(int r10) {
            this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(r10, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        @Override // com.google.common.base.Supplier
        public Set<V> get() {
            return Platform.newHashSetWithExpectedSize(this.expectedValuesPerKey);
        }
    }

    public static final class LinkedHashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        public LinkedHashSetSupplier(int r10) {
            this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(r10, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        @Override // com.google.common.base.Supplier
        public Set<V> get() {
            return Platform.newLinkedHashSetWithExpectedSize(this.expectedValuesPerKey);
        }
    }

    public static final enum LinkedListSupplier extends Enum<LinkedListSupplier> implements Supplier<List<Object>> {
        private static final /* synthetic */ LinkedListSupplier[] $VALUES = null;
        public static final LinkedListSupplier INSTANCE = null;

        static {
            LinkedListSupplier r10 = new LinkedListSupplier("INSTANCE", 0);
            INSTANCE = r10;
            $VALUES = new LinkedListSupplier[]{r10};
        }

        private LinkedListSupplier(String r10, int r11) {
            super(r10, r11);
        }

        public static <V> Supplier<List<V>> instance() {
            return INSTANCE;
        }

        public static LinkedListSupplier valueOf(String r10) {
            return (LinkedListSupplier) Enum.valueOf(LinkedListSupplier.class, r10);
        }

        public static LinkedListSupplier[] values() {
            return (LinkedListSupplier[]) $VALUES.clone();
        }

        @Override // com.google.common.base.Supplier
        public /* bridge */ /* synthetic */ List<Object> get() {
            return get2();
        }

        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public List<Object> get2() {
            return new LinkedList();
        }
    }

    public static abstract class ListMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        public ListMultimapBuilder() {
            super(null);
        }

        @Override // com.google.common.collect.MultimapBuilder
        public abstract <K extends K0, V extends V0> ListMultimap<K, V> build();

        @Override // com.google.common.collect.MultimapBuilder
        public /* bridge */ /* synthetic */ Multimap build() {
            return build();
        }

        @Override // com.google.common.collect.MultimapBuilder
        public /* bridge */ /* synthetic */ Multimap build(Multimap r10) {
            return build(r10);
        }

        @Override // com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> ListMultimap<K, V> build(Multimap<? extends K, ? extends V> r10) {
            return (ListMultimap) super.build(r10);
        }
    }

    public static abstract class MultimapBuilderWithKeys<K0> {
        private static final int DEFAULT_EXPECTED_VALUES_PER_KEY = 2;

        public MultimapBuilderWithKeys() {
        }

        public ListMultimapBuilder<K0, Object> arrayListValues() {
            return arrayListValues(2);
        }

        public abstract <K extends K0, V> Map<K, Collection<V>> createMap();

        public <V0 extends Enum<V0>> SetMultimapBuilder<K0, V0> enumSetValues(final Class<V0> r10) {
            Preconditions.checkNotNull(r10, "valueClass");
            return new AnonymousClass6(this, r10);
        }

        public SetMultimapBuilder<K0, Object> hashSetValues() {
            return hashSetValues(2);
        }

        public SetMultimapBuilder<K0, Object> linkedHashSetValues() {
            return linkedHashSetValues(2);
        }

        public ListMultimapBuilder<K0, Object> linkedListValues() {
            return new AnonymousClass2(this);
        }

        public SortedSetMultimapBuilder<K0, Comparable> treeSetValues() {
            return treeSetValues(Ordering.natural());
        }

        public ListMultimapBuilder<K0, Object> arrayListValues(final int r10) {
            CollectPreconditions.checkNonnegative(r10, "expectedValuesPerKey");
            return new AnonymousClass1(this, r10);
        }

        public SetMultimapBuilder<K0, Object> hashSetValues(final int r10) {
            CollectPreconditions.checkNonnegative(r10, "expectedValuesPerKey");
            return new AnonymousClass3(this, r10);
        }

        public SetMultimapBuilder<K0, Object> linkedHashSetValues(final int r10) {
            CollectPreconditions.checkNonnegative(r10, "expectedValuesPerKey");
            return new AnonymousClass4(this, r10);
        }

        public <V0> SortedSetMultimapBuilder<K0, V0> treeSetValues(final Comparator<V0> r10) {
            Preconditions.checkNotNull(r10, "comparator");
            return new AnonymousClass5(this, r10);
        }
    }

    public static abstract class SetMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        public SetMultimapBuilder() {
            super(null);
        }

        @Override // com.google.common.collect.MultimapBuilder
        public /* bridge */ /* synthetic */ Multimap build() {
            return build();
        }

        @Override // com.google.common.collect.MultimapBuilder
        public abstract <K extends K0, V extends V0> SetMultimap<K, V> build();

        @Override // com.google.common.collect.MultimapBuilder
        public /* bridge */ /* synthetic */ Multimap build(Multimap r10) {
            return build(r10);
        }

        @Override // com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> SetMultimap<K, V> build(Multimap<? extends K, ? extends V> r10) {
            return (SetMultimap) super.build(r10);
        }
    }

    public static abstract class SortedSetMultimapBuilder<K0, V0> extends SetMultimapBuilder<K0, V0> {
        public SortedSetMultimapBuilder() {
        }

        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public /* bridge */ /* synthetic */ Multimap build() {
            return build();
        }

        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public abstract <K extends K0, V extends V0> SortedSetMultimap<K, V> build();

        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public /* bridge */ /* synthetic */ Multimap build(Multimap r10) {
            return build(r10);
        }

        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public /* bridge */ /* synthetic */ SetMultimap build() {
            return build();
        }

        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public /* bridge */ /* synthetic */ SetMultimap build(Multimap r10) {
            return build(r10);
        }

        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> SortedSetMultimap<K, V> build(Multimap<? extends K, ? extends V> r10) {
            return (SortedSetMultimap) super.build(r10);
        }
    }

    public static final class TreeSetSupplier<V> implements Supplier<SortedSet<V>>, Serializable {
        private final Comparator<? super V> comparator;

        public TreeSetSupplier(Comparator<? super V> r10) {
            this.comparator = (Comparator) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.base.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        @Override // com.google.common.base.Supplier
        public SortedSet<V> get() {
            return new TreeSet(this.comparator);
        }
    }

    public /* synthetic */ MultimapBuilder(AnonymousClass1 r10) {
        this();
    }

    public static <K0 extends Enum<K0>> MultimapBuilderWithKeys<K0> enumKeys(final Class<K0> r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass4(r10);
    }

    public static MultimapBuilderWithKeys<Object> hashKeys() {
        return hashKeys(8);
    }

    public static MultimapBuilderWithKeys<Object> linkedHashKeys() {
        return linkedHashKeys(8);
    }

    public static MultimapBuilderWithKeys<Comparable> treeKeys() {
        return treeKeys(Ordering.natural());
    }

    public abstract <K extends K0, V extends V0> Multimap<K, V> build();

    public <K extends K0, V extends V0> Multimap<K, V> build(Multimap<? extends K, ? extends V> r10) {
        Multimap<K, V> r11 = build();
        r11.putAll(r10);
        return r11;
    }

    private MultimapBuilder() {
    }

    public static MultimapBuilderWithKeys<Object> hashKeys(final int r10) {
        CollectPreconditions.checkNonnegative(r10, "expectedKeys");
        return new AnonymousClass1(r10);
    }

    public static MultimapBuilderWithKeys<Object> linkedHashKeys(final int r10) {
        CollectPreconditions.checkNonnegative(r10, "expectedKeys");
        return new AnonymousClass2(r10);
    }

    public static <K0> MultimapBuilderWithKeys<K0> treeKeys(final Comparator<K0> r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass3(r10);
    }
}
