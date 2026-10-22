package org.bouncycastle.crypto.util;

import k7.b;

/* loaded from: classes.dex */
public class ScryptConfig extends PBKDFConfig {
    private final int blockSize;
    private final int costParameter;
    private final int parallelizationParameter;
    private final int saltLength;

    public static class Builder {
        private final int blockSize;
        private final int costParameter;
        private final int parallelizationParameter;
        private int saltLength = 16;

        public Builder(int i8, int i9, int i10) {
            if (i8 <= 1 || !isPowerOf2(i8)) {
                throw new IllegalArgumentException("Cost parameter N must be > 1 and a power of 2");
            }
            this.costParameter = i8;
            this.blockSize = i9;
            this.parallelizationParameter = i10;
        }

        private static boolean isPowerOf2(int i8) {
            return (i8 & (i8 + (-1))) == 0;
        }

        public ScryptConfig build() {
            return new ScryptConfig(this);
        }

        public Builder withSaltLength(int i8) {
            this.saltLength = i8;
            return this;
        }
    }

    private ScryptConfig(Builder builder) {
        super(b.f3661c);
        this.costParameter = builder.costParameter;
        this.blockSize = builder.blockSize;
        this.parallelizationParameter = builder.parallelizationParameter;
        this.saltLength = builder.saltLength;
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public int getCostParameter() {
        return this.costParameter;
    }

    public int getParallelizationParameter() {
        return this.parallelizationParameter;
    }

    public int getSaltLength() {
        return this.saltLength;
    }
}
