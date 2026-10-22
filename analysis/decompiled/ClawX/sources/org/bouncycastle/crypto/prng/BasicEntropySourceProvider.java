package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;

/* loaded from: classes.dex */
public class BasicEntropySourceProvider implements EntropySourceProvider {
    private final boolean _predictionResistant;
    private final SecureRandom _sr;

    public BasicEntropySourceProvider(SecureRandom secureRandom, boolean z) {
        this._sr = secureRandom;
        this._predictionResistant = z;
    }

    @Override // org.bouncycastle.crypto.prng.EntropySourceProvider
    public EntropySource get(final int i8) {
        return new EntropySource(this) { // from class: org.bouncycastle.crypto.prng.BasicEntropySourceProvider.1
            final /* synthetic */ BasicEntropySourceProvider this$0;

            {
                this.this$0 = this;
            }

            @Override // org.bouncycastle.crypto.prng.EntropySource
            public int entropySize() {
                return i8;
            }

            @Override // org.bouncycastle.crypto.prng.EntropySource
            public byte[] getEntropy() {
                if (!(this.this$0._sr instanceof SP800SecureRandom) && !(this.this$0._sr instanceof X931SecureRandom)) {
                    return this.this$0._sr.generateSeed((i8 + 7) / 8);
                }
                byte[] bArr = new byte[(i8 + 7) / 8];
                this.this$0._sr.nextBytes(bArr);
                return bArr;
            }

            @Override // org.bouncycastle.crypto.prng.EntropySource
            public boolean isPredictionResistant() {
                return this.this$0._predictionResistant;
            }
        };
    }
}
