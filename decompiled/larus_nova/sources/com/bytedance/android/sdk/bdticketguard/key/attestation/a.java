package com.bytedance.android.sdk.bdticketguard.key.attestation;

import android.security.keystore.KeyGenParameterSpec;
import com.bytedance.crypto.utils.CryptoConst;
import java.security.KeyPairGenerator;
import java.security.KeyStore;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f163868a = null;

    @Override // com.bytedance.android.sdk.bdticketguard.key.attestation.d
    public final String e() {
        return "Android";
    }

    static {
        f163868a = new a();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.attestation.d
    public final KeyStore b() {
        KeyStore r100 = KeyStore.getInstance("AndroidKeyStore");
        r100.load(null);
        return r100;
    }

    public a() {
    }

    @Override // com.bytedance.android.sdk.bdticketguard.key.attestation.d
    public final KeyPairGenerator d(KeyGenParameterSpec r100) {
        KeyPairGenerator r101 = KeyPairGenerator.getInstance(CryptoConst.ALGORITHM_EC, "AndroidKeyStore");
        r101.initialize(r100);
        return r101;
    }
}
