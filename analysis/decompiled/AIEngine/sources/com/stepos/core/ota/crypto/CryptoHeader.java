package com.stepos.core.ota.crypto;

import a0.a;
import com.stepos.core.ota.d;
import java.util.Arrays;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CryptoHeader {
    public static final Companion Companion = new Companion(null);
    public static final int HEADER_SIZE = 38;
    private final CryptoAlgorithm algorithm;
    private final int blockSize;
    private final long cipherLen;
    private final int formatVersion;
    private final byte[] iv;
    private final long plainLen;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public CryptoHeader(CryptoAlgorithm algorithm, int i10, byte[] iv, int i11, long j10, long j11) {
        g.f(algorithm, "algorithm");
        g.f(iv, "iv");
        this.algorithm = algorithm;
        this.formatVersion = i10;
        this.iv = iv;
        this.blockSize = i11;
        this.plainLen = j10;
        this.cipherLen = j11;
    }

    public static /* synthetic */ CryptoHeader copy$default(CryptoHeader cryptoHeader, CryptoAlgorithm cryptoAlgorithm, int i10, byte[] bArr, int i11, long j10, long j11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            cryptoAlgorithm = cryptoHeader.algorithm;
        }
        if ((i12 & 2) != 0) {
            i10 = cryptoHeader.formatVersion;
        }
        if ((i12 & 4) != 0) {
            bArr = cryptoHeader.iv;
        }
        if ((i12 & 8) != 0) {
            i11 = cryptoHeader.blockSize;
        }
        if ((i12 & 16) != 0) {
            j10 = cryptoHeader.plainLen;
        }
        if ((i12 & 32) != 0) {
            j11 = cryptoHeader.cipherLen;
        }
        long j12 = j11;
        long j13 = j10;
        return cryptoHeader.copy(cryptoAlgorithm, i10, bArr, i11, j13, j12);
    }

    public final CryptoAlgorithm component1() {
        return this.algorithm;
    }

    public final int component2() {
        return this.formatVersion;
    }

    public final byte[] component3() {
        return this.iv;
    }

    public final int component4() {
        return this.blockSize;
    }

    public final long component5() {
        return this.plainLen;
    }

    public final long component6() {
        return this.cipherLen;
    }

    public final CryptoHeader copy(CryptoAlgorithm algorithm, int i10, byte[] iv, int i11, long j10, long j11) {
        g.f(algorithm, "algorithm");
        g.f(iv, "iv");
        return new CryptoHeader(algorithm, i10, iv, i11, j10, j11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CryptoHeader)) {
            return false;
        }
        CryptoHeader cryptoHeader = (CryptoHeader) obj;
        return this.algorithm == cryptoHeader.algorithm && this.formatVersion == cryptoHeader.formatVersion && Arrays.equals(this.iv, cryptoHeader.iv) && this.blockSize == cryptoHeader.blockSize && this.plainLen == cryptoHeader.plainLen && this.cipherLen == cryptoHeader.cipherLen;
    }

    public final CryptoAlgorithm getAlgorithm() {
        return this.algorithm;
    }

    public final int getBlockCount() {
        long j10 = this.plainLen;
        int i10 = this.blockSize;
        return (int) (((j10 + i10) - 1) / i10);
    }

    public final int getBlockSize() {
        return this.blockSize;
    }

    public final long getCipherLen() {
        return this.cipherLen;
    }

    public final int getFormatVersion() {
        return this.formatVersion;
    }

    public final byte[] getIv() {
        return this.iv;
    }

    public final long getPlainLen() {
        return this.plainLen;
    }

    public int hashCode() {
        return Long.hashCode(this.cipherLen) + a.c((((Arrays.hashCode(this.iv) + (((this.algorithm.hashCode() * 31) + this.formatVersion) * 31)) * 31) + this.blockSize) * 31, this.plainLen, 31);
    }

    public final int plainBytesOf(int i10) {
        return i10 < getBlockCount() + (-1) ? this.blockSize : (int) (this.plainLen - ((getBlockCount() - 1) * this.blockSize));
    }

    public String toString() {
        CryptoAlgorithm cryptoAlgorithm = this.algorithm;
        int i10 = this.formatVersion;
        String string = Arrays.toString(this.iv);
        int i11 = this.blockSize;
        long j10 = this.plainLen;
        long j11 = this.cipherLen;
        StringBuilder sb2 = new StringBuilder("CryptoHeader(algorithm=");
        sb2.append(cryptoAlgorithm);
        sb2.append(", formatVersion=");
        sb2.append(i10);
        sb2.append(", iv=");
        d.o(i11, string, ", blockSize=", ", plainLen=", sb2);
        sb2.append(j10);
        return a.d(j11, ", cipherLen=", ")", sb2);
    }
}
