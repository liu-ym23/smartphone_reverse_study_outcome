package io.ktor.network.tls.cipher;

import io.ktor.network.tls.CipherSuite;
import io.ktor.network.tls.KeysKt;
import io.ktor.network.tls.TLSRecordType;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a?\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\r\u001a?\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {"Lio/ktor/network/tls/CipherSuite;", "suite", "", "keyMaterial", "Lio/ktor/network/tls/TLSRecordType;", "recordType", "", "recordLength", "", "recordIv", "recordId", "Ljavax/crypto/Cipher;", "gcmEncryptCipher", "(Lio/ktor/network/tls/CipherSuite;[BLio/ktor/network/tls/TLSRecordType;IJJ)Ljavax/crypto/Cipher;", "gcmDecryptCipher", "ktor-network-tls"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GCMCipherKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Cipher gcmDecryptCipher(CipherSuite cipherSuite, byte[] bArr, TLSRecordType tLSRecordType, int i10, long j10, long j11) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(cipherSuite.getJdkCipherName());
        p.f(cipher);
        SecretKeySpec secretKeySpecServerKey = KeysKt.serverKey(bArr, cipherSuite);
        byte[] bArrCopyOf = Arrays.copyOf(KeysKt.serverIV(bArr, cipherSuite), cipherSuite.getIvLength());
        p.h(bArrCopyOf, "copyOf(...)");
        CipherKt.set(bArrCopyOf, cipherSuite.getFixedIvLength(), j10);
        cipher.init(2, secretKeySpecServerKey, new GCMParameterSpec(cipherSuite.getCipherTagSizeInBytes() * 8, bArrCopyOf));
        int ivLength = (i10 - (cipherSuite.getIvLength() - cipherSuite.getFixedIvLength())) - cipherSuite.getCipherTagSizeInBytes();
        if (ivLength >= 65536) {
            throw new IllegalStateException(("Content size should fit in 2 bytes, actual: " + ivLength).toString());
        }
        byte[] bArr2 = new byte[13];
        CipherKt.set(bArr2, 0, j11);
        bArr2[8] = (byte) tLSRecordType.getCode();
        bArr2[9] = 3;
        bArr2[10] = 3;
        CipherKt.set(bArr2, 11, (short) ivLength);
        cipher.updateAAD(bArr2);
        return cipher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Cipher gcmEncryptCipher(CipherSuite cipherSuite, byte[] bArr, TLSRecordType tLSRecordType, int i10, long j10, long j11) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(cipherSuite.getJdkCipherName());
        p.f(cipher);
        SecretKeySpec secretKeySpecClientKey = KeysKt.clientKey(bArr, cipherSuite);
        byte[] bArrCopyOf = Arrays.copyOf(KeysKt.clientIV(bArr, cipherSuite), cipherSuite.getIvLength());
        p.h(bArrCopyOf, "copyOf(...)");
        CipherKt.set(bArrCopyOf, cipherSuite.getFixedIvLength(), j10);
        cipher.init(1, secretKeySpecClientKey, new GCMParameterSpec(cipherSuite.getCipherTagSizeInBytes() * 8, bArrCopyOf));
        byte[] bArr2 = new byte[13];
        CipherKt.set(bArr2, 0, j11);
        bArr2[8] = (byte) tLSRecordType.getCode();
        bArr2[9] = 3;
        bArr2[10] = 3;
        CipherKt.set(bArr2, 11, (short) i10);
        cipher.updateAAD(bArr2);
        return cipher;
    }
}
