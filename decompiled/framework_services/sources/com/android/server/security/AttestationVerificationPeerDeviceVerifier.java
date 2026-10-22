package com.android.server.security;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.security.attestationverification.AttestationVerificationManager;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidator;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
class AttestationVerificationPeerDeviceVerifier {
    private static final String ANDROID_SYSTEM_PACKAGE_NAME = "AndroidSystem";
    private static final Set<String> ANDROID_SYSTEM_PACKAGE_NAME_SET = null;
    private static final int MAX_PATCH_AGE_MONTHS = 12;
    private static final String PARAM_OWNED_BY_SYSTEM = "android.key_owned_by_system";
    private static final String TAG = "AVF";
    private final CertPathValidator mCertPathValidator;
    private final CertificateFactory mCertificateFactory;
    private final CertificateRevocationStatusManager mCertificateRevocationStatusManager;
    private final Context mContext;
    private final AttestationVerificationManagerService.DumpLogger mDumpLogger;
    private final boolean mRevocationEnabled;
    private final LocalDate mTestLocalPatchDate;
    private final LocalDate mTestSystemDate;
    private final Set<TrustAnchor> mTrustAnchors;

    private static class MyDumpData extends AttestationVerificationManagerService.DumpData {
        boolean mAttestationParametersOk;
        boolean mAttestationVersionAtLeast3;
        boolean mBindingOk;
        int mBindingType;
        boolean mBootStateIsVerified;
        boolean mCertChainOk;
        boolean mCertPathValidatorAvailable;
        boolean mCertificationFactoryAvailable;
        boolean mKeyBootPatchLevelInRange;
        boolean mKeyHwBacked;
        boolean mKeyVendorPatchLevelInRange;
        boolean mKeymasterHwBacked;
        boolean mKeymasterVersionAtLeast4;
        boolean mOsPatchLevelInRange;
        boolean mOsVersionAtLeast10;
        int mResult;
        boolean mSystemOwned;
        boolean mSystemOwnershipChecked;
        boolean mVerifiedBootStateLocked;

        /* synthetic */ MyDumpData(AttestationVerificationPeerDeviceVerifierIA r1) {
            this();
        }

        private MyDumpData() {
            this.mResult = -1;
            this.mCertificationFactoryAvailable = false;
            this.mCertPathValidatorAvailable = false;
            this.mAttestationParametersOk = false;
            this.mCertChainOk = false;
            this.mBindingOk = false;
            this.mBindingType = -1;
            this.mSystemOwnershipChecked = false;
            this.mSystemOwned = false;
            this.mOsVersionAtLeast10 = false;
            this.mKeyHwBacked = false;
            this.mAttestationVersionAtLeast3 = false;
            this.mKeymasterVersionAtLeast4 = false;
            this.mKeymasterHwBacked = false;
            this.mBootStateIsVerified = false;
            this.mVerifiedBootStateLocked = false;
            this.mOsPatchLevelInRange = false;
            this.mKeyBootPatchLevelInRange = false;
            this.mKeyVendorPatchLevelInRange = false;
        }

        @Override // com.android.server.security.AttestationVerificationManagerService.DumpData
        public void dumpTo(IndentingPrintWriter writer) {
            writer.println("Result: " + this.mResult);
            if (this.mCertificationFactoryAvailable == true) goto L7;
            writer.println("Certificate Factory Unavailable");
            return;
        L7:
            if (this.mCertPathValidatorAvailable == true) goto L11;
            writer.println("Cert Path Validator Unavailable");
            return;
        L11:
            if (this.mAttestationParametersOk == true) goto L14;
            writer.println("Attestation parameters set incorrectly.");
            return;
        L14:
            writer.println("Certificate Chain Valid (inc. Trust Anchor): " + booleanToOkFail(this.mCertChainOk));
            if (this.mCertChainOk == true) goto L17;
            return;
        L17:
            writer.println("Local Binding: " + booleanToOkFail(this.mBindingOk));
            writer.increaseIndent();
            writer.println("Binding Type: " + this.mBindingType);
            writer.decreaseIndent();
            if (this.mSystemOwnershipChecked == false) goto L20;
            writer.println("System Ownership: " + booleanToOkFail(this.mSystemOwned));
        L20:
            writer.println("KeyStore Attestation Parameters");
            writer.increaseIndent();
            writer.println("OS Version >= 10: " + booleanToOkFail(this.mOsVersionAtLeast10));
            writer.println("OS Patch Level in Range: " + booleanToOkFail(this.mOsPatchLevelInRange));
            writer.println("Attestation Version >= 3: " + booleanToOkFail(this.mAttestationVersionAtLeast3));
            writer.println("Keymaster Version >= 4: " + booleanToOkFail(this.mKeymasterVersionAtLeast4));
            writer.println("Keymaster HW-Backed: " + booleanToOkFail(this.mKeymasterHwBacked));
            writer.println("Key is HW Backed: " + booleanToOkFail(this.mKeyHwBacked));
            writer.println("Boot State is VERIFIED: " + booleanToOkFail(this.mBootStateIsVerified));
            writer.println("Verified Boot is LOCKED: " + booleanToOkFail(this.mVerifiedBootStateLocked));
            writer.println("Key Boot Level in Range: " + booleanToOkFail(this.mKeyBootPatchLevelInRange));
            writer.println("Key Vendor Patch Level in Range: " + booleanToOkFail(this.mKeyVendorPatchLevelInRange));
            writer.decreaseIndent();
        }

