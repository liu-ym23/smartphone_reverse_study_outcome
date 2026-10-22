package org.apache.commons.math.fraction;

import java.io.Serializable;
import org.apache.commons.math.Field;

/* JADX INFO: loaded from: classes3.dex */
public class BigFractionField implements Field<BigFraction>, Serializable {
    private static final long serialVersionUID = -1699294557189741703L;

    /* JADX INFO: renamed from: org.apache.commons.math.fraction.BigFractionField$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class LazyHolder {
        private static final BigFractionField INSTANCE = null;

        private LazyHolder() {
        }

        static /* synthetic */ BigFractionField access$000() {
            return INSTANCE;
        }

        static {
            INSTANCE = new BigFractionField(null);
        }
    }

    /* synthetic */ BigFractionField(AnonymousClass1 x0) {
        this();
    }

    @Override // org.apache.commons.math.Field
    public /* bridge */ /* synthetic */ BigFraction getOne() {
        return getOne2();
    }

    @Override // org.apache.commons.math.Field
    public /* bridge */ /* synthetic */ BigFraction getZero() {
        return getZero2();
    }

    private BigFractionField() {
    }

    public static BigFractionField getInstance() {
        return LazyHolder.access$000();
    }

    @Override // org.apache.commons.math.Field
    /* JADX INFO: renamed from: getOne, reason: avoid collision after fix types in other method */
    public BigFraction getOne2() {
        return BigFraction.ONE;
    }

    @Override // org.apache.commons.math.Field
    /* JADX INFO: renamed from: getZero, reason: avoid collision after fix types in other method */
    public BigFraction getZero2() {
        return BigFraction.ZERO;
    }

    private Object readResolve() {
        return LazyHolder.access$000();
    }
}
