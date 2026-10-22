package com.stepos.core.ota.crypto.attest;

import ai.onnxruntime.a;
import com.stepos.core.common.telemetry.FailStage;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.core.ota.crypto.attest.KeyAttestation;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Result;
import kotlin.c;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AttestationParser {
    public static final String ATTESTATION_OID = "1.3.6.1.4.1.11129.2.1.17";
    public static final AttestationParser INSTANCE = new AttestationParser();
    private static final int TAG_ALGORITHM = 2;
    private static final int TAG_ATTESTATION_APPLICATION_ID = 709;
    private static final int TAG_DIGEST = 5;
    private static final int TAG_EC_CURVE = 10;
    private static final int TAG_KEY_SIZE = 3;
    private static final int TAG_NO_AUTH_REQUIRED = 503;
    private static final int TAG_ORIGIN = 702;
    private static final int TAG_OS_PATCH_LEVEL = 706;
    private static final int TAG_OS_VERSION = 705;
    private static final int TAG_PADDING = 6;
    private static final int TAG_PURPOSE = 1;
    private static final int TAG_ROOT_OF_TRUST = 704;

    private AttestationParser() {
    }

    private static final CharSequence parse$lambda$2(byte b10) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
    }

    private final KeyAttestation.AttestationApplicationId parseAttestationApplicationId(DerElement derElement) {
        String strAsUtf8;
        DerElement derElementUnwrapExplicit = derElement.unwrapExplicit();
        if (derElementUnwrapExplicit == null) {
            throw new IllegalStateException("attestationApplicationId empty");
        }
        DerElement next = new DerReader(derElementUnwrapExplicit.getContent(), 0, 0, 6, null).next();
        if (next == null) {
            throw new IllegalStateException("attestationApplicationId not DER");
        }
        DerReader erVar = next.reader();
        ArrayList arrayList = new ArrayList();
        DerElement next2 = erVar.next();
        if (next2 != null) {
            DerReader erVar2 = next2.reader();
            while (true) {
                DerElement next3 = erVar2.next();
                if (next3 == null) {
                    break;
                }
                DerReader erVar3 = next3.reader();
                DerElement next4 = erVar3.next();
                if (next4 != null && (strAsUtf8 = next4.asUtf8()) != null) {
                    DerElement next5 = erVar3.next();
                    arrayList.add(new KeyAttestation.AttestationApplicationId.PackageInfo(strAsUtf8, next5 != null ? next5.asLong() : 0L));
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        DerElement next6 = erVar.next();
        if (next6 != null) {
            DerReader erVar4 = next6.reader();
            while (true) {
                DerElement next7 = erVar4.next();
                if (next7 == null) {
                    break;
                }
                arrayList2.add(next7.hex());
            }
        }
        return new KeyAttestation.AttestationApplicationId(arrayList, arrayList2);
    }

    private final KeyAttestation.AuthorizationList parseAuthorizationList(DerElement derElement) {
        DerReader derReader;
        Long l10;
        Object objA;
        Object objA2;
        EmptyList emptyList = EmptyList.f10001a;
        ArrayList arrayList = new ArrayList();
        DerReader erVar = derElement.reader();
        Long lValueOf = null;
        List<Long> intSet = emptyList;
        List<Long> intSet2 = intSet;
        Long lValueOf2 = null;
        Long lValueOf3 = null;
        Long lValueOf4 = null;
        Long lValueOf5 = null;
        Long lValueOf6 = null;
        KeyAttestation.RootOfTrust rootOfTrust = null;
        KeyAttestation.AttestationApplicationId attestationApplicationId = null;
        boolean z = false;
        List<Long> intSet3 = intSet2;
        while (true) {
            DerElement next = erVar.next();
            if (next == null) {
                return new KeyAttestation.AuthorizationList(intSet3, lValueOf, lValueOf2, intSet, intSet2, lValueOf3, z, lValueOf4, lValueOf5, lValueOf6, rootOfTrust, attestationApplicationId, arrayList);
            }
            if (next.isContext()) {
                derReader = erVar;
                int tagNumber = next.getTagNumber();
                l10 = lValueOf;
                if (tagNumber == 1) {
                    intSet3 = readIntSet(next);
                } else if (tagNumber == 2) {
                    DerElement derElementUnwrapExplicit = next.unwrapExplicit();
                    lValueOf = derElementUnwrapExplicit != null ? Long.valueOf(derElementUnwrapExplicit.asLong()) : null;
                    erVar = derReader;
                } else if (tagNumber == 3) {
                    DerElement derElementUnwrapExplicit2 = next.unwrapExplicit();
                    lValueOf2 = derElementUnwrapExplicit2 != null ? Long.valueOf(derElementUnwrapExplicit2.asLong()) : null;
                } else if (tagNumber == 5) {
                    intSet = readIntSet(next);
                } else if (tagNumber == 6) {
                    intSet2 = readIntSet(next);
                } else if (tagNumber == 10) {
                    DerElement derElementUnwrapExplicit3 = next.unwrapExplicit();
                    lValueOf3 = derElementUnwrapExplicit3 != null ? Long.valueOf(derElementUnwrapExplicit3.asLong()) : null;
                } else if (tagNumber == TAG_NO_AUTH_REQUIRED) {
                    erVar = derReader;
                    lValueOf = l10;
                    z = true;
                } else if (tagNumber == TAG_ORIGIN) {
                    DerElement derElementUnwrapExplicit4 = next.unwrapExplicit();
                    lValueOf4 = derElementUnwrapExplicit4 != null ? Long.valueOf(derElementUnwrapExplicit4.asLong()) : null;
                } else if (tagNumber != TAG_ATTESTATION_APPLICATION_ID) {
                    switch (tagNumber) {
                        case TAG_ROOT_OF_TRUST /* 704 */:
                            try {
                                objA2 = parseRootOfTrust(next);
                            } catch (Throwable th) {
                                objA2 = c.a(th);
                            }
                            if (objA2 instanceof Result.Failure) {
                                objA2 = null;
                            }
                            rootOfTrust = (KeyAttestation.RootOfTrust) objA2;
                            break;
                        case TAG_OS_VERSION /* 705 */:
                            DerElement derElementUnwrapExplicit5 = next.unwrapExplicit();
                            if (derElementUnwrapExplicit5 == null) {
                                lValueOf5 = null;
                                break;
                            } else {
                                lValueOf5 = Long.valueOf(derElementUnwrapExplicit5.asLong());
                                break;
                            }
                        case TAG_OS_PATCH_LEVEL /* 706 */:
                            DerElement derElementUnwrapExplicit6 = next.unwrapExplicit();
                            if (derElementUnwrapExplicit6 == null) {
                                lValueOf6 = null;
                                break;
                            } else {
                                lValueOf6 = Long.valueOf(derElementUnwrapExplicit6.asLong());
                                break;
                            }
                        default:
                            arrayList.add(Integer.valueOf(next.getTagNumber()));
                            break;
                    }
                } else {
                    try {
                        objA = parseAttestationApplicationId(next);
                    } catch (Throwable th2) {
                        objA = c.a(th2);
                    }
                    if (objA instanceof Result.Failure) {
                        objA = null;
                    }
                    attestationApplicationId = (KeyAttestation.AttestationApplicationId) objA;
                }
            } else {
                arrayList.add(Integer.valueOf(next.getTagNumber()));
                derReader = erVar;
                l10 = lValueOf;
            }
            erVar = derReader;
            lValueOf = l10;
        }
    }

    private final KeyAttestation.RootOfTrust parseRootOfTrust(DerElement derElement) {
        DerElement derElementUnwrapExplicit = derElement.unwrapExplicit();
        if (derElementUnwrapExplicit == null) {
            throw new IllegalStateException("rootOfTrust empty");
        }
        DerReader erVar = derElementUnwrapExplicit.reader();
        DerElement derElementRequireNext = requireNext(erVar, "verifiedBootKey");
        boolean zAsBoolean = requireNext(erVar, "deviceLocked").asBoolean();
        long jAsLong = requireNext(erVar, "verifiedBootState").asLong();
        DerElement next = erVar.next();
        return new KeyAttestation.RootOfTrust(derElementRequireNext.hex(), zAsBoolean, KeyAttestation.RootOfTrust.VerifiedBootState.Companion.of(jAsLong), next != null ? next.hex() : null);
    }

    private final List<Long> readIntSet(DerElement derElement) {
        DerElement derElementUnwrapExplicit = derElement.unwrapExplicit();
        if (derElementUnwrapExplicit == null) {
            return EmptyList.f10001a;
        }
        ArrayList arrayList = new ArrayList();
        DerReader erVar = derElementUnwrapExplicit.reader();
        while (true) {
            DerElement next = erVar.next();
            if (next == null) {
                return arrayList;
            }
            arrayList.add(Long.valueOf(next.asLong()));
        }
    }

    private final DerElement requireNext(DerReader derReader, String str) {
        DerElement next = derReader.next();
        if (next != null) {
            return next;
        }
        throw new IllegalStateException(("KeyDescription missing " + str).toString());
    }

    public final String algorithmName(long j10) {
        int i10 = (int) j10;
        return i10 != 1 ? i10 != 3 ? i10 != 128 ? i10 != 32 ? i10 != 33 ? a.h(j10, "UNKNOWN(", ")") : "TRIPLE_DES" : "AES" : "HMAC" : "EC" : "RSA";
    }

    public final String digestName(long j10) {
        switch ((int) j10) {
            case 0:
                return ModelFlowMeta.PLAN_NONE;
            case 1:
                return "MD5";
            case 2:
                return "SHA1";
            case 3:
                return "SHA-224";
            case 4:
                return "SHA-256";
            case 5:
                return "SHA-384";
            case 6:
                return "SHA-512";
            default:
                return a.h(j10, "UNKNOWN(", ")");
        }
    }

    public final String ecCurveName(long j10) {
        int i10 = (int) j10;
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? a.h(j10, "UNKNOWN(", ")") : "CURVE_25519" : "P-521" : "P-384" : "P-256" : "P-224";
    }

    public final String originName(long j10) {
        int i10 = (int) j10;
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? a.h(j10, "UNKNOWN(", ")") : "SECURELY_IMPORTED" : FailStage.UNKNOWN : "IMPORTED" : "DERIVED" : "GENERATED";
    }

    public final String paddingName(long j10) {
        int i10 = (int) j10;
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? i10 != 64 ? a.h(j10, "UNKNOWN(", ")") : "PKCS7" : "RSA_PKCS1_1_5_SIGN" : "RSA_PKCS1_1_5_ENCRYPT" : "RSA_PSS" : "RSA_OAEP" : ModelFlowMeta.PLAN_NONE;
    }

    public final KeyAttestation parse(X509Certificate cert) {
        DerElement next;
        KeyAttestation keyAttestation;
        g.f(cert, "cert");
        byte[] extensionValue = cert.getExtensionValue(ATTESTATION_OID);
        if (extensionValue == null || (next = new DerReader(extensionValue, 0, 0, 6, null).next()) == null) {
            return null;
        }
        if (next.getTagNumber() != 4) {
            throw new IllegalStateException("extnValue not OCTET STRING");
        }
        DerElement next2 = new DerReader(next.getContent(), 0, 0, 6, null).next();
        if (next2 == null) {
            return null;
        }
        if (!next2.getConstructed() || next2.getTagNumber() != 16) {
            throw new IllegalStateException("KeyDescription not SEQUENCE");
        }
        DerReader erVar = next2.reader();
        long jAsLong = requireNext(erVar, "attestationVersion").asLong();
        long jAsLong2 = requireNext(erVar, "attestationSecurityLevel").asLong();
        long jAsLong3 = requireNext(erVar, "keymasterVersion").asLong();
        long jAsLong4 = requireNext(erVar, "keymasterSecurityLevel").asLong();
        byte[] content = requireNext(erVar, "attestationChallenge").getContent();
        byte[] content2 = requireNext(erVar, "uniqueId").getContent();
        KeyAttestation.AuthorizationList authorizationList = parseAuthorizationList(requireNext(erVar, "softwareEnforced"));
        KeyAttestation.AuthorizationList authorizationList2 = parseAuthorizationList(requireNext(erVar, "teeEnforced"));
        KeyAttestation.SecurityLevel.Companion companion = KeyAttestation.SecurityLevel.Companion;
        KeyAttestation.SecurityLevel securityLevelOf = companion.of(jAsLong2);
        KeyAttestation.SecurityLevel securityLevelOf2 = companion.of(jAsLong4);
        g.f(content2, "<this>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "");
        int length = content2.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            byte b10 = content2[i10];
            KeyAttestation keyAttestation2 = keyAttestation;
            i11++;
            if (i11 > 1) {
                sb2.append((CharSequence) "");
            }
            sb2.append(parse$lambda$2(b10));
            i10++;
            keyAttestation = keyAttestation2;
        }
        sb2.append((CharSequence) "");
        return new KeyAttestation(jAsLong, securityLevelOf, jAsLong3, securityLevelOf2, content, sb2.toString(), authorizationList, authorizationList2);
    }

    public final String purposeName(long j10) {
        switch ((int) j10) {
            case 0:
                return "ENCRYPT";
            case 1:
                return "DECRYPT";
            case 2:
                return "SIGN";
            case 3:
                return "VERIFY";
            case 4:
                return "DERIVE_KEY";
            case 5:
                return "WRAP_KEY";
            case 6:
                return "AGREE_KEY";
            case 7:
                return "ATTEST_KEY";
            default:
                return a.h(j10, "UNKNOWN(", ")");
        }
    }
}
