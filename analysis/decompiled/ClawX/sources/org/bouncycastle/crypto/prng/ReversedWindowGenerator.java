package org.bouncycastle.crypto.prng;

/* loaded from: classes.dex */
public class ReversedWindowGenerator implements RandomGenerator {
    private final RandomGenerator generator;
    private byte[] window;
    private int windowCount;

    public ReversedWindowGenerator(RandomGenerator randomGenerator, int i8) {
        if (randomGenerator == null) {
            throw new IllegalArgumentException("generator cannot be null");
        }
        if (i8 < 2) {
            throw new IllegalArgumentException("windowSize must be at least 2");
        }
        this.generator = randomGenerator;
        this.window = new byte[i8];
    }

    private void doNextBytes(byte[] bArr, int i8, int i9) {
        synchronized (this) {
            for (int i10 = 0; i10 < i9; i10++) {
                try {
                    if (this.windowCount < 1) {
                        RandomGenerator randomGenerator = this.generator;
                        byte[] bArr2 = this.window;
                        randomGenerator.nextBytes(bArr2, 0, bArr2.length);
                        this.windowCount = this.window.length;
                    }
                    byte[] bArr3 = this.window;
                    int i11 = this.windowCount - 1;
                    this.windowCount = i11;
                    bArr[i10 + i8] = bArr3[i11];
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // org.bouncycastle.crypto.prng.RandomGenerator
    public void addSeedMaterial(long j4) {
        synchronized (this) {
            this.windowCount = 0;
            this.generator.addSeedMaterial(j4);
        }
    }

    @Override // org.bouncycastle.crypto.prng.RandomGenerator
    public void nextBytes(byte[] bArr) {
        doNextBytes(bArr, 0, bArr.length);
    }

    @Override // org.bouncycastle.crypto.prng.RandomGenerator
    public void addSeedMaterial(byte[] bArr) {
        synchronized (this) {
            this.windowCount = 0;
            this.generator.addSeedMaterial(bArr);
        }
    }

    @Override // org.bouncycastle.crypto.prng.RandomGenerator
    public void nextBytes(byte[] bArr, int i8, int i9) {
        doNextBytes(bArr, i8, i9);
    }
}
