package com.android.ttcjpaysdk.thirdparty.fingerprint;

import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes39.dex */
public interface CJPayFingerprintAuthCallback {
    void onAuthenticationError(int r100, CharSequence r101);

    void onAuthenticationFailed();

    void onAuthenticationHelp(int r100, CharSequence r101);

    void onAuthenticationSucceeded(Cipher r100);
}
