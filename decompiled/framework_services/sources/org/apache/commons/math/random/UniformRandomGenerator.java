package org.apache.commons.math.random;

import org.apache.commons.math.util.FastMath;

/* JADX INFO: loaded from: classes3.dex */
public class UniformRandomGenerator implements NormalizedRandomGenerator {
    private static final double SQRT3 = 0.0d;
    private static final long serialVersionUID = 1569292426375546027L;
    private final RandomGenerator generator;

    static {
        SQRT3 = FastMath.sqrt(3.0d);
    }

    public UniformRandomGenerator(RandomGenerator generator) {
        this.generator = generator;
    }

    @Override // org.apache.commons.math.random.NormalizedRandomGenerator
    public double nextNormalizedDouble() {
        return SQRT3 * ((this.generator.nextDouble() * 2.0d) - 1.0d);
    }
}
