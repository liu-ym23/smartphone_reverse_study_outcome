package com.android.server.locksettings;

import android.hardware.authsecret.IAuthSecret;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
class AuthSecretHidlAdapter implements IAuthSecret {
    private final android.hardware.authsecret.V1_0.IAuthSecret mImpl;

    AuthSecretHidlAdapter(android.hardware.authsecret.V1_0.IAuthSecret impl) {
        this.mImpl = impl;
    }

    @Override // android.hardware.authsecret.IAuthSecret
    public void setPrimaryUserCredential(byte[] secret) throws RemoteException {
        ArrayList<Byte> secretAsArrayList = new ArrayList(secret.length);
        int i = 0;
    L4:
        if (i >= secret.length) goto L6;
        secretAsArrayList.add(Byte.valueOf(secret[i]));
        i = i + 1;
        goto L4
    L6:
        this.mImpl.primaryUserCredential(secretAsArrayList);
    }

    @Override // android.hardware.authsecret.IAuthSecret
    public int getInterfaceVersion() throws RemoteException {
        return 1;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        throw new UnsupportedOperationException("AuthSecretHidlAdapter does not support asBinder");
    }

    @Override // android.hardware.authsecret.IAuthSecret
    public String getInterfaceHash() throws RemoteException {
        throw new UnsupportedOperationException("AuthSecretHidlAdapter does not support getInterfaceHash");
    }
}
