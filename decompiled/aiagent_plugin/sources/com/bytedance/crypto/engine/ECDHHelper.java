package com.bytedance.crypto.engine;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.crypto.cloudtrans.CloudTransException;
import com.bytedance.crypto.utils.FrameworkSecurityCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.KeyAgreement;

/* JADX INFO: loaded from: classes.dex */
public class ECDHHelper {
    public ECDHHelper() {
    }

    public static PrivateKey bytesToECPrivateKey(byte[] r1) {
        PKCS8EncodedKeySpec r0 = new PKCS8EncodedKeySpec(r1);
        return KeyFactory.getInstance("EC").generatePrivate(r0);
    }

    private static PublicKey bytesToPublicKey(byte[] r1) {
        X509EncodedKeySpec r0 = new X509EncodedKeySpec(r1);
        return KeyFactory.getInstance("EC").generatePublic(r0);
    }

    public static byte[] generateBDSharedSecret(Context r3, String r4, byte[] r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Bundle r0 = new Bundle();
        r0.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_ALGO(), FrameworkSecurityCompat.KeyManagerConst.KEY_ALGORITHM_ECC());
        r0.putInt(FrameworkSecurityCompat.KeyManagerConst.KEY_LEN(), 256);
        FrameworkSecurityCompat.KmResult r7 = FrameworkSecurityCompat.keyAgreement(r6, r4, r5, r0);
        if (r7.getResultCode() != FrameworkSecurityCompat.KeyManagerErrorCode.KM_SUCCESS()) goto L7;
        return r7.getOutData();
    L7:
        throw new CloudTransException("bd keyAgreement failed, system errorCode: " + r7.getResultCode());
    }

    public static byte[] generateSharedSecret(PrivateKey r2, PublicKey r3) {
        PrivateKey r4 = (PrivateKey) ZeusTransformUtils.wrapperContextForParams(r2, PrivateKey.class, "com.obric.aiagent.plugin");
        PublicKey r5 = (PublicKey) ZeusTransformUtils.wrapperContextForParams(r3, PublicKey.class, "com.obric.aiagent.plugin");
        KeyAgreement r0 = KeyAgreement.getInstance("ECDH");
        r0.init(r4);
        r0.doPhase(r5, true);
        return r0.generateSecret();
    }
}
