package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class Converter<A, B> implements Function<A, B> {
    private final boolean handleNullAutomatically;

    @LazyInit
    @MonotonicNonNullDecl
    private transient Converter<B, A> reverse;

    public static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> first;
        final Converter<B, C> second;

        public ConverterComposition(Converter<A, B> r10, Converter<B, C> r11) {
            this.first = r10;
            this.second = r11;
        }

        @Override // com.google.common.base.Converter
        @NullableDecl
        public A correctedDoBackward(@NullableDecl C r10) {
            return (A) this.first.correctedDoBackward(this.second.correctedDoBackward(r10));
        }

        @Override // com.google.common.base.Converter
        @NullableDecl
        public C correctedDoForward(@NullableDecl A r10) {
            return (C) this.second.correctedDoForward(this.first.correctedDoForward(r10));
        }

        @Override // com.google.common.base.Converter
        public A doBackward(C r10) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        public C doForward(A r10) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof ConverterComposition) == false) goto L10;
            ConverterComposition r11 = (ConverterComposition) r10;
            if (this.first.equals(r11.first) == true) goto L7;
            return false;
        L7:
            if (this.second.equals(r11.second) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public String toString() {
            return this.first + ".andThen(" + this.second + ")";
        }
    }

    public static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
        private final Function<? super B, ? extends A> backwardFunction;
        private final Function<? super A, ? extends B> forwardFunction;

        public /* synthetic */ FunctionBasedConverter(Function r10, Function r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        @Override // com.google.common.base.Converter
        public A doBackward(B r10) {
            return this.backwardFunction.apply(r10);
        }

        @Override // com.google.common.base.Converter
        public B doForward(A r10) {
            return this.forwardFunction.apply(r10);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof FunctionBasedConverter) == false) goto L10;
            FunctionBasedConverter r11 = (FunctionBasedConverter) r10;
            if (this.forwardFunction.equals(r11.forwardFunction) == true) goto L7;
            return false;
        L7:
            if (this.backwardFunction.equals(r11.backwardFunction) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            return (this.forwardFunction.hashCode() * 31) + this.backwardFunction.hashCode();
        }

        public String toString() {
            return "Converter.from(" + this.forwardFunction + ", " + this.backwardFunction + ")";
        }

        private FunctionBasedConverter(Function<? super A, ? extends B> r10, Function<? super B, ? extends A> r11) {
            this.forwardFunction = (Function) Preconditions.checkNotNull(r10);
            this.backwardFunction = (Function) Preconditions.checkNotNull(r11);
        }
    }

    public static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
        static final IdentityConverter INSTANCE = null;
        private static final long serialVersionUID = 0;

        static {
            INSTANCE = new IdentityConverter();
        }

        private IdentityConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        public <S> Converter<T, S> doAndThen(Converter<T, S> r10) {
            return (Converter) Preconditions.checkNotNull(r10, "otherConverter");
        }

        @Override // com.google.common.base.Converter
        public T doBackward(T r10) {
            return r10;
        }

        @Override // com.google.common.base.Converter
        public T doForward(T r10) {
            return r10;
        }

        @Override // com.google.common.base.Converter
        public IdentityConverter<T> reverse() {
            return this;
        }

        public String toString() {
            return "Converter.identity()";
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ Converter reverse() {
            return reverse();
        }
    }

    public static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> original;

        public ReverseConverter(Converter<A, B> r10) {
            this.original = r10;
        }

        @Override // com.google.common.base.Converter
        @NullableDecl
        public B correctedDoBackward(@NullableDecl A r10) {
            return this.original.correctedDoForward(r10);
        }

        @Override // com.google.common.base.Converter
        @NullableDecl
        public A correctedDoForward(@NullableDecl B r10) {
            return this.original.correctedDoBackward(r10);
        }

        @Override // com.google.common.base.Converter
        public B doBackward(A r10) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        public A doForward(B r10) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof ReverseConverter) == true) goto L5;
            return false;
        L5:
            return this.original.equals(((ReverseConverter) r10).original);
        }

        public int hashCode() {
            return ~this.original.hashCode();
        }

        @Override // com.google.common.base.Converter
        public Converter<A, B> reverse() {
            return this.original;
        }

        public String toString() {
            return this.original + ".reverse()";
        }
    }

    public Converter() {
        this(true);
    }

    public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> r10, Function<? super B, ? extends A> r11) {
        return new FunctionBasedConverter(r10, r11, null);
    }

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.INSTANCE;
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> r10) {
        return doAndThen(r10);
    }

    @Override // com.google.common.base.Function
    @CanIgnoreReturnValue
    @NullableDecl
    @Deprecated
    public final B apply(@NullableDecl A r10) {
        return convert(r10);
    }

    @CanIgnoreReturnValue
    @NullableDecl
    public final B convert(@NullableDecl A r10) {
        return correctedDoForward(r10);
    }

    @CanIgnoreReturnValue
    public Iterable<B> convertAll(final Iterable<? extends A> r10) {
        Preconditions.checkNotNull(r10, "fromIterable");
        return new AnonymousClass1(this, r10);
    }

    @NullableDecl
    public A correctedDoBackward(@NullableDecl B r10) {
        if (this.handleNullAutomatically == false) goto L9;
        if (r10 != null) goto L7;
        return null;
    L7:
        return (A) Preconditions.checkNotNull(doBackward(r10));
    L9:
        return doBackward(r10);
    }

    @NullableDecl
    public B correctedDoForward(@NullableDecl A r10) {
        if (this.handleNullAutomatically == false) goto L9;
        if (r10 != null) goto L7;
        return null;
    L7:
        return (B) Preconditions.checkNotNull(doForward(r10));
    L9:
        return doForward(r10);
    }

    public <C> Converter<A, C> doAndThen(Converter<B, C> r10) {
        return new ConverterComposition(this, (Converter) Preconditions.checkNotNull(r10));
    }

    @ForOverride
    public abstract A doBackward(B r10);

    @ForOverride
    public abstract B doForward(A r10);

    @Override // com.google.common.base.Function
    public boolean equals(@NullableDecl Object r10) {
        return super.equals(r10);
    }

    @CanIgnoreReturnValue
    public Converter<B, A> reverse() {
        Converter<B, A> r10 = this.reverse;
        if (r10 != null) goto L6;
        ReverseConverter r11 = new ReverseConverter(this);
        this.reverse = r11;
        return r11;
    L6:
        return r10;
    }

    public Converter(boolean r10) {
        this.handleNullAutomatically = r10;
    }
}
