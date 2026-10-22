package com.google.crypto.tink.jwt;

import androidx.activity.b;
import b8.z;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.KeyStatus;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.internal.LegacyProtoKey;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.proto.JwtEcdsaAlgorithm;
import com.google.crypto.tink.proto.JwtEcdsaPublicKey;
import com.google.crypto.tink.proto.JwtRsaSsaPkcs1Algorithm;
import com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey;
import com.google.crypto.tink.proto.JwtRsaSsaPssAlgorithm;
import com.google.crypto.tink.proto.JwtRsaSsaPssPublicKey;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.subtle.Base64;
import com.google.crypto.tink.tinkkey.KeyAccess;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Optional;
import javax.annotation.Nullable;
import k0.a;
import m7.f;
import m7.g;
import m7.j;
import m7.l;
import o7.n;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class JwkSetConverter {
    private static final String JWT_ECDSA_PUBLIC_KEY_URL = "type.googleapis.com/google.crypto.tink.JwtEcdsaPublicKey";
    private static final String JWT_RSA_SSA_PKCS1_PUBLIC_KEY_URL = "type.googleapis.com/google.crypto.tink.JwtRsaSsaPkcs1PublicKey";
    private static final String JWT_RSA_SSA_PSS_PUBLIC_KEY_URL = "type.googleapis.com/google.crypto.tink.JwtRsaSsaPssPublicKey";

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    /* renamed from: com.google.crypto.tink.jwt.JwkSetConverter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm;

        static {
            int[] iArr = new int[JwtRsaSsaPssAlgorithm.values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm = iArr;
            try {
                iArr[JwtRsaSsaPssAlgorithm.PS256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm[JwtRsaSsaPssAlgorithm.PS384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm[JwtRsaSsaPssAlgorithm.PS512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[JwtRsaSsaPkcs1Algorithm.values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm = iArr2;
            try {
                iArr2[JwtRsaSsaPkcs1Algorithm.RS256.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm[JwtRsaSsaPkcs1Algorithm.RS384.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm[JwtRsaSsaPkcs1Algorithm.RS512.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[JwtEcdsaAlgorithm.values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm = iArr3;
            try {
                iArr3[JwtEcdsaAlgorithm.ES256.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[JwtEcdsaAlgorithm.ES384.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[JwtEcdsaAlgorithm.ES512.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    private JwkSetConverter() {
    }

    private static j convertJwtEcdsaKey(ProtoKeySerialization protoKeySerialization) throws GeneralSecurityException {
        String str;
        String str2;
        try {
            JwtEcdsaPublicKey from = JwtEcdsaPublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[from.getAlgorithm().ordinal()];
            if (i == 1) {
                str = "ES256";
                str2 = "P-256";
            } else if (i == 2) {
                str = "ES384";
                str2 = "P-384";
            } else {
                if (i != 3) {
                    z.l("unknown algorithm");
                    return null;
                }
                str = "ES512";
                str2 = "P-521";
            }
            j jVar = new j();
            jVar.l("kty", "EC");
            jVar.l("crv", str2);
            jVar.l("x", Base64.urlSafeEncode(from.getX().toByteArray()));
            jVar.l("y", Base64.urlSafeEncode(from.getY().toByteArray()));
            jVar.l("use", "sig");
            jVar.l("alg", str);
            f fVar = new f();
            fVar.j("verify");
            jVar.j("key_ops", fVar);
            Optional<String> kid = getKid(protoKeySerialization.getIdRequirementOrNull());
            if (kid.isPresent()) {
                jVar.l("kid", kid.get());
                return jVar;
            }
            if (from.hasCustomKid()) {
                jVar.l("kid", from.getCustomKid().getValue());
            }
            return jVar;
        } catch (InvalidProtocolBufferException e10) {
            z.s("failed to parse value as JwtEcdsaPublicKey proto", e10);
            return null;
        }
    }

    private static j convertJwtRsaSsaPkcs1(ProtoKeySerialization protoKeySerialization) throws GeneralSecurityException {
        String str;
        try {
            JwtRsaSsaPkcs1PublicKey from = JwtRsaSsaPkcs1PublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm[from.getAlgorithm().ordinal()];
            if (i == 1) {
                str = "RS256";
            } else if (i == 2) {
                str = "RS384";
            } else {
                if (i != 3) {
                    z.l("unknown algorithm");
                    return null;
                }
                str = "RS512";
            }
            j jVar = new j();
            jVar.l("kty", "RSA");
            jVar.l("n", Base64.urlSafeEncode(from.getN().toByteArray()));
            jVar.l("e", Base64.urlSafeEncode(from.getE().toByteArray()));
            jVar.l("use", "sig");
            jVar.l("alg", str);
            f fVar = new f();
            fVar.j("verify");
            jVar.j("key_ops", fVar);
            Optional<String> kid = getKid(protoKeySerialization.getIdRequirementOrNull());
            if (kid.isPresent()) {
                jVar.l("kid", kid.get());
                return jVar;
            }
            if (from.hasCustomKid()) {
                jVar.l("kid", from.getCustomKid().getValue());
            }
            return jVar;
        } catch (InvalidProtocolBufferException e10) {
            z.s("failed to parse value as JwtRsaSsaPkcs1PublicKey proto", e10);
            return null;
        }
    }

    private static j convertJwtRsaSsaPss(ProtoKeySerialization protoKeySerialization) throws GeneralSecurityException {
        String str;
        try {
            JwtRsaSsaPssPublicKey from = JwtRsaSsaPssPublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm[from.getAlgorithm().ordinal()];
            if (i == 1) {
                str = "PS256";
            } else if (i == 2) {
                str = "PS384";
            } else {
                if (i != 3) {
                    z.l("unknown algorithm");
                    return null;
                }
                str = "PS512";
            }
            j jVar = new j();
            jVar.l("kty", "RSA");
            jVar.l("n", Base64.urlSafeEncode(from.getN().toByteArray()));
            jVar.l("e", Base64.urlSafeEncode(from.getE().toByteArray()));
            jVar.l("use", "sig");
            jVar.l("alg", str);
            f fVar = new f();
            fVar.j("verify");
            jVar.j("key_ops", fVar);
            Optional<String> kid = getKid(protoKeySerialization.getIdRequirementOrNull());
            if (kid.isPresent()) {
                jVar.l("kid", kid.get());
                return jVar;
            }
            if (from.hasCustomKid()) {
                jVar.l("kid", from.getCustomKid().getValue());
            }
            return jVar;
        } catch (InvalidProtocolBufferException e10) {
            z.s("failed to parse value as JwtRsaSsaPssPublicKey proto", e10);
            return null;
        }
    }

    private static ProtoKeySerialization convertToEcdsaKey(j jVar) throws GeneralSecurityException {
        JwtEcdsaAlgorithm jwtEcdsaAlgorithm;
        String stringItem = getStringItem(jVar, "alg");
        stringItem.getClass();
        switch (stringItem) {
            case "ES256":
                expectStringItem(jVar, "crv", "P-256");
                jwtEcdsaAlgorithm = JwtEcdsaAlgorithm.ES256;
                break;
            case "ES384":
                expectStringItem(jVar, "crv", "P-384");
                jwtEcdsaAlgorithm = JwtEcdsaAlgorithm.ES384;
                break;
            case "ES512":
                expectStringItem(jVar, "crv", "P-521");
                jwtEcdsaAlgorithm = JwtEcdsaAlgorithm.ES512;
                break;
            default:
                throw new GeneralSecurityException("Unknown Ecdsa Algorithm: " + getStringItem(jVar, "alg"));
        }
        if (jVar.f8266c.containsKey("d")) {
            g5.f.o("importing ECDSA private keys is not implemented");
            return null;
        }
        expectStringItem(jVar, "kty", "EC");
        validateUseIsSig(jVar);
        validateKeyOpsIsVerify(jVar);
        JwtEcdsaPublicKey.Builder y10 = JwtEcdsaPublicKey.newBuilder().setVersion(0).setAlgorithm(jwtEcdsaAlgorithm).setX(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jVar, "x")))).setY(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jVar, "y"))));
        if (jVar.f8266c.containsKey("kid")) {
            y10.setCustomKid(JwtEcdsaPublicKey.CustomKid.newBuilder().setValue(getStringItem(jVar, "kid")).build());
        }
        return ProtoKeySerialization.create(JWT_ECDSA_PUBLIC_KEY_URL, y10.build().toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, OutputPrefixType.RAW, null);
    }

    private static ProtoKeySerialization convertToRsaSsaPkcs1Key(j jVar) throws GeneralSecurityException {
        JwtRsaSsaPkcs1Algorithm jwtRsaSsaPkcs1Algorithm;
        String stringItem = getStringItem(jVar, "alg");
        stringItem.getClass();
        switch (stringItem) {
            case "RS256":
                jwtRsaSsaPkcs1Algorithm = JwtRsaSsaPkcs1Algorithm.RS256;
                break;
            case "RS384":
                jwtRsaSsaPkcs1Algorithm = JwtRsaSsaPkcs1Algorithm.RS384;
                break;
            case "RS512":
                jwtRsaSsaPkcs1Algorithm = JwtRsaSsaPkcs1Algorithm.RS512;
                break;
            default:
                throw new GeneralSecurityException("Unknown Rsa Algorithm: " + getStringItem(jVar, "alg"));
        }
        n nVar = jVar.f8266c;
        n nVar2 = jVar.f8266c;
        if (nVar.containsKey("p") || nVar2.containsKey("q") || nVar2.containsKey("dp") || nVar2.containsKey("dq") || nVar2.containsKey("d") || nVar2.containsKey("qi")) {
            g5.f.o("importing RSA private keys is not implemented");
            return null;
        }
        expectStringItem(jVar, "kty", "RSA");
        validateUseIsSig(jVar);
        validateKeyOpsIsVerify(jVar);
        JwtRsaSsaPkcs1PublicKey.Builder n8 = JwtRsaSsaPkcs1PublicKey.newBuilder().setVersion(0).setAlgorithm(jwtRsaSsaPkcs1Algorithm).setE(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jVar, "e")))).setN(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jVar, "n"))));
        if (nVar2.containsKey("kid")) {
            n8.setCustomKid(JwtRsaSsaPkcs1PublicKey.CustomKid.newBuilder().setValue(getStringItem(jVar, "kid")).build());
        }
        return ProtoKeySerialization.create(JWT_RSA_SSA_PKCS1_PUBLIC_KEY_URL, n8.build().toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, OutputPrefixType.RAW, null);
    }

    private static ProtoKeySerialization convertToRsaSsaPssKey(j jVar) throws GeneralSecurityException {
        JwtRsaSsaPssAlgorithm jwtRsaSsaPssAlgorithm;
        String stringItem = getStringItem(jVar, "alg");
        stringItem.getClass();
        switch (stringItem) {
            case "PS256":
                jwtRsaSsaPssAlgorithm = JwtRsaSsaPssAlgorithm.PS256;
                break;
            case "PS384":
                jwtRsaSsaPssAlgorithm = JwtRsaSsaPssAlgorithm.PS384;
                break;
            case "PS512":
                jwtRsaSsaPssAlgorithm = JwtRsaSsaPssAlgorithm.PS512;
                break;
            default:
                throw new GeneralSecurityException("Unknown Rsa Algorithm: " + getStringItem(jVar, "alg"));
        }
        n nVar = jVar.f8266c;
        n nVar2 = jVar.f8266c;
        if (nVar.containsKey("p") || nVar2.containsKey("q") || nVar2.containsKey("dq") || nVar2.containsKey("dq") || nVar2.containsKey("d") || nVar2.containsKey("qi")) {
            g5.f.o("importing RSA private keys is not implemented");
            return null;
        }
        expectStringItem(jVar, "kty", "RSA");
        validateUseIsSig(jVar);
        validateKeyOpsIsVerify(jVar);
        JwtRsaSsaPssPublicKey.Builder n8 = JwtRsaSsaPssPublicKey.newBuilder().setVersion(0).setAlgorithm(jwtRsaSsaPssAlgorithm).setE(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jVar, "e")))).setN(ByteString.copyFrom(Base64.urlSafeDecode(getStringItem(jVar, "n"))));
        if (nVar2.containsKey("kid")) {
            n8.setCustomKid(JwtRsaSsaPssPublicKey.CustomKid.newBuilder().setValue(getStringItem(jVar, "kid")).build());
        }
        return ProtoKeySerialization.create(JWT_RSA_SSA_PSS_PUBLIC_KEY_URL, n8.build().toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, OutputPrefixType.RAW, null);
    }

    private static void expectStringItem(j jVar, String str, String str2) throws GeneralSecurityException {
        String stringItem = getStringItem(jVar, str);
        if (!stringItem.equals(str2)) {
            throw new GeneralSecurityException(b.j("unexpected ", str, " value: ", stringItem));
        }
    }

    @Deprecated
    public static String fromKeysetHandle(KeysetHandle keysetHandle, KeyAccess keyAccess) {
        return fromPublicKeysetHandle(keysetHandle);
    }

    public static String fromPublicKeysetHandle(KeysetHandle keysetHandle) throws GeneralSecurityException {
        f fVar = new f();
        for (int i = 0; i < keysetHandle.size(); i++) {
            KeysetHandle.Entry at = keysetHandle.getAt(i);
            if (at.getStatus() == KeyStatus.ENABLED) {
                Key key = at.getKey();
                if (!(key instanceof LegacyProtoKey)) {
                    z.l("only LegacyProtoKey is currently supported");
                    return null;
                }
                ProtoKeySerialization serialization = ((LegacyProtoKey) key).getSerialization(null);
                if (serialization.getOutputPrefixType() != OutputPrefixType.RAW && serialization.getOutputPrefixType() != OutputPrefixType.TINK) {
                    z.l("only OutputPrefixType RAW and TINK are supported");
                    return null;
                }
                if (serialization.getKeyMaterialType() != KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC) {
                    z.l("only public keys can be converted");
                    return null;
                }
                String typeUrl = serialization.getTypeUrl();
                typeUrl.getClass();
                switch (typeUrl) {
                    case "type.googleapis.com/google.crypto.tink.JwtEcdsaPublicKey":
                        fVar.k(convertJwtEcdsaKey(serialization));
                        break;
                    case "type.googleapis.com/google.crypto.tink.JwtRsaSsaPkcs1PublicKey":
                        fVar.k(convertJwtRsaSsaPkcs1(serialization));
                        break;
                    case "type.googleapis.com/google.crypto.tink.JwtRsaSsaPssPublicKey":
                        fVar.k(convertJwtRsaSsaPss(serialization));
                        break;
                    default:
                        throw new GeneralSecurityException(a.C("key type ", serialization.getTypeUrl(), " is not supported"));
                }
            }
        }
        j jVar = new j();
        jVar.j("keys", fVar);
        return jVar.toString();
    }

    private static Optional<String> getKid(@Nullable Integer num) {
        return num == null ? Optional.empty() : Optional.of(Base64.urlSafeEncode(ByteBuffer.allocate(4).putInt(num.intValue()).array()));
    }

    private static String getStringItem(j jVar, String str) throws GeneralSecurityException {
        if (!jVar.f8266c.containsKey(str)) {
            throw new GeneralSecurityException(a.n(str, " not found"));
        }
        g gVarN = jVar.n(str);
        gVarN.getClass();
        if ((gVarN instanceof l) && (jVar.n(str).f().f8267c instanceof String)) {
            return jVar.n(str).i();
        }
        throw new GeneralSecurityException(a.n(str, " is not a string"));
    }

    @Deprecated
    public static KeysetHandle toKeysetHandle(String str, KeyAccess keyAccess) {
        return toPublicKeysetHandle(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0070 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.crypto.tink.KeysetHandle toPublicKeysetHandle(java.lang.String r11) throws java.security.GeneralSecurityException {
        /*
            r0 = 0
            u7.a r1 = new u7.a     // Catch: java.lang.Throwable -> Lbf
            java.io.StringReader r2 = new java.io.StringReader     // Catch: java.lang.Throwable -> Lbf
            r2.<init>(r11)     // Catch: java.lang.Throwable -> Lbf
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lbf
            r11 = 2
            r1.f14161s = r11     // Catch: java.lang.Throwable -> Lbf
            m7.g r1 = o7.h.i(r1)     // Catch: java.lang.Throwable -> Lbf
            m7.j r1 = r1.e()     // Catch: java.lang.Throwable -> Lbf
            com.google.crypto.tink.KeysetHandle$Builder r2 = com.google.crypto.tink.KeysetHandle.newBuilder()
            java.lang.String r3 = "keys"
            m7.g r1 = r1.n(r3)
            m7.f r1 = r1.d()
            java.util.ArrayList r1 = r1.f8264c
            int r3 = r1.size()
            r4 = 0
            r5 = r4
        L2c:
            if (r5 >= r3) goto La7
            java.lang.Object r6 = r1.get(r5)
            int r5 = r5 + 1
            m7.g r6 = (m7.g) r6
            m7.j r6 = r6.e()
            java.lang.String r7 = "alg"
            java.lang.String r8 = getStringItem(r6, r7)
            java.lang.String r8 = r8.substring(r4, r11)
            int r9 = r8.hashCode()
            r10 = -1
            switch(r9) {
                case 2222: goto L63;
                case 2563: goto L58;
                case 2625: goto L4d;
                default: goto L4c;
            }
        L4c:
            goto L6d
        L4d:
            java.lang.String r9 = "RS"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L56
            goto L6d
        L56:
            r10 = r11
            goto L6d
        L58:
            java.lang.String r9 = "PS"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L61
            goto L6d
        L61:
            r10 = 1
            goto L6d
        L63:
            java.lang.String r9 = "ES"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L6c
            goto L6d
        L6c:
            r10 = r4
        L6d:
            switch(r10) {
                case 0: goto L92;
                case 1: goto L8d;
                case 2: goto L88;
                default: goto L70;
            }
        L70:
            java.security.GeneralSecurityException r11 = new java.security.GeneralSecurityException
            java.lang.String r0 = getStringItem(r6, r7)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "unexpected alg value: "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r11.<init>(r0)
            throw r11
        L88:
            com.google.crypto.tink.internal.ProtoKeySerialization r6 = convertToRsaSsaPkcs1Key(r6)
            goto L96
        L8d:
            com.google.crypto.tink.internal.ProtoKeySerialization r6 = convertToRsaSsaPssKey(r6)
            goto L96
        L92:
            com.google.crypto.tink.internal.ProtoKeySerialization r6 = convertToEcdsaKey(r6)
        L96:
            com.google.crypto.tink.internal.LegacyProtoKey r7 = new com.google.crypto.tink.internal.LegacyProtoKey
            r7.<init>(r6, r0)
            com.google.crypto.tink.KeysetHandle$Builder$Entry r6 = com.google.crypto.tink.KeysetHandle.importKey(r7)
            com.google.crypto.tink.KeysetHandle$Builder$Entry r6 = r6.withRandomId()
            r2.addEntry(r6)
            goto L2c
        La7:
            int r11 = r2.size()
            if (r11 <= 0) goto Lb9
            com.google.crypto.tink.KeysetHandle$Builder$Entry r11 = r2.getAt(r4)
            r11.makePrimary()
            com.google.crypto.tink.KeysetHandle r11 = r2.build()
            return r11
        Lb9:
            java.lang.String r11 = "empty keyset"
            b8.z.l(r11)
            return r0
        Lbf:
            r11 = move-exception
            java.lang.String r1 = "JWK set is invalid JSON"
            b8.z.s(r1, r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.jwt.JwkSetConverter.toPublicKeysetHandle(java.lang.String):com.google.crypto.tink.KeysetHandle");
    }

    private static void validateKeyOpsIsVerify(j jVar) throws GeneralSecurityException {
        if (jVar.f8266c.containsKey("key_ops")) {
            g gVarN = jVar.n("key_ops");
            gVarN.getClass();
            if (!(gVarN instanceof f)) {
                z.l("key_ops is not an array");
                return;
            }
            f fVarD = jVar.n("key_ops").d();
            if (fVarD.f8264c.size() != 1) {
                z.l("key_ops must contain exactly one element");
                return;
            }
            g gVarL = fVarD.l(0);
            gVarL.getClass();
            if (!(gVarL instanceof l) || !(fVarD.l(0).f().f8267c instanceof String)) {
                z.l("key_ops is not a string");
            } else {
                if (fVarD.l(0).i().equals("verify")) {
                    return;
                }
                throw new GeneralSecurityException("unexpected keyOps value: " + fVarD.l(0).i());
            }
        }
    }

    private static void validateUseIsSig(j jVar) throws GeneralSecurityException {
        if (jVar.f8266c.containsKey("use")) {
            expectStringItem(jVar, "use", "sig");
        }
    }
}
