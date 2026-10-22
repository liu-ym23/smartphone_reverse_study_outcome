package com.android.server.locksettings.recoverablekeystore;

import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

/* JADX INFO: loaded from: classes2.dex */
public interface KeyStoreProxy {
    boolean containsAlias(String r1) throws KeyStoreException;

    void deleteEntry(String r1) throws KeyStoreException;

    Key getKey(String r1, char[] r2) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException;

    void setEntry(String r1, KeyStore.Entry r2, KeyStore.ProtectionParameter r3) throws KeyStoreException;
}
