package org.bouncycastle.crypto.params;

import java.security.SecureRandom;

/* loaded from: classes.dex */
public class DSAParameterGenerationParameters {
    public static final int DIGITAL_SIGNATURE_USAGE = 1;
    public static final int KEY_ESTABLISHMENT_USAGE = 2;
    private final int certainty;

    /* renamed from: l, reason: collision with root package name */
    private final int f4547l;

    /* renamed from: n, reason: collision with root package name */
    private final int f4548n;
    private final SecureRandom random;
    private final int usageIndex;

    public DSAParameterGenerationParameters(int i8, int i9, int i10, SecureRandom secureRandom) {
        this(i8, i9, i10, secureRandom, -1);
    }

    public int getCertainty() {
        return this.certainty;
    }

    public int getL() {
        return this.f4547l;
    }

    public int getN() {
        return this.f4548n;
    }

    public SecureRandom getRandom() {
        return this.random;
    }

    public int getUsageIndex() {
        return this.usageIndex;
    }

    public DSAParameterGenerationParameters(int i8, int i9, int i10, SecureRandom secureRandom, int i11) {
        this.f4547l = i8;
        this.f4548n = i9;
        this.certainty = i10;
        this.usageIndex = i11;
        this.random = secureRandom;
    }
}
