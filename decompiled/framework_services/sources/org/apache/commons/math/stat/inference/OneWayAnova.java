package org.apache.commons.math.stat.inference;

import java.util.Collection;
import org.apache.commons.math.MathException;

/* JADX INFO: loaded from: classes3.dex */
public interface OneWayAnova {
    double anovaFValue(Collection<double[]> r1) throws IllegalArgumentException, MathException;

    double anovaPValue(Collection<double[]> r1) throws IllegalArgumentException, MathException;

    boolean anovaTest(Collection<double[]> r1, double r2) throws IllegalArgumentException, MathException;
}
