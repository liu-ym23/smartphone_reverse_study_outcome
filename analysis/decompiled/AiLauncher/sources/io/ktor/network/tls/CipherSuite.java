package io.ktor.network.tls;

import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.ktor.network.tls.extensions.HashAlgorithm;
import io.ktor.network.tls.extensions.SignatureAlgorithm;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b \u0010\u001cJ\u0010\u0010!\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b#\u0010\"J\u0010\u0010$\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b$\u0010\"J\u0010\u0010%\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b%\u0010\"J\u0010\u0010&\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b&\u0010\u001cJ\u0010\u0010'\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b'\u0010\"J\u0010\u0010(\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b,\u0010-J\u009c\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015HÆ\u0001¢\u0006\u0004\b.\u0010/J\u001a\u00102\u001a\u0002012\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b4\u0010\"J\u0010\u00105\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b5\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00106\u001a\u0004\b7\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00108\u001a\u0004\b9\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u00108\u001a\u0004\b:\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010;\u001a\u0004\b<\u0010\u001fR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u00108\u001a\u0004\b=\u0010\u001cR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010>\u001a\u0004\b?\u0010\"R\u0017\u0010\f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\f\u0010>\u001a\u0004\b@\u0010\"R\u0017\u0010\r\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\r\u0010>\u001a\u0004\bA\u0010\"R\u0017\u0010\u000e\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000e\u0010>\u001a\u0004\bB\u0010\"R\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u00108\u001a\u0004\bC\u0010\u001cR\u0017\u0010\u0010\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0010\u0010>\u001a\u0004\bD\u0010\"R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010E\u001a\u0004\bF\u0010)R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010G\u001a\u0004\bH\u0010+R\u0017\u0010\u0016\u001a\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010I\u001a\u0004\bJ\u0010-R\u0017\u0010K\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\bK\u0010>\u001a\u0004\bL\u0010\"R\u0017\u0010M\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\bM\u0010>\u001a\u0004\bN\u0010\"¨\u0006O"}, d2 = {"Lio/ktor/network/tls/CipherSuite;", "", "", "code", "", "name", "openSSLName", "Lio/ktor/network/tls/SecretExchangeType;", "exchangeType", "jdkCipherName", "", "keyStrength", "fixedIvLength", "ivLength", "cipherTagSizeInBytes", "macName", "macStrength", "Lio/ktor/network/tls/extensions/HashAlgorithm;", "hash", "Lio/ktor/network/tls/extensions/SignatureAlgorithm;", "signatureAlgorithm", "Lio/ktor/network/tls/CipherType;", "cipherType", "<init>", "(SLjava/lang/String;Ljava/lang/String;Lio/ktor/network/tls/SecretExchangeType;Ljava/lang/String;IIIILjava/lang/String;ILio/ktor/network/tls/extensions/HashAlgorithm;Lio/ktor/network/tls/extensions/SignatureAlgorithm;Lio/ktor/network/tls/CipherType;)V", "component1", "()S", "component2", "()Ljava/lang/String;", "component3", "component4", "()Lio/ktor/network/tls/SecretExchangeType;", "component5", "component6", "()I", "component7", "component8", "component9", "component10", "component11", "component12", "()Lio/ktor/network/tls/extensions/HashAlgorithm;", "component13", "()Lio/ktor/network/tls/extensions/SignatureAlgorithm;", "component14", "()Lio/ktor/network/tls/CipherType;", ChatTracker.CLICK_COPY, "(SLjava/lang/String;Ljava/lang/String;Lio/ktor/network/tls/SecretExchangeType;Ljava/lang/String;IIIILjava/lang/String;ILio/ktor/network/tls/extensions/HashAlgorithm;Lio/ktor/network/tls/extensions/SignatureAlgorithm;Lio/ktor/network/tls/CipherType;)Lio/ktor/network/tls/CipherSuite;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", ExifInterface.LATITUDE_SOUTH, "getCode", "Ljava/lang/String;", "getName", "getOpenSSLName", "Lio/ktor/network/tls/SecretExchangeType;", "getExchangeType", "getJdkCipherName", "I", "getKeyStrength", "getFixedIvLength", "getIvLength", "getCipherTagSizeInBytes", "getMacName", "getMacStrength", "Lio/ktor/network/tls/extensions/HashAlgorithm;", "getHash", "Lio/ktor/network/tls/extensions/SignatureAlgorithm;", "getSignatureAlgorithm", "Lio/ktor/network/tls/CipherType;", "getCipherType", "keyStrengthInBytes", "getKeyStrengthInBytes", "macStrengthInBytes", "getMacStrengthInBytes", "ktor-network-tls"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CipherSuite {
    private final int cipherTagSizeInBytes;
    private final CipherType cipherType;
    private final short code;
    private final SecretExchangeType exchangeType;
    private final int fixedIvLength;
    private final HashAlgorithm hash;
    private final int ivLength;
    private final String jdkCipherName;
    private final int keyStrength;
    private final int keyStrengthInBytes;
    private final String macName;
    private final int macStrength;
    private final int macStrengthInBytes;
    private final String name;
    private final String openSSLName;
    private final SignatureAlgorithm signatureAlgorithm;

    public CipherSuite(short s10, String name, String openSSLName, SecretExchangeType exchangeType, String jdkCipherName, int i10, int i11, int i12, int i13, String macName, int i14, HashAlgorithm hash, SignatureAlgorithm signatureAlgorithm, CipherType cipherType) {
        p.i(name, "name");
        p.i(openSSLName, "openSSLName");
        p.i(exchangeType, "exchangeType");
        p.i(jdkCipherName, "jdkCipherName");
        p.i(macName, "macName");
        p.i(hash, "hash");
        p.i(signatureAlgorithm, "signatureAlgorithm");
        p.i(cipherType, "cipherType");
        this.code = s10;
        this.name = name;
        this.openSSLName = openSSLName;
        this.exchangeType = exchangeType;
        this.jdkCipherName = jdkCipherName;
        this.keyStrength = i10;
        this.fixedIvLength = i11;
        this.ivLength = i12;
        this.cipherTagSizeInBytes = i13;
        this.macName = macName;
        this.macStrength = i14;
        this.hash = hash;
        this.signatureAlgorithm = signatureAlgorithm;
        this.cipherType = cipherType;
        this.keyStrengthInBytes = i10 / 8;
        this.macStrengthInBytes = i14 / 8;
    }

    /* renamed from: component1, reason: from getter */
    public final short getCode() {
        return this.code;
    }

    /* renamed from: component10, reason: from getter */
    public final String getMacName() {
        return this.macName;
    }

    /* renamed from: component11, reason: from getter */
    public final int getMacStrength() {
        return this.macStrength;
    }

    /* renamed from: component12, reason: from getter */
    public final HashAlgorithm getHash() {
        return this.hash;
    }

    /* renamed from: component13, reason: from getter */
    public final SignatureAlgorithm getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    /* renamed from: component14, reason: from getter */
    public final CipherType getCipherType() {
        return this.cipherType;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getOpenSSLName() {
        return this.openSSLName;
    }

    /* renamed from: component4, reason: from getter */
    public final SecretExchangeType getExchangeType() {
        return this.exchangeType;
    }

    /* renamed from: component5, reason: from getter */
    public final String getJdkCipherName() {
        return this.jdkCipherName;
    }

    /* renamed from: component6, reason: from getter */
    public final int getKeyStrength() {
        return this.keyStrength;
    }

    /* renamed from: component7, reason: from getter */
    public final int getFixedIvLength() {
        return this.fixedIvLength;
    }

    /* renamed from: component8, reason: from getter */
    public final int getIvLength() {
        return this.ivLength;
    }

    /* renamed from: component9, reason: from getter */
    public final int getCipherTagSizeInBytes() {
        return this.cipherTagSizeInBytes;
    }

    public final CipherSuite copy(short code, String name, String openSSLName, SecretExchangeType exchangeType, String jdkCipherName, int keyStrength, int fixedIvLength, int ivLength, int cipherTagSizeInBytes, String macName, int macStrength, HashAlgorithm hash, SignatureAlgorithm signatureAlgorithm, CipherType cipherType) {
        p.i(name, "name");
        p.i(openSSLName, "openSSLName");
        p.i(exchangeType, "exchangeType");
        p.i(jdkCipherName, "jdkCipherName");
        p.i(macName, "macName");
        p.i(hash, "hash");
        p.i(signatureAlgorithm, "signatureAlgorithm");
        p.i(cipherType, "cipherType");
        return new CipherSuite(code, name, openSSLName, exchangeType, jdkCipherName, keyStrength, fixedIvLength, ivLength, cipherTagSizeInBytes, macName, macStrength, hash, signatureAlgorithm, cipherType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CipherSuite)) {
            return false;
        }
        CipherSuite cipherSuite = (CipherSuite) other;
        return this.code == cipherSuite.code && p.d(this.name, cipherSuite.name) && p.d(this.openSSLName, cipherSuite.openSSLName) && this.exchangeType == cipherSuite.exchangeType && p.d(this.jdkCipherName, cipherSuite.jdkCipherName) && this.keyStrength == cipherSuite.keyStrength && this.fixedIvLength == cipherSuite.fixedIvLength && this.ivLength == cipherSuite.ivLength && this.cipherTagSizeInBytes == cipherSuite.cipherTagSizeInBytes && p.d(this.macName, cipherSuite.macName) && this.macStrength == cipherSuite.macStrength && this.hash == cipherSuite.hash && this.signatureAlgorithm == cipherSuite.signatureAlgorithm && this.cipherType == cipherSuite.cipherType;
    }

    public final int getCipherTagSizeInBytes() {
        return this.cipherTagSizeInBytes;
    }

    public final CipherType getCipherType() {
        return this.cipherType;
    }

    public final short getCode() {
        return this.code;
    }

    public final SecretExchangeType getExchangeType() {
        return this.exchangeType;
    }

    public final int getFixedIvLength() {
        return this.fixedIvLength;
    }

    public final HashAlgorithm getHash() {
        return this.hash;
    }

    public final int getIvLength() {
        return this.ivLength;
    }

    public final String getJdkCipherName() {
        return this.jdkCipherName;
    }

    public final int getKeyStrength() {
        return this.keyStrength;
    }

    public final int getKeyStrengthInBytes() {
        return this.keyStrengthInBytes;
    }

    public final String getMacName() {
        return this.macName;
    }

    public final int getMacStrength() {
        return this.macStrength;
    }

    public final int getMacStrengthInBytes() {
        return this.macStrengthInBytes;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOpenSSLName() {
        return this.openSSLName;
    }

    public final SignatureAlgorithm getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((Short.hashCode(this.code) * 31) + this.name.hashCode()) * 31) + this.openSSLName.hashCode()) * 31) + this.exchangeType.hashCode()) * 31) + this.jdkCipherName.hashCode()) * 31) + Integer.hashCode(this.keyStrength)) * 31) + Integer.hashCode(this.fixedIvLength)) * 31) + Integer.hashCode(this.ivLength)) * 31) + Integer.hashCode(this.cipherTagSizeInBytes)) * 31) + this.macName.hashCode()) * 31) + Integer.hashCode(this.macStrength)) * 31) + this.hash.hashCode()) * 31) + this.signatureAlgorithm.hashCode()) * 31) + this.cipherType.hashCode();
    }

    public String toString() {
        return "CipherSuite(code=" + ((int) this.code) + ", name=" + this.name + ", openSSLName=" + this.openSSLName + ", exchangeType=" + this.exchangeType + ", jdkCipherName=" + this.jdkCipherName + ", keyStrength=" + this.keyStrength + ", fixedIvLength=" + this.fixedIvLength + ", ivLength=" + this.ivLength + ", cipherTagSizeInBytes=" + this.cipherTagSizeInBytes + ", macName=" + this.macName + ", macStrength=" + this.macStrength + ", hash=" + this.hash + ", signatureAlgorithm=" + this.signatureAlgorithm + ", cipherType=" + this.cipherType + ')';
    }

    public /* synthetic */ CipherSuite(short s10, String str, String str2, SecretExchangeType secretExchangeType, String str3, int i10, int i11, int i12, int i13, String str4, int i14, HashAlgorithm hashAlgorithm, SignatureAlgorithm signatureAlgorithm, CipherType cipherType, int i15, kotlin.jvm.internal.i iVar) {
        this(s10, str, str2, secretExchangeType, str3, i10, i11, i12, i13, str4, i14, hashAlgorithm, signatureAlgorithm, (i15 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? CipherType.GCM : cipherType);
    }
}
