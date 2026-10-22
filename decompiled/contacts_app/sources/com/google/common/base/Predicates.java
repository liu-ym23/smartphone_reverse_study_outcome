package com.google.common.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Predicates {
    private static final Joiner COMMA_JOINER = null;

    /* JADX INFO: renamed from: com.google.common.base.Predicates$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class AndPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends Predicate<? super T>> components;

        /* synthetic */ AndPredicate(List r1, AnonymousClass1 r2) {
            this(r1);
        }

        private AndPredicate(List<? extends Predicate<? super T>> r1) {
            this.components = r1;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@Nullable T r4) {
            int r1 = 0;
        L4:
            if (r1 >= this.components.size()) goto L9;
            if (this.components.get(r1).apply(r4) == false) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            return false;
        L9:
            return true;
        }

        public int hashCode() {
            return this.components.hashCode() + 306654252;
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@Nullable Object r2) {
            if ((r2 instanceof AndPredicate) == true) goto L5;
            return false;
        L5:
            return this.components.equals(((AndPredicate) r2).components);
        }

        public String toString() {
            return "Predicates.and(" + Predicates.access$800().join(this.components) + ")";
        }
    }

    private static class AssignableFromPredicate implements Predicate<Class<?>>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        @Override // com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Class<?> r1) {
            return apply2(r1);
        }

        /* synthetic */ AssignableFromPredicate(Class r1, AnonymousClass1 r2) {
            this(r1);
        }

        private AssignableFromPredicate(Class<?> r1) {
            this.clazz = (Class) Preconditions.checkNotNull(r1);
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public boolean apply2(Class<?> r1) {
            return this.clazz.isAssignableFrom(r1);
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@Nullable Object r3) {
            if ((r3 instanceof AssignableFromPredicate) == true) goto L5;
            return false;
        L5:
            if (this.clazz != ((AssignableFromPredicate) r3).clazz) goto L9;
            return true;
        L9:
            return false;
        }

        public String toString() {
            return "Predicates.assignableFrom(" + this.clazz.getName() + ")";
        }
    }

    private static class CompositionPredicate<A, B> implements Predicate<A>, Serializable {
        private static final long serialVersionUID = 0;
        final Function<A, ? extends B> f;
        final Predicate<B> p;

        /* synthetic */ CompositionPredicate(Predicate r1, Function r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private CompositionPredicate(Predicate<B> r1, Function<A, ? extends B> r2) {
            this.p = (Predicate) Preconditions.checkNotNull(r1);
            this.f = (Function) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@Nullable A r2) {
            return this.p.apply(this.f.apply(r2));
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@Nullable Object r4) {
            if ((r4 instanceof CompositionPredicate) == false) goto L10;
            CompositionPredicate r5 = (CompositionPredicate) r4;
            if (this.f.equals(r5.f) == true) goto L7;
            return false;
        L7:
            if (this.p.equals(r5.p) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            int r0 = this.f.hashCode();
            return this.p.hashCode() ^ r0;
        }

        public String toString() {
            return this.p.toString() + "(" + this.f.toString() + ")";
        }
    }

    private static class ContainsPatternFromStringPredicate extends ContainsPatternPredicate {
        private static final long serialVersionUID = 0;

        ContainsPatternFromStringPredicate(String r1) {
            super(Pattern.compile(r1));
        }

        @Override // com.google.common.base.Predicates.ContainsPatternPredicate
        public String toString() {
            return "Predicates.containsPattern(" + this.pattern.pattern() + ")";
        }
    }

    private static class ContainsPatternPredicate implements Predicate<CharSequence>, Serializable {
        private static final long serialVersionUID = 0;
        final Pattern pattern;

        @Override // com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(CharSequence r1) {
            return apply2(r1);
        }

        ContainsPatternPredicate(Pattern r1) {
            this.pattern = (Pattern) Preconditions.checkNotNull(r1);
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public boolean apply2(CharSequence r1) {
            return this.pattern.matcher(r1).find();
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.pattern.pattern(), Integer.valueOf(this.pattern.flags())});
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@Nullable Object r4) {
            if ((r4 instanceof ContainsPatternPredicate) == false) goto L10;
            ContainsPatternPredicate r5 = (ContainsPatternPredicate) r4;
            if (Objects.equal(this.pattern.pattern(), r5.pattern.pattern()) == true) goto L7;
            return false;
        L7:
            if (Objects.equal(Integer.valueOf(this.pattern.flags()), Integer.valueOf(r5.pattern.flags())) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public String toString() {
            return "Predicates.contains(" + Objects.toStringHelper(this.pattern).add("pattern", this.pattern.pattern()).add("pattern.flags", this.pattern.flags()).toString() + ")";
        }
    }

    private static class InPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Collection<?> target;

        /* synthetic */ InPredicate(Collection r1, AnonymousClass1 r2) {
            this(r1);
        }

        private InPredicate(Collection<?> r1) {
            this.target = (Collection) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@Nullable T r2) {
            return this.target.contains(r2);
        L5:
            return false;
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@Nullable Object r2) {
            if ((r2 instanceof InPredicate) == true) goto L5;
            return false;
        L5:
            return this.target.equals(((InPredicate) r2).target);
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "Predicates.in(" + this.target + ")";
        }
    }

    private static class InstanceOfPredicate implements Predicate<Object>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        /* synthetic */ InstanceOfPredicate(Class r1, AnonymousClass1 r2) {
            this(r1);
        }

        private InstanceOfPredicate(Class<?> r1) {
            this.clazz = (Class) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@Nullable Object r1) {
            return this.clazz.isInstance(r1);
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@Nullable Object r3) {
            if ((r3 instanceof InstanceOfPredicate) == true) goto L5;
            return false;
        L5:
            if (this.clazz != ((InstanceOfPredicate) r3).clazz) goto L9;
            return true;
        L9:
            return false;
        }

        public String toString() {
            return "Predicates.instanceOf(" + this.clazz.getName() + ")";
        }
    }

    private static class IsEqualToPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final T target;

        /* synthetic */ IsEqualToPredicate(Object r1, AnonymousClass1 r2) {
            this(r1);
        }

        private IsEqualToPredicate(T r1) {
            this.target = r1;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(T r1) {
            return this.target.equals(r1);
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@Nullable Object r2) {
            if ((r2 instanceof IsEqualToPredicate) == true) goto L5;
            return false;
        L5:
            return this.target.equals(((IsEqualToPredicate) r2).target);
        }

        public String toString() {
            return "Predicates.equalTo(" + this.target + ")";
        }
    }

    private static class NotPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Predicate<T> predicate;

        NotPredicate(Predicate<T> r1) {
            this.predicate = (Predicate) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@Nullable T r1) {
            return !this.predicate.apply(r1);
        }

        public int hashCode() {
            return ~this.predicate.hashCode();
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@Nullable Object r2) {
            if ((r2 instanceof NotPredicate) == true) goto L5;
            return false;
        L5:
            return this.predicate.equals(((NotPredicate) r2).predicate);
        }

        public String toString() {
            return "Predicates.not(" + this.predicate.toString() + ")";
        }
    }

    static abstract enum ObjectPredicate extends Enum<ObjectPredicate> implements Predicate<Object> {
        private static final /* synthetic */ ObjectPredicate[] $VALUES = null;
        public static final ObjectPredicate ALWAYS_FALSE = null;
        public static final ObjectPredicate ALWAYS_TRUE = null;
        public static final ObjectPredicate IS_NULL = null;
        public static final ObjectPredicate NOT_NULL = null;

        <T> Predicate<T> withNarrowedType() {
            return this;
        }

        private ObjectPredicate(String r1, int r2) {
            super(r1, r2);
        }

        /* synthetic */ ObjectPredicate(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public static ObjectPredicate valueOf(String r1) {
            return (ObjectPredicate) Enum.valueOf(ObjectPredicate.class, r1);
        }

        public static ObjectPredicate[] values() {
            return (ObjectPredicate[]) $VALUES.clone();
        }

        static {
            final String r1 = "ALWAYS_TRUE";
            final int r2 = 0;
            ObjectPredicate r0 = new AnonymousClass1(r1, r2);
            ALWAYS_TRUE = r0;
            final String r3 = "ALWAYS_FALSE";
            final int r4 = 1;
            ObjectPredicate r5 = new AnonymousClass2(r3, r4);
            ALWAYS_FALSE = r5;
            final String r6 = "IS_NULL";
            final int r7 = 2;
            ObjectPredicate r8 = new AnonymousClass3(r6, r7);
            IS_NULL = r8;
            final String r9 = "NOT_NULL";
            final int r10 = 3;
            ObjectPredicate r11 = new AnonymousClass4(r9, r10);
            NOT_NULL = r11;
            $VALUES = new ObjectPredicate[]{r0, r5, r8, r11};
        }
    }

    private static class OrPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends Predicate<? super T>> components;

        /* synthetic */ OrPredicate(List r1, AnonymousClass1 r2) {
            this(r1);
        }

        private OrPredicate(List<? extends Predicate<? super T>> r1) {
            this.components = r1;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@Nullable T r4) {
            int r1 = 0;
        L4:
            if (r1 >= this.components.size()) goto L10;
            if (this.components.get(r1).apply(r4) == true) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            return this.components.hashCode() + 87855567;
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@Nullable Object r2) {
            if ((r2 instanceof OrPredicate) == true) goto L5;
            return false;
        L5:
            return this.components.equals(((OrPredicate) r2).components);
        }

        public String toString() {
            return "Predicates.or(" + Predicates.access$800().join(this.components) + ")";
        }
    }

    static /* synthetic */ Joiner access$800() {
        return COMMA_JOINER;
    }

    private Predicates() {
    }

    public static <T> Predicate<T> alwaysTrue() {
        return ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }

    public static <T> Predicate<T> alwaysFalse() {
        return ObjectPredicate.ALWAYS_FALSE.withNarrowedType();
    }

    public static <T> Predicate<T> isNull() {
        return ObjectPredicate.IS_NULL.withNarrowedType();
    }

    public static <T> Predicate<T> notNull() {
        return ObjectPredicate.NOT_NULL.withNarrowedType();
    }

    public static <T> Predicate<T> not(Predicate<T> r1) {
        return new NotPredicate(r1);
    }

    public static <T> Predicate<T> and(Iterable<? extends Predicate<? super T>> r2) {
        return new AndPredicate(defensiveCopy(r2), null);
    }

    public static <T> Predicate<T> and(Predicate<? super T>... r2) {
        return new AndPredicate(defensiveCopy(r2), null);
    }

    public static <T> Predicate<T> and(Predicate<? super T> r1, Predicate<? super T> r2) {
        return new AndPredicate(asList((Predicate) Preconditions.checkNotNull(r1), (Predicate) Preconditions.checkNotNull(r2)), null);
    }

    public static <T> Predicate<T> or(Iterable<? extends Predicate<? super T>> r2) {
        return new OrPredicate(defensiveCopy(r2), null);
    }

    public static <T> Predicate<T> or(Predicate<? super T>... r2) {
        return new OrPredicate(defensiveCopy(r2), null);
    }

    public static <T> Predicate<T> or(Predicate<? super T> r1, Predicate<? super T> r2) {
        return new OrPredicate(asList((Predicate) Preconditions.checkNotNull(r1), (Predicate) Preconditions.checkNotNull(r2)), null);
    }

    public static <T> Predicate<T> equalTo(@Nullable T r2) {
        if (r2 != null) goto L5;
        return isNull();
    L5:
        return new IsEqualToPredicate(r2, null);
    }

    public static Predicate<Object> instanceOf(Class<?> r2) {
        return new InstanceOfPredicate(r2, null);
    }

    public static Predicate<Class<?>> assignableFrom(Class<?> r2) {
        return new AssignableFromPredicate(r2, null);
    }

    public static <T> Predicate<T> in(Collection<? extends T> r2) {
        return new InPredicate(r2, null);
    }

    public static <A, B> Predicate<A> compose(Predicate<B> r2, Function<A, ? extends B> r3) {
        return new CompositionPredicate(r2, r3, null);
    }

    public static Predicate<CharSequence> containsPattern(String r1) {
        return new ContainsPatternFromStringPredicate(r1);
    }

    public static Predicate<CharSequence> contains(Pattern r1) {
        return new ContainsPatternPredicate(r1);
    }

    static {
        COMMA_JOINER = Joiner.on(',');
    }

    private static <T> List<Predicate<? super T>> asList(Predicate<? super T> r2, Predicate<? super T> r3) {
        return Arrays.asList(new Predicate[]{r2, r3});
    }

    private static <T> List<T> defensiveCopy(T... r0) {
        return defensiveCopy(Arrays.asList(r0));
    }

    static <T> List<T> defensiveCopy(Iterable<T> r2) {
        ArrayList r0 = new ArrayList();
        Iterator<T> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r0.add(Preconditions.checkNotNull(r3.next()));
        goto L4
    L6:
        return r0;
    }
}
