package com.ttnet.org.chromium.net;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes4.dex */
public class AndroidKeyStore {
    private static final String TAG = "AndroidKeyStore";

    public AndroidKeyStore() {
    }

    private static String getPrivateKeyClassName(PrivateKey r2) {
        return ((PrivateKey) ZeusTransformUtils.wrapperContextForParams(r2, PrivateKey.class, "com.obric.aiagent.plugin")).getClass().getName();
    }

    private static boolean privateKeySupportsSignature(PrivateKey r3, String r4) {
        Signature.getInstance(r4).initSign((PrivateKey) ZeusTransformUtils.wrapperContextForParams(r3, PrivateKey.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L6 Throwable -> L9
        return true;
    L6:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(TAG, "Exception while checking support for " + r4 + ": " + e, new Object[0]);
    L8:
        return false;
    }

    private static boolean privateKeySupportsCipher(PrivateKey r3, String r4) {
        Cipher.getInstance(r4).init(1, (PrivateKey) ZeusTransformUtils.wrapperContextForParams(r3, PrivateKey.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L5 Throwable -> L8
        return true;
    L5:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(TAG, "Exception while checking support for " + r4 + ": " + e, new Object[0]);
    L7:
        return false;
    }

    private static byte[] signWithPrivateKey(PrivateKey r5, String r6, byte[] r7) {
        PrivateKey r8 = (PrivateKey) ZeusTransformUtils.wrapperContextForParams(r5, PrivateKey.class, "com.obric.aiagent.plugin");
        Signature r3 = Signature.getInstance(r6);     // Catch: NoSuchAlgorithmException -> L9
        r3.initSign(r8);     // Catch: Exception -> L6
        r3.update(r7);     // Catch: Exception -> L6
        return r3.sign();
    L6:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(TAG, "Exception while signing message with " + r6 + " and " + r8.getAlgorithm() + " private key (" + r8.getClass().getName() + "): " + e, new Object[0]);
        return null;
    L9:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(TAG, "Signature algorithm " + r6 + " not supported: " + e, new Object[0]);
        return null;
    }

    private static byte[] encryptWithPrivateKey(PrivateKey r5, String r6, byte[] r7) {
        PrivateKey r8 = (PrivateKey) ZeusTransformUtils.wrapperContextForParams(r5, PrivateKey.class, "com.obric.aiagent.plugin");
        Cipher r3 = Cipher.getInstance(r6);     // Catch: Throwable -> L10
        r3.init(1, r8);     // Catch: Exception -> L7
        return r3.doFinal(r7);
    L7:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(TAG, "Exception while encrypting input with " + r6 + " and " + r8.getAlgorithm() + " private key (" + r8.getClass().getName() + "): " + e, new Object[0]);
        return null;
    L10:
        e = move-exception;
        com.ttnet.org.chromium.base.j.e(TAG, "Cipher " + r6 + " not supported: " + e, new Object[0]);
        return null;
    }
}
