package com.stepos.core.ota.crypto;

import ai.onnxruntime.a;
import java.util.Arrays;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FekEnvelopeCipher {
    private final String alg;
    private final byte[] ciphertext;
    private final byte[] epk;
    private final String fingerprint;
    private final byte[] iv;
    private final int keyEpoch;

    public FekEnvelopeCipher(String alg, byte[] epk, byte[] iv, byte[] ciphertext, int i10, String fingerprint) {
        g.f(alg, "alg");
        g.f(epk, "epk");
        g.f(iv, "iv");
        g.f(ciphertext, "ciphertext");
        g.f(fingerprint, "fingerprint");
        this.alg = alg;
        this.epk = epk;
        this.iv = iv;
        this.ciphertext = ciphertext;
        this.keyEpoch = i10;
        this.fingerprint = fingerprint;
    }

    public static /* synthetic */ FekEnvelopeCipher copy$default(FekEnvelopeCipher fekEnvelopeCipher, String str, byte[] bArr, byte[] bArr2, byte[] bArr3, int i10, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = fekEnvelopeCipher.alg;
        }
        if ((i11 & 2) != 0) {
            bArr = fekEnvelopeCipher.epk;
        }
        if ((i11 & 4) != 0) {
            bArr2 = fekEnvelopeCipher.iv;
        }
        if ((i11 & 8) != 0) {
            bArr3 = fekEnvelopeCipher.ciphertext;
        }
        if ((i11 & 16) != 0) {
            i10 = fekEnvelopeCipher.keyEpoch;
        }
        if ((i11 & 32) != 0) {
            str2 = fekEnvelopeCipher.fingerprint;
        }
        int i12 = i10;
        String str3 = str2;
        return fekEnvelopeCipher.copy(str, bArr, bArr2, bArr3, i12, str3);
    }

    public final String component1() {
        return this.alg;
    }

    public final byte[] component2() {
        return this.epk;
    }

    public final byte[] component3() {
        return this.iv;
    }

    public final byte[] component4() {
        return this.ciphertext;
    }

    public final int component5() {
        return this.keyEpoch;
    }

    public final String component6() {
        return this.fingerprint;
    }

    public final FekEnvelopeCipher copy(String alg, byte[] epk, byte[] iv, byte[] ciphertext, int i10, String fingerprint) {
        g.f(alg, "alg");
        g.f(epk, "epk");
        g.f(iv, "iv");
        g.f(ciphertext, "ciphertext");
        g.f(fingerprint, "fingerprint");
        return new FekEnvelopeCipher(alg, epk, iv, ciphertext, i10, fingerprint);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FekEnvelopeCipher)) {
            return false;
        }
        FekEnvelopeCipher fekEnvelopeCipher = (FekEnvelopeCipher) obj;
        return g.b(this.alg, fekEnvelopeCipher.alg) && Arrays.equals(this.epk, fekEnvelopeCipher.epk) && Arrays.equals(this.iv, fekEnvelopeCipher.iv) && Arrays.equals(this.ciphertext, fekEnvelopeCipher.ciphertext) && this.keyEpoch == fekEnvelopeCipher.keyEpoch && g.b(this.fingerprint, fekEnvelopeCipher.fingerprint);
    }

    public final String getAlg() {
        return this.alg;
    }

    public final byte[] getCiphertext() {
        return this.ciphertext;
    }

    public final byte[] getEpk() {
        return this.epk;
    }

    public final String getFingerprint() {
        return this.fingerprint;
    }

    public final byte[] getIv() {
        return this.iv;
    }

    public final int getKeyEpoch() {
        return this.keyEpoch;
    }

    public int hashCode() {
        return this.fingerprint.hashCode() + ((((Arrays.hashCode(this.ciphertext) + ((Arrays.hashCode(this.iv) + ((Arrays.hashCode(this.epk) + (this.alg.hashCode() * 31)) * 31)) * 31)) * 31) + this.keyEpoch) * 31);
    }

    public String toString() {
        String str = this.alg;
        String string = Arrays.toString(this.epk);
        String string2 = Arrays.toString(this.iv);
        String string3 = Arrays.toString(this.ciphertext);
        int i10 = this.keyEpoch;
        String str2 = this.fingerprint;
        StringBuilder sbS = a.s("FekEnvelopeCipher(alg=", str, ", epk=", string, ", iv=");
        a.z(sbS, string2, ", ciphertext=", string3, ", keyEpoch=");
        sbS.append(i10);
        sbS.append(", fingerprint=");
        sbS.append(str2);
        sbS.append(")");
        return sbS.toString();
    }
}
