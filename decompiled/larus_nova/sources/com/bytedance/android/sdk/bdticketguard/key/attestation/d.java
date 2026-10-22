package com.bytedance.android.sdk.bdticketguard.key.attestation;

import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.bytedance.android.sdk.bdticketguard.h0;
import com.bytedance.android.sdk.bdticketguard.key.TeeApi;
import com.bytedance.android.sdk.bdticketguard.key.TeeKeyObject;
import com.bytedance.android.sdk.bdticketguard.r0;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import kotlin.TypeCastException;
import net.bytedance.zdplib.Delta;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    public h0 a(com.bytedance.android.sdk.bdticketguard.d r100, c r101) throws Exception {
        return null;
    }

    public abstract KeyStore b();

    public abstract KeyPairGenerator d(KeyGenParameterSpec r100);

    public abstract String e();

    public boolean f() {
        return true;
    }

    public boolean g() {
        return false;
    }

    public final String c() {
        KeyStore r100 = b();     // Catch: Throwable -> L5
    L8:
        if (r100 != null) goto L19;
        return "";
    L19:
        PublicKey r101 = r100.getCertificate("bd_ticket_guard_key_attestation").getPublicKey();     // Catch: Throwable -> L16
        TeeKeyObject.a r102 = TeeKeyObject.f163828g;     // Catch: Throwable -> L16
        if (r101 == null) goto L15;
        r102.getClass();     // Catch: Throwable -> L16
        return Base64.encodeToString(Delta.e(TeeApi.j((ECPublicKey) r101)), 2);
    L15:
        throw new TypeCastException("null cannot be cast to non-null type java.security.interfaces.ECPublicKey");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r0.d(6, "BaseAttestationAdapter", "getAttestationPubKey error", th);
        return "";
    L5:
        th = move-exception;
        int r103 = r0.f163979a;
        r0.d(6, "BaseAttestationAdapter", "getKeyStoreOrNull error", th);
        r100 = null;
        goto L8
    }
}
