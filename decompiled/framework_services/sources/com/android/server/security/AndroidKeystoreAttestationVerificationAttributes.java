package com.android.server.security;

import com.android.framework.protobuf.ByteString;
import com.android.internal.org.bouncycastle.asn1.ASN1Boolean;
import com.android.internal.org.bouncycastle.asn1.ASN1Encodable;
import com.android.internal.org.bouncycastle.asn1.ASN1Enumerated;
import com.android.internal.org.bouncycastle.asn1.ASN1InputStream;
import com.android.internal.org.bouncycastle.asn1.ASN1Integer;
import com.android.internal.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.android.internal.org.bouncycastle.asn1.ASN1OctetString;
import com.android.internal.org.bouncycastle.asn1.ASN1Sequence;
import com.android.internal.org.bouncycastle.asn1.ASN1Set;
import com.android.internal.org.bouncycastle.asn1.ASN1TaggedObject;
import com.android.internal.org.bouncycastle.asn1.x509.Certificate;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class AndroidKeystoreAttestationVerificationAttributes {
    private static final String ANDROID_KEYMASTER_KEY_DESCRIPTION_EXTENSION_OID = "1.3.6.1.4.1.11129.2.1.17";
    private static final int ATTESTATION_CHALLENGE_INDEX = 4;
    private static final int ATTESTATION_SECURITY_LEVEL_INDEX = 1;
    private static final int ATTESTATION_VERSION_INDEX = 0;
    private static final int HW_AUTH_NONE = 0;
    private static final int HW_ENFORCED_INDEX = 7;
    private static final int KEYMASTER_SECURITY_LEVEL_INDEX = 3;
    private static final int KEYMASTER_UNIQUE_ID_INDEX = 5;
    private static final int KEYMASTER_VERSION_INDEX = 2;
    private static final int KM_SECURITY_LEVEL_SOFTWARE = 0;
    private static final int KM_SECURITY_LEVEL_STRONG_BOX = 2;
    private static final int KM_SECURITY_LEVEL_TRUSTED_ENVIRONMENT = 1;
    private static final int KM_TAG_ALL_APPLICATIONS = 600;
    private static final int KM_TAG_ATTESTATION_APPLICATION_ID = 709;
    private static final int KM_TAG_ATTESTATION_ID_BRAND = 710;
    private static final int KM_TAG_ATTESTATION_ID_DEVICE = 711;
    private static final int KM_TAG_ATTESTATION_ID_PRODUCT = 712;
    private static final int KM_TAG_BOOT_PATCHLEVEL = 719;
    private static final int KM_TAG_NO_AUTH_REQUIRED = 503;
    private static final int KM_TAG_OS_PATCHLEVEL = 706;
    private static final int KM_TAG_OS_VERSION = 705;
    private static final int KM_TAG_ROOT_OF_TRUST = 704;
    private static final int KM_TAG_UNLOCKED_DEVICE_REQUIRED = 509;
    private static final int KM_TAG_VENDOR_PATCHLEVEL = 718;
    private static final int KM_VERIFIED_BOOT_STATE_FAILED = 3;
    private static final int KM_VERIFIED_BOOT_STATE_SELF_SIGNED = 1;
    private static final int KM_VERIFIED_BOOT_STATE_UNVERIFIED = 2;
    private static final int KM_VERIFIED_BOOT_STATE_VERIFIED = 0;
    private static final int PACKAGE_INFO_NAME_INDEX = 0;
    private static final int PACKAGE_INFO_SET_INDEX = 0;
    private static final int PACKAGE_INFO_VERSION_INDEX = 1;
    private static final int PACKAGE_SIGNATURE_SET_INDEX = 1;
    private static final int SW_ENFORCED_INDEX = 6;
    private static final int VERIFIED_BOOT_HASH_INDEX = 3;
    private static final int VERIFIED_BOOT_KEY_INDEX = 0;
    private static final int VERIFIED_BOOT_LOCKED_INDEX = 1;
    private static final int VERIFIED_BOOT_STATE_INDEX = 2;
    private List<ByteString> mApplicationCertificateDigests;
    private Map<String, Long> mApplicationPackageNameVersion;
    private ByteString mAttestationChallenge;
    private boolean mAttestationHardwareBacked;
    private SecurityLevel mAttestationSecurityLevel;
    private Integer mAttestationVersion;
    private String mDeviceBrand;
    private String mDeviceName;
    private String mDeviceProductName;
    private boolean mKeyAllowedForAllApplications;
    private Integer mKeyAuthenticatorType;
    private Integer mKeyBootPatchLevel;
    private Integer mKeyOsPatchLevel;
    private Integer mKeyOsVersion;
    private Boolean mKeyRequiresUnlockedDevice;
    private Integer mKeyVendorPatchLevel;
    private boolean mKeymasterHardwareBacked;
    private SecurityLevel mKeymasterSecurityLevel;
    private ByteString mKeymasterUniqueId;
    private Integer mKeymasterVersion;
    private ByteString mVerifiedBootHash;
    private ByteString mVerifiedBootKey;
    private Boolean mVerifiedBootLocked;
    private VerifiedBootState mVerifiedBootState;

    static final enum SecurityLevel extends Enum<SecurityLevel> {
        private static final /* synthetic */ SecurityLevel[] $VALUES = null;
        public static final SecurityLevel SOFTWARE = null;
        public static final SecurityLevel STRONG_BOX = null;
        public static final SecurityLevel TRUSTED_ENVIRONMENT = null;

        private static /* synthetic */ SecurityLevel[] $values() {
            return new SecurityLevel[]{SOFTWARE, TRUSTED_ENVIRONMENT, STRONG_BOX};
        }

        private SecurityLevel(String r1, int r2) {
            super(r1, r2);
        }

        public static SecurityLevel valueOf(String name) {
            return (SecurityLevel) Enum.valueOf(SecurityLevel.class, name);
        }

        public static SecurityLevel[] values() {
            return (SecurityLevel[]) $VALUES.clone();
        }

        static {
            SOFTWARE = new SecurityLevel("SOFTWARE", 0);
            TRUSTED_ENVIRONMENT = new SecurityLevel("TRUSTED_ENVIRONMENT", 1);
            STRONG_BOX = new SecurityLevel("STRONG_BOX", 2);
            $VALUES = $values();
        }
    }

    static final enum VerifiedBootState extends Enum<VerifiedBootState> {
        private static final /* synthetic */ VerifiedBootState[] $VALUES = null;
        public static final VerifiedBootState FAILED = null;
        public static final VerifiedBootState SELF_SIGNED = null;
        public static final VerifiedBootState UNVERIFIED = null;
        public static final VerifiedBootState VERIFIED = null;

        private static /* synthetic */ VerifiedBootState[] $values() {
            return new VerifiedBootState[]{VERIFIED, SELF_SIGNED, UNVERIFIED, FAILED};
        }

        private VerifiedBootState(String r1, int r2) {
            super(r1, r2);
        }

        public static VerifiedBootState valueOf(String name) {
            return (VerifiedBootState) Enum.valueOf(VerifiedBootState.class, name);
        }

        public static VerifiedBootState[] values() {
            return (VerifiedBootState[]) $VALUES.clone();
        }

        static {
            VERIFIED = new VerifiedBootState("VERIFIED", 0);
            SELF_SIGNED = new VerifiedBootState("SELF_SIGNED", 1);
            UNVERIFIED = new VerifiedBootState("UNVERIFIED", 2);
            FAILED = new VerifiedBootState("FAILED", 3);
            $VALUES = $values();
        }
    }

    static AndroidKeystoreAttestationVerificationAttributes fromCertificate(X509Certificate x509Certificate) throws CertificateEncodingException, IOException {
        return new AndroidKeystoreAttestationVerificationAttributes(x509Certificate);
    }

    int getAttestationVersion() {
        return this.mAttestationVersion.intValue();
    }

    SecurityLevel getAttestationSecurityLevel() {
        return this.mAttestationSecurityLevel;
    }

    boolean isAttestationHardwareBacked() {
        return this.mAttestationHardwareBacked;
    }

    int getKeymasterVersion() {
        return this.mKeymasterVersion.intValue();
    }

    SecurityLevel getKeymasterSecurityLevel() {
        return this.mKeymasterSecurityLevel;
    }

    boolean isKeymasterHardwareBacked() {
        return this.mKeymasterHardwareBacked;
    }

    ByteString getAttestationChallenge() {
        return this.mAttestationChallenge;
    }

    ByteString getKeymasterUniqueId() {
        return this.mKeymasterUniqueId;
    }

    String getDeviceBrand() {
        return this.mDeviceBrand;
    }

    String getDeviceName() {
        return this.mDeviceName;
    }

    String getDeviceProductName() {
        return this.mDeviceProductName;
    }

    boolean isKeyAllowedForAllApplications() {
        return this.mKeyAllowedForAllApplications;
    }

    int getKeyAuthenticatorType() {
        if (this.mKeyAuthenticatorType == null) goto L7;
        return this.mKeyAuthenticatorType.intValue();
    L7:
        throw new IllegalStateException("KeyAuthenticatorType is not set.");
    }

    int getKeyBootPatchLevel() {
        if (this.mKeyBootPatchLevel == null) goto L7;
        return this.mKeyBootPatchLevel.intValue();
    L7:
        throw new IllegalStateException("KeyBootPatchLevel is not set.");
    }

    int getKeyOsPatchLevel() {
        if (this.mKeyOsPatchLevel == null) goto L7;
        return this.mKeyOsPatchLevel.intValue();
    L7:
        throw new IllegalStateException("KeyOsPatchLevel is not set.");
    }

    int getKeyVendorPatchLevel() {
        if (this.mKeyVendorPatchLevel == null) goto L7;
        return this.mKeyVendorPatchLevel.intValue();
    L7:
        throw new IllegalStateException("KeyVendorPatchLevel is not set.");
    }

    int getKeyOsVersion() {
        if (this.mKeyOsVersion == null) goto L7;
        return this.mKeyOsVersion.intValue();
    L7:
        throw new IllegalStateException("KeyOsVersion is not set.");
    }

    boolean isKeyRequiresUnlockedDevice() {
        if (this.mKeyRequiresUnlockedDevice == null) goto L7;
        return this.mKeyRequiresUnlockedDevice.booleanValue();
    L7:
        throw new IllegalStateException("KeyRequiresUnlockedDevice is not set.");
    }

    ByteString getVerifiedBootHash() {
        return this.mVerifiedBootHash;
    }

    ByteString getVerifiedBootKey() {
        return this.mVerifiedBootKey;
    }

    boolean isVerifiedBootLocked() {
        if (this.mVerifiedBootLocked == null) goto L7;
        return this.mVerifiedBootLocked.booleanValue();
    L7:
        throw new IllegalStateException("VerifiedBootLocked is not set.");
    }

    VerifiedBootState getVerifiedBootState() {
        return this.mVerifiedBootState;
    }

    Map<String, Long> getApplicationPackageNameVersion() {
        return Collections.unmodifiableMap(this.mApplicationPackageNameVersion);
    }

    List<ByteString> getApplicationCertificateDigests() {
        return Collections.unmodifiableList(this.mApplicationCertificateDigests);
    }

    private AndroidKeystoreAttestationVerificationAttributes(X509Certificate x509Certificate) throws CertificateEncodingException, IOException {
        this.mAttestationVersion = null;
        this.mAttestationSecurityLevel = null;
        this.mAttestationHardwareBacked = false;
        this.mKeymasterVersion = null;
        this.mKeymasterSecurityLevel = null;
        this.mKeymasterHardwareBacked = false;
        this.mAttestationChallenge = null;
        this.mKeymasterUniqueId = null;
        this.mDeviceBrand = null;
        this.mDeviceName = null;
        this.mDeviceProductName = null;
        this.mKeyAllowedForAllApplications = false;
        this.mKeyAuthenticatorType = null;
        this.mKeyBootPatchLevel = null;
        this.mKeyOsPatchLevel = null;
        this.mKeyOsVersion = null;
        this.mKeyVendorPatchLevel = null;
        this.mKeyRequiresUnlockedDevice = null;
        this.mVerifiedBootHash = null;
        this.mVerifiedBootKey = null;
        this.mVerifiedBootLocked = null;
        this.mVerifiedBootState = null;
        this.mApplicationPackageNameVersion = null;
        this.mApplicationCertificateDigests = null;
        Certificate certificate = Certificate.getInstance(new ASN1InputStream(x509Certificate.getEncoded()).readObject());
        ASN1Sequence keyAttributes = certificate.getTBSCertificate().getExtensions().getExtensionParsedValue(new ASN1ObjectIdentifier(ANDROID_KEYMASTER_KEY_DESCRIPTION_EXTENSION_OID));
        if (keyAttributes == null) goto L40;
        this.mAttestationVersion = Integer.valueOf(getIntegerFromAsn1(keyAttributes.getObjectAt(0)));
        this.mAttestationSecurityLevel = getSecurityLevelEnum(keyAttributes.getObjectAt(1));
        if (this.mAttestationSecurityLevel != SecurityLevel.TRUSTED_ENVIRONMENT) goto L7;
        boolean r4 = true;
    L8:
        this.mAttestationHardwareBacked = r4;
        this.mAttestationChallenge = getOctetsFromAsn1(keyAttributes.getObjectAt(4));
        this.mKeymasterVersion = Integer.valueOf(getIntegerFromAsn1(keyAttributes.getObjectAt(2)));
        this.mKeymasterUniqueId = getOctetsFromAsn1(keyAttributes.getObjectAt(5));
        this.mKeymasterSecurityLevel = getSecurityLevelEnum(keyAttributes.getObjectAt(3));
        if (this.mKeymasterSecurityLevel != SecurityLevel.TRUSTED_ENVIRONMENT) goto L11;
        boolean r6 = true;
    L12:
        this.mKeymasterHardwareBacked = r6;
        ASN1TaggedObject[] r7 = keyAttributes.getObjectAt(6).toArray();
        int r8 = r7.length;
        int r9 = 0;
    L13:
        if (r9 >= r8) goto L20;
        ASN1TaggedObject taggedEntry = r7[r9];
        switch(taggedEntry.getTagNo()) {
            case 509: goto L18;
            case 709: goto L17;
            default: goto L19;
        };
    L17:
        parseAttestationApplicationId(getOctetsFromAsn1(taggedEntry.getObject()).toByteArray());
        goto L19
    L18:
        this.mKeyRequiresUnlockedDevice = getBoolFromAsn1(taggedEntry.getObject());
    L19:
        r9 = r9 + 1;
        goto L13
    L20:
        ASN1TaggedObject[] r10 = keyAttributes.getObjectAt(7).toArray();
        int r11 = r10.length;
        int r12 = 0;
    L21:
        if (r12 >= r11) goto L38;
        ASN1TaggedObject taggedEntry2 = r10[r12];
        switch(taggedEntry2.getTagNo()) {
            case 503: goto L36;
            case 600: goto L35;
            case 704: goto L32;
            case 705: goto L31;
            case 706: goto L30;
            case 710: goto L29;
            case 711: goto L28;
            case 712: goto L27;
            case 718: goto L26;
            case 719: goto L25;
            default: goto L37;
        };
    L25:
        this.mKeyBootPatchLevel = Integer.valueOf(getIntegerFromAsn1(taggedEntry2.getObject()));
        goto L37
    L26:
        this.mKeyVendorPatchLevel = Integer.valueOf(getIntegerFromAsn1(taggedEntry2.getObject()));
        goto L37
    L27:
        this.mDeviceProductName = getUtf8FromOctetsFromAsn1(taggedEntry2.getObject());
        goto L37
    L28:
        this.mDeviceName = getUtf8FromOctetsFromAsn1(taggedEntry2.getObject());
        goto L37
    L29:
        this.mDeviceBrand = getUtf8FromOctetsFromAsn1(taggedEntry2.getObject());
        goto L37
    L30:
        this.mKeyOsPatchLevel = Integer.valueOf(getIntegerFromAsn1(taggedEntry2.getObject()));
        goto L37
    L31:
        this.mKeyOsVersion = Integer.valueOf(getIntegerFromAsn1(taggedEntry2.getObject()));
        goto L37
    L32:
        ASN1Sequence rootOfTrust = taggedEntry2.getObject();
        this.mVerifiedBootKey = getOctetsFromAsn1(rootOfTrust.getObjectAt(0));
        this.mVerifiedBootLocked = getBoolFromAsn1(rootOfTrust.getObjectAt(1));
        this.mVerifiedBootState = getVerifiedBootStateEnum(rootOfTrust.getObjectAt(2));
        if (this.mAttestationVersion.intValue() < 3) goto L37;
        this.mVerifiedBootHash = getOctetsFromAsn1(rootOfTrust.getObjectAt(3));
        goto L37
    L35:
        this.mKeyAllowedForAllApplications = true;
        goto L37
    L36:
        this.mKeyAuthenticatorType = 0;
    L37:
        r12 = r12 + 1;
        goto L21
    L38:
        return;
    L11:
        r6 = false;
        goto L12
    L7:
        r4 = false;
        goto L8
    L40:
        throw new CertificateEncodingException("No attestation extension found in certificate.");
    }

    private void parseAttestationApplicationId(byte[] attestationApplicationId) throws IOException {
        ASN1Sequence outerSequence = ASN1Sequence.getInstance(new ASN1InputStream(attestationApplicationId).readObject());
        Map<String, Long> packageNameVersion = new HashMap();
        int r2 = 0;
        ASN1Set packageInfoSet = outerSequence.getObjectAt(0);
        ASN1Sequence[] r4 = packageInfoSet.toArray();
        int r5 = r4.length;
        int r6 = 0;
    L4:
        if (r6 >= r5) goto L6;
        ASN1Sequence packageInfoSequence = r4[r6];
        packageNameVersion.put(getUtf8FromOctetsFromAsn1(packageInfoSequence.getObjectAt(0)), Long.valueOf(getLongFromAsn1(packageInfoSequence.getObjectAt(1))));
        r6 = r6 + 1;
        goto L4
    L6:
        List<ByteString> certificateDigests = new ArrayList();
        ASN1Set certificateDigestSet = outerSequence.getObjectAt(1);
        ASN1Encodable[] r7 = certificateDigestSet.toArray();
        int r8 = r7.length;
    L7:
        if (r2 >= r8) goto L9;
        ASN1Encodable certificateDigestEntry = r7[r2];
        certificateDigests.add(getOctetsFromAsn1(certificateDigestEntry));
        r2 = r2 + 1;
        goto L7
    L9:
        this.mApplicationPackageNameVersion = Collections.unmodifiableMap(packageNameVersion);
        this.mApplicationCertificateDigests = Collections.unmodifiableList(certificateDigests);
    }

    private VerifiedBootState getVerifiedBootStateEnum(ASN1Encodable asn1) {
        int verifiedBoot = getEnumFromAsn1(asn1);
        switch(verifiedBoot) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalArgumentException("Invalid verified boot state.");
    L7:
        return VerifiedBootState.FAILED;
    L9:
        return VerifiedBootState.UNVERIFIED;
    L11:
        return VerifiedBootState.SELF_SIGNED;
    L13:
        return VerifiedBootState.VERIFIED;
    }

    private SecurityLevel getSecurityLevelEnum(ASN1Encodable asn1) {
        int securityLevel = getEnumFromAsn1(asn1);
        switch(securityLevel) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalArgumentException("Invalid security level.");
    L7:
        return SecurityLevel.STRONG_BOX;
    L9:
        return SecurityLevel.TRUSTED_ENVIRONMENT;
    L11:
        return SecurityLevel.SOFTWARE;
    }

    private ByteString getOctetsFromAsn1(ASN1Encodable asn1) {
        return ByteString.copyFrom(((ASN1OctetString) asn1).getOctets());
    }

    private String getUtf8FromOctetsFromAsn1(ASN1Encodable asn1) {
        return new String(((ASN1OctetString) asn1).getOctets(), StandardCharsets.UTF_8);
    }

    private int getIntegerFromAsn1(ASN1Encodable asn1) {
        return ((ASN1Integer) asn1).getValue().intValueExact();
    }

    private long getLongFromAsn1(ASN1Encodable asn1) {
        return ((ASN1Integer) asn1).getValue().longValueExact();
    }

    private int getEnumFromAsn1(ASN1Encodable asn1) {
        return ((ASN1Enumerated) asn1).getValue().intValueExact();
    }

    private Boolean getBoolFromAsn1(ASN1Encodable asn1) {
        if ((asn1 instanceof ASN1Boolean) == true) goto L5;
        return null;
    L5:
        return Boolean.valueOf(((ASN1Boolean) asn1).isTrue());
    }
}
