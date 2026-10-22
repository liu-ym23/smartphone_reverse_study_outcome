package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.errorprone.annotations.Immutable;
import java.util.Comparator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
@Beta
public final class ElementOrder<T> {

    @NullableDecl
    private final Comparator<T> comparator;
    private final Type type;

    /* JADX INFO: renamed from: com.google.common.graph.ElementOrder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$graph$ElementOrder$Type = null;

        static {
            int[] r10 = new int[Type.values().length];
            $SwitchMap$com$google$common$graph$ElementOrder$Type = r10;
            r10[Type.UNORDERED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$common$graph$ElementOrder$Type[Type.INSERTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$common$graph$ElementOrder$Type[Type.SORTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type INSERTION = null;
        public static final Type SORTED = null;
        public static final Type UNORDERED = null;

        static {
            Type r10 = new Type("UNORDERED", 0);
            UNORDERED = r10;
            Type r11 = new Type("INSERTION", 1);
            INSERTION = r11;
            Type r12 = new Type("SORTED", 2);
            SORTED = r12;
            $VALUES = new Type[]{r10, r11, r12};
        }

        private Type(String r10, int r11) {
            super(r10, r11);
        }

        public static Type valueOf(String r10) {
            return (Type) Enum.valueOf(Type.class, r10);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    private ElementOrder(Type r10, @NullableDecl Comparator<T> r11) {
        this.type = (Type) Preconditions.checkNotNull(r10);
        this.comparator = r11;
        boolean r12 = false;
        if (r10 != Type.SORTED) goto L5;
        boolean r13 = true;
    L6:
        if (r11 == null) goto L8;
        boolean r14 = true;
    L9:
        if (r13 != r14) goto L11;
        r12 = true;
    L11:
        Preconditions.checkState(r12);
        return;
    L8:
        r14 = false;
        goto L9
    L5:
        r13 = false;
        goto L6
    }

    public static <S> ElementOrder<S> insertion() {
        return new ElementOrder(Type.INSERTION, null);
    }

    public static <S extends Comparable<? super S>> ElementOrder<S> natural() {
        return new ElementOrder(Type.SORTED, Ordering.natural());
    }

    public static <S> ElementOrder<S> sorted(Comparator<S> r10) {
        return new ElementOrder(Type.SORTED, r10);
    }

    public static <S> ElementOrder<S> unordered() {
        return new ElementOrder(Type.UNORDERED, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T1 extends T> ElementOrder<T1> cast() {
        return this;
    }

    public Comparator<T> comparator() {
        Comparator<T> r10 = this.comparator;
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new UnsupportedOperationException("This ordering does not define a comparator.");
    }

    public <K extends T, V> Map<K, V> createMap(int r10) {
        int r11 = AnonymousClass1.$SwitchMap$com$google$common$graph$ElementOrder$Type[this.type.ordinal()];
        if (r11 == 1) goto L15;
        if (r11 == 2) goto L13;
        if (r11 != 3) goto L11;
        return Maps.newTreeMap(comparator());
    L11:
        throw new AssertionError();
    L13:
        return Maps.newLinkedHashMapWithExpectedSize(r10);
    L15:
        return Maps.newHashMapWithExpectedSize(r10);
    }

    public boolean equals(@NullableDecl Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ElementOrder) == true) goto L8;
        return false;
    L8:
        ElementOrder r11 = (ElementOrder) r10;
        if (this.type != r11.type) goto L14;
        if (Objects.equal(this.comparator, r11.comparator) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.type, this.comparator});
    }

    public String toString() {
        MoreObjects.ToStringHelper r10 = MoreObjects.toStringHelper(this).add("type", this.type);
        Comparator<T> r11 = this.comparator;
        if (r11 == null) goto L6;
        r10.add("comparator", r11);
    L6:
        return r10.toString();
    }

    public Type type() {
        return this.type;
    }
}
