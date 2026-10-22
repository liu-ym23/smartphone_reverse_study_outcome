package com.android.server.locksettings.recoverablekeystore;

import android.os.RemoteException;
import android.os.ServiceSpecificException;
import android.security.keystore.recovery.TrustedRootCertificates;
import android.util.Log;
import android.util.Pair;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes2.dex */
public class TestOnlyInsecureCertificateHelper {
    private static final String TAG = "TestCertHelper";

    public TestOnlyInsecureCertificateHelper() {
    }

    public X509Certificate getRootCertificate(String rootCertificateAlias) throws RemoteException {
        String rootCertificateAlias2 = getDefaultCertificateAliasIfEmpty(rootCertificateAlias);
        if (isTestOnlyCertificateAlias(rootCertificateAlias2) == true) goto L5;
        X509Certificate rootCertificate = TrustedRootCertificates.getRootCertificate(rootCertificateAlias2);
        if (rootCertificate == null) goto L10;
        return rootCertificate;
    L10:
        throw new ServiceSpecificException(28, "The provided root certificate alias is invalid");
    L5:
        return TrustedRootCertificates.getTestOnlyInsecureCertificate();
    }

    public Date getValidationDate(String rootCertificateAlias) {
        if (isTestOnlyCertificateAlias(rootCertificateAlias) == true) goto L5;
        return null;
    L5:
        return new Date(119, 1, 30);
    }

    public String getDefaultCertificateAliasIfEmpty(String rootCertificateAlias) {
        if (rootCertificateAlias != null) goto L4;
    L5:
        Log.e(TAG, "rootCertificateAlias is null or empty - use secure default value");
        return "GoogleCloudKeyVaultServiceV1";
    L4:
        if (rootCertificateAlias.isEmpty() == true) goto L5;
        return rootCertificateAlias;
    }

    public boolean isTestOnlyCertificateAlias(String rootCertificateAlias) {
        return "TEST_ONLY_INSECURE_CERTIFICATE_ALIAS".equals(rootCertificateAlias);
    }

    public boolean isValidRootCertificateAlias(String rootCertificateAlias) {
        if (TrustedRootCertificates.getRootCertificates().containsKey(rootCertificateAlias) == false) goto L5;
    L8:
        return true;
    L5:
        if (isTestOnlyCertificateAlias(rootCertificateAlias) == true) goto L8;
        return false;
    }

    public boolean doesCredentialSupportInsecureMode(int credentialType, byte[] credential) {
        if (credential != null) goto L6;
        return false;
    L6:
        if (credentialType != 4) goto L8;
    L10:
        byte[] insecurePasswordPrefixBytes = "INSECURE_PSWD_".getBytes();
        if (credential.length >= insecurePasswordPrefixBytes.length) goto L13;
        return false;
    L13:
        int i = 0;
    L15:
        if (i >= insecurePasswordPrefixBytes.length) goto L20;
        if (credential[i] != insecurePasswordPrefixBytes[i]) goto L18;
        i = i + 1;
        goto L15
    L18:
        return false;
    L20:
        return true;
    L8:
        if (credentialType == 3) goto L10;
        return false;
    }

    public Map<String, Pair<SecretKey, byte[]>> keepOnlyWhitelistedInsecureKeys(Map<String, Pair<SecretKey, byte[]>> rawKeys) {
        if (rawKeys != null) goto L5;
        return null;
    L5:
        Map<String, Pair<SecretKey, byte[]>> filteredKeys = new HashMap();
        Iterator<Map.Entry<String, Pair<SecretKey, byte[]>>> r1 = rawKeys.entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L14;
        Map.Entry<String, Pair<SecretKey, byte[]>> entry = r1.next();
        String alias = entry.getKey();
        if (alias == null) goto L7;
        if (alias.startsWith("INSECURE_KEY_ALIAS_KEY_MATERIAL_IS_NOT_PROTECTED_") == false) goto L7;
        filteredKeys.put(entry.getKey(), Pair.create((SecretKey) entry.getValue().first, (byte[]) entry.getValue().second));
        Log.d(TAG, "adding key with insecure alias " + alias + " to the recovery snapshot");
        goto L7
    L14:
        return filteredKeys;
    }
}