        private String booleanToOkFail(boolean value) {
            if (value == false) goto L4;
            return "OK";
        L4:
            return "FAILURE";
        }
    }

    static {
        ANDROID_SYSTEM_PACKAGE_NAME_SET = Collections.singleton(ANDROID_SYSTEM_PACKAGE_NAME);
    }

    AttestationVerificationPeerDeviceVerifier(Context context, AttestationVerificationManagerService.DumpLogger dumpLogger) throws Exception {
        context.getClass();
        this.mContext = context;
        this.mDumpLogger = dumpLogger;
        this.mCertificateFactory = CertificateFactory.getInstance("X.509");
        this.mCertPathValidator = CertPathValidator.getInstance("PKIX");
        this.mTrustAnchors = getTrustAnchors();
        this.mCertificateRevocationStatusManager = new CertificateRevocationStatusManager(this.mContext);
        this.mRevocationEnabled = true;
        this.mTestSystemDate = null;
        this.mTestLocalPatchDate = null;
    }

    AttestationVerificationPeerDeviceVerifier(Context context, AttestationVerificationManagerService.DumpLogger dumpLogger, Set<TrustAnchor> trustAnchors, boolean revocationEnabled, LocalDate systemDate, LocalDate localPatchDate) throws Exception {
        context.getClass();
        this.mContext = context;
        this.mDumpLogger = dumpLogger;
        this.mCertificateFactory = CertificateFactory.getInstance("X.509");
        this.mCertPathValidator = CertPathValidator.getInstance("PKIX");
        this.mTrustAnchors = trustAnchors;
        this.mCertificateRevocationStatusManager = new CertificateRevocationStatusManager(this.mContext);
        this.mRevocationEnabled = revocationEnabled;
        this.mTestSystemDate = systemDate;
        this.mTestLocalPatchDate = localPatchDate;
    }

    int verifyAttestation(int localBindingType, Bundle requirements, byte[] attestation) {
        MyDumpData dumpData = new MyDumpData(null);
        int result = verifyAttestationInternal(localBindingType, requirements, attestation, dumpData);
        dumpData.mResult = result;
        this.mDumpLogger.logAttempt(dumpData);
        return result;
    }

    private int verifyAttestationInternal(int localBindingType, Bundle requirements, byte[] attestation, MyDumpData dumpData) {
        if (this.mCertificateFactory != null) goto L6;
        Slog.e(TAG, "Unable to access CertificateFactory");
        return 4;
    L6:
        dumpData.mCertificationFactoryAvailable = true;
        if (this.mCertPathValidator != null) goto L10;
        Slog.e(TAG, "Unable to access CertPathValidator");
        return 4;
    L10:
        dumpData.mCertPathValidatorAvailable = true;
        int result = 0;
        List<X509Certificate> certificateChain = getCertificates(attestation);     // Catch: RuntimeException -> L27 Throwable -> L29
        validateCertificateChain(certificateChain);     // Catch: RuntimeException -> L27 Throwable -> L29
        dumpData.mCertChainOk = true;     // Catch: RuntimeException -> L27 Throwable -> L29
        X509Certificate leafCertificate = certificateChain.get(0);     // Catch: RuntimeException -> L27 Throwable -> L29
        AndroidKeystoreAttestationVerificationAttributes attestationExtension = AndroidKeystoreAttestationVerificationAttributes.fromCertificate(leafCertificate);     // Catch: RuntimeException -> L27 Throwable -> L29
        if (validateAttestationParameters(localBindingType, requirements) == true) goto L15;
        return 8;
    L15:
        dumpData.mAttestationParametersOk = true;     // Catch: RuntimeException -> L27 Throwable -> L29
    L36:
    L25:
        e = move-exception;
        Exception e = e;
    L32:
        Slog.e(TAG, "Unable to parse/validate Android Attestation certificate(s)", e);
        return 4;
    L23:
        e = move-exception;
        RuntimeException e2 = e;
    L31:
        Slog.e(TAG, "Unexpected error", e2);
        return 1;
    L18:
        if (checkLocalBindingRequirements(leafCertificate, attestationExtension, localBindingType, requirements, dumpData) == true) goto L20;
        result = 0 | 8;     // Catch: RuntimeException -> L23 Throwable -> L25
    L20:
    L38:
        return checkAttestationForPeerDeviceProfile(requirements, attestationExtension, dumpData) | result;
    L29:
        e = move-exception;
        e = e;
    L27:
        e = move-exception;
        e2 = e;
        goto L31
    }

