package com.google.common.collect;

import java.util.Comparator;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ComparisonChain {
    private static final ComparisonChain ACTIVE = null;
    private static final ComparisonChain GREATER = null;
    private static final ComparisonChain LESS = null;

    private static final class InactiveComparisonChain extends ComparisonChain {
        final int result;

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(double r1, double r3) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(float r1, float r2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(int r1, int r2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(long r1, long r3) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compare(@Nullable Comparable r1, @Nullable Comparable r2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public <T> ComparisonChain compare(@Nullable T r1, @Nullable T r2, @Nullable Comparator<T> r3) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareFalseFirst(boolean r1, boolean r2) {
            return this;
        }

        @Override // com.google.common.collect.ComparisonChain
        public ComparisonChain compareTrueFirst(boolean r1, boolean r2) {
            return this;
        }

        InactiveComparisonChain(int r2) {
            super(null);
            this.result = r2;
        }

        @Override // com.google.common.collect.ComparisonChain
        public int result() {
            return this.result;
        }
    }

    public abstract ComparisonChain compare(double r1, double r3);

    public abstract ComparisonChain compare(float r1, float r2);

    public abstract ComparisonChain compare(int r1, int r2);

    public abstract ComparisonChain compare(long r1, long r3);

    public abstract ComparisonChain compare(Comparable<?> r1, Comparable<?> r2);

    public abstract <T> ComparisonChain compare(@Nullable T r1, @Nullable T r2, Comparator<T> r3);

    public abstract ComparisonChain compareFalseFirst(boolean r1, boolean r2);

    public abstract ComparisonChain compareTrueFirst(boolean r1, boolean r2);

    public abstract int result();

    /* synthetic */ ComparisonChain(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ ComparisonChain access$100() {
        return LESS;
    }

    static /* synthetic */ ComparisonChain access$200() {
        return GREATER;
    }

    static /* synthetic */ ComparisonChain access$300() {
        return ACTIVE;
    }

    private ComparisonChain() {
    }

    public static ComparisonChain start() {
        return ACTIVE;
    }

    static {
        ACTIVE = new AnonymousClass1();
        LESS = new InactiveComparisonChain(-1);
        GREATER = new InactiveComparisonChain(1);
    }
}
