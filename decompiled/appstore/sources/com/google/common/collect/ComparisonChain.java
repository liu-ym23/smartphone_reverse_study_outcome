package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class ComparisonChain {
    private static final ComparisonChain ACTIVE = null;
    private static final ComparisonChain GREATER = null;
    private static final ComparisonChain LESS = null;

    public static final class InactiveComparisonChain extends ComparisonChain {
        final int result;

        public InactiveComparisonChain(int r10) {
            super(null);
            this.result = r10;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(double r10, double r11) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareFalseFirst(boolean r10, boolean r11) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareTrueFirst(boolean r10, boolean r11) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public int result() {
            return this.result;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(float r10, float r11) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(int r10, int r11) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(long r10, long r11) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(@NullableDecl Comparable r10, @NullableDecl Comparable r11) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public <T> ComparisonChain compare(@NullableDecl T r10, @NullableDecl T r11, @NullableDecl Comparator<T> r12) {
            return this;
        }
    }

    static {
        ACTIVE = new AnonymousClass1();
        LESS = new InactiveComparisonChain(-1);
        GREATER = new InactiveComparisonChain(1);
    }

    public /* synthetic */ ComparisonChain(AnonymousClass1 r10) {
        this();
    }

    public static /* synthetic */ ComparisonChain access$100() {
        return LESS;
    }

    public static /* synthetic */ ComparisonChain access$200() {
        return GREATER;
    }

    public static /* synthetic */ ComparisonChain access$300() {
        return ACTIVE;
    }

    public static ComparisonChain start() {
        return ACTIVE;
    }

    public abstract ComparisonChain compare(double r10, double r11);

    public abstract ComparisonChain compare(float r10, float r11);

    public abstract ComparisonChain compare(int r10, int r11);

    public abstract ComparisonChain compare(long r10, long r11);

    @Deprecated
    public final ComparisonChain compare(Boolean r10, Boolean r11) {
        return compareFalseFirst(r10.booleanValue(), r11.booleanValue());
    }

    public abstract ComparisonChain compare(Comparable<?> r10, Comparable<?> r11);

    public abstract <T> ComparisonChain compare(@NullableDecl T r10, @NullableDecl T r11, Comparator<T> r12);

    public abstract ComparisonChain compareFalseFirst(boolean r10, boolean r11);

    public abstract ComparisonChain compareTrueFirst(boolean r10, boolean r11);

    public abstract int result();

    private ComparisonChain() {
    }
}
