package org.bouncycastle.crypto.prng;

/* loaded from: classes.dex */
public class ThreadedSeedGenerator {

    public static class SeedGenerator implements Runnable {
        private volatile int counter;
        private volatile boolean stop;

        private SeedGenerator() {
            this.counter = 0;
            this.stop = false;
        }

        public byte[] generateSeed(int i8, boolean z) throws InterruptedException {
            Thread thread = new Thread(this);
            byte[] bArr = new byte[i8];
            this.counter = 0;
            this.stop = false;
            thread.start();
            if (!z) {
                i8 *= 8;
            }
            int i9 = 0;
            for (int i10 = 0; i10 < i8; i10++) {
                while (this.counter == i9) {
                    try {
                        Thread.sleep(1L);
                    } catch (InterruptedException unused) {
                    }
                }
                i9 = this.counter;
                if (z) {
                    bArr[i10] = (byte) (i9 & 255);
                } else {
                    int i11 = i10 / 8;
                    bArr[i11] = (byte) ((bArr[i11] << 1) | (i9 & 1));
                }
            }
            this.stop = true;
            return bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.stop) {
                this.counter++;
            }
        }
    }

    public byte[] generateSeed(int i8, boolean z) {
        return new SeedGenerator().generateSeed(i8, z);
    }
}