    private List<X509Certificate> getCertificates(byte[] attestation) throws CertificateException {
        List<X509Certificate> certificates = new ArrayList();
        ByteArrayInputStream bis = new ByteArrayInputStream(attestation);
    L4:
        if (bis.available() <= 0) goto L6;
        certificates.add((X509Certificate) this.mCertificateFactory.generateCertificate(bis));
        goto L4
    L6:
        return certificates;
    }

    private boolean validateAttestationParameters(int localBindingType, Bundle requirements) {
        if (localBindingType == 2) goto L8;
        if (localBindingType == 3) goto L8;
        Slog.e(TAG, "Binding type is not supported: " + localBindingType);
        return false;
    L8:
        if (requirements.size() >= 1) goto L11;
        Slog.e(TAG, "At least 1 requirement is required.");
        return false;
    L11:
        if (localBindingType == 2) goto L13;
    L16:
        if (localBindingType == 3) goto L18;
    L21:
        return true;
    L18:
        if (requirements.containsKey("localbinding.challenge") == true) goto L21;
        Slog.e(TAG, "Requirements does not contain key: localbinding.challenge");
        return false;
    L13:
        if (requirements.containsKey("localbinding.public_key") == true) goto L16;
        Slog.e(TAG, "Requirements does not contain key: localbinding.public_key");
        return false;
    }

    private void validateCertificateChain(List<X509Certificate> certificates) throws CertificateException, CertPathValidatorException, InvalidAlgorithmParameterException {
        if (certificates.size() < 2) goto L8;
        CertPath certificatePath = this.mCertificateFactory.generateCertPath(certificates);
        PKIXParameters validationParams = new PKIXParameters(this.mTrustAnchors);
        validationParams.setRevocationEnabled(false);
        this.mCertPathValidator.validate(certificatePath, validationParams);
        if (this.mRevocationEnabled == false) goto L10;
        this.mCertificateRevocationStatusManager.checkRevocationStatus(new ArrayList(certificates.subList(1, certificates.size())));
        return;
    L10:
        return;
    L8:
        Slog.e(TAG, "Certificate chain less than 2 in size.");
        throw new CertificateException("Certificate chain less than 2 in size.");
    }

    private Set<TrustAnchor> getTrustAnchors() throws CertPathValidatorException {
        Set<TrustAnchor> modifiableSet = new HashSet();
        String[] r1 = getTrustAnchorResources();     // Catch: CertificateException -> L7
        int r2 = r1.length;     // Catch: CertificateException -> L7
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L10;
        String certString = r1[r3];     // Catch: CertificateException -> L7
        modifiableSet.add(new TrustAnchor((X509Certificate) this.mCertificateFactory.generateCertificate(new ByteArrayInputStream(getCertificateBytes(certString))), null));     // Catch: CertificateException -> L7
        r3 = r3 + 1;
        goto L4
    L10:
        return Collections.unmodifiableSet(modifiableSet);
    L7:
        e = move-exception;
        e.printStackTrace();
        throw new CertPathValidatorException("Invalid trust anchor certificate.", e);
    }

    private byte[] getCertificateBytes(String certString) {
        String formattedCertString = certString.replaceAll("\\s+", "\n");
        return formattedCertString.replaceAll("-BEGIN\\nCERTIFICATE-", "-BEGIN CERTIFICATE-").replaceAll("-END\\nCERTIFICATE-", "-END CERTIFICATE-").getBytes(StandardCharsets.UTF_8);
    }

