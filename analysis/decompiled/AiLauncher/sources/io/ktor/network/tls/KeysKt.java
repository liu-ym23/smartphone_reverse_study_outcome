package io.ktor.network.tls;

import La.C0953c;
import La.H;
import Z8.C1168p;
import java.nio.charset.Charset;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u001b\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\b\u0010\u0005\u001a\u001b\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u000b\u0010\n\u001a7\u0010\u0013\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a'\u0010\r\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\r\u0010\u0018\"\u0014\u0010\u0019\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a\"\u0014\u0010\u001b\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001a\"\u001a\u0010\u001c\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\u001e\"\u001a\u0010\u001f\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001e¨\u0006!"}, d2 = {"", "Lio/ktor/network/tls/CipherSuite;", "suite", "Ljavax/crypto/spec/SecretKeySpec;", "clientMacKey", "([BLio/ktor/network/tls/CipherSuite;)Ljavax/crypto/spec/SecretKeySpec;", "serverMacKey", "serverKey", "clientKey", "clientIV", "([BLio/ktor/network/tls/CipherSuite;)[B", "serverIV", "Ljavax/crypto/SecretKey;", "masterSecret", "seed", "", "keySize", "macSize", "ivSize", "keyMaterial", "(Ljavax/crypto/SecretKey;[BIII)[B", "preMasterSecret", "clientRandom", "serverRandom", "(Ljavax/crypto/SecretKey;[B[B)Ljavax/crypto/spec/SecretKeySpec;", "MASTER_SECRET_LABEL", "[B", "KEY_EXPANSION_LABEL", "CLIENT_FINISHED_LABEL", "getCLIENT_FINISHED_LABEL", "()[B", "SERVER_FINISHED_LABEL", "getSERVER_FINISHED_LABEL", "ktor-network-tls"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KeysKt {
    private static final byte[] CLIENT_FINISHED_LABEL;
    private static final byte[] KEY_EXPANSION_LABEL;
    private static final byte[] MASTER_SECRET_LABEL;
    private static final byte[] SERVER_FINISHED_LABEL;

    static {
        Charset charset = C0953c.UTF_8;
        byte[] bytes = "master secret".getBytes(charset);
        p.h(bytes, "getBytes(...)");
        MASTER_SECRET_LABEL = bytes;
        byte[] bytes2 = "key expansion".getBytes(charset);
        p.h(bytes2, "getBytes(...)");
        KEY_EXPANSION_LABEL = bytes2;
        byte[] bytes3 = "client finished".getBytes(charset);
        p.h(bytes3, "getBytes(...)");
        CLIENT_FINISHED_LABEL = bytes3;
        byte[] bytes4 = "server finished".getBytes(charset);
        p.h(bytes4, "getBytes(...)");
        SERVER_FINISHED_LABEL = bytes4;
    }

    public static final byte[] clientIV(byte[] bArr, CipherSuite suite) {
        p.i(bArr, "<this>");
        p.i(suite, "suite");
        return C1168p.o(bArr, (suite.getMacStrengthInBytes() * 2) + (suite.getKeyStrengthInBytes() * 2), (suite.getMacStrengthInBytes() * 2) + (suite.getKeyStrengthInBytes() * 2) + suite.getFixedIvLength());
    }

    public static final SecretKeySpec clientKey(byte[] bArr, CipherSuite suite) {
        p.i(bArr, "<this>");
        p.i(suite, "suite");
        return new SecretKeySpec(bArr, suite.getMacStrengthInBytes() * 2, suite.getKeyStrengthInBytes(), H.x1(suite.getJdkCipherName(), "/", null, 2, null));
    }

    public static final SecretKeySpec clientMacKey(byte[] bArr, CipherSuite suite) {
        p.i(bArr, "<this>");
        p.i(suite, "suite");
        return new SecretKeySpec(bArr, 0, suite.getMacStrengthInBytes(), suite.getHash().getMacName());
    }

    public static final byte[] getCLIENT_FINISHED_LABEL() {
        return CLIENT_FINISHED_LABEL;
    }

    public static final byte[] getSERVER_FINISHED_LABEL() {
        return SERVER_FINISHED_LABEL;
    }

    public static final byte[] keyMaterial(SecretKey masterSecret, byte[] seed, int i10, int i11, int i12) {
        p.i(masterSecret, "masterSecret");
        p.i(seed, "seed");
        return HashesKt.PRF(masterSecret, KEY_EXPANSION_LABEL, seed, (i11 * 2) + (i10 * 2) + (i12 * 2));
    }

    public static final SecretKeySpec masterSecret(SecretKey preMasterSecret, byte[] clientRandom, byte[] serverRandom) {
        p.i(preMasterSecret, "preMasterSecret");
        p.i(clientRandom, "clientRandom");
        p.i(serverRandom, "serverRandom");
        return new SecretKeySpec(HashesKt.PRF(preMasterSecret, MASTER_SECRET_LABEL, C1168p.E(clientRandom, serverRandom), 48), preMasterSecret.getAlgorithm());
    }

    public static final byte[] serverIV(byte[] bArr, CipherSuite suite) {
        p.i(bArr, "<this>");
        p.i(suite, "suite");
        return C1168p.o(bArr, (suite.getMacStrengthInBytes() * 2) + (suite.getKeyStrengthInBytes() * 2) + suite.getFixedIvLength(), (suite.getMacStrengthInBytes() * 2) + (suite.getKeyStrengthInBytes() * 2) + (suite.getFixedIvLength() * 2));
    }

    public static final SecretKeySpec serverKey(byte[] bArr, CipherSuite suite) {
        p.i(bArr, "<this>");
        p.i(suite, "suite");
        return new SecretKeySpec(bArr, (suite.getMacStrengthInBytes() * 2) + suite.getKeyStrengthInBytes(), suite.getKeyStrengthInBytes(), H.x1(suite.getJdkCipherName(), "/", null, 2, null));
    }

    public static final SecretKeySpec serverMacKey(byte[] bArr, CipherSuite suite) {
        p.i(bArr, "<this>");
        p.i(suite, "suite");
        return new SecretKeySpec(bArr, suite.getMacStrengthInBytes(), suite.getMacStrengthInBytes(), suite.getHash().getMacName());
    }
}
