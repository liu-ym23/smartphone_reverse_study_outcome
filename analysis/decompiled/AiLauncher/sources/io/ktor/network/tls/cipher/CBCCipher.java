package io.ktor.network.tls.cipher;

import Y8.t;
import Z8.r;
import com.stepos.ame.sdk.SkillStoreKt;
import fb.C4074a;
import fb.s;
import fb.v;
import fb.x;
import io.ktor.network.tls.CipherSuite;
import io.ktor.network.tls.KeysKt;
import io.ktor.network.tls.TLSException;
import io.ktor.network.tls.TLSRecord;
import io.ktor.util.CryptoKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000f\u001a\u00020\u000e*\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\u001fR\u0014\u0010'\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010\"R\u0014\u0010(\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010%R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+¨\u0006-"}, d2 = {"Lio/ktor/network/tls/cipher/CBCCipher;", "Lio/ktor/network/tls/cipher/TLSCipher;", "Lio/ktor/network/tls/CipherSuite;", "suite", "", "keyMaterial", "<init>", "(Lio/ktor/network/tls/CipherSuite;[B)V", "Lio/ktor/network/tls/TLSRecord;", "record", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "prepareMac", "(Lio/ktor/network/tls/TLSRecord;[B)[B", "Lfb/s;", "LY8/t;", "writePadding", "(Lfb/s;)V", "", "paddingStart", "validatePadding", "([BI)V", "macOffset", "validateMac", "(Lio/ktor/network/tls/TLSRecord;[BI)V", com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b.f30736c, "(Lio/ktor/network/tls/TLSRecord;)Lio/ktor/network/tls/TLSRecord;", "decrypt", "Lio/ktor/network/tls/CipherSuite;", "[B", "Ljavax/crypto/Cipher;", "sendCipher", "Ljavax/crypto/Cipher;", "Ljavax/crypto/spec/SecretKeySpec;", "sendKey", "Ljavax/crypto/spec/SecretKeySpec;", "Ljavax/crypto/Mac;", "sendMac", "Ljavax/crypto/Mac;", "receiveCipher", "receiveKey", "receiveMac", "", "inputCounter", "J", "outputCounter", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CBCCipher implements TLSCipher {
    private long inputCounter;
    private final byte[] keyMaterial;
    private long outputCounter;
    private final Cipher receiveCipher;
    private final SecretKeySpec receiveKey;
    private final Mac receiveMac;
    private final Cipher sendCipher;
    private final SecretKeySpec sendKey;
    private final Mac sendMac;
    private final CipherSuite suite;

    public CBCCipher(CipherSuite suite, byte[] keyMaterial) throws NoSuchPaddingException, NoSuchAlgorithmException {
        p.i(suite, "suite");
        p.i(keyMaterial, "keyMaterial");
        this.suite = suite;
        this.keyMaterial = keyMaterial;
        Cipher cipher = Cipher.getInstance(suite.getJdkCipherName());
        p.f(cipher);
        this.sendCipher = cipher;
        this.sendKey = KeysKt.clientKey(keyMaterial, suite);
        Mac mac = Mac.getInstance(suite.getMacName());
        p.f(mac);
        this.sendMac = mac;
        Cipher cipher2 = Cipher.getInstance(suite.getJdkCipherName());
        p.f(cipher2);
        this.receiveCipher = cipher2;
        this.receiveKey = KeysKt.serverKey(keyMaterial, suite);
        Mac mac2 = Mac.getInstance(suite.getMacName());
        p.f(mac2);
        this.receiveMac = mac2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t encrypt$lambda$1(CBCCipher cBCCipher, s cipherLoop) {
        p.i(cipherLoop, "$this$cipherLoop");
        byte[] iv = cBCCipher.sendCipher.getIV();
        p.h(iv, "getIV(...)");
        BytePacketBuilderKt.writeFully$default(cipherLoop, iv, 0, 0, 6, null);
        return t.f7040a;
    }

    private final byte[] prepareMac(TLSRecord record, byte[] content) throws IllegalStateException, InvalidKeyException {
        this.sendMac.reset();
        this.sendMac.init(KeysKt.clientMacKey(this.keyMaterial, this.suite));
        byte[] bArr = new byte[13];
        CipherKt.set(bArr, 0, this.outputCounter);
        bArr[8] = (byte) record.getType().getCode();
        bArr[9] = 3;
        bArr[10] = 3;
        CipherKt.set(bArr, 11, (short) content.length);
        this.outputCounter++;
        this.sendMac.update(bArr);
        byte[] bArrDoFinal = this.sendMac.doFinal(content);
        p.h(bArrDoFinal, "doFinal(...)");
        return bArrDoFinal;
    }

    private final void validateMac(TLSRecord record, byte[] content, int macOffset) throws IllegalStateException, TLSException, InvalidKeyException {
        this.receiveMac.reset();
        this.receiveMac.init(KeysKt.serverMacKey(this.keyMaterial, this.suite));
        byte[] bArr = new byte[13];
        CipherKt.set(bArr, 0, this.inputCounter);
        bArr[8] = (byte) record.getType().getCode();
        bArr[9] = 3;
        bArr[10] = 3;
        CipherKt.set(bArr, 11, (short) macOffset);
        this.inputCounter++;
        this.receiveMac.update(bArr);
        this.receiveMac.update(content, 0, macOffset);
        byte[] bArrDoFinal = this.receiveMac.doFinal();
        p.f(bArrDoFinal);
        if (!MessageDigest.isEqual(bArrDoFinal, r.G0(content, C5685n.s(macOffset, this.suite.getMacStrengthInBytes() + macOffset)))) {
            throw new TLSException("Failed to verify MAC content", null, 2, null);
        }
    }

    private final void validatePadding(byte[] content, int paddingStart) throws TLSException {
        int i10 = content[content.length - 1] & 255;
        int length = content.length;
        while (paddingStart < length) {
            int i11 = content[paddingStart] & 255;
            if (i10 != i11) {
                throw new TLSException("Padding invalid: expected " + i10 + ", actual " + i11, null, 2, null);
            }
            paddingStart++;
        }
    }

    private final void writePadding(s sVar) {
        byte blockSize = (byte) (this.sendCipher.getBlockSize() - ((BytePacketBuilderKt.getSize(sVar) + 1) % this.sendCipher.getBlockSize()));
        int i10 = blockSize + 1;
        for (int i11 = 0; i11 < i10; i11++) {
            sVar.H0(blockSize);
        }
    }

    @Override // io.ktor.network.tls.cipher.TLSCipher
    public TLSRecord decrypt(TLSRecord record) throws IllegalStateException, TLSException, InvalidKeyException, InvalidAlgorithmParameterException {
        p.i(record, "record");
        v packet = record.getPacket();
        this.receiveCipher.init(2, this.receiveKey, new IvParameterSpec(x.d(packet, this.suite.getFixedIvLength())));
        byte[] bArrC = x.c(CipherUtilsKt.cipherLoop$default(packet, this.receiveCipher, null, 2, null));
        int length = (bArrC.length - (bArrC[bArrC.length - 1] & 255)) - 1;
        int macStrengthInBytes = length - this.suite.getMacStrengthInBytes();
        validatePadding(bArrC, length);
        validateMac(record, bArrC, macStrengthInBytes);
        C4074a c4074a = new C4074a();
        BytePacketBuilderKt.writeFully(c4074a, bArrC, 0, macStrengthInBytes);
        return new TLSRecord(record.getType(), record.getVersion(), c4074a);
    }

    @Override // io.ktor.network.tls.cipher.TLSCipher
    public TLSRecord encrypt(TLSRecord record) throws IllegalStateException, InvalidKeyException, InvalidAlgorithmParameterException {
        p.i(record, "record");
        this.sendCipher.init(1, this.sendKey, new IvParameterSpec(CryptoKt.generateNonce(this.suite.getFixedIvLength())));
        byte[] bArrC = x.c(record.getPacket());
        byte[] bArrPrepareMac = prepareMac(record, bArrC);
        C4074a c4074a = new C4074a();
        BytePacketBuilderKt.writeFully$default(c4074a, bArrC, 0, 0, 6, null);
        BytePacketBuilderKt.writeFully$default(c4074a, bArrPrepareMac, 0, 0, 6, null);
        writePadding(c4074a);
        return new TLSRecord(record.getType(), null, CipherUtilsKt.cipherLoop(c4074a, this.sendCipher, new InterfaceC5074l() { // from class: io.ktor.network.tls.cipher.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CBCCipher.encrypt$lambda$1(this.f33320a, (s) obj);
            }
        }), 2, null);
    }
}
