package io.ktor.network.tls;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import fb.C4074a;
import fb.s;
import fb.v;
import g9.InterfaceC4112d;
import io.ktor.network.tls.extensions.HashAndSign;
import io.ktor.network.tls.extensions.NamedCurve;
import io.ktor.network.tls.extensions.NamedCurvesKt;
import io.ktor.network.tls.extensions.PointFormat;
import io.ktor.network.tls.extensions.PointFormatKt;
import io.ktor.network.tls.extensions.SignatureAlgorithmKt;
import io.ktor.network.tls.extensions.TLSExtensionType;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0080@¢\u0006\u0004\b\u0004\u0010\u0005\u001a#\u0010\u000b\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001aE\u0010\u0017\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a!\u0010\u001c\u001a\u00020\u0003*\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a+\u0010\"\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020!H\u0000¢\u0006\u0004\b\"\u0010#\u001a\u001f\u0010(\u001a\u00020'2\u0006\u0010$\u001a\u00020\u00122\u0006\u0010&\u001a\u00020%H\u0000¢\u0006\u0004\b(\u0010)\u001a)\u0010+\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010&\u001a\u00020%2\b\b\u0002\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b+\u0010,\u001a\u001b\u0010.\u001a\u00020\u0003*\u00020\u00062\u0006\u0010-\u001a\u00020\u001fH\u0000¢\u0006\u0004\b.\u0010/\u001a#\u00103\u001a\u00020\u0003*\u00020\u00062\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\tH\u0000¢\u0006\u0004\b3\u00104\u001a\u001f\u00107\u001a\u00020'2\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u0002050\u000fH\u0002¢\u0006\u0004\b7\u00108\u001a\u0017\u0010:\u001a\u00020'2\u0006\u00109\u001a\u00020\u0015H\u0002¢\u0006\u0004\b:\u0010;\u001a\u001f\u0010>\u001a\u00020'2\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020<0\u000fH\u0002¢\u0006\u0004\b>\u00108\u001a\u001f\u0010A\u001a\u00020'2\u000e\b\u0002\u0010@\u001a\b\u0012\u0004\u0012\u00020?0\u000fH\u0002¢\u0006\u0004\bA\u00108\u001a#\u0010C\u001a\u00020\u0003*\u00020\u00062\u0006\u0010B\u001a\u00020\u00122\u0006\u00102\u001a\u00020\tH\u0002¢\u0006\u0004\bC\u0010D\u001a\u001b\u0010F\u001a\u00020\u0003*\u00020\u00062\u0006\u0010E\u001a\u00020\tH\u0002¢\u0006\u0004\bF\u0010G\"\u0014\u0010H\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\bH\u0010I\"\u0014\u0010J\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\bJ\u0010I¨\u0006K"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "Lio/ktor/network/tls/TLSRecord;", "record", "LY8/t;", "writeRecord", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/network/tls/TLSRecord;Le9/c;)Ljava/lang/Object;", "Lfb/s;", "Lio/ktor/network/tls/TLSHandshakeType;", "type", "", "length", "writeTLSHandshakeType", "(Lfb/s;Lio/ktor/network/tls/TLSHandshakeType;I)V", "Lio/ktor/network/tls/TLSVersion;", "version", "", "Lio/ktor/network/tls/CipherSuite;", "suites", "", "random", "sessionId", "", "serverName", "writeTLSClientHello", "(Lfb/s;Lio/ktor/network/tls/TLSVersion;Ljava/util/List;[B[BLjava/lang/String;)V", "", "Ljava/security/cert/X509Certificate;", "certificates", "writeTLSCertificates", "(Lfb/s;[Ljava/security/cert/X509Certificate;)V", "preSecret", "Ljava/security/PublicKey;", "publicKey", "Ljava/security/SecureRandom;", "writeEncryptedPreMasterSecret", "(Lfb/s;[BLjava/security/PublicKey;Ljava/security/SecureRandom;)V", "digest", "Ljavax/crypto/SecretKey;", "secretKey", "Lfb/v;", "finished", "([BLjavax/crypto/SecretKey;)Lfb/v;", "handshakeHash", "serverFinished", "([BLjavax/crypto/SecretKey;I)[B", "key", "writePublicKeyUncompressed", "(Lfb/s;Ljava/security/PublicKey;)V", "Ljava/security/spec/ECPoint;", "point", "fieldSize", "writeECPoint", "(Lfb/s;Ljava/security/spec/ECPoint;I)V", "Lio/ktor/network/tls/extensions/HashAndSign;", "algorithms", "buildSignatureAlgorithmsExtension", "(Ljava/util/List;)Lfb/v;", "name", "buildServerNameExtension", "(Ljava/lang/String;)Lfb/v;", "Lio/ktor/network/tls/extensions/NamedCurve;", "curves", "buildECCurvesExtension", "Lio/ktor/network/tls/extensions/PointFormat;", "formats", "buildECPointFormatExtension", "src", "writeAligned", "(Lfb/s;[BI)V", UxipConstants.f30680s, "writeTripleByteLength", "(Lfb/s;I)V", "MAX_SERVER_NAME_LENGTH", "I", "MAX_CURVES_QUANTITY", "ktor-network-tls"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RenderKt {
    private static final int MAX_CURVES_QUANTITY = 16382;
    private static final int MAX_SERVER_NAME_LENGTH = 32762;

    @InterfaceC4112d(c = "io.ktor.network.tls.RenderKt", f = "Render.kt", l = {18, 19, 20, 21, 22, 23}, m = "writeRecord")
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: io.ktor.network.tls.RenderKt$writeRecord$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RenderKt.writeRecord(null, null, this);
        }
    }

    private static final v buildECCurvesExtension(List<? extends NamedCurve> list) {
        C4074a c4074a = new C4074a();
        if (list.size() > MAX_CURVES_QUANTITY) {
            throw new IllegalArgumentException("Too many named curves provided: at most 16382 could be provided");
        }
        c4074a.writeShort(TLSExtensionType.ELLIPTIC_CURVES.getCode());
        int size = list.size() * 2;
        c4074a.writeShort((short) (size + 2));
        c4074a.writeShort((short) size);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            c4074a.writeShort(((NamedCurve) it.next()).getCode());
        }
        return c4074a;
    }

    public static /* synthetic */ v buildECCurvesExtension$default(List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = NamedCurvesKt.getSupportedNamedCurves();
        }
        return buildECCurvesExtension(list);
    }

    private static final v buildECPointFormatExtension(List<? extends PointFormat> list) {
        C4074a c4074a = new C4074a();
        c4074a.writeShort(TLSExtensionType.EC_POINT_FORMAT.getCode());
        int size = list.size();
        c4074a.writeShort((short) (size + 1));
        c4074a.H0((byte) size);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            c4074a.H0(((PointFormat) it.next()).getCode());
        }
        return c4074a;
    }

    public static /* synthetic */ v buildECPointFormatExtension$default(List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = PointFormatKt.getSupportedPointFormats();
        }
        return buildECPointFormatExtension(list);
    }

    private static final v buildServerNameExtension(String str) {
        C4074a c4074a = new C4074a();
        if (str.length() >= MAX_SERVER_NAME_LENGTH) {
            throw new IllegalArgumentException("Server name length limit exceeded: at most 32762 characters allowed");
        }
        c4074a.writeShort(TLSExtensionType.SERVER_NAME.getCode());
        c4074a.writeShort((short) (str.length() + 5));
        c4074a.writeShort((short) (str.length() + 3));
        c4074a.H0((byte) 0);
        c4074a.writeShort((short) str.length());
        StringsKt.writeText$default(c4074a, str, 0, 0, (Charset) null, 14, (Object) null);
        return c4074a;
    }

    private static final v buildSignatureAlgorithmsExtension(List<HashAndSign> list) {
        C4074a c4074a = new C4074a();
        c4074a.writeShort(TLSExtensionType.SIGNATURE_ALGORITHMS.getCode());
        int size = list.size() * 2;
        c4074a.writeShort((short) (size + 2));
        c4074a.writeShort((short) size);
        for (HashAndSign hashAndSign : list) {
            c4074a.H0(hashAndSign.getHash().getCode());
            c4074a.H0(hashAndSign.getSign().getCode());
        }
        return c4074a;
    }

    public static /* synthetic */ v buildSignatureAlgorithmsExtension$default(List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = SignatureAlgorithmKt.getSupportedSignatureAlgorithms();
        }
        return buildSignatureAlgorithmsExtension(list);
    }

    public static final v finished(byte[] digest, SecretKey secretKey) {
        p.i(digest, "digest");
        p.i(secretKey, "secretKey");
        C4074a c4074a = new C4074a();
        BytePacketBuilderKt.writeFully$default(c4074a, HashesKt.PRF(secretKey, KeysKt.getCLIENT_FINISHED_LABEL(), digest, 12), 0, 0, 6, null);
        return c4074a;
    }

    public static final byte[] serverFinished(byte[] handshakeHash, SecretKey secretKey, int i10) {
        p.i(handshakeHash, "handshakeHash");
        p.i(secretKey, "secretKey");
        return HashesKt.PRF(secretKey, KeysKt.getSERVER_FINISHED_LABEL(), handshakeHash, i10);
    }

    public static /* synthetic */ byte[] serverFinished$default(byte[] bArr, SecretKey secretKey, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 12;
        }
        return serverFinished(bArr, secretKey, i10);
    }

    private static final void writeAligned(s sVar, byte[] bArr, int i10) {
        s sVar2;
        int i11 = (i10 + 7) >>> 3;
        int length = bArr.length;
        int i12 = 0;
        while (true) {
            if (i12 >= length) {
                i12 = -1;
                break;
            } else if (bArr[i12] != 0) {
                break;
            } else {
                i12++;
            }
        }
        int length2 = i11 - (bArr.length - i12);
        if (length2 > 0) {
            sVar2 = sVar;
            BytePacketBuilderKt.writeFully$default(sVar2, new byte[length2], 0, 0, 6, null);
        } else {
            sVar2 = sVar;
        }
        BytePacketBuilderKt.writeFully(sVar2, bArr, i12, bArr.length - i12);
    }

    public static final void writeECPoint(s sVar, ECPoint point, int i10) {
        p.i(sVar, "<this>");
        p.i(point, "point");
        C4074a c4074a = new C4074a();
        c4074a.H0((byte) 4);
        byte[] byteArray = point.getAffineX().toByteArray();
        p.h(byteArray, "toByteArray(...)");
        writeAligned(c4074a, byteArray, i10);
        byte[] byteArray2 = point.getAffineY().toByteArray();
        p.h(byteArray2, "toByteArray(...)");
        writeAligned(c4074a, byteArray2, i10);
        sVar.H0((byte) ByteReadPacketKt.getRemaining(c4074a));
        BytePacketBuilderKt.writePacket(sVar, c4074a);
    }

    public static final void writeEncryptedPreMasterSecret(s sVar, byte[] preSecret, PublicKey publicKey, SecureRandom random) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, TLSException, InvalidKeyException {
        p.i(sVar, "<this>");
        p.i(preSecret, "preSecret");
        p.i(publicKey, "publicKey");
        p.i(random, "random");
        if (preSecret.length != 48) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        p.f(cipher);
        cipher.init(1, publicKey, random);
        byte[] bArrDoFinal = cipher.doFinal(preSecret);
        if (bArrDoFinal.length > 65535) {
            throw new TLSException("Encrypted premaster secret is too long", null, 2, null);
        }
        sVar.writeShort((short) bArrDoFinal.length);
        p.f(bArrDoFinal);
        BytePacketBuilderKt.writeFully$default(sVar, bArrDoFinal, 0, 0, 6, null);
    }

    public static final void writePublicKeyUncompressed(s sVar, PublicKey key) throws TLSException {
        p.i(sVar, "<this>");
        p.i(key, "key");
        if (!(key instanceof ECPublicKey)) {
            throw new TLSException("Unsupported public key type: " + key, null, 2, null);
        }
        ECPublicKey eCPublicKey = (ECPublicKey) key;
        int fieldSize = eCPublicKey.getParams().getCurve().getField().getFieldSize();
        ECPoint w10 = eCPublicKey.getW();
        p.h(w10, "getW(...)");
        writeECPoint(sVar, w10, fieldSize);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x015e, code lost:
    
        if (r3.flush(r0) != r1) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0105 A[PHI: r2 r3 r6 r7
      0x0105: PHI (r2v11 io.ktor.network.tls.TLSRecord) = (r2v8 io.ktor.network.tls.TLSRecord), (r2v13 io.ktor.network.tls.TLSRecord) binds: [B:27:0x0102, B:15:0x0062] A[DONT_GENERATE, DONT_INLINE]
      0x0105: PHI (r3v12 io.ktor.utils.io.ByteWriteChannel) = (r3v9 io.ktor.utils.io.ByteWriteChannel), (r3v14 io.ktor.utils.io.ByteWriteChannel) binds: [B:27:0x0102, B:15:0x0062] A[DONT_GENERATE, DONT_INLINE]
      0x0105: PHI (r6v7 int) = (r6v5 int), (r6v8 int) binds: [B:27:0x0102, B:15:0x0062] A[DONT_GENERATE, DONT_INLINE]
      0x0105: PHI (r7v7 io.ktor.network.tls.TLSRecord) = (r7v4 io.ktor.network.tls.TLSRecord), (r7v9 io.ktor.network.tls.TLSRecord) binds: [B:27:0x0102, B:15:0x0062] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0125 A[PHI: r2 r3 r6 r7
      0x0125: PHI (r2v14 io.ktor.network.tls.TLSRecord) = (r2v11 io.ktor.network.tls.TLSRecord), (r2v16 io.ktor.network.tls.TLSRecord) binds: [B:30:0x0122, B:14:0x004f] A[DONT_GENERATE, DONT_INLINE]
      0x0125: PHI (r3v15 io.ktor.utils.io.ByteWriteChannel) = (r3v12 io.ktor.utils.io.ByteWriteChannel), (r3v17 io.ktor.utils.io.ByteWriteChannel) binds: [B:30:0x0122, B:14:0x004f] A[DONT_GENERATE, DONT_INLINE]
      0x0125: PHI (r6v9 int) = (r6v7 int), (r6v10 int) binds: [B:30:0x0122, B:14:0x004f] A[DONT_GENERATE, DONT_INLINE]
      0x0125: PHI (r7v10 io.ktor.network.tls.TLSRecord) = (r7v7 io.ktor.network.tls.TLSRecord), (r7v12 io.ktor.network.tls.TLSRecord) binds: [B:30:0x0122, B:14:0x004f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0143 A[PHI: r2 r3 r6 r7
      0x0143: PHI (r2v17 io.ktor.network.tls.TLSRecord) = (r2v14 io.ktor.network.tls.TLSRecord), (r2v19 io.ktor.network.tls.TLSRecord) binds: [B:33:0x0140, B:13:0x003c] A[DONT_GENERATE, DONT_INLINE]
      0x0143: PHI (r3v18 io.ktor.utils.io.ByteWriteChannel) = (r3v15 io.ktor.utils.io.ByteWriteChannel), (r3v20 io.ktor.utils.io.ByteWriteChannel) binds: [B:33:0x0140, B:13:0x003c] A[DONT_GENERATE, DONT_INLINE]
      0x0143: PHI (r6v11 int) = (r6v9 int), (r6v14 int) binds: [B:33:0x0140, B:13:0x003c] A[DONT_GENERATE, DONT_INLINE]
      0x0143: PHI (r7v13 io.ktor.network.tls.TLSRecord) = (r7v10 io.ktor.network.tls.TLSRecord), (r7v16 io.ktor.network.tls.TLSRecord) binds: [B:33:0x0140, B:13:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object writeRecord(io.ktor.utils.io.ByteWriteChannel r6, io.ktor.network.tls.TLSRecord r7, e9.InterfaceC4014c<? super Y8.t> r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.tls.RenderKt.writeRecord(io.ktor.utils.io.ByteWriteChannel, io.ktor.network.tls.TLSRecord, e9.c):java.lang.Object");
    }

    public static final void writeTLSCertificates(s sVar, X509Certificate[] certificates) throws CertificateEncodingException {
        p.i(sVar, "<this>");
        p.i(certificates, "certificates");
        C4074a c4074a = new C4074a();
        for (X509Certificate x509Certificate : certificates) {
            byte[] encoded = x509Certificate.getEncoded();
            p.f(encoded);
            writeTripleByteLength(c4074a, encoded.length);
            BytePacketBuilderKt.writeFully$default(c4074a, encoded, 0, 0, 6, null);
        }
        writeTripleByteLength(sVar, (int) ByteReadPacketKt.getRemaining(c4074a));
        BytePacketBuilderKt.writePacket(sVar, c4074a);
    }

    public static final void writeTLSClientHello(s sVar, TLSVersion version, List<CipherSuite> suites, byte[] random, byte[] sessionId, String str) throws TLSException {
        p.i(sVar, "<this>");
        p.i(version, "version");
        p.i(suites, "suites");
        p.i(random, "random");
        p.i(sessionId, "sessionId");
        sVar.writeShort((short) version.getCode());
        BytePacketBuilderKt.writeFully$default(sVar, random, 0, 0, 6, null);
        int length = sessionId.length;
        if (length < 0 || length > 255 || length > sessionId.length) {
            throw new TLSException("Illegal sessionIdLength", null, 2, null);
        }
        sVar.H0((byte) length);
        int remaining = 0;
        BytePacketBuilderKt.writeFully(sVar, sessionId, 0, length);
        sVar.writeShort((short) (suites.size() * 2));
        Iterator<CipherSuite> it = suites.iterator();
        while (it.hasNext()) {
            sVar.writeShort(it.next().getCode());
        }
        sVar.H0((byte) 1);
        sVar.H0((byte) 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(buildSignatureAlgorithmsExtension$default(null, 1, null));
        arrayList.add(buildECCurvesExtension$default(null, 1, null));
        arrayList.add(buildECPointFormatExtension$default(null, 1, null));
        if (str != null) {
            arrayList.add(buildServerNameExtension(str));
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            remaining += (int) ByteReadPacketKt.getRemaining((v) it2.next());
        }
        sVar.writeShort((short) remaining);
        Iterator it3 = arrayList.iterator();
        p.h(it3, "iterator(...)");
        while (it3.hasNext()) {
            Object next = it3.next();
            p.h(next, "next(...)");
            BytePacketBuilderKt.writePacket(sVar, (v) next);
        }
    }

    public static /* synthetic */ void writeTLSClientHello$default(s sVar, TLSVersion tLSVersion, List list, byte[] bArr, byte[] bArr2, String str, int i10, Object obj) throws TLSException {
        if ((i10 & 16) != 0) {
            str = null;
        }
        writeTLSClientHello(sVar, tLSVersion, list, bArr, bArr2, str);
    }

    public static final void writeTLSHandshakeType(s sVar, TLSHandshakeType type, int i10) throws TLSException {
        p.i(sVar, "<this>");
        p.i(type, "type");
        if (i10 <= 16777215) {
            sVar.writeInt((type.getCode() << 24) | i10);
            return;
        }
        throw new TLSException("TLS handshake size limit exceeded: " + i10, null, 2, null);
    }

    private static final void writeTripleByteLength(s sVar, int i10) {
        sVar.H0((byte) ((i10 >>> 16) & 255));
        sVar.writeShort((short) (i10 & 65535));
    }
}