    private String[] getTrustAnchorResources() {
        return this.mContext.getResources().getStringArray(17236313);
    }

    private boolean checkLocalBindingRequirements(X509Certificate leafCertificate, AndroidKeystoreAttestationVerificationAttributes attestationAttributes, int localBindingType, Bundle requirements, MyDumpData dumpData) {
        dumpData.mBindingType = localBindingType;
        switch(localBindingType) {
            case 2: goto L10;
            case 3: goto L6;
            default: goto L5;
        };
    L6:
        boolean attestationChallengeMatches = checkAttestationChallenge(attestationAttributes, requirements.getByteArray("localbinding.challenge"));
        if (attestationChallengeMatches == true) goto L14;
        Slog.e(TAG, "Provided challenge does not match leaf certificate challenge.");
        return false;
    L14:
        dumpData.mBindingOk = true;
        if (requirements.containsKey(PARAM_OWNED_BY_SYSTEM) == false) goto L25;
        dumpData.mSystemOwnershipChecked = true;
        if (requirements.getBoolean(PARAM_OWNED_BY_SYSTEM) == false) goto L24;
        boolean ownedBySystem = checkOwnedBySystem(leafCertificate, attestationAttributes);
        if (ownedBySystem == true) goto L22;
        Slog.e(TAG, "Certificate public key is not owned by the AndroidSystem.");
        return false;
    L22:
        dumpData.mSystemOwned = true;
        goto L25
    L24:
        throw new IllegalArgumentException("The value of the requirement key android.key_owned_by_system cannot be false. You can remove the key if you don't want to verify it.");
    L25:
        return true;
    L10:
        boolean publicKeyMatches = checkPublicKey(leafCertificate, requirements.getByteArray("localbinding.public_key"));
        if (publicKeyMatches == true) goto L14;
        Slog.e(TAG, "Provided public key does not match leaf certificate public key.");
        return false;
    L5:
        throw new IllegalArgumentException("Unsupported local binding type " + AttestationVerificationManager.localBindingTypeToString(localBindingType));
    }

    private int checkAttestationForPeerDeviceProfile(Bundle requirements, AndroidKeystoreAttestationVerificationAttributes attestationAttributes, MyDumpData dumpData) {
        int result = 0;
        if (attestationAttributes.getAttestationVersion() >= 3) goto L5;
        Slog.e(TAG, "Attestation version is not at least 3 (Keymaster 4).");
        result = 0 | 16;
    L7:
        if (attestationAttributes.getKeymasterVersion() >= 4) goto L9;
        Slog.e(TAG, "Keymaster version is not at least 4.");
        result = result | 16;
    L11:
        if (attestationAttributes.getKeyOsVersion() >= 100000) goto L13;
        Slog.e(TAG, "Android OS version is not 10+.");
        result = result | 16;
    L15:
        if (attestationAttributes.isAttestationHardwareBacked() == true) goto L17;
        Slog.e(TAG, "Key is not HW backed.");
        result = result | 16;
    L19:
        if (attestationAttributes.isKeymasterHardwareBacked() == true) goto L21;
        Slog.e(TAG, "Keymaster is not HW backed.");
        result = result | 16;
    L23:
        if (attestationAttributes.getVerifiedBootState() == AndroidKeystoreAttestationVerificationAttributes.VerifiedBootState.VERIFIED) goto L25;
        Slog.e(TAG, "Boot state not Verified.");
        result = result | 32;
    L51:
    L29:
        e = move-exception;
        Slog.e(TAG, "VerifiedBootLocked is not set.", e);
        result = 32;
    L34:
        int maxPatchLevelDiffMonths = requirements.getInt("param_max_patch_level_diff_months", 12);
        if (isValidPatchLevel(attestationAttributes.getKeyOsPatchLevel(), maxPatchLevelDiffMonths) == true) goto L37;
        Slog.e(TAG, "OS patch level is not within valid range.");
        result = result | 64;
    L39:
        if (isValidPatchLevel(attestationAttributes.getKeyBootPatchLevel(), maxPatchLevelDiffMonths) == true) goto L41;
        Slog.e(TAG, "Boot patch level is not within valid range.");
        result = result | 64;
    L43:
        if (isValidPatchLevel(attestationAttributes.getKeyVendorPatchLevel(), maxPatchLevelDiffMonths) == true) goto L45;
        Slog.e(TAG, "Vendor patch level is not within valid range.");
        result = result | 64;
    L47:
        if (isValidPatchLevel(attestationAttributes.getKeyBootPatchLevel(), maxPatchLevelDiffMonths) == true) goto L49;
        Slog.e(TAG, "Boot patch level is not within valid range.");
        return result | 64;
    L49:
        dumpData.mKeyBootPatchLevelInRange = true;
        return result;
    L45:
        dumpData.mKeyVendorPatchLevelInRange = true;
        goto L47
    L41:
        dumpData.mKeyBootPatchLevelInRange = true;
        goto L43
    L37:
        dumpData.mOsPatchLevelInRange = true;
        goto L39
    L27:
        if (attestationAttributes.isVerifiedBootLocked() == true) goto L31;
        Slog.e(TAG, "Verified boot state is not locked.");     // Catch: IllegalStateException -> L29
        result = result | 32;     // Catch: IllegalStateException -> L29
        goto L34
    L31:
        dumpData.mVerifiedBootStateLocked = true;     // Catch: IllegalStateException -> L29
        goto L34
    L25:
        dumpData.mBootStateIsVerified = true;
        goto L51
    L21:
        dumpData.mKeymasterHwBacked = true;
        goto L23
    L17:
        dumpData.mKeyHwBacked = true;
        goto L19
    L13:
        dumpData.mOsVersionAtLeast10 = true;
        goto L15
    L9:
        dumpData.mKeymasterVersionAtLeast4 = true;
        goto L11
    L5:
        dumpData.mAttestationVersionAtLeast3 = true;
        goto L7
    }

