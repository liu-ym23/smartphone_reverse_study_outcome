package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class Predicates {

    /* JADX INFO: renamed from: com.google.common.base.Predicates$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class AndPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends Predicate<? super T>> components;

        public /* synthetic */ AndPredicate(List r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl T r10) {
            int r11 = 0;
        L4:
            if (r11 >= this.components.size()) goto L9;
            if (this.components.get(r11).apply(r10) == false) goto L7;
            r11 = r11 + 1;
            goto L4
        L7:
            return false;
        L9:
            return true;
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof AndPredicate) == true) goto L5;
            return false;
        L5:
            return this.components.equals(((AndPredicate) r10).components);
        }

        public int hashCode() {
            return this.components.hashCode() + 306654252;
        }

        public String toString() {
            return Predicates.access$800("and", this.components);
        }

        private AndPredicate(List<? extends Predicate<? super T>> r10) {
            this.components = r10;
        }
    }

    public static class CompositionPredicate<A, B> implements Predicate<A>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Function<A, ? extends B> f10333f;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final Predicate<B> f10334p;

        public /* synthetic */ CompositionPredicate(Predicate r10, Function r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl A r10) {
            return this.f10334p.apply(this.f10333f.apply(r10));
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof CompositionPredicate) == false) goto L10;
            CompositionPredicate r11 = (CompositionPredicate) r10;
            if (this.f10333f.equals(r11.f10333f) == true) goto L7;
            return false;
        L7:
            if (this.f10334p.equals(r11.f10334p) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            int r10 = this.f10333f.hashCode();
            return this.f10334p.hashCode() ^ r10;
        }

        public String toString() {
            return this.f10334p + "(" + this.f10333f + ")";
        }

        private CompositionPredicate(Predicate<B> r10, Function<A, ? extends B> r11) {
            this.f10334p = (Predicate) Preconditions.checkNotNull(r10);
            this.f10333f = (Function) Preconditions.checkNotNull(r11);
        }
    }

    @GwtIncompatible
    public static class ContainsPatternFromStringPredicate extends ContainsPatternPredicate {
        private static final long serialVersionUID = 0;

        public ContainsPatternFromStringPredicate(String r10) {
            super(Platform.compilePattern(r10));
        }

        @Override // com.google.common.base.Predicates.ContainsPatternPredicate
        public String toString() {
            return "Predicates.containsPattern(" + this.pattern.pattern() + ")";
        }
    }

    @GwtIncompatible
    public static class ContainsPatternPredicate implements Predicate<CharSequence>, Serializable {
        private static final long serialVersionUID = 0;
        final CommonPattern pattern;

        public ContainsPatternPredicate(CommonPattern r10) {
            this.pattern = (CommonPattern) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(CharSequence r10) {
            return apply2(r10);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof ContainsPatternPredicate) == false) goto L10;
            ContainsPatternPredicate r11 = (ContainsPatternPredicate) r10;
            if (Objects.equal(this.pattern.pattern(), r11.pattern.pattern()) == true) goto L7;
            return false;
        L7:
            if (this.pattern.flags() != r11.pattern.flags()) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.pattern.pattern(), Integer.valueOf(this.pattern.flags())});
        }

        public String toString() {
            return "Predicates.contains(" + MoreObjects.toStringHelper(this.pattern).add("pattern", this.pattern.pattern()).add("pattern.flags", this.pattern.flags()).toString() + ")";
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public boolean apply2(CharSequence r10) {
            return this.pattern.matcher(r10).find();
        }
    }

    public static class InPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Collection<?> target;

        public /* synthetic */ InPredicate(Collection r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl T r10) {
            return this.target.contains(r10);
        L4:
            return false;
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof InPredicate) == true) goto L5;
            return false;
        L5:
            return this.target.equals(((InPredicate) r10).target);
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "Predicates.in(" + this.target + ")";
        }

        private InPredicate(Collection<?> r10) {
            this.target = (Collection) Preconditions.checkNotNull(r10);
        }
    }

    @GwtIncompatible
    public static class InstanceOfPredicate implements Predicate<Object>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        public /* synthetic */ InstanceOfPredicate(Class r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl Object r10) {
            return this.clazz.isInstance(r10);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof InstanceOfPredicate) == true) goto L5;
            return false;
        L5:
            if (this.clazz != ((InstanceOfPredicate) r10).clazz) goto L9;
            return true;
        L9:
            return false;
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public String toString() {
            return "Predicates.instanceOf(" + this.clazz.getName() + ")";
        }

        private InstanceOfPredicate(Class<?> r10) {
            this.clazz = (Class) Preconditions.checkNotNull(r10);
        }
    }

    public static class IsEqualToPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final T target;

        public /* synthetic */ IsEqualToPredicate(Object r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(T r10) {
            return this.target.equals(r10);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof IsEqualToPredicate) == true) goto L5;
            return false;
        L5:
            return this.target.equals(((IsEqualToPredicate) r10).target);
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "Predicates.equalTo(" + this.target + ")";
        }

        private IsEqualToPredicate(T r10) {
            this.target = r10;
        }
    }

    public static class NotPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Predicate<T> predicate;

        public NotPredicate(Predicate<T> r10) {
            this.predicate = (Predicate) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl T r10) {
            return !this.predicate.apply(r10);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof NotPredicate) == true) goto L5;
            return false;
        L5:
            return this.predicate.equals(((NotPredicate) r10).predicate);
        }

        public int hashCode() {
            return ~this.predicate.hashCode();
        }

        public String toString() {
            return "Predicates.not(" + this.predicate + ")";
        }
    }

    public static abstract enum ObjectPredicate extends Enum<ObjectPredicate> implements Predicate<Object> {
        private static final /* synthetic */ ObjectPredicate[] $VALUES = null;
        public static final ObjectPredicate ALWAYS_FALSE = null;
        public static final ObjectPredicate ALWAYS_TRUE = null;
        public static final ObjectPredicate IS_NULL = null;
        public static final ObjectPredicate NOT_NULL = null;

        static {
            final String r10 = "ALWAYS_TRUE";
            final int r11 = 0;
            ObjectPredicate r12 = new AnonymousClass1(r10, r11);
            ALWAYS_TRUE = r12;
            final String r13 = "ALWAYS_FALSE";
            final int r14 = 1;
            ObjectPredicate r15 = new AnonymousClass2(r13, r14);
            ALWAYS_FALSE = r15;
            final String r16 = "IS_NULL";
            final int r17 = 2;
            ObjectPredicate r18 = new AnonymousClass3(r16, r17);
            IS_NULL = r18;
            final String r19 = "NOT_NULL";
            final int r20 = 3;
            ObjectPredicate r21 = new AnonymousClass4(r19, r20);
            NOT_NULL = r21;
            $VALUES = new ObjectPredicate[]{r12, r15, r18, r21};
        }

        private ObjectPredicate(String r10, int r11) {
            super(r10, r11);
        }

        public static ObjectPredicate valueOf(String r10) {
            return (ObjectPredicate) Enum.valueOf(ObjectPredicate.class, r10);
        }

        public static ObjectPredicate[] values() {
            return (ObjectPredicate[]) $VALUES.clone();
        }

        public <T> Predicate<T> withNarrowedType() {
            return this;
        }

        public /* synthetic */ ObjectPredicate(String r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
        }
    }

    public static class OrPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends Predicate<? super T>> components;

        public /* synthetic */ OrPredicate(List r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@NullableDecl T r10) {
            int r11 = 0;
        L4:
            if (r11 >= this.components.size()) goto L10;
            if (this.components.get(r11).apply(r10) == true) goto L7;
            r11 = r11 + 1;
            goto L4
        L7:
            return true;
        L10:
            return false;
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof OrPredicate) == true) goto L5;
            return false;
        L5:
            return this.components.equals(((OrPredicate) r10).components);
        }

        public int hashCode() {
            return this.components.hashCode() + 87855567;
        }

        public String toString() {
            return Predicates.access$800("or", this.components);
        }

        private OrPredicate(List<? extends Predicate<? super T>> r10) {
            this.components = r10;
        }
    }

    @GwtIncompatible
    public static class SubtypeOfPredicate implements Predicate<Class<?>>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        public /* synthetic */ SubtypeOfPredicate(Class r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Class<?> r10) {
            return apply2(r10);
        }

        @Override // com.google.common.base.Predicate
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof SubtypeOfPredicate) == true) goto L5;
            return false;
        L5:
            if (this.clazz != ((SubtypeOfPredicate) r10).clazz) goto L9;
            return true;
        L9:
            return false;
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public String toString() {
            return "Predicates.subtypeOf(" + this.clazz.getName() + ")";
        }

        private SubtypeOfPredicate(Class<?> r10) {
            this.clazz = (Class) Preconditions.checkNotNull(r10);
        }

        /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
        public boolean apply2(Class<?> r10) {
            return this.clazz.isAssignableFrom(r10);
        }
    }

    private Predicates() {
    }

    public static /* synthetic */ String access$800(String r10, Iterable r11) {
        return toStringHelper(r10, r11);
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> alwaysFalse() {
        return ObjectPredicate.ALWAYS_FALSE.withNarrowedType();
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> alwaysTrue() {
        return ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }

    public static <T> Predicate<T> and(Iterable<? extends Predicate<? super T>> r10) {
        return new AndPredicate(defensiveCopy(r10), null);
    }

    private static <T> List<Predicate<? super T>> asList(Predicate<? super T> r10, Predicate<? super T> r11) {
        return Arrays.asList(new Predicate[]{r10, r11});
    }

    public static <A, B> Predicate<A> compose(Predicate<B> r10, Function<A, ? extends B> r11) {
        return new CompositionPredicate(r10, r11, null);
    }

    @GwtIncompatible("java.util.regex.Pattern")
    public static Predicate<CharSequence> contains(Pattern r10) {
        return new ContainsPatternPredicate(new JdkPattern(r10));
    }

    @GwtIncompatible
    public static Predicate<CharSequence> containsPattern(String r10) {
        return new ContainsPatternFromStringPredicate(r10);
    }

    private static <T> List<T> defensiveCopy(T... r10) {
        return defensiveCopy(Arrays.asList(r10));
    }

    public static <T> Predicate<T> equalTo(@NullableDecl T r10) {
        if (r10 != null) goto L5;
        return isNull();
    L5:
        return new IsEqualToPredicate(r10, null);
    }

    public static <T> Predicate<T> in(Collection<? extends T> r10) {
        return new InPredicate(r10, null);
    }

    @GwtIncompatible
    public static Predicate<Object> instanceOf(Class<?> r10) {
        return new InstanceOfPredicate(r10, null);
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> isNull() {
        return ObjectPredicate.IS_NULL.withNarrowedType();
    }

    public static <T> Predicate<T> not(Predicate<T> r10) {
        return new NotPredicate(r10);
    }

    @GwtCompatible(serializable = true)
    public static <T> Predicate<T> notNull() {
        return ObjectPredicate.NOT_NULL.withNarrowedType();
    }

    public static <T> Predicate<T> or(Iterable<? extends Predicate<? super T>> r10) {
        return new OrPredicate(defensiveCopy(r10), null);
    }

    @Beta
    @GwtIncompatible
    public static Predicate<Class<?>> subtypeOf(Class<?> r10) {
        return new SubtypeOfPredicate(r10, null);
    }

    private static String toStringHelper(String r10, Iterable<?> r11) {
        StringBuilder r12 = new StringBuilder("Predicates.");
        r12.append(r10);
        r12.append('(');
        Iterator<?> r13 = r11.iterator();
        boolean r14 = true;
    L4:
        if (r13.hasNext() == false) goto L9;
        Object r15 = r13.next();
        if (r14 == true) goto L8;
        r12.append(',');
    L8:
        r12.append(r15);
        r14 = false;
        goto L4
    L9:
        r12.append(')');
        return r12.toString();
    }

    @SafeVarargs
    public static <T> Predicate<T> and(Predicate<? super T>... r10) {
        return new AndPredicate(defensiveCopy(r10), null);
    }

    public static <T> List<T> defensiveCopy(Iterable<T> r10) {
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(Preconditions.checkNotNull(r12.next()));
        goto L4
    L6:
        return r11;
    }

    @SafeVarargs
    public static <T> Predicate<T> or(Predicate<? super T>... r10) {
        return new OrPredicate(defensiveCopy(r10), null);
    }

    public static <T> Predicate<T> and(Predicate<? super T> r10, Predicate<? super T> r11) {
        return new AndPredicate(asList((Predicate) Preconditions.checkNotNull(r10), (Predicate) Preconditions.checkNotNull(r11)), null);
    }

    public static <T> Predicate<T> or(Predicate<? super T> r10, Predicate<? super T> r11) {
        return new OrPredicate(asList((Predicate) Preconditions.checkNotNull(r10), (Predicate) Preconditions.checkNotNull(r11)), null);
    }
}
