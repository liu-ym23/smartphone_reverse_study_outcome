package com.android.ttcjpaysdk.base.service;

import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes3.dex */
public interface ICJPayFingerprintAuthCallback {
    void onAuthError();

    void onAuthFailed();

    void onAuthSucceeded(Cipher r100);
}