    private boolean checkPublicKey(Certificate certificate, byte[] expectedPublicKey) {
        byte[] publicKey = certificate.getPublicKey().getEncoded();
        return Arrays.equals(publicKey, expectedPublicKey);
    }

    private boolean checkAttestationChallenge(AndroidKeystoreAttestationVerificationAttributes attestationAttributes, byte[] expectedChallenge) {
        byte[] challenge = attestationAttributes.getAttestationChallenge().toByteArray();
        return Arrays.equals(challenge, expectedChallenge);
    }

    private boolean checkOwnedBySystem(X509Certificate certificate, AndroidKeystoreAttestationVerificationAttributes attestationAttributes) {
        Set<String> ownerPackages = attestationAttributes.getApplicationPackageNameVersion().keySet();
        if (ANDROID_SYSTEM_PACKAGE_NAME_SET.equals(ownerPackages) == true) goto L6;
        Slog.e(TAG, "Owner is not system, packages=" + ownerPackages);
        return false;
    L6:
        return true;
    }

    private boolean isValidPatchLevel(int patchLevel, int maxPatchLevelDiffMonths) {
        if (this.mTestSystemDate == null) goto L5;
        LocalDate currentDate = this.mTestSystemDate;
    L28:
        if (this.mTestLocalPatchDate == null) goto L12;
        LocalDate localPatchDate = this.mTestLocalPatchDate;     // Catch: Throwable -> L10
    L14:
        if (ChronoUnit.MONTHS.between(localPatchDate, currentDate) <= 12) goto L16;
        return true;
    L16:
        String remoteDeviceDateStr = String.valueOf(patchLevel);
        if (remoteDeviceDateStr.length() != 6) goto L19;
    L22:
        int patchYear = Integer.parseInt(remoteDeviceDateStr.substring(0, 4));
        int patchMonth = Integer.parseInt(remoteDeviceDateStr.substring(4, 6));
        LocalDate remotePatchDate = LocalDate.of(patchYear, patchMonth, 1);
        if (Math.abs(ChronoUnit.MONTHS.between(localPatchDate, remotePatchDate)) <= maxPatchLevelDiffMonths) goto L25;
        return false;
    L25:
        return true;
    L19:
        if (remoteDeviceDateStr.length() == 8) goto L22;
        Slog.e(TAG, "Patch level is not in format YYYYMM or YYYYMMDD");
        return false;
    L12:
        localPatchDate = LocalDate.parse(Build.VERSION.SECURITY_PATCH);     // Catch: Throwable -> L10
        goto L14
    L26:
        Slog.e(TAG, "Build.VERSION.SECURITY_PATCH: " + Build.VERSION.SECURITY_PATCH + " is not in format YYYY-MM-DD");
        return false;
    L5:
        currentDate = LocalDate.now(ZoneId.systemDefault());
        goto L28
    }
}
